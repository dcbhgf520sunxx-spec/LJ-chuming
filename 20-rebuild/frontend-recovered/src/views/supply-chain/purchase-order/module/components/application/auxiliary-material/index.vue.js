import { inject as V } from "vue";
import { watchEffect as G } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as d } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { createVNode as l } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as O } from "vue";
import { withDirectives as y } from "vue";
import { createElementVNode as T } from "vue";
import { createElementBlock as h } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as N } from "vue";
import { mergeProps as X } from "vue";
import { reactive as Z } from "vue";
import { watch as H } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElTooltip as w } from "element-plus";
import { ElInput as ee } from "element-plus";
import { am as te, jY as ae, i as P, iX as U, D as S, cS as M, uY as ne, aw as ie, aI as le, c9 as se, uZ as oe } from "../../../../../../../shared/runtime.js";
const ue = { key: 1 }, ce = { key: 1 }, ge = { __name: "index", setup(re, { expose: A }) {
  var E;
  const R = te.MATERIAL.V, { purchaseCfg: x } = ae(), I = V("matSpecRef"), a = (E = V("cu")) == null ? void 0 : E.form, o = V("cu");
  G(() => {
    let e = 0;
    P(a.list) && a.list.forEach((i) => {
      e += Number(i.amount) || 0;
    }), a.amount = U(e, S.YUAN), a.mete = void 0, a.meteUnit = "";
  });
  const B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, i) => i.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: se, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, i) => P(i.mete) && P(i.unitPrice) ? +U(i.mete * i.unitPrice, S.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleMeteChangeCalcPrice: D } = oe("mete"), { tableValidate: F, wrongCellMask: L } = ie({ rules: B });
  function z({ row: e, rowIndex: i }) {
    var n, r;
    if ((r = (n = o == null ? void 0 : o.submitResult) == null ? void 0 : n.data) != null && r.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function Y(e) {
    const i = Z({ uid: le(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifySerialNumber: e.classify.serialNumber, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, outboundUnitType: e.classify.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: void 0, quantity: void 0 });
    return k(i), i;
  }
  function k(e) {
    H([() => e.mete], () => D(e));
  }
  function $(e, i, n) {
    var r, p, g, b;
    if ((p = (r = o == null ? void 0 : o.submitResult) == null ? void 0 : r.data) != null && p.includes(n.classifyId)) {
      const C = (g = o == null ? void 0 : o.submitResult) == null ? void 0 : g.data.findIndex((t) => t === n.classifyId);
      a.list.filter((t) => t.classifyId === n.classifyId).length === 1 && ((b = o == null ? void 0 : o.submitResult) == null || b.data.splice(C, 1));
    }
    I.value ? I.value.delListItem(e, i) : a.list.splice(i, 1);
  }
  function j(e) {
    a.useRequisitions && (e.mete = U(e.quantity * e.unitNet, e.accountingPrecision));
  }
  function Q(e) {
    a.useRequisitions && (e.quantity = U(e.mete * e.accountingUnitNet, e.measurePrecision));
  }
  function W() {
    const { validResult: e, dealList: i } = F(a.list);
    return a.list = i, a.basicClass = a.currentBasicClass, e;
  }
  return A({ rowInit: Y, validate: W, rowWatch: k }), (e, i) => {
    const n = J, r = w, p = v("common-input-number"), g = ee, b = v("common-button"), C = v("common-table"), m = K("empty-text");
    return d(), _(C, X({ "cell-class-name": s(L), data: s(a).list, "row-style": z, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: u(() => [l(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(a).useRequisitions ? (d(), _(n, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : O("", true), l(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), l(n, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => [l(r, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: u(() => [y(T("span", null, null, 512), [[m, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => [l(r, { content: t.specificationLabels, placement: "top" }, { default: u(() => [y(T("span", null, null, 512), [[m, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), l(n, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: u(({ row: t }) => [y((d(), h("span", null, [q(N(t.measureUnit), 1)])), [[m]])]), _: 1 }), l(n, { align: "center", label: "数量", prop: "quantity" }, { default: u(({ row: t }) => {
      var c;
      return [t.measureUnit && (!s(a).useRequisitions || s(a).useRequisitions && ((c = s(x)) == null ? void 0 : c.quantity) & s(R) && t.outboundUnitType === s(M).MEASURE.V) ? (d(), _(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (f) => t.quantity = f, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (f) => j(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : y((d(), h("span", ue, [q(N(t.quantity || "-"), 1)])), [[m]])];
    }), _: 1 }), l(n, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: u(({ row: t }) => [y((d(), h("span", null, [q(N(t.accountingUnit), 1)])), [[m]])]), _: 1 }), l(n, { align: "center", label: "核算量", prop: "mete" }, { default: u(({ row: t }) => {
      var c;
      return [!s(a).useRequisitions || s(a).useRequisitions && ((c = s(x)) == null ? void 0 : c.mete) & s(R) && t.outboundUnitType === s(M).ACCOUNTING.V ? (d(), _(p, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (f) => t.mete = f, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (f) => Q(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (d(), h("span", ce, N(t.mete || "-"), 1))];
    }), _: 1 }), l(ne, { "weight-attribute": "mete" }), l(n, { align: "center", label: "颜色", prop: "color" }, { default: u(({ row: t }) => [l(g, { modelValue: t.color, "onUpdate:modelValue": (c) => t.color = c, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(n, { align: "center", label: "品牌", prop: "brand" }, { default: u(({ row: t }) => [l(g, { modelValue: t.brand, "onUpdate:modelValue": (c) => t.brand = c, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(n, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: u(({ row: t, $index: c }) => [l(b, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (f) => $(t.sn, c, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ge as default
};
