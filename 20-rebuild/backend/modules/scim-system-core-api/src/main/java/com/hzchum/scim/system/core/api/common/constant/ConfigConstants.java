package com.hzchum.scim.system.core.api.common.constant;

public class ConfigConstants {
   public static final String OVERWEIGHT_SMS_RECIPIENT = "OVERWEIGHT_SMS_RECIPIENT";
   public static final String NEW_OVERWEIGHT_SMS_RECIPIENT = "NEW_OVERWEIGHT_SMS_RECIPIENT";
   public static final String COMPANY_NAME = "COMPANY_NAME";
   public static final String AMOUNT_DECIMAL = "AMOUNT_DECIMAL";
   public static final String PROJECT = "PROJECT";
   public static final String PRINT = "PRINT";
   public static final String LOGO = "LOGO";
   public static final String SAFETY_FACTOR = "SAFETY_FACTOR";
   public static final String INSTALLATION_AUDIT = "INSTALLATION_AUDIT";
   public static final String DRIVER_CONFIGURE = "DRIVER_CONFIGURE";
   public static final String CAR_MODEL = "CAR_MODEL";
   public static final String APP_PRINT = "APP_PRINT";
   public static final String PROJECT_MODE = "PROJECT_MODE";
   public static final String FLANGING_PIECE_PRICE = "FLANGING_PIECE_PRICE";
   public static final String TECHNICAL_CLARIFICATION_MODEL = "TECHNICAL_CLARIFICATION_MODEL";
   public static final String STEEL_PLATE_CONFIG = "STEEL_PLATE_CONFIG";
   public static final String VEHICLE = "VEHICLE";
   public static final String APP_WAREHOUSE_WEIGHT = "APP_WAREHOUSE_WEIGHT";
   public static final String CRAFT_CONFIG = "CRAFT_CONFIG";
   public static final String SHOW_NEED = "SHOW_NEED";
   public static final String APPROVE_STATUS = "APPROVE_STATUS";
   public static final String APP_WEIGHT_CONFIG = "APP_WEIGHT_CONFIG";
   public static final String FEATURE_DEFINITION_CONFIG = "FEATURE_DEFINITION_CONFIG";
   public static final String SERVER_EXPIRE_DATE = "SERVER_EXPIRE_DATE";
   public static final String PRICE_EDIT_MODE = "PRICE_EDIT_MODE";
   public static final String WASTE_PRICE_ENTRY_TYPE = "WASTE_PRICE_ENTRY_TYPE";
   public static final String FINISHED_PRODUCT_WAREHOUSE = "FINISHED_PRODUCT_WAREHOUSE";
   public static final String COATING_CONFIG_MEASUREMENT_MANNER = "COATING_CONFIG_MEASUREMENT_MANNER";
   public static final String LIST_ERROR_CONFIGURATION = "LIST_ERROR_CONFIGURATION";
   public static final String SYSTEM_CHARGING_METHOD = "SYSTEM_CHARGING_METHOD";
   public static final String SMS_SEND_EXPECTED_TIME = "SMS_SEND_EXPECTED_TIME";
   public static final String BIM_MODEL_CONVERT_RESTRICT_ENCIPHER = "BIM_MODEL_CONVERT_RESTRICT_ENCIPHER";
   public static final String PRODUCT_LABEL_LOGO = "productLabelLogo";
   public static final String FINANCE_AMOUNT_LIMIT_CONFIG = "FINANCE_AMOUNT_LIMIT_CONFIG";
   public static final String FINANCE_AMOUNT_SHOW_CONFIG = "FINANCE_AMOUNT_SHOW_CONFIG";
   public static final String SYSTEM_WATERMARK_CONFIG = "SYSTEM_WATERMARK_CONFIG";
   public static final String WAGE_STATISTICS_DEADLINE = "WAGE_STATISTICS_DEADLINE";
   public static final String RAW_MATERIAL_LOSS_CALCULATION_FORMULA = "RAW_MATERIAL_LOSS_CALCULATION_FORMULA";
   public static final String NESTING_TASK_SETTING = "NESTING_TASK_SETTING";
   public static final String NUMERICAL_CONTROL_DRAWING_MATCH_RANGE = "NUMERICAL_CONTROL_DRAWING_MATCH_RANGE";
   public static final String PART_DRAWING_LAYER_SETTING = "PART_DRAWING_LAYER_SETTING";
   public static final String PAINT_THICKNESS_DETECTION = "PAINT_THICKNESS_DETECTION";
   public static final String CAPP_WELDING_CRAFT = "CAPP_WELDING_CRAFT";
   public static final String WAGE_CONFIG = "WAGE_CONFIG";
   public static final String PASSWORD_POLICY = "PASSWORD_POLICY";
   public static final String PRINT_CONFIGURATION = "PRINT_CONFIGURATION";
   public static final String PROJECT_CONTRACT_TECH_CONFIG = "PROJECT_CONTRACT_TECH_CONFIG";

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConfigConstants)) {
         return false;
      }

      ConfigConstants other = (ConfigConstants)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConfigConstants;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ConfigConstants()";
   }
}
