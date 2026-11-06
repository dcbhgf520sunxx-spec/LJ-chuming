package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureTaskOrderMatchingDTOParam", description = "多余匹配列表")
public class MesEnclosureTaskOrderMatchingDTOParam {
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;

   public static MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder builder() {
      return new MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder();
   }

   public MesEnclosureTaskOrderMatchingDTOParam(
      final Long schedulingId, final Long productId, final Integer quantity, final LocalDateTime askCompleteTime, final Long groupsId
   ) {
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
      this.groupsId = groupsId;
   }

   public MesEnclosureTaskOrderMatchingDTOParam() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureTaskOrderMatchingDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureTaskOrderMatchingDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderMatchingDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderMatchingDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderMatchingDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderMatchingDTOParam)) {
         return false;
      }

      MesEnclosureTaskOrderMatchingDTOParam other = (MesEnclosureTaskOrderMatchingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                  Object this$askCompleteTime = this.getAskCompleteTime();
                  Object other$askCompleteTime = other.getAskCompleteTime();
                  return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesEnclosureTaskOrderMatchingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderMatchingDTOParam(schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", groupsId="
         + this.getGroupsId()
         + ")";
   }

   public static class MesEnclosureTaskOrderMatchingDTOParamBuilder {
      private Long schedulingId;
      private Long productId;
      private Integer quantity;
      private LocalDateTime askCompleteTime;
      private Long groupsId;

      MesEnclosureTaskOrderMatchingDTOParamBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesEnclosureTaskOrderMatchingDTOParam build() {
         return new MesEnclosureTaskOrderMatchingDTOParam(this.schedulingId, this.productId, this.quantity, this.askCompleteTime, this.groupsId);
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderMatchingDTOParam.MesEnclosureTaskOrderMatchingDTOParamBuilder(schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", groupsId="
            + this.groupsId
            + ")";
      }
   }
}
