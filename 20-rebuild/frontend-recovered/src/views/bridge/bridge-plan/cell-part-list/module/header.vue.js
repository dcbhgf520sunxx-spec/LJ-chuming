import { ref as u } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as g } from "vue";
import { vShow as h } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { normalizeStyle as T } from "vue";
import { ElInput as x } from "element-plus";
import { B as j, T as N, q as S, C as k, E as A } from "../../../../../shared/runtime.js";
import { a as B } from "../../../../../modules/index-8356a01a.js";
const q = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(m) {
  const c = { name: "", serialNumber: "", specification: "", material: "", areaId: { value: void 0, resetAble: false } }, p = u(), f = u({}), o = u([]), d = u({}), { crud: i, query: a } = j(c), b = m;
  function v(s) {
    const { name: l, label: n } = s;
    f.value = { id: l, name: n }, i.toQuery();
  }
  function V(s) {
    console.log(o.value), o.value = s || [], o.value.length > 0 ? d.value = { id: o.value[0].id + "", name: o.value[0].name } : d.value = {};
  }
  return (s, l) => {
    const n = x;
    return y(), I("div", null, [g(w("div", null, [r(e(S), { ref_key: "monomerSelectRef", ref: p, modelValue: e(a).monomerId, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).monomerId = t), "project-id": b.projectId, class: "filter-item", productType: e(N).BRIDGE.V, "show-tips": o.value.length <= 0, onGetAreaInfo: V }, null, 8, ["modelValue", "project-id", "productType", "show-tips"]), r(e(B), { class: "filter-item", style: T(o.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(a).areaId, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).areaId = t), "area-info": o.value, "default-tab": d.value, onTabClick: v }, null, 8, ["style", "modelValue", "area-info", "default-tab"]), r(n, { modelValue: e(a).serialNumber, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(a).serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(n, { modelValue: e(a).specification, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(a).specification = t), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(n, { modelValue: e(a).material, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(a).material = t), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(e(k))], 512), [[h, e(i).searchToggle]]), r(e(A))]);
  };
} };
export {
  q as default
};
