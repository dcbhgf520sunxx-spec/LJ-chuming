import { ref as C } from "vue";
import { inject as I } from "vue";
import { ElMessage as Y } from "element-plus";
import { resolveComponent as b } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as d } from "vue";
import { createBlock as h } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { unref as l } from "vue";
import { createTextVNode as E } from "vue";
import { createElementBlock as p } from "vue";
import { toDisplayString as c } from "vue";
import { withDirectives as ee } from "vue";
import { createElementVNode as m } from "vue";
import { nextTick as te } from "vue";
import { ElTableColumn as oe } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElCheckbox as ae } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElForm as re } from "element-plus";
import { _ as de, t as ce, ao as ue, o as se, bV as M, ia as me, bD as g, i as k, aw as fe } from "../../../../../../shared/runtime.js";
const pe = { key: 1 }, ve = { key: 1 }, he = { key: 0 }, _e = { style: { display: "flex" } }, ye = { style: { "padding-right": "5px" } }, ge = { key: 1 }, we = { key: 1 }, xe = { key: 1 }, be = { key: 1 }, ke = { class: "add-row-box" }, Ae = { __name: "form", props: { existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, setup(A) {
  const T = C(), D = C(), N = { projectId: void 0, list: [] }, { decimalPrecision: w } = ce(), { CRUD: z, crud: _, form: f } = ue(N, T), x = I("contractInfo"), R = I("totalAmount"), v = C(0), s = A, { maxHeight: j } = se({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), B = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, o) => !!k(t), message: "请选择开票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, o) => o.invoiceType !== g.RECEIPT.V && !o.checked ? k(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: F, wrongCellMask: P } = fe({ rules: B });
  function $(t) {
    f.list.splice(t, 1);
  }
  function q() {
    f.list.push({ invoiceAmount: void 0, invoiceDate: void 0, checked: false, boolIncludeTax: true, invoiceType: void 0, invoiceNo: void 0, taxRate: s.currentRow.taxRate ? s.currentRow.taxRate * 100 : void 0, tax: void 0, invoiceUnit: x.value.branchCompanyName || void 0, invoiceUnitId: x.value.branchCompanyId || void 0, collectionUnit: x.value.purchaser || void 0, contractWasteId: x.value.contractWasteId, dataIndex: f.list.length + 1, isModify: true });
  }
  function H(t) {
    if (s.currentRow.settlementAmount && (v.value = 0, f.list.map((o) => {
      o.invoiceAmount && (v.value += o.invoiceAmount);
    }), v.value > s.currentRow.settlementAmount - R.value)) {
      const o = t.invoiceAmount - (v.value - (s.currentRow.settlementAmount - R.value));
      te(() => {
        t.invoiceAmount = o || 0, y(t), v.value = 0, f.list.map((u) => {
          u.invoiceAmount && (v.value += u.invoiceAmount);
        });
      });
    }
    y(t);
  }
  function O(t) {
    t.checked = false, t.boolIncludeTax = true, t.invoiceType === g.RECEIPT.V && (t.taxRate = 0, y(t));
  }
  function S(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : s.currentRow.taxRate ? s.currentRow.taxRate * 100 : void 0, y(t);
  }
  function y(t) {
    t.tax = 0;
    let o = t.invoiceAmount;
    k(t.invoiceAmount) && t.taxRate ? (t.tax = t.invoiceAmount * t.taxRate / 100, o = (t.invoiceAmount / (1 + t.taxRate / 100)).toFixed(w.value.contract)) : t.invoiceType === g.RECEIPT.V && (o = t.invoiceAmount), t.noTaxAmount = o;
  }
  return z.HOOK.beforeValidateCU = (t, o) => {
    if (t.form.list.length <= 0) return Y({ message: "请添加开票明细", type: "error" }), false;
    const { validResult: u, dealList: r } = F(t.form.list);
    if (u) t.form.list = r;
    else return u;
    t.form.projectId = s.projectId;
  }, (t, o) => {
    const u = b("common-button"), r = oe, W = ne, U = ie, K = b("common-select"), L = ae, V = le, G = b("common-table"), J = re, Q = b("common-drawer"), X = Z("show-thousand");
    return d(), h(Q, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(_).cancelCU, visible: l(_).status.cu > 0, title: l(_).status.title, "wrapper-closable": false, size: "100%" }, { titleRight: a(() => [n(u, { loading: l(_).status.cu === 2, type: "primary", size: "default", onClick: l(_).submitCU }, { default: a(() => o[1] || (o[1] = [E("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: a(() => [n(J, { ref_key: "formRef", ref: T, model: l(f), size: "default", "label-width": "140px" }, { default: a(() => [n(G, { ref_key: "detailRef", ref: D, border: "", data: l(f).list, "max-height": l(j), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "cell-class-name": l(P), "return-source-data": "", showEmptySymbol: false }, { default: a(() => [n(r, { label: "序号", type: "index", align: "center", width: "55" }), n(r, { key: "invoiceDate", prop: "invoiceDate", label: "*开票日期", align: "center", width: "160" }, { default: a((e) => [e.row.isModify ? (d(), h(W, { key: 0, modelValue: e.row.invoiceDate, "onUpdate:modelValue": (i) => e.row.invoiceDate = i, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("div", pe, c(e.row.invoiceDate ? t.parseTime(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), n(r, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "*开票额", align: "center", "min-width": "180", class: "money-column" }, { default: a(() => [n(r, { key: "invoiceAmount", prop: "invoiceAmount", label: "金额", align: "center", "min-width": "85" }, { default: a((e) => [e.row.isModify ? ee((d(), h(U, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (i) => e.row.invoiceAmount = i, modelModifiers: { number: true }, min: -9999999999, max: A.currentRow.settlementAmount ? A.currentRow.settlementAmount - l(R) : 9999999999, step: 100, precision: l(w).contract, placeholder: "开票额(元)", "controls-position": "right", onChange: (i) => H(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[X]]) : (d(), p("div", ve, c(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? l(M)(e.row.invoiceAmount, l(w).contract) : e.row.invoiceAmount), 1))]), _: 1 }), n(r, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", "min-width": "85", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, c(e.row.invoiceAmount ? l(me)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), n(r, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "120" }, { default: a((e) => [n(K, { modelValue: e.row.invoiceType, "onUpdate:modelValue": (i) => e.row.invoiceType = i, options: l(g).ENUM, type: "enum", size: "default", clearable: "", placeholder: "发票类型", style: { width: "100%" }, onChange: (i) => O(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), n(r, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "130" }, { default: a((e) => [e.row.invoiceType !== l(g).RECEIPT.V && e.row.isModify ? (d(), p("div", he, [m("div", _e, [m("div", ye, [n(L, { modelValue: e.row.checked, "onUpdate:modelValue": (i) => e.row.checked = i, label: "免税", size: "large", onChange: (i) => S(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), n(U, { modelValue: e.row.taxRate, "onUpdate:modelValue": (i) => e.row.taxRate = i, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "80px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (i) => y(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), o[2] || (o[2] = m("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (d(), p("div", ge, c(l(k)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), n(r, { key: "noTaxAmount", prop: "noTaxAmount", label: "不含税金额", align: "center", width: "70" }, { default: a((e) => [m("span", null, c(e.row.noTaxAmount && e.row.noTaxAmount > 0 ? l(M)(e.row.noTaxAmount, l(w).contract) : e.row.noTaxAmount), 1)]), _: 1 }), n(r, { key: "invoiceUnit", prop: "invoiceUnit", label: "*开票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, c(e.row.invoiceUnit), 1)]), _: 1 }), n(r, { key: "collectionUnit", prop: "collectionUnit", label: "*收票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, c(e.row.collectionUnit), 1)]), _: 1 }), n(r, { prop: "invoiceNo", label: "*发票号码", align: "center", "min-width": "130" }, { default: a((e) => [e.row.isModify ? (d(), h(V, { key: 0, modelValue: e.row.invoiceNo, "onUpdate:modelValue": (i) => e.row.invoiceNo = i, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", we, c(e.row.invoiceNo), 1))]), _: 1 }), n(r, { prop: "invoiceContent", label: "发票内容", align: "center", "min-width": "130" }, { default: a((e) => [e.row.isModify ? (d(), h(V, { key: 0, modelValue: e.row.invoiceContent, "onUpdate:modelValue": (i) => e.row.invoiceContent = i, modelModifiers: { trim: true }, type: "text", placeholder: "发票内容", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", xe, c(e.row.invoiceContent), 1))]), _: 1 }), n(r, { prop: "remark", label: "备注", align: "center", "min-width": "130" }, { default: a((e) => [e.row.isModify ? (d(), h(V, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (i) => e.row.remark = i, modelModifiers: { trim: true }, type: "textarea", placeholder: "备注", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), p("span", be, c(e.row.remark), 1))]), _: 1 }), n(r, { label: "操作", align: "center" }, { default: a((e) => [n(u, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (i) => $(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), m("div", ke, [n(u, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: o[0] || (o[0] = (e) => q()) }, { default: a(() => o[3] || (o[3] = [E("继续添加")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ue = de(Ae, [["__scopeId", "data-v-21cfa148"]]);
export {
  Ue as default
};
