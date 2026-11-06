import { F as c } from "../shared/runtime.js";
import { ref as d } from "vue";
import { watchEffect as y } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as q } from "vue";
import { withKeys as i } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as _ } from "vue";
import { Fragment as h } from "vue";
import { ElInput as V } from "element-plus";
import { computed as v } from "vue";
import { resolveDynamicComponent as w } from "vue";
const M = { __name: "box", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, u = r, e = d({});
  y(() => {
    e.value = u.query;
  });
  function l() {
    s("to-query");
  }
  return (p, t) => {
    const a = V;
    return m(), b(h, null, [q(a, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.serialNumber = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(l, ["enter"]) }, null, 8, ["modelValue"]), q(a, { modelValue: e.value.specification, "onUpdate:modelValue": t[1] || (t[1] = (o) => e.value.specification = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(l, ["enter"]) }, null, 8, ["modelValue"]), r.showMaterial ? (m(), f(a, { key: 0, modelValue: e.value.material, "onUpdate:modelValue": t[2] || (t[2] = (o) => e.value.material = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(l, ["enter"]) }, null, 8, ["modelValue"])) : _("", true)], 64);
  };
} }, N = { __name: "element", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, u = r, e = d({});
  y(() => {
    e.value = u.query;
  });
  function l() {
    s("to-query");
  }
  return (p, t) => {
    const a = V;
    return m(), f(a, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.serialNumber = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入单元件号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(l, ["enter"]) }, null, 8, ["modelValue"]);
  };
} }, x = { __name: "machine-part", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, u = r, e = d({});
  y(() => {
    e.value = u.query;
  });
  function l() {
    s("to-query");
  }
  return (p, t) => {
    const a = V;
    return m(), f(a, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.serialNumber = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(l, ["enter"]) }, null, 8, ["modelValue"]);
  };
} }, B = { __name: "index", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, toQuery: { type: Function }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, u = r, e = v(() => {
    switch (u.productType) {
      case c.BOX.V:
        return M;
      case c.MACHINE_PART.V:
        return x;
      case c.AUXILIARY_MATERIAL.V:
        return null;
      case c.CELL.V:
        return N;
      default:
        return null;
    }
  }), l = d({});
  y(() => {
    l.value = u.query;
  });
  function p() {
    typeof u.toQuery == "function" && u.toQuery(), s("to-query");
  }
  return (t, a) => (m(), f(w(e.value), { query: r.query, "product-type": r.productType, onToQuery: p, showMaterial: r.showMaterial }, null, 40, ["query", "product-type", "showMaterial"]));
} };
export {
  B as _
};
