import { ref as V } from "vue";
import { inject as X } from "vue";
import { ElMessage as Y } from "element-plus";
import { resolveComponent as x } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as c } from "vue";
import { createBlock as v } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as ee } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as te } from "vue";
import { createElementVNode as p } from "vue";
import { nextTick as oe } from "vue";
import { ElTag as ne } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { ElInputNumber as le } from "element-plus";
import { ElCheckbox as re } from "element-plus";
import { ElInput as ce } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as se, t as ue, ao as me, o as pe, bV as U, i as _, ia as fe, bD as b, S as ve, aw as he } from "../../../../../../../../shared/runtime.js";
import { _ as ye } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
const ge = { key: 1 }, _e = { key: 1 }, be = { key: 1 }, we = { key: 0 }, xe = { style: { display: "flex" } }, ke = { style: { "padding-right": "5px" } }, Re = { key: 1 }, Ce = { key: 1 }, Te = { class: "add-row-box" }, Ve = { __name: "form", props: { existInvoiceNo: { type: Array, default: () => [] }, currentRow: { type: Object, default: () => {
} }, propertyType: { type: [Number, String], default: void 0 } }, setup(w) {
  const { decimalPrecision: k } = ue(), I = V(), D = V(), E = { list: [] }, { CRUD: M, crud: y, form: m } = me(E, I), R = X("totalAmount"), f = V(0), u = w, { maxHeight: S } = pe({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), z = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, i) => !!_(t), message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, i) => i.invoiceType !== b.RECEIPT.V && !i.checked ? _(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }], supplierId: [{ required: true, message: "请输入收票单位", trigger: "blur" }], branchCompanyId: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: $, wrongCellMask: B } = he({ rules: z });
  function q(t) {
    m.list.splice(t, 1);
  }
  function F() {
    m.list.push({ id: void 0, orderId: u.currentRow.id, propertyType: u.propertyType, invoiceAmount: void 0, receiveInvoiceDate: void 0, invoiceType: void 0, invoiceSerialNumber: void 0, checked: false, boolIncludeTax: true, taxRate: void 0, tax: void 0, branchCompanyId: u.currentRow.branchCompanyId, branchCompanyName: u.currentRow.branchCompanyName, supplierId: u.currentRow.supplierId, supplierName: u.currentRow.supplierName, dataIndex: m.list.length + 1, isModify: true });
  }
  function P(t) {
    t.checked = false, t.boolIncludeTax = true, t.invoiceType === b.RECEIPT.V && (t.taxRate = 0, g(t));
  }
  function j(t) {
    if (f.value = 0, m.list.map((i) => {
      i.invoiceAmount && (f.value += i.invoiceAmount);
    }), f.value > u.currentRow.freight - R.value) {
      const i = t.invoiceAmount - (f.value - (u.currentRow.freight - R.value));
      oe(() => {
        t.invoiceAmount = i || 0, g(t), f.value = 0, m.list.map((d) => {
          d.invoiceAmount && (f.value += d.invoiceAmount);
        });
      });
    } else g(t);
  }
  function H(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : t.taxRate, g(t);
  }
  function g(t) {
    t.tax = 0, _(t.invoiceAmount) && t.taxRate && (t.tax = t.invoiceAmount * t.taxRate / 100);
  }
  return M.HOOK.beforeValidateCU = (t, i) => {
    if (t.form.list.length <= 0) return Y({ message: "请添加收票明细", type: "error" }), false;
    const { validResult: d, dealList: C } = $(t.form.list);
    if (d) t.form.list = C;
    else return d;
    t.form.list.map((r) => {
      r.attachmentIds = r.attachments ? r.attachments.map((T) => T.id) : void 0;
    });
  }, (t, i) => {
    const d = x("common-button"), C = ne, r = ae, T = ie, N = le, O = x("common-select"), L = re, K = ce, G = x("common-table"), J = de, Q = x("common-drawer"), W = Z("show-thousand");
    return c(), v(Q, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(y).cancelCU, visible: o(y).status.cu > 0, title: o(y).status.title, "wrapper-closable": false, size: "90%" }, { titleRight: l(() => [a(d, { loading: o(y).status.cu === 2, type: "primary", size: "default", onClick: o(y).submitCU }, { default: l(() => i[1] || (i[1] = [A("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: l(() => [w.currentRow.freight ? (c(), v(C, { key: 0, type: "success" }, { default: l(() => [A(s("运输额:" + o(U)(w.currentRow.freight, o(k).contract)), 1)]), _: 1 })) : ee("", true), a(J, { ref_key: "formRef", ref: I, model: o(m), size: "default", "label-width": "140px" }, { default: l(() => [a(G, { ref_key: "detailRef", ref: D, border: "", data: o(m).list, "max-height": o(S), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": o(B) }, { default: l(() => [a(r, { label: "序号", type: "index", align: "center", width: "55" }), a(r, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "*收票日期", align: "center", width: "160" }, { default: l((e) => [e.row.isModify ? (c(), v(T, { key: 0, modelValue: e.row.receiveInvoiceDate, "onUpdate:modelValue": (n) => e.row.receiveInvoiceDate = n, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" }, disabledDate: (n) => n.getTime() > (/* @__PURE__ */ new Date()).getTime() }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (c(), h("div", ge, s(e.row.receiveInvoiceDate ? t.parseTime(e.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), a(r, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "*收票额", align: "center", class: "money-column" }, { default: l(() => [a(r, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "85" }, { default: l((e) => [e.row.isModify ? te((c(), v(N, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (n) => e.row.invoiceAmount = n, modelModifiers: { number: true }, min: -9999999999, max: w.currentRow.freight - o(R), step: 100, precision: o(k).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (n) => j(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[W]]) : (c(), h("div", _e, s(o(_)(e.row.invoiceAmount) ? o(U)(e.row.invoiceAmount, o(k).contract) : "-"), 1))]), _: 1 }), a(r, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: l((e) => [p("div", null, s(e.row.invoiceAmount ? o(fe)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), a(r, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "180" }, { default: l((e) => [e.row.isModify ? (c(), v(O, { key: 0, modelValue: e.row.invoiceType, "onUpdate:modelValue": (n) => e.row.invoiceType = n, options: o(b).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "发票类型", style: { width: "100%" }, onChange: (n) => P(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (c(), h("div", be, s(e.row.invoiceType ? o(b).VL[e.row.invoiceType] : ""), 1))]), _: 1 }), a(r, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "150" }, { default: l((e) => [e.row.invoiceType !== o(b).RECEIPT.V && e.row.isModify ? (c(), h("div", we, [p("div", xe, [p("div", ke, [a(L, { modelValue: e.row.checked, "onUpdate:modelValue": (n) => e.row.checked = n, label: "免税", size: "large", onChange: (n) => H(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), a(N, { modelValue: e.row.taxRate, "onUpdate:modelValue": (n) => e.row.taxRate = n, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "100px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (n) => g(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), i[2] || (i[2] = p("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (c(), h("div", Re, s(o(_)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), a(r, { key: "branchCompanyId", prop: "branchCompanyId", label: "*购方单位", align: "center", "show-overflow-tooltip": true }, { default: l((e) => [p("div", null, s(e.row.branchCompanyName), 1)]), _: 1 }), a(r, { key: "supplierId", prop: "supplierId", label: "*销售单位", align: "center", "show-overflow-tooltip": true }, { default: l((e) => [p("div", null, s(e.row.supplierName), 1)]), _: 1 }), a(r, { key: "invoiceSerialNumber", prop: "invoiceSerialNumber", label: "*发票号码", align: "center", width: "120" }, { default: l((e) => [e.row.isModify ? (c(), v(K, { key: 0, modelValue: e.row.invoiceSerialNumber, "onUpdate:modelValue": (n) => e.row.invoiceSerialNumber = n, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (c(), h("span", Ce, s(e.row.invoiceSerialNumber), 1))]), _: 1 }), a(r, { key: "attachments", prop: "attachments", label: "发票附件", align: "center", width: "150" }, { default: l((e) => [a(o(ye), { ref: "uploadRef", files: e.row.attachments, "onUpdate:files": (n) => e.row.attachments = n, "file-classify": o(ve).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])]), _: 1 }), a(r, { label: "操作", align: "center" }, { default: l((e) => [a(d, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (n) => q(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), p("div", Te, [a(d, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: i[0] || (i[0] = (e) => F()) }, { default: l(() => i[3] || (i[3] = [A("继续添加")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ee = se(Ve, [["__scopeId", "data-v-908ef7cc"]]);
export {
  Ee as default
};
