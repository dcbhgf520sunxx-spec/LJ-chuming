package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ManagementFeeAllDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProjectCostReportDto对象", description = "成本报表汇总返回表 ")
public class ProjectCostReportDto {
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
   @ApiModelProperty("材料费用")
   private BigDecimal materialCost;
   @ApiModelProperty("材料费占比")
   private BigDecimal materialCostRatio;
   @ApiModelProperty("劳务费用")
   private BigDecimal laborCost;
   @ApiModelProperty("分包费用")
   private BigDecimal subcontractCost;
   @ApiModelProperty("租赁费用")
   private BigDecimal leaseCost;
   @ApiModelProperty("期间费用")
   private BigDecimal indirectCost;
   @ApiModelProperty("其他摊销费用")
   private BigDecimal otherCost;
   @ApiModelProperty("资金利息")
   private BigDecimal capitalInterest;
   @ApiModelProperty("管理费")
   private BigDecimal managementFee;
   @ApiModelProperty("材料支出明细")
   private List<ProjectMaterialsAllDto> materialExpenditure;
   @ApiModelProperty("其他费用使用明细")
   private List<ProjectElseAllDto> otherExpenditure;
   @ApiModelProperty("管理费用明细")
   private List<ManagementFeeAllDto> managementFeeDetail;

   public static ProjectCostReportDto.ProjectCostReportDtoBuilder builder() {
      return new ProjectCostReportDto.ProjectCostReportDtoBuilder();
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

   public BigDecimal getMaterialCost() {
      return this.materialCost;
   }

   public BigDecimal getMaterialCostRatio() {
      return this.materialCostRatio;
   }

   public BigDecimal getLaborCost() {
      return this.laborCost;
   }

   public BigDecimal getSubcontractCost() {
      return this.subcontractCost;
   }

   public BigDecimal getLeaseCost() {
      return this.leaseCost;
   }

   public BigDecimal getIndirectCost() {
      return this.indirectCost;
   }

   public BigDecimal getOtherCost() {
      return this.otherCost;
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

   public List<ManagementFeeAllDto> getManagementFeeDetail() {
      return this.managementFeeDetail;
   }

   public ProjectCostReportDto setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ProjectCostReportDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public ProjectCostReportDto setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public ProjectCostReportDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ProjectCostReportDto setTotalExpenditure(final BigDecimal totalExpenditure) {
      this.totalExpenditure = totalExpenditure;
      return this;
   }

   public ProjectCostReportDto setTotalIncome(final BigDecimal totalIncome) {
      this.totalIncome = totalIncome;
      return this;
   }

   public ProjectCostReportDto setProfit(final BigDecimal profit) {
      this.profit = profit;
      return this;
   }

   public ProjectCostReportDto setProfitRate(final BigDecimal profitRate) {
      this.profitRate = profitRate;
      return this;
   }

   public ProjectCostReportDto setMaterialCost(final BigDecimal materialCost) {
      this.materialCost = materialCost;
      return this;
   }

   public ProjectCostReportDto setMaterialCostRatio(final BigDecimal materialCostRatio) {
      this.materialCostRatio = materialCostRatio;
      return this;
   }

   public ProjectCostReportDto setLaborCost(final BigDecimal laborCost) {
      this.laborCost = laborCost;
      return this;
   }

   public ProjectCostReportDto setSubcontractCost(final BigDecimal subcontractCost) {
      this.subcontractCost = subcontractCost;
      return this;
   }

   public ProjectCostReportDto setLeaseCost(final BigDecimal leaseCost) {
      this.leaseCost = leaseCost;
      return this;
   }

   public ProjectCostReportDto setIndirectCost(final BigDecimal indirectCost) {
      this.indirectCost = indirectCost;
      return this;
   }

   public ProjectCostReportDto setOtherCost(final BigDecimal otherCost) {
      this.otherCost = otherCost;
      return this;
   }

   public ProjectCostReportDto setCapitalInterest(final BigDecimal capitalInterest) {
      this.capitalInterest = capitalInterest;
      return this;
   }

   public ProjectCostReportDto setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
      return this;
   }

   public ProjectCostReportDto setMaterialExpenditure(final List<ProjectMaterialsAllDto> materialExpenditure) {
      this.materialExpenditure = materialExpenditure;
      return this;
   }

   public ProjectCostReportDto setOtherExpenditure(final List<ProjectElseAllDto> otherExpenditure) {
      this.otherExpenditure = otherExpenditure;
      return this;
   }

   public ProjectCostReportDto setManagementFeeDetail(final List<ManagementFeeAllDto> managementFeeDetail) {
      this.managementFeeDetail = managementFeeDetail;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCostReportDto)) {
         return false;
      }

