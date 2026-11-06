package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProcessLagDTO", description = "工序滞后数据")
public class MesBuildingProcessNoProcessDTO {
   @ApiModelProperty(name = "workshopId", value = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", value = "产线id")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名称")
   private String productionLineName;
   @ApiModelProperty(name = "teamId", value = "班组id")
   private Long teamId;
   @ApiModelProperty(name = "teamName", value = "班组名称")
   private String teamName;
   @ApiModelProperty(name = "deviceTypeName", value = "切割方式名称")
   private String deviceTypeName;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getDeviceTypeName() {
      return this.deviceTypeName;
   }

   public MesBuildingProcessNoProcessDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public MesBuildingProcessNoProcessDTO setDeviceTypeName(final String deviceTypeName) {
      this.deviceTypeName = deviceTypeName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessNoProcessDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", deviceTypeName="
         + this.getDeviceTypeName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessNoProcessDTO)) {
         return false;
      }

      MesBuildingProcessNoProcessDTO other = (MesBuildingProcessNoProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                  Object this$productionLineName = this.getProductionLineName();
                  Object other$productionLineName = other.getProductionLineName();
                  if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                     Object this$teamName = this.getTeamName();
                     Object other$teamName = other.getTeamName();
                     if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                        Object this$deviceTypeName = this.getDeviceTypeName();
                        Object other$deviceTypeName = other.getDeviceTypeName();
                        return this$deviceTypeName == null ? other$deviceTypeName == null : this$deviceTypeName.equals(other$deviceTypeName);
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
      return other instanceof MesBuildingProcessNoProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $deviceTypeName = this.getDeviceTypeName();
      return result * 59 + ($deviceTypeName == null ? 43 : $deviceTypeName.hashCode());
   }
}
