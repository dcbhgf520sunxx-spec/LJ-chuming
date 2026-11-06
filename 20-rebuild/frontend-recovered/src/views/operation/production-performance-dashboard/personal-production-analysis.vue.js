import { ref as h } from "vue";
import { onMounted as k } from "vue";
import { watch as f } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as i } from "vue";
import { normalizeStyle as v } from "vue";
import { toDisplayString as x } from "vue";
import { withDirectives as I } from "vue";
import { vLoading as P } from "element-plus";
import { j as C, k as S } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { _ as q, c as w } from "../../../shared/runtime.js";
import { u as A } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const z = { class: "personal_chart", style: { display: "flex" } }, L = { style: { width: "29%" } }, H = { class: "title_color title_size" }, O = { class: "title_size" }, j = { __name: "personal-production-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, personalWorkshopId: { type: Number } }, setup(c) {
  const r = h(), d = h(false), u = h({}), n = c;
  k(() => {
    m();
  }), f(() => n.query, (e) => {
    p(), m();
  }, { deep: true }), f(() => n.personalWorkshopId, (e) => {
    e ? r.value = e : r.value = n.query.workshopId || void 0, p(), m();
  }, { deep: true });
  const { getMyChart: b } = A({ elementId: "personalProductionAnalysisChart", fetchHook: p, initOption: { legend: { show: true }, xAxis: { axisTick: { show: true }, type: "category", data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { type: "value", name: "", min: 0, axisLabel: { formatter: "{value}" } }, title: { text: "" }, series: [{ name: "本年度", data: [100, 200, 300, 400, 500, 600, 700, 500, 400, 300, 200, 100], type: "line", label: { show: true, distance: 1, position: "left" }, itemStyle: { color: "#19be7a" } }, { name: "去年同期", data: [100, 500, 200, 300, 700, 400, 200, 100, 500, 300, 200, 100], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#22e4ff" } }] } });
  async function p(e) {
    var t, l;
    try {
      d.value = true;
      const a = e || b(), s = await C({ ...n.query, workshopId: r.value }) || [], y = a.getOption();
      y.series[0].data = (t = s == null ? void 0 : s.currentList) == null ? void 0 : t.map((o) => o.mete && o.numbers ? w(o.mete / o.numbers, "kg", "t", 3) : 0), y.series[1].data = (l = s == null ? void 0 : s.lastList) == null ? void 0 : l.map((o) => o.mete && o.numbers ? w(o.mete / o.numbers, "kg", "t", 3) : 0), a.setOption(y);
    } catch (a) {
      console.log(a, "获取人均产量分析失败");
    } finally {
      d.value = false;
    }
  }
  async function m() {
    try {
      const e = await S({ ...n.query, workshopId: r.value });
      u.value = e || {};
    } catch (e) {
      console.log(e, "获取人均产量汇总信息失败");
    }
  }
  return (e, t) => {
    var a, s;
    const l = P;
    return _(), g("div", z, [i("div", L, [i("div", { style: v(`height: ${c.maxHeight}px;display: flex; flex-direction: column; justify-content: center;align-items: center; align-content: center;`) }, [t[0] || (t[0] = i("div", { class: "title_color title_size" }, "本年度人均产量(吨)", -1)), i("div", H, x(((a = u.value) == null ? void 0 : a.currentRatio) || 0), 1), t[1] || (t[1] = i("div", { class: "title_size" }, "去年人均产量(吨)", -1)), i("div", O, x(((s = u.value) == null ? void 0 : s.lastRatio) || 0), 1)], 4)]), I((_(), g("div", { style: v({ height: c.maxHeight + "px", width: "70%" }) }, t[2] || (t[2] = [i("div", { id: "personalProductionAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[l, d.value]])]);
  };
} }, W = q(j, [["__scopeId", "data-v-cd7fbab9"]]);
export {
  W as default
};
