import { resolveComponent as y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as v } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as b } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElTag as k } from "element-plus";
import { l as p, _ as w, i9 as m, B as C, G as E, L as T } from "../../../../../shared/runtime.js";
function B(o) {
  return p({ url: "/api/contract/analysis/department", method: "get", params: o });
}
function N(o) {
  return p({ url: "/api/contract/analysis/department/export", method: "get", responseType: "blob", params: o });
}
const Q = { get: B };
const S = { class: "head-container" }, A = { style: { float: "right" } }, Y = { __name: "header", setup(o) {
  const u = { registerDate: (/* @__PURE__ */ new Date()).getTime(), type: { value: m.SELLER.V, resetAble: false } }, { crud: a, query: s } = C(u);
  return (q, t) => {
    const _ = x, f = y("common-radio-button"), g = k;
    return l(), h("div", S, [v(i("div", null, [n(_, { modelValue: e(s).registerDate, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(s).registerDate = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(f, { modelValue: e(s).type, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(s).type = r), options: e(m).ENUM, class: "filter-item", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i("div", A, [e(E)(e(a).permission.download) ? (l(), V(T, { key: 0, fn: e(N), params: { registerDate: e(a).query.registerDate }, class: "filter-item" }, { default: d(() => t[2] || (t[2] = [c(" 承接合同分析表下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : b("", true), n(g, { effect: "plain", class: "filter-item" }, { default: d(() => t[3] || (t[3] = [c("单位：万元")])), _: 1, __: [3] })])], 512), [[D, e(a).searchToggle]])]);
  };
} }, j = w(Y, [["__scopeId", "data-v-7800a92f"]]), U = Object.freeze(Object.defineProperty({ __proto__: null, default: j }, Symbol.toStringTag, { value: "Module" }));
export {
  Q as c,
  U as h,
  j as m
};
