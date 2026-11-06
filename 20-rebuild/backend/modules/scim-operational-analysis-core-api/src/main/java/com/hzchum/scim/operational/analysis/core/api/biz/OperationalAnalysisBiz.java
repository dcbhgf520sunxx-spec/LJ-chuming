package com.hzchum.scim.operational.analysis.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.AuxiliaryMaterialsAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.AverageDifferenceRatioDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InspectionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InventoryDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InventoryStockDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MonthSummaryRangeDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderDeliverDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionLoadDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionTypeAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProjectCostDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProjectProductionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.QhseDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.YearSummaryDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface OperationalAnalysisBiz {
   OrderAnalysisDTO orderAnalysis(LocalDateTime dateTime);

   List<ProductionAnalysisDTO> productionAnalysis(LocalDateTime dateTime, Long factoryId, Integer yearSize, Integer productType);

   List<ProjectProductionDTO> differenceAnalysis(LocalDateTime dateTime);

   List<AverageDifferenceRatioDTO> averageDifferenceRatioAnalysis(Integer range);

   AuxiliaryMaterialsAnalysisDTO auxiliaryMaterialsAnalysis(LocalDateTime dateTime, Long factoryId);

   List<QhseDTO> qhseAnalysis(LocalDateTime dateTime);

   List<ProductionTypeAnalysisDTO> productionTypeAnalysis(LocalDateTime dateTime, Integer productType);

   List<MonthSummaryRangeDTO> purchaseTrendAnalysis(
      LocalDateTime dateTime, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId, Integer range
   );

   List<YearSummaryDTO> purchaseRatioAnalysis(LocalDateTime dateTime, Integer basicClass);

   List<InventoryDTO> inventorySummaryAnalysis(LocalDateTime dateTime, Integer tax, Integer type);

   List<InventoryDTO> incomeAnalysis(LocalDateTime dateTime, Long branchCompanyId);

   PageVO<ProjectAbleCollectionDTO> collectionAnalysis(Integer type, Integer pageNumber, Integer pageSize);

   List<ProjectCostDTO> costAnalysis(Integer settlementStatus, Integer status);

   List<InventoryStockDTO> inventoryStockAnalysis(LocalDateTime dateTime, Integer tax, Integer type);

   List<InventoryStockDTO> inventoryStockSteelAnalysis(LocalDateTime dateTime, Integer tax);

   ProductionLoadDTO loadAnalysis(LocalDateTime dateTime, Long factoryId);

   OrderDeliverDTO deliverAnalysis(LocalDateTime dateTime);

   InspectionDTO inspectionAnalysis(LocalDateTime dateTime);
}
