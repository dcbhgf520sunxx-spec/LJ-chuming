package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("出库列表")
public class MoveOutboundDetailFinanceDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "出库数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "出库核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "amount", value = "总价")
   private BigDecimal amount;
   @ApiModelProperty(name = "unitPrice", value = "加权价(含税)")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outboundTime", value = "出库时间(可修改,默认生成时间)")
   private LocalDateTime outboundTime;

   public static MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder builder() {
      return new MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder();
   }

   public MoveOutboundDetailFinanceDTO() {
   }

   public MoveOutboundDetailFinanceDTO(
      final Long id,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final LocalDateTime outboundTime
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.outboundTime = outboundTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveOutboundDetailFinanceDTO)) {
         return false;
      }

      MoveOutboundDetailFinanceDTO other = (MoveOutboundDetailFinanceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$accountingUnit = this.getAccountingUnit();
                        Object other$accountingUnit = other.getAccountingUnit();
                        if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                           Object this$amount = this.getAmount();
                           Object other$amount = other.getAmount();
                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                              Object this$unitPrice = this.getUnitPrice();
                              Object other$unitPrice = other.getUnitPrice();
                              if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                 Object this$outboundTime = this.getOutboundTime();
                                 Object other$outboundTime = other.getOutboundTime();
                                 return this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime);
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
      return other instanceof MoveOutboundDetailFinanceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $outboundTime = this.getOutboundTime();
      return result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
   }

   @Override
   public String toString() {
      return "MoveOutboundDetailFinanceDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outboundTime="
         + this.getOutboundTime()
         + ")";
   }

   public static class MoveOutboundDetailFinanceDTOBuilder {
      private Long id;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private LocalDateTime outboundTime;

      MoveOutboundDetailFinanceDTOBuilder() {
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public MoveOutboundDetailFinanceDTO build() {
         return new MoveOutboundDetailFinanceDTO(
            this.id,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.amount,
            this.unitPrice,
            this.outboundTime
         );
      }

      @Override
      public String toString() {
         return "MoveOutboundDetailFinanceDTO.MoveOutboundDetailFinanceDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", outboundTime="
            + this.outboundTime
            + ")";
      }
   }
}
