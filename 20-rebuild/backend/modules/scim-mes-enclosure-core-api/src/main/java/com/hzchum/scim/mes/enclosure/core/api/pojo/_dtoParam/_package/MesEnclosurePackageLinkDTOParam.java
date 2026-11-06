package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam._package.MesEnclosurePackageLinkDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosurePackageLink对象", description = "包的产品关联表 ")
public class MesEnclosurePackageLinkDTOParam extends MesEnclosurePackageLinkDOParam {
   @Override
   public String toString() {
      return "MesEnclosurePackageLinkDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageLinkDTOParam)) {
         return false;
      }

      MesEnclosurePackageLinkDTOParam other = (MesEnclosurePackageLinkDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageLinkDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
