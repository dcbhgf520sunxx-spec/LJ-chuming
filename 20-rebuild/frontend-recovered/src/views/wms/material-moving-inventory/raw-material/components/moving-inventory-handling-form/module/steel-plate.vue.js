import { ref as p } from "vue";
import { computed as _ } from "vue";
import { provide as x } from "vue";
import { watch as C } from "vue";
import { unref as s } from "vue";
import { openBlock as U } from "vue";
import { createBlock as q } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as B } from "vue";
import { ElFormItem as V } from "element-plus";
import { ElForm as W } from "element-plus";
import { c as P } from "../../../../../../../modules/application-0ee072a2.js";
import { _ as N, sQ as Q, bC as $, V as j, x_ as z, b as E } from "../../../../../../../shared/runtime.js";
import S from "../components/common-form-item.vue.js";
import A from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const D = { class: "material-info" }, O = { class: "form-info" }, K = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(b, { expose: h }) {
  const c = b, y = { directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: (a, e, o) => {
    if (E(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > m.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, i = p(), r = p({ quantity: void 0 }), t = _(() => c.material || {}), { loaded: g, baseUnit: d } = Q(c.basicClass);
  $(i, r, ["quantity", "halfSize"]);
  const m = _(() => !r.value || !r.value.projectId || !t.value.projectFrozenForUnitKV ? t.value.corOperableQuantity : t.value.corOperableQuantity + (t.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  x("maxQuantity", m), C(t, (a) => {
    I(a);
  }, { immediate: true, deep: true });
  function I(a) {
    const e = { directionWarehouseId: void 0, directionWorkshopId: void 0, materialId: a.id, basicClass: a.basicClass, boolPartyA: a.boolPartyA, outboundUnit: a.outboundUnit, outboundUnitPrecision: a.outboundUnitPrecision, quantity: void 0, remark: void 0 };
    r.value = e;
  }
  async function w() {
    if (!await i.value.validate()) return false;
    const e = j(r.value);
    await z(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true });
    const o = { directionWarehouseId: e.directionWarehouseId, directionWorkshopId: e.directionWorkshopId, basicClass: e.basicClass, detailList: [{ materialId: e.materialId, quantity: e.quantity, remark: e.remark }] };
    return await P(o);
  }
  function k() {
    i.value && i.value.resetFields();
  }
  function F() {
    i.value && i.value.clearValidate();
  }
  return h({ submit: w, resetForm: k, clearValidate: F }), (a, e) => {
    const o = V, f = W;
    return s(g) ? (U(), q(f, { key: 0, ref_key: "formRef", ref: i, model: r.value, rules: y, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: n(() => [u("div", D, [l(A, { form: r.value, material: t.value }, { afterSpec: n(() => [l(o, { label: "厚 * 宽 * 长" }, { default: n(() => [u("span", null, v(`${t.value.thickness}${s(d).thickness.unit} * ${t.value.width}${s(d).width.unit} * ${t.value.length}${s(d).length.unit}`), 1)]), _: 1 })]), afterBrand: n(() => [l(o, { label: "炉批号/卷号" }, { default: n(() => [u("span", null, v(t.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), u("div", O, [l(S, { form: r.value, material: t.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : B("", true);
  };
} }, X = N(K, [["__scopeId", "data-v-8cb336d3"]]);
export {
  X as default
};
