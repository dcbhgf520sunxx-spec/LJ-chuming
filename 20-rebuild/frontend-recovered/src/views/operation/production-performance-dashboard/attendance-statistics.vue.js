import { ref as p } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as F } from "vue";
import { normalizeStyle as v } from "vue";
import { createVNode as O } from "vue";
import { Fragment as k } from "vue";
import { vLoading as I } from "element-plus";
import { u as b } from "../../../modules/use-chart-59e4b63c.js";
import N from "./attendance-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../shared/runtime.js";
const H = { style: { display: "flex" } }, T = { __name: "attendance-statistics", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, lossWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(l) {
  const s = p(false), f = p(false), { getMyChart: w } = b({ elementId: "attendanceStatisticsCircleChart", fetchHook: C, initOption: { grid: { top: "20" }, color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { text: "年龄统计", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, tooltip: { trigger: "item", appendToBody: true, position: function(e, t, o, a, i) {
    var n = 0, r = 0, c = e[0], u = e[1], m = i.contentSize[0], h = i.contentSize[1];
    return m > c ? n = 5 : n = c - m, h > u ? r = 5 : r = u - h, [n, r];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "horizontal", type: "scroll", top: 15, left: "center", formatter: function(e) {
    let t = "";
    const o = e.length, a = 15, i = Math.ceil(o / a);
    if (o > a) for (let n = 0; n < i; n++) {
      const r = n * a, c = r + a, u = n === i - 1 ? e.substring(r, o) : e.substring(r, c) + `
`;
      t += u;
    }
    else t = e;
    return t;
  } }, series: [{ type: "pie", radius: [30, 80], roseType: "area", center: ["50%", "60%"], itemStyle: { borderRadius: 8 }, data: [{ name: "<30", value: "30" }, { name: "30~40", value: "30" }, { name: "40~50", value: "15" }, { name: "50~60", value: "30" }, { name: ">60", value: "30" }], label: { formatter: (e) => `${e.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } }), { getMyChart: x } = b({ elementId: "attendanceStatisticsColumnChart", fetchHook: S, initOption: { legend: { show: true }, xAxis: { axisTick: { show: false }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "考勤统计", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ name: "在册人数", data: [40, 60, 70, 80, 98, 40, 60, 70, 80, 98, 40, 60], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }, { name: "考勤人数", data: [40, 60, 70, 80, 98, 40, 60, 70, 80, 98, 40, 60], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#22e4ff" } }] } });
  async function C(e) {
    try {
      s.value = true;
      const t = e || w();
      t.on("click", function(i) {
        console.log(i, "params"), f.value = true;
      });
      const { content: o } = await getDiffAverageAnalysis({ range: 10 }), a = t.getOption();
      a.series[0].data = [{ name: "焊接H型构件", value: "30%" }], t.setOption(a);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      s.value = false;
    }
  }
  async function S(e) {
    try {
      s.value = true;
      const t = e || x(), { content: o } = await getDiffAverageAnalysis({ range: 10 }), a = t.getOption();
      a.series[0].data = [{ name: "焊接H型构件", value: "30%" }], t.setOption(a);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      s.value = false;
    }
  }
  return (e, t) => {
    const o = I;
    return y(), g(k, null, [d("div", H, [F((y(), g("div", { style: v({ height: l.maxHeight + "px", width: "29%" }) }, t[1] || (t[1] = [d("div", { id: "attendanceStatisticsCircleChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, s.value]]), d("div", { style: v(`width: 70%;;height: ${l.maxHeight}px`) }, t[2] || (t[2] = [d("div", { id: "attendanceStatisticsColumnChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), O(N, { visible: f.value, "onUpdate:visible": t[0] || (t[0] = (a) => f.value = a), query: l.query, workshopId: e.workshopId, branchInfo: l.branchInfo }, null, 8, ["visible", "query", "workshopId", "branchInfo"])], 64);
  };
} };
export {
  T as default
};
