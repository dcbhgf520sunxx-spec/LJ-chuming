import { B as u } from "../../../../../shared/runtime.js";
import { _ as l } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import { watch as c } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as f } from "vue";
import { unref as e } from "vue";
const I = { class: "head-container" }, h = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(s) {
  const n = { projectId: { value: void 0, resetAble: false }, supplierid: void 0 }, { crud: r, query: t } = u(n), o = s;
  return c(() => o.projectId, (d) => {
    d && (r.query.projectId = o.projectId, r.toQuery());
  }, { immediate: true, deep: true }), (d, a) => (i(), m("div", I, [f(l, { modelValue: e(t).supplierId, "onUpdate:modelValue": a[0] || (a[0] = (p) => e(t).supplierId = p), projectId: e(t).projectId, style: { width: "300px" }, class: "filter-item", size: "default", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "projectId", "onChange"])]));
} };
export {
  h as default
};
