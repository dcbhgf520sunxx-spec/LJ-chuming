package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory.MesEnclosureGroupsDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureGroupsDOParam", description = "生产组 ")
public class MesEnclosureGroupsDTOParam extends MesEnclosureGroupsDOParam {
   @Override
   public String toString() {
      return "MesEnclosureGroupsDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureGroupsDTOParam)) {
         return false;
      }

      MesEnclosureGroupsDTOParam other = (MesEnclosureGroupsDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureGroupsDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
