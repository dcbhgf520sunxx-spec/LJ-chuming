import { ref as C } from "vue";
import { computed as ie } from "vue";
import { watch as ue } from "vue";
import { nextTick as de } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as l } from "vue";
import { createBlock as h } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as k } from "vue";
import { withDirectives as p } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as S } from "vue";
import { unref as o } from "vue";
import { createVNode as s } from "vue";
import { toDisplayString as d } from "vue";
import { createElementVNode as I } from "vue";
import { renderList as W } from "vue";
import { isRef as me } from "vue";
import { ElNotification as G } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElDatePicker as ce } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElCheckbox as ye } from "element-plus";
import { ElInputNumber as ve } from "element-plus";
import { InfoFilled as he } from "@element-plus/icons-vue";
import { ElIcon as Ie } from "element-plus";
import { ElTooltip as ke } from "element-plus";
import { ElForm as be } from "element-plus";
import { vLoading as Te } from "element-plus";
import { s as we, a as pe, c as De } from "../../../../../modules/payment-application-18cdaf45.js";
import { t as ge, u as Ve, bC as Se, c3 as P, p as H, bV as g, ia as F, S as Ae, iy as Ce, i as Be } from "../../../../../shared/runtime.js";
import { _ as Ee } from "../../../../../modules/UploadBtn-b4cfb47a.js";
const xe = { key: 1 }, Ne = { key: 0 }, Oe = { key: 1 }, Re = { key: 0, style: { color: "#82848a" } }, je = { key: 0 }, Pe = { key: 1, style: { color: "#82848a" } }, Fe = { key: 0 }, ze = { key: 1 }, Ue = { key: 2 }, $e = { key: 0 }, Je = { key: 1 }, qe = { key: 2 }, Le = { key: 0 }, Me = ["onDblclick"], We = { key: 0 }, Ge = ["onDblclick"], Ze = { __name: "settle-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 } }, emits: ["success", "update:modelValue"], setup(e, { emit: K }) {
  const { decimalPrecision: b } = ge(), T = C(false), N = K, m = e, { visible: E, handleClose: O } = Ve({ emit: N, props: m }), z = { applyDate: void 0, amount: void 0, notBoolDeduct: void 0, boolDeduct: void 0, attachmentIds: void 0, attachments: [], orderId: void 0, remark: "" }, t = C(JSON.parse(JSON.stringify(z))), V = C(), Q = C(), x = C(false), U = C(), R = ie(() => m.detailInfo.penalty), X = { applyDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], amount: [{ required: true, validator: (v, a, r) => {
    a || r(new Error("请填写申请金额并大于0")), r();
  }, trigger: "blur" }] };
  ue(() => E.value, (v) => {
    v && Y();
  }, { deep: true, immediate: true });
  function $(v) {
    U.value = v.id, x.value = true;
  }
  function Y(v) {
    var a, r, y, D, f;
    V.value && V.value.resetFields(), t.value = JSON.parse(JSON.stringify(z)), m.showType === "edit" && (t.value.applyDate = (a = m.detailInfo.settlementInfo) == null ? void 0 : a.applyDate, t.value.amount = (r = m.detailInfo.settlementInfo) == null ? void 0 : r.amount, t.value.boolDeduct = (y = m.detailInfo.settlementInfo) == null ? void 0 : y.boolDeduct, t.value.attachmentDTOS = (D = m.detailInfo.settlementInfo) == null ? void 0 : D.attachments, t.value.orderId = m.detailInfo.id, t.value.remark = (f = m.detailInfo.settlementInfo) == null ? void 0 : f.remark, t.value.notBoolDeduct = !t.value.boolDeduct), m.showType !== "add" && m.showType !== "edit" && (t.value.notBoolDeduct = m.detailInfo.settleNotBoolDeduct), V.value && de(() => {
      V.value.clearValidate();
    }), Se(V, t);
  }
  async function Z() {
    var v, a;
    T.value = true;
    try {
      if (!await V.value.validate()) return;
      t.value.boolDeduct = Be(t.value.notBoolDeduct) ? !t.value.notBoolDeduct : R.value ? void 0 : false, t.value.orderId = m.detailInfo.id, t.value.attachmentIds = t.value.attachments.length ? t.value.attachments.map((y) => y.id) : (v = m.detailInfo.settlementInfo) != null && v.attachments.length ? (a = m.detailInfo.settlementInfo) == null ? void 0 : a.attachments.map((y) => y.id) : void 0, m.showType === "add" ? await we(t.value) : await pe(t.value), T.value = false, G({ title: "提交成功", type: "success" }), N("success"), O();
    } catch (r) {
      T.value = false, console.log("项目结算失败", r);
    }
  }
  async function J(v) {
    var r, y;
    T.value = true;
    const a = v === P.PASS.V ? "通过" : "驳回";
    try {
      const D = { auditStatus: v, id: (y = (r = m.detailInfo) == null ? void 0 : r.settlementInfo) == null ? void 0 : y.id };
      await De(D), T.value = false, G({ title: "审核" + a, type: "success" }), N("success"), O();
    } catch (D) {
      T.value = false, console.log("项目结算审核失败", D);
    }
  }
  return (v, a) => {
    const r = fe, y = M("common-button"), D = ce, f = re, q = ye, _ = ve, ee = he, te = Ie, ae = ke, le = be, ne = M("common-drawer"), j = Te, A = se("thousand");
    return l(), h(ne, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(O), modelValue: o(E), "onUpdate:modelValue": a[8] || (a[8] = (n) => me(E) ? E.value = n : null), title: "订单结算", "wrapper-closable": false, size: "40%" }, { titleAfter: i(() => [e.showType === "detail" ? (l(), h(r, { key: 0 }, { default: i(() => a[9] || (a[9] = [B(" 已结算 ")])), _: 1, __: [9] })) : k("", true)]), titleRight: i(() => [e.showType === "add" || e.showType === "edit" ? p((l(), h(y, { key: 0, type: "primary", size: "default", onClick: Z }, { default: i(() => a[10] || (a[10] = [B("提交审核")])), _: 1, __: [10] })), [[j, T.value]]) : k("", true), e.showType === "audit" ? (l(), u(S, { key: 1 }, [e.showType === "audit" ? p((l(), h(y, { key: 0, size: "default", type: "info", onClick: a[0] || (a[0] = (n) => J(o(P).REJECT.V)) }, { default: i(() => a[11] || (a[11] = [B("驳回")])), _: 1, __: [11] })), [[j, T.value]]) : k("", true), e.showType === "audit" ? p((l(), h(y, { key: 1, size: "default", type: "success", onClick: a[1] || (a[1] = (n) => J(o(P).PASS.V)) }, { default: i(() => a[12] || (a[12] = [B("通过")])), _: 1, __: [12] })), [[j, T.value]]) : k("", true)], 64)) : k("", true)]), content: i(() => [s(le, { ref_key: "formRef", ref: V, model: t.value, rules: X, size: "default", "label-width": "130px" }, { default: i(() => [s(f, { label: "申请日期", prop: "applyDate" }, { default: i(() => {
      var n, c;
      return [e.showType === "add" || e.showType === "edit" ? (l(), h(D, { key: 0, modelValue: t.value.applyDate, "onUpdate:modelValue": a[2] || (a[2] = (w) => t.value.applyDate = w), type: "date", "value-format": "x", placeholder: "选择申请日期", disabledDate: (w) => w.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "220px" } }, null, 8, ["modelValue", "disabledDate"])) : (l(), u("span", xe, d((n = e.detailInfo) != null && n.lastPaymentTime ? o(H)((c = e.detailInfo) == null ? void 0 : c.lastPaymentTime, "{y}-{m}-{d}") : "-"), 1))];
    }), _: 1 }), s(f, { label: "所属项目" }, { default: i(() => [I("span", null, d(e.detailInfo.serialNumber), 1)]), _: 1 }), s(f, { label: "分包单位" }, { default: i(() => [I("span", null, d(e.detailInfo.supplierName), 1)]), _: 1 }), s(f, { label: "合同额" }, { default: i(() => [p(I("span", null, null, 512), [[A, e.detailInfo.amount]])]), _: 1 }), s(f, { label: "已付款" }, { default: i(() => [p(I("span", null, null, 512), [[A, e.detailInfo.paymentAmount]]), I("span", null, "（" + d(e.detailInfo.paymentRate) + "%）", 1)]), _: 1 }), s(f, { label: "最近一次付款" }, { default: i(() => {
      var n, c;
      return [p(I("span", null, null, 512), [[A, (n = e.detailInfo) == null ? void 0 : n.lastPaymentAmount]]), (c = e.detailInfo) != null && c.lastPaymentTime ? (l(), h(r, { key: 0, style: { "margin-left": "5px" } }, { default: i(() => {
        var w;
        return [B(d(o(H)((w = e.detailInfo) == null ? void 0 : w.lastPaymentTime, "{y}-{m}-{d}")), 1)];
      }), _: 1 })) : k("", true)];
    }), _: 1 }), s(f, { label: "签证额" }, { default: i(() => [p(I("span", null, null, 512), [[A, e.detailInfo.visaAmount]])]), _: 1 }), s(f, { label: "已收票" }, { default: i(() => [p(I("span", null, null, 512), [[A, e.detailInfo.invoiceAmount]]), I("span", null, "（" + d(e.detailInfo.invoiceRate) + "%）", 1)]), _: 1 }), s(f, { label: "项目违法处罚" }, { default: i(() => [p(I("span", null, null, 512), [[A, R.value]]), e.showType === "add" || e.showType === "edit" ? (l(), h(q, { key: 0, modelValue: t.value.notBoolDeduct, "onUpdate:modelValue": a[3] || (a[3] = (n) => t.value.notBoolDeduct = n), label: "不扣除", size: "default", style: { "margin-left": "30px", "vertical-align": "middle" }, disabled: !R.value }, null, 8, ["modelValue", "disabled"])) : (l(), h(q, { key: 1, modelValue: t.value.notBoolDeduct, "onUpdate:modelValue": a[4] || (a[4] = (n) => t.value.notBoolDeduct = n), label: "不扣除", size: "default", style: { "margin-left": "30px", "vertical-align": "middle" }, disabled: "" }, null, 8, ["modelValue"]))]), _: 1 }), s(f, { label: "最终结算额", prop: "amount" }, { default: i(() => {
      var n, c, w, L;
      return [e.showType === "add" || e.showType === "edit" ? (l(), h(_, { key: 0, modelValue: t.value.amount, "onUpdate:modelValue": a[5] || (a[5] = (oe) => t.value.amount = oe), step: 1, min: (c = (n = e.detailInfo) == null ? void 0 : n.sourceRow) != null && c.paymentAmount ? (L = (w = e.detailInfo) == null ? void 0 : w.sourceRow) == null ? void 0 : L.paymentAmount : 0, max: 999999999999, precision: o(b).project, placeholder: "最终结算额", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "min", "precision"])) : (l(), u(S, { key: 1 }, [e.showType === "audit" ? (l(), u("span", Ne, d(e.detailInfo.unCheckSettlementAmount ? o(g)(e.detailInfo.unCheckSettlementAmount, o(b).project) : "-"), 1)) : (l(), u("span", Oe, d(e.detailInfo.settlementAmount ? o(g)(e.detailInfo.settlementAmount, o(b).project) : "-"), 1))], 64))];
    }), _: 1 }), s(f, { label: "大写" }, { default: i(() => [e.showType === "add" || e.showType === "edit" ? (l(), u("span", Re, d(t.value.amount ? o(F)(t.value.amount) : ""), 1)) : (l(), u(S, { key: 1 }, [e.showType === "audit" ? (l(), u("span", je, d(e.detailInfo.unCheckSettlementAmount ? o(F)(e.detailInfo.unCheckSettlementAmount) : "-"), 1)) : (l(), u("span", Pe, d(e.detailInfo.settlementAmount ? o(F)(e.detailInfo.settlementAmount) : ""), 1))], 64))]), _: 1 }), s(f, { label: "应付金额" }, { default: i(() => {
      var n, c;
      return [e.showType === "audit" ? (l(), u("span", Fe, d(o(g)(e.detailInfo.unCheckSettlementAmount - e.detailInfo.paymentAmount, o(b).project)), 1)) : e.showType === "add" || e.showType === "edit" ? (l(), u("span", ze, d(t.value.amount ? o(g)(t.value.amount - ((c = (n = e.detailInfo) == null ? void 0 : n.sourceRow) == null ? void 0 : c.paymentAmount), o(b).project) : ""), 1)) : (l(), u("span", Ue, d(o(g)(e.detailInfo.settlementAmount - e.detailInfo.paymentAmount, o(b).project)), 1))];
    }), _: 1 }), s(f, { label: "应补发票" }, { default: i(() => {
      var n, c;
      return [e.showType === "audit" ? (l(), u("span", $e, d(o(g)(e.detailInfo.unCheckSettlementAmount - e.detailInfo.invoiceAmount, o(b).project)), 1)) : e.showType === "add" || e.showType === "edit" ? (l(), u("span", Je, d(t.value.amount ? o(g)(t.value.amount - ((c = (n = e.detailInfo) == null ? void 0 : n.sourceRow) == null ? void 0 : c.invoiceAmount), o(b).project) : ""), 1)) : (l(), u("span", qe, d(o(g)(e.detailInfo.settlementAmount - e.detailInfo.invoiceAmount, o(b).project)), 1))];
    }), _: 1 }), s(f, { label: "附件" }, { label: i(() => [a[13] || (a[13] = B(" 附件 ")), e.detailInfo.attachmentDTOS && e.detailInfo.attachmentDTOS.length > 0 ? (l(), h(ae, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: i(() => [s(te, null, { default: i(() => [s(ee)]), _: 1 })]), _: 1 })) : k("", true)]), default: i(() => [e.showType === "add" || e.showType === "edit" ? (l(), u(S, { key: 0 }, [s(o(Ee), { ref_key: "uploadRef", ref: Q, files: t.value.attachments, "onUpdate:files": a[6] || (a[6] = (n) => t.value.attachments = n), "file-classify": o(Ae).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"]), t.value.attachmentDTOS && t.value.attachmentDTOS.length > 0 && !t.value.attachments.length ? (l(), u("div", Le, [(l(true), u(S, null, W(t.value.attachmentDTOS, (n) => (l(), u("div", { key: n.id }, [I("div", { style: { cursor: "pointer" }, onDblclick: (c) => $(n) }, d(n.name), 41, Me)]))), 128))])) : k("", true)], 64)) : (l(), u(S, { key: 1 }, [e.detailInfo.attachmentDTOS && e.detailInfo.attachmentDTOS.length > 0 ? (l(), u("div", We, [(l(true), u(S, null, W(e.detailInfo.attachmentDTOS, (n) => (l(), u("div", { key: n.id }, [I("div", { style: { cursor: "pointer" }, onDblclick: (c) => $(n) }, d(n.name), 41, Ge)]))), 128))])) : k("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["model"]), x.value ? (l(), h(Ce, { key: 0, isVisible: x.value, showType: "attachment", id: U.value, onClose: a[7] || (a[7] = (n) => x.value = false) }, null, 8, ["isVisible", "id"])) : k("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  Ze as default
};
