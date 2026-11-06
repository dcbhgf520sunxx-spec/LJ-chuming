import s from "moment";
import { resolveComponent as p } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as c } from "vue";
import { vShow as D } from "vue";
import { unref as t } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as r } from "vue";
import { createBlock as E } from "vue";
import { createCommentVNode as O } from "vue";
import { withCtx as k } from "vue";
import { Fragment as I } from "vue";
import { ElDatePicker as N } from "element-plus";
import { r$ as u, dM as l, B as U, I as A, C as R, E as S } from "../../../../../../shared/runtime.js";
const Q = { __name: "header", setup(w) {
  const f = { date: [s().subtract(1, "month").valueOf(), s().valueOf()], startDate: s().subtract(1, "month").valueOf(), endDate: s().valueOf(), productType: u.ONCE.V, componentType: l.ARTIFACT.V };
  function y(d) {
    d === l.ARTIFACT.V ? e.productType = u.ONCE.V : e.productType = d, n.toQuery();
  }
  const { crud: n, query: e } = U(f);
  function _() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), n.toQuery();
  }
  return (d, o) => {
    const T = p("project-radio-button"), i = p("common-radio-button"), V = N, C = p("print-table"), g = h("permission");
    return m(), v(I, null, [c(b("div", null, [r(T, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).projectId = a), class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(i, { modelValue: t(e).componentType, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).componentType = a), options: t(l).ENUM, type: "enum", class: "filter-item", onChange: y }, null, 8, ["modelValue", "options"]), t(e).componentType === t(l).ARTIFACT.V ? (m(), E(i, { key: 0, modelValue: t(e).productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).productType = a), options: t(u).ENUM, type: "enum", class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : O("", true), r(V, { modelValue: t(e).date, "onUpdate:modelValue": o[3] || (o[3] = (a) => t(e).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: t(A), "value-format": "x", onChange: _ }, null, 8, ["modelValue", "shortcuts"]), r(t(R))], 512), [[D, t(n).searchToggle]]), r(t(S), null, { optLeft: k(() => [c(r(C, { "api-key": "mesWageSummary", params: { ...t(e) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[g, t(n).permission.print]])]), _: 1 })], 64);
  };
} };
export {
  Q as default
};
