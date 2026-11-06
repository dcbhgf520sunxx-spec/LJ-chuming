import { ref as s } from "vue";
import { computed as u } from "vue";
import { provide as g } from "vue";
import { watch as I } from "vue";
import { openBlock as h } from "vue";
import { createBlock as w } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as d } from "vue";
import { ElForm as F } from "element-plus";
import { g as k } from "../../../../../../../modules/application-0ee072a2.js";
import { _ as q, bC as U, V as W, x_ as C, b as V } from "../../../../../../../shared/runtime.js";
import B from "../components/common-form-item.vue.js";
import Q from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const j = { class: "material-info" }, P = { class: "form-info" }, E = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object } }, setup(m, { expose: c }) {
  const f = m, p = { directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: (t, e, a) => {
    if (V(e)) return a(new Error("请填写数量"));
    if (e <= 0) return a(new Error("数量必须大于0"));
    if (e > n.value) return a(new Error("数量不可超过可操作数量"));
    a();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, i = s(), r = s({}), o = u(() => f.material || {});
  U(i, r, ["quantity"]);
  const n = u(() => !r.value || !r.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  g("maxQuantity", n), I(o, (t) => {
    _(t);
  }, { immediate: true });
  function _(t) {
    const e = { directionWarehouseId: void 0, directionWorkshopId: void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, materialId: t.id, basicClass: t.basicClass, boolPartyA: t.boolPartyA, quantity: void 0, remark: void 0 };
    r.value = e;
  }
  async function v() {
    if (!await i.value.validate()) return false;
    const e = W(r.value);
    await C(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true });
    const a = { directionWarehouseId: e.directionWarehouseId, directionWorkshopId: e.directionWorkshopId, basicClass: e.basicClass, detailList: [{ materialId: e.materialId, quantity: e.quantity, remark: e.remark }] };
    return await k(a);
  }
  function b() {
    i.value.resetFields();
  }
  function y() {
    i.value && i.value.clearValidate();
  }
  return c({ submit: v, resetForm: b, clearValidate: y }), (t, e) => {
    const a = F;
    return h(), w(a, { ref_key: "formRef", ref: i, model: r.value, rules: p, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: x(() => [l("div", j, [d(Q, { form: r.value, material: o.value }, null, 8, ["form", "material"])]), l("div", P, [d(B, { form: r.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"]);
  };
} }, L = q(E, [["__scopeId", "data-v-42865d03"]]);
export {
  L as default
};
