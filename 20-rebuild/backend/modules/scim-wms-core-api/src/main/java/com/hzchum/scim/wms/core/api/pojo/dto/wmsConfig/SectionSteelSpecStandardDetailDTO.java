package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.math.BigDecimal;

public class SectionSteelSpecStandardDetailDTO {
   private Long id;
   private BigDecimal unitNet;
   private Long standardName;
   private Boolean boolDefault;

   public static SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder builder() {
      return new SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getStandardName() {
      return this.standardName;
   }

   public Boolean getBoolDefault() {
      return this.boolDefault;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setStandardName(final Long standardName) {
      this.standardName = standardName;
   }

   public void setBoolDefault(final Boolean boolDefault) {
      this.boolDefault = boolDefault;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpecStandardDetailDTO)) {
         return false;
      }

      SectionSteelSpecStandardDetailDTO other = (SectionSteelSpecStandardDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$standardName = this.getStandardName();
         Object other$standardName = other.getStandardName();
         if (this$standardName == null ? other$standardName == null : this$standardName.equals(other$standardName)) {
            Object this$boolDefault = this.getBoolDefault();
            Object other$boolDefault = other.getBoolDefault();
            if (this$boolDefault == null ? other$boolDefault == null : this$boolDefault.equals(other$boolDefault)) {
               Object this$unitNet = this.getUnitNet();
               Object other$unitNet = other.getUnitNet();
               return this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet);
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
      return other instanceof SectionSteelSpecStandardDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $boolDefault = this.getBoolDefault();
      result = result * 59 + ($boolDefault == null ? 43 : $boolDefault.hashCode());
      Object $unitNet = this.getUnitNet();
      return result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelSpecStandardDetailDTO(id="
         + this.getId()
         + ", unitNet="
         + this.getUnitNet()
         + ", standardName="
         + this.getStandardName()
         + ", boolDefault="
         + this.getBoolDefault()
         + ")";
   }

   public SectionSteelSpecStandardDetailDTO(final Long id, final BigDecimal unitNet, final Long standardName, final Boolean boolDefault) {
      this.id = id;
      this.unitNet = unitNet;
      this.standardName = standardName;
      this.boolDefault = boolDefault;
   }

   public SectionSteelSpecStandardDetailDTO() {
   }

   public static class SectionSteelSpecStandardDetailDTOBuilder {
      private Long id;
      private BigDecimal unitNet;
      private Long standardName;
      private Boolean boolDefault;

      SectionSteelSpecStandardDetailDTOBuilder() {
      }

      public SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder standardName(final Long standardName) {
         this.standardName = standardName;
         return this;
      }

      public SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder boolDefault(final Boolean boolDefault) {
         this.boolDefault = boolDefault;
         return this;
      }

      public SectionSteelSpecStandardDetailDTO build() {
         return new SectionSteelSpecStandardDetailDTO(this.id, this.unitNet, this.standardName, this.boolDefault);
      }

      @Override
      public String toString() {
         return "SectionSteelSpecStandardDetailDTO.SectionSteelSpecStandardDetailDTOBuilder(id="
            + this.id
            + ", unitNet="
            + this.unitNet
            + ", standardName="
            + this.standardName
            + ", boolDefault="
            + this.boolDefault
            + ")";
      }
   }
}
