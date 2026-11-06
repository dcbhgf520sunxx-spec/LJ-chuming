package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface PlanAreaMapper extends BaseMapper<PlanArea> {
   PlanMaxMinDateDTO selectMaxMinDate(@Param("monomerId") Long monomerId, @Param("areaProductType") Integer areaProductType);

   List<PlanArea> getMachinePartByAreaList(Set<Long> cutIds, List<Long> projectIds);

   List<PlanArea> getArtifactAndAssembleByAreaList(Set<Long> assemblesTaskOrderIds, Integer taskTypeEnum);

   List<ProjectPlanAreaDTO> getListByProjectId(@Param("projectId") Long projectId);
}
