package com.hzchum.scim.mes.building.core.api.pojo._do.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProcessDTO对象", description = "")
public class MesBuildingProcessDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "type", notes = "工序类型 [0 一次工序,2 二次工序]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Boolean type;
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

   public static MesBuildingProcessDO.MesBuildingProcessDOBuilder builder() {
      return new MesBuildingProcessDO.MesBuildingProcessDOBuilder();
   }

   public MesBuildingProcessDO() {
   }

   public MesBuildingProcessDO(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Boolean type,
      final Integer productType,
      final Long userId,
      final Integer sort
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.type = type;
      this.productType = productType;
      this.userId = userId;
      this.sort = sort;
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

   public Boolean getType() {
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

   @JsonProperty("id")
   public MesBuildingProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProcessDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProcessDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingProcessDO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProcessDO setType(final Boolean type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProcessDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcessDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProcessDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessDO(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessDO)) {
         return false;
      }

      MesBuildingProcessDO other = (MesBuildingProcessDO)o;
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProcessDO;
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
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingProcessDOBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Boolean type;
      private Integer productType;
      private Long userId;
      private Integer sort;

      MesBuildingProcessDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder type(final Boolean type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProcessDO.MesBuildingProcessDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingProcessDO build() {
         return new MesBuildingProcessDO(this.id, this.name, this.reportType, this.inspectType, this.type, this.productType, this.userId, this.sort);
      }

      @Override
      public String toString() {
         return "MesBuildingProcessDO.MesBuildingProcessDOBuilder(id="
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
            + ")";
      }
   }
}
