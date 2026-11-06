import { ref as n } from "vue";
import { watch as d } from "vue";
import { nextTick as g } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as v } from "vue";
import { normalizeStyle as b } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as k } from "vue";
import { Fragment as x } from "vue";
import { vLoading as I } from "element-plus";
import { i as q } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { u as C } from "../../../modules/use-chart-59e4b63c.js";
import M from "./material-loss-analysis-detail.vue.js";
import "../../../shared/runtime.js";
import "../../../modules/index-18acf776.js";
const T = { __name: "material-loss-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, lossWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(o) {
  const l = n(), u = n(false), c = n(false), p = n(), i = o;
  d(() => i.query, (r) => {
    g(() => {
      l.value = i.query.workshopId || void 0, m();
    });
  }, { deep: true }), d(() => i.lossWorkshopId, (r) => {
    l.value = r || i.query.workshopId, m();
  }, { deep: true });
  const { getMyChart: y } = C({ elementId: "materialLossAnalysisChart", fetchHook: m, initOption: { legend: { show: false }, tooltip: { trigger: "item", show: true }, xAxis: { type: "category", axisTick: { show: true }, data: ["2020", "2021", "2022", "2023", "2024", "2025"] }, yAxis: { axisLabel: { formatter: "{value}%" } }, title: {}, series: [{ name: "", data: [0, 0, 0, 0, 0, 0], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function m(r) {
    try {
      u.value = true;
      const t = r || y(), a = await q({ ...i.query, workshopId: l.value }) || [], s = t.getOption();
      s.xAxis[0].data = a == null ? void 0 : a.map((e) => e.dateTime), s.series[0].data = a == null ? void 0 : a.map((e) => e.ratio ?? (e.outMete ? ((e.outMete - e.mete - e.sellMete) / e.outMete * 100).toFixed(2) : 0)), t.setOption(s), t.on("click", function(e) {
        p.value = new Date(e.name).getTime(), c.value = true;
      });
    } catch (t) {
      console.log(t, "获取主材损耗月份图表失败");
    } finally {
      u.value = false;
    }
  }
  return (r, t) => {
    var s;
    const a = I;
    return h(), f(x, null, [v((h(), f("div", { style: b({ height: o.maxHeight + "px" }) }, t[1] || (t[1] = [w("div", { id: "materialLossAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, u.value]]), k(M, { visible: c.value, "onUpdate:visible": t[0] || (t[0] = (e) => c.value = e), query: o.query, workshopId: l.value, searchDate: p.value, branchInfo: o.branchInfo, permission: (s = o.permission) == null ? void 0 : s.loss }, null, 8, ["visible", "query", "workshopId", "searchDate", "branchInfo", "permission"])], 64);
  };
} };
export {
  T as default
};
