function wI() {
  return W({ module: "wms", url: "config/all", method: "get" });
}
function Cnt() {
  return W({ url: "/api/v2/wms/config/inbound/base", method: "get" });
}
function Pnt(e) {
  return W({ module: "wms", url: "config/inbound/base", method: "put", data: e });
}
function Ont() {
  return W({ module: "wms", url: "config/purchase-spec/base", method: "get" });
}
function knt(e) {
  return W({ module: "wms", url: "config/purchase-spec/base", method: "put", data: e });
}
function Dnt() {
  return W({ module: "wms", url: "config/inbound/steel", method: "get" });
}
function xnt(e) {
  return W({ module: "wms", url: "config/inbound/steel", method: "put", data: e });
}
function Unt() {
  return W({ module: "wms", url: "config/report/download", method: "get" });
}
function Ynt(e) {
  return W({ module: "wms", url: "config/report/download", method: "put", data: e });
}
function Knt() {
  return W({ module: "wms", url: "config/outbound/base", method: "get" });
}
function Wnt(e) {
  return W({ module: "wms", url: "config/outbound/base", method: "put", data: e });
}
function jnt() {
  return W({ module: "wms", url: "config/transfer/party-a-borrow-return", method: "get" });
}
function Fnt(e) {
  return W({ module: "wms", url: "config/transfer/party-a-borrow-return", method: "put", data: e });
}
function znt() {
  return W({ module: "wms", url: "config/weighted-price", method: "get" });
}
function Bnt(e) {
  return W({ module: "wms", url: "config/weighted-price", method: "put", data: e });
}
function Hnt() {
  return W({ module: "wms", url: "config/reject/base", method: "get" });
}
function qnt(e) {
  return W({ module: "wms", url: "config/reject/base", method: "put", data: e });
}
function Gnt() {
  return W({ module: "wms", url: "config/return", method: "get" });
}
function Qnt(e) {
  return W({ module: "wms", url: "config/return", method: "put", data: e });
}
function Znt() {
  return W({ module: "wms", url: "config/transfer", method: "get" });
}
function Jnt(e) {
  return W({ module: "wms", url: "config/transfer", method: "put", data: e });
}
function Xnt() {
  return W({ url: "api/config/getWastePriceEntryType", method: "get" });
}
function $nt(e) {
  return W({ url: "api/config/setWastePriceEntryType", method: "put", params: e });
}
function est() {
  return W({ url: "api/wms/config/inventory", method: "get" });
}
function tst(e) {
  return W({ url: "api/wms/config/inventory", method: "put", data: e });
}
function ist() {
  return W({ url: "/api/wms/config/basicShowConfig", method: "get" });
}
function ast(e) {
  return W({ url: "/api/wms/config/basicShowConfig", method: "put", data: e });
}
function lst() {
  return W({ url: "api/wms/config/inventoryType", method: "get" });
}
function ost(e) {
  return W({ url: "api/wms/config/inventoryType", method: "put", data: e });
}
function SI() {
  return W({ url: "api/wms/config/weighted-price_type", method: "get" });
}
function nst() {
  return W({ url: "api/wms/config/convert", method: "get" });
}
function sst(e) {
  return W({ url: "api/wms/config/convert", method: "put", data: e });
}
function rst() {
  return W({ url: "api/wms/config/outboundUpdateConfig", method: "get" });
}
function ust(e) {
  return W({ url: "api/wms/config/outboundUpdateConfig", method: "put", data: e });
}
function cst() {
  return W({ url: "api/wms/config/priceAbnormalConfig", method: "get" });
}
function dst(e) {
  return W({ url: "api/wms/config/priceAbnormalConfig", method: "put", data: e });
}
function mst() {
  return W({ url: "/api/crm/oa/config", method: "get" });
}
function pst(e) {
  return W({ url: "/api/crm/oa/config", method: "post", data: e });
}
const Y1 = { UNCONFIRMED: { L: "未确认", K: "UNCONFIRMED", V: 1, T: "danger" }, CONFIRMING: { L: "处理中", K: "CONFIRMING", V: 2, T: "primary" }, CONFIRMED: { L: "处理完成", K: "CONFIRMED", V: 4, T: "success" } };
ve(Y1);
const K1 = { HOMEMADE: { L: "自制", K: "HOMEMADE", V: 1, T: "primary" }, OUTSOURCE: { L: "外包", K: "OUTSOURCE", V: 2, T: "warning" } };
ve(K1);
const Bt = { CONSTRUCTION_SITE: { L: "直发工地", SL: "工地采购", K: "CONSTRUCTION_SITE", V: 1 }, FACTORY: { L: "直发工厂", SL: "工厂采购", K: "FACTORY", V: 2 } };
ve(Bt);
const Oc = { CONSTRUCTION_SITE_FACTORY: { L: "工地&工厂", SL: "工地&工厂采购", K: "CONSTRUCTION_SITE_FACTORY", V: Bt.CONSTRUCTION_SITE.V | Bt.FACTORY.V } };
ve(Oc);
const W1 = { UNSTART: { L: "未开始", K: "NORMAL", V: 1, T: "info", COLOR: "#f5f7fa" }, PROCESS: { L: "进行中", K: "PROCESS", V: 2, T: "warning", COLOR: "#ffba00" }, COMPLETE: { L: "已完成", K: "NORMAL", V: 4, T: "success", COLOR: "#40ed8d" }, ABNORMAL: { L: "异常", K: "ABNORMAL", V: 8, T: "danger", COLOR: "#ff6d6d" } };
ve(W1);
const j1 = { QUALITY: { L: "质量问题", K: "QUALITY", V: 1, T: "info" }, SECURITY: { L: "安全问题", K: "SECURITY", V: 2, T: "warning" }, ENVIRONMENT: { L: "环境问题", K: "ENVIRONMENT", V: 4, T: "success" }, SPECIAL_QUALITY: { L: "特殊质量问题", K: "SPECIAL_QUALITY", V: 8, T: "danger" } };
ve(j1);
