import { inject as q } from "vue";
import { computed as le } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as v } from "vue";
import { createBlock as W } from "vue";
import { withCtx as c } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { createElementVNode as T } from "vue";
import { toDisplayString as V } from "vue";
import { withDirectives as oe } from "vue";
import { createElementBlock as ce } from "vue";
import j from "moment";
import { createTextVNode as re } from "vue";
import { mergeProps as de } from "vue";
import { reactive as ue } from "vue";
import { watch as N } from "vue";
import { ElTableColumn as fe } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { ElDatePicker as pe } from "element-plus";
import { am as ge, sQ as he, tC as ye, fE as be, v5 as _e, wc as I, fv as Ie, b as S, c9 as x, aw as Se, cP as k, aI as ve, sU as Te, i as C, v9 as Ve, iX as R } from "../../../../../../../shared/runtime.js";
const Ne = { key: 1 }, Ee = { __name: "section-steel-table", emits: ["search-inventory"], setup(Ce, { expose: O, emit: P }) {
  const B = P, M = ge.SECTION_STEEL.V, D = q("useInventoryInfo"), U = q("matSpecRef"), { baseUnit: m } = he(M), { cu: d, form: i } = ye(), z = (e, s) => C(e) ? e >= 0 : true, $ = le(() => {
    let e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: x, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ validator: z, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: x, message: "重量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return i.level === be.CONSTRUCTION_SITE.V && (e = Object.assign(e, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), e;
  });
  function F({ row: e, rowIndex: s }) {
    var a, o;
    if ((o = (a = d == null ? void 0 : d.submitResult) == null ? void 0 : a.data) != null && o.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const A = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: Q, wrongCellMask: Y, cleanUpData: H } = Se({ rules: $, ditto: A, errorMsg: "请修正【型材清单】中标红的信息" }), { projectAllType: J } = _e();
  function K(e) {
    var o, u, f, y;
    let s;
    e.classify.basicClass === k.SECTION_STEEL.V && (s = (u = (o = e.nationalStandardOptions) == null ? void 0 : o.find((p) => p.boolDefault === true)) == null ? void 0 : u.standardId);
    const a = ue({ uid: ve(), sn: e.sn, requisitionMode: I.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, arrivalTime: ((f = i.sectionSteelList) == null ? void 0 : f.length) > 0 ? "同上" : void 0, projectId: ((y = i.sectionSteelList) == null ? void 0 : y.length) > 0 ? -1 : void 0, project: void 0, standardId: s, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0 });
    if (e.classify.basicClass === k.SECTION_STEEL.V) {
      let p;
      const b = [];
      for (const g in a.specificationMap) g.indexOf("standard") > -1 ? p = a.specificationMap[g] : b.push(a.specificationMap[g]);
      a.sectionSteelSpec = p, a.doNotSectionSteelSpec = b.join(" * ");
    }
    return L(a), a;
  }
  function X(e) {
    return e.materialInventoryId && i.originInventoryInfo[e.materialInventoryId] ? i.originInventoryInfo[e.materialInventoryId].quantity - i.originInventoryInfo[e.materialInventoryId].frozenQuantity - D.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function L(e) {
    N([() => e.length, () => e.unitWeight, m], () => G(e), { immediate: true }), N([() => e.theoryWeight, () => e.quantity], () => {
      w(e);
    }, { immediate: true }), N([() => e.length, () => e.quantity], () => {
      Z(e);
    }, { immediate: true });
  }
  async function G(e) {
    e.theoryWeight = await Te({ length: e.length, unitWeight: e.unitWeight });
  }
  function Z(e) {
    C(e.length) && e.quantity ? e.totalLength = Ve({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function w(e) {
    C(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = R(e.theoryWeight * e.quantity, m.value.weight.precision), e.weighingTotalWeight = R(e.theoryWeight * e.quantity, m.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function ee(e, s) {
    B("search-inventory", e, s);
  }
  function te(e, s, a) {
    var o, u, f, y;
    if ((u = (o = d == null ? void 0 : d.submitResult) == null ? void 0 : o.data) != null && u.includes(a.classifyId)) {
      const p = (f = d == null ? void 0 : d.submitResult) == null ? void 0 : f.data.findIndex((g) => g === a.classifyId);
      i.list.filter((g) => g.classifyId === a.classifyId).length === 1 && ((y = d == null ? void 0 : d.submitResult) == null || y.data.splice(p, 1));
    }
    U.value ? U.value.delListItem(e, s) : i.sectionSteelList.splice(s, 1);
  }
  function ae() {
    if (S(i.sectionSteelList)) return true;
    const { validResult: e, dealList: s } = Q(i.sectionSteelList);
    return E(s), e;
  }
  function ie() {
    if (S(i.sectionSteelList)) return true;
    const e = i.sectionSteelList.filter((s) => true);
    E(e);
  }
  function E(e) {
    const s = JSON.parse(JSON.stringify(e));
    H(s), s.forEach((a, o) => {
      var u;
      i.sectionSteelList[o].projectId = a.projectId, i.sectionSteelList[o].project = (u = J.value) == null ? void 0 : u.find((f) => i.sectionSteelList[o].projectId === f.id), i.sectionSteelList[o].arrivalTime = a.arrivalTime;
    });
  }
  function ne(e) {
    e.projectId = void 0, e.project = void 0;
  }
  return O({ rowInit: K, rowWatch: L, validate: ae, TSValidate: ie }), (e, s) => {
    const a = fe, o = _("table-cell-tag"), u = me, f = _("common-input-number"), y = pe, p = _("common-button"), b = _("common-table"), g = se("empty-text");
    return v(), W(b, de({ "cell-class-name": n(Y), data: n(i).sectionSteelList, "row-style": F, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [l(a, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(a, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: c(({ row: t }) => [l(o, { name: n(I).USE_INVENTORY.L, show: t.requisitionMode === n(I).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), T("span", null, V(t.serialNumber), 1)]), _: 1 }), l(a, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [l(u, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [oe(T("span", null, null, 512), [[g, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(a, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [l(u, { content: t.specificationLabels, placement: "top" }, { default: c(() => [T("span", null, V(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(a, { label: `定尺长度 (${n(m).length.unit})`, align: "center", prop: "length" }, { default: c(({ row: t }) => [t.requisitionMode !== n(I).USE_INVENTORY.V ? (v(), W(f, { key: 0, modelValue: t.length, "onUpdate:modelValue": (r) => t.length = r, controls: false, disabled: !!n(i).boolUsed, max: 999999999, min: 0, precision: n(m).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (v(), ce("span", Ne, V(t.length), 1))]), _: 1 }, 8, ["label"]), l(a, { label: `数量 (${n(m).measure.unit})`, align: "center", prop: "quantity" }, { default: c(({ row: t }) => [l(f, { modelValue: t.quantity, "onUpdate:modelValue": (r) => t.quantity = r, controls: false, disabled: !!n(i).boolUsed, max: X(t), min: 1, precision: n(m).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])]), _: 1 }, 8, ["label"]), l(a, { label: "总长度 (m)", align: "center", prop: "totalLength" }), l(a, { key: "weighingTotalWeight", label: `总重 (${n(m).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => [l(f, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (r) => t.weighingTotalWeight = r, controls: false, disabled: !!n(i).boolUsed, max: 999999999, min: 0, precision: n(m).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), l(a, { key: "projectId", align: "center", label: "项目", prop: "projectId" }, { default: c(({ row: t, $index: r }) => [l(Ie, { modelValue: t.projectId, "onUpdate:modelValue": (h) => t.projectId = h, branchCompanyId: n(i).branchCompanyId, disabled: n(S)(n(i).branchCompanyId) || !!n(i).boolUsed, isLumpSum: false, isNotInternalContractSystem: true, "show-extra": r !== 0, clearable: "", style: { width: "100%" }, onClear: (h) => ne(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), l(a, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: c(({ row: t, $index: r }) => [l(y, { modelValue: t.arrivalTime, "onUpdate:modelValue": (h) => t.arrivalTime = h, disabled: !!n(i).boolUsed, disabledDate: (h) => n(j)(h).valueOf() < n(j)().subtract(1, "days").valueOf(), placeholder: r === 0 || n(S)(t.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), l(a, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: c(({ row: t, $index: r }) => [l(p, { size: "default", type: "primary", onClick: (h) => ee(t, r) }, { default: c(() => s[0] || (s[0] = [re(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), l(a, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: r }) => [l(p, { disabled: !!n(i).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (h) => te(t.sn, r, t) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  Ee as default
};
