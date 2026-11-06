import { onMounted } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as v } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as D } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElTag as k } from "element-plus";
import { l as u, _ as w, iq as m, B as C, G as N, L as S } from "../../../../../shared/runtime.js";
function T(o) {
  return u({ url: "/api/contract/analysis/pooled", method: "get", params: o });
}
function B(o) {
  return u({ url: "/api/contract/analysis/pooled/export", method: "get", responseType: "blob", params: o });
}
const U = { get: T };
const q = { class: "head-container" }, A = { style: { float: "right" } }, E = { __name: "header", setup(o) {
  const p = { registerDate: (/* @__PURE__ */ new Date()).getTime(), type: { value: m.SIGN.V, resetAble: false } }, { crud: a, query: s } = C(p);
  let refreshRunning = false;
  let refreshRequested = false;
  async function refreshSummary() {
    refreshRequested = true;
    if (refreshRunning) return;
    refreshRunning = true;
    try {
      while (refreshRequested) {
        refreshRequested = false;
        await a.refresh();
      }
    } finally {
      refreshRunning = false;
    }
  }
  onMounted(refreshSummary);
  return (j, t) => {
    const _ = x, f = g("common-radio-button"), y = k;
    return l(), h("div", q, [v(i("div", null, [n(_, { modelValue: e(s).registerDate, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(s).registerDate = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "x", onChange: refreshSummary }, null, 8, ["modelValue", "onChange"]), n(f, { modelValue: e(s).type, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(s).type = r), options: e(m).ENUM, class: "filter-item", type: "enum", onChange: refreshSummary }, null, 8, ["modelValue", "options", "onChange"]), i("div", A, [e(N)(e(a).permission.download) ? (l(), V(S, { key: 0, fn: e(B), params: { registerDate: e(a).query.registerDate }, class: "filter-item" }, { default: d(() => t[2] || (t[2] = [c(" 汇总分析表下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : D("", true), n(y, { effect: "plain", class: "filter-item" }, { default: d(() => t[3] || (t[3] = [c("单位：万元")])), _: 1, __: [3] })])], 512), [[b, e(a).searchToggle]])]);
  };
} }, Y = w(E, [["__scopeId", "data-v-14b81405"]]), z = Object.freeze(Object.defineProperty({ __proto__: null, default: Y }, Symbol.toStringTag, { value: "Module" }));
export {
  U as c,
  z as h,
  Y as m
};
