package com.hzchum.scim.mes.building.core.api.service.warehouse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskPartPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppDispatchSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.AppWarehouseRecordDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingProductBoolChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TaskConditionByDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.DeliverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseReportSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingWarehouseRecordService extends IService<MesBuildingWarehouseRecord> {
   List<WarehouseReportDTO> listReport(WarehouseReportDOParam param);

   PrintVO<List<Map<String, Object>>> printReport(WarehouseReportDOParam param);

   WarehouseReportSumDTO sumReport(WarehouseReportDOParam param);

   PageVO listArtifactReportDetail(WarehouseReportDetailDOParam param);

   PageVO listEnclosureReportDetail(WarehouseReportDetailDOParam param);

   ListVO listArtifactRecordDetail(AppWarehouseRecordDOParam param);

   ListVO listEnclosureRecordDetail(AppWarehouseRecordDOParam param);

   ListVO<ProductProjectSumDO> sumGroupByProject(AppShipTimeDOParam productType);

   ProductMeteDO sumMeteByCondition(
      @Param("projectId") Long projectId,
      @Param("factoryId") Long factoryId,
      @Param("productType") Integer productType,
      @Param("type") Integer type,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<DeliverDTO> DeliverGroupByMonth(LocalDateTime dateTime);

   List<AppDispatchSumDO> dispatchSum(Long projectId, Long monomerId, Integer productType);

   PageVO<ProductWarehouseDTO> getProductPage(
      LocalDateTime dateTime,
      String productionLineName,
      String productName,
      String serialNumber,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProductWarehouseDTO> getProductList(
      LocalDateTime dateTime,
      String productionLineName,
      String productName,
      String serialNumber,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType
   );

   List<WarehouseReportArtifactDO> finishArtifactReport(WarehouseReportDetailDOParam param);

   List<WarehouseReportEnclosureDO> finishEnclosureReport(WarehouseReportDetailDOParam param);

   List<TechArtifactChangeDTO> listQuantityChanges(List<Long> changeIds);

   List<TechArtifactChangeDTO> listWeightChanges(List<Long> changeIds);

   List<TaskPartPrintDO> listSendUnProcess(Long areaId, String name, String material, Long lineId, String specification, String serialNumber);

   List<MesBuildingWarehouseRecord> findWarehouseRecordByProjectId(Long projectId);

   List<MesBuildingProductBoolChangeDTO> listBoolArtInCargo(List<NumberInfoDTO> changeList);

   List<MesBuildingProductBoolChangeDTO> listBoolAssInCargo(List<NumberInfoDTO> assNumbers);

   List<TaskPartPrintDO> sumlistSendUnProcess(
      Long areaId, Long areaBatchId, String name, String material, Long productionLineId, String specification, String serialNumber
   );

   List<ProductionDetailDO> steelProduction(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId);

   BigDecimal recordTotalWeight(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId);

   List<TaskConditionByDateDTO> getEachWorkShopWarehouseRecord(LocalDateTime date);

   List<WorkShopTaskCompleteDetailDTO> findWorkshopCompletePercentageDetail(LocalDateTime date, Long workShopId);
}
