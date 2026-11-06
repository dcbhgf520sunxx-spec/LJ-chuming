import { computed as f } from "vue";
import { ref as h } from "vue";
import { provide as K } from "vue";
import { watch as J } from "vue";
import { resolveComponent as R } from "vue";
import { unref as d } from "vue";
import { openBlock as S } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as U } from "vue";
import { ElFormItem as X } from "element-plus";
import { ElForm as Z } from "element-plus";
import { _ as ee, jY as te, gG as u, sQ as ne, bC as ae, yQ as g, yP as q, zL as C, bR as P, bD as E, yS as ie, Al as oe, Am as ue, An as re, Ao as le, i as se, V as de, cS as T, jl as me, b as A } from "../../../../../../../../../shared/runtime.js";
import ce from "../components/common-material-info.vue.js";
const fe = { class: "material-info" }, pe = { class: "form-info" }, ge = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(N, { expose: j }) {
  const n = N, x = (i, a, e) => {
    if (A(a)) return e(new Error("请填写数量"));
    if (a <= 0) return e(new Error("数量必须大于0"));
    if (a > I.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, F = (i, a, e) => {
    if (A(a)) return e(new Error("请填写半出尺寸"));
    if (a <= 0) return e(new Error("半出尺寸必须大于0"));
    if (a > o.value.length) return e(new Error("半出尺寸不可超过当前物料定尺长度"));
    e();
  }, z = (i, a, e) => {
    t.value.invoiceType || t.value.invoiceType === 0 ? t.value.invoiceType === E.SPECIAL.V && !t.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: O } = te(), B = f(() => {
    let i = { projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], halfSize: [{ required: true, validator: F, trigger: "blur" }], quantity: [{ required: true, validator: x, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: z, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return t.value.outboundTypeSelection !== u.CONSTRUCTION_SITE_USE.V && (i = Object.assign(i, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), O.value.productionOutBoundUserIsRequired && (i = Object.assign(i, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), i;
  }), m = h(), t = h({}), o = f(() => n.material || {}), { loaded: L, baseUnit: V } = ne(n.basicClass);
  ae(m, t, ["quantity", "halfSize"]);
  const I = f(() => !t.value || !t.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  K("maxQuantity", I), J(o, (i) => {
    H(i);
  }, { immediate: true, deep: true });
  function H(i) {
    let a = { materialId: i.id, workshopId: void 0, outboundUnit: i.outboundUnit, outboundUnitPrecision: i.outboundUnitPrecision, projectId: i.project ? i.project.id : void 0, materialOutboundMode: g.WHOLE.V, halfMode: q.LENGTH.V, halfSize: void 0, recipientId: void 0, quantity: void 0, remark: void 0, boolPartyA: false, outboundTypeSelection: u.PRODUCE.V, isNeedRemind: C.YES.V };
    if (t.value.outboundTypeSelection === u.FOR_SALE.V) {
      const e = { weightMeasurementMode: P.THEORY.V, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: E.SPECIAL.V, taxRate: void 0, inputMete: void 0 };
      a = Object.assign(a, e);
    }
    t.value = a;
  }
  function D() {
    t.value.materialOutboundMode = g.WHOLE.V, t.value.halfMode = q.LENGTH.V, t.value.weightMeasurementMode = P.THEORY.V, t.value.quantity = void 0, t.value.sellUnitPrice = void 0, t.value.sellAmount = void 0, t.value.theoryTotalWeight = void 0, t.value.weighingWeight = void 0, t.value.invoiceType = E.SPECIAL.V, t.value.taxRate = void 0, t.value.inputMete = void 0, t.value.isNeedRemind = C.YES.V;
  }
  const Q = f(() => {
    switch (t.value.outboundTypeSelection) {
      case u.OUTSOURCE.V:
        return re;
      case u.FOR_SALE.V:
        return b.value ? oe : ue;
      default:
        return ie;
    }
  }), W = f(() => t.value.outboundTypeSelection || u.PRODUCE.V), b = h();
  function k() {
    return b.value = true, v(true);
  }
  async function Y() {
    return b.value = false, v(false);
  }
  async function v(i) {
    if (!await m.value.validate()) return false;
    let e = de(t.value);
    e = { ...e, outboundUnitType: n.material.outboundUnitType, unitNet: n.material.unitNet, outboundQuantity: n.material.outboundUnitType === T.MEASURE.V ? e.quantity : n.material.measureUnit && n.material.mete ? e.quantity / n.material.mete * n.material.quantity : void 0, outboundMete: n.material.outboundUnitType === T.MEASURE.V ? n.material.accountingUnit && n.material.quantity ? e.quantity / n.material.quantity * n.material.mete : void 0 : e.quantity }, e.outboundTypeSelection !== u.PRODUCE.V && (e.boolSubmitCheck = i), await me(e, { basicClass: n.material.basicClass, measureUnit: n.material.measureUnit, measurePrecision: n.material.measurePrecision, accountingUnit: n.material.accountingUnit, accountingPrecision: n.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
    let r = { materialId: n.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, halfSize: e.halfSize, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === T.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, isNeedRemind: e.isNeedRemind };
    if (t.value.outboundTypeSelection === u.PRODUCE.V || e.outboundTypeSelection === u.OUTSOURCE.V) {
      const s = { recipientId: e.recipientId };
      r = Object.assign(r, s);
    }
    if (e.outboundTypeSelection === u.OUTSOURCE.V) {
      const s = { purchaseId: e.purchaseId };
      r = Object.assign(r, s);
    }
    if (e.outboundTypeSelection === u.FOR_SALE.V) {
      const s = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      r = Object.assign(r, s);
    }
    return await Q.value(r);
  }
  function G() {
    m.value.resetFields();
  }
  function $() {
    m.value && m.value.clearValidate();
  }
  return j({ submit: v, commonSubmit: Y, auditSubmit: k, resetForm: G, form: t, formInitTwo: D, outboundTypeSelection: W, clearValidate: $ }), (i, a) => {
    const e = X, r = R("common-radio"), M = R("common-input-number"), s = Z;
    return d(L) ? (S(), _(s, { key: 0, ref_key: "formRef", ref: m, model: t.value, rules: B.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: l(() => [p("div", fe, [c(ce, { form: t.value, material: o.value }, { afterSpec: l(() => [c(e, { label: "定尺长度" }, { default: l(() => [p("span", null, w(`${o.value.length}${d(V).length.unit}`), 1)]), _: 1 })]), afterBrand: l(() => [c(e, { label: "炉批号/卷号" }, { default: l(() => [p("span", null, w(o.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), p("div", pe, [c(le, { form: t.value, material: o.value }, { extra: l(() => [!d(se)(n.material.dxfUrl) && d(O).showHalfOut ? (S(), _(e, { key: 0, label: "出库方式", prop: "materialOutboundMode" }, { default: l(() => [c(r, { modelValue: t.value.materialOutboundMode, "onUpdate:modelValue": a[0] || (a[0] = (y) => t.value.materialOutboundMode = y), options: d(g).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : U("", true), t.value.materialOutboundMode === d(g).HALF.V ? (S(), _(e, { key: 1, label: "半出尺寸(mm)", prop: "halfSize" }, { default: l(() => [c(M, { modelValue: t.value.halfSize, "onUpdate:modelValue": a[1] || (a[1] = (y) => t.value.halfSize = y), max: +o.value.length, min: 0, precision: d(V).length.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 })) : U("", true)]), _: 1 }, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"])) : U("", true);
  };
} }, he = ee(ge, [["__scopeId", "data-v-792fdd9c"]]);
export {
  he as default
};
