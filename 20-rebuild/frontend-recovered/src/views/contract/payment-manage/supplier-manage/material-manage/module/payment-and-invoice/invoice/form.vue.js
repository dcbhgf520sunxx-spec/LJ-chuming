import { ref as T } from "vue";
import { inject as W } from "vue";
import { ElMessage as X } from "element-plus";
import { resolveComponent as V } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as s } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as Z } from "vue";
import { createElementVNode as m } from "vue";
import { nextTick as ee } from "vue";
import { ElTag as te } from "element-plus";
import { ElTableColumn as ne } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElCheckbox as ie } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElForm as re } from "element-plus";
import { _ as ce, t as se, ao as ue, o as de, bV as I, i as _, ia as me, bD as R, S as pe, aw as fe, jF as ve } from "../../../../../../../../shared/runtime.js";
import { _ as ye } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
const ge = { key: 1 }, he = { key: 1 }, _e = { key: 0 }, we = { style: { display: "flex" } }, be = { style: { "padding-right": "5px" } }, xe = { key: 1 }, Re = { key: 1 }, ke = { class: "add-row-box" }, Ae = { __name: "form", props: { existInvoiceNo: { type: Array, default: () => [] }, currentRow: { type: Object, default: () => {
} }, propertyType: { type: [Number, String], default: void 0 } }, setup(p) {
  const { decimalPrecision: w } = se(), N = T(), U = T(), S = { list: [] }, { CRUD: M, crud: g, form: f } = ue(S, N), k = W("totalAmount"), v = T(0), c = p, { maxHeight: z } = de({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), P = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, i) => !!_(t), message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, i) => i.invoiceType !== R.RECEIPT.V && !i.checked ? _(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }], supplierId: [{ required: true, message: "请输入收票单位", trigger: "blur" }], branchCompanyId: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: $, wrongCellMask: B } = fe({ rules: P });
  function F(t) {
    f.list.splice(t, 1);
  }
  function j() {
    f.list.push({ id: void 0, orderId: c.currentRow.id, propertyType: ve.PURCHASE.V, invoiceAmount: void 0, receiveInvoiceDate: void 0, invoiceType: c.currentRow.invoiceType, invoiceSerialNumber: void 0, checked: false, boolIncludeTax: true, taxRate: c.currentRow.taxRate, branchCompanyId: c.currentRow.branchCompanyId, branchCompanyName: c.currentRow.branchCompanyName, supplierId: c.currentRow.supplierId, supplierName: c.currentRow.supplierName, dataIndex: f.list.length + 1, isModify: true });
  }
  function q(t) {
    if (c.currentRow.settlementAmount && (v.value = 0, f.list.map((i) => {
      i.invoiceAmount && (v.value += i.invoiceAmount);
    }), v.value > c.currentRow.settlementAmount - k.value)) {
      const i = t.invoiceAmount - (v.value - (c.currentRow.settlementAmount - k.value));
      ee(() => {
        t.invoiceAmount = i || 0, v.value = 0, f.list.map((d) => {
          d.invoiceAmount && (v.value += d.invoiceAmount);
        });
      });
    }
    A(t);
  }
  function H(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : c.currentRow.taxRate ? c.currentRow.taxRate * 100 : void 0, A(t);
  }
  function A(t) {
    t.tax = 0, _(t.invoiceAmount) && t.taxRate && t.invoiceType !== R.RECEIPT.V && (t.tax = t.invoiceAmount * t.taxRate / 100);
  }
  return M.HOOK.beforeValidateCU = (t, i) => {
    if (t.form.list.length <= 0) return X({ message: "请添加收票明细", type: "error" }), false;
    const { validResult: d, dealList: b } = $(t.form.list);
    if (d) t.form.list = b;
    else return d;
    t.form.list.map((r) => {
      r.attachmentIds = r.attachments ? r.attachments.map((C) => C.id) : void 0;
    });
  }, (t, i) => {
    const d = V("common-button"), b = te, r = ne, C = ae, E = oe, O = ie, L = le, K = V("common-table"), G = re, J = V("common-drawer"), Q = Y("show-thousand");
    return s(), y(J, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(g).cancelCU, visible: n(g).status.cu > 0, title: n(g).status.title, "wrapper-closable": false, size: "90%" }, { titleRight: o(() => [a(d, { loading: n(g).status.cu === 2, type: "primary", size: "default", onClick: n(g).submitCU }, { default: o(() => i[1] || (i[1] = [x("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: o(() => [p.currentRow.amount ? (s(), y(b, { key: 0, type: "success" }, { default: o(() => [x(u("合同金额:" + n(I)(p.currentRow.amount, n(w).contract)), 1)]), _: 1 })) : D("", true), p.currentRow.settlementAmount ? (s(), y(b, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: o(() => [x(u(`结算额:${n(I)(p.currentRow.settlementAmount, n(w).contract)}`), 1)]), _: 1 })) : D("", true), a(G, { ref_key: "formRef", ref: N, model: n(f), size: "default", "label-width": "140px" }, { default: o(() => [a(K, { ref_key: "detailRef", ref: U, border: "", data: n(f).list, "max-height": n(z), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": n(B) }, { default: o(() => [a(r, { label: "序号", type: "index", align: "center", width: "55" }), a(r, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "*收票日期", align: "center", width: "160" }, { default: o((e) => [e.row.isModify ? (s(), y(C, { key: 0, modelValue: e.row.receiveInvoiceDate, "onUpdate:modelValue": (l) => e.row.receiveInvoiceDate = l, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", disabledDate: (l) => l.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (s(), h("div", ge, u(e.row.receiveInvoiceDate ? t.parseTime(e.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), a(r, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "*收票额", align: "center", class: "money-column" }, { default: o(() => [a(r, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "85" }, { default: o((e) => [e.row.isModify ? Z((s(), y(E, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (l) => e.row.invoiceAmount = l, modelModifiers: { number: true }, min: -9999999999, max: p.currentRow.settlementAmount ? p.currentRow.settlementAmount - n(k) : 9999999999, step: 100, precision: n(w).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (l) => q(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[Q]]) : (s(), h("div", he, u(n(_)(e.row.invoiceAmount) ? n(I)(e.row.invoiceAmount, n(w).contract) : "-"), 1))]), _: 1 }), a(r, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, u(e.row.invoiceAmount ? n(me)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), a(r, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "120" }, { default: o((e) => [m("div", null, u(e.row.invoiceType ? n(R).VL[e.row.invoiceType] : ""), 1)]), _: 1 }), a(r, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "150" }, { default: o((e) => [e.row.invoiceType !== n(R).RECEIPT.V && e.row.isModify ? (s(), h("div", _e, [m("div", we, [m("div", be, [a(O, { modelValue: e.row.checked, "onUpdate:modelValue": (l) => e.row.checked = l, label: "免税", size: "large", onChange: (l) => H(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), a(E, { modelValue: e.row.taxRate, "onUpdate:modelValue": (l) => e.row.taxRate = l, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "100px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (l) => A(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), i[2] || (i[2] = m("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (s(), h("div", xe, u(n(_)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), a(r, { key: "branchCompanyId", prop: "branchCompanyId", label: "*购方单位", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, u(e.row.branchCompanyName), 1)]), _: 1 }), a(r, { key: "supplierId", prop: "supplierId", label: "*销售单位", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, u(e.row.supplierName), 1)]), _: 1 }), a(r, { key: "invoiceSerialNumber", prop: "invoiceSerialNumber", label: "*发票号码", align: "center", width: "150" }, { default: o((e) => [e.row.isModify ? (s(), y(L, { key: 0, modelValue: e.row.invoiceSerialNumber, "onUpdate:modelValue": (l) => e.row.invoiceSerialNumber = l, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), h("span", Re, u(e.row.invoiceSerialNumber), 1))]), _: 1 }), a(r, { key: "attachments", prop: "attachments", label: "发票附件", align: "center", width: "150" }, { default: o((e) => [a(n(ye), { ref: "uploadRef", files: e.row.attachments, "onUpdate:files": (l) => e.row.attachments = l, "file-classify": n(pe).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])]), _: 1 }), a(r, { label: "操作", align: "center", width: "70" }, { default: o((e) => [a(d, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (l) => F(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), m("div", ke, [a(d, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: i[0] || (i[0] = (e) => j()) }, { default: o(() => i[3] || (i[3] = [x("继续添加")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ee = ce(Ae, [["__scopeId", "data-v-b64de390"]]);
export {
  Ee as default
};
