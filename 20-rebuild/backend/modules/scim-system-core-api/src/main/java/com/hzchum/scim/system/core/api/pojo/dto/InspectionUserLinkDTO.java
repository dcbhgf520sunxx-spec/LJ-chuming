package com.hzchum.scim.system.core.api.pojo.dto;

public class InspectionUserLinkDTO {
   private Long productionLineId;
   private Long processId;
   private Integer type;

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getType() {
      return this.type;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionUserLinkDTO)) {
         return false;
      }

      InspectionUserLinkDTO other = (InspectionUserLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineId = this.getProductionLineId();
      Object other$productionLineId = other.getProductionLineId();
      if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            return this$type == null ? other$type == null : this$type.equals(other$type);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionUserLinkDTO(productionLineId=" + this.getProductionLineId() + ", processId=" + this.getProcessId() + ", type=" + this.getType() + ")";
   }
}
