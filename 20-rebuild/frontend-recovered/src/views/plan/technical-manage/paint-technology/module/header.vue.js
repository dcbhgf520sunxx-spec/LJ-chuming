import { ref as _ } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as h } from "vue";
import { vShow as C } from "vue";
import { unref as t } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as r } from "vue";
import { withCtx as m } from "vue";
import { createBlock as v } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as x } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElInput as b } from "element-plus";
import { B as N, C as U, G as B, E as j } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/project-select-94bb5bbd.js";
import { F as I } from "../../../../../modules/plan-d12d7ccf.js";
const q = { __name: "header", setup(R) {
  const u = { projectId: { value: void 0, resetAble: false }, createUserName: "", createTime: void 0, endTime: void 0 }, { crud: l, query: a, CRUD: c } = N(u), s = _([]), d = () => {
    const n = /* @__PURE__ */ new Date(), e = /* @__PURE__ */ new Date();
    e.setTime(e.getTime() - 180 * 24 * 60 * 60 * 1e3), s.value = [e.getTime(), n.getTime()], a.createTime = e.getTime(), a.endTime = n.getTime();
  };
  d();
  function p(n) {
    n && n.length === 2 ? (a.createTime = n[0], a.endTime = n[1]) : (a.createTime = void 0, a.endTime = void 0), l.toQuery();
  }
  return c.HOOK.beforeReset = () => (d(), true), (n, e) => {
    const f = D, g = b, T = V("common-button");
    return i(), y("div", null, [h(k("div", null, [r(f, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => s.value = o), type: "daterange", "range-separator": ":", "start-placeholder": "开始日期", "end-placeholder": "结束日期", class: "filter-item", style: { width: "240px" }, "value-format": "x", onChange: p }, null, 8, ["modelValue"]), r(t(E), { modelValue: t(a).projectId, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(a).projectId = o), clearable: "", class: "filter-item", style: { width: "200px" }, placeholder: "选择项目", onChange: e[2] || (e[2] = (o) => t(l).toQuery()) }, null, 8, ["modelValue"]), r(g, { modelValue: t(a).createUserName, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(a).createUserName = o), placeholder: "输入创建人搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(t(U))], 512), [[C, t(l).searchToggle]]), r(t(j), null, { optLeft: m(() => [t(B)(t(I).add) ? (i(), v(T, { key: 0, type: "primary", size: "default", onClick: t(l).toAdd }, { default: m(() => e[4] || (e[4] = [w("创建工艺")])), _: 1, __: [4] }, 8, ["onClick"])) : x("", true)]), _: 1 })]);
  };
} };
export {
  q as default
};
