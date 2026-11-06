import { inject as b } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as p } from "vue";
import { unref as e } from "vue";
import { createBlock as C } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as E } from "vue";
import { withKeys as _ } from "vue";
import { vShow as Y } from "vue";
import { ElCol as D } from "element-plus";
import { ElRow as k } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { ElInput as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as T, p as U, B as z, l_ as I, C as P, E as S } from "../../../../../shared/runtime.js";
import { P as d } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const q = { class: "head-container" }, H = { __name: "header", setup(L) {
  const r = b("projectInfo"), f = { projectName: void 0, projectNumber: void 0, importTime: U(/* @__PURE__ */ new Date(), "{y}") };
  function y(m) {
    return m > /* @__PURE__ */ new Date();
  }
  const { crud: n, query: o } = z(f);
  return (m, t) => {
    const u = D, v = k, g = B, h = w("common-radio-button"), i = K, V = Q, N = j("permission");
    return c(), x("div", q, [p((c(), C(v, { gutter: 20, class: "panel-group" }, { default: s(() => [a(u, { span: 6, class: "card-panel-col" }, { default: s(() => [a(e(d), { name: "新排产的项目", "num-color": "#1890ff", "end-val": e(r).summary.projectNum || 0 }, null, 8, ["end-val"])]), _: 1 }), a(u, { span: 6, class: "card-panel-col" }, { default: s(() => [a(e(d), { name: "未开始的项目", "num-color": "#1890ff", "end-val": e(r).summary.noCuttingNum || 0 }, null, 8, ["end-val"])]), _: 1 }), a(u, { span: 6, class: "card-panel-col" }, { default: s(() => [a(e(d), { name: "未完成的项目", "num-color": "#1890ff", "end-val": e(r).summary.partialNum || 0 }, null, 8, ["end-val"])]), _: 1 }), a(u, { span: 6, class: "card-panel-col" }, { default: s(() => [a(e(d), { name: "已经完成的项目", "num-color": "#1890ff", "end-val": e(r).summary.cuttingNum || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[V, e(r).loading], [N, e(n).permission.statistics]]), a(e(S), null, { optLeft: s(() => [p(E("div", null, [a(g, { modelValue: e(o).importTime, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(o).importTime = l), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, format: "YYYY", "value-format": "YYYY", placeholder: "选择年", "disabled-date": y, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(h, { style: { "margin-right": "8px" }, class: "filter-item", modelValue: e(o).cutState, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(o).cutState = l), options: e(I).ENUM, "show-option-all": "", type: "enum", size: "default", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(i, { modelValue: e(o).projectName, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(o).projectName = l), placeholder: "请输入项目名称", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: _(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(i, { modelValue: e(o).projectNo, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(o).projectNo = l), placeholder: "请输入项目编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: _(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(P))], 512), [[Y, e(n).searchToggle]])]), _: 1 })]);
  };
} }, A = T(H, [["__scopeId", "data-v-b9f9aa48"]]);
export {
  A as default
};
