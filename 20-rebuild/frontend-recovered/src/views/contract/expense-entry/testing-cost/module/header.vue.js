import { inject as d } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as l } from "vue";
import { withCtx as v } from "vue";
import { renderSlot as V } from "vue";
import { ElDatePicker as C } from "element-plus";
import { p as w, B as Y, C as I, E as j } from "../../../../../shared/runtime.js";
const k = { class: "head-container" }, B = { __name: "header", props: { branchList: { type: Array, default: () => [] } }, setup(x) {
  const i = d("dict"), p = d("projectList"), c = { year: w(/* @__PURE__ */ new Date(), "{y}"), projectId: void 0, testingFeeTypeId: void 0, branchCompanyId: void 0 }, { crud: n, query: t } = Y(c);
  function u(r) {
    return r > /* @__PURE__ */ new Date();
  }
  return (r, a) => {
    const m = C, s = y("common-select-v2");
    return f(), h("div", k, [_(g("div", null, [l(m, { modelValue: e(t).year, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).year = o), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", clearable: false, format: "YYYY", "value-format": "YYYY", "disabled-date": u, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(s, { modelValue: e(t).projectId, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).projectId = o), options: e(p), type: "other", "data-structure": { key: "id", label: "serialNumberName", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "300px" }, placeholder: "选择项目", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(s, { modelValue: e(t).testingFeeTypeId, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).testingFeeTypeId = o), options: e(i).testing_fee_type, type: "other", "data-structure": { key: "id", label: "label", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "检测费用类别", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(I))], 512), [[b, e(n).searchToggle]]), l(e(j), null, { optLeft: v(() => [V(r.$slots, "btn")]), _: 3 })]);
  };
} };
export {
  B as default
};
