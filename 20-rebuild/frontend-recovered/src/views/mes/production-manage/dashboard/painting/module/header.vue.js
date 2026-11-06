import { openBlock as s } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as u } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { vShow as i } from "vue";
import { B as p, q as f, E as g } from "../../../../../../shared/runtime.js";
import { u as h } from "../../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
const b = { __name: "header", setup(_) {
  const t = { projectId: { value: void 0, resetAble: false } }, { crud: o, query: a } = p(t);
  return h(o), (j, r) => (s(), d(e(g), null, { optLeft: n(() => [u(c("div", null, [m(e(f), { modelValue: e(a).monomerId, "onUpdate:modelValue": r[0] || (r[0] = (l) => e(a).monomerId = l), "project-id": e(a).projectId, default: false, clearable: "", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "project-id", "onChange"])], 512), [[i, e(o).searchToggle]])]), _: 1 }));
} };
export {
  b as default
};
