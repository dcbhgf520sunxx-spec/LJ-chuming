package com.hzchum.scim.contract.core.api.pojo.dto;

public class BriefIdAndSNDTO {
   private Long id;
   private String serialNumber;

   public static BriefIdAndSNDTO.BriefIdAndSNDTOBuilder builder() {
      return new BriefIdAndSNDTO.BriefIdAndSNDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BriefIdAndSNDTO)) {
         return false;
      } else {
         BriefIdAndSNDTO other = (BriefIdAndSNDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BriefIdAndSNDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "BriefIdAndSNDTO(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ")";
   }

   public BriefIdAndSNDTO(final Long id, final String serialNumber) {
      this.id = id;
      this.serialNumber = serialNumber;
   }

   public BriefIdAndSNDTO() {
   }

   public static class BriefIdAndSNDTOBuilder {
      private Long id;
      private String serialNumber;

      BriefIdAndSNDTOBuilder() {
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefIdAndSNDTO build() {
         return new BriefIdAndSNDTO(this.id, this.serialNumber);
      }

      @Override
      public String toString() {
         return "BriefIdAndSNDTO.BriefIdAndSNDTOBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ")";
      }
   }
}
