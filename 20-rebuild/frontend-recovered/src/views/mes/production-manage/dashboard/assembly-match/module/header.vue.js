import { ref as i } from "vue";
import { watch as K } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as z } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as H } from "vue";
import { vShow as M } from "vue";
import { unref as a } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as Z } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as I } from "vue";
import { withKeys as F } from "vue";
import { createTextVNode as V } from "vue";
import { Fragment as G } from "vue";
import { ElInput as L } from "element-plus";
import { ElCheckbox as P } from "element-plus";
import { B as $, a3 as W, q as J, bW as X, C as Y, E as ee, ng as ae } from "../../../../../../shared/runtime.js";
import { u as te } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { u as le } from "../../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import { C as oe } from "../../../../../../modules/index-d6a37d29.js";
import { S as ne } from "../../../../../../modules/index-21d3d7d7.js";
import { c as re } from "../../../../../../modules/convert-product-type-fcb585d7.js";
import { a as se } from "../../../../../../modules/index-8356a01a.js";
import ue from "./not-complete-list.vue.js";
const de = { class: "head-container" }, ie = { style: { display: "flex" } }, ge = { __name: "header", props: { isIndeterminate: { type: Boolean, default: false } }, emits: ["load", "checkedAll", "batchMatch", "clear"], setup(T, { expose: x, emit: w }) {
  const h = i(false), k = i([]), s = i([]), d = i([]), f = i({}), A = { serialNumber: "", structureClassId: void 0, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, areaBatchId: void 0, status: { value: void 0, resetAble: false } }, { crud: u, query: l, CRUD: b } = $(A), C = le(u), p = w, y = i(1), { colors: B, boxZoomOut: S, getColorByValue: U, getTagByValue: _ } = te({ colorCardTitles: ["不齐套", "部分齐套", "完全齐套"], emit: p, crud: u });
  K([() => l.areaId, () => s.value], (r) => {
    var e;
    r && (s.value.length > 0 ? (d.value = (e = s.value.filter((o) => l.areaId === o.id)[0]) == null ? void 0 : e.planAreaBatchDTOS, f.value = { id: d.value ? d.value[0].id + "" : "", name: d.value ? d.value[0].name : "" }) : (f.value = {}, d.value = []));
  }, { immediate: true, deep: true });
  const v = i(false);
  function Q(r) {
    p("checkedAll", r);
  }
  function O() {
    p("batchMatch");
  }
  b.HOOK.beforeToQuery = () => {
    l.projectId = C.value;
  }, b.HOOK.handleRefresh = (r, e) => {
    p("clear"), v.value = false, e.data.content = e.data.content.map((o) => (o.checked = false, o.compareQuantity = r.query.factoryId ? o.assignQuantity : o.quantity, o.boxColor = U(o, { field: "type" }), o.tagType = _(o, { field: "type" }), o));
  };
  function E(r) {
    var e;
    s.value = r.filter((o) => o.itemizedType === ae.STRUCTURE.V), l.areaId = (e = s.value[0]) == null ? void 0 : e.id;
  }
  function R(r) {
    l.structureClassId = r, u.toQuery();
  }
  return x({ boxScale: y }), (r, e) => {
    const o = g("common-select"), j = L, q = g("common-button"), D = P;
    return N(), z(G, null, [m("div", de, [H(m("div", null, [n(a(J), { ref: "monomerSelectRef", modelValue: a(l).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (t) => a(l).monomerId = t), productType: a(re)(a(W).ARTIFACT.V, void 0), "project-id": a(C), "show-tips": s.value.length <= 0, class: "filter-item", onChange: r.monomerChange, onGetAreaInfo: E }, null, 8, ["modelValue", "productType", "project-id", "show-tips", "onChange"]), n(o, { modelValue: a(l).areaId, "onUpdate:modelValue": e[1] || (e[1] = (t) => a(l).areaId = t), options: s.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: a(u).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(a(se), { modelValue: a(l).areaBatchId, "onUpdate:modelValue": e[2] || (e[2] = (t) => a(l).areaBatchId = t), "area-info": d.value, "default-tab": f.value, style: Z(s.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: a(u).toQuery }, null, 8, ["modelValue", "area-info", "default-tab", "style", "onTabClick"]), m("div", null, [n(a(X), { modelValue: a(l).structureClassId, "onUpdate:modelValue": e[3] || (e[3] = (t) => a(l).structureClassId = t), class: "filter-item", style: "width:calc(100% - 0px)", data: k.value, itemKey: "id", onChange: R }, { default: c(({ item: t }) => [m("span", null, I(t.name) + "：", 1), m("span", null, I(t.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data"])]), n(j, { modelValue: a(l).serialNumber, "onUpdate:modelValue": e[4] || (e[4] = (t) => a(l).serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: F(a(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(a(Y))], 512), [[M, a(u).searchToggle]]), n(a(ee), { "show-grid": false, "show-refresh": false }, { optRight: c(() => [m("div", ie, [n(q, { type: "primary", size: "default", onClick: O }, { default: c(() => e[9] || (e[9] = [V("批量匹配")])), _: 1, __: [9] }), n(D, { modelValue: v.value, "onUpdate:modelValue": e[5] || (e[5] = (t) => v.value = t), indeterminate: T.isIndeterminate, border: "", style: { "margin-left": "5px", "margin-right": "10px" }, onChange: Q }, { default: c(() => e[10] || (e[10] = [V("全选")])), _: 1, __: [10] }, 8, ["modelValue", "indeterminate"]), n(a(oe), { class: "filter-item", value: a(l).status, "onUpdate:value": e[6] || (e[6] = (t) => a(l).status = t), colors: a(B), "color-border": "", "select-able": "", onChange: a(u).toQuery }, null, 8, ["value", "colors", "onChange"])])]), viewLeft: c(() => [n(a(ne), { class: "filter-item", value: y.value, "onUpdate:value": e[7] || (e[7] = (t) => y.value = t), intervals: 400, onZoomOut: a(S) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]), n(ue, { visible: h.value, "onUpdate:visible": e[8] || (e[8] = (t) => h.value = t) }, null, 8, ["visible"])], 64);
  };
} };
export {
  ge as default
};
