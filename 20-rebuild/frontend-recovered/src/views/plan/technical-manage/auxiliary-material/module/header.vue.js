import { ref as c } from "vue";
import { watch as v } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as B } from "vue";
import { vShow as j } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as n } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as k } from "vue";
import { ElInput as Q } from "element-plus";
import { B as S, q as x, C as A, E as q } from "../../../../../shared/runtime.js";
const E = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, emits: ["currentChange", "currentAreaChange"], setup(p, { emit: y }) {
  const I = { classifyName: "", serialNumber: "", monomerId: void 0, projectId: { value: void 0, resetAble: false } }, V = c(), m = y, u = c([]), { crud: r, query: t } = S(I), s = p;
  v(() => s.projectId, (a) => {
    a && (r.query.projectId = s.projectId, r.toQuery());
  }, { immediate: true, deep: true });
  function g(a) {
    m("currentChange", a);
  }
  function h(a) {
    const o = u.value.find((d) => d.id === a) || {};
    m("currentAreaChange", o), r.toQuery();
  }
  function C(a) {
    u.value = a || [];
  }
  return (a, o) => {
    const d = b("common-select"), i = Q;
    return f(), N("div", null, [B(w("div", null, [n(e(x), { ref_key: "monomerSelectRef", ref: V, modelValue: e(t).monomerId, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).monomerId = l), "project-id": s.projectId, class: "filter-item", onChange: e(r).toQuery, onGetCurrentInfo: g, onGetAreaInfo: C }, null, 8, ["modelValue", "project-id", "onChange"]), n(d, { modelValue: e(t).areaId, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).areaId = l), options: u.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: h }, null, 8, ["modelValue", "options"]), n(i, { modelValue: e(t).classifyName, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).classifyName = l), size: "default", placeholder: "名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(r).toQuery }, null, 8, ["modelValue", "onBlur"]), n(i, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(t).serialNumber = l), size: "default", placeholder: "编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onBlur: e(r).toQuery }, null, 8, ["modelValue", "onBlur"]), n(e(A))], 512), [[j, e(r).searchToggle]]), e(t).monomerId ? (f(), _(e(q), { key: 0 })) : k("", true)]);
  };
} };
export {
  E as default
};
