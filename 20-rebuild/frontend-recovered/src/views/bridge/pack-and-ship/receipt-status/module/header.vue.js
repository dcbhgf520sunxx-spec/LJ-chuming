import { inject as k } from "vue";
import { ref as b } from "vue";
import { onMounted as O } from "vue";
import { computed as P } from "vue";
import { resolveComponent as s } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as h } from "vue";
import { vShow as A } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as n } from "vue";
import { withKeys as d } from "vue";
import { withCtx as M } from "vue";
import { ElMessage as j } from "element-plus";
import p from "moment";
import { ElDatePicker as B } from "element-plus";
import { ElInput as L } from "element-plus";
import { _ as H, B as Y, G as g, i as D, bA as q, bO as E, bw as F, by as U, bP as S, I as G, C as $, E as J } from "../../../../../shared/runtime.js";
const W = { class: "head-container" }, X = { class: "date-div", style: { position: "relative", "padding-left": "115px", "vertical-align": "0px", display: "inline-block", border: "1px solid #dcdfe6", "border-radius": "4px", height: "31px" } }, Z = { __name: "header", setup(ee) {
  const _ = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, auditReceiptName: void 0, receiptName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, shipmentStatus: void 0 }, { crud: o, query: t } = Y(_), r = k("permission"), u = b(), m = b([]);
  O(() => {
    g(r.print) && m.value.push("bridgeReceiptStatusSummary"), g(r.detailPrint) && m.value.push("bridgeShippingList");
  });
  const c = P(() => {
    if (u.value === "bridgeReceiptStatusSummary") return { ...t };
    if (u.value === "bridgeShippingList" && D(o.selections)) return o.selections.map((v) => v.id);
  });
  function N() {
    if (u.value === "bridgeShippingList" && !D(c.value)) return j.warning("至少选择一条需要打印的发运信息"), false;
  }
  function V() {
    t.deliveryDate && t.deliveryDate.length > 1 ? t.searchType === S.DELIVERY_DATE.V ? (t.auditStartDate = p(t.deliveryDate[0]).valueOf(), t.auditEndDate = p(t.deliveryDate[1]).valueOf(), t.statusUpdateStartDate = void 0, t.statusUpdateEndDate = void 0) : (t.statusUpdateStartDate = p(t.deliveryDate[0]).valueOf(), t.statusUpdateEndDate = p(t.deliveryDate[1]).valueOf(), t.auditStartDate = void 0, t.auditEndDate = void 0) : (t.statusUpdateStartDate = void 0, t.statusUpdateEndDate = void 0, t.auditStartDate = void 0, t.auditEndDate = void 0);
  }
  return (v, a) => {
    const w = s("project-radio-button"), f = s("common-radio-button"), x = s("component-radio-button"), K = s("common-select"), C = B, i = L, T = s("print-table"), z = Q("permission");
    return R(), I("div", W, [h(y("div", null, [n(w, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(f, { modelValue: e(t).manufactureType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).manufactureType = l), options: e(q).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(f, { modelValue: e(t).receiptStatus, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).receiptStatus = l), options: e(E).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: a[3] || (a[3] = () => {
      e(o).toQuery(), e(t).shipmentStatus = void 0;
    }) }, null, 8, ["modelValue", "options"]), n(x, { modelValue: e(t).productType, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).productType = l), options: e(F).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(f, { modelValue: e(t).shipmentStatus, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).shipmentStatus = l), options: e(U).ENUM, showOptionAll: "", unshowVal: e(t).receiptStatus === e(E).RECEIVED.V ? [e(U).DELIVERY.V] : [], type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), y("div", X, [n(K, { modelValue: e(t).searchType, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).searchType = l), options: e(S).ENUM, type: "enum", class: "date-select", style: { width: "115px", "vertical-align": "middle" }, onChange: V }, null, 8, ["modelValue", "options"]), n(C, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": a[7] || (a[7] = (l) => e(t).deliveryDate = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item date-change", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "vertical-align": "middle" }, shortcuts: e(G), onChange: V }, null, 8, ["modelValue", "shortcuts"])]), y("div", null, [n(i, { modelValue: e(t).blurry, "onUpdate:modelValue": a[8] || (a[8] = (l) => e(t).blurry = l), placeholder: "产品名称/产品编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[9] || (a[9] = (l) => e(t).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).licensePlate, "onUpdate:modelValue": a[10] || (a[10] = (l) => e(t).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).driverName, "onUpdate:modelValue": a[11] || (a[11] = (l) => e(t).driverName = l), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).auditUserName, "onUpdate:modelValue": a[12] || (a[12] = (l) => e(t).auditUserName = l), placeholder: "可输入发运人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).receiptName, "onUpdate:modelValue": a[13] || (a[13] = (l) => e(t).receiptName = l), placeholder: "可输入收货人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(t).auditReceiptName, "onUpdate:modelValue": a[14] || (a[14] = (l) => e(t).auditReceiptName = l), placeholder: "可输入实际收货人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e($))])], 512), [[A, e(o).searchToggle]]), n(e(J), null, { optLeft: M(() => [h(n(T, { "current-key": u.value, "onUpdate:currentKey": a[15] || (a[15] = (l) => u.value = l), "api-key": m.value, params: c.value, "before-print": N, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[z, [...e(r).print, ...e(r).detailPrint]]])]), _: 1 })]);
  };
} }, le = H(Z, [["__scopeId", "data-v-0f283f49"]]);
export {
  le as default
};
