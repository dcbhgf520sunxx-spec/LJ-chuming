import { inject as L } from "vue";
import f from "moment";
import { computed as U } from "vue";
import { ref as h } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as b } from "vue";
import { createBlock as j } from "vue";
import { withCtx as s } from "vue";
import { withKeys as w } from "vue";
import { vShow as A } from "vue";
import { Fragment as M } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElCol as $ } from "element-plus";
import { ElRow as F } from "element-plus";
import { ElInput as H } from "element-plus";
import { vLoading as q } from "element-plus";
import { g as W } from "../../../../../modules/piecework-system-3800a6fe.js";
import { t as Y, B as G, a3 as m, I as J, aY as X, C as Z, E as ee, V as te, pr as ae, ps as oe, D as le } from "../../../../../shared/runtime.js";
import { P as E } from "../../../../../modules/index-5b9e6004.js";
import { _ as ne } from "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const fe = { __name: "header", setup(re) {
  const { decimalPrecision: O } = Y(), P = { productType: L("initProductType"), date: [f().subtract(1, "month").valueOf(), f().valueOf()], startDate: f().subtract(1, "month").valueOf(), endDate: f().valueOf() }, { crud: n, query: t, CRUD: N } = G(P), u = U(() => m.ENCLOSURE.V & t.productType ? m.ENCLOSURE.V : m.ARTIFACT.V), I = U(() => {
    if (u.value === m.ARTIFACT.V) return "mesStructureTeamWage";
    if (u.value === m.ENCLOSURE.V) return "mesEnclosureTeamWage";
  }), y = h(false), v = h(""), p = h({ mate: 0, price: 0, per: 0, mete_dp: 0 });
  async function S() {
    y.value = true;
    try {
      const { mate: i = 0, price: a = 0 } = await W(Object.assign(te(t), { productType: u.value })), { c_unit: _, unit: c, dp: r } = ae({ productType: u.value });
      v.value = _;
      const d = oe({ productType: u.value, weight: { num: i, to: c, dp: r }, length: { num: i, to: c, dp: r } }), g = d && a ? a / d : 0;
      p.value = { mete: d, mete_dp: le[r], price: a, per: g };
    } catch (i) {
      console.log("获取汇总数据", i);
    } finally {
      y.value = false;
    }
  }
  N.HOOK.beforeRefresh = () => {
    S();
  };
  function R() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), n.toQuery();
  }
  return (i, a) => {
    const _ = C("project-radio-button"), c = B, r = $, d = F, g = C("common-radio-button"), V = H, k = C("print-table"), x = q, K = z("permission");
    return D(), Q(M, null, [T("div", null, [o(_, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(c, { modelValue: e(t).date, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).date = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: e(J), "value-format": "x", onChange: R }, null, 8, ["modelValue", "shortcuts"]), o(e(ne), { modelValue: e(t).factoryId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).factoryId = l), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), T("div", null, [b((D(), j(d, { gutter: 20, style: { "margin-bottom": "15px" } }, { default: s(() => [o(r, { span: 8, class: "card-panel-col" }, { default: s(() => [o(e(E), { name: `制成品生产量（${v.value}）`, "num-color": "#1890ff", "end-val": p.value.mete || 0, precision: 2 }, null, 8, ["name", "end-val"])]), _: 1 }), o(r, { span: 8, class: "card-panel-col" }, { default: s(() => [o(e(E), { name: "工资总额（元）", "num-color": "#1890ff", "end-val": p.value.price || 0, precision: e(O).mes }, null, 8, ["end-val", "precision"])]), _: 1 }), o(r, { span: 8, class: "card-panel-col" }, { default: s(() => [o(e(E), { name: `平均人工费（元/${v.value}）`, "num-color": "#1890ff", "end-val": p.value.per || 0, precision: e(O).mes }, null, 8, ["name", "end-val", "precision"])]), _: 1 })]), _: 1 })), [[x, y.value]])]), o(e(ee), null, { optLeft: s(() => [b(T("div", null, [o(g, { modelValue: e(t).organizationType, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).organizationType = l), options: e(X).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(V, { modelValue: e(t).workshopName, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).workshopName = l), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "车间搜索", class: "filter-item", onKeyup: w(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(V, { modelValue: e(t).productionLineName, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).productionLineName = l), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "生产线搜索", class: "filter-item", onKeyup: w(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(V, { modelValue: e(t).processName, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).processName = l), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "工序搜索", class: "filter-item", onKeyup: w(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(Z))], 512), [[A, e(n).searchToggle]])]), viewLeft: s(() => [b(o(k, { "api-key": I.value, params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[K, e(n).permission.print]])]), _: 1 })], 64);
  };
} };
export {
  fe as default
};
