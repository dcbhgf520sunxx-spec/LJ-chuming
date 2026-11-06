import { inject as u } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as f } from "vue";
import { withDirectives as o } from "vue";
import { vShow as y } from "vue";
import { unref as e } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as g } from "vue";
import { ElDatePicker as k } from "element-plus";
import { B as w } from "../../../../../shared/runtime.js";
const D = { style: { display: "flex", "justify-content": "space-between" } }, b = { style: { width: "300px" } }, T = { __name: "header", setup(x) {
  const r = u("permission"), l = { localDateTime: void 0 }, { crud: t, query: a } = w(l);
  return (n, s) => {
    const c = k, p = _("print-table"), d = f("permission");
    return o((h(), v("div", D, [i(c, { modelValue: e(a).localDateTime, "onUpdate:modelValue": s[0] || (s[0] = (m) => e(a).localDateTime = m), type: "year", size: "default", "value-format": "x", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), g("div", b, [o(i(p, { "api-key": n.apiKey, params: { ...e(a) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[d, e(r).print]])])], 512)), [[y, e(t).searchToggle]]);
  };
} };
export {
  T as default
};
