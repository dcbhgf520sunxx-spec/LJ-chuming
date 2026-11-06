import { ref as k } from "vue";
import { computed as Q } from "vue";
import { watchEffect as O } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { Fragment as $ } from "vue";
import { createBlock as P } from "vue";
import { createCommentVNode as R } from "vue";
import { createElementVNode as C } from "vue";
import { ElCheckbox as W } from "element-plus";
import { watch as X } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as L } from "vue";
import { toDisplayString as M } from "vue";
import { renderList as Z } from "vue";
import { isRef as ee } from "vue";
import { ElFormItem as te } from "element-plus";
import { ElCol as ae } from "element-plus";
import { ElRow as le } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { ElTooltip as se } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as H, ke as ue, bv as re, bH as y, kf as pe, bD as T, b as j, u as ce, ao as me, D as fe, S as ve, i as z } from "../../../../../shared/runtime.js";
import { _ as _e } from "../../../../../modules/UploadBtn-b4cfb47a.js";
const ye = { class: "invoice-type-select flex-rsc child-mr-10" }, be = { __name: "invoice-type-select-no-tax", props: { invoiceType: { type: Number }, taxRate: { type: Number }, checked: { type: Boolean }, showChecked: { type: Boolean, default: false }, classification: { type: Number }, unshowOptions: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: false } }, emits: ["update:invoiceType", "update:taxRate", "update:checked", "change"], setup(h, { emit: D }) {
  const r = D, m = h, f = k(), p = k(), _ = k(), { loaded: U, taxRateKV: I } = ue(), c = Q(() => {
    const s = re.getBits(y, m.classification, "V"), i = [];
    return s.forEach((d) => {
      i.push.apply(i, I.value[d]);
    }), pe(i).map((d) => ({ value: d, label: `${d}` }));
  });
  O(() => {
    f.value = m.invoiceType, l();
  }), O(() => {
    p.value = m.taxRate;
  }), O(() => {
    _.value = m.checked;
  });
  function l() {
    if (!f.value && m.default) {
      f.value = T.SPECIAL.V, A(f.value);
      return;
    }
  }
  function N(s) {
    r("update:checked", s), s && (p.value = 0, r("update:taxRate", p.value)), r("change", {});
  }
  function A(s) {
    j(s) && (s = void 0), _.value = false, N(_.value), s === T.RECEIPT.V && (p.value = 0, r("update:taxRate", p.value)), r("update:invoiceType", s), r("change", {});
  }
  function w(s) {
    j(s) && (s = void 0), r("update:taxRate", s), r("change", {});
  }
  function S(s) {
    p.value = s.target.value || p.value, w(p.value);
  }
  return (s, i) => {
    const e = F("common-select"), d = W;
    return b(), E("span", ye, [t(e, { modelValue: f.value, "onUpdate:modelValue": i[0] || (i[0] = (u) => f.value = u), options: a(T).ENUM, type: "enum", unshowOptions: m.unshowOptions, clearable: m.clearable, disabled: m.disabled, style: { width: "150px" }, placeholder: "选择票据类型", onChange: A }, null, 8, ["modelValue", "options", "unshowOptions", "clearable", "disabled"]), f.value !== a(T).RECEIPT.V ? (b(), E($, { key: 0 }, [h.showChecked ? (b(), P(d, { key: 0, modelValue: _.value, "onUpdate:modelValue": i[1] || (i[1] = (u) => _.value = u), label: "免税", size: "large", onChange: N }, null, 8, ["modelValue"])) : R("", true), t(e, { modelValue: p.value, "onUpdate:modelValue": i[2] || (i[2] = (u) => p.value = u), options: c.value, disabled: m.disabled || _.value, loading: !a(U), "data-structure": { key: "id", label: "label", value: "value" }, "allow-create": "", style: { width: "80px" }, clearable: m.clearable, filterable: "", placeholder: "税率", onBlur: S, onChange: w }, null, 8, ["modelValue", "options", "disabled", "loading", "clearable"]), i[3] || (i[3] = C("span", null, "%", -1))], 64)) : R("", true)]);
  };
} }, he = H(be, [["__scopeId", "data-v-3a1a6892"]]);
const ge = ["onDblclick"], xe = { __name: "invoice", props: { visible: { type: Boolean }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(h, { emit: D }) {
  var s;
  const r = h, m = D, { visible: f, handleClose: p } = ce({ emit: m, props: r, field: "visible" }), _ = k(), U = { attachmentIds: [], files: [], branchCompanyId: void 0, invoiceAmount: void 0, invoiceSerialNumber: void 0, invoiceType: void 0, projectId: void 0, receiveInvoiceDate: void 0, remark: void 0, supplierId: void 0, taxRate: void 0, checked: false, createInvoiceDate: void 0, invoiceContent: void 0, customerUnit: (s = r.detailInfo) == null ? void 0 : s.customerUnit, status: "invoice" }, { CRUD: I, crud: c, form: l } = me(U, _);
  X(() => r.detailInfo, (i) => {
    l.branchCompanyId = i == null ? void 0 : i.branchCompanyId;
  }, { deep: true, immediate: true });
  const w = { invoiceType: [{ validator: (i, e, d) => {
    z(e) ? (e !== T.RECEIPT.V && !l.checked && (z(l.taxRate) || d(new Error("请选择税率")), d()), d()) : d(new Error("请选择发票及税率")), d();
  }, message: "请选择发票及税率", trigger: "change" }], paymentDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], invoiceAmount: [{ required: true, validator: (i, e, d) => {
    z(e) ? d() : d(new Error("金额必填"));
  }, trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号码", trigger: "blur" }], receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }] }, S = y.STEEL_PLATE.V | y.SECTION_STEEL.V | y.STEEL_COIL.V | y.MATERIAL.V | y.GAS.V | y.STRUC_MANUFACTURED.V | y.ENCL_MANUFACTURED.V;
  return I.HOOK.beforeSubmit = () => {
    c.form.attachmentIds = c.form.files ? c.form.files.map((i) => i.id) : c.form.attachments ? c.form.attachments.map((i) => i.id) : void 0, c.form.supplierId = r.detailInfo.supplierId, c.form.boolIncludeTax = !c.form.checked;
  }, I.HOOK.afterSubmit = () => {
    p();
  }, (i, e) => {
    const d = F("common-button"), u = te, v = ae, g = le, K = oe, B = ne, q = ie, G = se, Y = de, J = F("common-drawer");
    return b(), P(J, { modelValue: a(f), "onUpdate:modelValue": e[10] || (e[10] = (n) => ee(f) ? f.value = n : null), onClose: a(c).cancelCU, "close-on-click-modal": false, "show-close": false, "wrapper-closable": false, "append-to-body": "", size: "60%", title: "收票申请" }, { titleRight: o(() => [t(d, { loading: a(c).status.cu === 2, size: "mini", type: "primary", onClick: a(c).submitCU }, { default: o(() => e[11] || (e[11] = [L("确认")])), _: 1, __: [11] }, 8, ["loading", "onClick"]), t(d, { size: "mini", onClick: a(p) }, { default: o(() => e[12] || (e[12] = [L("关闭")])), _: 1, __: [12] }, 8, ["onClick"])]), content: o(() => [t(Y, { ref_key: "formRef", ref: _, model: a(l), rules: w, "label-width": "140px" }, { default: o(() => [t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { label: "购买方", prop: "branchCompanyId" }, { default: o(() => [C("span", null, M(h.detailInfo.branchCompanyName), 1)]), _: 1 })]), _: 1 }), t(v, { span: 12 }, { default: o(() => [t(u, { label: "开票单位", prop: "customerUnit" }, { default: o(() => {
      var n;
      return [C("span", null, M((n = h.detailInfo) == null ? void 0 : n.customerUnit), 1)];
    }), _: 1 })]), _: 1 })]), _: 1 }), t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { class: "form-label-require", label: "发票及税率", prop: "invoiceType" }, { default: o(() => [t(he, { checked: a(l).checked, "onUpdate:checked": e[0] || (e[0] = (n) => a(l).checked = n), invoiceType: a(l).invoiceType, "onUpdate:invoiceType": e[1] || (e[1] = (n) => a(l).invoiceType = n), taxRate: a(l).taxRate, "onUpdate:taxRate": e[2] || (e[2] = (n) => a(l).taxRate = n), classification: S, showChecked: "", style: { width: "280px" } }, null, 8, ["checked", "invoiceType", "taxRate"])]), _: 1 })]), _: 1 })]), _: 1 }), t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { label: "发票面额", prop: "invoiceAmount" }, { default: o(() => [t(K, { modelValue: a(l).invoiceAmount, "onUpdate:modelValue": e[3] || (e[3] = (n) => a(l).invoiceAmount = n), modelModifiers: { number: true }, max: 9999999999, min: -9999999999, precision: a(fe).YUAN, step: 100, "controls-position": "right", placeholder: "收票额(元)", style: { width: "280px" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }), t(v, { span: 12 }, { default: o(() => [t(u, { label: "发票号", prop: "invoiceSerialNumber" }, { default: o(() => [t(B, { modelValue: a(l).invoiceSerialNumber, "onUpdate:modelValue": e[4] || (e[4] = (n) => a(l).invoiceSerialNumber = n), modelModifiers: { trim: true }, maxlength: "20", placeholder: "发票号码", style: { width: "280px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { label: "收票日期", prop: "receiveInvoiceDate" }, { default: o(() => [t(q, { modelValue: a(l).receiveInvoiceDate, "onUpdate:modelValue": e[5] || (e[5] = (n) => a(l).receiveInvoiceDate = n), disabledDate: (n) => n.getTime() > (/* @__PURE__ */ new Date()).getTime(), placeholder: "选择日期", style: { width: "280px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "disabledDate"])]), _: 1 })]), _: 1 }), t(v, { span: 12 }, { default: o(() => [t(u, { label: "开票日期", prop: "createInvoiceDate" }, { default: o(() => [t(q, { modelValue: a(l).createInvoiceDate, "onUpdate:modelValue": e[6] || (e[6] = (n) => a(l).createInvoiceDate = n), disabledDate: (n) => n.getTime() > (/* @__PURE__ */ new Date()).getTime(), placeholder: "选择日期", style: { width: "280px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "disabledDate"])]), _: 1 })]), _: 1 })]), _: 1 }), t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { label: "备注", prop: "remark" }, { default: o(() => [t(B, { modelValue: a(l).remark, "onUpdate:modelValue": e[7] || (e[7] = (n) => a(l).remark = n), autosize: { minRows: 2, maxRows: 4 }, maxlength: "200", placeholder: "请输入备注", "show-word-limit": "", style: { width: "280px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), t(v, { span: 12 }, { default: o(() => [t(u, { label: "发票内容", prop: "invoiceContent" }, { default: o(() => [t(B, { modelValue: a(l).invoiceContent, "onUpdate:modelValue": e[8] || (e[8] = (n) => a(l).invoiceContent = n), autosize: { minRows: 2, maxRows: 4 }, maxlength: "200", placeholder: "请输入发票内容", "show-word-limit": "", style: { width: "280px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t(g, null, { default: o(() => [t(v, { span: 12 }, { default: o(() => [t(u, { label: "发票凭证" }, { label: o(() => {
      var n, x;
      return [e[14] || (e[14] = L(" 付款凭证 ")), a(l).id && ((n = a(l).attachments) != null && n.length) && !((x = a(l).files) != null && x.length) ? (b(), P(G, { key: 0, content: "双击可预览附件", effect: "light", placement: "top" }, { default: o(() => e[13] || (e[13] = [C("i", { class: "el-icon-info" }, null, -1)])), _: 1, __: [13] })) : R("", true)];
    }), default: o(() => {
      var n, x;
      return [a(l).id && ((n = a(l).attachments) != null && n.length) && !((x = a(l).files) != null && x.length) ? (b(true), E($, { key: 0 }, Z(a(l).attachments, (V) => (b(), E("div", { key: V.id }, [C("div", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (Ve) => i.attachmentView(V) }, M(V.name), 41, ge)]))), 128)) : R("", true), t(a(_e), { ref: "uploadRef", files: a(l).files, "onUpdate:files": e[9] || (e[9] = (V) => a(l).files = V), accept: ".jpg,.png,.pdf,.jpeg", "file-classify": a(ve).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"])];
    }), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "onClose"]);
  };
} }, we = H(xe, [["__scopeId", "data-v-12326910"]]);
export {
  we as default
};
