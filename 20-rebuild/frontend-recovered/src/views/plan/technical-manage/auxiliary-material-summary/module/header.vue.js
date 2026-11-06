import { B as g, q as h, T as V, E as b } from "../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as a } from "vue";
import { withCtx as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
const R = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(u) {
  const p = { monomerId: void 0, areaId: void 0 }, c = i(), l = i([]), { crud: r, query: o } = g(p), f = u;
  function y(s) {
    l.value = s || [];
  }
  return (s, t) => {
    const _ = m("common-select"), I = m("print-table"), v = C("permission");
    return S(), T("div", null, [a(e(b), null, { optLeft: d(() => [a(e(h), { ref_key: "monomerSelectRef", ref: c, modelValue: e(o).monomerId, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(o).monomerId = n), "project-id": f.projectId, class: "filter-item", default: false, clearable: "", productType: e(V).STRUCTURE.V, onGetAreaInfo: y, onChange: e(r).toQuery }, null, 8, ["modelValue", "project-id", "productType", "onChange"]), a(_, { modelValue: e(o).areaId, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(o).areaId = n), options: l.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), viewLeft: d(() => [k(a(I, { "api-key": "auxiliaryMaterialSummary", params: { ...e(o) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[v, e(r).permission.print]])]), _: 1 })]);
  };
} };
export {
  R as default
};
