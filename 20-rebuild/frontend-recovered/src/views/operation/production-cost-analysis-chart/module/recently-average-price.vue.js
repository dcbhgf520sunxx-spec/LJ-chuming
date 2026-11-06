import { ref as p } from "vue";
import { watch as f } from "vue";
import { withDirectives as u } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as h } from "vue";
import { normalizeStyle as g } from "vue";
import { vLoading as x } from "element-plus";
import { b as v } from "../../../../modules/production-cost-analysis-chart-d811fbd9.js";
import { u as w } from "../../../../modules/use-chart-59e4b63c.js";
import { G as b } from "../../../../shared/runtime.js";
import "../../../../modules/index-18acf776.js";
const _ = { __name: "recently-average-price", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(l) {
  const i = p(false), r = l;
  f(() => r.query, (s) => {
    c();
  }, { deep: true });
  const { getMyChart: m } = w({ elementId: "rencentlyAveragePrice", fetchHook: c, initOption: { legend: { show: false }, custom: { title: [{ text: "近三年综合平均单价" }, { text: "单位：元/吨", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ data: [], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#009dff" } }] } });
  async function c(s) {
    var a;
    if (!b((a = r.permission) == null ? void 0 : a.get)) return false;
    try {
      i.value = true;
      const e = s || m(), t = await v({ ...r.query }), o = e.getOption();
      o.xAxis[0].data = t == null ? void 0 : t.map((n) => n.dateTime), o.series[0].data = t == null ? void 0 : t.map((n) => n.avgCost), e.setOption(o);
    } catch (e) {
      console.log(e, "获取柱状图失败");
    } finally {
      i.value = false;
    }
  }
  return (s, a) => {
    const e = x;
    return u((d(), y("div", { style: g({ height: l.maxHeight + "px" }) }, a[0] || (a[0] = [h("div", { id: "rencentlyAveragePrice", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, i.value]]);
  };
} };
export {
  _ as default
};
