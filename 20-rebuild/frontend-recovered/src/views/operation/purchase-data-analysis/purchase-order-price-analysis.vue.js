import { ref as r } from "vue";
import { watch as h } from "vue";
import { nextTick as B } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as v } from "vue";
import { createCommentVNode as q } from "vue";
import { withDirectives as Y } from "vue";
import { normalizeStyle as D } from "vue";
import { Fragment as F } from "vue";
import { vLoading as K } from "element-plus";
import { i as M, j as G, k as J } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { _ as Q, n as R, cO as _, pA as A, G as W } from "../../../shared/runtime.js";
import { u as X } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const Z = { class: "head-container", style: { display: "flex", "margin-top": "8px" } }, $ = { key: 0 }, ee = { key: 1 }, te = { __name: "purchase-order-price-analysis", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(T) {
  const I = r([]), g = { STEEL: { L: "钢板", K: "STEEL", V: 1 }, SECTIONS: { L: "型材", K: "SECTIONS", V: 2 } };
  R(g);
  const b = r(false), c = r(g.STEEL.V), S = r(), d = r(), u = r(), m = r(), N = r([]), V = r([]), E = r([]), L = r([]), y = T;
  h(() => y.query, (s) => {
    C(), z(), f();
  }, { deep: true }), h(() => d.value, (s) => {
    f();
  }), h(() => u.value, (s) => {
    d.value = void 0, m.value = void 0, S.value = void 0, C(), f();
  }), h(() => S.value, (s) => {
    d.value = void 0, P(), f();
  }), h(() => m.value, (s) => {
    d.value = void 0, U(), f();
  }), h(() => c.value, async (s) => {
    s && (u.value = void 0, S.value = void 0, m.value = void 0, d.value = void 0, await C(), await z(), B(async () => {
      await f();
    }));
  }, { immediate: true });
  async function C() {
    var s, a, l;
    try {
      const o = await M({ ...y.query, basicClass: c.value, classifyId: u.value, sectionSteelSpec: m.value, material: d.value, thickness: S.value });
      I.value = o || [];
      const e = /* @__PURE__ */ new Map(), n = /* @__PURE__ */ new Map(), p = /* @__PURE__ */ new Map(), i = await _(I.value);
      i == null || i.forEach(async (t) => {
        await A(t);
      }), i == null || i.forEach(async (t) => {
        if (!e.has(t.sectionSteelSpec)) e.set(t.sectionSteelSpec, { ...t });
        else {
          const w = e.get(t.sectionSteelSpec);
          e.set(t.sectionSteelSpec, { ...w, ...t });
        }
      }), i == null || i.forEach(async (t) => {
        if (!n.has(t.doNotSectionSteelSpec)) n.set(t.doNotSectionSteelSpec, { ...t });
        else {
          const w = n.get(t.doNotSectionSteelSpec);
          n.set(t.doNotSectionSteelSpec, { ...w, ...t });
        }
      }), i == null || i.forEach(async (t) => {
        if (!p.has(t.thickness)) p.set(t.thickness, { ...t });
        else {
          const w = p.get(t.thickness);
          p.set(t.thickness, { ...w, ...t });
        }
      }), V.value = (s = Array.from(e.values())) == null ? void 0 : s.filter((t) => t.sectionSteelSpec != null && t.sectionSteelSpec !== ""), E.value = (a = Array.from(n.values())) == null ? void 0 : a.filter((t) => t.doNotSectionSteelSpec != null && t.doNotSectionSteelSpec !== ""), L.value = (l = Array.from(p.values())) == null ? void 0 : l.filter((t) => t.thickness != null && t.thickness !== "");
    } catch (o) {
      console.log(o, "获取选择筛选列列表");
    }
  }
  async function P() {
    var s;
    try {
      const a = await M({ ...y.query, basicClass: c.value, classifyId: u.value, sectionSteelSpec: m.value, thickness: S.value }) || [], l = /* @__PURE__ */ new Map(), o = await _(a);
      o == null || o.forEach(async (e) => {
        await A(e);
      }), o == null || o.forEach(async (e) => {
        if (!l.has(e.doNotSectionSteelSpec)) l.set(e.doNotSectionSteelSpec, { ...e });
        else {
          const n = l.get(e.doNotSectionSteelSpec);
          l.set(e.doNotSectionSteelSpec, { ...n, ...e });
        }
      }), E.value = (s = Array.from(l.values())) == null ? void 0 : s.filter((e) => e.doNotSectionSteelSpec != null && e.doNotSectionSteelSpec !== "");
    } catch (a) {
      console.log(a, "获取选择筛选列列表");
    }
  }
  async function U() {
    var s;
    try {
      const a = await M({ ...y.query, basicClass: c.value, classifyId: u.value }) || [], l = /* @__PURE__ */ new Map(), o = await _(a);
      o == null || o.forEach(async (e) => {
        await A(e);
      }), o == null || o.forEach(async (e) => {
        if (!l.has(e.sectionSteelSpec)) l.set(e.sectionSteelSpec, { ...e });
        else {
          const n = l.get(e.sectionSteelSpec);
          l.set(e.sectionSteelSpec, { ...n, ...e });
        }
      }), V.value = (s = Array.from(l.values())) == null ? void 0 : s.filter((e) => e.sectionSteelSpec != null && e.sectionSteelSpec !== "");
    } catch (a) {
      console.log(a, "获取选择筛选列列表");
    }
  }
  async function z() {
    try {
      const s = await G({ basicClass: c.value });
      N.value = s ? s[c.value] : [];
    } catch (s) {
      console.log(s, "获取不同类型名称列表");
    }
  }
  const { getMyChart: j } = X({ elementId: "purchaseOrderPriceAnalysisChart", fetchHook: f, initOption: { legend: { show: true }, xAxis: { axisTick: { show: true }, type: "category", data: [] }, yAxis: { type: "value", name: "", min: 0, axisLabel: { formatter: "{value}" } }, custom: { title: [{ text: "单位：元/吨", right: 0, textStyle: { fontSize: 13 } }] }, series: [{ name: "本年度", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "line", label: { show: true, distance: 5, position: "left" }, itemStyle: { color: "#19be7a" } }, { name: "去年同期", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "line", label: { show: true, distance: 5, position: "right" }, itemStyle: { color: "#22e4ff" } }] } });
  async function f(s) {
    var a, l, o, e;
    if (!W((a = y.permission) == null ? void 0 : a.get)) return false;
    try {
      b.value = true;
      const n = s || j(), p = n.getOption(), i = await J({ ...y.query, basicClass: c.value, classifyId: u.value, sectionSteelSpec: m.value, material: d.value, thickness: S.value });
      p.xAxis[0].data = (l = i == null ? void 0 : i.currentYear) == null ? void 0 : l.map((t) => t.dateTime), p.series[0].data = (o = i == null ? void 0 : i.currentYear) == null ? void 0 : o.map((t) => t.avgPrice), p.series[1].data = (e = i == null ? void 0 : i.lastYear) == null ? void 0 : e.map((t) => t.avgPrice), n.setOption(p);
    } catch (n) {
      console.log(n, "获取差异分析柱状图失败");
    } finally {
      b.value = false;
    }
  }
  return (s, a) => {
    const l = H("common-select"), o = K;
    return x(), k(F, null, [a[7] || (a[7] = O("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "主材采购价格走势", -1)), O("div", Z, [v(l, { modelValue: c.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => c.value = e), options: g.ENUM, type: "enum", clearable: false, class: "filter-item", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"]), c.value === g.STEEL.V ? (x(), k("div", $, [v(l, { modelValue: u.value, "onUpdate:modelValue": a[1] || (a[1] = (e) => u.value = e), options: N.value, type: "other", clearable: "", class: "filter-item", placeholder: "选择钢板", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"]), v(l, { modelValue: S.value, "onUpdate:modelValue": a[2] || (a[2] = (e) => S.value = e), options: L.value, dataStructure: { key: "thickness", label: "thickness", value: "thickness" }, type: "other", clearable: "", placeholder: "选择厚度", class: "filter-item", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"])])) : q("", true), c.value === g.SECTIONS.V ? (x(), k("div", ee, [v(l, { modelValue: u.value, "onUpdate:modelValue": a[3] || (a[3] = (e) => u.value = e), options: N.value, type: "other", clearable: "", class: "filter-item", placeholder: "选择型材", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"]), v(l, { modelValue: m.value, "onUpdate:modelValue": a[4] || (a[4] = (e) => m.value = e), options: V.value, dataStructure: { key: "sectionSteelSpec", label: "sectionSteelSpec", value: "sectionSteelSpec" }, type: "other", clearable: "", class: "filter-item", placeholder: "选择规格", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"])])) : q("", true), v(l, { modelValue: d.value, "onUpdate:modelValue": a[5] || (a[5] = (e) => d.value = e), options: E.value, type: "other", clearable: "", dataStructure: { key: "doNotSectionSteelSpec", label: "doNotSectionSteelSpec", value: "doNotSectionSteelSpec" }, placeholder: "选择材质", class: "filter-item", style: { width: "160px" }, size: "small" }, null, 8, ["modelValue", "options"])]), Y((x(), k("div", { style: D({ height: T.maxHeight + "px" }) }, a[6] || (a[6] = [O("div", { id: "purchaseOrderPriceAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, b.value]])], 64);
  };
} }, ne = Q(te, [["__scopeId", "data-v-bfde7ccd"]]);
export {
  ne as default
};
