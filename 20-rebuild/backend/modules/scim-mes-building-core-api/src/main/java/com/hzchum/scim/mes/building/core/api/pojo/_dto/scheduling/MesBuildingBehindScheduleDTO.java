package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingBehindScheduleDTO", description = "计划滞后")
public class MesBuildingBehindScheduleDTO {
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "businessType", value = "订单类型")
   private Integer businessType;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "shortName", value = "简称")
   private String shortName;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "projectPlanProductCategory", value = "项目计划制品类别")
   private Integer projectPlanProductCategory;
   @ApiModelProperty(name = "endDate", value = "结束时间")
   private LocalDateTime endDate;

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getProjectPlanProductCategory() {
      return this.projectPlanProductCategory;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public MesBuildingBehindScheduleDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingBehindScheduleDTO setBusinessType(final Integer businessType) {
      this.businessType = businessType;
      return this;
   }

   public MesBuildingBehindScheduleDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingBehindScheduleDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public MesBuildingBehindScheduleDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MesBuildingBehindScheduleDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MesBuildingBehindScheduleDTO setProjectPlanProductCategory(final Integer projectPlanProductCategory) {
      this.projectPlanProductCategory = projectPlanProductCategory;
      return this;
   }

   public MesBuildingBehindScheduleDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBehindScheduleDTO(areaId="
         + this.getAreaId()
         + ", businessType="
         + this.getBusinessType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", projectPlanProductCategory="
         + this.getProjectPlanProductCategory()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBehindScheduleDTO)) {
         return false;
      }

      MesBuildingBehindScheduleDTO other = (MesBuildingBehindScheduleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$projectPlanProductCategory = this.getProjectPlanProductCategory();
            Object other$projectPlanProductCategory = other.getProjectPlanProductCategory();
            if (this$projectPlanProductCategory == null
               ? other$projectPlanProductCategory == null
               : this$projectPlanProductCategory.equals(other$projectPlanProductCategory)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof MesBuildingBehindScheduleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectPlanProductCategory = this.getProjectPlanProductCategory();
      result = result * 59 + ($projectPlanProductCategory == null ? 43 : $projectPlanProductCategory.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }
}
