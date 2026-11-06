package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.get;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling.MesEnclosureArtifactSchedulingDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureArtifactSchedulingVORequest", description = "构件排产请求类")
public class MesEnclosureArtifactSchedulingVORequest extends MesEnclosureArtifactSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactSchedulingVORequest)) {
         return false;
      }

      MesEnclosureArtifactSchedulingVORequest other = (MesEnclosureArtifactSchedulingVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactSchedulingVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
