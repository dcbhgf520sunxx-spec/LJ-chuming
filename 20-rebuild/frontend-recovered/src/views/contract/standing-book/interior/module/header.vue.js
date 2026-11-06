import { inject as V } from "vue";
import { ref as v } from "vue";
import { watch as p } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as g } from "vue";
import { ElTag as A } from "element-plus";
import { _ as M, B as S, cy as Y, l1 as T, c1 as Q, fv as k, bV as B, C as E } from "../../../../../shared/runtime.js";
import F from "./project-info.vue.js";
import { i as N } from "../../../../../modules/index-1f7d934b.js";
import U from "../components/year-date.vue.js";
import "../../../../../modules/contract-9b18cc88.js";
const q = { class: "select-pm" }, z = { key: 0, style: { padding: "0 20px 0 20px" } }, H = { class: "search-container" }, P = { key: 0, class: "cash" }, R = { __name: "header", setup($) {
  const _ = (/* @__PURE__ */ new Date()).getFullYear(), f = { startDate: new Date(_ - 2, 0, 1).getTime(), endDate: (/* @__PURE__ */ new Date()).getTime(), projectManagerId: void 0, projectId: void 0, projectAttribute: void 0, settlementStatus: void 0 }, { crud: n, query: t } = S(f), { projectManagerId: h } = V("common"), u = v(), c = async (a) => {
    try {
      u.value = await N({ id: a });
    } catch (o) {
      console.log("获取总结余失败", o);
    }
  };
  p(() => h.value, (a) => {
    a && (c(a), n.crudApi.getAmount = () => c(a));
  }, { immediate: true });
  const y = [new Date((/* @__PURE__ */ new Date()).getFullYear() - 2, 0, 1).getFullYear(), (/* @__PURE__ */ new Date()).getFullYear()], j = (a) => {
    a.length === 2 && (t.startDate = new Date(a[0], 0, 1).getTime(), t.endDate = new Date(a[1], 11, 31).getTime());
  };
  return p(() => [t.startDate, t.endDate], (a, o) => {
    (a[0] !== o[0] || a[1] !== o[1]) && n.toQuery();
  }), (a, o) => {
    const i = I("common-select"), D = E, C = A;
    return l(), d("div", null, [m("div", q, [r(Y, { modelValue: e(t).projectManagerId, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).projectManagerId = s), clearable: false, filterable: "", placeholder: "项目经理", style: { width: "220px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), e(n).query.projectManagerId ? (l(), d("div", z, [r(F), m("div", H, [r(U, { value: y, style: { width: "200px" }, onInput: j }), r(i, { modelValue: e(t).projectAttribute, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).projectAttribute = s), options: e(T).V, clearable: "", placeholder: "全部类型", size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(i, { modelValue: e(t).settlementStatus, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(t).settlementStatus = s), options: e(Q).V, clearable: "", placeholder: "全部状态", size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(k, { modelValue: e(t).projectId, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(t).projectId = s), projectManagerId: e(n).query.projectManagerId, class: "filter-item", clearable: "", placeholder: "项目搜索", size: "default", onChange: e(n).toQuery }, null, 8, ["modelValue", "projectManagerId", "onChange"]), r(D), e(t).projectAttribute != 2 ? (l(), d("div", P, [r(C, { type: "primary" }, { default: w(() => [b("内包制项目结余: " + x(e(B)(u.value)), 1)]), _: 1 })])) : g("", true)])])) : g("", true)]);
  };
} }, Z = M(R, [["__scopeId", "data-v-f6824214"]]);
export {
  Z as default
};
