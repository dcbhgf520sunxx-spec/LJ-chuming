import { inject as P } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as d } from "vue";
import { createBlock as I } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as m } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as V } from "vue";
import { withDirectives as _ } from "vue";
import { createElementBlock as h } from "vue";
import { createTextVNode as N } from "vue";
import { createCommentVNode as Y } from "vue";
import { mergeProps as A } from "vue";
import { reactive as H } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { ElInput as G } from "element-plus";
import { tC as J, wc as U, wp as W, aw as X, aI as Z, c9 as w } from "../../../../../../../shared/runtime.js";
const ee = { key: 1 }, ie = { __name: "aux-mat-table", emits: ["search-inventory"], setup(te, { expose: R, emit: q }) {
  const k = q, E = P("useInventoryInfo"), x = P("matSpecRef"), { cu: s, form: c } = J(), S = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, i) => i.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: w, message: "核算量必须大于0", trigger: "blur" }] }, { tableValidate: M, wrongCellMask: z } = X({ rules: S });
  function L({ row: e, rowIndex: i }) {
    var a, u;
    if ((u = (a = s == null ? void 0 : s.submitResult) == null ? void 0 : a.data) != null && u.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function T(e) {
    return H({ uid: Z(), sn: e.sn, requisitionMode: U.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0 });
  }
  function F(e) {
    return e.materialInventoryId && c.originInventoryInfo[e.materialInventoryId] ? c.originInventoryInfo[e.materialInventoryId].quantity - c.originInventoryInfo[e.materialInventoryId].frozenQuantity - E.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function B(e, i) {
    k("search-inventory", e, i);
  }
  function D(e, i, a) {
    var u, f, p, y;
    if ((f = (u = s == null ? void 0 : s.submitResult) == null ? void 0 : u.data) != null && f.includes(a.classifyId)) {
      const b = (p = s == null ? void 0 : s.submitResult) == null ? void 0 : p.data.findIndex((r) => r === a.classifyId);
      c.list.filter((r) => r.classifyId === a.classifyId).length === 1 && ((y = s == null ? void 0 : s.submitResult) == null || y.data.splice(b, 1));
    }
    x.value ? x.value.delListItem(e, i) : c.list.splice(i, 1);
  }
  function Q() {
    const { validResult: e, dealList: i } = M(c.list);
    return c.list = i, e;
  }
  return R({ rowInit: T, validate: Q }), (e, i) => {
    const a = K, u = g("table-cell-tag"), f = $, p = g("common-input-number"), y = G, b = g("common-button"), C = g("common-table"), r = O("empty-text");
    return d(), I(C, A({ "cell-class-name": m(z), data: m(c).list, "row-style": L, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: n(() => [l(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(a, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [l(u, { name: m(U).USE_INVENTORY.L, show: t.requisitionMode === m(U).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), v("span", null, V(t.serialNumber), 1)]), _: 1 }), l(a, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [l(f, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [_(v("span", null, null, 512), [[r, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [l(f, { content: t.specificationLabels, placement: "top" }, { default: n(() => [_(v("span", null, null, 512), [[r, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: n(({ row: t }) => [_((d(), h("span", null, [N(V(t.measureUnit), 1)])), [[r]])]), _: 1 }), l(a, { align: "center", label: "数量", prop: "quantity" }, { default: n(({ row: t }) => [t.measureUnit ? (d(), I(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, max: F(t), min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : _((d(), h("span", ee, null, 512)), [[r]])]), _: 1 }), l(a, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: n(({ row: t }) => [_((d(), h("span", null, [N(V(t.accountingUnit), 1)])), [[r]])]), _: 1 }), l(a, { align: "center", label: "核算量", prop: "mete" }, { default: n(({ row: t }) => [l(p, { modelValue: t.mete, "onUpdate:modelValue": (o) => t.mete = o, controls: false, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), l(a, { align: "center", label: "颜色", prop: "color" }, { default: n(({ row: t }) => [l(y, { modelValue: t.color, "onUpdate:modelValue": (o) => t.color = o, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { align: "center", label: "品牌", prop: "brand" }, { default: n(({ row: t }) => [l(y, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(a, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: n(({ row: t, $index: o }) => [m(c).type !== m(W).PUBLIC.V ? (d(), I(b, { key: 0, size: "default", type: "primary", onClick: (j) => B(t, o) }, { default: n(() => i[0] || (i[0] = [N(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : Y("", true), l(b, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => D(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ie as default
};
