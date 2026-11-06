package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class CrmHeadFillOutDetail {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目信息id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "businessProjectBidManagerQuote", value = "商务投标报价", notes = "商务投标报价")
   private BigDecimal businessProjectBidManagerQuote;
   @ApiModelProperty(name = "businessProjectBidManagerEstimatedWorks", value = "商务工程量", notes = "商务工程量")
   private BigDecimal businessProjectBidManagerEstimatedWorks;
   @ApiModelProperty(name = "businessProjectBidManagerCost", value = "商务成本", notes = "商务成本")
   private BigDecimal businessProjectBidManagerCost;
   @ApiModelProperty(name = "businessProjectBidManagerGrossProfit", value = "商务毛利", notes = "商务毛利")
   private BigDecimal businessProjectBidManagerGrossProfit;
   @ApiModelProperty(name = "businessProjectBidManagerRemark", value = "商务投标备注", notes = "商务投标备注")
   private String businessProjectBidManagerRemark;
   @ApiModelProperty(name = "bidManagerAttachments", value = "投标附件", notes = "投标附件")
   private List<AttachmentDTO> bidManagerAttachments;

   public static CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder builder() {
      return new CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder();
   }

   public CrmHeadFillOutDetail() {
   }

   public CrmHeadFillOutDetail(
      final Long crmProjectInformationWarehousingId,
      final BigDecimal businessProjectBidManagerQuote,
      final BigDecimal businessProjectBidManagerEstimatedWorks,
      final BigDecimal businessProjectBidManagerCost,
      final BigDecimal businessProjectBidManagerGrossProfit,
      final String businessProjectBidManagerRemark,
      final List<AttachmentDTO> bidManagerAttachments
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      this.bidManagerAttachments = bidManagerAttachments;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public BigDecimal getBusinessProjectBidManagerQuote() {
      return this.businessProjectBidManagerQuote;
   }

   public BigDecimal getBusinessProjectBidManagerEstimatedWorks() {
      return this.businessProjectBidManagerEstimatedWorks;
   }

   public BigDecimal getBusinessProjectBidManagerCost() {
      return this.businessProjectBidManagerCost;
   }

   public BigDecimal getBusinessProjectBidManagerGrossProfit() {
      return this.businessProjectBidManagerGrossProfit;
   }

   public String getBusinessProjectBidManagerRemark() {
      return this.businessProjectBidManagerRemark;
   }

   public List<AttachmentDTO> getBidManagerAttachments() {
      return this.bidManagerAttachments;
   }

   public CrmHeadFillOutDetail setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmHeadFillOutDetail setBusinessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      return this;
   }

   public CrmHeadFillOutDetail setBusinessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      return this;
   }

   public CrmHeadFillOutDetail setBusinessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      return this;
   }

   public CrmHeadFillOutDetail setBusinessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      return this;
   }

   public CrmHeadFillOutDetail setBusinessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      return this;
   }

   public CrmHeadFillOutDetail setBidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
      this.bidManagerAttachments = bidManagerAttachments;
      return this;
   }

   @Override
   public String toString() {
      return "CrmHeadFillOutDetail(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", businessProjectBidManagerQuote="
         + this.getBusinessProjectBidManagerQuote()
         + ", businessProjectBidManagerEstimatedWorks="
         + this.getBusinessProjectBidManagerEstimatedWorks()
         + ", businessProjectBidManagerCost="
         + this.getBusinessProjectBidManagerCost()
         + ", businessProjectBidManagerGrossProfit="
         + this.getBusinessProjectBidManagerGrossProfit()
         + ", businessProjectBidManagerRemark="
         + this.getBusinessProjectBidManagerRemark()
         + ", bidManagerAttachments="
         + this.getBidManagerAttachments()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmHeadFillOutDetail)) {
         return false;
      }

      CrmHeadFillOutDetail other = (CrmHeadFillOutDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
         Object other$businessProjectBidManagerQuote = other.getBusinessProjectBidManagerQuote();
         if (this$businessProjectBidManagerQuote == null
            ? other$businessProjectBidManagerQuote == null
            : this$businessProjectBidManagerQuote.equals(other$businessProjectBidManagerQuote)) {
            Object this$businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
            Object other$businessProjectBidManagerEstimatedWorks = other.getBusinessProjectBidManagerEstimatedWorks();
            if (this$businessProjectBidManagerEstimatedWorks == null
               ? other$businessProjectBidManagerEstimatedWorks == null
               : this$businessProjectBidManagerEstimatedWorks.equals(other$businessProjectBidManagerEstimatedWorks)) {
               Object this$businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
               Object other$businessProjectBidManagerCost = other.getBusinessProjectBidManagerCost();
               if (this$businessProjectBidManagerCost == null
                  ? other$businessProjectBidManagerCost == null
                  : this$businessProjectBidManagerCost.equals(other$businessProjectBidManagerCost)) {
                  Object this$businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
                  Object other$businessProjectBidManagerGrossProfit = other.getBusinessProjectBidManagerGrossProfit();
                  if (this$businessProjectBidManagerGrossProfit == null
                     ? other$businessProjectBidManagerGrossProfit == null
                     : this$businessProjectBidManagerGrossProfit.equals(other$businessProjectBidManagerGrossProfit)) {
                     Object this$businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
                     Object other$businessProjectBidManagerRemark = other.getBusinessProjectBidManagerRemark();
                     if (this$businessProjectBidManagerRemark == null
                        ? other$businessProjectBidManagerRemark == null
                        : this$businessProjectBidManagerRemark.equals(other$businessProjectBidManagerRemark)) {
                        Object this$bidManagerAttachments = this.getBidManagerAttachments();
                        Object other$bidManagerAttachments = other.getBidManagerAttachments();
                        return this$bidManagerAttachments == null
                           ? other$bidManagerAttachments == null
                           : this$bidManagerAttachments.equals(other$bidManagerAttachments);
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
      return other instanceof CrmHeadFillOutDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
      result = result * 59 + ($businessProjectBidManagerQuote == null ? 43 : $businessProjectBidManagerQuote.hashCode());
      Object $businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
      result = result * 59 + ($businessProjectBidManagerEstimatedWorks == null ? 43 : $businessProjectBidManagerEstimatedWorks.hashCode());
      Object $businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
      result = result * 59 + ($businessProjectBidManagerCost == null ? 43 : $businessProjectBidManagerCost.hashCode());
      Object $businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
      result = result * 59 + ($businessProjectBidManagerGrossProfit == null ? 43 : $businessProjectBidManagerGrossProfit.hashCode());
      Object $businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
      result = result * 59 + ($businessProjectBidManagerRemark == null ? 43 : $businessProjectBidManagerRemark.hashCode());
      Object $bidManagerAttachments = this.getBidManagerAttachments();
      return result * 59 + ($bidManagerAttachments == null ? 43 : $bidManagerAttachments.hashCode());
   }

   public static class CrmHeadFillOutDetailBuilder {
      private Long crmProjectInformationWarehousingId;
      private BigDecimal businessProjectBidManagerQuote;
      private BigDecimal businessProjectBidManagerEstimatedWorks;
      private BigDecimal businessProjectBidManagerCost;
      private BigDecimal businessProjectBidManagerGrossProfit;
      private String businessProjectBidManagerRemark;
      private List<AttachmentDTO> bidManagerAttachments;

      CrmHeadFillOutDetailBuilder() {
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder businessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
         this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder businessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
         this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder businessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
         this.businessProjectBidManagerCost = businessProjectBidManagerCost;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder businessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
         this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder businessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
         this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
         return this;
      }

      public CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder bidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
         this.bidManagerAttachments = bidManagerAttachments;
         return this;
      }

      public CrmHeadFillOutDetail build() {
         return new CrmHeadFillOutDetail(
            this.crmProjectInformationWarehousingId,
            this.businessProjectBidManagerQuote,
            this.businessProjectBidManagerEstimatedWorks,
            this.businessProjectBidManagerCost,
            this.businessProjectBidManagerGrossProfit,
            this.businessProjectBidManagerRemark,
            this.bidManagerAttachments
         );
      }

      @Override
      public String toString() {
         return "CrmHeadFillOutDetail.CrmHeadFillOutDetailBuilder(crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", businessProjectBidManagerQuote="
            + this.businessProjectBidManagerQuote
            + ", businessProjectBidManagerEstimatedWorks="
            + this.businessProjectBidManagerEstimatedWorks
            + ", businessProjectBidManagerCost="
            + this.businessProjectBidManagerCost
            + ", businessProjectBidManagerGrossProfit="
            + this.businessProjectBidManagerGrossProfit
            + ", businessProjectBidManagerRemark="
            + this.businessProjectBidManagerRemark
            + ", bidManagerAttachments="
            + this.bidManagerAttachments
            + ")";
      }
   }
}
