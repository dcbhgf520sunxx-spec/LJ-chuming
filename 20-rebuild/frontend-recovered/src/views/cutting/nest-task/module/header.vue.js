import { inject as V } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as p } from "vue";
import { unref as e } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as E } from "vue";
import { withKeys as Y } from "vue";
import { vShow as j } from "vue";
import { ElCol as D } from "element-plus";
import { ElRow as k } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { ElInput as T } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as Q, p as S, B as U, m3 as z, C as K, E as P } from "../../../../shared/runtime.js";
import { P as m } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const q = { class: "head-container" }, H = { __name: "header", setup(L) {
  const l = V("projectInfo"), u = { projectName: void 0, importTime: S(/* @__PURE__ */ new Date(), "{y}") }, { crud: s, query: t } = U(u);
  function _(c) {
    return c > /* @__PURE__ */ new Date();
  }
  return (c, o) => {
    const i = D, f = k, v = B, g = b("common-radio-button"), y = T, h = I, w = N("permission");
    return d(), x("div", q, [p((d(), C(f, { gutter: 20, class: "panel-group" }, { default: n(() => [a(i, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(m), { name: "套料项目", "num-color": "#1890ff", "end-val": e(l).summary.projectNum || 0 }, null, 8, ["end-val"])]), _: 1 }), a(i, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(m), { name: "全部套料", "num-color": "#1890ff", "end-val": e(l).summary.nestingNum || 0 }, null, 8, ["end-val"])]), _: 1 }), a(i, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(m), { name: "部分套料", "num-color": "#1890ff", "end-val": e(l).summary.partialNesting || 0 }, null, 8, ["end-val"])]), _: 1 }), a(i, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(m), { name: "未套料", "num-color": "#1890ff", "end-val": e(l).summary.noNesting || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[h, e(l).loading], [w, e(s).permission.statistics]]), a(e(P), null, { optLeft: n(() => [p(E("div", null, [a(v, { modelValue: e(t).importTime, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(t).importTime = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, format: "YYYY", "value-format": "YYYY", placeholder: "选择年", "disabled-date": _, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), a(g, { style: { "margin-right": "8px" }, class: "filter-item", modelValue: e(t).nestingState, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(t).nestingState = r), options: e(z).ENUM, "show-option-all": "", type: "enum", size: "default", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(y, { modelValue: e(t).projectName, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(t).projectName = r), placeholder: "请输入项目名称", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: Y(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(K))], 512), [[j, e(s).searchToggle]])]), _: 1 })]);
  };
} }, A = Q(H, [["__scopeId", "data-v-57bc9960"]]);
export {
  A as default
};
