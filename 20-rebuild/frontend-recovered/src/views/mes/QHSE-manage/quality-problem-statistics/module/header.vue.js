import i from "moment";
import { computed as S } from "vue";
import { ref as d } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as L } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as o } from "vue";
import { createBlock as x } from "vue";
import { withCtx as r } from "vue";
import { withKeys as g } from "vue";
import { createTextVNode as j } from "vue";
import { createCommentVNode as q } from "vue";
import { Fragment as z } from "vue";
import { ElDatePicker as $ } from "element-plus";
import { ElCascader as R } from "element-plus";
import { ElCol as A } from "element-plus";
import { ElRow as H } from "element-plus";
import { ElInput as M } from "element-plus";
import { vLoading as Y } from "element-plus";
import { P as F } from "../../../../../modules/index-5b9e6004.js";
import { a as G, g as J, b as W } from "../../../../../modules/index-d532b8ca.js";
import { _ as X, B as Z, A as ee, fv as ae, C as le, G as te, mV as oe, L as ne, E as se } from "../../../../../shared/runtime.js";
import { _ as re } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const de = { __name: "header", setup(ue) {
  const C = { date: [i().subtract(1, "months").valueOf(), i().valueOf()], startDate: i().subtract(1, "months").valueOf(), endDate: i().valueOf(), boolApp: false, type: 9, status: void 0, projectId: void 0, processId: void 0, serialNumber: void 0 }, D = S(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), { crud: s, query: l } = Z(C), u = d({}), h = d([]), V = d(), b = d(), c = d(false), Q = d([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  function N() {
    l.date && l.date.length > 1 ? (l.startDate = l.date[0], l.endDate = l.date[1]) : (l.startDate = void 0, l.endDate = void 0), s.toQuery();
  }
  async function T() {
    c.value = true;
    try {
      const n = await J();
      u.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      c.value = false;
    }
  }
  async function k() {
    try {
      const n = await W();
      h.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  function I(n) {
    V.value.popperVisible = false, n && n.length ? (l.levelOneType = n[0] || void 0, l.levelTwoType = n[1] || void 0) : (l.levelOneType = void 0, l.levelTwoType = void 0), s.toQuery();
  }
  return k(), T(), (n, t) => {
    const U = $, E = B("common-select"), P = R, m = F, p = A, K = H, f = M, O = Y;
    return y(), L(z, null, [_(v("div", null, [o(U, { modelValue: e(l).date, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).date = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: "", "value-format": "x", "default-time": Q.value, onChange: N }, null, 8, ["modelValue", "default-time"]), o(E, { modelValue: e(l).status, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).status = a), options: e(ee).ENUM, type: "enum", placeholder: "整改状态", class: "filter-item", clearable: "", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(re), { class: "filter-item", multiple: false, placeholder: "工序", clearable: "", modelValue: e(l).processId, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).processId = a), style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(P, { ref_key: "cascaderRef", ref: V, modelValue: b.value, "onUpdate:modelValue": t[3] || (t[3] = (a) => b.value = a), options: h.value, props: D.value, filterable: "", clearable: "", separator: " > ", "show-all-levels": "", placeholder: "质量分类", class: "filter-item", style: { width: "250px" }, onChange: I }, null, 8, ["modelValue", "options", "props"])], 512), [[w, e(s).searchToggle]]), v("div", null, [_((y(), x(K, { gutter: 20, class: "panel-group custom-row" }, { default: r(() => [o(p, { class: "card-panel-col custom-col" }, { default: r(() => {
      var a;
      return [o(m, { name: "全年质量问题总数", "text-color": "#626262", "num-color": "#f20a0a", "end-val": ((a = u.value) == null ? void 0 : a.totalQualityCurrentYear) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(p, { class: "card-panel-col custom-col" }, { default: r(() => {
      var a;
      return [o(m, { name: "已整改数量", "text-color": "#626262", "num-color": "#0a7565", "end-val": ((a = u.value) == null ? void 0 : a.rectifiedQuantity) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(p, { class: "card-panel-col custom-col" }, { default: r(() => {
      var a;
      return [o(m, { name: "让步接收", "text-color": "#626262", "num-color": "#f09e0e", "end-val": ((a = u.value) == null ? void 0 : a.concessionQuantity) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[O, c.value]])]), o(e(se), null, { optLeft: r(() => [_(v("div", null, [o(e(ae), { modelValue: e(l).projectId, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(l).projectId = a), style: { width: "200px" }, filterable: "", clearable: "", class: "filter-item", placeholder: "项目搜索", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(f, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(l).serialNumber = a), size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(f, { modelValue: e(l).userName, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(l).userName = a), size: "default", placeholder: "检查人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(f, { modelValue: e(l).dutyName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(l).dutyName = a), size: "default", placeholder: "责任人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: g(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(le))], 512), [[w, e(s).searchToggle]])]), viewLeft: r(() => {
      var a;
      return [e(te)(e(oe).export) ? (y(), x(ne, { key: 0, fn: e(G), params: (a = e(s)) == null ? void 0 : a.getQueryParams(), disabled: e(s).data.length === 0, class: "filter-item" }, { default: r(() => t[8] || (t[8] = [j(" 导出当前全部 ")])), _: 1, __: [8] }, 8, ["fn", "params", "disabled"])) : q("", true)];
    }), _: 1 })], 64);
  };
} }, ge = X(de, [["__scopeId", "data-v-8fcfdd0d"]]);
export {
  ge as default
};
