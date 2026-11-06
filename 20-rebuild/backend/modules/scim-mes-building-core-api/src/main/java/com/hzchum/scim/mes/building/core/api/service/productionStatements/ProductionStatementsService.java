package com.hzchum.scim.mes.building.core.api.service.productionStatements;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.EnclosureProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.EnclosureSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionStatements.ProductionStatementsDTOParam;
import java.util.List;

public interface ProductionStatementsService {
   ArtifactSummaryDTO summaryByCondition(ProductionStatementsDTOParam dtoParam);

   List<ArtifactProductionStatementsDTO> artifactlistByCondition(ProductionStatementsDTOParam dtoParam);

   PageVO<ArtifactProductionStatementsDTO> artifactPage(ProductionStatementsDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   EnclosureSummaryDTO enclosureSummary(ProductionStatementsDTOParam dtoParam);

   List<EnclosureProductionStatementsDTO> enclosurelistByCondition(ProductionStatementsDTOParam dtoParam);

   PageVO<EnclosureProductionStatementsDTO> enclosurePage(ProductionStatementsDTOParam dtoParam, Integer pageNumber, Integer pageSize);
}
