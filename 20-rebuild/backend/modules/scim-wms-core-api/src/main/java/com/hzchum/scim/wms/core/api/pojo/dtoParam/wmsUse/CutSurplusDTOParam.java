package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class CutSurplusDTOParam {
   private Integer surplusState;
   private BigDecimal area;
   private Long materialId;
   private String surplusDxfPictureUrl;
   private String projectNo;
   private String projectName;
   private String material;
   private BigDecimal weight;
   private String specification;
   private String number;
   private BigDecimal num;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;

   public static CutSurplusDTOParam.CutSurplusDTOParamBuilder builder() {
      return new CutSurplusDTOParam.CutSurplusDTOParamBuilder();
   }

   public Integer getSurplusState() {
      return this.surplusState;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public String getSurplusDxfPictureUrl() {
      return this.surplusDxfPictureUrl;
   }

   public String getProjectNo() {
      return this.projectNo;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getNumber() {
      return this.number;
   }

   public BigDecimal getNum() {
      return this.num;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public void setSurplusState(final Integer surplusState) {
      this.surplusState = surplusState;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setSurplusDxfPictureUrl(final String surplusDxfPictureUrl) {
      this.surplusDxfPictureUrl = surplusDxfPictureUrl;
   }

   public void setProjectNo(final String projectNo) {
      this.projectNo = projectNo;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setNumber(final String number) {
      this.number = number;
   }

   public void setNum(final BigDecimal num) {
      this.num = num;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutSurplusDTOParam)) {
         return false;
      }

      CutSurplusDTOParam other = (CutSurplusDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$surplusState = this.getSurplusState();
      Object other$surplusState = other.getSurplusState();
      if (this$surplusState == null ? other$surplusState == null : this$surplusState.equals(other$surplusState)) {
         Object this$materialId = this.getMaterialId();
         Object other$materialId = other.getMaterialId();
         if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
            Object this$area = this.getArea();
            Object other$area = other.getArea();
            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
               Object this$surplusDxfPictureUrl = this.getSurplusDxfPictureUrl();
               Object other$surplusDxfPictureUrl = other.getSurplusDxfPictureUrl();
               if (this$surplusDxfPictureUrl == null ? other$surplusDxfPictureUrl == null : this$surplusDxfPictureUrl.equals(other$surplusDxfPictureUrl)) {
                  Object this$projectNo = this.getProjectNo();
                  Object other$projectNo = other.getProjectNo();
                  if (this$projectNo == null ? other$projectNo == null : this$projectNo.equals(other$projectNo)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$weight = this.getWeight();
                           Object other$weight = other.getWeight();
                           if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$num = this.getNum();
                                    Object other$num = other.getNum();
                                    if (this$num == null ? other$num == null : this$num.equals(other$num)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             return this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CutSurplusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $surplusState = this.getSurplusState();
      result = result * 59 + ($surplusState == null ? 43 : $surplusState.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $surplusDxfPictureUrl = this.getSurplusDxfPictureUrl();
      result = result * 59 + ($surplusDxfPictureUrl == null ? 43 : $surplusDxfPictureUrl.hashCode());
      Object $projectNo = this.getProjectNo();
      result = result * 59 + ($projectNo == null ? 43 : $projectNo.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   @Override
   public String toString() {
      return "CutSurplusDTOParam(surplusState="
         + this.getSurplusState()
         + ", area="
         + this.getArea()
         + ", materialId="
         + this.getMaterialId()
         + ", surplusDxfPictureUrl="
         + this.getSurplusDxfPictureUrl()
         + ", projectNo="
         + this.getProjectNo()
         + ", projectName="
         + this.getProjectName()
         + ", material="
         + this.getMaterial()
         + ", weight="
         + this.getWeight()
         + ", specification="
         + this.getSpecification()
         + ", number="
         + this.getNumber()
         + ", num="
         + this.getNum()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   public CutSurplusDTOParam(
      final Integer surplusState,
      final BigDecimal area,
      final Long materialId,
      final String surplusDxfPictureUrl,
      final String projectNo,
      final String projectName,
      final String material,
      final BigDecimal weight,
      final String specification,
      final String number,
      final BigDecimal num,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness
   ) {
      this.surplusState = surplusState;
      this.area = area;
      this.materialId = materialId;
      this.surplusDxfPictureUrl = surplusDxfPictureUrl;
      this.projectNo = projectNo;
      this.projectName = projectName;
      this.material = material;
      this.weight = weight;
      this.specification = specification;
      this.number = number;
      this.num = num;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
   }

   public CutSurplusDTOParam() {
   }

   public static class CutSurplusDTOParamBuilder {
      private Integer surplusState;
      private BigDecimal area;
      private Long materialId;
      private String surplusDxfPictureUrl;
      private String projectNo;
      private String projectName;
      private String material;
      private BigDecimal weight;
      private String specification;
      private String number;
      private BigDecimal num;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;

      CutSurplusDTOParamBuilder() {
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder surplusState(final Integer surplusState) {
         this.surplusState = surplusState;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder surplusDxfPictureUrl(final String surplusDxfPictureUrl) {
         this.surplusDxfPictureUrl = surplusDxfPictureUrl;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder projectNo(final String projectNo) {
         this.projectNo = projectNo;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder num(final BigDecimal num) {
         this.num = num;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public CutSurplusDTOParam.CutSurplusDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public CutSurplusDTOParam build() {
         return new CutSurplusDTOParam(
            this.surplusState,
            this.area,
            this.materialId,
            this.surplusDxfPictureUrl,
            this.projectNo,
            this.projectName,
            this.material,
            this.weight,
            this.specification,
            this.number,
            this.num,
            this.length,
            this.width,
            this.thickness
         );
      }

      @Override
      public String toString() {
         return "CutSurplusDTOParam.CutSurplusDTOParamBuilder(surplusState="
            + this.surplusState
            + ", area="
            + this.area
            + ", materialId="
            + this.materialId
            + ", surplusDxfPictureUrl="
            + this.surplusDxfPictureUrl
            + ", projectNo="
            + this.projectNo
            + ", projectName="
            + this.projectName
            + ", material="
            + this.material
            + ", weight="
            + this.weight
            + ", specification="
            + this.specification
            + ", number="
            + this.number
            + ", num="
            + this.num
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}
