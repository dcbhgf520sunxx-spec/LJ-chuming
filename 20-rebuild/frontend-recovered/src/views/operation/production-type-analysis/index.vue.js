import { ref as _ } from "vue";
import U from "moment";
import { computed as N } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as C } from "vue";
import { normalizeStyle as V } from "vue";
import { unref as b } from "vue";
import { createBlock as A } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as p } from "vue";
import { Fragment as $ } from "vue";
import { createCommentVNode as q } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElDivider as j } from "element-plus";
import { vLoading as J } from "element-plus";
import { l as K, m as W, a3 as S, o as X, G as T } from "../../../shared/runtime.js";
import { g as O } from "../../../modules/operation-4e9312fe.js";
import { u as F } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
function I(k) {
  return K({ url: "/api/operational/analysis/production_type", method: "get", params: k });
}
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = { style: { display: "flex" } }, ae = { style: { display: "flex", "margin-top": "20px" } }, se = { __name: "index", setup(k) {
  function M(n) {
    return n > /* @__PURE__ */ new Date();
  }
  const m = _(U().valueOf()), { productMenu: B } = W("productMenu"), E = N(() => S.ENCLOSURE.V & B.value), h = N(() => E.value ? 2 : 1), c = _(false), f = _([]), y = _([]), { maxHeight: g } = X({ extraBox: [".head-container", ".divider"] }), v = { xAxis: { show: false }, tooltip: { trigger: "item" }, legend: { cancelDefaultData: true, top: "center", left: "right", orient: "vertical" }, series: { type: "pie", radius: [50, 110], center: ["40%", "50%"], roseType: "area", itemStyle: { borderRadius: 8 }, label: { show: true, formatter: (n) => {
    const { value: t, ratio: r } = n.data;
    return `${t} | ${r}%`;
  } } } }, { getMyChart: L } = F({ elementId: "structureChart", initOption: { custom: { title: [{ text: "结构制品" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, ...v, series: [{ name: "", ...v.series, data: [] }] } }), { getMyChart: z } = F({ elementId: "enclosureChart", fetchHook: D, initOption: { custom: { title: [{ text: "围护制品" }, { text: "单位：米", right: 0, textStyle: { fontSize: 13 } }] }, ...v, series: [{ name: "", ...v.series, data: [] }] } });
  function P() {
    f.value = [], y.value = [];
  }
  async function D(n) {
    try {
      if (P(), !T(O.get)) return false;
      c.value = true, await R(), E.value && await H();
    } catch (t) {
      console.log(t, "获取产量分析信息");
    } finally {
      c.value = false;
    }
  }
  async function R(n) {
    if (!T(O.get)) return false;
    try {
      const { content: t } = await I({ dateTime: m.value, productType: S.ARTIFACT.V });
      f.value = t.map((e) => {
        var u;
        return e.yield = (e.yield / 1e3).toFixed(2), e.ratio = (u = e.ratio) == null ? void 0 : u.toFixed(2), e;
      });
      const r = n || L(), a = r.getOption();
      a.series[0].data = f.value.map((e) => ({ value: e.yield, name: e.typeName, ratio: e.ratio })), r.setOption(a);
    } catch (t) {
      console.log(t, "获取结构制品分析信息");
    }
  }
  async function H(n) {
    if (!T(O.get)) return false;
    try {
      const { content: t } = await I({ dateTime: m.value, productType: S.ENCLOSURE.V });
      y.value = t.map((e) => {
        var u;
        return e.yield = (e.yield / 1e3).toFixed(2), e.ratio = (u = e.ratio) == null ? void 0 : u.toFixed(2), e;
      });
      const r = n || z(), a = r.getOption();
      a.series[0].data = y.value.map((e) => ({ value: e.yield, name: e.typeName, ratio: e.ratio })), r.setOption(a);
    } catch (t) {
      console.log(t, "获取围护制品分析信息");
    }
  }
  return (n, t) => {
    const r = Q, a = Y, e = G("common-table"), u = j, x = J;
    return d(), w("div", Z, [l("div", ee, [i(r, { modelValue: m.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => m.value = o), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", class: "filter-item", "value-format": "x", clearable: false, "disabled-date": M, onChange: D }, null, 8, ["modelValue"])]), l("div", te, [C((d(), w("div", { style: V([{ height: b(g) / h.value + "px" }, { flex: "1" }]) }, t[1] || (t[1] = [l("div", { id: "structureChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[x, c.value]]), C((d(), A(e, { height: b(g) / h.value, data: f.value, style: { flex: "1", "margin-left": "20px" } }, { default: s(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), i(a, { "show-overflow-tooltip": true, label: "构件类型", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.typeName), 1)]), _: 1 }), i(a, { "show-overflow-tooltip": true, label: "产量", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.yield), 1)]), _: 1 }), i(a, { "show-overflow-tooltip": true, label: "占比", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.ratio) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["height", "data"])), [[x, c.value]])]), E.value ? (d(), w($, { key: 0 }, [i(u, { class: "divider" }), l("div", ae, [C((d(), w("div", { style: V([{ height: b(g) / h.value + "px" }, { flex: "1" }]) }, t[2] || (t[2] = [l("div", { id: "enclosureChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[x, c.value]]), C((d(), A(e, { height: b(g) / h.value, data: y.value, style: { flex: "1", "margin-left": "20px" } }, { default: s(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), i(a, { "show-overflow-tooltip": true, label: "板型", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.typeName), 1)]), _: 1 }), i(a, { "show-overflow-tooltip": true, label: "产量", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.yield), 1)]), _: 1 }), i(a, { "show-overflow-tooltip": true, label: "占比", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [l("span", null, p(o.ratio) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["height", "data"])), [[x, c.value]])])], 64)) : q("", true)]);
  };
} };
export {
  se as default
};
