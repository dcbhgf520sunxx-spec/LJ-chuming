import { ref as h } from "vue";
import { computed as E } from "vue";
import { watch as k } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as V } from "vue";
import { createBlock as w } from "vue";
import { useStore as L } from "vuex";
import { mergeProps as M } from "vue";
import { unref as e } from "vue";
import { resolveDirective as G } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as B } from "vue";
import { withDirectives as H } from "vue";
import { createCommentVNode as N } from "vue";
import { createElementBlock as F } from "vue";
import { Fragment as K } from "vue";
import { renderList as J } from "vue";
import { createElementVNode as Q } from "vue";
import { toDisplayString as W } from "vue";
import { ElInput as X } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElDatePicker as Z } from "element-plus";
import { ElInputNumber as ee } from "element-plus";
import { ElForm as te } from "element-plus";
import { _ as le } from "../../../../modules/UploadBtn-b4cfb47a.js";
import { bN as ae, mx as oe, b as I, ai as z, _ as ne, t as se, ao as de, q as ue, bE as ie, bF as re, bD as S, S as me, L as ce, iy as pe } from "../../../../shared/runtime.js";
const fe = { __name: "project-subcontract-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "name", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, placeholder: { type: String, default: "请选择项目" }, businessType: { type: Number, default: ae.INSTALLATION.V } }, emits: ["update:modelValue", "change", "changeInfo"], setup(n, { emit: g }) {
  const { projects: p } = oe(), b = h(), r = g, m = n, v = h(false), s = h(), t = E(() => p.value.filter((d) => d.businessType === m.businessType));
  k(() => m.modelValue, (d) => {
    s.value = d;
  }), k(() => m.modelValue, (d) => {
    s.value = d;
  }, { immediate: true });
  function c(d) {
    let u = d;
    I(u) && (u = void 0);
    const T = !z(u, m.modelValue), C = I(u) && I(m.modelValue);
    if (T && !C) {
      r("update:modelValue", u), r("change", u);
      const y = d ? t.value.find((l) => l.id === d) : {};
      r("changeInfo", y);
    }
  }
  return (d, u) => {
    const T = x("common-select");
    return V(), w(T, { ref_key: "subcontractRef", ref: b, modelValue: s.value, "onUpdate:modelValue": u[0] || (u[0] = (C) => s.value = C), loading: v.value, options: t.value, type: "other", "collapse-tags": n.collapseTags, "data-structure": n.dataStructure, size: n.size, clearable: n.clearable, "default-id": m.defaultId, disabled: m.disabled, filterable: "", placeholder: n.placeholder, onChange: c }, null, 8, ["modelValue", "loading", "options", "collapse-tags", "data-structure", "size", "clearable", "default-id", "disabled", "placeholder"]);
  };
} }, ge = (n) => {
  const g = L(), p = E(() => g.state.config.loaded.subcontractType);
  if (p.value || g.dispatch("config/fetchSubcontractType"), n) {
    const b = k(p, (r) => {
      r && setTimeout(() => {
        n(), b();
      }, 0);
    }, { immediate: true });
  }
  return { subcontractType: E(() => g.state.config.subcontractType), loaded: p };
}, be = { __name: "subcontract-type-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择分包类别" } }, emits: ["change", "update:modelValue"], setup(n, { emit: g }) {
  const p = g, b = n, r = h(), { loaded: m, subcontractType: v } = ge();
  k(() => b.modelValue, (t) => {
    r.value = t;
  }, { immediate: true });
  function s(t) {
    let c = t;
    I(c) && (c = void 0);
    const d = !z(c, b.modelValue), u = I(c) && I(b.modelValue);
    d && !u && (p("update:modelValue", c), p("change", c));
  }
  return (t, c) => {
    const d = x("common-select");
    return V(), w(d, M(t.$attrs, { modelValue: r.value, "onUpdate:modelValue": c[0] || (c[0] = (u) => r.value = u), size: n.size, disabled: n.disabled, multiple: n.multiple, loading: !e(m), clearable: n.clearable, showOptionAll: n.showOptionAll, allLabelText: "全部", filterable: "", placeholder: n.placeholder, options: e(v), onChange: s }), null, 16, ["modelValue", "size", "disabled", "multiple", "loading", "clearable", "showOptionAll", "placeholder", "options"]);
  };
} };
const ye = ["onClick"], Ve = { __name: "form", setup(n) {
  const { decimalPrecision: g } = se(), p = h(), b = { serialNumber: void 0, projectId: void 0, monomerIds: void 0, subcontractClassId: void 0, supplierId: void 0, amount: void 0, invoiceType: void 0, taxRate: void 0, remark: void 0, signDate: void 0, attachmentFiles: [], attachmentIds: void 0 }, r = h(false), m = h(), { CRUD: v, crud: s, form: t } = de(b, p), d = { serialNumber: [{ required: true, message: "请输入订单编号", trigger: "blur" }], signDate: [{ required: true, message: "请选择签订日期", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], monomerIds: [{ required: true, message: "请选择单体", trigger: "change" }], subcontractClassId: [{ required: true, message: "请选择分包类别", trigger: "change" }], supplierId: [{ required: true, message: "请选择分包单位", trigger: "change" }], amount: [{ required: true, message: "请输入合同额", trigger: "change" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], taxRate: [{ required: true, validator: (y, l, R) => {
    t.invoiceType !== S.RECEIPT.V && (l || R(new Error("请填写税率"))), R();
  }, trigger: "blur" }] };
  function u(y) {
    m.value = y.id, r.value = true;
  }
  function T(y) {
    y === S.RECEIPT.V && (t.taxRate = void 0);
  }
  function C() {
    t.monomerIds = [];
  }
  return v.HOOK.beforeSubmit = async () => {
    s.form.attachmentIds = s.form.attachmentFiles ? s.form.attachmentFiles.map((y) => y.id) : s.form.attachmentIds;
  }, (y, l) => {
    const R = x("common-button"), U = X, f = Y, D = Z, j = ee, q = x("common-select"), O = le, A = te, P = x("common-dialog"), $ = G("show-thousand");
    return V(), w(P, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: e(s).status.cu > 0, title: e(s).status.title, width: "600px" }, { titleRight: i(() => [a(R, { loading: e(s).status.cu === 2, type: "primary", size: "default", onClick: e(s).submitCU }, { default: i(() => l[12] || (l[12] = [B("提交")])), _: 1, __: [12] }, 8, ["loading", "onClick"])]), default: i(() => [a(A, { ref_key: "formRef", ref: p, model: e(t), rules: d, size: "default", "label-width": "120px", "label-position": "right" }, { default: i(() => [a(f, { label: "订单编号", prop: "serialNumber" }, { default: i(() => [a(U, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).serialNumber = o), type: "text", maxlength: "20", placeholder: "请输入订单编号", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), a(f, { label: "签订日期", prop: "signDate" }, { default: i(() => [a(D, { modelValue: e(t).signDate, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).signDate = o), type: "date", "value-format": "x", style: { width: "200px" }, placeholder: "签订日期" }, null, 8, ["modelValue"])]), _: 1 }), a(f, { label: "项目", prop: "projectId" }, { default: i(() => [a(fe, { modelValue: e(t).projectId, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).projectId = o), defaultId: e(t).id ? e(t).projectId : void 0, onChange: C }, null, 8, ["modelValue", "defaultId"])]), _: 1 }), a(f, { label: "包含单体", prop: "monomerIds" }, { default: i(() => [a(e(ue), { ref: "monomerSelectRef", modelValue: e(t).monomerIds, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).monomerIds = o), "project-id": e(t).projectId, multiple: "", default: false, defaultValue: e(t).id ? e(t).monomerIds : void 0, clearable: "" }, null, 8, ["modelValue", "project-id", "defaultValue"])]), _: 1 }), a(f, { label: "分包单位", prop: "supplierId" }, { default: i(() => [a(ie, { modelValue: e(t).supplierId, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(t).supplierId = o), type: e(re).SUBCONTRACTING.V, clearable: "", filterable: "", style: { width: "200px" } }, null, 8, ["modelValue", "type"])]), _: 1 }), a(f, { label: "分包类别", prop: "subcontractClassId" }, { default: i(() => [a(e(be), { modelValue: e(t).subcontractClassId, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).subcontractClassId = o) }, null, 8, ["modelValue"])]), _: 1 }), a(f, { label: "合同额", prop: "amount" }, { default: i(() => [H(a(j, { modelValue: e(t).amount, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(t).amount = o), max: 9999999999, min: 0, step: 100, precision: e(g).supplyChain, "controls-position": "right", placeholder: "合同额(元)", style: { width: "200px" } }, null, 8, ["modelValue", "precision"]), [[$]])]), _: 1 }), a(f, { label: "发票类型", prop: "invoiceType" }, { default: i(() => [a(q, { type: "enum", size: "default", modelValue: e(t).invoiceType, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(t).invoiceType = o), options: e(S).ENUM, placeholder: "选择发票类型", onChange: T }, null, 8, ["modelValue", "options"])]), _: 1 }), e(t).invoiceType !== e(S).RECEIPT.V ? (V(), w(f, { key: 0, label: "税率", prop: "taxRate" }, { default: i(() => [a(j, { modelValue: e(t).taxRate, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(t).taxRate = o), step: 1, min: 0, max: 100, precision: 0, controls: false, placeholder: "0-100" }, null, 8, ["modelValue"]), l[13] || (l[13] = B("% "))]), _: 1, __: [13] })) : N("", true), a(f, { label: "备注", prop: "remark" }, { default: i(() => [a(U, { modelValue: e(t).remark, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(t).remark = o), type: "textarea", style: { width: "100%" }, maxlength: "500", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入备注", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), a(f, { label: "附件", prop: "attachments" }, { default: i(() => {
      var o;
      return [a(O, { ref: "uploadRef", files: e(t).attachmentFiles, "onUpdate:files": l[10] || (l[10] = (_) => e(t).attachmentFiles = _), "file-classify": e(me).NORMAL.V, limit: 10, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "file-classify"]), ((o = e(t).attachments) == null ? void 0 : o.length) > 0 && (!e(t).attachmentFiles || e(t).attachmentFiles.length === 0) ? (V(true), F(K, { key: 0 }, J(e(t).attachments, (_) => (V(), F("div", { key: _.id }, [Q("span", { style: { cursor: "pointer", color: "#409eff", "margin-left": "3px" }, onClick: (he) => u(_) }, W(_.name), 9, ye), a(ce, { params: { id: _.id } }, null, 8, ["params"])]))), 128)) : N("", true)];
    }), _: 1 }), r.value ? (V(), w(pe, { key: 1, isVisible: r.value, showType: "attachment", id: m.value, onClose: l[11] || (l[11] = (o) => r.value = false) }, null, 8, ["isVisible", "id"])) : N("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Te = ne(Ve, [["__scopeId", "data-v-c4fca8bb"]]);
export {
  Te as default
};
