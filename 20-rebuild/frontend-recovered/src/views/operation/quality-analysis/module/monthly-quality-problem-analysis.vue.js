import { ref as l } from "vue";
import { openBlock as n } from "vue";
import { createBlock as p } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as f } from "vue";
import { createElementBlock as h } from "vue";
import { normalizeStyle as g } from "vue";
import { ElCard as x } from "element-plus";
import { vLoading as v } from "element-plus";
import { u as b } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const C = { __name: "monthly-quality-problem-analysis", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(u) {
  const i = l(false), d = l(false), { getMyChart: m } = b({ elementId: "monthlyQualityProblemAnalysis", fetchHook: y, initOption: { grid: { bottom: "10" }, legend: { show: false }, tooltip: { show: true }, xAxis: { type: "category", axisTick: { show: true }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "" }, series: [{ name: "", data: [60, 80, 48, 69, 78, 43, 19, 90, 59, 45, 78, 90], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function y(s) {
    try {
      i.value = true;
      const e = s || m();
      e.on("click", function(a) {
        console.log(a, "params"), d.value = true;
      });
      const { content: o } = await getDiffAverageAnalysis({ range: 10 }), t = e.getOption();
      t.xAxis[0].data = o.map((a) => a.year), t.series[0].data = o.map((a) => a.averageDifferenceRatio), e.setOption(t);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      i.value = false;
    }
  }
  return (s, e) => {
    const o = x, t = v;
    return n(), p(o, null, { header: r(() => e[0] || (e[0] = [c("div", null, "月度质量问题分析", -1)])), default: r(() => [f((n(), h("div", { style: g({ height: u.maxHeight + "px" }) }, e[1] || (e[1] = [c("div", { id: "monthlyQualityProblemAnalysis", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[t, i.value]])]), _: 1 });
  };
} };
export {
  C as default
};
