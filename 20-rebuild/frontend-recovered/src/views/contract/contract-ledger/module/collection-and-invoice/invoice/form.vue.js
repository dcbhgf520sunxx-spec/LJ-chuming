import { ref as I } from "vue";
import { inject as D } from "vue";
import { ElMessage as te } from "element-plus";
import { resolveComponent as b } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as r } from "vue";
import { createBlock as p } from "vue";
import { withCtx as l } from "vue";
import { createVNode as i } from "vue";
import { unref as o } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as B } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as ne } from "vue";
import { createElementVNode as y } from "vue";
import { nextTick as ae } from "vue";
import { ElTag as ie } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElDatePicker as re } from "element-plus";
import { ElInputNumber as ce } from "element-plus";
import { ElCheckbox as ue } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElForm as me } from "element-plus";
import { _ as se, t as pe, ao as ve, o as fe, bV as R, ia as ye, bD as T, iD as E, i as U, aw as we } from "../../../../../../shared/runtime.js";
const he = { key: 1 }, ge = { key: 1 }, _e = { key: 0 }, xe = { style: { display: "flex" } }, ke = { style: { "padding-right": "5px" } }, Ae = { key: 1 }, be = { key: 1 }, Ve = { key: 1 }, Re = { key: 1 }, Te = { key: 1 }, Ue = { class: "add-row-box" }, Ce = { __name: "form", props: { existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, setup(w) {
  const N = I(), j = I(), z = { projectId: void 0, list: [] }, { decimalPrecision: h } = pe(), { CRUD: F, crud: _, form: v } = ve(z, N), m = D("contractInfo"), C = D("totalAmount"), g = I(0), u = w, { maxHeight: L } = fe({ wrapperBox: ".invoiceAddForm", paginate: true, extraHeight: 40 }), $ = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, n) => !!U(t), message: "请选择开票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, n) => n.invoiceType !== T.RECEIPT.V && u.currentRow.isTax !== E.NO.V && !n.checked ? U(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ validator: (t, n) => u.currentRow.isTax !== E.NO.V ? !!t : true, message: "请选择发票类型", trigger: "change" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, { tableValidate: O, wrongCellMask: P } = we({ rules: $ });
  function q(t) {
    v.list.splice(t, 1);
  }
  function H() {
    v.list.push({ invoiceAmount: void 0, invoiceDate: void 0, invoiceType: u.currentRow.invoiceType, invoiceNo: void 0, taxRate: u.currentRow.taxRate ? u.currentRow.taxRate * 100 : void 0, checked: false, boolIncludeTax: true, tax: void 0, invoiceUnit: m.value.companyBankAccountList && m.value.companyBankAccountList.length > 0 ? m.value.companyBankAccountList[0].companyName : void 0, invoiceUnitId: m.value.companyBankAccountList && m.value.companyBankAccountList.length > 0 ? m.value.companyBankAccountList[0].companyId : void 0, collectionUnit: m.value.customerUnit || void 0, projectId: u.projectId, dataIndex: v.list.length + 1, isModify: true });
  }
  function S(t) {
    console.log(t), console.log(v.list);
  }
  function K(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : u.currentRow.taxRate ? u.currentRow.taxRate * 100 : void 0, x(t);
  }
  function G(t) {
    if (u.currentRow.settlementAmount && (g.value = 0, v.list.map((n) => {
      n.invoiceAmount && (g.value += n.invoiceAmount);
    }), g.value > u.currentRow.settlementAmount - C.value)) {
      const n = t.invoiceAmount - (g.value - (u.currentRow.settlementAmount - C.value));
      ae(() => {
        t.invoiceAmount = n || 0, x(t), g.value = 0, v.list.map((s) => {
          s.invoiceAmount && (g.value += s.invoiceAmount);
        });
      });
    }
    x(t);
  }
  function x(t) {
    t.tax = 0;
    let n = t.invoiceAmount;
    U(t.invoiceAmount) && t.taxRate ? (t.tax = t.invoiceAmount * t.taxRate / 100, n = (t.invoiceAmount / (1 + t.taxRate / 100)).toFixed(h.value.contract)) : t.invoiceType === T.RECEIPT.V && (n = t.invoiceAmount), t.noTaxAmount = n;
  }
  return F.HOOK.beforeValidateCU = (t, n) => {
    if (t.form.list.length <= 0) return te({ message: "请添加开票明细", type: "error" }), false;
    const { validResult: s, dealList: k } = O(t.form.list);
    if (s) t.form.list = k;
    else return s;
    t.form.projectId = u.projectId;
  }, (t, n) => {
    const s = b("common-button"), k = ie, c = le, J = re, M = ce, Q = b("common-select"), W = ue, A = de, X = b("common-table"), Y = me, Z = b("common-drawer"), ee = oe("show-thousand");
    return r(), p(Z, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(_).cancelCU, visible: o(_).status.cu > 0, title: o(_).status.title, "wrapper-closable": false, size: "100%" }, { titleRight: l(() => [i(s, { loading: o(_).status.cu === 2, type: "primary", size: "default", onClick: o(_).submitCU }, { default: l(() => n[1] || (n[1] = [V("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: l(() => [o(m).contractAmount ? (r(), p(k, { key: 0, type: "success" }, { default: l(() => [V(d("合同金额:" + o(R)(o(m).contractAmount, o(h).contract)), 1)]), _: 1 })) : B("", true), w.currentRow.settlementAmount ? (r(), p(k, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: l(() => [V(d("结算金额:" + o(R)(w.currentRow.settlementAmount, o(h).contract)), 1)]), _: 1 })) : B("", true), i(Y, { ref_key: "formRef", ref: N, model: o(v), size: "default", "label-width": "140px" }, { default: l(() => [i(X, { ref_key: "detailRef", ref: j, border: "", data: o(v).list, "max-height": o(L), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "cell-class-name": o(P), "return-source-data": "", showEmptySymbol: false }, { default: l(() => [i(c, { label: "序号", type: "index", align: "center", width: "55" }), i(c, { key: "invoiceDate", prop: "invoiceDate", label: "*开票日期", align: "center", width: "160" }, { default: l((e) => [e.row.isModify ? (r(), p(J, { key: 0, modelValue: e.row.invoiceDate, "onUpdate:modelValue": (a) => e.row.invoiceDate = a, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", he, d(e.row.invoiceDate ? t.parseTime(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), i(c, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "*开票额", align: "center", "min-width": "180", class: "money-column" }, { default: l(() => [i(c, { key: "invoiceAmount", prop: "invoiceAmount", label: "金额", align: "center", "min-width": "85" }, { default: l((e) => [e.row.isModify ? ne((r(), p(M, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (a) => e.row.invoiceAmount = a, modelModifiers: { number: true }, min: -9999999999, max: w.currentRow.settlementAmount ? w.currentRow.settlementAmount - o(C) : 9999999999, step: 100, precision: o(h).contract, placeholder: "开票额(元)", "controls-position": "right", onChange: (a) => G(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[ee]]) : (r(), f("div", ge, d(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? o(R)(e.row.invoiceAmount, o(h).contract) : e.row.invoiceAmount), 1))]), _: 1 }), i(c, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", "min-width": "85", "show-overflow-tooltip": true }, { default: l((e) => [y("div", null, d(e.row.invoiceAmount ? o(ye)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), i(c, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "160" }, { default: l((e) => [i(Q, { modelValue: e.row.invoiceType, "onUpdate:modelValue": (a) => e.row.invoiceType = a, options: o(T).ENUM, type: "enum", placeholder: "发票类型", onChange: (a) => S(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), i(c, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "130" }, { default: l((e) => [e.row.invoiceType !== o(T).RECEIPT.V && w.currentRow.isTax !== o(E).NO.V && e.row.isModify ? (r(), f("div", _e, [y("div", xe, [y("div", ke, [i(W, { modelValue: e.row.checked, "onUpdate:modelValue": (a) => e.row.checked = a, label: "免税", size: "large", onChange: (a) => K(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), i(M, { modelValue: e.row.taxRate, "onUpdate:modelValue": (a) => e.row.taxRate = a, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "80px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (a) => x(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), n[2] || (n[2] = y("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (r(), f("div", Ae, d(o(U)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), i(c, { key: "noTaxAmount", prop: "noTaxAmount", label: "不含税金额", align: "center", width: "70" }, { default: l((e) => [y("span", null, d(e.row.noTaxAmount && e.row.noTaxAmount > 0 ? o(R)(e.row.noTaxAmount, o(h).contract) : e.row.noTaxAmount), 1)]), _: 1 }), i(c, { key: "invoiceUnit", prop: "invoiceUnit", label: "*开票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l((e) => [y("div", null, d(e.row.invoiceUnit), 1)]), _: 1 }), i(c, { key: "collectionUnit", prop: "collectionUnit", label: "*收票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l((e) => [e.row.isModify ? (r(), p(A, { key: 0, modelValue: e.row.collectionUnit, "onUpdate:modelValue": (a) => e.row.collectionUnit = a, modelModifiers: { trim: true }, placeholder: "收票单位", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", be, d(e.row.collectionUnit), 1))]), _: 1 }), i(c, { prop: "invoiceNo", label: "*发票号码", align: "center", "min-width": "130" }, { default: l((e) => [e.row.isModify ? (r(), p(A, { key: 0, modelValue: e.row.invoiceNo, "onUpdate:modelValue": (a) => e.row.invoiceNo = a, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("span", Ve, d(e.row.invoiceNo), 1))]), _: 1 }), i(c, { prop: "invoiceContent", label: "发票内容", align: "center", "min-width": "130" }, { default: l((e) => [e.row.isModify ? (r(), p(A, { key: 0, modelValue: e.row.invoiceContent, "onUpdate:modelValue": (a) => e.row.invoiceContent = a, modelModifiers: { trim: true }, type: "text", placeholder: "发票内容", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("span", Re, d(e.row.invoiceContent), 1))]), _: 1 }), i(c, { prop: "remark", label: "备注", align: "center", "min-width": "130" }, { default: l((e) => [e.row.isModify ? (r(), p(A, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (a) => e.row.remark = a, modelModifiers: { trim: true }, type: "textarea", placeholder: "备注", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("span", Te, d(e.row.remark), 1))]), _: 1 }), i(c, { label: "操作", align: "center" }, { default: l((e) => [i(s, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (a) => q(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), y("div", Ue, [i(s, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: n[0] || (n[0] = (e) => H()) }, { default: l(() => n[3] || (n[3] = [V("继续添加")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Be = se(Ce, [["__scopeId", "data-v-8a75365c"]]);
export {
  Be as default
};
