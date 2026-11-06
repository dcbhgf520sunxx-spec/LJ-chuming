package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import io.swagger.annotations.ApiModel;

@ApiModel("报工未审批详情Query")
public class MesReportWorkUnapprovedDetailQuery extends MesReportWorkUnapprovedDTO {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkUnapprovedDetailQuery)) {
         return false;
      }

      MesReportWorkUnapprovedDetailQuery other = (MesReportWorkUnapprovedDetailQuery)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesReportWorkUnapprovedDetailQuery;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesReportWorkUnapprovedDetailQuery()";
   }
}
