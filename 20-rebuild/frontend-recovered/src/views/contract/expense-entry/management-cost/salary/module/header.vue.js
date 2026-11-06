import { resolveComponent as l } from "vue";
import { resolveDirective as f } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as m } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as o } from "vue";
import { withCtx as V } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { p as E, ji as s, B as T, C as b, E as A } from "../../../../../../shared/runtime.js";
const C = { class: "head-container" }, S = { __name: "header", setup(N) {
  const p = { year: E(/* @__PURE__ */ new Date(), "{y}"), wageType: s.MANAGEMENT_SALARY.V };
  function d(i) {
    return i > /* @__PURE__ */ new Date();
  }
  const { crud: a, query: t } = T(p);
  return (i, n) => {
    const u = Y, c = l("common-radio-button"), y = l("print-table"), _ = f("permission");
    return g(), w("div", C, [m(h("div", null, [o(u, { modelValue: e(t).year, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(t).year = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", clearable: false, "disabled-date": d, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), o(c, { modelValue: e(t).wageType, "onUpdate:modelValue": n[1] || (n[1] = (r) => e(t).wageType = r), options: e(s).ENUM, class: "filter-item", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(b))], 512), [[v, e(a).searchToggle]]), o(e(A), null, { viewLeft: V(() => [m(o(y, { "api-key": `${e(a).query.wageType === e(s).MANAGEMENT_SALARY.V ? "managementSalaryList" : "productionSalaryList"}`, params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[_, e(a).permission.print]])]), _: 1 })]);
  };
} };
export {
  S as default
};
