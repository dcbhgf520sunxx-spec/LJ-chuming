import { ref as A } from "vue";
import Q from "moment";
import { resolveComponent as R } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as c } from "vue";
import { createBlock as b } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as m } from "vue";
import { withDirectives as _ } from "vue";
import { createCommentVNode as I } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as X } from "vue";
import { renderList as Z } from "vue";
import { ElFormItem as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElInputNumber as le } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElInput as ne } from "element-plus";
import { InfoFilled as oe } from "@element-plus/icons-vue";
import { ElIcon as ie } from "element-plus";
import { ElTooltip as se } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as ue, t as me, g8 as re, ao as fe, p as pe, ia as ce, S as ye, iy as _e, i as be } from "../../../../../../shared/runtime.js";
import { _ as Ie } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
const ge = { style: { color: "#82848a" } }, ke = ["onDblclick"], ve = { __name: "form", props: { detailInfo: { type: Object, default: () => {
} } }, setup(n) {
  const { decimalPrecision: N } = me(), D = A(), U = re(["payment_reason"]), g = n, F = { paymentDate: Q().startOf("day").valueOf(), applyAmount: void 0, attachmentIds: void 0, files: [], orderId: void 0, paymentReasonId: void 0, propertyType: void 0, receiveBank: void 0, receiveBankAccount: void 0, remark: "" }, { CRUD: z, crud: u, form: a } = fe(F, D), k = A(false), x = A(), O = { paymentDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], paymentReasonId: [{ required: true, message: "请选择付款事由", trigger: "change" }], applyAmount: [{ required: true, validator: (p, o, v) => {
    be(o) || v(new Error("请填写申请金额")), v();
  }, trigger: "blur" }] };
  function P(p) {
    x.value = p.id, k.value = true;
  }
  return z.HOOK.beforeSubmit = () => {
    u.form.attachmentIds = u.form.files ? u.form.files.map((p) => p.id) : u.form.attachments ? u.form.attachments.map((p) => p.id) : void 0, u.form.orderId = g.detailInfo.id, u.form.propertyType = g.detailInfo.propertyType, u.form.receiveBank = g.detailInfo.supplierBankName || void 0, u.form.receiveBankAccount = g.detailInfo.supplierBankAccount || void 0;
  }, (p, o) => {
    const v = R("common-button"), i = ee, S = te, j = le, q = ae, $ = R("common-select"), M = ne, H = oe, K = ie, L = se, Y = de, G = R("common-drawer"), y = W("thousand");
    return c(), b(G, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(u).cancelCU, visible: e(u).status.cu > 0, title: "付款申请", "wrapper-closable": false, size: "40%" }, { titleRight: t(() => [l(v, { loading: e(u).status.cu === 2, type: "primary", size: "default", onClick: e(u).submitCU }, { default: t(() => o[6] || (o[6] = [V("提交审核")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), content: t(() => [l(Y, { ref_key: "formRef", ref: D, model: e(a), rules: O, size: "default", "label-width": "130px" }, { default: t(() => {
      var h, T;
      return [l(i, { label: "采购合同编号" }, { default: t(() => [d("span", null, m(n.detailInfo.serialNumber), 1)]), _: 1 }), l(i, { label: "供应商" }, { default: t(() => [d("span", null, m(n.detailInfo.supplierName), 1)]), _: 1 }), l(i, { label: "合同额" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.amount]])]), _: 1 }), l(i, { label: "入库额" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.inboundAmount]])]), _: 1 }), (T = (h = n.detailInfo) == null ? void 0 : h.sourceRow) != null && T.settlementAmount ? (c(), b(i, { key: 0, label: "结算额" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.settlementAmount]])]), _: 1 })) : I("", true), l(i, { label: "已付款" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.paymentAmount]]), d("span", null, "（" + m(n.detailInfo.paymentRate) + "%）", 1)]), _: 1 }), l(i, { label: "已收票" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.invoiceAmount]]), d("span", null, "（" + m(n.detailInfo.invoiceRate) + "%）", 1)]), _: 1 }), l(i, { label: "最后一次付款" }, { default: t(() => [_(d("span", null, null, 512), [[y, n.detailInfo.lastPaymentAmount]]), n.detailInfo.lastPaymentTime ? (c(), b(S, { key: 0, style: { "margin-left": "5px" } }, { default: t(() => [V(m(e(pe)(n.detailInfo.lastPaymentTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : I("", true)]), _: 1 }), l(i, { label: "本次付款", prop: "applyAmount" }, { default: t(() => {
        var s, r, f, w, B, C;
        return [l(j, { modelValue: e(a).applyAmount, "onUpdate:modelValue": o[0] || (o[0] = (J) => e(a).applyAmount = J), step: 1e4, min: -9999999999, max: (r = (s = n.detailInfo) == null ? void 0 : s.sourceRow) != null && r.settlementAmount ? ((w = (f = n.detailInfo) == null ? void 0 : f.sourceRow) == null ? void 0 : w.settlementAmount) - ((C = (B = n.detailInfo) == null ? void 0 : B.sourceRow) == null ? void 0 : C.paymentAmount) : 9999999999, precision: e(N).supplyChain, placeholder: "本次付款", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "max", "precision"])];
      }), _: 1 }), l(i, { label: "大写" }, { default: t(() => [d("span", ge, m(e(a).applyAmount ? e(ce)(e(a).applyAmount) : ""), 1)]), _: 1 }), l(i, { label: "申请日期", prop: "paymentDate" }, { default: t(() => [l(q, { modelValue: e(a).paymentDate, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(a).paymentDate = s), type: "date", "value-format": "x", placeholder: "选择申请日期", disabledDate: (s) => s.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "220px" } }, null, 8, ["modelValue", "disabledDate"])]), _: 1 }), l(i, { label: "付款事由", prop: "paymentReasonId" }, { default: t(() => [l($, { modelValue: e(a).paymentReasonId, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(a).paymentReasonId = s), options: e(U).payment_reason, type: "dict", size: "default", clearable: "", placeholder: "付款事由", style: { width: "220px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(i, { label: "收款单位" }, { default: t(() => [d("span", null, m(n.detailInfo.supplierBankName), 1)]), _: 1 }), l(i, { label: "收款银行" }, { default: t(() => [d("span", null, m(n.detailInfo.supplierBankAccount), 1)]), _: 1 }), l(i, { label: "备注", prop: "remark" }, { default: t(() => [l(M, { modelValue: e(a).remark, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(a).remark = s), type: "textarea", style: { width: "100%" }, maxlength: "200", "show-word-limit": "", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入备注" }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "附件" }, { label: t(() => {
        var s, r;
        return [o[7] || (o[7] = V(" 附件 ")), e(a).id && ((s = e(a).attachments) != null && s.length) && !((r = e(a).files) != null && r.length) ? (c(), b(L, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: t(() => [l(K, null, { default: t(() => [l(H)]), _: 1 })]), _: 1 })) : I("", true)];
      }), default: t(() => {
        var s, r;
        return [e(a).id && ((s = e(a).attachments) != null && s.length) && !((r = e(a).files) != null && r.length) ? (c(true), E(X, { key: 0 }, Z(e(a).attachments, (f) => (c(), E("div", { key: f.id }, [d("div", { style: { cursor: "pointer" }, onDblclick: (w) => P(f) }, m(f.name), 41, ke)]))), 128)) : I("", true), l(e(Ie), { ref: "uploadRef", files: e(a).files, "onUpdate:files": o[4] || (o[4] = (f) => e(a).files = f), "file-classify": e(ye).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"])];
      }), _: 1 })];
    }), _: 1 }, 8, ["model"]), k.value ? (c(), b(_e, { key: 0, isVisible: k.value, showType: "attachment", id: x.value, onClose: o[5] || (o[5] = (h) => k.value = false) }, null, 8, ["isVisible", "id"])) : I("", true)]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Ve = ue(ve, [["__scopeId", "data-v-a71b7929"]]);
export {
  Ve as default
};
