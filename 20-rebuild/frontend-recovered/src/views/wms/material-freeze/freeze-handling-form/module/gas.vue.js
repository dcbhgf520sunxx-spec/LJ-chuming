import { ref as u } from "vue";
import { computed as n } from "vue";
import { provide as F } from "vue";
import { watch as w } from "vue";
import { openBlock as x } from "vue";
import { createBlock as U } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as m } from "vue";
import { ElForm as V } from "element-plus";
import { i as q } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as B, m as I, bC as Q, V as j, x_ as z, b as C } from "../../../../../shared/runtime.js";
import E from "../components/common-form-item.vue.js";
import N from "../components/common-material-info.vue.js";
const k = { class: "material-info" }, O = { class: "form-info" }, P = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object } }, setup(c, { expose: d }) {
  const f = c, p = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: (a, e, o) => {
    if (C(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > s.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, i = u(), t = u({});
  I("user");
  const r = n(() => f.material || {});
  Q(i, t, ["quantity"]);
  const s = n(() => !t.value || !t.value.projectId || !r.value.projectFrozenForUnitKV ? r.value.corOperableQuantity : r.value.corOperableQuantity + (r.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  F("maxQuantity", s), w(r, (a) => {
    _(a);
  }, { immediate: true });
  function _(a) {
    const e = { materialId: a.id, quantity: void 0, remark: void 0, outboundUnit: a.outboundUnit, outboundUnitPrecision: a.outboundUnitPrecision };
    t.value = e;
  }
  const v = n(() => q);
  async function b() {
    if (!await i.value.validate()) return false;
    const e = j(t.value);
    return await z(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await v.value(e);
  }
  function y() {
    i.value.resetFields();
  }
  function g() {
    i.value && i.value.clearValidate();
  }
  return d({ submit: b, resetForm: y, clearValidate: g }), (a, e) => {
    const o = V;
    return x(), U(o, { ref_key: "formRef", ref: i, model: t.value, rules: p, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: h(() => [l("div", k, [m(N, { form: t.value, material: r.value }, null, 8, ["form", "material"])]), l("div", O, [m(E, { form: t.value, material: r.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"]);
  };
} }, S = B(P, [["__scopeId", "data-v-c5a66124"]]);
export {
  S as default
};
