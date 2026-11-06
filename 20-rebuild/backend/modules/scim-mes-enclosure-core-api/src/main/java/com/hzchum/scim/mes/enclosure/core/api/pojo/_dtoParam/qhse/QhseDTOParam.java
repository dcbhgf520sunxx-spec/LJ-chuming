package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.qhse;

import io.swagger.annotations.ApiModelProperty;

public class QhseDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "qhseReportId", value = "问题上报记录id", notes = "问题上报记录id")
   private Long qhseReportId;
   @ApiModelProperty(name = "inspectionReportId", value = "质检上报id", notes = "质检上报id")
   private Long inspectionReportId;

   public Long getId() {
      return this.id;
   }

   public Long getQhseReportId() {
      return this.qhseReportId;
   }

   public Long getInspectionReportId() {
      return this.inspectionReportId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQhseReportId(final Long qhseReportId) {
      this.qhseReportId = qhseReportId;
   }

   public void setInspectionReportId(final Long inspectionReportId) {
      this.inspectionReportId = inspectionReportId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseDTOParam)) {
         return false;
      }

      QhseDTOParam other = (QhseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseReportId = this.getQhseReportId();
         Object other$qhseReportId = other.getQhseReportId();
         if (this$qhseReportId == null ? other$qhseReportId == null : this$qhseReportId.equals(other$qhseReportId)) {
            Object this$inspectionReportId = this.getInspectionReportId();
            Object other$inspectionReportId = other.getInspectionReportId();
            return this$inspectionReportId == null ? other$inspectionReportId == null : this$inspectionReportId.equals(other$inspectionReportId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseReportId = this.getQhseReportId();
      result = result * 59 + ($qhseReportId == null ? 43 : $qhseReportId.hashCode());
      Object $inspectionReportId = this.getInspectionReportId();
      return result * 59 + ($inspectionReportId == null ? 43 : $inspectionReportId.hashCode());
   }

   @Override
   public String toString() {
      return "QhseDTOParam(id=" + this.getId() + ", qhseReportId=" + this.getQhseReportId() + ", inspectionReportId=" + this.getInspectionReportId() + ")";
   }
}
