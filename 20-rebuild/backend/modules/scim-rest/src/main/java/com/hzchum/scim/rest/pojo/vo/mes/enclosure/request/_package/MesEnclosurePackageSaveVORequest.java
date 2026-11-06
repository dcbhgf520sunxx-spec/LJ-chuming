package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package.MesEnclosurePackageDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosurePackage对象", description = "包 ")
public class MesEnclosurePackageSaveVORequest extends MesEnclosurePackageDTOParam {
   @Override
   public String toString() {
      return "MesEnclosurePackageSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageSaveVORequest)) {
         return false;
      }

      MesEnclosurePackageSaveVORequest other = (MesEnclosurePackageSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
