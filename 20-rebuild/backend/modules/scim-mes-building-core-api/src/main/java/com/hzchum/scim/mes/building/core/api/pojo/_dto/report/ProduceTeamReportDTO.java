package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceTeamReportDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProduceTeamReportDTO", description = "班组生产上报记录表 ")
public class ProduceTeamReportDTO extends ProduceTeamReportDO {
   @Override
   public String toString() {
      return "ProduceTeamReportDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceTeamReportDTO)) {
         return false;
      }

      ProduceTeamReportDTO other = (ProduceTeamReportDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProduceTeamReportDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
