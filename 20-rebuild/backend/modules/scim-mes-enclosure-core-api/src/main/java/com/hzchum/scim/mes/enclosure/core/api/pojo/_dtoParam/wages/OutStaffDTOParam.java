package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.OutStaffDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "OutStaffRequest", description = "")
public class OutStaffDTOParam extends OutStaffDOParam {
   @Override
   public String toString() {
      return "OutStaffDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffDTOParam)) {
         return false;
      }

      OutStaffDTOParam other = (OutStaffDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof OutStaffDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
