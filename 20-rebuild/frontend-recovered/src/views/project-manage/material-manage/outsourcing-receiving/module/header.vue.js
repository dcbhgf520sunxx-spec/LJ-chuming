import { watch as u } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { withCtx as f } from "vue";
import { withDirectives as m } from "vue";
import { createElementVNode as I } from "vue";
import { renderSlot as h } from "vue";
import { unref as e } from "vue";
import { vShow as j } from "vue";
import { B as y, E as g } from "../../../../../shared/runtime.js";
import { s as v } from "../../../../../modules/index-8edb1b61.js";
const w = { class: "head-container" }, S = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(a) {
  const n = { projectId: { value: void 0, resetAble: false }, spplierId: void 0 }, { crud: t, query: o } = y(n), s = a;
  return u(() => s.projectId, (r) => {
    r && (t.query.projectId = s.projectId, t.toQuery());
  }, { immediate: true, deep: true }), (r, d) => (c(), i("div", w, [l(e(g), null, { optLeft: f(() => [m(I("div", null, [h(r.$slots, "createBtn"), l(v, { modelValue: e(o).supplierId, "onUpdate:modelValue": d[0] || (d[0] = (p) => e(o).supplierId = p), class: "filter-item", clearable: "", filterable: "", style: { width: "300px" }, projectId: a.projectId, onChange: e(t).toQuery }, null, 8, ["modelValue", "projectId", "onChange"])], 512), [[j, e(t).searchToggle]])]), _: 3 })]));
} };
export {
  S as default
};
