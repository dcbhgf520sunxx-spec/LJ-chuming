package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.PlanOperationTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("备料需采购DTO类")
public class PlanStockPurchaseDTO {
   @NotNull(message = "科目id不能为空")
   @ApiModelProperty("科目id")
   private Long classifyId;
   @NotNull(message = "物料基础类型不能为空")
   @ApiModelProperty("物料基础类型")
   @EnumValidator(value = PlanOperationTypeEnum.class, message = "物料基础类型错误")
   private Integer basicClass;
   @NotBlank(message = "规格/材质不能为空")
   @ApiModelProperty("规格")
   private String specification;
   @NotBlank(message = "编号不能为空")
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   private BigDecimal width;
   @Min(1L)
   @NotNull(message = "数量不能为空")
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @Min(1L)
   @NotNull(message = "核算量不能为空")
   @ApiModelProperty(name = "mete", value = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "specKV", value = "规格/材质Map")
   private Map<String, String> specKV;
   @ApiModelProperty(name = "specKV", value = "规格/材质Map")
   private Map<String, String> specNameKV;

   public static PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder builder() {
      return new PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder();
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getBrand() {
      return this.brand;
   }

   public Map<String, String> getSpecKV() {
      return this.specKV;
   }

   public Map<String, String> getSpecNameKV() {
      return this.specNameKV;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setSpecKV(final Map<String, String> specKV) {
      this.specKV = specKV;
   }

   public void setSpecNameKV(final Map<String, String> specNameKV) {
      this.specNameKV = specNameKV;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanStockPurchaseDTO)) {
         return false;
      }

      PlanStockPurchaseDTO other = (PlanStockPurchaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$measurePrecision = this.getMeasurePrecision();
            Object other$measurePrecision = other.getMeasurePrecision();
            if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
               Object this$accountingPrecision = this.getAccountingPrecision();
               Object other$accountingPrecision = other.getAccountingPrecision();
               if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$measureUnit = this.getMeasureUnit();
                        Object other$measureUnit = other.getMeasureUnit();
                        if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                           Object this$accountingUnit = this.getAccountingUnit();
                           Object other$accountingUnit = other.getAccountingUnit();
                           if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$unitNet = this.getUnitNet();
                                             Object other$unitNet = other.getUnitNet();
                                             if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$specKV = this.getSpecKV();
                                                   Object other$specKV = other.getSpecKV();
                                                   if (this$specKV == null ? other$specKV == null : this$specKV.equals(other$specKV)) {
                                                      Object this$specNameKV = this.getSpecNameKV();
                                                      Object other$specNameKV = other.getSpecNameKV();
                                                      return this$specNameKV == null ? other$specNameKV == null : this$specNameKV.equals(other$specNameKV);
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
      return other instanceof PlanStockPurchaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specKV = this.getSpecKV();
      result = result * 59 + ($specKV == null ? 43 : $specKV.hashCode());
      Object $specNameKV = this.getSpecNameKV();
      return result * 59 + ($specNameKV == null ? 43 : $specNameKV.hashCode());
   }

   @Override
   public String toString() {
      return "PlanStockPurchaseDTO(classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ", specKV="
         + this.getSpecKV()
         + ", specNameKV="
         + this.getSpecNameKV()
         + ")";
   }

   public PlanStockPurchaseDTO() {
   }

   public PlanStockPurchaseDTO(
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final String serialNumber,
      final String measureUnit,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final String accountingUnit,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final String brand,
      final Map<String, String> specKV,
      final Map<String, String> specNameKV
   ) {
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.serialNumber = serialNumber;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.quantity = quantity;
      this.mete = mete;
      this.unitNet = unitNet;
      this.brand = brand;
      this.specKV = specKV;
      this.specNameKV = specNameKV;
   }

   public static class PlanStockPurchaseDTOBuilder {
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private String serialNumber;
      private String measureUnit;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private String accountingUnit;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private String brand;
      private Map<String, String> specKV;
      private Map<String, String> specNameKV;

      PlanStockPurchaseDTOBuilder() {
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder specKV(final Map<String, String> specKV) {
         this.specKV = specKV;
         return this;
      }

      public PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder specNameKV(final Map<String, String> specNameKV) {
         this.specNameKV = specNameKV;
         return this;
      }

      public PlanStockPurchaseDTO build() {
         return new PlanStockPurchaseDTO(
            this.classifyId,
            this.basicClass,
            this.specification,
            this.serialNumber,
            this.measureUnit,
            this.measurePrecision,
            this.accountingPrecision,
            this.accountingUnit,
            this.length,
            this.thickness,
            this.width,
            this.quantity,
            this.mete,
            this.unitNet,
            this.brand,
            this.specKV,
            this.specNameKV
         );
      }

      @Override
      public String toString() {
         return "PlanStockPurchaseDTO.PlanStockPurchaseDTOBuilder(classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", serialNumber="
            + this.serialNumber
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ", specKV="
            + this.specKV
            + ", specNameKV="
            + this.specNameKV
            + ")";
      }
   }
}
