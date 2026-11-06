package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureSchedulingDTOParam;
import org.springframework.validation.annotation.Validated;

@Validated
public class MesEnclosureSchedulingSaveVORequest extends MesEnclosureSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureSchedulingSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSchedulingSaveVORequest)) {
         return false;
      }

      MesEnclosureSchedulingSaveVORequest other = (MesEnclosureSchedulingSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureSchedulingSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