      ProjectCostReportDto other = (ProjectCostReportDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
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
                              Object this$materialCost = this.getMaterialCost();
                              Object other$materialCost = other.getMaterialCost();
                              if (this$materialCost == null ? other$materialCost == null : this$materialCost.equals(other$materialCost)) {
                                 Object this$materialCostRatio = this.getMaterialCostRatio();
                                 Object other$materialCostRatio = other.getMaterialCostRatio();
                                 if (this$materialCostRatio == null ? other$materialCostRatio == null : this$materialCostRatio.equals(other$materialCostRatio)) {
                                    Object this$laborCost = this.getLaborCost();
                                    Object other$laborCost = other.getLaborCost();
                                    if (this$laborCost == null ? other$laborCost == null : this$laborCost.equals(other$laborCost)) {
                                       Object this$subcontractCost = this.getSubcontractCost();
                                       Object other$subcontractCost = other.getSubcontractCost();
                                       if (this$subcontractCost == null ? other$subcontractCost == null : this$subcontractCost.equals(other$subcontractCost)) {
                                          Object this$leaseCost = this.getLeaseCost();
                                          Object other$leaseCost = other.getLeaseCost();
                                          if (this$leaseCost == null ? other$leaseCost == null : this$leaseCost.equals(other$leaseCost)) {
                                             Object this$indirectCost = this.getIndirectCost();
                                             Object other$indirectCost = other.getIndirectCost();
                                             if (this$indirectCost == null ? other$indirectCost == null : this$indirectCost.equals(other$indirectCost)) {
                                                Object this$otherCost = this.getOtherCost();
                                                Object other$otherCost = other.getOtherCost();
                                                if (this$otherCost == null ? other$otherCost == null : this$otherCost.equals(other$otherCost)) {
                                                   Object this$capitalInterest = this.getCapitalInterest();
                                                   Object other$capitalInterest = other.getCapitalInterest();
                                                   if (this$capitalInterest == null
                                                      ? other$capitalInterest == null
                                                      : this$capitalInterest.equals(other$capitalInterest)) {
                                                      Object this$managementFee = this.getManagementFee();
                                                      Object other$managementFee = other.getManagementFee();
                                                      if (this$managementFee == null
                                                         ? other$managementFee == null
                                                         : this$managementFee.equals(other$managementFee)) {
                                                         Object this$materialExpenditure = this.getMaterialExpenditure();
                                                         Object other$materialExpenditure = other.getMaterialExpenditure();
                                                         if (this$materialExpenditure == null
                                                            ? other$materialExpenditure == null
                                                            : this$materialExpenditure.equals(other$materialExpenditure)) {
                                                            Object this$otherExpenditure = this.getOtherExpenditure();
                                                            Object other$otherExpenditure = other.getOtherExpenditure();
                                                            if (this$otherExpenditure == null
                                                               ? other$otherExpenditure == null
                                                               : this$otherExpenditure.equals(other$otherExpenditure)) {
                                                               Object this$managementFeeDetail = this.getManagementFeeDetail();
                                                               Object other$managementFeeDetail = other.getManagementFeeDetail();
                                                               return this$managementFeeDetail == null
                                                                  ? other$managementFeeDetail == null
                                                                  : this$managementFeeDetail.equals(other$managementFeeDetail);
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
      return other instanceof ProjectCostReportDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
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
      Object $materialCost = this.getMaterialCost();
      result = result * 59 + ($materialCost == null ? 43 : $materialCost.hashCode());
      Object $materialCostRatio = this.getMaterialCostRatio();
      result = result * 59 + ($materialCostRatio == null ? 43 : $materialCostRatio.hashCode());
      Object $laborCost = this.getLaborCost();
      result = result * 59 + ($laborCost == null ? 43 : $laborCost.hashCode());
      Object $subcontractCost = this.getSubcontractCost();
      result = result * 59 + ($subcontractCost == null ? 43 : $subcontractCost.hashCode());
      Object $leaseCost = this.getLeaseCost();
      result = result * 59 + ($leaseCost == null ? 43 : $leaseCost.hashCode());
      Object $indirectCost = this.getIndirectCost();
      result = result * 59 + ($indirectCost == null ? 43 : $indirectCost.hashCode());
      Object $otherCost = this.getOtherCost();
      result = result * 59 + ($otherCost == null ? 43 : $otherCost.hashCode());
      Object $capitalInterest = this.getCapitalInterest();
      result = result * 59 + ($capitalInterest == null ? 43 : $capitalInterest.hashCode());
      Object $managementFee = this.getManagementFee();
      result = result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
      Object $materialExpenditure = this.getMaterialExpenditure();
      result = result * 59 + ($materialExpenditure == null ? 43 : $materialExpenditure.hashCode());
      Object $otherExpenditure = this.getOtherExpenditure();
      result = result * 59 + ($otherExpenditure == null ? 43 : $otherExpenditure.hashCode());
      Object $managementFeeDetail = this.getManagementFeeDetail();
      return result * 59 + ($managementFeeDetail == null ? 43 : $managementFeeDetail.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCostReportDto(project="
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
         + ", materialCost="
         + this.getMaterialCost()
         + ", materialCostRatio="
         + this.getMaterialCostRatio()
         + ", laborCost="
         + this.getLaborCost()
         + ", subcontractCost="
         + this.getSubcontractCost()
         + ", leaseCost="
         + this.getLeaseCost()
         + ", indirectCost="
         + this.getIndirectCost()
         + ", otherCost="
         + this.getOtherCost()
         + ", capitalInterest="
         + this.getCapitalInterest()
         + ", managementFee="
         + this.getManagementFee()
         + ", materialExpenditure="
         + this.getMaterialExpenditure()
         + ", otherExpenditure="
         + this.getOtherExpenditure()
         + ", managementFeeDetail="
         + this.getManagementFeeDetail()
         + ")";
   }

   public ProjectCostReportDto(
      final ProjectInfo project,
      final BigDecimal contractAmount,
      final Long orderId,
      final BigDecimal settlementAmount,
      final BigDecimal totalExpenditure,
      final BigDecimal totalIncome,
      final BigDecimal profit,
      final BigDecimal profitRate,
      final BigDecimal materialCost,
      final BigDecimal materialCostRatio,
      final BigDecimal laborCost,
      final BigDecimal subcontractCost,
      final BigDecimal leaseCost,
      final BigDecimal indirectCost,
      final BigDecimal otherCost,
      final BigDecimal capitalInterest,
      final BigDecimal managementFee,
      final List<ProjectMaterialsAllDto> materialExpenditure,
      final List<ProjectElseAllDto> otherExpenditure,
      final List<ManagementFeeAllDto> managementFeeDetail
   ) {
      this.project = project;
      this.contractAmount = contractAmount;
      this.orderId = orderId;
      this.settlementAmount = settlementAmount;
      this.totalExpenditure = totalExpenditure;
      this.totalIncome = totalIncome;
      this.profit = profit;
      this.profitRate = profitRate;
      this.materialCost = materialCost;
      this.materialCostRatio = materialCostRatio;
      this.laborCost = laborCost;
      this.subcontractCost = subcontractCost;
      this.leaseCost = leaseCost;
      this.indirectCost = indirectCost;
      this.otherCost = otherCost;
      this.capitalInterest = capitalInterest;
      this.managementFee = managementFee;
      this.materialExpenditure = materialExpenditure;
      this.otherExpenditure = otherExpenditure;
      this.managementFeeDetail = managementFeeDetail;
   }

   public ProjectCostReportDto() {
   }

   public static class ProjectCostReportDtoBuilder {
      private ProjectInfo project;
      private BigDecimal contractAmount;
      private Long orderId;
      private BigDecimal settlementAmount;
      private BigDecimal totalExpenditure;
      private BigDecimal totalIncome;
      private BigDecimal profit;
      private BigDecimal profitRate;
      private BigDecimal materialCost;
      private BigDecimal materialCostRatio;
      private BigDecimal laborCost;
      private BigDecimal subcontractCost;
      private BigDecimal leaseCost;
      private BigDecimal indirectCost;
      private BigDecimal otherCost;
      private BigDecimal capitalInterest;
      private BigDecimal managementFee;
      private List<ProjectMaterialsAllDto> materialExpenditure;
      private List<ProjectElseAllDto> otherExpenditure;
      private List<ManagementFeeAllDto> managementFeeDetail;

      ProjectCostReportDtoBuilder() {
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder totalExpenditure(final BigDecimal totalExpenditure) {
         this.totalExpenditure = totalExpenditure;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder totalIncome(final BigDecimal totalIncome) {
         this.totalIncome = totalIncome;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder profit(final BigDecimal profit) {
         this.profit = profit;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder profitRate(final BigDecimal profitRate) {
         this.profitRate = profitRate;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder materialCost(final BigDecimal materialCost) {
         this.materialCost = materialCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder materialCostRatio(final BigDecimal materialCostRatio) {
         this.materialCostRatio = materialCostRatio;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder laborCost(final BigDecimal laborCost) {
         this.laborCost = laborCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder subcontractCost(final BigDecimal subcontractCost) {
         this.subcontractCost = subcontractCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder leaseCost(final BigDecimal leaseCost) {
         this.leaseCost = leaseCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder indirectCost(final BigDecimal indirectCost) {
         this.indirectCost = indirectCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder otherCost(final BigDecimal otherCost) {
         this.otherCost = otherCost;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder capitalInterest(final BigDecimal capitalInterest) {
         this.capitalInterest = capitalInterest;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder materialExpenditure(final List<ProjectMaterialsAllDto> materialExpenditure) {
         this.materialExpenditure = materialExpenditure;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder otherExpenditure(final List<ProjectElseAllDto> otherExpenditure) {
         this.otherExpenditure = otherExpenditure;
         return this;
      }

      public ProjectCostReportDto.ProjectCostReportDtoBuilder managementFeeDetail(final List<ManagementFeeAllDto> managementFeeDetail) {
         this.managementFeeDetail = managementFeeDetail;
         return this;
      }

      public ProjectCostReportDto build() {
         return new ProjectCostReportDto(
            this.project,
            this.contractAmount,
            this.orderId,
            this.settlementAmount,
            this.totalExpenditure,
            this.totalIncome,
            this.profit,
            this.profitRate,
            this.materialCost,
            this.materialCostRatio,
            this.laborCost,
            this.subcontractCost,
            this.leaseCost,
            this.indirectCost,
            this.otherCost,
            this.capitalInterest,
            this.managementFee,
            this.materialExpenditure,
            this.otherExpenditure,
            this.managementFeeDetail
         );
      }

      @Override
      public String toString() {
         return "ProjectCostReportDto.ProjectCostReportDtoBuilder(project="
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
            + ", materialCost="
            + this.materialCost
            + ", materialCostRatio="
            + this.materialCostRatio
            + ", laborCost="
            + this.laborCost
            + ", subcontractCost="
            + this.subcontractCost
            + ", leaseCost="
            + this.leaseCost
            + ", indirectCost="
            + this.indirectCost
            + ", otherCost="
            + this.otherCost
            + ", capitalInterest="
            + this.capitalInterest
            + ", managementFee="
            + this.managementFee
            + ", materialExpenditure="
            + this.materialExpenditure
            + ", otherExpenditure="
            + this.otherExpenditure
            + ", managementFeeDetail="
            + this.managementFeeDetail
            + ")";
      }
   }
}
