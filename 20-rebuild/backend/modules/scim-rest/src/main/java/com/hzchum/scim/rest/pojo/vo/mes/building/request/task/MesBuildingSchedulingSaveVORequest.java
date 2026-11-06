package com.hzchum.scim.rest.pojo.vo.mes.building.request.task;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import org.springframework.validation.annotation.Validated;

@Validated
public class MesBuildingSchedulingSaveVORequest extends MesBuildingSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesBuildingSchedulingSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSchedulingSaveVORequest)) {
         return false;
      }

      MesBuildingSchedulingSaveVORequest other = (MesBuildingSchedulingSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSchedulingSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
