package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class BusinessPriceProjectDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理计 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty("计价状态 1未计价 2部分计价 4全部计价")
   private Integer pricingStatusEnum;

   public static BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder builder() {
      return new BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder();
   }

   public BusinessPriceProjectDTO(
      final Long id, final String name, final String shortName, final String serialNumber, final Integer structureMeasureMode, final Integer pricingStatusEnum
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.structureMeasureMode = structureMeasureMode;
      this.pricingStatusEnum = pricingStatusEnum;
   }

   public BusinessPriceProjectDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getPricingStatusEnum() {
      return this.pricingStatusEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setPricingStatusEnum(final Integer pricingStatusEnum) {
      this.pricingStatusEnum = pricingStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceProjectDTO)) {
         return false;
      }

      BusinessPriceProjectDTO other = (BusinessPriceProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$structureMeasureMode = this.getStructureMeasureMode();
         Object other$structureMeasureMode = other.getStructureMeasureMode();
         if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
            Object this$pricingStatusEnum = this.getPricingStatusEnum();
            Object other$pricingStatusEnum = other.getPricingStatusEnum();
            if (this$pricingStatusEnum == null ? other$pricingStatusEnum == null : this$pricingStatusEnum.equals(other$pricingStatusEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $pricingStatusEnum = this.getPricingStatusEnum();
      result = result * 59 + ($pricingStatusEnum == null ? 43 : $pricingStatusEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceProjectDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", pricingStatusEnum="
         + this.getPricingStatusEnum()
         + ")";
   }

   public static class BusinessPriceProjectDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private Integer structureMeasureMode;
      private Integer pricingStatusEnum;

      BusinessPriceProjectDTOBuilder() {
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder pricingStatusEnum(final Integer pricingStatusEnum) {
         this.pricingStatusEnum = pricingStatusEnum;
         return this;
      }

      public BusinessPriceProjectDTO build() {
         return new BusinessPriceProjectDTO(this.id, this.name, this.shortName, this.serialNumber, this.structureMeasureMode, this.pricingStatusEnum);
      }

      @Override
      public String toString() {
         return "BusinessPriceProjectDTO.BusinessPriceProjectDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", pricingStatusEnum="
            + this.pricingStatusEnum
            + ")";
      }
   }
}
