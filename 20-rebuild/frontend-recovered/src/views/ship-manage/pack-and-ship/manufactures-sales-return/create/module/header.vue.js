import { computed as f } from "vue";
import { ref as A } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { createCommentVNode as d } from "vue";
import { Fragment as L } from "vue";
import { withKeys as V } from "vue";
import { ElInput as j } from "element-plus";
import { a as Q } from "../../../../../../modules/enclosure-6f8adfb8.js";
import { _ as M } from "../../../../../../modules/project-select-94bb5bbd.js";
import { _ as K, kG as r, ug as S, kJ as i, B as z, q as B, C as X } from "../../../../../../shared/runtime.js";
const Y = { class: "filter" }, O = { __name: "header", setup($) {
  const g = { projectId: void 0, type: r.STRUCTURE.V, status: S.SHIPMENT.V, areaId: void 0, material: void 0, monomerId: void 0, name: void 0, serialNumber: void 0, specification: void 0 }, h = f(() => t.type === r.ENCLOSURE.V), p = f(() => t.type === r.STRUCTURE.V), m = f(() => t.type === r.AUXILIARY_MATERIAL.V && t.relationType === i.STRUCTURE.V), U = f(() => t.type === r.AUXILIARY_MATERIAL.V && t.relationType === i.ENCLOSURE.V), { crud: n, query: t } = z(g), E = A([]), v = A([]);
  function _(a) {
    E.value = a || [];
  }
  function b(a) {
    a && (w(), n.toQuery());
  }
  function k(a) {
    a === r.AUXILIARY_MATERIAL.V && (t.relationType = i.STRUCTURE.V), n.toQuery();
  }
  function N(a) {
    a === i.ENCLOSURE.V && (t.monomerId = void 0, t.areaId = void 0), n.toQuery();
  }
  async function w() {
    try {
      const a = await Q({ projectId: t.projectId });
      v.value = a;
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  return (a, l) => {
    const I = C("common-radio-button"), R = C("common-select"), y = j;
    return u(), T("div", null, [x("div", Y, [c(e(M), { modelValue: e(t).projectId, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).projectId = o), class: "filter-item", style: { width: "450px" }, placeholder: "可选择项目搜索", onChange: b }, null, 8, ["modelValue"]), e(t).projectId ? (u(), s(I, { key: 0, modelValue: e(t).type, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).type = o), options: e(r).ENUM, disabledVal: [e(r).ENCLOSURE.V, e(r).AUXILIARY_MATERIAL.V], class: "filter-item", type: "enum", onChange: k }, null, 8, ["modelValue", "options", "disabledVal"])) : d("", true), e(t).type === e(r).AUXILIARY_MATERIAL.V && e(t).projectId ? (u(), s(I, { key: 1, modelValue: e(t).relationType, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).relationType = o), options: e(i).ENUM, type: "enum", size: "default", class: "filter-item", onChange: N }, null, 8, ["modelValue", "options"])) : d("", true), e(t).projectId ? (u(), s(I, { key: 2, modelValue: e(t).status, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).status = o), options: e(S).ENUM, class: "filter-item", type: "enum", onChange: l[4] || (l[4] = (o) => e(n).toQuery()) }, null, 8, ["modelValue", "options"])) : d("", true)]), e(t).projectId ? (u(), T(L, { key: 0 }, [p.value || m.value ? (u(), s(e(B), { key: 0, ref: "monomerRef", modelValue: e(t).monomerId, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).monomerId = o), "project-id": e(t).projectId, placeholder: "可选择单体", clearable: "", default: false, class: "filter-item", style: { width: "200px" }, onGetAreaInfo: _, onChange: l[6] || (l[6] = (o) => e(t).monomerId && e(n).toQuery()) }, null, 8, ["modelValue", "project-id"])) : d("", true), h.value || U.value ? (u(), s(R, { key: 1, modelValue: e(t).planId, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(t).planId = o), options: v.value, type: "other", dataStructure: { key: "planId", label: "planName", value: "planId" }, size: "default", clearable: "", placeholder: "请选择计划", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : d("", true), p.value || m.value ? (u(), s(R, { key: 2, modelValue: e(t).areaId, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(t).areaId = o), options: E.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : d("", true), c(y, { modelValue: e(t).name, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(t).name = o), placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: V(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), c(y, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[10] || (l[10] = (o) => e(t).serialNumber = o), placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: V(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), p.value || m.value || U.value ? (u(), s(y, { key: 3, modelValue: e(t).specification, "onUpdate:modelValue": l[11] || (l[11] = (o) => e(t).specification = o), placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: V(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])) : d("", true), p.value || m.value ? (u(), s(y, { key: 4, modelValue: e(t).material, "onUpdate:modelValue": l[12] || (l[12] = (o) => e(t).material = o), placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: V(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])) : d("", true), c(e(X))], 64)) : d("", true)]);
  };
} }, D = K(O, [["__scopeId", "data-v-cfeda4c2"]]);
export {
  D as default
};
