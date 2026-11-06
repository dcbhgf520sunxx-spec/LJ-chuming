package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("零件修改类")
public class MachinePartUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "零件id")
   @NotNull(message = "零件id不能为空")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "newQuantity", value = "修改后的数量")
   private Integer newQuantity;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartUpdateDTOParam)) {
         return false;
      }

      MachinePartUpdateDTOParam other = (MachinePartUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$newQuantity = this.getNewQuantity();
            Object other$newQuantity = other.getNewQuantity();
            if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MachinePartUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartUpdateDTOParam(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
