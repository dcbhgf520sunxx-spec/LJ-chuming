package com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements;

import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.ArtifactProductionStatementsDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ArtifactProductionStatementsDTO", description = "构件生产报表")
public class ArtifactProductionStatementsDTO extends ArtifactProductionStatementsDO {
   @Override
   public String toString() {
      return "ArtifactProductionStatementsDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactProductionStatementsDTO)) {
         return false;
      }

      ArtifactProductionStatementsDTO other = (ArtifactProductionStatementsDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactProductionStatementsDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
