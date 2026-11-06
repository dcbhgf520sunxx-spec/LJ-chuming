function pO(e) {
  return W({ url: "/api/wms/inbound/manufactured/application/update", method: "put", data: e });
}
function hO(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "delete", data: e });
}
function SS(e) {
  return W({ url: `/api/wms/inbound/manufactured/application/record/${e}`, method: "get" });
}
function fO(e) {
  return W({ url: `/api/wms/inbound/manufactured/application/review/revocation/${e.id}`, method: "post" });
}
function gO(e, o) {
  return W({ url: "/api/wms/inbound/manufactured/application/review/approval", method: "post", params: e, data: o });
}
const Eut = { get: mO, edit: pO, del: hO, detail: SS };
function yut(e) {
  return W({ url: "/api/config/classification/getMaterialClassification", method: "get", params: e });
}
function EO(e) {
  return W({ url: "/api/wms/deficit/deficit", method: "get", params: e });
}
function Tut(e) {
  return W({ url: "/api/wms/material-inventory/steel-plateDetail", method: "get", params: e });
}
function _ut(e) {
  return W({ url: "/api/wms/material-inventory/group/steel-plateDetail", method: "get", params: e });
}
function but(e) {
  return W({ url: "/api/wms/deficit/saveDeficit", method: "put", data: e });
}
function yO(e) {
  return W({ url: `/api/wms/deficit/deficit/${e}`, method: "get" });
}
function H2(e) {
  return W({ url: "/api/wms/deficit/approval", method: "post", params: e });
}
function TO(e) {
  return W({ url: `/api/wms/deficit/revocation/${e.id}`, method: "post" });
}
function Vut(e) {
  return W({ url: "/api/wms/deficit/deficitDetails", method: "get", params: e });
}
function wut(e) {
  return W({ module: "wms", url: "report/raw-materials/deficitDetail/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function Sut(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/loseInventory/download", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
const vut = { get: EO };
function _O(e) {
  return W({ url: "/api/wms/surplus/receiptList", method: "get", params: e });
}
function __(e) {
  return W({ module: "wms", url: `surplus/${e}`, method: "get" });
}
function Rut(e) {
  return W({ url: "/api/wms/surplus/submitReview", method: "post", data: e });
}
function Mut() {
  return W({ url: "/api/wms/surplus/clearDetailList", method: "delete" });
}
function Aut(e) {
  return W({ url: "/api/wms/surplus/saveSurplusToList", method: "post", data: e });
}
function Nut(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/surplus/package", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function Lut(e) {
  return W({ url: "/api/wms/surplus/getByCurrentUser/number", method: "get", params: e });
}
function Iut(e) {
  return W({ module: "wms", url: "surplus/getByCurrentUser", method: "get", params: e });
}
function Cut(e) {
  return W({ url: "/api/wms/surplus/deleteByList", method: "delete", data: e });
}
function bO(e) {
  return W({ url: "/api/wms/surplus/check", method: "put", data: e });
}
function VO(e) {
  return W({ url: `/api/wms/surplus/cancelApproveDetail/${e.id}`, method: "post" });
}
function Put(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/surplusImport/template/excel", method: "get", params: e, responseType: "blob" });
}
const Out = { get: _O, detail: __ };
function wO(e) {
  return W({ module: "crm", url: `project/follow/up/record/detail/${e}`, method: "get" });
}
function q2(e) {
  return W({ module: "crm", url: "project/follow/up/record/approval", method: "post", data: e });
}
function SO(e) {
  return W({ module: "crm", url: "project/follow/up/record/quash", method: "post", params: e });
}
function vO(e) {
  return W({ module: "crm", url: `prequalification/record/detail/${e}`, method: "get" });
}
function kut(e) {
  return W({ module: "crm", url: "prequalification/record/detail", method: "get", params: e });
}
function G2(e) {
  return W({ module: "crm", url: "prequalification/record/approval", method: "post", data: e });
}
function RO(e) {
  return W({ module: "crm", url: "prequalification/record/quash", method: "post", params: e });
}
function MO(e, o) {
  return W({ module: "crm", url: `apply/for/bid/record/detail/${e}/custom`, method: "get", params: o });
}
function Q2(e) {
  return W({ module: "crm", url: "apply/for/bid/record/approval/custom", method: "post", data: e });
}
function AO(e) {
  return W({ module: "crm", url: "apply/for/bid/record/quash/custom", method: "post", params: e });
}
function NO(e) {
  return W({ module: "crm", url: `project/abandon/record/detail/${e}`, method: "get" });
}
function Z2(e) {
  return W({ module: "crm", url: "project/abandon/record/approval", method: "post", data: e });
}
function LO(e) {
  return W({ module: "crm", url: "project/abandon/record/quash", method: "post", params: e });
}
function IO(e) {
  return W({ module: "crm", url: `project/information/warehousing/detail/${e}`, method: "get" });
}
function J2(e) {
  return W({ module: "crm", url: "project/information/warehousing/approval", method: "post", data: e });
}
function CO(e) {
  return W({ module: "crm", url: "project/information/warehousing/quash", method: "post", params: e });
}
function PO(e) {
  return W({ module: "crm", url: `tech/entrust/get/special/programs/approve/detail/${e}`, method: "get" });
}
function X2(e) {
  return W({ module: "crm", url: "tech/entrust/special/programs/approve", method: "post", data: e });
}
function OO(e) {
  return W({ module: "crm", url: "tech/entrust/special/programs/cancel", method: "post", params: e });
}
