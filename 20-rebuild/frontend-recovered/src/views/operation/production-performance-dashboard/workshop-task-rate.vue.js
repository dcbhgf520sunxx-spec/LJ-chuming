import { ref as l } from "vue";
import { watch as h } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as b } from "vue";
import { normalizeStyle as g } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as x } from "vue";
import { Fragment as I } from "vue";
import { vLoading as q } from "element-plus";
import { b as T } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { c as k, p as A } from "../../../shared/runtime.js";
import { u as C } from "../../../modules/use-chart-v2-ba3ec3fa.js";
import D from "./workshop-task-rate-detail.vue.js";
import "../../../modules/index-18acf776.js";
const F = { __name: "workshop-task-rate", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, taskWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(i) {
  const n = l(), u = l(false), c = l(false), d = l(), a = i;
  h(() => a.query, (r) => {
    n.value = a.query.workshopId || void 0, p();
  }, { deep: true }), h(() => a.taskWorkshopId, (r) => {
    n.value = a.query.workshopId || r, p();
  }, { deep: true });
  const { getMyChart: v } = C({ elementId: "workshopTaskRateChart", fetchHook: p, initOption: { legend: { show: true }, xAxis: { axisTick: { show: true }, type: "category", data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: [{ type: "value", name: "", min: 0, alignTicks: true, axisLabel: { formatter: "{value}" } }, { type: "value", name: "", min: 0, axisLabel: { formatter: "{value}%" } }], title: {}, series: [{ name: "排产量", data: [10, 20, 30, 40, 50, 60, 70, 50, 40, 30, 20, 10], type: "bar", yAxisIndex: 0, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }, { name: "实际完成", data: [10, 20, 30, 40, 50, 60, 70, 50, 40, 30, 20, 10], type: "bar", yAxisIndex: 0, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#22e4ff" } }, { name: "达成率", data: [10, 20, 30, 40, 50, 60, 70, 50, 40, 30, 20, 10], type: "line", yAxisIndex: 1, label: { show: true, distance: 10, position: "top" }, itemStyle: { color: "#F4A80A" } }] } });
  async function p(r) {
    try {
      u.value = true;
      const t = r || v(), o = t.getOption(), s = await T({ ...a.query, workshopId: n.value }) || {};
      o.series[0].data = s.map((e) => k(e.taskMete, "kg", "t", 0)), o.series[1].data = s.map((e) => k(e.mete, "kg", "t", 0)), o.series[2].data = s.map((e) => {
        var m;
        return (m = e.ratio) == null ? void 0 : m.toFixed(2);
      }), t.setOption(o), t.on("click", function(e) {
        d.value = (/* @__PURE__ */ new Date(A(a.query.yearDate, "{y}") + "-" + (e.name.slice(0, e.name.length - 1) < 10 ? "0" + e.name.slice(0, e.name.length - 1) : e.name.slice(0, e.name.length - 1)))).getTime(), c.value = true;
      });
    } catch (t) {
      console.log(t, "获取车间月度任务达成率图表失败");
    } finally {
      u.value = false;
    }
  }
  return (r, t) => {
    var s;
    const o = q;
    return y(), f(I, null, [b((y(), f("div", { style: g({ height: i.maxHeight + "px" }) }, t[1] || (t[1] = [w("div", { id: "workshopTaskRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, u.value]]), x(D, { visible: c.value, "onUpdate:visible": t[0] || (t[0] = (e) => c.value = e), query: i.query, workshopId: n.value, searchDate: d.value, branchInfo: i.branchInfo, permission: (s = i.permission) == null ? void 0 : s.workshopTask }, null, 8, ["visible", "query", "workshopId", "searchDate", "branchInfo", "permission"])], 64);
  };
} };
export {
  F as default
};
