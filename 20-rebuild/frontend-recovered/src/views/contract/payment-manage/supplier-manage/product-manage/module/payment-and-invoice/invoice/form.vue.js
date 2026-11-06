import { ref as k } from "vue";
import { inject as J } from "vue";
import { ElMessage as N } from "element-plus";
import { resolveComponent as C } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as W } from "vue";
import { createElementVNode as g } from "vue";
import { nextTick as X } from "vue";
import { ElTag as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElDatePicker as ee } from "element-plus";
import { ElInputNumber as te } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElForm as oe } from "element-plus";
import { _ as ae, t as ie, ao as le, o as re, bV as I, ia as ue, bD as R, S as ce, aw as se } from "../../../../../../../../shared/runtime.js";
import { _ as me } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
const de = { key: 1 }, pe = { key: 1 }, fe = { key: 1 }, ve = { class: "add-row-box" }, ye = { __name: "form", props: { existInvoiceNo: { type: Array, default: () => [] }, currentRow: { type: Object, default: () => {
} }, propertyType: { type: [Number, String], default: void 0 } }, setup(d) {
  const { decimalPrecision: _ } = ie(), V = k(), E = k(), U = { list: [] }, { CRUD: S, crud: w, form: p } = le(U, V), A = J("totalAmount"), f = k(0), r = d, { maxHeight: M } = re({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), z = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, i) => !!t, message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, i) => i.invoiceType !== R.RECEIPT.V ? !!t : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }], supplierId: [{ required: true, message: "请输入收票单位", trigger: "blur" }], branchCompanyId: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: F, wrongCellMask: q } = se({ rules: z });
  function B(t) {
    p.list.splice(t, 1);
  }
  function P() {
    p.list.push({ id: void 0, orderId: r.currentRow.id, propertyType: r.propertyType, invoiceAmount: void 0, receiveInvoiceDate: void 0, invoiceType: r.currentRow.invoiceType, invoiceSerialNumber: void 0, taxRate: r.currentRow.taxRate, branchCompanyId: r.currentRow.branchCompanyId, branchCompanyName: r.currentRow.branchCompanyName, supplierId: r.currentRow.supplierId, supplierName: r.currentRow.supplierName, dataIndex: p.list.length + 1, isModify: true });
  }
  function $(t) {
    if (r.currentRow.settlementAmount && (f.value = 0, p.list.map((i) => {
      i.invoiceAmount && (f.value += i.invoiceAmount);
    }), f.value > r.currentRow.settlementAmount - A.value)) {
      const i = t.invoiceAmount - (f.value - (r.currentRow.settlementAmount - A.value));
      X(() => {
        t.invoiceAmount = i || 0, f.value = 0, p.list.map((s) => {
          s.invoiceAmount && (f.value += s.invoiceAmount);
        });
      });
    }
    j(t);
  }
  function j(t) {
    t.invoiceAmount && t.taxRate && t.invoiceType !== R.RECEIPT.V && (t.tax = t.invoiceAmount * t.taxRate / 100);
  }
  return S.HOOK.beforeValidateCU = (t, i) => {
    if (t.form.list.length <= 0) return N({ message: "请添加收票明细", type: "error" }), false;
    const { validResult: s, dealList: b } = F(t.form.list);
    if (s) t.form.list = b;
    else return s;
    let l = true;
    if (t.form.list.map((v) => {
      v.invoiceAmount === 0 && (l = false), v.attachmentIds = v.attachments ? v.attachments.map((x) => x.id) : void 0;
    }), !l) return N.error("收票金额必须大于0"), false;
  }, (t, i) => {
    const s = C("common-button"), b = Y, l = Z, v = ee, x = te, H = ne, O = C("common-table"), L = oe, K = C("common-drawer"), G = Q("show-thousand");
    return m(), y(K, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(w).cancelCU, visible: n(w).status.cu > 0, title: n(w).status.title, "wrapper-closable": false, size: "90%" }, { titleRight: o(() => [a(s, { loading: n(w).status.cu === 2, type: "primary", size: "default", onClick: n(w).submitCU }, { default: o(() => i[1] || (i[1] = [h("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: o(() => [d.currentRow.amount ? (m(), y(b, { key: 0, type: "success" }, { default: o(() => [h(c("合同金额:" + n(I)(d.currentRow.amount, n(_).contract)), 1)]), _: 1 })) : D("", true), d.currentRow.settlementAmount ? (m(), y(b, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: o(() => [h(c(`结算额:${n(I)(d.currentRow.settlementAmount, n(_).contract)}`), 1)]), _: 1 })) : D("", true), a(L, { ref_key: "formRef", ref: V, model: n(p), size: "default", "label-width": "140px" }, { default: o(() => [a(O, { ref_key: "detailRef", ref: E, border: "", data: n(p).list, "max-height": n(M), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": n(q) }, { default: o(() => [a(l, { label: "序号", type: "index", align: "center", width: "55" }), a(l, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "*收票日期", align: "center", width: "160" }, { default: o((e) => [e.row.isModify ? (m(), y(v, { key: 0, modelValue: e.row.receiveInvoiceDate, "onUpdate:modelValue": (u) => e.row.receiveInvoiceDate = u, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", disabledDate: (u) => u.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (m(), T("div", de, c(e.row.receiveInvoiceDate ? t.parseTime(e.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), a(l, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "*收票额", align: "center", class: "money-column" }, { default: o(() => [a(l, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "85" }, { default: o((e) => [e.row.isModify ? W((m(), y(x, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (u) => e.row.invoiceAmount = u, modelModifiers: { number: true }, min: 0, max: d.currentRow.settlementAmount ? d.currentRow.settlementAmount - n(A) : 999999999999, step: 100, precision: n(_).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (u) => $(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[G]]) : (m(), T("div", pe, c(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? n(I)(e.row.invoiceAmount, n(_).contract) : e.row.invoiceAmount), 1))]), _: 1 }), a(l, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: o((e) => [g("div", null, c(e.row.invoiceAmount ? "(" + n(ue)(e.row.invoiceAmount) + ")" : ""), 1)]), _: 1 })]), _: 1 }), a(l, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "120" }, { default: o((e) => [g("div", null, c(e.row.invoiceType ? n(R).VL[e.row.invoiceType] : ""), 1)]), _: 1 }), a(l, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "110" }, { default: o((e) => [g("div", null, c(e.row.taxRate && e.row.invoiceType !== n(R).RECEIPT.V ? e.row.taxRate + "%" : ""), 1)]), _: 1 }), a(l, { key: "branchCompanyId", prop: "branchCompanyId", label: "*购方单位", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [g("div", null, c(e.row.branchCompanyName), 1)]), _: 1 }), a(l, { key: "supplierId", prop: "supplierId", label: "*销售单位", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [g("div", null, c(e.row.supplierName), 1)]), _: 1 }), a(l, { key: "invoiceSerialNumber", prop: "invoiceSerialNumber", label: "*发票号码", align: "center", width: "150" }, { default: o((e) => [e.row.isModify ? (m(), y(H, { key: 0, modelValue: e.row.invoiceSerialNumber, "onUpdate:modelValue": (u) => e.row.invoiceSerialNumber = u, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (m(), T("span", fe, c(e.row.invoiceSerialNumber), 1))]), _: 1 }), a(l, { key: "attachments", prop: "attachments", label: "发票附件", align: "center", width: "150" }, { default: o((e) => [a(n(me), { ref: "uploadRef", files: e.row.attachments, "onUpdate:files": (u) => e.row.attachments = u, "file-classify": n(ce).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])]), _: 1 }), a(l, { label: "操作", align: "center", width: "70" }, { default: o((e) => [a(s, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (u) => B(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), g("div", ve, [a(s, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: i[0] || (i[0] = (e) => P()) }, { default: o(() => i[2] || (i[2] = [h("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Re = ae(ye, [["__scopeId", "data-v-31b4a1a4"]]);
export {
  Re as default
};
