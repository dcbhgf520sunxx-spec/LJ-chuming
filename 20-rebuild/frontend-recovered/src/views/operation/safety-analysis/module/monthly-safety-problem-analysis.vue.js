import { ref as l } from "vue";
import { openBlock as n } from "vue";
import { createBlock as u } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as p } from "vue";
import { createElementBlock as h } from "vue";
import { normalizeStyle as g } from "vue";
import { ElCard as x } from "element-plus";
import { vLoading as v } from "element-plus";
import { u as b } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const C = { __name: "monthly-safety-problem-analysis", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(d) {
  const s = l(false), m = l(false), { getMyChart: y } = b({ elementId: "monthlySafetyProblemAnalysis", fetchHook: f, initOption: { grid: { bottom: "10" }, legend: { show: false }, tooltip: { show: true }, xAxis: { type: "category", axisTick: { show: true }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "" }, series: [{ name: "", data: [60, 80, 48, 69, 78, 43, 19, 90, 59, 45, 78, 90], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function f(i) {
    try {
      s.value = true;
      const e = i || y();
      e.on("click", function(a) {
        console.log(a, "params"), m.value = true;
      });
      const { content: o } = await getDiffAverageAnalysis({ range: 10 }), t = e.getOption();
      t.xAxis[0].data = o.map((a) => a.year), t.series[0].data = o.map((a) => a.averageDifferenceRatio), e.setOption(t);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      s.value = false;
    }
  }
  return (i, e) => {
    const o = x, t = v;
    return n(), u(o, null, { header: r(() => e[0] || (e[0] = [c("div", null, "月度安环问题分析", -1)])), default: r(() => [p((n(), h("div", { style: g({ height: d.maxHeight + "px" }) }, e[1] || (e[1] = [c("div", { id: "monthlySafetyProblemAnalysis", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[t, s.value]])]), _: 1 });
  };
} };
export {
  C as default
};
