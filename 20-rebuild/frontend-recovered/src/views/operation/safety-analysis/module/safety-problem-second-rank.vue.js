import { ref as y } from "vue";
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
const z = { __name: "safety-problem-second-rank", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(d) {
  const u = y(false), { getMyChart: m } = k({ elementId: "safetyProblemSecondRank", fetchHook: h, initOption: { grid: { top: "20", right: "20", bottom: "15", left: "20" }, yAxis: { type: "category", axisTick: { show: true, length: 8 }, axisLabel: { show: true, margin: 10, fontSize: 9, interval: 0, formatter: function(e) {
    let t = "";
    const n = e.length, a = 3, o = Math.ceil(n / a);
    if (n > a) for (let i = 0; i < o; i++) {
      const s = i * a, f = s + a, g = i === o - 1 ? e.substring(s, n) : e.substring(s, f) + `
`;
      t += g;
    }
    else t = e;
    return t;
  } }, data: ["不带安全帽不带安全帽不带安全帽不带安全帽", "抽烟", "喝酒", "烫头"] }, xAxis: { type: "value", axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10 } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [10, 20, 30, 40], type: "bar", label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#009DFF" } }] } });
  function p(e, t) {
    options.value.yAxis.data = e, options.value.series[0].data = t;
  }
  async function h(e) {
    (e || m()).getOption();
    const n = content.map((o) => o.name), a = content.map((o) => o.submitCount);
    p(n, a);
  }
  return (e, t) => {
    const n = S, a = _;
    return r(), b(n, null, { header: l(() => t[0] || (t[0] = [c("div", null, "年度安环问题(二级)排名", -1)])), default: l(() => [x((r(), v("div", { style: w({ height: d.maxHeight + "px" }) }, t[1] || (t[1] = [c("div", { id: "safetyProblemSecondRank", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, u.value]])]), _: 1 });
  };
} };
export {
  z as default
};
