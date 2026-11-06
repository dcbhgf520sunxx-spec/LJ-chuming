function CI(e) {
  return W({ module: "plan", url: "monomer", method: "put", data: e });
}
function PI(e) {
  return W({ module: "plan", url: "monomer", method: "delete", data: e });
}
function Cw(e, o) {
  return W({ module: "plan", url: `monomer/listByProjectId/${e}`, method: "get", params: o, cancelKey: false });
}
function gst(e) {
  return W({ module: "plan", url: `monomer/listProductTypeListById/${e}`, method: "get" });
}
function Est(e) {
  return W({ url: `/api/plan/monomer/getTreeByProjectId/${e}`, method: "get" });
}
const yst = { add: II, edit: CI, del: PI, get: LI };
function OI(e) {
  return W({ module: "contract", url: "change/reason", method: "get", params: e, cancelKey: false });
}
function kI(e) {
  return W({ module: "contract", url: "change/reason/all", method: "get", params: e, cancelKey: false });
}
function DI(e) {
  return W({ module: "contract", url: "change/reason", method: "post", data: e });
}
function xI(e) {
  return W({ module: "contract", url: "change/reason", method: "put", data: e });
}
function UI(e) {
  return W({ module: "contract", url: "change/reason", method: "delete", data: e });
}
const Tst = { get: OI, add: DI, edit: xI, del: UI };
function YI() {
  return W({ module: "", url: "/api/scm/SubcontractClass-config", method: "get", cancelKey: false });
}
function KI() {
  return W({ module: "", url: "/api/scm/SubcontractClass-config/all", method: "get", cancelKey: false });
}
function WI(e) {
  return W({ module: "", url: "/api/scm/SubcontractClass-config", method: "post", data: e.list });
}
function jI(e) {
  return W({ module: "", url: "/api/scm/SubcontractClass-config", method: "put", data: e });
}
function FI(e) {
  return W({ module: "", url: "/api/scm/SubcontractClass-config", method: "delete", data: e });
}
const _st = { get: YI, add: WI, edit: jI, del: FI };
function zI() {
  return W({ module: "project", url: "qhse-problem-type", method: "get", cancelKey: false });
}
function BI() {
  return W({ module: "project", url: "qhse-problem-type/all", method: "get", cancelKey: false });
}
function HI(e) {
  return W({ module: "project", url: "qhse-problem-type", method: "post", data: e.list });
}
function qI(e) {
  return W({ module: "project", url: "qhse-problem-type", method: "put", data: e });
}
function GI(e) {
  return W({ module: "project", url: "qhse-problem-type", method: "delete", data: e });
}
const bst = { get: zI, add: HI, edit: qI, del: GI };
function QI() {
  return W({ module: "project", url: "visa-reason", method: "get", cancelKey: false });
}
function ZI() {
  return W({ module: "project", url: "visa-reason/all", method: "get", cancelKey: false });
}
function JI(e) {
  return W({ module: "project", url: "visa-reason", method: "post", data: e.list });
}
function XI(e) {
  return W({ module: "project", url: "visa-reason", method: "put", data: e });
}
function $I(e) {
  return W({ module: "project", url: "visa-reason", method: "delete", data: e });
}
const Vst = { get: QI, add: JI, edit: XI, del: $I };
function eC(e) {
  return W({ module: "wms_v2", url: "config/approve/template/all", method: "get", params: e });
}
function tC(e) {
  return W({ module: "wms_v2", url: "config/approve/template", method: "POST", data: e });
}
function iC(e) {
  return W({ module: "wms_v2", url: "config/approve/template", method: "DELETE", data: e });
}
function wst(e) {
  return W({ module: "wms_v2", url: "config/approve/template/enabled", method: "put", data: e });
}
function aC(e) {
  return W({ url: `/api/app/wms/getDeptJobUser/${e}`, method: "get" });
}
function lC(e) {
  return W({ module: "wms_v2", url: "config/approve/template/getTypeList", method: "get", params: e });
}
const Sst = { get: eC, edit: tC, del: iC };
function oC(e) {
  return W({ module: "contract", url: "user/project/simple", method: "get", params: e });
}
function vst(e) {
  return W({ url: "/api/project/prime/contract/list", method: "get", params: e });
}
function nC(e) {
  return W({ module: "contract", url: "user/project/visa/simple", method: "get", params: e });
}
function sC(e) {
  return W({ module: "contract", url: "project/tree", method: "get", params: e });
}
function Rst(e) {
  return W({ module: "contract", url: "project/getAllType", method: "get", params: e });
}
function rC(e) {
  return W({ module: "contract", url: "project/listAllProject", method: "get", params: e });
}
function uC(e) {
  return W({ module: "contract", url: `project/${e}/details`, method: "get" });
}
function Mst(e) {
  return W({ module: "contract", url: `project/${e}/serialnumber`, method: "get" });
}
function cC(e) {
  return W({ url: "/api/project/v2/addContract", method: "post", data: e });
}
function dC(e) {
  return W({ module: "contract", url: "project", method: "put", data: e });
}
function Ast(e) {
  return W({ module: "contract", url: "project/updateProject", method: "post", data: e });
}
function Nst(e) {
  return W({ module: "contract", url: "project/changeAudit", method: "put", data: e });
}
function mC(e) {
  return W({ module: "contract", url: "project", method: "delete", data: e });
}
