package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.PlanOperationTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("库存利用单DTO类")
public class PlanWmsInventoryDTO {
   @NotNull(message = "物料仓id不能为空")
   @ApiModelProperty("物料仓id")
   private Long id;
   @NotNull(message = "科目id不能为空")
   @ApiModelProperty("科目id")
   private Long classifyId;
   @NotNull(message = "物料基础类型不能为空")
   @ApiModelProperty("物料基础类型")
   @EnumValidator(value = PlanOperationTypeEnum.class, message = "物料基础类型错误")
   private Integer basicClass;
   @Min(1L)
   @NotNull(message = "利用数量不能为空")
   @ApiModelProperty(name = "usedQuantity", value = "利用数量")
   private BigDecimal usedQuantity;
   @Min(1L)
   @NotNull(message = "利用量不能为空")
   @ApiModelProperty(name = "usedQuantity", value = "利用量")
   private BigDecimal usedMete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;

   public static PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder builder() {
      return new PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getUsedQuantity() {
      return this.usedQuantity;
   }

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setUsedQuantity(final BigDecimal usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanWmsInventoryDTO)) {
         return false;
      }

      PlanWmsInventoryDTO other = (PlanWmsInventoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$accountingPrecision = this.getAccountingPrecision();
               Object other$accountingPrecision = other.getAccountingPrecision();
               if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                  Object this$measurePrecision = this.getMeasurePrecision();
                  Object other$measurePrecision = other.getMeasurePrecision();
                  if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                     Object this$usedQuantity = this.getUsedQuantity();
                     Object other$usedQuantity = other.getUsedQuantity();
                     if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                        Object this$usedMete = this.getUsedMete();
                        Object other$usedMete = other.getUsedMete();
                        if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                           Object this$accountingUnit = this.getAccountingUnit();
                           Object other$accountingUnit = other.getAccountingUnit();
                           if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                              Object this$measureUnit = this.getMeasureUnit();
                              Object other$measureUnit = other.getMeasureUnit();
                              if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                 Object this$unitNet = this.getUnitNet();
                                 Object other$unitNet = other.getUnitNet();
                                 if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    return this$brand == null ? other$brand == null : this$brand.equals(other$brand);
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
      return other instanceof PlanWmsInventoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      return result * 59 + ($brand == null ? 43 : $brand.hashCode());
   }

   @Override
   public String toString() {
      return "PlanWmsInventoryDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", usedMete="
         + this.getUsedMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ")";
   }

   public PlanWmsInventoryDTO() {
   }

   public PlanWmsInventoryDTO(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final BigDecimal usedQuantity,
      final BigDecimal usedMete,
      final String accountingUnit,
      final Integer accountingPrecision,
      final String measureUnit,
      final Integer measurePrecision,
      final BigDecimal unitNet,
      final String brand
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.usedQuantity = usedQuantity;
      this.usedMete = usedMete;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.unitNet = unitNet;
      this.brand = brand;
   }

   public static class PlanWmsInventoryDTOBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private BigDecimal usedQuantity;
      private BigDecimal usedMete;
      private String accountingUnit;
      private Integer accountingPrecision;
      private String measureUnit;
      private Integer measurePrecision;
      private BigDecimal unitNet;
      private String brand;

      PlanWmsInventoryDTOBuilder() {
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder usedQuantity(final BigDecimal usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public PlanWmsInventoryDTO build() {
         return new PlanWmsInventoryDTO(
            this.id,
            this.classifyId,
            this.basicClass,
            this.usedQuantity,
            this.usedMete,
            this.accountingUnit,
            this.accountingPrecision,
            this.measureUnit,
            this.measurePrecision,
            this.unitNet,
            this.brand
         );
      }

      @Override
      public String toString() {
         return "PlanWmsInventoryDTO.PlanWmsInventoryDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", usedQuantity="
            + this.usedQuantity
            + ", usedMete="
            + this.usedMete
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ")";
      }
   }
}
