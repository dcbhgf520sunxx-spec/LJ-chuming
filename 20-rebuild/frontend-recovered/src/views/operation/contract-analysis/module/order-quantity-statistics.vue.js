import { ref as d } from "vue";
import { watch as H } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as F } from "vue";
import { normalizeStyle as I } from "vue";
import { createVNode as Q } from "vue";
import { vLoading as B } from "element-plus";
import { a as D, b as M, _ as E } from "./order-detail.vue.js";
import { kx as u, G as O, p as G } from "../../../../shared/runtime.js";
import { u as L } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const j = { style: { display: "flex", width: "100%" } }, U = { __name: "order-quantity-statistics", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(m) {
  const p = d(false), h = d(false), g = d(""), b = d(), w = d({}), x = d(0), v = d(u.MACHINING.V | u.INSTALLATION.V), f = m;
  H(() => f.query, (a) => {
    C(), N();
  }, { deep: true });
  const { getMyChart: k } = L({ elementId: "orderQuantityStatisticsPieChart", fetchHook: C, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { text: "", textStyle: { fontSize: 16, color: "#000000", fontWeight: "bold" }, textAlign: "center", textVerticalAlign: "middle", left: "35%", top: "50%" }, tooltip: { trigger: "item", appendToBody: true, position: function(a, s, i, e, t) {
    var o = 0, n = 0, r = a[0], c = a[1], l = t.contentSize[0], S = t.contentSize[1];
    return l > r ? o = 5 : o = r - l, S > c ? n = 5 : n = c - S, [o, n];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: "center", right: 10, formatter: function(a) {
    let s = "";
    const i = a.length, e = 15, t = Math.ceil(i / e);
    if (i > e) for (let o = 0; o < t; o++) {
      const n = o * e, r = n + e, c = o === t - 1 ? a.substring(n, i) : a.substring(n, r) + `
`;
      s += c;
    }
    else s = a;
    return s;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["35%", "50%"], data: [], label: { formatter: (a) => `${a.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } }), { getMyChart: q } = L({ elementId: "orderQuantityStatisticsColumnChart", fetchHook: N, initOption: { legend: { show: true }, xAxis: { axisTick: { show: false }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "2025", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function C(a) {
    var s;
    if (!O((s = f.permission) == null ? void 0 : s.get)) return false;
    try {
      p.value = true;
      const i = a || k();
      i.on("click", function(n) {
        h.value = true, g.value = "订单数量统计", b.value = 1, console.log(n, "点击");
      });
      const e = await D({ ...f.query }) || [], t = i.getOption();
      t.series[0].data = e == null ? void 0 : e.map((n) => ({ name: u.VL[n.businessType], value: n.contractQuantity }));
      const o = e == null ? void 0 : e.reduce((n, r) => r != null && r.contractQuantity ? n + (r == null ? void 0 : r.contractQuantity) : n, 0);
      t.title[0].text = o + "个", i.setOption(t), i.on("legendselectchanged", function(n) {
        console.log(n, "params"), V(i, n);
      });
    } catch (i) {
      console.log(i, "获取订单数量柱状图失败");
    } finally {
      p.value = false;
    }
  }
  function V(a, s) {
    var c;
    x.value = 0;
    const i = a.getOption().series, e = a.getOption().legend[0].data;
    console.log(i, e, "legendData");
    let t;
    s ? t = s.selected : (t = {}, e.forEach((l) => {
      t[l] = true;
    }));
    const o = Object.keys(t).filter((l) => t[l]), n = Object.keys(t).every((l) => t[l]);
    ((c = i[0].data) == null ? void 0 : c.filter((l) => o.includes(l.name))).forEach((l) => {
      x.value += Number(l.value);
    }), a.setOption({ title: { text: `${x.value.toLocaleString()}个` } }), n ? v.value = u.MACHINING.V | u.INSTALLATION.V : o[0] === u.MACHINING.L ? v.value = u.MACHINING.V : o[0] === u.INSTALLATION.L && (v.value = u.INSTALLATION.V);
  }
  async function N(a) {
    var s;
    if (!O((s = f.permission) == null ? void 0 : s.get)) return false;
    try {
      p.value = true;
      const i = a || q();
      i.on("click", function(o) {
        w.value = o, h.value = true, g.value = "订单数量统计", b.value = 2;
      });
      const e = await M({ ...f.query }) || [], t = i.getOption();
      t.series[0].data = e == null ? void 0 : e.map((o) => o.contractQuantity), t.series[0].name = G(f.query.yearDate, "{y}"), t.xAxis[0].data = e == null ? void 0 : e.map((o) => o.dateTime), i.setOption(t);
    } catch (i) {
      console.log(i, "获取差异分析柱状图失败");
    } finally {
      p.value = false;
    }
  }
  return (a, s) => {
    var e;
    const i = B;
    return T(), A("div", null, [s[3] || (s[3] = y("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "订单数量统计", -1)), y("div", j, [F((T(), A("div", { style: I({ height: m.maxHeight + "px", width: "29%" }) }, s[1] || (s[1] = [y("div", { id: "orderQuantityStatisticsPieChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, p.value]]), y("div", { style: I(`height: ${m.maxHeight}px; width: 70%`) }, s[2] || (s[2] = [y("div", { id: "orderQuantityStatisticsColumnChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), Q(E, { visible: h.value, "onUpdate:visible": s[0] || (s[0] = (t) => h.value = t), showTitle: g.value, showType: b.value, info: w.value, query: m.query, permission: (e = m.permission) == null ? void 0 : e.quantity, businessType: v.value }, null, 8, ["visible", "showTitle", "showType", "info", "query", "permission", "businessType"])]);
  };
} };
export {
  U as default
};
