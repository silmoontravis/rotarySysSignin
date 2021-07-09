package com.smd.rotary.domain.signin.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smd.rotary.domain.signin.model.RsParticipants;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RsParticipantsMapper extends BaseMapper<RsParticipants> {
}
