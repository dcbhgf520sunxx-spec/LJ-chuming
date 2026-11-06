import { computed as l } from "vue";
import { ref as f } from "vue";
import { provide as j } from "vue";
import { watch as x } from "vue";
import { openBlock as F } from "vue";
import { createBlock as N } from "vue";
import { withCtx as B } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as v } from "vue";
import { ElForm as D } from "element-plus";
import { _ as L, jY as Q, bC as W, gG as u, zL as h, bR as U, bD as p, yU as k, Al as Y, Am as H, An as z, Ao as K, V as G, cS as g, jl as $, b as J } from "../../../../../../../../../shared/runtime.js";
import X from "../components/common-material-info.vue.js";
const Z = { class: "material-info" }, ee = { class: "form-info" }, te = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object } }, setup(T, { expose: S }) {
  const n = T, _ = (i, a, e) => {
    if (J(a)) return e(new Error("请填写数量"));
    if (a <= 0) return e(new Error("数量必须大于0"));
    if (a > b.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, E = (i, a, e) => {
    t.value.invoiceType || t.value.invoiceType === 0 ? t.value.invoiceType === p.SPECIAL.V && !t.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: I } = Q(), R = l(() => {
    let i = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], quantity: [{ required: true, validator: _, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: E, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return I.value.productionOutBoundUserIsRequired && (i = Object.assign(i, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), i;
  }), s = f(), t = f({}), r = l(() => n.material || {});
  W(s, t, ["quantity"]);
  const b = l(() => !t.value || !t.value.projectId || !r.value.projectFrozenForUnitKV ? r.value.corOperableQuantity : r.value.corOperableQuantity + (r.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  j("maxQuantity", b), x(r, (i) => {
    M(i);
  }, { immediate: true });
  function M(i) {
    let a = { materialId: i.id, workshopId: void 0, outboundUnit: i.outboundUnit, outboundUnitPrecision: i.outboundUnitPrecision, projectId: i.project ? i.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, boolPartyA: false, outboundTypeSelection: u.PRODUCE.V, isNeedRemind: h.YES.V };
    if (t.value.outboundTypeSelection === u.FOR_SALE.V) {
      const e = { weightMeasurementMode: U.THEORY.V, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: p.SPECIAL.V, taxRate: void 0, inputMete: void 0 };
      a = Object.assign(a, e);
    }
    t.value = a;
  }
  function q() {
    t.value.weightMeasurementMode = U.THEORY.V, t.value.quantity = void 0, t.value.sellUnitPrice = void 0, t.value.sellAmount = void 0, t.value.theoryTotalWeight = void 0, t.value.weighingWeight = void 0, t.value.invoiceType = p.SPECIAL.V, t.value.taxRate = void 0, t.value.inputMete = void 0, t.value.isNeedRemind = h.YES.V;
  }
  const w = l(() => {
    switch (t.value.outboundTypeSelection) {
      case u.OUTSOURCE.V:
        return z;
      case u.FOR_SALE.V:
        return c.value ? Y : H;
      default:
        return k;
    }
  }), c = f(), O = l(() => t.value.outboundTypeSelection || u.PRODUCE.V);
  function V() {
    return c.value = true, m(true);
  }
  async function P() {
    return c.value = false, m(false);
  }
  async function m(i) {
    if (!await s.value.validate()) return false;
    let e = G(t.value);
    e = { ...e, weightMeasurementMode: void 0, outboundUnitType: n.material.outboundUnitType, unitNet: n.material.unitNet, outboundQuantity: n.material.outboundUnitType === g.MEASURE.V ? e.quantity : n.material.measureUnit && n.material.mete ? e.quantity / n.material.mete * n.material.quantity : void 0, outboundMete: n.material.outboundUnitType === g.MEASURE.V ? n.material.accountingUnit && n.material.quantity ? e.quantity / n.material.quantity * n.material.mete : void 0 : e.quantity }, e.outboundTypeSelection !== u.PRODUCE.V && (e.boolSubmitCheck = i), await $(e, { basicClass: n.material.basicClass, measureUnit: n.material.measureUnit, measurePrecision: n.material.measurePrecision, accountingUnit: n.material.accountingUnit, accountingPrecision: n.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
    let o = { materialId: n.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === g.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, isNeedRemind: e.isNeedRemind };
    if (t.value.outboundTypeSelection === u.PRODUCE.V || e.outboundTypeSelection === u.OUTSOURCE.V) {
      const d = { recipientId: e.recipientId };
      o = Object.assign(o, d);
    }
    if (e.outboundTypeSelection === u.OUTSOURCE.V) {
      const d = { purchaseId: e.purchaseId, boolSubmitCheck: e.boolSubmitCheck };
      o = Object.assign(o, d);
    }
    if (e.outboundTypeSelection === u.FOR_SALE.V) {
      const d = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      o = Object.assign(o, d);
    }
    return await w.value(o);
  }
  function A() {
    s.value.resetFields();
  }
  function C() {
    s.value && s.value.clearValidate();
  }
  return S({ submit: m, commonSubmit: P, auditSubmit: V, resetForm: A, formInitTwo: q, form: t, outboundTypeSelection: O, clearValidate: C }), (i, a) => {
    const e = D;
    return F(), N(e, { ref_key: "formRef", ref: s, model: t.value, rules: R.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: B(() => [y("div", Z, [v(X, { form: t.value, material: r.value }, null, 8, ["form", "material"])]), y("div", ee, [v(K, { form: t.value, material: r.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, re = L(te, [["__scopeId", "data-v-446b76f9"]]);
export {
  re as default
};
