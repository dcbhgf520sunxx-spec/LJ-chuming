import { ref as V } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as y } from "vue";
import { vShow as I } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as a } from "vue";
import { createBlock as N } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as S } from "vue";
import { createTextVNode as x } from "vue";
import { ElInput as B } from "element-plus";
import { m as z, oG as n, aa as i, B as D, tF as j, C as k, E as G } from "../../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import L from "./bind.vue.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
import "../../../../../../modules/craft-library-fde84566.js";
import "./preview.vue.js";
const P = { class: "head-container" }, X = { __name: "header", setup(_) {
  const { globalProjectId: p } = z(["globalProjectId"]), v = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, isBind: { value: void 0, resetAble: false }, craftType: { value: n.WELDING.V, resetAble: false }, productType: { value: i.ARTIFACT.V, resetAble: false }, productDwgNum: "", productMaterial: "", productName: "", productSerialNumber: "", productSpecification: "", techCappCraftCardStorehouseSerialNumber: "", weldSerialNumber: "" }, s = V(false), w = V({}), { crud: r, query: o } = D(v);
  function T({ monomerId: f, areaId: l, data: u }) {
    w.value = u, o.monomerId = f, o.areaId = l, r.toQuery();
  }
  function g() {
    o.productName = "", r.toQuery();
  }
  return (f, l) => {
    var c;
    const u = b("common-radio-button"), d = B, M = b("common-button"), A = U("permission");
    return m(), h("div", P, [y(C("div", null, [a(e(Q), { "project-id": e(p), onChange: T }, null, 8, ["project-id"]), a(u, { modelValue: e(o).productType, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(o).productType = t), options: e(i).ENUM, unshowVal: [e(i).MACHINE_PART.V], type: "enum", class: "filter-item", onChange: g }, null, 8, ["modelValue", "options", "unshowVal"]), a(u, { modelValue: e(o).isBind, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(o).isBind = t), options: e(j).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(u, { modelValue: e(o).craftType, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(o).craftType = t), options: e(n).ENUM, disabledVal: [e(n).CUTTING.V, e(n).COATING.V], type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"]), e(o).productType === e(i).ASSEMBLY.V ? (m(), N(d, { key: 0, modelValue: e(o).productName, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(o).productName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "部件名称搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"])) : E("", true), a(d, { modelValue: e(o).productSerialNumber, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(o).productSerialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: `${(c = e(i).VL) == null ? void 0 : c[e(o).productType]}编号搜索`, size: "default", style: { width: "170px" } }, null, 8, ["modelValue", "placeholder"]), a(d, { modelValue: e(o).productSpecification, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(o).productSpecification = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(d, { modelValue: e(o).productMaterial, "onUpdate:modelValue": l[6] || (l[6] = (t) => e(o).productMaterial = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "材质搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), l[12] || (l[12] = C("br", null, null, -1)), a(d, { modelValue: e(o).weldSerialNumber, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(o).weldSerialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "焊缝编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(d, { modelValue: e(o).techCappCraftCardStorehouseSerialNumber, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(o).techCappCraftCardStorehouseSerialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "工艺编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(d, { modelValue: e(o).productDwgNum, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(o).productDwgNum = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "图号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(e(k))], 512), [[I, e(r).searchToggle]]), a(e(G), null, { optLeft: S(() => [y((m(), N(M, { size: "default", type: "primary", onClick: l[10] || (l[10] = (t) => s.value = true) }, { default: S(() => l[13] || (l[13] = [x(" 绑定工艺卡 ")])), _: 1, __: [13] })), [[A, e(r).permission.bind]])]), _: 1 }), a(e(L), { modelValue: s.value, "onUpdate:modelValue": l[11] || (l[11] = (t) => s.value = t), param: { ...e(o), projectId: e(p) }, onSuccess: e(r).refresh }, null, 8, ["modelValue", "param", "onSuccess"])]);
  };
} };
export {
  X as default
};
