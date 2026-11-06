package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProcessUpdateVORequest", description = "")
public class ProcessUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "reportType", notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "inspectType", notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;

   public static ProcessUpdateVORequest.ProcessUpdateVORequestBuilder builder() {
      return new ProcessUpdateVORequest.ProcessUpdateVORequestBuilder();
   }

   public ProcessUpdateVORequest() {
   }

   public ProcessUpdateVORequest(final Long id, final Integer reportType, final Integer inspectType) {
      this.id = id;
      this.reportType = reportType;
      this.inspectType = inspectType;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   @JsonProperty("id")
   public ProcessUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("reportType")
   public ProcessUpdateVORequest setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public ProcessUpdateVORequest setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessUpdateVORequest(id=" + this.getId() + ", reportType=" + this.getReportType() + ", inspectType=" + this.getInspectType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessUpdateVORequest)) {
         return false;
      }

      ProcessUpdateVORequest other = (ProcessUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reportType = this.getReportType();
         Object other$reportType = other.getReportType();
         if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
            Object this$inspectType = this.getInspectType();
            Object other$inspectType = other.getInspectType();
            return this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      return result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
   }

   public static class ProcessUpdateVORequestBuilder {
      private Long id;
      private Integer reportType;
      private Integer inspectType;

      ProcessUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProcessUpdateVORequest.ProcessUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("reportType")
      public ProcessUpdateVORequest.ProcessUpdateVORequestBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public ProcessUpdateVORequest.ProcessUpdateVORequestBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      public ProcessUpdateVORequest build() {
         return new ProcessUpdateVORequest(this.id, this.reportType, this.inspectType);
      }

      @Override
      public String toString() {
         return "ProcessUpdateVORequest.ProcessUpdateVORequestBuilder(id="
            + this.id
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ")";
      }
   }
}
