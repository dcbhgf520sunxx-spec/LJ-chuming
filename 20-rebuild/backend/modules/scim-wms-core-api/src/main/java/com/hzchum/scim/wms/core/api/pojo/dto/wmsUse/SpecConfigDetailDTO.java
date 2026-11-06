package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class SpecConfigDetailDTO {
   private Long id;
   private String code;
   private String name;
   private BigDecimal unitWeight;
   private Boolean status;

   public static SpecConfigDetailDTO.SpecConfigDetailDTOBuilder builder() {
      return new SpecConfigDetailDTO.SpecConfigDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getUnitWeight() {
      return this.unitWeight;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUnitWeight(final BigDecimal unitWeight) {
      this.unitWeight = unitWeight;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecConfigDetailDTO)) {
         return false;
      }

      SpecConfigDetailDTO other = (SpecConfigDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            if (this$code == null ? other$code == null : this$code.equals(other$code)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$unitWeight = this.getUnitWeight();
                  Object other$unitWeight = other.getUnitWeight();
                  return this$unitWeight == null ? other$unitWeight == null : this$unitWeight.equals(other$unitWeight);
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
      return other instanceof SpecConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unitWeight = this.getUnitWeight();
      return result * 59 + ($unitWeight == null ? 43 : $unitWeight.hashCode());
   }

   @Override
   public String toString() {
      return "SpecConfigDetailDTO(id="
         + this.getId()
         + ", code="
         + this.getCode()
         + ", name="
         + this.getName()
         + ", unitWeight="
         + this.getUnitWeight()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public SpecConfigDetailDTO(final Long id, final String code, final String name, final BigDecimal unitWeight, final Boolean status) {
      this.id = id;
      this.code = code;
      this.name = name;
      this.unitWeight = unitWeight;
      this.status = status;
   }

   public SpecConfigDetailDTO() {
   }

   public static class SpecConfigDetailDTOBuilder {
      private Long id;
      private String code;
      private String name;
      private BigDecimal unitWeight;
      private Boolean status;

      SpecConfigDetailDTOBuilder() {
      }

      public SpecConfigDetailDTO.SpecConfigDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SpecConfigDetailDTO.SpecConfigDetailDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SpecConfigDetailDTO.SpecConfigDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SpecConfigDetailDTO.SpecConfigDetailDTOBuilder unitWeight(final BigDecimal unitWeight) {
         this.unitWeight = unitWeight;
         return this;
      }

      public SpecConfigDetailDTO.SpecConfigDetailDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SpecConfigDetailDTO build() {
         return new SpecConfigDetailDTO(this.id, this.code, this.name, this.unitWeight, this.status);
      }

      @Override
      public String toString() {
         return "SpecConfigDetailDTO.SpecConfigDetailDTOBuilder(id="
            + this.id
            + ", code="
            + this.code
            + ", name="
            + this.name
            + ", unitWeight="
            + this.unitWeight
            + ", status="
            + this.status
            + ")";
      }
   }
}
