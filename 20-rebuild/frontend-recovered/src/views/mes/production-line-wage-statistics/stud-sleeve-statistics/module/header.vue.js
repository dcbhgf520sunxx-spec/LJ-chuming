import { inject as v } from "vue";
import s from "moment";
import { ref as g } from "vue";
import { resolveComponent as l } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withCtx as C } from "vue";
import { withDirectives as D } from "vue";
import { ElDatePicker as O } from "element-plus";
import { B as b, fj as i, I as k, E as w } from "../../../../../shared/runtime.js";
const j = { class: "header-container" }, Q = { __name: "header", setup(S) {
  const d = v("permission"), u = { projectId: void 0, auxiliaryTypeEnum: void 0, date: [s().subtract(1, "week").valueOf(), s().valueOf()], startDate: s().subtract(1, "week").valueOf(), endDate: s().valueOf() }, { crud: r, query: e } = b(u);
  function p() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  const m = g([i.PEG, i.SLEEVE]);
  return (T, a) => {
    const c = l("project-radio-button"), f = l("common-radio-button"), _ = O, y = l("print-table"), h = E("permission");
    return V(), x("div", j, [o(c, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).projectId = n), type: "all", class: "filter-item", onChange: t(r).toQuery }, null, 8, ["modelValue", "onChange"]), o(f, { modelValue: t(e).auxiliaryTypeEnum, "onUpdate:modelValue": a[1] || (a[1] = (n) => t(e).auxiliaryTypeEnum = n), options: m.value, showOptionAll: "", class: "filter-item", type: "enum", onChange: t(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(_, { modelValue: t(e).date, "onUpdate:modelValue": a[2] || (a[2] = (n) => t(e).date = n), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: t(k), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: p }, null, 8, ["modelValue", "shortcuts"]), o(t(w), null, { viewLeft: C(() => [D(o(y, { "api-key": "mesStudSleeveStatisticsList", params: { ...t(e) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[h, t(d).print]])]), _: 1 })]);
  };
} };
export {
  Q as default
};
