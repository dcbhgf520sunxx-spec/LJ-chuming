package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineUpdateVORequest", description = "")
public class ProductionLineUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @NotNull(message = "生产线类型不能为空")
   @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "linkIdList", value = "可生产列表", notes = "可生产列表")
   @JsonProperty("linkIdList")
   @JSONField(name = "linkIdList")
   private List<Long> linkIdList;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;

   public static ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder builder() {
      return new ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<Long> getLinkIdList() {
      return this.linkIdList;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   @JsonProperty("id")
   public ProductionLineUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductionLineUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public ProductionLineUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public ProductionLineUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("productType")
   public ProductionLineUpdateVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public ProductionLineUpdateVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("linkIdList")
   public ProductionLineUpdateVORequest setLinkIdList(final List<Long> linkIdList) {
      this.linkIdList = linkIdList;
      return this;
   }

   @JsonProperty("targetProduction")
   public ProductionLineUpdateVORequest setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineUpdateVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", linkIdList="
         + this.getLinkIdList()
         + ", targetProduction="
         + this.getTargetProduction()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineUpdateVORequest)) {
         return false;
      }

      ProductionLineUpdateVORequest other = (ProductionLineUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
               Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
               if (this$productionLineTypeEnum == null
                  ? other$productionLineTypeEnum == null
                  : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$linkIdList = this.getLinkIdList();
                        Object other$linkIdList = other.getLinkIdList();
                        if (this$linkIdList == null ? other$linkIdList == null : this$linkIdList.equals(other$linkIdList)) {
                           Object this$targetProduction = this.getTargetProduction();
                           Object other$targetProduction = other.getTargetProduction();
                           return this$targetProduction == null ? other$targetProduction == null : this$targetProduction.equals(other$targetProduction);
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
      return other instanceof ProductionLineUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $linkIdList = this.getLinkIdList();
      result = result * 59 + ($linkIdList == null ? 43 : $linkIdList.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public ProductionLineUpdateVORequest(
      final Long id,
      final String name,
      final Integer sort,
      final String remark,
      final Integer productType,
      final Integer productionLineTypeEnum,
      final List<Long> linkIdList,
      final BigDecimal targetProduction
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.remark = remark;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.linkIdList = linkIdList;
      this.targetProduction = targetProduction;
   }

   public ProductionLineUpdateVORequest() {
   }

   public static class ProductionLineUpdateVORequestBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private String remark;
      private Integer productType;
      private Integer productionLineTypeEnum;
      private List<Long> linkIdList;
      private BigDecimal targetProduction;

      ProductionLineUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("productType")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("linkIdList")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder linkIdList(final List<Long> linkIdList) {
         this.linkIdList = linkIdList;
         return this;
      }

      @JsonProperty("targetProduction")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public ProductionLineUpdateVORequest build() {
         return new ProductionLineUpdateVORequest(
            this.id, this.name, this.sort, this.remark, this.productType, this.productionLineTypeEnum, this.linkIdList, this.targetProduction
         );
      }

      @Override
      public String toString() {
         return "ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", linkIdList="
            + this.linkIdList
            + ", targetProduction="
            + this.targetProduction
            + ")";
      }
   }
}
