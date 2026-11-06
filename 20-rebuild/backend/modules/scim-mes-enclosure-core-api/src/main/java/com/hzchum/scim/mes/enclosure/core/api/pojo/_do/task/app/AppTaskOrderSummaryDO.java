package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AppTaskOrderSummaryDTO", description = "可生产的任务工单")
public class AppTaskOrderSummaryDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "cutName", notes = "切割名称")
   @JsonProperty("cutName")
   @JSONField(name = "cutName")
   private String cutName;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "netWeight", notes = "重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public static AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder builder() {
      return new AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder();
   }

   public AppTaskOrderSummaryDO() {
   }

   public AppTaskOrderSummaryDO(
      final Long id, final Integer quantity, final String orderNumber, final String cutName, final LocalDateTime askCompleteTime, final BigDecimal netWeight
   ) {
      this.id = id;
      this.quantity = quantity;
      this.orderNumber = orderNumber;
      this.cutName = cutName;
      this.askCompleteTime = askCompleteTime;
      this.netWeight = netWeight;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getCutName() {
      return this.cutName;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("id")
   public AppTaskOrderSummaryDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskOrderSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskOrderSummaryDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("cutName")
   public AppTaskOrderSummaryDO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskOrderSummaryDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("netWeight")
   public AppTaskOrderSummaryDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskOrderSummaryDO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", cutName="
         + this.getCutName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskOrderSummaryDO)) {
         return false;
      }

      AppTaskOrderSummaryDO other = (AppTaskOrderSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$orderNumber = this.getOrderNumber();
            Object other$orderNumber = other.getOrderNumber();
            if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
               Object this$cutName = this.getCutName();
               Object other$cutName = other.getCutName();
               if (this$cutName == null ? other$cutName == null : this$cutName.equals(other$cutName)) {
                  Object this$askCompleteTime = this.getAskCompleteTime();
                  Object other$askCompleteTime = other.getAskCompleteTime();
                  if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
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
      return other instanceof AppTaskOrderSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class AppTaskOrderSummaryDOBuilder {
      private Long id;
      private Integer quantity;
      private String orderNumber;
      private String cutName;
      private LocalDateTime askCompleteTime;
      private BigDecimal netWeight;

      AppTaskOrderSummaryDOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("cutName")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("netWeight")
      public AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public AppTaskOrderSummaryDO build() {
         return new AppTaskOrderSummaryDO(this.id, this.quantity, this.orderNumber, this.cutName, this.askCompleteTime, this.netWeight);
      }

      @Override
      public String toString() {
         return "AppTaskOrderSummaryDO.AppTaskOrderSummaryDOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", orderNumber="
            + this.orderNumber
            + ", cutName="
            + this.cutName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
