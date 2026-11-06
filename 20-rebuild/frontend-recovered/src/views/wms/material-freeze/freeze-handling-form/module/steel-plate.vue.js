import { ref as p } from "vue";
import { computed as d } from "vue";
import { provide as V } from "vue";
import { watch as C } from "vue";
import { unref as s } from "vue";
import { openBlock as I } from "vue";
import { createBlock as N } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as Q } from "vue";
import { ElFormItem as $ } from "element-plus";
import { ElForm as k } from "element-plus";
import { d as q } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as z, sQ as P, bC as j, V as E, x_ as S, b as D } from "../../../../../shared/runtime.js";
import O from "../components/common-form-item.vue.js";
import A from "../components/common-material-info.vue.js";
const K = { class: "material-info" }, M = { class: "form-info" }, R = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(v, { expose: b }) {
  const c = v, y = { quantity: [{ required: true, validator: (r, t, o) => {
    if (D(t)) return o(new Error("请填写数量"));
    if (t <= 0) return o(new Error("数量必须大于0"));
    if (t > f.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, n = p(), a = p({ quantity: void 0 }), e = d(() => c.material || {}), { loaded: h, baseUnit: m } = P(c.basicClass);
  j(n, a, ["quantity", "halfSize"]);
  const f = d(() => !a.value || !a.value.projectId || !e.value.projectFrozenForUnitKV ? e.value.corOperableQuantity : e.value.corOperableQuantity + (e.value.projectFrozenForUnitKV[a.value.projectId] || 0));
  V("maxQuantity", f), C(e, (r) => {
    w(r);
  }, { immediate: true, deep: true });
  function w(r) {
    const t = { materialId: r.id, quantity: void 0, remark: void 0, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision };
    a.value = t;
  }
  const F = d(() => q);
  async function x() {
    if (!await n.value.validate()) return false;
    const t = E(a.value);
    return await S(t, { unit: t.outboundUnit, precision: t.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await F.value(t);
  }
  function U() {
    n.value && n.value.resetFields();
  }
  function g() {
    n.value && n.value.clearValidate();
  }
  return b({ submit: x, resetForm: U, clearValidate: g }), (r, t) => {
    const o = $, B = k;
    return s(h) ? (I(), N(B, { key: 0, ref_key: "formRef", ref: n, model: a.value, rules: y, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: i(() => [u("div", K, [l(A, { form: a.value, material: e.value }, { afterSpec: i(() => [l(o, { label: "厚 * 宽 * 长" }, { default: i(() => [u("span", null, _(`${e.value.thickness}${s(m).thickness.unit} * ${e.value.width}${s(m).width.unit} * ${e.value.length}${s(m).length.unit}`), 1)]), _: 1 })]), afterBrand: i(() => [l(o, { label: "炉批号/卷号" }, { default: i(() => [u("span", null, _(e.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), u("div", M, [l(O, { form: a.value, material: e.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : Q("", true);
  };
} }, X = z(R, [["__scopeId", "data-v-dba20178"]]);
export {
  X as default
};
