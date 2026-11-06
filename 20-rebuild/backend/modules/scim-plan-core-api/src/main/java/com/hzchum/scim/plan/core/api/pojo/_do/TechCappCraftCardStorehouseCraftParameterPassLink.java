package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechCappCraftCardStorehouseCraftparameterPassLink对象", description = "焊接工艺参数表")
@Entity
@TableName("tech_capp_craft_card_storehouse_craft_parameter_pass_link")
@Table(name = "tech_capp_craft_card_storehouse_craft_parameter_pass_link")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_storehouse_craft_parameter_pass_link", comment = "焊接工艺参数表")
public class TechCappCraftCardStorehouseCraftParameterPassLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "weldingCraftParameterPass", value = "道次", notes = "道次")
   @TableField("welding_craft_parameter_pass")
   @Column(name = "welding_craft_parameter_pass", columnDefinition = "varchar(255)  COMMENT '道次'", nullable = false)
   private String weldingCraftParameterPass;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   @TableField("welding_base_welding_method")
   @Column(name = "welding_base_welding_method", columnDefinition = "varchar(255)  COMMENT '焊接方法'", nullable = true)
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingMaterialTrademark", value = "牌号", notes = "牌号")
   @TableField("welding_material_trademark")
   @Column(name = "welding_material_trademark", columnDefinition = "varchar(255)  COMMENT '牌号'", nullable = true)
   private String weldingMaterialTrademark;
   @ApiModelProperty(name = "weldingCraftParameterRodOrWireDesignation", value = "直径φ(mm)", notes = "直径φ(mm)")
   @TableField("welding_craft_parameter_rod_or_wire_designation")
   @Column(name = "welding_craft_parameter_rod_or_wire_designation", columnDefinition = "varchar(255)  COMMENT '直径φ(mm)'", nullable = true)
   private String weldingCraftParameterRodOrWireDesignation;
   @ApiModelProperty(name = "weldingCraftParameterWeldingFluxOrShieldingGas", value = "焊剂或保护气", notes = "焊剂或保护气")
   @TableField("welding_craft_parameter_welding_flux_or_shielding_gas")
   @Column(name = "welding_craft_parameter_welding_flux_or_shielding_gas", columnDefinition = "varchar(255)  COMMENT '焊剂或保护气'", nullable = true)
   private String weldingCraftParameterWeldingFluxOrShieldingGas;
   @ApiModelProperty(name = "weldingCraftParameterShieldingGasFlow", value = "保护气体流量(L/min)", notes = "保护气体流量(L/min)")
   @TableField("welding_craft_parameter_shielding_gas_flow")
   @Column(name = "welding_craft_parameter_shielding_gas_flow", columnDefinition = "varchar(255)  COMMENT '保护气体流量(L/min)'", nullable = true)
   private String weldingCraftParameterShieldingGasFlow;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   @TableField("electricity")
   @Column(name = "electricity", columnDefinition = "varchar(255)  COMMENT '电流(A)'", nullable = true)
   private String electricity;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   @TableField("voltage")
   @Column(name = "voltage", columnDefinition = "varchar(255)  COMMENT '电压(V)'", nullable = true)
   private String voltage;
   @ApiModelProperty(name = "weldingSpeed", value = "焊接速度(cm/min)", notes = "焊接速度(cm/min)")
   @TableField("welding_speed")
   @Column(name = "welding_speed", columnDefinition = "varchar(255)  COMMENT '焊接速度(cm/min)'", nullable = true)
   private String weldingSpeed;
   @ApiModelProperty(name = "thermalInput", value = "热输入(kj/cm)", notes = "热输入(kj/cm)")
   @TableField("thermal_input")
   @Column(name = "thermal_input", columnDefinition = "varchar(255)  COMMENT '热输入(kj/cm)'", nullable = true)
   private String thermalInput;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺id", notes = "焊接工艺id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺id'", nullable = false)
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder builder() {
      return new TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder();
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink() {
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink(
      final Long id,
      final String weldingCraftParameterPass,
      final String weldingBaseWeldingMethod,
      final String weldingMaterialTrademark,
      final String weldingCraftParameterRodOrWireDesignation,
      final String weldingCraftParameterWeldingFluxOrShieldingGas,
      final String weldingCraftParameterShieldingGasFlow,
      final String electricity,
      final String voltage,
      final String weldingSpeed,
      final String thermalInput,
      final String remark,
      final Long techCappCraftCardStorehouseId,
      final Integer sort
   ) {
      this.id = id;
      this.weldingCraftParameterPass = weldingCraftParameterPass;
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
      this.weldingMaterialTrademark = weldingMaterialTrademark;
      this.weldingCraftParameterRodOrWireDesignation = weldingCraftParameterRodOrWireDesignation;
      this.weldingCraftParameterWeldingFluxOrShieldingGas = weldingCraftParameterWeldingFluxOrShieldingGas;
      this.weldingCraftParameterShieldingGasFlow = weldingCraftParameterShieldingGasFlow;
      this.electricity = electricity;
      this.voltage = voltage;
      this.weldingSpeed = weldingSpeed;
      this.thermalInput = thermalInput;
      this.remark = remark;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      this.sort = sort;
   }

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

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingCraftParameterPass(final String weldingCraftParameterPass) {
      this.weldingCraftParameterPass = weldingCraftParameterPass;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingMaterialTrademark(final String weldingMaterialTrademark) {
      this.weldingMaterialTrademark = weldingMaterialTrademark;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingCraftParameterRodOrWireDesignation(final String weldingCraftParameterRodOrWireDesignation) {
      this.weldingCraftParameterRodOrWireDesignation = weldingCraftParameterRodOrWireDesignation;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingCraftParameterWeldingFluxOrShieldingGas(
      final String weldingCraftParameterWeldingFluxOrShieldingGas
   ) {
      this.weldingCraftParameterWeldingFluxOrShieldingGas = weldingCraftParameterWeldingFluxOrShieldingGas;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingCraftParameterShieldingGasFlow(final String weldingCraftParameterShieldingGasFlow) {
      this.weldingCraftParameterShieldingGasFlow = weldingCraftParameterShieldingGasFlow;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setElectricity(final String electricity) {
      this.electricity = electricity;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setVoltage(final String voltage) {
      this.voltage = voltage;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setWeldingSpeed(final String weldingSpeed) {
      this.weldingSpeed = weldingSpeed;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setThermalInput(final String thermalInput) {
      this.thermalInput = thermalInput;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   public TechCappCraftCardStorehouseCraftParameterPassLink setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardStorehouseCraftParameterPassLink(id="
         + this.getId()
         + ", weldingCraftParameterPass="
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
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardStorehouseCraftParameterPassLink)) {
         return false;
      }

      TechCappCraftCardStorehouseCraftParameterPassLink other = (TechCappCraftCardStorehouseCraftParameterPassLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
         Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
         if (this$techCappCraftCardStorehouseId == null
            ? other$techCappCraftCardStorehouseId == null
            : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechCappCraftCardStorehouseCraftParameterPassLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
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

   public static class TechCappCraftCardStorehouseCraftParameterPassLinkBuilder {
      private Long id;
      private String weldingCraftParameterPass;
      private String weldingBaseWeldingMethod;
      private String weldingMaterialTrademark;
      private String weldingCraftParameterRodOrWireDesignation;
      private String weldingCraftParameterWeldingFluxOrShieldingGas;
      private String weldingCraftParameterShieldingGasFlow;
      private String electricity;
      private String voltage;
      private String weldingSpeed;
      private String thermalInput;
      private String remark;
      private Long techCappCraftCardStorehouseId;
      private Integer sort;

      TechCappCraftCardStorehouseCraftParameterPassLinkBuilder() {
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingCraftParameterPass(
         final String weldingCraftParameterPass
      ) {
         this.weldingCraftParameterPass = weldingCraftParameterPass;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingBaseWeldingMethod(
         final String weldingBaseWeldingMethod
      ) {
         this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingMaterialTrademark(
         final String weldingMaterialTrademark
      ) {
         this.weldingMaterialTrademark = weldingMaterialTrademark;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingCraftParameterRodOrWireDesignation(
         final String weldingCraftParameterRodOrWireDesignation
      ) {
         this.weldingCraftParameterRodOrWireDesignation = weldingCraftParameterRodOrWireDesignation;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingCraftParameterWeldingFluxOrShieldingGas(
         final String weldingCraftParameterWeldingFluxOrShieldingGas
      ) {
         this.weldingCraftParameterWeldingFluxOrShieldingGas = weldingCraftParameterWeldingFluxOrShieldingGas;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingCraftParameterShieldingGasFlow(
         final String weldingCraftParameterShieldingGasFlow
      ) {
         this.weldingCraftParameterShieldingGasFlow = weldingCraftParameterShieldingGasFlow;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder electricity(final String electricity) {
         this.electricity = electricity;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder voltage(final String voltage) {
         this.voltage = voltage;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder weldingSpeed(final String weldingSpeed) {
         this.weldingSpeed = weldingSpeed;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder thermalInput(final String thermalInput) {
         this.thermalInput = thermalInput;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder techCappCraftCardStorehouseId(
         final Long techCappCraftCardStorehouseId
      ) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public TechCappCraftCardStorehouseCraftParameterPassLink build() {
         return new TechCappCraftCardStorehouseCraftParameterPassLink(
            this.id,
            this.weldingCraftParameterPass,
            this.weldingBaseWeldingMethod,
            this.weldingMaterialTrademark,
            this.weldingCraftParameterRodOrWireDesignation,
            this.weldingCraftParameterWeldingFluxOrShieldingGas,
            this.weldingCraftParameterShieldingGasFlow,
            this.electricity,
            this.voltage,
            this.weldingSpeed,
            this.thermalInput,
            this.remark,
            this.techCappCraftCardStorehouseId,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardStorehouseCraftParameterPassLink.TechCappCraftCardStorehouseCraftParameterPassLinkBuilder(id="
            + this.id
            + ", weldingCraftParameterPass="
            + this.weldingCraftParameterPass
            + ", weldingBaseWeldingMethod="
            + this.weldingBaseWeldingMethod
            + ", weldingMaterialTrademark="
            + this.weldingMaterialTrademark
            + ", weldingCraftParameterRodOrWireDesignation="
            + this.weldingCraftParameterRodOrWireDesignation
            + ", weldingCraftParameterWeldingFluxOrShieldingGas="
            + this.weldingCraftParameterWeldingFluxOrShieldingGas
            + ", weldingCraftParameterShieldingGasFlow="
            + this.weldingCraftParameterShieldingGasFlow
            + ", electricity="
            + this.electricity
            + ", voltage="
            + this.voltage
            + ", weldingSpeed="
            + this.weldingSpeed
            + ", thermalInput="
            + this.thermalInput
            + ", remark="
            + this.remark
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
