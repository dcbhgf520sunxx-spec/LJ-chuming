package com.hzchum.scim.common.core.api.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;

public class ComponentNameUtils {
   public static final String APPLY_PURCHASE = "Requisitions-v2";
   public static final String PURCHASE_ORDER_SELF_SUPPORT = "PurchaseOrderV2";
   public static final String PURCHASE_ORDER_JOINT_VENTURE = "PurchaseOrderBG";
   public static final String PURCHASE_ORDER_LUMP_SUM_SYSTEM = "PurchaseOrderBG";
   public static final String SELF_BUYING_IN = "RawMatInboundApplicationRecordPurchase";
   public static final String MANUFACTURED_IN = "ManufInboundApplicationRecordPurchase";
   public static final String PARTY_A_SUPPLY_IN = "RawMatInboundApplicationRecordPartyA";
   public static final String FOR_SALE_OUTBOUND = "WMSOutboundReview-V2";
   public static final String TEMPORARY_LOAN_OUTBOUND = "WMSOutboundReview-V2";
   public static final String OUTSOURCING_RAW_MATERIALS_OUTBOUND = "WMSOutboundReview-V2";
   public static final String SCRAPS_OUTBOUND = "WMSOutboundReview-V2";
   public static final String PRODUCTION_USE_OUTBOUND = "WMSOutboundReview-V2";
   public static final String PARTY_A_SUPPLY_OUTBOUND = "WMSOutboundReview-ptA";
   public static final String OUTSOURCING_RAW_MATERIALS_RETURNED = "RawMatReturnApplicationReview";
   public static final String SCHEDULING_PICKING_OUT = "RawMatMesReceiptAudit";
   public static final String SHIPMENT_RECEIVE_OUT = "RawMatMesShipReceiptReview";
   public static final String PLAN_MODEL_DOCUMENT_MANAGE = "ModelFile";
   public static final String PLAN_DRAWING_DOCUMENT_MANAGE = "DrawingFile";
   public static final String PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE = "CNCFile";
   public static final String PLAN_CHANGE_FILE = "PlanChangeFile";
   public static final String PLAN_CONSTRUCTION_BLUEPRINT = "PlanBlueprint";
   public static final String PLAN_PROCESS_DOCUMENT = "PlanProcess";
   public static final String CRM_PROJECT_FOLLOW_UP = "CRMProjectFollowUp";
   public static final String CRM_PROJECT_ANTECEDENT_TRIAL = "CRMProjectAntecedentTrial";
   public static final String CRM_PROJECT_RECORD = "CRMProjectRecord";
   public static final String CRM_PROJECT_GIVE_UP = "CRMProjectGiveUp";
   public static final String CRM_PROJECT_BID = "CRMProjectBid";
   public static final String CRM_PROJECT_BUSINESS_BID = "CRMProjectBusinessBid";
   public static final String CRM_PROJECT_DEEP_DESIGN_BID = "CRMProjectDeepDesignBid";
   public static final String CRM_PROJECT_STRUCTURAL_DESIGN_BID = "CRMProjectStructuralDesignBid";
   public static final String CRM_PROJECT_TECHNOLOGY_BID = "CRMProjectTechnologyBid";
   public static final String CRM_TECHNOLOGY_DIRECT_BIDDING = "CRMTechnologyFirectBidding";
   public static final String CRM_TECHNOLOGY_NON_DIRECT_BIDDING = "CRMTechnologyNonDirectBidding";
   public static final String PURCHASE_ORDER_V2_INVOICE = "PurchaseOrderV2Invoice";
   public static final String PURCHASE_ORDER_V2_SETTLEMENT = "PurchaseOrderV2Settlement";
   public static final String PURCHASE_ORDER_V2_PRE_SETTLEMENT = "PurchaseOrderV2PreSettlement";
   public static final String PURCHASE_ORDER_V2_PAYMENT = "PurchaseOrderV2Payment";
   public static final String PURCHASE_ORDER_BG_PAYMENT = "PurchaseOrderBGPayment";
   public static final String PURCHASE_ORDER_BG_INVOICE = "PurchaseOrderBGInvoice";
   public static final String PURCHASE_ORDER_BG_SETTLEMENT = "PurchaseOrderBGSettlement";
   public static final String SUBCONTRACT_ORDER_PAYMENT = "selfSubpackagePayment";
   public static final String SUBCONTRACT_ORDER_INVOICE = "selfSubpackageInvoice";
   public static final String SUBCONTRACT_ORDER_SETTLE = "selfSubpackageSettle";
   public static final String SUBCONTRACT_ORDER_PRE_SETTLE = "selfSubpackagePreSettle";
   public static final String SUBCONTRACT_ORDER_INNER_PAYMENT = "interSubpackagePayment";
   public static final String SUBCONTRACT_ORDER_INNER_INVOICE = "interSubpackageEntry";
   public static final String SUBCONTRACT_ORDER_INNER_SETTLE = "interSubpackageSettle";
   private static final String STANDING_BOOK_SELF_INVOICE = "StandingBookSelfInvoice";
   private static final String STANDING_BOOK_INNER_INVOICE = "StandingBookInnerInvoice";
   private static final String STANDING_BOOK_SELF_COLLECTION = "StandingBookSelfCollection";
   private static final String STANDING_BOOK_SELF_SETTLEMENT = "projectSettlement";
   private static final String STANDING_BOOK_SELF_PRE_SETTLEMENT = "projectPreSettlement";
   private static final String FILL_TESTING_FEE_APPROVE = "fillTestingFeeApprove";
   private static final String FILL_WATER_ELECTRICITY_APPROVE = "fillWaterElectricityApprove";
   private static final String FILL_REIMBURSEMENT_APPROVE = "fillReimbursementApprove";
   private static final String FILL_STAFF_WAGE_APPROVE = "fillStaffWageApprove";
   public static final String APP_COMPONENT = "AppComponent";
   public static final String WAGE_ADJUST = "ReportingApproval";
   public static final String PROJECT_MANAGE_VISA = "InstallVisaManage";
   public static final String MES_PAINTING_CRAFT = "CoatingProcessApproval";
   public static final String MES_MACHINE_PART = "PartApproval";
   public static final String DEFICIT = "inventoryLossList";
   public static final String ADJUST = "PriceAdjustApplication";
   public static final String WMS_SURPLUS = "inventoryProfitList";
   public static final String RETURN = "RawMatReturnApplicationReviewBase";
   public static final String REJECT = "RawMatRejectReview";
   public static final String MOVE_MATERIAL = "RawMatMovingInventoryApplicationReview";
   public static final String MANUFACTURES_CONVERT = "StripConversionList";
   public static final String CONTRACT_PRE_REGISTRATION = "catalogPreRegister";
   public static final String CONTRACT_REVIEW_REGISTRATION = "catalogReviewRegister";
   public static final String SUPPLIER_EVALUATE = "SupplierEvaluationOperate";

