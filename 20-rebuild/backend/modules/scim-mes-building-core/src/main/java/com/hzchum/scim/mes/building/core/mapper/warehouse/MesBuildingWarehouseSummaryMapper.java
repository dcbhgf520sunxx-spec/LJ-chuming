package com.hzchum.scim.mes.building.core.mapper.warehouse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductCategoryMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WareEnclosureTaskPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WareSubscribeArtifactPrintDO;
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
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.WorkShopTonVO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartLabelDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingWarehouseSummaryMapper extends BaseMapper<MesBuildingWarehouseSummary> {
   List<WarehouseArtifactDO> listArtifactByCondition(WarehouseArtifactFindDOParam dtoParam);

   List<WarehouseEnclosureDO> listEnclosureByCondition(WarehouseEnclosureFindDOParam dtoParam);

   List<MesBuildingWarehouseSummary> selectListByFactoryAndArea(
      @Param("factoryId") Long factoryId, @Param("areaId") Long areaId, @Param("productId") Long productId, @Param("productType") Integer productType
   );

   List<ArtifactDetailDO> listArtifactPackageByCondition(ProductPackageDOParam param);

   List<ArtifactStockNumberDO> listArtifactPackageNumberByCondition(@Param("factoryId") Long factoryId, @Param("productIds") List<Long> productIds);

   List<SendDirectlyDetailDO> listDirectlyPackageByCondition(ProductPackageDOParam param);

   List<EnclosureDetailDO> listEnclosurePackageByCondition(ProductPackageDOParam param);

   List<TechStandardPartDetailDO> listTechStandardPartPackageByCondition(ProductPackageDOParam copy);

   ProductMeteDO sumMeteByCondition(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("factoryId") Long factoryId,
      @Param("productType") Integer productType,
      @Param("type") Integer type
   );

   List<ProductCategoryMeteDO> sumEnclosureMeteGroupCategoryByCondition(@Param("projectId") Long projectId);

   List<FinishProductWarehouseDTO> finishedWarehouse(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("productType") Integer productType,
      @Param("projectName") String projectName,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectStatus") Integer projectStatus,
      @Param("boolNowDate") Boolean boolNowDate
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosure(
      @Param("category") Integer category,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("productType") Integer productType,
      @Param("projectName") String projectName,
      @Param("projectIds") List<Long> projectIds
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureV2(
      @Param("dictionaryId") Long dictionaryId,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("productType") Integer productType,
      @Param("projectName") String projectName,
      @Param("projectIds") List<Long> projectIds
   );

   List<FinishProductWarehouseDTO> finishedWarehouseDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("workshopId") Long workshopId,
      @Param("productType") Integer productType,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList
   );

   List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetail(
      @Param("category") Integer category,
      @Param("projectId") Long projectId,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("serialNumber") String serialNumber,
      @Param("workshopId") Long workshopId,
      @Param("productType") Integer productType,
      @Param("dateTime") LocalDateTime dateTime
   );

   BigDecimal artifactWarehouseTon(@Param("type") Integer type, @Param("date") Date date, @Param("projectId") Long projectId);

   QuantityAndWeightDetailDO getMeteSummaryByCondition(
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   List<QuantityAndWeightDetailDO> getMeteSummaryByProjectIds(
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   BigDecimal artifactWarehouseTon(@Param("type") Integer type, @Param("date") Date date);

   List<TonVO> getTonOfDimension(@Param("type") Integer type, @Param("dimension") String dimension, @Param("val") int val);

   BigDecimal getTargetProduction();

   BigDecimal getProduction(@Param("date") Date date, @Param("type") Integer type, @Param("dimension") String dimension);

   List<WorkShopTonVO> manufacturingDeptProduction(@Param("dimension") String dimension, @Param("date") Date date);

   List<WorkShopTonVO> manufacturingDeptProductionOfMonth(@Param("workShopId") Long workShopId);

   List<ResponseVO> structureDespatchAndCarNumber(@Param("projectId") Long projectId);

   BigDecimal sumOutTon(@Param("projectId") Long projectId);

   BigDecimal artifactWarehouseQuantity(@Param("type") Integer type, @Param("date") Date date, @Param("projectId") Long projectId);

   List<MesBuildingProductionTaskDTO> produceStatisticsFinishList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   List<KevMeteDO> listUnCarQuantity(@Param("type") Integer type, @Param("ids") List<Long> ids, @Param("workshopId") Long workshopId);

   List<MesEnclosureWarehouseSummaryDTO> findEnclosureWarehouse(@Param("orderId") Long orderId, @Param("taskIds") List<Long> taskIds);

   List<UnEqualDTO> listUnEqual();

   List<MesBuildingWarehouseSummary> findAllWarehouseSummary(@Param("projectIds") List<Long> projectIds, @Param("type") Integer type);

   List<MesBuildingWarehouseSummary> listWareHouseSummary(@Param("addWarehouseDTOS") List<AddWarehouseDTO> addWarehouseDTOS);

   List<MesBuildingWarehouseSummary> listSummarysByData(@Param("checks") List<MesBuildingLineChangeListDTO> checks);

   BigDecimal selectTotalReceive(
      @Param("projectIds") List<Long> projectIds, @Param("projectId") Long projectId, @Param("workshopIds") List<Long> workshopIds, @Param("year") Integer year
   );

   List<WareSubscribeArtifactPrintDO> listArtifactPrint(WareSubscribeArtifactPrintDOParam param);

   List<WareEnclosureTaskPrintDTO> listEnclosurePrint(
      @Param("projectId") Long projectId,
      @Param("planId") Long planId,
      @Param("category") Integer category,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material
   );

   List<TechStandardPartLabelDTO> listTechStandardPart(AuxiliaryMaterialPrintDTOParam param);

   List<KevMeteDO> getProductOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<KevMeteDO> getProductOutMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);
}
