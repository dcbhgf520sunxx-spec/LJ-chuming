import { ref as c } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as x } from "vue";
import { withDirectives as B } from "vue";
import { normalizeStyle as I } from "vue";
import { Fragment as E } from "vue";
import { vLoading as L } from "element-plus";
import { e as z, f as H } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { n as Y, G as q, i as F } from "../../../shared/runtime.js";
import { u as V } from "../../../modules/use-chart-59e4b63c.js";
import D from "./supplier-list-detail.vue.js";
import Q from "./supplier-analysis-detail.vue.js";
import "../../../modules/index-18acf776.js";
const P = { style: { display: "flex", "justify-content": "space-between" } }, K = { style: { display: "flex" } }, ee = { __name: "supplier-analysis", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(u) {
  const v = { QUANTITY: { L: "数量", K: "QUANTITY", V: 1 }, AMOUNT: { L: "合同额", K: "AMOUNT", V: 2 } };
  Y(v);
  const d = c(false), h = c(false), y = c(false), w = c({}), m = c(v.QUANTITY.V), b = c(0), g = c([]), f = u;
  $([() => f.query, () => m.value], (n) => {
    C(), N();
  }, { deep: true });
  const { getMyChart: j } = V({ elementId: "supplierAnalisisCircleChart", fetchHook: C, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { text: "", textStyle: { fontSize: 16, color: "#000000", fontWeight: "bold" }, textAlign: "center", textVerticalAlign: "middle", x: "35%", y: "50%" }, tooltip: { trigger: "item", appendToBody: true, position: function(n, t, o, e, a) {
    var s = 0, l = 0, i = n[0], r = n[1], S = a.contentSize[0], O = a.contentSize[1];
    return S > i ? s = 5 : s = i - S, O > r ? l = 5 : l = r - O, [s, l];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: "center", right: 10, selected: g.value, formatter: function(n) {
    let t = "";
    const o = n.length, e = 10, a = Math.ceil(o / e);
    if (o > e) for (let s = 0; s < a; s++) {
      const l = s * e, i = l + e, r = s === a - 1 ? n.substring(l, o) : n.substring(l, i) + `
`;
      t += r;
    }
    else t = n;
    return t;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["35%", "50%"], data: [], label: { formatter: (n) => `${n.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } }), { getMyChart: k } = V({ elementId: "supplierAnalisisColumnChart", fetchHook: N, initOption: { legend: { show: false }, tooltip: { show: true, formatter(n) {
    return `<div style="padding: 3px 5px">
          <div>${n[0].name}</div>
          <div style="display: flex; justify-content: space-between">
            <div>${n[0].marker}</div>
            <div>
              <span>${n[0].value}<span>
              <span>${m.value === v.QUANTITY.V ? "家" : "万元"}<span>
            </div>
            </div>
          </div>`;
  } }, xAxis: { axisLabel: { show: true, margin: 8, fontSize: 12, interval: 0, formatter: function(n) {
    let t = "";
    const o = n.length, e = 7, a = Math.ceil(o / e);
    if (o > e) for (let s = 0; s < a; s++) {
      const l = s * e, i = l + e, r = s === a - 1 ? n.substring(l, o) : n.substring(l, i) + `
`;
      t += r;
    }
    else t = n;
    return t;
  } }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ data: [], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }] } });
  async function C(n) {
    var t;
    if (!q((t = f.permission) == null ? void 0 : t.get)) return false;
    try {
      d.value = true;
      const o = n || j();
      o.on("click", function(i) {
        h.value = true;
      });
      const e = await z({ ...f.query }), a = o.getOption();
      a.series[0].data = e == null ? void 0 : e.map((i) => ({ name: i.materialTypeName, value: m.value === 1 ? i.numbers : (i.amount / 1e4).toFixed(0) }));
      const s = e == null ? void 0 : e.reduce((i, r) => F(r == null ? void 0 : r.numbers) ? i + (r == null ? void 0 : r.numbers) : i, 0), l = e == null ? void 0 : e.reduce((i, r) => F(r == null ? void 0 : r.amount) ? i + (r == null ? void 0 : r.amount) : i, 0);
      a.title[0].text = m.value === 1 ? s + "家" : (l / 1e4).toFixed(0) + "万元", o.setOption(a), o.on("legendselectchanged", function(i) {
        U(o, i);
      });
    } catch (o) {
      console.log(o, "获取全年供应商汇总败");
    } finally {
      d.value = false;
    }
  }
  function U(n, t) {
    var l;
    b.value = 0;
    const o = n.getOption().series;
    g.value = n.getOption().legend[0].data;
    let e;
    t ? e = t.selected : (e = {}, g.value.forEach((i) => {
      e[i] = true;
    }));
    const a = Object.keys(e).filter((i) => e[i]);
    ((l = o[0].data) == null ? void 0 : l.filter((i) => a.includes(i.name))).forEach((i) => {
      b.value += Number(i.value);
    }), n.setOption({ title: { text: `${b.value.toLocaleString()}${m.value === 1 ? "家" : "万元"}` } });
  }
  async function N(n) {
    var t;
    if (!q((t = f.permission) == null ? void 0 : t.get)) return false;
    try {
      d.value = true;
      const o = n || k(), e = await H({ ...f.query, isAmountSort: m.value === 2 }), a = o.getOption();
      a.xAxis[0].data = e == null ? void 0 : e.map((s) => s.supplierName), a.series[0].data = e == null ? void 0 : e.map((s) => m.value === 1 ? s.numbers : (s.amount / 1e4).toFixed(0)), o.setOption(a), o.on("click", function(s) {
        var i;
        const l = (i = e == null ? void 0 : e.find((r) => r.supplierName === s.name)) == null ? void 0 : i.supplierId;
        w.value = Object.assign(s, { supplierId: l }), y.value = true;
      });
    } catch (o) {
      console.log(o, "获取供应商统计失败");
    } finally {
      d.value = false;
    }
  }
  return (n, t) => {
    var a, s;
    const o = M("common-radio-button"), e = L;
    return A(), T(E, null, [p("div", P, [t[3] || (t[3] = p("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "合同供应商统计", -1)), x(o, { modelValue: m.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => m.value = l), options: v.ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"])]), p("div", K, [B((A(), T("div", { style: I({ height: u.maxHeight + "px", flex: 1 }) }, t[4] || (t[4] = [p("div", { id: "supplierAnalisisCircleChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, d.value]]), p("div", { style: I(`flex: 2;height: ${u.maxHeight}px`) }, t[5] || (t[5] = [p("div", { id: "supplierAnalisisColumnChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)]), x(D, { visible: h.value, "onUpdate:visible": t[1] || (t[1] = (l) => h.value = l), query: u.query, branchInfo: u.branchInfo, permission: (a = u.permission) == null ? void 0 : a.supplier }, null, 8, ["visible", "query", "branchInfo", "permission"]), x(Q, { visible: y.value, "onUpdate:visible": t[2] || (t[2] = (l) => y.value = l), query: u.query, branchInfo: u.branchInfo, chartObj: w.value, permission: (s = u.permission) == null ? void 0 : s.supplier }, null, 8, ["visible", "query", "branchInfo", "chartObj", "permission"])], 64);
  };
} };
export {
  ee as default
};