   public static String getComponentName(Integer approveProcessTypeEnum, MountMessageDTO mountMessageDTO) {
      String componentName = "";
      switch (ApproveProcessTypeEnumV2.selectType(approveProcessTypeEnum)) {
         case APPLY_PURCHASE_ADD:
            componentName = "Requisitions-v2";
            break;
         case APPLY_PURCHASE_CANCELLATION:
            componentName = "Requisitions-v2";
            break;
         case APPLY_PURCHASE_UPDATE_ADD:
            componentName = "Requisitions-v2";
            break;
         case PURCHASE_ORDER_ADD:
            componentName = purchaseOrderComponent(mountMessageDTO);
            break;
         case PURCHASE_ORDER_CANCELLATION:
            componentName = purchaseOrderComponent(mountMessageDTO);
            break;
         case SELF_BUYING_IN:
            componentName = "RawMatInboundApplicationRecordPurchase";
            break;
         case PARTY_A_SUPPLY_IN:
            componentName = "RawMatInboundApplicationRecordPartyA";
            break;
         case SCHEDULING_PICKING_OUT:
            componentName = "RawMatMesReceiptAudit";
            break;
         case SHIPMENT_RECEIVE_OUT:
            componentName = "RawMatMesShipReceiptReview";
            break;
         case PLAN_MODEL_DOCUMENT_MANAGE:
            componentName = "ModelFile";
            break;
         case PLAN_DRAWING_DOCUMENT_MANAGE:
            componentName = "DrawingFile";
            break;
         case PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE:
            componentName = "CNCFile";
            break;
         case PLAN_CHANGE_FILE:
            componentName = "PlanChangeFile";
            break;
         case PLAN_CONSTRUCTION_BLUEPRINT:
            componentName = "PlanBlueprint";
            break;
         case PLAN_PROCESS_DOCUMENT:
            componentName = "PlanProcess";
            break;
         case PROJECT_MANAGE_VISA:
            componentName = "InstallVisaManage";
            break;
         case SELF_BUYING_OUT:
            componentName = outboundComponent(mountMessageDTO);
            break;
         case PARTY_A_SUPPLY_OUT:
            componentName = "WMSOutboundReview-ptA";
            break;
         case OUTSOURCING_RETURN:
            componentName = returnedComponent(mountMessageDTO);
            break;
         case CRM_PROJECT_FOLLOW_UP:
            componentName = "CRMProjectFollowUp";
            break;
         case CRM_PRELIMINARY:
            componentName = "CRMProjectAntecedentTrial";
            break;
         case CRM_TENDER:
            componentName = "CRMProjectBid";
            break;
         case CRM_BUSINESS_BIDDING:
            componentName = "CRMProjectBusinessBid";
            break;
         case CRM_DEEP_DESIGN_BIDDING:
            componentName = "CRMProjectDeepDesignBid";
            break;
         case CRM_STRUCTURAL_DESIGN_BIDDING:
            componentName = "CRMProjectStructuralDesignBid";
            break;
         case CRM_TECHNOLOGY_BIDDING:
            componentName = "CRMProjectTechnologyBid";
            break;
         case CRM_TECHNOLOGY_DIRECT_BIDDING:
            componentName = "CRMTechnologyFirectBidding";
            break;
         case CRM_TECHNOLOGY_NON_DIRECT_BIDDING:
            componentName = "CRMTechnologyNonDirectBidding";
            break;
         case CRM_ABANDON:
            componentName = "CRMProjectGiveUp";
            break;
         case CRM_PROJECT_FILING:
            componentName = "CRMProjectRecord";
            break;
         case CONTRACT_INVOICE_AUDIT:
            componentName = "StandingBookSelfInvoice";
            break;
         case CONTRACT_INSOURCING:
            componentName = "StandingBookInnerInvoice";
            break;
         case CONTRACT_COLLECTION_AUDIT:
            componentName = "StandingBookSelfCollection";
            break;
         case CONTRACT_SETTLEMENT_AUDIT:
            componentName = "projectSettlement";
            break;
         case CONTRACT_PRE_SETTLEMENT_AUDIT:
            componentName = "projectPreSettlement";
            break;
         case CONTRACT_TESTING_AUDIT:
            componentName = "fillTestingFeeApprove";
            break;
         case CONTRACT_WATER_ELECTRICITY_AUDIT:
            componentName = "fillWaterElectricityApprove";
            break;
         case CONTRACT_REIMBURSEMENT_AUDIT:
            componentName = "fillReimbursementApprove";
            break;
         case CONTRACT_STAFF_WAGE_AUDIT:
            componentName = "fillStaffWageApprove";
            break;
         case SELF_BUYING_PAYMENT_AUDIT:
            componentName = "PurchaseOrderV2Payment";
            break;
         case SELF_BUYING_INVOICE_AUDIT:
            componentName = "PurchaseOrderV2Invoice";
            break;
         case SELF_BUYING_SETTLEANACCOUNT_AUDIT:
            componentName = "PurchaseOrderV2Settlement";
            break;
         case SELF_BUYING_PRE_SETTLE_AUDIT:
            componentName = "PurchaseOrderV2PreSettlement";
            break;
         case INNER_PACKAGE_PAYMENT_AUDIT:
            componentName = "PurchaseOrderBGPayment";
            break;
         case INNER_PACKAGE_INVOICE_AUDIT:
            componentName = "PurchaseOrderBGInvoice";
            break;
         case INNER_PACKAGE_SETTLEMENT_AUDIT:
            componentName = "PurchaseOrderBGSettlement";
            break;
         case PURCHASE_ORDER_UPDATE_ADD:
            componentName = purchaseOrderComponent(mountMessageDTO);
            break;
         case MANUFACTURED_OUT:
            componentName = "WMSOutboundRecordManuf-V2";
            break;
         case MANUFACTURED_IN:
            componentName = "ManufInboundApplicationRecordPurchase";
            break;
         case CHECK_DEFICIT:
            componentName = "inventoryLossList";
            break;
         case INBOUND_MONEY_ADJUST:
            componentName = "PriceAdjustApplication";
            break;
         case OUTSOURCING_ORDER_PAYMENT_AUDIT:
            componentName = "selfSubpackagePayment";
            break;
         case OUTSOURCING_ORDER_INVOICE_AUDIT:
            componentName = "selfSubpackageInvoice";
            break;
         case OUTSOURCING_ORDER_SETTLE_AUDIT:
            componentName = "selfSubpackageSettle";
            break;
         case OUTSOURCING_ORDER_PRE_SETTLE_AUDIT:
            componentName = "selfSubpackagePreSettle";
            break;
         case OUTSOURCING_ORDER_INNER_PAYMENT_AUDIT:
            componentName = "interSubpackagePayment";
            break;
         case OUTSOURCING_ORDER_INNER_INVOICE_AUDIT:
            componentName = "interSubpackageEntry";
            break;
         case OUTSOURCING_ORDER_INNER_SETTLE_AUDIT:
            componentName = "interSubpackageSettle";
         case MES_TEMP_WORKER_MANAGE_ADD:
            break;
         case MES_WAGE_ADJUST:
            componentName = "ReportingApproval";
            break;
         case MES_PAINTING_CRAFT:
            componentName = "CoatingProcessApproval";
            break;
         case MES_MACHINE_PART:
            componentName = "PartApproval";
            break;
         case WMS_SURPLUS:
            componentName = "inventoryProfitList";
            break;
         case RETURN:
            componentName = "RawMatReturnApplicationReviewBase";
            break;
         case REJECT:
            componentName = "RawMatRejectReview";
            break;
         case MOVE_MATERIAL:
            componentName = "RawMatMovingInventoryApplicationReview";
            break;
         case MANUFACTURES_CONVERT:
            componentName = "StripConversionList";
            break;
         case CONTRACT_PRE_REGISTRATION:
            componentName = "catalogPreRegister";
            break;
         case CONTRACT_REVIEW_REGISTRATION:
            componentName = "catalogReviewRegister";
            break;
         case SUPPLIER_EVALUATE:
            componentName = "SupplierEvaluationOperate";
            break;
         default:
            Preconditions.checkArgument(false, "未获取到路径信息");
      }

      return componentName;
   }

