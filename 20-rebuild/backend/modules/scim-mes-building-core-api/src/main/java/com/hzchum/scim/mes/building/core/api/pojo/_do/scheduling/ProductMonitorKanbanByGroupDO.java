package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMonitorKanbanByGroupDO", description = "")
public class ProductMonitorKanbanByGroupDO {
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "taskTypeEnum", notes = "产品类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "重量(净重)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "重量(毛重)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;

   public static ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder builder() {
      return new ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder();
   }

   public ProductMonitorKanbanByGroupDO() {
   }

   public ProductMonitorKanbanByGroupDO(
      final ProductionLineDetailDO productionLine,
      final NameInfo groups,
      final Integer taskTypeEnum,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight
   ) {
      this.productionLine = productionLine;
      this.groups = groups;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   @JsonProperty("productionLine")
   public ProductMonitorKanbanByGroupDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public ProductMonitorKanbanByGroupDO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProductMonitorKanbanByGroupDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public ProductMonitorKanbanByGroupDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProductMonitorKanbanByGroupDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProductMonitorKanbanByGroupDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProductMonitorKanbanByGroupDO(productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMonitorKanbanByGroupDO)) {
         return false;
      }

      ProductMonitorKanbanByGroupDO other = (ProductMonitorKanbanByGroupDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$productionLine = this.getProductionLine();
            Object other$productionLine = other.getProductionLine();
            if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
               Object this$groups = this.getGroups();
               Object other$groups = other.getGroups();
               if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                     Object this$totalGrossWeight = this.getTotalGrossWeight();
                     Object other$totalGrossWeight = other.getTotalGrossWeight();
                     return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
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
      return other instanceof ProductMonitorKanbanByGroupDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   public static class ProductMonitorKanbanByGroupDOBuilder {
      private ProductionLineDetailDO productionLine;
      private NameInfo groups;
      private Integer taskTypeEnum;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      ProductMonitorKanbanByGroupDOBuilder() {
      }

      @JsonProperty("productionLine")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProductMonitorKanbanByGroupDO build() {
         return new ProductMonitorKanbanByGroupDO(
            this.productionLine, this.groups, this.taskTypeEnum, this.quantity, this.totalNetWeight, this.totalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "ProductMonitorKanbanByGroupDO.ProductMonitorKanbanByGroupDOBuilder(productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
