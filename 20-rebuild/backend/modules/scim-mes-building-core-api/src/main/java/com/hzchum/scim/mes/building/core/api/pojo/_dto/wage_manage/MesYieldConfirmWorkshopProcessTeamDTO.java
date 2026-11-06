package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("产量确认表DTO类")
public class MesYieldConfirmWorkshopProcessTeamDTO {
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   private Long workshopId;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   private Long processId;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "teamLeaderName", value = "班组组长名称", notes = "班组组长名称")
   private String teamLeaderName;
   @ApiModelProperty(name = "totalQuantity", value = "总数量", notes = "总数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "productType", value = "产品类型(ProductTypeEnum)", notes = "产品类型(ProductTypeEnum)")
   private Integer productType;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesYieldConfirmWorkshopProcessTeamDTO)) {
         return false;
      }

      MesYieldConfirmWorkshopProcessTeamDTO other = (MesYieldConfirmWorkshopProcessTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$workshopName = this.getWorkshopName();
                  Object other$workshopName = other.getWorkshopName();
                  if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                     Object this$processName = this.getProcessName();
                     Object other$processName = other.getProcessName();
                     if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                        Object this$teamLeaderName = this.getTeamLeaderName();
                        Object other$teamLeaderName = other.getTeamLeaderName();
                        return this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName);
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
      return other instanceof MesYieldConfirmWorkshopProcessTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   @Override
   public String toString() {
      return "MesYieldConfirmWorkshopProcessTeamDTO(workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processName="
         + this.getProcessName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", productType="
         + this.getProductType()
         + ")";
   }
}
