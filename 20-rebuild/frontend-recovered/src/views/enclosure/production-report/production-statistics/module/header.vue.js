import { ref as r } from "vue";
import s from "moment";
import { watch as W } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as Z } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { createBlock as z } from "vue";
import { createCommentVNode as H } from "vue";
import { withCtx as I } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as F } from "vue";
import { withDirectives as V } from "vue";
import { vShow as X } from "vue";
import { ElDatePicker as J } from "element-plus";
import { ElTag as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { l as E, jg as d, B as ae, mt as oe, p as k, D as le, I as ne, bb as re, C as se, E as ie } from "../../../../../shared/runtime.js";
import { h as de } from "../../../../../modules/enclosure-365a2177.js";
import { u as ue } from "../../../../../modules/use-chart-59e4b63c.js";
function ce(p) {
  return E({ url: "/api/mes/enclosure/produce/overview/v2/order/detail", method: "get", params: p });
}
function me(p) {
  return E({ url: "/api/mes/enclosure/produce/overview/v2/order/total", method: "get", params: p });
}
function pe(p) {
  return E({ url: "/api/mes/enclosure/produce/overview/v2/order/list", method: "get", params: p });
}
const xe = { get: ce }, fe = { id: "enclosureWorkshopReportChart", style: { width: "100%", height: "250px", "margin-bottom": "10px" } }, he = { __name: "header", setup(p) {
  const Y = r(0), O = r(), C = r(), y = r([]), L = r(false), v = s().startOf("year").valueOf(), A = s().valueOf(), B = { type: d.ALL_YEAR.V, startTime: v, endTime: A, date: [v, A], time: v, dictionaryId: void 0 }, { crud: u, query: e } = ae(B), Q = r({ key: "id", value: "id", label: "label" }), { enclosureDictList: q } = oe();
  function $(o) {
    o === d.ALL_YEAR.V ? e.time = v : e.time = s().startOf("month").valueOf();
  }
  function R(o) {
    return o > /* @__PURE__ */ new Date();
  }
  M();
  async function M() {
    try {
      Y.value = await me({ time: e.time, dictionaryId: e.dictionaryId });
    } catch (o) {
      console.log("获取全年产量失败", o);
    }
  }
  function P(o = []) {
    e.date = o, e.startTime = o[0], e.endTime = o[1], u.toQuery();
  }
  const w = r([]);
  for (let o = 1; o <= 12; o++) w.value.push(o + "月");
  const D = r(), T = r([]);
  W([() => e.dictionaryId, () => e.type, () => e.time], (o) => {
    if (e.type === d.CURRENT_MONTH.V) {
      D.value = s(k(e.time, "{y}-{m}"), "YYYY-MM").daysInMonth(), T.value = [];
      for (let a = 1; a <= D.value; a++) T.value.push(a + "日");
    }
    K();
  });
  const { getMyChart: G } = ue({ elementId: "enclosureWorkshopReportChart", fetchHook: N, initOption: { legend: { show: false }, xAxis: { data: w.value }, title: { text: "单位：m" }, yAxis: { axisTick: { show: false }, axisLine: { show: true }, splitLine: { show: false } }, series: [{ name: "产量", type: "bar", yAxisIndex: 0, data: [], label: { show: true, position: "top", formatter: (o) => o.value || "" } }] } });
  async function N() {
    y.value = [];
    try {
      const o = [];
      L.value = true;
      const a = G();
      a.getZr().off("click"), a.getZr().on("click", function(l) {
        const _ = [l.offsetX, l.offsetY];
        if (a.containPixel("grid", _)) {
          const n = a.convertFromPixel({ seriesIndex: 0 }, _)[0];
          if (C.value = e.time, O.value = n < 9 ? `0${n + 1}` : n + 1, u.query.type === d.ALL_YEAR.V) {
            const h = k(C.value, "{y}") + "-" + O.value;
            y.value = [s(h).startOf("month").valueOf(), s(h).endOf("month").valueOf()];
          } else {
            const h = k(C.value, "{y}-{m}") + "-" + O.value;
            y.value = [s(h).startOf("date").valueOf(), s(h).endOf("date").valueOf()];
          }
          P(y.value);
        }
      });
      const g = await pe({ dictionaryId: e.dictionaryId, type: e.type, time: e.time }), c = {};
      g.forEach((l) => {
        c[l.date] = l.totalLength;
      });
      const m = a.getOption();
      u.query.type === d.CURRENT_MONTH.V ? m.xAxis[0].data = T.value : m.xAxis[0].data = w.value;
      const f = m.xAxis[0].data || [];
      for (let l = 0; l < f.length; l++) c[l + 1] ? o.push({ date: f[l], totalLength: c[l + 1] }) : o.push({ date: f[l], totalLength: 0 });
      m.series[0].data = o.map((l) => l.totalLength), a.setOption(m);
    } catch (o) {
      console.log(o, "获取车间报表图表失败");
    } finally {
      L.value = false;
    }
  }
  function K() {
    M(), N(), u.toQuery();
  }
  return (o, a) => {
    const g = U("common-radio-button"), c = J, m = ee, f = U("print-table"), l = j("thousand"), _ = te, S = j("permission");
    return b(), Z("div", null, [i(g, { modelValue: t(e).dictionaryId, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).dictionaryId = n), "data-structure": Q.value, options: t(q), class: "filter-item", size: "default", type: "other", onChange: t(u).toQuery }, null, 8, ["modelValue", "data-structure", "options", "onChange"]), i(g, { modelValue: t(e).type, "onUpdate:modelValue": a[1] || (a[1] = (n) => t(e).type = n), options: t(d).ENUM, class: "filter-item", type: "enumSL", onChange: $ }, null, 8, ["modelValue", "options"]), t(e).type === t(d).ALL_YEAR.V ? (b(), z(c, { key: 0, modelValue: t(e).time, "onUpdate:modelValue": a[2] || (a[2] = (n) => t(e).time = n), clearable: false, "disabled-date": R, class: "filter-item", format: "YYYY", placeholder: "选择年", size: "default", style: { width: "120px !important" }, type: "year", "value-format": "x" }, null, 8, ["modelValue"])) : H("", true), t(e).type === t(d).CURRENT_MONTH.V ? (b(), z(c, { key: 1, modelValue: t(e).time, "onUpdate:modelValue": a[3] || (a[3] = (n) => t(e).time = n), clearable: false, "disabled-date": R, class: "filter-item", format: "YYYY-MM", placeholder: "选择月", size: "default", style: { width: "120px !important" }, type: "month", "value-format": "x" }, null, 8, ["modelValue"])) : H("", true), i(m, { class: "filter-item", effect: "plain", size: "large", style: { float: "right" } }, { default: I(() => [x("span", null, [a[7] || (a[7] = F("全年累计产量（m）：")), V(x("span", null, null, 512), [[l, { val: Y.value || 0, dp: t(le).MES_ENCLOSURE_L__M }]])])]), _: 1 }), V(x("div", null, [V(x("div", fe, null, 512), [[_, L.value]])], 512), [[X, t(u).searchToggle]]), i(t(ie), null, { optLeft: I(() => [i(c, { modelValue: t(e).date, "onUpdate:modelValue": a[4] || (a[4] = (n) => t(e).date = n), clearable: false, shortcuts: t(ne), class: "filter-item date-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px", "margin-right": "10px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: P }, null, 8, ["modelValue", "shortcuts"]), i(t(re), { modelValue: t(e).projectId, "onUpdate:modelValue": a[5] || (a[5] = (n) => t(e).projectId = n), class: "filter-item", onChange: a[6] || (a[6] = (n) => t(u).toQuery()) }, null, 8, ["modelValue"]), i(t(se))]), viewLeft: I(() => [V(i(f, { params: { ...t(e) }, "api-key": "enclosureProductionStatistics", size: "default", type: "warning" }, null, 8, ["params"]), [[S, t(de).print]])]), _: 1 })]);
  };
} }, Ve = Object.freeze(Object.defineProperty({ __proto__: null, default: he }, Symbol.toStringTag, { value: "Module" }));
export {
  he as _,
  xe as c,
  Ve as h
};
