import { ref as E } from "vue";
import { inject as q } from "vue";
import { watch as G } from "vue";
import { computed as T } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as X } from "vue";
import { withDirectives as N } from "vue";
import { vShow as F } from "vue";
import { unref as e } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as o } from "vue";
import { createBlock as C } from "vue";
import { createCommentVNode as w } from "vue";
import { withKeys as d } from "vue";
import { withCtx as $ } from "vue";
import { ElMessage as J } from "element-plus";
import y from "moment";
import { ElDatePicker as W } from "element-plus";
import { ElInput as Z } from "element-plus";
import { _ as ee, m as te, B as ae, bi as s, G as R, K as _, i as f, bA as le, bO as K, od as O, bw as x, by as k, bP as I, I as ne, C as oe, E as ue } from "../../../../../shared/runtime.js";
const se = { class: "head-container" }, ie = { class: "date-div", style: { position: "relative", "padding-left": "115px", "vertical-align": "0px", display: "inline-block", border: "1px solid #dcdfe6", "border-radius": "4px", height: "31px" } }, de = { __name: "header", setup(re) {
  const r = E(), { globalProject: S } = te(["globalProject"]), A = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, auditReceiptName: void 0, receiptName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, shipmentStatus: void 0 }, { crud: n, query: t } = ae(A), c = q("permission"), u = E(), p = E([]);
  G(() => S.value, (v) => {
    var a;
    t.productType = void 0, r.value = void 0, r.value = (a = S.value) == null ? void 0 : a.productCategory;
  }, { immediate: true });
  const B = T(() => {
    switch (r.value) {
      case s.STRUCTURE.V:
        return [s.ENCLOSURE.V];
      case s.ENCLOSURE.V:
        return [s.STRUCTURE.V, s.MACHINE_PART.V];
      case s.STRUCTURE.V + s.ENCLOSURE.V:
        return [];
      default:
        return [];
    }
  });
  H(() => {
    R(c.print) && (n.query.projectType === _.BRIDGE.V ? p.value.push("mesBridgeReceiptStatusSummary") : p.value.push("mesReceiptStatusSummary")), R(c.detailPrint) && (n.query.projectType === _.BRIDGE.V ? p.value.push("mesBridgeShippingList") : p.value.push("mesShippingList"));
  });
  const V = T(() => {
    if (u.value === "mesReceiptStatusSummary" || u.value === "mesBridgeReceiptStatusSummary") return { ...t };
    if (u.value === "mesShippingList" && f(n.selections) || u.value === "mesBridgeShippingList" && f(n.selections)) return n.selections.map((v) => v.id);
  });
  function P() {
    if (u.value === "mesShippingList" && !f(V.value) || u.value === "mesBridgeShippingList" && !f(V.value)) return J.warning("至少选择一条需要打印的发运信息"), false;
  }
  function b() {
    t.deliveryDate && t.deliveryDate.length > 1 ? t.searchType === I.DELIVERY_DATE.V ? (t.auditStartDate = y(t.deliveryDate[0]).valueOf(), t.auditEndDate = y(t.deliveryDate[1]).valueOf(), t.statusUpdateStartDate = void 0, t.statusUpdateEndDate = void 0) : (t.statusUpdateStartDate = y(t.deliveryDate[0]).valueOf(), t.statusUpdateEndDate = y(t.deliveryDate[1]).valueOf(), t.auditStartDate = void 0, t.auditEndDate = void 0) : (t.statusUpdateStartDate = void 0, t.statusUpdateEndDate = void 0, t.auditStartDate = void 0, t.auditEndDate = void 0);
  }
  return (v, a) => {
    const z = m("project-radio-button"), h = m("common-radio-button"), D = m("component-radio-button"), L = m("common-select"), Q = W, i = Z, j = m("print-table"), M = Y("permission");
    return g(), X("div", se, [N(U("div", null, [o(z, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(h, { modelValue: e(t).manufactureType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).manufactureType = l), options: e(le).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(h, { modelValue: e(t).receiptStatus, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).receiptStatus = l), options: e(K).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: a[3] || (a[3] = () => {
      e(n).toQuery(), e(t).shipmentStatus = void 0;
    }) }, null, 8, ["modelValue", "options"]), r.value !== e(O).BOX.V ? (g(), C(D, { key: 0, modelValue: e(t).productType, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).productType = l), options: e(s).ENUM, unshowVal: e(t).projectId ? B.value : [], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : w("", true), r.value === e(O).BOX.V ? (g(), C(D, { key: 1, modelValue: e(t).productType, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).productType = l), options: e(x).ENUM, disabledVal: [e(x).AUXILIARY_MATERIAL.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : w("", true), o(h, { modelValue: e(t).shipmentStatus, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).shipmentStatus = l), options: e(k).ENUM, showOptionAll: "", unshowVal: e(t).receiptStatus === e(K).RECEIVED.V ? [e(k).DELIVERY.V] : [], type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), U("div", ie, [o(L, { modelValue: e(t).searchType, "onUpdate:modelValue": a[7] || (a[7] = (l) => e(t).searchType = l), options: e(I).ENUM, type: "enum", class: "date-select", style: { width: "115px", "vertical-align": "middle" }, onChange: b }, null, 8, ["modelValue", "options"]), o(Q, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": a[8] || (a[8] = (l) => e(t).deliveryDate = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item date-change", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "vertical-align": "middle" }, shortcuts: e(ne), onChange: b }, null, 8, ["modelValue", "shortcuts"])]), U("div", null, [o(i, { modelValue: e(t).blurry, "onUpdate:modelValue": a[9] || (a[9] = (l) => e(t).blurry = l), placeholder: "产品名称/产品编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[10] || (a[10] = (l) => e(t).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).licensePlate, "onUpdate:modelValue": a[11] || (a[11] = (l) => e(t).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).driverName, "onUpdate:modelValue": a[12] || (a[12] = (l) => e(t).driverName = l), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).auditUserName, "onUpdate:modelValue": a[13] || (a[13] = (l) => e(t).auditUserName = l), placeholder: "可输入发运人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).receiptName, "onUpdate:modelValue": a[14] || (a[14] = (l) => e(t).receiptName = l), placeholder: "可输入收货人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(i, { modelValue: e(t).auditReceiptName, "onUpdate:modelValue": a[15] || (a[15] = (l) => e(t).auditReceiptName = l), placeholder: "可输入实际收货人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(oe))])], 512), [[F, e(n).searchToggle]]), o(e(ue), null, { optLeft: $(() => [N(o(j, { "current-key": u.value, "onUpdate:currentKey": a[16] || (a[16] = (l) => u.value = l), "api-key": p.value, params: V.value, "before-print": P, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[M, [...e(c).print, ...e(c).detailPrint]]])]), _: 1 })]);
  };
} }, ce = ee(de, [["__scopeId", "data-v-13518957"]]);
export {
  ce as default
};
