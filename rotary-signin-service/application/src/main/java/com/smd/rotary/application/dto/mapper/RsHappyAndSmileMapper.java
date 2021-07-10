package com.smd.rotary.application.dto.mapper;

import com.smd.rotary.application.dto.model.RsHappyAndSmileDto;
import com.smd.rotary.domain.signin.model.RsHappyAndSmile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RsHappyAndSmileMapper {

    public static RsHappyAndSmileDto convertDto(RsHappyAndSmile rsHappyAndSmile) {
        return RsHappyAndSmileDto.builder()
            .participant(rsHappyAndSmile.getParticipant())
            .club(rsHappyAndSmile.getClub())
            .title(rsHappyAndSmile.getTitle())
            .device(rsHappyAndSmile.getDevice())
            .fingerprint(rsHappyAndSmile.getFingerprint())
            .price(rsHappyAndSmile.getPrice())
            .paytype(rsHappyAndSmile.getPaytype())
            .remark(rsHappyAndSmile.getRemark())
            .signAt(rsHappyAndSmile.getSignAt()).build();
    }

    public static RsHappyAndSmile convertDao(RsHappyAndSmileDto happyAndSmileDto) {
        return RsHappyAndSmile.builder()
            .participant(happyAndSmileDto.getParticipant())
            .club(happyAndSmileDto.getClub())
            .title(happyAndSmileDto.getTitle())
            .device(happyAndSmileDto.getDevice())
            .fingerprint(happyAndSmileDto.getFingerprint())
            .price(happyAndSmileDto.getPrice())
            .paytype(happyAndSmileDto.getPaytype())
            .remark(happyAndSmileDto.getRemark()).build();
    }
}
