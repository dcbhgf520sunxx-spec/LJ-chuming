package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingDrillQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingTaskNeedMachinePartSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.PartDistributionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingPartCheckDrillDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingMachinePartSchedulingBiz extends IBiz<MesBuildingMachinePartScheduling> {
   List<MesBuildingMachinePartSchedulingDTO> getMachinePartList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      String thick,
      List<String> thickList,
      String serialNumber,
      BigDecimal minLength,
      BigDecimal maxLength,
      Integer taskTypeEnum,
      Boolean boolDxfEnum,
      Boolean boolPriceEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   );

   MesBuildingMachinePartSchedulingSummaryDTO getMachinePartListAndSummary(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      String thick,
      List<String> thickList,
      String serialNumber,
      BigDecimal minLength,
      BigDecimal maxLength,
      Integer taskTypeEnum,
      Boolean boolDxfEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   );

   Long saveMachinePartNestCut(MesBuildingMachinePartSchedulingDTOParam dtoParam);

   Long saveMachinePartNestCutNew(MesBuildingMachinePartSchedulingDTOParam dtoParam);

   MesBuildingDrillQuantitySummaryDTO chenkDrill(List<MesBuildingPartCheckDrillDTOParam> partList, Long schedulingId, Long cutConfigId, String thick);

   MesBuildingDrillQuantitySummaryDTO chenkDrillV2(
      List<MesBuildingPartCheckDrillDTOParam> partList, Long schedulingId, Long cutConfigId, List<String> thickList
   );

   Boolean saveMachinePartNestCutTask(MesBuildingMachinePartSchedulingDTOParam dtoParam);

   List<MesBuildingMachinePartSchedulingDTO> getMachinePartSchedulingRecordList(Integer issueStatusEnum, LocalDateTime dateTime);

   PageVO<MesBuildingMachinePartSchedulingDTO> getMachinePartSchedulingRecordPage(
      Integer issueStatusEnum, LocalDateTime dateTime, Integer pageNumber, Integer pageSize
   );

   List<MesBuildingMachinePartSchedulingProjectDTO> getProjectList(List<LocalDateTime> monthList, LocalDateTime dateTime);

   List<ProjectDetailDO> getProjectTree(List<LocalDateTime> monthList, LocalDateTime dateTime, Integer level);

   List<MonomerDetailDO> getMonomerList(List<Long> projectIds, List<LocalDateTime> monthList, LocalDateTime dateTime);

   List<AreaDetailDO> getAreaList(List<Long> projectIds, List<Long> monomerIds, List<LocalDateTime> monthList, LocalDateTime dateTime);

   List<String> getMaterialList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      Integer taskTypeEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   );

   List<Integer> getPartTypeList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   );

   List<String> getThickList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      Integer taskTypeEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   );

   List<String> getDateList(LocalDateTime dateTime);

   List<String> getMonthList(Long workshopId);

   List<String> getMonthListTwo(List<Long> workshopIds, List<Integer> steelPlateTypeEnum, Boolean sendStatus);

   Boolean removeList(List<Long> ids);

   Boolean removeDetail(Long id);

   Boolean saveMachinePartNestingIssued(List<MesBuildingMachinePartNestingDTOParam> dtoParamList);

   List<MesBuildingMachinePartSchedulingDTO> getMachinePartTaskIssuedList(LocalDateTime date, Boolean boolNestCutEnum, Integer issueStatusEnum, Long projectId);

   PageVO<MesBuildingMachinePartSchedulingDTO> getMachinePartTaskIssuedPage(
      LocalDateTime date,
      Boolean boolNestCutEnum,
      Integer issueStatusEnum,
      String orderNumber,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String thick,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProjectTreeResponseVO> getNestCutProjectList(LocalDateTime startDate, LocalDateTime endDate, String name, Integer issueStatusEnum);

   List<MesBuildingNestCutPlateDTO> getMachinePartTaskIssuedDetails(Long id);

   Boolean updataIssueStatusEnum(String orderNumber);

   Boolean saveMachinePartUnNestingIssued(MesBuildingMachinePartNestingDTOParam copy);

   PartDistributionDTO partDistribution(Long id);

   void getSchedulingPDF(Long id);

   void downloadSchedulingFile(Long id);

   void downloadOffLineSchedulingFile(Long id);

   List<MesBuildingTaskNeedMachinePartSchedulingDTO> getNeedDetailByIds(List<Long> ids);

   Boolean partTaskOrderRevoke(Long id);

   Boolean partTaskOrderRevokeV2(Long taskOrderId);
}
