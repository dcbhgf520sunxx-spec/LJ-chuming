import { ref as V } from "vue";
import { inject as g } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as C } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as l } from "vue";
import { withCtx as i } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as f } from "vue";
import { createCommentVNode as c } from "vue";
import { ElDatePicker as v } from "element-plus";
import { B as N, aV as B, C as M, G as h, L as y, E } from "../../../../../shared/runtime.js";
import { y as I, a as O } from "../../../../../modules/finished-product-storage-summary-8160e784.js";
const j = { __name: "header", setup(Y) {
  const p = V(), m = g("permission"), _ = { yearMonth: +/* @__PURE__ */ new Date(), workshopId: void 0, workshopName: void 0 }, { crud: t, query: o } = N(_);
  function k(r) {
    var s;
    const a = (s = p.value) == null ? void 0 : s.getOption(r);
    o.workshopName = a == null ? void 0 : a.shortName, t.toQuery();
  }
  function w(r) {
    return r > /* @__PURE__ */ new Date();
  }
  return (r, a) => {
    const s = v;
    return d(), x("div", null, [C(b("div", null, [l(s, { modelValue: e(o).yearMonth, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(o).yearMonth = n), size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择月份", type: "month", "value-format": "x", format: "YYYY-MM", clearable: false, "disabled-date": w, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(B), { ref_key: "workshopSelectRef", ref: p, modelValue: e(o).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(o).workshopId = n), placeholder: "选择车间搜索", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", clearable: false, default: "", onChange: k }, null, 8, ["modelValue", "factory-id"]), l(e(M))], 512), [[D, e(t).searchToggle]]), l(e(E), null, { optLeft: i(() => [e(h)(e(m).export) ? (d(), u(e(y), { key: 0, disabled: !e(t).data.length, fn: e(I), params: e(o) }, { default: i(() => a[2] || (a[2] = [f(" 成品入库汇总下载 ")])), _: 1, __: [2] }, 8, ["disabled", "fn", "params"])) : c("", true), e(h)(e(m).detailExport) ? (d(), u(e(y), { key: 1, fn: e(O), params: e(o) }, { default: i(() => a[3] || (a[3] = [f(" 成品入库详情下载 ")])), _: 1, __: [3] }, 8, ["fn", "params"])) : c("", true)]), _: 1 })]);
  };
} };
export {
  j as default
};
