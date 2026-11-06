import { resolveComponent as s } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as i } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { withCtx as C } from "vue";
import { ElDatePicker as g } from "element-plus";
import { p as V, B as Y, E as k } from "../../../../../shared/runtime.js";
const D = { class: "head-container" }, E = { __name: "header", props: { branchList: { type: Array, default: () => [] } }, setup(d) {
  const c = { branchCompanyId: void 0, year: V(/* @__PURE__ */ new Date(), "{y}") }, { crud: t, query: a } = Y(c);
  function p(l) {
    return l > /* @__PURE__ */ new Date();
  }
  return (l, o) => {
    const m = g, u = s("common-select-v2"), y = s("print-table"), f = h("permission");
    return _(), b("div", D, [i(w("div", null, [r(m, { modelValue: e(a).year, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(a).year = n), type: "year", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", clearable: false, format: "YYYY", "value-format": "YYYY", "disabled-date": p, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), r(u, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(a).branchCompanyId = n), options: d.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "费用归属筛选", class: "filter-item", style: { width: "270px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[v, e(t).searchToggle]]), r(e(k), null, { viewLeft: C(() => [i(r(y, { "api-key": "wageCost", params: e(a), size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[f, e(t).permission.print]])]), _: 1 })]);
  };
} };
export {
  E as default
};
