import { ref as V } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as r } from "vue";
import { withKeys as s } from "vue";
import { createElementVNode as h } from "vue";
import { createCommentVNode as b } from "vue";
import { withCtx as g } from "vue";
import { ElDatePicker as N } from "element-plus";
import { ElInput as C } from "element-plus";
import { jU as i, B as I, jJ as U, I as j, bF as w, bE as E, C as K, E as S } from "../../../../shared/runtime.js";
import { _ as x } from "../../../../modules/warehouse-project-cascader-17e2b952.js";
const Q = { class: "head-container" }, M = { key: 0 }, O = { __name: "header", setup(k) {
  const m = V([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), y = { createTime: [], purchaseType: void 0, logisticsTransportType: i.FREIGHT.V, projectWarehouseType: void 0, projectId: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, inboundSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, { crud: a, query: o } = I(y);
  function f() {
    a.data = [], a.setColumns(), a.toQuery();
  }
  return (z, l) => {
    const u = T("common-radio-button"), c = N, n = C;
    return d(), p("div", Q, [e(a).searchToggle ? (d(), p("div", M, [r(u, { type: "enum", modelValue: e(o).purchaseType, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(o).purchaseType = t), options: e(U).ENUM, "show-option-all": "", clearable: "", placeholder: "可选择物料种类", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(u, { type: "enum", modelValue: e(o).logisticsTransportType, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(o).logisticsTransportType = t), options: e(i).ENUM, "show-option-all": "", clearable: "", placeholder: "可选择运输方式", class: "filter-item", onChange: f }, null, 8, ["modelValue", "options"]), r(c, { modelValue: e(o).createTime, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(o).createTime = t), "default-time": m.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(j), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), r(E, { modelValue: e(o).supplierId, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(o).supplierId = t), type: e(w).LOGISTICS.V, clearable: "", class: "filter-item", onChange: e(a).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "type", "onChange"]), r(n, { modelValue: e(o).operatorName, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(o).operatorName = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按操作人搜索", class: "filter-item", onKeyup: s(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l[11] || (l[11] = h("br", null, null, -1)), r(e(x), { projectId: e(o).projectId, "onUpdate:projectId": l[5] || (l[5] = (t) => e(o).projectId = t), projectWarehouseType: e(o).projectWarehouseType, "onUpdate:projectWarehouseType": l[6] || (l[6] = (t) => e(o).projectWarehouseType = t), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), r(n, { modelValue: e(o).purchaseSN, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(o).purchaseSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按采购合同编号搜索", class: "filter-item", onKeyup: s(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(n, { modelValue: e(o).inboundSN, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(o).inboundSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按入库单号搜索", class: "filter-item", onKeyup: s(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(n, { modelValue: e(o).licensePlate, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(o).licensePlate = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按车牌/船牌号搜索", class: "filter-item", onKeyup: s(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(n, { modelValue: e(o).serialNumber, "onUpdate:modelValue": l[10] || (l[10] = (t) => e(o).serialNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按物流单号搜索", class: "filter-item", onKeyup: s(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(K))])) : b("", true), r(e(S), null, { optLeft: g(() => l[12] || (l[12] = [])), _: 1 })]);
  };
} };
export {
  O as default
};
