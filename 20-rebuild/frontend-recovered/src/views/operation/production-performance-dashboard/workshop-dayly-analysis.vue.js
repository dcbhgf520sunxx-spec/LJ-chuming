import { ref as n } from "vue";
import y from "moment";
import { watch as f } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as I } from "vue";
import { normalizeStyle as O } from "vue";
import { createVNode as k } from "vue";
import { createElementVNode as q } from "vue";
import { Fragment as S } from "vue";
import { ElDatePicker as A } from "element-plus";
import { vLoading as C } from "element-plus";
import { h as T } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { p as h, c as V } from "../../../shared/runtime.js";
import { u as Y } from "../../../modules/use-chart-59e4b63c.js";
import z from "./workshop-dayly-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const L = { __name: "workshop-dayly-analysis", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, productWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(i) {
  const u = n(), c = n(false), p = n(false), o = n(y().valueOf()), v = n(), l = i;
  function x(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const { getMyChart: D } = Y({ elementId: "daylyAnalysisChart", fetchHook: d, initOption: { legend: { show: false }, xAxis: { axisTick: { show: true }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "日产量统计", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ name: "", data: [10, 20, 30, 40, 50, 60, 70, 50, 40, 30, 20, 10], type: "line", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#F4A80A" } }] } });
  f(() => l.query, (e) => {
    e && (h(e == null ? void 0 : e.yearDate, "{y}") === h((/* @__PURE__ */ new Date()).getTime(), "{y}") ? o.value = y().valueOf() : o.value = y(e.yearDate).startOf(1, "month").valueOf(), u.value = l.query.workshopId || void 0, d());
  }, { deep: true }), f(() => o.value, (e) => {
    d();
  }), f(() => l.productWorkshopId, (e) => {
    u.value = e || l.query.workshopId, d();
  }, { deep: true });
  async function d(e) {
    try {
      c.value = true;
      const t = e || D(), m = await T({ ...l.query, mouthDate: o.value, workshopId: u.value }) || {}, r = t.getOption();
      r.xAxis[0].data = m.map((a) => {
        var s, g;
        return ((s = a.dateTime) == null ? void 0 : s.split("-")[1]) + "-" + ((g = a.dateTime) == null ? void 0 : g.split("-")[2]);
      }), r.series[0].data = m.map((a) => V(a.mete, "kg", "t", 0)), t.setOption(r), t.on("click", function(a) {
        v.value = (/* @__PURE__ */ new Date(h(o.value, "{y}") + "-" + a.name)).getTime(), p.value = true;
      });
    } catch (t) {
      console.log(t, "获取日产量统计失败");
    } finally {
      c.value = false;
    }
  }
  return (e, t) => {
    var a;
    const m = A, r = C;
    return b(), w(S, null, [I((b(), w("div", { style: O({ height: i.maxHeight + "px" }) }, [k(m, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => o.value = s), type: "month", size: "small", class: "date-item filter-item", clearable: false, style: { width: "130px", float: "right", "z-index": "100", "margin-right": "8px" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x", "disabled-date": x }, null, 8, ["modelValue"]), t[2] || (t[2] = q("div", { id: "daylyAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1))], 4)), [[r, c.value]]), k(z, { visible: p.value, "onUpdate:visible": t[1] || (t[1] = (s) => p.value = s), query: i.query, workshopId: u.value, searchDate: v.value, branchInfo: i.branchInfo, permission: (a = i.permission) == null ? void 0 : a.workshopMete }, null, 8, ["visible", "query", "workshopId", "searchDate", "branchInfo", "permission"])], 64);
  };
} };
export {
  L as default
};
