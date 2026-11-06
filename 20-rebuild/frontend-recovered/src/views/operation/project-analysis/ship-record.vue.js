import { ref as o } from "vue";
import v from "moment";
import { openBlock as m } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as g } from "vue";
import { normalizeStyle as x } from "vue";
import { createVNode as p } from "vue";
import { createElementVNode as y } from "vue";
import { Fragment as b } from "vue";
import { ElDatePicker as k } from "element-plus";
import { vLoading as _ } from "element-plus";
import { u as w } from "../../../modules/use-chart-59e4b63c.js";
import C from "./ship-record-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const N = { __name: "ship-record", props: { maxHeight: [Number, String], default: void 0, projectId: { type: Number } }, setup(r) {
  const i = o(false), l = o(false), n = o({}), d = o(v().valueOf()), { getMyChart: f } = w({ elementId: "shipRecordChart", fetchHook: h, initOption: { legend: { show: false }, xAxis: { axisTick: { show: true }, data: ["09-01", "09-02", "09-03", "09-04", "09-05", "09-06", "09-07", "09-08", "09-09", "09-10", "09-11", "09-12", "09-13", "09-14", "09-15", "09-16", "09-17", "09-18", "09-19", "09-20", "09-21", "09-22", "09-23", "09-24", "09-25", "09-26", "09-27", "09-28", "09-29", "09-30"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "生产加工统计" }, series: [{ name: "", data: [4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98, 4, 6, 7, 8, 98], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#F4A80A" } }] } });
  async function h(c) {
    try {
      i.value = true;
      const e = c || f(), a = e.getOption();
      e.on("click", function(t) {
        console.log(t, "params"), n.value = t, l.value = true;
      }), a.xAxis[0].data = content.map((t) => t.year), a.series[0].data = content.map((t) => t.averageDifferenceRatio), e.setOption(a);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      i.value = false;
    }
  }
  return (c, e) => {
    const a = k, t = _;
    return m(), u(b, null, [g((m(), u("div", { style: x({ height: r.maxHeight + "px" }) }, [p(a, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (s) => d.value = s), type: "month", size: "small", class: "date-item filter-item", style: { width: "130px", float: "right", "z-index": "100", "margin-right": "8px" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x" }, null, 8, ["modelValue"]), e[2] || (e[2] = y("div", { id: "shipRecordChart", style: { width: "100%", height: "100%" } }, null, -1))], 4)), [[t, i.value]]), p(C, { visible: l.value, "onUpdate:visible": e[1] || (e[1] = (s) => l.value = s), "detail-data": n.value, projectId: r.projectId }, null, 8, ["visible", "detail-data", "projectId"])], 64);
  };
} };
export {
  N as default
};
