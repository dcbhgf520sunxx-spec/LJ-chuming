import { inject as U } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as d } from "vue";
import { createBlock as g } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as h } from "vue";
import { withDirectives as J } from "vue";
import { createElementBlock as k } from "vue";
import { createTextVNode as Z } from "vue";
import { createCommentVNode as w } from "vue";
import { mergeProps as ee } from "vue";
import { reactive as te } from "vue";
import { watch as x } from "vue";
import { ElMessage as ae } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElInput as le } from "element-plus";
import { _ as se, am as C, sQ as oe, tC as ce, wc as f, wp as re, aw as ue, aI as de, sT as me, i as pe, iX as P, b as R, c9 as b } from "../../../../../../../shared/runtime.js";
const fe = { key: 1 }, ge = { key: 1 }, he = { key: 1 }, ye = { key: 1 }, _e = { __name: "steel-plate-table", emits: ["search-inventory"], setup(be, { expose: W, emit: L }) {
  const S = L, M = C.STEEL_PLATE.V, z = U("useInventoryInfo"), T = U("matSpecRef"), { baseUnit: o } = oe(M), { cu: c, form: u } = ce(), B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: b, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: b, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: b, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: b, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: b, message: "数量必须大于0", trigger: "blur" }] };
  function F({ row: e, rowIndex: n }) {
    var a, m;
    if ((m = (a = c == null ? void 0 : c.submitResult) == null ? void 0 : a.data) != null && m.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const { tableValidate: O, wrongCellMask: Y } = ue({ rules: B, errorMsg: "请修正【钢板清单】中标红的信息" });
  function $(e) {
    const n = te({ uid: de(), sn: e.sn, requisitionMode: f.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return E(n), n;
  }
  function D(e) {
    var n, a;
    return e.materialInventoryId && u.originInventoryInfo[e.materialInventoryId] ? ((a = (n = u.originInventoryInfo) == null ? void 0 : n[e.materialInventoryId]) == null ? void 0 : a.basicClass) & C.STEEL_COIL.V ? 1 : u.originInventoryInfo[e.materialInventoryId].quantity - u.originInventoryInfo[e.materialInventoryId].frozenQuantity - z.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function E(e) {
    x([() => e.length, () => e.width, () => e.thickness, o], () => Q(e)), x([() => e.theoryWeight, () => e.quantity], () => j(e));
  }
  async function Q(e) {
    e.theoryWeight = await me({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function j(e) {
    pe(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = P(e.theoryWeight * e.quantity, o.value.weight.precision), e.weighingTotalWeight = P(e.theoryWeight * e.quantity, o.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function A(e, n) {
    if (R(e.thickness)) {
      ae.warning("请填写厚度");
      return;
    }
    S("search-inventory", e, n);
  }
  function H(e, n, a) {
    var m, y, p, I;
    if ((y = (m = c == null ? void 0 : c.submitResult) == null ? void 0 : m.data) != null && y.includes(a.classifyId)) {
      const V = (p = c == null ? void 0 : c.submitResult) == null ? void 0 : p.data.findIndex((_) => _ === a.classifyId);
      u.steelPlateList.filter((_) => _.classifyId === a.classifyId).length === 1 && ((I = c == null ? void 0 : c.submitResult) == null || I.data.splice(V, 1));
    }
    T.value ? T.value.delListItem(e, n) : u.steelPlateList.splice(n, 1);
  }
  function K() {
    if (R(u.steelPlateList)) return true;
    const { validResult: e, dealList: n } = O(u.steelPlateList);
    return u.steelPlateList = n, e;
  }
  return W({ rowInit: $, rowWatch: E, validate: K }), (e, n) => {
    const a = ie, m = v("table-cell-tag"), y = ne, p = v("common-input-number"), I = le, V = v("common-button"), q = v("common-table"), _ = G("empty-text");
    return d(), g(q, ee({ "cell-class-name": i(Y), data: i(u).steelPlateList, "row-style": F, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: s(() => [l(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(a, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: s(({ row: t }) => [l(m, { name: i(f).USE_INVENTORY.L, show: t.requisitionMode === i(f).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), N("span", null, h(t.serialNumber), 1)]), _: 1 }), l(a, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(y, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [J(N("span", null, null, 512), [[_, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [l(y, { content: t.specificationLabels, placement: "top" }, { default: s(() => [N("span", null, h(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { label: `厚 (${i(o).thickness.unit})`, align: "center", prop: "thickness" }, { default: s(({ row: t }) => [t.requisitionMode !== i(f).USE_INVENTORY.V ? (d(), g(p, { key: 0, modelValue: t.thickness, "onUpdate:modelValue": (r) => t.thickness = r, controls: false, max: 999999, min: 0, precision: i(o).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), k("span", fe, h(t.thickness), 1))]), _: 1 }, 8, ["label"]), l(a, { label: `宽 (${i(o).width.unit})`, align: "center", prop: "width" }, { default: s(({ row: t }) => [t.requisitionMode !== i(f).USE_INVENTORY.V ? (d(), g(p, { key: 0, modelValue: t.width, "onUpdate:modelValue": (r) => t.width = r, controls: false, max: 999999, min: 0, precision: i(o).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), k("span", ge, h(t.width), 1))]), _: 1 }, 8, ["label"]), l(a, { label: `长 (${i(o).length.unit})`, align: "center", prop: "length" }, { default: s(({ row: t }) => [t.requisitionMode !== i(f).USE_INVENTORY.V ? (d(), g(p, { key: 0, modelValue: t.length, "onUpdate:modelValue": (r) => t.length = r, controls: false, max: 999999999, min: 0, precision: i(o).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (d(), k("span", he, h(t.length), 1))]), _: 1 }, 8, ["label"]), l(a, { label: `数量 (${i(o).measure.unit})`, align: "center", prop: "quantity" }, { default: s(({ row: t }) => [l(p, { modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, controls: false, max: D(t), min: 1, precision: i(o).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), l(a, { key: "weighingTotalWeight", label: `总重 (${i(o).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, null, 8, ["label"]), l(a, { align: "center", label: "品牌", prop: "brand" }, { default: s(({ row: t }) => [t.requisitionMode !== i(f).USE_INVENTORY.V ? (d(), g(I, { key: 0, modelValue: t.brand, "onUpdate:modelValue": (r) => t.brand = r, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), k("span", ye, h(t.brand || "-"), 1))]), _: 1 }), l(a, { align: "center", fixed: "right", label: "操作", width: "140" }, { default: s(({ row: t, $index: r }) => [i(u).type !== i(re).PUBLIC.V ? (d(), g(V, { key: 0, size: "default", type: "primary", onClick: (X) => A(t, r) }, { default: s(() => n[0] || (n[0] = [Z(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : w("", true), l(V, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (X) => H(t.sn, r, t) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, ve = se(_e, [["__scopeId", "data-v-9a1907fe"]]);
export {
  ve as default
};
