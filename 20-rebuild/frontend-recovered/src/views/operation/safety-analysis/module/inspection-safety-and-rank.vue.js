import { ref as m } from "vue";
import { openBlock as o } from "vue";
import { createBlock as f } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as h } from "vue";
import { normalizeStyle as g } from "vue";
import { ElCard as x } from "element-plus";
import { vLoading as v } from "element-plus";
import { u as _ } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const b = { __name: "inspection-safety-and-rank", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(l) {
  const d = m(false), { getMyChart: c } = _({ elementId: "inspectionSafetyAndRank", fetchHook: u, initOption: { legend: { show: true }, xAxis: { axisTick: { show: false }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}%" } }, series: [{ name: "刘磊", data: [4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#009dff" } }, { name: "刘伞", data: [8, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 2, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#fc710f" } }] } });
  function p(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function u(e) {
    (e || c()).getOption();
    const a = content.map((i) => i.name), n = content.map((i) => i.submitCount);
    p(a, n);
  }
  return (e, t) => {
    const a = x, n = v;
    return o(), f(a, null, { header: s(() => t[0] || (t[0] = [r("div", null, "年度安环检查数及问题数", -1)])), default: s(() => [y((o(), h("div", { style: g({ height: l.maxHeight + "px", overflow: e.auto }) }, t[1] || (t[1] = [r("div", { id: "inspectionSafetyAndRank", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, d.value]])]), _: 1 });
  };
} };
export {
  b as default
};
