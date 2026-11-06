package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProcessDTO对象", description = "")
public class MesBuildingProcessDTOParam {
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
   @ApiModelProperty(name = "type", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "产品工序类型 [0 零件,1  构件,2  围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
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
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;

   public static MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder builder() {
      return new MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder();
   }

   public MesBuildingProcessDTOParam() {
   }

   public MesBuildingProcessDTOParam(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Integer type,
      final Integer productType,
      final Long userId,
      final Integer sort,
      final Boolean organizationType,
      final Integer productionLineTypeEnum
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.type = type;
      this.productType = productType;
      this.userId = userId;
      this.sort = sort;
      this.organizationType = organizationType;
      this.productionLineTypeEnum = productionLineTypeEnum;
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

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   @JsonProperty("id")
   public MesBuildingProcessDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProcessDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProcessDTOParam setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingProcessDTOParam setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProcessDTOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProcessDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcessDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProcessDTOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingProcessDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingProcessDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", organizationType="
         + this.getOrganizationType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessDTOParam)) {
         return false;
      }

      MesBuildingProcessDTOParam other = (MesBuildingProcessDTOParam)o;
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
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$organizationType = this.getOrganizationType();
                           Object other$organizationType = other.getOrganizationType();
                           if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                              Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                              Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                              if (this$productionLineTypeEnum == null
                                 ? other$productionLineTypeEnum == null
                                 : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
      return other instanceof MesBuildingProcessDTOParam;
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingProcessDTOParamBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Integer type;
      private Integer productType;
      private Long userId;
      private Integer sort;
      private Boolean organizationType;
      private Integer productionLineTypeEnum;

      MesBuildingProcessDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public MesBuildingProcessDTOParam build() {
         return new MesBuildingProcessDTOParam(
            this.id,
            this.name,
            this.reportType,
            this.inspectType,
            this.type,
            this.productType,
            this.userId,
            this.sort,
            this.organizationType,
            this.productionLineTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProcessDTOParam.MesBuildingProcessDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", organizationType="
            + this.organizationType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
