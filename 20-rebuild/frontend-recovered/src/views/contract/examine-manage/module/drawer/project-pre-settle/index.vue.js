import { inject as w } from "vue";
import { ref as m } from "vue";
import { watch as z } from "vue";
import { reactive as M } from "vue";
import { computed as $ } from "vue";
import { onMounted as H } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { Fragment as A } from "vue";
import { renderList as Q } from "vue";
import { createBlock as R } from "vue";
import { toDisplayString as G } from "vue";
import { unref as V } from "vue";
import { withDirectives as J } from "vue";
import { createCommentVNode as I } from "vue";
import { ElCol as K } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElFormItem as X } from "element-plus";
import { ElOption as Y } from "element-plus";
import { ElSelect as Z } from "element-plus";
import { ElRow as ee } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElForm as ae } from "element-plus";
import { _ as te, j1 as ne, ec as oe, ia as se, dp as ue, R as de, j2 as re, dq as pe, e2 as me, e6 as k } from "../../../../../../shared/runtime.js";
import { p as ie } from "../../../../../../modules/self-healing-6f411a5c.js";
import ce from "../../../components/approval-status.vue.js";
const _e = { class: "settle-container" }, fe = { class: "label" }, ve = { key: 0, style: { "margin-top": "10px" } }, ye = { key: 1, class: "remark-container box-container", style: { "margin-top": "10px" } }, be = { __name: "index", emits: ["component-mounted"], setup(ge, { expose: E, emit: D }) {
  const _ = w("tableItemData"), v = m(false), B = w("size");
  B.value = "45%";
  const y = m([]);
  (async () => {
    try {
      const { content: u } = await re();
      y.value = u;
    } catch (u) {
      console.log(u);
    }
  })(), z(() => _, async (u) => {
    u.id && await P(u.id);
  }, { deep: true, immediate: true });
  async function P(u) {
    let l = await ne.get(`/api/contract/audit/projectLedger/projectDetail?auditId=${u}`);
    l.passButton && j("updateBtn", l.passButton), n.settlementAmount = l.settlementAmount, l.paymentRate = l.paymentRate.toFixed(2), l.invoiceRate = l.invoiceRate.toFixed(2), l.paymentRate += " %", l.invoiceRate += " %", l = oe([l]), s.value = l[0], n.projectId = l[0].project.id, n.attachments = l[0].attachments, v.value = l[0].passButton;
  }
  const n = M({ attachmentId: [] }), h = $(() => n != null && n.settlementAmount ? se(n.settlementAmount) : ""), b = m(null), F = m([]), g = m(false), U = { settlementAmount: [{ required: true, message: "请输入结算额", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, s = m({}), L = async () => {
    b.value.validate().then(async () => {
      try {
        g.value = true;
        const u = pe(n);
        u.projectManagerId = s.value.projectManager.id, await ie(u), me("success", "填报成功"), k(n, { sustainable: ["settlementTime"] }), k(s.value), F.value = [];
      } catch (u) {
        console.log(u);
      } finally {
        g.value = false;
      }
    });
  }, j = D;
  return H(() => {
    j("component-mounted", true);
  }), E({ saveSettle: L, formData: n }), (u, l) => {
    var x;
    const t = K, S = W, f = X, T = Y, C = Z, p = ee, r = le, N = ae, q = O("ellipsis");
    return i(), c(A, null, [d("div", _e, [e(ue, { "header-title": "基本信息" }), e(N, { ref_key: "formRef", ref: b, model: n, rules: U, class: "form-container", "label-position": "left" }, { default: a(() => [e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[5] || (l[5] = [d("span", { class: "prop-span label" }, "结算日期", -1)])), _: 1, __: [5] }), e(t, { span: 8 }, { default: a(() => [e(f, null, { default: a(() => [e(S, { modelValue: s.value.settlementTime, "onUpdate:modelValue": l[0] || (l[0] = (o) => s.value.settlementTime = o), disabled: true, clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(t, { span: 3 }, { default: a(() => l[6] || (l[6] = [d("span", { class: "prop-span label" }, "项目", -1)])), _: 1, __: [6] }), e(t, { span: 9 }, { default: a(() => [e(f, { prop: "projectId" }, { default: a(() => [e(C, { modelValue: n.projectId, "onUpdate:modelValue": l[1] || (l[1] = (o) => n.projectId = o), disabled: "" }, { default: a(() => [(i(true), c(A, null, Q(y.value, (o) => (i(), R(T, { key: o.id, label: o.serialNumber + "-" + o.shortName, value: o.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => [d("span", fe, G(V(_).projectAttribute === 1 ? "销售负责人" : "项目经理"), 1)]), _: 1 }), e(t, { span: 20 }, { default: a(() => {
      var o;
      return [e(r, { "model-value": (o = s.value.projectManager) == null ? void 0 : o.name, placeholder: V(_).projectAttribute === 1 ? "销售负责人" : "项目经理", readonly: "" }, null, 8, ["model-value", "placeholder"])];
    }), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[7] || (l[7] = [d("span", { class: "label" }, "发包单位", -1)])), _: 1, __: [7] }), e(t, { span: 20 }, { default: a(() => {
      var o;
      return [e(r, { "model-value": (o = s.value) == null ? void 0 : o.customerUnit, placeholder: "发包单位", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[8] || (l[8] = [d("span", { class: "label" }, "合同额", -1)])), _: 1, __: [8] }), e(t, { span: 20 }, { default: a(() => [e(r, { "model-value": s.value.contractProjectAmount, placeholder: "合同额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[9] || (l[9] = [d("span", { class: "label" }, "累计收款", -1)])), _: 1, __: [9] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.paymentAmount, placeholder: "累计收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(t, { span: 4 }, { default: a(() => l[10] || (l[10] = [d("span", { class: "label" }, "收款率", -1)])), _: 1, __: [10] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.paymentRate, placeholder: "收款率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[11] || (l[11] = [d("span", { class: "label" }, "累计开票", -1)])), _: 1, __: [11] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.invoiceAmount, placeholder: "累计开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(t, { span: 4 }, { default: a(() => l[12] || (l[12] = [d("span", { class: "label" }, "开票率", -1)])), _: 1, __: [12] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.invoiceRate, placeholder: "开票率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[13] || (l[13] = [d("span", { class: "prop-span label" }, "结算额", -1)])), _: 1, __: [13] }), e(t, { span: 8 }, { default: a(() => [e(f, { prop: "settlementAmount" }, { default: a(() => [e(r, { modelValue: n.settlementAmount, "onUpdate:modelValue": l[2] || (l[2] = (o) => n.settlementAmount = o), clearable: "", disabled: "", placeholder: "请输入金额" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(t, { span: 4 }, { default: a(() => l[14] || (l[14] = [d("span", { class: "label" }, "大写", -1)])), _: 1, __: [14] }), J((i(), R(t, { span: 8 }, { default: a(() => [e(r, { "model-value": h.value, placeholder: "输入结算额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })), [[q]])]), _: 1 }), e(p, null, { default: a(() => [e(t, { span: 4 }, { default: a(() => l[15] || (l[15] = [d("span", { class: "label" }, "应收款", -1)])), _: 1, __: [15] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.remainderPayment, placeholder: "应收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(t, { span: 4 }, { default: a(() => l[16] || (l[16] = [d("span", { class: "label" }, "应开票", -1)])), _: 1, __: [16] }), e(t, { span: 8 }, { default: a(() => [e(r, { "model-value": s.value.remainderInvoice, placeholder: "应开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), (x = n.attachments) != null && x.length ? (i(), c("div", ve, [e(de, { files: n.attachments, "onUpdate:files": l[3] || (l[3] = (o) => n.attachments = o), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", padding: "0" } }, null, 8, ["files"])])) : I("", true), v.value ? (i(), c("div", ye, [e(r, { modelValue: n.remark, "onUpdate:modelValue": l[4] || (l[4] = (o) => n.remark = o), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : I("", true)]), e(ce, { style: { "margin-top": "10px" } })], 64);
  };
} }, Ve = te(be, [["__scopeId", "data-v-71c99bd0"]]);
export {
  Ve as default
};
