package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.product;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.product.MesEnclosureArtifactDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureArtifactDTOParam对象", description = "构件  ")
public class MesEnclosureArtifactVORequest extends MesEnclosureArtifactDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureArtifactVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactVORequest)) {
         return false;
      }

      MesEnclosureArtifactVORequest other = (MesEnclosureArtifactVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
