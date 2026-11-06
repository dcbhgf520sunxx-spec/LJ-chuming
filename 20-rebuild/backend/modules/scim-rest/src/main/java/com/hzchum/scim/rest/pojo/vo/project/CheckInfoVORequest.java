package com.hzchum.scim.rest.pojo.vo.project;

import com.hzchum.scim.project.core.api.pojo.dtoParam.CheckInfoDTOParam;

public class CheckInfoVORequest extends CheckInfoDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CheckInfoVORequest)) {
         return false;
      }

      CheckInfoVORequest other = (CheckInfoVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CheckInfoVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CheckInfoVORequest()";
   }
}
