import { inject as v } from "vue";
import { ref as _ } from "vue";
import { watch as E } from "vue";
import { reactive as I } from "vue";
import { onMounted as z } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as r } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as F } from "vue";
import { Fragment as R } from "vue";
import { ElCol as T } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElRow as A } from "element-plus";
import { ElForm as U } from "element-plus";
import { ElInput as H } from "element-plus";
import { _ as L, j8 as M, ec as P, dp as $, p as q, i as G, z as J, bV as K, R as O } from "../../../../../../shared/runtime.js";
import Q from "../../../components/approval-status.vue.js";
const W = { class: "settle-container" }, X = { style: { "margin-top": "10px" } }, Y = { key: 0, class: "remark-container box-container", style: { "margin-top": "10px" } }, Z = { __name: "index", emits: ["component-mounted"], setup(h, { expose: w, emit: N }) {
  const g = v("tableItemData"), f = _(false), k = v("size");
  k.value = "45%", E(() => g, async (p) => {
    p.id && await B(p.id);
  }, { deep: true, immediate: true });
  async function B(p) {
    let t = await M({ auditId: p });
    t.passButton && c("updateBtn", t.passButton), t = P([t]), s.value = t[0], f.value = t[0].passButton;
  }
  const d = I({ remark: void 0 }), D = _(null), V = {}, s = _({}), c = N;
  return z(() => {
    c("component-mounted", true);
  }), w({ formData: d }), (p, t) => {
    const l = T, b = S, o = A, j = U, C = H;
    return x(), y(R, null, [n("div", W, [e($, { "header-title": "基本信息" }), e(j, { ref_key: "formRef", ref: D, model: d, rules: V, class: "form-container", "label-position": "left" }, { default: a(() => [e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[2] || (t[2] = [n("span", { class: "label" }, "报销日期", -1)])), _: 1, __: [2] }), e(l, { span: 20 }, { default: a(() => [e(b, null, { default: a(() => [u(r(s.value.reimbursementDate ? m(q)(s.value.reimbursementDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[3] || (t[3] = [n("span", { class: "label" }, "费用归属", -1)])), _: 1, __: [3] }), e(l, { span: 20 }, { default: a(() => [e(b, { prop: "branchCompany" }, { default: a(() => [u(r(s.value.branchCompanyName), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[4] || (t[4] = [n("span", { class: "label" }, "费用类型", -1)])), _: 1, __: [4] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.expenseTypeName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[5] || (t[5] = [n("span", { class: "label" }, "项目", -1)])), _: 1, __: [5] }), e(l, { span: 20 }, { default: a(() => [u(r(m(G)(s.value.project) ? m(J)(s.value.project) : "-"), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[6] || (t[6] = [n("span", { class: "label" }, "部门", -1)])), _: 1, __: [6] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.deptName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[7] || (t[7] = [n("span", { class: "label" }, "报销金额", -1)])), _: 1, __: [7] }), e(l, { span: 20 }, { default: a(() => [u(r(m(K)(s.value.reimbursementAmount)), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[8] || (t[8] = [n("span", { class: "label" }, "报销人", -1)])), _: 1, __: [8] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.reimburserName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[9] || (t[9] = [n("span", { class: "label" }, "报销凭证号", -1)])), _: 1, __: [9] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.reimbursementVoucherNumber), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[10] || (t[10] = [n("span", { class: "label" }, "填报人", -1)])), _: 1, __: [10] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.writtenByName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[11] || (t[11] = [n("span", { class: "label" }, "备注", -1)])), _: 1, __: [11] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.remark), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), n("div", X, [e(O, { files: s.value.attachments, "onUpdate:files": t[0] || (t[0] = (i) => s.value.attachments = i), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), f.value ? (x(), y("div", Y, [e(C, { modelValue: d.remark, "onUpdate:modelValue": t[1] || (t[1] = (i) => d.remark = i), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : F("", true)]), e(Q, { style: { "margin-top": "10px" } })], 64);
  };
} }, le = L(Z, [["__scopeId", "data-v-6881e4a9"]]);
export {
  le as default
};
