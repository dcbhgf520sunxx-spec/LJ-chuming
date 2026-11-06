import { provide as ye } from "vue";
import { ref as s } from "vue";
import { computed as be } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as l } from "vue";
import { Fragment as _e } from "vue";
import { createElementVNode as n } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as b } from "vue";
import { unref as u } from "vue";
import { createBlock as $ } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as J } from "vue";
import { withDirectives as m } from "vue";
import { vShow as he } from "vue";
import { withKeys as k } from "vue";
import { ElDescriptionsItem as we } from "element-plus";
import { ElTag as Te } from "element-plus";
import { ElDescriptions as Ve } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { ElTableColumn as xe } from "element-plus";
import { ElPagination as ke } from "element-plus";
import { vLoading as Ie } from "element-plus";
import { g as Se } from "../../../../../modules/list-valuation-9a754659.js";
import { g as Me, a as je } from "../../../../../modules/order-tracking-a52bc8e9.js";
import { _ as Ne, n as Le, o as Ae, J as Ee, G as I, z as He, p as Pe, c1 as Z, kQ as S, kL as Ue, bZ as Oe } from "../../../../../shared/runtime.js";
import { T as w } from "../../../../../modules/contract-9b18cc88.js";
import ze from "./module/collection-detail-drawer.vue.js";
import De from "./module/invoice-detail-drawer.vue.js";
import $e from "./module/detail-drawer.vue.js";
import "../../../../../modules/manufactures-sales-return-578c5329.js";
import "../../../../../modules/ship-manage-3066b2ed.js";
const Ke = { class: "app-container" }, Be = { style: { "margin-top": "20px" } }, Re = { class: "dialog-title", style: { "margin-bottom": "10px" } }, qe = { class: "head-container" }, Fe = { class: "flex-rbc" }, Ge = { key: 1, style: { color: "red" } }, Qe = { __name: "index", setup(Je) {
  ye("permission", w);
  const v = { THIS_MONTH: { L: "本月", K: "THIS_MONTH", V: 1 }, LAST_MONTH: { L: "上月", K: "LAST_MONTH", V: 2 } };
  Le(v);
  const { maxHeight: W } = Ae({ paginate: true, extraHeight: 450 }), { handleSizeChange: X, handleCurrentChange: Y, total: ee, setTotalPage: le, queryPage: V } = Ee({ fetchHook: F }), y = s(), M = s(false), K = s([]), i = s({}), B = s(false), j = s(false), g = s(), C = s(), R = s([]), N = s(false), r = s({}), L = s(false), A = s(false), q = s(), E = s(false), te = s("view"), ae = be(() => ({ projectId: y.value, monthType: g.value, productType: r.value.productType }));
  ie();
  async function ne() {
    if (I(w.get) && y.value) try {
      B.value = true;
      const a = await je({ projectId: y.value });
      i.value = a || {}, j.value = false;
    } catch (a) {
      console.log(a);
    } finally {
      B.value = false;
    }
  }
  function H(a) {
    g.value = a, r.value.productType = void 0, f();
  }
  function oe() {
    r.value = {};
  }
  function f() {
    V.pageNumber = 1, F();
  }
  async function F() {
    if (I(w.get)) try {
      j.value = true, N.value = true;
      const { content: a, totalElements: e } = await Me({ projectId: y.value, monthType: g.value, ...r.value, ...V });
      le(e), R.value = a || [];
    } catch (a) {
      console.log(a);
    } finally {
      N.value = false;
    }
  }
  function P(a) {
    I(w.get) && (g.value = a, C.value = a ? v.VL[a] : "累计", L.value = true);
  }
  function U(a) {
    I(w.get) && (g.value = a, C.value = a ? v.VL[a] : "累计", A.value = true);
  }
  async function ie() {
    try {
      M.value = true;
      const { content: a } = await Se();
      K.value = a.map((e) => (e.fullname = He(e), e));
    } catch (a) {
      console.log(a);
    } finally {
      M.value = false;
    }
  }
  function re(a) {
    a.boolExistReturn && (a.id = a.linkId, q.value = a, E.value = true);
  }
  return (a, e) => {
    const se = _("common-select"), p = we, O = Te, ue = Ve, G = _("common-radio-button"), pe = _("print-table"), x = Ce, Q = _("common-button"), d = xe, de = _("table-cell-tag"), me = _("common-table"), ce = ke, c = z("thousand"), ve = z("permission"), fe = z("parse-time"), ge = Ie;
    return h(), D("div", Ke, [l(se, { modelValue: y.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => y.value = t), dataStructure: { key: "id", label: "fullname", value: "id" }, loading: M.value, options: K.value, class: "filter-item", clearable: "", filterable: "", placeholder: "请选择项目", style: { width: "450px", "margin-bottom": "10px" }, type: "other", onChange: ne }, null, 8, ["modelValue", "loading", "options"]), y.value ? (h(), D(_e, { key: 0 }, [e[24] || (e[24] = n("div", { class: "dialog-title" }, [n("span", { class: "title-left", style: { "margin-bottom": "10px" } }, "项目财务数据")], -1)), l(ue, { column: 3, border: "", class: "margin-top", "label-width": "140" }, { default: o(() => [l(p, { align: "center", label: "项目编号" }, { default: o(() => [n("span", null, b(i.value.serialNumber), 1)]), _: 1 }), l(p, { align: "center", label: "项目名称" }, { default: o(() => [n("span", null, b(i.value.name), 1)]), _: 1 }), l(p, { align: "center", label: "销售负责人" }, { default: o(() => [n("span", null, b(i.value.signerName), 1)]), _: 1 }), l(p, { align: "center", label: "签订日期" }, { default: o(() => [n("span", null, b(u(Pe)(i.value.signingDate, "{y}-{m}-{d}")), 1)]), _: 1 }), l(p, { align: "center", label: "项目状态" }, { default: o(() => [i.value.status ? (h(), $(O, { key: 0, type: u(Z).V[i.value.status].TAG, effect: "plain", size: "large" }, { default: o(() => [T(b(u(Z).VL[i.value.status]), 1)]), _: 1 }, 8, ["type"])) : J("", true)]), _: 1 }), l(p, { align: "center", label: "结算额" }, { default: o(() => [m(n("span", null, null, 512), [[c, { val: i.value.settlementAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "累计发运额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[1] || (e[1] = (t) => H(void 0)) }, null, 512), [[c, { val: i.value.shipAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "上月发运额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[2] || (e[2] = (t) => H(v.LAST_MONTH.V)) }, null, 512), [[c, { val: i.value.lastMonthShipAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "本月发运额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[3] || (e[3] = (t) => H(v.THIS_MONTH.V)) }, null, 512), [[c, { val: i.value.thisMonthShipAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "累计收款额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[4] || (e[4] = (t) => P(void 0)) }, null, 512), [[c, { val: i.value.collectionAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "上月收款额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[5] || (e[5] = (t) => P(v.LAST_MONTH.V)) }, null, 512), [[c, { val: i.value.lastMonthCollectionAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "本月收款额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[6] || (e[6] = (t) => P(v.THIS_MONTH.V)) }, null, 512), [[c, { val: i.value.thisMonthCollectionAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "累计开票额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[7] || (e[7] = (t) => U(void 0)) }, null, 512), [[c, { val: i.value.invoiceAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "上月开票额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[8] || (e[8] = (t) => U(v.LAST_MONTH.V)) }, null, 512), [[c, { val: i.value.lastMonthInvoiceAmount || 0 }]])]), _: 1 }), l(p, { align: "center", label: "本月开票额" }, { default: o(() => [m(n("span", { class: "tc-primary pointer", onClick: e[9] || (e[9] = (t) => U(v.THIS_MONTH.V)) }, null, 512), [[c, { val: i.value.thisMonthInvoiceAmount || 0 }]])]), _: 1 })]), _: 1 }), m(n("div", Be, [n("div", Re, [e[21] || (e[21] = n("span", { class: "title-left" }, "发运数据", -1)), l(O, { effect: "plain", size: "large", type: "success" }, { default: o(() => [T(b(g.value ? v.VL[g.value] : "累计"), 1)]), _: 1 })]), n("div", qe, [n("div", Fe, [n("div", null, [l(G, { modelValue: r.value.productType, "onUpdate:modelValue": e[10] || (e[10] = (t) => r.value.productType = t), options: u(S).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: f }, null, 8, ["modelValue", "options"]), l(G, { modelValue: r.value.handleMethod, "onUpdate:modelValue": e[11] || (e[11] = (t) => r.value.handleMethod = t), options: u(Ue).ENUM, "show-option-all": true, class: "filter-item", size: "default", type: "enum", onChange: f }, null, 8, ["modelValue", "options"])]), m(l(pe, { params: ae.value, "api-key": "unitOrderTrackingShip", class: "filter-item", type: "warning" }, null, 8, ["params"]), [[ve, u(w).print]])]), n("div", null, [r.value.productType !== u(S).ENCLOSURE.V ? (h(), $(u(Oe), { key: 0, areaId: r.value.areaId, "onUpdate:areaId": e[12] || (e[12] = (t) => r.value.areaId = t), monomerId: r.value.monomerId, "onUpdate:monomerId": e[13] || (e[13] = (t) => r.value.monomerId = t), productType: r.value.productType, "project-id": y.value, areaClearable: "", clearable: "", onAreaChange: f, onMonomerChange: f }, null, 8, ["areaId", "monomerId", "productType", "project-id"])) : J("", true), l(x, { modelValue: r.value.name, "onUpdate:modelValue": e[14] || (e[14] = (t) => r.value.name = t), class: "filter-item", clearable: "", placeholder: "按名称搜索", style: { width: "200px" }, onKeyup: k(f, ["enter"]) }, null, 8, ["modelValue"]), l(x, { modelValue: r.value.serialNumber, "onUpdate:modelValue": e[15] || (e[15] = (t) => r.value.serialNumber = t), class: "filter-item", clearable: "", placeholder: "按编号搜索", style: { width: "200px" }, onKeyup: k(f, ["enter"]) }, null, 8, ["modelValue"]), l(x, { modelValue: r.value.specification, "onUpdate:modelValue": e[16] || (e[16] = (t) => r.value.specification = t), class: "filter-item", clearable: "", placeholder: "按规格搜索", style: { width: "200px" }, onKeyup: k(f, ["enter"]) }, null, 8, ["modelValue"]), l(x, { modelValue: r.value.material, "onUpdate:modelValue": e[17] || (e[17] = (t) => r.value.material = t), class: "filter-item", clearable: "", placeholder: "按材质/型号搜索", style: { width: "200px" }, onKeyup: k(f, ["enter"]) }, null, 8, ["modelValue"]), l(Q, { class: "filter-item", type: "success", onClick: f }, { default: o(() => e[22] || (e[22] = [T("搜索")])), _: 1, __: [22] }), l(Q, { class: "filter-item", type: "warning", onClick: oe }, { default: o(() => e[23] || (e[23] = [T("重置")])), _: 1, __: [23] })])]), m((h(), $(me, { data: R.value, "max-height": u(W), "row-style": { cursor: "pointer" }, style: { width: "100%" }, onRowClick: re }, { default: o(() => [l(d, { align: "center", label: "序号", type: "index", width: "60" }), l(d, { align: "center", label: "产品类型", prop: "productType", "show-overflow-tooltip": "", width: "100" }, { default: o(({ row: t }) => [l(O, { type: u(S).V[t.productType].T, effect: "plain" }, { default: o(() => [T(b(u(S).VL[t.productType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), l(d, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [l(de, { offset: 15, show: !!(t != null && t.boolExistReturn), color: "#e64242", name: "退货" }, null, 8, ["show"]), n("span", null, b(t.name), 1)]), _: 1 }), l(d, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "材质/型号", "min-width": "100px", prop: "material", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "计量单位", prop: "measure", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "数量", prop: "quantity", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "核算单位", "min-width": "100", prop: "nuclear", "show-overflow-tooltip": "" }), l(d, { align: "center", label: "核算量", "min-width": "100", prop: "totalMete", "show-overflow-tooltip": "" }), l(d, { align: "right", label: "单价（元）", "min-width": "120", prop: "unitPrice" }), l(d, { align: "right", label: "金额（元）", "min-width": "120", prop: "totalPrice" }, { default: o(({ row: t }) => [m(n("span", null, null, 512), [[c, { val: t.totalPrice || 0 }]])]), _: 1 }), l(d, { align: "center", label: "发运日期", prop: "auditTime", width: "100" }, { default: o(({ row: t }) => [m(n("span", null, null, 512), [[fe, { val: t.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[ge, N.value]]), l(ce, { "current-page": u(V).pageNumber, "page-size": u(V).pageSize, total: u(ee), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: u(X), onCurrentChange: u(Y) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])], 512), [[he, j.value]])], 64)) : (h(), D("div", Ge, "* 请选择项目查看项目数据")), l(ze, { visible: L.value, "onUpdate:visible": e[18] || (e[18] = (t) => L.value = t), "month-type": g.value, "month-type-label": C.value, "project-id": i.value.id, "project-name": i.value.name }, null, 8, ["visible", "month-type", "month-type-label", "project-id", "project-name"]), l(De, { visible: A.value, "onUpdate:visible": e[19] || (e[19] = (t) => A.value = t), "month-type": g.value, "month-type-label": C.value, "project-id": i.value.id, "project-name": i.value.name }, null, 8, ["visible", "month-type", "month-type-label", "project-id", "project-name"]), l($e, { visible: E.value, "onUpdate:visible": e[20] || (e[20] = (t) => E.value = t), "audit-type": te.value, "row-data": { ...q.value } }, null, 8, ["visible", "audit-type", "row-data"])]);
  };
} }, il = Ne(Qe, [["__scopeId", "data-v-279ecf85"]]);
export {
  il as default
};
