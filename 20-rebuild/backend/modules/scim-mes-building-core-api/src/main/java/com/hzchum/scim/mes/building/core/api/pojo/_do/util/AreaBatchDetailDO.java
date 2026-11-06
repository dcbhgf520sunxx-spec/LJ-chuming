package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "AreaBatchDetailDO", description = "批次基础信息")
public class AreaBatchDetailDO {
   @ApiModelProperty(name = "id", notes = "区域id", value = "批次id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "批次名", value = "批次id")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", notes = "区域类型", value = "区域类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
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
   @ApiModelProperty(name = "workshopList", value = "车间")
   @JsonProperty("workshopList")
   @JSONField(name = "workshopList")
   @JsonInclude(Include.NON_NULL)
   private List<WorkshopDetailDO> workshopList;
   @ApiModelProperty(name = "productionLineList", value = "生产线")
   @JsonProperty("productionLineList")
   @JSONField(name = "productionLineList")
   @JsonInclude(Include.NON_NULL)
   private List<ProductionLineDetailDO> productionLineList;
   @ApiModelProperty(name = "groupsList", value = "生产组")
   @JsonProperty("groupsList")
   @JSONField(name = "groupsList")
   @JsonInclude(Include.NON_NULL)
   private List<GroupsCurrencyDO> groupsList;

   public static AreaBatchDetailDO.AreaBatchDetailDOBuilder builder() {
      return new AreaBatchDetailDO.AreaBatchDetailDOBuilder();
   }

   public AreaBatchDetailDO() {
   }

   public AreaBatchDetailDO(
      final Long id,
      final String name,
      final Integer productType,
      final Integer quantity,
      final BigDecimal netWeight,
      final List<WorkshopDetailDO> workshopList,
      final List<ProductionLineDetailDO> productionLineList,
      final List<GroupsCurrencyDO> groupsList
   ) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.workshopList = workshopList;
      this.productionLineList = productionLineList;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public List<WorkshopDetailDO> getWorkshopList() {
      return this.workshopList;
   }

   public List<ProductionLineDetailDO> getProductionLineList() {
      return this.productionLineList;
   }

   public List<GroupsCurrencyDO> getGroupsList() {
      return this.groupsList;
   }

   @JsonProperty("id")
   public AreaBatchDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public AreaBatchDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public AreaBatchDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public AreaBatchDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public AreaBatchDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("workshopList")
   public AreaBatchDetailDO setWorkshopList(final List<WorkshopDetailDO> workshopList) {
      this.workshopList = workshopList;
      return this;
   }

   @JsonProperty("productionLineList")
   public AreaBatchDetailDO setProductionLineList(final List<ProductionLineDetailDO> productionLineList) {
      this.productionLineList = productionLineList;
      return this;
   }

   @JsonProperty("groupsList")
   public AreaBatchDetailDO setGroupsList(final List<GroupsCurrencyDO> groupsList) {
      this.groupsList = groupsList;
      return this;
   }

   @Override
   public String toString() {
      return "AreaBatchDetailDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", workshopList="
         + this.getWorkshopList()
         + ", productionLineList="
         + this.getProductionLineList()
         + ", groupsList="
         + this.getGroupsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaBatchDetailDO)) {
         return false;
      }

      AreaBatchDetailDO other = (AreaBatchDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$workshopList = this.getWorkshopList();
                     Object other$workshopList = other.getWorkshopList();
                     if (this$workshopList == null ? other$workshopList == null : this$workshopList.equals(other$workshopList)) {
                        Object this$productionLineList = this.getProductionLineList();
                        Object other$productionLineList = other.getProductionLineList();
                        if (this$productionLineList == null ? other$productionLineList == null : this$productionLineList.equals(other$productionLineList)) {
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
      return other instanceof AreaBatchDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $workshopList = this.getWorkshopList();
      result = result * 59 + ($workshopList == null ? 43 : $workshopList.hashCode());
      Object $productionLineList = this.getProductionLineList();
      result = result * 59 + ($productionLineList == null ? 43 : $productionLineList.hashCode());
      Object $groupsList = this.getGroupsList();
      return result * 59 + ($groupsList == null ? 43 : $groupsList.hashCode());
   }

   public static class AreaBatchDetailDOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer quantity;
      private BigDecimal netWeight;
      private List<WorkshopDetailDO> workshopList;
      private List<ProductionLineDetailDO> productionLineList;
      private List<GroupsCurrencyDO> groupsList;

      AreaBatchDetailDOBuilder() {
      }

      @JsonProperty("id")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("workshopList")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder workshopList(final List<WorkshopDetailDO> workshopList) {
         this.workshopList = workshopList;
         return this;
      }

      @JsonProperty("productionLineList")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder productionLineList(final List<ProductionLineDetailDO> productionLineList) {
         this.productionLineList = productionLineList;
         return this;
      }

      @JsonProperty("groupsList")
      public AreaBatchDetailDO.AreaBatchDetailDOBuilder groupsList(final List<GroupsCurrencyDO> groupsList) {
         this.groupsList = groupsList;
         return this;
      }

      public AreaBatchDetailDO build() {
         return new AreaBatchDetailDO(
            this.id, this.name, this.productType, this.quantity, this.netWeight, this.workshopList, this.productionLineList, this.groupsList
         );
      }

      @Override
      public String toString() {
         return "AreaBatchDetailDO.AreaBatchDetailDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", workshopList="
            + this.workshopList
            + ", productionLineList="
            + this.productionLineList
            + ", groupsList="
            + this.groupsList
            + ")";
      }
   }
}
