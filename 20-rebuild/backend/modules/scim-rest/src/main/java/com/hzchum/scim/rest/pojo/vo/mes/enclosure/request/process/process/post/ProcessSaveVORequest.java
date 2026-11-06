package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProcessSaveVORequest", description = "")
public class ProcessSaveVORequest {
   @ApiModelProperty(name = "id", notes = "名称")
   @JsonProperty("id")
   @JSONField(name = "id")
   private String id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "reportType", notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @NotNull(message = "上报类型不能为空")
   private Integer reportType;
   @ApiModelProperty(name = "inspectType", notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   @NotNull(message = "质检类型不能为空")
   private Integer inspectType;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static ProcessSaveVORequest.ProcessSaveVORequestBuilder builder() {
      return new ProcessSaveVORequest.ProcessSaveVORequestBuilder();
   }

   public ProcessSaveVORequest() {
   }

   public ProcessSaveVORequest(
      final String id, final String name, final Integer reportType, final Integer inspectType, final Integer sort, final Integer wageQuotaType
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.sort = sort;
      this.wageQuotaType = wageQuotaType;
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public ProcessSaveVORequest setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProcessSaveVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public ProcessSaveVORequest setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public ProcessSaveVORequest setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("sort")
   public ProcessSaveVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ProcessSaveVORequest setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSaveVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", sort="
         + this.getSort()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSaveVORequest)) {
         return false;
      }

      ProcessSaveVORequest other = (ProcessSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportType = this.getReportType();
      Object other$reportType = other.getReportType();
      if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
         Object this$inspectType = this.getInspectType();
         Object other$inspectType = other.getInspectType();
         if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$id = this.getId();
                  Object other$id = other.getId();
                  if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     return this$name == null ? other$name == null : this$name.equals(other$name);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProcessSaveVORequestBuilder {
      private String id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Integer sort;
      private Integer wageQuotaType;

      ProcessSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("sort")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProcessSaveVORequest build() {
         return new ProcessSaveVORequest(this.id, this.name, this.reportType, this.inspectType, this.sort, this.wageQuotaType);
      }

      @Override
      public String toString() {
         return "ProcessSaveVORequest.ProcessSaveVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", sort="
            + this.sort
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
