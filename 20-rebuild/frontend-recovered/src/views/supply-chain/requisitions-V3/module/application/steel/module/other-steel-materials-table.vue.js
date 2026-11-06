import { inject as j } from "vue";
import { computed as Z } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as p } from "vue";
import { createBlock as U } from "vue";
import { withCtx as s } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as S } from "vue";
import { withDirectives as _ } from "vue";
import { createElementBlock as N } from "vue";
import { createTextVNode as C } from "vue";
import R from "moment";
import { createCommentVNode as ee } from "vue";
import { mergeProps as te } from "vue";
import { reactive as ae } from "vue";
import { ElTableColumn as le } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { tC as oe, fE as re, v5 as ce, wc as T, fv as de, b as x, c9 as ue, aw as me, aI as fe } from "../../../../../../../shared/runtime.js";
const pe = { key: 1 }, ge = { __name: "other-steel-materials-table", emits: ["search-inventory"], setup(be, { expose: k, emit: P }) {
  const q = P, E = j("useInventoryInfo"), L = j("matSpecRef"), { cu: d, form: a } = oe(), B = (e, i) => i.measureUnit ? !!e : true, D = Z(() => {
    let e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: B, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ue, message: "核算量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return a.level === re.CONSTRUCTION_SITE.V && (e = Object.assign(e, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), e;
  }), O = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: z, wrongCellMask: F, cleanUpData: $ } = me({ rules: D, ditto: O }), { projectAllType: A } = ce();
  function Q({ row: e, rowIndex: i }) {
    var l, r;
    if ((r = (l = d == null ? void 0 : d.submitResult) == null ? void 0 : l.data) != null && r.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function Y(e) {
    var l, r;
    return ae({ uid: fe(), sn: e.sn, requisitionMode: T.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0, arrivalTime: ((l = a.otherSteelMaterialList) == null ? void 0 : l.length) > 0 ? "同上" : void 0, projectId: ((r = a.otherSteelMaterialList) == null ? void 0 : r.length) > 0 ? -1 : void 0 });
  }
  function J(e) {
    return e.materialInventoryId && a.originInventoryInfo[e.materialInventoryId] ? a.originInventoryInfo[e.materialInventoryId].quantity - a.originInventoryInfo[e.materialInventoryId].frozenQuantity - E.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function H(e, i) {
    q("search-inventory", e, i);
  }
  function K(e, i, l) {
    var r, u, f, g;
    if ((u = (r = d == null ? void 0 : d.submitResult) == null ? void 0 : r.data) != null && u.includes(l.classifyId)) {
      const h = (f = d == null ? void 0 : d.submitResult) == null ? void 0 : f.data.findIndex((b) => b === l.classifyId);
      a.list.filter((b) => b.classifyId === l.classifyId).length === 1 && ((g = d == null ? void 0 : d.submitResult) == null || g.data.splice(h, 1));
    }
    L.value ? L.value.delListItem(e, i) : a.otherSteelMaterialList.splice(i, 1);
  }
  function G() {
    if (x(a.otherSteelMaterialList)) return true;
    const { validResult: e, dealList: i } = z(a.otherSteelMaterialList);
    return M(i), e;
  }
  function W() {
    if (x(a.otherSteelMaterialList)) return true;
    const e = a.otherSteelMaterialList.filter((i) => true);
    M(e);
  }
  function M(e) {
    const i = JSON.parse(JSON.stringify(e));
    $(i), i.forEach((l, r) => {
      var u;
      a.otherSteelMaterialList[r].projectId = l.projectId, a.otherSteelMaterialList[r].project = (u = A.value) == null ? void 0 : u.find((f) => a.otherSteelMaterialList[r].projectId === f.id), a.otherSteelMaterialList[r].arrivalTime = l.arrivalTime;
    });
  }
  function X(e) {
    e.projectId = void 0, e.project = void 0;
  }
  return k({ rowInit: Y, validate: G, TSValidate: W }), (e, i) => {
    const l = le, r = I("table-cell-tag"), u = ne, f = I("common-input-number"), g = ie, h = se, v = I("common-button"), b = I("common-table"), y = w("empty-text");
    return p(), U(b, te({ "cell-class-name": o(F), data: o(a).otherSteelMaterialList, "row-style": Q, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: s(() => [n(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), n(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(r, { name: o(T).USE_INVENTORY.L, show: t.requisitionMode === o(T).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), V("span", null, S(t.serialNumber), 1)]), _: 1 }), n(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(u, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [_(V("span", null, null, 512), [[y, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(u, { content: t.specificationLabels, placement: "top" }, { default: s(() => [_(V("span", null, null, 512), [[y, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), n(l, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: s(({ row: t }) => [_((p(), N("span", null, [C(S(t.measureUnit), 1)])), [[y]])]), _: 1 }), n(l, { align: "center", label: "数量", prop: "quantity" }, { default: s(({ row: t }) => [t.measureUnit ? (p(), U(f, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (c) => t.quantity = c, controls: false, disabled: !!o(a).boolUsed, max: J(t), min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])) : _((p(), N("span", pe, null, 512)), [[y]])]), _: 1 }), n(l, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: s(({ row: t }) => [_((p(), N("span", null, [C(S(t.accountingUnit), 1)])), [[y]])]), _: 1 }), n(l, { align: "center", label: "核算量", prop: "mete" }, { default: s(({ row: t }) => [n(f, { modelValue: t.mete, "onUpdate:modelValue": (c) => t.mete = c, controls: false, disabled: !!o(a).boolUsed, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), n(l, { align: "center", label: "颜色", prop: "color" }, { default: s(({ row: t }) => [n(g, { modelValue: t.color, "onUpdate:modelValue": (c) => t.color = c, modelModifiers: { trim: true }, disabled: !!o(a).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), n(l, { align: "center", label: "项目", prop: "projectId" }, { default: s(({ row: t, $index: c }) => [n(de, { modelValue: t.projectId, "onUpdate:modelValue": (m) => t.projectId = m, branchCompanyId: o(a).branchCompanyId, disabled: o(x)(o(a).branchCompanyId) || !!o(a).boolUsed, isLumpSum: false, isNotInternalContractSystem: true, "show-extra": c !== 0, clearable: "", style: { width: "100%" }, onClear: (m) => X(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), n(l, { align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: s(({ row: t, $index: c }) => [n(h, { modelValue: t.arrivalTime, "onUpdate:modelValue": (m) => t.arrivalTime = m, disabled: !!o(a).boolUsed, disabledDate: (m) => o(R)(m).valueOf() < o(R)().subtract(1, "days").valueOf(), placeholder: c === 0 ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), n(l, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: s(({ row: t, $index: c }) => [n(v, { size: "default", type: "primary", onClick: (m) => H(t, c) }, { default: s(() => i[0] || (i[0] = [C(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), o(a).boolUsed ? ee("", true) : (p(), U(l, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: s(({ row: t, $index: c }) => [n(v, { disabled: !!o(a).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (m) => K(t.sn, c, t) }, null, 8, ["disabled", "onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ge as default
};
