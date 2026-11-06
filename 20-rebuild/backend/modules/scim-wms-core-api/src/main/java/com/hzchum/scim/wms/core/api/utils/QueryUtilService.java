package com.hzchum.scim.wms.core.api.utils;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.common.PriceDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface QueryUtilService {
   Map<Long, PlanMonomer> getMonomerMapByIds(Collection<Long> list);

   Map<Long, PlanMonomer> getMonomerMapAll();

   Map<Long, PlanArea> getAreaMapByIds(Collection<Long> list);

   Map<Long, PlanArea> getAreaMapAll();

   Map<Long, Classification> getClassificationMapByIds(Collection<Long> list);

   Map<Long, Classification> getClassificationMap(List<Long> list);

   Map<Long, MesBuildingFactory> getFactoryMap(List<Long> list);

   Map<Long, Workshop> getWorkshopMapByIds(Collection<Long> list);

   Map<Long, Workshop> getWorkshopMap(List<Long> list);

   Map<Long, Warehouse> getWarehouseMapByIds(Collection<Long> list);

   Map<Long, Warehouse> getWarehouseMap(List<Long> list);

   Map<Long, ContractProject> getProjectMapByIds(Collection<Long> list);

   Map<Long, ContractProject> getProjectMap(List<Long> list);

   Map<Long, ProjectInfo> getProjectInfoMapByIds(Collection<Long> list);

   Map<Long, MaterialFreeze> getMaterialFreezeMap(List<Long> list);

   Map<Long, List<MaterialFreezeRecord>> getMaterialFreezeRecordMap(Integer freezeType);

   Map<Long, Supplier> getSupplierMapByIds(Collection<Long> list);

   Map<Long, Supplier> getSupplierMap(List<Long> list);

   Map<Long, PurchaseOrder> getPrchaseOrderMap(List<Long> list);

   Map<Long, Measure> getMeasureMapByClassifyIds(Collection<Long> list);

   Map<Long, Measure> getMeasureMap();

   Map<Long, BranchCompany> getBranchCompanyMap(List<Long> list);

   Map<Long, ApplyPurchase> getApplyPurchaseMapByIds(Collection<Long> list);

   Map<Long, ApplyPurchase> getApplyPurchaseMap(List<Long> list);

   Map<Long, PurchaseOrder> getPurchaseOrderMapByIds(Collection<Long> list);

   List<PurchaseOrderDetail> getPurchaseOrderDetail(List<Long> list);

   Map<Long, ApplyPurchaseDetail> getApplyPurchaseDetailMap(List<Long> list);

   List<Long> getLateClassificationList(List<Long> list);

   Map<Long, MonthWeightedAveragePrice> getMonthWeightedAveragePriceMap(List<Long> list);

   Map<Long, WholeWeightedAveragePrice> getWholeWeightedAveragePriceMap(List<Long> list);

   Map<Long, InboundManufactured> getInboundManufacturedMapByIds(Collection<Long> list);

   Map<Long, OutboundManufactured> getOutboundManufacturedMapByIds(Collection<Long> list);

   Map<Long, ReturnManufactured> getReturnManufacturedMapByIds(Collection<Long> list);

   String getConfigShowSpec(String jsonStr, BasicShowConfig config);

   Integer createInboundSerialNumber(String tableNameKey);

   void getMaterialInventorys(Outbound outbound, List<MoveOutboundDetail> outboundDetailList, String currentName, Long currentUserId);

   Map<Long, User> getUserMapByIds(Collection<Long> list);

   Map<Long, MesBuildingWorkshop> getMesWorkshopByIds(Collection<Long> list);

   Map<Long, WmsMaterialCodeConfig> getMaterialCodeConfigMap(Collection<Long> list);

   Map<String, WmsMaterialCodeConfig> getMaterialCodeConfigMaps(Collection<Long> list);

   BigDecimal getMete(SubjectMeasureDTO subjectMeasureDTO, BigDecimal mete);

   String getSurplusSn();

   PriceDTO getPrice(
      WeightedPriceConf weightedPriceConf, WeightedExecutionPriceConf weightedExecutionPriceConf, MaterialInventory materialInventory, LocalDateTime realTime
   );
}
