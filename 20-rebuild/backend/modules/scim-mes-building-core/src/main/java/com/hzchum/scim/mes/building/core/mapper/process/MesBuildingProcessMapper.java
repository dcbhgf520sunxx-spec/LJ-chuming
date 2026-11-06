package com.hzchum.scim.mes.building.core.mapper.process;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProcessMapper extends BaseMapper<MesBuildingProcess> {
   List<MesBuildingProcess> listByUserId(@Param("type") Boolean type, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("userId") Long userId);

   List<MesBuildingProcess> listByUserId2(@Param("type") Boolean type, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("userId") Long userId);

   List<MesBuildingProcess> listByProductionLineId(@Param("productionLineId") Long productionLineId, @Param("productType") Integer productType);

   List<MesBuildingProcessDTO> getWorkshopByProcessList(@Param("workshopId") Long workshopId);

   List<AppTaskProcessDTO> listAssistDetail(
      @Param("assIstIds") List<Long> assIstIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("taskId") Long taskId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("serialNumber") String serialNumber
   );

   List<AppTaskProcessDTO> listAssistDetail2(
      @Param("assIstIds") List<Long> assIstIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("taskId") Long taskId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("serialNumber") String serialNumber
   );
}
