import { ref as w } from "vue";
import g from "moment";
import { computed as U } from "vue";
import { watch as D } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as C } from "vue";
import { vShow as A } from "vue";
import { unref as e } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as t } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as d } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElCol as P } from "element-plus";
import { ElRow as S } from "element-plus";
import { vLoading as q } from "element-plus";
import { g as j } from "../../../../../modules/scheduling-data-3ad04307.js";
import { jg as u, bo as p, B as z, aV as F, rE as H } from "../../../../../shared/runtime.js";
import { P as f } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const $ = { class: "head-container" }, te = { __name: "header", setup(J) {
  const h = w(false), o = w({}), N = { dateTime: g().startOf("year").valueOf(), type: u.ALL_YEAR.V, workshopId: void 0, weightType: p.NET.V }, { crud: r, query: a } = z(N), y = U(() => a.weightType === p.NET.V);
  function k(n) {
    n === u.ALL_YEAR.V ? a.dateTime = g().startOf("year").valueOf() : a.dateTime = g().startOf("month").valueOf(), i(), r.data = [], r.toQuery();
  }
  D(() => r.query, (n) => {
    i();
  }, { immediate: true });
  function V(n) {
    return /* @__PURE__ */ new Date() < n;
  }
  async function i() {
    h.value = true;
    try {
      const n = await j({ type: a.type, dateTime: a.dateTime, workshopId: a.workshopId });
      o.value = n || {};
    } catch (n) {
      console.log("获取排产数据汇总失败", n);
    } finally {
      h.value = false;
    }
  }
  function b() {
    i(), r.toQuery();
  }
  function Y() {
    i(), r.toQuery();
  }
  function x() {
    i(), r.toQuery();
  }
  function W() {
    i(), r.toQuery();
  }
  return (n, l) => {
    const _ = I("common-radio-button"), T = G, m = P, L = S, O = q, Q = M("permission");
    return c(), R("div", $, [C(B("div", null, [t(_, { modelValue: e(a).type, "onUpdate:modelValue": l[0] || (l[0] = (s) => e(a).type = s), options: e(u).ENUM, class: "filter-item", type: "enum", onChange: k }, null, 8, ["modelValue", "options"]), e(a).type === e(u).ALL_YEAR.V ? (c(), v(T, { key: 0, modelValue: e(a).dateTime, "onUpdate:modelValue": l[1] || (l[1] = (s) => e(a).dateTime = s), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "x", clearable: false, "disabled-date": V, onChange: b }, null, 8, ["modelValue"])) : E("", true), e(a).type === e(u).CURRENT_MONTH.V ? (c(), v(T, { key: 1, modelValue: e(a).dateTime, "onUpdate:modelValue": l[2] || (l[2] = (s) => e(a).dateTime = s), type: "month", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x", clearable: false, "disabled-date": V, onChange: Y }, null, 8, ["modelValue"])) : E("", true), t(F, { modelValue: e(a).workshopId, "onUpdate:modelValue": l[3] || (l[3] = (s) => e(a).workshopId = s), placeholder: "选择车间", style: { width: "200px" }, class: "filter-item", clearable: "", "factory-id": e(a).factoryId, onChange: x }, null, 8, ["modelValue", "factory-id"]), t(_, { type: "enum", modelValue: e(a).weightType, "onUpdate:modelValue": l[4] || (l[4] = (s) => e(a).weightType = s), options: e(p).ENUM, unshowVal: [e(p).NONE.V], class: "filter-item", onChange: W }, null, 8, ["modelValue", "options", "unshowVal"]), C((c(), v(L, { gutter: 24, class: "panel-group" }, { default: d(() => [t(m, { span: 6, class: "card-panel-col" }, { default: d(() => [t(e(f), { name: "排产总量(吨)", "text-color": "#626262", "num-color": "#1890ff", "end-val": (y.value ? o.value.schedulingTotalNetWeight : o.value.schedulingTotalGrossWeight) / 1e3 || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), t(m, { span: 6, class: "card-panel-col" }, { default: d(() => [t(e(f), { name: "排产项目数(个)", "text-color": "#626262", "num-color": "#F56C6C", endVal: o.value.projectQuantity || 0 }, null, 8, ["endVal"])]), _: 1 }), t(m, { span: 6, class: "card-panel-col" }, { default: d(() => [t(e(f), { name: "完成量(吨)", "text-color": "#626262", "num-color": "#F56C6C", endVal: (y.value ? o.value.completeTotalNetWeight : o.value.completeTotalGrossWeight) / 1e3 || 0, precision: 2 }, null, 8, ["endVal"])]), _: 1 }), t(m, { span: 6, class: "card-panel-col" }, { default: d(() => [t(e(f), { name: "完成率(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": y.value ? o.value.completeTotalNetWeight / o.value.schedulingTotalNetWeight * 100 || 0 : o.value.completeTotalGrossWeight / o.value.schedulingTotalGrossWeight * 100 || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[O, h.value], [Q, e(H).statistics]])], 512), [[A, e(r).searchToggle]])]);
  };
} };
export {
  te as default
};
