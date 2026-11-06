import _ from "moment";
import { inject as k } from "vue";
import { ref as w } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as V } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as l } from "vue";
import { withKeys as x } from "vue";
import { withCtx as i } from "vue";
import { createBlock as C } from "vue";
import { createTextVNode as I } from "vue";
import { createCommentVNode as M } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElInput as j } from "element-plus";
import { l as c, B as N, aV as S, C as T, G as R, L as B, E as P } from "../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../modules/project-select-94bb5bbd.js";
function Y(s) {
  return c({ module: "mes", url: "outputReport/workshopProductionOutputStatisticsMonthlyReport", method: "get", params: s });
}
function D(s) {
  return c({ module: "mes", url: "outputReport/workshopProductionOutputStatisticsMonthlyReportDownload", method: "get", responseType: "blob", params: s });
}
const K = { get: Y }, E = { __name: "header", setup(s) {
  const m = { yearMonth: _().startOf("month").valueOf(), workshopId: void 0, workshopName: void 0, projectId: void 0, structureType: void 0 }, f = k("permission"), d = w();
  function h(u) {
    var n;
    const o = (n = d.value) == null ? void 0 : n.getOption(u);
    t.workshopName = o == null ? void 0 : o.shortName, r.toQuery();
  }
  const { crud: r, query: t } = N(m);
  return (u, o) => {
    const n = O, y = j;
    return p(), g("div", null, [V(v("div", null, [l(n, { modelValue: e(t).yearMonth, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).yearMonth = a), type: "month", size: "default", "value-format": "x", format: "YYYY-MM", placeholder: "选择月份", style: { width: "120px" }, class: "filter-item", clearable: false, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(S), { ref_key: "workshopSelectRef", ref: d, modelValue: e(t).workshopId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).workshopId = a), placeholder: "选择车间搜索", "factory-id": e(t).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: h }, null, 8, ["modelValue", "factory-id"]), l(e(Q), { modelValue: e(t).projectId, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).projectId = a), class: "filter-item", clearable: "", placeholder: "选择项目搜索", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(y, { modelValue: e(t).structureType, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).structureType = a), placeholder: "输入构件类别搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: x(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(T))], 512), [[b, e(r).searchToggle]]), l(e(P), null, { optLeft: i(() => [e(R)(e(f).export) ? (p(), C(e(B), { key: 0, disabled: !e(r).data.length || !e(t).workshopId, fn: e(D), params: e(t) }, { default: i(() => o[4] || (o[4] = [I(" 车间制作产量统计月报下载 ")])), _: 1, __: [4] }, 8, ["disabled", "fn", "params"])) : M("", true)]), _: 1 })]);
  };
} }, q = Object.freeze(Object.defineProperty({ __proto__: null, default: E }, Symbol.toStringTag, { value: "Module" }));
export {
  E as _,
  K as c,
  q as h
};
