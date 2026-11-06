import { ref as T } from "vue";
import { inject as v } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { withKeys as c } from "vue";
import { createElementVNode as f } from "vue";
import { createCommentVNode as Q } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as D } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElInput as O } from "element-plus";
import { ElTag as W } from "element-plus";
import { e as z } from "../../../../../../../modules/external-sales-details-a890aa63.js";
import { B, sQ as q, cJ as K, bR as y, I as b, gF as L, y3 as R, ap as $, fD as j, ya as P, C as F, L as H, bV as A, E as J } from "../../../../../../../shared/runtime.js";
import { r as X } from "../../../../../../../modules/reset-query-5216307c.js";
const G = { class: "head-container" }, Y = { key: 0 }, Z = { class: "flex gap-2" }, se = { __name: "header", props: { DetailsCount: { type: Object } }, setup(C) {
  const V = C, u = T([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), g = { basicClass: void 0, measuringMethod: void 0, outboundTime: [], sourceWorkshopIds: void 0, warehouseId: void 0, outboundSN: void 0, materialOutboundTime: void 0, operatorName: void 0, classifyId: void 0, branchCompanyId: void 0 }, w = v("permission"), { crud: s, query: a } = B(g);
  q(a.basicClass);
  async function _(I) {
    await X(a), s.toQuery(), s.data = [], s.setColumns();
  }
  return (I, l) => {
    const i = M("common-radio-button"), d = S, m = O, x = W, k = U("permission");
    return r(), p("div", G, [e(s).searchToggle ? (r(), p("div", Y, [t(P, { "basic-class": e(a).basicClass, query: e(a), "show-material-is-whole": false, showWarehouse: false, "to-query": e(s).toQuery, multiple: "", spcLabel: "型号" }, { afterProjectWarehouseType: n(() => [t(i, { modelValue: e(a).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).basicClass = o), options: e(K).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: _ }, null, 8, ["modelValue", "options"]), t(i, { modelValue: e(a).weightMeasurementMode, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).weightMeasurementMode = o), options: e(y).ENUM, unshowVal: [e(y).MIXTURE.V], class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), t(d, { modelValue: e(a).materialOutboundTime, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).materialOutboundTime = o), "default-time": u.value, shortcuts: e(b), class: "filter-item", "end-placeholder": "出库时间", "range-separator": ":", size: "default", "start-placeholder": "出库时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), t(d, { modelValue: e(a).outboundTime, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(a).outboundTime = o), "default-time": u.value, shortcuts: e(b), class: "filter-item", "end-placeholder": "审核时间", "range-separator": ":", size: "default", "start-placeholder": "审核时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"])]), beforeWarehouse: n(() => [t(L, { modelValue: e(a).sourceWorkshopIds, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(a).sourceWorkshopIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), t(R, { modelValue: e(a).warehouseId, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(a).warehouseId = o), "basic-class": e(a).basicClass, "workshop-id": e(a).sourceWorkshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), secondLineFirstItem: n(() => [t(m, { modelValue: e(a).outboundSN, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(a).outboundSN = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "240px" }, onKeyup: c(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(m, { modelValue: e(a).operatorName, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(a).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "160px" }, onKeyup: c(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t($, { modelValue: e(a).classifyId, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(a).classifyId = o), "basic-class": e(a).basicClass, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), t(j, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(a).branchCompanyId = o), class: "filter-item", clearable: "", filterable: "", placeholder: "请选择关联交易单位", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l[10] || (l[10] = f("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), t(e(F))])) : Q("", true), t(e(J), null, { optLeft: n(() => [N((r(), E(H, { fn: e(z), params: e(a), "response-header-result": "" }, { default: n(() => l[11] || (l[11] = [h(" 下载对外出售明细（根据查询条件） ")])), _: 1, __: [11] }, 8, ["fn", "params"])), [[k, e(w).get]])]), viewLeft: n(() => [f("div", Z, [t(x, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: n(() => {
      var o;
      return [h(" 出售含税金额汇总：" + D(e(A)(((o = V.DetailsCount) == null ? void 0 : o.sellAmountSum) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} };
export {
  se as default
};
