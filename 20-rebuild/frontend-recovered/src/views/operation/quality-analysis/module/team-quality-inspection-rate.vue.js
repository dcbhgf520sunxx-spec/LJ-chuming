import { ref as p } from "vue";
import { openBlock as n } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as f } from "vue";
import { normalizeStyle as g } from "vue";
import { ElCard as x } from "element-plus";
import { vLoading as v } from "element-plus";
import { u as w } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const _ = { __name: "team-quality-inspection-rate", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(l) {
  const d = p(false), { getMyChart: u } = w({ elementId: "teamQualityInspectionRate", fetchHook: m, initOption: { grid: { top: "15", bottom: "15", right: "30", left: "20" }, yAxis: { type: "category", axisTick: { show: true }, axisLabel: { show: true, fontSize: 10 }, data: ["张三", "李四", "王五", "测试"] }, xAxis: { type: "value", min: 0, max: 100, axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10, formatter: "{value}%" } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#119760" } }] } });
  function c(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function m(e) {
    (e || u()).getOption();
    const a = content.map((o) => o.name), i = content.map((o) => o.submitCount);
    c(a, i);
  }
  return (e, t) => {
    const a = x, i = v;
    return n(), h(a, null, { header: s(() => t[0] || (t[0] = [r("div", null, "班组一次质检合格率排名", -1)])), default: s(() => [y((n(), f("div", { style: g({ height: l.maxHeight + "px", overflow: e.auto }) }, t[1] || (t[1] = [r("div", { id: "teamQualityInspectionRate", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, d.value]])]), _: 1 });
  };
} };
export {
  _ as default
};
