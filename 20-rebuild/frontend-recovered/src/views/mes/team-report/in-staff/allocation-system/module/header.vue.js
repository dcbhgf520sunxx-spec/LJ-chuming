import r from "moment";
import { resolveComponent as m } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as _ } from "vue";
import { withDirectives as g } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as O } from "vue";
import { vShow as D } from "vue";
import { ElDatePicker as I } from "element-plus";
import { r$ as u, dM as s, B as v, I as E, C as N, E as U } from "../../../../../../shared/runtime.js";
import { _ as b } from "../../../../../../modules/factory-select-b8d0a4ac.js";
const w = { __name: "header", setup(k) {
  const f = { date: [r().startOf("year").valueOf(), r().valueOf()], startDate: r().startOf("year").valueOf(), endDate: r().valueOf(), productType: u.ONCE.V, componentType: s.ARTIFACT.V };
  function y(d) {
    d === s.ARTIFACT.V ? t.productType = u.ONCE.V : t.productType = d, n.toQuery();
  }
  const { crud: n, query: t } = v(f);
  function V() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), n.toQuery();
  }
  return (d, o) => {
    const C = m("project-radio-button"), p = m("common-radio-button"), T = I;
    return i(), c(e(U), null, { optLeft: _(() => [g(h("div", null, [l(C, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).projectId = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(p, { modelValue: e(t).componentType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).componentType = a), options: e(s).ENUM, type: "enum", class: "filter-item", onChange: y }, null, 8, ["modelValue", "options"]), e(t).componentType === e(s).ARTIFACT.V ? (i(), c(p, { key: 0, modelValue: e(t).productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).productType = a), options: e(u).ENUM, type: "enum", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : O("", true), l(T, { modelValue: e(t).date, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: e(E), "value-format": "x", onChange: V }, null, 8, ["modelValue", "shortcuts"]), l(e(b), { modelValue: e(t).factoryId, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).factoryId = a), class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(N))], 512), [[D, e(n).searchToggle]])]), _: 1 });
  };
} };
export {
  w as default
};
