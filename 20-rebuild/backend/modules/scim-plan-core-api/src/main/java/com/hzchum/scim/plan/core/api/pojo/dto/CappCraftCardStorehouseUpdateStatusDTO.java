package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP 焊接工艺 状态修改 请求参数")
public class CappCraftCardStorehouseUpdateStatusDTO {
   private Long id;
   private Boolean enabledFlag;

   public CappCraftCardStorehouseUpdateStatusDTO(final Long id, final Boolean enabledFlag) {
      this.id = id;
      this.enabledFlag = enabledFlag;
   }

   public CappCraftCardStorehouseUpdateStatusDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardStorehouseUpdateStatusDTO)) {
         return false;
      } else {
         CappCraftCardStorehouseUpdateStatusDTO other = (CappCraftCardStorehouseUpdateStatusDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$enabledFlag = this.getEnabledFlag();
               Object other$enabledFlag = other.getEnabledFlag();
               return this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardStorehouseUpdateStatusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      return result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseUpdateStatusDTO(id=" + this.getId() + ", enabledFlag=" + this.getEnabledFlag() + ")";
   }
}
