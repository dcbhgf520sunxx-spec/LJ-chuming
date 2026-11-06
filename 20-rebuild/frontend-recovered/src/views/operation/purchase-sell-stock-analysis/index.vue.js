import { ref as g } from "vue";
import b from "moment";
import { resolveComponent as L } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as v } from "vue";
import { normalizeStyle as S } from "vue";
import { unref as k } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElDivider as z } from "element-plus";
import { l as A, n as O, o as B } from "../../../shared/runtime.js";
import { u as C } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
function D({ tax: c, type: l, dateTime: a }) {
  return A({ url: "/api/operational/analysis/inventory/summary", method: "get", params: { tax: c, type: l, dateTime: a } });
}
function F({ tax: c, type: l, dateTime: a }) {
  return A({ url: "/api/operational/analysis/inventory/stock", method: "get", params: { tax: c, type: l, dateTime: a } });
}
function K({ tax: c, type: l, dateTime: a }) {
  return A({ url: "/api/operational/analysis/inventory/stock/steel", method: "get", params: { tax: c, type: l, dateTime: a } });
}
const Y = { class: "app-container" }, P = { class: "head-container" }, R = { style: { display: "flex" } }, Q = { __name: "index", setup(c) {
  function l(o) {
    return o > /* @__PURE__ */ new Date();
  }
  const a = { STEEL: { L: "钢材", K: "STEEL", V: 1 }, MATERIAL: { L: "辅材", K: "MATERIAL", V: 2 } };
  O(a);
  const _ = { YES: { L: "含税", K: "YES", V: 1 }, NO: { L: "不含税", K: "NO", V: 2 } };
  O(_);
  const u = g(b().valueOf()), d = g(), h = _.YES.V, p = g([]);
  for (let o = 1; o <= 12; o++) p.value.push(o + "月");
  const { maxHeight: y } = B({ extraBox: [".head-container", ".divider"], minHeight: 400 }), { getMyChart: V } = C({ elementId: "purchaseUseChart", fetchHook: x, initOption: { custom: { title: [{ text: "采购和使用分析" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { data: p.value }, series: [{ name: "月度采购数据", type: "line", data: [] }, { name: "月度使用数据", type: "line", data: [] }] } }), { getMyChart: w } = C({ elementId: "stockChart", fetchHook: f, initOption: { custom: { title: [{ text: "库存分析" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { data: p.value }, series: [{ name: "", type: "line", data: [] }] } }), { getMyChart: I } = C({ elementId: "steelStockChart", fetchHook: E, initOption: { custom: { title: [{ text: "钢材库存" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { data: p.value }, series: [{ name: "", type: "line", data: [] }] } });
  async function x(o) {
    try {
      const t = o || V(), { content: i } = await D({ dateTime: u.value, tax: h, type: d.value }), r = i.map((m) => m.intoAmount && Number((m.intoAmount / 1e4).toFixed(2)) || 0), n = i.map((m) => m.outAmount && Number((m.outAmount / 1e4).toFixed(2)) || 0), e = t.getOption();
      e.series[0].data = r, e.series[1].data = n, t.setOption(e);
    } catch (t) {
      console.log(t, "获取采购和使用分析信息失败");
    }
  }
  async function f(o) {
    try {
      const t = o || w(), { content: i } = await F({ dateTime: u.value, tax: h, type: d.value }), r = i.map((e) => e.amount && Number((e.amount / 1e4).toFixed(2)) || 0), n = t.getOption();
      n.series[0].data = r, t.setOption(n);
    } catch (t) {
      console.log(t, "获取库存分析信息失败");
    }
  }
  async function E(o) {
    try {
      const t = o || I(), { content: i } = await K({ dateTime: u.value, tax: h }), r = i.map((e) => e.weight && Number((e.weight / 1e6).toFixed(0)) || 0), n = t.getOption();
      n.series[0].data = r, t.setOption(n);
    } catch (t) {
      console.log(t, "获取钢材库存信息失败");
    }
  }
  function T() {
    x(), f(), E();
  }
  function N() {
    x(), f();
  }
  return (o, t) => {
    const i = U, r = L("common-select"), n = z;
    return M(), H("div", Y, [s("div", P, [v(i, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => u.value = e), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", clearable: false, "value-format": "x", "disabled-date": l, class: "filter-item", onChange: T }, null, 8, ["modelValue"]), v(r, { modelValue: d.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => d.value = e), options: a.ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: N }, null, 8, ["modelValue", "options"])]), s("div", { style: S([{ height: k(y) / 2 + "px" }, { flex: "1" }]) }, t[2] || (t[2] = [s("div", { id: "purchaseUseChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4), v(n, { class: "divider" }), s("div", R, [s("div", { style: S([{ height: k(y) / 2 + "px" }, { flex: "1", "margin-right": "20px" }]) }, t[3] || (t[3] = [s("div", { id: "stockChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4), s("div", { style: S([{ height: k(y) / 2 + "px" }, { flex: "1" }]) }, t[4] || (t[4] = [s("div", { id: "steelStockChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)])]);
  };
} };
export {
  Q as default
};
