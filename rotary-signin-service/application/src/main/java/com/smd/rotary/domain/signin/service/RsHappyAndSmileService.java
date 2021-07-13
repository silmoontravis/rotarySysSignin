package com.smd.rotary.domain.signin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.smd.rotary.application.controller.v1.request.DateTimeRangeRequest;
import com.smd.rotary.domain.signin.model.RsHappyAndSmile;
import com.smd.rotary.domain.signin.repository.RsHappyAndSmileMapper;
import com.smd.rotary.util.DateConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RsHappyAndSmileService {

    @Autowired
    private RsHappyAndSmileMapper rsHappyAndSmileMapper;

    public void insertOne(RsHappyAndSmile happyAndSmile) {
        happyAndSmile.setVersion(1);
        happyAndSmile.setSignAt(LocalDateTime.now());
        happyAndSmile.setCreateAt(LocalDateTime.now());
        happyAndSmile.setUpdateAt(LocalDateTime.now());
        rsHappyAndSmileMapper.insert(happyAndSmile);
    }

    public List<RsHappyAndSmile> getAll() {
        return rsHappyAndSmileMapper.selectList(Wrappers.lambdaQuery());
    }

    public List<RsHappyAndSmile> getHappyAndSmileByDateTime(DateTimeRangeRequest dateTimeRangeRequest) {
        LambdaQueryWrapper<RsHappyAndSmile> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.between(RsHappyAndSmile::getSignAt, DateConvertUtil.convertDateFixTimeZoneSearch(dateTimeRangeRequest.getBeginAt()), DateConvertUtil.convertDateFixTimeZoneSearch(dateTimeRangeRequest.getEndAt()));
        return rsHappyAndSmileMapper.selectList(queryWrapper);
    }

    public RsHappyAndSmile getOne(RsHappyAndSmile happyAndSmile) {
        if (happyAndSmile.getId() != null) return rsHappyAndSmileMapper.selectById(happyAndSmile.getId());
        LambdaQueryWrapper<RsHappyAndSmile> queryWrapper = getUniqueCondition(happyAndSmile);
        return rsHappyAndSmileMapper.selectOne(queryWrapper);
    }

    public List<String> getAutocompleteClub(String clubPrefix) {
        LambdaQueryWrapper<RsHappyAndSmile> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.likeRight(RsHappyAndSmile::getClub, clubPrefix);
        return rsHappyAndSmileMapper.selectList(queryWrapper).stream()
            .map(RsHappyAndSmile::getClub)
            .distinct()
            .collect(Collectors.toList());
    }

    private LambdaQueryWrapper<RsHappyAndSmile> getUniqueCondition(RsHappyAndSmile happyAndSmile) {
        LambdaQueryWrapper<RsHappyAndSmile> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.nested(i -> {
            i.eq(RsHappyAndSmile::getParticipant, happyAndSmile.getParticipant());
            i.eq(RsHappyAndSmile::getClub, happyAndSmile.getClub());
            i.eq(RsHappyAndSmile::getTitle, happyAndSmile.getTitle());
            i.eq(RsHappyAndSmile::getPrice, happyAndSmile.getPrice());
            i.eq(RsHappyAndSmile::getPaytype, happyAndSmile.getPaytype());
            i.eq(RsHappyAndSmile::getRemark, happyAndSmile.getRemark());
            return i;
        });
        queryWrapper.or().eq(RsHappyAndSmile::getFingerprint, happyAndSmile.getFingerprint());
        return queryWrapper;
    }

}
