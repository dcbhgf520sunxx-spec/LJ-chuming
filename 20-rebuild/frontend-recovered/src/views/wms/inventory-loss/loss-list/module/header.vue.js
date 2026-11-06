import { ref as u } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as a } from "vue";
import { withKeys as c } from "vue";
import { createCommentVNode as h } from "vue";
import { withCtx as f } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as U } from "vue";
import { createTextVNode as N } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElInput as K } from "element-plus";
import { B as O, cJ as S, tX as k, hg as Q, I, fv as D, C as M, E as R } from "../../../../../shared/runtime.js";
import L from "./form/index.vue.js";
import "./form/components/steel-plate-table.vue.js";
import "./form/components/section-steel-table.vue.js";
import "./form/components/steel-coil-table.vue.js";
import "./form/components/other-steel-material-table.vue.js";
import "./form/components/auxiliary-material.vue.js";
import "./form/components/gas-table.vue.js";
import "./form/components/other-table.vue.js";
import "./form/submit-preview.vue.js";
const B = { class: "head-container" }, j = { key: 0 }, ee = { __name: "header", emits: ["success"], setup(z, { emit: V }) {
  const y = { basicClass: void 0, classifyId: void 0 }, C = V, _ = u([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: n, query: l } = O(y), s = u(false);
  function v() {
    C("success");
  }
  return (F, o) => {
    const i = d("common-radio-button"), b = x, m = K, g = d("common-button"), w = E("permission");
    return r(), p("div", B, [e(n).searchToggle ? (r(), p("div", j, [a(i, { modelValue: e(l).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(l).basicClass = t), options: e(S).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(i, { modelValue: e(l).reviewStatus, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(l).reviewStatus = t), options: { ...e(k).ENUM, REVOKE: { L: "已撤销", SL: "已撤销", K: "REVOKE", V: 8, TAG: "info", O_COLOR: "#409EFF" } }, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(i, { modelValue: e(l).deficitType, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(l).deficitType = t), options: e(Q).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(b, { modelValue: e(l).createTime, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(l).createTime = t), "default-time": _.value, shortcuts: e(I), class: "filter-item", "end-placeholder": "盘亏日期", "range-separator": ":", size: "default", "start-placeholder": "盘亏日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), a(e(D), { modelValue: e(l).projectId, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(l).projectId = t), class: "filter-item", clearable: "", isAll: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(m, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(l).serialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "盘亏单号", size: "default", style: { width: "200px" }, onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(m, { modelValue: e(l).applicantName, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(l).applicantName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "200px" }, onKeyup: c(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(M))])) : h("", true), a(e(R), null, { optLeft: f(() => [T((r(), U(g, { type: "primary", onClick: o[7] || (o[7] = (t) => s.value = true) }, { default: f(() => o[9] || (o[9] = [N("新增盘亏 ")])), _: 1, __: [9] })), [[w, e(n).permission.add]])]), _: 1 }), a(e(L), { modelValue: s.value, "onUpdate:modelValue": o[8] || (o[8] = (t) => s.value = t), onSuccess: v }, null, 8, ["modelValue"])]);
  };
} };
export {
  ee as default
};
