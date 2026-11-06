import { ref as b } from "vue";
import { inject as C } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as N } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as T } from "vue";
import { createTextVNode as m } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as S } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElTag as O } from "element-plus";
import { l as d, B as k, I as z, C as E, L as P, bV as Q, E as U } from "../../../../../shared/runtime.js";
function B(s) {
  return d({ url: "/api/v2/supply-chain/logistics/record/loadingCharge", method: "get", params: s });
}
function M(s) {
  return d({ url: "/api/v2/supply-chain/logistics/loadingCharge/export", method: "get", responseType: "blob", timeout: 6e7, params: s });
}
function A(s) {
  return d({ url: "/api/v2/supply-chain/logistics/loadingChargeCount", method: "get", params: s });
}
const F = { get: B }, j = { class: "head-container" }, I = { key: 0 }, L = { class: "flex gap-2" }, R = { __name: "header", props: { detailsCount: { type: Number, default: void 0 } }, setup(s) {
  const c = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = C("permission"), y = s, g = { inboundTime: [], licensePlate: void 0, purchaseOrderSN: void 0, inboundSN: void 0, userName: void 0 }, { crud: n, query: a } = k(g);
  return (q, t) => {
    const h = D, r = K, _ = O, V = v("permission");
    return u(), p("div", j, [e(n).searchToggle ? (u(), p("div", I, [o(h, { modelValue: e(a).inboundTime, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).inboundTime = l), "default-time": c.value, shortcuts: e(z), class: "filter-item", "end-placeholder": "入库时间", "range-separator": ":", size: "default", "start-placeholder": "入库时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(r, { modelValue: e(a).licensePlate, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).licensePlate = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按车牌/船牌号搜索", size: "default", style: { width: "200px" }, onKeyup: e(n).toQuery }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).inboundSN, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).inboundSN = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按入库单号搜索", size: "default", style: { width: "200px" }, onKeyup: e(n).toQuery }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).purchaseOrderSN, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).purchaseOrderSN = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "default", style: { width: "200px" }, onKeyup: e(n).toQuery }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).userName, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).userName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购员/入库申请人搜索", size: "default", style: { width: "200px" }, onClear: e(n).toQuery, onKeyup: e(n).toQuery }, null, 8, ["modelValue", "onClear", "onKeyup"]), o(e(E))])) : N("", true), o(e(U), null, { optLeft: i(() => [x((u(), T(P, { fn: e(M), params: e(a), "response-header-result": "" }, { default: i(() => t[5] || (t[5] = [m(" 下载原材料装车费明细（根据查询条件） ")])), _: 1, __: [5] }, 8, ["fn", "params"])), [[V, e(f).download]])]), viewLeft: i(() => [w("div", L, [o(_, { class: "filter-item", size: "large", type: "warning" }, { default: i(() => [m(" 装车费汇总：" + S(e(Q)(y.detailsCount) || "0") + " 元 ", 1)]), _: 1 })])]), _: 1 })]);
  };
} }, G = Object.freeze(Object.defineProperty({ __proto__: null, default: R }, Symbol.toStringTag, { value: "Module" }));
export {
  R as _,
  F as c,
  A as g,
  G as h
};
