import { ref as c } from "vue";
import { watch as V } from "vue";
import { onMounted as F } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as C } from "vue";
import { withDirectives as S } from "vue";
import { normalizeStyle as w } from "vue";
import { Fragment as j } from "vue";
import { ElDivider as z } from "element-plus";
import { vLoading as D } from "element-plus";
import { a as M, g as L } from "../../../modules/stock-data-analysis-37c7a329.js";
import { u as O } from "../../../modules/use-chart-59e4b63c.js";
import { i as k } from "../../../shared/runtime.js";
import T from "./auxiliary-outbound-and-inbound-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const $ = { style: { display: "flex", "align-items": "center" } }, E = { style: { display: "flex" } }, P = { __name: "auxiliary-outbound-and-inbound-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(r) {
  const d = c(false), h = c(false), x = c({}), y = c(), p = c([]), v = r;
  V([() => v.query, () => y.value], (l) => {
    I(), A();
  }, { deep: true }), F(() => {
    B();
  });
  const { getMyChart: q } = O({ elementId: "auxiliaryInboundAndOutboundSummaryAnalysisChart", fetchHook: A, initOption: { legend: { show: false }, xAxis: { axisTick: { show: false }, data: ["入库", "出库"] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ data: [], type: "bar", barWidth: "50%", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#009dff" } }] } });
  async function B() {
    try {
      const l = await M();
      p.value = l || [];
    } catch (l) {
      console.log(l, "获取辅材类型列表");
    }
  }
  const { getMyChart: H } = O({ elementId: "auxiliaryInboundAndOutboundAnalysisChart", fetchHook: I, initOption: { legend: { show: false }, custom: { title: [{ text: "" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "辅材入库", data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "left" }, itemStyle: { color: "#1ec07d" } }, { name: "辅材出库", data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "right" }, itemStyle: { color: "#34dfe3" } }] } });
  async function A(l) {
    var t, u;
    try {
      d.value = true;
      const s = l || q(), e = await L({ ...v.query, classifyId: y.value }), a = s.getOption(), o = (t = e == null ? void 0 : e.inCostList) == null ? void 0 : t.reduce((m, i) => k(i == null ? void 0 : i.totalCost) ? m + (i == null ? void 0 : i.totalCost) : i, 0), n = (u = e == null ? void 0 : e.outCostList) == null ? void 0 : u.reduce((m, i) => k(i == null ? void 0 : i.totalCost) ? m + (i == null ? void 0 : i.totalCost) : i, 0);
      a.series[0].data = [(o / 1e4).toFixed(4), (n / 1e4).toFixed(4)], s.setOption(a), s.on("click", function(m) {
        h.value = true, x.value = m;
      });
    } catch (s) {
      console.log(s, "获取柱状图失败");
    } finally {
      d.value = false;
    }
  }
  async function I(l) {
    var t, u, s;
    try {
      d.value = true;
      const e = l || H(), a = await L({ ...v.query, classifyId: y.value }), o = e.getOption();
      o.xAxis[0].data = (t = a == null ? void 0 : a.inCostList) == null ? void 0 : t.map((n) => n.dateTime), o.series[0].data = (u = a == null ? void 0 : a.inCostList) == null ? void 0 : u.map((n) => (n.totalCost / 1e4).toFixed(4)), o.series[1].data = (s = a == null ? void 0 : a.outCostList) == null ? void 0 : s.map((n) => (n.totalCost / 1e4).toFixed(4)), e.setOption(o), e.on("click", function(n) {
        h.value = true, x.value = n;
      });
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      d.value = false;
    }
  }
  return (l, t) => {
    var a;
    const u = N("common-select-v2"), s = z, e = D;
    return b(), g(j, null, [f("div", $, [t[2] || (t[2] = f("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "辅材出入库数据统计", -1)), C(u, { modelValue: y.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => y.value = o), options: p.value, dataStructure: { value: "classifyId", label: "name", key: "classifyId" }, type: "other", clearable: "", filterable: "", style: { width: "200px", "margin-left": "10px" }, placeholder: "选择辅材" }, null, 8, ["modelValue", "options"])]), f("div", E, [S((b(), g("div", { style: w({ height: r.maxHeight + "px", width: "30%" }) }, t[3] || (t[3] = [f("div", { id: "auxiliaryInboundAndOutboundSummaryAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, d.value]]), C(s, { direction: "vertical", style: w(`height: ${r.maxHeight}px`) }, null, 8, ["style"]), S((b(), g("div", { style: w(` width: 70%;height: ${r.maxHeight}px`) }, t[4] || (t[4] = [f("div", { id: "auxiliaryInboundAndOutboundAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, d.value]])]), C(T, { visible: h.value, "onUpdate:visible": t[1] || (t[1] = (o) => h.value = o), "auxiliary-data": x.value, query: r.query, classifyId: y.value, auxList: p.value, branchInfo: r.branchInfo, permission: (a = r.permission) == null ? void 0 : a.auxiliary }, null, 8, ["visible", "auxiliary-data", "query", "classifyId", "auxList", "branchInfo", "permission"])], 64);
  };
} };
export {
  P as default
};
