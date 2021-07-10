package com.smd.rotary.application.controller.v1;

import com.smd.rotary.application.controller.v1.request.DateTimeRangeRequest;
import com.smd.rotary.application.dto.mapper.RsHappyAndSmileMapper;
import com.smd.rotary.application.dto.model.RsHappyAndSmileDto;
import com.smd.rotary.application.dto.response.ApiResult;
import com.smd.rotary.application.dto.response.StatusCode;
import com.smd.rotary.domain.signin.model.RsHappyAndSmile;
import com.smd.rotary.domain.signin.service.RsHappyAndSmileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API for HappyAndSmile", tags = "參與人")
@RequestMapping("/v1/HappyAndSmile")
@RestController
// @CrossOrigin(allowCredentials = "true")
public class HappyAndSmileController {

    @Autowired
    private RsHappyAndSmileService rsHappyAndSmileService;

    @ApiOperation("新增參與人")
    @PostMapping("/")
    public ApiResult<RsHappyAndSmileDto> addParticipant(@Valid RsHappyAndSmileDto HappyAndSmileDto) {
        RsHappyAndSmile participant = RsHappyAndSmileMapper.convertDao(HappyAndSmileDto);
        rsHappyAndSmileService.insertOne(participant);
        return new ApiResult(StatusCode.SUCCESS, RsHappyAndSmileMapper.convertDto(rsHappyAndSmileService.getOne(participant)));
    }

    @ApiOperation("查詢某時間段參與人列表")
    @GetMapping("/")
    public ApiResult<List<RsHappyAndSmileDto>> getParticipantByDateTime(@Valid DateTimeRangeRequest dateTimeRangeRequest) {
        return new ApiResult(StatusCode.SUCCESS, rsHappyAndSmileService.gethappyAndSmileByDateTime(dateTimeRangeRequest).stream().map(RsHappyAndSmileMapper::convertDto).collect(Collectors.toList()));
    }

    @ApiOperation("獲取社團列表")
    @GetMapping("/club/{club}")
    public ApiResult<List<String>> getAutocompleteClub(@PathVariable("club") String club) {
        return new ApiResult(StatusCode.SUCCESS, rsHappyAndSmileService.getAutocompleteClub(club));
    }
}
