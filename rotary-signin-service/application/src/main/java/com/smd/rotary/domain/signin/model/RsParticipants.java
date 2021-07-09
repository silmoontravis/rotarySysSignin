package com.smd.rotary.domain.signin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@TableName("rs_participants")
@Data
@Builder
public class RsParticipants {

    /**
     * 表 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 參與人
     */
    private String participant;
    /**
     * 職稱
     */
    private String title;
    /**
     * 社團
     */
    private String club;
    /**
     * 裝置 (User Agent)
     */
    private String device;
    /**
     * 裝置唯一碼
     */
    private String fingerprint;
    /**
     * 登記時間
     */
    private LocalDateTime signAt;
    /**
     * 版控
     */
    private Integer version;
    /**
     * 版控
     */
    private LocalDateTime createAt;
    /**
     * 版控
     */
    private LocalDateTime updateAt;
}
