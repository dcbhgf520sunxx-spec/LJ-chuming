import U from "moment";
import { inject as y } from "vue";
import { ref as j } from "vue";
import { computed as B } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as c } from "vue";
import { withCtx as i } from "vue";
import { normalizeStyle as Y } from "vue";
import { toDisplayString as g } from "vue";
import { withKeys as M } from "vue";
import { createTextVNode as P } from "vue";
import { Fragment as H } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElCol as W } from "element-plus";
import { ElCard as $ } from "element-plus";
import { ElRow as q } from "element-plus";
import { ElInput as R } from "element-plus";
import { vLoading as F } from "element-plus";
import { d as G } from "../../../../../modules/work-in-progress-statistics-5c372d83.js";
import { _ as O, sw as b, B as A, aV as J, a as w, C as X, L as Z } from "../../../../../shared/runtime.js";
import { P as ee } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const oe = { class: "card-description" }, ae = { class: "flex-rbc card-right" }, te = { class: "card-svg" }, se = { key: 2, class: "card-svg-text", style: { color: "#f00a0a" } }, le = { key: 3, class: "card-svg-text", style: { color: "#18b95e" } }, ne = { class: "search-box" }, re = { __name: "header", setup(de) {
  const x = { date: U().valueOf(), branchCompanyId: void 0, workShopId: void 0, showType: b.WEIGHT.V, projectSerialNumber: void 0 }, V = y("branchList"), u = y("summaryInfo"), C = j(false), { crud: r, query: t } = A(x), m = B(() => {
    var d;
    return ((d = u.value) == null ? void 0 : d.growthWeight) >= 0;
  });
  function k(d) {
    return d > /* @__PURE__ */ new Date();
  }
  return (d, o) => {
    const I = K, S = h("common-select"), E = h("component-radio-button"), _ = W, z = $, D = q, N = R, Q = F, T = L("permission");
    return n(), p(H, null, [l("div", null, [s(I, { style: { width: "140px" }, modelValue: e(t).date, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).date = a), type: "date", size: "default", class: "filter-item", format: "YYYY-MM-DD", "value-format": "x", clearable: "", placeholder: "请选择日期", "disabled-date": k, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), s(S, { modelValue: e(t).branchCompanyId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).branchCompanyId = a), options: e(V), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", class: "filter-item", placeholder: "机构", style: { width: "300px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(e(J), { modelValue: e(t).workShopId, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).workShopId = a), placeholder: "车间", style: { width: "200px" }, size: "default", class: "filter-item", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), s(E, { modelValue: e(t).showType, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).showType = a), options: e(b).ENUM, type: "enum", size: "default", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), v((n(), c(D, { gutter: 20, class: "panel-group" }, { default: i(() => [s(_, { span: 8 }, { default: i(() => {
      var a;
      return [s(e(ee), { name: "昨日在制品库存（吨）:", "text-color": "#626262", "num-color": "#18b95e", "end-val": ((a = e(u)) == null ? void 0 : a.yesterdaySInventory) || 0, precision: 5 }, null, 8, ["end-val"])];
    }), _: 1 }), s(_, { span: 8 }, { default: i(() => [s(z, null, { default: i(() => {
      var a, f;
      return [l("div", oe, [o[6] || (o[6] = l("div", { class: "card-text" }, "较前日对比：", -1)), l("div", ae, [l("div", te, [m.value ? (n(), c(e(w), { key: 0, "icon-class": "mes-rising-trend", style: { "font-size": "32px" } })) : (n(), c(e(w), { key: 1, "icon-class": "mes-downtrend", style: { "font-size": "32px" } })), o[5] || (o[5] = l("br", null, null, -1)), m.value ? (n(), p("span", se, "增 长")) : (n(), p("span", le, "下降"))]), l("div", { class: "card-num", style: Y({ color: m.value ? "#f00a0a" : "#18b95e" }) }, g(((a = e(u)) == null ? void 0 : a.growthWeight) || 0) + " (" + g(((f = e(u)) == null ? void 0 : f.rate) || 0) + "%) ", 5)])])];
    }), _: 1 })]), _: 1 })]), _: 1 })), [[Q, C.value]]), l("div", ne, [l("div", null, [s(N, { modelValue: e(t).projectSerialNumber, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).projectSerialNumber = a), modelModifiers: { trim: true }, placeholder: "项目编号或名称搜索", class: "filter-item", style: { width: "280px" }, size: "default", clearable: "", onKeyup: M(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(X))]), v((n(), c(Z, { params: e(t), fn: e(G), "response-header-result": "" }, { default: i(() => o[7] || (o[7] = [P(" 在制品统计报表 ")])), _: 1, __: [7] }, 8, ["params", "fn"])), [[T, e(r).permission.export]])])], 64);
  };
} }, _e = O(re, [["__scopeId", "data-v-d3f75f75"]]);
export {
  _e as default
};
