package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MachinePartUnProductionSaveVORequest", description = "")
public class MachinePartUnProductionSaveVORequest {
   @ApiModelProperty(name = "needId", notes = "needId")
   @JsonProperty("needId")
   @JSONField(name = "needId")
   private Long needId;
   @ApiModelProperty(name = "quantity", notes = "不排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public Long getNeedId() {
      return this.needId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("needId")
   public MachinePartUnProductionSaveVORequest setNeedId(final Long needId) {
      this.needId = needId;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartUnProductionSaveVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartUnProductionSaveVORequest(needId=" + this.getNeedId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MachinePartUnProductionSaveVORequest)) {
         return false;
      } else {
         MachinePartUnProductionSaveVORequest other = (MachinePartUnProductionSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$needId = this.getNeedId();
            Object other$needId = other.getNeedId();
            if (this$needId == null ? other$needId == null : this$needId.equals(other$needId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartUnProductionSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $needId = this.getNeedId();
      result = result * 59 + ($needId == null ? 43 : $needId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }
}
