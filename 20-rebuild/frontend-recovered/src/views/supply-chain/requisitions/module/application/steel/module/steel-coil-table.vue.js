import { inject as A } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as d } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { unref as i } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as h } from "vue";
import { withDirectives as K } from "vue";
import { createElementBlock as V } from "vue";
import { createTextVNode as Q } from "vue";
import { createCommentVNode as G } from "vue";
import { mergeProps as J } from "vue";
import { reactive as X } from "vue";
import { watch as T } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTableColumn as w } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { am as le, sQ as ie, tC as ae, wc as u, wp as se, aw as ne, aI as oe, va as ce, i as de, b as x, c9 as C } from "../../../../../../../shared/runtime.js";
const re = { key: 1 }, ue = { key: 1 }, me = { key: 1 }, pe = { key: 1 }, fe = { key: 1 }, ye = { __name: "steel-coil-table", emits: ["search-inventory"], setup(ge, { expose: R, emit: v }) {
  const q = v, M = le.STEEL_COIL.V, S = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: C, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: C, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: C, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: C, message: "长度必须大于0", trigger: "blur" }] }, E = A("matSpecRef"), { baseUnit: m } = ie(M), { cu: c, form: r } = ae();
  function P({ row: e, rowIndex: o }) {
    var l, p;
    if ((p = (l = c == null ? void 0 : c.submitResult) == null ? void 0 : l.data) != null && p.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const { tableValidate: W, wrongCellMask: z } = ne({ rules: S, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function B(e) {
    const o = X({ uid: oe(), sn: e.sn, requisitionMode: u.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0 });
    return I(o), o;
  }
  function I(e) {
    T([() => e.weighingTotalWeight, () => e.width, () => e.thickness, m], () => O(e)), T([() => e.theoryLength], () => F(e));
  }
  async function O(e) {
    e.theoryLength = await ce({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function F(e) {
    de(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function Y(e, o) {
    if (x(e.thickness)) {
      Z.warning("请填写厚度");
      return;
    }
    q("search-inventory", e, o);
  }
  function D(e, o, l) {
    var p, _, f, y;
    if ((_ = (p = c == null ? void 0 : c.submitResult) == null ? void 0 : p.data) != null && _.includes(l.classifyId)) {
      const k = (f = c == null ? void 0 : c.submitResult) == null ? void 0 : f.data.findIndex((b) => b === l.classifyId);
      r.steelCoilList.filter((b) => b.classifyId === l.classifyId).length === 1 && ((y = c == null ? void 0 : c.submitResult) == null || y.data.splice(k, 1));
    }
    E.value ? E.value.delListItem(e, o) : r.steelCoilList.splice(o, 1);
  }
  function $() {
    if (x(r.steelCoilList)) return true;
    const { validResult: e, dealList: o } = W(r.steelCoilList);
    return r.steelCoilList = o, r.steelCoilList.forEach((l) => {
      l.quantity = l.length;
    }), e;
  }
  return R({ rowInit: B, rowWatch: I, validate: $ }), (e, o) => {
    const l = w, p = N("table-cell-tag"), _ = ee, f = N("common-input-number"), y = te, k = N("common-button"), L = N("common-table"), b = H("empty-text");
    return d(), g(L, J({ "cell-class-name": i(z), data: i(r).steelCoilList, "row-style": P, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: n(() => [a(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), a(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: n(({ row: t }) => [a(p, { name: i(u).USE_INVENTORY.L, show: t.requisitionMode === i(u).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), U("span", null, h(t.serialNumber), 1)]), _: 1 }), a(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [a(_, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [K(U("span", null, null, 512), [[b, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [a(_, { content: t.specificationLabels, placement: "top" }, { default: n(() => [U("span", null, h(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(l, { key: "weighingTotalWeight", label: `总重 (${i(m).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: n(({ row: t }) => [a(f, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (s) => t.weighingTotalWeight = s, controls: false, max: 999999999, min: 0, precision: i(m).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), a(l, { label: `厚 (${i(m).thickness.unit})`, align: "center", prop: "thickness" }, { default: n(({ row: t }) => [t.requisitionMode !== i(u).USE_INVENTORY.V ? (d(), g(f, { key: 0, modelValue: t.thickness, "onUpdate:modelValue": (s) => t.thickness = s, controls: false, max: 999999, min: 0, precision: i(m).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), V("span", re, h(t.thickness), 1))]), _: 1 }, 8, ["label"]), a(l, { label: `宽 (${i(m).width.unit})`, align: "center", prop: "width" }, { default: n(({ row: t }) => [t.requisitionMode !== i(u).USE_INVENTORY.V ? (d(), g(f, { key: 0, modelValue: t.width, "onUpdate:modelValue": (s) => t.width = s, controls: false, max: 999999, min: 0, precision: i(m).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), V("span", ue, h(t.width), 1))]), _: 1 }, 8, ["label"]), a(l, { label: "长 (m)", align: "center", prop: "length" }, { default: n(({ row: t }) => [t.requisitionMode !== i(u).USE_INVENTORY.V ? (d(), g(f, { key: 0, modelValue: t.length, "onUpdate:modelValue": (s) => t.length = s, controls: false, max: 999999999, min: 0, precision: t.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), V("span", me, h(t.length), 1))]), _: 1 }), a(l, { align: "center", label: "颜色", prop: "color" }, { default: n(({ row: t }) => [t.requisitionMode !== i(u).USE_INVENTORY.V ? (d(), g(y, { key: 0, modelValue: t.color, "onUpdate:modelValue": (s) => t.color = s, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), V("span", pe, h(t.color), 1))]), _: 1 }), a(l, { align: "center", label: "品牌", prop: "brand" }, { default: n(({ row: t }) => [t.requisitionMode !== i(u).USE_INVENTORY.V ? (d(), g(y, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (s) => t.brand = s, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), V("span", fe, h(t.brand), 1))]), _: 1 }), a(l, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: n(({ row: t, $index: s }) => [i(r).type !== i(se).PUBLIC.V ? (d(), g(k, { key: 0, size: "default", type: "primary", onClick: (j) => Y(t, s) }, { default: n(() => o[0] || (o[0] = [Q(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : G("", true), a(k, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => D(t.sn, s, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ye as default
};
