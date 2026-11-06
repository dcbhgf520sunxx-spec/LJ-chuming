import { ref as E } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as y } from "vue";
import { withKeys as u } from "vue";
import { withCtx as b } from "vue";
import { renderSlot as w } from "vue";
import { Fragment as R } from "vue";
import { ElInput as v } from "element-plus";
import { a as x } from "../../../../../../modules/enclosure-6f8adfb8.js";
import { _ as K } from "../../../../../../modules/project-select-94bb5bbd.js";
import { _ as N, kG as i, B as j, kJ as p, C as A, E as Q } from "../../../../../../shared/runtime.js";
const k = { class: "filter" }, L = { __name: "header", setup(S) {
  const V = { projectId: void 0, type: i.STRUCTURE.V, areaId: void 0, material: void 0, monomerId: void 0, name: void 0, serialNumber: void 0, specification: void 0 }, { crud: n, query: t } = j(V), _ = E([]);
  function I(a) {
    a && (C(), n.toQuery());
  }
  function U(a) {
    a === i.AUXILIARY_MATERIAL.V ? t.relationType = p.STRUCTURE.V : t.relationType = void 0, n.toQuery();
  }
  function h(a) {
    a === p.ENCLOSURE.V && (t.monomerId = void 0, t.areaId = void 0), n.toQuery();
  }
  async function C() {
    try {
      const a = await x({ projectId: t.projectId });
      _.value = a;
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  return (a, o) => {
    const m = T("common-radio-button"), d = v;
    return s(), g(R, null, [f("div", null, [f("div", k, [r(e(K), { modelValue: e(t).projectId, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).projectId = l), class: "filter-item", style: { width: "450px" }, clearable: "", placeholder: "可选择项目搜索", onChange: I }, null, 8, ["modelValue"]), e(t).projectId ? (s(), c(m, { key: 0, modelValue: e(t).type, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).type = l), options: e(i).ENUM, class: "filter-item", type: "enum", onChange: U }, null, 8, ["modelValue", "options"])) : y("", true), e(t).type === e(i).AUXILIARY_MATERIAL.V && e(t).projectId ? (s(), c(m, { key: 1, modelValue: e(t).relationType, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).relationType = l), options: e(p).ENUM, type: "enum", size: "default", class: "filter-item", onChange: h }, null, 8, ["modelValue", "options"])) : y("", true)]), r(d, { modelValue: e(t).name, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(t).name = l), placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(d, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[4] || (o[4] = (l) => e(t).serialNumber = l), placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(d, { modelValue: e(t).specification, "onUpdate:modelValue": o[5] || (o[5] = (l) => e(t).specification = l), placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(d, { modelValue: e(t).material, "onUpdate:modelValue": o[6] || (o[6] = (l) => e(t).material = l), placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(A))]), r(e(Q), null, { viewLeft: b(() => [w(a.$slots, "viewLeft", {}, void 0, true)]), _: 3 })], 64);
  };
} }, H = N(L, [["__scopeId", "data-v-c191c6f6"]]);
export {
  H as default
};
