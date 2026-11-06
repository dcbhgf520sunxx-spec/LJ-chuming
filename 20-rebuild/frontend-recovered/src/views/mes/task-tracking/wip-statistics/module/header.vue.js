import y from "moment";
import { inject as v } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as g } from "vue";
import { ElDatePicker as k } from "element-plus";
import { B as w } from "../../../../../shared/runtime.js";
const x = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, C = { style: { width: "300px" } }, T = { __name: "header", setup(D) {
  const d = y().startOf("month").valueOf(), c = v("permission"), p = { projectId: void 0, dateTime: d };
  function m(i) {
    return i > /* @__PURE__ */ new Date();
  }
  const { crud: n, query: t } = w(p);
  return (i, a) => {
    const u = k, f = r("project-radio-button"), _ = r("print-table"), h = b("permission");
    return V(), j("div", x, [l("div", null, [s(u, { modelValue: e(t).dateTime, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).dateTime = o), type: "month", size: "default", class: "date-item filter-item", style: { width: "130px !important" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x", "disabled-date": m, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), s(f, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).projectId = o), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), l("div", C, [g(s(_, { "api-key": "mesWipStatisticsList", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[h, e(c).print]])])]);
  };
} };
export {
  T as default
};
