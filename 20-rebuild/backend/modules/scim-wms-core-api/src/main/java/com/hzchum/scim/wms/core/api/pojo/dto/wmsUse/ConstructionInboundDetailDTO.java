package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConstructionInboundDetailDTO {
   @ApiModelProperty(name = "id", value = "ID")
   private Long id;
   @ApiModelProperty(name = "purchaseDetailId", value = "采购详情表ID")
   private Long purchaseDetailId;
   @ApiModelProperty(name = "quantity", value = "收货数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "收货核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "actualReceivedMete", value = "实际收货量")
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量")
   private BigDecimal rejectActualReceivedMete;
   @ApiModelProperty(name = "rejectQuantity", value = "退货数量 ", notes = "退货数量")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "applicantId", value = "办理人")
   private NameInfo applicant;
   @ApiModelProperty(name = "applicantDate", value = "办理人日期")
   private LocalDateTime applicantDate;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;

   public static ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder builder() {
      return new ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public BigDecimal getRejectActualReceivedMete() {
      return this.rejectActualReceivedMete;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public NameInfo getApplicant() {
      return this.applicant;
   }

   public LocalDateTime getApplicantDate() {
      return this.applicantDate;
   }

   public String getUnit() {
      return this.unit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
   }

   public void setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
   }

   public void setApplicant(final NameInfo applicant) {
      this.applicant = applicant;
   }

   public void setApplicantDate(final LocalDateTime applicantDate) {
      this.applicantDate = applicantDate;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConstructionInboundDetailDTO)) {
         return false;
      }

      ConstructionInboundDetailDTO other = (ConstructionInboundDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseDetailId = this.getPurchaseDetailId();
         Object other$purchaseDetailId = other.getPurchaseDetailId();
         if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$actualReceivedMete = this.getActualReceivedMete();
                  Object other$actualReceivedMete = other.getActualReceivedMete();
                  if (this$actualReceivedMete == null ? other$actualReceivedMete == null : this$actualReceivedMete.equals(other$actualReceivedMete)) {
                     Object this$rejectActualReceivedMete = this.getRejectActualReceivedMete();
                     Object other$rejectActualReceivedMete = other.getRejectActualReceivedMete();
                     if (this$rejectActualReceivedMete == null
                        ? other$rejectActualReceivedMete == null
                        : this$rejectActualReceivedMete.equals(other$rejectActualReceivedMete)) {
                        Object this$rejectQuantity = this.getRejectQuantity();
                        Object other$rejectQuantity = other.getRejectQuantity();
                        if (this$rejectQuantity == null ? other$rejectQuantity == null : this$rejectQuantity.equals(other$rejectQuantity)) {
                           Object this$rejectMete = this.getRejectMete();
                           Object other$rejectMete = other.getRejectMete();
                           if (this$rejectMete == null ? other$rejectMete == null : this$rejectMete.equals(other$rejectMete)) {
                              Object this$applicant = this.getApplicant();
                              Object other$applicant = other.getApplicant();
                              if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                                 Object this$applicantDate = this.getApplicantDate();
                                 Object other$applicantDate = other.getApplicantDate();
                                 if (this$applicantDate == null ? other$applicantDate == null : this$applicantDate.equals(other$applicantDate)) {
                                    Object this$unit = this.getUnit();
                                    Object other$unit = other.getUnit();
                                    if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       return this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit);
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
      return other instanceof ConstructionInboundDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      result = result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $applicantDate = this.getApplicantDate();
      result = result * 59 + ($applicantDate == null ? 43 : $applicantDate.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ConstructionInboundDetailDTO(id="
         + this.getId()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", applicant="
         + this.getApplicant()
         + ", applicantDate="
         + this.getApplicantDate()
         + ", unit="
         + this.getUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public ConstructionInboundDetailDTO(
      final Long id,
      final Long purchaseDetailId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal actualReceivedMete,
      final BigDecimal rejectActualReceivedMete,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final NameInfo applicant,
      final LocalDateTime applicantDate,
      final String unit,
      final String accountingUnit
   ) {
      this.id = id;
      this.purchaseDetailId = purchaseDetailId;
      this.quantity = quantity;
      this.mete = mete;
      this.actualReceivedMete = actualReceivedMete;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.applicant = applicant;
      this.applicantDate = applicantDate;
      this.unit = unit;
      this.accountingUnit = accountingUnit;
   }

   public ConstructionInboundDetailDTO() {
   }

   public static class ConstructionInboundDetailDTOBuilder {
      private Long id;
      private Long purchaseDetailId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal actualReceivedMete;
      private BigDecimal rejectActualReceivedMete;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private NameInfo applicant;
      private LocalDateTime applicantDate;
      private String unit;
      private String accountingUnit;

      ConstructionInboundDetailDTOBuilder() {
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder purchaseDetailId(final Long purchaseDetailId) {
         this.purchaseDetailId = purchaseDetailId;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder applicant(final NameInfo applicant) {
         this.applicant = applicant;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder applicantDate(final LocalDateTime applicantDate) {
         this.applicantDate = applicantDate;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ConstructionInboundDetailDTO build() {
         return new ConstructionInboundDetailDTO(
            this.id,
            this.purchaseDetailId,
            this.quantity,
            this.mete,
            this.actualReceivedMete,
            this.rejectActualReceivedMete,
            this.rejectQuantity,
            this.rejectMete,
            this.applicant,
            this.applicantDate,
            this.unit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ConstructionInboundDetailDTO.ConstructionInboundDetailDTOBuilder(id="
            + this.id
            + ", purchaseDetailId="
            + this.purchaseDetailId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", applicant="
            + this.applicant
            + ", applicantDate="
            + this.applicantDate
            + ", unit="
            + this.unit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