   private static String purchaseOrderComponent(MountMessageDTO mountMessageDTO) {
      String componentName = "";
      Preconditions.checkArgument(
         ObjectUtil.isNotEmpty(mountMessageDTO) && CollectionUtil.isNotEmpty(mountMessageDTO.getProjectAttribute()), "未传挂载信息或挂载信息采购单类型为空"
      );
      Integer type = mountMessageDTO.getProjectAttribute().get(0);
      if (type.equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         componentName = "PurchaseOrderV2";
      } else if (type.equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         componentName = "PurchaseOrderBG";
      } else if (type.equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         componentName = "PurchaseOrderBG";
      } else {
         Preconditions.checkArgument(false, "未匹配到采购单类型，返回ComponentName失败");
      }

      return componentName;
   }

   private static String outboundComponent(MountMessageDTO mountMessageDTO) {
      String componentName = "";
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(mountMessageDTO) && CollectionUtil.isNotEmpty(mountMessageDTO.getOutboundType()), "未传挂载信息或挂载信息出库单类型为空");
      Integer type = mountMessageDTO.getOutboundType().get(0);
      if (type.equals(OutboundTypeEnum.FOR_SALE.getType())) {
         componentName = "WMSOutboundReview-V2";
      } else if (type.equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())) {
         componentName = "WMSOutboundReview-V2";
      } else if (type.equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         componentName = "WMSOutboundReview-V2";
      } else if (type.equals(OutboundTypeEnum.SCRAPS.getType())) {
         componentName = "WMSOutboundReview-V2";
      } else if (!type.equals(OutboundTypeEnum.PRODUCTION_USE.getType()) && !type.equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         Preconditions.checkArgument(false, "未匹配到出库单类型，返回ComponentName失败");
      } else {
         componentName = "WMSOutboundReview-V2";
      }

      return componentName;
   }

   private static String returnedComponent(MountMessageDTO mountMessageDTO) {
      String componentName = "";
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(mountMessageDTO) && CollectionUtil.isNotEmpty(mountMessageDTO.getReturnedType()), "未传挂载信息或挂载信息退库库单类型为空");
      Integer type = mountMessageDTO.getReturnedType().get(0);
      if (type.equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         componentName = "RawMatReturnApplicationReview";
      } else {
         Preconditions.checkArgument(false, "未匹配到采购单类型，返回ComponentName失败");
      }

      return componentName;
   }
}
