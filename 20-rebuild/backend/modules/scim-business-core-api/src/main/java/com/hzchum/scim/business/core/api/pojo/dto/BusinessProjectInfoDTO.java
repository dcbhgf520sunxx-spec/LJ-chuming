package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BusinessProjectInfoDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "signer_id", notes = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signer_name", notes = "签约人姓名")
   private String signerName;
   @ApiModelProperty(name = "signing_date", notes = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "status", notes = "项目状态  1：进行中，2：已暂停，4：已完工 ")
   private Integer status;
   @ApiModelProperty(name = "settlement_status", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", notes = "结算额(元)")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "shipAmount", notes = "累计发运额(元)")
   private BigDecimal shipAmount;
   @ApiModelProperty(name = "collectionAmount", notes = "累计收款额(元)")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "invoiceAmount", notes = "累计开票额(元)")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "lastMonthShipAmount", notes = "上月发运额(元)")
   private BigDecimal lastMonthShipAmount;
   @ApiModelProperty(name = "lastMonthCollectionAmount", notes = "上月收款额(元)")
   private BigDecimal lastMonthCollectionAmount;
   @ApiModelProperty(name = "lastMonthInvoiceAmount", notes = "上月开票额(元)")
   private BigDecimal lastMonthInvoiceAmount;
   @ApiModelProperty(name = "thisMonthShipAmount", notes = "本月发运额(元)")
   private BigDecimal thisMonthShipAmount;
   @ApiModelProperty(name = "thisMonthCollectionAmount", notes = "本月收款额(元)")
   private BigDecimal thisMonthCollectionAmount;
   @ApiModelProperty(name = "thisMonthInvoiceAmount", notes = "本月开票额(元)")
   private BigDecimal thisMonthInvoiceAmount;

   public static BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder builder() {
      return new BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder();
   }

   public BusinessProjectInfoDTO(
      final Long id,
      final String name,
      final String shortName,
      final String serialNumber,
      final Long signerId,
      final String signerName,
      final LocalDate signingDate,
      final Integer status,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal shipAmount,
      final BigDecimal collectionAmount,
      final BigDecimal invoiceAmount,
      final BigDecimal lastMonthShipAmount,
      final BigDecimal lastMonthCollectionAmount,
      final BigDecimal lastMonthInvoiceAmount,
      final BigDecimal thisMonthShipAmount,
      final BigDecimal thisMonthCollectionAmount,
      final BigDecimal thisMonthInvoiceAmount
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.signerId = signerId;
      this.signerName = signerName;
      this.signingDate = signingDate;
      this.status = status;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.shipAmount = shipAmount;
      this.collectionAmount = collectionAmount;
      this.invoiceAmount = invoiceAmount;
      this.lastMonthShipAmount = lastMonthShipAmount;
      this.lastMonthCollectionAmount = lastMonthCollectionAmount;
      this.lastMonthInvoiceAmount = lastMonthInvoiceAmount;
      this.thisMonthShipAmount = thisMonthShipAmount;
      this.thisMonthCollectionAmount = thisMonthCollectionAmount;
      this.thisMonthInvoiceAmount = thisMonthInvoiceAmount;
   }

   public BusinessProjectInfoDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getShipAmount() {
      return this.shipAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getLastMonthShipAmount() {
      return this.lastMonthShipAmount;
   }

   public BigDecimal getLastMonthCollectionAmount() {
      return this.lastMonthCollectionAmount;
   }

   public BigDecimal getLastMonthInvoiceAmount() {
      return this.lastMonthInvoiceAmount;
   }

   public BigDecimal getThisMonthShipAmount() {
      return this.thisMonthShipAmount;
   }

   public BigDecimal getThisMonthCollectionAmount() {
      return this.thisMonthCollectionAmount;
   }

   public BigDecimal getThisMonthInvoiceAmount() {
      return this.thisMonthInvoiceAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setShipAmount(final BigDecimal shipAmount) {
      this.shipAmount = shipAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setLastMonthShipAmount(final BigDecimal lastMonthShipAmount) {
      this.lastMonthShipAmount = lastMonthShipAmount;
   }

   public void setLastMonthCollectionAmount(final BigDecimal lastMonthCollectionAmount) {
      this.lastMonthCollectionAmount = lastMonthCollectionAmount;
   }

   public void setLastMonthInvoiceAmount(final BigDecimal lastMonthInvoiceAmount) {
      this.lastMonthInvoiceAmount = lastMonthInvoiceAmount;
   }

   public void setThisMonthShipAmount(final BigDecimal thisMonthShipAmount) {
      this.thisMonthShipAmount = thisMonthShipAmount;
   }

   public void setThisMonthCollectionAmount(final BigDecimal thisMonthCollectionAmount) {
      this.thisMonthCollectionAmount = thisMonthCollectionAmount;
   }

   public void setThisMonthInvoiceAmount(final BigDecimal thisMonthInvoiceAmount) {
      this.thisMonthInvoiceAmount = thisMonthInvoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessProjectInfoDTO)) {
         return false;
      }

      BusinessProjectInfoDTO other = (BusinessProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$signerId = this.getSignerId();
         Object other$signerId = other.getSignerId();
         if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$settlementStatus = this.getSettlementStatus();
               Object other$settlementStatus = other.getSettlementStatus();
               if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$signerName = this.getSignerName();
                           Object other$signerName = other.getSignerName();
                           if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                              Object this$signingDate = this.getSigningDate();
                              Object other$signingDate = other.getSigningDate();
                              if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                                 Object this$settlementAmount = this.getSettlementAmount();
                                 Object other$settlementAmount = other.getSettlementAmount();
                                 if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                                    Object this$shipAmount = this.getShipAmount();
                                    Object other$shipAmount = other.getShipAmount();
                                    if (this$shipAmount == null ? other$shipAmount == null : this$shipAmount.equals(other$shipAmount)) {
                                       Object this$collectionAmount = this.getCollectionAmount();
                                       Object other$collectionAmount = other.getCollectionAmount();
                                       if (this$collectionAmount == null
                                          ? other$collectionAmount == null
                                          : this$collectionAmount.equals(other$collectionAmount)) {
                                          Object this$invoiceAmount = this.getInvoiceAmount();
                                          Object other$invoiceAmount = other.getInvoiceAmount();
                                          if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                             Object this$lastMonthShipAmount = this.getLastMonthShipAmount();
                                             Object other$lastMonthShipAmount = other.getLastMonthShipAmount();
                                             if (this$lastMonthShipAmount == null
                                                ? other$lastMonthShipAmount == null
                                                : this$lastMonthShipAmount.equals(other$lastMonthShipAmount)) {
                                                Object this$lastMonthCollectionAmount = this.getLastMonthCollectionAmount();
                                                Object other$lastMonthCollectionAmount = other.getLastMonthCollectionAmount();
                                                if (this$lastMonthCollectionAmount == null
                                                   ? other$lastMonthCollectionAmount == null
                                                   : this$lastMonthCollectionAmount.equals(other$lastMonthCollectionAmount)) {
                                                   Object this$lastMonthInvoiceAmount = this.getLastMonthInvoiceAmount();
                                                   Object other$lastMonthInvoiceAmount = other.getLastMonthInvoiceAmount();
                                                   if (this$lastMonthInvoiceAmount == null
                                                      ? other$lastMonthInvoiceAmount == null
                                                      : this$lastMonthInvoiceAmount.equals(other$lastMonthInvoiceAmount)) {
                                                      Object this$thisMonthShipAmount = this.getThisMonthShipAmount();
                                                      Object other$thisMonthShipAmount = other.getThisMonthShipAmount();
                                                      if (this$thisMonthShipAmount == null
                                                         ? other$thisMonthShipAmount == null
                                                         : this$thisMonthShipAmount.equals(other$thisMonthShipAmount)) {
                                                         Object this$thisMonthCollectionAmount = this.getThisMonthCollectionAmount();
                                                         Object other$thisMonthCollectionAmount = other.getThisMonthCollectionAmount();
                                                         if (this$thisMonthCollectionAmount == null
                                                            ? other$thisMonthCollectionAmount == null
                                                            : this$thisMonthCollectionAmount.equals(other$thisMonthCollectionAmount)) {
                                                            Object this$thisMonthInvoiceAmount = this.getThisMonthInvoiceAmount();
                                                            Object other$thisMonthInvoiceAmount = other.getThisMonthInvoiceAmount();
                                                            return this$thisMonthInvoiceAmount == null
                                                               ? other$thisMonthInvoiceAmount == null
                                                               : this$thisMonthInvoiceAmount.equals(other$thisMonthInvoiceAmount);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $shipAmount = this.getShipAmount();
      result = result * 59 + ($shipAmount == null ? 43 : $shipAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $lastMonthShipAmount = this.getLastMonthShipAmount();
      result = result * 59 + ($lastMonthShipAmount == null ? 43 : $lastMonthShipAmount.hashCode());
      Object $lastMonthCollectionAmount = this.getLastMonthCollectionAmount();
      result = result * 59 + ($lastMonthCollectionAmount == null ? 43 : $lastMonthCollectionAmount.hashCode());
      Object $lastMonthInvoiceAmount = this.getLastMonthInvoiceAmount();
      result = result * 59 + ($lastMonthInvoiceAmount == null ? 43 : $lastMonthInvoiceAmount.hashCode());
      Object $thisMonthShipAmount = this.getThisMonthShipAmount();
      result = result * 59 + ($thisMonthShipAmount == null ? 43 : $thisMonthShipAmount.hashCode());
      Object $thisMonthCollectionAmount = this.getThisMonthCollectionAmount();
      result = result * 59 + ($thisMonthCollectionAmount == null ? 43 : $thisMonthCollectionAmount.hashCode());
      Object $thisMonthInvoiceAmount = this.getThisMonthInvoiceAmount();
      return result * 59 + ($thisMonthInvoiceAmount == null ? 43 : $thisMonthInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessProjectInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", signingDate="
         + this.getSigningDate()
         + ", status="
         + this.getStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", shipAmount="
         + this.getShipAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", lastMonthShipAmount="
         + this.getLastMonthShipAmount()
         + ", lastMonthCollectionAmount="
         + this.getLastMonthCollectionAmount()
         + ", lastMonthInvoiceAmount="
         + this.getLastMonthInvoiceAmount()
         + ", thisMonthShipAmount="
         + this.getThisMonthShipAmount()
         + ", thisMonthCollectionAmount="
         + this.getThisMonthCollectionAmount()
         + ", thisMonthInvoiceAmount="
         + this.getThisMonthInvoiceAmount()
         + ")";
   }

   public static class BusinessProjectInfoDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private Long signerId;
      private String signerName;
      private LocalDate signingDate;
      private Integer status;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal shipAmount;
      private BigDecimal collectionAmount;
      private BigDecimal invoiceAmount;
      private BigDecimal lastMonthShipAmount;
      private BigDecimal lastMonthCollectionAmount;
      private BigDecimal lastMonthInvoiceAmount;
      private BigDecimal thisMonthShipAmount;
      private BigDecimal thisMonthCollectionAmount;
      private BigDecimal thisMonthInvoiceAmount;

      BusinessProjectInfoDTOBuilder() {
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder shipAmount(final BigDecimal shipAmount) {
         this.shipAmount = shipAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder lastMonthShipAmount(final BigDecimal lastMonthShipAmount) {
         this.lastMonthShipAmount = lastMonthShipAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder lastMonthCollectionAmount(final BigDecimal lastMonthCollectionAmount) {
         this.lastMonthCollectionAmount = lastMonthCollectionAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder lastMonthInvoiceAmount(final BigDecimal lastMonthInvoiceAmount) {
         this.lastMonthInvoiceAmount = lastMonthInvoiceAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder thisMonthShipAmount(final BigDecimal thisMonthShipAmount) {
         this.thisMonthShipAmount = thisMonthShipAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder thisMonthCollectionAmount(final BigDecimal thisMonthCollectionAmount) {
         this.thisMonthCollectionAmount = thisMonthCollectionAmount;
         return this;
      }

      public BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder thisMonthInvoiceAmount(final BigDecimal thisMonthInvoiceAmount) {
         this.thisMonthInvoiceAmount = thisMonthInvoiceAmount;
         return this;
      }

      public BusinessProjectInfoDTO build() {
         return new BusinessProjectInfoDTO(
            this.id,
            this.name,
            this.shortName,
            this.serialNumber,
            this.signerId,
            this.signerName,
            this.signingDate,
            this.status,
            this.settlementStatus,
            this.settlementAmount,
            this.shipAmount,
            this.collectionAmount,
            this.invoiceAmount,
            this.lastMonthShipAmount,
            this.lastMonthCollectionAmount,
            this.lastMonthInvoiceAmount,
            this.thisMonthShipAmount,
            this.thisMonthCollectionAmount,
            this.thisMonthInvoiceAmount
         );
      }

      @Override
      public String toString() {
         return "BusinessProjectInfoDTO.BusinessProjectInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", signingDate="
            + this.signingDate
            + ", status="
            + this.status
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", shipAmount="
            + this.shipAmount
            + ", collectionAmount="
            + this.collectionAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", lastMonthShipAmount="
            + this.lastMonthShipAmount
            + ", lastMonthCollectionAmount="
            + this.lastMonthCollectionAmount
            + ", lastMonthInvoiceAmount="
            + this.lastMonthInvoiceAmount
            + ", thisMonthShipAmount="
            + this.thisMonthShipAmount
            + ", thisMonthCollectionAmount="
            + this.thisMonthCollectionAmount
            + ", thisMonthInvoiceAmount="
            + this.thisMonthInvoiceAmount
            + ")";
      }
   }
}
