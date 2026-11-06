import { ref as m } from "vue";
import S from "moment";
import { reactive as K } from "vue";
import { computed as R } from "vue";
import { watch as X } from "vue";
import { resolveComponent as Z } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as n } from "vue";
import { normalizeStyle as A } from "vue";
import { unref as O } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as y } from "vue";
import { withCtx as i } from "vue";
import { createVNode as f } from "vue";
import { toDisplayString as v } from "vue";
import { Fragment as N } from "vue";
import { renderList as V } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElDivider as te } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as ne, _ as re, bN as D, V as L, a$ as se, o as z, c8 as ie } from "../../../shared/runtime.js";
import { u as M } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
function le(k) {
  return ne({ url: "/api/operational/analysis/order", method: "get", params: k });
}
const ce = { class: "order-analysis-container" }, de = { class: "app-container main-content" }, ue = { class: "project-chart" }, he = { class: "chart-head" }, pe = { __name: "index", setup(k) {
  function P(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const l = m(S().valueOf()), h = m([]);
  for (let t = 1; t <= 12; t++) h.value.push(t + "月");
  const p = m(false), o = K([{ name: "订单数", data: [] }, { name: "合同额（万元）", data: [] }]), g = {};
  for (const t in D.ENUM) {
    const e = D.ENUM[t];
    e && (g[e.V] = { name: e.L, data: new Array(12).fill(0) });
  }
  const _ = m(Object.assign({}, L(g))), b = R(() => se(_.value)), { maxHeight: I } = z({ mainBox: ".main-content", extraBox: [".chart-table-annual", ".chart-table-type", ".divider"], wrapperBox: ".main-content", minHeight: 400 }), { maxHeight: T } = z({ extraBox: ".chart-head", wrapperBox: ".chart-container", minHeight: 566, extraHeight: 40 }), H = { legend: { right: 0 }, xAxis: { show: false, data: h.value } }, { getMyChart: U } = M({ elementId: "annualOrderChart", initOption: { ...H, custom: { yAxis: o == null ? void 0 : o.reduce((t, e) => (t.push({ type: "value" }), t), []) }, title: { text: "年度订单量" }, series: o == null ? void 0 : o.reduce((t, e, a) => (t.push({ type: "bar", yAxisIndex: a, ...e }), t), []) } }), { getMyChart: q } = M({ elementId: "orderTypeAnalysisChart", initOption: { ...H, title: { text: "订单类型分析" }, series: x(b.value) } }), { getMyChart: F } = M({ elementId: "orderQuantityChart", fetchHook: j, initOption: { grid: { left: "0%", right: "0%", bottom: 0, top: 0, containLabel: true }, tooltip: { trigger: "item" }, toolbox: { show: false }, xAxis: { show: false, type: "value", boundaryGap: [0, 0], position: "top" }, yAxis: { type: "category", axisLine: { show: false }, inverse: true, axisTick: [{ show: false }], axisLabel: { fontSize: "14" }, data: [] }, legend: { show: false }, series: [{ name: "", type: "bar", tooltip: { show: false }, barMinHeight: 30, barWidth: 40, barMaxWidth: 100, data: [], label: { show: true, position: "inside", fontSize: "14" }, itemStyle: { color: "#1890ff" } }] } });
  X(() => l.value, (t, e) => {
    t && e && j();
  });
  function Q(t) {
    for (let e = 0; e < t.length; e++) t[e].data = new Array(12).fill(0);
  }
  function W() {
    Q(o), _.value = Object.assign({}, L(g));
  }
  async function j() {
    try {
      W(), p.value = true;
      const { orders: t } = await le({ dateTime: l.value });
      for (let e = 0; e < t.length; e++) {
        const a = t[e];
        o[0].data[a.month - 1] += a.count, o[1].data[a.month - 1] += a.contractAmount, _.value[a.businessType].data[a.month - 1] += a.count;
      }
      for (let e = 0; e < o[1].data.length; e++) o[1].data[e] && (o[1].data[e] = (o[1].data[e] / 1e4).toFixed(2));
      G(), Y(), $();
    } catch (t) {
      console.log(t, "获取信息失败");
    } finally {
      p.value = false;
    }
  }
  async function G(t) {
    try {
      const e = t || F(), a = e.getOption(), { provinceList: c } = await ie({ year: S(Number(l.value)).year() });
      a.yAxis[0].max = parseInt(T.value / 50), a.yAxis[0].data = c.map((d) => d.provinceName), a.series[0].data = c.map((d) => d.quantity), e.setOption(a);
    } catch (e) {
      console.log(e, "获取项目汇总列表失败");
    }
  }
  function x(t) {
    return t == null ? void 0 : t.reduce((e, a) => (e.push({ type: "bar", ...a }), e), []);
  }
  async function Y(t) {
    try {
      (t || U()).setOption({ series: x(o) });
    } catch (e) {
      console.log(e, "刷新年度信息失败");
    }
  }
  async function $(t) {
    try {
      (t || q()).setOption({ series: x(b.value) });
    } catch (e) {
      console.log(e, "刷新订单类型失败");
    }
  }
  return (t, e) => {
    const a = ee, c = Z("common-table"), d = te, J = ae, B = oe;
    return s(), C("div", ce, [n("div", de, [n("div", { style: A({ height: O(I) / 2 + "px" }) }, e[1] || (e[1] = [n("div", { id: "annualOrderChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4), E((s(), y(c, { data: o, class: "chart-table chart-table-annual" }, { default: i(() => [f(a, { "show-overflow-tooltip": true, label: "月份", align: "center", width: "110" }, { default: i(({ row: r }) => [n("span", null, v(r.name), 1)]), _: 1 }), (s(true), C(N, null, V(h.value, (r, u) => (s(), y(a, { key: u, "show-overflow-tooltip": true, label: r, align: "center" }, { default: i(({ row: w }) => [n("span", null, v(w.data[u] || 0), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data"])), [[B, p.value]]), f(d, { class: "divider" }), n("div", { style: A({ height: O(I) / 2 + "px" }) }, e[2] || (e[2] = [n("div", { id: "orderTypeAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4), E((s(), y(c, { data: b.value, class: "chart-table chart-table-type" }, { default: i(() => [f(a, { "show-overflow-tooltip": true, label: "月份", align: "center", width: "110" }, { default: i(({ row: r }) => [n("span", null, v(r.name), 1)]), _: 1 }), (s(true), C(N, null, V(h.value, (r, u) => (s(), y(a, { key: u, "show-overflow-tooltip": true, label: r, align: "center" }, { default: i(({ row: w }) => [n("span", null, v(w.data[u] || 0), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data"])), [[B, p.value]])]), n("div", ue, [n("div", he, [f(J, { modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => l.value = r), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": P }, null, 8, ["modelValue"])]), n("div", { class: "chart-container", style: A({ height: O(T) + "px" }) }, e[3] || (e[3] = [n("div", { id: "orderQuantityChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)])]);
  };
} }, ge = re(pe, [["__scopeId", "data-v-8ab21595"]]);
export {
  ge as default
};
