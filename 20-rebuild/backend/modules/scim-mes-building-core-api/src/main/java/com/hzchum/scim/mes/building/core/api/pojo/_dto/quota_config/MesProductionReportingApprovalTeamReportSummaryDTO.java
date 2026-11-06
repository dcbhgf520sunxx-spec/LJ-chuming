package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("报工审核班组上报汇总信息DTO")
public class MesProductionReportingApprovalTeamReportSummaryDTO {
   @ApiModelProperty("车间")
   private ShowInfo workshop;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("班组")
   private ShowInfo team;
   @ApiModelProperty("上报数量")
   private BigDecimal reportQuantity;

   public ShowInfo getWorkshop() {
      return this.workshop;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public void setWorkshop(final ShowInfo workshop) {
      this.workshop = workshop;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   public void setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalTeamReportSummaryDTO)) {
         return false;
      }

      MesProductionReportingApprovalTeamReportSummaryDTO other = (MesProductionReportingApprovalTeamReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$workshop = this.getWorkshop();
         Object other$workshop = other.getWorkshop();
         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                  Object this$reportQuantity = this.getReportQuantity();
                  Object other$reportQuantity = other.getReportQuantity();
                  return this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity);
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
      return other instanceof MesProductionReportingApprovalTeamReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      return result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalTeamReportSummaryDTO(workshop="
         + this.getWorkshop()
         + ", process="
         + this.getProcess()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", team="
         + this.getTeam()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ")";
   }
}
