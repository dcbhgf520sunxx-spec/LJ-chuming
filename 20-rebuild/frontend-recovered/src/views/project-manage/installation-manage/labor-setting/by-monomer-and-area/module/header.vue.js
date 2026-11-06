import { ref as s } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as d } from "vue";
import { withDirectives as m } from "vue";
import { vShow as c } from "vue";
import { unref as e } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as i } from "vue";
import { B as f, q as p } from "../../../../../../shared/runtime.js";
const _ = { style: { display: "flex" } }, V = { __name: "header", setup(h) {
  const t = { type: void 0, monomerId: void 0 }, { crud: r, query: o } = f(t);
  return s(false), (y, a) => (n(), d("div", null, [m(u("div", _, [i(e(p), { ref: "monomerSelectRef", modelValue: e(o).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).monomerId = l), "project-id": e(o).projectId, default: false, clearable: "", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "project-id", "onChange"])], 512), [[c, e(r).searchToggle]])]));
} };
export {
  V as default
};
