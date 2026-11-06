import s from "moment";
import { resolveComponent as i } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as n } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as d } from "vue";
import { createElementVNode as y } from "vue";
import { unref as e } from "vue";
import { vShow as C } from "vue";
import { ElDatePicker as b } from "element-plus";
import { B as O, I as V, C as k, E as w } from "../../../../../shared/runtime.js";
const B = { __name: "header", setup(x) {
  const p = { projectId: { value: void 0, resetAble: false }, date: [s().subtract(1, "month").valueOf(), s().valueOf()], startTime: s().subtract(1, "month").valueOf(), endTime: s().valueOf() }, { crud: o, query: t } = O(p);
  function c(a = []) {
    a != null && a.length ? (t.startTime = a[0], t.endTime = a[1]) : (t.startTime = void 0, t.endTime = void 0), o.toQuery();
  }
  return (a, r) => {
    const m = i("project-radio-button"), f = b, _ = i("print-table"), h = v("permission");
    return g(), T("div", null, [n(e(w), null, { optLeft: u(() => [d(y("div", null, [n(m, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": r[0] || (r[0] = (l) => e(t).projectId = l), type: "all", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(f, { modelValue: e(t).date, "onUpdate:modelValue": r[1] || (r[1] = (l) => e(t).date = l), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(V), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: c }, null, 8, ["modelValue", "shortcuts"]), n(e(k))], 512), [[C, e(o).searchToggle]])]), viewLeft: u(() => [d(n(_, { "api-key": "enclosureTeamProduction", params: { ...e(t) }, size: "default", type: "warning" }, null, 8, ["params"]), [[h, e(o).permission.print]])]), _: 1 })]);
  };
} };
export {
  B as default
};
