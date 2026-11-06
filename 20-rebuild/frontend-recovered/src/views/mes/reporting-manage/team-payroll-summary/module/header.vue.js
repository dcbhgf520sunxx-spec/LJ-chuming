import d from "moment";
import { ref as f } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as B } from "vue";
import { withCtx as u } from "vue";
import { withKeys as E } from "vue";
import { ElDatePicker as N } from "element-plus";
import { ElCol as S } from "element-plus";
import { ElRow as U } from "element-plus";
import { ElInput as K } from "element-plus";
import { vLoading as R } from "element-plus";
import { P as q } from "../../../../../modules/index-5b9e6004.js";
import { g as H } from "../../../../../modules/team-payroll-summary-ec5d2034.js";
import { _ as $, B as z, aV as L, C as M, ql as T } from "../../../../../shared/runtime.js";
import { _ as W } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const j = { class: "wage-adjust" }, G = { class: "search" }, Y = { __name: "header", setup(A) {
  const y = { date: [d().startOf("month").valueOf(), d().valueOf()], startDate: d().startOf("month").valueOf(), endDate: d().valueOf(), workshopId: void 0, processId: void 0, teamName: void 0 }, s = f({}), i = f(false), { crud: r, CRUD: g, query: e } = z(y), h = f([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  function w() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  async function V() {
    i.value = true;
    try {
      const n = await H(e);
      s.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      i.value = false;
    }
  }
  return g.HOOK.handleRefresh = async (n, { data: o }) => {
    V();
  }, (n, o) => {
    const D = N, m = q, p = S, x = U, b = K, k = I("print-table"), C = R, P = O("permission");
    return _(), Q("div", null, [c("div", j, [c("div", null, [l(t(L), { modelValue: t(e).workshopId, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).workshopId = a), placeholder: "全部车间", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: t(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(t(W), { modelValue: t(e).processId, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).processId = a), class: "filter-item", multiple: false, clearable: "", placeholder: "全部工序", style: { width: "200px" }, onChange: t(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(D, { modelValue: t(e).date, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).date = a), "default-time": h.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", clearable: false, "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: w }, null, 8, ["modelValue", "default-time"])])]), v((_(), B(x, { gutter: 20, class: "panel-group custom-row" }, { default: u(() => [l(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var a;
      return [l(m, { name: "工资总额（元）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((a = s.value) == null ? void 0 : a.totalWage) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 }), l(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var a;
      return [l(m, { name: "产量（吨）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((a = s.value) == null ? void 0 : a.totalProductionQuantity) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 }), l(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var a;
      return [l(m, { name: "平均单价（元/吨）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((a = s.value) == null ? void 0 : a.averagePrice) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[C, i.value]]), c("div", G, [c("div", null, [l(b, { modelValue: t(e).teamName, "onUpdate:modelValue": o[3] || (o[3] = (a) => t(e).teamName = a), modelModifiers: { trim: true }, clearable: "", placeholder: "班组搜索", class: "filter-item", style: { width: "200px" }, onKeyup: E(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(t(M))]), v(l(k, { "api-key": "mesTeamWageSummary", params: { ...t(e) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[P, t(T).groupPayrollSummaryPrint]])])]);
  };
} }, oe = $(Y, [["__scopeId", "data-v-0427b259"]]);
export {
  oe as default
};
