package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("收款预警类")
public class ContractCollectionWarningDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "signingDate", notes = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "businessType", notes = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "collectionAmount", notes = "收款金额（元）")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "happenedAmount", notes = "发生额（元）")
   private BigDecimal happenedAmount;
   @ApiModelProperty(name = "arrearAmount", notes = "欠款额（元）")
   private BigDecimal arrearAmount;

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getHappenedAmount() {
      return this.happenedAmount;
   }

   public BigDecimal getArrearAmount() {
      return this.arrearAmount;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setHappenedAmount(final BigDecimal happenedAmount) {
      this.happenedAmount = happenedAmount;
   }

   public void setArrearAmount(final BigDecimal arrearAmount) {
      this.arrearAmount = arrearAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionWarningDTO)) {
         return false;
      }

      ContractCollectionWarningDTO other = (ContractCollectionWarningDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectManagerId = this.getProjectManagerId();
      Object other$projectManagerId = other.getProjectManagerId();
      if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$projectManagerName = this.getProjectManagerName();
               Object other$projectManagerName = other.getProjectManagerName();
               if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                  Object this$contractAmount = this.getContractAmount();
                  Object other$contractAmount = other.getContractAmount();
                  if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                     Object this$signingDate = this.getSigningDate();
                     Object other$signingDate = other.getSigningDate();
                     if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                        Object this$collectionAmount = this.getCollectionAmount();
                        Object other$collectionAmount = other.getCollectionAmount();
                        if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                           Object this$happenedAmount = this.getHappenedAmount();
                           Object other$happenedAmount = other.getHappenedAmount();
                           if (this$happenedAmount == null ? other$happenedAmount == null : this$happenedAmount.equals(other$happenedAmount)) {
                              Object this$arrearAmount = this.getArrearAmount();
                              Object other$arrearAmount = other.getArrearAmount();
                              return this$arrearAmount == null ? other$arrearAmount == null : this$arrearAmount.equals(other$arrearAmount);
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
      return other instanceof ContractCollectionWarningDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $arrearAmount = this.getArrearAmount();
      return result * 59 + ($arrearAmount == null ? 43 : $arrearAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCollectionWarningDTO(project="
         + this.getProject()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", signingDate="
         + this.getSigningDate()
         + ", businessType="
         + this.getBusinessType()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", arrearAmount="
         + this.getArrearAmount()
         + ")";
   }
}
