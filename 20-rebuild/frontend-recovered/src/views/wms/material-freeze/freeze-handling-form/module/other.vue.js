import { ref as u } from "vue";
import { computed as s } from "vue";
import { provide as x } from "vue";
import { watch as F } from "vue";
import { openBlock as w } from "vue";
import { createBlock as q } from "vue";
import { withCtx as U } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as d } from "vue";
import { ElForm as j } from "element-plus";
import { j as I } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as V, bC as B, b as Q, V as k, x_ as z } from "../../../../../shared/runtime.js";
import C from "../components/common-form-item.vue.js";
import E from "../components/common-material-info.vue.js";
const N = { class: "material-info" }, O = { class: "form-info" }, P = { __name: "other", props: { basicClass: { type: Number }, material: { type: Object } }, setup(f, { expose: p }) {
  const v = f, l = (r, e, o) => {
    if (Q(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > m.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, n = u({ quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }), i = u(), t = u({}), a = s(() => v.material || {});
  B(i, t, ["quantity"]);
  const m = s(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  x("maxQuantity", m), F(a, (r) => {
    _(r);
  }, { immediate: true });
  function _(r) {
    const e = { materialId: r.id, quantity: void 0, remark: void 0, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision };
    t.value = e, n.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, e.projectId && (n.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  const b = s(() => I);
  async function g() {
    if (!await i.value.validate()) return false;
    const e = k(t.value);
    return await z(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await b.value(e);
  }
  function y() {
    i.value.resetFields();
  }
  function h() {
    i.value && i.value.clearValidate();
  }
  return p({ submit: g, resetForm: y, clearValidate: h }), (r, e) => {
    const o = j;
    return w(), q(o, { ref_key: "formRef", ref: i, model: t.value, rules: n.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: U(() => [c("div", N, [d(E, { form: t.value, material: a.value }, null, 8, ["form", "material"])]), c("div", O, [d(C, { form: t.value, material: a.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, S = V(P, [["__scopeId", "data-v-64ad5268"]]);
export {
  S as default
};
