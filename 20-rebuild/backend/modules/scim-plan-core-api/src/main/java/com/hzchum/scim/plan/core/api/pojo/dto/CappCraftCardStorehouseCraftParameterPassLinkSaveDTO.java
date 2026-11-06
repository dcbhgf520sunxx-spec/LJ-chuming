package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "CAPP 焊接工艺参数 新增 请求参数")
public class CappCraftCardStorehouseCraftParameterPassLinkSaveDTO {
   @ApiModelProperty(name = "weldingCraftParameterPass", value = "道次", notes = "道次")
   @NotNull(message = "道次不能为空")
   @Size(max = 200, message = "道次不能超过200个字符")
   private String weldingCraftParameterPass;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   @Size(max = 200, message = "焊接方法不能超过200个字符")
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingMaterialTrademark", value = "牌号", notes = "牌号")
   @Size(max = 200, message = "牌号不能超过200个字符")
   private String weldingMaterialTrademark;
   @ApiModelProperty(name = "weldingCraftParameterRodOrWireDesignation", value = "直径φ(mm)", notes = "直径φ(mm)")
   @Size(max = 200, message = "直径φ(mm)不能超过200个字符")
   private String weldingCraftParameterRodOrWireDesignation;
   @ApiModelProperty(name = "weldingCraftParameterWeldingFluxOrShieldingGas", value = "焊剂或保护气", notes = "焊剂或保护气")
   @Size(max = 200, message = "焊剂或保护气不能超过200个字符")
   private String weldingCraftParameterWeldingFluxOrShieldingGas;
   @ApiModelProperty(name = "weldingCraftParameterShieldingGasFlow", value = "保护气体流量(L/min)", notes = "保护气体流量(L/min)")
   @Size(max = 200, message = "保护气体流量(L/min)不能超过200个字符")
   private String weldingCraftParameterShieldingGasFlow;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   @NotNull(message = "电流(A)不能为空")
   @Size(max = 200, message = "电流(A)不能超过200个字符")
   private String electricity;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   @NotNull(message = "电压(V)不能为空")
   @Size(max = 200, message = "电压(V)不能超过200个字符")
   private String voltage;
   @ApiModelProperty(name = "weldingSpeed", value = "焊接速度(cm/min)", notes = "焊接速度(cm/min)")
   @Size(max = 200, message = "焊接速度(cm/min)不能超过200个字符")
   private String weldingSpeed;
   @ApiModelProperty(name = "thermalInput", value = "热输入(kj/cm)", notes = "热输入(kj/cm)")
   @Size(max = 200, message = "热输入(kj/cm)不能超过200个字符")
   private String thermalInput;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 200, message = "备注不能超过200个字符")
   private String remark;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public String getWeldingCraftParameterPass() {
      return this.weldingCraftParameterPass;
   }

   public String getWeldingBaseWeldingMethod() {
      return this.weldingBaseWeldingMethod;
   }

   public String getWeldingMaterialTrademark() {
      return this.weldingMaterialTrademark;
   }

   public String getWeldingCraftParameterRodOrWireDesignation() {
      return this.weldingCraftParameterRodOrWireDesignation;
   }

   public String getWeldingCraftParameterWeldingFluxOrShieldingGas() {
      return this.weldingCraftParameterWeldingFluxOrShieldingGas;
   }

   public String getWeldingCraftParameterShieldingGasFlow() {
      return this.weldingCraftParameterShieldingGasFlow;
   }

   public String getElectricity() {
      return this.electricity;
   }

   public String getVoltage() {
      return this.voltage;
   }

   public String getWeldingSpeed() {
      return this.weldingSpeed;
   }

   public String getThermalInput() {
      return this.thermalInput;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setWeldingCraftParameterPass(final String weldingCraftParameterPass) {
      this.weldingCraftParameterPass = weldingCraftParameterPass;
   }

   public void setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
   }

   public void setWeldingMaterialTrademark(final String weldingMaterialTrademark) {
      this.weldingMaterialTrademark = weldingMaterialTrademark;
   }

   public void setWeldingCraftParameterRodOrWireDesignation(final String weldingCraftParameterRodOrWireDesignation) {
      this.weldingCraftParameterRodOrWireDesignation = weldingCraftParameterRodOrWireDesignation;
   }

   public void setWeldingCraftParameterWeldingFluxOrShieldingGas(final String weldingCraftParameterWeldingFluxOrShieldingGas) {
      this.weldingCraftParameterWeldingFluxOrShieldingGas = weldingCraftParameterWeldingFluxOrShieldingGas;
   }

   public void setWeldingCraftParameterShieldingGasFlow(final String weldingCraftParameterShieldingGasFlow) {
      this.weldingCraftParameterShieldingGasFlow = weldingCraftParameterShieldingGasFlow;
   }

   public void setElectricity(final String electricity) {
      this.electricity = electricity;
   }

   public void setVoltage(final String voltage) {
      this.voltage = voltage;
   }

   public void setWeldingSpeed(final String weldingSpeed) {
      this.weldingSpeed = weldingSpeed;
   }

   public void setThermalInput(final String thermalInput) {
      this.thermalInput = thermalInput;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseCraftParameterPassLinkSaveDTO)) {
         return false;
      }

      CappCraftCardStorehouseCraftParameterPassLinkSaveDTO other = (CappCraftCardStorehouseCraftParameterPassLinkSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$weldingCraftParameterPass = this.getWeldingCraftParameterPass();
         Object other$weldingCraftParameterPass = other.getWeldingCraftParameterPass();
         if (this$weldingCraftParameterPass == null
            ? other$weldingCraftParameterPass == null
            : this$weldingCraftParameterPass.equals(other$weldingCraftParameterPass)) {
            Object this$weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
            Object other$weldingBaseWeldingMethod = other.getWeldingBaseWeldingMethod();
            if (this$weldingBaseWeldingMethod == null
               ? other$weldingBaseWeldingMethod == null
               : this$weldingBaseWeldingMethod.equals(other$weldingBaseWeldingMethod)) {
               Object this$weldingMaterialTrademark = this.getWeldingMaterialTrademark();
               Object other$weldingMaterialTrademark = other.getWeldingMaterialTrademark();
               if (this$weldingMaterialTrademark == null
                  ? other$weldingMaterialTrademark == null
                  : this$weldingMaterialTrademark.equals(other$weldingMaterialTrademark)) {
                  Object this$weldingCraftParameterRodOrWireDesignation = this.getWeldingCraftParameterRodOrWireDesignation();
                  Object other$weldingCraftParameterRodOrWireDesignation = other.getWeldingCraftParameterRodOrWireDesignation();
                  if (this$weldingCraftParameterRodOrWireDesignation == null
                     ? other$weldingCraftParameterRodOrWireDesignation == null
                     : this$weldingCraftParameterRodOrWireDesignation.equals(other$weldingCraftParameterRodOrWireDesignation)) {
                     Object this$weldingCraftParameterWeldingFluxOrShieldingGas = this.getWeldingCraftParameterWeldingFluxOrShieldingGas();
                     Object other$weldingCraftParameterWeldingFluxOrShieldingGas = other.getWeldingCraftParameterWeldingFluxOrShieldingGas();
                     if (this$weldingCraftParameterWeldingFluxOrShieldingGas == null
                        ? other$weldingCraftParameterWeldingFluxOrShieldingGas == null
                        : this$weldingCraftParameterWeldingFluxOrShieldingGas.equals(other$weldingCraftParameterWeldingFluxOrShieldingGas)) {
                        Object this$weldingCraftParameterShieldingGasFlow = this.getWeldingCraftParameterShieldingGasFlow();
                        Object other$weldingCraftParameterShieldingGasFlow = other.getWeldingCraftParameterShieldingGasFlow();
                        if (this$weldingCraftParameterShieldingGasFlow == null
                           ? other$weldingCraftParameterShieldingGasFlow == null
                           : this$weldingCraftParameterShieldingGasFlow.equals(other$weldingCraftParameterShieldingGasFlow)) {
                           Object this$electricity = this.getElectricity();
                           Object other$electricity = other.getElectricity();
                           if (this$electricity == null ? other$electricity == null : this$electricity.equals(other$electricity)) {
                              Object this$voltage = this.getVoltage();
                              Object other$voltage = other.getVoltage();
                              if (this$voltage == null ? other$voltage == null : this$voltage.equals(other$voltage)) {
                                 Object this$weldingSpeed = this.getWeldingSpeed();
                                 Object other$weldingSpeed = other.getWeldingSpeed();
                                 if (this$weldingSpeed == null ? other$weldingSpeed == null : this$weldingSpeed.equals(other$weldingSpeed)) {
                                    Object this$thermalInput = this.getThermalInput();
                                    Object other$thermalInput = other.getThermalInput();
                                    if (this$thermalInput == null ? other$thermalInput == null : this$thermalInput.equals(other$thermalInput)) {
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
      return other instanceof CappCraftCardStorehouseCraftParameterPassLinkSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $weldingCraftParameterPass = this.getWeldingCraftParameterPass();
      result = result * 59 + ($weldingCraftParameterPass == null ? 43 : $weldingCraftParameterPass.hashCode());
      Object $weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
      result = result * 59 + ($weldingBaseWeldingMethod == null ? 43 : $weldingBaseWeldingMethod.hashCode());
      Object $weldingMaterialTrademark = this.getWeldingMaterialTrademark();
      result = result * 59 + ($weldingMaterialTrademark == null ? 43 : $weldingMaterialTrademark.hashCode());
      Object $weldingCraftParameterRodOrWireDesignation = this.getWeldingCraftParameterRodOrWireDesignation();
      result = result * 59 + ($weldingCraftParameterRodOrWireDesignation == null ? 43 : $weldingCraftParameterRodOrWireDesignation.hashCode());
      Object $weldingCraftParameterWeldingFluxOrShieldingGas = this.getWeldingCraftParameterWeldingFluxOrShieldingGas();
      result = result * 59 + ($weldingCraftParameterWeldingFluxOrShieldingGas == null ? 43 : $weldingCraftParameterWeldingFluxOrShieldingGas.hashCode());
      Object $weldingCraftParameterShieldingGasFlow = this.getWeldingCraftParameterShieldingGasFlow();
      result = result * 59 + ($weldingCraftParameterShieldingGasFlow == null ? 43 : $weldingCraftParameterShieldingGasFlow.hashCode());
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $voltage = this.getVoltage();
      result = result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
      Object $weldingSpeed = this.getWeldingSpeed();
      result = result * 59 + ($weldingSpeed == null ? 43 : $weldingSpeed.hashCode());
      Object $thermalInput = this.getThermalInput();
      result = result * 59 + ($thermalInput == null ? 43 : $thermalInput.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseCraftParameterPassLinkSaveDTO(weldingCraftParameterPass="
         + this.getWeldingCraftParameterPass()
         + ", weldingBaseWeldingMethod="
         + this.getWeldingBaseWeldingMethod()
         + ", weldingMaterialTrademark="
         + this.getWeldingMaterialTrademark()
         + ", weldingCraftParameterRodOrWireDesignation="
         + this.getWeldingCraftParameterRodOrWireDesignation()
         + ", weldingCraftParameterWeldingFluxOrShieldingGas="
         + this.getWeldingCraftParameterWeldingFluxOrShieldingGas()
         + ", weldingCraftParameterShieldingGasFlow="
         + this.getWeldingCraftParameterShieldingGasFlow()
         + ", electricity="
         + this.getElectricity()
         + ", voltage="
         + this.getVoltage()
         + ", weldingSpeed="
         + this.getWeldingSpeed()
         + ", thermalInput="
         + this.getThermalInput()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
