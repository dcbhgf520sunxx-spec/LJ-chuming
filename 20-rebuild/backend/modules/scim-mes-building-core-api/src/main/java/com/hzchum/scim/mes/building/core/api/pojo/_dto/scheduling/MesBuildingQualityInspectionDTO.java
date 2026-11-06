package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingQualityInspectionDTO", description = "质检数据")
public class MesBuildingQualityInspectionDTO {
   @ApiModelProperty(name = "serialCode", value = "项目编号")
   private String serialCode;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   private String processName;
   @ApiModelProperty(name = "inspectUserName", value = "质检人")
   private String inspectUserName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;

   public String getSerialCode() {
      return this.serialCode;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public MesBuildingQualityInspectionDTO setSerialCode(final String serialCode) {
      this.serialCode = serialCode;
      return this;
   }

   public MesBuildingQualityInspectionDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public MesBuildingQualityInspectionDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public MesBuildingQualityInspectionDTO setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
      return this;
   }

   public MesBuildingQualityInspectionDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQualityInspectionDTO(serialCode="
         + this.getSerialCode()
         + ", shortName="
         + this.getShortName()
         + ", processName="
         + this.getProcessName()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQualityInspectionDTO)) {
         return false;
      }

      MesBuildingQualityInspectionDTO other = (MesBuildingQualityInspectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialCode = this.getSerialCode();
      Object other$serialCode = other.getSerialCode();
      if (this$serialCode == null ? other$serialCode == null : this$serialCode.equals(other$serialCode)) {
         Object this$shortName = this.getShortName();
         Object other$shortName = other.getShortName();
         if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$inspectUserName = this.getInspectUserName();
               Object other$inspectUserName = other.getInspectUserName();
               if (this$inspectUserName == null ? other$inspectUserName == null : this$inspectUserName.equals(other$inspectUserName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof MesBuildingQualityInspectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialCode = this.getSerialCode();
      result = result * 59 + ($serialCode == null ? 43 : $serialCode.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      result = result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }
}
