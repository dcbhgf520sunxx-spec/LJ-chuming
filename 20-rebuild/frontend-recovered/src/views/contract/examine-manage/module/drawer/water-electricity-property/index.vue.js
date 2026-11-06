import { inject as x } from "vue";
import { ref as v } from "vue";
import { watch as F } from "vue";
import { reactive as N } from "vue";
import { onMounted as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as o } from "vue";
import { unref as n } from "vue";
import { Fragment as C } from "vue";
import { createCommentVNode as c } from "vue";
import { createBlock as L } from "vue";
import { ElCol as P } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElRow as M } from "element-plus";
import { ElForm as A } from "element-plus";
import { ElInput as $ } from "element-plus";
import { _ as U, je as W, ec as h, dp as H, jf as p, p as Y, bV as y } from "../../../../../../shared/runtime.js";
import q from "../../../components/approval-status.vue.js";
const G = { class: "settle-container" }, J = { class: "label" }, K = { class: "label" }, Q = { key: 0, class: "remark-container box-container", style: { "margin-top": "10px" } }, X = { __name: "index", emits: ["component-mounted"], setup(Z, { expose: V, emit: k }) {
  const R = x("tableItemData"), b = v(false), w = x("size");
  w.value = "45%", F(() => R, async (d) => {
    d.id && await D(d.id);
  }, { deep: true, immediate: true });
  async function D(d) {
    let t = await W({ auditId: d });
    t.passButton && E("updateBtn", t.passButton), t = h([t]), l.value = t[0], b.value = t[0].passButton;
  }
  const m = N({ remark: void 0 }), g = v(null), I = {}, l = v({}), E = k;
  return j(() => {
    E("component-mounted", true);
  }), V({ formData: m }), (d, t) => {
    const s = P, T = z, r = M, S = A, B = $;
    return i(), f(C, null, [u("div", G, [e(H, { "header-title": "基本信息" }), e(S, { ref_key: "formRef", ref: g, model: m, rules: I, class: "form-container", "label-position": "left" }, { default: a(() => [e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[1] || (t[1] = [u("span", { class: "label" }, "类型", -1)])), _: 1, __: [1] }), e(s, { span: 20 }, { default: a(() => [e(T, null, { default: a(() => [_(o(n(p).VL[l.value.type]), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[2] || (t[2] = [u("span", { class: "label" }, "月份", -1)])), _: 1, __: [2] }), e(s, { span: 20 }, { default: a(() => [e(T, { prop: "yearMonthDate" }, { default: a(() => [_(o(l.value.yearMonthDate ? n(Y)(l.value.yearMonthDate, "{y}-{m}") : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[3] || (t[3] = [u("span", { class: "label" }, "费用归属", -1)])), _: 1, __: [3] }), e(s, { span: 20 }, { default: a(() => [_(o(l.value.branchCompanyName), 1)]), _: 1 })]), _: 1 }), e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[4] || (t[4] = [u("span", { class: "label" }, "录入人", -1)])), _: 1, __: [4] }), e(s, { span: 20 }, { default: a(() => [_(o(l.value.userName), 1)]), _: 1 })]), _: 1 }), l.value.type === n(p).ELECTRIC_COST.V || l.value.type === n(p).WATER_COST.V ? (i(), f(C, { key: 0 }, [e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => [u("span", J, o(`用${l.value.type === n(p).ELECTRIC_COST.V ? "电" : "水"}量：`), 1)]), _: 1 }), e(s, { span: 20 }, { default: a(() => [_(o(n(y)(l.value.consumption)), 1)]), _: 1 })]), _: 1 }), e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => [u("span", K, o(`${l.value.type === n(p).ELECTRIC_COST.V ? "电" : "水"}费总额（元）`), 1)]), _: 1 }), e(s, { span: 19 }, { default: a(() => [_(o(n(y)(l.value.totalFee)), 1)]), _: 1 })]), _: 1 })], 64)) : c("", true), l.value.type === n(p).PROPERTY_COST.V ? (i(), L(r, { key: 1 }, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[5] || (t[5] = [u("span", { class: "label" }, "物业费（元）", -1)])), _: 1, __: [5] }), e(s, { span: 20 }, { default: a(() => [_(o(n(y)(l.value.totalFee)), 1)]), _: 1 })]), _: 1 })) : c("", true), l.value.type === n(p).ELECTRIC_COST.V || l.value.type === n(p).WATER_COST.V ? (i(), f(C, { key: 2 }, [e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[6] || (t[6] = [u("span", { class: "label" }, "平均单价", -1)])), _: 1, __: [6] }), e(s, { span: 20 }, { default: a(() => [_(o(n(y)(l.value.averageUnitPrice)), 1)]), _: 1 })]), _: 1 }), e(r, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => t[7] || (t[7] = [u("span", { class: "label" }, "备注", -1)])), _: 1, __: [7] }), e(s, { span: 20 }, { default: a(() => [_(o(l.value.remark), 1)]), _: 1 })]), _: 1 })], 64)) : c("", true)]), _: 1 }, 8, ["model"]), b.value ? (i(), f("div", Q, [e(B, { modelValue: m.remark, "onUpdate:modelValue": t[0] || (t[0] = (O) => m.remark = O), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : c("", true)]), e(q, { style: { "margin-top": "10px" } })], 64);
  };
} }, le = U(X, [["__scopeId", "data-v-6f9dd172"]]);
export {
  le as default
};
