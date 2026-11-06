package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("型材申购")
public class SectionSteelPurchaseApplyListDetailDTOParam {
   private Long id;
   @ApiModelProperty(name = "basicClass", notes = "科目基础分类")
   @NotNull(message = "基础分类不能为空")
   private Integer basicClass;
   @ApiModelProperty(name = "subjectSerialNumber", notes = "末级科目编号")
   @NotBlank(message = "科目编号不能为空")
   private String subjectSerialNumber;
   @ApiModelProperty(name = "subjectId", notes = "末级科目ID")
   @NotNull(message = "科目ID不能为空")
   private Long subjectId;
   @ApiModelProperty(name = "spec", notes = "规格")
   @NotBlank(message = "规格信息不能为空")
   private String spec;
   @ApiModelProperty(name = "quantity ", notes = "数量")
   @NotNull(message = "数量不能为空")
   private Integer quantity;
   @ApiModelProperty(name = "length", notes = "长度")
   @NotNull(message = "长度不能为空")
   private BigDecimal length;
   @ApiModelProperty(name = "weight", notes = "重量")
   @NotNull(message = "重量不能为空")
   private BigDecimal weight;
   @ApiModelProperty(name = "colour", notes = "颜色")
   private String colour;
   @ApiModelProperty(name = "brand", notes = "品牌")
   private String brand;
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSubjectSerialNumber() {
      return this.subjectSerialNumber;
   }

   public Long getSubjectId() {
      return this.subjectId;
   }

   public String getSpec() {
      return this.spec;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWeight() {
      return this.weight;
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

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSubjectSerialNumber(final String subjectSerialNumber) {
      this.subjectSerialNumber = subjectSerialNumber;
   }

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
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

      if (!(o instanceof SectionSteelPurchaseApplyListDetailDTOParam)) {
         return false;
      }

      SectionSteelPurchaseApplyListDetailDTOParam other = (SectionSteelPurchaseApplyListDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$subjectId = this.getSubjectId();
            Object other$subjectId = other.getSubjectId();
            if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$subjectSerialNumber = this.getSubjectSerialNumber();
                  Object other$subjectSerialNumber = other.getSubjectSerialNumber();
                  if (this$subjectSerialNumber == null ? other$subjectSerialNumber == null : this$subjectSerialNumber.equals(other$subjectSerialNumber)) {
                     Object this$spec = this.getSpec();
                     Object other$spec = other.getSpec();
                     if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SectionSteelPurchaseApplyListDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $subjectSerialNumber = this.getSubjectSerialNumber();
      result = result * 59 + ($subjectSerialNumber == null ? 43 : $subjectSerialNumber.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
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
      return "SectionSteelPurchaseApplyListDetailDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", subjectSerialNumber="
         + this.getSubjectSerialNumber()
         + ", subjectId="
         + this.getSubjectId()
         + ", spec="
         + this.getSpec()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", weight="
         + this.getWeight()
         + ", colour="
         + this.getColour()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
