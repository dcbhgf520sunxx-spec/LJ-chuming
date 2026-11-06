import { inject as q } from "vue";
import { computed as ne } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as g } from "vue";
import { createBlock as V } from "vue";
import { withCtx as c } from "vue";
import { createVNode as s } from "vue";
import { unref as a } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as b } from "vue";
import { withDirectives as oe } from "vue";
import { createElementBlock as N } from "vue";
import x from "moment";
import { createTextVNode as ce } from "vue";
import { mergeProps as de } from "vue";
import { reactive as re } from "vue";
import { watch as L } from "vue";
import { ElTableColumn as ue } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { ElDatePicker as pe } from "element-plus";
import { _ as fe, am as S, sQ as ge, tC as he, fE as ye, v5 as be, wc as h, fv as _e, b as T, c9 as R, aw as Ie, aI as ve, sT as Ve, i as W, iX as j } from "../../../../../../../shared/runtime.js";
const Te = { key: 1 }, Ue = { key: 1 }, Ne = { key: 1 }, ke = { __name: "steel-plate-table", emits: ["search-inventory"], setup(Pe, { expose: B, emit: O }) {
  const M = O, z = S.STEEL_PLATE.V, $ = q("useInventoryInfo"), k = q("matSpecRef"), { baseUnit: r } = ge(z), { cu: u, form: i } = he(), D = (e, n) => W(e) ? e >= 0 : true, F = ne(() => {
    let e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: R, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: R, message: "重量必须大于0", trigger: "blur" }], quantity: [{ validator: D, message: "数量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return i.level === ye.CONSTRUCTION_SITE.V && (e = Object.assign(e, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), e;
  });
  function Y({ row: e, rowIndex: n }) {
    var l, d;
    if ((d = (l = u == null ? void 0 : u.submitResult) == null ? void 0 : l.data) != null && d.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const A = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: Q, wrongCellMask: H, cleanUpData: J } = Ie({ rules: F, ditto: A, errorMsg: "请修正【钢板清单】中标红的信息" }), { projectAllType: K } = be();
  function X(e) {
    var l, d;
    const n = re({ uid: ve(), sn: e.sn, requisitionMode: h.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, arrivalTime: ((l = i.steelPlateList) == null ? void 0 : l.length) > 0 ? "同上" : void 0, projectId: ((d = i.steelPlateList) == null ? void 0 : d.length) > 0 ? -1 : void 0, project: void 0 });
    return P(n), n;
  }
  function G(e) {
    var n, l;
    return e.materialInventoryId && i.originInventoryInfo[e.materialInventoryId] ? ((l = (n = i.originInventoryInfo) == null ? void 0 : n[e.materialInventoryId]) == null ? void 0 : l.basicClass) & S.STEEL_COIL.V ? 1 : i.originInventoryInfo[e.materialInventoryId].quantity - i.originInventoryInfo[e.materialInventoryId].frozenQuantity - $.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function P(e) {
    L([() => e.length, () => e.width, () => e.thickness, r], () => Z(e), { immediate: true }), L([() => e.theoryWeight, () => e.quantity], () => w(e), { immediate: true });
  }
  async function Z(e) {
    e.theoryWeight = await Ve({ name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function w(e) {
    W(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = j(e.theoryWeight * e.quantity, r.value.weight.precision), e.weighingTotalWeight = j(e.theoryWeight * e.quantity, r.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ee(e, n) {
    M("search-inventory", e, n);
  }
  function te(e, n, l) {
    var d, p, m, _;
    if ((p = (d = u == null ? void 0 : u.submitResult) == null ? void 0 : d.data) != null && p.includes(l.classifyId)) {
      const I = (m = u == null ? void 0 : u.submitResult) == null ? void 0 : m.data.findIndex((y) => y === l.classifyId);
      i.list.filter((y) => y.classifyId === l.classifyId).length === 1 && ((_ = u == null ? void 0 : u.submitResult) == null || _.data.splice(I, 1));
    }
    k.value ? k.value.delListItem(e, n) : i.steelPlateList.splice(n, 1);
  }
  function ae() {
    if (T(i.steelPlateList)) return true;
    const { validResult: e, dealList: n } = Q(i.steelPlateList);
    return C(n), e;
  }
  function le() {
    if (T(i.steelPlateList)) return true;
    const e = i.steelPlateList.filter((n) => true);
    C(e);
  }
  function C(e) {
    const n = JSON.parse(JSON.stringify(e));
    J(n), n.forEach((l, d) => {
      var p;
      i.steelPlateList[d].projectId = l.projectId, i.steelPlateList[d].project = (p = K.value) == null ? void 0 : p.find((m) => i.steelPlateList[d].projectId === m.id), i.steelPlateList[d].arrivalTime = l.arrivalTime;
    });
  }
  function ie(e) {
    e.projectId = void 0, e.project = void 0;
  }
  return B({ rowInit: X, rowWatch: P, validate: ae, TSValidate: le }), (e, n) => {
    const l = ue, d = v("table-cell-tag"), p = me, m = v("common-input-number"), _ = pe, I = v("common-button"), E = v("common-table"), y = se("empty-text");
    return g(), V(E, de({ "cell-class-name": a(H), data: a(i).steelPlateList, "row-style": Y, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [s(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: c(({ row: t }) => [s(d, { name: a(h).USE_INVENTORY.L, show: t.requisitionMode === a(h).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), U("span", null, b(t.serialNumber), 1)]), _: 1 }), s(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [s(p, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [oe(U("span", null, null, 512), [[y, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [s(p, { content: t.specificationLabels, placement: "top" }, { default: c(() => [U("span", null, b(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(l, { label: `厚 (${a(r).thickness.unit})`, align: "center", prop: "thickness" }, { default: c(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (g(), V(m, { key: 0, modelValue: t.thickness, "onUpdate:modelValue": (o) => t.thickness = o, controls: false, disabled: !!a(i).boolUsed, max: 999999, min: 0, precision: a(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (g(), N("span", Te, b(t.thickness), 1))]), _: 1 }, 8, ["label"]), s(l, { label: `宽 (${a(r).width.unit})`, align: "center", prop: "width" }, { default: c(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (g(), V(m, { key: 0, modelValue: t.width, "onUpdate:modelValue": (o) => t.width = o, controls: false, disabled: !!a(i).boolUsed, max: 999999, min: 0, precision: a(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (g(), N("span", Ue, b(t.width), 1))]), _: 1 }, 8, ["label"]), s(l, { label: `长 (${a(r).length.unit})`, align: "center", prop: "length" }, { default: c(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (g(), V(m, { key: 0, modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, disabled: !!a(i).boolUsed, max: 999999999, min: 0, precision: a(r).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (g(), N("span", Ne, b(t.length), 1))]), _: 1 }, 8, ["label"]), s(l, { label: `数量 (${a(r).measure.unit})`, align: "center", prop: "quantity" }, { default: c(({ row: t }) => [s(m, { modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, disabled: !!a(i).boolUsed, max: G(t), min: 1, precision: a(r).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])]), _: 1 }, 8, ["label"]), s(l, { key: "weighingTotalWeight", label: `总重 (${a(r).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => [s(m, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, controls: false, disabled: !!a(i).boolUsed, max: 999999999, min: 0, precision: a(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(l, { key: "projectId", align: "center", label: "项目", prop: "projectId" }, { default: c(({ row: t, $index: o }) => [s(_e, { modelValue: t.projectId, "onUpdate:modelValue": (f) => t.projectId = f, branchCompanyId: a(i).branchCompanyId, disabled: a(T)(a(i).branchCompanyId) || !!a(i).boolUsed, isLumpSum: false, isNotInternalContractSystem: true, "show-extra": o !== 0, clearable: "", style: { width: "100%" }, onClear: (f) => ie(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(l, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: c(({ row: t, $index: o }) => [s(_, { modelValue: t.arrivalTime, "onUpdate:modelValue": (f) => t.arrivalTime = f, disabled: !!a(i).boolUsed, disabledDate: (f) => a(x)(f).valueOf() < a(x)().subtract(1, "days").valueOf(), placeholder: o === 0 || a(T)(t.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(l, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: c(({ row: t, $index: o }) => [s(I, { size: "default", type: "primary", onClick: (f) => ee(t, o) }, { default: c(() => n[0] || (n[0] = [ce(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), s(l, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: o }) => [s(I, { disabled: !!a(i).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (f) => te(t.sn, o, t) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, qe = fe(ke, [["__scopeId", "data-v-3e8d75bc"]]);
export {
  qe as default
};
