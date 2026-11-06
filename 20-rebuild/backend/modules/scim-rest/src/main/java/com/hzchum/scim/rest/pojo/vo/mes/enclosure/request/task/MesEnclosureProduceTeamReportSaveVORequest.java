package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureProduceTeamReportDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureTaskProduceTeamReportSaveVORequest", description = "")
public class MesEnclosureProduceTeamReportSaveVORequest extends MesEnclosureProduceTeamReportDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureProduceTeamReportSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceTeamReportSaveVORequest)) {
         return false;
      }

      MesEnclosureProduceTeamReportSaveVORequest other = (MesEnclosureProduceTeamReportSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProduceTeamReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
