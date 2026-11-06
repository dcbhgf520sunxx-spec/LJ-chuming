package com.hzchum.scim.mes.building.core.mapper.record;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.ArtifactAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.ArtifactDetailsAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.ArtifactGroupAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.EnclosureAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.EnclosureDetailsAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.EnclosureGroupAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingProductProductionSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProductAnalysisDOParam;
import java.util.List;

public interface MesBuildingProductProductionSummaryMapper extends BaseMapper<MesBuildingProductProductionSummary> {
   ArtifactAnalysisDO productionArtifactSummary(ProductAnalysisDOParam dtoParam);

   EnclosureAnalysisDO productionEnclosureSummary(ProductAnalysisDOParam dtoParam);

   List<ArtifactGroupAnalysisDO> productionArtifactGroup(ProductAnalysisDOParam doParam);

   List<EnclosureGroupAnalysisDO> productionEnclosureGroup(ProductAnalysisDOParam doParam);

   List<ArtifactDetailsAnalysisDO> productionArtifactCompleteDetails(ProductAnalysisDOParam doParam);

   List<EnclosureDetailsAnalysisDO> productionEnclosureCompleteDetails(ProductAnalysisDOParam doParam);

   List<ArtifactDetailsAnalysisDO> productionArtifactInProductionDetails(ProductAnalysisDOParam doParam);

   List<EnclosureDetailsAnalysisDO> productionEnclosureInProductionDetails(ProductAnalysisDOParam doParam);

   List<ArtifactDetailsAnalysisDO> productionArtifactUnProductionDetails(ProductAnalysisDOParam doParam);

   List<EnclosureDetailsAnalysisDO> productionEnclosureUnProductionDetails(ProductAnalysisDOParam doParam);

   List<ArtifactDetailsAnalysisDO> productionArtifactDetails(ProductAnalysisDOParam doParam);

   List<EnclosureDetailsAnalysisDO> productionEnclosureDetails(ProductAnalysisDOParam doParam);

   List<ProcessSummaryDetailsDO> processSummary(ProductAnalysisDOParam doParam);

   Integer getCompleteQuantity(ProductAnalysisDOParam doParam);
}
