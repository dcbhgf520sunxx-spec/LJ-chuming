import { computed as l } from "vue";
import { ref as p } from "vue";
import { provide as j } from "vue";
import { watch as x } from "vue";
import { openBlock as F } from "vue";
import { createBlock as N } from "vue";
import { withCtx as D } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as U } from "vue";
import { ElForm as B } from "element-plus";
import { _ as L, jY as Q, bC as W, qS as Y, gG as u, zL as S, bR as q, bD as f, yV as k, Al as H, Am as z, An as K, Ao as G, b as $, V as J, cS as b, jl as X } from "../../../../../../../../../shared/runtime.js";
import Z from "../components/common-material-info.vue.js";
const ee = { class: "material-info" }, te = { class: "form-info" }, re = { __name: "other", props: { basicClass: { type: Number }, material: { type: Object } }, setup(I, { expose: _ }) {
  const r = I, y = (i, n, e) => {
    if ($(n)) return e(new Error("请填写数量"));
    if (n <= 0) return e(new Error("数量必须大于0"));
    if (n > h.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, v = (i, n, e) => {
    t.value.invoiceType || t.value.invoiceType === 0 ? t.value.invoiceType === f.SPECIAL.V && !t.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: E } = Q(), c = l(() => {
    let i = { quantity: [{ required: true, validator: y, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: v, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return E.value.productionOutBoundUserIsRequired && (i = Object.assign(i, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), i;
  }), s = p(), t = p({}), o = l(() => r.material || {});
  W(s, t, ["quantity"]);
  const h = l(() => !t.value || !t.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  j("maxQuantity", h), x(o, (i) => {
    R(i);
  }, { immediate: true });
  function R(i) {
    var e;
    let n = { materialId: i.id, factoryId: (e = i.factory) == null ? void 0 : e.id, outboundUnit: i.outboundUnit, outboundUnitPrecision: i.outboundUnitPrecision, outboundAddress: Y.FACTORY.V, projectId: i.project ? i.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, boolPartyA: false, outboundTypeSelection: u.PRODUCE.V, isNeedRemind: S.YES.V };
    if (t.value.outboundTypeSelection === u.FOR_SALE.V) {
      const a = { weightMeasurementMode: q.THEORY.V, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: f.SPECIAL.V, taxRate: void 0, inputMete: void 0 };
      n = Object.assign(n, a);
    }
    t.value = n, c.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: y, trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: v, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] }, n.projectId && (c.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  function V() {
    t.value.weightMeasurementMode = q.THEORY.V, t.value.quantity = void 0, t.value.sellUnitPrice = void 0, t.value.sellAmount = void 0, t.value.theoryTotalWeight = void 0, t.value.weighingWeight = void 0, t.value.invoiceType = f.SPECIAL.V, t.value.taxRate = void 0, t.value.inputMete = void 0, t.value.isNeedRemind = S.YES.V;
  }
  const M = l(() => {
    switch (t.value.outboundTypeSelection) {
      case u.OUTSOURCE.V:
        return K;
      case u.FOR_SALE.V:
        return m.value ? H : z;
      default:
        return k;
    }
  }), O = l(() => t.value.outboundTypeSelection || u.PRODUCE.V), m = p();
  function w() {
    return m.value = true, g(true);
  }
  async function A() {
    return m.value = false, g(false);
  }
  async function g(i) {
    if (!await s.value.validate()) return false;
    let e = J(t.value);
    e = { ...e, weightMeasurementMode: void 0, outboundUnitType: r.material.outboundUnitType, unitNet: r.material.unitNet, outboundQuantity: r.material.outboundUnitType === b.MEASURE.V ? e.quantity : r.material.measureUnit && r.material.mete ? e.quantity / r.material.mete * r.material.quantity : void 0, outboundMete: r.material.outboundUnitType === b.MEASURE.V ? r.material.accountingUnit && r.material.quantity ? e.quantity / r.material.quantity * r.material.mete : void 0 : e.quantity }, e.outboundTypeSelection !== u.PRODUCE.V && (e.boolSubmitCheck = i), await X(e, { basicClass: r.material.basicClass, measureUnit: r.material.measureUnit, measurePrecision: r.material.measurePrecision, accountingUnit: r.material.accountingUnit, accountingPrecision: r.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
    let a = { materialId: r.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: e.outboundAddress, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === b.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, isNeedRemind: e.isNeedRemind };
    if (t.value.outboundTypeSelection === u.PRODUCE.V || e.outboundTypeSelection === u.OUTSOURCE.V) {
      const d = { recipientId: e.recipientId };
      a = Object.assign(a, d);
    }
    if (e.outboundTypeSelection === u.OUTSOURCE.V) {
      const d = { purchaseId: e.purchaseId, boolSubmitCheck: e.boolSubmitCheck };
      a = Object.assign(a, d);
    }
    if (e.outboundTypeSelection === u.FOR_SALE.V) {
      const d = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      a = Object.assign(a, d);
    }
    return await M.value(a);
  }
  function P() {
    s.value.resetFields();
  }
  function C() {
    s.value && s.value.clearValidate();
  }
  return _({ submit: g, commonSubmit: A, auditSubmit: w, resetForm: P, formInitTwo: V, form: t, outboundTypeSelection: O, clearValidate: C }), (i, n) => {
    const e = B;
    return F(), N(e, { ref_key: "formRef", ref: s, model: t.value, rules: c.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: D(() => [T("div", ee, [U(Z, { form: t.value, material: o.value }, null, 8, ["form", "material"])]), T("div", te, [U(G, { form: t.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, oe = L(re, [["__scopeId", "data-v-69c115cb"]]);
export {
  oe as default
};
