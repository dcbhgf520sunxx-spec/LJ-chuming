import { ref as c } from "vue";
import N from "moment";
import { resolveComponent as S } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as d } from "vue";
import { unref as m } from "vue";
import { withDirectives as C } from "vue";
import { normalizeStyle as z } from "vue";
import { createBlock as k } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as D } from "vue";
import { Fragment as T } from "vue";
import { renderList as F } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { vLoading as q } from "element-plus";
import { l as Y, _ as $, t as j, o as V } from "../../../shared/runtime.js";
import { u as G } from "../../../modules/use-chart-59e4b63c.js";
import { P } from "../../../modules/index-5b9e6004.js";
import { _ as J } from "../../../modules/factory-select-b8d0a4ac.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function K(b) {
  return Y({ url: "/api/operational/analysis/auxiliary_materials", method: "get", params: b });
}
const Q = { class: "app-container" }, R = { class: "head-container" }, W = { class: "main-content" }, X = { style: { flex: "0.55", "margin-right": "15px" } }, Z = { gutter: 20, class: "panel-group" }, ee = { __name: "index", setup(b) {
  const { decimalPrecision: B } = j();
  function H(o) {
    return o > /* @__PURE__ */ new Date();
  }
  const v = c(N().valueOf()), _ = c(), w = c(false), r = c({}), A = c([]), g = c([]);
  for (let o = 1; o <= 12; o++) g.value.push(o + "月");
  const { maxHeight: I } = V({ extraBox: [".head-container", ".panel-group"] }), { maxHeight: O } = V({ extraBox: [".head-container"] }), { getMyChart: E } = G({ elementId: "diffAnalysisChart", fetchHook: y, initOption: { legend: { show: false }, xAxis: { data: g.value }, title: { text: "辅材费用消耗" }, series: [{ name: "费用消耗", type: "bar", data: [], markPoint: { data: [{ type: "max", name: "Max" }, { type: "min", name: "Min" }] } }] } });
  function M(o) {
    const { columns: t, data: p } = o, l = [];
    return t.forEach((u, s) => {
      if (s === 0) {
        l[s] = "合计";
        return;
      }
      l[s] = p.reduce((n, e) => (n += e.amount && e.amount[s] || 0, n), 0);
    }), l;
  }
  async function y() {
    try {
      r.value = {};
      const o = E(), { outboundAmounts: t, productionAnalysisDetails: p } = await K({ dateTime: v.value, factoryId: _.value });
      A.value = t;
      const l = p.reduce((e, a) => (e += a.production, e), 0);
      r.value.production = l / 1e3;
      const u = new Array(12).fill(0);
      for (let e = 0; e < u.length; e++) for (let a = 0; a < t.length; a++) t[a].amount && t[a].amount[e + 1] && (t[a].amount[e + 1] = Number(t[a].amount[e + 1].toFixed(0)), u[e] += t[a].amount[e + 1] || 0);
      const s = u.reduce((e, a) => (e += a, e), 0);
      r.value.average = r.value.production ? s / r.value.production : 0;
      const n = o.getOption();
      n.series[0].data = u, o.setOption(n);
    } catch (o) {
      console.log(o, "获取辅材消耗失败");
    }
  }
  return (o, t) => {
    const p = L, l = U, u = S("common-table"), s = q;
    return f(), x("div", Q, [i("div", R, [d(p, { modelValue: v.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => v.value = n), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", class: "filter-item", clearable: false, "disabled-date": H, onChange: y }, null, 8, ["modelValue"]), d(m(J), { modelValue: _.value, "onUpdate:modelValue": t[1] || (t[1] = (n) => _.value = n), class: "filter-item", showOptionAll: "", style: { width: "300px" }, onChange: y }, null, 8, ["modelValue"]), t[2] || (t[2] = i("div", { style: { float: "right", "font-size": "16px", color: "#303133" } }, "单位：元", -1))]), i("div", W, [i("div", X, [C((f(), x("div", Z, [d(m(P), { name: "总产量（吨）", "num-color": "#1890ff", "end-val": r.value.production || 0, precision: 2 }, null, 8, ["end-val"]), d(m(P), { name: "平均辅材费（元/吨）", "num-color": "#1890ff", "end-val": r.value.average || 0, precision: m(B).operation }, null, 8, ["end-val", "precision"])])), [[s, w.value]]), i("div", { style: z({ height: m(I) + "px" }) }, t[3] || (t[3] = [i("div", { id: "diffAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), C((f(), k(u, { style: { flex: "1" }, "show-summary": "", "summary-method": M, height: m(O), data: A.value }, { default: h(() => [d(l, { "show-overflow-tooltip": true, label: "辅材种类", "min-width": "100px", align: "center" }, { default: h(({ row: n }) => [i("span", null, D(n.classifyName), 1)]), _: 1 }), d(l, { "show-overflow-tooltip": true, label: "月份/消耗金额", "min-width": "100px", align: "center" }, { default: h(() => [(f(true), x(T, null, F(g.value, (n, e) => (f(), k(l, { key: e, "show-overflow-tooltip": true, label: n, align: "center" }, { default: h(({ row: a }) => [i("span", null, D(a.amount && a.amount[e + 1] || 0), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })]), _: 1 }, 8, ["height", "data"])), [[s, w.value]])])]);
  };
} }, re = $(ee, [["__scopeId", "data-v-84c8dbc5"]]);
export {
  re as default
};
