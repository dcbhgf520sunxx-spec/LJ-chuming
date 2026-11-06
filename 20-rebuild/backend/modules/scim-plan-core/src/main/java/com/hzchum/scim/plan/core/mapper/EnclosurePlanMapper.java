package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureTechQureyDto;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;

public interface EnclosurePlanMapper extends BaseMapper<EnclosurePlan> {
   List<EnclosurePlan> findById(@Param("dto") EnclosureTechQureyDto dto);

   List<String> selectSql(String areaName);

   void updateSql(String areaName);
}
