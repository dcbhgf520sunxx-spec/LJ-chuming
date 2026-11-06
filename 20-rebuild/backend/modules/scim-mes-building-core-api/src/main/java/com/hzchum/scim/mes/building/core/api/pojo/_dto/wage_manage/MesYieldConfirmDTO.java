package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("产量确认-车间工序班组DTO类")
public class MesYieldConfirmDTO extends MesProductionWage {
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称", notes = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "typeName", value = "类型名称", notes = "类型名称")
   private String typeName;
   @ApiModelProperty(name = "measurementUnit", value = "计量单位", notes = "计量单位")
   private String measurementUnit;

   public String getMeasurementUnit() {
      return StrUtil.blankToDefault(this.measurementUnit, this.getMeasurementUnit(this.getMeasurementManner()));
   }

   private String getMeasurementUnit(Integer measurementManner) {
      WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(measurementManner);
      if (typeEnum != null) {
         switch (typeEnum) {
            case WEIGHT_PRICE:
               return "吨";
            case LENGTH_PRICE:
               return "米";
            case QUANTITY_PRICE:
               return "件";
            case AREA_PRICE:
               return "平方米";
         }
      }

      return null;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesYieldConfirmDTO)) {
         return false;
      }

      MesYieldConfirmDTO other = (MesYieldConfirmDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$projectSerialNumber = this.getProjectSerialNumber();
         Object other$projectSerialNumber = other.getProjectSerialNumber();
         if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$monomerName = this.getMonomerName();
               Object other$monomerName = other.getMonomerName();
               if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                  Object this$areaName = this.getAreaName();
                  Object other$areaName = other.getAreaName();
                  if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                     Object this$typeName = this.getTypeName();
                     Object other$typeName = other.getTypeName();
                     if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
                        Object this$measurementUnit = this.getMeasurementUnit();
                        Object other$measurementUnit = other.getMeasurementUnit();
                        return this$measurementUnit == null ? other$measurementUnit == null : this$measurementUnit.equals(other$measurementUnit);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesYieldConfirmDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $measurementUnit = this.getMeasurementUnit();
      return result * 59 + ($measurementUnit == null ? 43 : $measurementUnit.hashCode());
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setMeasurementUnit(final String measurementUnit) {
      this.measurementUnit = measurementUnit;
   }

   @Override
   public String toString() {
      return "MesYieldConfirmDTO(super="
         + super.toString()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", quantity="
         + this.getQuantity()
         + ", typeName="
         + this.getTypeName()
         + ", measurementUnit="
         + this.getMeasurementUnit()
         + ")";
   }
}
