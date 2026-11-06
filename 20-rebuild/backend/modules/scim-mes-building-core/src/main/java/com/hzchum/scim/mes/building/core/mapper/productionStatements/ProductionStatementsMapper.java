package com.hzchum.scim.mes.building.core.mapper.productionStatements;

import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.ArtifactProductionStatementsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.EnclosureProductionStatementsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionStatements.ProductionStatementsDOParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductionStatementsMapper {
   List<ArtifactProductionStatementsDO> artifactlistByCondition(ProductionStatementsDOParam doParam);

   List<EnclosureProductionStatementsDO> enclosurelistByCondition(ProductionStatementsDOParam doParam);
}
