import { resolveComponent as w } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as b } from "vue";
import { vShow as h } from "vue";
import { unref as a } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as u } from "vue";
import { createBlock as V } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as f } from "vue";
import { createCommentVNode as q } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElTag as x } from "element-plus";
import { l as g, _ as Y, p as d, ip as l, B as S, G as C, L as N } from "../../../../../shared/runtime.js";
function A(r) {
  return g({ url: "/api/contract/analysis/department/quarter", method: "get", params: r });
}
function B(r) {
  return g({ url: "/api/contract/analysis/department/quarter/export", method: "get", responseType: "blob", params: r });
}
const H = { get: A };
const E = { class: "head-container" }, Q = { style: { float: "right" } }, j = { __name: "header", setup(r) {
  const T = { year: d((/* @__PURE__ */ new Date()).getTime(), "{y}"), type: { value: l.FIRST.V, resetAble: false }, startTime: (/* @__PURE__ */ new Date(d((/* @__PURE__ */ new Date()).getTime(), "{y}") + "-01-01 00:00:00")).getTime(), endTime: (/* @__PURE__ */ new Date(d((/* @__PURE__ */ new Date()).getTime(), "{y}") + "-03-31 23:59:59")).getTime() }, { crud: e, query: o } = S(T);
  function c() {
    var i, t, n, s;
    e.query.type && (e.query.startTime = new Date(e.query.year + ((t = (i = l.V) == null ? void 0 : i[e.query.type]) == null ? void 0 : t.START)).getTime(), e.query.endTime = new Date(e.query.year + ((s = (n = l.V) == null ? void 0 : n[e.query.type]) == null ? void 0 : s.END)).getTime()), e.toQuery();
  }
  return (i, t) => {
    const n = k, s = w("common-radio-button"), v = x;
    return p(), D("div", E, [b(y("div", null, [u(n, { modelValue: a(o).year, "onUpdate:modelValue": t[0] || (t[0] = (m) => a(o).year = m), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: c }, null, 8, ["modelValue"]), u(s, { modelValue: a(o).type, "onUpdate:modelValue": t[1] || (t[1] = (m) => a(o).type = m), options: a(l).ENUM, class: "filter-item", type: "enum", onChange: c }, null, 8, ["modelValue", "options"]), y("div", Q, [a(C)(a(e).permission.download) ? (p(), V(N, { key: 0, fn: a(B), params: { registerDate: new Date(a(e).query.year).getTime() }, class: "filter-item" }, { default: _(() => t[2] || (t[2] = [f(" 销售部季度排名表下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : q("", true), u(v, { effect: "plain", class: "filter-item" }, { default: _(() => t[3] || (t[3] = [f("单位：万元")])), _: 1, __: [3] })])], 512), [[h, a(e).searchToggle]])]);
  };
} }, P = Y(j, [["__scopeId", "data-v-822b9b70"]]), I = Object.freeze(Object.defineProperty({ __proto__: null, default: P }, Symbol.toStringTag, { value: "Module" }));
export {
  H as c,
  I as h,
  P as m
};
