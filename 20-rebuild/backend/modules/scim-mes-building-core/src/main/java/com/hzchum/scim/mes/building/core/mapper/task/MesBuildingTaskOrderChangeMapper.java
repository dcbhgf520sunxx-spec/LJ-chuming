package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskOrderChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChange;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskOrderChangeMapper extends BaseMapper<MesBuildingTaskOrderChange> {
   List<MesBuildingTaskOrderChangeDO> getTaskOrderList(
      @Param("projectId") Long projectId, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("dateTime") LocalDateTime dateTime
   );

   List<MesBuildingTaskChangeDO> getTaskOrderDetailsList(
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification
   );

   List<MesBuildingChangeDO> getChangeList(@Param("taskTypeEnum") Integer taskTypeEnum, @Param("userName") String userName);

   List<MesBuildingChangeDetailsDO> getChangeDetailsList(@Param("taskTypeEnum") Integer taskTypeEnum, @Param("changeId") Long changeId);
}
