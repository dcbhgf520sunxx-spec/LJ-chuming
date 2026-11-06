import { resolveComponent as m } from "vue";
import { resolveDirective as f } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as V } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElTag as w } from "element-plus";
import { eA as v, B as C, aV as D, E } from "../../../../../shared/runtime.js";
const b = { class: "head-container" }, Q = { __name: "header", props: { totalOutput: { type: Number, default: null }, totalQuantity: { type: Number, default: null } }, setup(r) {
  const i = { workshopId: void 0, selectedDate: void 0, statisticsModeEnum: v.JETBRAKING.V }, { crud: l, query: t } = C(i);
  return (x, o) => {
    const d = k, u = w, p = m("print-table"), c = f("permission");
    return _(), y("div", b, [a(e(E), null, { optLeft: n(() => [a(e(D), { modelValue: e(t).workshopId, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).workshopId = s), placeholder: "全部车间", class: "filter-item", clearable: "", "factory-id": e(t).factoryId, onChange: e(l).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), a(d, { modelValue: e(t).selectedDate, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).selectedDate = s), type: "month", size: "default", "value-format": "x", format: "YYYY-MM", placeholder: "选择月份", style: { width: "120px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), a(u, { effect: "plain", size: "large" }, { default: n(() => [h("统计模式：入库反推 | 数量：" + g(r.totalQuantity), 1)]), _: 1 })]), viewLeft: n(() => [V(a(p, { "api-key": "wagesReport", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[c, e(l).permission.print]])]), _: 1 })]);
  };
} };
export {
  Q as default
};
