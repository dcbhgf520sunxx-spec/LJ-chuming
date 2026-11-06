import { ref as m } from "vue";
import { watch as H } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as h } from "vue";
import { withDirectives as q } from "vue";
import { normalizeStyle as I } from "vue";
import { createVNode as B } from "vue";
import { vLoading as M } from "element-plus";
import { a as D, b as E, _ as G } from "./order-detail.vue.js";
import { kx as u, G as O, p as j } from "../../../../shared/runtime.js";
import { u as L } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const z = { style: { display: "flex", width: "100%" } }, Y = { __name: "order-amount-statistics", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(f) {
  const p = m(false), y = m(false), g = m(""), x = m(), A = m({}), b = m(0), v = m(u.MACHINING.V | u.INSTALLATION.V), d = f;
  H(() => d.query, (n) => {
    w(), C();
  }, { deep: true });
  const { getMyChart: k } = L({ elementId: "orderAmountAnalisisCircleChart", fetchHook: w, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { text: "", textStyle: { fontSize: 16, color: "#000000", fontWeight: "bold" }, textAlign: "center", textVerticalAlign: "middle", left: "35%", top: "50%" }, tooltip: { trigger: "item", appendToBody: true, position: function(n, i, s, e, t) {
    var o = 0, a = 0, r = n[0], c = n[1], l = t.contentSize[0], N = t.contentSize[1];
    return l > r ? o = 5 : o = r - l, N > c ? a = 5 : a = c - N, [o, a];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: "center", right: 10, formatter: function(n) {
    let i = "";
    const s = n.length, e = 15, t = Math.ceil(s / e);
    if (s > e) for (let o = 0; o < t; o++) {
      const a = o * e, r = a + e, c = o === t - 1 ? n.substring(a, s) : n.substring(a, r) + `
`;
      i += c;
    }
    else i = n;
    return i;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["35%", "50%"], data: [], label: { formatter: (n) => `${n.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } }), { getMyChart: F } = L({ elementId: "orderAmountAnalisisColumnChart", fetchHook: C, initOption: { legend: { show: true }, xAxis: { axisTick: { show: false }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "2025", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function w(n) {
    var i;
    if (!O((i = d.permission) == null ? void 0 : i.get)) return false;
    try {
      p.value = true;
      const s = n || k();
      s.on("click", function(a) {
        y.value = true, g.value = "订单合同额统计", x.value = 1;
      });
      const e = await D({ ...d.query }) || [], t = s.getOption();
      t.series[0].data = e == null ? void 0 : e.map((a) => ({ name: u.VL[a.businessType], value: (a.contractAmount / 1e4).toFixed(0) }));
      const o = e == null ? void 0 : e.reduce((a, r) => r != null && r.contractAmount ? a + (r == null ? void 0 : r.contractAmount) : a, 0);
      t.title[0].text = (o / 1e4).toFixed(0) + "万元", s.setOption(t), s.on("legendselectchanged", function(a) {
        V(s, a);
      });
    } catch (s) {
      console.log(s, "获取差异分析柱状图失败");
    } finally {
      p.value = false;
    }
  }
  function V(n, i) {
    var c;
    b.value = 0;
    const s = n.getOption().series, e = n.getOption().legend[0].data;
    let t;
    i ? t = i.selected : (t = {}, e.forEach((l) => {
      t[l] = true;
    }));
    const o = Object.keys(t).filter((l) => t[l]), a = Object.keys(t).every((l) => t[l]);
    ((c = s[0].data) == null ? void 0 : c.filter((l) => o.includes(l.name))).forEach((l) => {
      b.value += Number(l.value);
    }), n.setOption({ title: { text: `${b.value.toLocaleString()}万元` } }), a ? v.value = u.MACHINING.V | u.INSTALLATION.V : o[0] === u.MACHINING.L ? v.value = u.MACHINING.V : o[0] === u.INSTALLATION.L && (v.value = u.INSTALLATION.V);
  }
  async function C(n) {
    var i;
    if (!O((i = d.permission) == null ? void 0 : i.get)) return false;
    try {
      p.value = true;
      const s = n || F();
      s.on("click", function(o) {
        A.value = o, y.value = true, g.value = "订单合同额统计", x.value = 2;
      });
      const e = await E({ ...d.query }) || [], t = s.getOption();
      t.series[0].data = e == null ? void 0 : e.map((o) => (o.contractAmount / 1e4).toFixed(0)), t.series[0].name = j(d.query.yearDate, "{y}"), t.xAxis[0].data = e == null ? void 0 : e.map((o) => o.dateTime), s.setOption(t);
    } catch (s) {
      console.log(s, "获取差异分析柱状图失败");
    } finally {
      p.value = false;
    }
  }
  return (n, i) => {
    var e;
    const s = M;
    return T(), S("div", null, [i[3] || (i[3] = h("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "订单合同额统计", -1)), h("div", z, [q((T(), S("div", { style: I({ height: f.maxHeight + "px", width: "29%" }) }, i[1] || (i[1] = [h("div", { id: "orderAmountAnalisisCircleChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[s, p.value]]), h("div", { style: I(`height: ${f.maxHeight}px; width: 70%`) }, i[2] || (i[2] = [h("div", { id: "orderAmountAnalisisColumnChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), B(G, { visible: y.value, "onUpdate:visible": i[0] || (i[0] = (t) => y.value = t), showTitle: g.value, showType: x.value, info: A.value, query: f.query, permission: (e = f.permission) == null ? void 0 : e.amount, businessType: v.value }, null, 8, ["visible", "showTitle", "showType", "info", "query", "permission", "businessType"])]);
  };
} };
export {
  Y as default
};
