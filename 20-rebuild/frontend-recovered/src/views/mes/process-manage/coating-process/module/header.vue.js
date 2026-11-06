import u from "moment";
import { ref as z } from "vue";
import { computed as I } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as o } from "vue";
import { unref as n } from "vue";
import { withCtx as m } from "vue";
import { Fragment as O } from "vue";
import { renderList as U } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as $ } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElOption as q } from "element-plus";
import { ElSelect as A } from "element-plus";
import { _ as H, B as M, fv as R, bY as Y, C as F, G as D, ow as G } from "../../../../../shared/runtime.js";
const J = { class: "flex-btn" }, K = { style: { display: "flex", "justify-content": "space-between" } }, W = { __name: "header", props: { paintBrandList: { type: Array, default: () => [] }, paintSelectList: { type: Array, default: () => [] } }, emits: ["openPaintConfig", "creationProcess", "creatProjectQuota"], setup(V, { emit: k }) {
  const c = k, v = V, T = { date: [u().subtract(180, "day").valueOf(), u().valueOf()], startDateTime: u().subtract(180, "day").valueOf(), endDateTime: u().valueOf(), projectId: void 0, paintingTypeEnum: void 0, paintBrand: void 0 }, x = z([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: i, query: t } = M(T), w = I(() => {
    var e, d;
    let l = [];
    return t.paintingTypeEnum ? (l = (e = v.paintSelectList) == null ? void 0 : e.find((s) => s.id === t.paintingTypeEnum), ((d = l == null ? void 0 : l.nameInfos) == null ? void 0 : d.map((s) => s.name)) || []) : v.paintBrandList;
  });
  function B(l) {
    return l > /* @__PURE__ */ new Date();
  }
  function E() {
    t.date && t.date.length > 1 ? (t.startDateTime = t.date[0], t.endDateTime = t.date[1]) : (t.startDateTime = void 0, t.endDateTime = void 0), i.toQuery();
  }
  function P() {
    t.paintBrand = void 0, i.toQuery();
  }
  return (l, e) => {
    const d = S, s = y("common-select"), h = q, Q = A, f = y("common-button"), j = y("print-table"), L = N("permission");
    return r(), C("div", null, [p("div", J, [p("div", null, [o(d, { modelValue: n(t).date, "onUpdate:modelValue": e[0] || (e[0] = (a) => n(t).date = a), "default-time": x.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", "disabled-date": B, onChange: E }, null, 8, ["modelValue", "default-time"]), o(n(R), { modelValue: n(t).projectId, "onUpdate:modelValue": e[1] || (e[1] = (a) => n(t).projectId = a), class: "filter-item", style: { width: "240px" }, clearable: "", placeholder: "项目筛选", onChange: n(i).toQuery }, null, 8, ["modelValue", "onChange"]), o(s, { type: "enum", modelValue: n(t).paintingTypeEnum, "onUpdate:modelValue": e[2] || (e[2] = (a) => n(t).paintingTypeEnum = a), options: n(Y).ENUM, placeholder: "油漆类型筛选", clearable: "", style: { width: "240px" }, class: "filter-item", onChange: P }, null, 8, ["modelValue", "options"]), o(Q, { modelValue: n(t).paintBrand, "onUpdate:modelValue": e[3] || (e[3] = (a) => n(t).paintBrand = a), clearable: "", filterable: "", placeholder: "油漆品牌筛选", class: "filter-item", onChange: n(i).toQuery, style: { width: "270px" } }, { default: m(() => [(r(true), C(O, null, U(w.value, (a) => (r(), _(h, { key: a, label: a, value: a }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), o(n(F))]), n(D)(n(i).permission.paintConfig) ? (r(), _(f, { key: 0, type: "success", size: "default", class: "filter-item", onClick: e[4] || (e[4] = (a) => c("openPaintConfig")) }, { default: m(() => e[7] || (e[7] = [g("油漆配置表")])), _: 1, __: [7] })) : b("", true)]), p("div", K, [p("div", null, [o(f, { type: "primary", icon: "el-icon-plus", size: "default", onClick: e[5] || (e[5] = (a) => c("creationProcess")) }, { default: m(() => e[8] || (e[8] = [g(" 油漆使用对比 ")])), _: 1, __: [8] }), n(D)(n(i).permission.add) ? (r(), _(f, { key: 0, type: "success", icon: "el-icon-plus", size: "default", onClick: e[6] || (e[6] = (a) => c("creatProjectQuota")) }, { default: m(() => e[9] || (e[9] = [g(" 创建项目定额 ")])), _: 1, __: [9] })) : b("", true)]), $(o(j, { "api-key": "paintingCraftListPrint", params: n(t), size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, n(G).print]])])]);
  };
} }, ee = H(W, [["__scopeId", "data-v-43dc30c1"]]);
export {
  ee as default
};
