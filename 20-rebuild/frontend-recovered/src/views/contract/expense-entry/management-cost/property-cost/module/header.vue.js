import { resolveComponent as u } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as n } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as r } from "vue";
import { withCtx as w } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { p as b, B as g, E as D } from "../../../../../../shared/runtime.js";
const k = { class: "head-container" }, C = { __name: "header", setup(V) {
  const i = { year: b(/* @__PURE__ */ new Date(), "{y}") };
  function l(s) {
    return s > /* @__PURE__ */ new Date();
  }
  const { crud: a, query: t } = g(i);
  return (s, o) => {
    const p = Y, c = u("print-table"), d = _("permission");
    return f(), y("div", k, [n(h("div", null, [r(p, { modelValue: e(t).year, "onUpdate:modelValue": o[0] || (o[0] = (m) => e(t).year = m), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", clearable: false, "disabled-date": l, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), r(e(D), null, { viewLeft: w(() => [n(r(c, { "api-key": "propertyFeeList", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[d, e(a).permission.print]])]), _: 1 })], 512), [[v, e(a).searchToggle]])]);
  };
} };
export {
  C as default
};
