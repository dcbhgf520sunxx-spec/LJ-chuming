import { inject as R } from "vue";
import { watchEffect as Q } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as u } from "vue";
import { createBlock as p } from "vue";
import { withCtx as o } from "vue";
import { createVNode as i } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as W } from "vue";
import { withDirectives as d } from "vue";
import { createElementVNode as k } from "vue";
import { createElementBlock as f } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as g } from "vue";
import { mergeProps as G } from "vue";
import { reactive as H } from "vue";
import { watch as K } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { ElInput as J } from "element-plus";
import { am as w, jY as ee, i as h, iX as _, D as E, cS as I, uY as te, aw as ae, aI as ne, c9 as ie, uZ as le } from "../../../../../../../shared/runtime.js";
const se = { key: 1 }, oe = { key: 1 }, pe = { __name: "index", setup(ce, { expose: T }) {
  var v;
  const C = w.OTHER.V, { purchaseCfg: U } = ee(), N = R("matSpecRef"), a = (v = R("cu")) == null ? void 0 : v.form;
  Q(() => {
    let e = 0;
    h(a.list) && a.list.forEach((n) => {
      e += Number(n.amount) || 0;
    }), a.amount = _(e, E.YUAN), a.mete = void 0, a.meteUnit = "";
  });
  const B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, n) => n.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ie, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, n) => h(n.mete) && h(n.unitPrice) ? +_(n.mete * n.unitPrice, E.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleMeteChangeCalcPrice: M } = le("mete"), { tableValidate: S, wrongCellMask: A } = ae({ rules: B });
  function D(e) {
    const n = H({ uid: ne(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0 });
    return V(n), n;
  }
  function V(e) {
    K([() => e.mete], () => M(e));
  }
  function F(e, n) {
    N.value ? N.value.delListItem(e, n) : a.list.splice(n, 1);
  }
  function z(e) {
    a.useRequisitions && (e.mete = _(e.quantity * e.unitNet, e.measurePrecision));
  }
  function L(e) {
    a.useRequisitions && (e.quantity = _(e.mete * e.accountingUnitNet, e.accountingPrecision));
  }
  function Y() {
    const { validResult: e, dealList: n } = S(a.list);
    return a.list = n, a.basicClass = a.currentBasicClass, e;
  }
  return T({ rowInit: D, validate: Y, rowWatch: V }), (e, n) => {
    const s = X, q = Z, P = b("common-input-number"), x = J, $ = b("common-button"), j = b("common-table"), m = O("empty-text");
    return u(), p(j, G(e.$attrs, { data: l(a).list, "cell-class-name": l(A), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: o(() => [i(s, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), l(a).useRequisitions ? (u(), p(s, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : W("", true), i(s, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), i(s, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [i(q, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [d(k("span", null, null, 512), [[m, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), i(s, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [i(q, { content: t.specificationLabels, placement: "top" }, { default: o(() => [d(k("span", null, null, 512), [[m, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), i(s, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: o(({ row: t }) => [d((u(), f("span", null, [y(g(t.measureUnit), 1)])), [[m]])]), _: 1 }), i(s, { prop: "quantity", label: "数量", align: "center" }, { default: o(({ row: t }) => {
      var c;
      return [t.measureUnit && (!l(a).useRequisitions || l(a).useRequisitions && ((c = l(U)) == null ? void 0 : c.quantity) & l(C) && t.outboundUnitType === l(I).MEASURE.V) ? (u(), p(P, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, min: 0, max: 999999999, controls: false, step: 1, precision: t.measurePrecision, size: "default", placeholder: "数量", onChange: (r) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : d((u(), f("span", se, [y(g(t.quantity || "-"), 1)])), [[m]])];
    }), _: 1 }), i(s, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: o(({ row: t }) => [d((u(), f("span", null, [y(g(t.accountingUnit), 1)])), [[m]])]), _: 1 }), i(s, { prop: "mete", label: "核算量", align: "center" }, { default: o(({ row: t }) => {
      var c;
      return [!l(a).useRequisitions || l(a).useRequisitions && ((c = l(U)) == null ? void 0 : c.mete) & l(C) && t.outboundUnitType === l(I).ACCOUNTING.V ? (u(), p(P, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (r) => t.mete = r, min: 1e-6, max: 999999999, controls: false, step: 1, precision: t.accountingPrecision, size: "default", placeholder: "核算量", onChange: (r) => L(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (u(), f("span", oe, g(t.mete || "-"), 1))];
    }), _: 1 }), i(te, { "weight-attribute": "mete" }), i(s, { prop: "color", label: "颜色", align: "center" }, { default: o(({ row: t }) => [i(x, { modelValue: t.color, "onUpdate:modelValue": (c) => t.color = c, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(s, { prop: "brand", label: "品牌", align: "center" }, { default: o(({ row: t }) => [i(x, { modelValue: t.brand, "onUpdate:modelValue": (c) => t.brand = c, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(s, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: o(({ row: t, $index: c }) => [i($, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (r) => F(t.sn, c) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  pe as default
};
