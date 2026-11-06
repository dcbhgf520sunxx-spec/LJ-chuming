import { watch as R } from "vue";
import { ref as h } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as P } from "vue";
import { vShow as _ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as f } from "vue";
import { normalizeStyle as w } from "vue";
import { createBlock as M } from "vue";
import { createCommentVNode as q } from "vue";
import { withCtx as I } from "vue";
import { bX as o, B as k, m as D, q as j, a3 as V, C as K, E as Z, ng as z } from "../../../../../../shared/runtime.js";
import { u as H } from "../../../../../../modules/use-unshow-productType-by-mode-dfef77e4.js";
import { C as Y } from "../../../../../../modules/index-d6a37d29.js";
import { S as $ } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as G } from "../../../../../../modules/index-b238c21c.js";
import { a as X } from "../../../../../../modules/index-8356a01a.js";
import { _ as F } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { c as J } from "../../../../../../modules/convert-product-type-fcb585d7.js";
function W({ colorCardTitles: p = ["未入库", "部分入库", "全部入库", "异常"], emit: g, crud: y, fetchSummaryInfo: v }) {
  const u = [{ title: p[0], color: o.UNSTART.COLOR, value: o.UNSTART.V }, { title: p[1], color: o.PROCESS.COLOR, value: o.PROCESS.V }, { title: p[2], color: o.COMPLETE.COLOR, value: o.COMPLETE.V }, { title: p[3], color: o.ABNORMAL.COLOR, value: o.ABNORMAL.V }];
  R([() => y.query.monomerId, () => y.query.factoryId], () => {
    typeof v == "function" && v();
  }, { immediate: true });
  function d(l, { complete: m = "completeQuantity", listQuantity: i = "quantity", inProduction: O = "inProductionQuantity" }) {
    return l[m] === 0 && l[O] === 0 ? o.UNSTART.COLOR : l[m] === l[i] ? o.COMPLETE.COLOR : l[m] < l[i] && (l[m] > 0 || l[O] > 0) ? o.PROCESS.COLOR : o.ABNORMAL.COLOR;
  }
  function C(l, { field: m = "type" }) {
    const i = o.VK[l[m]];
    return i ? o[i].COLOR : o.ABNORMAL.COLOR;
  }
  function s(l, { field: m = "type" }) {
    const i = o.VK[l[m]];
    return i ? o[i].T : o.ABNORMAL.T;
  }
  function a() {
    y.page.hasNextPage && g("load");
  }
  return { colors: u, boxZoomOut: a, getColor: d, getColorByValue: C, getTagByValue: s };
}
const ee = { class: "head-container" }, de = { __name: "header", emits: "load", setup(p, { expose: g, emit: y }) {
  const v = { name: void 0, serialNumber: void 0, specification: void 0, material: void 0, status: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false }, areaBatchId: void 0 }, u = h([]), d = h([]), C = h({}), { crud: s, query: a, CRUD: l } = k(v), { unshowVal: m, showComponent: i } = H({ resetQuery: function() {
  } }), { globalProjectId: O } = D(["globalProjectId"]);
  R(() => O.value, (c) => {
    c && (a.projectId = c);
  }, { immediate: true }), R([() => a.areaId, () => u.value], (c) => {
    var t;
    c && (u.value.length > 0 ? (d.value = (t = u.value.filter((n) => a.areaId === n.id)[0]) == null ? void 0 : t.planAreaBatchDTOS, C.value = { id: d.value ? d.value[0].id + "" : "", name: d.value ? d.value[0].name : "" }) : (C.value = {}, d.value = []));
  }, { immediate: true, deep: true });
  const L = y, T = h(1), { colors: E, boxZoomOut: S, getColor: B } = W({ colorCardTitles: ["未生产", "生产中", "已完成", "待质检"], emit: L, crud: s });
  l.HOOK.handleRefresh = (c, t) => {
    t.data.content = t.data.content.map((n) => (n.detailLoading = false, n.hasDetail = false, n.compareQuantity = n.quantity, n.isProcess = n.completeQuantity > 0, n.boxColor = B(n, { complete: "completeQuantity", listQuantity: "quantity", inProduction: "inProductionQuantity" }), n));
  };
  function U(c) {
    var t;
    u.value = c.filter((n) => n.itemizedType === z.STRUCTURE.V), a.areaId = (t = u.value[0]) == null ? void 0 : t.id;
  }
  return g({ boxScale: T }), (c, t) => {
    const n = b("common-select"), Q = b("common-radio-button");
    return A(), N("div", ee, [P(x("div", null, [f(e(j), { ref: "monomerSelectRef", modelValue: e(a).monomerId, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(a).monomerId = r), productType: e(J)(e(a).productType, void 0), "project-id": e(O), "show-tips": u.value.length <= 0, class: "filter-item", onChange: c.monomerChange, onGetAreaInfo: U }, null, 8, ["modelValue", "productType", "project-id", "show-tips", "onChange"]), f(n, { modelValue: e(a).areaId, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(a).areaId = r), options: u.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), f(e(X), { modelValue: e(a).areaBatchId, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(a).areaBatchId = r), "area-info": d.value, "default-tab": C.value, style: w(u.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: e(s).toQuery }, null, 8, ["modelValue", "area-info", "default-tab", "style", "onTabClick"]), e(i) ? (A(), M(Q, { key: 0, modelValue: e(a).productType, "onUpdate:modelValue": t[3] || (t[3] = (r) => e(a).productType = r), options: e(V).ENUM, size: "default", class: "filter-item", type: "enumSL", default: "", unshowVal: [e(V).ENCLOSURE.V, e(V).AUXILIARY_MATERIAL.V], onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : q("", true), f(e(F), { modelValue: e(a).factoryId, "onUpdate:modelValue": t[4] || (t[4] = (r) => e(a).factoryId = r), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), f(e(G), { productType: e(a).productType, toQuery: e(s).toQuery, query: e(a) }, null, 8, ["productType", "toQuery", "query"]), f(e(K))], 512), [[_, e(s).searchToggle]]), f(e(Z), { "show-grid": false, "show-refresh": false }, { optRight: I(() => [f(e(Y), { class: "filter-item", value: e(a).status, "onUpdate:value": t[5] || (t[5] = (r) => e(a).status = r), colors: e(E), "color-border": "", "select-able": "", onChange: e(s).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: I(() => [f(e($), { class: "filter-item", value: T.value, "onUpdate:value": t[6] || (t[6] = (r) => T.value = r), intervals: 400, onZoomOut: e(S) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  de as default
};
