import { ref as c } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as A } from "vue";
import { withDirectives as Y } from "vue";
import { normalizeStyle as F } from "vue";
import { Fragment as B } from "vue";
import { vLoading as E } from "element-plus";
import { g as H, a as L } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { n as M, G as k, i as V } from "../../../shared/runtime.js";
import { u as I } from "../../../modules/use-chart-59e4b63c.js";
import z from "./purchase-order-detail.vue.js";
import "../../../modules/index-18acf776.js";
const D = { style: { display: "flex", "justify-content": "space-between" } }, Q = { style: { display: "flex" } }, Z = { __name: "all-purchase-order-analysis", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(d) {
  const h = { QUANTITY: { L: "数量", K: "QUANTITY", V: 1 }, AMOUNT: { L: "合同额", K: "AMOUNT", V: 2 } };
  M(h);
  const p = c(false), v = c(false), u = c(h.QUANTITY.V), y = c(), x = c({}), g = c(0), b = c([]), f = d;
  $([() => f.query, () => u.value], (n) => {
    w(), C();
  }, { deep: true });
  const { getMyChart: j } = I({ elementId: "allPurchaseOrderAnalisisCircleChart", fetchHook: w, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { text: "0", textStyle: { fontSize: 16, color: "#000000", fontWeight: "bold" }, textAlign: "center", textVerticalAlign: "middle", x: "35%", y: "50%" }, tooltip: { trigger: "item", appendToBody: true, position: function(n, a, i, e, s) {
    var o = 0, r = 0, t = n[0], l = n[1], O = s.contentSize[0], T = s.contentSize[1];
    return O > t ? o = 5 : o = t - O, T > l ? r = 5 : r = l - T, [o, r];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: "center", right: 10, selected: b.value, formatter: function(n) {
    let a = "";
    const i = n.length, e = 10, s = Math.ceil(i / e);
    if (i > e) for (let o = 0; o < s; o++) {
      const r = o * e, t = r + e, l = o === s - 1 ? n.substring(r, i) : n.substring(r, t) + `
`;
      a += l;
    }
    else a = n;
    return a;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["35%", "50%"], data: [], label: { formatter: (n) => `${n.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } }), { getMyChart: q } = I({ elementId: "allPurchaseOrderAnalisisColumnChart", fetchHook: C, initOption: { legend: { show: false }, tooltip: { show: true, formatter(n) {
    return `<div style="padding: 3px 5px">
          <div>${n[0].name}</div>
          <div style="display: flex; justify-content: space-between">
            <div>${n[0].marker}</div>
            <div>
              <span>${n[0].value}<span>
              <span>${u.value === h.QUANTITY.V ? "单" : "万元"}<span>
            </div>
            </div>
          </div>`;
  } }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ data: [40, 60, 70, 80, 98, 40, 60, 70, 80, 98, 40, 60], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function w(n) {
    var a;
    if (!k((a = f.permission) == null ? void 0 : a.get)) return false;
    try {
      p.value = true;
      const i = n || j(), e = await H({ ...f.query }), s = i.getOption();
      s.series[0].data = e == null ? void 0 : e.map((t) => ({ name: t.materialTypeName, value: u.value === 1 ? t.numbers : (t.amount / 1e4).toFixed(0) }));
      const o = e == null ? void 0 : e.reduce((t, l) => V(l == null ? void 0 : l.numbers) ? t + (l == null ? void 0 : l.numbers) : t, 0), r = e == null ? void 0 : e.reduce((t, l) => V(l == null ? void 0 : l.amount) ? t + (l == null ? void 0 : l.amount) : t, 0);
      s.title[0].text = u.value === 1 ? o + "单" : (r / 1e4).toFixed(0) + "万元", i.setOption(s), i.on("click", function(t) {
        y.value = 1, v.value = true;
      }), i.on("legendselectchanged", function(t) {
        U(i, t);
      });
    } catch (i) {
      console.log(i, "获取全年采购订单圆环图失败");
    } finally {
      p.value = false;
    }
  }
  function U(n, a) {
    var r;
    g.value = 0;
    const i = n.getOption().series;
    b.value = n.getOption().legend[0].data;
    let e;
    a ? e = a.selected : (e = {}, b.value.forEach((t) => {
      e[t] = true;
    }));
    const s = Object.keys(e).filter((t) => e[t]);
    ((r = i[0].data) == null ? void 0 : r.filter((t) => s.includes(t.name))).forEach((t) => {
      g.value += Number(t.value);
    }), n.setOption({ title: { text: `${g.value.toLocaleString()}${u.value === 1 ? "单" : "万元"}` } });
  }
  async function C(n) {
    var a;
    if (!k((a = f.permission) == null ? void 0 : a.get)) return false;
    try {
      p.value = true;
      const i = n || q(), e = await L({ ...f.query }), s = i.getOption();
      s.xAxis[0].data = e == null ? void 0 : e.map((o) => o.dateTime), s.series[0].data = e == null ? void 0 : e.map((o) => u.value === 1 ? o.numbers : (o.amount / 1e4).toFixed(0)), i.setOption(s), i.on("click", function(o) {
        y.value = 2, x.value = o, v.value = true;
      });
    } catch (i) {
      console.log(i, "获取全年采购订单柱状图失败");
    } finally {
      p.value = false;
    }
  }
  return (n, a) => {
    var s;
    const i = P("common-radio-button"), e = E;
    return N(), S(B, null, [m("div", D, [a[2] || (a[2] = m("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "全年采购订单分析", -1)), A(i, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => u.value = o), options: h.ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"])]), m("div", Q, [Y((N(), S("div", { style: F({ height: d.maxHeight + "px", flex: 1 }) }, a[3] || (a[3] = [m("div", { id: "allPurchaseOrderAnalisisCircleChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, p.value]]), m("div", { style: F(`flex: 2;height: ${d.maxHeight}px`) }, a[4] || (a[4] = [m("div", { id: "allPurchaseOrderAnalisisColumnChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), A(z, { visible: v.value, "onUpdate:visible": a[1] || (a[1] = (o) => v.value = o), query: d.query, showType: u.value, dateType: y.value, branchInfo: d.branchInfo, chartObj: x.value, permission: (s = d.permission) == null ? void 0 : s.allYear }, null, 8, ["visible", "query", "showType", "dateType", "branchInfo", "chartObj", "permission"])], 64);
  };
} };
export {
  Z as default
};
