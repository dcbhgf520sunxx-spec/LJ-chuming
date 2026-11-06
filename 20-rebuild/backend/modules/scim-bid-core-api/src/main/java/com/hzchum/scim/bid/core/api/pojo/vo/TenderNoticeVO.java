package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.Date;

public class TenderNoticeVO {
   private String title;
   private Date createDate;
   private String reasons;
   private String biddingName;
   private String projectName;
   private String contractNo;
   private String tenderContent;
   private String purchasing;
   private String qualificationsBidder;
   private String apply;
   private String cashDeposit;
   private String paymentMethod;
   private String quotationDelivery;
   private String contactWay;
   private String report;
   private Integer type;

   public static TenderNoticeVO.TenderNoticeVOBuilder builder() {
      return new TenderNoticeVO.TenderNoticeVOBuilder();
   }

   public TenderNoticeVO() {
   }

   public TenderNoticeVO(
      final String title,
      final Date createDate,
      final String reasons,
      final String biddingName,
      final String projectName,
      final String contractNo,
      final String tenderContent,
      final String purchasing,
      final String qualificationsBidder,
      final String apply,
      final String cashDeposit,
      final String paymentMethod,
      final String quotationDelivery,
      final String contactWay,
      final String report,
      final Integer type
   ) {
      this.title = title;
      this.createDate = createDate;
      this.reasons = reasons;
      this.biddingName = biddingName;
      this.projectName = projectName;
      this.contractNo = contractNo;
      this.tenderContent = tenderContent;
      this.purchasing = purchasing;
      this.qualificationsBidder = qualificationsBidder;
      this.apply = apply;
      this.cashDeposit = cashDeposit;
      this.paymentMethod = paymentMethod;
      this.quotationDelivery = quotationDelivery;
      this.contactWay = contactWay;
      this.report = report;
      this.type = type;
   }

   public String getTitle() {
      return this.title;
   }

   public Date getCreateDate() {
      return this.createDate;
   }

   public String getReasons() {
      return this.reasons;
   }

