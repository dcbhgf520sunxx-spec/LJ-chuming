package com.hzchum.scim.rest.pojo.vo.project;

import com.hzchum.scim.project.core.api.pojo.dtoParam.DataConstructionConfigDTOParam;

public class DataConstructionConfigVOParam extends DataConstructionConfigDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DataConstructionConfigVOParam)) {
         return false;
      }

      DataConstructionConfigVOParam other = (DataConstructionConfigVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof DataConstructionConfigVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "DataConstructionConfigVOParam()";
   }
}
