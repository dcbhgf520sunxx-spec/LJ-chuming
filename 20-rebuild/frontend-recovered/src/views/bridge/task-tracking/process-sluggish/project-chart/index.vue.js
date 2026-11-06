import { p as k } from "../../../../../modules/process-sluggish-6aee505d.js";
import { _ as C, o as B, bW as S } from "../../../../../shared/runtime.js";
import V from "./module/chart.vue.js";
import { inject as p } from "vue";
import { ref as _ } from "vue";
import { watch as f } from "vue";
import { onMounted as I } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as s } from "vue";
import { createBlock as j } from "vue";
import { withCtx as D } from "vue";
import { toDisplayString as H } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as T } from "vue";
import { withDirectives as N } from "vue";
import { normalizeStyle as z } from "vue";
import { createVNode as E } from "vue";
import "../../../../../modules/index-18acf776.js";
const M = { class: "project-chart" }, P = { class: "chart-head" }, q = { style: { width: "calc(100% - 0px)" } }, G = { __name: "index", emits: ["update:year", "change", "success"], setup(K, { emit: x }) {
  const n = x, y = p("permission"), a = _(), o = _([]), c = p("searchProductType"), r = p("workShopId");
  f(() => c.value, (e) => {
    e && d();
  }, { deep: true, immediate: true }), f(() => r.value, (e) => {
    e && (d(), l());
  }, { deep: true, immediate: true });
  async function d() {
    var e;
    if (o.value = [], a.value = void 0, !(!c.value || !r.value)) try {
      const t = await k({ productType: c.value, workShopId: r.value });
      o.value = t, a.value = (e = t[0]) == null ? void 0 : e.id;
    } catch (t) {
      console.log("获取当前车间下的生产线失败", t);
    } finally {
      l(a.value);
    }
  }
  const { maxHeight: g } = B({ extraBox: [".chart-head"], wrapperBox: [".chart-container"], minHeight: 566, extraHeight: 115 });
  I(() => {
    d();
  });
  function l(e) {
    n("change", e), n("success", {});
  }
  function w(e) {
    n("success", e);
  }
  return (e, t) => {
    var h;
    const b = L("permission");
    return m(), v("div", M, [s("div", P, [t[1] || (t[1] = s("div", { style: { width: "100%", display: "flex", "justify-content": "flex-end", "margin-bottom": "8px" } }, [s("span", { style: { "font-size": "14px" } }, "单位：件|吨")], -1)), s("div", q, [(h = o.value) != null && h.length ? (m(), j(i(S), { key: 0, modelValue: a.value, "onUpdate:modelValue": t[0] || (t[0] = (u) => a.value = u), class: "filter-item", style: { width: "100%" }, data: o.value, itemKey: "id", onChange: l }, { default: D(({ item: u }) => [s("span", null, H(u.name), 1)]), _: 1 }, 8, ["modelValue", "data"])) : T("", true)])]), N((m(), v("div", { class: "chart-container", style: z({ height: i(g) + "px" }) }, [E(i(V), { id: "projectChart", width: "300px", onSuccess: w })], 4)), [[b, i(y).statistics]])]);
  };
} }, F = C(G, [["__scopeId", "data-v-14f93fcb"]]);
export {
  F as default
};
