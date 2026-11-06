import { ref as I } from "vue";
import { inject as j } from "vue";
import { useRoute as M } from "vue-router";
import { computed as Q } from "vue";
import { watchEffect as x } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as b } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as C } from "vue";
import { withKeys as r } from "vue";
import { createElementVNode as h } from "vue";
import { withCtx as K } from "vue";
import { withDirectives as _ } from "vue";
import { ElInput as z } from "element-plus";
import { ElDatePicker as A } from "element-plus";
import { r as P } from "../../../../../../modules/inbound-9bad80c1.js";
import { B as W, yA as m, cV as D, cJ as c, j$ as B, jZ as L, BF as $, gF as F, bF as g, bE as O, iH as H, I as q, C as J, E as Z } from "../../../../../../shared/runtime.js";
import { _ as G } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { _ as X } from "../../../../../../modules/closing-time-date-query-82715fa2.js";
const Y = { class: "head-container" }, ee = { key: 0 }, re = { __name: "header", setup(le) {
  const T = I([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), w = { inboundTime: [], basicClass: void 0, orderSupplyType: void 0, rejectStatus: void 0, projectId: void 0, projectWarehouseType: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, workshopIds: [], operatorName: void 0, realTime: [] }, U = j("permission"), d = M(), { crud: t, query: l } = W(w), y = Q(() => t.selections.map((u) => u.id));
  x(() => {
    l.basicClass & m && (l.orderSupplyType = void 0);
  }), R(() => {
    +d.params.basicClass === D ? l.basicClass = c.STEEL_PLATE.V : +d.params.basicClass === m ? l.basicClass = c.STRUC_MANUFACTURED.V : l.basicClass = d.params.basicClass;
  });
  async function f(u) {
    await P(u), t.toQuery();
  }
  return (u, o) => {
    const i = V("common-radio-button"), n = z, E = A, S = V("print-table"), N = k("permission");
    return p(), b("div", Y, [e(t).searchToggle ? (p(), b("div", ee, [s(i, { modelValue: e(l).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).basicClass = a), options: e(c).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(i, { type: "enum", modelValue: e(l).inboundWay, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).inboundWay = a), options: e(B).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(l).basicClass & e(m) ? C("", true) : (p(), v(i, { key: 0, modelValue: e(l).orderSupplyType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).orderSupplyType = a), options: e(L).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])), s(i, { modelValue: e(l).rejectStatus, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).rejectStatus = a), options: e($).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(F, { modelValue: e(l).workshopIds, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(l).workshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), s(X, { modelValue: e(l).realTime, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(l).realTime = a), label: "入库", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), s(O, { modelValue: e(l).supplierId, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(l).supplierId = a), basicClass: e(l).basicClass, type: e(g).RAW_MATERIAL.V | e(g).OTHER.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(n, { modelValue: e(l).operatorName, "onUpdate:modelValue": o[7] || (o[7] = (a) => e(l).operatorName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/编辑人/审核人", size: "default", style: { width: "200px" }, onKeyup: r(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o[16] || (o[16] = h("br", null, null, -1)), s(e(G), { projectId: e(l).projectId, "onUpdate:projectId": o[8] || (o[8] = (a) => e(l).projectId = a), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": o[9] || (o[9] = (a) => e(l).projectWarehouseType = a), class: "filter-item", onChange: e(t).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s(H, { modelValue: e(l).branchCompanyId, "onUpdate:modelValue": o[10] || (o[10] = (a) => e(l).branchCompanyId = a), class: "filter-item", clearable: "", placeholder: "合同签订主体", style: { width: "250px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), s(n, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": o[11] || (o[11] = (a) => e(l).purchaseSN = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "采购合同编号", size: "default", style: { width: "200px" }, onKeyup: r(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[12] || (o[12] = (a) => e(l).serialNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "入库单号", size: "default", style: { width: "200px" }, onKeyup: r(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).licensePlate, "onUpdate:modelValue": o[13] || (o[13] = (a) => e(l).licensePlate = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "车牌/船牌号", size: "default", style: { width: "200px" }, onKeyup: r(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o[17] || (o[17] = h("br", null, null, -1)), s(n, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": o[14] || (o[14] = (a) => e(l).shipmentNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "物流单号", size: "default", style: { width: "200px" }, onKeyup: r(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(E, { modelValue: e(l).inboundTime, "onUpdate:modelValue": o[15] || (o[15] = (a) => e(l).inboundTime = a), "default-time": T.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(q), "unlink-panels": "", "start-placeholder": "审核日期", "end-placeholder": "审核日期", style: { width: "240px" }, class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(e(J))])) : C("", true), s(e(Z), null, { optLeft: K(() => [_(s(S, { disabled: y.value.length === 0, params: y.value, "api-key": "wmsRmInboundReceipt", class: "filter-item", size: "default", type: "warning", onDownloadSuccess: f, onSuccess: e(t).selectAllChange, onPrintSuccess: f }, null, 8, ["disabled", "params", "onSuccess"]), [[N, e(U).get]])]), _: 1 })]);
  };
} };
export {
  re as default
};
