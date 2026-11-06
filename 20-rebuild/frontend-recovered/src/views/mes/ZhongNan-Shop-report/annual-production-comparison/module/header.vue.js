import { ref as _ } from "vue";
import { inject as k } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as g } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as n } from "vue";
import { withCtx as p } from "vue";
import { createBlock as C } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as D } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { l as c, p as x, B as N, aV as O, C as B, G as I, L as S, E as T } from "../../../../../shared/runtime.js";
function j(t) {
  return c({ module: "mes", url: "outputReport/yearlyOutputComparison", method: "get", params: t });
}
function R(t) {
  return c({ module: "mes", url: "outputReport/yearlyOutputComparisonDownload", method: "get", responseType: "blob", params: t });
}
const $ = { get: j }, E = { __name: "header", setup(t) {
  const u = _(), m = k("permission"), f = { year: x(/* @__PURE__ */ new Date(), "{y}"), workshopId: void 0, workshopName: void 0 }, { crud: r, query: o } = N(f);
  function y(s) {
    var l;
    const a = (l = u.value) == null ? void 0 : l.getOption(s);
    o.workshopName = a == null ? void 0 : a.shortName, r.toQuery();
  }
  function h(s) {
    return s > /* @__PURE__ */ new Date();
  }
  return (s, a) => {
    const l = Y;
    return i(), w("div", null, [g(V("div", null, [n(l, { modelValue: e(o).year, "onUpdate:modelValue": a[0] || (a[0] = (d) => e(o).year = d), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, format: "YYYY", "value-format": "YYYY", placeholder: "选择年", clearable: false, "disabled-date": h, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(O), { ref_key: "workshopSelectRef", ref: u, modelValue: e(o).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (d) => e(o).workshopId = d), placeholder: "选择车间搜索", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: y }, null, 8, ["modelValue", "factory-id"]), n(e(B))], 512), [[b, e(r).searchToggle]]), n(e(T), null, { optLeft: p(() => [e(I)(e(m).export) ? (i(), C(e(S), { key: 0, disabled: !e(r).data.length || !e(o).workshopId, fn: e(R), params: e(o) }, { default: p(() => a[2] || (a[2] = [v(" 年度产量对比下载 ")])), _: 1, __: [2] }, 8, ["disabled", "fn", "params"])) : D("", true)]), _: 1 })]);
  };
} }, q = Object.freeze(Object.defineProperty({ __proto__: null, default: E }, Symbol.toStringTag, { value: "Module" }));
export {
  E as _,
  $ as c,
  q as h
};
