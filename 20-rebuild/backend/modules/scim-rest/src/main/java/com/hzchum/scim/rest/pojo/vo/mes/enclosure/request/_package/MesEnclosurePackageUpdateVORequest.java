package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package.MesEnclosurePackageUpdateDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "包修改")
public class MesEnclosurePackageUpdateVORequest extends MesEnclosurePackageUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageUpdateVORequest)) {
         return false;
      }

      MesEnclosurePackageUpdateVORequest other = (MesEnclosurePackageUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageUpdateVORequest()";
   }
}
