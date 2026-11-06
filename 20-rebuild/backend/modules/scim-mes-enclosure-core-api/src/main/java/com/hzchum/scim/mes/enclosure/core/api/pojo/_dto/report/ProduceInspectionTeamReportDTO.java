package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ProduceInspectionTeamReportDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProduceTeamReportDTO", description = "班组生产上报记录表 ")
public class ProduceInspectionTeamReportDTO extends ProduceInspectionTeamReportDO {
   @Override
   public String toString() {
      return "ProduceInspectionTeamReportDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceInspectionTeamReportDTO)) {
         return false;
      }

      ProduceInspectionTeamReportDTO other = (ProduceInspectionTeamReportDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProduceInspectionTeamReportDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
