import { ref as _ } from "vue";
import g from "moment";
import { resolveComponent as V } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as e } from "vue";
import { unref as p } from "vue";
import { createBlock as j } from "vue";
import { withCtx as a } from "vue";
import { createCommentVNode as v } from "vue";
import { createTextVNode as d } from "vue";
import { ElDatePicker as h } from "element-plus";
import { ElTag as I } from "element-plus";
import { ElDivider as $ } from "element-plus";
import { c1 as u } from "../../../shared/runtime.js";
import { _ as k } from "../../../modules/project-select-94bb5bbd.js";
import H from "./project-total-process.vue.js";
import E from "./project-maching-process.vue.js";
import z from "./part-scheduling-statistics.vue.js";
import b from "./artifact-scheduling-statistics.vue.js";
import w from "./produce-process-statistics.vue.js";
import N from "./project-steel-usage-statistics.vue.js";
import S from "./project-auxiliary-usage-statistics.vue.js";
import C from "./artifact-type-analysis.vue.js";
import U from "./steel-type-analysis.vue.js";
import Y from "./ship-analysis.vue.js";
import B from "./ship-record.vue.js";
import "../../../modules/use-chart-v2-ba3ec3fa.js";
import "../../../modules/index-18acf776.js";
import "./product-statistics-detail.vue.js";
import "../../../modules/project-overview-1b3937a7.js";
import "./scheduling-product-statistics-detail.vue.js";
import "../../../modules/use-chart-59e4b63c.js";
import "./product-process-statistics-detail.vue.js";
import "./project-outbound-statistics-detail.vue.js";
import "./artifact-type-statistics-detail.vue.js";
import "./ship-statistics-detail.vue.js";
import "./ship-record-detail.vue.js";
const D = { class: "app-container" }, P = { class: "head-container", style: { display: "flex", "align-items": "center" } }, O = { key: 1 }, T = { key: 0 }, M = { style: { display: "flex" } }, A = { style: { flex: "1" } }, L = { style: { flex: "1", "margin-left": "20px" } }, R = { style: { display: "flex" } }, q = { style: { flex: "1" } }, F = { style: { flex: "1", "margin-left": "20px" } }, G = { key: 1 }, je = { __name: "index", setup(J) {
  const c = _(g().valueOf()), f = _(u.PROCESS.V), l = _();
  return (K, t) => {
    const x = h, y = V("common-radio-button"), s = I, o = $;
    return r(), n("div", D, [i("div", P, [e(x, { modelValue: c.value, "onUpdate:modelValue": t[0] || (t[0] = (m) => c.value = m), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), e(y, { modelValue: f.value, "onUpdate:modelValue": t[1] || (t[1] = (m) => f.value = m), options: p(u).ENUM, class: "filter-item", "show-option-all": "", unshowVal: [p(u).SUSPEND.V, p(u).COMPLETE.V], size: "default", type: "enum" }, null, 8, ["modelValue", "options", "unshowVal"]), e(p(k), { modelValue: l.value, "onUpdate:modelValue": t[2] || (t[2] = (m) => l.value = m), class: "filter-item", clearable: "", style: { width: "320px" } }, null, 8, ["modelValue"]), l.value ? (r(), j(s, { key: 0, size: "medium", class: "filter-item" }, { default: a(() => t[3] || (t[3] = [i("span", null, "结束时间: 2024-10-30", -1), i("span", { style: { margin: "0 15px" } }, "|", -1), i("span", null, "合同工期： 31天", -1)])), _: 1, __: [3] })) : v("", true), l.value ? (r(), n("div", O, [e(s, { class: "filter-item", size: "medium", type: "success" }, { default: a(() => t[4] || (t[4] = [d("倒计时：15天")])), _: 1, __: [4] }), e(s, { class: "filter-item", size: "medium", type: "success" }, { default: a(() => t[5] || (t[5] = [d("正常")])), _: 1, __: [5] }), e(s, { class: "filter-item", size: "medium", type: "danger" }, { default: a(() => t[6] || (t[6] = [d("超时：15天")])), _: 1, __: [6] }), e(s, { class: "filter-item", size: "medium", type: "danger" }, { default: a(() => t[7] || (t[7] = [d("超期")])), _: 1, __: [7] })])) : v("", true)]), l.value ? (r(), n("div", T, [i("div", M, [i("div", A, [e(H, { maxHeight: 260 })]), i("div", L, [e(E, { projectId: l.value, maxHeight: 260 }, null, 8, ["projectId"])])]), e(o, { class: "divider" }), i("div", R, [i("div", q, [e(z, { projectId: l.value, maxHeight: 260 }, null, 8, ["projectId"])]), i("div", F, [e(b, { projectId: l.value, maxHeight: 260 }, null, 8, ["projectId"])])]), e(o, { class: "divider" }), i("div", null, [e(w, { projectId: l.value, maxHeight: 240 }, null, 8, ["projectId"])]), e(o, { class: "divider" }), i("div", null, [e(N, { maxHeight: 240 })]), e(o, { class: "divider" }), i("div", null, [e(S, { maxHeight: 240 })]), e(o, { class: "divider" }), i("div", null, [e(C, { projectId: l.value, maxHeight: 240 }, null, 8, ["projectId"])]), e(o, { class: "divider" }), i("div", null, [e(U, { maxHeight: 240 })]), e(o, { class: "divider" }), i("div", null, [e(Y, { maxHeight: 240 })]), e(o, { class: "divider" }), i("div", null, [e(B, { projectId: l.value, maxHeight: 240 }, null, 8, ["projectId"])]), e(o, { class: "divider" })])) : (r(), n("div", G, [e(s, { type: "danger", size: "medium", style: { "margin-bottom": "10px" } }, { default: a(() => t[8] || (t[8] = [d(" * 您好，请先选择项目，当前页面需要选择项目方可查看 ")])), _: 1, __: [8] })]))]);
  };
} };
export {
  je as default
};
