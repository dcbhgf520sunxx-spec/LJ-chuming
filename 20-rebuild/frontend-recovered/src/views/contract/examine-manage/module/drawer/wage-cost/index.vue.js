import { inject as b } from "vue";
import { ref as m } from "vue";
import { watch as T } from "vue";
import { reactive as j } from "vue";
import { onMounted as z } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as r } from "vue";
import { unref as _ } from "vue";
import { createCommentVNode as F } from "vue";
import { Fragment as R } from "vue";
import { ElCol as S } from "element-plus";
import { ElFormItem as W } from "element-plus";
import { ElRow as A } from "element-plus";
import { ElForm as H } from "element-plus";
import { ElInput as M } from "element-plus";
import { _ as P, jd as Q, ec as U, dp as $, p as q, bV as i } from "../../../../../../shared/runtime.js";
import G from "../../../components/approval-status.vue.js";
const J = { class: "settle-container" }, K = { key: 0, class: "remark-container box-container", style: { "margin-top": "10px" } }, L = { __name: "index", emits: ["component-mounted"], setup(O, { expose: g, emit: w }) {
  const D = b("tableItemData"), f = m(false), k = b("size");
  k.value = "45%", T(() => D, async (p) => {
    p.id && await B(p.id);
  }, { deep: true, immediate: true });
  async function B(p) {
    let t = await Q({ auditId: p });
    t.passButton && c("updateBtn", t.passButton), t = U([t]), s.value = t[0], f.value = t[0].passButton;
  }
  const d = j({ remark: void 0 }), I = m(null), C = {}, s = m({}), c = w;
  return z(() => {
    c("component-mounted", true);
  }), g({ formData: d }), (p, t) => {
    const l = S, v = W, o = A, N = H, V = M;
    return x(), y(R, null, [n("div", J, [e($, { "header-title": "基本信息" }), e(N, { ref_key: "formRef", ref: I, model: d, rules: C, class: "form-container", "label-position": "left" }, { default: a(() => [e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[1] || (t[1] = [n("span", { class: "label" }, "日期", -1)])), _: 1, __: [1] }), e(l, { span: 20 }, { default: a(() => [e(v, null, { default: a(() => [u(r(s.value.fillInDate ? _(q)(s.value.fillInDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[2] || (t[2] = [n("span", { class: "label" }, "费用归属", -1)])), _: 1, __: [2] }), e(l, { span: 20 }, { default: a(() => [e(v, { prop: "branchCompany" }, { default: a(() => [u(r(s.value.branchCompanyName), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[3] || (t[3] = [n("span", { class: "label" }, "费用类型", -1)])), _: 1, __: [3] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.expenseTypeName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[4] || (t[4] = [n("span", { class: "label" }, "创建人", -1)])), _: 1, __: [4] }), e(l, { span: 20 }, { default: a(() => [u(r(s.value.founderName), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[5] || (t[5] = [n("span", { class: "label" }, "工资总额", -1)])), _: 1, __: [5] }), e(l, { span: 20 }, { default: a(() => [u(r(_(i)(s.value.totalWage)), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[6] || (t[6] = [n("span", { class: "label" }, "员工数量", -1)])), _: 1, __: [6] }), e(l, { span: 20 }, { default: a(() => [u(r(_(i)(s.value.employeeQuantity, 0)), 1)]), _: 1 })]), _: 1 }), e(o, null, { default: a(() => [e(l, { span: 4 }, { default: a(() => t[7] || (t[7] = [n("span", { class: "label" }, "平均工资", -1)])), _: 1, __: [7] }), e(l, { span: 20 }, { default: a(() => [u(r(_(i)(s.value.averageWage)), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), f.value ? (x(), y("div", K, [e(V, { modelValue: d.remark, "onUpdate:modelValue": t[0] || (t[0] = (E) => d.remark = E), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : F("", true)]), e(G, { style: { "margin-top": "10px" } })], 64);
  };
} }, h = P(L, [["__scopeId", "data-v-287e695f"]]);
export {
  h as default
};
