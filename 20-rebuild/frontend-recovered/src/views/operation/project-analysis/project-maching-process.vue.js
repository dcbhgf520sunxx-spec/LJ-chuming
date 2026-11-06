import { ref as n } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as h } from "vue";
import { normalizeStyle as p } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as g } from "vue";
import { Fragment as f } from "vue";
import { vLoading as x } from "element-plus";
import { u as y } from "../../../modules/use-chart-v2-ba3ec3fa.js";
import v from "./product-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const H = { __name: "project-maching-process", props: { maxHeight: { type: [Number, String], default: void 0 }, projectId: { type: Number } }, setup(i) {
  const o = n(false), r = n(false), { getMyChart: m } = y({ elementId: "projectMachingProcessChart", fetchHook: d, initOption: { grid: { right: "20" }, legend: { data: ["清单量", "完成量"], left: "center" }, custom: { title: [{ text: "项目加工进度" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, yAxis: [{ data: ["零件生产", "部件生产", "构件生产"], axisLabel: { rotate: 45 } }], xAxis: { axisLabel: { formatter: "{value}%" } }, series: [{ name: "清单量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right" }, data: [10, 20] }, { name: "完成量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right" }, data: [20, 30] }] } });
  async function d(s) {
    try {
      o.value = true;
      const t = s || m(), a = t.getOption();
      t.on("click", function(e) {
        console.log(e, "params"), r.value = true;
      }), a.xAxis[0].data = content.map((e) => e.year), a.series[0].data = content.map((e) => e.averageDifferenceRatio), t.setOption(a);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      o.value = false;
    }
  }
  return (s, t) => {
    const a = x;
    return l(), c(f, null, [h((l(), c("div", { style: p({ height: i.maxHeight + "px" }) }, t[1] || (t[1] = [u("div", { id: "projectMachingProcessChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, o.value]]), g(v, { maxHeight: i.maxHeight, projectId: i.projectId, visible: r.value, "onUpdate:visible": t[0] || (t[0] = (e) => r.value = e) }, null, 8, ["maxHeight", "projectId", "visible"])], 64);
  };
} };
export {
  H as default
};
