import { inject as j } from "vue";
import { computed as P } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as f } from "vue";
import { createBlock as U } from "vue";
import { withCtx as s } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as N } from "vue";
import { withDirectives as _ } from "vue";
import { createElementBlock as C } from "vue";
import { createTextVNode as T } from "vue";
import k from "moment";
import { createCommentVNode as ee } from "vue";
import { mergeProps as te } from "vue";
import { reactive as ae } from "vue";
import { ElTableColumn as le } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { tC as oe, fE as re, v5 as ce, wc as S, fv as de, b as R, c9 as ue, aw as me, aI as pe } from "../../../../../../../shared/runtime.js";
const fe = { key: 1 }, ge = { __name: "aux-mat-table", emits: ["search-inventory"], setup(be, { expose: q, emit: L }) {
  const B = L, M = j("useInventoryInfo"), x = j("matSpecRef"), { cu: d, form: a } = oe(), O = (e, i) => i.measureUnit ? !!e : true, A = P(() => {
    let e = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: O, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ue, message: "核算量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return a.level === re.CONSTRUCTION_SITE.V && (e = Object.assign(e, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), e;
  }), D = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: z, wrongCellMask: F, cleanUpData: $ } = me({ rules: A, ditto: D }), { projectAllType: H } = ce();
  function Q({ row: e, rowIndex: i }) {
    var l, r;
    if ((r = (l = d == null ? void 0 : d.submitResult) == null ? void 0 : l.data) != null && r.includes(e.classifyId)) return { backgroundColor: "#ffdede" };
  }
  a.steelPlateList, a.sectionSteelList, a.steelCoilList, a.otherSteelMaterials, a.MATERIAL, a.OTHER, a.GAS, P(() => prop.showForm);
  function Y(e) {
    var l, r;
    return ae({ uid: pe(), sn: e.sn, requisitionMode: S.PURCHASE.V, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, mete: void 0, quantity: void 0, arrivalTime: ((l = a.list) == null ? void 0 : l.length) > 0 ? "同上" : void 0, projectId: ((r = a.list) == null ? void 0 : r.length) > 0 ? -1 : void 0, project: void 0 });
  }
  function G(e) {
    return e.materialInventoryId && a.originInventoryInfo[e.materialInventoryId] ? a.originInventoryInfo[e.materialInventoryId].quantity - a.originInventoryInfo[e.materialInventoryId].frozenQuantity - M.value[e.materialInventoryId] + e.quantity : 999999999;
  }
  function J(e, i) {
    B("search-inventory", e, i);
  }
  function K(e, i, l) {
    var r, u, p, g;
    if ((u = (r = d == null ? void 0 : d.submitResult) == null ? void 0 : r.data) != null && u.includes(l.classifyId)) {
      const v = (p = d == null ? void 0 : d.submitResult) == null ? void 0 : p.data.findIndex((b) => b === l.classifyId);
      a.list.filter((b) => b.classifyId === l.classifyId).length === 1 && ((g = d == null ? void 0 : d.submitResult) == null || g.data.splice(v, 1));
    }
    x.value ? x.value.delListItem(e, i) : a.list.splice(i, 1);
  }
  function W() {
    if (R(a.list)) return true;
    const { validResult: e, dealList: i } = z(a.list);
    return E(i), e;
  }
  function X() {
    if (R(a.list)) return true;
    const e = a.list.filter((i) => true);
    E(e);
  }
  function E(e) {
    const i = JSON.parse(JSON.stringify(e));
    $(i), i.forEach((l, r) => {
      var u;
      a.list[r].projectId = l.projectId, a.list[r].project = (u = H.value) == null ? void 0 : u.find((p) => a.list[r].projectId === p.id), a.list[r].arrivalTime = l.arrivalTime;
    });
  }
  function Z(e) {
    e.projectId = void 0, e.project = void 0;
  }
  return q({ rowInit: Y, validate: W, TSValidate: X }), (e, i) => {
    const l = le, r = I("table-cell-tag"), u = ne, p = I("common-input-number"), g = ie, v = se, h = I("common-button"), b = I("common-table"), y = w("empty-text");
    return f(), U(b, te({ "cell-class-name": o(F), data: o(a).list, "row-style": Q, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: s(() => [n(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), n(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(r, { name: o(S).USE_INVENTORY.L, show: t.requisitionMode === o(S).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), V("span", null, N(t.serialNumber), 1)]), _: 1 }), n(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(u, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [_(V("span", null, null, 512), [[y, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), n(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [n(u, { content: t.specificationLabels, placement: "top" }, { default: s(() => [_(V("span", null, null, 512), [[y, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), n(l, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: s(({ row: t }) => [_((f(), C("span", null, [T(N(t.measureUnit), 1)])), [[y]])]), _: 1 }), n(l, { align: "center", label: "数量", prop: "quantity" }, { default: s(({ row: t }) => [t.measureUnit ? (f(), U(p, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (c) => t.quantity = c, controls: false, disabled: !!o(a).boolUsed, max: G(t), min: 0, precision: t.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])) : _((f(), C("span", fe, null, 512)), [[y]])]), _: 1 }), n(l, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: s(({ row: t }) => [_((f(), C("span", null, [T(N(t.accountingUnit), 1)])), [[y]])]), _: 1 }), n(l, { align: "center", label: "核算量", prop: "mete" }, { default: s(({ row: t }) => [n(p, { modelValue: t.mete, "onUpdate:modelValue": (c) => t.mete = c, controls: false, disabled: !!o(a).boolUsed, max: 999999999, min: 1e-6, precision: t.accountingPrecision, step: 1, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), n(l, { align: "center", label: "颜色", prop: "color" }, { default: s(({ row: t }) => [n(g, { modelValue: t.color, "onUpdate:modelValue": (c) => t.color = c, modelModifiers: { trim: true }, disabled: !!o(a).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), n(l, { align: "center", label: "项目", prop: "projectId" }, { default: s(({ row: t, $index: c }) => [n(de, { modelValue: t.projectId, "onUpdate:modelValue": (m) => t.projectId = m, branchCompanyId: o(a).branchCompanyId, disabled: o(R)(o(a).branchCompanyId) || !!o(a).boolUsed, isLumpSum: false, isNotInternalContractSystem: true, "show-extra": c !== 0, clearable: "", style: { width: "100%" }, onClear: (m) => Z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), n(l, { align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: s(({ row: t, $index: c }) => [n(v, { modelValue: t.arrivalTime, "onUpdate:modelValue": (m) => t.arrivalTime = m, disabled: !!o(a).boolUsed, disabledDate: (m) => o(k)(m).valueOf() < o(k)().subtract(1, "days").valueOf(), placeholder: c === 0 ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), n(l, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: s(({ row: t, $index: c }) => [n(h, { size: "default", type: "primary", onClick: (m) => J(t, c) }, { default: s(() => i[0] || (i[0] = [T(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), o(a).boolUsed ? ee("", true) : (f(), U(l, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: s(({ row: t, $index: c }) => [n(h, { disabled: !!o(a).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (m) => K(t.sn, c, t) }, null, 8, ["disabled", "onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ge as default
};
