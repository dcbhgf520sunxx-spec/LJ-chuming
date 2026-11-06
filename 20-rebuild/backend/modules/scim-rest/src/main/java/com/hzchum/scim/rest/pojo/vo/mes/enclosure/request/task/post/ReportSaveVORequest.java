package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReportSaveVORequest", description = "")
public class ReportSaveVORequest {
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;

   public ReportSaveVORequest(final Integer reportQuantity, final Long id) {
      this.reportQuantity = reportQuantity;
      this.id = id;
   }

   public ReportSaveVORequest() {
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getId() {
      return this.id;
   }

   @JsonProperty("reportQuantity")
   public ReportSaveVORequest setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("id")
   public ReportSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "ReportSaveVORequest(reportQuantity=" + this.getReportQuantity() + ", id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReportSaveVORequest)) {
         return false;
      } else {
         ReportSaveVORequest other = (ReportSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$reportQuantity = this.getReportQuantity();
            Object other$reportQuantity = other.getReportQuantity();
            if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               return this$id == null ? other$id == null : this$id.equals(other$id);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }
}
