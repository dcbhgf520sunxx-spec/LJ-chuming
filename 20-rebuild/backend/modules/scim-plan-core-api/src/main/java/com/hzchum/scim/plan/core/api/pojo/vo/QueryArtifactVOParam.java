package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.QueryListDTOParam;

public class QueryArtifactVOParam extends QueryListDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryArtifactVOParam)) {
         return false;
      }

      QueryArtifactVOParam other = (QueryArtifactVOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QueryArtifactVOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "QueryArtifactVOParam()";
   }
}
