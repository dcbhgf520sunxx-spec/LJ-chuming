import { ref as h } from "vue";
import { openBlock as s } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as _ } from "vue";
import { normalizeStyle as f } from "vue";
import { ElCard as g } from "element-plus";
import { vLoading as x } from "element-plus";
import { u as v } from "../../../../modules/use-chart-59e4b63c.js";
import { _ as w } from "../../../../shared/runtime.js";
import "../../../../modules/index-18acf776.js";
const k = { __name: "workshop-quality-inspection-rate", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(l) {
  const p = h(false), { getMyChart: c } = v({ elementId: "workshopQualityInspectionRate", fetchHook: u, initOption: { grid: { top: "15", bottom: "15", right: "30" }, yAxis: { type: "category", axisTick: { show: true }, axisLabel: { show: true, interval: 0, fontSize: 10 }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, xAxis: { type: "value", min: 0, max: 100, axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10, formatter: "{value}%" } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 100], type: "bar", label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#009DFF" } }] } });
  function d(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function u(e) {
    (e || c()).getOption();
    const a = content.map((o) => o.name), i = content.map((o) => o.submitCount);
    d(a, i);
  }
  return (e, t) => {
    const a = g, i = x;
    return s(), m(a, null, { header: n(() => t[0] || (t[0] = [r("div", null, "车间月度一次质检合格率", -1)])), default: n(() => [y((s(), _("div", { style: f({ height: l.maxHeight + "px" }) }, t[1] || (t[1] = [r("div", { id: "workshopQualityInspectionRate", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, p.value]])]), _: 1 });
  };
} }, D = w(k, [["__scopeId", "data-v-a15ede18"]]);
export {
  D as default
};
