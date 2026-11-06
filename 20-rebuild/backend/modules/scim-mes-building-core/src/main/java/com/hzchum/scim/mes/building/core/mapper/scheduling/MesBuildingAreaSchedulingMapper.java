package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.AreaSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAreaSchedulingMapper extends BaseMapper<MesBuildingAreaScheduling> {
   List<ProjectSchedulingDO> getProjectScheduling(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("status") Integer status,
      @Param("endDate") LocalDateTime endDate,
      @Param("endTimeList") List<LocalDateTime> endTimeList,
      @Param("projectIds") List<Long> projectIds
   );

   List<AreaSchedulingDO> getAreaSchedulingList(@Param("projectId") Integer projectId, @Param("projectType") Integer projectType);

   ProductMeteDTO getSumMeteByCondition(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<ProjectSchedulingTreeDO> getScheduling(
      @Param("dateTime") LocalDateTime dateTime, @Param("projectType") Integer projectType, @Param("workshopId") Long workshopId
   );
}
