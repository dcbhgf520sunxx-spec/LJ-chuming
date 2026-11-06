function S_e(e) {
  return W({ url: "/api/contract/return/sale/ledger/list/print", method: "get", params: e });
}
function v_e(e) {
  return W({ url: "/api/contract/return/sale/ledger/product/list/print", method: "get", params: e });
}
function R_e(e) {
  return W({ url: "/api/contract/return/sale/ledger/collection/list/print", method: "get", params: e });
}
function M_e(e) {
  return W({ url: "/api/contract/return/sale/ledger/invoice/list/print", method: "get", params: e });
}
function A_e(e) {
  return e != null && e.isSales ? W({ url: "/api/project/tracking/v2/return/list/print", method: "get", params: e }) : W({ url: "/api/business/ship/return/list/print", method: "get", params: e });
}
function N_e(e) {
  return W({ url: "/api/business/ship/return/list/print", method: "get", params: e });
}
function L_e(e) {
  return W({ url: "/api/contract/supplier/summary/purchaseOrder/list/print", method: "get", params: e });
}
function I_e(e) {
  return W({ url: "/api/contract/supplier/summary/subcontractOrder/list/print", method: "get", params: e });
}
function C_e(e) {
  return W({ url: "/api/contract/supplier/summary/cargoList/list/print", method: "get", params: e });
}
function P_e(e) {
  return W({ url: "/api/contract/supplier/summary/logistics/list/print", method: "get", params: e });
}
const yt = { contractLedger: m0e, collectionLedger: p0e, collectionProject: h0e, invoiceLedger: f0e, invoiceProject: g0e, arrearsList: E0e, myProject: w0e, projectList: S0e, structurePrice: v0e, enclosurePrice: A0e, machinePartPrice: R0e, machinePartDetail: M0e, auxiliaryMaterialPrice: N0e, logisticsLedger: y0e, payableSummary: T0e, supplierPayableList: _0e, supplierPayableLedger: b0e, supplierInvoiceLedger: V0e, collectionDetail: L0e, invoiceDetail: I0e, happenedDetail: C0e, transactionRecord: P0e, saleOrderTracking: O0e, unitListValuationDetail: k0e, unitOrderTrackingShip: D0e, unitOrderTrackingCollection: x0e, unitOrderTrackingInvoice: U0e, shipmentTracking: Y0e, bridgeShipmentTracking: K0e, warehouseRecord: W0e, industryElectricRecord: j0e, civilElectricRecord: F0e, waterRecord: z0e, gasRecord: B0e, expenseReimburseList: H0e, managementSalaryList: q0e, productionSalaryList: G0e, propertyFeeList: Q0e, purchaseSupplierInvoiceDetail: ITe, stairUnitSupplierSettleDetail: CTe, secondUnitSelfInvoiceDetail: LTe, secondUnitSelfCollectionDetail: RTe, secondUnitSelfPreSettleDetail: ATe, selfPreSettleDetail: MTe, stairUnitSupplierTicketDetail: FTe, stairUnitSupplierPaymentDetail: jTe, selfCostPeriod: WTe, selfPaymentRecord: KTe, selfCostMaterials: YTe, capitalInjectionUse: TTe, innerIncomeDetail: UTe, innerCostManage: xTe, innerCostOther: DTe, innerCostMaterials: kTe, collectionInfo: mTe, collectionInfoV2: pTe, invoiceInfo: hTe, invoiceInfoV2: fTe, expendInfo: gTe, expendInfoV2: ETe, capitalInjection: yTe, creditExtension: _Te, approvalManagement: bTe, expendPaymentRecord: VTe, expendInvoiceRecord: STe, selfExpendCollectionDetail: vTe, selfExpendInvoiceDetail: NTe, selfCollectionAndInvoiceInfo: PTe, selfTotalDisburse: OTe, mainMaterialList: Z0e, manualList: J0e, shippingFeeList: X0e, testingFee: $0e, subcontractFee: eTe, projectManagementFee: tTe, managementFee: iTe, waterElectricFee: aTe, depreciationFee: lTe, fortuneReportList: oTe, contractBoxPrice: nTe, scrapInvoice: sTe, totalScrapDetaile: dTe, scrapCollection: rTe, scrapPurchaser: cTe, scrapDate: uTe, factoryDepreciation: zTe, equipmentDepreciation: BTe, reimbursementFee: HTe, wageCost: qTe, fabricatingCostStatistics: GTe, mainMaterialsStatistics: QTe, auxiliaryMaterialsDirectCost: ZTe, auxiliaryMaterialsAmortizationCost: JTe, otherSteelMaterials: XTe, paintCost: $Te, weldingConsumableCost: e_e, productionLaborCost: t_e, tempWorkAmortizationCost: i_e, managerAmortizationCost: a_e, transportationCost: l_e, waterElectricityAmortization: o_e, propertyAmortization: r_e, fabricatingCostStatisticsGasFee: n_e, fabricatingCostStatisticsGasDirectCost: s_e, directCostReport: u_e, amortizationCostReport: c_e, materialConstructionSiteCostReport: d_e, materialConstructionSitePaymentRecord: wTe, factoryDepreciationReport: m_e, equipmentDepreciationReport: p_e, testingFeeReport: h_e, finishedProductScrapLoss: f_e, manufRepairList: g_e, manufReuseList: E_e, mainBusinessIncome: y_e, nonMainBusinessIncome: T_e, returnLedgerList: __e, returnLedgerDetail: b_e, recoveryPaymentRecord: V_e, recoveryInvoiceRecord: w_e, productWasteList: S_e, productWasteDetail: v_e, productCollectionRecord: R_e, productInvoiceRecord: M_e, shipmentReturnListStructure: A_e, shipmentReturnListEnclosure: N_e, paymentPurchaseOrderRecord: L_e, paymentSubcontractRecord: I_e, paymentManufShippingRecord: C_e, paymentMaterialShippingRecord: P_e };
function O_e(e) {
  return W({ url: `api/mes/building/package/${e}/print`, method: "get" });
}
function k_e(e) {
  return W({ url: `api/mes/bridge/package/${e}/print`, method: "get" });
}
function D_e(e) {
  return W({ url: `api/mes/building/package/${e}/print`, method: "get" });
}
function x_e(e) {
  return W({ url: "api/mes/building/cargo/ship/print", method: "get", params: e });
}
function U_e(e) {
  return W({ url: "api/mes/bridge/cargo/ship/print", method: "get", params: e });
}
function Y_e(e) {
  return W({ url: `api/mes/building/cargo/ship/${e}/print`, method: "get" });
}
function K_e(e) {
  return W({ url: `api/mes/bridge/cargo/ship/${e}/print`, method: "get" });
}
function W_e(e) {
  return W({ url: "api/mes/building/cargo/receipt/print", method: "get", params: e });
}
function j_e(e) {
  return W({ url: "api/mes/bridge/cargo/receipt/print", method: "get", params: e });
}
function F_e(e) {
  return W({ url: `api/mes/building/cargo/receipt/${e}/print`, method: "get" });
}
function z_e(e) {
  return W({ url: `api/mes/bridge/cargo/receipt/${e}/print`, method: "get" });
}
function B_e(e) {
  return W({ url: "api/mes/building/cargo/review/print", method: "get", params: e });
}
function H_e(e) {
  return W({ url: `/api/mes/building/cargo/review/${e}/print`, method: "get" });
}
function q_e(e) {
  return W({ url: `api/mes/building/cargo/receipt/${e}/print`, method: "get" });
}
function G_e(e) {
  return W({ url: "api/mes/bridge/cargo/review/print", method: "get", params: e });
}
function Q_e(e) {
  return W({ url: `api/mes/bridge/cargo/receipt/${e}/print`, method: "get" });
}
function Z_e(e) {
  return W({ url: "api/mes/building/cargo/logistics/print", method: "get", params: e });
}
function J_e(e) {
  return W({ url: "api/mes/bridge/cargo/logistics/print", method: "get", params: e });
}
function X_e({ monomerId: e, areaId: o, factoryId: n }) {
  return W({ url: "api/mes/building/warehouse/artifact/print", method: "get", params: { monomerId: e, areaId: o, factoryId: n } });
}
function $_e({ monomerId: e, areaId: o, factoryId: n }) {
  return W({ url: "api/mes/building/warehouse/enclosure/print", method: "get", params: { monomerId: e, areaId: o, factoryId: n } });
}
function e2e(e) {
  return W({ url: "/api/mes/building/warehouse/report/print", method: "get", params: e });
}
function t2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/artifact", method: "get", params: e });
}
function i2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/artifact", method: "get", params: e });
}
function a2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/artifact", method: "get", params: e });
}
function l2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/artifact", method: "get", params: e });
}
function o2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/artifact", method: "get", params: e });
}
function n2e(e) {
  return W({ url: "/api/mes/bridge/warehouse/print/finish-product/box", method: "get", params: e });
}
function s2e(e) {
  return W({ url: "/api/mes/bridge/warehouse/print/finish-product/box", method: "get", params: e });
}
function r2e(e) {
  return W({ url: "/api/mes/bridge/warehouse/print/finish-product/box", method: "get", params: e });
}
function u2e(e) {
  return W({ url: "/api/mes/bridge/warehouse/print/finish-product/box", method: "get", params: e });
}
function c2e(e) {
  return W({ url: "/api/mes/bridge/warehouse/print/finish-product/box", method: "get", params: e });
}
function d2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function m2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function p2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function h2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function f2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function g2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function E2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
function y2e(e) {
  return W({ url: "/api/mes/building/warehouse/print/finish-product/enclosure", method: "get", params: e });
}
