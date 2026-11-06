import { ref as l } from "vue";
import { watch as p } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as h } from "vue";
import { normalizeStyle as v } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as g } from "vue";
import { Fragment as b } from "vue";
import { vLoading as S } from "element-plus";
import { j as k } from "../../../modules/stock-data-analysis-37c7a329.js";
import { u as w } from "../../../modules/use-chart-59e4b63c.js";
import { c as q } from "../../../shared/runtime.js";
import C from "./remain-stock-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const L = { __name: "remain-stock-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(s) {
  const n = l(false), o = l(false), y = l(false), c = s;
  p(() => c.query, (r) => {
    m();
  }, { deep: true });
  const { getMyChart: d } = w({ elementId: "remainStockAnalysisChart", fetchHook: m, initOption: { legend: { show: false }, custom: { title: [{ text: "余料库存分析" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "余料库存", data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#1ec07d" } }] } });
  async function m(r) {
    try {
      n.value = true;
      const e = r || d(), t = await k({ ...c.query }), i = e.getOption();
      i.xAxis[0].data = t == null ? void 0 : t.map((a) => a.dateTime), i.series[0].data = t == null ? void 0 : t.map((a) => q(a.mete, "g", "t", 0)), e.setOption(i), e.on("click", function(a) {
        o.value = true, y.value = a;
      });
    } catch (e) {
      console.log(e, "获取余料库存分析失败");
    } finally {
      n.value = false;
    }
  }
  return (r, e) => {
    var i;
    const t = S;
    return u(), f(b, null, [h((u(), f("div", { style: v({ height: s.maxHeight + "px" }) }, e[1] || (e[1] = [x("div", { id: "remainStockAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[t, n.value]]), g(C, { visible: o.value, "onUpdate:visible": e[0] || (e[0] = (a) => o.value = a), query: s.query, branchInfo: s.branchInfo, permission: (i = s.permission) == null ? void 0 : i.remain }, null, 8, ["visible", "query", "branchInfo", "permission"])], 64);
  };
} };
export {
  L as default
};
