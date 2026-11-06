package com.hzchum.scim.rest.pojo.vo.project;

import com.hzchum.scim.project.core.api.pojo.dtoParam.DataConstructionLogDTOParam;

public class DataConstructionLogVOParam extends DataConstructionLogDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DataConstructionLogVOParam)) {
         return false;
      }

      DataConstructionLogVOParam other = (DataConstructionLogVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof DataConstructionLogVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "DataConstructionLogVOParam()";
   }
}
