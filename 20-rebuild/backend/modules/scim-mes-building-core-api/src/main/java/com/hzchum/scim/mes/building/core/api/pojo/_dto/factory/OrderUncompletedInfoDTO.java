package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "OrderUncompletedInfoDTO", description = "未完成订单信息")
public class OrderUncompletedInfoDTO {
   @ApiModelProperty(name = "serialNumber", notes = "订单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "shortName", notes = "短名称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "orderId", notes = "工厂id")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private String orderId;
   @ApiModelProperty(name = "orderNumber", notes = "订单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "uncompletedQuantity", notes = "未完成数量")
   @JsonProperty("uncompletedQuantity")
   @JSONField(name = "uncompletedQuantity")
   private Integer uncompletedQuantity;
   @ApiModelProperty(name = "uncompletedWeight", notes = "未完成重量（吨）")
   @JsonProperty("uncompletedWeight")
   @JSONField(name = "uncompletedWeight")
   private BigDecimal uncompletedWeight;

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getOrderId() {
      return this.orderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getUncompletedQuantity() {
      return this.uncompletedQuantity;
   }

   public BigDecimal getUncompletedWeight() {
      return this.uncompletedWeight;
   }

   @JsonProperty("serialNumber")
   public OrderUncompletedInfoDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("shortName")
   public OrderUncompletedInfoDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("orderId")
   public OrderUncompletedInfoDTO setOrderId(final String orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public OrderUncompletedInfoDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public OrderUncompletedInfoDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("uncompletedQuantity")
   public OrderUncompletedInfoDTO setUncompletedQuantity(final Integer uncompletedQuantity) {
      this.uncompletedQuantity = uncompletedQuantity;
      return this;
   }

   @JsonProperty("uncompletedWeight")
   public OrderUncompletedInfoDTO setUncompletedWeight(final BigDecimal uncompletedWeight) {
      this.uncompletedWeight = uncompletedWeight;
      return this;
   }

   @Override
   public String toString() {
      return "OrderUncompletedInfoDTO(serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", orderId="
         + this.getOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", uncompletedQuantity="
         + this.getUncompletedQuantity()
         + ", uncompletedWeight="
         + this.getUncompletedWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderUncompletedInfoDTO)) {
         return false;
      }

      OrderUncompletedInfoDTO other = (OrderUncompletedInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$uncompletedQuantity = this.getUncompletedQuantity();
      Object other$uncompletedQuantity = other.getUncompletedQuantity();
      if (this$uncompletedQuantity == null ? other$uncompletedQuantity == null : this$uncompletedQuantity.equals(other$uncompletedQuantity)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$orderId = this.getOrderId();
               Object other$orderId = other.getOrderId();
               if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                  Object this$orderNumber = this.getOrderNumber();
                  Object other$orderNumber = other.getOrderNumber();
                  if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                     Object this$askCompleteTime = this.getAskCompleteTime();
                     Object other$askCompleteTime = other.getAskCompleteTime();
                     if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                        Object this$uncompletedWeight = this.getUncompletedWeight();
                        Object other$uncompletedWeight = other.getUncompletedWeight();
                        return this$uncompletedWeight == null ? other$uncompletedWeight == null : this$uncompletedWeight.equals(other$uncompletedWeight);
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
      return other instanceof OrderUncompletedInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $uncompletedQuantity = this.getUncompletedQuantity();
      result = result * 59 + ($uncompletedQuantity == null ? 43 : $uncompletedQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $uncompletedWeight = this.getUncompletedWeight();
      return result * 59 + ($uncompletedWeight == null ? 43 : $uncompletedWeight.hashCode());
   }
}
