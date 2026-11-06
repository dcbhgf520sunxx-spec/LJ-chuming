package com.hzchum.scim.contract.core.api.pojo.dto.response.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("收款与开票")
public class AppCollectionDTO {
   @ApiModelProperty(name = "project", notes = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "collectionAmount", notes = "项目已收款额")
   @JsonProperty("collectionAmount")
   @JSONField(name = "collectionAmount")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "invoiceAmount", notes = "项目已开票额")
   @JsonProperty("invoiceAmount")
   @JSONField(name = "invoiceAmount")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "settlementStatus", notes = "结算状态 0 未结算 1已结算")
   @JsonProperty("settlementStatus")
   @JSONField(name = "settlementStatus")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", notes = "结算额(元)")
   @JsonProperty("settlementAmount")
   @JSONField(name = "settlementAmount")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "accountAge", notes = "账龄")
   @JsonProperty("accountAge")
   @JSONField(name = "accountAge")
   private Integer accountAge;
   @ApiModelProperty(name = "collectionList", notes = "收款列表")
   @JsonProperty("collectionList")
   @JSONField(name = "collectionList")
   private List<ContractCollectionDTO> collectionList;
   @ApiModelProperty(name = "invoiceList", notes = "开票列表")
   @JsonProperty("invoiceList")
   @JSONField(name = "invoiceList")
   private List<ContractInvoiceDTO> invoiceList;

   public static AppCollectionDTO.AppCollectionDTOBuilder builder() {
      return new AppCollectionDTO.AppCollectionDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getAccountAge() {
      return this.accountAge;
   }

   public List<ContractCollectionDTO> getCollectionList() {
      return this.collectionList;
   }

   public List<ContractInvoiceDTO> getInvoiceList() {
      return this.invoiceList;
   }

   @JsonProperty("project")
   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   @JsonProperty("collectionAmount")
   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   @JsonProperty("invoiceAmount")
   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   @JsonProperty("settlementStatus")
   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   @JsonProperty("settlementAmount")
   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   @JsonProperty("contractAmount")
   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   @JsonProperty("accountAge")
   public void setAccountAge(final Integer accountAge) {
      this.accountAge = accountAge;
   }

   @JsonProperty("collectionList")
   public void setCollectionList(final List<ContractCollectionDTO> collectionList) {
      this.collectionList = collectionList;
   }

   @JsonProperty("invoiceList")
   public void setInvoiceList(final List<ContractInvoiceDTO> invoiceList) {
      this.invoiceList = invoiceList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppCollectionDTO)) {
         return false;
      }

      AppCollectionDTO other = (AppCollectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$settlementStatus = this.getSettlementStatus();
      Object other$settlementStatus = other.getSettlementStatus();
      if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
         Object this$accountAge = this.getAccountAge();
         Object other$accountAge = other.getAccountAge();
         if (this$accountAge == null ? other$accountAge == null : this$accountAge.equals(other$accountAge)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$collectionAmount = this.getCollectionAmount();
               Object other$collectionAmount = other.getCollectionAmount();
               if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                     Object this$settlementAmount = this.getSettlementAmount();
                     Object other$settlementAmount = other.getSettlementAmount();
                     if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                        Object this$contractAmount = this.getContractAmount();
                        Object other$contractAmount = other.getContractAmount();
                        if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                           Object this$collectionList = this.getCollectionList();
                           Object other$collectionList = other.getCollectionList();
                           if (this$collectionList == null ? other$collectionList == null : this$collectionList.equals(other$collectionList)) {
                              Object this$invoiceList = this.getInvoiceList();
                              Object other$invoiceList = other.getInvoiceList();
                              return this$invoiceList == null ? other$invoiceList == null : this$invoiceList.equals(other$invoiceList);
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
      return other instanceof AppCollectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $accountAge = this.getAccountAge();
      result = result * 59 + ($accountAge == null ? 43 : $accountAge.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $collectionList = this.getCollectionList();
      result = result * 59 + ($collectionList == null ? 43 : $collectionList.hashCode());
      Object $invoiceList = this.getInvoiceList();
      return result * 59 + ($invoiceList == null ? 43 : $invoiceList.hashCode());
   }

   @Override
   public String toString() {
      return "AppCollectionDTO(project="
         + this.getProject()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", contractAmount="
         + this.getContractAmount()
         + ", accountAge="
         + this.getAccountAge()
         + ", collectionList="
         + this.getCollectionList()
         + ", invoiceList="
         + this.getInvoiceList()
         + ")";
   }

   public AppCollectionDTO(
      final ProjectInfo project,
      final BigDecimal collectionAmount,
      final BigDecimal invoiceAmount,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal contractAmount,
      final Integer accountAge,
      final List<ContractCollectionDTO> collectionList,
      final List<ContractInvoiceDTO> invoiceList
   ) {
      this.project = project;
      this.collectionAmount = collectionAmount;
      this.invoiceAmount = invoiceAmount;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.contractAmount = contractAmount;
      this.accountAge = accountAge;
      this.collectionList = collectionList;
      this.invoiceList = invoiceList;
   }

   public AppCollectionDTO() {
   }

   public static class AppCollectionDTOBuilder {
      private ProjectInfo project;
      private BigDecimal collectionAmount;
      private BigDecimal invoiceAmount;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal contractAmount;
      private Integer accountAge;
      private List<ContractCollectionDTO> collectionList;
      private List<ContractInvoiceDTO> invoiceList;

      AppCollectionDTOBuilder() {
      }

      @JsonProperty("project")
      public AppCollectionDTO.AppCollectionDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("collectionAmount")
      public AppCollectionDTO.AppCollectionDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      @JsonProperty("invoiceAmount")
      public AppCollectionDTO.AppCollectionDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      @JsonProperty("settlementStatus")
      public AppCollectionDTO.AppCollectionDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      @JsonProperty("settlementAmount")
      public AppCollectionDTO.AppCollectionDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      @JsonProperty("contractAmount")
      public AppCollectionDTO.AppCollectionDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("accountAge")
      public AppCollectionDTO.AppCollectionDTOBuilder accountAge(final Integer accountAge) {
         this.accountAge = accountAge;
         return this;
      }

      @JsonProperty("collectionList")
      public AppCollectionDTO.AppCollectionDTOBuilder collectionList(final List<ContractCollectionDTO> collectionList) {
         this.collectionList = collectionList;
         return this;
      }

      @JsonProperty("invoiceList")
      public AppCollectionDTO.AppCollectionDTOBuilder invoiceList(final List<ContractInvoiceDTO> invoiceList) {
         this.invoiceList = invoiceList;
         return this;
      }

      public AppCollectionDTO build() {
         return new AppCollectionDTO(
            this.project,
            this.collectionAmount,
            this.invoiceAmount,
            this.settlementStatus,
            this.settlementAmount,
            this.contractAmount,
            this.accountAge,
            this.collectionList,
            this.invoiceList
         );
      }

      @Override
      public String toString() {
         return "AppCollectionDTO.AppCollectionDTOBuilder(project="
            + this.project
            + ", collectionAmount="
            + this.collectionAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", contractAmount="
            + this.contractAmount
            + ", accountAge="
            + this.accountAge
            + ", collectionList="
            + this.collectionList
            + ", invoiceList="
            + this.invoiceList
            + ")";
      }
   }
}
