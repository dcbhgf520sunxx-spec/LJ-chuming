import { ref as l } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as u } from "vue";
import { normalizeStyle as h } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as g } from "vue";
import { Fragment as f } from "vue";
import { vLoading as x } from "element-plus";
import { u as y } from "../../../modules/use-chart-v2-ba3ec3fa.js";
import v from "./scheduling-product-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const B = { __name: "artifact-scheduling-statistics", props: { maxHeight: { type: [Number, String], default: void 0 }, projectId: { type: Number } }, setup(s) {
  const i = l(false), o = l(false), { getMyChart: m } = y({ elementId: "artifactSchedulingChart", fetchHook: d, initOption: { grid: { right: "20" }, legend: { data: ["排产量", "完成量"], left: "center" }, custom: { title: [{ text: "构件排产&生产统计" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { data: ["2024-01", "2024-02", "2024-03", "2024-04", "2024-05", "2024-06", "2024-07", "2024-08", "2024-09", "2024-10", "2024-11", "2024-12"], axisLabel: { rotate: 45 } }, yAxis: [{ axisLabel: { formatter: "{value}%" } }], series: [{ name: "排产量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "top" }, data: [40, 60, 70, 80, 98, 40, 60, 70, 80, 98, 40, 60] }, { name: "完成量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "top" }, data: [20, 80, 40, 60, 58, 40, 80, 70, 120, 48, 60, 90] }] } });
  async function d(r) {
    try {
      i.value = true;
      const t = r || m(), a = t.getOption();
      t.on("click", function(e) {
        console.log(e, "params"), o.value = true;
      }), a.xAxis[0].data = content.map((e) => e.year), a.series[0].data = content.map((e) => e.averageDifferenceRatio), t.setOption(a);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      i.value = false;
    }
  }
  return (r, t) => {
    const a = x;
    return n(), c(f, null, [u((n(), c("div", { style: h({ height: s.maxHeight + "px" }) }, t[1] || (t[1] = [p("div", { id: "artifactSchedulingChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, i.value]]), g(v, { maxHeight: s.maxHeight, visible: o.value, "onUpdate:visible": t[0] || (t[0] = (e) => o.value = e) }, null, 8, ["maxHeight", "visible"])], 64);
  };
} };
export {
  B as default
};
