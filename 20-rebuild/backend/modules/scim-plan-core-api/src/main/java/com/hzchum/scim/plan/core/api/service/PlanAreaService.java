package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PlanAreaService extends IService<PlanArea> {
   PageVO<PlanAreaDTO> listAreaByConditions(Long projectId, Long monomerId, Integer productType, Integer itemizedType, Integer pageNumber, Integer pageSize);

   ListVO<Map<String, Object>> listProductTypeByMonomerId(Long monomerId);

   PlanArea getByIdFromCache(Long areaId);

   PlanArea updateAreaWithCache(PlanArea area);

   PlanArea saveAreaWithCache(PlanArea area);

   int deleteAreaWithCache(Long id);

   NameInfo getSimpleById(Long areaId);

   List<NameInfo> listSimpleByIds(Collection<Long> areaIds);

   PlanMaxMinDateDTO getMaxMinDate(Long monomerId, Integer areaProductType);

   List<PlanArea> listAreaByMonomerId(Long monomerId);

   List<PlanArea> getMachinePartByAreaList(Set<Long> cutIds, List<Long> projectIds);

   List<PlanArea> getArtifactAndAssembleByAreaList(Set<Long> assemblesTaskOrderIds, Integer taskTypeEnum);

   List<ProjectPlanAreaDTO> getListByProjectId(Long projectId);
}
