package com.hzchum.scim.rest.pojo.vo.project;

import com.hzchum.scim.project.core.api.pojo.dtoParam.QhseRectifyDTOParam;

public class QhseRectifyVOParam extends QhseRectifyDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseRectifyVOParam)) {
         return false;
      }

      QhseRectifyVOParam other = (QhseRectifyVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QhseRectifyVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "QhseRectifyVOParam()";
   }
}
