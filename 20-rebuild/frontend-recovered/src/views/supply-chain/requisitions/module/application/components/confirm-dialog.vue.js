import { ref as k } from "vue";
import { computed as C } from "vue";
import { watch as ne } from "vue";
import { ElMessage as re } from "element-plus";
import { resolveComponent as h } from "vue";
import { openBlock as c } from "vue";
import { createBlock as p } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as x } from "vue";
import { unref as a } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as v } from "vue";
import { createVNode as t } from "vue";
import S from "moment";
import { isRef as ue } from "vue";
import { ElTag as de } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElDatePicker as ce } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElForm as fe } from "element-plus";
import { _ as he, m as A, jX as _e, u as be, tC as ge, o as ve, jl as we, wv as ye, wc as E, jG as xe, jH as Ve, k5 as Se, aw as Te, ba as ke, jN as Ce } from "../../../../../../shared/runtime.js";
import { u as Ne } from "../../../../../../modules/use-approval-cfg-0a67817c.js";
import Ee from "./common-footer.vue.js";
const Ie = { class: "child-mr-6", style: { display: "flex", "align-items": "center" } }, Me = { class: "table-remark" }, Re = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del"], setup(I, { emit: H }) {
  const M = H, _ = I, f = k(), { approvalCfg: z } = Ne(), { user: F } = A("user"), { projectMap: Q } = A("projectMap"), T = k([]), G = k([..._e]), { visible: g, handleClose: R } = be({ emit: M, props: _ }), { cu: r, form: s, FORM: b } = ge(), $ = { arrivalTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, L = /* @__PURE__ */ new Map([["arrivalTime", "同上"]]), { tableValidate: Y, cleanUpData: K, wrongCellMask: P } = Te({ rules: $, ditto: L }), U = C(() => {
    var e;
    return ((e = z.value) == null ? void 0 : e.requisition) || s.boolInitiateApprove;
  }), { maxHeight: O } = ve({ mainBox: ".requisitions-application-preview", extraBox: [".el-dialog__header", ".footer", ".table-remark"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, g), W = C(() => {
    var o;
    const e = ((o = Q.value) == null ? void 0 : o[s.projectId]) || {};
    return `${e.serialNumber} ${e.shortName}`;
  });
  function X({ row: e, rowIndex: o }) {
    var d, w, y;
    if ((w = (d = r == null ? void 0 : r.submitResult) == null ? void 0 : d.data) != null && w.includes(e.classifyId) && ((y = r == null ? void 0 : r.submitResult) == null ? void 0 : y.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  ne(() => _.modelValue, (e) => {
    T.value = [], f.value = void 0, e && J(), s.list.forEach((o, d) => {
      d !== 0 && (o.arrivalTime = "同上");
    });
  }, { immediate: true }), r.submitFormFormat = async (e) => (e.list = K(e.list), _.isManufactured ? e.list = e.list.map((o) => ({ artifactEnclosureId: o.id, quantity: o.curPurchaseQuantity })) : e.list = await we(e.list, { toSmallest: true, toNum: true }), e), b.HOOK.beforeSubmit = async () => {
    const { validResult: e } = Y(s.list);
    if (!e) return !_.isManufactured && f.value && (f.value = void 0), false;
    if (!s.approveProcessId && U.value) return re.warning("请选择审批流程"), false;
  }, b.HOOK.afterSubmit = () => {
    R();
  };
  function B(e, o, d) {
    d !== 0 && !e && (o.arrivalTime = "同上");
  }
  async function J() {
    const e = await ye() || [];
    T.value = e;
  }
  function Z(e) {
    return ke(e, { props: [["quantity", 3], ["mete", Ce.weight.precision]] });
  }
  const D = C(() => _.isManufactured ? s.list.map((e) => (e.delPurchaseQuantity = e.curPurchaseQuantity, e)) : s.list.filter((e) => {
    let o = true;
    return f.value && e.requisitionMode !== f.value && (o = false), o;
  }));
  function ee(e) {
    M("manuf-del", { id: e.id, quantity: e.delPurchaseQuantity }, e);
  }
  return (e, o) => {
    const d = de, w = h("common-radio-button"), y = h("common-select"), ae = h("table-cell-tag"), i = me, j = ce, q = h("common-table"), te = h("common-input-number"), le = h("common-button"), oe = pe, se = fe, ie = h("common-dialog");
    return c(), p(ie, { modelValue: a(g), "onUpdate:modelValue": o[3] || (o[3] = (l) => ue(g) ? g.value = l : null), "before-close": a(R), "custom-class": "requisitions-application-preview", fullscreen: "", title: "材料申购汇总" }, { titleAfter: n(() => [x("span", Ie, [a(s).projectId ? (c(), p(d, { key: 0, effect: "plain", size: "large" }, { default: n(() => [N("申购项目：" + V(W.value), 1)]), _: 1 })) : v("", true), a(s).serialNumber ? (c(), p(d, { key: 1, effect: "plain", size: "large" }, { default: n(() => [N("申购编号：" + V(a(s).serialNumber), 1)]), _: 1 })) : v("", true), t(d, { effect: "plain", size: "large", type: "success" }, { default: n(() => [N("申购人：" + V(a(F).name), 1)]), _: 1 }), _.isManufactured ? v("", true) : (c(), p(w, { key: 2, modelValue: f.value, "onUpdate:modelValue": o[0] || (o[0] = (l) => f.value = l), options: a(E).ENUM, clearable: "", "show-option-all": "", type: "enum" }, null, 8, ["modelValue", "options"]))])]), titleRight: n(() => [U.value ? (c(), p(y, { key: 0, modelValue: a(s).approveProcessId, "onUpdate:modelValue": o[1] || (o[1] = (l) => a(s).approveProcessId = l), dataStructure: { key: "id", label: "approveInfoName", value: "id" }, disabled: a(r).status.edit === a(b).STATUS.PROCESSING, options: T.value, placeholder: "选择审批流程", size: "default", style: { width: "220px" }, type: "other" }, null, 8, ["modelValue", "disabled", "options"])) : v("", true)]), default: n(() => [a(g) ? (c(), p(se, { key: 0, ref: "formRef", disabled: a(r).status.edit === a(b).STATUS.PROCESSING, model: a(s) }, { default: n(() => [I.isManufactured ? (c(), p(q, { key: 1, "cell-class-name": a(P), data: D.value, "max-height": a(O) - 170, "show-summary": "" }, { default: n(() => [t(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), t(i, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "申购数量", prop: "curPurchaseQuantity", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "申购重量(kg)", prop: "curPurchaseWeight", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "删除数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: l } }) => [t(te, { modelValue: l.delPurchaseQuantity, "onUpdate:modelValue": (m) => l.delPurchaseQuantity = m, controls: false, max: l.curPurchaseQuantity, min: 1, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), t(i, { align: "center", label: "到厂日期", prop: "arrivalTime", width: "160px" }, { default: n(({ row: { sourceRow: l }, $index: m }) => [t(j, { modelValue: l.arrivalTime, "onUpdate:modelValue": (u) => l.arrivalTime = u, disabled: a(r).status.edit === a(b).STATUS.PROCESSING, disabledDate: (u) => a(S)(u).valueOf() < a(S)().subtract(1, "days").valueOf(), placeholder: l.arrivalTime !== "同上" ? "选择到厂日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x", onChange: (u) => B(u, l, m) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder", "onChange"])]), _: 1 }), t(i, { align: "center", label: "操作", width: "80" }, { default: n(({ row: { sourceRow: l } }) => [t(le, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (m) => ee(l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : (c(), p(q, { key: 0, "cell-class-name": a(P), data: D.value, "data-format": G.value, "max-height": a(O), "row-style": X, stripe: false, "summary-method": Z, "show-summary": "" }, { default: n(() => [t(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: n(({ row: l, $index: m }) => [t(ae, { name: a(E).USE_INVENTORY.L, show: l.requisitionMode === a(E).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), x("span", null, V(m + 1), 1)]), _: 1 }), t(xe, { showIndex: false, fixed: "left" }), t(Ve), t(Se, { showBatchNo: false }), t(i, { align: "center", label: "到厂日期", prop: "arrivalTime", width: "160px" }, { default: n(({ row: { sourceRow: l }, $index: m }) => [t(j, { modelValue: l.arrivalTime, "onUpdate:modelValue": (u) => l.arrivalTime = u, disabled: a(r).status.edit === a(b).STATUS.PROCESSING, disabledDate: (u) => a(S)(u).valueOf() < a(S)().subtract(1, "days").valueOf(), placeholder: l.arrivalTime !== "同上" ? "选择到厂日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x", onChange: (u) => B(u, l, m) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "max-height"])), x("div", Me, [o[4] || (o[4] = x("span", null, "备注", -1)), t(oe, { modelValue: a(s).remark, "onUpdate:modelValue": o[2] || (o[2] = (l) => a(s).remark = l), rows: 2, class: "remark input-border-none", maxlength: "200", placeholder: "请填写申购备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["disabled", "model"])) : v("", true), t(Ee, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, De = he(Re, [["__scopeId", "data-v-68d160a9"]]);
export {
  De as default
};
