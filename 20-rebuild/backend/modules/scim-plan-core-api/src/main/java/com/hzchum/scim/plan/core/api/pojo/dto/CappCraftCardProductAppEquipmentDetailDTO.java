package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CAPP  app焊接设备查询 请求参数")
public class CappCraftCardProductAppEquipmentDetailDTO {
   private String id;

   public String getId() {
      return this.id;
   }

   public void setId(final String id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppEquipmentDetailDTO)) {
         return false;
      }

      CappCraftCardProductAppEquipmentDetailDTO other = (CappCraftCardProductAppEquipmentDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppEquipmentDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppEquipmentDetailDTO(id=" + this.getId() + ")";
   }
}
