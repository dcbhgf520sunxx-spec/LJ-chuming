import { ref as f } from "vue";
import { openBlock as r } from "vue";
import { createBlock as b } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as x } from "vue";
import { createElementBlock as v } from "vue";
import { normalizeStyle as w } from "vue";
import { ElCard as S } from "element-plus";
import { vLoading as _ } from "element-plus";
import { u as k } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const D = { __name: "quality-problem-second-rank", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(u) {
  const d = f(false), { getMyChart: m } = k({ elementId: "qualityProblemSecondRank", fetchHook: h, initOption: { grid: { top: "20", right: "20", bottom: "15", left: "20" }, yAxis: { type: "category", axisTick: { show: true, length: 8 }, axisLabel: { show: true, margin: 10, fontSize: 9, interval: 0, formatter: function(e) {
    let t = "";
    const i = e.length, a = 3, n = Math.ceil(i / a);
    if (i > a) for (let o = 0; o < n; o++) {
      const s = o * a, g = s + a, y = o === n - 1 ? e.substring(s, i) : e.substring(s, g) + `
`;
      t += y;
    }
    else t = e;
    return t;
  } }, data: ["不带安全帽不带安全帽不带安全帽不带安全帽", "抽烟", "喝酒", "烫头"] }, xAxis: { type: "value", axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10 } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [10, 20, 30, 40], type: "bar", label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#009DFF" } }] } });
  function p(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function h(e) {
    (e || m()).getOption();
    const i = content.map((n) => n.name), a = content.map((n) => n.submitCount);
    p(i, a);
  }
  return (e, t) => {
    const i = S, a = _;
    return r(), b(i, null, { header: l(() => t[0] || (t[0] = [c("div", null, "质量问题(二级)发生排名", -1)])), default: l(() => [x((r(), v("div", { style: w({ height: u.maxHeight + "px" }) }, t[1] || (t[1] = [c("div", { id: "qualityProblemSecondRank", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, d.value]])]), _: 1 });
  };
} };
export {
  D as default
};
