import { ref as h } from "vue";
import { openBlock as o } from "vue";
import { createBlock as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as g } from "vue";
import { normalizeStyle as f } from "vue";
import { ElCard as x } from "element-plus";
import { vLoading as w } from "element-plus";
import { u as b } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const C = { __name: "inspection-quantity-and-rank", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(l) {
  const d = h(false), { getMyChart: u } = b({ elementId: "inspectionQuantityAndRank", fetchHook: p, initOption: { grid: { top: "30", bottom: "15", right: "30", left: "20" }, legend: { show: true }, yAxis: { type: "category", axisTick: { show: true }, axisLabel: { show: true, fontSize: 10 }, data: ["张三", "李四", "王五", "测试"] }, xAxis: { type: "value", min: 0, max: 100, axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10 } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "检查数量", data: [50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#119760" } }, { name: "问题数量", data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#33d7f3" } }] } });
  function c(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function p(e) {
    (e || u()).getOption();
    const a = content.map((n) => n.name), i = content.map((n) => n.submitCount);
    c(a, i);
  }
  return (e, t) => {
    const a = x, i = w;
    return o(), m(a, null, { header: s(() => t[0] || (t[0] = [r("div", null, "质检人员检查数及问题数排名", -1)])), default: s(() => [y((o(), g("div", { style: f({ height: l.maxHeight + "px", overflow: e.auto }) }, t[1] || (t[1] = [r("div", { id: "inspectionQuantityAndRank", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, d.value]])]), _: 1 });
  };
} };
export {
  C as default
};
