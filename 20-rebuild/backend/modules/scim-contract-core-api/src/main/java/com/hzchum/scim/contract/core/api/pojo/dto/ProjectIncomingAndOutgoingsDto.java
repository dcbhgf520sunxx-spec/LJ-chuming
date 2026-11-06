package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目台账-收支明细详情")
public class ProjectIncomingAndOutgoingsDto {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性")
   private Integer projectAttribute;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "date", value = "日期")
   private String date;
   @ApiModelProperty(name = "contractSignBodyScale", notes = "合同签订主体占比")
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "contractSignBodyAmount", notes = "合同签订主体剩余金额")
   private BigDecimal contractSignBodyAmount;
   @ApiModelProperty(name = "projectManagerScale", notes = "项目经理占比")
   private BigDecimal projectManagerScale;
   @ApiModelProperty(name = "projectManagerAmount", notes = "项目经理剩余金额")
   private BigDecimal projectManagerAmount;
   @ApiModelProperty(name = "contractSignBodyName", notes = "合同签订主体名称")
   private String contractSignBodyName;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty("收入金额")
   private BigDecimal income;
   @ApiModelProperty("支出金额")
   private BigDecimal expense;
   @ApiModelProperty("项目结余")
   private BigDecimal remainingSum;
   @ApiModelProperty("项目经理id")
   private Long projectManagerId;
   @ApiModelProperty("收款详情")
   private CollectionDetailsDto collectionDetailsDto;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public BigDecimal getContractSignBodyAmount() {
      return this.contractSignBodyAmount;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public BigDecimal getProjectManagerAmount() {
      return this.projectManagerAmount;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getExpense() {
      return this.expense;
   }

   public BigDecimal getRemainingSum() {
      return this.remainingSum;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public CollectionDetailsDto getCollectionDetailsDto() {
      return this.collectionDetailsDto;
   }

   public ProjectIncomingAndOutgoingsDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setDate(final String date) {
      this.date = date;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setContractSignBodyAmount(final BigDecimal contractSignBodyAmount) {
      this.contractSignBodyAmount = contractSignBodyAmount;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectManagerAmount(final BigDecimal projectManagerAmount) {
      this.projectManagerAmount = projectManagerAmount;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setIncome(final BigDecimal income) {
      this.income = income;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setExpense(final BigDecimal expense) {
      this.expense = expense;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setRemainingSum(final BigDecimal remainingSum) {
      this.remainingSum = remainingSum;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ProjectIncomingAndOutgoingsDto setCollectionDetailsDto(final CollectionDetailsDto collectionDetailsDto) {
      this.collectionDetailsDto = collectionDetailsDto;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectIncomingAndOutgoingsDto)) {
         return false;
      }

      ProjectIncomingAndOutgoingsDto other = (ProjectIncomingAndOutgoingsDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$projectManagerId = this.getProjectManagerId();
            Object other$projectManagerId = other.getProjectManagerId();
            if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$date = this.getDate();
                  Object other$date = other.getDate();
                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                     Object this$contractSignBodyScale = this.getContractSignBodyScale();
                     Object other$contractSignBodyScale = other.getContractSignBodyScale();
                     if (this$contractSignBodyScale == null
                        ? other$contractSignBodyScale == null
                        : this$contractSignBodyScale.equals(other$contractSignBodyScale)) {
                        Object this$contractSignBodyAmount = this.getContractSignBodyAmount();
                        Object other$contractSignBodyAmount = other.getContractSignBodyAmount();
                        if (this$contractSignBodyAmount == null
                           ? other$contractSignBodyAmount == null
                           : this$contractSignBodyAmount.equals(other$contractSignBodyAmount)) {
                           Object this$projectManagerScale = this.getProjectManagerScale();
                           Object other$projectManagerScale = other.getProjectManagerScale();
                           if (this$projectManagerScale == null
                              ? other$projectManagerScale == null
                              : this$projectManagerScale.equals(other$projectManagerScale)) {
                              Object this$projectManagerAmount = this.getProjectManagerAmount();
                              Object other$projectManagerAmount = other.getProjectManagerAmount();
                              if (this$projectManagerAmount == null
                                 ? other$projectManagerAmount == null
                                 : this$projectManagerAmount.equals(other$projectManagerAmount)) {
                                 Object this$contractSignBodyName = this.getContractSignBodyName();
                                 Object other$contractSignBodyName = other.getContractSignBodyName();
                                 if (this$contractSignBodyName == null
                                    ? other$contractSignBodyName == null
                                    : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                    Object this$projectManagerName = this.getProjectManagerName();
                                    Object other$projectManagerName = other.getProjectManagerName();
                                    if (this$projectManagerName == null
                                       ? other$projectManagerName == null
                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                       Object this$income = this.getIncome();
                                       Object other$income = other.getIncome();
                                       if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                                          Object this$expense = this.getExpense();
                                          Object other$expense = other.getExpense();
                                          if (this$expense == null ? other$expense == null : this$expense.equals(other$expense)) {
                                             Object this$remainingSum = this.getRemainingSum();
                                             Object other$remainingSum = other.getRemainingSum();
                                             if (this$remainingSum == null ? other$remainingSum == null : this$remainingSum.equals(other$remainingSum)) {
                                                Object this$collectionDetailsDto = this.getCollectionDetailsDto();
                                                Object other$collectionDetailsDto = other.getCollectionDetailsDto();
                                                return this$collectionDetailsDto == null
                                                   ? other$collectionDetailsDto == null
                                                   : this$collectionDetailsDto.equals(other$collectionDetailsDto);
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
      return other instanceof ProjectIncomingAndOutgoingsDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $contractSignBodyAmount = this.getContractSignBodyAmount();
      result = result * 59 + ($contractSignBodyAmount == null ? 43 : $contractSignBodyAmount.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      result = result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
      Object $projectManagerAmount = this.getProjectManagerAmount();
      result = result * 59 + ($projectManagerAmount == null ? 43 : $projectManagerAmount.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expense = this.getExpense();
      result = result * 59 + ($expense == null ? 43 : $expense.hashCode());
      Object $remainingSum = this.getRemainingSum();
      result = result * 59 + ($remainingSum == null ? 43 : $remainingSum.hashCode());
      Object $collectionDetailsDto = this.getCollectionDetailsDto();
      return result * 59 + ($collectionDetailsDto == null ? 43 : $collectionDetailsDto.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectIncomingAndOutgoingsDto(projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectName="
         + this.getProjectName()
         + ", date="
         + this.getDate()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", contractSignBodyAmount="
         + this.getContractSignBodyAmount()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ", projectManagerAmount="
         + this.getProjectManagerAmount()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", income="
         + this.getIncome()
         + ", expense="
         + this.getExpense()
         + ", remainingSum="
         + this.getRemainingSum()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", collectionDetailsDto="
         + this.getCollectionDetailsDto()
         + ")";
   }

   public ProjectIncomingAndOutgoingsDto(
      final Long projectId,
      final Integer projectAttribute,
      final String projectName,
      final String date,
      final BigDecimal contractSignBodyScale,
      final BigDecimal contractSignBodyAmount,
      final BigDecimal projectManagerScale,
      final BigDecimal projectManagerAmount,
      final String contractSignBodyName,
      final String projectManagerName,
      final BigDecimal income,
      final BigDecimal expense,
      final BigDecimal remainingSum,
      final Long projectManagerId,
      final CollectionDetailsDto collectionDetailsDto
   ) {
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.projectName = projectName;
      this.date = date;
      this.contractSignBodyScale = contractSignBodyScale;
      this.contractSignBodyAmount = contractSignBodyAmount;
      this.projectManagerScale = projectManagerScale;
      this.projectManagerAmount = projectManagerAmount;
      this.contractSignBodyName = contractSignBodyName;
      this.projectManagerName = projectManagerName;
      this.income = income;
      this.expense = expense;
      this.remainingSum = remainingSum;
      this.projectManagerId = projectManagerId;
      this.collectionDetailsDto = collectionDetailsDto;
   }

   public ProjectIncomingAndOutgoingsDto() {
   }
}
