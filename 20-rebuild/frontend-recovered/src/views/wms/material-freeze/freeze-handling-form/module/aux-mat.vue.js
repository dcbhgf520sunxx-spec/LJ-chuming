import { ref as n } from "vue";
import { computed as u } from "vue";
import { provide as F } from "vue";
import { watch as w } from "vue";
import { openBlock as U } from "vue";
import { createBlock as h } from "vue";
import { withCtx as V } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as f } from "vue";
import { ElForm as q } from "element-plus";
import { h as B } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as I, bC as j, b as Q, V as k, x_ as z } from "../../../../../shared/runtime.js";
import C from "../components/common-form-item.vue.js";
import E from "../components/common-material-info.vue.js";
const M = { class: "material-info" }, N = { class: "form-info" }, O = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object } }, setup(d, { expose: p }) {
  const v = d, s = (a, e, o) => {
    if (Q(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > m.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, l = n({ quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }), i = n(), t = n({}), r = u(() => v.material || {});
  j(i, t, ["quantity"]);
  const m = u(() => !t.value || !t.value.projectId || !r.value.projectFrozenForUnitKV ? r.value.corOperableQuantity : r.value.corOperableQuantity + (r.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  F("maxQuantity", m), w(r, (a) => {
    _(a);
  }, { immediate: true });
  function _(a) {
    const e = { materialId: a.id, quantity: void 0, remark: void 0, outboundUnit: a.outboundUnit, outboundUnitPrecision: a.outboundUnitPrecision };
    t.value = e, l.value = { quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] };
  }
  const b = u(() => B);
  async function y() {
    if (!await i.value.validate()) return false;
    const e = k(t.value);
    return await z(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await b.value(e);
  }
  function x() {
    i.value.resetFields();
  }
  function g() {
    i.value && i.value.clearValidate();
  }
  return p({ submit: y, resetForm: x, clearValidate: g }), (a, e) => {
    const o = q;
    return U(), h(o, { ref_key: "formRef", ref: i, model: t.value, rules: l.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: V(() => [c("div", M, [f(E, { form: t.value, material: r.value }, null, 8, ["form", "material"])]), c("div", N, [f(C, { form: t.value, material: r.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, S = I(O, [["__scopeId", "data-v-3aff2794"]]);
export {
  S as default
};
