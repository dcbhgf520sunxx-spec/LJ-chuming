function ZL(e) {
  return W({ module: "scm", url: "purchase-order/export", method: "get", responseType: "blob", params: { id: e } });
}
const unt = { get: HL, add: qL, edit: GL, del: QL, detail: U1, download: ZL };
function JL() {
  return W({ module: "wms", url: "config/material/warehouse/all/brief", method: "get" });
}
function XL(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "get", params: e });
}
function $L(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "post", data: [e] });
}
function eI(e) {
  return W({ module: "wms", url: "config/material/warehouse/batch", method: "post", data: e });
}
function tI(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "put", data: e });
}
function cnt(e) {
  return W({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "config/material/warehouse/enabled", method: "put", data: e });
}
function iI(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "delete", data: e });
}
function aI(e) {
  return W({ module: "wms", url: "config/material/warehouse/ids", method: "get", params: e });
}
function dnt(e) {
  return W({ module: "wms", url: "config/material/warehouse/workshop/batch", method: "post", data: e });
}
function mnt(e) {
  return W({ module: "wms", url: "config/material/warehouse/workshop", method: "delete", data: [e] });
}
const pnt = { get: XL, add: $L, batchAdd: eI, edit: tI, del: iI };
function lI(e) {
  return W({ module: "wms_v2", url: "config/material/warehouse/workshopList", method: "get", params: e });
}
function hnt(e) {
  return W({ url: "api/user/all/simple", method: "get", params: e, cancelKey: false });
}
function oI(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "post", data: [e] });
}
function nI(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "post", data: e });
}
function fnt(e) {
  return W({ module: "wms_v2", url: "config/material/warehouse/workshop/batch", method: "post", data: e });
}
function sI(e) {
  return W({ module: "wms_v2", url: "config/material/warehouse/workshop/update", method: "put", data: e });
}
function gnt(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "put", data: e });
}
function Ent(e) {
  return W({ module: "wms_v2", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "config/material/warehouse/workshop/enabled", method: "put", data: e });
}
function rI(e) {
  return W({ module: "wms_v2", url: "config/material/warehouse/workshop", method: "delete", data: e });
}
function ynt(e) {
  return W({ module: "wms_v2", url: "config/material/warehouse", method: "get", params: e });
}
function Tnt(e) {
  return W({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "config/material/warehouse/enabled", method: "put", data: e });
}
function _nt(e) {
  return W({ module: "wms", url: "config/material/warehouse", method: "delete", data: e });
}
function uI(e) {
  return W({ url: "/api/v2/wms/config/material/warehouse/ids", method: "get", params: e });
}
function cI(e) {
  return W({ url: "/api/v2/wms/config/material/warehouse/getWorkShop", method: "get", params: e });
}
function dI() {
  return W({ url: "/api/v2/wms/config/material/warehouse/all/brief", method: "get" });
}
const bnt = { get: lI, add: oI, batchAdd: nI, edit: sI, del: rI };
function mI() {
  return W({ module: "config", url: "structure-steel/classification/all/brief", method: "get" });
}
function pI(e) {
  return W({ module: "config", url: "structure-steel/classification", method: "get", params: e });
}
function hI(e) {
  return W({ module: "config", url: "structure-steel/classification", method: "post", data: e });
}
function fI(e) {
  return W({ module: "config", url: "structure-steel/classification", method: "put", data: e });
}
function gI(e) {
  return W({ module: "config", url: "structure-steel/classification", method: "delete", data: e });
}
function Vnt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getPartTypeList", method: "post", data: e });
}
const wnt = { get: pI, add: hI, edit: fI, del: gI };
function Snt() {
  return W({ module: "wms", url: "config/steel/scrap-definition", method: "get" });
}
function vnt(e) {
  return W({ module: "wms", url: "config/steel/scrap-definition", method: "put", data: e });
}
function EI() {
  return W({ module: "wms", url: "config/steel/scrap-definition/getSteelScrapDefinitionConf", method: "get" });
}
function yI(e) {
  return W({ url: "/api/system/section/warehouse/config/list", method: "get", params: e, cancelKey: false });
}
function TI(e) {
  return W({ url: "/api/system/section/warehouse/config/update", method: "put", data: e });
}
function _I(e) {
  return W({ url: "/api/system/section/warehouse/config/simpleness/list", method: "get", params: e });
}
const Rnt = { get: yI, edit: TI };
function bI(e) {
  return W({ url: "/api/system/structure-classification/allClass/list", method: "get", params: e });
}
function Mnt(e) {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage", method: "get", params: e });
}
function Ant(e) {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function Nnt(e) {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage/setWmsClosingTime", method: "post", data: e });
}
function VI() {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage/wmsClosingTime", method: "get" });
}
function Lnt(e) {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage/detail", method: "get", params: e });
}
function Int(e) {
  return W({ module: "wms", url: "report/raw-materials/send-and-receive-storage/detail/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
