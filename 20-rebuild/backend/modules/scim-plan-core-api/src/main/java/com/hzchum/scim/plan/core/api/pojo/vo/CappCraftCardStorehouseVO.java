package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 工艺库 响应参数")
public class CappCraftCardStorehouseVO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   private Integer craftType;
   @ApiModelProperty(name = "processAttributes", value = "工艺属性参考枚举 CAPPProcessAttributesEnum", notes = "工艺属性参考枚举 CAPPProcessAttributesEnum")
   private Integer processAttributes;
   @ApiModelProperty(name = "projectName", value = "工程项目名称", notes = "工程项目名称")
   private String projectName;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingBaseJointType", value = "接头形式", notes = "接头形式")
   private String weldingBaseJointType;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "weldingBaseWeldingDeviceType", value = "焊接设备型号", notes = "焊接设备型号")
   private String weldingBaseWeldingDeviceType;
   @ApiModelProperty(name = "weldingBaseParentMaterialSteelGrade", value = "母材钢号", notes = "母材钢号")
   private String weldingBaseParentMaterialSteelGrade;
   @ApiModelProperty(name = "weldingBasePlateThicknessOrPipeDiameter", value = "板厚或管径X壁厚", notes = "板厚或管径X壁厚")
   private String weldingBasePlateThicknessOrPipeDiameter;
   @ApiModelProperty(name = "weldingBaseHotRollingOrHeatTreatmentStatus", value = "轧制或热处理状态", notes = "轧制或热处理状态")
   private String weldingBaseHotRollingOrHeatTreatmentStatus;
   @ApiModelProperty(name = "weldingBasePowerSupplyAndPolarity", value = "电源及极性", notes = "电源及极性")
   private String weldingBasePowerSupplyAndPolarity;
   @ApiModelProperty(name = "processStatus", value = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum", notes = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum")
   private Integer processStatus;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   private Boolean enabledFlag;
   @ApiModelProperty(name = "versionNumber", value = "字母版本号A~Z(暂不考虑超出如何处理)", notes = "字母版本号A~Z(暂不考虑超出如何处理)")
   private String versionNumber;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public Integer getProcessAttributes() {
      return this.processAttributes;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getWeldingBaseWeldingMethod() {
      return this.weldingBaseWeldingMethod;
   }

   public String getWeldingBaseJointType() {
      return this.weldingBaseJointType;
   }

   public String getWeldingBaseWeldingPosition() {
      return this.weldingBaseWeldingPosition;
   }

   public String getWeldingBaseWeldingDeviceType() {
      return this.weldingBaseWeldingDeviceType;
   }

   public String getWeldingBaseParentMaterialSteelGrade() {
      return this.weldingBaseParentMaterialSteelGrade;
   }

   public String getWeldingBasePlateThicknessOrPipeDiameter() {
      return this.weldingBasePlateThicknessOrPipeDiameter;
   }

   public String getWeldingBaseHotRollingOrHeatTreatmentStatus() {
      return this.weldingBaseHotRollingOrHeatTreatmentStatus;
   }

   public String getWeldingBasePowerSupplyAndPolarity() {
      return this.weldingBasePowerSupplyAndPolarity;
   }

   public Integer getProcessStatus() {
      return this.processStatus;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public String getVersionNumber() {
      return this.versionNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setProcessAttributes(final Integer processAttributes) {
      this.processAttributes = processAttributes;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
   }

   public void setWeldingBaseJointType(final String weldingBaseJointType) {
      this.weldingBaseJointType = weldingBaseJointType;
   }

   public void setWeldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
   }

   public void setWeldingBaseWeldingDeviceType(final String weldingBaseWeldingDeviceType) {
      this.weldingBaseWeldingDeviceType = weldingBaseWeldingDeviceType;
   }

   public void setWeldingBaseParentMaterialSteelGrade(final String weldingBaseParentMaterialSteelGrade) {
      this.weldingBaseParentMaterialSteelGrade = weldingBaseParentMaterialSteelGrade;
   }

   public void setWeldingBasePlateThicknessOrPipeDiameter(final String weldingBasePlateThicknessOrPipeDiameter) {
      this.weldingBasePlateThicknessOrPipeDiameter = weldingBasePlateThicknessOrPipeDiameter;
   }

   public void setWeldingBaseHotRollingOrHeatTreatmentStatus(final String weldingBaseHotRollingOrHeatTreatmentStatus) {
      this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
   }

   public void setWeldingBasePowerSupplyAndPolarity(final String weldingBasePowerSupplyAndPolarity) {
      this.weldingBasePowerSupplyAndPolarity = weldingBasePowerSupplyAndPolarity;
   }

   public void setProcessStatus(final Integer processStatus) {
      this.processStatus = processStatus;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   public void setVersionNumber(final String versionNumber) {
      this.versionNumber = versionNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseVO)) {
         return false;
      }

      CappCraftCardStorehouseVO other = (CappCraftCardStorehouseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$craftType = this.getCraftType();
         Object other$craftType = other.getCraftType();
         if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
            Object this$processAttributes = this.getProcessAttributes();
            Object other$processAttributes = other.getProcessAttributes();
            if (this$processAttributes == null ? other$processAttributes == null : this$processAttributes.equals(other$processAttributes)) {
               Object this$processStatus = this.getProcessStatus();
               Object other$processStatus = other.getProcessStatus();
               if (this$processStatus == null ? other$processStatus == null : this$processStatus.equals(other$processStatus)) {
                  Object this$enabledFlag = this.getEnabledFlag();
                  Object other$enabledFlag = other.getEnabledFlag();
                  if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$projectName = this.getProjectName();
                        Object other$projectName = other.getProjectName();
                        if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
                              Object other$weldingBaseWeldingMethod = other.getWeldingBaseWeldingMethod();
                              if (this$weldingBaseWeldingMethod == null
                                 ? other$weldingBaseWeldingMethod == null
                                 : this$weldingBaseWeldingMethod.equals(other$weldingBaseWeldingMethod)) {
                                 Object this$weldingBaseJointType = this.getWeldingBaseJointType();
                                 Object other$weldingBaseJointType = other.getWeldingBaseJointType();
                                 if (this$weldingBaseJointType == null
                                    ? other$weldingBaseJointType == null
                                    : this$weldingBaseJointType.equals(other$weldingBaseJointType)) {
                                    Object this$weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
                                    Object other$weldingBaseWeldingPosition = other.getWeldingBaseWeldingPosition();
                                    if (this$weldingBaseWeldingPosition == null
                                       ? other$weldingBaseWeldingPosition == null
                                       : this$weldingBaseWeldingPosition.equals(other$weldingBaseWeldingPosition)) {
                                       Object this$weldingBaseWeldingDeviceType = this.getWeldingBaseWeldingDeviceType();
                                       Object other$weldingBaseWeldingDeviceType = other.getWeldingBaseWeldingDeviceType();
                                       if (this$weldingBaseWeldingDeviceType == null
                                          ? other$weldingBaseWeldingDeviceType == null
                                          : this$weldingBaseWeldingDeviceType.equals(other$weldingBaseWeldingDeviceType)) {
                                          Object this$weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
                                          Object other$weldingBaseParentMaterialSteelGrade = other.getWeldingBaseParentMaterialSteelGrade();
                                          if (this$weldingBaseParentMaterialSteelGrade == null
                                             ? other$weldingBaseParentMaterialSteelGrade == null
                                             : this$weldingBaseParentMaterialSteelGrade.equals(other$weldingBaseParentMaterialSteelGrade)) {
                                             Object this$weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
                                             Object other$weldingBasePlateThicknessOrPipeDiameter = other.getWeldingBasePlateThicknessOrPipeDiameter();
                                             if (this$weldingBasePlateThicknessOrPipeDiameter == null
                                                ? other$weldingBasePlateThicknessOrPipeDiameter == null
                                                : this$weldingBasePlateThicknessOrPipeDiameter.equals(other$weldingBasePlateThicknessOrPipeDiameter)) {
                                                Object this$weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                                Object other$weldingBaseHotRollingOrHeatTreatmentStatus = other.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                                if (this$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                                   ? other$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                                   : this$weldingBaseHotRollingOrHeatTreatmentStatus.equals(other$weldingBaseHotRollingOrHeatTreatmentStatus)) {
                                                   Object this$weldingBasePowerSupplyAndPolarity = this.getWeldingBasePowerSupplyAndPolarity();
                                                   Object other$weldingBasePowerSupplyAndPolarity = other.getWeldingBasePowerSupplyAndPolarity();
                                                   if (this$weldingBasePowerSupplyAndPolarity == null
                                                      ? other$weldingBasePowerSupplyAndPolarity == null
                                                      : this$weldingBasePowerSupplyAndPolarity.equals(other$weldingBasePowerSupplyAndPolarity)) {
                                                      Object this$versionNumber = this.getVersionNumber();
                                                      Object other$versionNumber = other.getVersionNumber();
                                                      return this$versionNumber == null
                                                         ? other$versionNumber == null
                                                         : this$versionNumber.equals(other$versionNumber);
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
      return other instanceof CappCraftCardStorehouseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $processAttributes = this.getProcessAttributes();
      result = result * 59 + ($processAttributes == null ? 43 : $processAttributes.hashCode());
      Object $processStatus = this.getProcessStatus();
      result = result * 59 + ($processStatus == null ? 43 : $processStatus.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
      result = result * 59 + ($weldingBaseWeldingMethod == null ? 43 : $weldingBaseWeldingMethod.hashCode());
      Object $weldingBaseJointType = this.getWeldingBaseJointType();
      result = result * 59 + ($weldingBaseJointType == null ? 43 : $weldingBaseJointType.hashCode());
      Object $weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
      result = result * 59 + ($weldingBaseWeldingPosition == null ? 43 : $weldingBaseWeldingPosition.hashCode());
      Object $weldingBaseWeldingDeviceType = this.getWeldingBaseWeldingDeviceType();
      result = result * 59 + ($weldingBaseWeldingDeviceType == null ? 43 : $weldingBaseWeldingDeviceType.hashCode());
      Object $weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
      result = result * 59 + ($weldingBaseParentMaterialSteelGrade == null ? 43 : $weldingBaseParentMaterialSteelGrade.hashCode());
      Object $weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
      result = result * 59 + ($weldingBasePlateThicknessOrPipeDiameter == null ? 43 : $weldingBasePlateThicknessOrPipeDiameter.hashCode());
      Object $weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
      result = result * 59 + ($weldingBaseHotRollingOrHeatTreatmentStatus == null ? 43 : $weldingBaseHotRollingOrHeatTreatmentStatus.hashCode());
      Object $weldingBasePowerSupplyAndPolarity = this.getWeldingBasePowerSupplyAndPolarity();
      result = result * 59 + ($weldingBasePowerSupplyAndPolarity == null ? 43 : $weldingBasePowerSupplyAndPolarity.hashCode());
      Object $versionNumber = this.getVersionNumber();
      return result * 59 + ($versionNumber == null ? 43 : $versionNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseVO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", craftType="
         + this.getCraftType()
         + ", processAttributes="
         + this.getProcessAttributes()
         + ", projectName="
         + this.getProjectName()
         + ", processName="
         + this.getProcessName()
         + ", weldingBaseWeldingMethod="
         + this.getWeldingBaseWeldingMethod()
         + ", weldingBaseJointType="
         + this.getWeldingBaseJointType()
         + ", weldingBaseWeldingPosition="
         + this.getWeldingBaseWeldingPosition()
         + ", weldingBaseWeldingDeviceType="
         + this.getWeldingBaseWeldingDeviceType()
         + ", weldingBaseParentMaterialSteelGrade="
         + this.getWeldingBaseParentMaterialSteelGrade()
         + ", weldingBasePlateThicknessOrPipeDiameter="
         + this.getWeldingBasePlateThicknessOrPipeDiameter()
         + ", weldingBaseHotRollingOrHeatTreatmentStatus="
         + this.getWeldingBaseHotRollingOrHeatTreatmentStatus()
         + ", weldingBasePowerSupplyAndPolarity="
         + this.getWeldingBasePowerSupplyAndPolarity()
         + ", processStatus="
         + this.getProcessStatus()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ", versionNumber="
         + this.getVersionNumber()
         + ")";
   }
}
