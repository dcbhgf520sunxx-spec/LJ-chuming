package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "ProjectCostReportDto对象", description = "成本报表汇总返回表 ")
public class ProjectSelfSupportCostReportDTO {
   @ApiModelProperty("签订日期")
   private LocalDate signDate;
   @ApiModelProperty("合同信息")
   private ProjectInfo project;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("采购id")
   private Long orderId;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计付款")
   private BigDecimal totalExpenditure;
   @ApiModelProperty("累计收入")
   private BigDecimal totalIncome;
   @ApiModelProperty("毛利")
   private BigDecimal profit;
   @ApiModelProperty("毛利率")
   private BigDecimal profitRate;
   @ApiModelProperty(name = "advancesReceived", notes = "预收款")
   private BigDecimal advancesReceived;
   @ApiModelProperty("剩余预付")
   private BigDecimal remainingAdvances;
   @ApiModelProperty("发包单位")
   private String sendingUnit;
   @ApiModelProperty("成本科目费用")
   private List<ProjectExpenseCostReportDTO> costSubjectCost;
   @ApiModelProperty("资金利息")
   private BigDecimal capitalInterest;
   @ApiModelProperty("管理费")
   private BigDecimal managementFee;
   @ApiModelProperty("材料支出明细")
   private List<ProjectMaterialsAllDto> materialExpenditure;
   @ApiModelProperty("其他费用使用明细")
   private List<ProjectElseAllDto> otherExpenditure;

