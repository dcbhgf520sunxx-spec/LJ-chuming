function vL(e) {
  return W({ url: "/api/config/getMesWarehouseConfig/public", method: "get", params: e });
}
function RL(e) {
  return W({ url: "/api/plan/technological_achievement_approve/commonApprove", method: "put", data: e });
}
function ML(e) {
  return W({ module: "plan", url: `technological_achievement_approve/getApproveDetail/${e}`, method: "get" });
}
function AL(e) {
  return W({ url: "/api/plan/technological_achievement_approve/cancelApproveDetail", method: "put", params: e });
}
function Tw(e) {
  return W({ url: "/api/mes/enclosure/productionLine/page", method: "get", params: e });
}
function NL(e) {
  return W({ url: "/api/mes/enclosure/productionLine", method: "post", data: e });
}
function LL(e) {
  return W({ url: "/api/mes/enclosure/productionLine", method: "put", data: e });
}
function IL(e) {
  return W({ url: "/api/mes/enclosure/productionLine", method: "delete", data: { ids: e } });
}
function Wot({ id: e, boolEnabledEnum: o }) {
  return W({ url: "/api/mes/enclosure/productionLine/changeState", method: "put", data: { id: e, boolEnabledEnum: o } });
}
function jot(e) {
  return W({ url: "/api/mes/enclosure/productionLine/name", method: "get", params: e });
}
function Fot(e) {
  return W({ url: "/api/dictDetail/all", method: "get", params: { name: "enclosure_type" } });
}
const zot = { get: Tw, add: NL, edit: LL, del: IL };
function CL(e) {
  return W({ url: "/api/wms/annualContract/annualContract", method: "get", params: e });
}
function PL(e) {
  return W({ url: "/api/wms/annualContract/addAnnualContract", method: "put", data: e });
}
function OL(e) {
  return W({ url: "/api/wms/annualContract/updateAnnualContract", method: "put", data: e });
}
function kL(e) {
  return W({ url: "/api/wms/annualContract/deleteAnnualContract", method: "delete", params: { id: e[0] } });
}
function DL(e) {
  return W({ url: "/api/scm/supplier/allBoolAnnual", method: "get", params: e });
}
const Bot = { get: CL, add: PL, edit: OL, del: kL };
function xL(e) {
  return W({ module: "wms", url: "config/material/tax-rate/all/brief", method: "get", params: e });
}
function UL(e) {
  return W({ module: "wms", url: "config/material/tax-rate", method: "get", params: e });
}
function YL(e) {
  return W({ module: "wms", url: "config/material/tax-rate", method: "put", data: e });
}
const Hot = { get: UL, edit: YL };
function KL() {
  return W({ url: "/api/sys/approve-process/status", method: "get" });
}
function qot(e) {
  return W({ url: "/api/sys/approve-process/status", method: "put", data: e });
}
function WL(e) {
  return W({ module: "config", url: "company/name", method: "get", params: e });
}
function Got(e) {
  return W({ module: "config", url: "company", method: "put", data: e });
}
function Qot(e) {
  return W({ module: "config", url: "project", method: "get", params: e });
}
function Zot(e) {
  return W({ module: "config", url: "project", method: "put", data: e });
}
function jL(e) {
  return W({ module: "config", url: "company/logo/all", method: "get", params: e });
}
function Jot(e) {
  return W({ module: "config", url: "company/logo/all", method: "get", params: e });
}
function Xot(e) {
  return W({ module: "config", url: `company/logo/default/${e}`, method: "put" });
}
function $ot(e) {
  return W({ module: "config", url: `company/logo/${e}`, method: "delete" });
}
function ent() {
  return W({ url: "/api/config/company/productLabel/logo", method: "get" });
}
function tnt(e) {
  return W({ url: "/api/config/company/productLabel/logo", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function int(e) {
  return W({ url: `/api/config/company/productLabel/logo/${e}`, method: "delete" });
}
function ant(e) {
  return W({ url: "/api/home/config/detail", method: "get", params: e });
}
function lnt(e) {
  return W({ url: "/api/home/config/update", method: "post", data: e });
}
function ont(e) {
  return W({ url: "/api/config/watermarkConfig/get", method: "get", params: e });
}
function nnt(e) {
  return W({ url: "/api/config/watermarkConfig/edit", method: "post", data: e });
}
function FL() {
  return W({ module: "wms", url: "requisitions/unclosed/brief", method: "get" });
}
function _w(e) {
  return W({ module: "wms", url: `requisitions/serial-number/${e}`, method: "get" });
}
function zL(e) {
  return W({ module: "scm", url: "purchase-order/purchasing/all/brief", method: "get", params: e });
}
function BL(e) {
  return W({ module: "scm", url: "purchase-order/purchasing/serialNumber", method: "get", params: e });
}
function HL(e) {
  return W({ module: "scm", url: "purchase-order", method: "get", params: e });
}
function qL(e) {
  return W({ module: "scm", url: "purchase-order", method: "post", data: e });
}
function GL(e) {
  return W({ module: "scm", url: "purchase-order", method: "put", data: e });
}
function QL(e) {
  return W({ module: "scm", url: "purchase-order", method: "delete", data: e });
}
function U1(e) {
  return W({ module: "scm", url: `purchase-order/${e}`, method: "get" });
}
function snt(e) {
  return W({ module: "scm", url: `purchase-order/inbound/${e}`, method: "get" });
}
function rnt(e) {
  return W({ module: "scm", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "purchase-order/purchase-status", method: "put", data: e });
}
