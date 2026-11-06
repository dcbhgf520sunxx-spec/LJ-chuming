import { computed as d } from "vue";
import { ref as p } from "vue";
import { provide as j } from "vue";
import { watch as x } from "vue";
import { openBlock as F } from "vue";
import { createBlock as N } from "vue";
import { withCtx as D } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as U } from "vue";
import { ElForm as B } from "element-plus";
import { _ as k, jY as L, gG as n, bC as Q, zL as S, bR as _, bD as f, yT as W, Al as Y, Am as H, An as z, Ao as K, b as G, V as $, cS as b, jl as J } from "../../../../../../../../../shared/runtime.js";
import X from "../components/common-material-info.vue.js";
const Z = { class: "material-info" }, ee = { class: "form-info" }, te = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object } }, setup(I, { expose: E }) {
  const i = I, v = (r, a, e) => {
    if (G(a)) return e(new Error("请填写数量"));
    if (a <= 0) return e(new Error("数量必须大于0"));
    if (a > h.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, y = (r, a, e) => {
    t.value.invoiceType || t.value.invoiceType === 0 ? t.value.invoiceType === f.SPECIAL.V && !t.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: q } = L(), c = d(() => {
    let r = { quantity: [{ required: true, validator: v, trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: y, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return q.value.productionOutBoundUserIsRequired && (r = Object.assign(r, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), t.value.outboundTypeSelection !== n.CONSTRUCTION_SITE_USE.V && (r = Object.assign(r, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), r;
  }), s = p(), t = p({}), u = d(() => i.material || {});
  Q(s, t, ["quantity"]);
  const h = d(() => !t.value || !t.value.projectId || !u.value.projectFrozenForUnitKV ? u.value.corOperableQuantity : u.value.corOperableQuantity + (u.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  j("maxQuantity", h), x(u, (r) => {
    R(r);
  }, { immediate: true });
  function R(r) {
    let a = { materialId: r.id, workshopId: void 0, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision, projectId: r.project ? r.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, boolPartyA: false, outboundTypeSelection: n.PRODUCE.V, isNeedRemind: S.YES.V };
    if (t.value.outboundTypeSelection === n.FOR_SALE.V) {
      const e = { weightMeasurementMode: _.THEORY.V, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: f.SPECIAL.V, taxRate: void 0, inputMete: void 0 };
      a = Object.assign(a, e);
    }
    t.value = a, c.value = { quantity: [{ required: true, validator: v, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: y, trigger: "change" }] }, a.projectId && t.value.outboundType === n.PRODUCE.V && (c.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  function M() {
    t.value.weightMeasurementMode = _.THEORY.V, t.value.quantity = void 0, t.value.sellUnitPrice = void 0, t.value.sellAmount = void 0, t.value.theoryTotalWeight = void 0, t.value.weighingWeight = void 0, t.value.invoiceType = f.SPECIAL.V, t.value.taxRate = void 0, t.value.inputMete = void 0, t.value.isNeedRemind = S.YES.V;
  }
  const O = d(() => {
    switch (t.value.outboundTypeSelection) {
      case n.OUTSOURCE.V:
        return z;
      case n.FOR_SALE.V:
        return m.value ? Y : H;
      default:
        return W;
    }
  }), V = d(() => t.value.outboundTypeSelection || n.PRODUCE.V), m = p();
  function w() {
    return m.value = true, g(true);
  }
  async function C() {
    return m.value = false, g(false);
  }
  async function g(r) {
    if (!await s.value.validate()) return false;
    let e = $(t.value);
    e = { ...e, weightMeasurementMode: void 0, outboundUnitType: i.material.outboundUnitType, unitNet: i.material.unitNet, outboundQuantity: i.material.outboundUnitType === b.MEASURE.V ? e.quantity : i.material.measureUnit && i.material.mete ? e.quantity / i.material.mete * i.material.quantity : void 0, outboundMete: i.material.outboundUnitType === b.MEASURE.V ? i.material.accountingUnit && i.material.quantity ? e.quantity / i.material.quantity * i.material.mete : void 0 : e.quantity }, e.outboundTypeSelection !== n.PRODUCE.V && (e.boolSubmitCheck = r), await J(e, { basicClass: i.material.basicClass, measureUnit: i.material.measureUnit, measurePrecision: i.material.measurePrecision, accountingUnit: i.material.accountingUnit, accountingPrecision: i.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
    let o = { materialId: i.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === b.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, isNeedRemind: e.isNeedRemind };
    if (t.value.outboundTypeSelection === n.PRODUCE.V || e.outboundTypeSelection === n.OUTSOURCE.V) {
      const l = { recipientId: e.recipientId };
      o = Object.assign(o, l);
    }
    if (e.outboundTypeSelection === n.OUTSOURCE.V) {
      const l = { purchaseId: e.purchaseId, boolSubmitCheck: e.boolSubmitCheck };
      o = Object.assign(o, l);
    }
    if (e.outboundTypeSelection === n.FOR_SALE.V) {
      const l = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      o = Object.assign(o, l);
    }
    return await O.value(o);
  }
  function P() {
    s.value.resetFields();
  }
  function A() {
    s.value && s.value.clearValidate();
  }
  return E({ submit: g, commonSubmit: C, auditSubmit: w, resetForm: P, formInitTwo: M, form: t, outboundTypeSelection: V, clearValidate: A }), (r, a) => {
    const e = B;
    return F(), N(e, { ref_key: "formRef", ref: s, model: t.value, rules: c.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: D(() => [T("div", Z, [U(X, { form: t.value, material: u.value }, null, 8, ["form", "material"])]), T("div", ee, [U(K, { form: t.value, material: u.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, ue = k(te, [["__scopeId", "data-v-3e1ec40f"]]);
export {
  ue as default
};
