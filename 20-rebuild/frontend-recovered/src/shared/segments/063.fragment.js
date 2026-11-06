function ATe(e) {
  return W({ url: `/api/contract/project/preSettlement/list/print?projectId=${e}`, method: "get", params: { level: 2 } });
}
function NTe(e) {
  return W({ url: `/api/contract/invoice/downloadInvoice/${e}`, method: "get", params: { level: 1 } });
}
function LTe(e) {
  return W({ url: `/api/contract/invoice/downloadInvoice/${e}`, method: "get", params: { level: 2 } });
}
function ITe(e) {
  return e != null && e.isSub ? W({ url: `/api/v2/scm/subcontract-order/invoiceList/${e.id}/print`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/invoiceList/print", method: "get", params: e }) : W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/invoiceDetail/${e.id}/download`, method: "get", params: e });
}
function CTe(e) {
  return e != null && e.isSub ? W({ url: `/api/v2/scm/subcontract-order/settleList/${e.id}/print`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/settleList/print", method: "get", params: e }) : W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/settleDetail/${e.id}/download`, method: "get", params: e });
}
function PTe(e) {
  return W({ url: `/api/project/v2/${e}/collectionAndInvoiceDetailDownload`, method: "get" });
}
function OTe(e) {
  return W({ url: `/api/project/v2/detailList/${e}`, method: "get" });
}
function kTe(e) {
  return W({ url: "", method: "get", params: { incomeExpendType: 2, ...e } });
}
function DTe(e) {
  return W({ url: "", method: "get", params: { incomeExpendType: 2, ...e } });
}
function xTe(e) {
  return W({ url: "", method: "get", params: { incomeExpendType: 2, ...e } });
}
function UTe(e) {
  return W({ url: "/api/project/v2/standingbook/download", method: "get", params: e });
}
function YTe(e) {
  return W({ url: "/api/project/v2/selfSupportCost/detail/print", method: "get", params: e });
}
function KTe(e) {
  return W({ url: "/api/project/v2/selfSupportCost/detail/paymentList/print", method: "get", params: e });
}
function WTe(e) {
  return W({ url: "/api/project/v2/periodCost/download", method: "get", params: e });
}
function jTe(e) {
  return e != null && e.isSub ? W({ url: `/api/v2/scm/subcontract-order/paymentList/${e.id}/print`, method: "get", params: e }) : e != null && e.isPre ? W({ url: `/api/v2/scm/subcontract-order/preSettleList/${e.id}/print`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/paymentList/print", method: "get", params: e }) : W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/paymentDetail/${e.id}/download`, method: "get", params: e });
}
function FTe(e) {
  return e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/invoiceList/print", method: "get", params: e }) : W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/invoiceDetail/${e.id}/download`, method: "get", params: e });
}
function zTe(e) {
  return W({ url: "/api/contract/fixed-assets-depreciation/factory-building-depreciation/print", method: "get", params: e });
}
function BTe(e) {
  return W({ url: "/api/contract/equipment-depreciation/page/print", method: "get", params: e });
}
function HTe(e) {
  return W({ url: "/api/contract/reimbursement-fee/print", method: "get", params: e });
}
function qTe(e) {
  return W({ url: "/api/contract/wage-fee/print", method: "get", params: e });
}
function GTe(e) {
  return W({ url: "/api/contract/manufacturecost/manufactureCost/print", method: "get", params: e });
}
function QTe(e) {
  return W({ url: "/api/contract/manufacturecost/main-materials-statistics/print", method: "get", params: e });
}
function ZTe(e) {
  return W({ url: "/api/contract/manufacturecost/auxiliary-materials-direct-cost/print", method: "get", params: e });
}
function JTe(e) {
  return W({ url: "/api/contract/manufacturecost/auxiliary-materials-amortization-cost/print", method: "get", params: e });
}
function XTe(e) {
  return W({ url: "/api/contract/manufacturecost/other-steel-materials-amortization/print", method: "get", params: e });
}
function $Te(e) {
  return W({ url: "/api/contract/manufacturecost/paint-cost/print", method: "get", params: e });
}
function e_e(e) {
  return W({ url: "/api/contract/manufacturecost/welding-consumable-cost/print", method: "get", params: e });
}
function t_e(e) {
  return W({ url: "/api/contract/manufacturecost/production-labor-cost/print", method: "get", params: e });
}
function i_e(e) {
  return W({ url: "/api/contract/manufacturecost/temp-work-amortization-cost/print", method: "get", params: e });
}
function a_e(e) {
  return W({ url: "/api/contract/manufacturecost/manager-amortization-cost/print", method: "get", params: e });
}
function l_e(e) {
  return W({ url: "/api/contract/manufacturecost/transportationCost/print", method: "get", params: e });
}
function o_e(e) {
  return W({ url: "/api/contract/manufacturecost/water-electricity-amortization/print", method: "get", params: e });
}
function n_e(e) {
  return W({ url: "/api/contract/manufacturecost/gas-fee/print", method: "get", params: e });
}
function s_e(e) {
  return W({ url: "/api/contract/manufacturecost/gas-direct-cost/print", method: "get", params: e });
}
function r_e(e) {
  return W({ url: "/api/contract/manufacturecost/property-amortization/print", method: "get", params: e });
}
function u_e(e) {
  return W({ url: "/api/contract/manufacturecost/direct-cost/print", method: "get", params: e });
}
function c_e(e) {
  return W({ url: "/api/contract/manufacturecost/amortization-cost/print", method: "get", params: e });
}
function d_e(e) {
  return W({ url: "/api/contract/manufacturecost/send-directly-site-material-cost/print", method: "get", params: e });
}
function m_e(e) {
  return W({ url: "/api/contract/manufacturecost/factory-depreciation/print", method: "get", params: e });
}
function p_e(e) {
  return W({ url: "/api/contract/manufacturecost/equipment-depreciation/print", method: "get", params: e });
}
function h_e(e) {
  return W({ url: "/api/contract/manufacturecost/testing-fee/print", method: "get", params: e });
}
function f_e(e) {
  return W({ url: "/api/contract/manufacturecost/finishedProductScrapLoss/print", method: "get", params: e });
}
function g_e(e) {
  return W({ module: "contract", url: "contract/manufacturecost/repair/list/print", method: "get", params: e });
}
function E_e(e) {
  return W({ module: "contract", url: "contract/manufacturecost/reuse/list/print", method: "get", params: e });
}
function y_e(e) {
  return W({ url: "/api/contract/manufacturecost/mainBusinessIncome/print", method: "get", params: e });
}
function T_e(e) {
  return W({ url: "/api/contract/manufacturecost/nonMainBusinessIncome/print", method: "get", params: e });
}
function __e(e) {
  return W({ url: "/api/contract/return/recycle/ledger/list/print", method: "get", params: e });
}
function b_e(e) {
  return W({ url: "/api/contract/return/recycle/ledger/product/list/print", method: "get", params: e });
}
function V_e(e) {
  return W({ url: "/api/contract/return/recycle/ledger/payment/list/print", method: "get", params: e });
}
function w_e(e) {
  return W({ url: "/api/contract/return/recycle/ledger/invoice/list/print", method: "get", params: e });
}
