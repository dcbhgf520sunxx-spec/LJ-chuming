package com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements;

import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.EnclosureProductionStatementsDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ArtifactProductionStatementsDTO", description = "构件生产报表")
public class EnclosureProductionStatementsDTO extends EnclosureProductionStatementsDO {
   @Override
   public String toString() {
      return "EnclosureProductionStatementsDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProductionStatementsDTO)) {
         return false;
      }

      EnclosureProductionStatementsDTO other = (EnclosureProductionStatementsDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureProductionStatementsDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
