package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class ReturnableMaterialInventoryDTOParam {
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal thickness;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private Long projectId;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal minWidth;
   private BigDecimal maxWidth;

   public static ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder builder() {
      return new ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public BigDecimal getMinWidth() {
      return this.minWidth;
   }

   public BigDecimal getMaxWidth() {
      return this.maxWidth;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setMinWidth(final BigDecimal minWidth) {
      this.minWidth = minWidth;
   }

   public void setMaxWidth(final BigDecimal maxWidth) {
      this.maxWidth = maxWidth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnableMaterialInventoryDTOParam)) {
         return false;
      }

      ReturnableMaterialInventoryDTOParam other = (ReturnableMaterialInventoryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$brand = this.getBrand();
                     Object other$brand = other.getBrand();
                     if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                        if (this$heatNoAndBatchNo == null ? other$heatNoAndBatchNo == null : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                           Object this$color = this.getColor();
                           Object other$color = other.getColor();
                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                              Object this$minLength = this.getMinLength();
                              Object other$minLength = other.getMinLength();
                              if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                                 Object this$maxLength = this.getMaxLength();
                                 Object other$maxLength = other.getMaxLength();
                                 if (this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength)) {
                                    Object this$minWidth = this.getMinWidth();
                                    Object other$minWidth = other.getMinWidth();
                                    if (this$minWidth == null ? other$minWidth == null : this$minWidth.equals(other$minWidth)) {
                                       Object this$maxWidth = this.getMaxWidth();
                                       Object other$maxWidth = other.getMaxWidth();
                                       return this$maxWidth == null ? other$maxWidth == null : this$maxWidth.equals(other$maxWidth);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReturnableMaterialInventoryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $minWidth = this.getMinWidth();
      result = result * 59 + ($minWidth == null ? 43 : $minWidth.hashCode());
      Object $maxWidth = this.getMaxWidth();
      return result * 59 + ($maxWidth == null ? 43 : $maxWidth.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnableMaterialInventoryDTOParam(classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", projectId="
         + this.getProjectId()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", minWidth="
         + this.getMinWidth()
         + ", maxWidth="
         + this.getMaxWidth()
         + ")";
   }

   public ReturnableMaterialInventoryDTOParam(
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long projectId,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal minWidth,
      final BigDecimal maxWidth
   ) {
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.projectId = projectId;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.minWidth = minWidth;
      this.maxWidth = maxWidth;
   }

   public ReturnableMaterialInventoryDTOParam() {
   }

   public static class ReturnableMaterialInventoryDTOParamBuilder {
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long projectId;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal minWidth;
      private BigDecimal maxWidth;

      ReturnableMaterialInventoryDTOParamBuilder() {
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder minWidth(final BigDecimal minWidth) {
         this.minWidth = minWidth;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder maxWidth(final BigDecimal maxWidth) {
         this.maxWidth = maxWidth;
         return this;
      }

      public ReturnableMaterialInventoryDTOParam build() {
         return new ReturnableMaterialInventoryDTOParam(
            this.classifyId,
            this.basicClass,
            this.specification,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.projectId,
            this.minLength,
            this.maxLength,
            this.minWidth,
            this.maxWidth
         );
      }

      @Override
      public String toString() {
         return "ReturnableMaterialInventoryDTOParam.ReturnableMaterialInventoryDTOParamBuilder(classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", projectId="
            + this.projectId
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", minWidth="
            + this.minWidth
            + ", maxWidth="
            + this.maxWidth
            + ")";
      }
   }
}
