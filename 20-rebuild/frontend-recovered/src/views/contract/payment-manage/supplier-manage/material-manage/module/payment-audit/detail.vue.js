import { ref as f } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as v } from "vue";
import { unref as n } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as y } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as S } from "vue";
import { renderList as M } from "vue";
import { withDirectives as te } from "vue";
import { isRef as ae } from "vue";
import { ElMessage as B } from "element-plus";
import { ElNotification as le } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElDescriptionsItem as oe } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElDescriptions as se } from "element-plus";
import { p as ce, e as ie } from "../../../../../../../modules/pay-9ccccafb.js";
import { d as re } from "../../../../../../../modules/collection-9275714a.js";
import { _ as de, t as me, g8 as ye, u as be, iv as p, c3 as A, p as j, bV as h, D as fe, ia as ve, iy as pe } from "../../../../../../../shared/runtime.js";
const we = { class: "dialog-title" }, ke = { style: { position: "absolute", right: "20px" } }, Ae = { key: 0, style: { "margin-left": "5px" } }, Re = { key: 0, style: { "margin-left": "5px" } }, he = { key: 1 }, ge = { key: 1 }, Ve = { key: 1 }, Te = ["onDblclick"], Ce = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, branchCompanyId: { type: [String, Number], default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: z }) {
  const { decimalPrecision: R } = me(), P = e, T = ye(["payment_reason"]), I = f([]), $ = { key: "id", label: "depositBank", value: "id" }, w = f(), g = f(), C = f(), V = f(), a = f({}), E = f(false), _ = f(), F = z, { visible: L, handleClose: N } = be({ emit: F, props: P }), H = f([p.PUBLIC_TRANSFER, p.ACCEPTANCE_DRAFT, p.TRANSFER_CHECK, p.PRIVATE_TRANSFER, p.ALLOT_ACCOUNT, p.GIVE_UP_PROFIT, p.EXCHANGE_ACCOUNT, p.OTHER]);
  Z(() => L.value, (d) => {
    d && (a.value = {}, w.value = void 0, C.value = void 0, g.value = void 0, V.value = void 0, J(P.detailInfo.id), q(P.branchCompanyId));
  }, { deep: true, immediate: true });
  async function J(d) {
    try {
      const t = await ce(d);
      a.value = t || {}, w.value = a.value.applyAmount || 0;
    } catch (t) {
      console.log("获取付款详情", t);
    }
  }
  async function q(d) {
    try {
      const { content: t } = await re(d);
      I.value = t;
    } catch (t) {
      console.log("获取银行账号", t);
    }
  }
  function G(d) {
    _.value = d.id, E.value = true;
  }
  function K(d) {
    if (d) {
      const t = I.value.find((k) => k.id === d);
      C.value = t.depositBank;
    } else C.value = void 0;
  }
  async function U(d) {
    if (d === A.PASS.V) {
      if (!w.value) {
        B.error("本次实付必填");
        return;
      }
      if (!V.value) {
        B.error("付款方式必填");
        return;
      }
      if (!g.value) {
        B.error("付款银行必填");
        return;
      }
    }
    try {
      const t = { auditStatus: d, actuallyPaymentAmount: w.value, id: a.value.id, paymentBank: C.value, paymentBankAccount: g.value, paymentMethod: V.value };
      await ie(t), le({ title: "提交成功", type: "success" }), F("success"), N();
    } catch (t) {
      console.log("审核", t);
    }
  }
  return (d, t) => {
    const k = ne, x = D("common-button"), c = oe, X = ue, O = D("common-select"), Y = se, Q = D("common-dialog"), W = ee("show-thousand");
    return u(), m(Q, { "append-to-body": "", modelValue: n(L), "onUpdate:modelValue": t[6] || (t[6] = (i) => ae(L) ? L.value = i : null), top: "10vh", width: "60%", "before-close": n(N), title: "审核详情", center: false, "close-on-click-modal": false }, { title: l(() => [v("div", we, [t[10] || (t[10] = v("span", { class: "title-left" }, "审核详情", -1)), e.detailInfo.auditStatus ? (u(), m(k, { key: 0, size: "large", type: e.detailInfo.auditStatus == n(A).REJECT.V ? "info" : e.detailInfo.auditStatus == n(A).PASS.V ? "success" : "warning" }, { default: l(() => [r(o(e.detailInfo.auditStatus == n(A).REJECT.V ? "已驳回" : e.detailInfo.auditStatus == n(A).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : y("", true), v("span", ke, [e.showType === "audit" ? (u(), m(x, { key: 0, size: "default", type: "info", onClick: t[0] || (t[0] = (i) => U(n(A).REJECT.V)) }, { default: l(() => t[7] || (t[7] = [r(" 驳回 ")])), _: 1, __: [7] })) : y("", true), e.showType === "audit" ? (u(), m(x, { key: 1, size: "default", type: "success", onClick: t[1] || (t[1] = (i) => U(n(A).PASS.V)) }, { default: l(() => t[8] || (t[8] = [r(" 通过 ")])), _: 1, __: [8] })) : y("", true), s(x, { size: "default", onClick: n(N) }, { default: l(() => t[9] || (t[9] = [r("关闭")])), _: 1, __: [9] }, 8, ["onClick"])])])]), default: l(() => [s(Y, { class: "margin-top", column: 2, border: "" }, { default: l(() => [s(c, { "label-class-name": "contractLabel", label: "申请人" }, { default: l(() => [r(o(a.value.applyUserName), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "申请日期" }, { default: l(() => [r(o(a.value.createTime ? n(j)(a.value.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "采购合同编号" }, { default: l(() => [r(o(e.currentRow.serialNumber), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "所属项目" }, { default: l(() => [e.currentRow.projects && e.currentRow.projects.length > 0 ? (u(true), b(S, { key: 0 }, M(e.currentRow.projects, (i) => (u(), b("div", { key: i.id }, o(i.serialNumber + " " + i.shortName), 1))), 128)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "供应商" }, { default: l(() => [r(o(e.currentRow.supplierName), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "合同额" }, { default: l(() => [r(o(e.currentRow.amount ? n(h)(e.currentRow.amount, n(R).contract) : "-") + " ", 1), v("span", null, "（入库额:" + o(e.currentRow.inboundAmount ? n(h)(e.currentRow.inboundAmount, n(fe).YUAN) : "-") + "）", 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "已付款" }, { default: l(() => [v("span", null, o(e.currentRow.paymentAmount ? n(h)(e.currentRow.paymentAmount, n(R).contract) : "-"), 1), e.currentRow.paymentAmount && e.currentRow.inboundAmount ? (u(), b("span", Ae, o((e.currentRow.paymentAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "最近一次付款" }, { default: l(() => [v("span", null, o(e.currentRow.lastPaymentAmount ? n(h)(e.currentRow.lastPaymentAmount, n(R).contract) : "-"), 1), e.currentRow.lastPaymentTime ? (u(), b("span", Re, o(n(j)(e.currentRow.lastPaymentTime, "{y}-{m}-{d}")), 1)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "本次申请" }, { default: l(() => [s(k, { effect: "plain" }, { default: l(() => [r(o(a.value.applyAmount ? n(h)(a.value.applyAmount, n(R).contract) : "-"), 1)]), _: 1 }), a.value.applyAmount && e.currentRow.inboundAmount ? (u(), m(k, { key: 0, style: { "margin-left": "5px" } }, { default: l(() => [r(o((a.value.applyAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "大写" }, { default: l(() => [v("div", null, o(a.value.applyAmount ? "(" + n(ve)(a.value.applyAmount) + ")" : "-"), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款事由" }, { default: l(() => [r(o(a.value.paymentReasonId && n(T) && n(T).label && n(T).label.payment_reason ? n(T).label.payment_reason[a.value.paymentReasonId] : ""), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "收款单位" }, { default: l(() => [r(o(a.value.receivingUnit), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "收款银行" }, { default: l(() => [r(o(a.value.receiveBank), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "账号" }, { default: l(() => [r(o(a.value.receiveBankAccount), 1)]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "本次实付" }, { default: l(() => [e.showType === "audit" ? te((u(), m(X, { key: 0, modelValue: w.value, "onUpdate:modelValue": t[2] || (t[2] = (i) => w.value = i), modelModifiers: { number: true }, min: -9999999999, max: e.detailInfo.applyAmount, step: 100, precision: n(R).contract, placeholder: "本次实付(元)", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "max", "precision"])), [[W]]) : (u(), b("span", he, o(a.value.actuallyPaymentAmount ? n(h)(a.value.actuallyPaymentAmount, n(R).contract) : "-"), 1)), e.showType === "audit" ? (u(), b(S, { key: 2 }, [w.value && e.currentRow.inboundAmount ? (u(), m(k, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: l(() => [r(o((w.value / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64)) : (u(), b(S, { key: 3 }, [a.value.actuallyPaymentAmount && e.currentRow.inboundAmount ? (u(), m(k, { key: 0, type: "success", style: { "margin-left": "5px" } }, { default: l(() => [r(o((a.value.actuallyPaymentAmount / e.currentRow.inboundAmount * 100).toFixed(2) + "%"), 1)]), _: 1 })) : y("", true)], 64))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款方式" }, { default: l(() => [e.showType === "audit" ? (u(), m(O, { key: 0, modelValue: V.value, "onUpdate:modelValue": t[3] || (t[3] = (i) => V.value = i), options: H.value, type: "enum", size: "default", placeholder: "付款方式", style: { width: "100%" } }, null, 8, ["modelValue", "options"])) : (u(), b("span", ge, o(a.value.paymentMethod ? n(p).VL[a.value.paymentMethod] : "-"), 1))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "付款银行" }, { default: l(() => [e.showType === "audit" ? (u(), m(O, { key: 0, modelValue: g.value, "onUpdate:modelValue": t[4] || (t[4] = (i) => g.value = i), options: I.value, type: "other", dataStructure: $, clearable: "", size: "default", placeholder: "收款银行", style: { width: "100%" }, onChange: K }, null, 8, ["modelValue", "options"])) : (u(), b("span", Ve, o(a.value.paymentBank ? a.value.paymentBank : "-"), 1))]), _: 1 }), s(c, { "label-class-name": "contractLabel", label: "附件" }, { default: l(() => [a.value && a.value.attachments && a.value.attachments.length > 0 ? (u(true), b(S, { key: 0 }, M(a.value.attachments, (i) => (u(), b("div", { key: i.id }, [v("div", { style: { cursor: "pointer" }, onDblclick: (Ee) => G(i) }, o(i.name), 41, Te)]))), 128)) : y("", true)]), _: 1 }), s(c, { "label-class-name": "remark", label: "备注", span: 2 }, { default: l(() => [v("span", null, o(a.value.remark), 1)]), _: 1 })]), _: 1 }), E.value ? (u(), m(pe, { key: 0, isVisible: E.value, showType: "attachment", id: _.value, onClose: t[5] || (t[5] = (i) => E.value = false) }, null, 8, ["isVisible", "id"])) : y("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ne = de(Ce, [["__scopeId", "data-v-e27f92c7"]]);
export {
  Ne as default
};
