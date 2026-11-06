function m5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
function p5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/deleteType", method: "put", data: e });
}
function h5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/revocation", method: "post", data: e });
}
function f5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveTS", method: "post", data: e });
}
function g5() {
  return W({ module: "scm_V2", url: "apply-purchase/getTSCount", method: "get" });
}
function E5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/update/under-review/applyPurchase", method: "put", data: e });
}
function y5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/update/submit/applyPurchase", method: "put", data: e });
}
function T5(e) {
  return W({ module: "wms_v2", url: "material-inventory/apply-getInventory", method: "get", params: e });
}
function _5(e) {
  return W({ module: "plan", url: "artifact/no/scheduling/listByCondition", method: "get", params: e });
}
function b5(e) {
  return W({ module: "plan", url: "enclosure/unScheduling/list", method: "get", params: e });
}
function V5(e) {
  return W({ module: "scm_V2", url: `apply-purchase/purchase/detail/${e}`, method: "get" });
}
function A2({ id: e }) {
  return W({ module: "scm_V2", url: `apply-purchase/track/export/${e}`, method: "get", responseType: "blob" });
}
function w5(e) {
  return W({ module: "scm_V2", url: `apply-purchase/inbound/detail/${e}`, method: "get" });
}
const nn = { add: d5, edit: m5, detail: c5, get: u5 };
function hw(e) {
  return W({ module: "scm_V2", url: "purchase-order/selectProjectManger", method: "get", params: e });
}
function S5(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingList", method: "get", params: e });
}
function v5(e) {
  return W({ module: "scm", url: "LumpSumSystem-purchase-order/createPurchase", method: "post", data: e });
}
function fw(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingSubmitReviewOrder", method: "post", data: e });
}
function gw(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingUpdatePurchaseOrder", method: "put", data: e });
}
function R5(e) {
  return W({ module: "scm_V2", method: "delete", url: "purchase-order/innerSourcingDeleteByIdStagingPurchaseOrder", data: e });
}
function Ew(e) {
  return W({ module: "scm_V2", url: `purchase-order/innerSourcingGetById/${e}`, method: "get" });
}
function got(e) {
  return W({ module: "scm_V2", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "purchase-order/innerSourcingEditPurchaseStatus", method: "put", data: e });
}
function M5(e) {
  return W({ module: "scm", url: "purchase-order/export", method: "get", responseType: "blob", params: { id: e } });
}
function Eot() {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingStagingList", method: "get", params: { boolTemporaryStorage: 1 } });
}
function yot() {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingDeleteStagingPurchaseOrder", method: "delete" });
}
function A5(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingApprovePurchaseOrder", method: "post", data: e });
}
function N5(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingRevocation", method: "post", data: e });
}
function Tot(e) {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingCancellation", method: "post", data: e });
}
function L5() {
  return W({ module: "scm_V2", url: "purchase-order/innerSourcingStagingListCount", method: "get", params: { boolTemporaryStorage: 1 }, cancelKey: false });
}
function I5(e) {
  if (!Ai(DS.download)) throw new Error("没有采购详情下载权限");
  return K5(e);
}
function Ic(e) {
  return W({ module: "scm_V2", url: "purchase-order/update/submit/purchaseOrder", method: "put", data: e });
}
function Cc(e) {
  return W({ module: "scm_V2", url: "purchase-order/update/under-review/purchase", method: "put", data: e });
}
const _ot = { get: S5, add: v5, edit: gw, del: R5, detail: Ew, download: M5 };
function C5(e) {
  return W({ url: "/api/v2/scm/purchase-order", method: "get", params: e });
}
function x1(e) {
  return W({ url: "/api/v2/scm/purchase-order/submitReviewOrder", method: "post", data: e });
}
function Pc(e) {
  return W({ url: "/api/v2/scm/purchase-order/updatePurchaseOrder", method: "put", data: e });
}
function P5(e) {
  return W({ url: "/api/v2/scm/purchase-order/deleteByIdStagingPurchaseOrder", method: "delete", data: e });
}
function Tr(e) {
  return W({ url: `/api/v2/scm/purchase-order/${e}`, method: "get" });
}
function yw(e) {
  return W({ url: `/api/v2/scm/purchase-order/inbound/${e}`, method: "get" });
}
function bot(e) {
  return W({ headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "/api/v2/scm/purchase-order/purchase-status", method: "put", data: e });
}
function O5(e) {
  return W({ url: "/api/v2/scm/purchase-order/export", method: "get", responseType: "blob", params: { id: e } });
}
function Vot() {
  return W({ url: "/api/v2/scm/purchase-order/StagingList", method: "get", params: { boolTemporaryStorage: 1, projectAttribute: [1] } });
}
function wot() {
  return W({ url: "/api/v2/scm/purchase-order/deleteStagingPurchaseOrder", method: "delete" });
}
function k5(e) {
  return W({ url: `/api/v2/scm/purchase-order/inbound/supplier/${e}`, method: "get" });
}
function D5() {
  return W({ url: "/api/v2/scm/purchase-order/inbound/getWorkshop", method: "get" });
}
function x5(e) {
  return W({ url: "/api/v2/scm/purchase-order/purchasing/all/briefV2", method: "get", params: e });
}
function Sot(e) {
  return W({ url: "/api/v2/scm/purchase-order/statistics", method: "get", params: e, cancelKey: false });
}
function U5(e) {
  return W({ url: "/api/v2/scm/purchase-order/ApprovePurchaseOrder", method: "post", data: e });
}
function Y5(e) {
  return W({ url: "/api/v2/scm/purchase-order/revocation", method: "post", data: e });
}
function vot(e) {
  return W({ url: "/api/v2/scm/purchase-order/cancellation", method: "post", data: e });
}
