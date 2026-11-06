import { ref as k } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as c } from "vue";
import { createBlock as b } from "vue";
import { withCtx as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as O } from "vue";
import { renderList as U } from "vue";
import { isRef as q } from "vue";
import { ElTag as L } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { InfoFilled as G } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { ElForm as Q } from "element-plus";
import { _ as W, g8 as X, u as Y, c3 as w, p as _, ia as Z, iy as ee } from "../../../../../../shared/runtime.js";
const te = { style: { color: "#82848a" } }, ae = { key: 0, style: { "margin-left": "5px" } }, le = ["onDblclick"], ne = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: D }) {
  const T = D, x = k(), p = X(["payment_reason"]), V = e, { visible: I, handleClose: C } = Y({ emit: T, props: V }), R = k(false), A = k();
  function B(E) {
    A.value = E.id, R.value = true;
  }
  return (E, d) => {
    const S = L, n = M, N = G, P = H, z = K, F = Q, j = $("common-drawer"), r = J("thousand");
    return c(), b(j, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(C), modelValue: o(I), "onUpdate:modelValue": d[1] || (d[1] = (s) => q(I) ? I.value = s : null), title: "付款申请详情", "wrapper-closable": false, size: "40%" }, { titleAfter: t(() => [e.currentRow.auditStatus ? (c(), b(S, { key: 0, size: "large", type: e.currentRow.auditStatus === o(w).REJECT.V ? "info" : e.currentRow.auditStatus === o(w).PASS.V ? "success" : "warning" }, { default: t(() => [g(u(e.currentRow.auditStatus === o(w).REJECT.V ? "已驳回" : e.currentRow.auditStatus === o(w).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : f("", true)]), content: t(() => [a(F, { ref_key: "formRef", ref: x, size: "default", "label-width": "130px" }, { default: t(() => [a(n, { label: "采购合同编号" }, { default: t(() => [l("span", null, u(e.detailInfo.serialNumber), 1)]), _: 1 }), a(n, { label: "供应商" }, { default: t(() => [l("span", null, u(e.detailInfo.supplierName), 1)]), _: 1 }), a(n, { label: "合同额" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.detailInfo.amount]])]), _: 1 }), a(n, { label: "入库额" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.detailInfo.inboundAmount]])]), _: 1 }), a(n, { label: "已付款" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.detailInfo.paymentAmount]]), l("span", null, "（" + u(e.detailInfo.paymentRate) + "%）", 1)]), _: 1 }), a(n, { label: "已收票" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.detailInfo.invoiceAmount]]), l("span", null, "（" + u(e.detailInfo.invoiceRate) + "%）", 1)]), _: 1 }), a(n, { label: "最后一次付款" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.detailInfo.lastPaymentAmount]]), e.detailInfo.lastPaymentTime ? (c(), b(S, { key: 0, style: { "margin-left": "5px" } }, { default: t(() => [g(u(o(_)(e.detailInfo.lastPaymentTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : f("", true)]), _: 1 }), a(n, { label: "本次付款", prop: "applyAmount" }, { default: t(() => [y(l("span", null, null, 512), [[r, e.currentRow.applyAmount]])]), _: 1 }), a(n, { label: "大写" }, { default: t(() => {
      var s, i, m, v;
      return [l("span", te, u((i = (s = e.currentRow) == null ? void 0 : s.sourceRow) != null && i.applyAmount ? o(Z)((v = (m = e.currentRow) == null ? void 0 : m.sourceRow) == null ? void 0 : v.applyAmount) : ""), 1)];
    }), _: 1 }), a(n, { label: "申请日期", prop: "paymentDate" }, { default: t(() => [e.currentRow.paymentDate ? (c(), h("span", ae, u(o(_)(e.currentRow.paymentDate, "{y}-{m}-{d}")), 1)) : f("", true)]), _: 1 }), a(n, { label: "付款事由", prop: "paymentReasonId" }, { default: t(() => [l("div", null, u(e.currentRow.paymentReasonId && o(p) && o(p).label && o(p).label.payment_reason ? o(p).label.payment_reason[e.currentRow.paymentReasonId] : ""), 1)]), _: 1 }), a(n, { label: "收款单位" }, { default: t(() => [l("span", null, u(e.detailInfo.supplierBankName), 1)]), _: 1 }), a(n, { label: "收款银行" }, { default: t(() => [l("span", null, u(e.detailInfo.supplierBankAccount), 1)]), _: 1 }), a(n, { label: "备注", prop: "remark" }, { default: t(() => [l("span", null, u(e.currentRow.remark), 1)]), _: 1 }), a(n, { label: "附件" }, { label: t(() => {
      var s, i;
      return [d[2] || (d[2] = g(" 附件 ")), (s = e.currentRow.attachments) != null && s.length && !((i = e.currentRow.files) != null && i.length) ? (c(), b(z, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: t(() => [a(P, null, { default: t(() => [a(N)]), _: 1 })]), _: 1 })) : f("", true)];
    }), default: t(() => {
      var s, i;
      return [(s = V.currentRow.attachments) != null && s.length && !((i = e.currentRow.files) != null && i.length) ? (c(true), h(O, { key: 0 }, U(e.currentRow.attachments, (m) => (c(), h("div", { key: m.id }, [l("div", { style: { cursor: "pointer" }, onDblclick: (v) => B(m) }, u(m.name), 41, le)]))), 128)) : f("", true)];
    }), _: 1 })]), _: 1 }, 512), R.value ? (c(), b(ee, { key: 0, isVisible: R.value, showType: "attachment", id: A.value, onClose: d[0] || (d[0] = (s) => R.value = false) }, null, 8, ["isVisible", "id"])) : f("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, se = W(ne, [["__scopeId", "data-v-86fb79db"]]);
export {
  se as default
};
