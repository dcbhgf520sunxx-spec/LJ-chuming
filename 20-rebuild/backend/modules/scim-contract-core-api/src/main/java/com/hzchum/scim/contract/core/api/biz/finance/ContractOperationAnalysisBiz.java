package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProductionCostAnalysisDTO;
import java.util.List;
import java.util.Map;

public interface ContractOperationAnalysisBiz {
   List<ProductionCostAnalysisDTO> productionCostAnalysis(Integer year);

   PrintVO<List<Map<String, Object>>> printProductionCostAnalysis(Integer year);

   List listProjectPaintingPrice(Integer year);

   PrintVO<List<Map<String, Object>>> listProjectPaintingPricePrint(Integer year);
}
