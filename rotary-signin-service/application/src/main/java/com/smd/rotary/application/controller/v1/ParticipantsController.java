package com.smd.rotary.application.controller.v1;

import com.smd.rotary.application.controller.v1.request.DateTimeRangeRequest;
import com.smd.rotary.application.dto.mapper.RsParticipantsMapper;
import com.smd.rotary.application.dto.model.RsParticipantsDto;
import com.smd.rotary.application.dto.response.ApiResult;
import com.smd.rotary.application.dto.response.StatusCode;
import com.smd.rotary.domain.signin.model.RsParticipants;
import com.smd.rotary.domain.signin.service.RsParticipantsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API for participants", tags = "參與人")
@RequestMapping("/v1/participants")
@RestController
// @CrossOrigin(allowCredentials = "true")
public class ParticipantsController {

    @Autowired
    private RsParticipantsService rsParticipantsService;

    @ApiOperation("新增參與人")
    @PostMapping("/")
    public ApiResult<RsParticipantsDto> addParticipant(@Valid RsParticipantsDto participantsDto) {
        RsParticipants participant = RsParticipantsMapper.convertDao(participantsDto);
        rsParticipantsService.insertOne(participant);
        return new ApiResult(StatusCode.SUCCESS, RsParticipantsMapper.convertDto(rsParticipantsService.getOne(participant)));
    }

    @ApiOperation("查詢某時間段參與人列表")
    @GetMapping("/")
    public ApiResult<List<RsParticipantsDto>> getParticipantByDateTime(@Valid DateTimeRangeRequest dateTimeRangeRequest) {
        return new ApiResult(StatusCode.SUCCESS, rsParticipantsService.getParticipantByDateTime(dateTimeRangeRequest).stream().map(RsParticipantsMapper::convertDto).collect(Collectors.toList()));
    }

    @ApiOperation("獲取社團列表")
    @GetMapping("/club/{club}")
    public ApiResult<List<String>> getAutocompleteClub(@PathVariable("club") String club) {
        return new ApiResult(StatusCode.SUCCESS, rsParticipantsService.getAutocompleteClub(club));
    }
}
