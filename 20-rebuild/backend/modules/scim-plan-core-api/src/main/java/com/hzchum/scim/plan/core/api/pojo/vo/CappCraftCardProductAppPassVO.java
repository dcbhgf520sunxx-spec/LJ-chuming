package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "CAPP app焊接工艺焊道 响应参数")
public class CappCraftCardProductAppPassVO {
   private Long id;
   @ApiModelProperty(name = "weldingCraftParameterPass", value = "道次", notes = "道次")
   private String weldingCraftParameterPass;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingMaterialTrademark", value = "牌号", notes = "牌号")
   private String weldingMaterialTrademark;
   @ApiModelProperty(name = "weldingCraftParameterRodOrWireDesignation", value = "直径φ(mm)", notes = "直径φ(mm)")
   private String weldingCraftParameterRodOrWireDesignation;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   private String voltage;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   private String electricity;
   @ApiModelProperty(name = "weldingSpeed", value = "焊接速度(cm/min)", notes = "焊接速度(cm/min)")
   private String weldingSpeed;
   @ApiModelProperty(name = "weldingCraftParameterWeldingFluxOrShieldingGas", value = "焊剂或保护气", notes = "焊剂或保护气")
   private String weldingCraftParameterWeldingFluxOrShieldingGas;
   @ApiModelProperty(name = "weldingCraftParameterShieldingGasFlow", value = "保护气体流量(L/min)", notes = "保护气体流量(L/min)")
   private String weldingCraftParameterShieldingGasFlow;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   private Integer techCappProductTaskWorkType;
   @ApiModelProperty(name = "equimentSerialNumber", value = "设备编号", notes = "设备编号")
   private String equimentSerialNumber;
   @ApiModelProperty(name = "equimentName", value = "设备名称", notes = "设备名称")
   private String equimentName;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   private String equimentCode;
   @ApiModelProperty(name = "weldingGunCode", value = "焊枪编号", notes = "焊枪编号")
   private String weldingGunCode;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "工艺卡id", notes = "工艺卡id")
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "isPause", value = "是否暂停", notes = "是否暂停")
   private Boolean isPause;
   @ApiModelProperty(name = "attachmentDTOS", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentDTOS;

   public Long getId() {
      return this.id;
   }

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

   public String getVoltage() {
      return this.voltage;
   }

   public String getElectricity() {
      return this.electricity;
   }

   public String getWeldingSpeed() {
      return this.weldingSpeed;
   }

   public String getWeldingCraftParameterWeldingFluxOrShieldingGas() {
      return this.weldingCraftParameterWeldingFluxOrShieldingGas;
   }

   public String getWeldingCraftParameterShieldingGasFlow() {
      return this.weldingCraftParameterShieldingGasFlow;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public String getEquimentSerialNumber() {
      return this.equimentSerialNumber;
   }

   public String getEquimentName() {
      return this.equimentName;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getWeldingGunCode() {
      return this.weldingGunCode;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public Boolean getIsPause() {
      return this.isPause;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setVoltage(final String voltage) {
      this.voltage = voltage;
   }

   public void setElectricity(final String electricity) {
      this.electricity = electricity;
   }

   public void setWeldingSpeed(final String weldingSpeed) {
      this.weldingSpeed = weldingSpeed;
   }

   public void setWeldingCraftParameterWeldingFluxOrShieldingGas(final String weldingCraftParameterWeldingFluxOrShieldingGas) {
      this.weldingCraftParameterWeldingFluxOrShieldingGas = weldingCraftParameterWeldingFluxOrShieldingGas;
   }

   public void setWeldingCraftParameterShieldingGasFlow(final String weldingCraftParameterShieldingGasFlow) {
      this.weldingCraftParameterShieldingGasFlow = weldingCraftParameterShieldingGasFlow;
   }

   public void setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
   }

   public void setEquimentSerialNumber(final String equimentSerialNumber) {
      this.equimentSerialNumber = equimentSerialNumber;
   }

   public void setEquimentName(final String equimentName) {
      this.equimentName = equimentName;
   }

   public void setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
   }

   public void setWeldingGunCode(final String weldingGunCode) {
      this.weldingGunCode = weldingGunCode;
   }

   public void setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public void setIsPause(final Boolean isPause) {
      this.isPause = isPause;
   }

   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppPassVO)) {
         return false;
      }

      CappCraftCardProductAppPassVO other = (CappCraftCardProductAppPassVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
         Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
         if (this$techCappProductTaskWorkType == null
            ? other$techCappProductTaskWorkType == null
            : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
            Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
            Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
            if (this$techCappCraftCardStorehouseId == null
               ? other$techCappCraftCardStorehouseId == null
               : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
               Object this$isPause = this.getIsPause();
               Object other$isPause = other.getIsPause();
               if (this$isPause == null ? other$isPause == null : this$isPause.equals(other$isPause)) {
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
                              Object this$voltage = this.getVoltage();
                              Object other$voltage = other.getVoltage();
                              if (this$voltage == null ? other$voltage == null : this$voltage.equals(other$voltage)) {
                                 Object this$electricity = this.getElectricity();
                                 Object other$electricity = other.getElectricity();
                                 if (this$electricity == null ? other$electricity == null : this$electricity.equals(other$electricity)) {
                                    Object this$weldingSpeed = this.getWeldingSpeed();
                                    Object other$weldingSpeed = other.getWeldingSpeed();
                                    if (this$weldingSpeed == null ? other$weldingSpeed == null : this$weldingSpeed.equals(other$weldingSpeed)) {
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
                                             Object this$equimentSerialNumber = this.getEquimentSerialNumber();
                                             Object other$equimentSerialNumber = other.getEquimentSerialNumber();
                                             if (this$equimentSerialNumber == null
                                                ? other$equimentSerialNumber == null
                                                : this$equimentSerialNumber.equals(other$equimentSerialNumber)) {
                                                Object this$equimentName = this.getEquimentName();
                                                Object other$equimentName = other.getEquimentName();
                                                if (this$equimentName == null ? other$equimentName == null : this$equimentName.equals(other$equimentName)) {
                                                   Object this$equimentCode = this.getEquimentCode();
                                                   Object other$equimentCode = other.getEquimentCode();
                                                   if (this$equimentCode == null ? other$equimentCode == null : this$equimentCode.equals(other$equimentCode)) {
                                                      Object this$weldingGunCode = this.getWeldingGunCode();
                                                      Object other$weldingGunCode = other.getWeldingGunCode();
                                                      if (this$weldingGunCode == null
                                                         ? other$weldingGunCode == null
                                                         : this$weldingGunCode.equals(other$weldingGunCode)) {
                                                         Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                         Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                         return this$attachmentDTOS == null
                                                            ? other$attachmentDTOS == null
                                                            : this$attachmentDTOS.equals(other$attachmentDTOS);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppPassVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $isPause = this.getIsPause();
      result = result * 59 + ($isPause == null ? 43 : $isPause.hashCode());
      Object $weldingCraftParameterPass = this.getWeldingCraftParameterPass();
      result = result * 59 + ($weldingCraftParameterPass == null ? 43 : $weldingCraftParameterPass.hashCode());
      Object $weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
      result = result * 59 + ($weldingBaseWeldingMethod == null ? 43 : $weldingBaseWeldingMethod.hashCode());
      Object $weldingMaterialTrademark = this.getWeldingMaterialTrademark();
      result = result * 59 + ($weldingMaterialTrademark == null ? 43 : $weldingMaterialTrademark.hashCode());
      Object $weldingCraftParameterRodOrWireDesignation = this.getWeldingCraftParameterRodOrWireDesignation();
      result = result * 59 + ($weldingCraftParameterRodOrWireDesignation == null ? 43 : $weldingCraftParameterRodOrWireDesignation.hashCode());
      Object $voltage = this.getVoltage();
      result = result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $weldingSpeed = this.getWeldingSpeed();
      result = result * 59 + ($weldingSpeed == null ? 43 : $weldingSpeed.hashCode());
      Object $weldingCraftParameterWeldingFluxOrShieldingGas = this.getWeldingCraftParameterWeldingFluxOrShieldingGas();
      result = result * 59 + ($weldingCraftParameterWeldingFluxOrShieldingGas == null ? 43 : $weldingCraftParameterWeldingFluxOrShieldingGas.hashCode());
      Object $weldingCraftParameterShieldingGasFlow = this.getWeldingCraftParameterShieldingGasFlow();
      result = result * 59 + ($weldingCraftParameterShieldingGasFlow == null ? 43 : $weldingCraftParameterShieldingGasFlow.hashCode());
      Object $equimentSerialNumber = this.getEquimentSerialNumber();
      result = result * 59 + ($equimentSerialNumber == null ? 43 : $equimentSerialNumber.hashCode());
      Object $equimentName = this.getEquimentName();
      result = result * 59 + ($equimentName == null ? 43 : $equimentName.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $weldingGunCode = this.getWeldingGunCode();
      result = result * 59 + ($weldingGunCode == null ? 43 : $weldingGunCode.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppPassVO(id="
         + this.getId()
         + ", weldingCraftParameterPass="
         + this.getWeldingCraftParameterPass()
         + ", weldingBaseWeldingMethod="
         + this.getWeldingBaseWeldingMethod()
         + ", weldingMaterialTrademark="
         + this.getWeldingMaterialTrademark()
         + ", weldingCraftParameterRodOrWireDesignation="
         + this.getWeldingCraftParameterRodOrWireDesignation()
         + ", voltage="
         + this.getVoltage()
         + ", electricity="
         + this.getElectricity()
         + ", weldingSpeed="
         + this.getWeldingSpeed()
         + ", weldingCraftParameterWeldingFluxOrShieldingGas="
         + this.getWeldingCraftParameterWeldingFluxOrShieldingGas()
         + ", weldingCraftParameterShieldingGasFlow="
         + this.getWeldingCraftParameterShieldingGasFlow()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ", equimentSerialNumber="
         + this.getEquimentSerialNumber()
         + ", equimentName="
         + this.getEquimentName()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", weldingGunCode="
         + this.getWeldingGunCode()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", isPause="
         + this.getIsPause()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }
}
