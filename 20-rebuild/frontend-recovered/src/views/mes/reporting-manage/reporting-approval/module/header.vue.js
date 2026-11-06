import f from "moment";
import { ref as v } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createBlock as g } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as L } from "vue";
import { withKeys as S } from "vue";
import { ElDatePicker as W } from "element-plus";
import { ElCol as K } from "element-plus";
import { ElRow as R } from "element-plus";
import { ElInput as q } from "element-plus";
import { vLoading as H } from "element-plus";
import { P as M } from "../../../../../modules/index-5b9e6004.js";
import { l as y, _ as F, p6 as E, B as G, p as J, G as x, qd as D, fv as X, C as Z } from "../../../../../shared/runtime.js";
import { _ as ee } from "../../../../../modules/index-c07af747.js";
import { _ as te } from "../../../../../modules/process-select-b35dffc0.js";
function oe(n) {
  return y({ module: "mes", url: "report-work/report-work-approved/unapproved-page", method: "get", params: n });
}
function ae(n) {
  return y({ module: "mes", url: "report-work/report-work-approved/statistics", method: "get", params: n });
}
function fe(n) {
  return y({ module: "mes", url: "report-work/report-work-approved/approved", method: "post", data: n });
}
function ve(n) {
  return y({ module: "mes", url: "report-work/report-work-approved/elimination", method: "put", data: n });
}
const ge = { get: oe };
const le = { class: "wage-adjust" }, ne = { class: "search" }, re = { class: "filter-item" }, se = { __name: "header", props: { adjustLoading: { type: Boolean, default: false }, eliminateLoading: { type: Boolean, default: false } }, emits: ["toAdjust", "wageAdjust", "toEliminate"], setup(n, { expose: I, emit: A }) {
  const _ = A, O = { date: [f().startOf("month").valueOf(), f().valueOf()], startDate: f().startOf("month").valueOf(), endDate: f().valueOf(), productTypeEnum: E.ARTIFACT.V, workshopId: void 0, projectId: void 0, processId: void 0, productSerialNumber: void 0 }, d = v({}), w = v(false), { crud: r, CRUD: U, query: a } = G(O), Y = v([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), h = v(J(/* @__PURE__ */ new Date(), "{y}"));
  function N() {
    a.date && a.date.length > 1 ? (a.startDate = a.date[0], a.endDate = a.date[1]) : (a.startDate = void 0, a.endDate = void 0), r.toQuery();
  }
  async function k() {
    w.value = true;
    try {
      const u = await ae({ year: h.value });
      d.value = u || {};
    } catch (u) {
      console.log(u);
    } finally {
      w.value = false;
    }
  }
  return U.HOOK.beforeToQuery = async (u) => {
    k();
  }, I({ getSummaryData: k }), (u, o) => {
    const j = W, V = T("common-button"), p = M, c = K, Q = R, z = T("common-radio-button"), B = q, P = H;
    return i(), $("div", null, [m("div", le, [m("div", null, [l(j, { modelValue: h.value, "onUpdate:modelValue": o[0] || (o[0] = (t) => h.value = t), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择日期", "value-format": "YYYY", format: "YYYY", clearable: false, class: "filter-item", onChange: k }, null, 8, ["modelValue"])]), e(x)(e(D).wageAdjustment) ? (i(), g(V, { key: 0, type: "warning", size: "default", icon: "el-icon-setting", onClick: o[1] || (o[1] = (t) => _("wageAdjust")) }, { default: s(() => o[10] || (o[10] = [b("工价调整")])), _: 1, __: [10] })) : C("", true)]), L((i(), g(Q, { gutter: 20, class: "panel-group custom-row" }, { default: s(() => [l(c, { class: "card-panel-col custom-col" }, { default: s(() => {
      var t;
      return [l(p, { name: "累计报量（吨）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((t = d.value) == null ? void 0 : t.cumulativeWeight) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 }), l(c, { class: "card-panel-col custom-col" }, { default: s(() => {
      var t;
      return [l(p, { name: "已审核（吨）", "text-color": "#626262", "num-color": "#16c14e", "end-val": ((t = d.value) == null ? void 0 : t.approvedWeight) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 }), l(c, { class: "card-panel-col custom-col" }, { default: s(() => {
      var t;
      return [l(p, { name: "未审核（条）", "text-color": "#626262", "num-color": "#f00a0a", "end-val": ((t = d.value) == null ? void 0 : t.unapprovedCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), l(c, { class: "card-panel-col custom-col" }, { default: s(() => {
      var t;
      return [l(p, { name: "工价总额（元）", "text-color": "#626262", "num-color": "#f00a0a", "end-val": ((t = d.value) == null ? void 0 : t.totalWage) || 0, precision: 2 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[P, w.value]]), m("div", ne, [m("div", null, [l(z, { modelValue: e(a).productTypeEnum, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).productTypeEnum = t), options: e(E).ENUM, type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(j, { modelValue: e(a).date, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(a).date = t), "default-time": Y.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: N }, null, 8, ["modelValue", "default-time"]), l(e(ee), { modelValue: e(a).workshopId, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(a).workshopId = t), placeholder: "车间筛选", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(X, { modelValue: e(a).projectId, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(a).projectId = t), class: "filter-item", style: { width: "200px" }, clearable: "", placeholder: "项目筛选", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(e(te), { modelValue: e(a).processId, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(a).processId = t), class: "filter-item", multiple: false, clearable: "", placeholder: "工序筛选", style: { width: "200px" }, "product-type": e(a).productTypeEnum, onChange: e(r).toQuery }, null, 8, ["modelValue", "product-type", "onChange"]), l(B, { modelValue: e(a).productSerialNumber, "onUpdate:modelValue": o[7] || (o[7] = (t) => e(a).productSerialNumber = t), placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: S(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(Z))]), m("div", re, [e(x)(e(D).eliminate) ? (i(), g(V, { key: 0, type: "danger", size: "default", disabled: !e(r).selections.length, loading: n.eliminateLoading, onClick: o[8] || (o[8] = (t) => _("toEliminate")) }, { default: s(() => o[11] || (o[11] = [b(" 剔除 ")])), _: 1, __: [11] }, 8, ["disabled", "loading"])) : C("", true), e(x)(e(D).passTheAudit) ? (i(), g(V, { key: 1, type: "success", size: "default", disabled: !e(r).selections.length, loading: n.adjustLoading, onClick: o[9] || (o[9] = (t) => _("toAdjust")) }, { default: s(() => o[12] || (o[12] = [b(" 审核通过 ")])), _: 1, __: [12] }, 8, ["disabled", "loading"])) : C("", true)])])]);
  };
} }, de = F(se, [["__scopeId", "data-v-4f5f956a"]]), ye = Object.freeze(Object.defineProperty({ __proto__: null, default: de }, Symbol.toStringTag, { value: "Module" }));
export {
  ge as c,
  ve as e,
  ye as h,
  de as m,
  fe as r
};
