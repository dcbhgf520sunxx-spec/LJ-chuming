import { ref as x } from "vue";
import { watch as q } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as w } from "vue";
import { unref as d } from "vue";
import { withDirectives as I } from "vue";
import { normalizeStyle as S } from "vue";
import { Fragment as F } from "vue";
import { ElDivider as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { h as T } from "../../../modules/stock-data-analysis-37c7a329.js";
import { G as U, i as L, sB as u } from "../../../shared/runtime.js";
import { u as k } from "../../../modules/use-chart-59e4b63c.js";
import H from "./steel-outbound-and-inbound-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const K = { style: { display: "flex", "align-items": "center" } }, V = { style: { display: "flex" } }, X = { __name: "steel-outbound-and-inbound-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(o) {
  const m = x(false), b = x(false), y = x(), g = x({}), c = o;
  q([() => c.query, () => y.value], (p) => {
    O(), M();
  }, { deep: true });
  const { getMyChart: E } = k({ elementId: "steelInboundAndOutboundAnalysisSummaryChart", fetchHook: M, initOption: { legend: { show: false }, xAxis: { axisTick: { show: false }, data: ["入库", "出库"] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ data: [], type: "bar", barWidth: "50%", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#009dff" } }] } }), { getMyChart: N } = k({ elementId: "steelInboundAndOutboundAnalysisChart", fetchHook: O, initOption: { legend: { show: false }, custom: { title: [{ text: "" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "钢材入库", data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "left" }, itemStyle: { color: "#1ec07d" } }, { name: "钢材出库", data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "right" }, itemStyle: { color: "#34dfe3" } }] } });
  async function M(p) {
    var e, l, r;
    if (!U((e = c.permission) == null ? void 0 : e.get)) return false;
    try {
      m.value = true;
      const a = p || E(), s = await T({ ...c.query, basicClass: y.value }), t = a.getOption(), f = (l = s == null ? void 0 : s.inMeteList) == null ? void 0 : l.reduce((h, i) => L(i == null ? void 0 : i.totalMete) ? h + (i == null ? void 0 : i.totalMete) : i, 0), n = (r = s == null ? void 0 : s.outMeteList) == null ? void 0 : r.reduce((h, i) => L(i == null ? void 0 : i.totalMete) ? h + (i == null ? void 0 : i.totalMete) : i, 0);
      t.series[0].data = [(f / 1e4).toFixed(0), (n / 1e4).toFixed(0)], a.setOption(t), a.on("click", function(h) {
        b.value = true, g.value = h;
      });
    } catch (a) {
      console.log(a, "获取柱状图失败");
    } finally {
      m.value = false;
    }
  }
  async function O(p) {
    var e, l, r, a;
    if (!U((e = c.permission) == null ? void 0 : e.get)) return false;
    try {
      m.value = true;
      const s = p || N(), t = await T({ ...c.query, basicClass: y.value }), f = s.getOption();
      f.xAxis[0].data = (l = t == null ? void 0 : t.inMeteList) == null ? void 0 : l.map((n) => n.dateTime), f.series[0].data = (r = t == null ? void 0 : t.inMeteList) == null ? void 0 : r.map((n) => (n.totalMete / 1e4).toFixed(0)), f.series[1].data = (a = t == null ? void 0 : t.outMeteList) == null ? void 0 : a.map((n) => (n.totalMete / 1e4).toFixed(0)), s.setOption(f), s.on("click", function(n) {
        b.value = true, g.value = n;
      });
    } catch (s) {
      console.log(s, "获取差异分析柱状图失败");
    } finally {
      m.value = false;
    }
  }
  return (p, e) => {
    var s;
    const l = B("common-select"), r = R, a = D;
    return A(), C(F, null, [v("div", K, [e[2] || (e[2] = v("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "钢材出入库数据统计", -1)), w(l, { modelValue: y.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => y.value = t), options: d(u).ENUM, class: "filter-item", clearable: "", unshowOptions: [d(u).PRODUCTION_AUXILIARY_MATERIALS.K, d(u).GAS.K, d(u).STRUC_MANUFACTURED.K, d(u).ENCL_MANUFACTURED.K, d(u).OTHER.K, d(u).AUX_MANUFACTURED.K], placeholder: "选择钢材", style: { width: "200px", "margin-left": "10px" }, type: "enum" }, null, 8, ["modelValue", "options", "unshowOptions"])]), v("div", V, [I((A(), C("div", { style: S({ height: o.maxHeight + "px", width: "30%" }) }, e[3] || (e[3] = [v("div", { id: "steelInboundAndOutboundAnalysisSummaryChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, m.value]]), w(r, { direction: "vertical", style: S(`height: ${o.maxHeight}px`) }, null, 8, ["style"]), I((A(), C("div", { style: S(` width: 70%;height: ${o.maxHeight}px`) }, e[4] || (e[4] = [v("div", { id: "steelInboundAndOutboundAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, m.value]])]), w(H, { visible: b.value, "onUpdate:visible": e[1] || (e[1] = (t) => b.value = t), query: o.query, "steel-data": g.value, basicClassType: y.value, branchInfo: o.branchInfo, permission: (s = o.permission) == null ? void 0 : s.steel }, null, 8, ["visible", "query", "steel-data", "basicClassType", "branchInfo", "permission"])], 64);
  };
} };
export {
  X as default
};
