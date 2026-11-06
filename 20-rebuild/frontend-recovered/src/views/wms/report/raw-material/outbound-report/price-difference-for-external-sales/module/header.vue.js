import { ref as M } from "vue";
import { inject as L } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as Y } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as T } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as h } from "vue";
import { withKeys as E } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as g } from "vue";
import { ElCol as W } from "element-plus";
import { ElRow as A } from "element-plus";
import { ElDatePicker as F } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElTag as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { P as X } from "../../../../../../../modules/index-5b9e6004.js";
import { l as S, jY as Z, B as ee, sQ as ae, G as le, cJ as oe, bR as I, I as U, gF as te, ap as ne, fD as se, ya as re, C as ie, L as ue, i as de, bV as N, j_ as me, E as ce } from "../../../../../../../shared/runtime.js";
import { r as pe } from "../../../../../../../modules/reset-query-5216307c.js";
import "../../../../../../../modules/vue3-count-to.esm-8987f38d.js";
function fe(i) {
  return S({ module: "wms_v2", url: "report/raw-materials/forSale/difference/outbound/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: i });
}
function he(i) {
  return S({ module: "wms_v2", url: "report/raw-materials/outbound/forSale/statistics", method: "get", params: i });
}
const ye = { class: "head-container" }, ge = { key: 0 }, be = { class: "flex gap-2" }, xe = { __name: "header", props: { DetailsCount: { type: Object } }, setup(i) {
  Z();
  const b = M([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), w = i, Q = { basicClass: void 0, measuringMethod: void 0, outboundTime: [], workshopId: void 0, warehouseId: void 0, outboundSN: void 0, reviewTime: void 0, operatorName: void 0, classifyId: void 0, branchCompanyId: void 0 }, r = M({}), P = L("permission"), { crud: n, query: a } = ee(Q), { baseUnit: B } = ae(a.basicClass);
  async function j(d) {
    await pe(a), n.toQuery(), n.data = [], n.setColumns();
  }
  async function z() {
    let d = {};
    try {
      d = await he() || {};
    } catch (l) {
      console.log("获取项目数量", l);
    } finally {
      r.value = d;
    }
  }
  return R(() => {
    z();
  }), (d, l) => {
    const m = X, c = W, O = A, C = Y("common-radio-button"), _ = F, v = H, V = G, q = J, K = $("permission");
    return u(), T("div", ye, [e(n).searchToggle ? (u(), T("div", ge, [e(le)(e(n).permission.get) ? k((u(), p(O, { key: 0, gutter: 24, class: "panel-group" }, { default: s(() => [t(c, { span: 6, class: "card-panel-col" }, { default: s(() => [t(m, { "end-val": r.value.accumulativeDifference || 0, "num-color": r.value.nowYearDifference >= 0 ? "#67c23a" : "#fa0303", precision: 2, name: "累计差异（元）", "text-color": "#626262" }, null, 8, ["end-val", "num-color"])]), _: 1 }), t(c, { span: 6, class: "card-panel-col" }, { default: s(() => [t(m, { "end-val": r.value.nowYearDifference || 0, "num-color": r.value.nowYearDifference >= 0 ? "#67c23a" : "#fa0303", precision: 2, name: "本年差异（元）", "text-color": "#626262" }, null, 8, ["end-val", "num-color"])]), _: 1 }), t(c, { span: 6, class: "card-panel-col" }, { default: s(() => [t(m, { "end-val": r.value.nowMonthDifference || 0, "num-color": r.value.nowYearDifference >= 0 ? "#67c23a" : "#fa0303", precision: 2, name: "本月差异（元）", "text-color": "#626262" }, null, 8, ["end-val", "num-color"])]), _: 1 }), t(c, { span: 6, class: "card-panel-col" }, { default: s(() => [t(m, { "end-val": r.value.lastMonthDifference || 0, "num-color": r.value.nowYearDifference >= 0 ? "#67c23a" : "#fa0303", precision: 2, name: "上月差异（元）", "text-color": "#626262" }, null, 8, ["end-val", "num-color"])]), _: 1 })]), _: 1 })), [[q, e(n).loading]]) : f("", true), l[10] || (l[10] = h("br", null, null, -1)), t(re, { "basic-class": e(a).basicClass, query: e(a), "show-material-is-whole": false, "to-query": e(n).toQuery, multiple: "" }, { afterProjectWarehouseType: s(() => [t(C, { modelValue: e(a).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).basicClass = o), options: e(oe).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: j }, null, 8, ["modelValue", "options"]), t(C, { modelValue: e(a).weightMeasurementMode, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).weightMeasurementMode = o), options: e(I).ENUM, unshowVal: [e(I).MIXTURE.V], class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), t(_, { modelValue: e(a).materialOutboundTime, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).materialOutboundTime = o), "default-time": b.value, shortcuts: e(U), class: "filter-item", "end-placeholder": "出库时间", "range-separator": ":", size: "default", "start-placeholder": "出库时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), t(_, { modelValue: e(a).outboundTime, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(a).outboundTime = o), "default-time": b.value, shortcuts: e(U), class: "filter-item", "end-placeholder": "审核时间", "range-separator": ":", size: "default", "start-placeholder": "审核时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"])]), beforeWarehouse: s(() => [t(te, { modelValue: e(a).workshopId, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(a).workshopId = o), class: "filter-item", clearable: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), secondLineFirstItem: s(() => [t(v, { modelValue: e(a).outboundSN, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(a).outboundSN = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "240px" }, onKeyup: E(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(v, { modelValue: e(a).operatorName, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(a).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "160px" }, onKeyup: E(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(ne, { modelValue: e(a).classifyId, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(a).classifyId = o), "basic-class": e(a).basicClass, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), t(se, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(a).branchCompanyId = o), class: "filter-item", clearable: "", filterable: "", placeholder: "请选择关联交易单位", style: { width: "240px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l[9] || (l[9] = h("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), t(e(ie))])) : f("", true), t(e(ce), null, { optLeft: s(() => [k((u(), p(ue, { fn: e(fe), params: e(a), "response-header-result": "" }, { default: s(() => l[11] || (l[11] = [y(" 下载价格明细表（根据查询条件） ")])), _: 1, __: [11] }, 8, ["fn", "params"])), [[K, e(P).get]])]), viewLeft: s(() => [h("div", be, [e(de)(e(a).basicClass) ? (u(), p(V, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: s(() => {
      var o, x, D;
      return [y(" 重量差异汇总：" + g(e(N)(((o = w.DetailsCount) == null ? void 0 : o.differenceMeteSum) || 0)) + " " + g(((x = e(a)) == null ? void 0 : x.basicClass) & e(me).STEEL.V ? e(B)[(D = e(a)) == null ? void 0 : D.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : f("", true), t(V, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: s(() => {
      var o;
      return [y(" 价格差异汇总：" + g(e(N)(((o = w.DetailsCount) == null ? void 0 : o.profitAmountSum) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} };
export {
  xe as default
};