   public String getBiddingName() {
      return this.biddingName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public String getTenderContent() {
      return this.tenderContent;
   }

   public String getPurchasing() {
      return this.purchasing;
   }

   public String getQualificationsBidder() {
      return this.qualificationsBidder;
   }

   public String getApply() {
      return this.apply;
   }

   public String getCashDeposit() {
      return this.cashDeposit;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getQuotationDelivery() {
      return this.quotationDelivery;
   }

   public String getContactWay() {
      return this.contactWay;
   }

   public String getReport() {
      return this.report;
   }

   public Integer getType() {
      return this.type;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setCreateDate(final Date createDate) {
      this.createDate = createDate;
   }

   public void setReasons(final String reasons) {
      this.reasons = reasons;
   }

   public void setBiddingName(final String biddingName) {
      this.biddingName = biddingName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setTenderContent(final String tenderContent) {
      this.tenderContent = tenderContent;
   }

   public void setPurchasing(final String purchasing) {
      this.purchasing = purchasing;
   }

   public void setQualificationsBidder(final String qualificationsBidder) {
      this.qualificationsBidder = qualificationsBidder;
   }

   public void setApply(final String apply) {
      this.apply = apply;
   }

   public void setCashDeposit(final String cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setQuotationDelivery(final String quotationDelivery) {
      this.quotationDelivery = quotationDelivery;
   }

   public void setContactWay(final String contactWay) {
      this.contactWay = contactWay;
   }

   public void setReport(final String report) {
      this.report = report;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TenderNoticeVO)) {
         return false;
      }

      TenderNoticeVO other = (TenderNoticeVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$createDate = this.getCreateDate();
            Object other$createDate = other.getCreateDate();
            if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
               Object this$reasons = this.getReasons();
               Object other$reasons = other.getReasons();
               if (this$reasons == null ? other$reasons == null : this$reasons.equals(other$reasons)) {
                  Object this$biddingName = this.getBiddingName();
                  Object other$biddingName = other.getBiddingName();
                  if (this$biddingName == null ? other$biddingName == null : this$biddingName.equals(other$biddingName)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$contractNo = this.getContractNo();
                        Object other$contractNo = other.getContractNo();
                        if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                           Object this$tenderContent = this.getTenderContent();
                           Object other$tenderContent = other.getTenderContent();
                           if (this$tenderContent == null ? other$tenderContent == null : this$tenderContent.equals(other$tenderContent)) {
                              Object this$purchasing = this.getPurchasing();
                              Object other$purchasing = other.getPurchasing();
                              if (this$purchasing == null ? other$purchasing == null : this$purchasing.equals(other$purchasing)) {
                                 Object this$qualificationsBidder = this.getQualificationsBidder();
                                 Object other$qualificationsBidder = other.getQualificationsBidder();
                                 if (this$qualificationsBidder == null
                                    ? other$qualificationsBidder == null
                                    : this$qualificationsBidder.equals(other$qualificationsBidder)) {
                                    Object this$apply = this.getApply();
                                    Object other$apply = other.getApply();
                                    if (this$apply == null ? other$apply == null : this$apply.equals(other$apply)) {
                                       Object this$cashDeposit = this.getCashDeposit();
                                       Object other$cashDeposit = other.getCashDeposit();
                                       if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                                          Object this$paymentMethod = this.getPaymentMethod();
                                          Object other$paymentMethod = other.getPaymentMethod();
                                          if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
                                             Object this$quotationDelivery = this.getQuotationDelivery();
                                             Object other$quotationDelivery = other.getQuotationDelivery();
                                             if (this$quotationDelivery == null
                                                ? other$quotationDelivery == null
                                                : this$quotationDelivery.equals(other$quotationDelivery)) {
                                                Object this$contactWay = this.getContactWay();
                                                Object other$contactWay = other.getContactWay();
                                                if (this$contactWay == null ? other$contactWay == null : this$contactWay.equals(other$contactWay)) {
                                                   Object this$report = this.getReport();
                                                   Object other$report = other.getReport();
                                                   return this$report == null ? other$report == null : this$report.equals(other$report);
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
      return other instanceof TenderNoticeVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $reasons = this.getReasons();
      result = result * 59 + ($reasons == null ? 43 : $reasons.hashCode());
      Object $biddingName = this.getBiddingName();
      result = result * 59 + ($biddingName == null ? 43 : $biddingName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $tenderContent = this.getTenderContent();
      result = result * 59 + ($tenderContent == null ? 43 : $tenderContent.hashCode());
      Object $purchasing = this.getPurchasing();
      result = result * 59 + ($purchasing == null ? 43 : $purchasing.hashCode());
      Object $qualificationsBidder = this.getQualificationsBidder();
      result = result * 59 + ($qualificationsBidder == null ? 43 : $qualificationsBidder.hashCode());
      Object $apply = this.getApply();
      result = result * 59 + ($apply == null ? 43 : $apply.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $quotationDelivery = this.getQuotationDelivery();
      result = result * 59 + ($quotationDelivery == null ? 43 : $quotationDelivery.hashCode());
      Object $contactWay = this.getContactWay();
      result = result * 59 + ($contactWay == null ? 43 : $contactWay.hashCode());
      Object $report = this.getReport();
      return result * 59 + ($report == null ? 43 : $report.hashCode());
   }

   @Override
   public String toString() {
      return "TenderNoticeVO(title="
         + this.getTitle()
         + ", createDate="
         + this.getCreateDate()
         + ", reasons="
         + this.getReasons()
         + ", biddingName="
         + this.getBiddingName()
         + ", projectName="
         + this.getProjectName()
         + ", contractNo="
         + this.getContractNo()
         + ", tenderContent="
         + this.getTenderContent()
         + ", purchasing="
         + this.getPurchasing()
         + ", qualificationsBidder="
         + this.getQualificationsBidder()
         + ", apply="
         + this.getApply()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", quotationDelivery="
         + this.getQuotationDelivery()
         + ", contactWay="
         + this.getContactWay()
         + ", report="
         + this.getReport()
         + ", type="
         + this.getType()
         + ")";
   }

   public static class TenderNoticeVOBuilder {
      private String title;
      private Date createDate;
      private String reasons;
      private String biddingName;
      private String projectName;
      private String contractNo;
      private String tenderContent;
      private String purchasing;
      private String qualificationsBidder;
      private String apply;
      private String cashDeposit;
      private String paymentMethod;
      private String quotationDelivery;
      private String contactWay;
      private String report;
      private Integer type;

      TenderNoticeVOBuilder() {
      }

      public TenderNoticeVO.TenderNoticeVOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder createDate(final Date createDate) {
         this.createDate = createDate;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder reasons(final String reasons) {
         this.reasons = reasons;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder biddingName(final String biddingName) {
         this.biddingName = biddingName;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder tenderContent(final String tenderContent) {
         this.tenderContent = tenderContent;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder purchasing(final String purchasing) {
         this.purchasing = purchasing;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder qualificationsBidder(final String qualificationsBidder) {
         this.qualificationsBidder = qualificationsBidder;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder apply(final String apply) {
         this.apply = apply;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder cashDeposit(final String cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder quotationDelivery(final String quotationDelivery) {
         this.quotationDelivery = quotationDelivery;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder contactWay(final String contactWay) {
         this.contactWay = contactWay;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder report(final String report) {
         this.report = report;
         return this;
      }

      public TenderNoticeVO.TenderNoticeVOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TenderNoticeVO build() {
         return new TenderNoticeVO(
            this.title,
            this.createDate,
            this.reasons,
            this.biddingName,
            this.projectName,
            this.contractNo,
            this.tenderContent,
            this.purchasing,
            this.qualificationsBidder,
            this.apply,
            this.cashDeposit,
            this.paymentMethod,
            this.quotationDelivery,
            this.contactWay,
            this.report,
            this.type
         );
      }

      @Override
      public String toString() {
         return "TenderNoticeVO.TenderNoticeVOBuilder(title="
            + this.title
            + ", createDate="
            + this.createDate
            + ", reasons="
            + this.reasons
            + ", biddingName="
            + this.biddingName
            + ", projectName="
            + this.projectName
            + ", contractNo="
            + this.contractNo
            + ", tenderContent="
            + this.tenderContent
            + ", purchasing="
            + this.purchasing
            + ", qualificationsBidder="
            + this.qualificationsBidder
            + ", apply="
            + this.apply
            + ", cashDeposit="
            + this.cashDeposit
            + ", paymentMethod="
            + this.paymentMethod
            + ", quotationDelivery="
            + this.quotationDelivery
            + ", contactWay="
            + this.contactWay
            + ", report="
            + this.report
            + ", type="
            + this.type
            + ")";
      }
   }
}
