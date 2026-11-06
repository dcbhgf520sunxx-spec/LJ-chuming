import { ref as C } from "vue";
import { inject as I } from "vue";
import { watch as P } from "vue";
import { computed as Q } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as f } from "vue";
import { vShow as x } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as U } from "vue";
import { withKeys as p } from "vue";
import { withCtx as V } from "vue";
import { createTextVNode as B } from "vue";
import { Fragment as L } from "vue";
import N from "moment";
import { ElDatePicker as M } from "element-plus";
import { ElInput as H } from "element-plus";
import { B as X, m as q, bi as u, bA as F, od as w, bw as _, bB as Y, I as $, C as G, E as J } from "../../../../../shared/runtime.js";
import W from "./logistics-fee-setting/index.vue.js";
import "../../../../../modules/logistics-list-4584a3aa.js";
import "../../../../../modules/base-6bc46ddf.js";
import "./logistics-fee-setting/module/header.vue.js";
import "./logistics-fee-setting/module/form.vue.js";
import "./logistics-fee-setting/module/price-all-detail.vue.js";
const Z = { class: "head-container" }, se = { __name: "header", setup(ee) {
  const i = C(), h = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, auditReceiptName: void 0, receiptName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, supplierName: void 0, priceType: void 0 }, { crud: n, query: t } = X(h), { globalProject: v } = q(["globalProject"]), b = I("permission"), m = C(false);
  P(() => v.value, (R) => {
    var l;
    t.productType = void 0, i.value = void 0, i.value = (l = v.value) == null ? void 0 : l.productCategory;
  }, { immediate: true, deep: true });
  const D = Q(() => {
    switch (i.value) {
      case u.STRUCTURE.V:
        return [u.ENCLOSURE.V];
      case u.ENCLOSURE.V:
        return [u.STRUCTURE.V, u.MACHINE_PART.V];
      case u.STRUCTURE.V + u.ENCLOSURE.V:
        return [];
      default:
        return [];
    }
  });
  function O() {
    t.deliveryDate && t.deliveryDate.length > 1 ? (t.auditStartDate = N(t.deliveryDate[0]).valueOf(), t.auditEndDate = N(t.deliveryDate[1]).valueOf()) : (t.auditStartDate = void 0, t.auditEndDate = void 0), n.toQuery();
  }
  return (R, l) => {
    const S = r("project-radio-button"), g = r("common-radio-button"), T = r("component-radio-button"), A = M, s = H, k = r("print-table"), z = r("common-button"), E = j("permission");
    return d(), K(L, null, [c("div", Z, [f(c("div", null, [o(S, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).projectId = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(g, { modelValue: e(t).manufactureType, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).manufactureType = a), options: e(F).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i.value !== e(w).BOX.V ? (d(), y(T, { key: 0, modelValue: e(t).productType, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).productType = a), options: e(u).ENUM, unshowVal: e(t).projectId ? D.value : [], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : U("", true), i.value === e(w).BOX.V ? (d(), y(T, { key: 1, modelValue: e(t).productType, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).productType = a), options: e(_).ENUM, disabledVal: [e(_).AUXILIARY_MATERIAL.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : U("", true), o(g, { modelValue: e(t).priceType, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).priceType = a), options: e(Y).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(A, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(t).deliveryDate = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "发运开始日期", "end-placeholder": "发运结束日期", style: { width: "240px" }, shortcuts: e($), onChange: O }, null, 8, ["modelValue", "shortcuts"]), c("div", null, [o(s, { modelValue: e(t).supplierName, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(t).supplierName = a), placeholder: "可输入物流公司搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(t).serialNumber = a), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: e(t).licensePlate, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(t).licensePlate = a), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: e(t).driverName, "onUpdate:modelValue": l[9] || (l[9] = (a) => e(t).driverName = a), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(G))])], 512), [[x, e(n).searchToggle]]), o(e(J), null, { optLeft: V(() => [f(o(k, { "api-key": "mesLogisticsSummary", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[E, e(b).print]])]), viewLeft: V(() => [f((d(), y(z, { onClick: l[10] || (l[10] = (a) => m.value = true), size: "default", type: "primary" }, { default: V(() => l[12] || (l[12] = [B("物流费设置")])), _: 1, __: [12] })), [[E, e(b).edit]])]), _: 1 })]), o(e(W), { visible: m.value, "onUpdate:visible": l[11] || (l[11] = (a) => m.value = a) }, null, 8, ["visible"])], 64);
  };
} };
export {
  se as default
};
