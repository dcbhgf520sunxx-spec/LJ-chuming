import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { ElInput as u } from "element-plus";
import { B as m, C as f } from "../../../../../../../shared/runtime.js";
const p = { class: "head-container" }, _ = { __name: "header", setup(c) {
  const r = { artifactTypeId: void 0, material: void 0, name: void 0, serialNumber: void 0, specification: void 0 }, { query: l } = m(r);
  return (V, a) => {
    const d = u;
    return o(), s("div", p, [n("div", null, [i(d, { modelValue: e(l).name, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).name = t), modelModifiers: { trim: true }, placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), i(d, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(l).serialNumber = t), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), i(d, { modelValue: e(l).specification, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(l).specification = t), modelModifiers: { trim: true }, placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), i(d, { modelValue: e(l).material, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(l).material = t), modelModifiers: { trim: true }, placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), i(e(f))])]);
  };
} };
export {
  _ as default
};
