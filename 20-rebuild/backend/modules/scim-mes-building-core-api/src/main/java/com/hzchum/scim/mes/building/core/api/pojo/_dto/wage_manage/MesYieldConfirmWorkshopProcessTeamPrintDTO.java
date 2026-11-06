package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("产量确认打印DTO类")
public class MesYieldConfirmWorkshopProcessTeamPrintDTO {
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   private Long workshopId;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组ID", notes = "班组ID")
   private Long teamId;
   @ApiModelProperty(name = "productType", value = "产品类型(ProductTypeEnum)", notes = "产品类型(ProductTypeEnum)")
   private Integer productType;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "teamLeaderUserName", value = "班组组长名称", notes = "班组组长名称")
   private String teamLeaderUserName;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检通过数量", notes = "质检通过数量")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "totalWage", value = "工价总额（元）", notes = "工价总额（元）")
   private BigDecimal totalWage;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamLeaderUserName() {
      return this.teamLeaderUserName;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTeamLeaderUserName(final String teamLeaderUserName) {
      this.teamLeaderUserName = teamLeaderUserName;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesYieldConfirmWorkshopProcessTeamPrintDTO)) {
         return false;
      }

      MesYieldConfirmWorkshopProcessTeamPrintDTO other = (MesYieldConfirmWorkshopProcessTeamPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                           Object this$teamLeaderUserName = this.getTeamLeaderUserName();
                           Object other$teamLeaderUserName = other.getTeamLeaderUserName();
                           if (this$teamLeaderUserName == null ? other$teamLeaderUserName == null : this$teamLeaderUserName.equals(other$teamLeaderUserName)) {
                              Object this$totalWage = this.getTotalWage();
                              Object other$totalWage = other.getTotalWage();
                              return this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage);
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
      return other instanceof MesYieldConfirmWorkshopProcessTeamPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamLeaderUserName = this.getTeamLeaderUserName();
      result = result * 59 + ($teamLeaderUserName == null ? 43 : $teamLeaderUserName.hashCode());
      Object $totalWage = this.getTotalWage();
      return result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
   }

   @Override
   public String toString() {
      return "MesYieldConfirmWorkshopProcessTeamPrintDTO(workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", productType="
         + this.getProductType()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processName="
         + this.getProcessName()
         + ", teamLeaderUserName="
         + this.getTeamLeaderUserName()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", totalWage="
         + this.getTotalWage()
         + ")";
   }
}
