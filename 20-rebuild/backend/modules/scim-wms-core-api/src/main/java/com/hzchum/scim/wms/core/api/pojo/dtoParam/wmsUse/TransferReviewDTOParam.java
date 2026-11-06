package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class TransferReviewDTOParam {
   private Long id;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private String approvalComments;
   private List<TransferDetailReviewDTOParam> list;

   public static TransferReviewDTOParam.TransferReviewDTOParamBuilder builder() {
      return new TransferReviewDTOParam.TransferReviewDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public List<TransferDetailReviewDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setList(final List<TransferDetailReviewDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferReviewDTOParam)) {
         return false;
      }

      TransferReviewDTOParam other = (TransferReviewDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$invoiceType = this.getInvoiceType();
         Object other$invoiceType = other.getInvoiceType();
         if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
            Object this$taxRate = this.getTaxRate();
            Object other$taxRate = other.getTaxRate();
            if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
               Object this$approvalComments = this.getApprovalComments();
               Object other$approvalComments = other.getApprovalComments();
               if (this$approvalComments == null ? other$approvalComments == null : this$approvalComments.equals(other$approvalComments)) {
                  Object this$list = this.getList();
                  Object other$list = other.getList();
                  return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof TransferReviewDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "TransferReviewDTOParam(id="
         + this.getId()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", list="
         + this.getList()
         + ")";
   }

   public TransferReviewDTOParam(
      final Long id, final Integer invoiceType, final BigDecimal taxRate, final String approvalComments, final List<TransferDetailReviewDTOParam> list
   ) {
      this.id = id;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.approvalComments = approvalComments;
      this.list = list;
   }

   public TransferReviewDTOParam() {
   }

   public static class TransferReviewDTOParamBuilder {
      private Long id;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private String approvalComments;
      private List<TransferDetailReviewDTOParam> list;

      TransferReviewDTOParamBuilder() {
      }

      public TransferReviewDTOParam.TransferReviewDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferReviewDTOParam.TransferReviewDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public TransferReviewDTOParam.TransferReviewDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public TransferReviewDTOParam.TransferReviewDTOParamBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public TransferReviewDTOParam.TransferReviewDTOParamBuilder list(final List<TransferDetailReviewDTOParam> list) {
         this.list = list;
         return this;
      }

      public TransferReviewDTOParam build() {
         return new TransferReviewDTOParam(this.id, this.invoiceType, this.taxRate, this.approvalComments, this.list);
      }

      @Override
      public String toString() {
         return "TransferReviewDTOParam.TransferReviewDTOParamBuilder(id="
            + this.id
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", approvalComments="
            + this.approvalComments
            + ", list="
            + this.list
            + ")";
      }
   }
}
