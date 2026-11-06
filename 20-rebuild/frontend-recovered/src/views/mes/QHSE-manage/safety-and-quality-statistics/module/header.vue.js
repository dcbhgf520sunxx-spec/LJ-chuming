import i from "moment";
import { computed as B } from "vue";
import { ref as d } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as K } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { createElementVNode as w } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as b } from "vue";
import { withCtx as r } from "vue";
import { withKeys as x } from "vue";
import { vShow as L } from "vue";
import { createTextVNode as z } from "vue";
import { createCommentVNode as A } from "vue";
import { Fragment as R } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElCascader as H } from "element-plus";
import { ElCol as M } from "element-plus";
import { ElRow as Y } from "element-plus";
import { ElInput as $ } from "element-plus";
import { vLoading as F } from "element-plus";
import { P as G } from "../../../../../modules/index-5b9e6004.js";
import { l as _, _ as Z, B as J, A as W, C as X, G as ee, mZ as ae, L as te, E as le } from "../../../../../shared/runtime.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
function oe(u) {
  return _({ module: "mes", url: "qhse/safety_and_quality/summary", method: "get", params: u });
}
function ne(u) {
  return _({ module: "mes", url: "safety/config/tree", method: "get", params: u });
}
function se(u) {
  return _({ module: "mes", url: "qhse/export/list", responseType: "blob", method: "get", params: u });
}
const re = { __name: "header", setup(u) {
  const C = { date: [i().subtract(1, "months").valueOf(), i().valueOf()], startDate: i().subtract(1, "months").valueOf(), endDate: i().valueOf(), boolApp: false, type: 6, status: void 0, dutyName: void 0, userName: void 0, projectId: void 0 }, { crud: s, query: e } = J(C), D = B(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), c = d({}), v = d([]), g = d(), T = d([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), m = d(false);
  function N() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), s.toQuery();
  }
  async function Q() {
    m.value = true;
    try {
      const l = await oe();
      c.value = l || {};
    } catch (l) {
      console.log(l);
    } finally {
      m.value = false;
    }
  }
  async function k() {
    try {
      const l = await ne({});
      v.value = l || [];
    } catch (l) {
      console.log(l);
    }
  }
  k(), Q();
  function E(l) {
    g.value.popperVisible = false, l && l.length ? (e.levelOneType = l[0] || void 0, e.levelTwoType = l[1] || void 0) : (e.levelOneType = void 0, e.levelTwoType = void 0), s.toQuery();
  }
  return (l, n) => {
    const P = j, S = I("common-select"), O = H, p = G, f = M, U = Y, h = $, q = F;
    return y(), K(R, null, [o(P, { modelValue: a(e).date, "onUpdate:modelValue": n[0] || (n[0] = (t) => a(e).date = t), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, "value-format": "x", "default-time": T.value, onChange: N }, null, 8, ["modelValue", "default-time"]), o(S, { modelValue: a(e).status, "onUpdate:modelValue": n[1] || (n[1] = (t) => a(e).status = t), options: a(W).ENUM, type: "enum", placeholder: "整改状态", class: "filter-item", clearable: "", onChange: a(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(O, { ref_key: "cascaderRef", ref: g, modelValue: a(e).line, "onUpdate:modelValue": n[2] || (n[2] = (t) => a(e).line = t), options: v.value, props: D.value, filterable: "", clearable: "", separator: " > ", "show-all-levels": "", placeholder: "安环分类", class: "filter-item", style: { width: "250px" }, onChange: E }, null, 8, ["modelValue", "options", "props"]), w("div", null, [V((y(), b(U, { gutter: 20, class: "panel-group custom-row" }, { default: r(() => [o(f, { class: "card-panel-col custom-col" }, { default: r(() => {
      var t;
      return [o(p, { name: "全年安环问题总数", "text-color": "#626262", "num-color": "#f20a0a", "end-val": ((t = c.value) == null ? void 0 : t.totalQualityCurrentYear) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(f, { class: "card-panel-col custom-col" }, { default: r(() => {
      var t;
      return [o(p, { name: "已整改数量", "text-color": "#626262", "num-color": "#0a7565", "end-val": ((t = c.value) == null ? void 0 : t.rectifiedQuantity) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(f, { class: "card-panel-col custom-col" }, { default: r(() => {
      var t;
      return [o(p, { name: "让步接收", "text-color": "#626262", "num-color": "#f09e0e", "end-val": ((t = c.value) == null ? void 0 : t.concessionQuantity) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[q, m.value]])]), o(a(le), null, { optLeft: r(() => [V(w("div", null, [o(h, { modelValue: a(e).userName, "onUpdate:modelValue": n[3] || (n[3] = (t) => a(e).userName = t), size: "default", placeholder: "检查人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: x(a(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(h, { modelValue: a(e).dutyName, "onUpdate:modelValue": n[4] || (n[4] = (t) => a(e).dutyName = t), size: "default", placeholder: "责任人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: x(a(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(a(X))], 512), [[L, a(s).searchToggle]])]), viewLeft: r(() => {
      var t;
      return [a(ee)(a(ae).export) ? (y(), b(te, { key: 0, fn: a(se), params: (t = a(s)) == null ? void 0 : t.getQueryParams(), disabled: a(s).data.length === 0, class: "filter-item" }, { default: r(() => n[5] || (n[5] = [z(" 导出当前全部 ")])), _: 1, __: [5] }, 8, ["fn", "params", "disabled"])) : A("", true)];
    }), _: 1 })], 64);
  };
} }, me = Z(re, [["__scopeId", "data-v-16c89aa6"]]);
export {
  me as default
};
