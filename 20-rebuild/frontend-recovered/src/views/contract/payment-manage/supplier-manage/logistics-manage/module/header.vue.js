import { resolveComponent as c } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as r } from "vue";
import { withCtx as o } from "vue";
import { withDirectives as n } from "vue";
import { createElementVNode as h } from "vue";
import { unref as e } from "vue";
import { withKeys as v } from "vue";
import { vShow as g } from "vue";
import { ElDatePicker as w } from "element-plus";
import { ElInput as Y } from "element-plus";
import { B as V, C as k, E as x } from "../../../../../../shared/runtime.js";
const C = { class: "head-container" }, E = { __name: "header", setup(N) {
  const i = { year: String((/* @__PURE__ */ new Date()).getFullYear()), supplierName: void 0 }, { crud: s, query: a } = V(i);
  return (b, l) => {
    const p = w, m = Y, u = c("print-table"), d = _("permission");
    return f(), y("div", C, [r(e(x), null, { optLeft: o(() => [n(h("div", null, [r(p, { modelValue: e(a).year, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).year = t), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px!important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), r(m, { modelValue: e(a).supplierName, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).supplierName = t), modelModifiers: { trim: true }, placeholder: "物流公司", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: v(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(k))], 512), [[g, e(s).searchToggle]])]), viewLeft: o(() => {
      var t;
      return [n(r(u, { "api-key": "logisticsPaymentLedger", params: { ...e(a) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[d, (t = e(s).permission) == null ? void 0 : t.print]])];
    }), _: 1 })]);
  };
} };
export {
  E as default
};
