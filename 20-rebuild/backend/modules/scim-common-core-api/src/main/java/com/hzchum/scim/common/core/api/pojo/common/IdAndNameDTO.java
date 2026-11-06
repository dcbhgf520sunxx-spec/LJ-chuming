package com.hzchum.scim.common.core.api.pojo.common;

public class IdAndNameDTO {
   private Long id;
   private String name;
   private String serialNumber;
   private String code;
   private Boolean status;

   IdAndNameDTO(final Long id, final String name, final String serialNumber, final String code, final Boolean status) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.code = code;
      this.status = status;
   }

   public static IdAndNameDTO.IdAndNameDTOBuilder builder() {
      return new IdAndNameDTO.IdAndNameDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getCode() {
      return this.code;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdAndNameDTO)) {
         return false;
      }

      IdAndNameDTO other = (IdAndNameDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$code = this.getCode();
                  Object other$code = other.getCode();
                  return this$code == null ? other$code == null : this$code.equals(other$code);
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
      return other instanceof IdAndNameDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "IdAndNameDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", code="
         + this.getCode()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class IdAndNameDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String code;
      private Boolean status;

      IdAndNameDTOBuilder() {
      }

      public IdAndNameDTO.IdAndNameDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public IdAndNameDTO.IdAndNameDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public IdAndNameDTO.IdAndNameDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public IdAndNameDTO.IdAndNameDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public IdAndNameDTO.IdAndNameDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public IdAndNameDTO build() {
         return new IdAndNameDTO(this.id, this.name, this.serialNumber, this.code, this.status);
      }

      @Override
      public String toString() {
         return "IdAndNameDTO.IdAndNameDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", code="
            + this.code
            + ", status="
            + this.status
            + ")";
      }
   }
}
