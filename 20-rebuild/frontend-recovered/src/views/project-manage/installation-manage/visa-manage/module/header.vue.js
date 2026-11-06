import { watch as m } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as l } from "vue";
import { withCtx as y } from "vue";
import { withDirectives as _ } from "vue";
import { createElementVNode as j } from "vue";
import { renderSlot as g } from "vue";
import { unref as e } from "vue";
import { vShow as v } from "vue";
import { B as V, u1 as I, E as b } from "../../../../../shared/runtime.js";
const w = { class: "head-container" }, E = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(u) {
  const c = { projectId: { value: void 0, resetAble: false }, mode: void 0 }, { crud: o, query: t } = V(c), s = u;
  return m(() => s.projectId, (r) => {
    r && (o.query.projectId = s.projectId, o.toQuery());
  }, { immediate: true, deep: true }), (r, a) => {
    const p = d("project-radio-button"), i = d("common-select");
    return f(), h("div", w, [l(e(b), null, { optLeft: y(() => [_(j("div", null, [g(r.$slots, "createBtn"), l(p, { size: "default", type: "all", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(t).projectId = n), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), l(i, { type: "enum", modelValue: e(t).mode, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(t).mode = n), options: e(I).ENUM, clearable: "", placeholder: "选择类别", style: { width: "270px" }, class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[v, e(o).searchToggle]])]), _: 3 })]);
  };
} };
export {
  E as default
};
