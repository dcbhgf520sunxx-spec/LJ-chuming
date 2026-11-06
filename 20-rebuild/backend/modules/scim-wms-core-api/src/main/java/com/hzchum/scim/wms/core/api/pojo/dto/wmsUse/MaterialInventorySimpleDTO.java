package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MaterialInventorySimpleDTO {
   private Long id;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private String basicClassName;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal quantity;
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;
   @JsonInclude(Include.NON_NULL)
   private Integer accountingPrecision;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime createTime;
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   @JsonInclude(Include.NON_NULL)
   private Long index;

   public static MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder builder() {
      return new MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBasicClassName() {
      return this.basicClassName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getIndex() {
      return this.index;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("index")
   public void setIndex(final Long index) {
      this.index = index;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialInventorySimpleDTO)) {
         return false;
      }

      MaterialInventorySimpleDTO other = (MaterialInventorySimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$accountingPrecision = this.getAccountingPrecision();
               Object other$accountingPrecision = other.getAccountingPrecision();
               if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                  Object this$index = this.getIndex();
                  Object other$index = other.getIndex();
                  if (this$index == null ? other$index == null : this$index.equals(other$index)) {
                     Object this$basicClassName = this.getBasicClassName();
                     Object other$basicClassName = other.getBasicClassName();
                     if (this$basicClassName == null ? other$basicClassName == null : this$basicClassName.equals(other$basicClassName)) {
                        Object this$classifyName = this.getClassifyName();
                        Object other$classifyName = other.getClassifyName();
                        if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                    Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                    if (this$unitPriceExcludingVAT == null
                                       ? other$unitPriceExcludingVAT == null
                                       : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                       Object this$amount = this.getAmount();
                                       Object other$amount = other.getAmount();
                                       if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                          Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                          Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                          if (this$amountExcludingVAT == null
                                             ? other$amountExcludingVAT == null
                                             : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof MaterialInventorySimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialInventorySimpleDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", createTime="
         + this.getCreateTime()
         + ", index="
         + this.getIndex()
         + ")";
   }

   public MaterialInventorySimpleDTO(
      final Long id,
      final Integer basicClass,
      final String basicClassName,
      final Long classifyId,
      final String classifyName,
      final BigDecimal quantity,
      final String specification,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal mete,
      final String accountingUnit,
      final Integer accountingPrecision,
      final LocalDateTime createTime,
      final Long index
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.quantity = quantity;
      this.specification = specification;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.createTime = createTime;
      this.index = index;
   }

   public MaterialInventorySimpleDTO() {
   }

   public static class MaterialInventorySimpleDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String basicClassName;
      private Long classifyId;
      private String classifyName;
      private BigDecimal quantity;
      private String specification;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal mete;
      private String accountingUnit;
      private Integer accountingPrecision;
      private LocalDateTime createTime;
      private Long index;

      MaterialInventorySimpleDTOBuilder() {
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("index")
      public MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      public MaterialInventorySimpleDTO build() {
         return new MaterialInventorySimpleDTO(
            this.id,
            this.basicClass,
            this.basicClassName,
            this.classifyId,
            this.classifyName,
            this.quantity,
            this.specification,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.mete,
            this.accountingUnit,
            this.accountingPrecision,
            this.createTime,
            this.index
         );
      }

      @Override
      public String toString() {
         return "MaterialInventorySimpleDTO.MaterialInventorySimpleDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", basicClassName="
            + this.basicClassName
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", quantity="
            + this.quantity
            + ", specification="
            + this.specification
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", createTime="
            + this.createTime
            + ", index="
            + this.index
            + ")";
      }
   }
}
