import { ref as d } from "vue";
import P from "moment";
import { computed as R } from "vue";
import { resolveComponent as te } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as v } from "vue";
import { unref as y } from "vue";
import { withDirectives as D } from "vue";
import { normalizeStyle as Y } from "vue";
import { createBlock as S } from "vue";
import { withCtx as f } from "vue";
import { toDisplayString as E } from "vue";
import { Fragment as k } from "vue";
import { renderList as G } from "vue";
import { createCommentVNode as ae } from "vue";
import { ElDatePicker as oe } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElDivider as ne } from "element-plus";
import { vLoading as re } from "element-plus";
import { l as se, m as ie, a3 as T, o as ue, G as H } from "../../../shared/runtime.js";
import { l as M } from "../../../modules/operation-4e9312fe.js";
import { u as j } from "../../../modules/use-chart-59e4b63c.js";
import { _ as ce } from "../../../modules/factory-select-b8d0a4ac.js";
import "../../../modules/index-18acf776.js";
function q(z) {
  return se({ url: "/api/operational/analysis/production", method: "get", params: z, cancelKey: false });
}
const de = { class: "app-container" }, me = { class: "head-container" }, pe = { style: { display: "flex" } }, fe = { style: { display: "flex", "margin-top": "20px" } }, K = 3, we = { __name: "index", setup(z) {
  function Q(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const g = d(P().valueOf()), _ = d(), L = d([]);
  for (let t = 1; t <= 12; t++) L.value.push(t + "月");
  const { productMenu: $ } = ie("productMenu"), V = R(() => T.ENCLOSURE.V & $.value), x = R(() => V.value ? 2 : 1), m = d(false), N = d([]), I = d([]), w = d({}), C = d({}), { maxHeight: b } = ue({ extraBox: [".head-container", ".divider"] });
  function B(t) {
    const { columns: e, data: n } = t, o = [];
    return e.forEach((l, s) => {
      if (s === 0) o[s] = "合计";
      else {
        const r = n.map((a) => Number(a.yearData[l.property]) || 0);
        r.every((a) => isNaN(a)) || (o[s] = r.reduce((a, i) => {
          const h = Number(i);
          return isNaN(h) ? a : a + i;
        }, 0));
      }
    }), o;
  }
  const U = { xAxis: { data: L.value }, series: O() }, { getMyChart: J } = j({ elementId: "yieldStructureChart", initOption: { ...U, custom: { title: [{ text: "产量分析（结构制品）" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] } } }), { getMyChart: W } = j({ elementId: "yieldEnclosureChart", fetchHook: A, initOption: { ...U, custom: { title: [{ text: "产量分析（围护制品）" }, { text: "单位：米", right: 0, textStyle: { fontSize: 13 } }] } } });
  function O(t) {
    if (!t || !Object.keys(t).length) return [];
    const e = [];
    for (const n in t) e.push({ type: "bar", name: n, data: t[n] });
    return e;
  }
  function X() {
    w.value = {}, N.value = [], C.value = {}, I.value = [];
  }
  async function A(t) {
    try {
      if (X(), !H(M.get)) return false;
      m.value = true, await Z(), V.value && await ee();
    } catch (e) {
      console.log(e, "获取产量分析信息");
    } finally {
      m.value = false;
    }
  }
  async function Z(t) {
    if (!H(M.get)) return false;
    try {
      const e = t || J(), { content: n } = await q({ dateTime: g.value, factoryId: _.value, productType: T.ARTIFACT.V, yearSize: K }), { resData: o, resList: l } = F(n);
      w.value = o, N.value = l, e.setOption({ series: O(w.value) });
    } catch (e) {
      console.log(e, "获取结构产量分析信息");
    }
  }
  async function ee(t) {
    if (!H(M.get)) return false;
    try {
      const e = t || W(), { content: n } = await q({ dateTime: g.value, factoryId: _.value, productType: T.ENCLOSURE.V, yearSize: K }), { resData: o, resList: l } = F(n);
      C.value = o, I.value = l, e.setOption({ series: O(C.value) });
    } catch (e) {
      console.log(e, "获取围护产量分析信息");
    }
  }
  function F(t) {
    const e = {};
    let n = [];
    for (let o = 0; o < t.length; o++) {
      const l = t[o];
      e[l.year] = new Array(12).fill(0);
      for (let s = 0; s < l.productionDetailsList.length; s++) {
        const r = l.productionDetailsList[s];
        e[l.year][P(r.month).month()] = (r.production / 1e3).toFixed(2);
      }
    }
    return n = L.value.reduce((o, l, s) => {
      const r = {};
      for (const a in e) r[a] = e[a][s] || 0;
      return o.push({ month: l, yearData: r }), o;
    }, []), { resData: e, resList: n };
  }
  return (t, e) => {
    const n = oe, o = le, l = te("common-table"), s = ne, r = re;
    return u(), p("div", de, [c("div", me, [v(n, { modelValue: g.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => g.value = a), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", class: "filter-item", "value-format": "x", clearable: false, "disabled-date": Q, onChange: A }, null, 8, ["modelValue"]), v(y(ce), { modelValue: _.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => _.value = a), class: "filter-item", showOptionAll: "", style: { width: "300px" }, onChange: A }, null, 8, ["modelValue"])]), c("div", pe, [D((u(), p("div", { style: Y([{ height: y(b) / x.value + "px" }, { flex: "1" }]) }, e[2] || (e[2] = [c("div", { id: "yieldStructureChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[r, m.value]]), D((u(), S(l, { maxHeight: y(b) / x.value, data: N.value, "show-summary": "", "summary-method": B, style: { width: "500px", "margin-left": "20px" } }, { default: f(() => [v(o, { "show-overflow-tooltip": true, label: "月份", align: "center" }, { default: f(({ row: a }) => [c("span", null, E(a.month), 1)]), _: 1 }), (u(true), p(k, null, G(w.value, (a, i) => (u(), S(o, { key: i, prop: i, "show-overflow-tooltip": true, label: i, align: "center" }, { default: f(({ $index: h }) => [c("span", null, E(a[h] || 0), 1)]), _: 2 }, 1032, ["prop", "label"]))), 128))]), _: 1 }, 8, ["maxHeight", "data"])), [[r, m.value]])]), V.value ? (u(), p(k, { key: 0 }, [v(s, { class: "divider" }), c("div", fe, [D((u(), p("div", { style: Y([{ height: y(b) / x.value + "px" }, { flex: "1" }]) }, e[3] || (e[3] = [c("div", { id: "yieldEnclosureChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[r, m.value]]), D((u(), S(l, { maxHeight: y(b) / x.value, data: I.value, "show-summary": "", "summary-method": B, style: { width: "500px", "margin-left": "20px" } }, { default: f(() => [v(o, { "show-overflow-tooltip": true, label: "月份", align: "center" }, { default: f(({ row: a }) => [c("span", null, E(a.month), 1)]), _: 1 }), (u(true), p(k, null, G(C.value, (a, i) => (u(), S(o, { key: i, prop: i, "show-overflow-tooltip": true, label: i, align: "center" }, { default: f(({ $index: h }) => [c("span", null, E(a[h] || 0), 1)]), _: 2 }, 1032, ["prop", "label"]))), 128))]), _: 1 }, 8, ["maxHeight", "data"])), [[r, m.value]])])], 64)) : ae("", true)]);
  };
} };
export {
  we as default
};
