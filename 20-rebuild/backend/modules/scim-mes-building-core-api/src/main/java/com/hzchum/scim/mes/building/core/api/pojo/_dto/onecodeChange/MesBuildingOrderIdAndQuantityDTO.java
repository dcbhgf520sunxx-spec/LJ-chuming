package com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange;

public class MesBuildingOrderIdAndQuantityDTO {
   private Long id;
   private Integer taskQuantity;
   private Integer completeQuantity;

   public static MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder builder() {
      return new MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingOrderIdAndQuantityDTO)) {
         return false;
      }

      MesBuildingOrderIdAndQuantityDTO other = (MesBuildingOrderIdAndQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            return this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingOrderIdAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      return result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingOrderIdAndQuantityDTO(id="
         + this.getId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }

   public MesBuildingOrderIdAndQuantityDTO(final Long id, final Integer taskQuantity, final Integer completeQuantity) {
      this.id = id;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
   }

   public MesBuildingOrderIdAndQuantityDTO() {
   }

   public static class MesBuildingOrderIdAndQuantityDTOBuilder {
      private Long id;
      private Integer taskQuantity;
      private Integer completeQuantity;

      MesBuildingOrderIdAndQuantityDTOBuilder() {
      }

      public MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBuildingOrderIdAndQuantityDTO build() {
         return new MesBuildingOrderIdAndQuantityDTO(this.id, this.taskQuantity, this.completeQuantity);
      }

      @Override
      public String toString() {
         return "MesBuildingOrderIdAndQuantityDTO.MesBuildingOrderIdAndQuantityDTOBuilder(id="
            + this.id
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ")";
      }
   }
}
