import { ref as b } from "vue";
import { useRoute as C } from "vue-router";
import { watchEffect as h } from "vue";
import { onMounted as E } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as m } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as N } from "vue";
import { withKeys as r } from "vue";
import { createCommentVNode as U } from "vue";
import { withCtx as g } from "vue";
import { ElDatePicker as w } from "element-plus";
import { ElInput as S } from "element-plus";
import { jZ as M, B as j, yA as y, cV as I, cJ as d, j$ as A, k0 as Q, kD as v, I as K, bF as x, bE as P, C as W, E as k } from "../../../../../../../shared/runtime.js";
import { _ as R } from "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const _ = { class: "head-container" }, z = { key: 0 }, F = { __name: "header", setup(D) {
  const f = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { createTime: [], orderSupplyType: { value: M.PARTY_A.V, resetAble: false }, basicClass: void 0, projectId: void 0, projectWarehouseType: void 0, qualityTestingEnum: void 0, reviewStatus: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0, boolPartyA: { value: true, resetAble: false } }, i = C(), { crud: s, query: l } = j(c);
  return h(() => {
    l.basicClass & y && (l.orderSupplyType = void 0);
  }), E(() => {
    +i.params.basicClass === I ? l.basicClass = d.STEEL_PLATE.V : +i.params.basicClass === y ? l.basicClass = d.STRUC_MANUFACTURED.V : l.basicClass = i.params.basicClass;
  }), (L, a) => {
    const u = T("common-radio-button"), V = w, n = S;
    return p(), m("div", _, [e(s).searchToggle ? (p(), m("div", z, [t(u, { type: "enum", modelValue: e(l).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(l).basicClass = o), options: e(d).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(u, { type: "enum", modelValue: e(l).inboundWay, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(l).inboundWay = o), options: e(A).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(u, { type: "enum", modelValue: e(l).qualityTestingEnum, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(l).qualityTestingEnum = o), options: e(Q).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(u, { type: "enum", modelValue: e(l).reviewStatus, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(l).reviewStatus = o), options: e(v).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(V, { modelValue: e(l).createTime, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(l).createTime = o), "default-time": f.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(K), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), a[13] || (a[13] = N("br", null, null, -1)), t(e(R), { projectId: e(l).projectId, "onUpdate:projectId": a[5] || (a[5] = (o) => e(l).projectId = o), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": a[6] || (a[6] = (o) => e(l).projectWarehouseType = o), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), t(P, { modelValue: e(l).supplierId, "onUpdate:modelValue": a[7] || (a[7] = (o) => e(l).supplierId = o), basicClass: e(l).basicClass, type: e(x).RAW_MATERIAL.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(s).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), t(n, { modelValue: e(l).operatorName, "onUpdate:modelValue": a[8] || (a[8] = (o) => e(l).operatorName = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: r(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(n, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": a[9] || (a[9] = (o) => e(l).purchaseSN = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: r(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(n, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[10] || (a[10] = (o) => e(l).serialNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: r(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(n, { modelValue: e(l).licensePlate, "onUpdate:modelValue": a[11] || (a[11] = (o) => e(l).licensePlate = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: r(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(n, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": a[12] || (a[12] = (o) => e(l).shipmentNumber = o), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: r(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(W))])) : U("", true), t(e(k), null, { optLeft: g(() => a[14] || (a[14] = [])), _: 1 })]);
  };
} };
export {
  F as default
};
