import { ref as V } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as b } from "vue";
import { createBlock as I } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { unref as n } from "vue";
import { createTextVNode as A } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as y } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as S } from "vue";
import { renderList as T } from "vue";
import { createCommentVNode as U } from "vue";
import { isRef as te } from "vue";
import { ElFormItem as ne } from "element-plus";
import { ElCol as ae } from "element-plus";
import { ElRow as le } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElDatePicker as de } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElOption as se } from "element-plus";
import { ElSelect as ue } from "element-plus";
import { ElTooltip as me } from "element-plus";
import { ElForm as pe } from "element-plus";
import { _ as re, g8 as fe, u as ce, ao as ye, D as _e, ia as be, iv as ke, kd as F, S as ge, iy as Ve, kb as Ie, i as he } from "../../../../../shared/runtime.js";
import { _ as ve } from "../../../../../modules/UploadBtn-b4cfb47a.js";
const we = { style: { color: "#82848a" } }, Ce = ["onDblclick"], Ae = { __name: "payment", props: { visible: { type: Boolean }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(m, { emit: j }) {
  const x = V(), z = fe(["payment_reason"]), k = m, H = j, { visible: h, handleClose: R } = ce({ emit: H, props: k, field: "visible" }), q = { paymentDate: (/* @__PURE__ */ new Date()).getTime(), actualReceivingUnitId: void 0, applyAmount: void 0, attachmentIds: [], files: [], paymentBank: void 0, paymentBankAccount: void 0, paymentReasonId: void 0, branchCompanyId: void 0, projectId: void 0, receivingUnitId: void 0, remark: void 0, receiveBank: void 0, receiveBankAccount: void 0, paymentMethod: void 0, customerUnit: void 0, status: "payment" }, { CRUD: v, crud: u, form: l } = ye(q, x), g = V(false), D = V();
  V([]), ee(() => k.detailInfo, (d) => {
    l.branchCompanyId = d == null ? void 0 : d.branchCompanyId, l.customerUnit = d == null ? void 0 : d.customerUnit;
  }, { deep: true, immediate: true });
  const $ = { paymentDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], paymentReasonId: [{ required: true, message: "请选择付款事由", trigger: "change" }], applyAmount: [{ required: true, validator: (d, a, _) => {
    he(a) || _(new Error("请填写申请金额")), _();
  }, trigger: "blur" }], paymentMethod: [{ required: true, message: "请选择付款方式", trigger: "change" }] };
  v.HOOK.afterToAdd = () => {
    u.form.actualReceivingUnitId = u.form.actualReceivingUnitId || k.detailInfo.supplierId;
  };
  function K(d) {
    D.value = d.id, g.value = true;
  }
  function L(d) {
    d === F.CASH.V && (u.form.paymentBankAccount = void 0, u.form.paymentBank = void 0);
  }
  function P(d) {
    const a = k.detailInfo.bankList.find((_) => _.depositBank === d) || {};
    u.form.paymentBankAccount = a.account;
  }
  return v.HOOK.beforeSubmit = () => {
    u.form.attachmentIds = u.form.files ? u.form.files.map((d) => d.id) : u.form.attachments ? u.form.attachments.map((d) => d.id) : void 0, u.form.receivingUnitId = k.detailInfo.supplierId;
  }, v.HOOK.afterSubmit = () => {
    R();
  }, (d, a) => {
    const _ = O("common-button"), i = ne, s = ae, r = le, w = oe, Q = de, Y = ie, E = O("common-select"), G = se, J = ue, W = me, X = pe;
    return b(), I(Ie, { modelValue: n(h), "onUpdate:modelValue": a[10] || (a[10] = (o) => te(h) ? h.value = o : null), "close-on-click-modal": false, "show-close": false, "wrapper-closable": false, "append-to-body": "", size: "60%", title: "付款申请", onClose: n(u).cancelCU }, { titleRight: t(() => [e(_, { loading: n(u).status.cu === 2, size: "mini", type: "primary", onClick: n(u).submitCU }, { default: t(() => a[11] || (a[11] = [A("提交审核")])), _: 1, __: [11] }, 8, ["loading", "onClick"]), e(_, { size: "mini", onClick: n(R) }, { default: t(() => a[12] || (a[12] = [A("关闭")])), _: 1, __: [12] }, 8, ["onClick"])]), content: t(() => [e(X, { ref_key: "formRef", ref: x, model: n(l), rules: $, "label-width": "130px" }, { default: t(() => [e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "出售方" }, { default: t(() => {
      var o;
      return [p("span", null, y((o = m.detailInfo) == null ? void 0 : o.customerUnit), 1)];
    }), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "累计回收额" }, { default: t(() => [p("span", null, y(m.detailInfo.totalAmount), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "累计付款" }, { default: t(() => [p("span", null, y(m.detailInfo.paymentAmount), 1)]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "累计收票" }, { default: t(() => [p("span", null, y(m.detailInfo.invoiceAmount), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "开户行", prop: "receiveBank" }, { default: t(() => [e(w, { modelValue: n(l).receiveBank, "onUpdate:modelValue": a[0] || (a[0] = (o) => n(l).receiveBank = o), modelModifiers: { trim: true }, maxlength: "50", placeholder: "请输入开户行", style: { width: "280px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "账号", prop: "receiveBankAccount" }, { default: t(() => [e(w, { modelValue: n(l).receiveBankAccount, "onUpdate:modelValue": a[1] || (a[1] = (o) => n(l).receiveBankAccount = o), modelModifiers: { trim: true }, maxlength: "50", placeholder: "请输入账号", style: { width: "280px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款日期", prop: "paymentDate" }, { default: t(() => [e(Q, { modelValue: n(l).paymentDate, "onUpdate:modelValue": a[2] || (a[2] = (o) => n(l).paymentDate = o), placeholder: "选择付款日期", style: { width: "280px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "本次付款", prop: "applyAmount" }, { default: t(() => {
      var o, f, c, C, M, N;
      return [e(Y, { modelValue: n(l).applyAmount, "onUpdate:modelValue": a[3] || (a[3] = (Z) => n(l).applyAmount = Z), max: (f = (o = m.detailInfo) == null ? void 0 : o.sourceRow) != null && f.settlementAmount ? ((C = (c = m.detailInfo) == null ? void 0 : c.sourceRow) == null ? void 0 : C.settlementAmount) - ((N = (M = m.detailInfo) == null ? void 0 : M.sourceRow) == null ? void 0 : N.paymentAmount) : 9999999999, min: -9999999999, precision: n(_e).YUAN, step: 1e4, "controls-position": "right", placeholder: "本次付款", style: { width: "280px" } }, null, 8, ["modelValue", "max", "precision"])];
    }), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款事由", prop: "paymentReasonId" }, { default: t(() => [e(E, { modelValue: n(l).paymentReasonId, "onUpdate:modelValue": a[4] || (a[4] = (o) => n(l).paymentReasonId = o), options: n(z).payment_reason, clearable: "", placeholder: "付款事由", style: { width: "280px" }, type: "dict" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "大写" }, { default: t(() => [p("span", we, y(n(l).applyAmount ? n(be)(n(l).applyAmount) : ""), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款单位" }, { default: t(() => [p("span", null, y(m.detailInfo.branchCompanyName), 1)]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款方式", prop: "paymentMethod" }, { default: t(() => [e(E, { modelValue: n(l).paymentMethod, "onUpdate:modelValue": a[5] || (a[5] = (o) => n(l).paymentMethod = o), options: n(ke).ENUM, placeholder: "付款方式", style: { width: "280px" }, type: "enum", onChange: L }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "备注", prop: "remark" }, { default: t(() => [e(w, { modelValue: n(l).remark, "onUpdate:modelValue": a[6] || (a[6] = (o) => n(l).remark = o), autosize: { minRows: 2, maxRows: 4 }, maxlength: "200", placeholder: "请输入备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款行", prop: "paymentBank" }, { default: t(() => [e(J, { modelValue: n(l).paymentBank, "onUpdate:modelValue": a[7] || (a[7] = (o) => n(l).paymentBank = o), disabled: n(l).paymentMethod === n(F).CASH.V, clearable: "", placeholder: "付款行", style: { width: "280px" }, onChange: P }, { default: t(() => [(b(true), B(S, null, T(m.detailInfo.bankList, (o) => (b(), I(G, { key: o.account, label: o.depositBank, value: o.depositBank }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: t(() => [e(s, { span: 12 }, { default: t(() => [e(i, { label: "付款凭证" }, { label: t(() => {
      var o, f;
      return [a[14] || (a[14] = A(" 付款凭证 ")), n(l).id && ((o = n(l).attachments) != null && o.length) && !((f = n(l).files) != null && f.length) ? (b(), I(W, { key: 0, content: "双击可预览附件", effect: "light", placement: "top" }, { default: t(() => a[13] || (a[13] = [p("i", { class: "el-icon-info" }, null, -1)])), _: 1, __: [13] })) : U("", true)];
    }), default: t(() => {
      var o, f;
      return [n(l).id && ((o = n(l).attachments) != null && o.length) && !((f = n(l).files) != null && f.length) ? (b(true), B(S, { key: 0 }, T(n(l).attachments, (c) => (b(), B("div", { key: c.id }, [p("div", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (C) => K(c) }, y(c.name), 41, Ce)]))), 128)) : U("", true), e(n(ve), { ref: "uploadRef", files: n(l).files, "onUpdate:files": a[8] || (a[8] = (c) => n(l).files = c), accept: ".jpg,.png,.pdf,.jpeg", "file-classify": n(ge).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"])];
    }), _: 1 })]), _: 1 }), e(s, { span: 12 }, { default: t(() => [e(i, { label: "账号" }, { default: t(() => [p("span", null, y(n(l).paymentBankAccount), 1)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), g.value ? (b(), I(Ve, { key: 0, id: D.value, isVisible: g.value, showType: "attachment", onClose: a[9] || (a[9] = (o) => g.value = false) }, null, 8, ["id", "isVisible"])) : U("", true)]), _: 1 }, 8, ["modelValue", "onClose"]);
  };
} }, De = re(Ae, [["__scopeId", "data-v-a713f1e7"]]);
export {
  De as default
};
