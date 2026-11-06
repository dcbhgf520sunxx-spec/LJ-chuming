package com.hzchum.scim.plan.core.api.enums;

public enum CappCraftCardDictEnum {
   WELDING_BASE_JOINT_TYPE("welding_base_jointType", "接头形式"),
   WELDING_BASE_PARENT_MATERIAL_STEEL_GRADE("welding_base_parentMaterialSteelGrade", "母材钢号"),
   WELDING_BASE_PLATE_THICKNESS_OR_PIPE_DIAMETER("welding_base_plateThicknessOrPipeDiameter", "板厚或管径×壁厚"),
   WELDING_BASE_HOT_ROLLING_OR_HEAT_TREATMENT_STATUS("welding_base_hotRollingOrHeatTreatmentStatus", "轧制或热处理状态"),
   WELDING_BASE_WELDING_METHOD("welding_base_weldingMethod", "焊接方法"),
   WELDING_BASE_WELDING_POSITION("welding_base_weldingPosition", "焊接位置"),
   WELDING_BASE_WELDING_DEVICE_TYPE("welding_base_weldingDeviceType", "焊接设备型号"),
   WELDING_BASE_POWER_SUPPLY_AND_POLARITY("welding_base_powerSupplyAndPolarity", "电源及极性"),
   WELDING_PLATE_THICKNESS_OR_TEMPERATURE_PLATE_THICKNESS("welding_plateThicknessOrTemperature_plateThickness", "板厚"),
   WELDING_TECHNICAL_MEASURE_PRE_WELD_CLEANING("welding_technicalMeasure_preWeldCleaning", "焊前清理"),
   WELDING_TECHNICAL_MEASURE_ROAD_CLEANING("welding_technicalMeasure_roadCleaning", "道间清理"),
   WELDING_TECHNICAL_MEASURE_BACK_CLEANING("welding_technicalMeasure_backCleaning", "背面清理"),
   WELDING_MATERIAL_NAME("welding_material_name", "名称"),
   WELDING_MATERIAL_MANUFACTURING_PLANT("welding_material_manufacturingPlant", "生产厂"),
   WELDING_MATERIAL_TRADEMARK("welding_material_trademark", "牌号"),
   WELDING_MATERIAL_MODEL("welding_material_model", "型号"),
   WELDING_MATERIAL_TYPE("welding_material_type", "类型"),
   WELDING_MATERIAL_DRYING_PROCEDURE("welding_material_dryingProcedure", "烘干制度(℃×h)"),
   WELDING_CRAFT_PARAMETER_PASS("welding_craftParameter_pass", "道次"),
   WELDING_CRAFT_PARAMETER_ROD_OR_WIRE_DESIGNATION("welding_craftParameter_rodOrWireDesignation", "焊条或焊丝直径"),
   WELDING_CRAFT_PARAMETER_WELDING_FLUX_OR_SHIELDING_GAS("welding_craftParameter_weldingFluxOrShieldingGas", "焊剂或保护气"),
   WELDING_CRAFT_PARAMETER_SHIELDING_GAS_FLOW("welding_craftParameter_shieldingGasFlow", "保护气体流量(L/min)");

   private final String type;
   private final String name;

   public String getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CappCraftCardDictEnum(final String type, final String name) {
      this.type = type;
      this.name = name;
   }
}
