package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.AreaSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingAreaSchedulingService extends IService<MesBuildingAreaScheduling> {
   List<ProjectSchedulingDO> getProjectScheduling(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, List<LocalDateTime> endTimeList, List<Long> projectIds
   );

   List<AreaSchedulingDO> getAreaSchedulingList(Integer projectId, Integer projectType);

   ProductMeteDTO getSumMeteByCondition(Long projectId, Integer productType);

   List<ProjectSchedulingTreeDO> getScheduling(LocalDateTime dateTime, Integer projectType, Long workshopId);
}
