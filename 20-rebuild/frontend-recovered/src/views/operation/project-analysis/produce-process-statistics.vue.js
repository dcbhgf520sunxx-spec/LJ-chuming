import { ref as l } from "vue";
import h from "moment";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as v } from "vue";
import { normalizeStyle as g } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as y } from "vue";
import { Fragment as x } from "vue";
import { ElDatePicker as b } from "element-plus";
import { vLoading as k } from "element-plus";
import { u as A } from "../../../modules/use-chart-59e4b63c.js";
import _ from "./product-process-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const N = { __name: "produce-process-statistics", props: { maxHeight: { type: [Number, String], default: void 0 }, projectId: { type: Number } }, setup(r) {
  const o = l(false), s = l(false), n = l(h().valueOf()), { getMyChart: u } = A({ elementId: "produceProcessAnalysisChart", fetchHook: f, initOption: { legend: { show: false }, xAxis: { axisTick: { show: true }, data: ["09-01", "09-02", "09-03", "09-04", "09-05", "09-06", "09-07", "09-08", "09-09", "09-10", "09-11", "09-12", "09-13", "09-14", "09-15", "09-16", "09-17", "09-18", "09-19", "09-20", "09-21", "09-22", "09-23", "09-24", "09-25", "09-26", "09-27", "09-28", "09-29", "09-30"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "生产加工统计" }, series: [{ name: "", data: [4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#F4A80A" } }] } });
  async function f(c) {
    try {
      o.value = true;
      const e = c || u(), a = e.getOption();
      e.on("click", function(t) {
        console.log(t, "params"), s.value = true;
      }), a.xAxis[0].data = content.map((t) => t.year), a.series[0].data = content.map((t) => t.averageDifferenceRatio), e.setOption(a);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      o.value = false;
    }
  }
  return (c, e) => {
    const a = b, t = k;
    return m(), p(x, null, [v((m(), p("div", { style: g({ height: r.maxHeight + "px" }) }, [d(a, { modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => n.value = i), type: "month", size: "small", class: "date-item filter-item", style: { width: "130px", float: "right", "z-index": "100", "margin-right": "8px" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x" }, null, 8, ["modelValue"]), e[2] || (e[2] = y("div", { id: "produceProcessAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1))], 4)), [[t, o.value]]), d(_, { projectId: r.projectId, visible: s.value, "onUpdate:visible": e[1] || (e[1] = (i) => s.value = i) }, null, 8, ["projectId", "visible"])], 64);
  };
} };
export {
  N as default
};
