import { ref as c } from "vue";
import { watch as b } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as k } from "vue";
import { normalizeStyle as p } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as O } from "vue";
import { Fragment as C } from "vue";
import { vLoading as L } from "element-plus";
import { f as M } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { p as t, c as q } from "../../../shared/runtime.js";
import { u as j } from "../../../modules/use-chart-59e4b63c.js";
import N from "./workshop-monthly-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const E = { __name: "workshop-monthly-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, productWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(s) {
  const l = c(), d = c(false), m = c(false), r = c(), e = s, { getMyChart: x } = j({ elementId: "workshopMonthlyChart", fetchHook: g, initOption: { legend: { show: true }, xAxis: { axisTick: { show: true }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "车间月度产量统计", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ name: "", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }, { name: "", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#22e4ff" } }, { name: "", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#3bffd0" } }] } });
  b(() => e.query, (o) => {
    l.value = e.query.workshopId || void 0, g();
  }, { deep: true }), b(() => e.productWorkshopId, (o) => {
    l.value = o || e.query.workshopId, g();
  }, { deep: true });
  async function g(o) {
    var i, D, u;
    try {
      d.value = true;
      const y = o || x(), n = await M({ ...e.query, workshopId: l.value }) || {}, w = y.getOption(), h = t(e.query.yearDate, "{y}"), f = [{ name: h, data: (i = n == null ? void 0 : n.currentList) == null ? void 0 : i.map((a) => q(a.mete, "kg", "t", 0)) }, { name: String(h - 1), data: (D = n == null ? void 0 : n.lastList) == null ? void 0 : D.map((a) => q(a.mete, "kg", "t", 0)) }, { name: String(h - 2), data: (u = n == null ? void 0 : n.frontList) == null ? void 0 : u.map((a) => q(a.mete, "kg", "t", 0)) }];
      w.series.forEach((a, v) => {
        Object.assign(a, f[v]);
      }), w.legend.data = f.map((a) => a.name), y.setOption(w, true), y.on("click", function(a) {
        switch (a.name) {
          case "1月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-01")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-01")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-01")).getTime();
            break;
          case "2月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-02")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-02")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-02")).getTime();
            break;
          case "3月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-03")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-03")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-03")).getTime();
            break;
          case "4月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-04")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-04")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-04")).getTime();
            break;
          case "5月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-05")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-05")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-05")).getTime();
            break;
          case "6月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-06")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-06")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-06")).getTime();
            break;
          case "7月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-07")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-07")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-07")).getTime();
            break;
          case "8月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-08")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-08")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-08")).getTime();
            break;
          case "9月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-09")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-09")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-09")).getTime();
            break;
          case "10月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-10")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-10")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-10")).getTime();
            break;
          case "11月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-11")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-11")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-11")).getTime();
            break;
          case "12月":
            r.value = a.seriesIndex === 2 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 2 + "-12")).getTime() : a.seriesIndex === 1 ? (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") - 1 + "-12")).getTime() : (/* @__PURE__ */ new Date(t(e.query.yearDate, "{y}") + "-12")).getTime();
            break;
          default:
            break;
        }
        m.value = true;
      });
    } catch (y) {
      console.log(y, "获取车间月度产量统计失败");
    } finally {
      d.value = false;
    }
  }
  return (o, i) => {
    var u;
    const D = L;
    return T(), I(C, null, [k((T(), I("div", { style: p({ height: s.maxHeight + "px" }) }, i[1] || (i[1] = [S("div", { id: "workshopMonthlyChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[D, d.value]]), O(N, { visible: m.value, "onUpdate:visible": i[0] || (i[0] = (y) => m.value = y), query: s.query, workshopId: l.value, searchDate: r.value, branchInfo: s.branchInfo, permission: (u = s.permission) == null ? void 0 : u.workshopMete }, null, 8, ["visible", "query", "workshopId", "searchDate", "branchInfo", "permission"])], 64);
  };
} };
export {
  E as default
};
