import { ref as p } from "vue";
import { watch as X } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as f } from "vue";
import { unref as l } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as y } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as x } from "vue";
import { renderList as M } from "vue";
import { withDirectives as ee } from "vue";
import { isRef as te } from "vue";
import { ElMessage as B } from "element-plus";
import { ElNotification as ae } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElDescriptions as ue } from "element-plus";
import { p as se, e as ce } from "../../../../../../../modules/pay-9ccccafb.js";
import { d as ie } from "../../../../../../../modules/collection-9275714a.js";
import { _ as re, t as de, g8 as me, u as ye, c3 as k, p as j, bV as h, D as be, ia as fe, iv as z, iy as ve } from "../../../../../../../shared/runtime.js";
const pe = { class: "dialog-title" }, we = { style: { position: "absolute", right: "20px" } }, ke = { key: 0, style: { "margin-left": "5px" } }, Ae = { key: 0, style: { "margin-left": "5px" } }, he = { key: 1 }, ge = { key: 1 }, Re = { key: 1 }, Ve = ["onDblclick"], Le = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, branchCompanyId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: $ }) {
  const { decimalPrecision: A } = de(), C = e, V = me(["payment_reason"]), I = p([]), J = { key: "account", label: "depositBank", value: "account" }, v = p(), g = p(), L = p(), R = p(), a = p({}), S = p(false), N = p(), F = $, { visible: T, handleClose: P } = ye({ emit: F, props: C });
  X(() => T.value, (d) => {
    d && (a.value = {}, v.value = void 0, L.value = void 0, g.value = void 0, R.value = void 0, q(C.detailInfo.id), O(C.branchCompanyId));
  }, { deep: true, immediate: true });
  async function q(d) {
    try {
      const t = await se(d);
      a.value = t || {}, v.value = a.value.applyAmount || 0;
    } catch (t) {
      console.log("获取付款详情", t);
    }
  }
  async function O(d) {
    try {
      const { content: t } = await ie(d);
      I.value = t;
    } catch (t) {
      console.log("获取银行账号", t);
    }
  }
  function Y(d) {
    N.value = d.id, S.value = true;
  }
  function G(d) {
    if (d) {
      const t = I.value.find((w) => w.account === d);
      L.value = t.depositBank;
    } else L.value = void 0;
  }
  async function U(d) {
    if (d === k.PASS.V) {
      if (!v.value) {
        B.error("本次实付必填且大于0");
        return;
      }
      if (!R.value) {
        B.error("付款方式必填");
        return;
      }
      if (!g.value) {
        B.error("付款银行必填");
        return;
      }
    }
    try {
      const t = { auditStatus: d, actuallyPaymentAmount: v.value, id: a.value.id, paymentBank: L.value, paymentBankAccount: g.value, paymentMethod: R.value };
      await ce(t), ae({ title: "提交成功", type: "success" }), F("success"), P();
    } catch (t) {
      console.log("审核", t);
    }
  }
  return (d, t) => {
    const w = le, D = E("common-button"), c = ne, H = oe, _ = E("common-select"), K = ue, Q = E("common-dialog"), W = Z("show-thousand");
    return u(), m(Q, { "append-to-body": "", modelValue: l(T), "onUpdate:modelValue": t[6] || (t[6] = (i) => te(T) ? T.value = i : null), top: "10vh", width: "60%", "before-close": l(P), title: "审核详情", center: false, "close-on-click-modal": false }, { title: n(() => [f("div", pe, [t[10] || (t[10] = f("span", { class: "title-left" }, "审核详情", -1)), e.detailInfo.auditStatus ? (u(), m(w, { key: 0, size: "large", type: e.detailInfo.auditStatus == l(k).REJECT.V ? "info" : e.detailInfo.auditStatus == l(k).PASS.V ? "success" : "warning" }, { default: n(() => [r(o(e.detailInfo.auditStatus == l(k).REJECT.V ? "已驳回" : e.detailInfo.auditStatus == l(k).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : y("", true), f("span", we, [e.showType === "audit" ? (u(), m(D, { key: 0, size: "default", type: "info", onClick: t[0] || (t[0] = (i) => U(l(k).REJECT.V)) }, { default: n(() => t[7] || (t[7] = [r("驳回")])), _: 1, __: [7] })) : y("", true), e.showType === "audit" ? (u(), m(D, { key: 1, size: "default", type: "success", onClick: t[1] || (t[1] = (i) => U(l(k).PASS.V)) }, { default: n(() => t[8] || (t[8] = [r("通过")])), _: 1, __: [8] })) : y("", true), s(D, { size: "default", onClick: l(P) }, { default: n(() => t[9] || (t[9] = [r("关闭")])), _: 1, __: [9] }, 8, ["onClick"])])])]), default: n(() => [s(K, { class: "margin-top", column: 2, border: "" }, { default: n(() => [s(c, { "label-class-name": "contractLabel", label: "申请人" }, { default: n(() => [r(o(a.value.applyUserName), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "申请日期" }, { default: n(() => [r(o(a.value.createTime ? l(j)(a.value.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "采购合同编号" }, { default: n(() => [r(o(e.currentRow.serialNumber), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "所属项目" }, { default: n(() => [e.currentRow.projects && e.currentRow.projects.length > 0 ? (u(true), b(x, { key: 0 }, M(e.currentRow.projects, (i) => (u(), b("div", { key: i.id }, o(i.serialNumber + " " + i.shortName), 1))), 128)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "供应商" }, { default: n(() => [r(o(e.currentRow.supplierName), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "合同额" }, { default: n(() => [r(o(e.currentRow.amount ? l(h)(e.currentRow.amount, l(A).contract) : "-") + " ", 1), f("span", null, "（入库额:" + o(e.currentRow.inboundAmount ? l(h)(e.currentRow.inboundAmount, l(be).YUAN) : "-") + "）", 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "已付款" }, { default: n(() => [f("span", null, o(e.currentRow.paymentAmount ? l(h)(e.currentRow.paymentAmount, l(A).contract) : "-"), 1), e.currentRow.paymentAmount && e.currentRow.inboundAmount ? (u(), b("span", ke, o((e.currentRow.paymentAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "最近一次付款" }, { default: n(() => [f("span", null, o(e.currentRow.lastPaymentAmount ? l(h)(e.currentRow.lastPaymentAmount, l(A).contract) : "-"), 1), e.currentRow.lastPaymentTime ? (u(), b("span", Ae, o(l(j)(e.currentRow.lastPaymentTime, "{y}-{m}-{d}")), 1)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "本次申请" }, { default: n(() => [s(w, { effect: "plain" }, { default: n(() => [r(o(a.value.applyAmount ? l(h)(a.value.applyAmount, l(A).contract) : "-"), 1)]), _: 1 }), a.value.applyAmount && e.currentRow.inboundAmount ? (u(), m(w, { key: 0, style: { "margin-left": "5px" } }, { default: n(() => [r(o((a.value.applyAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "大写" }, { default: n(() => [f("div", null, o(a.value.applyAmount ? "(" + l(fe)(a.value.applyAmount) + ")" : "-"), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款事由" }, { default: n(() => [r(o(a.value.paymentReasonId && l(V) && l(V).label && l(V).label.payment_reason ? l(V).label.payment_reason[a.value.paymentReasonId] : ""), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "收款单位" }, { default: n(() => [r(o(a.value.receivingUnit), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "收款银行" }, { default: n(() => [r(o(a.value.receiveBank), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "账号" }, { default: n(() => [r(o(a.value.receiveBankAccount), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "本次实付" }, { default: n(() => [e.showType === "audit" ? ee((u(), m(H, { key: 0, modelValue: v.value, "onUpdate:modelValue": t[2] || (t[2] = (i) => v.value = i), modelModifiers: { number: true }, min: 0, max: e.detailInfo.applyAmount, step: 100, precision: l(A).contract, placeholder: "本次实付(元)", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "max", "precision"])), [[W]]) : (u(), b("span", he, o(a.value.actuallyPaymentAmount ? l(h)(a.value.actuallyPaymentAmount, l(A).contract) : "-"), 1)), e.showType === "audit" ? (u(), b(x, { key: 2 }, [v.value && e.currentRow.inboundAmount ? (u(), m(w, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: n(() => [r(o((v.value / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64)) : (u(), b(x, { key: 3 }, [a.value.actuallyPaymentAmount && e.currentRow.inboundAmount ? (u(), m(w, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: n(() => [r(o((a.value.actuallyPaymentAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款方式" }, { default: n(() => [e.showType === "audit" ? (u(), m(_, { key: 0, modelValue: R.value, "onUpdate:modelValue": t[3] || (t[3] = (i) => R.value = i), options: l(z).ENUM, type: "enum", size: "default", placeholder: "付款方式", style: { width: "100%" } }, null, 8, ["modelValue", "options"])) : (u(), b("span", ge, o(a.value.paymentMethod ? l(z).VL[a.value.paymentMethod] : "-"), 1))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款银行" }, { default: n(() => [e.showType === "audit" ? (u(), m(_, { key: 0, modelValue: g.value, "onUpdate:modelValue": t[4] || (t[4] = (i) => g.value = i), options: I.value, type: "other", dataStructure: J, size: "default", placeholder: "收款银行", style: { width: "100%" }, onChange: G }, null, 8, ["modelValue", "options"])) : (u(), b("span", Re, o(a.value.paymentBank ? a.value.paymentBank : "-"), 1))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "附件" }, { default: n(() => [a.value && a.value.attachments && a.value.attachments.length > 0 ? (u(true), b(x, { key: 0 }, M(a.value.attachments, (i) => (u(), b("div", { key: i.id }, [f("div", { style: { cursor: "pointer" }, onDblclick: (Se) => Y(i) }, o(i.name), 41, Ve)]))), 128)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "remark", label: "备注", span: 2 }, { default: n(() => [f("span", null, o(a.value.remark), 1)]), _: 1 })]), _: 1 }), S.value ? (u(), m(ve, { key: 0, isVisible: S.value, showType: "attachment", id: N.value, onClose: t[5] || (t[5] = (i) => S.value = false) }, null, 8, ["isVisible", "id"])) : y("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Pe = re(Le, [["__scopeId", "data-v-9637e15e"]]);
export {
  Pe as default
};
