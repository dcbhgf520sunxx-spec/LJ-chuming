function C0e(e) {
  return W({ module: "contract", url: "project/tracking/record/print", method: "get", params: e });
}
function P0e(e) {
  return W({ module: "contract", url: "business/check/detail/print", method: "get", params: e });
}
function O0e(e) {
  return W({ module: "contract", url: "project/tracking/print", method: "get", params: e });
}
function k0e(e) {
  return W({ url: "/api/business/pricing/detail/print", method: "get", params: e });
}
function D0e(e) {
  return W({ url: "/api/project/tracking/v2/ship/print", method: "get", params: e });
}
function x0e(e) {
  return W({ url: "/api/project/tracking/v2/collection/print", method: "get", params: e });
}
function U0e(e) {
  return W({ url: "/api/project/tracking/v2/invoice/print", method: "get", params: e });
}
function Y0e(e) {
  return W({ module: "contract", url: "business/ship/detail/print", method: "get", params: e });
}
function K0e(e) {
  return W({ module: "contract", url: "business/ship/bridge/detail/print", method: "get", params: e });
}
function W0e(e) {
  return W({ url: "/api/mes/building/warehouse/list-record/print", method: "get", params: e });
}
function j0e(e) {
  return W({ url: "/api/contract/water-electricity/print", method: "get", params: e });
}
function F0e(e) {
  return W({ url: "/api/contract/water-electricity/print", method: "get", params: e });
}
function z0e(e) {
  return W({ url: "/api/contract/water-electricity/print", method: "get", params: e });
}
function B0e(e) {
  return W({ url: "/api/contract/gas-summary/print", method: "get", params: e });
}
function H0e(e) {
  return W({ url: "/api/contract/expense-reimburse/print", method: "get", params: e });
}
function q0e(e) {
  return W({ url: "/api/contract/wage-summary/print", method: "get", params: e });
}
function G0e(e) {
  return W({ url: "/api/contract/wage-summary/print", method: "get", params: e });
}
function Q0e(e) {
  return W({ url: "/api/contract/property-fee/print", method: "get", params: e });
}
function Z0e(e) {
  return W({ url: "/api/contract/project-finance/list-outbound/print", method: "get", params: e });
}
function J0e(e) {
  return W({ url: "/api/contract/project-finance/list-wage/print", method: "get", params: e });
}
function X0e(e) {
  return W({ url: `/api/mes/building/cargo/shipment/list/print/${e}`, method: "get" });
}
function $0e(e) {
  return W({ url: "/api/contract/project-finance/list-testing/print", method: "get", params: e });
}
function eTe(e) {
  return W({ url: "/api/contract/project-finance/list-sub/print", method: "get", params: e });
}
function tTe(e) {
  return W({ url: "", method: "get", params: e });
}
function iTe(e) {
  return W({ url: "/api/contract/project-finance/list-manage/print", method: "get", params: e });
}
function aTe(e) {
  return W({ url: "/api/contract/project-finance/list-water/print", method: "get", params: e });
}
function lTe(e) {
  return W({ url: "/api/contract/project-finance/list-depreciation/print", method: "get", params: e });
}
function oTe(e) {
  return W({ url: "/api/contract/project-finance/print", method: "get", params: e });
}
function nTe(e) {
  return W({ url: "/api/business/bridge-box/print", method: "get", params: e });
}
function sTe(e) {
  return W({ url: "/api/contract/invoice/waste/print", method: "get", params: e });
}
function rTe(e) {
  return W({ url: "/api/contract/collection/waste/print", method: "get", params: e });
}
function uTe(e) {
  return W({ url: "/api/contract/contractWaste/saleDetail/print", method: "get", params: e });
}
function cTe(e) {
  return W({ url: "/api/contract/contractWaste/summary/ledger/print", method: "get", params: e });
}
function dTe(e) {
  return W({ url: "/api/contract/contractWaste/saleAmount/print", method: "get", params: e });
}
function mTe(e) {
  return W({ url: "/api/project/v2/costReport/download/income", method: "get", params: { ...e, downloadType: "true" } });
}
function pTe(e) {
  return W({ url: `/api/contract/collection/v2/downloadCollection/${e}`, method: "get" });
}
function hTe(e) {
  return W({ url: "/api/project/v2/costReport/download/income", method: "get", params: { ...e, downloadType: "false" } });
}
function fTe(e) {
  return W({ url: `/api/contract/invoice/downloadInvoice/${e}`, method: "get" });
}
function gTe(e) {
  return W({ url: "/api/project/v2/costReport/download/invoice", method: "get", params: e });
}
function ETe(e) {
  return W({ url: "/api/project/v2/order/projectPaymentAll/download", method: "get", params: e });
}
function yTe(e) {
  return W({ url: `/api/project/v2/costReport/download/${e.projectId}`, method: "get", params: { supplierId: e.supplierId } });
}
function TTe(e) {
  return W({ url: `/api/contract/Injection/getInjectionDetailDownload/${e.projectId}/${e.supplierId}`, method: "get", params: { supplierId: e.supplierId } });
}
function _Te(e) {
  return W({ url: "/api/contract/givingCredit/download", method: "get", params: e });
}
function bTe(e) {
  return W({ url: "/api/contract/audit/print/downloadAll", method: "get", params: e });
}
function VTe(e) {
  return W({ url: "/api/v2/contract/payment/projectPaymentDetailList/print", method: "get", params: { incomeExpendType: 1, ...e } });
}
function wTe(e) {
  return W({ url: "/api/contract/manufacturecost/send-directly-site-material-order-payment/print", method: "get", params: e });
}
function STe(e) {
  return W({ url: "/api/v2/contract/payment/projectPaymentDetailList/print", method: "get", params: { incomeExpendType: 2, ...e } });
}
function vTe(e) {
  return W({ url: `/api/contract/collection/v2/downloadCollection/${e}`, method: "get", params: { level: 1 } });
}
function RTe(e) {
  return W({ url: `/api/contract/collection/v2/downloadCollection/${e}`, method: "get", params: { level: 2 } });
}
function MTe(e) {
  return W({ url: `/api/contract/project/preSettlement/list/print?projectId=${e}`, method: "get", params: { level: 1 } });
}
