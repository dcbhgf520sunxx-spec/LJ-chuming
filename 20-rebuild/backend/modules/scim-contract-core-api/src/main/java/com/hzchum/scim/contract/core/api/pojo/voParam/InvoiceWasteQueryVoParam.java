package com.hzchum.scim.contract.core.api.pojo.voParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("废料台账-开票列表-查询类")
public class InvoiceWasteQueryVoParam {
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同ID", notes = "废料合同ID")
   private Long contractWasteId;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位ID", notes = "出售单位ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   private Integer auditStatus;

   public static InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder builder() {
      return new InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder();
   }

   public InvoiceWasteQueryVoParam() {
   }

   public InvoiceWasteQueryVoParam(
      final LocalDate startDate, final LocalDate endDate, final Long contractWasteId, final Long branchCompanyId, final Integer auditStatus
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.contractWasteId = contractWasteId;
      this.branchCompanyId = branchCompanyId;
      this.auditStatus = auditStatus;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InvoiceWasteQueryVoParam)) {
         return false;
      }

      InvoiceWasteQueryVoParam other = (InvoiceWasteQueryVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$contractWasteId = this.getContractWasteId();
      Object other$contractWasteId = other.getContractWasteId();
      if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$auditStatus = this.getAuditStatus();
            Object other$auditStatus = other.getAuditStatus();
            if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$endDate = this.getEndDate();
                  Object other$endDate = other.getEndDate();
                  return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof InvoiceWasteQueryVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InvoiceWasteQueryVoParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   public static class InvoiceWasteQueryVoParamBuilder {
      private LocalDate startDate;
      private LocalDate endDate;
      private Long contractWasteId;
      private Long branchCompanyId;
      private Integer auditStatus;

      InvoiceWasteQueryVoParamBuilder() {
      }

      public InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public InvoiceWasteQueryVoParam build() {
         return new InvoiceWasteQueryVoParam(this.startDate, this.endDate, this.contractWasteId, this.branchCompanyId, this.auditStatus);
      }

      @Override
      public String toString() {
         return "InvoiceWasteQueryVoParam.InvoiceWasteQueryVoParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", contractWasteId="
            + this.contractWasteId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