   public static ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder builder() {
      return new ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder();
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getTotalExpenditure() {
      return this.totalExpenditure;
   }

   public BigDecimal getTotalIncome() {
      return this.totalIncome;
   }

   public BigDecimal getProfit() {
      return this.profit;
   }

   public BigDecimal getProfitRate() {
      return this.profitRate;
   }

   public BigDecimal getAdvancesReceived() {
      return this.advancesReceived;
   }

   public BigDecimal getRemainingAdvances() {
      return this.remainingAdvances;
   }

   public String getSendingUnit() {
      return this.sendingUnit;
   }

   public List<ProjectExpenseCostReportDTO> getCostSubjectCost() {
      return this.costSubjectCost;
   }

   public BigDecimal getCapitalInterest() {
      return this.capitalInterest;
   }

   public BigDecimal getManagementFee() {
      return this.managementFee;
   }

   public List<ProjectMaterialsAllDto> getMaterialExpenditure() {
      return this.materialExpenditure;
   }

   public List<ProjectElseAllDto> getOtherExpenditure() {
      return this.otherExpenditure;
   }

   public ProjectSelfSupportCostReportDTO setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setTotalExpenditure(final BigDecimal totalExpenditure) {
      this.totalExpenditure = totalExpenditure;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setTotalIncome(final BigDecimal totalIncome) {
      this.totalIncome = totalIncome;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setProfit(final BigDecimal profit) {
      this.profit = profit;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setProfitRate(final BigDecimal profitRate) {
      this.profitRate = profitRate;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setAdvancesReceived(final BigDecimal advancesReceived) {
      this.advancesReceived = advancesReceived;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setRemainingAdvances(final BigDecimal remainingAdvances) {
      this.remainingAdvances = remainingAdvances;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setSendingUnit(final String sendingUnit) {
      this.sendingUnit = sendingUnit;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setCostSubjectCost(final List<ProjectExpenseCostReportDTO> costSubjectCost) {
      this.costSubjectCost = costSubjectCost;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setCapitalInterest(final BigDecimal capitalInterest) {
      this.capitalInterest = capitalInterest;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setMaterialExpenditure(final List<ProjectMaterialsAllDto> materialExpenditure) {
      this.materialExpenditure = materialExpenditure;
      return this;
   }

   public ProjectSelfSupportCostReportDTO setOtherExpenditure(final List<ProjectElseAllDto> otherExpenditure) {
      this.otherExpenditure = otherExpenditure;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSelfSupportCostReportDTO)) {
         return false;
      }

      ProjectSelfSupportCostReportDTO other = (ProjectSelfSupportCostReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$signDate = this.getSignDate();
         Object other$signDate = other.getSignDate();
         if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$contractAmount = this.getContractAmount();
               Object other$contractAmount = other.getContractAmount();
               if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                  Object this$settlementAmount = this.getSettlementAmount();
                  Object other$settlementAmount = other.getSettlementAmount();
                  if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                     Object this$totalExpenditure = this.getTotalExpenditure();
                     Object other$totalExpenditure = other.getTotalExpenditure();
                     if (this$totalExpenditure == null ? other$totalExpenditure == null : this$totalExpenditure.equals(other$totalExpenditure)) {
                        Object this$totalIncome = this.getTotalIncome();
                        Object other$totalIncome = other.getTotalIncome();
                        if (this$totalIncome == null ? other$totalIncome == null : this$totalIncome.equals(other$totalIncome)) {
                           Object this$profit = this.getProfit();
                           Object other$profit = other.getProfit();
                           if (this$profit == null ? other$profit == null : this$profit.equals(other$profit)) {
                              Object this$profitRate = this.getProfitRate();
                              Object other$profitRate = other.getProfitRate();
                              if (this$profitRate == null ? other$profitRate == null : this$profitRate.equals(other$profitRate)) {
                                 Object this$advancesReceived = this.getAdvancesReceived();
                                 Object other$advancesReceived = other.getAdvancesReceived();
                                 if (this$advancesReceived == null ? other$advancesReceived == null : this$advancesReceived.equals(other$advancesReceived)) {
                                    Object this$remainingAdvances = this.getRemainingAdvances();
                                    Object other$remainingAdvances = other.getRemainingAdvances();
                                    if (this$remainingAdvances == null
                                       ? other$remainingAdvances == null
                                       : this$remainingAdvances.equals(other$remainingAdvances)) {
                                       Object this$sendingUnit = this.getSendingUnit();
                                       Object other$sendingUnit = other.getSendingUnit();
                                       if (this$sendingUnit == null ? other$sendingUnit == null : this$sendingUnit.equals(other$sendingUnit)) {
                                          Object this$costSubjectCost = this.getCostSubjectCost();
                                          Object other$costSubjectCost = other.getCostSubjectCost();
                                          if (this$costSubjectCost == null ? other$costSubjectCost == null : this$costSubjectCost.equals(other$costSubjectCost)
                                             )
                                           {
                                             Object this$capitalInterest = this.getCapitalInterest();
                                             Object other$capitalInterest = other.getCapitalInterest();
                                             if (this$capitalInterest == null
                                                ? other$capitalInterest == null
                                                : this$capitalInterest.equals(other$capitalInterest)) {
                                                Object this$managementFee = this.getManagementFee();
                                                Object other$managementFee = other.getManagementFee();
                                                if (this$managementFee == null ? other$managementFee == null : this$managementFee.equals(other$managementFee)) {
                                                   Object this$materialExpenditure = this.getMaterialExpenditure();
                                                   Object other$materialExpenditure = other.getMaterialExpenditure();
                                                   if (this$materialExpenditure == null
                                                      ? other$materialExpenditure == null
                                                      : this$materialExpenditure.equals(other$materialExpenditure)) {
                                                      Object this$otherExpenditure = this.getOtherExpenditure();
                                                      Object other$otherExpenditure = other.getOtherExpenditure();
                                                      return this$otherExpenditure == null
                                                         ? other$otherExpenditure == null
                                                         : this$otherExpenditure.equals(other$otherExpenditure);
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
      return other instanceof ProjectSelfSupportCostReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $totalExpenditure = this.getTotalExpenditure();
      result = result * 59 + ($totalExpenditure == null ? 43 : $totalExpenditure.hashCode());
      Object $totalIncome = this.getTotalIncome();
      result = result * 59 + ($totalIncome == null ? 43 : $totalIncome.hashCode());
      Object $profit = this.getProfit();
      result = result * 59 + ($profit == null ? 43 : $profit.hashCode());
      Object $profitRate = this.getProfitRate();
      result = result * 59 + ($profitRate == null ? 43 : $profitRate.hashCode());
      Object $advancesReceived = this.getAdvancesReceived();
      result = result * 59 + ($advancesReceived == null ? 43 : $advancesReceived.hashCode());
      Object $remainingAdvances = this.getRemainingAdvances();
      result = result * 59 + ($remainingAdvances == null ? 43 : $remainingAdvances.hashCode());
      Object $sendingUnit = this.getSendingUnit();
      result = result * 59 + ($sendingUnit == null ? 43 : $sendingUnit.hashCode());
      Object $costSubjectCost = this.getCostSubjectCost();
      result = result * 59 + ($costSubjectCost == null ? 43 : $costSubjectCost.hashCode());
      Object $capitalInterest = this.getCapitalInterest();
      result = result * 59 + ($capitalInterest == null ? 43 : $capitalInterest.hashCode());
      Object $managementFee = this.getManagementFee();
      result = result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
      Object $materialExpenditure = this.getMaterialExpenditure();
      result = result * 59 + ($materialExpenditure == null ? 43 : $materialExpenditure.hashCode());
      Object $otherExpenditure = this.getOtherExpenditure();
      return result * 59 + ($otherExpenditure == null ? 43 : $otherExpenditure.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSelfSupportCostReportDTO(signDate="
         + this.getSignDate()
         + ", project="
         + this.getProject()
         + ", contractAmount="
         + this.getContractAmount()
         + ", orderId="
         + this.getOrderId()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", totalExpenditure="
         + this.getTotalExpenditure()
         + ", totalIncome="
         + this.getTotalIncome()
         + ", profit="
         + this.getProfit()
         + ", profitRate="
         + this.getProfitRate()
         + ", advancesReceived="
         + this.getAdvancesReceived()
         + ", remainingAdvances="
         + this.getRemainingAdvances()
         + ", sendingUnit="
         + this.getSendingUnit()
         + ", costSubjectCost="
         + this.getCostSubjectCost()
         + ", capitalInterest="
         + this.getCapitalInterest()
         + ", managementFee="
         + this.getManagementFee()
         + ", materialExpenditure="
         + this.getMaterialExpenditure()
         + ", otherExpenditure="
         + this.getOtherExpenditure()
         + ")";
   }

   public ProjectSelfSupportCostReportDTO(
      final LocalDate signDate,
      final ProjectInfo project,
      final BigDecimal contractAmount,
      final Long orderId,
      final BigDecimal settlementAmount,
      final BigDecimal totalExpenditure,
      final BigDecimal totalIncome,
      final BigDecimal profit,
      final BigDecimal profitRate,
      final BigDecimal advancesReceived,
      final BigDecimal remainingAdvances,
      final String sendingUnit,
      final List<ProjectExpenseCostReportDTO> costSubjectCost,
      final BigDecimal capitalInterest,
      final BigDecimal managementFee,
      final List<ProjectMaterialsAllDto> materialExpenditure,
      final List<ProjectElseAllDto> otherExpenditure
   ) {
      this.signDate = signDate;
      this.project = project;
      this.contractAmount = contractAmount;
      this.orderId = orderId;
      this.settlementAmount = settlementAmount;
      this.totalExpenditure = totalExpenditure;
      this.totalIncome = totalIncome;
      this.profit = profit;
      this.profitRate = profitRate;
      this.advancesReceived = advancesReceived;
      this.remainingAdvances = remainingAdvances;
      this.sendingUnit = sendingUnit;
      this.costSubjectCost = costSubjectCost;
      this.capitalInterest = capitalInterest;
      this.managementFee = managementFee;
      this.materialExpenditure = materialExpenditure;
      this.otherExpenditure = otherExpenditure;
   }

   public ProjectSelfSupportCostReportDTO() {
   }

   public static class ProjectSelfSupportCostReportDTOBuilder {
      private LocalDate signDate;
      private ProjectInfo project;
      private BigDecimal contractAmount;
      private Long orderId;
      private BigDecimal settlementAmount;
      private BigDecimal totalExpenditure;
      private BigDecimal totalIncome;
      private BigDecimal profit;
      private BigDecimal profitRate;
      private BigDecimal advancesReceived;
      private BigDecimal remainingAdvances;
      private String sendingUnit;
      private List<ProjectExpenseCostReportDTO> costSubjectCost;
      private BigDecimal capitalInterest;
      private BigDecimal managementFee;
      private List<ProjectMaterialsAllDto> materialExpenditure;
      private List<ProjectElseAllDto> otherExpenditure;

      ProjectSelfSupportCostReportDTOBuilder() {
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder totalExpenditure(final BigDecimal totalExpenditure) {
         this.totalExpenditure = totalExpenditure;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder totalIncome(final BigDecimal totalIncome) {
         this.totalIncome = totalIncome;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder profit(final BigDecimal profit) {
         this.profit = profit;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder profitRate(final BigDecimal profitRate) {
         this.profitRate = profitRate;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder advancesReceived(final BigDecimal advancesReceived) {
         this.advancesReceived = advancesReceived;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder remainingAdvances(final BigDecimal remainingAdvances) {
         this.remainingAdvances = remainingAdvances;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder sendingUnit(final String sendingUnit) {
         this.sendingUnit = sendingUnit;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder costSubjectCost(final List<ProjectExpenseCostReportDTO> costSubjectCost) {
         this.costSubjectCost = costSubjectCost;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder capitalInterest(final BigDecimal capitalInterest) {
         this.capitalInterest = capitalInterest;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder materialExpenditure(final List<ProjectMaterialsAllDto> materialExpenditure) {
         this.materialExpenditure = materialExpenditure;
         return this;
      }

      public ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder otherExpenditure(final List<ProjectElseAllDto> otherExpenditure) {
         this.otherExpenditure = otherExpenditure;
         return this;
      }

      public ProjectSelfSupportCostReportDTO build() {
         return new ProjectSelfSupportCostReportDTO(
            this.signDate,
            this.project,
            this.contractAmount,
            this.orderId,
            this.settlementAmount,
            this.totalExpenditure,
            this.totalIncome,
            this.profit,
            this.profitRate,
            this.advancesReceived,
            this.remainingAdvances,
            this.sendingUnit,
            this.costSubjectCost,
            this.capitalInterest,
            this.managementFee,
            this.materialExpenditure,
            this.otherExpenditure
         );
      }

      @Override
      public String toString() {
         return "ProjectSelfSupportCostReportDTO.ProjectSelfSupportCostReportDTOBuilder(signDate="
            + this.signDate
            + ", project="
            + this.project
            + ", contractAmount="
            + this.contractAmount
            + ", orderId="
            + this.orderId
            + ", settlementAmount="
            + this.settlementAmount
            + ", totalExpenditure="
            + this.totalExpenditure
            + ", totalIncome="
            + this.totalIncome
            + ", profit="
            + this.profit
            + ", profitRate="
            + this.profitRate
            + ", advancesReceived="
            + this.advancesReceived
            + ", remainingAdvances="
            + this.remainingAdvances
            + ", sendingUnit="
            + this.sendingUnit
            + ", costSubjectCost="
            + this.costSubjectCost
            + ", capitalInterest="
            + this.capitalInterest
            + ", managementFee="
            + this.managementFee
            + ", materialExpenditure="
            + this.materialExpenditure
            + ", otherExpenditure="
            + this.otherExpenditure
            + ")";
      }
   }
}
