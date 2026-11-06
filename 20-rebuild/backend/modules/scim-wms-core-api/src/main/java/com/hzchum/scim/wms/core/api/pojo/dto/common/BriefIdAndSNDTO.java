package com.hzchum.scim.wms.core.api.pojo.dto.common;

public class BriefIdAndSNDTO {
   private Long id;
   private String serialNumber;
   private Integer receiptType;
   private Integer logisticsPayerType;
   private String enclUnit;

   public static BriefIdAndSNDTO.BriefIdAndSNDTOBuilder builder() {
      return new BriefIdAndSNDTO.BriefIdAndSNDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReceiptType() {
      return this.receiptType;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public String getEnclUnit() {
      return this.enclUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReceiptType(final Integer receiptType) {
      this.receiptType = receiptType;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setEnclUnit(final String enclUnit) {
      this.enclUnit = enclUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefIdAndSNDTO)) {
         return false;
      }

      BriefIdAndSNDTO other = (BriefIdAndSNDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$receiptType = this.getReceiptType();
         Object other$receiptType = other.getReceiptType();
         if (this$receiptType == null ? other$receiptType == null : this$receiptType.equals(other$receiptType)) {
            Object this$logisticsPayerType = this.getLogisticsPayerType();
            Object other$logisticsPayerType = other.getLogisticsPayerType();
            if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$enclUnit = this.getEnclUnit();
                  Object other$enclUnit = other.getEnclUnit();
                  return this$enclUnit == null ? other$enclUnit == null : this$enclUnit.equals(other$enclUnit);
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
      return other instanceof BriefIdAndSNDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $receiptType = this.getReceiptType();
      result = result * 59 + ($receiptType == null ? 43 : $receiptType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $enclUnit = this.getEnclUnit();
      return result * 59 + ($enclUnit == null ? 43 : $enclUnit.hashCode());
   }

   @Override
   public String toString() {
      return "BriefIdAndSNDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", receiptType="
         + this.getReceiptType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", enclUnit="
         + this.getEnclUnit()
         + ")";
   }

   public BriefIdAndSNDTO(final Long id, final String serialNumber, final Integer receiptType, final Integer logisticsPayerType, final String enclUnit) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.receiptType = receiptType;
      this.logisticsPayerType = logisticsPayerType;
      this.enclUnit = enclUnit;
   }

   public BriefIdAndSNDTO() {
   }

   public static class BriefIdAndSNDTOBuilder {
      private Long id;
      private String serialNumber;
      private Integer receiptType;
      private Integer logisticsPayerType;
      private String enclUnit;

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

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder receiptType(final Integer receiptType) {
         this.receiptType = receiptType;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder enclUnit(final String enclUnit) {
         this.enclUnit = enclUnit;
         return this;
      }

      public BriefIdAndSNDTO build() {
         return new BriefIdAndSNDTO(this.id, this.serialNumber, this.receiptType, this.logisticsPayerType, this.enclUnit);
      }

      @Override
      public String toString() {
         return "BriefIdAndSNDTO.BriefIdAndSNDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", receiptType="
            + this.receiptType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", enclUnit="
            + this.enclUnit
            + ")";
      }
   }
}
