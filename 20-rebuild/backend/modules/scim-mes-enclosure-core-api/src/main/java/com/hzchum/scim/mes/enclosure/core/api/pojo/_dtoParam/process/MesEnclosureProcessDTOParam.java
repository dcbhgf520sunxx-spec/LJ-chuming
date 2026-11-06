package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureProcessDTO对象", description = "")
public class MesEnclosureProcessDTOParam {
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
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder builder() {
      return new MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder();
   }

   public MesEnclosureProcessDTOParam() {
   }

   public MesEnclosureProcessDTOParam(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Long userId,
      final Integer sort,
      final Boolean organizationType
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.userId = userId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public MesEnclosureProcessDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProcessDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesEnclosureProcessDTOParam setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesEnclosureProcessDTOParam setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProcessDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureProcessDTOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("organizationType")
   public MesEnclosureProcessDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProcessDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", userId="
         + this.getUserId()
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

      if (!(o instanceof MesEnclosureProcessDTOParam)) {
         return false;
      }

      MesEnclosureProcessDTOParam other = (MesEnclosureProcessDTOParam)o;
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
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProcessDTOParam;
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
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesEnclosureProcessDTOParamBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Long userId;
      private Integer sort;
      private Boolean organizationType;

      MesEnclosureProcessDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("organizationType")
      public MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public MesEnclosureProcessDTOParam build() {
         return new MesEnclosureProcessDTOParam(this.id, this.name, this.reportType, this.inspectType, this.userId, this.sort, this.organizationType);
      }

      @Override
      public String toString() {
         return "MesEnclosureProcessDTOParam.MesEnclosureProcessDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
