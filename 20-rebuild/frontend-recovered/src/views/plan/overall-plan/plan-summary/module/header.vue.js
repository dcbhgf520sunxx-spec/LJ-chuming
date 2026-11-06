import { computed as T } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as V } from "vue";
import { vShow as f } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as l } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as h } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElTag as Y } from "element-plus";
import { m as S, K as u, T as o, B as U, E as B } from "../../../../../shared/runtime.js";
const w = { __name: "header", setup(D) {
  const { globalProject: s } = S(["globalProject"]), c = { type: s.value.projectType === u.STEEL.V ? o.STRUCTURE.V : o.BRIDGE.V, year: String((/* @__PURE__ */ new Date()).getFullYear()) }, { crud: n, query: t } = U(c), m = T(() => s.value.projectType === u.STEEL.V ? [o.STRUCTURE] : [o.BRIDGE]);
  return (j, a) => {
    const d = R, i = _("common-radio-button"), y = Y;
    return E(), g("div", null, [V(v("div", null, [l(d, { modelValue: e(t).year, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(t).year = r), type: "year", placeholder: "请选择", format: "YYYY", "value-format": "YYYY", class: "filter-item", onChange: e(n).toQuery, style: { width: "120px" } }, null, 8, ["modelValue", "onChange"]), l(i, { modelValue: e(t).type, "onUpdate:modelValue": a[1] || (a[1] = (r) => e(t).type = r), options: m.value, type: "enum", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[f, e(n).searchToggle]]), l(e(B), null, { optLeft: p(() => [l(y, null, { default: p(() => [C(h(e(t).type === e(o).STRUCTURE.V || e(t).type === e(o).BRIDGE.V ? "单位(t)" : "单位(m)"), 1)]), _: 1 })]), _: 1 })]);
  };
} };
export {
  w as default
};
