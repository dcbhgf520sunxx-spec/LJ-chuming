package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AreaSchedulingDetailDO", description = "区域排期信息 ")
public class AreaSchedulingTreeDO extends AreaDetailDO {
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "schedulingQuantity", notes = "清单数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalNetWeight", notes = "清单量")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "factory", value = "工厂信息")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", value = "车间信息")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线信息")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   @Override
   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   @JsonProperty("startDate")
   public AreaSchedulingTreeDO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public AreaSchedulingTreeDO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("quantity")
   public AreaSchedulingTreeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public AreaSchedulingTreeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public AreaSchedulingTreeDO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public AreaSchedulingTreeDO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("factory")
   public AreaSchedulingTreeDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AreaSchedulingTreeDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AreaSchedulingTreeDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @Override
   public String toString() {
      return "AreaSchedulingTreeDO(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaSchedulingTreeDO)) {
         return false;
      }

      AreaSchedulingTreeDO other = (AreaSchedulingTreeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                     Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                     Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                     if (this$schedulingTotalNetWeight == null
                        ? other$schedulingTotalNetWeight == null
                        : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                        Object this$factory = this.getFactory();
                        Object other$factory = other.getFactory();
                        if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              return this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AreaSchedulingTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      return result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
   }
}
