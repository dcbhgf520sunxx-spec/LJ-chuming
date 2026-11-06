package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import java.util.Collection;
import java.util.List;

public interface PlanMonomerService extends IService<PlanMonomer> {
   List<PlanMonomerDTO> listByCondition(Long projectId, String name);

   PlanMonomerDTO getMonomerById(Long id);

   PlanMonomer getByIdFromCache(Long id);

   PlanMonomer updateWithCache(PlanMonomer monomer);

   PlanMonomer saveWithCache(PlanMonomer monomer);

   int deleteWithCache(Long id);

   NameInfo getSimpleById(Long monomerId);

   List<NameInfo> listNameInfo(Collection<Long> monomerIds);

   PlanMaxMinDateDTO getMonomerDate(Long projectId);

   List<PlanMonomerDTO> getNoDeepenedPersonId(Long projectId);

   Integer yearOrderTon();

   List<ProjectPlanMonomerDTO> getListByProjectId(Long projectId);
}
