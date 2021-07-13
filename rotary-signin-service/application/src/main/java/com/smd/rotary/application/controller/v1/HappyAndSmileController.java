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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API for HappyAndSmile", tags = "歡喜單")
@RequestMapping("/v1/happy-and-smile")
@RestController
// @CrossOrigin(allowCredentials = "true")
public class HappyAndSmileController {

    @Autowired
    private RsHappyAndSmileService rsHappyAndSmileService;

    @ApiOperation("新增歡喜單")
    @PostMapping("/")
    public ApiResult<RsHappyAndSmileDto> addHappyAndSmile(@Valid RsHappyAndSmileDto happyAndSmileDto) {
        RsHappyAndSmile participant = RsHappyAndSmileMapper.convertDao(happyAndSmileDto);
        rsHappyAndSmileService.insertOne(participant);
        return new ApiResult(StatusCode.SUCCESS, RsHappyAndSmileMapper.convertDto(rsHappyAndSmileService.getOne(participant)));
    }

    @ApiOperation("查詢某時間段歡喜單列表")
    @GetMapping("/")
    public ApiResult<List<RsHappyAndSmileDto>> getHappyAndSmile(@Valid DateTimeRangeRequest dateTimeRangeRequest) {
        return new ApiResult(StatusCode.SUCCESS, rsHappyAndSmileService.gethappyAndSmileByDateTime(dateTimeRangeRequest).stream().map(RsHappyAndSmileMapper::convertDto).collect(Collectors.toList()));
    }

    @ApiOperation("獲取社團列表")
    @GetMapping("/club/{club}")
    public ApiResult<List<String>> getHappyAndSmileClub(@PathVariable("club") String club) {
        return new ApiResult(StatusCode.SUCCESS, rsHappyAndSmileService.getAutocompleteClub(club));
    }
}
