package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.product;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.product.MesEnclosureEnclosureDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("MesEnclosureEnclosureVORequest")
public class MesEnclosureEnclosureVORequest extends MesEnclosureEnclosureDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureEnclosureVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureEnclosureVORequest)) {
         return false;
      }

      MesEnclosureEnclosureVORequest other = (MesEnclosureEnclosureVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureEnclosureVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
