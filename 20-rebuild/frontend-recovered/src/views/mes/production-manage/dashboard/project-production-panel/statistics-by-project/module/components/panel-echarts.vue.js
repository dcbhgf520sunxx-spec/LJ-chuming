import { u as y } from "../../../../../../../../modules/use-chart-59e4b63c.js";
import { _ as g, i as N } from "../../../../../../../../shared/runtime.js";
import { inject as v } from "vue";
import { computed as _ } from "vue";
import { watchEffect as x } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as o } from "vue";
import { normalizeStyle as l } from "vue";
import { toDisplayString as i } from "vue";
import { createTextVNode as c } from "vue";
import { unref as w } from "vue";
import { createCommentVNode as b } from "vue";
import "../../../../../../../../modules/index-18acf776.js";
const k = { id: "panel-container" }, S = { class: "left-conatainer" }, C = { style: { "font-weight": "bold" } }, I = { style: { "font-weight": "bold" } }, j = { key: 0, style: { "font-weight": "bold" } }, B = ["id"], E = { __name: "panel-echarts", props: { echartId: { type: String, default: +/* @__PURE__ */ new Date() + "" }, totalNum: { type: Number, default: 0 }, finshNum: { type: Number, default: 0 }, heedTaskNum: { type: Number, default: void 0 }, color: { type: String, default: "#666" }, name: { type: String } }, setup(n) {
  const e = n, h = v("projectId"), s = _(() => e.totalNum === 0 ? "100%" : Math.floor(e.finshNum / e.totalNum * 100 * 100) / 100 + "%"), { getMyChart: p } = y({ elementId: e.echartId, fetchHook: u, initOption: { legend: { show: true }, xAxis: { data: [], axisLabel: { interval: 0 } }, custom: { backgroundColor: "#fff", title: { show: false }, graphic: { elements: [{ type: "text", top: "43%", left: "36%", style: { text: s.value || 0, font: '12px "microsoft yahei"', textAlign: "center", fill: "#4d71df" } }] }, tooltip: { show: false }, series: [{ name: "高级风险", type: "pie", center: ["50%", "50%"], radius: ["100%", "80%"], startAngle: 90, label: { show: false }, labelLine: { show: false }, emphasis: false, data: [{ value: e.finshNum, name: "", itemStyle: { color: e.color } }, { name: "", itemStyle: { color: "#e6e9f0" }, emphasis: { itemStyle: { color: "#e6e9f0" } }, value: e.totalNum - e.finshNum }] }] } } });
  x(() => {
    h && (s.value, u());
  });
  async function u(f) {
    try {
      const t = f || p();
      if (!t) return;
      const a = t.getOption();
      a.graphic[0].elements[0].style.text = s.value, s.value.length === 4 ? a.graphic[0].elements[0].left = "32%" : s.value.length === 5 ? a.graphic[0].elements[0].left = "30%" : s.value.length === 6 ? a.graphic[0].elements[0].left = "28%" : a.graphic[0].elements[0].left = "40%";
      const r = a.series[0].data;
      e.totalNum === 0 ? (r[0].value = 1, r[1].value = 0) : (r[0].value = e.finshNum, r[1].value = e.totalNum - e.finshNum), t.setOption(a);
    } catch (t) {
      console.log(t, "获取卡片统计图信息失败");
    }
  }
  return (f, t) => (m(), d("div", k, [o("div", S, [o("div", C, [o("span", { style: l({ color: e.color }) }, i(e.name) + ":", 5), t[0] || (t[0] = c()), o("span", { style: l({ color: e.color }) }, i(n.totalNum) + "件", 5)]), o("div", I, [o("span", { style: l({ color: e.color }) }, "已完成:", 4), t[1] || (t[1] = c()), o("span", { style: l({ color: e.color }) }, i(n.finshNum) + "件", 5)]), w(N)(e.heedTaskNum) ? (m(), d("div", j, [o("span", { style: l({ color: e.color }) }, "未排产:", 4), t[2] || (t[2] = c()), o("span", { style: l({ color: e.color }) }, i(n.heedTaskNum) + "件", 5)])) : b("", true)]), o("div", { class: "right-conatainer", id: e.echartId, style: { width: "80px", height: "80px" } }, null, 8, B)]));
} }, V = g(E, [["__scopeId", "data-v-3e134c3e"]]);
export {
  V as default
};
