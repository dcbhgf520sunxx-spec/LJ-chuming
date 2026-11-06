package com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "清单排期-车间排期统计")
public class ListSchedulingWorkshopDTO {
   @ApiModelProperty("生产方式(0: 自制, 1: 外包)")
   private Integer productionWay;
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("车间名称")
   private String workshopName;
   @ApiModelProperty("排期数量(件)")
   private BigDecimal schedulingQuantity;
   @ApiModelProperty("排期重量(吨)")
   private BigDecimal schedulingWeight;
   @ApiModelProperty("占比(%)")
   private BigDecimal ratio;

   public Integer getProductionWay() {
      return this.productionWay;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public BigDecimal getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public void setProductionWay(final Integer productionWay) {
      this.productionWay = productionWay;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setSchedulingQuantity(final BigDecimal schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
   }

   public void setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
   }

   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ListSchedulingWorkshopDTO)) {
         return false;
      }

      ListSchedulingWorkshopDTO other = (ListSchedulingWorkshopDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionWay = this.getProductionWay();
      Object other$productionWay = other.getProductionWay();
      if (this$productionWay == null ? other$productionWay == null : this$productionWay.equals(other$productionWay)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$workshopName = this.getWorkshopName();
            Object other$workshopName = other.getWorkshopName();
            if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
               Object this$schedulingQuantity = this.getSchedulingQuantity();
               Object other$schedulingQuantity = other.getSchedulingQuantity();
               if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                  Object this$schedulingWeight = this.getSchedulingWeight();
                  Object other$schedulingWeight = other.getSchedulingWeight();
                  if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
                     Object this$ratio = this.getRatio();
                     Object other$ratio = other.getRatio();
                     return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
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
      return other instanceof ListSchedulingWorkshopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionWay = this.getProductionWay();
      result = result * 59 + ($productionWay == null ? 43 : $productionWay.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "ListSchedulingWorkshopDTO(productionWay="
         + this.getProductionWay()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", ratio="
         + this.getRatio()
         + ")";
   }
}
