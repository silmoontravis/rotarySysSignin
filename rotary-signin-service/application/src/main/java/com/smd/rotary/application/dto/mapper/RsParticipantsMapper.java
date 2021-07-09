package com.smd.rotary.application.dto.mapper;

import com.smd.rotary.application.dto.model.RsParticipantsDto;
import com.smd.rotary.domain.signin.model.RsParticipants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RsParticipantsMapper {

    public static RsParticipantsDto convertDto(RsParticipants participants) {
        return RsParticipantsDto.builder()
            .participant(participants.getParticipant())
            .club(participants.getClub())
            .title(participants.getTitle())
            .device(participants.getDevice())
            .fingerprint(participants.getFingerprint())
            .signAt(participants.getSignAt()).build();
    }

    public static RsParticipants convertDao(RsParticipantsDto participantsDto) {
        return RsParticipants.builder()
            .participant(participantsDto.getParticipant())
            .club(participantsDto.getClub())
            .title(participantsDto.getTitle())
            .device(participantsDto.getDevice())
            .fingerprint(participantsDto.getFingerprint()).build();
    }
}
