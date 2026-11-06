package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class ProjectWasteProductChildDTOParam {
   @NotNull(message = "退货记录id不能为空!")
   private Long mesBuildingReturnWarehouseRecordId;
   @NotNull(message = "数量不能为空!")
   private BigDecimal quantity;

   public static ProjectWasteProductChildDTOParam.ProjectWasteProductChildDTOParamBuilder builder() {
      return new ProjectWasteProductChildDTOParam.ProjectWasteProductChildDTOParamBuilder();
   }

   public ProjectWasteProductChildDTOParam(final Long mesBuildingReturnWarehouseRecordId, final BigDecimal quantity) {
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
      this.quantity = quantity;
   }

   public ProjectWasteProductChildDTOParam() {
   }

   public Long getMesBuildingReturnWarehouseRecordId() {
      return this.mesBuildingReturnWarehouseRecordId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setMesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectWasteProductChildDTOParam)) {
         return false;
      } else {
         ProjectWasteProductChildDTOParam other = (ProjectWasteProductChildDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
            Object other$mesBuildingReturnWarehouseRecordId = other.getMesBuildingReturnWarehouseRecordId();
            if (this$mesBuildingReturnWarehouseRecordId == null
               ? other$mesBuildingReturnWarehouseRecordId == null
               : this$mesBuildingReturnWarehouseRecordId.equals(other$mesBuildingReturnWarehouseRecordId)) {
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
      return other instanceof ProjectWasteProductChildDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
      result = result * 59 + ($mesBuildingReturnWarehouseRecordId == null ? 43 : $mesBuildingReturnWarehouseRecordId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductChildDTOParam(mesBuildingReturnWarehouseRecordId="
         + this.getMesBuildingReturnWarehouseRecordId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public static class ProjectWasteProductChildDTOParamBuilder {
      private Long mesBuildingReturnWarehouseRecordId;
      private BigDecimal quantity;

      ProjectWasteProductChildDTOParamBuilder() {
      }

      public ProjectWasteProductChildDTOParam.ProjectWasteProductChildDTOParamBuilder mesBuildingReturnWarehouseRecordId(
         final Long mesBuildingReturnWarehouseRecordId
      ) {
         this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
         return this;
      }

      public ProjectWasteProductChildDTOParam.ProjectWasteProductChildDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectWasteProductChildDTOParam build() {
         return new ProjectWasteProductChildDTOParam(this.mesBuildingReturnWarehouseRecordId, this.quantity);
      }

      @Override
      public String toString() {
         return "ProjectWasteProductChildDTOParam.ProjectWasteProductChildDTOParamBuilder(mesBuildingReturnWarehouseRecordId="
            + this.mesBuildingReturnWarehouseRecordId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
