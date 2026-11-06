import { ref as S } from "vue";
import { inject as U } from "vue";
import { watchEffect as I } from "vue";
import { computed as v } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as c } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createBlock as Q } from "vue";
import { createCommentVNode as y } from "vue";
import { withKeys as r } from "vue";
import { withCtx as K } from "vue";
import { withDirectives as M } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { ElInput as k } from "element-plus";
import { kD as f, B as x, yA as V, am as h, jZ as R, k0 as z, I as D, bF as b, bE as W, C as A, E as P } from "../../../../../../shared/runtime.js";
import { _ as q } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const O = { class: "head-container" }, B = { key: 0 }, G = { __name: "header", setup(H) {
  const C = S([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), g = { createTime: [], orderSupplyType: void 0, basicClass: void 0, qualityTestingEnum: void 0, reviewStatus: f.UNREVIEWED.V, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, shipmentNumber: void 0, licensePlate: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, w = U("permission"), { crud: a, query: l } = x(g);
  I(() => {
    l.basicClass & V && (l.orderSupplyType = void 0);
  });
  const d = v(() => a.selections.map((p) => p.id));
  return (p, t) => {
    const u = m("common-radio-button"), E = _, n = k, T = m("print-table"), N = j("permission");
    return i(), c("div", O, [e(a).searchToggle ? (i(), c("div", B, [s(u, { type: "enum", modelValue: e(l).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).basicClass = o), options: e(h).ENUM, unshowVal: [e(h).GAS.V], "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), e(l).basicClass & e(V) ? y("", true) : (i(), Q(u, { key: 0, modelValue: e(l).orderSupplyType, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).orderSupplyType = o), options: e(R).ENUM, "show-option-all": "", type: "enumSL", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])), s(u, { type: "enum", modelValue: e(l).qualityTestingEnum, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).qualityTestingEnum = o), options: e(z).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(u, { type: "enum", modelValue: e(l).reviewStatus, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).reviewStatus = o), options: e(f).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(E, { modelValue: e(l).createTime, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(l).createTime = o), "default-time": C.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(D), "unlink-panels": "", "start-placeholder": "申请日期", "end-placeholder": "申请日期", style: { width: "270px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(e(q), { projectId: e(l).projectId, "onUpdate:projectId": t[5] || (t[5] = (o) => e(l).projectId = o), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": t[6] || (t[6] = (o) => e(l).projectWarehouseType = o), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s(W, { modelValue: e(l).supplierId, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(l).supplierId = o), basicClass: e(l).basicClass, type: e(b).RAW_MATERIAL.V | e(b).OTHER.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(a).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(n, { modelValue: e(l).operatorName, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(l).operatorName = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: r(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": t[9] || (t[9] = (o) => e(l).purchaseSN = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: r(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[10] || (t[10] = (o) => e(l).serialNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: r(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).licensePlate, "onUpdate:modelValue": t[11] || (t[11] = (o) => e(l).licensePlate = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: r(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": t[12] || (t[12] = (o) => e(l).shipmentNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: r(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(A))])) : y("", true), s(e(P), null, { optLeft: K(() => [M(s(T, { "api-key": "wmsRmInboundReceipt", params: d.value, disabled: d.value.length === 0, size: "default", type: "warning", class: "filter-item", onSuccess: e(a).selectAllChange }, null, 8, ["params", "disabled", "onSuccess"]), [[N, e(w).get]])]), _: 1 })]);
  };
} };
export {
  G as default
};
