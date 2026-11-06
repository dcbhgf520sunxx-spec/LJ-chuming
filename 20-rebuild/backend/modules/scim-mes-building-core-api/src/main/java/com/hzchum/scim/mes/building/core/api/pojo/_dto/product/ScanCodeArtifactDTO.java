package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;

public class ScanCodeArtifactDTO extends ArtifactBaseInfo {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScanCodeArtifactDTO)) {
         return false;
      }

      ScanCodeArtifactDTO other = (ScanCodeArtifactDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ScanCodeArtifactDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ScanCodeArtifactDTO()";
   }
}
