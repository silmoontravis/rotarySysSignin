package com.smd.rotary.application.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smd.rotary.constant.AppConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


@ApiModel("參與人登記表 DTO")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RsHappyAndSmileDto implements Serializable {

    private static final long serialVersionUID = -6466038130343152717L;

    @ApiModelProperty(value = "參與人", example = "user", required = true)
    private String participant;

    @ApiModelProperty(value = "職稱", example = "title", required = true)
    private String title;

    @ApiModelProperty(value = "社團", example = "club", required = true)
    private String club;

    @ApiModelProperty(value = "裝置", example = "user agent", required = true)
    private String device;

    @ApiModelProperty(value = "裝置唯一碼", example = "abc", required = true)
    private String fingerprint;

    @ApiModelProperty(value = "金額", example = "1000", required = true)
    private Integer price;

    @ApiModelProperty(value = "支付方式", example = "1", required = true)
    private Integer paytype;

    @ApiModelProperty(value = "祝福的話", example = "happy and smile", required = true)
    private String remark;

    @ApiModelProperty(value = "登記時間", example = "2021-01-01T00:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = AppConstants.TIME_ZONE)
    private LocalDateTime signAt;
}
