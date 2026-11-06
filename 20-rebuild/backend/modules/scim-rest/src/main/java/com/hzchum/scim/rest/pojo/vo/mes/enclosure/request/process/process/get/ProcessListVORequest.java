package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessListVORequest", description = "")
public class ProcessListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "reportType", notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "inspectType", notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]")
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static ProcessListVORequest.ProcessListVORequestBuilder builder() {
      return new ProcessListVORequest.ProcessListVORequestBuilder();
   }

   public ProcessListVORequest() {
   }

   public ProcessListVORequest(
      final Long id, final String name, final Integer reportType, final Integer inspectType, final Integer sort, final Boolean organizationType
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.sort = sort;
      this.organizationType = organizationType;
   }

   public Long getId() {
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

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public ProcessListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProcessListVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public ProcessListVORequest setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public ProcessListVORequest setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("sort")
   public ProcessListVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("organizationType")
   public ProcessListVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessListVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", sort="
         + this.getSort()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessListVORequest)) {
         return false;
      }

      ProcessListVORequest other = (ProcessListVORequest)o;
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
            if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
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
      return other instanceof ProcessListVORequest;
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
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProcessListVORequestBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Integer sort;
      private Boolean organizationType;

      ProcessListVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProcessListVORequest.ProcessListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProcessListVORequest.ProcessListVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public ProcessListVORequest.ProcessListVORequestBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public ProcessListVORequest.ProcessListVORequestBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("sort")
      public ProcessListVORequest.ProcessListVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("organizationType")
      public ProcessListVORequest.ProcessListVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public ProcessListVORequest build() {
         return new ProcessListVORequest(this.id, this.name, this.reportType, this.inspectType, this.sort, this.organizationType);
      }

      @Override
      public String toString() {
         return "ProcessListVORequest.ProcessListVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", sort="
            + this.sort
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
