import { reactive as S } from "vue";
import f from "moment";
import { ref as h } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as D } from "vue";
import { createTextVNode as j } from "vue";
import { withModifiers as P } from "vue";
import { withDirectives as _ } from "vue";
import { ElDatePicker as q } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElDivider as J } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as y, B as Z, D as w, aV as ee, I as te, bb as oe, E as ae } from "../../../../../shared/runtime.js";
import { u as ne } from "../../../../../modules/use-chart-59e4b63c.js";
import { h as re } from "../../../../../modules/bridge-86f96a4f.js";
import { _ as ie } from "../../../../../modules/production-line-select-307387f7.js";
function de(d) {
  return y({ module: "bridge", url: "workshop/report/box/summary/page", method: "get", params: d });
}
function se(d) {
  return y({ module: "bridge", url: "workshop/report/year/mete/summary", method: "get", params: d });
}
function le(d) {
  return y({ module: "bridge", url: "workshop/report/report", method: "get", params: d });
}
function ue(d) {
  return y({ module: "bridge", url: "workshop/report/mete/summary", method: "get", params: d });
}
const Ie = { get: de }, pe = { class: "head-container" }, ce = { style: { width: "100%", height: "250px", display: "flex" } }, me = { id: "workshopDeliveryChart", style: { width: "100%", height: "250px" } }, fe = { style: { "margin-top": "10px" } }, he = { __name: "header", setup(d) {
  const k = S({ mete: 0 }), I = S({ mete: 0 }), z = { dateTime: void 0, date: [f().startOf("month").valueOf(), f().valueOf()], startTime: f().startOf("month").valueOf(), endTime: f().valueOf(), projectId: void 0, workShopId: void 0, productionLineId: void 0 }, { crud: v, query: e } = Z(z);
  function R(a) {
    return a > /* @__PURE__ */ new Date();
  }
  l(), g();
  async function l() {
    try {
      const a = await se({ dateTime: e.dateTime, workShopId: e.workShopId, productionLineId: e.productionLineId });
      k.mete = a;
    } catch (a) {
      console.log("获取全年产量失败", a);
    }
  }
  async function g() {
    try {
      const a = await ue({ startTime: e.startTime, endTime: e.endTime, projectId: e.projectId });
      I.mete = a;
    } catch (a) {
      console.log("获取车间产量失败", a);
    }
  }
  function E() {
    e.date && e.date.length > 1 ? (e.startTime = e.date[0], e.endTime = e.date[1]) : (e.startTime = void 0, e.endTime = void 0), g(), v.toQuery();
  }
  function M() {
    l(), u();
  }
  function A() {
    l(), u();
  }
  function U() {
    g(), v.toQuery();
  }
  function Y() {
    l(), u();
  }
  function F() {
    e.dateTime = void 0, e.workShopId = void 0, e.productionLineId = void 0, l(), u();
  }
  function N() {
    e.workShopId = void 0, e.productionLineId = void 0, l(), u();
  }
  const Q = h(), T = h([]);
  for (let a = 1; a <= 12; a++) T.value.push(a + "月");
  const x = h(false), C = h(false), { getMyChart: W } = ne({ elementId: "workshopDeliveryChart", fetchHook: u, initOption: { legend: { show: false }, xAxis: { data: T.value }, title: { text: "单位：吨", left: "90%", textStyle: { fontSize: 14 } }, yAxis: { axisTick: { show: false }, axisLine: { show: true }, splitLine: { show: true } }, series: [{ name: "产量", type: "bar", yAxisIndex: 0, data: [] }] } });
  async function u() {
    try {
      C.value = true;
      const a = W(), t = [], c = await le({ dateTime: e.dateTime, workShopId: e.workShopId, productionLineId: e.productionLineId }), m = a.getOption();
      for (const s in c) t.push(c[s]);
      console.log(t), m.series[0].data = t.map((s) => s && Number((s / 1e3).toFixed(w.COM_WT__KG)) || 0), a.setOption(m);
    } catch (a) {
      console.log(a, "获取车间报表信息失败");
    } finally {
      C.value = false;
    }
  }
  return (a, t) => {
    const c = q, m = $, s = V("common-button"), B = J, K = V("print-table"), b = X, G = H("permission");
    return L(), O("div", pe, [r("div", null, [n(c, { modelValue: o(e).dateTime, "onUpdate:modelValue": t[0] || (t[0] = (i) => o(e).dateTime = i), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, format: "YYYY", clearable: true, "value-format": "x", placeholder: "选择年", "disabled-date": R, onChange: N }, null, 8, ["modelValue"]), n(o(ee), { ref_key: "workshopInfRef", ref: Q, modelValue: o(e).workShopId, "onUpdate:modelValue": t[1] || (t[1] = (i) => o(e).workShopId = i), placeholder: "请选择车间", "factory-id": o(e).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: M }, null, 8, ["modelValue", "factory-id"]), n(o(ie), { ref: "productionLineRef", class: "filter-item", modelValue: o(e).productionLineId, "onUpdate:modelValue": t[2] || (t[2] = (i) => o(e).productionLineId = i), "factory-id": o(e).factoryId, "workshop-id": o(e).workShopId, placeholder: "请选择生产线", style: { width: "200px" }, clearable: "", onChange: A }, null, 8, ["modelValue", "factory-id", "workshop-id"]), n(m, { class: "filter-item", size: "large" }, { default: p(() => [t[5] || (t[5] = r("span", null, "全年累计产量（吨）", -1)), t[6] || (t[6] = r("span", null, "：", -1)), r("span", null, D((k.mete / 1e3).toFixed(o(w).COM_WT__KG)), 1)]), _: 1, __: [5, 6] }), n(s, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: P(Y, ["stop"]) }, { default: p(() => t[7] || (t[7] = [j("搜索")])), _: 1, __: [7] }), n(s, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: P(F, ["stop"]) }, { default: p(() => t[8] || (t[8] = [j(" 重置 ")])), _: 1, __: [8] })]), r("div", null, [_((L(), O("div", ce, [_(r("div", me, null, 512), [[b, x.value]])])), [[b, x.value]])]), n(B, { class: "divider" }), r("div", fe, [n(o(ae), null, { optLeft: p(() => [n(c, { modelValue: o(e).date, "onUpdate:modelValue": t[3] || (t[3] = (i) => o(e).date = i), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: o(te), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: E }, null, 8, ["modelValue", "shortcuts"]), n(o(oe), { modelValue: o(e).projectId, "onUpdate:modelValue": t[4] || (t[4] = (i) => o(e).projectId = i), class: "filter-item", onChange: U, clearable: "", style: { width: "300px" } }, null, 8, ["modelValue"]), n(m, { type: "success", class: "filter-item", size: "large" }, { default: p(() => [t[9] || (t[9] = r("span", null, "产量（吨）", -1)), t[10] || (t[10] = r("span", null, "：", -1)), r("span", null, D((I.mete / 1e3).toFixed(o(w).COM_WT__KG)), 1)]), _: 1, __: [9, 10] })]), viewLeft: p(() => [_(n(K, { "api-key": "bridgeFactoryWorkshopReport", params: { startTime: o(e).startTime, endTime: o(e).endTime, projectId: o(e).projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[G, o(re).print]])]), _: 1 })])]);
  };
} }, ve = Object.freeze(Object.defineProperty({ __proto__: null, default: he }, Symbol.toStringTag, { value: "Module" }));
export {
  he as _,
  Ie as c,
  ve as h
};
