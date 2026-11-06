import { ref as p } from "vue";
import { inject as Q } from "vue";
import { watchEffect as k } from "vue";
import { computed as K } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as h } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createBlock as R } from "vue";
import { createCommentVNode as T } from "vue";
import { withKeys as i } from "vue";
import { withCtx as C } from "vue";
import { withDirectives as L } from "vue";
import { ElDatePicker as W } from "element-plus";
import { ElInput as z } from "element-plus";
import { w5 as m, B as D, yA as w, am as g, j$ as O, jZ as q, k0 as B, I as _, bF as v, bE as $, C as F, E as G, t3 as H } from "../../../../../../../shared/runtime.js";
import { _ as Z } from "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import J from "../../../../../../supply-chain/components/audit-records.vue.js";
const X = { class: "head-container" }, Y = { key: 0 }, ae = { __name: "header", props: { TStotal: { type: Number, default: 0 }, APPtotal: { type: Number, default: 0 }, subTotal: { type: Number, default: 0 }, rejTotal: { type: Number, default: 0 } }, setup(N) {
  const S = p([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), y = N, E = { createTime: [], orderSupplyType: void 0, basicClass: void 0, qualityTestingEnum: void 0, reviewStatus: m.AUDITING.V, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, shipmentNumber: void 0, licensePlate: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, f = p(false), n = p({}), U = Q("permission"), { crud: a, query: t } = D(E), A = p([m.AUDITING, m.PASS, m.REFUSE]);
  k(() => {
    t.basicClass & w && (t.orderSupplyType = void 0);
  });
  function I(d) {
    const l = d;
    n.value.moduleType = 1, n.value.templateName = "入库", l === 1 ? (n.value.waitMeCheck = true, n.value.meLaunch = false) : l === 2 && (n.value.waitMeCheck = false, n.value.meLaunch = true), f.value = true;
  }
  const V = K(() => a.selections.map((d) => d.id));
  return (d, l) => {
    const u = b("common-radio-button"), j = W, r = z, P = b("print-table"), M = x("permission");
    return c(), h("div", X, [e(a).searchToggle ? (c(), h("div", Y, [s(u, { type: "enum", modelValue: e(t).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).basicClass = o), options: e(g).ENUM, unshowVal: [e(g).GAS.V], "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), s(u, { type: "enum", modelValue: e(t).inboundWay, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).inboundWay = o), options: e(O).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(t).basicClass & e(w) ? T("", true) : (c(), R(u, { key: 0, modelValue: e(t).orderSupplyType, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).orderSupplyType = o), options: e(q).ENUM, "show-option-all": "", type: "enumSL", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])), s(u, { type: "enum", modelValue: e(t).qualityTestingEnum, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).qualityTestingEnum = o), options: e(B).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(u, { type: "enum", modelValue: e(t).reviewStatus, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(t).reviewStatus = o), options: A.value, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(j, { modelValue: e(t).createTime, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).createTime = o), "default-time": S.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(_), "unlink-panels": "", "start-placeholder": "申请日期", "end-placeholder": "申请日期", style: { width: "270px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(e(Z), { projectId: e(t).projectId, "onUpdate:projectId": l[6] || (l[6] = (o) => e(t).projectId = o), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": l[7] || (l[7] = (o) => e(t).projectWarehouseType = o), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s($, { modelValue: e(t).supplierId, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(t).supplierId = o), basicClass: e(t).basicClass, type: e(v).RAW_MATERIAL.V | e(v).OTHER.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(a).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(r, { modelValue: e(t).operatorName, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(t).operatorName = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: i(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).purchaseSN, "onUpdate:modelValue": l[10] || (l[10] = (o) => e(t).purchaseSN = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: i(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[11] || (l[11] = (o) => e(t).serialNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: i(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).licensePlate, "onUpdate:modelValue": l[12] || (l[12] = (o) => e(t).licensePlate = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: i(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).shipmentNumber, "onUpdate:modelValue": l[13] || (l[13] = (o) => e(t).shipmentNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: i(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(F))])) : T("", true), s(e(G), null, { viewLeft: C(() => [s(J, { APPtotal: y.APPtotal, subTotal: y.subTotal, rejTotal: y.rejTotal, onOpenAPLists: I }, null, 8, ["APPtotal", "subTotal", "rejTotal"])]), optLeft: C(() => [L(s(P, { "api-key": "wmsRmInboundReceipt", params: V.value, disabled: V.value.length === 0, size: "default", type: "warning", class: "filter-item", onSuccess: e(a).selectAllChange }, null, 8, ["params", "disabled", "onSuccess"]), [[M, e(U).get]])]), _: 1 }), s(H, { modelValue: f.value, "onUpdate:modelValue": l[14] || (l[14] = (o) => f.value = o), form: n.value, onSuccess: l[15] || (l[15] = (o) => e(a).toQuery()) }, null, 8, ["modelValue", "form"])]);
  };
} };
export {
  ae as default
};
