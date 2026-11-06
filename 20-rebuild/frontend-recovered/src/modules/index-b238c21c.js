import { kA as _, a3 as c } from "../shared/runtime.js";
import { ref as y } from "vue";
import { watchEffect as d } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as V } from "vue";
import { withKeys as i } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as w } from "vue";
import { Fragment as h } from "vue";
import { ElInput as b } from "element-plus";
import { computed as M } from "vue";
import { resolveDynamicComponent as x } from "vue";
const T = { __name: "artifact", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, category: { type: Number }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, o = r, e = y({});
  d(() => {
    e.value = o.query;
  });
  function a() {
    s("to-query");
  }
  return (p, t) => {
    const l = b;
    return m(), N(h, null, [V(l, { modelValue: e.value.name, "onUpdate:modelValue": t[0] || (t[0] = (u) => e.value.name = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]), V(l, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[1] || (t[1] = (u) => e.value.serialNumber = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]), V(l, { modelValue: e.value.specification, "onUpdate:modelValue": t[2] || (t[2] = (u) => e.value.specification = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]), r.showMaterial ? (m(), f(l, { key: 0, modelValue: e.value.material, "onUpdate:modelValue": t[3] || (t[3] = (u) => e.value.material = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"])) : w("", true)], 64);
  };
} }, A = { __name: "assemble", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, category: { type: Number }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, o = r, e = y({});
  d(() => {
    e.value = o.query;
  });
  function a() {
    s("to-query");
  }
  return (p, t) => {
    const l = b;
    return m(), f(l, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (u) => e.value.serialNumber = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入部件号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]);
  };
} }, E = { __name: "enclosure", props: { productType: { type: Number }, category: { type: Number }, query: { type: Object, default: () => ({}) }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, o = r, e = y({});
  d(() => {
    e.value = o.query;
  });
  function a() {
    s("to-query");
  }
  const p = M(() => _.SANDWICH_BOARD.V);
  return (t, l) => {
    const u = b;
    return m(), N(h, null, [V(u, { modelValue: e.value.name, "onUpdate:modelValue": l[0] || (l[0] = (q) => e.value.name = q), modelModifiers: { trim: true }, size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]), p.value & r.category ? w("", true) : (m(), f(u, { key: 0, modelValue: e.value.serialNumber, "onUpdate:modelValue": l[1] || (l[1] = (q) => e.value.serialNumber = q), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]))], 64);
  };
} }, v = { __name: "machine-part", props: { productType: { type: Number }, query: { type: Object, default: () => ({}) }, category: { type: Number }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, o = r, e = y({});
  d(() => {
    e.value = o.query;
  });
  function a() {
    s("to-query");
  }
  return (p, t) => {
    const l = b;
    return m(), f(l, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (u) => e.value.serialNumber = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: i(a, ["enter"]) }, null, 8, ["modelValue"]);
  };
} }, B = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, query: { type: Object, default: () => ({}) }, toQuery: { type: Function }, showMaterial: { type: Boolean, default: true } }, emits: ["to-query"], setup(r, { emit: n }) {
  const s = n, o = r, e = M(() => {
    switch (o.productType) {
      case c.ARTIFACT.V:
        return T;
      case c.MACHINE_PART.V:
        return v;
      case c.ENCLOSURE.V:
        return E;
      case c.AUXILIARY_MATERIAL.V:
        return null;
      case c.ASSEMBLE.V:
        return A;
      default:
        return v;
    }
  }), a = y({});
  d(() => {
    a.value = o.query;
  });
  function p() {
    typeof o.toQuery == "function" && o.toQuery(), s("to-query");
  }
  return (t, l) => (m(), f(x(e.value), { query: r.query, "product-type": r.productType, category: r.category, onToQuery: p, showMaterial: r.showMaterial }, null, 40, ["query", "product-type", "category", "showMaterial"]));
} };
export {
  B as _
};
