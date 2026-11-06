package com.hzchum.scim.rest.pojo.vo.project;

import com.hzchum.scim.project.core.api.pojo.dtoParam.QhseDTOParam;

public class QhseVOParam extends QhseDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseVOParam)) {
         return false;
      }

      QhseVOParam other = (QhseVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QhseVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "QhseVOParam()";
   }
}
