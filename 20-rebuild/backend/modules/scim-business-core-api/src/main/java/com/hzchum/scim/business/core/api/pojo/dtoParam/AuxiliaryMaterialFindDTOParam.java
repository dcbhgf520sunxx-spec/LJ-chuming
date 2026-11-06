package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;

public class AuxiliaryMaterialFindDTOParam {
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("科目id")
   private Long classifyId;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("颜色")
   private String color;

   public static AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder builder() {
      return new AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder();
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialFindDTOParam)) {
         return false;
      }

      AuxiliaryMaterialFindDTOParam other = (AuxiliaryMaterialFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$color = this.getColor();
               Object other$color = other.getColor();
               return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof AuxiliaryMaterialFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialFindDTOParam(monomerId="
         + this.getMonomerId()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ")";
   }

   public AuxiliaryMaterialFindDTOParam(final Long monomerId, final Long classifyId, final String specification, final String color) {
      this.monomerId = monomerId;
      this.classifyId = classifyId;
      this.specification = specification;
      this.color = color;
   }

   public AuxiliaryMaterialFindDTOParam() {
   }

   public static class AuxiliaryMaterialFindDTOParamBuilder {
      private Long monomerId;
      private Long classifyId;
      private String specification;
      private String color;

      AuxiliaryMaterialFindDTOParamBuilder() {
      }

      public AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public AuxiliaryMaterialFindDTOParam build() {
         return new AuxiliaryMaterialFindDTOParam(this.monomerId, this.classifyId, this.specification, this.color);
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialFindDTOParam.AuxiliaryMaterialFindDTOParamBuilder(monomerId="
            + this.monomerId
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ")";
      }
   }
}
