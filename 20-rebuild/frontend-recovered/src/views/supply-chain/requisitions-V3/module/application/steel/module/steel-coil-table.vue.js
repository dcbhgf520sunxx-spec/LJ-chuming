import { computed as te } from "vue";
import { inject as le } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as d } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as b } from "vue";
import { withDirectives as ie } from "vue";
import { createElementBlock as I } from "vue";
import R from "moment";
import { createTextVNode as se } from "vue";
import { mergeProps as ne } from "vue";
import { reactive as oe } from "vue";
import { watch as x } from "vue";
import { ElTableColumn as de } from "element-plus";
import { ElTooltip as ce } from "element-plus";
import { ElInput as re } from "element-plus";
import { ElDatePicker as ue } from "element-plus";
import { am as me, fE as pe, sQ as fe, tC as ge, v5 as he, wc as h, fv as be, b as N, c9 as k, aw as _e, aI as ye, va as Ve, i as j } from "../../../../../../../shared/runtime.js";
const Ce = { key: 1 }, Ie = { key: 1 }, Ne = { key: 1 }, Te = { key: 1 }, Le = { __name: "steel-coil-table", emits: ["search-inventory"], setup(Ue, { expose: q, emit: B }) {
  const M = B, O = me.STEEL_COIL.V, P = (e, s) => j(e) ? e > 0 : true, W = te(() => {
    let e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: k, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: k, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: k, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: P, message: "长度必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return i.level === pe.CONSTRUCTION_SITE.V && (e = Object.assign(e, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), e;
  }), L = le("matSpecRef"), { baseUnit: g } = fe(O), { cu: r, form: i } = ge();
  function z({ row: e, rowIndex: s }) {
    var l, c;
    if ((c = (l = r == null ? void 0 : r.submitResult) == null ? void 0 : l.data) != null && c.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const D = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: $, wrongCellMask: F, cleanUpData: Y } = _e({ rules: W, ditto: D, errorMsg: "请修正【钢卷清单】中标红的信息" }), { projectAllType: w } = he();
  function A(e) {
    var l, c;
    const s = oe({ uid: ye(), sn: e.sn, requisitionMode: h.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, arrivalTime: ((l = i.steelCoilList) == null ? void 0 : l.length) > 0 ? "同上" : void 0, projectId: ((c = i.steelCoilList) == null ? void 0 : c.length) > 0 ? -1 : void 0, project: void 0 });
    return E(s), s;
  }
  function E(e) {
    x([() => e.weighingTotalWeight, () => e.width, () => e.thickness, g], () => H(e), { immediate: true }), x([() => e.theoryLength], () => J(e), { immediate: true });
  }
  async function H(e) {
    e.theoryLength = await Ve({ name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function J(e) {
    j(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function K(e, s) {
    M("search-inventory", e, s);
  }
  function Q(e, s, l) {
    var c, p, u, V;
    if ((p = (c = r == null ? void 0 : r.submitResult) == null ? void 0 : c.data) != null && p.includes(l.classifyId)) {
      const T = (u = r == null ? void 0 : r.submitResult) == null ? void 0 : u.data.findIndex((_) => _ === l.classifyId);
      i.list.filter((_) => _.classifyId === l.classifyId).length === 1 && ((V = r == null ? void 0 : r.submitResult) == null || V.data.splice(T, 1));
    }
    L.value ? L.value.delListItem(e, s) : i.steelCoilList.splice(s, 1);
  }
  function G() {
    if (N(i.steelCoilList)) return true;
    const { validResult: e, dealList: s } = $(i.steelCoilList);
    return S(s), i.steelCoilList.forEach((l) => {
      l.quantity = l.length;
    }), e;
  }
  function X() {
    if (N(i.steelCoilList)) return true;
    const e = i.steelCoilList.filter((s) => true);
    S(e), i.steelCoilList.forEach((s) => {
      s.quantity = s.length;
    });
  }
  function S(e) {
    const s = JSON.parse(JSON.stringify(e));
    Y(s), s.forEach((l, c) => {
      var p;
      i.steelCoilList[c].projectId = l.projectId, i.steelCoilList[c].project = (p = w.value) == null ? void 0 : p.find((u) => i.steelCoilList[c].projectId === u.id), i.steelCoilList[c].arrivalTime = l.arrivalTime;
    });
  }
  function Z(e) {
    e.projectId = void 0, e.project = void 0;
  }
  return q({ rowInit: A, rowWatch: E, validate: G, TSValidate: X }), (e, s) => {
    const l = de, c = C("table-cell-tag"), p = ce, u = C("common-input-number"), V = re, T = ue, U = C("common-button"), _ = C("common-table"), ee = ae("empty-text");
    return m(), y(_, ne({ "cell-class-name": a(F), data: a(i).steelCoilList, "row-style": z, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: d(() => [n(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), n(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: d(({ row: t }) => [n(c, { name: a(h).USE_INVENTORY.L, show: t.requisitionMode === a(h).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), v("span", null, b(t.serialNumber), 1)]), _: 1 }), n(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: d(({ row: t }) => [n(p, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: d(() => [ie(v("span", null, null, 512), [[ee, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: d(({ row: t }) => [n(p, { content: t.specificationLabels, placement: "top" }, { default: d(() => [v("span", null, b(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), n(l, { key: "weighingTotalWeight", label: `总重 (${a(g).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: d(({ row: t }) => [n(u, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, controls: false, disabled: !!a(i).boolUsed, max: 999999999, min: 0, precision: a(g).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), n(l, { label: `厚 (${a(g).thickness.unit})`, align: "center", prop: "thickness" }, { default: d(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (m(), y(u, { key: 0, modelValue: t.thickness, "onUpdate:modelValue": (o) => t.thickness = o, controls: false, disabled: !!a(i).boolUsed, max: 999999, min: 0, precision: a(g).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (m(), I("span", Ce, b(t.thickness), 1))]), _: 1 }, 8, ["label"]), n(l, { label: `宽 (${a(g).width.unit})`, align: "center", prop: "width" }, { default: d(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (m(), y(u, { key: 0, modelValue: t.width, "onUpdate:modelValue": (o) => t.width = o, controls: false, disabled: !!a(i).boolUsed, max: 999999, min: 0, precision: a(g).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (m(), I("span", Ie, b(t.width), 1))]), _: 1 }, 8, ["label"]), n(l, { label: "长 (m)", align: "center", prop: "length" }, { default: d(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (m(), y(u, { key: 0, modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, disabled: !!a(i).boolUsed, max: 999999999, min: 0, precision: t.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (m(), I("span", Ne, b(t.length), 1))]), _: 1 }), n(l, { align: "center", label: "颜色", prop: "color" }, { default: d(({ row: t }) => [t.requisitionMode !== a(h).USE_INVENTORY.V ? (m(), y(V, { key: 0, modelValue: t.color, "onUpdate:modelValue": (o) => t.color = o, modelModifiers: { trim: true }, disabled: !!a(i).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : (m(), I("span", Te, b(t.color), 1))]), _: 1 }), n(l, { key: "projectId", align: "center", label: "项目", prop: "projectId" }, { default: d(({ row: t, $index: o }) => [n(be, { modelValue: t.projectId, "onUpdate:modelValue": (f) => t.projectId = f, branchCompanyId: a(i).branchCompanyId, disabled: a(N)(a(i).branchCompanyId) && !!a(i).boolUsed, isLumpSum: false, isNotInternalContractSystem: true, "show-extra": o !== 0, clearable: "", style: { width: "100%" }, onClear: (f) => Z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), n(l, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: d(({ row: t, $index: o }) => [n(T, { modelValue: t.arrivalTime, "onUpdate:modelValue": (f) => t.arrivalTime = f, disabled: !!a(i).boolUsed, disabledDate: (f) => a(R)(f).valueOf() < a(R)().subtract(1, "days").valueOf(), placeholder: o === 0 || a(N)(t.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), n(l, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: d(({ row: t, $index: o }) => [n(U, { size: "default", type: "primary", onClick: (f) => K(t, o) }, { default: d(() => s[0] || (s[0] = [se(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), n(l, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: d(({ row: t, $index: o }) => [n(U, { disabled: !!a(i).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (f) => Q(t.sn, o, t) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  Le as default
};
