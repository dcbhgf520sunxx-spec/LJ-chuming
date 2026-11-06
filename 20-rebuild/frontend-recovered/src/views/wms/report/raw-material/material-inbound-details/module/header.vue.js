import { ref as L } from "vue";
import { inject as D } from "vue";
import { watchEffect as K } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as U } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withCtx as u } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as r } from "vue";
import { withKeys as f } from "vue";
import { createElementVNode as j } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as c } from "vue";
import { ElInput as q } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { ElTag as O } from "element-plus";
import { e as $, b as F } from "../../../../../../modules/inbound-9bad80c1.js";
import { jY as H, jJ as p, k0 as N, B as J, sQ as X, cJ as Y, j$ as Z, v0 as G, jZ as ee, xl as le, bE as ae, bF as A, gF as te, y3 as se, I as oe, ya as ne, C as ue, L as _, j_ as b, bV as C, E as ie } from "../../../../../../shared/runtime.js";
import { _ as re } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { r as de } from "../../../../../../modules/reset-query-5216307c.js";
import { _ as pe } from "../../../../../../modules/closing-time-date-query-82715fa2.js";
const me = { class: "head-container" }, ye = { key: 0 }, fe = { class: "flex gap-2" }, Te = { __name: "header", props: { DetailsCount: { type: Object } }, setup(k) {
  const { reportCfg: g } = H(), h = k, M = L([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), Q = { inboundTime: [], purchaseType: { value: p.RAW_MATERIAL.V, resetAble: false }, basicClass: void 0, orderSupplyType: void 0, rejectStatus: void 0, projectId: void 0, projectWarehouseType: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, inboundSN: void 0, supplierId: void 0, operatorName: void 0, workshopIds: void 0, qualityTestingEnumList: { value: [N.ALL_PASS.V, N.NO.V], resetAble: false } }, T = D("permission"), { crud: s, query: l } = J(Q), { baseUnit: R } = X(l.basicClass);
  K(() => {
    l.purchaseType & p.MANUFACTURED.V && (l.orderSupplyType = void 0, l.basicClass = void 0), l.purchaseType & p.RAW_MATERIAL.V && (l.basicClass = void 0);
  });
  async function E(W) {
    await de(l), s.toQuery(), s.data = [], s.setColumns();
  }
  return (W, t) => {
    const m = z("common-radio-button"), y = q, v = B, V = O, w = P("permission");
    return n(), U("div", me, [e(s).searchToggle ? (n(), U("div", ye, [o(ne, { "basic-class": e(l).basicClass, query: e(l), "show-material-is-whole": false, showWarehouse: false, "to-query": e(s).toQuery, multiple: "" }, { afterProjectWarehouseType: u(() => [e(l).purchaseType & e(p).RAW_MATERIAL.V ? (n(), i(m, { key: 0, modelValue: e(l).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).basicClass = a), options: e(Y).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: E }, null, 8, ["modelValue", "options"])) : r("", true), o(m, { type: "enum", modelValue: e(l).inboundWay, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).inboundWay = a), options: e(Z).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(l).purchaseType & e(p).MANUFACTURED.V ? (n(), i(m, { key: 1, modelValue: e(l).basicClass, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).basicClass = a), options: e(G).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: E }, null, 8, ["modelValue", "options"])) : r("", true), e(l).purchaseType & e(p).RAW_MATERIAL.V ? (n(), i(m, { key: 2, modelValue: e(l).orderSupplyType, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(l).orderSupplyType = a), options: e(ee).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : r("", true), o(m, { modelValue: e(l).rejectStatus, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(l).rejectStatus = a), options: e(le).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(ae, { modelValue: e(l).supplierId, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(l).supplierId = a), basicClass: e(l).basicClass, type: e(A).RAW_MATERIAL.V | e(A).OTHER.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"])]), beforeWarehouse: u(() => [o(te, { modelValue: e(l).workshopIds, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(l).workshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(se, { modelValue: e(l).warehouseId, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(l).warehouseId = a), "basic-class": e(l).basicClass, "workshop-id": e(l).workshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), secondLineFirstItem: u(() => [o(e(re), { projectId: e(l).projectId, "onUpdate:projectId": t[8] || (t[8] = (a) => e(l).projectId = a), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": t[9] || (t[9] = (a) => e(l).projectWarehouseType = a), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), o(pe, { modelValue: e(l).realTime, "onUpdate:modelValue": t[10] || (t[10] = (a) => e(l).realTime = a), label: "入库", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(y, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": t[11] || (t[11] = (a) => e(l).purchaseSN = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "采购合同编号", size: "default", style: { width: "160px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(l).inboundSN, "onUpdate:modelValue": t[12] || (t[12] = (a) => e(l).inboundSN = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "入库单号", size: "default", style: { width: "160px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(l).licensePlate, "onUpdate:modelValue": t[13] || (t[13] = (a) => e(l).licensePlate = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "车牌/船牌号", size: "default", style: { width: "160px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": t[14] || (t[14] = (a) => e(l).shipmentNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "物流单号", size: "default", style: { width: "160px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(y, { modelValue: e(l).operatorName, "onUpdate:modelValue": t[15] || (t[15] = (a) => e(l).operatorName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/编辑人/审核人", size: "default", style: { width: "160px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(v, { modelValue: e(l).inboundTime, "onUpdate:modelValue": t[16] || (t[16] = (a) => e(l).inboundTime = a), "default-time": M.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(oe), "unlink-panels": "", "start-placeholder": "审核时间", "end-placeholder": "审核时间", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), t[17] || (t[17] = j("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), o(e(ue))])) : r("", true), o(e(ie), null, { optLeft: u(() => [I((n(), i(_, { fn: e($), params: e(l), "response-header-result": "" }, { default: u(() => t[18] || (t[18] = [d(" 下载入库明细（根据查询条件） ")])), _: 1, __: [18] }, 8, ["fn", "params"])), [[w, e(T).get]]), I((n(), i(_, { fn: e(F), params: e(l), "response-header-result": "" }, { default: u(() => t[19] || (t[19] = [d(" 下载入库明细（体现退货，根据查询条件） ")])), _: 1, __: [19] }, 8, ["fn", "params"])), [[w, e(T).get]])]), viewLeft: u(() => [j("div", fe, [e(l).basicClass & e(b).STEEL.V ? (n(), i(V, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: u(() => {
      var a;
      return [d(" 数量汇总：" + c(e(C)(((a = h.DetailsCount) == null ? void 0 : a.quantityCount) || 0)), 1)];
    }), _: 1 })) : r("", true), e(l).basicClass & e(b).STEEL.V ? (n(), i(V, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: u(() => {
      var a, S, x;
      return [d(" 核算量汇总：" + c(e(C)(((a = h.DetailsCount) == null ? void 0 : a.meteCount) || 0)) + " " + c(((S = e(l)) == null ? void 0 : S.basicClass) & e(b).STEEL.V ? e(R)[(x = e(l)) == null ? void 0 : x.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : r("", true), e(g).amountShow ? (n(), i(V, { key: 2, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: u(() => {
      var a;
      return [d(" 含税金额汇总：" + c(e(C)(((a = h.DetailsCount) == null ? void 0 : a.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : r("", true), e(g).amountExcludingTAXShow ? (n(), i(V, { key: 3, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: u(() => {
      var a;
      return [d(" 不含税金额汇总：" + c(e(C)(((a = h.DetailsCount) == null ? void 0 : a.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : r("", true)])]), _: 1 })]);
  };
} };
export {
  Te as default
};
