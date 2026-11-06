import { inject as m } from "vue";
import { ref as f } from "vue";
import { reactive as T } from "vue";
import { watch as h } from "vue";
import { computed as b } from "vue";
import { watchEffect as F } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as l } from "vue";
import { withCtx as c } from "vue";
import { unref as v } from "vue";
import { toDisplayString as p } from "vue";
import { createBlock as A } from "vue";
import { createElementVNode as j } from "vue";
import { createCommentVNode as g } from "vue";
import { withDirectives as U } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElTable as K } from "element-plus";
import { ElForm as M } from "element-plus";
import { _ as $, ec as G, iK as H, j3 as J, e7 as L } from "../../../../../../../shared/runtime.js";
import { u as Q } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const W = { class: "second-container" }, X = { key: 0 }, Y = { key: 1 }, Z = { key: 0 }, O = { key: 1 }, ee = { key: 0 }, ae = { key: 1 }, te = { __name: "second-table", setup(le) {
  const { purchaseInfo: u } = m("purchaseInfo"), D = m("purchaseForm"), _ = m("purChaseSelfData"), P = m("tableItemData"), k = f(null), w = f(), y = T({});
  h(() => w.value, (a) => {
    y.actuallyPiad = a;
  });
  const i = b(() => _.value.some((a) => a.isStatus));
  F(() => {
    var a;
    u && ((a = u.supplierAuditSelfEmployedDto) == null ? void 0 : a.list.length) > 0 && (i != null && i.value || u.supplierAuditSelfEmployedDto.list.forEach((o) => {
      o.actuallyPiad = o.paymentAmount;
    }), _.value = G(u.supplierAuditSelfEmployedDto.list));
  });
  const { getSummaries: S, applyAmount: B } = Q(true, { defineData: ["contractAmount", "paymentAmountSum", "invoiceAmountSum", "paymentAmount", "actualAmountPaid", "actuallyPiad"] });
  h(B, (a) => {
    D.actuallyPayAmount = a;
  }, { immediate: true });
  const E = (a, o, t, r) => {
    o[t] = H(a, { decimalPlaces: 2, allowNegative: true });
  }, I = (a, o, t, r) => {
    J(a, o, t, L(r), "本次实付不得大于申请付款,请重新输入");
  }, V = b(() => u.boolFinalApprover && u.passButton && P.approvalFlag);
  return (a, o) => {
    const t = q, r = z, x = K, C = M, N = R("empty-bgc");
    return n(), s("div", W, [l(C, { ref_key: "formRef", ref: k, model: y }, { default: c(() => [l(x, { data: v(_), "summary-method": v(S), border: "", "row-key": "id", "show-summary": "", size: "default", stripe: "" }, { default: c(() => [l(t, { align: "center", label: "序号", type: "index", width: "60" }), l(t, { align: "center", label: "合同编号", "min-width": "180", prop: "purchaseContractNumber" }), l(t, { align: "center", label: "采购单位", "min-width": "180", prop: "contractSignBodyName" }), l(t, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }), l(t, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: c(({ row: { paymentAmountSum: e } }) => [e ? (n(), s("span", X, p(e), 1)) : (n(), s("span", Y, "-"))]), _: 1 }), l(t, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: c(({ row: { invoiceAmountSum: e } }) => [e ? (n(), s("span", Z, p(e), 1)) : (n(), s("span", O, "-"))]), _: 1 }), l(t, { align: "center", label: "本次申请付款", "min-width": "120", prop: "paymentAmount" }, { default: c(({ row: e }) => [e.paymentAmount ? (n(), s("span", ee, p(e.paymentAmount), 1)) : (n(), s("span", ae, "-"))]), _: 1 }), i.value ? (n(), A(t, { key: 0, align: "center", label: "本次实付", "min-width": "150", prop: "actualAmountPaid" }, { default: c(({ row: e }) => [j("span", null, p(e.actualAmountPaid), 1)]), _: 1 })) : g("", true), i.value ? g("", true) : (n(), A(t, { key: 1, align: "center", label: "本次实付", prop: "actuallyPiad", width: "150" }, { default: c(({ row: e }) => [U(l(r, { modelValue: e.actuallyPiad, "onUpdate:modelValue": (d) => e.actuallyPiad = d, disabled: !V.value, clearable: "", placeholder: "录入金额", onBlur: (d) => I(e.actuallyPiad, e, "actuallyPiad", e.paymentAmount), onInput: (d) => {
      E(d, e, "actuallyPiad", e.paymentAmount);
    } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur", "onInput"]), [[N]])]), _: 1 }))]), _: 1 }, 8, ["data", "summary-method"])]), _: 1 }, 8, ["model"])]);
  };
} }, ce = $(te, [["__scopeId", "data-v-863ddfb2"]]);
export {
  ce as default
};
