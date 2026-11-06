import { ref as L } from "vue";
import { reactive as P } from "vue";
import { inject as S } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as E } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as g } from "vue";
import { withKeys as Q } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElCol as B } from "element-plus";
import { ElRow as N } from "element-plus";
import { ElInput as j } from "element-plus";
import { vLoading as F } from "element-plus";
import { g as K } from "../../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { _ as H, p as O, B as q, aV as M, sr as T, C as $ } from "../../../../../shared/runtime.js";
import { P as c } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const z = { class: "flex-rbc" }, A = { __name: "header", setup(G) {
  const f = { year: O(/* @__PURE__ */ new Date(), "{y}"), branchCompanyId: void 0, workShopId: void 0, status: void 0 }, { crud: r, CRUD: y, query: a } = q(f), m = L(false), s = P({ totalFeedingWeight: 0, totalPickingWeight: 0, totalReportWeight: 0, avgLossRate: 0 }), h = S("branchList");
  async function v() {
    m.value = true;
    try {
      const l = await K(a);
      s.totalFeedingWeight = l.totalFeedingWeight, s.totalPickingWeight = l.totalPickingWeight, s.totalReportWeight = l.totalReportWeight, s.avgLossRate = l.avgLossRate;
    } catch (l) {
      console.log("汇总信息", l);
    } finally {
      m.value = false;
    }
  }
  y.HOOK.beforeToQuery = (l, o) => {
    v();
  };
  function b(l) {
    return l > /* @__PURE__ */ new Date();
  }
  return (l, o) => {
    const V = U, w = u("common-select"), C = u("component-radio-button"), d = B, x = N, k = j, W = u("print-table"), R = F, I = Y("permission");
    return p(), D("div", null, [t(V, { modelValue: e(a).year, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(a).year = n), type: "year", size: "small", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", clearable: false, "disabled-date": b, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), t(w, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(a).branchCompanyId = n), options: e(h), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", class: "filter-item", placeholder: "机构", style: { width: "320px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(e(M), { modelValue: e(a).workShopId, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(a).workShopId = n), placeholder: "车间", style: { width: "200px" }, class: "filter-item", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), t(C, { modelValue: e(a).status, "onUpdate:modelValue": o[3] || (o[3] = (n) => e(a).status = n), options: e(T).ENUM, showOptionAll: true, type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), _((p(), E(x, { gutter: 20, class: "panel-group" }, { default: i(() => [t(d, { span: 6 }, { default: i(() => [t(e(c), { name: "投料总量（吨）:", "text-color": "#626262", "num-color": "#18b95e", "end-val": s.totalFeedingWeight || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), t(d, { span: 6 }, { default: i(() => [t(e(c), { name: "领料总量（吨）:", "text-color": "#626262", "num-color": "#18b95e", "end-val": s.totalPickingWeight || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), t(d, { span: 6 }, { default: i(() => [t(e(c), { name: "生产总量（吨）:", "text-color": "#626262", "num-color": "#18b95e", "end-val": s.totalReportWeight || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), t(d, { span: 6 }, { default: i(() => [t(e(c), { name: "平均损耗率:", "text-color": "#626262", "num-color": "#18b95e", "end-val": s.avgLossRate || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[R, m.value]]), g("div", z, [g("div", null, [t(k, { modelValue: e(a).projectName, "onUpdate:modelValue": o[4] || (o[4] = (n) => e(a).projectName = n), modelModifiers: { trim: true }, placeholder: "项目搜索", class: "filter-item", style: { width: "280px" }, clearable: "", onKeyup: Q(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e($))]), _(t(W, { "api-key": "lossStatisticsV2", params: e(a), type: "warning", class: "filter-item" }, null, 8, ["params"]), [[I, e(r).permission.print]])])]);
  };
} }, ae = H(A, [["__scopeId", "data-v-cd7b0366"]]);
export {
  ae as default
};
