package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.wages.put;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.put.ChangeProductWageDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ChangeProductWageRequest", description = "")
public class ChangeProductWageRequest extends ChangeProductWageDTOParam {
   @Override
   public String toString() {
      return "ChangeProductWageRequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeProductWageRequest)) {
         return false;
      }

      ChangeProductWageRequest other = (ChangeProductWageRequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ChangeProductWageRequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
