package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BatchSchedulingOutboundDTOParam {
   private Long projectId;
   private Long recipientId;
   private String recipientName;
   private Boolean boolCross;
   private Boolean boolPartyA;
   private LocalDateTime outboundTime;
   private List<BatchSchedulingOutboundDetailDTOParam> list;
   private Integer outboundTypeSelection;
   private Boolean boolSubmitCheck;
   private Long branchCompanyId;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private Long purchaseId;
   private Integer outboundAddress;

   public static BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder builder() {
      return new BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public List<BatchSchedulingOutboundDetailDTOParam> getList() {
      return this.list;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Boolean getBoolSubmitCheck() {
      return this.boolSubmitCheck;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setList(final List<BatchSchedulingOutboundDetailDTOParam> list) {
      this.list = list;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setBoolSubmitCheck(final Boolean boolSubmitCheck) {
      this.boolSubmitCheck = boolSubmitCheck;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchSchedulingOutboundDTOParam)) {
         return false;
      }

      BatchSchedulingOutboundDTOParam other = (BatchSchedulingOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$recipientId = this.getRecipientId();
         Object other$recipientId = other.getRecipientId();
         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
            Object this$boolCross = this.getBoolCross();
            Object other$boolCross = other.getBoolCross();
            if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                  Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                  if (this$outboundTypeSelection == null ? other$outboundTypeSelection == null : this$outboundTypeSelection.equals(other$outboundTypeSelection)
                     )
                   {
                     Object this$boolSubmitCheck = this.getBoolSubmitCheck();
                     Object other$boolSubmitCheck = other.getBoolSubmitCheck();
                     if (this$boolSubmitCheck == null ? other$boolSubmitCheck == null : this$boolSubmitCheck.equals(other$boolSubmitCheck)) {
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                           Object this$invoiceType = this.getInvoiceType();
                           Object other$invoiceType = other.getInvoiceType();
                           if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                              Object this$purchaseId = this.getPurchaseId();
                              Object other$purchaseId = other.getPurchaseId();
                              if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                                 Object this$outboundAddress = this.getOutboundAddress();
                                 Object other$outboundAddress = other.getOutboundAddress();
                                 if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                                    Object this$recipientName = this.getRecipientName();
                                    Object other$recipientName = other.getRecipientName();
                                    if (this$recipientName == null ? other$recipientName == null : this$recipientName.equals(other$recipientName)) {
                                       Object this$outboundTime = this.getOutboundTime();
                                       Object other$outboundTime = other.getOutboundTime();
                                       if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                          Object this$list = this.getList();
                                          Object other$list = other.getList();
                                          if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                             Object this$taxRate = this.getTaxRate();
                                             Object other$taxRate = other.getTaxRate();
                                             return this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate);
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
      return other instanceof BatchSchedulingOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolSubmitCheck = this.getBoolSubmitCheck();
      result = result * 59 + ($boolSubmitCheck == null ? 43 : $boolSubmitCheck.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "BatchSchedulingOutboundDTOParam(projectId="
         + this.getProjectId()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", boolCross="
         + this.getBoolCross()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", list="
         + this.getList()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", boolSubmitCheck="
         + this.getBoolSubmitCheck()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ")";
   }

   public BatchSchedulingOutboundDTOParam(
      final Long projectId,
      final Long recipientId,
      final String recipientName,
      final Boolean boolCross,
      final Boolean boolPartyA,
      final LocalDateTime outboundTime,
      final List<BatchSchedulingOutboundDetailDTOParam> list,
      final Integer outboundTypeSelection,
      final Boolean boolSubmitCheck,
      final Long branchCompanyId,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Long purchaseId,
      final Integer outboundAddress
   ) {
      this.projectId = projectId;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.boolCross = boolCross;
      this.boolPartyA = boolPartyA;
      this.outboundTime = outboundTime;
      this.list = list;
      this.outboundTypeSelection = outboundTypeSelection;
      this.boolSubmitCheck = boolSubmitCheck;
      this.branchCompanyId = branchCompanyId;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.purchaseId = purchaseId;
      this.outboundAddress = outboundAddress;
   }

   public BatchSchedulingOutboundDTOParam() {
   }

   public static class BatchSchedulingOutboundDTOParamBuilder {
      private Long projectId;
      private Long recipientId;
      private String recipientName;
      private Boolean boolCross;
      private Boolean boolPartyA;
      private LocalDateTime outboundTime;
      private List<BatchSchedulingOutboundDetailDTOParam> list;
      private Integer outboundTypeSelection;
      private Boolean boolSubmitCheck;
      private Long branchCompanyId;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Long purchaseId;
      private Integer outboundAddress;

      BatchSchedulingOutboundDTOParamBuilder() {
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder list(final List<BatchSchedulingOutboundDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder boolSubmitCheck(final Boolean boolSubmitCheck) {
         this.boolSubmitCheck = boolSubmitCheck;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public BatchSchedulingOutboundDTOParam build() {
         return new BatchSchedulingOutboundDTOParam(
            this.projectId,
            this.recipientId,
            this.recipientName,
            this.boolCross,
            this.boolPartyA,
            this.outboundTime,
            this.list,
            this.outboundTypeSelection,
            this.boolSubmitCheck,
            this.branchCompanyId,
            this.invoiceType,
            this.taxRate,
            this.purchaseId,
            this.outboundAddress
         );
      }

      @Override
      public String toString() {
         return "BatchSchedulingOutboundDTOParam.BatchSchedulingOutboundDTOParamBuilder(projectId="
            + this.projectId
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", boolCross="
            + this.boolCross
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundTime="
            + this.outboundTime
            + ", list="
            + this.list
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", boolSubmitCheck="
            + this.boolSubmitCheck
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", purchaseId="
            + this.purchaseId
            + ", outboundAddress="
            + this.outboundAddress
            + ")";
      }
   }
}
