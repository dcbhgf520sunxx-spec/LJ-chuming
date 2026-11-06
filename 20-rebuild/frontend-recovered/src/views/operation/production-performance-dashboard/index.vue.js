import { ref as r } from "vue";
import C from "moment";
import { watch as H } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { withCtx as _ } from "vue";
import { ElDatePicker as $ } from "element-plus";
import { ElCol as B } from "element-plus";
import { ElRow as M } from "element-plus";
import { ElDivider as N } from "element-plus";
import { P as E } from "../../../modules/index-5b9e6004.js";
import { d as z } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { G, c as b, g3 as L, iH as j, fa as f, aV as h } from "../../../shared/runtime.js";
import { f as u } from "../../../modules/operation-4e9312fe.js";
import T from "./target-yield-rate.vue.js";
import A from "./workshop-monthly-analysis.vue.js";
import O from "./workshop-dayly-analysis.vue.js";
import S from "./average-task-rate.vue.js";
import R from "./workshop-task-rate.vue.js";
import F from "./average-loss-rate.vue.js";
import J from "./material-loss-analysis.vue.js";
import K from "./personal-production-analysis.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
import "./target-yield-rate-detail.vue.js";
import "./workshop-monthly-analysis-detail.vue.js";
import "./workshop-dayly-analysis-detail.vue.js";
import "./average-task-rate-detail.vue.js";
import "../../../modules/use-chart-v2-ba3ec3fa.js";
import "./workshop-task-rate-detail.vue.js";
import "./average-loss-rate-detail.vue.js";
import "./material-loss-analysis-detail.vue.js";
const Q = { class: "app-container" }, X = { class: "head-container" }, Z = { style: { display: "flex", "align-items": "center", "justify-content": "space-between", "margin-bottom": "8px" } }, ee = { style: { display: "flex" } }, oe = { style: { width: "29%" } }, le = { style: { width: "70%", "margin-left": "20px" } }, te = { style: { display: "flex" } }, ae = { style: { flex: "1" } }, se = { style: { display: "flex", "align-items": "center", "justify-content": "space-between", "margin-bottom": "8px" } }, ne = { style: { display: "flex" } }, re = { style: { width: "29%" } }, ie = { style: { width: "70%", "margin-left": "20px" } }, de = { style: { display: "flex", "align-items": "center", "justify-content": "space-between", "margin-bottom": "8px" } }, ue = { style: { display: "flex" } }, pe = { style: { width: "29%" } }, me = { style: { width: "70%", "margin-left": "20px" } }, ce = { style: { display: "flex", "justify-content": "space-between", "align-items": "center", "margin-bottom": "8px" } }, ze = { __name: "index", setup(fe) {
  const a = r({ yearDate: C().valueOf(), branchCompanyId: void 0, workshopId: void 0 }), p = r(), m = r(), c = r(), w = r(), v = r(), i = r({}), d = r({}), I = r(false);
  H(() => a.value, (s) => {
    g();
  }, { immediate: true, deep: true });
  function V(s) {
    return s > /* @__PURE__ */ new Date();
  }
  async function g() {
    if (G(u.get)) try {
      I.value = true;
      const s = await z({ ...a.value });
      d.value = s || {}, d.value.totalMete = b(d.value.totalMete, "kg", "t", 0), d.value.lastYearTotalMete = b(d.value.lastYearTotalMete, "kg", "t", 0);
    } catch (s) {
      console.log(s);
    } finally {
      I.value = false;
    }
  }
  async function W(s) {
    p.value = s, m.value = s, c.value = s, w.value = s, v.value = s, await g();
  }
  function q(s) {
    i.value = s;
  }
  return (s, l) => {
    const D = $, k = E, x = B, U = M, y = N;
    return P(), Y("div", Q, [o("div", X, [e(D, { modelValue: a.value.yearDate, "onUpdate:modelValue": l[0] || (l[0] = (n) => a.value.yearDate = n), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", "disabled-date": V }, null, 8, ["modelValue"]), e(j, { modelValue: a.value.branchCompanyId, "onUpdate:modelValue": l[1] || (l[1] = (n) => a.value.branchCompanyId = n), class: "filter-item", clearable: "", level: t(L).COMPANY.V, placeholder: "选择分支机构", style: { width: "260px" }, onCurrentChange: q }, null, 8, ["modelValue", "level"]), e(t(h), { modelValue: a.value.workshopId, "onUpdate:modelValue": l[2] || (l[2] = (n) => a.value.workshopId = n), placeholder: "请选择车间", "workshop-type": t(f).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "", onChange: W }, null, 8, ["modelValue", "workshop-type"]), e(U, { gutter: 24, loading: I.value, class: "panel-group" }, { default: _(() => [e(x, { span: 8, class: "card-panel-col" }, { default: _(() => [e(k, { name: "累计产量(吨)", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.totalMete || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(x, { span: 8, class: "card-panel-col" }, { default: _(() => [e(k, { name: "去年同期(吨)", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.lastYearTotalMete || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(x, { span: 8, class: "card-panel-col" }, { default: _(() => [e(k, { name: "同比增长(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.ratio || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }, 8, ["loading"])]), o("div", null, [o("div", Z, [l[7] || (l[7] = o("div", { style: { "font-size": "18px", "font-weight": "bold", "margin-right": "20px" } }, "车间产量统计", -1)), e(t(h), { modelValue: p.value, "onUpdate:modelValue": l[3] || (l[3] = (n) => p.value = n), placeholder: "请选择车间", "workshop-type": t(f).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), o("div", ee, [o("div", oe, [e(T, { maxHeight: 220, query: a.value, productWorkshopId: p.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "productWorkshopId", "branchInfo", "permission"])]), o("div", le, [e(A, { maxHeight: 220, query: a.value, productWorkshopId: p.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "productWorkshopId", "branchInfo", "permission"])])]), e(y, { class: "divider" }), o("div", te, [o("div", ae, [e(O, { maxHeight: 230, query: a.value, productWorkshopId: p.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "productWorkshopId", "branchInfo", "permission"])])])]), e(y, { class: "divider" }), o("div", null, [o("div", se, [l[8] || (l[8] = o("div", { style: { "font-size": "18px", "font-weight": "bold", "margin-right": "20px" } }, "车间任务达成率分析", -1)), e(t(h), { modelValue: m.value, "onUpdate:modelValue": l[4] || (l[4] = (n) => m.value = n), placeholder: "请选择车间", "workshop-type": t(f).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), o("div", ne, [o("div", re, [e(S, { maxHeight: 220, query: a.value, taskWorkshopId: m.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "taskWorkshopId", "branchInfo", "permission"])]), o("div", ie, [e(R, { maxHeight: 220, query: a.value, taskWorkshopId: m.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "taskWorkshopId", "branchInfo", "permission"])])])]), e(y, { class: "divider" }), o("div", null, [o("div", de, [l[9] || (l[9] = o("div", { style: { "font-size": "18px", "font-weight": "bold", "margin-right": "20px" } }, "主材损耗分析", -1)), e(t(h), { modelValue: c.value, "onUpdate:modelValue": l[5] || (l[5] = (n) => c.value = n), placeholder: "请选择车间", "workshop-type": t(f).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), o("div", ue, [o("div", pe, [e(F, { maxHeight: 220, query: a.value, lossWorkshopId: c.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "lossWorkshopId", "branchInfo", "permission"])]), o("div", me, [e(J, { maxHeight: 220, query: a.value, lossWorkshopId: c.value, branchInfo: i.value, permission: t(u) }, null, 8, ["query", "lossWorkshopId", "branchInfo", "permission"])])])]), e(y, { class: "divider" }), o("div", null, [o("div", ce, [l[10] || (l[10] = o("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "人均产量分析", -1)), e(t(h), { modelValue: v.value, "onUpdate:modelValue": l[6] || (l[6] = (n) => v.value = n), placeholder: "请选择车间", "workshop-type": t(f).BUILDING.V, style: { width: "200px" }, class: "filter-item", size: "small", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), e(K, { maxHeight: 200, query: a.value, personalWorkshopId: v.value }, null, 8, ["query", "personalWorkshopId"])])]);
  };
} };
export {
  ze as default
};
