import { openBlock as s } from "vue";
import { createElementBlock as n } from "vue";
import { withDirectives as d } from "vue";
import { vShow as m } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as u } from "vue";
import { B as i, q as f } from "../../../../shared/runtime.js";
const p = { style: { display: "float" } }, y = { __name: "header", setup(_) {
  const t = { monomerId: void 0 }, { crud: r, query: o } = i(t);
  return (h, a) => (s(), n("div", null, [d(c("div", p, [u(e(f), { ref: "monomerSelectRef", modelValue: e(o).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).monomerId = l), "project-id": e(o).projectId, default: false, clearable: "", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "project-id", "onChange"])], 512), [[m, e(r).searchToggle]])]));
} };
export {
  y as default
};
