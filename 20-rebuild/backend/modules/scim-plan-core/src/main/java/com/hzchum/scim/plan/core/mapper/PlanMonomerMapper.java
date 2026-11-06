package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface PlanMonomerMapper extends BaseMapper<PlanMonomer> {
   List<PlanMonomerDTO> listByProjectIdAndName(@Param("projectId") Long projectId, @Param("name") String name);

   List<ContractProjectContent> listContentByProjectId(@Param("projectId") Long projectId);

   @MapKey("")
   List<Map<String, Object>> listProductTypeByMonomerId(@Param("monomerId") Long monomerId);

   PlanMaxMinDateDTO selectMinMaxDate(@Param("projectId") Long projectId);

   List<PlanMonomerDTO> selectNoDeepenedPersonId(@Param("projectId") Long projectId);

   Integer yearOrderTon();

   List<ProjectPlanMonomerDTO> getListByProjectId(@Param("projectId") Long projectId);
}
