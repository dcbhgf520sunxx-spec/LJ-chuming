import { ref as s } from "vue";
import { resolveComponent as Q } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as q } from "vue";
import { withDirectives as E } from "vue";
import { vShow as K } from "vue";
import { unref as e } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { withKeys as N } from "vue";
import { withCtx as c } from "vue";
import { createBlock as L } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as v } from "vue";
import { Fragment as $ } from "vue";
import z from "moment";
import { ElDatePicker as P } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElTag as F } from "element-plus";
import { l as f, _ as R, B as Y, aV as G, q8 as J, C as X, L as Z, E as ee, i as A, bV as te } from "../../../../../shared/runtime.js";
import { _ as ae } from "../../../../../modules/project-select-94bb5bbd.js";
function oe(d) {
  return f({ url: "/api/mes/temp-work-record/page", method: "get", params: d });
}
function le(d) {
  return f({ url: "/api/mes/temp-work-record/summary", method: "get", params: d });
}
function ne() {
  return f({ url: "/api/mes/temp-work-record/cumulative-summary", method: "get" });
}
function re(d) {
  return f({ url: "/api/mes/temp-work-record/download", method: "get", responseType: "blob", params: d });
}
function de(d) {
  return f({ url: "/api/mes/building/wage-quota/temp-work-quota-config/select-list", method: "get", params: d });
}
const ge = { get: oe };
const ue = { class: "date-select filter-item" }, se = { class: "date-select filter-item" }, ie = { __name: "header", setup(d) {
  const T = { createDate: [], createStartDate: void 0, createEndDate: void 0, reportDate: [], reportStartDate: void 0, reportEndDate: void 0, workShopId: void 0, tempWorkQuotaConfigId: void 0, projectId: void 0, approvalStatus: void 0, teamName: void 0, reporterName: void 0 }, _ = s([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: r, CRUD: U, query: a } = Y(T), w = s(), V = s(), h = s(), k = s(), b = s([]);
  async function C(l, t, u) {
    try {
      t.value = "-", u.value = "-";
      const m = await l(a), { workHour: g, calculateAmount: p } = m || {};
      A(g) && (t.value = g), A(p) && (u.value = te(p));
    } catch (m) {
      console.log(m);
    }
  }
  function W() {
    return C(le, w, V);
  }
  function H() {
    return C(ne, h, k);
  }
  async function O() {
    try {
      const { content: l } = await de();
      b.value = l || [];
    } catch (l) {
      console.log(l);
    }
  }
  function D(l, t, u) {
    l && l.length > 1 ? (a[t] = z(l[0]).valueOf(), a[u] = z(l[1]).valueOf()) : (a[t] = void 0, a[u] = void 0), r.toQuery();
  }
  U.HOOK.beforeToQuery = () => {
    W(), H();
  }, O();
  function S(l) {
    return l > /* @__PURE__ */ new Date();
  }
  return (l, t) => {
    const u = P, m = Q("common-select"), g = Q("common-radio-button"), p = M, x = F, j = B("permission");
    return I(), q($, null, [E(i("div", null, [i("div", null, [i("div", ue, [t[10] || (t[10] = i("div", { class: "date-select-label" }, "创建日期", -1)), n(u, { modelValue: e(a).createDate, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).createDate = o), type: "daterange", "range-separator": ":", size: "default", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "default-time": _.value, "value-format": "x", "disabled-date": S, style: { width: "260px" }, onChange: t[1] || (t[1] = (o) => D(o, "createStartDate", "createEndDate")) }, null, 8, ["modelValue", "default-time"])]), i("div", se, [t[11] || (t[11] = i("div", { class: "date-select-label" }, "上报日期", -1)), n(u, { modelValue: e(a).reportDate, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).reportDate = o), type: "daterange", "range-separator": ":", size: "default", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "default-time": _.value, "value-format": "x", "disabled-date": S, style: { width: "260px" }, onChange: t[3] || (t[3] = (o) => D(o, "reportStartDate", "reportEndDate")) }, null, 8, ["modelValue", "default-time"])]), n(e(G), { ref: "workshopInfRef", modelValue: e(a).workShopId, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(a).workShopId = o), placeholder: "请选择车间", "factory-id": e(a).factoryId, style: { width: "200px" }, size: "default", class: "filter-item", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), n(m, { modelValue: e(a).tempWorkQuotaConfigId, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(a).tempWorkQuotaConfigId = o), dataStructure: { key: "id", label: "name", value: "id" }, options: b.value, placeholder: "点工类型", clearable: "", filterable: "", size: "default", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(ae), { modelValue: e(a).projectId, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(a).projectId = o), class: "filter-item", clearable: "", placeholder: "所属项目", style: { width: "300px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])]), n(g, { modelValue: e(a).approvalStatus, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(a).approvalStatus = o), options: e(J).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(a).teamName, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(a).teamName = o), placeholder: "所属班组检索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: N(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(p, { modelValue: e(a).reporterName, "onUpdate:modelValue": t[9] || (t[9] = (o) => e(a).reporterName = o), placeholder: "上报人检索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: N(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(X))], 512), [[K, e(r).searchToggle]]), n(e(ee), null, { optLeft: c(() => [E((I(), L(e(Z), { params: e(a), fn: e(re) }, { default: c(() => t[12] || (t[12] = [y(" 点工记录下载 ")])), _: 1, __: [12] }, 8, ["params", "fn"])), [[j, e(r).permission.download]])]), viewLeft: c(() => [n(x, { effect: "plain", size: "large" }, { default: c(() => [y("有效工时/核算金额：" + v(w.value) + "h / " + v(V.value) + "元", 1)]), _: 1 }), n(x, { type: "warning", effect: "plain", size: "large" }, { default: c(() => [y(" 累计有效工时/核算金额：" + v(h.value) + "h / " + v(k.value) + "元 ", 1)]), _: 1 })]), _: 1 })], 64);
  };
} }, me = R(ie, [["__scopeId", "data-v-12bd51b3"]]), ve = Object.freeze(Object.defineProperty({ __proto__: null, default: me }, Symbol.toStringTag, { value: "Module" }));
export {
  ge as c,
  ve as h,
  me as m
};
