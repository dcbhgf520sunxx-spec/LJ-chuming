import { inject as I } from "vue";
import { watchEffect as W } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as c } from "vue";
import { createVNode as a } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as R } from "vue";
import { withDirectives as p } from "vue";
import { createElementVNode as k } from "vue";
import { createElementBlock as f } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as g } from "vue";
import { mergeProps as H } from "vue";
import { reactive as K } from "vue";
import { watch as X } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElInput as w } from "element-plus";
import { am as ee, jY as te, i as h, iX as y, D as E, cS as T, uY as ae, fv as le, fE as F, aw as ne, aI as ie, c9 as se, uZ as oe } from "../../../../../../../shared/runtime.js";
import { _ as ce } from "../../../../../../../modules/factory-select-b8d0a4ac.js";
const ue = { key: 1 }, re = { key: 1 }, be = { __name: "index", setup(de, { expose: A }) {
  var N;
  const V = ee.OTHER.V, { purchaseCfg: U } = te(), v = I("matSpecRef"), l = (N = I("cu")) == null ? void 0 : N.form;
  W(() => {
    let e = 0;
    h(l.list) && l.list.forEach((n) => {
      e += Number(n.amount) || 0;
    }), l.amount = y(e, E.YUAN), l.mete = void 0, l.meteUnit = "";
  });
  const M = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, n) => n.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: se, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, n) => h(n.mete) && h(n.unitPrice) ? +y(n.mete * n.unitPrice, E.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: (e, n) => l.orderPlace === F.FACTORY.V ? !!e : true, message: "请选择工厂", trigger: "blur" }] }, { handleMeteChangeCalcPrice: S } = oe("mete"), { tableValidate: B, wrongCellMask: j } = ne({ rules: M });
  function D(e) {
    const n = K({ uid: ie(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0 });
    return C(n), n;
  }
  function C(e) {
    X([() => e.mete], () => S(e));
  }
  function Y(e, n) {
    v.value ? v.value.delListItem(e, n) : l.list.splice(n, 1);
  }
  function $(e) {
    l.useRequisitions && (e.mete = y(e.quantity * e.unitNet, e.measurePrecision));
  }
  function z(e) {
    l.useRequisitions && (e.quantity = y(e.mete * e.accountingUnitNet, e.accountingPrecision));
  }
  function L() {
    const { validResult: e, dealList: n } = B(l.list);
    return l.list = n, e;
  }
  return A({ rowInit: D, validate: L, rowWatch: C }), (e, n) => {
    const o = Z, P = J, q = _("common-input-number"), x = w, O = _("common-button"), Q = _("common-table"), d = G("empty-text");
    return u(), m(Q, H(e.$attrs, { data: i(l).list, "cell-class-name": i(j), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: c(() => [a(o, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), i(l).useRequisitions ? (u(), m(o, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : R("", true), a(o, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), a(o, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [a(P, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [p(k("span", null, null, 512), [[d, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(o, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [a(P, { content: t.specificationLabels, placement: "top" }, { default: c(() => [p(k("span", null, null, 512), [[d, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), a(o, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: c(({ row: t }) => [p((u(), f("span", null, [b(g(t.measureUnit), 1)])), [[d]])]), _: 1 }), a(o, { prop: "quantity", label: "数量", align: "center" }, { default: c(({ row: t }) => {
      var s;
      return [t.measureUnit && (!i(l).useRequisitions || i(l).useRequisitions && ((s = i(U)) == null ? void 0 : s.quantity) & i(V) && t.outboundUnitType === i(T).MEASURE.V) ? (u(), m(q, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, min: 0, max: 999999999, controls: false, step: 1, precision: t.measurePrecision, size: "default", placeholder: "数量", onChange: (r) => $(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : p((u(), f("span", ue, [b(g(t.quantity || "-"), 1)])), [[d]])];
    }), _: 1 }), a(o, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: c(({ row: t }) => [p((u(), f("span", null, [b(g(t.accountingUnit), 1)])), [[d]])]), _: 1 }), a(o, { prop: "mete", label: "核算量", align: "center" }, { default: c(({ row: t }) => {
      var s;
      return [!i(l).useRequisitions || i(l).useRequisitions && ((s = i(U)) == null ? void 0 : s.mete) & i(V) && t.outboundUnitType === i(T).ACCOUNTING.V ? (u(), m(q, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (r) => t.mete = r, min: 1e-6, max: 999999999, controls: false, step: 1, precision: t.accountingPrecision, size: "default", placeholder: "核算量", onChange: (r) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (u(), f("span", re, g(t.mete || "-"), 1))];
    }), _: 1 }), a(ae, { "weight-attribute": "mete" }), a(o, { prop: "color", label: "颜色", align: "center" }, { default: c(({ row: t }) => [a(x, { modelValue: t.color, "onUpdate:modelValue": (s) => t.color = s, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(o, { prop: "brand", label: "品牌", align: "center" }, { default: c(({ row: t }) => [a(x, { modelValue: t.brand, "onUpdate:modelValue": (s) => t.brand = s, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(o, { prop: "projectId", label: "所属项目", align: "center", "min-width": "180px" }, { default: c(({ row: t }) => [a(i(le), { modelValue: t.projectId, "onUpdate:modelValue": (s) => t.projectId = s, class: "filter-item", style: { width: "100%" }, clearable: "", placeholder: "可选择项目搜索" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(l).orderPlace === i(F).FACTORY.V ? (u(), m(o, { key: 1, prop: "factoryId", label: "所属工厂", align: "center", width: "140px" }, { default: c(({ row: t }) => [a(ce, { modelValue: t.factoryId, "onUpdate:modelValue": (s) => t.factoryId = s, placeholder: "选择工厂" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : R("", true), a(o, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: c(({ row: t, $index: s }) => [a(O, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (r) => Y(t.sn, s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  be as default
};
