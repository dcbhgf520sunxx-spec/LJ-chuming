import { inject as V } from "vue";
import { watchEffect as W } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as m } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as c } from "vue";
import { createVNode as i } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as H } from "vue";
import { withDirectives as b } from "vue";
import { createElementVNode as S } from "vue";
import { createElementBlock as h } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as C } from "vue";
import { mergeProps as K } from "vue";
import { reactive as X } from "vue";
import { watch as Z } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElTooltip as w } from "element-plus";
import { ElInput as ee } from "element-plus";
import { am as te, jY as ae, i as P, iX as N, D as T, cS as B, uY as ne, aw as le, aI as ie, c9 as se, uZ as oe } from "../../../../../../../shared/runtime.js";
const ce = { key: 1 }, ue = { key: 1 }, ge = { __name: "index", setup(re, { expose: M }) {
  var E;
  const R = te.OTHER.V, { purchaseCfg: x } = ae(), I = V("matSpecRef"), a = (E = V("cu")) == null ? void 0 : E.form, o = V("cu");
  W(() => {
    let e = 0;
    P(a.list) && a.list.forEach((l) => {
      e += Number(l.amount) || 0;
    }), a.amount = N(e, T.YUAN), a.mete = void 0, a.meteUnit = "";
  });
  const A = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, l) => l.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: se, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, l) => P(l.mete) && P(l.unitPrice) ? +N(l.mete * l.unitPrice, T.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleMeteChangeCalcPrice: D } = oe("mete"), { tableValidate: F, wrongCellMask: z } = le({ rules: A });
  function L({ row: e, rowIndex: l }) {
    var n, r;
    if ((r = (n = o == null ? void 0 : o.submitResult) == null ? void 0 : n.data) != null && r.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function Y(e) {
    const l = X({ uid: ie(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifySerialNumber: e.classify.serialNumber, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0 });
    return k(l), l;
  }
  function k(e) {
    Z([() => e.mete], () => D(e));
  }
  function $(e, l, n) {
    var r, p, g, y;
    if ((p = (r = o == null ? void 0 : o.submitResult) == null ? void 0 : r.data) != null && p.includes(n.classifyId)) {
      const U = (g = o == null ? void 0 : o.submitResult) == null ? void 0 : g.data.findIndex((t) => t === n.classifyId);
      a.list.filter((t) => t.classifyId === n.classifyId).length === 1 && ((y = o == null ? void 0 : o.submitResult) == null || y.data.splice(U, 1));
    }
    I.value ? I.value.delListItem(e, l) : a.list.splice(l, 1);
  }
  function j(e) {
    a.useRequisitions && (e.mete = N(e.quantity * e.unitNet, e.measurePrecision));
  }
  function Q(e) {
    a.useRequisitions && (e.quantity = N(e.mete * e.accountingUnitNet, e.accountingPrecision));
  }
  function O() {
    const { validResult: e, dealList: l } = F(a.list);
    return a.list = l, a.basicClass = a.currentBasicClass, e;
  }
  return M({ rowInit: Y, validate: O, rowWatch: k }), (e, l) => {
    const n = J, r = w, p = v("common-input-number"), g = ee, y = v("common-button"), U = v("common-table"), d = G("empty-text");
    return m(), _(U, K({ "cell-class-name": s(z), data: s(a).list, "row-style": L, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [i(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(a).useRequisitions ? (m(), _(n, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), i(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), i(n, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [i(r, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [b(S("span", null, null, 512), [[d, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), i(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [i(r, { content: t.specificationLabels, placement: "top" }, { default: c(() => [b(S("span", null, null, 512), [[d, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), i(n, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: c(({ row: t }) => [b((m(), h("span", null, [q(C(t.measureUnit), 1)])), [[d]])]), _: 1 }), i(n, { align: "center", label: "数量", prop: "quantity" }, { default: c(({ row: t }) => {
      var u;
      return [t.measureUnit && (!s(a).useRequisitions || s(a).useRequisitions && ((u = s(x)) == null ? void 0 : u.quantity) & s(R) && t.outboundUnitType === s(B).MEASURE.V) ? (m(), _(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (f) => t.quantity = f, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (f) => j(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : b((m(), h("span", ce, [q(C(t.quantity || "-"), 1)])), [[d]])];
    }), _: 1 }), i(n, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: c(({ row: t }) => [b((m(), h("span", null, [q(C(t.accountingUnit), 1)])), [[d]])]), _: 1 }), i(n, { align: "center", label: "核算量", prop: "mete" }, { default: c(({ row: t }) => {
      var u;
      return [!s(a).useRequisitions || s(a).useRequisitions && ((u = s(x)) == null ? void 0 : u.mete) & s(R) && t.outboundUnitType === s(B).ACCOUNTING.V ? (m(), _(p, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (f) => t.mete = f, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (f) => Q(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (m(), h("span", ue, C(t.mete || "-"), 1))];
    }), _: 1 }), i(ne, { "weight-attribute": "mete" }), i(n, { align: "center", label: "颜色", prop: "color" }, { default: c(({ row: t }) => [i(g, { modelValue: t.color, "onUpdate:modelValue": (u) => t.color = u, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(n, { align: "center", label: "品牌", prop: "brand" }, { default: c(({ row: t }) => [i(g, { modelValue: t.brand, "onUpdate:modelValue": (u) => t.brand = u, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), i(n, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: u }) => [i(y, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (f) => $(t.sn, u, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ge as default
};
