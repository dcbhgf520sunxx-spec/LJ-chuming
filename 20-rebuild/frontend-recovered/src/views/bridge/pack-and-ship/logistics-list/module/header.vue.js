import { inject as w } from "vue";
import { ref as U } from "vue";
import { resolveComponent as i } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as p } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withKeys as u } from "vue";
import { withCtx as m } from "vue";
import { createBlock as K } from "vue";
import { createTextVNode as Q } from "vue";
import { Fragment as S } from "vue";
import V from "moment";
import { ElDatePicker as k } from "element-plus";
import { ElInput as x } from "element-plus";
import { B as O, bA as P, bw as j, bB as A, I, C as B, E as R } from "../../../../../shared/runtime.js";
import L from "./logistics-fee-setting/index.vue.js";
import "../../../../../modules/logistics-list-3b33cbe0.js";
import "../../../../../modules/base-6bc46ddf.js";
import "./logistics-fee-setting/module/header.vue.js";
import "./logistics-fee-setting/module/form.vue.js";
import "./logistics-fee-setting/module/price-all-detail.vue.js";
const M = { class: "head-container" }, ee = { __name: "header", setup(q) {
  const b = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, auditReceiptName: void 0, receiptName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, supplierName: void 0, priceType: void 0 }, { crud: n, query: t } = O(b), f = w("permission"), d = U(false);
  function g() {
    t.deliveryDate && t.deliveryDate.length > 1 ? (t.auditStartDate = V(t.deliveryDate[0]).valueOf(), t.auditEndDate = V(t.deliveryDate[1]).valueOf()) : (t.auditStartDate = void 0, t.auditEndDate = void 0), n.toQuery();
  }
  return (F, l) => {
    const _ = i("project-radio-button"), c = i("common-radio-button"), N = i("component-radio-button"), D = k, r = x, T = i("print-table"), C = i("common-button"), y = h("permission");
    return v(), E(S, null, [s("div", M, [p(s("div", null, [o(_, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).projectId = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(c, { modelValue: e(t).manufactureType, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).manufactureType = a), options: e(P).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(N, { modelValue: e(t).productType, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).productType = a), options: e(j).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(c, { modelValue: e(t).priceType, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).priceType = a), options: e(A).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(D, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).deliveryDate = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "发运开始日期", "end-placeholder": "发运结束日期", style: { width: "240px" }, shortcuts: e(I), onChange: g }, null, 8, ["modelValue", "shortcuts"]), s("div", null, [o(r, { modelValue: e(t).supplierName, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(t).supplierName = a), placeholder: "可输入物流公司搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(t).serialNumber = a), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(t).licensePlate, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(t).licensePlate = a), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(t).driverName, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(t).driverName = a), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(B))])], 512), [[z, e(n).searchToggle]]), o(e(R), null, { optLeft: m(() => [p(o(T, { "api-key": "bridgeLogisticsSummary", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[y, e(f).print]])]), viewLeft: m(() => [p((v(), K(C, { onClick: l[9] || (l[9] = (a) => d.value = true), size: "default", type: "primary" }, { default: m(() => l[11] || (l[11] = [Q("物流费设置")])), _: 1, __: [11] })), [[y, e(f).edit]])]), _: 1 })]), o(e(L), { visible: d.value, "onUpdate:visible": l[10] || (l[10] = (a) => d.value = a) }, null, 8, ["visible"])], 64);
  };
} };
export {
  ee as default
};
