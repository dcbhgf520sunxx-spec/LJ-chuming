package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.post;

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
   @ApiModelProperty(name = "type", notes = "工序类型 [0 一次工序,1 二次工序]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "工序类型不能为空")
   private Boolean type;
   @ApiModelProperty(name = "productType", notes = "产品类型 [0 零件,1  构件,2  围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;

   public static ProcessSaveVORequest.ProcessSaveVORequestBuilder builder() {
      return new ProcessSaveVORequest.ProcessSaveVORequestBuilder();
   }

   public ProcessSaveVORequest() {
   }

   public ProcessSaveVORequest(
      final String id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Boolean type,
      final Integer productType,
      final Integer sort,
      final Integer wageQuotaType,
      final Integer productionLineTypeEnum
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.type = type;
      this.productType = productType;
      this.sort = sort;
      this.wageQuotaType = wageQuotaType;
      this.productionLineTypeEnum = productionLineTypeEnum;
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

   public Boolean getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
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

   @JsonProperty("type")
   public ProcessSaveVORequest setType(final Boolean type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public ProcessSaveVORequest setProductType(final Integer productType) {
      this.productType = productType;
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

   @JsonProperty("productionLineTypeEnum")
   public ProcessSaveVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
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
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
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
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                        Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                        if (this$productionLineTypeEnum == null
                           ? other$productionLineTypeEnum == null
                           : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
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
      private Boolean type;
      private Integer productType;
      private Integer sort;
      private Integer wageQuotaType;
      private Integer productionLineTypeEnum;

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

      @JsonProperty("type")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder type(final Boolean type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
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

      @JsonProperty("productionLineTypeEnum")
      public ProcessSaveVORequest.ProcessSaveVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public ProcessSaveVORequest build() {
         return new ProcessSaveVORequest(
            this.id, this.name, this.reportType, this.inspectType, this.type, this.productType, this.sort, this.wageQuotaType, this.productionLineTypeEnum
         );
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
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
