package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class RequisitionsDetailDTO {
   private Long id;
   @ApiModelProperty(name = "basicClass", notes = "科目基础分类")
   private Long basicClass;
   @ApiModelProperty(name = "subjectSerialNumber", notes = "末级科目编号")
   private String subjectSerialNumber;
   @ApiModelProperty(name = "subjectPath", notes = "科目路径,以>拼接")
   private String subjectPath;
   @ApiModelProperty(name = "spec", notes = "规格")
   private String spec;
   @ApiModelProperty(name = "number", notes = "数量")
   @JsonInclude(Include.NON_NULL)
   private Integer number;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "wide", notes = "宽")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal wide;
   @ApiModelProperty(name = "thickness", notes = "厚")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @ApiModelProperty(name = "totalWeight", notes = "重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal weight;
   @ApiModelProperty(name = "purchaseApplyListId", notes = "申购清单ID")
   private Long purchaseApplyListId;
   @ApiModelProperty(name = "colour", notes = "颜色")
   @JsonInclude(Include.NON_NULL)
   private String colour;
   @ApiModelProperty(name = "brand", notes = "品牌")
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonInclude(Include.NON_NULL)
   private String remark;

   RequisitionsDetailDTO(
      final Long id,
      final Long basicClass,
      final String subjectSerialNumber,
      final String subjectPath,
      final String spec,
      final Integer number,
      final BigDecimal length,
      final BigDecimal wide,
      final BigDecimal thickness,
      final BigDecimal weight,
      final Long purchaseApplyListId,
      final String colour,
      final String brand,
      final String remark
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.subjectSerialNumber = subjectSerialNumber;
      this.subjectPath = subjectPath;
      this.spec = spec;
      this.number = number;
      this.length = length;
      this.wide = wide;
      this.thickness = thickness;
      this.weight = weight;
      this.purchaseApplyListId = purchaseApplyListId;
      this.colour = colour;
      this.brand = brand;
      this.remark = remark;
   }

   public static RequisitionsDetailDTO.RequisitionsDetailDTOBuilder builder() {
      return new RequisitionsDetailDTO.RequisitionsDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getBasicClass() {
      return this.basicClass;
   }

   public String getSubjectSerialNumber() {
      return this.subjectSerialNumber;
   }

   public String getSubjectPath() {
      return this.subjectPath;
   }

   public String getSpec() {
      return this.spec;
   }

   public Integer getNumber() {
      return this.number;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWide() {
      return this.wide;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public Long getPurchaseApplyListId() {
      return this.purchaseApplyListId;
   }

   public String getColour() {
      return this.colour;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Long basicClass) {
      this.basicClass = basicClass;
   }

   public void setSubjectSerialNumber(final String subjectSerialNumber) {
      this.subjectSerialNumber = subjectSerialNumber;
   }

   public void setSubjectPath(final String subjectPath) {
      this.subjectPath = subjectPath;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWide(final BigDecimal wide) {
      this.wide = wide;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setPurchaseApplyListId(final Long purchaseApplyListId) {
      this.purchaseApplyListId = purchaseApplyListId;
   }

   public void setColour(final String colour) {
      this.colour = colour;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RequisitionsDetailDTO)) {
         return false;
      }

      RequisitionsDetailDTO other = (RequisitionsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$purchaseApplyListId = this.getPurchaseApplyListId();
               Object other$purchaseApplyListId = other.getPurchaseApplyListId();
               if (this$purchaseApplyListId == null ? other$purchaseApplyListId == null : this$purchaseApplyListId.equals(other$purchaseApplyListId)) {
                  Object this$subjectSerialNumber = this.getSubjectSerialNumber();
                  Object other$subjectSerialNumber = other.getSubjectSerialNumber();
                  if (this$subjectSerialNumber == null ? other$subjectSerialNumber == null : this$subjectSerialNumber.equals(other$subjectSerialNumber)) {
                     Object this$subjectPath = this.getSubjectPath();
                     Object other$subjectPath = other.getSubjectPath();
                     if (this$subjectPath == null ? other$subjectPath == null : this$subjectPath.equals(other$subjectPath)) {
                        Object this$spec = this.getSpec();
                        Object other$spec = other.getSpec();
                        if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$wide = this.getWide();
                              Object other$wide = other.getWide();
                              if (this$wide == null ? other$wide == null : this$wide.equals(other$wide)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$weight = this.getWeight();
                                    Object other$weight = other.getWeight();
                                    if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                       Object this$colour = this.getColour();
                                       Object other$colour = other.getColour();
                                       if (this$colour == null ? other$colour == null : this$colour.equals(other$colour)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof RequisitionsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $purchaseApplyListId = this.getPurchaseApplyListId();
      result = result * 59 + ($purchaseApplyListId == null ? 43 : $purchaseApplyListId.hashCode());
      Object $subjectSerialNumber = this.getSubjectSerialNumber();
      result = result * 59 + ($subjectSerialNumber == null ? 43 : $subjectSerialNumber.hashCode());
      Object $subjectPath = this.getSubjectPath();
      result = result * 59 + ($subjectPath == null ? 43 : $subjectPath.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $wide = this.getWide();
      result = result * 59 + ($wide == null ? 43 : $wide.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $colour = this.getColour();
      result = result * 59 + ($colour == null ? 43 : $colour.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "RequisitionsDetailDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", subjectSerialNumber="
         + this.getSubjectSerialNumber()
         + ", subjectPath="
         + this.getSubjectPath()
         + ", spec="
         + this.getSpec()
         + ", number="
         + this.getNumber()
         + ", length="
         + this.getLength()
         + ", wide="
         + this.getWide()
         + ", thickness="
         + this.getThickness()
         + ", weight="
         + this.getWeight()
         + ", purchaseApplyListId="
         + this.getPurchaseApplyListId()
         + ", colour="
         + this.getColour()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class RequisitionsDetailDTOBuilder {
      private Long id;
      private Long basicClass;
      private String subjectSerialNumber;
      private String subjectPath;
      private String spec;
      private Integer number;
      private BigDecimal length;
      private BigDecimal wide;
      private BigDecimal thickness;
      private BigDecimal weight;
      private Long purchaseApplyListId;
      private String colour;
      private String brand;
      private String remark;

      RequisitionsDetailDTOBuilder() {
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder basicClass(final Long basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder subjectSerialNumber(final String subjectSerialNumber) {
         this.subjectSerialNumber = subjectSerialNumber;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder subjectPath(final String subjectPath) {
         this.subjectPath = subjectPath;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder wide(final BigDecimal wide) {
         this.wide = wide;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder purchaseApplyListId(final Long purchaseApplyListId) {
         this.purchaseApplyListId = purchaseApplyListId;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder colour(final String colour) {
         this.colour = colour;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public RequisitionsDetailDTO.RequisitionsDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RequisitionsDetailDTO build() {
         return new RequisitionsDetailDTO(
            this.id,
            this.basicClass,
            this.subjectSerialNumber,
            this.subjectPath,
            this.spec,
            this.number,
            this.length,
            this.wide,
            this.thickness,
            this.weight,
            this.purchaseApplyListId,
            this.colour,
            this.brand,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "RequisitionsDetailDTO.RequisitionsDetailDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", subjectSerialNumber="
            + this.subjectSerialNumber
            + ", subjectPath="
            + this.subjectPath
            + ", spec="
            + this.spec
            + ", number="
            + this.number
            + ", length="
            + this.length
            + ", wide="
            + this.wide
            + ", thickness="
            + this.thickness
            + ", weight="
            + this.weight
            + ", purchaseApplyListId="
            + this.purchaseApplyListId
            + ", colour="
            + this.colour
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
