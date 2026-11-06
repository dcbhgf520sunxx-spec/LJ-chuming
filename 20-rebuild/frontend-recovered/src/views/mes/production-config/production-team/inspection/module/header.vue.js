import { openBlock as d } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as i } from "vue";
import { vShow as u } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { renderSlot as p } from "vue";
import { createVNode as a } from "vue";
import { Fragment as f } from "vue";
import { B as _, C as g, E as h } from "../../../../../../shared/runtime.js";
import { _ as y } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const N = { __name: "header", setup(V) {
  const t = { processId: void 0, leaderName: void 0 }, { crud: r, query: s } = _(t);
  return (l, o) => (d(), m(f, null, [i(c("div", null, [p(l.$slots, "teamType"), a(e(y), { class: "filter-item", multiple: false, clearable: "", modelValue: e(s).processId, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(s).processId = n), style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), a(e(g))], 512), [[u, e(r).searchToggle]]), a(e(h))], 64));
} };
export {
  N as default
};
