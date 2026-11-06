package com.hzchum.scim.mes.building.core.api.biz.warehouse;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.DeliverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.MesBuildingWarehouseRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface WarehouseBiz {
   ProductWarehouseSummaryDTO sumMete(Long monomerId, Long factoryId, Integer productType);

   void setStockQuantity(WarehouseSaveDTOParam param);

   void setWmsWarehousing(WarehouseSaveDTOParam param);

   void setStockQuantityProductReturn(WarehouseSaveDTOParam param);

   void removeWarehouseRecord(List<Long> productIds, Integer productType);

   void reduceQuantity(Long completeId, Integer quantity);

   Map<String, Object> sumAppMete(Long projectId, Long monomerId);

   List<DeliverDTO> DeliverGroupByMonth(LocalDateTime dateTime);

   PageVO<MesBuildingWarehouseRecordDTO> listWareHouseRecord(Long projectId, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printInWareHouseRecord(Long projectId);

   FinishProductWarehouseDTO finishedWarehouseSummary(
      Long projectId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Long workShopId,
      Integer productType,
      String projectName,
      List<Long> projectIds,
      Integer projectStatus
   );

   FinishProductWarehouseEnclosureDTO finishedWarehouseEnclosureSummary(
      Integer category, Long projectId, LocalDateTime dateTime, Long workShopId, Integer productType, String projectName, List<Long> projectIds
   );

   FinishProductWarehouseEnclosureDTO finishedWarehouseEnclosureSummaryV2(
      Long dictionaryId, Long projectId, LocalDateTime dateTime, Long workShopId, Integer productType, String projectName, List<Long> projectIds
   );

   List<FinishProductWarehouseDTO> finishedWarehouse(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      List<Long> projectIds,
      Integer projectStatus
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosure(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   );

   PageVO<FinishProductWarehouseDTO> finishedWarehousePage(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosurePage(
      Integer category,
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosurePageV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> finishedWarehousePrint(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer projectStatus
   );

   PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosurePrint(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, Integer lumpSumSystemType
   );

   PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosurePrintV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName
   );

   List<FinishProductWarehouseDTO> finishedWarehouseDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetail(
      Integer category, Long projectId, Long enclosurePlanId, String serialNumber, Long workshopId, Integer productType, LocalDateTime dateTime
   );

   PageVO<FinishProductWarehouseDTO> finishedWarehouseDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetailPage(
      Integer category,
      Long projectId,
      Long enclosurePlanId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> finishedWarehouseDetailPrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer weightStatus
   );

   PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosureDetailPrint(
      Integer category, Long projectId, Long enclosurePlanId, String serialNumber, Long workshopId, Integer productType, LocalDateTime dateTime
   );

   PageVO finishArtifactReport(WarehouseReportDetailDOParam param);

   Map<String, Object> finishArtifactReportSum(WarehouseReportDetailDOParam param);

   PageVO finishEnclosureReport(WarehouseReportDetailDOParam param);

   PageVO finishEnclosureReportV2(WarehouseReportDetailDOParam param);

   PrintVO<List<Map<String, Object>>> printFinishedWarehousePrint(WarehouseReportDetailDOParam param);

   PrintVO<List<Map<String, Object>>> printFinishedWarehouseEnclosurePrint(WarehouseReportDetailDOParam param);

   boolean checkTechStandardPart(Long id, BigDecimal inboundMete);
}
