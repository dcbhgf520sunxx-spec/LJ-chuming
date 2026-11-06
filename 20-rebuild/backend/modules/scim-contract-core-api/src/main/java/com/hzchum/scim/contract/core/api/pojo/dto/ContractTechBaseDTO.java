package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel
public class ContractTechBaseDTO {
   private String id;
   @ApiModelProperty(name = "plateType", notes = "版型")
   private String plateType;
   @ApiModelProperty(name = "effectiveWidth", value = "有效宽度(mm)")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;

   public static ContractTechBaseDTO.ContractTechBaseDTOBuilder builder() {
      return new ContractTechBaseDTO.ContractTechBaseDTOBuilder();
   }

   public ContractTechBaseDTO(final String id, final String plateType, final BigDecimal effectiveWidth, final BigDecimal unfoldedWidth) {
      this.id = id;
      this.plateType = plateType;
      this.effectiveWidth = effectiveWidth;
      this.unfoldedWidth = unfoldedWidth;
   }

   public ContractTechBaseDTO() {
   }

   public String getId() {
      return this.id;
   }

   public String getPlateType() {
      return this.plateType;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setPlateType(final String plateType) {
      this.plateType = plateType;
   }

   public void setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTechBaseDTO)) {
         return false;
      }

      ContractTechBaseDTO other = (ContractTechBaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$plateType = this.getPlateType();
         Object other$plateType = other.getPlateType();
         if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
            Object this$effectiveWidth = this.getEffectiveWidth();
            Object other$effectiveWidth = other.getEffectiveWidth();
            if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
               Object this$unfoldedWidth = this.getUnfoldedWidth();
               Object other$unfoldedWidth = other.getUnfoldedWidth();
               return this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth);
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
      return other instanceof ContractTechBaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $plateType = this.getPlateType();
      result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      return result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTechBaseDTO(id="
         + this.getId()
         + ", plateType="
         + this.getPlateType()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ")";
   }

   public static class ContractTechBaseDTOBuilder {
      private String id;
      private String plateType;
      private BigDecimal effectiveWidth;
      private BigDecimal unfoldedWidth;

      ContractTechBaseDTOBuilder() {
      }

      public ContractTechBaseDTO.ContractTechBaseDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      public ContractTechBaseDTO.ContractTechBaseDTOBuilder plateType(final String plateType) {
         this.plateType = plateType;
         return this;
      }

      public ContractTechBaseDTO.ContractTechBaseDTOBuilder effectiveWidth(final BigDecimal effectiveWidth) {
         this.effectiveWidth = effectiveWidth;
         return this;
      }

      public ContractTechBaseDTO.ContractTechBaseDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public ContractTechBaseDTO build() {
         return new ContractTechBaseDTO(this.id, this.plateType, this.effectiveWidth, this.unfoldedWidth);
      }

      @Override
      public String toString() {
         return "ContractTechBaseDTO.ContractTechBaseDTOBuilder(id="
            + this.id
            + ", plateType="
            + this.plateType
            + ", effectiveWidth="
            + this.effectiveWidth
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ")";
      }
   }
}
