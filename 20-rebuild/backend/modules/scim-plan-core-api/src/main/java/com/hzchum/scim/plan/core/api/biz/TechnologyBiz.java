package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.CreateDeeperLeaderDTOParam;

public interface TechnologyBiz {
   PageVO<TechnologyDTO> pageByYearAndName(Integer year, String name, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize);

   boolean createDeepArchivist(CreateDeeperLeaderDTOParam createDeeperLeaderDTOParam);

   boolean addDefaultDeepArchivist(PlanMonomer planMonomer);
}
