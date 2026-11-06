package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductionLineDO", description = "生产线信息")
public class ProductionLineDetailDO {
   @ApiModelProperty(name = "id", notes = "生产线id", value = "生产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名", value = "生产线名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "groupsList", value = "生产组")
   @JsonProperty("groupsList")
   @JSONField(name = "groupsList")
   @JsonInclude(Include.NON_NULL)
   private List<GroupsCurrencyDO> groupsList;

   public static ProductionLineDetailDO.ProductionLineDetailDOBuilder builder() {
      return new ProductionLineDetailDO.ProductionLineDetailDOBuilder();
   }

   public ProductionLineDetailDO() {
   }

   public ProductionLineDetailDO(
      final Long id, final String name, final Integer productType, final Integer productionLineTypeEnum, final List<GroupsCurrencyDO> groupsList
   ) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.groupsList = groupsList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<GroupsCurrencyDO> getGroupsList() {
      return this.groupsList;
   }

   @JsonProperty("id")
   public ProductionLineDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductionLineDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public ProductionLineDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public ProductionLineDetailDO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("groupsList")
   public ProductionLineDetailDO setGroupsList(final List<GroupsCurrencyDO> groupsList) {
      this.groupsList = groupsList;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineDetailDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", groupsList="
         + this.getGroupsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineDetailDO)) {
         return false;
      }

      ProductionLineDetailDO other = (ProductionLineDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
            Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
            if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$groupsList = this.getGroupsList();
                  Object other$groupsList = other.getGroupsList();
                  return this$groupsList == null ? other$groupsList == null : this$groupsList.equals(other$groupsList);
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
      return other instanceof ProductionLineDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $groupsList = this.getGroupsList();
      return result * 59 + ($groupsList == null ? 43 : $groupsList.hashCode());
   }

   public static class ProductionLineDetailDOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer productionLineTypeEnum;
      private List<GroupsCurrencyDO> groupsList;

      ProductionLineDetailDOBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("groupsList")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder groupsList(final List<GroupsCurrencyDO> groupsList) {
         this.groupsList = groupsList;
         return this;
      }

      public ProductionLineDetailDO build() {
         return new ProductionLineDetailDO(this.id, this.name, this.productType, this.productionLineTypeEnum, this.groupsList);
      }

      @Override
      public String toString() {
         return "ProductionLineDetailDO.ProductionLineDetailDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", groupsList="
            + this.groupsList
            + ")";
      }
   }
}
