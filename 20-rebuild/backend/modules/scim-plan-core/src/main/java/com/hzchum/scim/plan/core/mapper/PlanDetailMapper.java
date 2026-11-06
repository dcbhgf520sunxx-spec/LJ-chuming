package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanDetailMapper extends BaseMapper<PlanDetail> {
   List<PlanDetailResponseDTO> selectListDetailByCondition(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaProductType") Integer areaProductType, @Param("type") Integer type
   );

   List<PlanDetailTraceDTO> selectListDetailTrace(@Param("monomerId") Long monomerId, @Param("areaProductType") Integer areaProductType);

   PlanDetailTraceDTO selectPlanDate(
      @Param("monomerId") Long monomerId, @Param("areaProductType") Integer areaProductType, @Param("areaId") Long areaId, @Param("planType") Integer planType
   );
}
