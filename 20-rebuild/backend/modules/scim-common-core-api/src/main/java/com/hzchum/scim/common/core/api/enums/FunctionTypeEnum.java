package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum FunctionTypeEnum {
   WMS_SELF_BUYING_IN(1001, "自购入库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_PARTY_A_SUPPLY_IN(1002, "甲供入库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_SELF_BUYING_OUT(1003, "自购出库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_PARTY_A_SUPPLY_OUT(1004, "甲供出库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_SELF_BUYING_RETURN_WAREHOUSE(1005, "自购物料退库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_SELF_BUYING_RETURN_GOODS(1006, "自购物料退货", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_PARTY_A_LOAN_RETURN(1007, "甲供借用退还审核", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_MANUFACTURED_IN(1008, "制成品入库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_MANUFACTURED_OUT(1009, "制成品出库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_SCHEDULING_PICKING_OUT(1010, "排产领料出库审核", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_INBOUND_MONEY_ADJUST(1011, "入库金额调整", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_CHECK_DEFICIT(1012, "盘亏", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_SHIPMENT_RECEIVE_OUT(1013, "发运领用", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_RETURN(1014, "退库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_REJECT(1015, "退货", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_MOVE_MATERIAL(1016, "移库", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   WMS_MANUFACTURES_CONVERT(1017, "条板转换", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName()),
   SUPPLY_CHAIN_APPLY_PURCHASE(2001, "申购", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUPPLY_CHAIN_PURCHASE_ORDER(2002, "采购", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT(2003, "自合营采购-付款与结算", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT(2004, "采购-内包制采购-付款与结算", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUBCONTRACT_ORDER(2005, "分包订单", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUBCONTRACT_ORDER_AUDIT(2006, "分包订单(自营)-付款开票与结算", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUBCONTRACT_ORDER_INNER_AUDIT(2007, "分包订单(内包/合营)-付款开票与结算", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   SUPPLIER_EVALUATE(2008, "供应商评价", ModuleTypeEnum.SUPPLY_CHAIN.getType(), ModuleTypeEnum.SUPPLY_CHAIN.getName()),
   CONTRACT_INVOICE_AUDIT(3001, "项目发票-审批", ModuleTypeEnum.CONTRACT.getType(), ModuleTypeEnum.CONTRACT.getName()),
   CONTRACT_PROJECT_SETTLEMENT(3002, "项目结算-审批", ModuleTypeEnum.CONTRACT.getType(), ModuleTypeEnum.CONTRACT.getName()),
   CONTRACT_PROJECT_COLLECTION(3003, "项目收款-审批", ModuleTypeEnum.CONTRACT.getType(), ModuleTypeEnum.CONTRACT.getName()),
   CONTRACT_EXPENSE_ENTRY(3010, "费用录入-审批", ModuleTypeEnum.CONTRACT.getType(), ModuleTypeEnum.CONTRACT.getName()),
   CONTRACT_REGISTRATION(3003, "合同登记", ModuleTypeEnum.CONTRACT.getType(), ModuleTypeEnum.CONTRACT.getName()),
   PLAN_MODEL_DOCUMENT_MANAGE(5001, "模型文件管理", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   PLAN_DRAWING_DOCUMENT_MANAGE(5002, "图纸文件管理", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE(5003, "数控文件管理", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   PLAN_CHANGE_FILE(5004, "变更文件", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   PLAN_CONSTRUCTION_BLUEPRINT(5005, "施工蓝图", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   PLAN_PROCESS_DOCUMENT(5006, "工艺文件", ModuleTypeEnum.PLAN_MODULE.getType(), ModuleTypeEnum.PLAN_MODULE.getName()),
   MES_TEMP_WORKER_MANAGE(6001, "点工管理", ModuleTypeEnum.MES.getType(), ModuleTypeEnum.MES.getName()),
   MES_WAGE_ADJUST(6002, "工价调整", ModuleTypeEnum.MES.getType(), ModuleTypeEnum.MES.getName()),
   MES_PAINTING_CRAFT(6003, "涂装工艺", ModuleTypeEnum.MES.getType(), ModuleTypeEnum.MES.getName()),
   MES_MACHINE_PART(6004, "生产领料", ModuleTypeEnum.MES.getType(), ModuleTypeEnum.MES.getName()),
   PROJECT(8001, "项目管理", ModuleTypeEnum.PROJECT.getType(), ModuleTypeEnum.PROJECT.getName()),
   CRM_PROJECT_FOLLOW_UP(12001, "CRM项目跟进申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_PRELIMINARY(12002, "CRM项目预审申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_TENDER(12003, "CRM项目投标申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_ABANDON(12004, "CRM项目放弃申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_PROJECT_FILING(12005, "CRM项目备案申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_BUSINESS_BIDDING(12006, "CRM项目商务投标申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_DEEP_DESIGN_BIDDING(12007, "CRM项目深化设计投标申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_STRUCTURAL_DESIGN_BIDDING(12008, "CRM项目结构设计投标申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_TECHNOLOGY_BIDDING(12009, "CRM项目技术投标申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_TECHNOLOGY_DIRECT_BIDDING(12010, "CRM技术委托直营申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   CRM_TECHNOLOGY_NON_DIRECT_BIDDING(12011, "CRM技术委托非直营申请", ModuleTypeEnum.CRM.getType(), ModuleTypeEnum.CRM.getName()),
   WMS_SURPLUS(14001, "盘盈", ModuleTypeEnum.WMS.getType(), ModuleTypeEnum.WMS.getName());

   private Integer type;
   private String name;
   private Integer moduleType;
   private String moduleTypeName;

   FunctionTypeEnum(int type, String name, int moduleType, String moduleTypeName) {
      this.type = type;
      this.name = name;
      this.moduleType = moduleType;
      this.moduleTypeName = moduleTypeName;
   }

   public static Boolean exist(String name) {
      for (FunctionTypeEnum functionTypeEnum : values()) {
         if (functionTypeEnum.name.equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static String getName(Integer type) {
      for (FunctionTypeEnum functionTypeEnum : values()) {
         if (functionTypeEnum.getType().equals(type)) {
            return functionTypeEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (FunctionTypeEnum functionTypeEnum : EnumSet.allOf(FunctionTypeEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", functionTypeEnum.type.toString());
         integerStringHashMap.put("name", functionTypeEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static FunctionTypeEnum selectType(Integer type) {
      for (FunctionTypeEnum value : values()) {
         if (value.type.equals(type)) {
            return value;
         }
      }

      Preconditions.checkArgument(false, "枚举类未查询到!!");
      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public Integer getModuleType() {
      return this.moduleType;
   }

   public String getModuleTypeName() {
      return this.moduleTypeName;
   }
}
