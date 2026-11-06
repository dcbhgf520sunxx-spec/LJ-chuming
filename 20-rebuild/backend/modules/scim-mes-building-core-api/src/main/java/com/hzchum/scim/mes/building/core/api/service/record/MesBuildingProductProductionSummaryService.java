package com.hzchum.scim.mes.building.core.api.service.record;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingProductProductionSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProductAnalysisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryTaskDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductDetailsAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductGroupAnalysisDTO;
import java.util.List;
import java.util.Map;

public interface MesBuildingProductProductionSummaryService extends IService<MesBuildingProductProductionSummary> {
   boolean updateRecord(ProductProductionSummaryDTOParam param);

   // Reversals belong to the original accepted report month, including month boundaries.
   boolean updateRecordForMonth(ProductProductionSummaryDTOParam param, String month);

   boolean updateTaskQuantity(ProductProductionSummaryTaskDTOParam param);

   void statLastMonthProductionSummary();

   ProductAnalysisDTO productionSummary(ProductAnalysisDOParam param);

   ProductGroupAnalysisDTO productionGroup(ProductAnalysisDOParam param);

   PrintVO<List<Map<String, Object>>> productionGroupPrint(ProductAnalysisDOParam param);

   ProductDetailsAnalysisDTO productCompleteDetails(ProductAnalysisDOParam dtoParam);

   PrintVO<List<Map<String, Object>>> productCompleteDetailsPrint(ProductAnalysisDOParam param);

   ProductDetailsAnalysisDTO productInProductionDetails(ProductAnalysisDOParam dtoParam);

   PrintVO<List<Map<String, Object>>> productInProductionDetailsPrint(ProductAnalysisDOParam param);

   ProductDetailsAnalysisDTO productUnProductionDetails(ProductAnalysisDOParam dtoParam);

   PrintVO<List<Map<String, Object>>> productUnProductionDetailsPrint(ProductAnalysisDOParam param);
}
