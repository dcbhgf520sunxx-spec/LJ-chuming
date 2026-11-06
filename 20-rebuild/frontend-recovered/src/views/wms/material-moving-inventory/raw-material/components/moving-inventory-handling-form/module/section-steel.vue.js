import { ref as m } from "vue";
import { computed as f } from "vue";
import { provide as C } from "vue";
import { watch as U } from "vue";
import { unref as p } from "vue";
import { openBlock as k } from "vue";
import { createBlock as q } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as u } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as B } from "vue";
import { ElFormItem as V } from "element-plus";
import { ElForm as W } from "element-plus";
import { b as N } from "../../../../../../../modules/application-0ee072a2.js";
import { _ as Q, sQ as S, bC as j, V as z, x_ as E, b as P } from "../../../../../../../shared/runtime.js";
import A from "../components/common-form-item.vue.js";
import D from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const O = { class: "material-info" }, $ = { class: "form-info" }, K = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(v, { expose: b }) {
  const l = v, y = { directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: (t, e, o) => {
    if (P(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > d.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, i = m(), a = m({}), r = f(() => l.material || {}), { loaded: h, baseUnit: g } = S(l.basicClass);
  j(i, a, ["quantity", "halfSize"]);
  const d = f(() => !a.value || !a.value.projectId || !r.value.projectFrozenForUnitKV ? r.value.corOperableQuantity : r.value.corOperableQuantity + (r.value.projectFrozenForUnitKV[a.value.projectId] || 0));
  C("maxQuantity", d), U(r, (t) => {
    I(t);
  }, { immediate: true, deep: true });
  function I(t) {
    const e = { directionWarehouseId: void 0, directionWorkshopId: void 0, materialId: t.id, basicClass: t.basicClass, boolPartyA: t.boolPartyA, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, quantity: void 0, remark: void 0 };
    a.value = e;
  }
  async function F() {
    if (!await i.value.validate()) return false;
    const e = z(a.value);
    await E(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true });
    const o = { directionWarehouseId: e.directionWarehouseId, directionWorkshopId: e.directionWorkshopId, basicClass: e.basicClass, detailList: [{ materialId: e.materialId, quantity: e.quantity, remark: e.remark }] };
    return await N(o);
  }
  function w() {
    i.value.resetFields();
  }
  function x() {
    i.value && i.value.clearValidate();
  }
  return b({ submit: F, resetForm: w, clearValidate: x }), (t, e) => {
    const o = V, c = W;
    return p(h) ? (k(), q(c, { key: 0, ref_key: "formRef", ref: i, model: a.value, rules: y, class: "form", "label-position": "left", "label-width": "130px", size: "default" }, { default: n(() => [s("div", O, [u(D, { form: a.value, material: r.value }, { afterSpec: n(() => [u(o, { label: "定尺长度" }, { default: n(() => [s("span", null, _(`${r.value.length}${p(g).length.unit}`), 1)]), _: 1 })]), afterBrand: n(() => [u(o, { label: "炉批号/卷号" }, { default: n(() => [s("span", null, _(r.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), s("div", $, [u(A, { form: a.value, material: r.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : B("", true);
  };
} }, X = Q(K, [["__scopeId", "data-v-c863c675"]]);
export {
  X as default
};
