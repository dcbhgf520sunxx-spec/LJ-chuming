package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package.MesEnclosurePackageAddDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosurePackage对象", description = "包 ")
public class MesEnclosurePackageAddVORequest extends MesEnclosurePackageAddDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageAddVORequest)) {
         return false;
      }

      MesEnclosurePackageAddVORequest other = (MesEnclosurePackageAddVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageAddVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageAddVORequest()";
   }
}
