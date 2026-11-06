import { ref as V } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as w } from "vue";
import { vShow as D } from "vue";
import { unref as a } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { withCtx as i } from "vue";
import { Search as P } from "@element-plus/icons-vue";
import { withKeys as S } from "vue";
import { createBlock as B } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as j } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElIcon as Q } from "element-plus";
import { ElInput as R } from "element-plus";
import { _ as U, B as H, ab as I, C as K, G as $, op as q, E as z } from "../../../../shared/runtime.js";
const G = { __name: "header", emits: ["filter-change", "openPaintConfig"], setup(L, { emit: c }) {
  const u = c, p = { projectName: "", startTime: void 0, endTime: void 0, paintCalculateStatus: void 0 }, { crud: s, query: t, CRUD: f } = H(p), r = V([]), _ = [{ value: 1, label: "未计算" }, { value: 2, label: "部分计算" }, { value: 4, label: "全部计算" }], d = () => {
    const n = /* @__PURE__ */ new Date(), e = /* @__PURE__ */ new Date();
    e.setTime(e.getTime() - 180 * 24 * 60 * 60 * 1e3), r.value = [e.getTime(), n.getTime()], t.startTime = e.getTime(), t.endTime = n.getTime();
  };
  d();
  function g(n) {
    n && n.length === 2 ? (t.startTime = n[0], t.endTime = n[1]) : (t.startTime = void 0, t.endTime = void 0), s.toQuery();
  }
  function y(n) {
    t.paintCalculateStatus = n, s.toQuery();
  }
  function h() {
    u("openPaintConfig");
  }
  return f.HOOK.beforeReset = () => (d(), t.paintCalculateStatus = void 0, u("filter-change", void 0), true), (n, e) => {
    const C = O, T = Q, v = R, b = x("common-button");
    return m(), k("div", null, [w(N("div", null, [l(I, { "show-option-all": "", modelValue: a(t).paintCalculateStatus, "onUpdate:modelValue": e[0] || (e[0] = (o) => a(t).paintCalculateStatus = o), options: _, type: "other", class: "filter-item", size: "default", "data-structure": { key: "value", label: "label", value: "value" }, onChange: y }, null, 8, ["modelValue"]), l(C, { modelValue: r.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => r.value = o), type: "daterange", "range-separator": ":", "start-placeholder": "开始日期", "end-placeholder": "结束日期", class: "filter-item", style: { width: "240px" }, "value-format": "x", onChange: g }, null, 8, ["modelValue"]), l(v, { modelValue: a(t).projectName, "onUpdate:modelValue": e[2] || (e[2] = (o) => a(t).projectName = o), placeholder: "项目搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: e[3] || (e[3] = S((o) => a(s).toQuery(), ["enter"])) }, { prefix: i(() => [l(T, null, { default: i(() => [l(a(P))]), _: 1 })]), _: 1 }, 8, ["modelValue"]), l(a(K))], 512), [[D, a(s).searchToggle]]), l(a(z), null, { optLeft: i(() => [a($)(a(q).config) ? (m(), B(b, { key: 0, type: "primary", size: "default", onClick: h }, { default: i(() => e[4] || (e[4] = [E(" 油漆配量表 ")])), _: 1, __: [4] })) : j("", true)]), _: 1 })]);
  };
} }, F = U(G, [["__scopeId", "data-v-56a125fd"]]);
export {
  F as default
};
