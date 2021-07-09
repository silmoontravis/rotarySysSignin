package com.smd.rotary.domain.signin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.smd.rotary.application.controller.v1.request.DateTimeRangeRequest;
import com.smd.rotary.domain.signin.model.RsParticipants;
import com.smd.rotary.domain.signin.repository.RsParticipantsMapper;
import com.smd.rotary.util.DateConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RsParticipantsService {

    @Autowired
    private RsParticipantsMapper rsParticipantsMapper;

    public void insertOne(RsParticipants participant) {
        participant.setVersion(1);
        participant.setSignAt(LocalDateTime.now());
        participant.setCreateAt(LocalDateTime.now());
        participant.setUpdateAt(LocalDateTime.now());
        rsParticipantsMapper.insert(participant);
    }

    public List<RsParticipants> getParticipantByDateTime(DateTimeRangeRequest dateTimeRangeRequest) {
        LambdaQueryWrapper<RsParticipants> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.between(RsParticipants::getSignAt, DateConvertUtil.convertDateFixTimeZoneSearch(dateTimeRangeRequest.getBeginAt()), DateConvertUtil.convertDateFixTimeZoneSearch(dateTimeRangeRequest.getEndAt()));
        return rsParticipantsMapper.selectList(queryWrapper);
    }

    public RsParticipants getOne(RsParticipants participant) {
        if (participant.getId() != null) return rsParticipantsMapper.selectById(participant.getId());
        LambdaQueryWrapper<RsParticipants> queryWrapper = getUniqueCondition(participant);
        return rsParticipantsMapper.selectOne(queryWrapper);
    }

    public List<String> getAutocompleteClub(String clubPrefix) {
        LambdaQueryWrapper<RsParticipants> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.likeRight(RsParticipants::getClub, clubPrefix);
        return rsParticipantsMapper.selectList(queryWrapper).stream()
            .map(RsParticipants::getClub)
            .distinct()
            .collect(Collectors.toList());
    }

    private LambdaQueryWrapper<RsParticipants> getUniqueCondition(RsParticipants participant) {
        LambdaQueryWrapper<RsParticipants> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.nested(i -> {
            i.eq(RsParticipants::getParticipant, participant.getParticipant());
            i.eq(RsParticipants::getClub, participant.getClub());
            i.eq(RsParticipants::getTitle, participant.getTitle());
            return i;
        });
        queryWrapper.or().eq(RsParticipants::getFingerprint, participant.getFingerprint());
        return queryWrapper;
    }

}
