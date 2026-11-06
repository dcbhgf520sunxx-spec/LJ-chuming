package com.hzchum.scim.mes.building.core.api.service.warehouse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductCategoryMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.ProductPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.WareSubscribeArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseArtifactFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingLineChangeListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.MesEnclosureWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.UnEqualDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.ArtifactWarehouseTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.WorkShopTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.productionCapacity.ProductionCapacityVO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesBuildingWarehouseSummaryService extends IService<MesBuildingWarehouseSummary> {
   PageVO<ArtifactDetailDO> listArtifactPackageByCondition(ProductPackageDOParam copy);

   PageVO<SendDirectlyDetailDO> listPartPackageByCondition(ProductPackageDOParam copy);

   List<EnclosureDetailDO> listEnclosurePackageByCondition(ProductPackageDOParam copy);

   PageVO<TechStandardPartDetailDO> listTechStandardPartPackageByCondition(ProductPackageDOParam copy);

   Map<String, Object> listByProduct(Long factoryId, Long productId, Long taskId, Integer productType, Long workshopId, Long warehouseId, Integer number);

   MesBuildingWarehouseSummary updateQuantity(Long warehouseRecordId, BigDecimal quantity, Integer productType, int type);

   PageVO<WarehouseArtifactDO> pageArtifact(WarehouseArtifactFindDOParam param);

   PrintVO printArtifact(WarehouseArtifactFindDOParam param);

   PageVO<WarehouseEnclosureDO> pageEnclosure(WarehouseEnclosureFindDOParam param);

   PrintVO printEnclosure(WarehouseEnclosureFindDOParam param);

   ProductMeteDO sumMeteByCondition(Long projectId, Long monomerId, Long factoryId, Integer productType, Integer type);

   List<ProductCategoryMeteDO> sumEnclosureMeteGroupCategory(Long projectId);

   List<FinishProductWarehouseDTO> finishedWarehouse(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      List<Long> projectIds,
      Integer projectStatus,
      Boolean boolNowDate
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosure(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   );

   QuantityAndWeightDetailDO getMeteSummaryByCondition(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

   List<QuantityAndWeightDetailDO> getMeteSummaryByProjectIds(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

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

   List<ArtifactWarehouseTonVO> techArtifactWarehouseSummaryWarehouse();

   ProductionCapacityVO productionCapacity();

   List<TonVO> techArtifactProductionAnalysis(String type);

   List<WorkShopTonVO> manufacturingDeptProduction(String type);

   BigDecimal techArtifactWarehouseSummaryStock();

   BigDecimal techArtifactWarehouseSummaryRate();

   List<TonVO> techArtifactWarehouseSummaryTrend();

   BigDecimal manufacturingDeptProductionRate();

   List<ResponseVO> structureDespatchAndCarNumber(Long projectId);

   BigDecimal carGoDetailTon();

   List<ResponseVO> overviewOfEnclosureProduction();

   List<ResponseVO> overviewOfEnclosureProductionOfMonth();

   List<ResponseVO> trafficVolumeOfEnclosure();

   BigDecimal sumOutTon(Long projectId);

   Map<String, Object> techArtifactProduceOutInfo(Long projectId);

   Map<String, Object> techArtifactInventoryInfo(Long projectId);

   List<MesBuildingProductionTaskDTO> produceStatisticsFinishList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   List<KevMeteDO> listUnCarQuantity(Integer type, List<Long> ids, Long workshopId);

   List<MesEnclosureWarehouseSummaryDTO> findEnclosureWarehouse(Long orderId, List<Long> taskIds);

   List<UnEqualDTO> listUnEqual();

   List<MesBuildingWarehouseSummary> findAllWarehouseSummary(List<Long> projectIds, Integer type);

   List<MesBuildingWarehouseSummary> listWareHouseSummary(List<AddWarehouseDTO> addWarehouseDTOS);

   List<MesBuildingWarehouseSummary> listSummarysByData(List<MesBuildingLineChangeListDTO> listDtos);

   BigDecimal selectTotalReceive(List<Long> projectIds, Long projectId, List<Long> workshopIds, Integer year);

   PageVO listArtifactPrint(WareSubscribeArtifactPrintDOParam param);

   PageVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO listTechStandardPartPrint(AuxiliaryMaterialPrintDTOParam param);

   List<KevMeteDO> getProductOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<KevMeteDO> getProductOutMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);
}
