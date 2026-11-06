import s from "moment";
import { resolveComponent as l } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as i } from "vue";
import { vShow as y } from "vue";
import { unref as t } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as n } from "vue";
import { withCtx as V } from "vue";
import { Fragment as D } from "vue";
import { ElMessage as O } from "element-plus";
import { ElDatePicker as b } from "element-plus";
import { B as k, I as w, C as I, E as x, b as B } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/factory-select-b8d0a4ac.js";
const T = { __name: "header", setup(P) {
  const d = { date: [s().startOf("month").valueOf(), s().valueOf()], startDate: s().startOf("month").valueOf(), endDate: s().valueOf() }, { crud: a, query: e } = k(d);
  function u() {
    if (B(a.selections)) return O.warning("至少选择一条需要打印的生产线信息"), false;
  }
  function c() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), a.toQuery();
  }
  return (S, o) => {
    const m = l("project-radio-button"), p = b, f = l("print-table"), _ = h("permission");
    return g(), v(D, null, [i(C("div", null, [n(m, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": o[0] || (o[0] = (r) => t(e).projectId = r), class: "filter-item", onChange: t(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(p, { modelValue: t(e).date, "onUpdate:modelValue": o[1] || (o[1] = (r) => t(e).date = r), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: t(w), "value-format": "x", onChange: c }, null, 8, ["modelValue", "shortcuts"]), n(t(E), { modelValue: t(e).factoryId, "onUpdate:modelValue": o[2] || (o[2] = (r) => t(e).factoryId = r), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: t(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(t(I))], 512), [[y, t(a).searchToggle]]), n(t(x), null, { optRight: V(() => [i(n(f, { "api-key": "mesEnclosureProductionLine", params: { ...t(e) }, "before-print": u, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[_, t(a).permission.print]])]), _: 1 })], 64);
  };
} };
export {
  T as default
};
