import { ref as _ } from "vue";
import { inject as P } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as g } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as u } from "vue";
import { withKeys as B } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as K } from "element-plus";
import { ElInput as O } from "element-plus";
import { vLoading as $ } from "element-plus";
import { P as H } from "../../../../../modules/index-5b9e6004.js";
import { g as M } from "../../../../../modules/team-payroll-summary-1754395b.js";
import { _ as j, qm as m, B as z, C as G, ql as W } from "../../../../../shared/runtime.js";
import { _ as A } from "../../../../../modules/index-c07af747.js";
import { _ as F } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const J = { class: "wage-adjust" }, X = { class: "search" }, Y = { __name: "header", setup(Z) {
  const h = { date: [], startDate: void 0, endDate: void 0, workshopId: void 0, processId: void 0, teamName: void 0, productTypeEnum: m.STRUCTURE.V }, r = _({}), c = _(false), { crud: s, CRUD: V, query: a } = z(h), w = _([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = P("deadline");
  function C() {
    a.date && a.date.length > 1 ? (a.startDate = a.date[0], a.endDate = a.date[1]) : (a.startDate = void 0, a.endDate = void 0), s.toQuery();
  }
  async function E() {
    c.value = true;
    try {
      const n = await M(a);
      r.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      c.value = false;
    }
  }
  V.HOOK.handleRefresh = async (n, { data: l }) => {
    E();
  };
  const b = (n) => f.value ? n.getTime() > f.value : false;
  return (n, l) => {
    const D = L, x = y("common-radio-button"), i = H, p = q, T = K, U = O, k = y("print-table"), S = $, I = N("permission");
    return v(), R("div", null, [d("div", J, [d("div", null, [o(e(A), { modelValue: e(a).workshopId, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).workshopId = t), placeholder: "全部车间", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(F), { modelValue: e(a).processId, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).processId = t), class: "filter-item", multiple: false, clearable: "", placeholder: "全部工序", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(D, { modelValue: e(a).date, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(a).date = t), "default-time": w.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", clearable: false, "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", "disabled-date": b, onChange: C }, null, 8, ["modelValue", "default-time"]), o(x, { modelValue: e(a).productTypeEnum, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(a).productTypeEnum = t), options: e(m).ENUM, type: "enum", default: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])])]), g((v(), Q(T, { gutter: 20, class: "panel-group custom-row" }, { default: u(() => [o(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var t;
      return [o(i, { name: "工资总额（元）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((t = r.value) == null ? void 0 : t.totalSalary) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 }), o(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var t;
      return [o(i, { name: `产量${e(a).productTypeEnum === e(m).ENCLOSURE.V ? "（米）" : "（吨）"}`, "text-color": "#626262", "num-color": "#16c14e", "end-val": ((t = r.value) == null ? void 0 : t.productionVolume) || 0, precision: e(a).productTypeEnum === e(m).ENCLOSURE.V ? 2 : 5 }, null, 8, ["name", "end-val", "precision"])];
    }), _: 1 }), o(p, { class: "card-panel-col custom-col" }, { default: u(() => {
      var t;
      return [o(i, { name: "平均单价（元/吨）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((t = r.value) == null ? void 0 : t.averageLaborCost) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[S, c.value]]), d("div", X, [d("div", null, [o(U, { modelValue: e(a).teamName, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(a).teamName = t), modelModifiers: { trim: true }, clearable: "", placeholder: "班组搜索", class: "filter-item", style: { width: "200px" }, onKeyup: B(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(G))]), g(o(k, { "api-key": "mesTeamWageSummary", params: { ...e(a) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[I, e(W).groupPayrollSummaryPrint]])])]);
  };
} }, ue = j(Y, [["__scopeId", "data-v-c4712f0b"]]);
export {
  ue as default
};
