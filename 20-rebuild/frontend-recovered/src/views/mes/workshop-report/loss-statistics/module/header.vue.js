import { reactive as P } from "vue";
import { ref as S } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as W } from "vue";
import { Fragment as E } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElCol as D } from "element-plus";
import { ElRow as j } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as Q, b as U } from "../../../../../modules/loss-statistics-d681f3ee.js";
import { _ as L, p as N, B as z, aV as $, su as q, bb as H, C as M, ss as T, L as A } from "../../../../../shared/runtime.js";
import { P as i } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const F = { class: "search-box" }, O = { __name: "header", setup(G, { expose: g }) {
  const y = { year: N(/* @__PURE__ */ new Date(), "{y}"), status: void 0, workShopId: void 0 }, s = P({ totalYearProduction: 0, totalYearSteelPicking: 0, totalYearWastage: 0, totalYearWastageRate: 0 }), u = S(false), { crud: c, query: t } = z(y);
  function v(l) {
    return l > /* @__PURE__ */ new Date();
  }
  async function Y() {
    u.value = true;
    try {
      const l = await U(t);
      s.totalYearProduction = l.totalYearProduction, s.totalYearSteelPicking = l.totalYearSteelPicking, s.totalYearWastage = l.totalYearWastage, s.totalYearWastageRate = l.totalYearWastageRate;
    } catch (l) {
      console.log("汇总信息", l);
    } finally {
      u.value = false;
    }
  }
  return g({ fetchSummary: Y }), (l, o) => {
    const x = R, h = k("component-radio-button"), d = D, V = j, w = B, b = C("permission");
    return m(), I(E, null, [p("div", null, [a(x, { style: { "margin-right": "5px", width: "120px" }, modelValue: e(t).year, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(t).year = n), clearable: false, type: "year", size: "default", class: "filter-item", format: "YYYY", "value-format": "YYYY", placeholder: "请选择年", "disabled-date": v, onChange: e(c).toQuery }, null, 8, ["modelValue", "onChange"]), a(e($), { ref: "workshopInfRef", modelValue: e(t).workShopId, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(t).workShopId = n), placeholder: "请选择车间", "factory-id": e(t).factoryId, style: { width: "200px" }, size: "default", class: "filter-item", clearable: "", onChange: e(c).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), a(h, { modelValue: e(t).status, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(t).status = n), options: e(q).ENUM, showOptionAll: true, type: "enum", size: "default", class: "filter-item", onChange: e(c).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(H, { modelValue: e(t).projectIds, "onUpdate:modelValue": o[3] || (o[3] = (n) => e(t).projectIds = n), class: "filter-item", clearable: "", style: { width: "300px" }, onChange: e(c).toQuery }, null, 8, ["modelValue", "onChange"]), a(e(M))]), f((m(), _(V, { gutter: 20, class: "panel-group" }, { default: r(() => [a(d, { span: 6, class: "card-panel-col" }, { default: r(() => [a(e(i), { name: "年度累计生产量（吨）:", "text-color": "#626262", "num-color": "#1890ff", "end-val": s.totalYearProduction || 0, precision: 5 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: r(() => [a(e(i), { name: "年度累计钢材领用（吨）：", "text-color": "#626262", "num-color": "#1890ff", "end-val": s.totalYearSteelPicking || 0, precision: 5 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: r(() => [a(e(i), { name: "年度损耗（吨）：", "text-color": "#626262", "num-color": "#f56c6c", "end-val": s.totalYearWastage || 0, precision: 5 }, null, 8, ["end-val"])]), _: 1 }), a(d, { span: 6, class: "card-panel-col" }, { default: r(() => [a(e(i), { name: "年度平均损耗：", "text-color": "#626262", "num-color": "#f56c6c", "end-val": s.totalYearWastageRate || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[w, u.value]]), p("div", F, [f((m(), _(A, { params: e(t), fn: e(Q) }, { default: r(() => o[4] || (o[4] = [W(" 损耗统计报表 ")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[b, e(T).export]])])], 64);
  };
} }, ae = L(O, [["__scopeId", "data-v-d06906fc"]]);
export {
  ae as default
};
