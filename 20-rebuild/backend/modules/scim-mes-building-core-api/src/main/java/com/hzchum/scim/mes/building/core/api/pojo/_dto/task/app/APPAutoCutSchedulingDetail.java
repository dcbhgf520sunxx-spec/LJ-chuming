package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "半自动切割任务详情")
public class APPAutoCutSchedulingDetail {
   @ApiModelProperty(name = "schedulingId", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "orderNumber", notes = "工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;

   public static APPAutoCutSchedulingDetail.APPAutoCutSchedulingDetailBuilder builder() {
      return new APPAutoCutSchedulingDetail.APPAutoCutSchedulingDetailBuilder();
   }

   public APPAutoCutSchedulingDetail() {
   }

   public APPAutoCutSchedulingDetail(final Long schedulingId, final String orderNumber) {
      this.schedulingId = schedulingId;
      this.orderNumber = orderNumber;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   @JsonProperty("schedulingId")
   public APPAutoCutSchedulingDetail setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("orderNumber")
   public APPAutoCutSchedulingDetail setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @Override
   public String toString() {
      return "APPAutoCutSchedulingDetail(schedulingId=" + this.getSchedulingId() + ", orderNumber=" + this.getOrderNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof APPAutoCutSchedulingDetail)) {
         return false;
      } else {
         APPAutoCutSchedulingDetail other = (APPAutoCutSchedulingDetail)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$schedulingId = this.getSchedulingId();
            Object other$schedulingId = other.getSchedulingId();
            if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof APPAutoCutSchedulingDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class APPAutoCutSchedulingDetailBuilder {
      private Long schedulingId;
      private String orderNumber;

      APPAutoCutSchedulingDetailBuilder() {
      }

      @JsonProperty("schedulingId")
      public APPAutoCutSchedulingDetail.APPAutoCutSchedulingDetailBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("orderNumber")
      public APPAutoCutSchedulingDetail.APPAutoCutSchedulingDetailBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public APPAutoCutSchedulingDetail build() {
         return new APPAutoCutSchedulingDetail(this.schedulingId, this.orderNumber);
      }

      @Override
      public String toString() {
         return "APPAutoCutSchedulingDetail.APPAutoCutSchedulingDetailBuilder(schedulingId=" + this.schedulingId + ", orderNumber=" + this.orderNumber + ")";
      }
   }
}
