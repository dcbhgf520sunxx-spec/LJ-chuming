package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

@ApiModel(description = "CAPP 焊接材料 新增 请求参数")
public class CappCraftCardStorehouseMaterialsLinkSaveDTO {
   @ApiModelProperty(name = "weldingMaterialName", value = "焊接/施焊材料", notes = "焊接/施焊材料")
   @Size(max = 200, message = "焊接/施焊材料不能超过200个字符")
   private String weldingMaterialName;
   @ApiModelProperty(name = "weldingMaterialManufacturingPlant", value = "生产厂", notes = "生产厂")
   @Size(max = 200, message = "生产厂不能超过200个字符")
   private String weldingMaterialManufacturingPlant;
   @ApiModelProperty(name = "weldingMaterialTrademark", value = "牌号", notes = "牌号")
   @Size(max = 200, message = "牌号不能超过200个字符")
   private String weldingMaterialTrademark;
   @ApiModelProperty(name = "weldingMaterialModel", value = "型号", notes = "型号")
   @Size(max = 200, message = "型号不能超过200个字符")
   private String weldingMaterialModel;
   @ApiModelProperty(name = "weldingMaterialType", value = "类型", notes = "类型")
   @Size(max = 200, message = "类型不能超过200个字符")
   private String weldingMaterialType;
   @ApiModelProperty(name = "weldingMaterialDryingProcedure", value = "烘干制度(℃×h)", notes = "烘干制度(℃×h)")
   @Size(max = 200, message = "烘干制度(℃×h)不能超过200个字符")
   private String weldingMaterialDryingProcedure;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 200, message = "备注不能超过200个字符")
   private String remark;

   public String getWeldingMaterialName() {
      return this.weldingMaterialName;
   }

   public String getWeldingMaterialManufacturingPlant() {
      return this.weldingMaterialManufacturingPlant;
   }

   public String getWeldingMaterialTrademark() {
      return this.weldingMaterialTrademark;
   }

   public String getWeldingMaterialModel() {
      return this.weldingMaterialModel;
   }

   public String getWeldingMaterialType() {
      return this.weldingMaterialType;
   }

   public String getWeldingMaterialDryingProcedure() {
      return this.weldingMaterialDryingProcedure;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setWeldingMaterialName(final String weldingMaterialName) {
      this.weldingMaterialName = weldingMaterialName;
   }

   public void setWeldingMaterialManufacturingPlant(final String weldingMaterialManufacturingPlant) {
      this.weldingMaterialManufacturingPlant = weldingMaterialManufacturingPlant;
   }

   public void setWeldingMaterialTrademark(final String weldingMaterialTrademark) {
      this.weldingMaterialTrademark = weldingMaterialTrademark;
   }

   public void setWeldingMaterialModel(final String weldingMaterialModel) {
      this.weldingMaterialModel = weldingMaterialModel;
   }

   public void setWeldingMaterialType(final String weldingMaterialType) {
      this.weldingMaterialType = weldingMaterialType;
   }

   public void setWeldingMaterialDryingProcedure(final String weldingMaterialDryingProcedure) {
      this.weldingMaterialDryingProcedure = weldingMaterialDryingProcedure;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseMaterialsLinkSaveDTO)) {
         return false;
      }

      CappCraftCardStorehouseMaterialsLinkSaveDTO other = (CappCraftCardStorehouseMaterialsLinkSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$weldingMaterialName = this.getWeldingMaterialName();
      Object other$weldingMaterialName = other.getWeldingMaterialName();
      if (this$weldingMaterialName == null ? other$weldingMaterialName == null : this$weldingMaterialName.equals(other$weldingMaterialName)) {
         Object this$weldingMaterialManufacturingPlant = this.getWeldingMaterialManufacturingPlant();
         Object other$weldingMaterialManufacturingPlant = other.getWeldingMaterialManufacturingPlant();
         if (this$weldingMaterialManufacturingPlant == null
            ? other$weldingMaterialManufacturingPlant == null
            : this$weldingMaterialManufacturingPlant.equals(other$weldingMaterialManufacturingPlant)) {
            Object this$weldingMaterialTrademark = this.getWeldingMaterialTrademark();
            Object other$weldingMaterialTrademark = other.getWeldingMaterialTrademark();
            if (this$weldingMaterialTrademark == null
               ? other$weldingMaterialTrademark == null
               : this$weldingMaterialTrademark.equals(other$weldingMaterialTrademark)) {
               Object this$weldingMaterialModel = this.getWeldingMaterialModel();
               Object other$weldingMaterialModel = other.getWeldingMaterialModel();
               if (this$weldingMaterialModel == null ? other$weldingMaterialModel == null : this$weldingMaterialModel.equals(other$weldingMaterialModel)) {
                  Object this$weldingMaterialType = this.getWeldingMaterialType();
                  Object other$weldingMaterialType = other.getWeldingMaterialType();
                  if (this$weldingMaterialType == null ? other$weldingMaterialType == null : this$weldingMaterialType.equals(other$weldingMaterialType)) {
                     Object this$weldingMaterialDryingProcedure = this.getWeldingMaterialDryingProcedure();
                     Object other$weldingMaterialDryingProcedure = other.getWeldingMaterialDryingProcedure();
                     if (this$weldingMaterialDryingProcedure == null
                        ? other$weldingMaterialDryingProcedure == null
                        : this$weldingMaterialDryingProcedure.equals(other$weldingMaterialDryingProcedure)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof CappCraftCardStorehouseMaterialsLinkSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weldingMaterialName = this.getWeldingMaterialName();
      result = result * 59 + ($weldingMaterialName == null ? 43 : $weldingMaterialName.hashCode());
      Object $weldingMaterialManufacturingPlant = this.getWeldingMaterialManufacturingPlant();
      result = result * 59 + ($weldingMaterialManufacturingPlant == null ? 43 : $weldingMaterialManufacturingPlant.hashCode());
      Object $weldingMaterialTrademark = this.getWeldingMaterialTrademark();
      result = result * 59 + ($weldingMaterialTrademark == null ? 43 : $weldingMaterialTrademark.hashCode());
      Object $weldingMaterialModel = this.getWeldingMaterialModel();
      result = result * 59 + ($weldingMaterialModel == null ? 43 : $weldingMaterialModel.hashCode());
      Object $weldingMaterialType = this.getWeldingMaterialType();
      result = result * 59 + ($weldingMaterialType == null ? 43 : $weldingMaterialType.hashCode());
      Object $weldingMaterialDryingProcedure = this.getWeldingMaterialDryingProcedure();
      result = result * 59 + ($weldingMaterialDryingProcedure == null ? 43 : $weldingMaterialDryingProcedure.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseMaterialsLinkSaveDTO(weldingMaterialName="
         + this.getWeldingMaterialName()
         + ", weldingMaterialManufacturingPlant="
         + this.getWeldingMaterialManufacturingPlant()
         + ", weldingMaterialTrademark="
         + this.getWeldingMaterialTrademark()
         + ", weldingMaterialModel="
         + this.getWeldingMaterialModel()
         + ", weldingMaterialType="
         + this.getWeldingMaterialType()
         + ", weldingMaterialDryingProcedure="
         + this.getWeldingMaterialDryingProcedure()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
