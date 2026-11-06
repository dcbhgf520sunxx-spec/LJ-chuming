package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.PickingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductWastageLossCostMesDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProjectLossProcessProductionKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProjectLossWorkProgressStatisticsWastageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageLossCostSummaryDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesLossWorkProgressStatisticsBiz {
   PageVO<ProjectLossWorkProgressStatisticsWastageDTO> wastageLossList(
      Integer year, Integer status, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, Integer pageNumber, Integer pageSize, Boolean boolDownload
   );

   List<ProjectLossProcessProductionKanBanDTO> projectSignageProcessList();

   List<WastageLossCostSummaryDTO> wastageLossCostSummary(Integer year, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, Boolean boolDownload);

   List<ProductWastageLossCostMesDetailDTO> wastageLossCostMesDetail(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum
   );

   PageVO<ProductWastageLossCostMesDetailDTO> getPageWastageLossCostMesDetail(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum,
      Integer pageNumber,
      Integer pageSize
   );

   void wastageLossListDownload(Integer year, Integer status, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, HttpServletResponse response);

   void wastageLossCostSummaryDownload(HttpServletResponse response, Integer year, Long projectId, Long workShopId, Integer projectOrWorkShopEnum);

   void getPageWastageLossCostMesDetailDownload(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum,
      HttpServletResponse response
   );

   void workshopProjectWastageLossDetailDownload(Long projectId, Long workShopId, Integer projectOrWorkShopEnum, HttpServletResponse response);

   List<ProjectLossWorkProgressStatisticsWastageDTO> getWastageDtoByProject(Integer year, Integer status, List<Long> projectIds, Integer lossCalculationFormula);

   List<ProjectLossWorkProgressStatisticsWastageDTO> getWastageDtoByWorkShop(List<Long> workShopIds, Integer lossCalculationFormula);

   void getWastageLossCostSummaryByproject(Long projectId, List<WastageLossCostSummaryDTO> costSummaryDTOS, Integer lossCalculationFormula);

   void getWastageLossCostSummaryByWorkShop(Integer year, Long workshopId, List<WastageLossCostSummaryDTO> costSummaryDTOS, Integer lossCalculationFormula);

   PageVO<PickingDetailDTO> getPagePickingDetailDTO(
      List<LocalDateTime> dateTimeList,
      Integer lossWorkProgressStatisticsEnum,
      Long projectId,
      Long workShopId,
      Integer basicClass,
      String classifyName,
      Integer pageNumber,
      Integer pageSize
   );

   void downloadPickingDetailDTO(
      List<LocalDateTime> dateTimeList,
      Integer lossWorkProgressStatisticsEnum,
      Long projectId,
      Long workShopId,
      Integer basicClass,
      String classifyName,
      HttpServletResponse response
   );

   HashMap<String, BigDecimal> getPickingSummary(
      List<LocalDateTime> dateTimeList, Integer lossWorkProgressStatisticsEnum, Long projectId, Long workShopId, Integer basicClass, String classifyName
   );
}
