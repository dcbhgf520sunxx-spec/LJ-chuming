import { ref as v } from "vue";
import { watch as X } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as s } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as b } from "vue";
import { unref as l } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as y } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as Z } from "vue";
import { Fragment as E } from "vue";
import { renderList as ee } from "vue";
import { isRef as te } from "vue";
import { ElMessage as P } from "element-plus";
import { ElNotification as ae } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElDescriptions as ue } from "element-plus";
import { _ as se, t as ce, g8 as ie, u as de, c3 as w, p as U, z as re, bV as V, ia as me, i as ye, iv as z, iy as be } from "../../../../../../../shared/runtime.js";
import { p as fe } from "../../../../../../../modules/pay-9ccccafb.js";
import { e as pe } from "../../../../../../../modules/payment-application-18cdaf45.js";
import { d as ve } from "../../../../../../../modules/collection-9275714a.js";
const ke = { class: "dialog-title" }, we = { style: { position: "absolute", right: "20px" } }, he = { class: "project-name" }, Ae = { key: 0, style: { "margin-left": "5px" } }, ge = { key: 0, style: { "margin-left": "5px" } }, Ve = { key: 1 }, Re = { key: 1 }, Le = { key: 1 }, Se = ["onDblclick"], Te = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, branchCompanyId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: j }) {
  const { decimalPrecision: h } = ce(), x = t, R = ie(["payment_reason"]), _ = v([]), $ = { key: "account", label: "depositBank", value: "account" }, p = v(), A = v(), L = v(), g = v(), a = v({}), S = v(false), D = v(), N = j, { visible: T, handleClose: C } = de({ emit: N, props: x });
  X(() => T.value, (d) => {
    d && (a.value = {}, p.value = void 0, L.value = void 0, A.value = void 0, g.value = void 0, J(x.detailInfo.id), q(x.branchCompanyId));
  }, { deep: true, immediate: true });
  async function J(d) {
    try {
      const e = await fe(d);
      a.value = e || {}, p.value = a.value.applyAmount || 0;
    } catch (e) {
      console.log("获取付款详情", e);
    }
  }
  async function q(d) {
    try {
      const { content: e } = await ve(d);
      _.value = e;
    } catch (e) {
      console.log("获取银行账号", e);
    }
  }
  function O(d) {
    D.value = d.id, S.value = true;
  }
  function G(d) {
    if (d) {
      const e = _.value.find((k) => k.account === d);
      L.value = e.depositBank;
    } else L.value = void 0;
  }
  async function F(d) {
    if (d === w.PASS.V) {
      if (!p.value) {
        P.error("本次实付必填且大于0");
        return;
      }
      if (!g.value) {
        P.error("付款方式必填");
        return;
      }
      if (!A.value) {
        P.error("付款银行必填");
        return;
      }
    }
    try {
      const e = { auditStatus: d, actuallyPaymentAmount: p.value, id: a.value.id, paymentBank: L.value, paymentBankAccount: A.value, paymentMethod: g.value };
      await pe(e), ae({ title: "提交成功", type: "success" }), N("success"), C();
    } catch (e) {
      console.log("审核", e);
    }
  }
  return (d, e) => {
    const k = le, I = B("common-button"), c = ne, H = oe, M = B("common-select"), K = ue, Q = B("common-dialog"), W = Y("show-thousand");
    return s(), m(Q, { "append-to-body": "", modelValue: l(T), "onUpdate:modelValue": e[6] || (e[6] = (r) => te(T) ? T.value = r : null), top: "10vh", width: "60%", "before-close": l(C), title: "审核详情", center: false, "close-on-click-modal": false }, { title: n(() => [b("div", ke, [e[10] || (e[10] = b("span", { class: "title-left" }, "审核详情", -1)), t.detailInfo.auditStatus ? (s(), m(k, { key: 0, size: "large", type: t.detailInfo.auditStatus == l(w).REJECT.V ? "info" : t.detailInfo.auditStatus == l(w).PASS.V ? "success" : "warning" }, { default: n(() => [i(o(t.detailInfo.auditStatus == l(w).REJECT.V ? "已驳回" : t.detailInfo.auditStatus == l(w).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : y("", true), b("span", we, [t.showType === "audit" ? (s(), m(I, { key: 0, size: "default", type: "info", onClick: e[0] || (e[0] = (r) => F(l(w).REJECT.V)) }, { default: n(() => e[7] || (e[7] = [i("驳回")])), _: 1, __: [7] })) : y("", true), t.showType === "audit" ? (s(), m(I, { key: 1, size: "default", type: "success", onClick: e[1] || (e[1] = (r) => F(l(w).PASS.V)) }, { default: n(() => e[8] || (e[8] = [i("通过")])), _: 1, __: [8] })) : y("", true), u(I, { size: "default", onClick: l(C) }, { default: n(() => e[9] || (e[9] = [i("关闭")])), _: 1, __: [9] }, 8, ["onClick"])])])]), default: n(() => [u(K, { class: "margin-top", column: 2, border: "" }, { default: n(() => [u(c, { "label-class-name": "contractLabel", label: "申请人" }, { default: n(() => [i(o(a.value.applyUserName), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "申请日期" }, { default: n(() => [i(o(a.value.createTime ? l(U)(a.value.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "采购合同编号" }, { default: n(() => [i(o(t.currentRow.serialNumber), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "所属项目" }, { default: n(() => [b("span", he, o(l(re)(t.currentRow.project)), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "供应商" }, { default: n(() => [i(o(t.currentRow.supplierName), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "合同额" }, { default: n(() => [i(o(t.currentRow.amount ? l(V)(t.currentRow.amount, l(h).contract) : "-"), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "已付款" }, { default: n(() => [b("span", null, o(t.currentRow.paymentAmount ? l(V)(t.currentRow.paymentAmount, l(h).contract) : "-"), 1), t.currentRow.paymentAmount && t.currentRow.inboundAmount ? (s(), f("span", Ae, o((t.currentRow.paymentAmount / t.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)) : y("", true)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "最近一次付款" }, { default: n(() => [b("span", null, o(t.currentRow.lastPaymentAmount ? l(V)(t.currentRow.lastPaymentAmount, l(h).contract) : "-"), 1), t.currentRow.lastPaymentTime ? (s(), f("span", ge, o(l(U)(t.currentRow.lastPaymentTime, "{y}-{m}-{d}")), 1)) : y("", true)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "本次申请" }, { default: n(() => [u(k, { effect: "plain" }, { default: n(() => [i(o(a.value.applyAmount ? l(V)(a.value.applyAmount, l(h).contract) : "-"), 1)]), _: 1 }), a.value.applyAmount && t.currentRow.inboundAmount ? (s(), m(k, { key: 0, style: { "margin-left": "5px" } }, { default: n(() => [i(o((a.value.applyAmount / t.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "大写" }, { default: n(() => [b("div", null, o(a.value.applyAmount ? "(" + l(me)(a.value.applyAmount) + ")" : "-"), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "付款事由" }, { default: n(() => [i(o(a.value.paymentReasonId && l(R) && l(R).label && l(R).label.payment_reason ? l(R).label.payment_reason[a.value.paymentReasonId] : ""), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "收款单位" }, { default: n(() => [i(o(a.value.receivingUnit), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "收款银行" }, { default: n(() => [i(o(a.value.receiveBank), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "账号" }, { default: n(() => [i(o(a.value.receiveBankAccount), 1)]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "本次实付" }, { default: n(() => [t.showType === "audit" ? Z((s(), m(H, { key: 0, modelValue: p.value, "onUpdate:modelValue": e[2] || (e[2] = (r) => p.value = r), modelModifiers: { number: true }, min: -9999999999, max: t.detailInfo.applyAmount, step: 100, precision: l(h).contract, placeholder: "本次实付(元)", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "max", "precision"])), [[W]]) : (s(), f("span", Ve, o(l(ye)(a.value.actuallyPaymentAmount) ? l(V)(a.value.actuallyPaymentAmount, l(h).contract) : "-"), 1)), t.showType === "audit" ? (s(), f(E, { key: 2 }, [p.value && t.currentRow.inboundAmount ? (s(), m(k, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: n(() => [i(o((p.value / t.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64)) : (s(), f(E, { key: 3 }, [a.value.actuallyPaymentAmount && t.currentRow.inboundAmount ? (s(), m(k, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: n(() => [i(o((a.value.actuallyPaymentAmount / t.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64))]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "付款方式" }, { default: n(() => [t.showType === "audit" ? (s(), m(M, { key: 0, modelValue: g.value, "onUpdate:modelValue": e[3] || (e[3] = (r) => g.value = r), options: l(z).ENUM, type: "enum", size: "default", placeholder: "付款方式", style: { width: "100%" } }, null, 8, ["modelValue", "options"])) : (s(), f("span", Re, o(a.value.paymentMethod ? l(z).VL[a.value.paymentMethod] : "-"), 1))]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "付款银行" }, { default: n(() => [t.showType === "audit" ? (s(), m(M, { key: 0, modelValue: A.value, "onUpdate:modelValue": e[4] || (e[4] = (r) => A.value = r), options: _.value, type: "other", dataStructure: $, size: "default", placeholder: "收款银行", style: { width: "100%" }, onChange: G }, null, 8, ["modelValue", "options"])) : (s(), f("span", Le, o(a.value.paymentBank ? a.value.paymentBank : "-"), 1))]), _: 1 }), u(c, { "label-class-name": "contractLabel", label: "附件" }, { default: n(() => [a.value && a.value.attachments && a.value.attachments.length > 0 ? (s(true), f(E, { key: 0 }, ee(a.value.attachments, (r) => (s(), f("div", { key: r.id }, [b("div", { style: { cursor: "pointer" }, onDblclick: (xe) => O(r) }, o(r.name), 41, Se)]))), 128)) : y("", true)]), _: 1 }), u(c, { "label-class-name": "remark", label: "备注", span: 2 }, { default: n(() => [b("span", null, o(a.value.remark), 1)]), _: 1 })]), _: 1 }), S.value ? (s(), m(be, { key: 0, isVisible: S.value, showType: "attachment", id: D.value, onClose: e[5] || (e[5] = (r) => S.value = false) }, null, 8, ["isVisible", "id"])) : y("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Pe = se(Te, [["__scopeId", "data-v-8c657b89"]]);
export {
  Pe as default
};
