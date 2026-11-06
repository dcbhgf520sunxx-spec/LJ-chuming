package com.hzchum.scim.mes.building.core.api.biz.productionAnalysis;

import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProjectMaterialRequisitionAnalysisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProjectPartsAndRequisitionDTO;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectMaterialRequisitionAnalysisBiz {
   BigDecimal productionCompanySummary(ProjectMaterialRequisitionAnalysisDOParam param);

   List<ProjectPartsAndRequisitionDTO> getProjectPartsAndRequisitionList(ProjectMaterialRequisitionAnalysisDOParam param);
}
