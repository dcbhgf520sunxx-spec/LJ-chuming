package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("分包订单付款(自)")
public class SubcontractPaymentAndSettlementDTO {
   @ApiModelProperty("日期")
   private LocalDateTime date;
   @ApiModelProperty("创建人")
   private Long creatorId;
   @ApiModelProperty("类型")
   private Long type;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("签订主体")
   private String branchCompanyName;
   @ApiModelProperty("付款开票信息")
   private List<SupplierSettlementEchoDto> paymentAndInvoiceList;
   @ApiModelProperty("项目累计收入")
   private BigDecimal projectTotalIncome;
   @ApiModelProperty("项目累计支出")
   private BigDecimal projectTotalExpenditure;
   @ApiModelProperty("本合同累计支出")
   private BigDecimal contractTotalExpenditure;

   public static SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder builder() {
      return new SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder();
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Long getCreatorId() {
      return this.creatorId;
   }

   public Long getType() {
      return this.type;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public List<SupplierSettlementEchoDto> getPaymentAndInvoiceList() {
      return this.paymentAndInvoiceList;
   }

   public BigDecimal getProjectTotalIncome() {
      return this.projectTotalIncome;
   }

   public BigDecimal getProjectTotalExpenditure() {
      return this.projectTotalExpenditure;
   }

   public BigDecimal getContractTotalExpenditure() {
      return this.contractTotalExpenditure;
   }

   public SubcontractPaymentAndSettlementDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setCreatorId(final Long creatorId) {
      this.creatorId = creatorId;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setType(final Long type) {
      this.type = type;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setPaymentAndInvoiceList(final List<SupplierSettlementEchoDto> paymentAndInvoiceList) {
      this.paymentAndInvoiceList = paymentAndInvoiceList;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setProjectTotalIncome(final BigDecimal projectTotalIncome) {
      this.projectTotalIncome = projectTotalIncome;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setProjectTotalExpenditure(final BigDecimal projectTotalExpenditure) {
      this.projectTotalExpenditure = projectTotalExpenditure;
      return this;
   }

   public SubcontractPaymentAndSettlementDTO setContractTotalExpenditure(final BigDecimal contractTotalExpenditure) {
      this.contractTotalExpenditure = contractTotalExpenditure;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractPaymentAndSettlementDTO)) {
         return false;
      }

      SubcontractPaymentAndSettlementDTO other = (SubcontractPaymentAndSettlementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$creatorId = this.getCreatorId();
      Object other$creatorId = other.getCreatorId();
      if (this$creatorId == null ? other$creatorId == null : this$creatorId.equals(other$creatorId)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$contractAmount = this.getContractAmount();
               Object other$contractAmount = other.getContractAmount();
               if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                  Object this$branchCompanyName = this.getBranchCompanyName();
                  Object other$branchCompanyName = other.getBranchCompanyName();
                  if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                     Object this$paymentAndInvoiceList = this.getPaymentAndInvoiceList();
                     Object other$paymentAndInvoiceList = other.getPaymentAndInvoiceList();
                     if (this$paymentAndInvoiceList == null
                        ? other$paymentAndInvoiceList == null
                        : this$paymentAndInvoiceList.equals(other$paymentAndInvoiceList)) {
                        Object this$projectTotalIncome = this.getProjectTotalIncome();
                        Object other$projectTotalIncome = other.getProjectTotalIncome();
                        if (this$projectTotalIncome == null ? other$projectTotalIncome == null : this$projectTotalIncome.equals(other$projectTotalIncome)) {
                           Object this$projectTotalExpenditure = this.getProjectTotalExpenditure();
                           Object other$projectTotalExpenditure = other.getProjectTotalExpenditure();
                           if (this$projectTotalExpenditure == null
                              ? other$projectTotalExpenditure == null
                              : this$projectTotalExpenditure.equals(other$projectTotalExpenditure)) {
                              Object this$contractTotalExpenditure = this.getContractTotalExpenditure();
                              Object other$contractTotalExpenditure = other.getContractTotalExpenditure();
                              return this$contractTotalExpenditure == null
                                 ? other$contractTotalExpenditure == null
                                 : this$contractTotalExpenditure.equals(other$contractTotalExpenditure);
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
      return other instanceof SubcontractPaymentAndSettlementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $creatorId = this.getCreatorId();
      result = result * 59 + ($creatorId == null ? 43 : $creatorId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $paymentAndInvoiceList = this.getPaymentAndInvoiceList();
      result = result * 59 + ($paymentAndInvoiceList == null ? 43 : $paymentAndInvoiceList.hashCode());
      Object $projectTotalIncome = this.getProjectTotalIncome();
      result = result * 59 + ($projectTotalIncome == null ? 43 : $projectTotalIncome.hashCode());
      Object $projectTotalExpenditure = this.getProjectTotalExpenditure();
      result = result * 59 + ($projectTotalExpenditure == null ? 43 : $projectTotalExpenditure.hashCode());
      Object $contractTotalExpenditure = this.getContractTotalExpenditure();
      return result * 59 + ($contractTotalExpenditure == null ? 43 : $contractTotalExpenditure.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractPaymentAndSettlementDTO(date="
         + this.getDate()
         + ", creatorId="
         + this.getCreatorId()
         + ", type="
         + this.getType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", paymentAndInvoiceList="
         + this.getPaymentAndInvoiceList()
         + ", projectTotalIncome="
         + this.getProjectTotalIncome()
         + ", projectTotalExpenditure="
         + this.getProjectTotalExpenditure()
         + ", contractTotalExpenditure="
         + this.getContractTotalExpenditure()
         + ")";
   }

   public SubcontractPaymentAndSettlementDTO(
      final LocalDateTime date,
      final Long creatorId,
      final Long type,
      final BigDecimal contractAmount,
      final String branchCompanyName,
      final List<SupplierSettlementEchoDto> paymentAndInvoiceList,
      final BigDecimal projectTotalIncome,
      final BigDecimal projectTotalExpenditure,
      final BigDecimal contractTotalExpenditure
   ) {
      this.date = date;
      this.creatorId = creatorId;
      this.type = type;
      this.contractAmount = contractAmount;
      this.branchCompanyName = branchCompanyName;
      this.paymentAndInvoiceList = paymentAndInvoiceList;
      this.projectTotalIncome = projectTotalIncome;
      this.projectTotalExpenditure = projectTotalExpenditure;
      this.contractTotalExpenditure = contractTotalExpenditure;
   }

   public SubcontractPaymentAndSettlementDTO() {
   }

   public static class SubcontractPaymentAndSettlementDTOBuilder {
      private LocalDateTime date;
      private Long creatorId;
      private Long type;
      private BigDecimal contractAmount;
      private String branchCompanyName;
      private List<SupplierSettlementEchoDto> paymentAndInvoiceList;
      private BigDecimal projectTotalIncome;
      private BigDecimal projectTotalExpenditure;
      private BigDecimal contractTotalExpenditure;

      SubcontractPaymentAndSettlementDTOBuilder() {
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder creatorId(final Long creatorId) {
         this.creatorId = creatorId;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder type(final Long type) {
         this.type = type;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder paymentAndInvoiceList(
         final List<SupplierSettlementEchoDto> paymentAndInvoiceList
      ) {
         this.paymentAndInvoiceList = paymentAndInvoiceList;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder projectTotalIncome(final BigDecimal projectTotalIncome) {
         this.projectTotalIncome = projectTotalIncome;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder projectTotalExpenditure(final BigDecimal projectTotalExpenditure) {
         this.projectTotalExpenditure = projectTotalExpenditure;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder contractTotalExpenditure(final BigDecimal contractTotalExpenditure) {
         this.contractTotalExpenditure = contractTotalExpenditure;
         return this;
      }

      public SubcontractPaymentAndSettlementDTO build() {
         return new SubcontractPaymentAndSettlementDTO(
            this.date,
            this.creatorId,
            this.type,
            this.contractAmount,
            this.branchCompanyName,
            this.paymentAndInvoiceList,
            this.projectTotalIncome,
            this.projectTotalExpenditure,
            this.contractTotalExpenditure
         );
      }

      @Override
      public String toString() {
         return "SubcontractPaymentAndSettlementDTO.SubcontractPaymentAndSettlementDTOBuilder(date="
            + this.date
            + ", creatorId="
            + this.creatorId
            + ", type="
            + this.type
            + ", contractAmount="
            + this.contractAmount
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", paymentAndInvoiceList="
            + this.paymentAndInvoiceList
            + ", projectTotalIncome="
            + this.projectTotalIncome
            + ", projectTotalExpenditure="
            + this.projectTotalExpenditure
            + ", contractTotalExpenditure="
            + this.contractTotalExpenditure
            + ")";
      }
   }
}
