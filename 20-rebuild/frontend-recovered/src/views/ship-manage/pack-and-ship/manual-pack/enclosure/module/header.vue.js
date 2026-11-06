import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as y } from "vue";
import { withDirectives as f } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withKeys as r } from "vue";
import { vShow as V } from "vue";
import { ElInput as c } from "element-plus";
import { ElInputNumber as x } from "element-plus";
import { B as b, C as h, E as K } from "../../../../../../shared/runtime.js";
const Q = { __name: "header", setup(g) {
  const s = { name: void 0, minLength: void 0, maxLength: void 0, serialNumber: void 0, plate: void 0, material: void 0 }, { crud: o, query: l } = b(s);
  return (v, t) => {
    const u = c, m = x;
    return d(), p(e(K), null, { optLeft: y(() => [f(i("div", null, [n(u, { modelValue: e(l).name, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).name = a), size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(u, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(u, { modelValue: e(l).plate, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).plate = a), size: "default", placeholder: "输入板型搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(u, { modelValue: e(l).material, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(l).material = a), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(l).minLength, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(l).minLength = a), modelModifiers: { number: true }, min: 0, max: e(l).maxLength || 999999999, precision: 0, controls: false, size: "default", style: { width: "130px" }, class: "filter-item", clearable: "", placeholder: "最小长度(mm)", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "max", "onKeyup"]), t[6] || (t[6] = i("span", { class: "filter-item" }, "~", -1)), n(m, { modelValue: e(l).maxLength, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(l).maxLength = a), modelModifiers: { number: true }, class: "filter-item", min: e(l).minLength || 0, precision: 0, max: 999999999, controls: false, size: "default", style: { width: "130px" }, clearable: "", placeholder: "最大长度(mm)", onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "min", "onKeyup"]), n(e(h))], 512), [[V, e(o).searchToggle]])]), _: 1 });
  };
} };
export {
  Q as default
};
