package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package.MesEnclosurePackageLinkDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosurePackageLink对象", description = "包的产品关联表 ")
public class MesEnclosurePackageLinkSaveVORequest extends MesEnclosurePackageLinkDTOParam {
   @Override
   public String toString() {
      return "MesEnclosurePackageLinkSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageLinkSaveVORequest)) {
         return false;
      }

      MesEnclosurePackageLinkSaveVORequest other = (MesEnclosurePackageLinkSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageLinkSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
