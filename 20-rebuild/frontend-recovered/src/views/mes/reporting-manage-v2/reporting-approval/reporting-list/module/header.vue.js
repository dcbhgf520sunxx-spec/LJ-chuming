import { ref as w } from "vue";
import q from "moment";
import { inject as P } from "vue";
import { computed as g } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as i } from "vue";
import { unref as o } from "vue";
import { normalizeStyle as z } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as W } from "vue";
import { withCtx as $ } from "vue";
import { createTextVNode as H } from "vue";
import { createCommentVNode as K } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { l as v, _ as Y, B as X, qc as u, a3 as R, qd as F, L as J } from "../../../../../../shared/runtime.js";
import { i as Z } from "../../../../../../modules/reporting-approval-2b65eecd.js";
import { _ as ee } from "../../../../../../modules/index-c07af747.js";
import te from "./project-header-time.vue.js";
function oe(r) {
  return v({ module: "mes", url: "quota-config/production-reporting-approval/team-report-summary-list", method: "get", params: r });
}
function ae(r) {
  return v({ module: "mes", url: "quota-config/production-reporting-approval/date-exists-unapproved-data-list", method: "get", params: r });
}
function ne(r) {
  return v({ module: "mes", url: "quota-config/production-reporting-approval/date-exists-approved-data-list", method: "get", params: r });
}
function ge(r) {
  return v({ module: "mes", url: "quota-config/production-reporting-approval/team-report-approved-summary-list", method: "get", params: r });
}
const ve = { get: oe };
const re = { class: "header-container" }, se = { class: "filters-row" }, le = { __name: "header", emits: ["viewTypeChange"], setup(r, { emit: I }) {
  const k = I, A = { yearMonth: (/* @__PURE__ */ new Date()).getTime(), date: void 0, workshopId: void 0, productTypeEnum: void 0 }, { crud: p, query: t } = X(A), m = w([]), s = w(u.REAL_TIME_WORK_REPORTING.V), c = w();
  function _() {
    h();
  }
  const E = q().startOf("day").valueOf().toString(), M = P("handleCurrentChange"), b = g(() => s.value === u.REAL_TIME_WORK_REPORTING.V ? ae : ne), T = g(() => s.value === u.AUDIT_LOGGING.V), C = g(() => s.value === u.REAL_TIME_WORK_REPORTING.V ? "boolExistsUnapprovedData" : "boolExistsApprovedData"), L = g(() => ({ yearMonth: t.yearMonth, productTypeEnum: t.productTypeEnum, workshopId: t.workshopId, date: t.date }));
  async function h(l) {
    try {
      const e = [];
      c.value = t.date, t.date = void 0, m.value = [], M();
      const f = await b.value(t);
      f.length > 0 ? (m.value = f.filter((n) => n == null ? void 0 : n[C.value]).map((n) => {
        const d = new Date(n.date), y = d.getMonth() + 1, a = d.getDate(), S = ["周日", "周一", "周二", "周三", "周四", "周五", "周六"][d.getDay()];
        return e.push(String(n.date)), { day: `${y}/${a}`, week: S, timeStamp: String(n.date) };
      }), c.value && e.includes(String(c.value)) ? t.date = String(c.value) : e != null && e.length ? t.date = e.includes(E) ? E : e[0] : (t.date = void 0, p.data = []), t.date && p.toQuery()) : (m.value = [], p.data = []);
    } catch (e) {
      console.log(e);
    }
  }
  function O(l) {
    return l > /* @__PURE__ */ new Date();
  }
  function U(l) {
    h(), k("viewTypeChange", l);
  }
  h();
  async function N() {
    p.toQuery();
  }
  return (l, e) => {
    const f = Q, n = V("common-radio-button"), d = V("common-select-v2"), y = G("permission");
    return x(), j("div", re, [D("div", null, [i(f, { modelValue: o(t).yearMonth, "onUpdate:modelValue": e[0] || (e[0] = (a) => o(t).yearMonth = a), type: "month", size: "default", "value-format": "x", clearable: false, placeholder: "选择月份", "disabled-date": O, style: { width: "120px", "margin-bottom": "10px", "margin-right": "6px" }, class: "filter-item", onChange: _ }, null, 8, ["modelValue"]), i(n, { modelValue: s.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => s.value = a), options: o(u).ENUM, class: "filter-item", size: "default", type: "enum", onChange: U }, null, 8, ["modelValue", "options"]), D("div", se, [i(d, { modelValue: o(t).productTypeEnum, "onUpdate:modelValue": e[2] || (e[2] = (a) => o(t).productTypeEnum = a), options: o(R).ENUM, type: "enum", "unshow-options": [o(R).AUXILIARY_MATERIAL.V], clearable: "", class: "filter-item", placeholder: "全部类型", onChange: _, style: { width: "120px" } }, null, 8, ["modelValue", "options", "unshow-options"]), i(o(ee), { modelValue: o(t).workshopId, "onUpdate:modelValue": e[3] || (e[3] = (a) => o(t).workshopId = a), placeholder: "车间筛选", class: "filter-item", clearable: "", onChange: _, style: z({ width: T.value ? "140px" : "220px" }) }, null, 8, ["modelValue", "style"]), T.value ? B((x(), W(J, { key: 0, fn: o(Z), params: L.value, type: "warning", size: "default", class: "filter-item" }, { default: $(() => e[5] || (e[5] = [H(" 审核记录下载 ")])), _: 1, __: [5] }, 8, ["fn", "params"])), [[y, o(F).download]]) : K("", true)]), i(o(te), { modelValue: o(t).date, "onUpdate:modelValue": e[4] || (e[4] = (a) => o(t).date = a), data: m.value, onChange: N, "empty-text": "暂无未审核信息" }, null, 8, ["modelValue", "data"])])]);
  };
} }, de = Y(le, [["__scopeId", "data-v-00d96999"]]), _e = Object.freeze(Object.defineProperty({ __proto__: null, default: de }, Symbol.toStringTag, { value: "Module" }));
export {
  ve as c,
  ge as g,
  _e as h,
  de as m
};
