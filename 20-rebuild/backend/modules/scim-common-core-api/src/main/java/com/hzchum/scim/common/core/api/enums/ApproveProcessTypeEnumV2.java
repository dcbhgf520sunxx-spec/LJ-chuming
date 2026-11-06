package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum ApproveProcessTypeEnumV2 {
   CRM_PROJECT_FOLLOW_UP(
      120001,
      "CRM项目跟进申请",
      FunctionTypeEnum.CRM_PROJECT_FOLLOW_UP.getModuleType(),
      FunctionTypeEnum.CRM_PROJECT_FOLLOW_UP.getModuleTypeName(),
      FunctionTypeEnum.CRM_PROJECT_FOLLOW_UP.getType(),
      FunctionTypeEnum.CRM_PROJECT_FOLLOW_UP.getName(),
      1,
      true,
      0
   ),
   CRM_PRELIMINARY(
      120002,
      "CRM项目预审申请",
      FunctionTypeEnum.CRM_PRELIMINARY.getModuleType(),
      FunctionTypeEnum.CRM_PRELIMINARY.getModuleTypeName(),
      FunctionTypeEnum.CRM_PRELIMINARY.getType(),
      FunctionTypeEnum.CRM_PRELIMINARY.getName(),
      2,
      true,
      0
   ),
   CRM_TENDER(
      120003,
      "CRM项目投标申请",
      FunctionTypeEnum.CRM_TENDER.getModuleType(),
      FunctionTypeEnum.CRM_TENDER.getModuleTypeName(),
      FunctionTypeEnum.CRM_TENDER.getType(),
      FunctionTypeEnum.CRM_TENDER.getName(),
      3,
      true,
      0
   ),
   CRM_ABANDON(
      120004,
      "CRM项目放弃申请",
      FunctionTypeEnum.CRM_ABANDON.getModuleType(),
      FunctionTypeEnum.CRM_ABANDON.getModuleTypeName(),
      FunctionTypeEnum.CRM_ABANDON.getType(),
      FunctionTypeEnum.CRM_ABANDON.getName(),
      4,
      true,
      0
   ),
   CRM_PROJECT_FILING(
      120005,
      "CRM项目备案申请",
      FunctionTypeEnum.CRM_PROJECT_FILING.getModuleType(),
      FunctionTypeEnum.CRM_PROJECT_FILING.getModuleTypeName(),
      FunctionTypeEnum.CRM_PROJECT_FILING.getType(),
      FunctionTypeEnum.CRM_PROJECT_FILING.getName(),
      5,
      true,
      0
   ),
   CRM_BUSINESS_BIDDING(
      120006,
      "CRM项目商务投标申请",
      FunctionTypeEnum.CRM_BUSINESS_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_BUSINESS_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_BUSINESS_BIDDING.getType(),
      FunctionTypeEnum.CRM_BUSINESS_BIDDING.getName(),
      6,
      true,
      0
   ),
   CRM_DEEP_DESIGN_BIDDING(
      120007,
      "CRM项目深化设计投标申请",
      FunctionTypeEnum.CRM_DEEP_DESIGN_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_DEEP_DESIGN_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_DEEP_DESIGN_BIDDING.getType(),
      FunctionTypeEnum.CRM_DEEP_DESIGN_BIDDING.getName(),
      7,
      true,
      0
   ),
   CRM_STRUCTURAL_DESIGN_BIDDING(
      120008,
      "CRM项目结构设计投标申请",
      FunctionTypeEnum.CRM_STRUCTURAL_DESIGN_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_STRUCTURAL_DESIGN_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_STRUCTURAL_DESIGN_BIDDING.getType(),
      FunctionTypeEnum.CRM_STRUCTURAL_DESIGN_BIDDING.getName(),
      8,
      true,
      0
   ),
   CRM_TECHNOLOGY_BIDDING(
      120009,
      "CRM项目技术投标申请",
      FunctionTypeEnum.CRM_TECHNOLOGY_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_TECHNOLOGY_BIDDING.getType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_BIDDING.getName(),
      9,
      true,
      0
   ),
   CRM_TECHNOLOGY_DIRECT_BIDDING(
      120010,
      "CRM技术委托直营申请",
      FunctionTypeEnum.CRM_TECHNOLOGY_DIRECT_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_DIRECT_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_TECHNOLOGY_DIRECT_BIDDING.getType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_DIRECT_BIDDING.getName(),
      10,
      true,
      0
   ),
   CRM_TECHNOLOGY_NON_DIRECT_BIDDING(
      120011,
      "CRM技术委托非直营申请",
      FunctionTypeEnum.CRM_TECHNOLOGY_NON_DIRECT_BIDDING.getModuleType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_NON_DIRECT_BIDDING.getModuleTypeName(),
      FunctionTypeEnum.CRM_TECHNOLOGY_NON_DIRECT_BIDDING.getType(),
      FunctionTypeEnum.CRM_TECHNOLOGY_NON_DIRECT_BIDDING.getName(),
      11,
      true,
      0
   ),
   CONTRACT_INVOICE_AUDIT(
      30001,
      "项目开票-审核",
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getModuleType(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getType(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getName(),
      1001,
      true,
      0
   ),
   CONTRACT_INSOURCING(
      30003,
      "内包合营开票-审核",
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getModuleType(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getType(),
      FunctionTypeEnum.CONTRACT_INVOICE_AUDIT.getName(),
      1002,
      false,
      0
   ),
   CONTRACT_SETTLEMENT_AUDIT(
      30002,
      "项目结算-审核",
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getModuleType(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getType(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getName(),
      1003,
      true,
      0
   ),
   CONTRACT_PRE_SETTLEMENT_AUDIT(
      30004,
      "项目预结算-审核",
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getModuleType(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getType(),
      FunctionTypeEnum.CONTRACT_PROJECT_SETTLEMENT.getName(),
      1004,
      true,
      0
   ),
   CONTRACT_PRE_REGISTRATION(
      30005,
      "合同预登记",
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getName(),
      1005,
      true,
      0
   ),
   CONTRACT_REVIEW_REGISTRATION(
      30006,
      "合同评审登记",
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getName(),
      1006,
      true,
      0
   ),
   CONTRACT_IMMEDIATE_REGISTRATION(
      30007,
      "合同直接登记",
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getType(),
      FunctionTypeEnum.CONTRACT_REGISTRATION.getName(),
      1007,
      false,
      0
   ),
   CONTRACT_COLLECTION_AUDIT(
      30008,
      "项目收款-审核",
      FunctionTypeEnum.CONTRACT_PROJECT_COLLECTION.getModuleType(),
      FunctionTypeEnum.CONTRACT_PROJECT_COLLECTION.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_PROJECT_COLLECTION.getType(),
      FunctionTypeEnum.CONTRACT_PROJECT_COLLECTION.getName(),
      1001,
      true,
      0
   ),
   CONTRACT_TESTING_AUDIT(
      30009,
      "检测费-审批",
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getName(),
      1005,
      true,
      0
   ),
   CONTRACT_WATER_ELECTRICITY_AUDIT(
      30010,
      "水电物业费-审批",
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getName(),
      1006,
      true,
      0
   ),
   CONTRACT_REIMBURSEMENT_AUDIT(
      30011,
      "报销费用-审批",
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getName(),
      1007,
      true,
      0
   ),
   CONTRACT_STAFF_WAGE_AUDIT(
      30012,
      "人员工资费用-审批",
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getModuleTypeName(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getType(),
      FunctionTypeEnum.CONTRACT_EXPENSE_ENTRY.getName(),
      1008,
      true,
      0
   ),
   PLAN_MODEL_DOCUMENT_MANAGE(
      50001,
      "模型文件管理",
      FunctionTypeEnum.PLAN_MODEL_DOCUMENT_MANAGE.getModuleType(),
      FunctionTypeEnum.PLAN_MODEL_DOCUMENT_MANAGE.getModuleTypeName(),
      FunctionTypeEnum.PLAN_MODEL_DOCUMENT_MANAGE.getType(),
      FunctionTypeEnum.PLAN_MODEL_DOCUMENT_MANAGE.getName(),
      2001,
      false,
      0
   ),
   PLAN_DRAWING_DOCUMENT_MANAGE(
      50002,
      "图纸文件管理",
      FunctionTypeEnum.PLAN_DRAWING_DOCUMENT_MANAGE.getModuleType(),
      FunctionTypeEnum.PLAN_DRAWING_DOCUMENT_MANAGE.getModuleTypeName(),
      FunctionTypeEnum.PLAN_DRAWING_DOCUMENT_MANAGE.getType(),
      FunctionTypeEnum.PLAN_DRAWING_DOCUMENT_MANAGE.getName(),
      2002,
      true,
      0
   ),
   PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE(
      50003,
      "数控文件管理",
      FunctionTypeEnum.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.getModuleType(),
      FunctionTypeEnum.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.getModuleTypeName(),
      FunctionTypeEnum.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.getType(),
      FunctionTypeEnum.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.getName(),
      2003,
      true,
      0
   ),
   PLAN_CHANGE_FILE(
      50004,
      "变更文件",
      FunctionTypeEnum.PLAN_CHANGE_FILE.getModuleType(),
      FunctionTypeEnum.PLAN_CHANGE_FILE.getModuleTypeName(),
      FunctionTypeEnum.PLAN_CHANGE_FILE.getType(),
      FunctionTypeEnum.PLAN_CHANGE_FILE.getName(),
      2004,
      false,
      0
   ),
   PLAN_CONSTRUCTION_BLUEPRINT(
      50005,
      "施工蓝图",
      FunctionTypeEnum.PLAN_CONSTRUCTION_BLUEPRINT.getModuleType(),
      FunctionTypeEnum.PLAN_CONSTRUCTION_BLUEPRINT.getModuleTypeName(),
      FunctionTypeEnum.PLAN_CONSTRUCTION_BLUEPRINT.getType(),
      FunctionTypeEnum.PLAN_CONSTRUCTION_BLUEPRINT.getName(),
      2005,
      false,
      0
   ),
   PLAN_PROCESS_DOCUMENT(
      50006,
      "工艺文件",
      FunctionTypeEnum.PLAN_PROCESS_DOCUMENT.getModuleType(),
      FunctionTypeEnum.PLAN_PROCESS_DOCUMENT.getModuleTypeName(),
      FunctionTypeEnum.PLAN_PROCESS_DOCUMENT.getType(),
      FunctionTypeEnum.PLAN_PROCESS_DOCUMENT.getName(),
      2006,
      false,
      0
   ),
   MES_TEMP_WORKER_MANAGE_ADD(
      60001,
      "点工新增",
      FunctionTypeEnum.MES_TEMP_WORKER_MANAGE.getModuleType(),
      FunctionTypeEnum.MES_TEMP_WORKER_MANAGE.getModuleTypeName(),
      FunctionTypeEnum.MES_TEMP_WORKER_MANAGE.getType(),
      FunctionTypeEnum.MES_TEMP_WORKER_MANAGE.getName(),
      3001,
      true,
      1
   ),
   MES_WAGE_ADJUST(
      60002,
      "工价调整",
      FunctionTypeEnum.MES_WAGE_ADJUST.getModuleType(),
      FunctionTypeEnum.MES_WAGE_ADJUST.getModuleTypeName(),
      FunctionTypeEnum.MES_WAGE_ADJUST.getType(),
      FunctionTypeEnum.MES_WAGE_ADJUST.getName(),
      3002,
      true,
      0
   ),
   MES_PAINTING_CRAFT(
      60003,
      "涂装工艺",
      FunctionTypeEnum.MES_PAINTING_CRAFT.getModuleType(),
      FunctionTypeEnum.MES_PAINTING_CRAFT.getModuleTypeName(),
      FunctionTypeEnum.MES_PAINTING_CRAFT.getType(),
      FunctionTypeEnum.MES_PAINTING_CRAFT.getName(),
      3003,
      true,
      0
   ),
   MES_MACHINE_PART(
      60004,
      "生产领料",
      FunctionTypeEnum.MES_MACHINE_PART.getModuleType(),
      FunctionTypeEnum.MES_MACHINE_PART.getModuleTypeName(),
      FunctionTypeEnum.MES_MACHINE_PART.getType(),
      FunctionTypeEnum.MES_MACHINE_PART.getName(),
      3004,
      true,
      2
   ),
   APPLY_PURCHASE_ADD(
      20001,
      "申购新增",
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getName(),
      5001,
      true,
      0
   ),
   APPLY_PURCHASE_CANCELLATION(
      20002,
      "申购删除",
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getName(),
      5002,
      true,
      0
   ),
   APPLY_PURCHASE_UPDATE_ADD(
      20019,
      "申购单编辑申请-（已通过）",
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getName(),
      5003,
      true,
      0
   ),
   PURCHASE_ORDER_ADD(
      20003,
      "采购单发起审批",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getName(),
      5004,
      true,
      0
   ),
   PURCHASE_ORDER_CANCELLATION(
      20004,
      "采购单删除",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getName(),
      5005,
      true,
      0
   ),
   PURCHASE_ORDER_UPDATE_ADD(
      20018,
      "采购单编辑申请-（已通过）",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getName(),
      5006,
      true,
      0
   ),
   SELF_BUYING_PAYMENT_AUDIT(
      20005,
      "采购-付款",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getName(),
      5007,
      true,
      0
   ),
   SELF_BUYING_INVOICE_AUDIT(
      20006,
      "采购-收票",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getName(),
      5008,
      true,
      0
   ),
   SELF_BUYING_SETTLEANACCOUNT_AUDIT(
      20007,
      "采购-结算",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getName(),
      5009,
      true,
      0
   ),
   SELF_BUYING_PRE_SETTLE_AUDIT(
      20020,
      "采购-预结算",
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getName(),
      5010,
      true,
      0
   ),
   INNER_PACKAGE_PAYMENT_AUDIT(
      20008,
      "采购-内包制合营-付款",
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getName(),
      5011,
      false,
      0
   ),
   INNER_PACKAGE_INVOICE_AUDIT(
      20009,
      "采购-内包制合营-开票",
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getName(),
      5012,
      false,
      0
   ),
   INNER_PACKAGE_SETTLEMENT_AUDIT(
      20010,
      "采购-内包制合营-结算",
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUPPLY_CHAIN_LUMP_SUM_SYSTEM_PURCHASE_ORDER_AUDIT.getName(),
      5013,
      false,
      0
   ),
   OUTSOURCING_ORDER_AUDIT(
      20011,
      "分包订单",
      FunctionTypeEnum.SUBCONTRACT_ORDER.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER.getName(),
      5014,
      false,
      0
   ),
   OUTSOURCING_ORDER_PAYMENT_AUDIT(
      20012,
      "分包订单-付款",
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getName(),
      5015,
      true,
      0
   ),
   OUTSOURCING_ORDER_INVOICE_AUDIT(
      20013,
      "分包订单-收票",
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getName(),
      5016,
      true,
      0
   ),
   OUTSOURCING_ORDER_SETTLE_AUDIT(
      20014,
      "分包订单-结算",
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getName(),
      5017,
      true,
      0
   ),
   OUTSOURCING_ORDER_PRE_SETTLE_AUDIT(
      20021,
      "分包订单-预结算",
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_AUDIT.getName(),
      5021,
      true,
      0
   ),
   OUTSOURCING_ORDER_INNER_PAYMENT_AUDIT(
      20015,
      "分包订单(内包/合营)-付款",
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getName(),
      5018,
      false,
      0
   ),
   OUTSOURCING_ORDER_INNER_INVOICE_AUDIT(
      20016,
      "分包订单(内包/合营)-开票",
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getName(),
      5019,
      false,
      0
   ),
   OUTSOURCING_ORDER_INNER_SETTLE_AUDIT(
      20017,
      "分包订单(内包/合营)-结算",
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getModuleTypeName(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getType(),
      FunctionTypeEnum.SUBCONTRACT_ORDER_INNER_AUDIT.getName(),
      5020,
      false,
      0
   ),
   SUPPLIER_EVALUATE(
      20030,
      "供应商评价",
      FunctionTypeEnum.SUPPLIER_EVALUATE.getModuleType(),
      FunctionTypeEnum.SUPPLIER_EVALUATE.getModuleTypeName(),
      FunctionTypeEnum.SUPPLIER_EVALUATE.getType(),
      FunctionTypeEnum.SUPPLIER_EVALUATE.getName(),
      5030,
      true,
      0
   ),
   SELF_BUYING_IN(
      10001,
      "自购入库",
      FunctionTypeEnum.WMS_SELF_BUYING_IN.getModuleType(),
      FunctionTypeEnum.WMS_SELF_BUYING_IN.getModuleTypeName(),
      FunctionTypeEnum.WMS_SELF_BUYING_IN.getType(),
      FunctionTypeEnum.WMS_SELF_BUYING_IN.getName(),
      6001,
      true,
      0
   ),
   PARTY_A_SUPPLY_IN(
      10002,
      "甲供入库",
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getModuleType(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getModuleTypeName(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getType(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getName(),
      6002,
      true,
      0
   ),
   SELF_BUYING_OUT(
      10003,
      "自购出库",
      FunctionTypeEnum.WMS_SELF_BUYING_OUT.getModuleType(),
      FunctionTypeEnum.WMS_SELF_BUYING_OUT.getModuleTypeName(),
      FunctionTypeEnum.WMS_SELF_BUYING_OUT.getType(),
      FunctionTypeEnum.WMS_SELF_BUYING_OUT.getName(),
      6003,
      true,
      0
   ),
   PARTY_A_SUPPLY_OUT(
      10004,
      "甲供出库",
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_OUT.getModuleType(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_OUT.getModuleTypeName(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_OUT.getType(),
      FunctionTypeEnum.WMS_PARTY_A_SUPPLY_OUT.getName(),
      6004,
      true,
      0
   ),
   OUTSOURCING_RETURN(
      10005,
      "自购物料退库",
      FunctionTypeEnum.WMS_SELF_BUYING_RETURN_WAREHOUSE.getModuleType(),
      FunctionTypeEnum.WMS_SELF_BUYING_RETURN_WAREHOUSE.getModuleTypeName(),
      FunctionTypeEnum.WMS_SELF_BUYING_RETURN_WAREHOUSE.getType(),
      FunctionTypeEnum.WMS_SELF_BUYING_RETURN_WAREHOUSE.getName(),
      6005,
      false,
      0
   ),
   MANUFACTURED_IN(
      10006,
      "制成品入库",
      FunctionTypeEnum.WMS_MANUFACTURED_IN.getModuleType(),
      FunctionTypeEnum.WMS_MANUFACTURED_IN.getModuleTypeName(),
      FunctionTypeEnum.WMS_MANUFACTURED_IN.getType(),
      FunctionTypeEnum.WMS_MANUFACTURED_IN.getName(),
      6006,
      true,
      0
   ),
   MANUFACTURED_OUT(
      10007,
      "制成品出库",
      FunctionTypeEnum.WMS_MANUFACTURED_OUT.getModuleType(),
      FunctionTypeEnum.WMS_MANUFACTURED_OUT.getModuleTypeName(),
      FunctionTypeEnum.WMS_MANUFACTURED_OUT.getType(),
      FunctionTypeEnum.WMS_MANUFACTURED_OUT.getName(),
      6007,
      true,
      0
   ),
   SCHEDULING_PICKING_OUT(
      10008,
      "排产领料审核",
      FunctionTypeEnum.WMS_SCHEDULING_PICKING_OUT.getModuleType(),
      FunctionTypeEnum.WMS_SCHEDULING_PICKING_OUT.getModuleTypeName(),
      FunctionTypeEnum.WMS_SCHEDULING_PICKING_OUT.getType(),
      FunctionTypeEnum.WMS_SCHEDULING_PICKING_OUT.getName(),
      6008,
      true,
      0
   ),
   INBOUND_MONEY_ADJUST(
      10009,
      "入库金额调整",
      FunctionTypeEnum.WMS_INBOUND_MONEY_ADJUST.getModuleType(),
      FunctionTypeEnum.WMS_INBOUND_MONEY_ADJUST.getModuleTypeName(),
      FunctionTypeEnum.WMS_INBOUND_MONEY_ADJUST.getType(),
      FunctionTypeEnum.WMS_INBOUND_MONEY_ADJUST.getName(),
      6009,
      true,
      0
   ),
   CHECK_DEFICIT(
      10010,
      "盘亏",
      FunctionTypeEnum.WMS_CHECK_DEFICIT.getModuleType(),
      FunctionTypeEnum.WMS_CHECK_DEFICIT.getModuleTypeName(),
      FunctionTypeEnum.WMS_CHECK_DEFICIT.getType(),
      FunctionTypeEnum.WMS_CHECK_DEFICIT.getName(),
      6010,
      true,
      0
   ),
   WMS_SURPLUS(
      140001,
      "盘盈",
      FunctionTypeEnum.WMS_SURPLUS.getModuleType(),
      FunctionTypeEnum.WMS_SURPLUS.getModuleTypeName(),
      FunctionTypeEnum.WMS_SURPLUS.getType(),
      FunctionTypeEnum.WMS_SURPLUS.getName(),
      6011,
      true,
      2
   ),
   RETURN(
      10011,
      "退库",
      FunctionTypeEnum.WMS_RETURN.getModuleType(),
      FunctionTypeEnum.WMS_RETURN.getModuleTypeName(),
      FunctionTypeEnum.WMS_RETURN.getType(),
      FunctionTypeEnum.WMS_RETURN.getName(),
      6012,
      true,
      0
   ),
   SHIPMENT_RECEIVE_OUT(
      10012,
      "配套件领用审核",
      FunctionTypeEnum.WMS_SHIPMENT_RECEIVE_OUT.getModuleType(),
      FunctionTypeEnum.WMS_SHIPMENT_RECEIVE_OUT.getModuleTypeName(),
      FunctionTypeEnum.WMS_SHIPMENT_RECEIVE_OUT.getType(),
      FunctionTypeEnum.WMS_SHIPMENT_RECEIVE_OUT.getName(),
      6013,
      true,
      0
   ),
   REJECT(
      10013,
      "退货",
      FunctionTypeEnum.WMS_REJECT.getModuleType(),
      FunctionTypeEnum.WMS_REJECT.getModuleTypeName(),
      FunctionTypeEnum.WMS_REJECT.getType(),
      FunctionTypeEnum.WMS_REJECT.getName(),
      6014,
      true,
      0
   ),
   MOVE_MATERIAL(
      10014,
      "移库",
      FunctionTypeEnum.WMS_MOVE_MATERIAL.getModuleType(),
      FunctionTypeEnum.WMS_MOVE_MATERIAL.getModuleTypeName(),
      FunctionTypeEnum.WMS_MOVE_MATERIAL.getType(),
      FunctionTypeEnum.WMS_MOVE_MATERIAL.getName(),
      6015,
      true,
      0
   ),
   MANUFACTURES_CONVERT(
      10015,
      "条板转换",
      FunctionTypeEnum.WMS_MANUFACTURES_CONVERT.getModuleType(),
      FunctionTypeEnum.WMS_MANUFACTURES_CONVERT.getModuleTypeName(),
      FunctionTypeEnum.WMS_MANUFACTURES_CONVERT.getType(),
      FunctionTypeEnum.WMS_MANUFACTURES_CONVERT.getName(),
      6016,
      true,
      0
   ),
   PROJECT_MANAGE_VISA(
      80001,
      "签证管理",
      FunctionTypeEnum.PROJECT.getModuleType(),
      FunctionTypeEnum.PROJECT.getModuleTypeName(),
      FunctionTypeEnum.PROJECT.getType(),
      FunctionTypeEnum.PROJECT.getName(),
      8001,
      true,
      2
   );

   private Integer type;
   private String name;
   private Integer moduleType;
   private String moduleTypeName;
   private Integer functionType;
   private String functionTypeName;
   private Integer sort;
   private Boolean status;
   private Integer approveFacility;

   ApproveProcessTypeEnumV2(
      int type,
      String name,
      int moduleType,
      String moduleTypeName,
      int functionType,
      String functionTypeName,
      int sort,
      Boolean status,
      Integer approveFacility
   ) {
      this.type = type;
      this.name = name;
      this.moduleType = moduleType;
      this.moduleTypeName = moduleTypeName;
      this.functionType = functionType;
      this.functionTypeName = functionTypeName;
      this.sort = sort;
      this.status = status;
      this.approveFacility = approveFacility;
   }

   public static ApproveProcessTypeEnumV2 selectType(Integer type) {
      for (ApproveProcessTypeEnumV2 value : values()) {
         if (value.type.equals(type)) {
            return value;
         }
      }

      Preconditions.checkArgument(false, "审批模版枚举类未查询到!!");
      return null;
   }

   public static String getName(Integer type) {
      for (ApproveProcessTypeEnumV2 approveProcessTypeEnumV2 : values()) {
         if (approveProcessTypeEnumV2.getType().equals(type)) {
            return approveProcessTypeEnumV2.getName();
         }
      }

      return null;
   }

   public static List<WmsApproveTemplateDTO> getTemplate() {
      List<WmsApproveTemplateDTO> wmsApproveTemplateDTOS = new ArrayList<>();

      for (ApproveProcessTypeEnumV2 value : values()) {
         WmsApproveTemplateDTO build = WmsApproveTemplateDTO.builder()
            .name(value.getName())
            .moduleType(value.getModuleType())
            .functionType(value.getFunctionType())
            .approveProcessType(value.getType())
            .moduleName(value.getModuleTypeName())
            .sort(value.getSort())
            .status(value.getStatus())
            .build();
         wmsApproveTemplateDTOS.add(build);
      }

      return wmsApproveTemplateDTOS.stream()
         .filter(w -> w.getStatus())
         .sorted(Comparator.comparing(WmsApproveTemplateDTO::getSort))
         .collect(Collectors.toList());
   }

   public static Boolean boolRewrite(Integer approveProcessType) {
      Boolean boolRewrite = false;
      if (SELF_BUYING_IN.type.equals(approveProcessType)
         || PARTY_A_SUPPLY_IN.type.equals(approveProcessType)
         || APPLY_PURCHASE_ADD.type.equals(approveProcessType)
         || PURCHASE_ORDER_ADD.type.equals(approveProcessType)
         || PURCHASE_ORDER_UPDATE_ADD.type.equals(approveProcessType)
         || APPLY_PURCHASE_UPDATE_ADD.getType().equals(approveProcessType)
         || CONTRACT_PRE_REGISTRATION.type.equals(approveProcessType)) {
         boolRewrite = true;
      }

      return boolRewrite;
   }

   public static Boolean boolShowButton(Integer facility, Integer approveProcessType) {
      for (ApproveProcessTypeEnumV2 value : values()) {
         if (value.getType().equals(approveProcessType)) {
            if (value.approveFacility != 2 && !Objects.equals(facility, value.approveFacility)) {
               return false;
            }

            return true;
         }
      }

      return false;
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

   public Integer getFunctionType() {
      return this.functionType;
   }

   public String getFunctionTypeName() {
      return this.functionTypeName;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getApproveFacility() {
      return this.approveFacility;
   }
}
