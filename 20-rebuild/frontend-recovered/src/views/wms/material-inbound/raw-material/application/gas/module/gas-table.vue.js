import { inject as Y } from "vue";
import { ref as J } from "vue";
import { computed as Q } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as d } from "vue";
import { createBlock as N } from "vue";
import { withCtx as c } from "vue";
import { createVNode as l } from "vue";
import { unref as P } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as b } from "vue";
import { createElementBlock as U } from "vue";
import { createTextVNode as R } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as X } from "vue";
import { mergeProps as G } from "vue";
import { reactive as I } from "vue";
import { ElInput as H } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { tC as te, aR as ae, uY as le, c9 as ne, aw as ie, aI as w, i as g, iX as A, D as q } from "../../../../../../../shared/runtime.js";
const se = { class: "mtb-10" }, oe = { key: 1 }, me = { __name: "gas-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(k, { expose: S }) {
  const m = k, _ = Y("matSpecRef"), { cu: s, form: u } = te(), h = J([]), B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, a) => a.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ne, message: "核算量必须大于0", trigger: "blur" }] }, D = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, a) => g(a.mete) && g(a.unitPrice) ? +A(a.mete * a.unitPrice, q.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }] }, z = Q(() => {
    let e = Object.assign({}, B);
    return !m.boolPartyA && m.fillableAmount && (e = Object.assign(e, D)), e;
  }), { tableValidate: E, wrongCellMask: F } = ie({ rules: z });
  function L({ row: e, rowIndex: a }) {
    var i, n;
    if ((n = (i = s == null ? void 0 : s.submitResult) == null ? void 0 : i.data) != null && n.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function j(e) {
    const a = I({ uid: w(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0 });
    return !m.boolPartyA && m.fillableAmount && (a.unitPrice = void 0, a.amount = void 0), a;
  }
  function M(e, a) {
    g(a.unitPrice) && g(e) && (a.amount = A(e * a.unitPrice, q.YUAN));
  }
  function O(e, a, i) {
    var n, p, f, y;
    if ((p = (n = s == null ? void 0 : s.submitResult) == null ? void 0 : n.data) != null && p.includes(i.classifyId)) {
      const x = (f = s == null ? void 0 : s.submitResult) == null ? void 0 : f.data.findIndex((t) => t === i.classifyId);
      u.list.filter((t) => t.classifyId === i.classifyId).length === 1 && ((y = s == null ? void 0 : s.submitResult) == null || y.data.splice(x, 1));
    }
    _.value ? _.value.delListItem(e, a) : u.list.splice(a, 1);
  }
  function T(e, a) {
    const i = I(JSON.parse(JSON.stringify(e)));
    i.uid = w(), u.list.push(i), _.value.initSelected([i]);
  }
  function $() {
    const { validResult: e, dealList: a } = E(u.list);
    return u.list = a, e;
  }
  return S({ rowInit: j, validate: $ }), (e, a) => {
    const i = H, n = Z, p = ee, f = v("common-input-number"), y = v("common-button"), x = v("common-table"), r = W("empty-text");
    return d(), N(x, G({ "cell-class-name": P(F), data: P(u).list, "expand-row-keys": h.value, "row-style": L, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [l(ae, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (t) => h.value = t), data: P(u).list, fixed: "left", "row-key": "uid" }, { default: c(({ row: t }) => [V("div", se, [l(i, { modelValue: t.remark, "onUpdate:modelValue": (o) => t.remark = o, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", width: "110px" }), l(n, { align: "center", fixed: "left", label: "物料种类", "min-width": "150", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [l(p, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [b(V("span", null, null, 512), [[r, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(n, { align: "center", fixed: "left", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [l(p, { content: t.specificationLabels, placement: "top" }, { default: c(() => [b(V("span", null, null, 512), [[r, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), l(n, { align: "center", label: "计量单位", "min-width": "70px", prop: "measureUnit" }, { default: c(({ row: t }) => [b((d(), U("span", null, [R(C(t.measureUnit), 1)])), [[r]])]), _: 1 }), l(n, { align: "center", label: "数量", "min-width": "120px", prop: "quantity" }, { default: c(({ row: t }) => [t.measureUnit ? (d(), N(f, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, size: "default", step: 1, placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : b((d(), U("span", oe, null, 512)), [[r]])]), _: 1 }), l(n, { align: "center", label: "核算单位", "min-width": "70px", prop: "accountingUnit" }, { default: c(({ row: t }) => [b((d(), U("span", null, [R(C(t.accountingUnit), 1)])), [[r]])]), _: 1 }), l(n, { align: "center", label: "核算量", "min-width": "120px", prop: "mete" }, { default: c(({ row: t }) => [l(f, { modelValue: t.mete, "onUpdate:modelValue": (o) => t.mete = o, controls: false, max: 999999999, min: 0, precision: t.accountingPrecision, size: "default", step: 1, placeholder: "核算量", onChange: (o) => M(o, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), !m.boolPartyA && k.fillableAmount && e.noDetail ? (d(), N(le, { key: 0, "weight-attribute": "mete" })) : X("", true), l(n, { align: "center", label: "品牌", "min-width": "120px", prop: "brand" }, { default: c(({ row: t }) => [l(i, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(n, { align: "center", fixed: "right", label: "操作", width: "160" }, { default: c(({ row: t, $index: o }) => [l(y, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (K) => T(t, o) }, null, 8, ["onClick"]), l(y, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (K) => O(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} };
export {
  me as default
};
