import { ref as j } from "vue";
import { inject as P } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as _ } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withCtx as r } from "vue";
import { withKeys as h } from "vue";
import { createElementVNode as x } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as K } from "vue";
import { createBlock as g } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as d } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElTag as B } from "element-plus";
import { l as b, B as O, sQ as W, zd as $, cJ as R, jZ as F, gF as H, y3 as J, fv as E, zh as Z, I as A, ya as G, C as X, L as Y, j_ as V, bV as c, E as ee } from "../../../../../../shared/runtime.js";
import { r as te } from "../../../../../../modules/reset-query-5216307c.js";
import { _ as ae } from "../../../../../../modules/closing-time-date-query-82715fa2.js";
function pe(n) {
  return b({ module: "wms", url: "report/raw-materials/transfer/details", method: "get", params: n });
}
function le(n) {
  return b({ module: "wms", url: "report/raw-materials/transfer/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: n });
}
function fe(n) {
  return b({ module: "wms", url: "report/raw-materials/transfer/detailsCount", method: "get", params: n });
}
const oe = { class: "head-container" }, se = { key: 0 }, re = { class: "flex gap-2" }, ne = { __name: "header", props: { DetailsCount: { type: Object } }, setup(n) {
  const m = n, S = j([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), U = { realTime: [], reviewTime: [], basicClass: void 0, orderSupplyType: void 0, transferType: void 0, sourceProjectId: void 0, directionProjectId: void 0, transferSN: void 0, operatorName: void 0, sourceWorkshopIds: void 0 }, v = P("permission"), { crud: s, query: t } = O(U), { baseUnit: I } = W(t.basicClass);
  async function Q(k) {
    await te(t), s.toQuery(), s.data = [], s.setColumns();
  }
  return (k, l) => {
    const p = M("common-radio-button"), D = L, y = q, f = B, N = z("permission");
    return i(), _("div", oe, [e(s).searchToggle ? (i(), _("div", se, [o(G, { "basic-class": e(t).basicClass, query: e(t), "show-warehouse": false, "to-query": e(s).toQuery, multiple: "" }, { afterProjectWarehouseType: r(() => [o(p, { modelValue: e(t).transferType, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).transferType = a), options: e($).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(p, { modelValue: e(t).basicClass, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).basicClass = a), options: e(R).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: Q }, null, 8, ["modelValue", "options"]), o(p, { modelValue: e(t).orderSupplyType, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).orderSupplyType = a), options: e(F).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), beforeWarehouse: r(() => [o(H, { modelValue: e(t).sourceWorkshopIds, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).sourceWorkshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(J, { modelValue: e(t).warehouseId, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).warehouseId = a), "basic-class": e(t).basicClass, "workshop-id": e(t).sourceWorkshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), secondLineFirstItem: r(() => [o(e(E), { modelValue: e(t).sourceProjectId, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(t).sourceProjectId = a), class: "filter-item", clearable: "", placeholder: "原项目", style: { width: "300px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(E), { modelValue: e(t).directionProjectId, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(t).directionProjectId = a), class: "filter-item", clearable: "", placeholder: "目的项目", style: { width: "300px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(ae, { modelValue: e(t).realTime, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(t).realTime = a), label: "调拨", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(p, { type: "enum", modelValue: e(t).transferCreateType, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(t).transferCreateType = a), options: e(Z).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(D, { modelValue: e(t).reviewTime, "onUpdate:modelValue": l[9] || (l[9] = (a) => e(t).reviewTime = a), "default-time": S.value, type: "daterange", "range-separator": ":", class: "filter-item", size: "default", "value-format": "x", shortcuts: e(A), "unlink-panels": "", "start-placeholder": "审核时间", "end-placeholder": "审核时间", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(y, { modelValue: e(t).transferSN, "onUpdate:modelValue": l[10] || (l[10] = (a) => e(t).transferSN = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "调拨单号", size: "default", style: { width: "160px" }, onKeyup: h(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(t).outboundSn, "onUpdate:modelValue": l[11] || (l[11] = (a) => e(t).outboundSn = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按出库单号搜索", class: "filter-item", onKeyup: h(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(t).operatorName, "onUpdate:modelValue": l[12] || (l[12] = (a) => e(t).operatorName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/审核人", size: "default", style: { width: "140px" }, onKeyup: h(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l[13] || (l[13] = x("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), o(e(X))])) : C("", true), o(e(ee), null, { optLeft: r(() => [K((i(), g(Y, { fn: e(le), params: e(t), "response-header-result": "" }, { default: r(() => l[14] || (l[14] = [u(" 下载调拨明细（根据查询条件） ")])), _: 1, __: [14] }, 8, ["fn", "params"])), [[N, e(v).get]])]), viewLeft: r(() => [x("div", re, [e(t).basicClass & e(V).STEEL.V ? (i(), g(f, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: r(() => {
      var a;
      return [u(" 数量汇总：" + d(e(c)(((a = m.DetailsCount) == null ? void 0 : a.quantityCount) || 0)), 1)];
    }), _: 1 })) : C("", true), e(t).basicClass & e(V).STEEL.V ? (i(), g(f, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: r(() => {
      var a, w, T;
      return [u(" 核算量汇总：" + d(e(c)(((a = m.DetailsCount) == null ? void 0 : a.meteCount) || 0)) + " " + d(((w = e(t)) == null ? void 0 : w.basicClass) & e(V).STEEL.V ? e(I)[(T = e(t)) == null ? void 0 : T.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : C("", true), o(f, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: r(() => {
      var a;
      return [u(" 含税金额汇总：" + d(e(c)(((a = m.DetailsCount) == null ? void 0 : a.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 }), o(f, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: r(() => {
      var a;
      return [u(" 不含税金额汇总：" + d(e(c)(((a = m.DetailsCount) == null ? void 0 : a.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} }, ce = Object.freeze(Object.defineProperty({ __proto__: null, default: ne }, Symbol.toStringTag, { value: "Module" }));
export {
  ne as _,
  fe as a,
  pe as g,
  ce as h
};
