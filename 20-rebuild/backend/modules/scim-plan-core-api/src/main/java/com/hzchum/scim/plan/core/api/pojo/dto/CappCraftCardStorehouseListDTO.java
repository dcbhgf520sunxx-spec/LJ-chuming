package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 工艺库 列表查询 请求参数")
public class CappCraftCardStorehouseListDTO {
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   private Integer craftType;
   @ApiModelProperty(name = "processAttributes", value = "工艺属性参考枚举 CappProcessAttributesEnum", notes = "工艺属性参考枚举 CappProcessAttributesEnum")
   private Integer processAttributes;
   @ApiModelProperty(name = "processStatus", value = "工艺状态 1正常状态 2草稿状态 参考枚举 CappProcessStatusEnum", notes = "工艺状态 1正常状态 2草稿状态 参考枚举 CappProcessStatusEnum")
   private Integer processStatus;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   private Boolean enabledFlag;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "weldingBaseJointType", value = "接头形式", notes = "接头形式")
   private String weldingBaseJointType;
   @ApiModelProperty(name = "processId", value = "关联工序", notes = "关联工序")
   private Long processId;
   @ApiModelProperty(name = "projectId", value = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)", notes = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)")
   private Long projectId;
   @ApiModelProperty(name = "weldingBaseHotRollingOrHeatTreatmentStatus", value = "轧制或热处理状态", notes = "轧制或热处理状态")
   private String weldingBaseHotRollingOrHeatTreatmentStatus;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "weldingBaseWeldingDeviceType", value = "焊接设备型号", notes = "焊接设备型号")
   private String weldingBaseWeldingDeviceType;
   @ApiModelProperty(name = "weldingBaseParentMaterialSteelGrade", value = "母材钢号", notes = "母材钢号")
   private String weldingBaseParentMaterialSteelGrade;
   @ApiModelProperty(name = "weldingBasePlateThicknessOrPipeDiameter", value = "板厚或管径X壁厚", notes = "板厚或管径X壁厚")
   private String weldingBasePlateThicknessOrPipeDiameter;
   @ApiModelProperty(name = "pageNumber", value = "页码", notes = "页码")
   private Integer pageNumber;
   @ApiModelProperty(name = "pageSize", value = "每页数量", notes = "每页数量")
   private Integer pageSize;

   public Integer getCraftType() {
      return this.craftType;
   }

   public Integer getProcessAttributes() {
      return this.processAttributes;
   }

   public Integer getProcessStatus() {
      return this.processStatus;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getWeldingBaseJointType() {
      return this.weldingBaseJointType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getWeldingBaseHotRollingOrHeatTreatmentStatus() {
      return this.weldingBaseHotRollingOrHeatTreatmentStatus;
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

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setProcessAttributes(final Integer processAttributes) {
      this.processAttributes = processAttributes;
   }

   public void setProcessStatus(final Integer processStatus) {
      this.processStatus = processStatus;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWeldingBaseJointType(final String weldingBaseJointType) {
      this.weldingBaseJointType = weldingBaseJointType;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWeldingBaseHotRollingOrHeatTreatmentStatus(final String weldingBaseHotRollingOrHeatTreatmentStatus) {
      this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
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

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseListDTO)) {
         return false;
      }

      CappCraftCardStorehouseListDTO other = (CappCraftCardStorehouseListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$pageNumber = this.getPageNumber();
                        Object other$pageNumber = other.getPageNumber();
                        if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                           Object this$pageSize = this.getPageSize();
                           Object other$pageSize = other.getPageSize();
                           if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$weldingBaseJointType = this.getWeldingBaseJointType();
                                 Object other$weldingBaseJointType = other.getWeldingBaseJointType();
                                 if (this$weldingBaseJointType == null
                                    ? other$weldingBaseJointType == null
                                    : this$weldingBaseJointType.equals(other$weldingBaseJointType)) {
                                    Object this$weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                    Object other$weldingBaseHotRollingOrHeatTreatmentStatus = other.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                    if (this$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                       ? other$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                       : this$weldingBaseHotRollingOrHeatTreatmentStatus.equals(other$weldingBaseHotRollingOrHeatTreatmentStatus)) {
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
                                                return this$weldingBasePlateThicknessOrPipeDiameter == null
                                                   ? other$weldingBasePlateThicknessOrPipeDiameter == null
                                                   : this$weldingBasePlateThicknessOrPipeDiameter.equals(other$weldingBasePlateThicknessOrPipeDiameter);
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
      return other instanceof CappCraftCardStorehouseListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $processAttributes = this.getProcessAttributes();
      result = result * 59 + ($processAttributes == null ? 43 : $processAttributes.hashCode());
      Object $processStatus = this.getProcessStatus();
      result = result * 59 + ($processStatus == null ? 43 : $processStatus.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $weldingBaseJointType = this.getWeldingBaseJointType();
      result = result * 59 + ($weldingBaseJointType == null ? 43 : $weldingBaseJointType.hashCode());
      Object $weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
      result = result * 59 + ($weldingBaseHotRollingOrHeatTreatmentStatus == null ? 43 : $weldingBaseHotRollingOrHeatTreatmentStatus.hashCode());
      Object $weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
      result = result * 59 + ($weldingBaseWeldingPosition == null ? 43 : $weldingBaseWeldingPosition.hashCode());
      Object $weldingBaseWeldingDeviceType = this.getWeldingBaseWeldingDeviceType();
      result = result * 59 + ($weldingBaseWeldingDeviceType == null ? 43 : $weldingBaseWeldingDeviceType.hashCode());
      Object $weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
      result = result * 59 + ($weldingBaseParentMaterialSteelGrade == null ? 43 : $weldingBaseParentMaterialSteelGrade.hashCode());
      Object $weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
      return result * 59 + ($weldingBasePlateThicknessOrPipeDiameter == null ? 43 : $weldingBasePlateThicknessOrPipeDiameter.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseListDTO(craftType="
         + this.getCraftType()
         + ", processAttributes="
         + this.getProcessAttributes()
         + ", processStatus="
         + this.getProcessStatus()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", weldingBaseJointType="
         + this.getWeldingBaseJointType()
         + ", processId="
         + this.getProcessId()
         + ", projectId="
         + this.getProjectId()
         + ", weldingBaseHotRollingOrHeatTreatmentStatus="
         + this.getWeldingBaseHotRollingOrHeatTreatmentStatus()
         + ", weldingBaseWeldingPosition="
         + this.getWeldingBaseWeldingPosition()
         + ", weldingBaseWeldingDeviceType="
         + this.getWeldingBaseWeldingDeviceType()
         + ", weldingBaseParentMaterialSteelGrade="
         + this.getWeldingBaseParentMaterialSteelGrade()
         + ", weldingBasePlateThicknessOrPipeDiameter="
         + this.getWeldingBasePlateThicknessOrPipeDiameter()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
