import { resolveComponent as m } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as y } from "vue";
import { vShow as Y } from "vue";
import { unref as e } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as l } from "vue";
import { withCtx as k } from "vue";
import { ElDatePicker as C } from "element-plus";
import { p as D, B as L, E as x } from "../../../../../../shared/runtime.js";
const B = { class: "head-container" }, I = { __name: "header", props: { gasTypeList: { type: Array, default: () => [] } }, emits: ["change"], setup(u, { emit: f }) {
  const g = f, p = u, _ = { year: D(/* @__PURE__ */ new Date(), "{y}"), classifyId: void 0, unit: void 0 };
  function h(s) {
    return s > /* @__PURE__ */ new Date();
  }
  const { crud: a, query: n } = L(_);
  function v(s) {
    var i, r;
    const t = (i = p.gasTypeList.find((o) => o.id === s)) == null ? void 0 : i.accountingUnit, d = (r = p.gasTypeList.find((o) => o.id === s)) == null ? void 0 : r.name;
    a.query.unit = t, g("change", t, d), a.toQuery();
  }
  return (s, t) => {
    const d = C, i = m("common-radio-button"), r = m("print-table"), o = b("permission");
    return w(), V("div", B, [y(T("div", null, [l(d, { modelValue: e(n).year, "onUpdate:modelValue": t[0] || (t[0] = (c) => e(n).year = c), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", clearable: false, "value-format": "YYYY", "disabled-date": h, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), l(i, { modelValue: e(n).classifyId, "onUpdate:modelValue": t[1] || (t[1] = (c) => e(n).classifyId = c), options: u.gasTypeList, class: "filter-item", type: "other", "data-structure": { key: "id", label: "name", value: "id" }, onChange: v }, null, 8, ["modelValue", "options"])], 512), [[Y, e(a).searchToggle]]), l(e(x), null, { viewLeft: k(() => [y(l(r, { "api-key": "gasRecord", params: { ...e(n) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[o, e(a).permission.print]])]), _: 1 })]);
  };
} };
export {
  I as default
};
