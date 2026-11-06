const Brt = { get: G7, detail: Q7 };
function Z7(e) {
  return W({ module: "wms_v2", url: "outbound/application/review/raw-materials", method: "get", params: e });
}
function y_(e) {
  return W({ module: "wms_v2", url: `outbound/application/review/raw-materials/${e}`, method: "get" });
}
function Hrt(e) {
  return W({ module: "wms", url: "outbound/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function qrt(e) {
  return W({ module: "wms", url: `outbound/application/review/raw-materials/${e}/returned`, method: "put" });
}
function Grt(e) {
  return W({ module: "wms_v2", url: "outbound/application/submit", method: "put", data: e });
}
function Qrt(e) {
  return W({ module: "wms_v2", url: "outbound/application/submit", method: "put", data: e });
}
function Zrt(e) {
  return W({ module: "wms_v2", url: "outbound/application/review/raw-materials/current-user", method: "get", params: e });
}
function Jrt(e) {
  return W({ module: "wms_v2", url: "outbound/application/review/raw-materials/current-user/detail-number", method: "get", params: e });
}
function Xrt(e) {
  return W({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "outbound/application/review/raw-materials/material-del", method: "put", data: e });
}
function $rt(e) {
  return W({ url: "/api/v2/wms/outbound/application/submit", method: "put", data: e });
}
function eut(e) {
  return W({ module: "wms", url: `outbound/application/review/raw-materials/${e}/returned`, method: "put" });
}
function tut(e) {
  return W({ headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "/api/v2/wms/outbound/application/review/raw-materials/material-deleteOutsourcing", method: "put", data: e });
}
function bS(e, o) {
  return W({ url: "/api/v2/wms/outbound/application/review/raw-materials", method: "put", params: e });
}
function J7({ id: e }) {
  return W({ url: `/api/v2/wms/outbound/application/revocation/${e}`, method: "post" });
}
function iut(e) {
  return W({ url: "/api/wms/outbound/application/review/raw-materials/material-update", method: "put", data: e });
}
const aut = { get: Z7, detail: y_ };
function X7(e) {
  return W({ module: "wms", url: "return/application/record/raw-materials", method: "get", params: e });
}
function Nn(e) {
  return W({ module: "wms_v2", url: "return/application/record/raw-materials", method: "put", data: e });
}
function $7(e) {
  return W({ module: "wms", url: "return/application/record/raw-materials", method: "delete", data: e });
}
function T_(e) {
  return W({ module: "wms", url: `return/application/record/raw-materials/${e}`, method: "get" });
}
function eO(e) {
  return W({ url: "/api/v2/wms/return/application/review/raw-materials/sourcingUpdateReturn", method: "put", data: e });
}
const lut = { get: X7, edit: Nn, del: $7, detail: T_ };
function tO(e) {
  return W({ module: "project", url: "foreign/visa-settle/list/v2", method: "get", params: e });
}
function out(e) {
  return W({ module: "project", url: "foreign/visa-settle/visaV2", method: "post", data: e });
}
function B2(e) {
  return W({ module: "project", url: "foreign/visa-settle/checkV2", method: "put", data: e });
}
function VS(e) {
  return W({ module: "project", url: `foreign/visa-settle/V2/${e}`, method: "get" });
}
function iO(e) {
  return W({ module: "project", url: `foreign/visa-settle/V2/download/${e}`, method: "get", responseType: "blob" });
}
function aO({ id: e }) {
  return W({ module: "project", url: `foreign/visa-settle/cancelApproveDetail/${e}`, method: "put" });
}
function lO(e) {
  return W({ module: "project", url: "foreign/visa-settle/deleteVisa", method: "delete", data: e });
}
const nut = { get: tO, detail: VS, del: lO };
function oO(e) {
  return W({ module: "mes", url: "report-work/wage-adjust/list-select", method: "get", params: e });
}
function sut(e, o) {
  return W({ module: "mes", url: "report-work/wage-adjust/get-artifact-wage", method: "post", params: o, data: e });
}
function rut(e, o) {
  return W({ module: "mes", url: "report-work/wage-adjust/get-assemble-wage", method: "post", params: o, data: e });
}
function uut(e, o) {
  return W({ module: "mes", url: "report-work/wage-adjust/get-machine-part-wage", method: "post", params: o, data: e });
}
function cut(e) {
  return W({ module: "mes", url: "report-work/wage-adjust/initiate-approval", method: "post", data: e });
}
function wS(e) {
  return W({ module: "mes", url: `report-work/wage-adjust/detail/${e}`, method: "get" });
}
function nO(e) {
  return W({ module: "mes", url: "report-work/wage-adjust/approval", method: "post", data: e });
}
function sO(e) {
  return W({ module: "mes", url: "report-work/wage-adjust/cancel-approval", method: "post", params: e });
}
const dut = { get: oO, detail: wS };
function mut(e) {
  return W({ module: "mes", url: "craft/painting-craft/page", method: "get", params: e });
}
function put(e) {
  return W({ module: "mes", url: "craft/painting-craft/detail", method: "get", params: { id: e } });
}
function rO(e) {
  return W({ module: "mes", url: "craft/painting-craft/approval-detail", method: "get", params: { id: e } });
}
function uO(e) {
  return W({ module: "mes", url: "craft/painting-craft/approval", method: "post", data: e });
}
function cO(e) {
  return W({ module: "mes", url: "craft/painting-craft/cancel-approval", method: "post", params: e });
}
function dO(e) {
  return W({ module: "mes", url: "craft/painting-craft/invalid", method: "put", params: e });
}
function hut(e) {
  return W({ module: "mes", url: "craft/paint-config/paint-brand-list", method: "get", params: e });
}
function fut(e) {
  return W({ module: "mes", url: "craft/paint-config/common/paint-list", method: "get", params: e });
}
function gut(e) {
  return W({ module: "mes", url: "craft/paint-config/paint-select-list", method: "get", params: e });
}
function mO(e) {
  return W({ url: "/api/wms/inbound/manufactured/application/record", method: "get", params: e });
}
