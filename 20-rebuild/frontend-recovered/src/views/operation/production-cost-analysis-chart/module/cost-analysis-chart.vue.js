import { ref as w } from "vue";
import { watch as x } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as b } from "vue";
import { normalizeStyle as C } from "vue";
import { Fragment as F } from "vue";
import { vLoading as N } from "element-plus";
import { a as B } from "../../../../modules/production-cost-analysis-chart-d811fbd9.js";
import { G as S, i as M } from "../../../../shared/runtime.js";
import { u as O } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const A = { __name: "cost-analysis-chart", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(p) {
  const m = w(false), c = p;
  x(() => c.query, (e) => {
    u();
  }, { deep: true });
  const { getMyChart: v } = O({ elementId: "costAnalysisChart", fetchHook: u, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], tooltip: { trigger: "item", appendToBody: true, position: function(e, r, o, s, n) {
    var i = 0, t = 0, a = e[0], l = e[1], f = n.contentSize[0], h = n.contentSize[1];
    return f > a ? i = 5 : i = a - f, h > l ? t = 5 : t = l - h, [i, t];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: 7, right: 10, formatter: function(e) {
    let r = "";
    const o = e.length, s = 15, n = Math.ceil(o / s);
    if (o > s) for (let i = 0; i < n; i++) {
      const t = i * s, a = t + s, l = i === n - 1 ? e.substring(t, o) : e.substring(t, a) + `
`;
      r += l;
    }
    else r = e;
    return r;
  } }, series: [{ type: "pie", center: ["38%", "50%"], data: [], label: { formatter: (e) => `${e.value}%` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function u(e) {
    var r;
    if (!S((r = c.permission) == null ? void 0 : r.get)) return false;
    try {
      m.value = true;
      const o = e || v(), s = await B({ ...c.query }), n = o.getOption(), i = s == null ? void 0 : s.reduce((t, a) => M(a == null ? void 0 : a.sumMete) ? t + (a == null ? void 0 : a.sumMete) : t, 0);
      n.series[0].data = s == null ? void 0 : s.map((t) => ({ name: t.className, value: (t.sumMete / i * 100).toFixed(2) })), o.setOption(n);
    } catch (o) {
      console.log(o, "获取饼图失败");
    } finally {
      m.value = false;
    }
  }
  return (e, r) => {
    const o = N;
    return d(), g(F, null, [r[1] || (r[1] = y("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "成本分析", -1)), b((d(), g("div", { style: C({ height: p.maxHeight + "px" }) }, r[0] || (r[0] = [y("div", { id: "costAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, m.value]])], 64);
  };
} };
export {
  A as default
};
