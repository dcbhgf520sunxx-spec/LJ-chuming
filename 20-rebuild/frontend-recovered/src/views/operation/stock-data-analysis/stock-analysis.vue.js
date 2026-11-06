import { ref as o } from "vue";
import { watch as g } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as d } from "vue";
import { withDirectives as b } from "vue";
import { normalizeStyle as v } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as k } from "vue";
import { Fragment as w } from "vue";
import { vLoading as C } from "element-plus";
import { f as S } from "../../../modules/stock-data-analysis-37c7a329.js";
import { u as q } from "../../../modules/use-chart-59e4b63c.js";
import { G as A } from "../../../shared/runtime.js";
import H from "./stock-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const B = { __name: "stock-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(s) {
  const r = o(false), l = o(false), m = o(), f = o(), c = s;
  g([() => c.query, () => m.value], (u) => {
    h();
  }, { deep: true });
  const { getMyChart: p } = q({ elementId: "monthlyStockAnalysisChart", fetchHook: h, initOption: { legend: { show: false }, custom: { title: [{ text: "仓库库存分析" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: true }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "库存", data: [], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#19be7a" } }] } });
  async function h(u) {
    var t;
    if (!A((t = c.permission) == null ? void 0 : t.get)) return false;
    try {
      r.value = true;
      const a = u || p(), e = await S({ ...c.query }), i = a.getOption();
      i.xAxis[0].data = e == null ? void 0 : e.map((n) => n.dateTime), i.series[0].data = e == null ? void 0 : e.map((n) => Math.round(n.amountExcludingVAT / 1e4)), a.setOption(i), a.on("click", function(n) {
        f.value = new Date(n.name).getTime(), l.value = true;
      });
    } catch (a) {
      console.log(a, "获取仓库库存分析图表失败");
    } finally {
      r.value = false;
    }
  }
  return (u, t) => {
    var e;
    const a = C;
    return y(), d(w, null, [b((y(), d("div", { style: v({ height: s.maxHeight + "px" }) }, t[1] || (t[1] = [x("div", { id: "monthlyStockAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, r.value]]), k(H, { maxHeight: s.maxHeight, visible: l.value, "onUpdate:visible": t[0] || (t[0] = (i) => l.value = i), query: s.query, basicClass: m.value, currentDate: f.value, branchInfo: s.branchInfo, permission: (e = s.permission) == null ? void 0 : e.stock }, null, 8, ["maxHeight", "visible", "query", "basicClass", "currentDate", "branchInfo", "permission"])], 64);
  };
} };
export {
  B as default
};
