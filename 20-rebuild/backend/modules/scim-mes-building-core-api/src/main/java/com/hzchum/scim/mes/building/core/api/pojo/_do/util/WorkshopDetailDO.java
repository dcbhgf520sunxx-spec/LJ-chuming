package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "WorkshopDO", description = "工厂信息")
public class WorkshopDetailDO {
   @ApiModelProperty(name = "id", notes = "车间id", value = "车间id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productionLineList", value = "生产线")
   @JsonProperty("productionLineList")
   @JSONField(name = "productionLineList")
   @JsonInclude(Include.NON_NULL)
   private List<ProductionLineDetailDO> productionLineList;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "总净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "type", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", notes = "车间类型  1:建钢车间 2:桥梁车间 4:围护车间")
   private Integer type;

   public static WorkshopDetailDO.WorkshopDetailDOBuilder builder() {
      return new WorkshopDetailDO.WorkshopDetailDOBuilder();
   }

   public WorkshopDetailDO() {
   }

   public WorkshopDetailDO(
      final Long id,
      final String name,
      final List<ProductionLineDetailDO> productionLineList,
      final Integer quantity,
      final BigDecimal netWeight,
      final Integer type
   ) {
      this.id = id;
      this.name = name;
      this.productionLineList = productionLineList;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<ProductionLineDetailDO> getProductionLineList() {
      return this.productionLineList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public WorkshopDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public WorkshopDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productionLineList")
   public WorkshopDetailDO setProductionLineList(final List<ProductionLineDetailDO> productionLineList) {
      this.productionLineList = productionLineList;
      return this;
   }

   @JsonProperty("quantity")
   public WorkshopDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public WorkshopDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public WorkshopDetailDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopDetailDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productionLineList="
         + this.getProductionLineList()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopDetailDO)) {
         return false;
      }

      WorkshopDetailDO other = (WorkshopDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$productionLineList = this.getProductionLineList();
                  Object other$productionLineList = other.getProductionLineList();
                  if (this$productionLineList == null ? other$productionLineList == null : this$productionLineList.equals(other$productionLineList)) {
                     Object this$netWeight = this.getNetWeight();
                     Object other$netWeight = other.getNetWeight();
                     return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof WorkshopDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $productionLineList = this.getProductionLineList();
      result = result * 59 + ($productionLineList == null ? 43 : $productionLineList.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class WorkshopDetailDOBuilder {
      private Long id;
      private String name;
      private List<ProductionLineDetailDO> productionLineList;
      private Integer quantity;
      private BigDecimal netWeight;
      private Integer type;

      WorkshopDetailDOBuilder() {
      }

      @JsonProperty("id")
      public WorkshopDetailDO.WorkshopDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public WorkshopDetailDO.WorkshopDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productionLineList")
      public WorkshopDetailDO.WorkshopDetailDOBuilder productionLineList(final List<ProductionLineDetailDO> productionLineList) {
         this.productionLineList = productionLineList;
         return this;
      }

      @JsonProperty("quantity")
      public WorkshopDetailDO.WorkshopDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public WorkshopDetailDO.WorkshopDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public WorkshopDetailDO.WorkshopDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public WorkshopDetailDO build() {
         return new WorkshopDetailDO(this.id, this.name, this.productionLineList, this.quantity, this.netWeight, this.type);
      }

      @Override
      public String toString() {
         return "WorkshopDetailDO.WorkshopDetailDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productionLineList="
            + this.productionLineList
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", type="
            + this.type
            + ")";
      }
   }
}
