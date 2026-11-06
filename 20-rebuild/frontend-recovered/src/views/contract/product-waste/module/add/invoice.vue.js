import { ref as E } from "vue";
import { ElMessage as Y } from "element-plus";
import { watch as Z } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as d } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { unref as r } from "vue";
import { createTextVNode as V } from "vue";
import { createElementBlock as p } from "vue";
import { toDisplayString as s } from "vue";
import { createElementVNode as m } from "vue";
import { isRef as ee } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElDatePicker as oe } from "element-plus";
import { ElInputNumber as ne } from "element-plus";
import { ElCheckbox as ie } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElForm as le } from "element-plus";
import { _ as re, t as de, ao as ce, u as ue, o as se, V as me, bV as M, ia as pe, bD as _, i as x, aw as fe } from "../../../../../shared/runtime.js";
const ve = { key: 1 }, _e = { key: 1 }, ye = { key: 0 }, he = { style: { display: "flex" } }, we = { style: { "padding-right": "5px" } }, ge = { key: 1 }, xe = { key: 1 }, be = { key: 1 }, ke = { key: 1 }, Ve = { class: "add-row-box" }, Re = { __name: "invoice", props: { visible: { type: Boolean }, existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(R, { emit: N }) {
  const C = E(), D = E(), z = { projectId: void 0, list: [] }, { decimalPrecision: y } = de(), { CRUD: T, crud: h, form: v } = ce(z, C), c = R, B = N, { visible: b, handleClose: A } = ue({ emit: B, props: c, field: "visible" }), { maxHeight: j } = se({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), P = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, o) => !!x(t), message: "请选择开票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, o) => o.invoiceType !== _.RECEIPT.V && !o.checked ? x(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: $, wrongCellMask: F } = fe({ rules: P });
  function H(t) {
    v.list.splice(t, 1);
  }
  function O() {
    var t, o, u, l;
    v.list.push({ invoiceAmount: void 0, invoiceDate: void 0, checked: false, boolIncludeTax: true, invoiceType: void 0, invoiceNo: void 0, taxRate: c.currentRow.taxRate ? c.currentRow.taxRate * 100 : void 0, tax: void 0, invoiceUnit: ((t = c.currentRow) == null ? void 0 : t.branchCompanyName) || void 0, invoiceUnitId: ((o = c.currentRow) == null ? void 0 : o.branchCompanyId) || void 0, collectionUnit: ((u = c.currentRow) == null ? void 0 : u.purchaser) || void 0, contractWasteId: (l = c.currentRow) == null ? void 0 : l.contractWasteId, dataIndex: v.list.length + 1, isModify: true });
  }
  function q(t) {
    w(t);
  }
  function S(t) {
    t.checked = false, t.boolIncludeTax = true, t.invoiceType === _.RECEIPT.V && (t.taxRate = 0, w(t));
  }
  function K(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : c.currentRow.taxRate ? c.currentRow.taxRate * 100 : void 0, w(t);
  }
  function w(t) {
    t.tax = 0;
    let o = t.invoiceAmount;
    x(t.invoiceAmount) && t.taxRate ? (t.tax = t.invoiceAmount * t.taxRate / 100, o = (t.invoiceAmount / (1 + t.taxRate / 100)).toFixed(y.value.contract)) : t.invoiceType === _.RECEIPT.V && (o = t.invoiceAmount), t.noTaxAmount = o;
  }
  return T.HOOK.beforeValidateCU = (t, o) => {
    if (t.form.list.length <= 0) return Y({ message: "请添加开票明细", type: "error" }), false;
    const { validResult: u, dealList: l } = $(t.form.list);
    if (u) t.form.list = l;
    else return u;
    t.form.projectId = c.projectId;
  }, T.HOOK.afterSubmit = () => {
    A();
  }, Z(() => c.currentRow, (t) => {
    if (t != null && t.id) {
      const o = me(t);
      h.form.list = [{ ...o, isModify: true }];
    }
  }, { deep: true, immediate: true }), (t, o) => {
    var I;
    const u = g("common-button"), l = te, W = oe, U = ne, L = g("common-select"), G = ie, k = ae, J = g("common-table"), Q = le, X = g("common-drawer");
    return d(), f(X, { modelValue: r(b), "onUpdate:modelValue": o[1] || (o[1] = (e) => ee(b) ? b.value = e : null), onClose: r(h).cancelCU, "close-on-click-modal": false, "show-close": false, title: (I = R.currentRow) != null && I.id ? "修改开票填报" : "新增开票填报", "wrapper-closable": false, "append-to-body": "", size: "100%" }, { titleRight: a(() => [n(u, { loading: r(h).status.cu === 2, size: "small", type: "primary", onClick: r(h).submitCU }, { default: a(() => o[2] || (o[2] = [V("确认")])), _: 1, __: [2] }, 8, ["loading", "onClick"]), n(u, { size: "small", onClick: r(A) }, { default: a(() => o[3] || (o[3] = [V("关闭")])), _: 1, __: [3] }, 8, ["onClick"])]), content: a(() => [n(Q, { ref_key: "formRef", ref: C, model: r(v), "label-width": "140px", size: "small" }, { default: a(() => [n(J, { ref_key: "detailRef", ref: D, "cell-class-name": r(F), data: r(v).list, "max-height": r(j), showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: a(() => [n(l, { align: "center", label: "序号", type: "index", width: "50" }), n(l, { key: "invoiceDate", align: "center", label: "*开票日期", prop: "invoiceDate", width: "160" }, { default: a((e) => [e.row.isModify ? (d(), f(W, { key: 0, modelValue: e.row.invoiceDate, "onUpdate:modelValue": (i) => e.row.invoiceDate = i, placeholder: "选择日期", size: "small", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("div", ve, s(e.row.invoiceDate ? t.parseTime(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), n(l, { key: "invoiceAmount2", align: "center", class: "money-column", label: "*开票额", "min-width": "180", prop: "invoiceAmount2" }, { default: a(() => [n(l, { key: "invoiceAmount", align: "center", label: "金额", "min-width": "85", prop: "invoiceAmount" }, { default: a((e) => [e.row.isModify ? (d(), f(U, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (i) => e.row.invoiceAmount = i, modelModifiers: { number: true }, max: 9999999999, min: -9999999999, precision: r(y).contract, step: 100, "controls-position": "right", placeholder: "开票额(元)", onChange: (i) => q(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (d(), p("div", _e, s(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? r(M)(e.row.invoiceAmount, r(y).contract) : e.row.invoiceAmount), 1))]), _: 1 }), n(l, { key: "invoiceAmount1", "show-overflow-tooltip": true, align: "center", label: "大写", "min-width": "85", prop: "invoiceAmount1" }, { default: a((e) => [m("div", null, s(e.row.invoiceAmount ? r(pe)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), n(l, { key: "invoiceType", align: "center", label: "*发票类型", prop: "invoiceType", width: "120" }, { default: a((e) => [n(L, { modelValue: e.row.invoiceType, "onUpdate:modelValue": (i) => e.row.invoiceType = i, options: r(_).ENUM, clearable: "", placeholder: "发票类型", size: "small", style: { width: "100%" }, type: "enum", onChange: (i) => S(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), n(l, { key: "taxRate", align: "center", label: "税率", prop: "taxRate", width: "130" }, { default: a((e) => [e.row.invoiceType !== r(_).RECEIPT.V && e.row.isModify ? (d(), p("div", ye, [m("div", he, [m("div", we, [n(G, { modelValue: e.row.checked, "onUpdate:modelValue": (i) => e.row.checked = i, label: "免税", size: "large", onChange: (i) => K(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), n(U, { modelValue: e.row.taxRate, "onUpdate:modelValue": (i) => e.row.taxRate = i, controls: false, disabled: e.row.checked, max: 100, min: 0, precision: 0, step: 1, class: "input-underline", "controls-position": "right", placeholder: "0-100", style: { width: "80px", "text-align": "center" }, onChange: (i) => w(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), o[4] || (o[4] = m("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (d(), p("div", ge, s(r(x)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), n(l, { key: "noTaxAmount", align: "center", label: "不含税金额", prop: "noTaxAmount", width: "70" }, { default: a((e) => [m("span", null, s(e.row.noTaxAmount && e.row.noTaxAmount > 0 ? r(M)(e.row.noTaxAmount, r(y).contract) : e.row.noTaxAmount), 1)]), _: 1 }), n(l, { key: "invoiceUnitId", "show-overflow-tooltip": true, align: "center", label: "*开票单位", "min-width": "120", prop: "invoiceUnitId" }, { default: a((e) => [m("div", null, s(e.row.invoiceUnit), 1)]), _: 1 }), n(l, { key: "collectionUnit", "show-overflow-tooltip": true, align: "center", label: "*收票单位", "min-width": "120", prop: "collectionUnit" }, { default: a((e) => [m("div", null, s(e.row.collectionUnit), 1)]), _: 1 }), n(l, { align: "center", label: "*发票号码", "min-width": "130", prop: "invoiceNo" }, { default: a((e) => [e.row.isModify ? (d(), f(k, { key: 0, modelValue: e.row.invoiceNo, "onUpdate:modelValue": (i) => e.row.invoiceNo = i, modelModifiers: { trim: true }, placeholder: "发票号码", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", xe, s(e.row.invoiceNo), 1))]), _: 1 }), n(l, { align: "center", label: "发票内容", "min-width": "130", prop: "invoiceContent" }, { default: a((e) => [e.row.isModify ? (d(), f(k, { key: 0, modelValue: e.row.invoiceContent, "onUpdate:modelValue": (i) => e.row.invoiceContent = i, modelModifiers: { trim: true }, placeholder: "发票内容", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", be, s(e.row.invoiceContent), 1))]), _: 1 }), n(l, { align: "center", label: "备注", "min-width": "130", prop: "remark" }, { default: a((e) => [e.row.isModify ? (d(), f(k, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (i) => e.row.remark = i, modelModifiers: { trim: true }, maxlength: "200", placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", ke, s(e.row.remark), 1))]), _: 1 }), n(l, { align: "center", label: "操作" }, { default: a((e) => [n(u, { icon: "el-icon-delete", size: "small", type: "danger", onClick: (i) => H(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), m("div", Ve, [n(u, { icon: "el-icon-circle-plus", size: "small", style: { "margin-right": "15px" }, type: "warning", onClick: o[0] || (o[0] = (e) => O()) }, { default: a(() => o[5] || (o[5] = [V("继续添加")])), _: 1, __: [5] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "onClose", "title"]);
  };
} }, Ie = re(Re, [["__scopeId", "data-v-d3783f21"]]);
export {
  Ie as default
};
