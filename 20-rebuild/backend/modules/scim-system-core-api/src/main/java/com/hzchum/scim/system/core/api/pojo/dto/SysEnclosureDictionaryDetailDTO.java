package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护字典版型详情类 ")
public class SysEnclosureDictionaryDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "plateType", value = "版型")
   private String plateType;
   @ApiModelProperty(name = "effectiveWidth", value = "有效宽度")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽")
   private BigDecimal unfoldedWidth;

   public static SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder builder() {
      return new SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder();
   }

   public SysEnclosureDictionaryDetailDTO() {
   }

   public SysEnclosureDictionaryDetailDTO(final Long id, final String plateType, final BigDecimal effectiveWidth, final BigDecimal unfoldedWidth) {
      this.id = id;
      this.plateType = plateType;
      this.effectiveWidth = effectiveWidth;
      this.unfoldedWidth = unfoldedWidth;
   }

   public Long getId() {
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

   public void setId(final Long id) {
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

      if (!(o instanceof SysEnclosureDictionaryDetailDTO)) {
         return false;
      }

      SysEnclosureDictionaryDetailDTO other = (SysEnclosureDictionaryDetailDTO)o;
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
      return other instanceof SysEnclosureDictionaryDetailDTO;
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
      return "SysEnclosureDictionaryDetailDTO(id="
         + this.getId()
         + ", plateType="
         + this.getPlateType()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ")";
   }

   public static class SysEnclosureDictionaryDetailDTOBuilder {
      private Long id;
      private String plateType;
      private BigDecimal effectiveWidth;
      private BigDecimal unfoldedWidth;

      SysEnclosureDictionaryDetailDTOBuilder() {
      }

      public SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder plateType(final String plateType) {
         this.plateType = plateType;
         return this;
      }

      public SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder effectiveWidth(final BigDecimal effectiveWidth) {
         this.effectiveWidth = effectiveWidth;
         return this;
      }

      public SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public SysEnclosureDictionaryDetailDTO build() {
         return new SysEnclosureDictionaryDetailDTO(this.id, this.plateType, this.effectiveWidth, this.unfoldedWidth);
      }

      @Override
      public String toString() {
         return "SysEnclosureDictionaryDetailDTO.SysEnclosureDictionaryDetailDTOBuilder(id="
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
