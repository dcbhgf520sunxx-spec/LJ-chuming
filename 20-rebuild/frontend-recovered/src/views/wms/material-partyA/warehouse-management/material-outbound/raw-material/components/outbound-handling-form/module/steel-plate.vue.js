import { computed as f } from "vue";
import { ref as E } from "vue";
import { provide as A } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as M } from "vue";
import { unref as u } from "vue";
import { openBlock as g } from "vue";
import { createBlock as S } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as q } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as $ } from "vue";
import { ElFormItem as D } from "element-plus";
import { ElForm as L } from "element-plus";
import { _ as G, jY as Y, gG as T, sQ as K, bC as J, yP as d, qS as X, yQ as y, zL as Z, zN as ee, i as te, V as ae, cS as h, jl as oe, yR as re, b as w } from "../../../../../../../../../shared/runtime.js";
import ne from "../components/common-material-info.vue.js";
const ue = { class: "material-info" }, ie = { class: "form-info" }, le = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(O, { expose: N }) {
  const a = O, j = (o, e, r) => {
    if (w(e)) return r(new Error("请填写数量"));
    if (e <= 0) return r(new Error("数量必须大于0"));
    if (e > V.value) return r(new Error("数量不可超过可操作数量"));
    r();
  }, z = (o, e, r) => {
    if (w(e)) return r(new Error("请填写半出尺寸"));
    if (e <= 0) return r(new Error("半出尺寸必须大于0"));
    if (e > U.value) return r(new Error("半出尺寸不可超过当前物料尺寸"));
    r();
  }, { outboundCfg: _ } = Y(), C = f(() => {
    let o = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], halfMode: [{ required: true, message: "请选择物料半出方式", trigger: "change" }], halfSize: [{ required: true, validator: z, trigger: "blur" }], quantity: [{ required: true, validator: j, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return _.value.productionOutBoundUserIsRequired && (o = Object.assign(o, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), t.value.outboundTypeSelection !== T.CONSTRUCTION_SITE_USE.V && (o = Object.assign(o, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), o;
  }), s = E(), t = E({ quantity: void 0 }), n = f(() => a.material || {}), { loaded: P, baseUnit: m } = K(a.basicClass);
  J(s, t, ["quantity", "halfSize"]);
  const U = f(() => t.value.halfMode === d.LENGTH.V ? +n.value.length : t.value.halfMode === d.WIDTH.V ? +n.value.width : 0), I = f(() => t.value.halfMode === d.LENGTH.V ? m.value.length : t.value.halfMode === d.WIDTH.V ? m.value.width : {}), V = f(() => !t.value || !t.value.projectId || !n.value.projectFrozenForUnitKV ? n.value.corOperableQuantity : n.value.corOperableQuantity + (n.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  A("maxQuantity", V), Q(n, (o) => {
    R(o);
  }, { immediate: true, deep: true });
  function R(o) {
    const e = { materialId: o.id, workshopId: void 0, outboundUnit: o.outboundUnit, outboundUnitPrecision: o.outboundUnitPrecision, outboundAddress: X.FACTORY.V, projectId: o.project ? o.project.id : void 0, originProjectId: o.project ? o.project.id : void 0, materialOutboundMode: y.WHOLE.V, halfMode: d.LENGTH.V, recipientId: void 0, quantity: void 0, remark: void 0, outboundTypeSelection: T.PRODUCE.V, isNeedRemind: Z.YES.V };
    t.value = e;
  }
  async function x() {
    if (!await s.value.validate()) return false;
    t.value.boolPartyA = true;
    let e = ae(t.value);
    e = { ...e, outboundUnitType: a.material.outboundUnitType, unitNet: a.material.unitNet, outboundQuantity: a.material.outboundUnitType === h.MEASURE.V ? e.quantity : a.material.measureUnit && a.material.mete ? e.quantity / a.material.mete * a.material.quantity : void 0, outboundMete: a.material.outboundUnitType === h.MEASURE.V ? a.material.accountingUnit && a.material.quantity ? e.quantity / a.material.quantity * a.material.mete : void 0 : e.quantity }, await oe(e, { basicClass: a.material.basicClass, measureUnit: a.material.measureUnit, measurePrecision: a.material.measurePrecision, accountingUnit: a.material.accountingUnit, accountingPrecision: a.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["outboundMete", "actualTheoryWeight"] });
    const r = { materialId: a.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, halfSize: e.halfSize, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === h.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: true, outboundTime: e.outboundTime, actualTheoryWeight: e.actualTheoryWeight, recipientId: e.recipientId };
    return await re(r);
  }
  function B() {
    s.value && s.value.resetFields();
  }
  function F() {
    s.value && s.value.clearValidate();
  }
  return N({ submit: x, resetForm: B, clearValidate: F }), (o, e) => {
    const r = D, b = M("common-radio"), k = M("common-input-number"), H = L;
    return u(P) ? (g(), S(H, { key: 0, ref_key: "formRef", ref: s, model: t.value, rules: C.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: i(() => [p("div", ue, [l(ne, { form: t.value, material: n.value }, { afterSpec: i(() => [l(r, { label: "厚 * 宽 * 长" }, { default: i(() => [p("span", null, q(`${n.value.thickness}${u(m).thickness.unit} * ${n.value.width}${u(m).width.unit} * ${n.value.length}${u(m).length.unit}`), 1)]), _: 1 })]), afterBrand: i(() => [l(r, { label: "炉批号/卷号" }, { default: i(() => [p("span", null, q(n.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), p("div", ie, [l(ee, { form: t.value, material: n.value }, { extra: i(() => [!u(te)(a.material.dxfUrl) && u(_).showHalfOut ? (g(), S(r, { key: 0, label: "出库方式", prop: "materialOutboundMode" }, { default: i(() => [l(b, { modelValue: t.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (c) => t.value.materialOutboundMode = c), options: u(y).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : v("", true), t.value.materialOutboundMode === u(y).HALF.V ? (g(), W($, { key: 1 }, [l(r, { label: "半出方式", prop: "halfMode" }, { default: i(() => [l(b, { modelValue: t.value.halfMode, "onUpdate:modelValue": e[1] || (e[1] = (c) => t.value.halfMode = c), options: u(d).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: `半出尺寸(${I.value.unit})`, prop: "halfSize" }, { default: i(() => [l(k, { modelValue: t.value.halfSize, "onUpdate:modelValue": e[2] || (e[2] = (c) => t.value.halfSize = c), max: U.value, min: 0, precision: I.value.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 }, 8, ["label"])], 64)) : v("", true)]), _: 1 }, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"])) : v("", true);
  };
} }, ce = G(le, [["__scopeId", "data-v-fc9e7d0b"]]);
export {
  ce as default
};
