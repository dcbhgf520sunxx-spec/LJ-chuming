import { computed as f } from "vue";
import { ref as T } from "vue";
import { provide as X } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as R } from "vue";
import { unref as l } from "vue";
import { openBlock as U } from "vue";
import { createBlock as P } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as d } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementBlock as ee } from "vue";
import { Fragment as te } from "vue";
import { ElFormItem as ae } from "element-plus";
import { ElForm as ne } from "element-plus";
import { _ as ue, jY as ie, gG as r, sQ as re, bC as oe, yP as p, yQ as h, zL as N, bR as A, bD as E, yR as le, Al as se, Am as de, An as me, Ao as ce, i as fe, V as pe, cS as M, jl as ge, b as j } from "../../../../../../../../../shared/runtime.js";
import ve from "../components/common-material-info.vue.js";
const be = { class: "material-info" }, he = { class: "form-info" }, ye = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(x, { expose: H }) {
  const n = x, z = (u, a, e) => {
    if (j(a)) return e(new Error("请填写数量"));
    if (a <= 0) return e(new Error("数量必须大于0"));
    if (a > q.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, F = (u, a, e) => {
    if (j(a)) return e(new Error("请填写半出尺寸"));
    if (a <= 0) return e(new Error("半出尺寸必须大于0"));
    if (a > O.value) return e(new Error("半出尺寸不可超过当前物料尺寸"));
    e();
  }, L = (u, a, e) => {
    t.value.invoiceType || t.value.invoiceType === 0 ? t.value.invoiceType === E.SPECIAL.V && !t.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: V } = ie(), B = f(() => {
    let u = { materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], halfMode: [{ required: true, message: "请选择物料半出方式", trigger: "change" }], halfSize: [{ required: true, validator: F, trigger: "blur" }], quantity: [{ required: true, validator: z, trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字", trigger: "blur" }], unitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], amount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], measuringMethod: [{ required: true, message: "请选择计量方式", trigger: "change" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: L, trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return t.value.outboundTypeSelection !== r.CONSTRUCTION_SITE_USE.V && (u = Object.assign(u, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), V.value.productionOutBoundUserIsRequired && (u = Object.assign(u, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), u;
  }), m = T(), t = T({ quantity: void 0 }), W = f(() => t.value.outboundTypeSelection || r.PRODUCE.V), i = f(() => n.material || {}), { loaded: D, baseUnit: g } = re(n.basicClass);
  oe(m, t, ["quantity", "halfSize"]);
  const O = f(() => t.value.halfMode === p.LENGTH.V ? +i.value.length : t.value.halfMode === p.WIDTH.V ? +i.value.width : 0), I = f(() => t.value.halfMode === p.LENGTH.V ? g.value.length : t.value.halfMode === p.WIDTH.V ? g.value.width : {}), q = f(() => !t.value || !t.value.projectId || !i.value.projectFrozenForUnitKV ? i.value.corOperableQuantity : i.value.corOperableQuantity + (i.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  X("maxQuantity", q), Z(i, (u) => {
    k(u);
  }, { immediate: true, deep: true });
  function k(u) {
    let a = { materialId: u.id, workshopId: void 0, outboundUnit: u.outboundUnit, outboundUnitPrecision: u.outboundUnitPrecision, projectId: u.project ? u.project.id : void 0, materialOutboundMode: h.WHOLE.V, halfMode: p.LENGTH.V, halfSize: void 0, outboundTypeSelection: r.PRODUCE.V, remark: void 0, outboundTime: void 0, boolPartyA: false, isNeedRemind: N.YES.V };
    if (t.value.outboundTypeSelection === r.FOR_SALE.V) {
      const e = { weightMeasurementMode: A.THEORY.V, quantity: void 0, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: E.SPECIAL.V, inputMete: void 0, taxRate: void 0 };
      a = Object.assign(a, e);
    }
    t.value = a;
  }
  function Q() {
    t.value.materialOutboundMode = h.WHOLE.V, t.value.halfMode = p.LENGTH.V, t.value.weightMeasurementMode = A.THEORY.V, t.value.quantity = void 0, t.value.sellUnitPrice = void 0, t.value.sellAmount = void 0, t.value.theoryTotalWeight = void 0, t.value.weighingWeight = void 0, t.value.invoiceType = E.SPECIAL.V, t.value.taxRate = void 0, t.value.inputMete = void 0, t.value.outboundTime = void 0, t.value.isNeedRemind = N.YES.V;
  }
  const $ = f(() => {
    switch (t.value.outboundTypeSelection) {
      case r.OUTSOURCE.V:
        return me;
      case r.FOR_SALE.V:
        return y.value ? se : de;
      default:
        return le;
    }
  }), y = T();
  function Y() {
    return y.value = true, S(true);
  }
  async function G() {
    return y.value = false, S(false);
  }
  async function S(u) {
    if (!await m.value.validate()) return false;
    let e = pe(t.value);
    e = { ...e, outboundUnitType: n.material.outboundUnitType, unitNet: n.material.unitNet, outboundQuantity: n.material.outboundUnitType === M.MEASURE.V ? e.quantity : n.material.measureUnit && n.material.mete ? e.quantity / n.material.mete * n.material.quantity : void 0, outboundMete: n.material.outboundUnitType === M.MEASURE.V ? n.material.accountingUnit && n.material.quantity ? e.quantity / n.material.quantity * n.material.mete : void 0 : e.quantity }, e.outboundTypeSelection !== r.PRODUCE.V && (e.boolSubmitCheck = u), await ge(e, { basicClass: n.material.basicClass, measureUnit: n.material.measureUnit, measurePrecision: n.material.measurePrecision, accountingUnit: n.material.accountingUnit, accountingPrecision: n.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete", "actualTheoryWeight"], amount: ["sellUnitPrice"] });
    let o = { materialId: n.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode, halfMode: e.halfMode, halfSize: e.halfSize, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === M.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, actualTheoryWeight: e.actualTheoryWeight, isNeedRemind: e.isNeedRemind };
    if (t.value.outboundTypeSelection === r.PRODUCE.V || e.outboundTypeSelection === r.OUTSOURCE.V) {
      const c = { recipientId: e.recipientId };
      o = Object.assign(o, c);
    }
    if (e.outboundTypeSelection === r.OUTSOURCE.V) {
      const c = { purchaseId: e.purchaseId, boolSubmitCheck: e.boolSubmitCheck };
      o = Object.assign(o, c);
    }
    if (e.outboundTypeSelection === r.FOR_SALE.V) {
      const c = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      o = Object.assign(o, c);
    }
    return await $.value(o);
  }
  function K() {
    m.value && m.value.resetFields();
  }
  function J() {
    m.value && m.value.clearValidate();
  }
  return H({ submit: S, commonSubmit: G, auditSubmit: Y, resetForm: K, clearValidate: J, form: t, formInitTwo: Q, outboundTypeSelection: W }), (u, a) => {
    const e = ae, o = R("common-radio"), w = R("common-input-number"), c = ne;
    return l(D) ? (U(), P(c, { key: 0, ref_key: "formRef", ref: m, model: t.value, rules: B.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: s(() => [b("div", be, [d(ve, { form: t.value, material: i.value }, { afterSpec: s(() => [d(e, { label: "厚 * 宽 * 长" }, { default: s(() => [b("span", null, C(`${i.value.thickness}${l(g).thickness.unit} * ${i.value.width}${l(g).width.unit} * ${i.value.length}${l(g).length.unit}`), 1)]), _: 1 })]), afterBrand: s(() => [d(e, { label: "炉批号/卷号" }, { default: s(() => [b("span", null, C(i.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), b("div", he, [d(ce, { form: t.value, material: i.value }, { extra: s(() => [!l(fe)(n.material.dxfUrl) && l(V).showHalfOut ? (U(), P(e, { key: 0, label: "出库方式", prop: "materialOutboundMode" }, { default: s(() => [d(o, { modelValue: t.value.materialOutboundMode, "onUpdate:modelValue": a[0] || (a[0] = (v) => t.value.materialOutboundMode = v), options: l(h).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : _("", true), t.value.materialOutboundMode === l(h).HALF.V ? (U(), ee(te, { key: 1 }, [d(e, { label: "半出方式", prop: "halfMode" }, { default: s(() => [d(o, { modelValue: t.value.halfMode, "onUpdate:modelValue": a[1] || (a[1] = (v) => t.value.halfMode = v), options: l(p).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), d(e, { label: `半出尺寸(${I.value.unit})`, prop: "halfSize" }, { default: s(() => [d(w, { modelValue: t.value.halfSize, "onUpdate:modelValue": a[2] || (a[2] = (v) => t.value.halfSize = v), max: O.value, min: 0, precision: I.value.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 }, 8, ["label"])], 64)) : _("", true)]), _: 1 }, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"])) : _("", true);
  };
} }, _e = ue(ye, [["__scopeId", "data-v-d62912ee"]]);
export {
  _e as default
};
