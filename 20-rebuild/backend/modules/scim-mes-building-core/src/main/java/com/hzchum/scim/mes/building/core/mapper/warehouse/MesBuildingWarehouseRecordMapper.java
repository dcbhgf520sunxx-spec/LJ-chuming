package com.hzchum.scim.mes.building.core.mapper.warehouse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskPartPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppDispatchSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportDO;
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
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingWarehouseRecordMapper extends BaseMapper<MesBuildingWarehouseRecord> {
   List<WarehouseReportDO> listReportByCondition(WarehouseReportDOParam param);

   List<WarehouseReportArtifactDO> listArtifactReportByCondition(WarehouseReportDetailDOParam param);

   List<WarehouseReportEnclosureDO> listEnclosureReportByCondition(WarehouseReportDetailDOParam param);

   List<WarehouseReportArtifactDO> listArtifactRecordDetail(AppWarehouseRecordDOParam param);

   List<WarehouseReportEnclosureDO> listEnclosureRecordDetail(AppWarehouseRecordDOParam param);

   List<ProductProjectSumDO> sumGroupByProject(AppShipTimeDOParam param);

   ProductMeteDO sumMeteByCondition(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("factoryId") Long factoryId,
      @Param("productType") Integer productType,
      @Param("type") Integer type,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<DeliverDTO> DeliverGroupByMonth(@Param("dateTime") LocalDateTime dateTime);

   List<AppDispatchSumDO> dispatchSum(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("productType") Integer productType);

   List<ProductWarehouseDTO> getProductList(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("productionLineName") String productionLineName,
      @Param("productName") String productName,
      @Param("serialNumber") String serialNumber,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productType") Integer productType
   );

   List<WarehouseReportArtifactDO> finishArtifactReport(WarehouseReportDetailDOParam param);

   List<WarehouseReportArtifactDO> finishArtifactPackReport(WarehouseReportDetailDOParam param);

   List<WarehouseReportEnclosureDO> finishEnclosureReport(WarehouseReportDetailDOParam param);

   List<WarehouseReportArtifactDO> finishArtifactReportStock(WarehouseReportDetailDOParam param);

   List<WarehouseReportEnclosureDO> finishEnclosureReportStock(WarehouseReportDetailDOParam param);

   List<WarehouseReportArtifactDO> finishArtifactReportBeginning(WarehouseReportDetailDOParam param);

   List<WarehouseReportEnclosureDO> finishEnclosureReportBeginning(WarehouseReportDetailDOParam param);

   List<TechArtifactChangeDTO> listQuantityChanges(@Param("changeIds") List<Long> changeIds);

   List<TechArtifactChangeDTO> listWeightChanges(@Param("changeIds") List<Long> changeIds);

   List<TaskPartPrintDO> listSendUnProcess(
      @Param("areaId") Long areaId,
      @Param("name") String name,
      @Param("material") String material,
      @Param("lineId") Long lineId,
      @Param("specification") String specification,
      @Param("serialNumber") String serialNumber
   );

   List<MesBuildingWarehouseRecord> findWarehouseRecordByProjectId(@Param("projectId") Long projectId);

   List<MesBuildingProductBoolChangeDTO> listBoolArtInCargo(@Param("changeList") List<NumberInfoDTO> changeList);

   List<MesBuildingProductBoolChangeDTO> listBoolAssInCargo(@Param("assNumbers") List<NumberInfoDTO> assNumbers);

   List<TaskPartPrintDO> sumlistSendUnProcess(
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("name") String name,
      @Param("material") String material,
      @Param("lineId") Long productionLineId,
      @Param("specification") String specification,
      @Param("serialNumber") String serialNumber
   );

   List<ProductionDetailDO> steelProduction(
      @Param("year") Integer year,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId
   );

   BigDecimal recordTotalWeight(
      @Param("year") Integer year,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId
   );

   List<TaskConditionByDateDTO> getEachWorkShopWarehouseRecord(LocalDateTime date);

   List<WorkShopTaskCompleteDetailDTO> findWorkshopCompletePercentageDetail(@Param("date") LocalDateTime date, @Param("workShopId") Long workShopId);
}
