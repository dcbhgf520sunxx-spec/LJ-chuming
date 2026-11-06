import { ref as d } from "vue";
import { computed as l } from "vue";
import { provide as V } from "vue";
import { watch as C } from "vue";
import { unref as f } from "vue";
import { openBlock as I } from "vue";
import { createBlock as N } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as Q } from "vue";
import { ElFormItem as S } from "element-plus";
import { ElForm as z } from "element-plus";
import { e as j } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as q, sQ as E, bC as k, V as D, x_ as O, b as P } from "../../../../../shared/runtime.js";
import $ from "../components/common-form-item.vue.js";
import A from "../components/common-material-info.vue.js";
const K = { class: "material-info" }, M = { class: "form-info" }, R = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(_, { expose: v }) {
  const m = _, b = { quantity: [{ required: true, validator: (r, e, o) => {
    if (P(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > c.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, n = d(), t = d({}), a = l(() => m.material || {}), { loaded: y, baseUnit: F } = E(m.basicClass);
  k(n, t, ["quantity", "halfSize"]);
  const c = l(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  V("maxQuantity", c), C(a, (r) => {
    h(r);
  }, { immediate: true, deep: true });
  function h(r) {
    const e = { materialId: r.id, quantity: void 0, remark: void 0, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision };
    t.value = e;
  }
  const w = l(() => j);
  async function x() {
    if (!await n.value.validate()) return false;
    const e = D(t.value);
    return await O(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await w.value(e);
  }
  function U() {
    n.value.resetFields();
  }
  function g() {
    n.value && n.value.clearValidate();
  }
  return v({ submit: x, resetForm: U, clearValidate: g }), (r, e) => {
    const o = S, B = z;
    return f(y) ? (I(), N(B, { key: 0, ref_key: "formRef", ref: n, model: t.value, rules: b, class: "form", "label-position": "left", "label-width": "130px", size: "default" }, { default: i(() => [s("div", K, [u(A, { form: t.value, material: a.value }, { afterSpec: i(() => [u(o, { label: "定尺长度" }, { default: i(() => [s("span", null, p(`${a.value.length}${f(F).length.unit}`), 1)]), _: 1 })]), afterBrand: i(() => [u(o, { label: "炉批号/卷号" }, { default: i(() => [s("span", null, p(a.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), s("div", M, [u($, { form: t.value, material: a.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : Q("", true);
  };
} }, X = q(R, [["__scopeId", "data-v-ed7aa390"]]);
export {
  X as default
};
