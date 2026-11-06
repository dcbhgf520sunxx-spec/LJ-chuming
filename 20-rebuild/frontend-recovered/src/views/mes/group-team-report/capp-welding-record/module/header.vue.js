import { ref as h } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as C } from "vue";
import { vShow as S } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as a } from "vue";
import { createBlock as w } from "vue";
import { createCommentVNode as A } from "vue";
import { ElInput as T } from "element-plus";
import { m as v, aa as t, B as g, C as I } from "../../../../../shared/runtime.js";
import { _ as M } from "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
const x = { class: "head-container" }, P = { __name: "header", setup(B) {
  const { globalProjectId: p } = v(["globalProjectId"]), c = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, productType: { value: t.ARTIFACT.V, resetAble: false }, productName: "", productSerialNumber: "", techCappCraftCardStorehouseSerialNumber: "", weldSerialNumber: "" }, f = h({}), { crud: u, query: l } = g(c);
  function V({ monomerId: m, areaId: o, data: s }) {
    f.value = s, l.monomerId = m, l.areaId = o, u.toQuery();
  }
  function b() {
    l.productName = "", u.toQuery();
  }
  return (m, o) => {
    var n;
    const s = N("common-radio-button"), d = T;
    return i(), y("div", x, [C(_("div", null, [a(e(M), { "project-id": e(p), onChange: V }, null, 8, ["project-id"]), a(s, { modelValue: e(l).productType, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(l).productType = r), options: e(t).ENUM, unshowVal: [e(t).MACHINE_PART.V], type: "enum", class: "filter-item", onChange: b }, null, 8, ["modelValue", "options", "unshowVal"]), a(d, { modelValue: e(l).weldSerialNumber, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(l).weldSerialNumber = r), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "焊缝编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), e(l).productType === e(t).ASSEMBLY.V ? (i(), w(d, { key: 0, modelValue: e(l).productName, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(l).productName = r), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "部件名称搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"])) : A("", true), a(d, { modelValue: e(l).productSerialNumber, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(l).productSerialNumber = r), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: `${(n = e(t).VL) == null ? void 0 : n[e(l).productType]}编号搜索`, size: "default", style: { width: "170px" } }, null, 8, ["modelValue", "placeholder"]), a(d, { modelValue: e(l).techCappCraftCardStorehouseSerialNumber, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(l).techCappCraftCardStorehouseSerialNumber = r), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "工艺编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(e(I))], 512), [[S, e(u).searchToggle]])]);
  };
} };
export {
  P as default
};
