package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProjectSchedulingDetailDO", description = "项目信息 ")
public class ProjectSchedulingTreeDO extends ProjectDetailDO {
   @ApiModelProperty(name = "monomerSchedulingDetailDO", notes = "单体信息")
   @JsonProperty("monomerSchedulingDetailDO")
   @JSONField(name = "monomerSchedulingDetailDO")
   private List<MonomerSchedulingTreeDO> monomerSchedulingTreeDO;
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

   public List<MonomerSchedulingTreeDO> getMonomerSchedulingTreeDO() {
      return this.monomerSchedulingTreeDO;
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

   @JsonProperty("monomerSchedulingDetailDO")
   public ProjectSchedulingTreeDO setMonomerSchedulingTreeDO(final List<MonomerSchedulingTreeDO> monomerSchedulingTreeDO) {
      this.monomerSchedulingTreeDO = monomerSchedulingTreeDO;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectSchedulingTreeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProjectSchedulingTreeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public ProjectSchedulingTreeDO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ProjectSchedulingTreeDO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSchedulingTreeDO(monomerSchedulingTreeDO="
         + this.getMonomerSchedulingTreeDO()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSchedulingTreeDO)) {
         return false;
      }

      ProjectSchedulingTreeDO other = (ProjectSchedulingTreeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$monomerSchedulingTreeDO = this.getMonomerSchedulingTreeDO();
            Object other$monomerSchedulingTreeDO = other.getMonomerSchedulingTreeDO();
            if (this$monomerSchedulingTreeDO == null
               ? other$monomerSchedulingTreeDO == null
               : this$monomerSchedulingTreeDO.equals(other$monomerSchedulingTreeDO)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                  Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                  Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                  return this$schedulingTotalNetWeight == null
                     ? other$schedulingTotalNetWeight == null
                     : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight);
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
      return other instanceof ProjectSchedulingTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $monomerSchedulingTreeDO = this.getMonomerSchedulingTreeDO();
      result = result * 59 + ($monomerSchedulingTreeDO == null ? 43 : $monomerSchedulingTreeDO.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      return result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
   }
}
