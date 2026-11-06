import { ref as x } from "vue";
import { watch as A } from "vue";
import { nextTick as T } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as C } from "vue";
import { normalizeStyle as c } from "vue";
import { createVNode as b } from "vue";
import { Fragment as q } from "vue";
import { ElDivider as H } from "element-plus";
import { vLoading as M } from "element-plus";
import { i as w } from "../../../modules/stock-data-analysis-37c7a329.js";
import { G as S, i as k } from "../../../shared/runtime.js";
import { u as z } from "../../../modules/use-chart-59e4b63c.js";
import { u as F } from "../../../modules/use-chart-v2-ba3ec3fa.js";
import B from "./stock-turnover-detail.vue.js";
import "../../../modules/index-18acf776.js";
const L = { style: { display: "flex" } }, Y = { __name: "stock-turnover", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(n) {
  const l = x(false), h = x(false), u = n;
  A(() => u.query, (m) => {
    T(() => {
      p(), v();
    });
  }, { deep: true });
  const { getMyChart: I } = z({ elementId: "allYearTrunoverChart", fetchHook: v, initOption: { legend: { show: false }, tooltip: { trigger: "item", show: false }, custom: { title: { text: "平均库存周转率", right: 0, textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } } }, series: [{ type: "pie", radius: ["40%", "70%"], label: { normal: { show: true, position: "center", textStyle: { fontSize: 16, fontWeight: "bold" }, formatter: "{c}%" } }, data: [{ label: { normal: { show: true } } }, { itemStyle: { color: "#f1f1f1" }, label: { normal: { show: false } } }] }] } }), { getMyChart: O } = F({ elementId: "allMonthTrunoverChart", fetchHook: p, initOption: { legend: { show: true }, custom: { title: [{ text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: true }, type: "category", data: [] }, yAxis: [{ type: "value", name: "", min: 0, alignTicks: true, axisLabel: { formatter: "{value}" } }, { type: "value", name: "", min: 0, axisLabel: { formatter: "{value}%" } }], series: [{ name: "入库金额", data: [], type: "bar", yAxisIndex: 0, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }, { name: "出库金额", data: [], type: "bar", yAxisIndex: 0, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#22e4ff" } }, { name: "库存周转率", data: [], type: "line", yAxisIndex: 1, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#F4A80A" } }] } });
  async function p(m) {
    var o;
    if (!S((o = u.permission) == null ? void 0 : o.get)) return false;
    try {
      l.value = true;
      const a = m || O(), i = a.getOption(), e = await w({ ...u.query });
      i.xAxis[0].data = e == null ? void 0 : e.map((t) => t.dateTime), i.series[0].data = e == null ? void 0 : e.map((t) => Math.round(t.inCost / 1e4)), i.series[1].data = e == null ? void 0 : e.map((t) => Math.round(t.outCost / 1e4)), i.series[2].data = e == null ? void 0 : e.map((t) => t.outCost && t.inCost ? (t.outCost / t.inCost * 100).toFixed(2) : 0), a.setOption(i);
    } catch (a) {
      console.log(a, "获取月度库存周转率失败");
    } finally {
      l.value = false;
    }
  }
  async function v(m) {
    var o;
    if (!S((o = u.permission) == null ? void 0 : o.get)) return false;
    try {
      l.value = true;
      const a = m || I(), i = a.getOption(), e = await w({ ...u.query }), t = e == null ? void 0 : e.reduce((r, s) => k(s == null ? void 0 : s.inCost) ? r + (s == null ? void 0 : s.inCost) : r, 0), g = e == null ? void 0 : e.reduce((r, s) => k(s == null ? void 0 : s.outCost) ? r + (s == null ? void 0 : s.outCost) : r, 0);
      i.series[0].data[0].value = g && t ? (g / t * 100).toFixed(2) : 0, i.series[0].data[1].value = 100 - i.series[0].data[0].value, a.setOption(i), a.on("click", function(r) {
        h.value = true;
      });
    } catch (a) {
      console.log(a, "获取年度库存周转率失败");
    } finally {
      l.value = false;
    }
  }
  return (m, o) => {
    var e;
    const a = H, i = M;
    return d(), y(q, null, [o[3] || (o[3] = f("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "库存周转率", -1)), f("div", L, [C((d(), y("div", { style: c({ height: n.maxHeight + "px", width: "30%" }) }, o[1] || (o[1] = [f("div", { id: "allYearTrunoverChart", style: { width: "100%", height: "90%" } }, null, -1)]), 4)), [[i, l.value]]), b(a, { direction: "vertical", style: c(`height: ${n.maxHeight}px`) }, null, 8, ["style"]), C((d(), y("div", { style: c(`width: 70%;height: ${n.maxHeight}px`) }, o[2] || (o[2] = [f("div", { id: "allMonthTrunoverChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, l.value]]), b(B, { visible: h.value, "onUpdate:visible": o[0] || (o[0] = (t) => h.value = t), query: n.query, branchInfo: n.branchInfo, permission: (e = n.permission) == null ? void 0 : e.turnover }, null, 8, ["visible", "query", "branchInfo", "permission"])])], 64);
  };
} };
export {
  Y as default
};
