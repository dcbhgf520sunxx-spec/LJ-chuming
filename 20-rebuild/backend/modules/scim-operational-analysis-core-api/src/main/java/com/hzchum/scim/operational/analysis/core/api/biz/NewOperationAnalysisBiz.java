package com.hzchum.scim.operational.analysis.core.api.biz;

import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionCostAnalysisBaseDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionCostAnalysisDTOV2;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface NewOperationAnalysisBiz {
   List<ProductionCostAnalysisBaseDTO> getProductionCostAnalysisSummary(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<ProductionCostAnalysisDTOV2> getProductionCostAnalysisV2(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   void downloadProductionCostAnalysisV2(HttpServletResponse response, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getThreeYearsAvgInfo(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   HashMap<String, Object> getYearsSummary(LocalDate yearDate, Long branchCompanyId, Long workshopId);
}
