import { inject as C } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as m } from "vue";
import { createBlock as I } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as v } from "vue";
import { withDirectives as J } from "vue";
import { createElementBlock as U } from "vue";
import { createTextVNode as Z } from "vue";
import { createCommentVNode as w } from "vue";
import { mergeProps as ee } from "vue";
import { reactive as te } from "vue";
import { watch as V } from "vue";
import { ElTableColumn as ne } from "element-plus";
import { ElTooltip as ae } from "element-plus";
import { ElInput as ie } from "element-plus";
import { am as le, sQ as se, tC as oe, wc as h, wp as ce, aw as ue, aI as re, sU as de, i as E, v9 as me, iX as L, b as ge, c9 as q } from "../../../../../../../shared/runtime.js";
const fe = { key: 1 }, pe = { key: 1 }, _e = { __name: "section-steel-table", emits: ["search-inventory"], setup(he, { expose: k, emit: x }) {
  const R = x, P = le.SECTION_STEEL.V, M = C("useInventoryInfo"), T = C("matSpecRef"), { baseUnit: u } = se(P), { cu: s, form: c } = oe(), B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: q, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: q, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: q, message: "重量必须大于0", trigger: "blur" }] };
  function z({ row: e, rowIndex: i }) {
    var n, d;
    if ((d = (n = s == null ? void 0 : s.submitResult) == null ? void 0 : n.data) != null && d.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const { tableValidate: O, wrongCellMask: F } = ue({ rules: B, errorMsg: "请修正【型材清单】中标红的信息" });
  function D(e) {
    const i = te({ uid: re(), sn: e.sn, requisitionMode: h.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false });
    return W(i), i;
  }
  function Y(e) {
    return e.materialInventoryId && c.originInventoryInfo[e.materialInventoryId] ? c.originInventoryInfo[e.materialInventoryId].quantity - c.originInventoryInfo[e.materialInventoryId].frozenQuantity - M.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function W(e) {
    V([() => e.length, () => e.unitWeight, u], () => $(e)), V([() => e.theoryWeight, () => e.quantity], () => {
      j(e);
    }), V([() => e.length, () => e.quantity], () => {
      Q(e);
    });
  }
  async function $(e) {
    e.theoryWeight = await de({ length: e.length, unitWeight: e.unitWeight });
  }
  function Q(e) {
    E(e.length) && e.quantity ? e.totalLength = me({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function j(e) {
    E(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = L(e.theoryWeight * e.quantity, u.value.weight.precision), e.weighingTotalWeight = L(e.theoryWeight * e.quantity, u.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function A(e, i) {
    R("search-inventory", e, i);
  }
  function H(e, i, n) {
    var d, g, f, y;
    if ((g = (d = s == null ? void 0 : s.submitResult) == null ? void 0 : d.data) != null && g.includes(n.classifyId)) {
      const b = (f = s == null ? void 0 : s.submitResult) == null ? void 0 : f.data.findIndex((p) => p === n.classifyId);
      c.sectionSteelList.filter((p) => p.classifyId === n.classifyId).length === 1 && ((y = s == null ? void 0 : s.submitResult) == null || y.data.splice(b, 1));
    }
    T.value ? T.value.delListItem(e, i) : c.sectionSteelList.splice(i, 1);
  }
  function K() {
    if (ge(c.sectionSteelList)) return true;
    const { validResult: e, dealList: i } = O(c.sectionSteelList);
    return c.sectionSteelList = i, e;
  }
  return k({ rowInit: D, rowWatch: W, validate: K }), (e, i) => {
    const n = ne, d = _("table-cell-tag"), g = ae, f = _("common-input-number"), y = ie, b = _("common-button"), S = _("common-table"), p = G("empty-text");
    return m(), I(S, ee({ "cell-class-name": l(F), data: l(c).sectionSteelList, "row-style": z, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: o(() => [a(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), a(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: o(({ row: t }) => [a(d, { name: l(h).USE_INVENTORY.L, show: t.requisitionMode === l(h).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), N("span", null, v(t.serialNumber), 1)]), _: 1 }), a(n, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(g, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [J(N("span", null, null, 512), [[p, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(g, { content: t.specificationLabels, placement: "top" }, { default: o(() => [N("span", null, v(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(n, { label: `定尺长度 (${l(u).length.unit})`, align: "center", prop: "length" }, { default: o(({ row: t }) => [t.requisitionMode !== l(h).USE_INVENTORY.V ? (m(), I(f, { key: 0, modelValue: t.length, "onUpdate:modelValue": (r) => t.length = r, controls: false, max: 999999999, min: 0, precision: l(u).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (m(), U("span", fe, v(t.length), 1))]), _: 1 }, 8, ["label"]), a(n, { label: `数量 (${l(u).measure.unit})`, align: "center", prop: "quantity" }, { default: o(({ row: t }) => [a(f, { modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, controls: false, max: Y(t), min: 1, precision: l(u).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), a(n, { label: "总长度 (m)", align: "center", prop: "totalLength" }), a(n, { key: "weighingTotalWeight", label: `总重 (${l(u).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, null, 8, ["label"]), a(n, { align: "center", label: "品牌", prop: "brand" }, { default: o(({ row: t }) => [t.requisitionMode !== l(h).USE_INVENTORY.V ? (m(), I(y, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (r) => t.brand = r, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (m(), U("span", pe, v(t.brand), 1))]), _: 1 }), a(n, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: o(({ row: t, $index: r }) => [l(c).type !== l(ce).PUBLIC.V ? (m(), I(b, { key: 0, size: "default", type: "primary", onClick: (X) => A(t, r) }, { default: o(() => i[0] || (i[0] = [Z(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : w("", true), a(b, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (X) => H(t.sn, r, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  _e as default
};
