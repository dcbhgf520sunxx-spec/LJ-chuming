package com.hzchum.scim.mes.building.core.api.biz.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material.MachinePartReportRawMaterialFeedingRecordParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import java.util.List;

public interface MesBuildingTaskFastBiz extends IService<MesBuildingTask> {
   Boolean saveNestCutPlateReportFast(
      Long nestCutPlateId,
      List<Long> partIds,
      String ncCode,
      Boolean reportType,
      List<IdAndRecelveQuantityDTO> parts,
      Long userIdNest,
      List<MachinePartReportRawMaterialFeedingRecordParam> rawMaterialList
   );

   Boolean saveDrillNestCutPlateReportFast(Long nestCutPlateId, List<IdAndRecelveQuantityDTO> parts, Boolean reportType, Long userIdNest);

   List<Integer> saveProduceTeamReportFast(
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      Long userIdNest
   );

   List<AppTaskProcessDTO> getMachinePartListByCutId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber);

   Boolean checkProductMachinePartStatusFast(List<Long> productIds);

   List<Integer> saveTeamReportFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Long userIdNest
   );

   Boolean saveProduceTeamReportSummaryFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Integer type,
      Long userIdNest
   );

   Boolean updateNextTaskProcessFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Long userIdNest
   );
}
