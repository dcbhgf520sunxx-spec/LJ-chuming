package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package.MesEnclosurePackageFindDTOParam;

public class MesEnclosurePackageFindVORequest extends MesEnclosurePackageFindDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageFindVORequest)) {
         return false;
      }

      MesEnclosurePackageFindVORequest other = (MesEnclosurePackageFindVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageFindVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageFindVORequest()";
   }
}
