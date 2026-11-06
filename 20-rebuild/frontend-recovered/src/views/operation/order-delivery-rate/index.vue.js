import { ref as i } from "vue";
import k from "moment";
import { openBlock as v } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as D } from "vue";
import { unref as s } from "vue";
import { normalizeStyle as w } from "vue";
import { ElDatePicker as I } from "element-plus";
import { ElDivider as S } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as V, _ as B, o as N } from "../../../shared/runtime.js";
import { u as E } from "../../../modules/use-chart-59e4b63c.js";
import { P as c } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function H(_) {
  return V({ url: "/api/operational/analysis/deliver", method: "get", params: _ });
}
const L = { class: "app-container" }, P = { class: "head-container" }, z = { gutter: 20, class: "panel-group" }, F = { __name: "index", setup(_) {
  function b(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const y = i([]);
  for (let e = 1; e <= 12; e++) y.value.push(e + "月");
  const u = i(k().valueOf()), R = i(false), m = i(false), r = i({}), { maxHeight: A } = N({ extraBox: [".head-container", ".panel-group", ".divider"] }), { getMyChart: C } = E({ elementId: "orderDeliveryRateChart", fetchHook: x, initOption: { legend: { show: true }, xAxis: { data: y.value }, title: { text: "月度订单交付率" }, custom: { yAxis: [{ type: "value" }, { name: "交付率", axisLabel: { formatter: "{value} %" }, type: "value" }] }, series: [{ name: "计划", type: "bar", yAxisIndex: 0, data: [] }, { name: "实际", type: "bar", yAxisIndex: 0, data: [] }, { name: "交付率", yAxisIndex: 1, type: "line", data: [] }] } });
  async function x() {
    try {
      m.value = true;
      const e = C(), { details: a = [], completeSummary: d = 0, avgDeliverRatio: p = 0, orderSummary: n = 0 } = await H({ dateTime: u.value }), o = e.getOption();
      r.value = { completeSummary: d, avgDeliverRatio: p, orderSummary: n, totalRatio: d / n * 100 }, o.series[0].data = a.map((t) => t.order && Number((t.order / 1e3).toFixed(2)) || 0), o.series[1].data = a.map((t) => {
        const h = t.complete && Number((t.complete / 1e3).toFixed(2)) || 0;
        return { value: h, itemStyle: { color: h && !t.order ? "#cccccc" : "#91cc75" } };
      }), o.series[2].data = a.map((t) => t.deliverRatio || 0), e.setOption(o);
    } catch (e) {
      console.log(e, "获取产能负荷率信息");
    } finally {
      m.value = false;
    }
  }
  return (e, a) => {
    const d = I, p = S, n = O;
    return v(), f("div", L, [g("div", P, [l(d, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => u.value = o), type: "year", size: "default", style: { width: "300px" }, class: "filter-item", placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": b, onChange: x }, null, 8, ["modelValue"])]), D((v(), f("div", z, [l(s(c), { name: "在手订单（吨）", "num-color": "#1890ff", "end-val": r.value.orderSummary / 1e3 || 0, precision: 2 }, null, 8, ["end-val"]), l(s(c), { name: "实际交付（吨）", "num-color": "#1890ff", "end-val": r.value.completeSummary / 1e3 || 0, precision: 2 }, null, 8, ["end-val"]), l(s(c), { name: "总交付率", "num-color": "#1890ff", "end-val": r.value.totalRatio || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"]), l(s(c), { name: "平均交付率", "num-color": "#1890ff", "end-val": r.value.avgDeliverRatio || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"])])), [[n, R.value]]), l(p, { class: "divider" }), D((v(), f("div", { style: w({ height: s(A) + "px" }) }, a[1] || (a[1] = [g("div", { id: "orderDeliveryRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, m.value]])]);
  };
} }, G = B(F, [["__scopeId", "data-v-09d5de1a"]]);
export {
  G as default
};
