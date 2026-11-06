import { inject as x } from "vue";
import { ref as _ } from "vue";
import { watch as E } from "vue";
import { reactive as F } from "vue";
import { onMounted as I } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as e } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as r } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as z } from "vue";
import { Fragment as R } from "vue";
import { ElCol as T } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElRow as h } from "element-plus";
import { ElForm as A } from "element-plus";
import { ElInput as U } from "element-plus";
import { _ as H, jc as L, ec as M, dp as P, p as $, i as q, z as G, bV as J, R as K } from "../../../../../../shared/runtime.js";
import O from "../../../components/approval-status.vue.js";
const Q = { class: "settle-container" }, W = { style: { "margin-top": "10px" } }, X = { key: 0, class: "remark-container box-container", style: { "margin-top": "10px" } }, Y = { __name: "index", emits: ["component-mounted"], setup(Z, { expose: w, emit: g }) {
  const k = x("tableItemData"), f = _(false), D = x("size");
  D.value = "45%", E(() => k, async (u) => {
    u.id && await B(u.id);
  }, { deep: true, immediate: true });
  async function B(u) {
    let a = await L({ auditId: u });
    a.passButton && c("updateBtn", a.passButton), a = M([a]), l.value = a[0], f.value = a[0].passButton;
  }
  const d = F({ remark: void 0 }), N = _(null), V = {}, l = _({}), c = g;
  return I(() => {
    c("component-mounted", true);
  }), w({ formData: d }), (u, a) => {
    const s = T, v = S, o = h, j = A, C = U;
    return y(), b(R, null, [n("div", Q, [e(P, { "header-title": "基本信息" }), e(j, { ref_key: "formRef", ref: N, model: d, rules: V, class: "form-container", "label-position": "left" }, { default: t(() => [e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[2] || (a[2] = [n("span", { class: "label" }, "支付时间", -1)])), _: 1, __: [2] }), e(s, { span: 20 }, { default: t(() => [e(v, null, { default: t(() => [p(r(l.value.payDate ? i($)(l.value.payDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[3] || (a[3] = [n("span", { class: "label" }, "费用归属", -1)])), _: 1, __: [3] }), e(s, { span: 20 }, { default: t(() => [e(v, { prop: "branchCompany" }, { default: t(() => [p(r(l.value.branchCompanyName), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[4] || (a[4] = [n("span", { class: "label" }, "项目", -1)])), _: 1, __: [4] }), e(s, { span: 20 }, { default: t(() => [p(r(i(q)(l.value.project) ? i(G)(l.value.project) : "-"), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[5] || (a[5] = [n("span", { class: "label" }, "检测费类别", -1)])), _: 1, __: [5] }), e(s, { span: 20 }, { default: t(() => [p(r(l.value.testingFeeTypeName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[6] || (a[6] = [n("span", { class: "label" }, "费用(元)", -1)])), _: 1, __: [6] }), e(s, { span: 20 }, { default: t(() => [p(r(i(J)(l.value.feeAmount)), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: t(() => [e(s, { span: 4 }, { default: t(() => a[7] || (a[7] = [n("span", { class: "label" }, "备注", -1)])), _: 1, __: [7] }), e(s, { span: 20 }, { default: t(() => [p(r(l.value.remark), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), n("div", W, [e(K, { files: l.value.attachments, "onUpdate:files": a[0] || (a[0] = (m) => l.value.attachments = m), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), f.value ? (y(), b("div", X, [e(C, { modelValue: d.remark, "onUpdate:modelValue": a[1] || (a[1] = (m) => d.remark = m), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : z("", true)]), e(O, { style: { "margin-top": "10px" } })], 64);
  };
} }, se = H(Y, [["__scopeId", "data-v-c452014a"]]);
export {
  se as default
};
