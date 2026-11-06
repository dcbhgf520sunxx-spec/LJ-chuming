import { ref as p } from "vue";
import { openBlock as a } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as m } from "vue";
import { createElementBlock as u } from "vue";
import { normalizeStyle as y } from "vue";
import { ElCard as f } from "element-plus";
import { vLoading as g } from "element-plus";
import { u as x } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const v = { __name: "monthly-inspection-statistics-and-analysis", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(n) {
  const r = p(false), { getMyChart: l } = x({ elementId: "monthlyInspectionStatisticsAndStatistics", fetchHook: d, initOption: { grid: { top: "40", bottom: "15", right: "30", left: "20" }, legend: { show: true }, yAxis: { type: "value", axisTick: { show: true }, axisLabel: { show: true, fontSize: 10 } }, xAxis: { type: "category", axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10 }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, distance: 3, position: "top" }, itemStyle: { color: "#009dff" } }, { name: "", data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, distance: 3, position: "top" }, itemStyle: { color: "#22e4ff" } }] } });
  async function d(i) {
    const t = i || l(), e = t.getOption();
    e.series[0].name = "刘磊 累计巡检次数：120次", e.series[1].name = "刘伞 累计巡检次数：126次", t.setOption(e);
  }
  return (i, t) => {
    const e = f, c = g;
    return a(), h(e, null, { header: s(() => t[0] || (t[0] = [o("div", null, "月度巡检统计与分析", -1)])), default: s(() => [m((a(), u("div", { style: y({ height: n.maxHeight + "px", overflow: i.auto }) }, t[1] || (t[1] = [o("div", { id: "monthlyInspectionStatisticsAndStatistics", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[c, r.value]])]), _: 1 });
  };
} };
export {
  v as default
};
