package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingTaskOrderMatchingDTOParam", description = "多余匹配列表")
public class MesBuildingTaskOrderMatchingDTOParam {
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
   @ApiModelProperty(name = "prodLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("prodLineId")
   @JSONField(name = "prodLineId")
   private Long prodLineId;

   public static MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder builder() {
      return new MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder();
   }

   public MesBuildingTaskOrderMatchingDTOParam(
      final Long schedulingId, final Long productId, final Integer quantity, final LocalDateTime askCompleteTime, final Long groupsId, final Long prodLineId
   ) {
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
      this.groupsId = groupsId;
      this.prodLineId = prodLineId;
   }

   public MesBuildingTaskOrderMatchingDTOParam() {
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

   public Long getProdLineId() {
      return this.prodLineId;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTaskOrderMatchingDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskOrderMatchingDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrderMatchingDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrderMatchingDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrderMatchingDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("prodLineId")
   public MesBuildingTaskOrderMatchingDTOParam setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderMatchingDTOParam)) {
         return false;
      }

      MesBuildingTaskOrderMatchingDTOParam other = (MesBuildingTaskOrderMatchingDTOParam)o;
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
                  Object this$prodLineId = this.getProdLineId();
                  Object other$prodLineId = other.getProdLineId();
                  if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrderMatchingDTOParam;
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
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderMatchingDTOParam(schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", groupsId="
         + this.getGroupsId()
         + ", prodLineId="
         + this.getProdLineId()
         + ")";
   }

   public static class MesBuildingTaskOrderMatchingDTOParamBuilder {
      private Long schedulingId;
      private Long productId;
      private Integer quantity;
      private LocalDateTime askCompleteTime;
      private Long groupsId;
      private Long prodLineId;

      MesBuildingTaskOrderMatchingDTOParamBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("prodLineId")
      public MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public MesBuildingTaskOrderMatchingDTOParam build() {
         return new MesBuildingTaskOrderMatchingDTOParam(this.schedulingId, this.productId, this.quantity, this.askCompleteTime, this.groupsId, this.prodLineId);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderMatchingDTOParam.MesBuildingTaskOrderMatchingDTOParamBuilder(schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", groupsId="
            + this.groupsId
            + ", prodLineId="
            + this.prodLineId
            + ")";
      }
   }
}
