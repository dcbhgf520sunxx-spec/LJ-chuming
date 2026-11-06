import { ref as g } from "vue";
import { computed as C } from "vue";
import { resolveComponent as G } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as d } from "vue";
import { createBlock as b } from "vue";
import { withCtx as l } from "vue";
import { unref as u } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as a } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as f } from "vue";
import { Fragment as H } from "vue";
import { renderList as K } from "vue";
import { isRef as Q } from "vue";
import { ElTag as W } from "element-plus";
import { ElFormItem as X } from "element-plus";
import { ElCheckbox as Y } from "element-plus";
import { InfoFilled as Z } from "@element-plus/icons-vue";
import { ElIcon as ee } from "element-plus";
import { ElTooltip as te } from "element-plus";
import { ElForm as le } from "element-plus";
import { _ as ae, g8 as ne, u as oe, c3 as _, p as N, ia as ue, iy as se } from "../../../../../../shared/runtime.js";
const ce = { key: 0, style: { "margin-left": "5px" } }, de = { style: { color: "#82848a" } }, ie = ["onDblclick"], re = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: z }) {
  const P = z, j = g(), R = ne(["payment_reason"]), p = t, { visible: I, handleClose: F } = oe({ emit: P, props: p }), v = g(false), x = g(), k = C(() => p.currentRow.applyAmount + p.currentRow.breachAmount), A = C(() => !p.currentRow.boolDeduct);
  function U(D) {
    x.value = D.id, v.value = true;
  }
  return (D, i) => {
    const E = W, n = X, $ = Y, J = Z, O = ee, q = te, L = le, M = G("common-drawer"), r = B("thousand"), S = B("empty-text");
    return d(), b(M, { "append-to-body": "", "close-on-click-modal": false, "before-close": u(F), modelValue: u(I), "onUpdate:modelValue": i[2] || (i[2] = (w) => Q(I) ? I.value = w : null), title: "付款申请详情", "wrapper-closable": false, size: "40%" }, { titleAfter: l(() => [t.currentRow.auditStatus ? (d(), b(E, { key: 0, size: "large", type: t.currentRow.auditStatus === u(_).REJECT.V ? "info" : t.currentRow.auditStatus === u(_).PASS.V ? "success" : "warning" }, { default: l(() => [V(c(t.currentRow.auditStatus === u(_).REJECT.V ? "已驳回" : t.currentRow.auditStatus === u(_).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : m("", true)]), content: l(() => [a(L, { ref_key: "formRef", ref: j, size: "default", "label-width": "130px" }, { default: l(() => {
      var w, T;
      return [a(n, { label: "申请日期", prop: "paymentDate" }, { default: l(() => [t.currentRow.paymentDate ? (d(), h("span", ce, c(u(N)(t.currentRow.paymentDate, "{y}-{m}-{d}")), 1)) : m("", true)]), _: 1 }), a(n, { label: "所属项目" }, { default: l(() => {
        var e;
        return [o("span", null, c((e = p.detailInfo) == null ? void 0 : e.project), 1)];
      }), _: 1 }), a(n, { label: "分包公司" }, { default: l(() => {
        var e;
        return [o("span", null, c((e = t.detailInfo) == null ? void 0 : e.supplierName), 1)];
      }), _: 1 }), a(n, { label: "合同额" }, { default: l(() => {
        var e;
        return [f(o("span", null, null, 512), [[r, (e = t.detailInfo) == null ? void 0 : e.amount]])];
      }), _: 1 }), a(n, { label: "已付款" }, { default: l(() => {
        var e, s;
        return [f(o("span", null, null, 512), [[r, (e = t.detailInfo) == null ? void 0 : e.paymentAmount]]), o("span", null, "（" + c((s = t.detailInfo) == null ? void 0 : s.paymentRate) + "%）", 1)];
      }), _: 1 }), a(n, { label: "最近一次付款" }, { default: l(() => {
        var e, s;
        return [f(o("span", null, null, 512), [[r, (e = t.detailInfo) == null ? void 0 : e.lastPaymentAmount], [S]]), (s = t.detailInfo) != null && s.lastPaymentTime ? (d(), b(E, { key: 0, style: { "margin-left": "5px" } }, { default: l(() => {
          var y;
          return [V(c(u(N)((y = t.detailInfo) == null ? void 0 : y.lastPaymentTime, "{y}-{m}-{d}")), 1)];
        }), _: 1 })) : m("", true)];
      }), _: 1 }), (T = (w = t.detailInfo) == null ? void 0 : w.sourceRow) != null && T.settlementAmount ? (d(), b(n, { key: 0, label: "结算额" }, { default: l(() => {
        var e;
        return [f(o("span", null, null, 512), [[r, (e = t.detailInfo) == null ? void 0 : e.settlementAmount]])];
      }), _: 1 })) : m("", true), a(n, { label: "本次项目违法处罚", prop: "notBoolDeduct" }, { default: l(() => [f(o("span", null, null, 512), [[r, t.currentRow.breachAmount], [S]]), a($, { modelValue: A.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => A.value = e), label: "本次不扣除", size: "default", style: { "margin-left": "20px", "vertical-align": "middle" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 }), a(n, { label: "本次付款", prop: "inputAmount" }, { default: l(() => [f(o("span", null, null, 512), [[r, k.value]])]), _: 1 }), a(n, { label: "大写" }, { default: l(() => [o("span", de, c(k.value ? u(ue)(k.value) : ""), 1)]), _: 1 }), a(n, { label: "收款银行" }, { default: l(() => {
        var e;
        return [o("span", null, c((e = t.detailInfo) == null ? void 0 : e.supplier.bankName), 1)];
      }), _: 1 }), a(n, { label: "账号" }, { default: l(() => {
        var e;
        return [o("span", null, c((e = t.detailInfo) == null ? void 0 : e.supplier.bankAccount), 1)];
      }), _: 1 }), a(n, { label: "申请金额" }, { default: l(() => {
        var e;
        return [f(o("span", null, null, 512), [[r, (e = t.currentRow) == null ? void 0 : e.applyAmount]])];
      }), _: 1 }), a(n, { label: "付款事由", prop: "paymentReasonId" }, { default: l(() => [o("div", null, c(t.currentRow.paymentReasonId && u(R) && u(R).label && u(R).label.payment_reason ? u(R).label.payment_reason[t.currentRow.paymentReasonId] : ""), 1)]), _: 1 }), a(n, { label: "附件" }, { label: l(() => {
        var e, s;
        return [i[3] || (i[3] = V(" 附件 ")), (e = t.currentRow.attachments) != null && e.length && !((s = t.currentRow.files) != null && s.length) ? (d(), b(q, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: l(() => [a(O, null, { default: l(() => [a(J)]), _: 1 })]), _: 1 })) : m("", true)];
      }), default: l(() => {
        var e, s;
        return [(e = p.currentRow.attachments) != null && e.length && !((s = t.currentRow.files) != null && s.length) ? (d(true), h(H, { key: 0 }, K(t.currentRow.attachments, (y) => (d(), h("div", { key: y.id }, [o("div", { style: { cursor: "pointer" }, onDblclick: (me) => U(y) }, c(y.name), 41, ie)]))), 128)) : m("", true)];
      }), _: 1 })];
    }), _: 1 }, 512), v.value ? (d(), b(se, { key: 0, isVisible: v.value, showType: "attachment", id: x.value, onClose: i[1] || (i[1] = (w) => v.value = false) }, null, 8, ["isVisible", "id"])) : m("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, ye = ae(re, [["__scopeId", "data-v-ed2811d1"]]);
export {
  ye as default
};
