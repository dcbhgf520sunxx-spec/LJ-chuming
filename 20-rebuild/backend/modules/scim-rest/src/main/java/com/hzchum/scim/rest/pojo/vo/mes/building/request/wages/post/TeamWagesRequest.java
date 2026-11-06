package com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.post;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages.post.TeamWagesDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "TeamWagesRequest", description = "")
public class TeamWagesRequest extends TeamWagesDTOParam {
   @Override
   public String toString() {
      return "TeamWagesRequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamWagesRequest)) {
         return false;
      }

      TeamWagesRequest other = (TeamWagesRequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TeamWagesRequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
