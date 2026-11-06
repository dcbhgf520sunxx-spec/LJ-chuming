import { ref as N } from "vue";
import { inject as S } from "vue";
import { computed as _ } from "vue";
import { watchEffect as g } from "vue";
import { onMounted as v } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withKeys as r } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as A } from "vue";
import { withDirectives as I } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElInput as K } from "element-plus";
import { Au as u, ib as Q, B as R, yA as D, fv as z, I as P, bF as k, bE as j, iH as F, C as O, E as B } from "../../../../../../../shared/runtime.js";
const H = { class: "head-container" }, $ = { key: 0 }, G = { __name: "header", setup(q) {
  const y = N([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), V = { inboundTime: [], basicClass: u.STRUC_MANUFACTURED.V, orderSupplyType: void 0, rejectStatus: void 0, projectId: void 0, projectWarehouseType: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0, reviewStatus: { value: Q.PASS.V, resetAble: false } }, b = S("permission"), { crud: o, query: l } = R(V), d = _(() => o.selections.map((i) => i.id));
  g(() => {
    l.basicClass & D && (l.orderSupplyType = void 0);
  }), v(() => {
  });
  return (i, a) => {
    const h = m("common-radio-button"), C = x, n = K, w = m("print-table"), U = T("permission");
    return c(), f("div", H, [e(o).searchToggle ? (c(), f("div", $, [s(h, { modelValue: e(l).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).basicClass = t), options: e(u).ENUM, unshowVal: [e(u).AUX_MANUFACTURED.V], class: "filter-item", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), s(z, { modelValue: e(l).projectId, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(l).projectId = t), class: "filter-item", style: { width: "220px" }, clearable: "", isAll: "", placeholder: "所属项目", size: "default", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(C, { modelValue: e(l).inboundTime, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(l).inboundTime = t), "default-time": y.value, shortcuts: e(P), class: "filter-item", "end-placeholder": "入库日期", "range-separator": ":", size: "default", "start-placeholder": "入库日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(j, { modelValue: e(l).supplierId, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(l).supplierId = t), basicClass: e(l).basicClass, type: e(k).MANUFACTURED.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(n, { modelValue: e(l).operatorName, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(l).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/编辑人/审核人", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(F, { modelValue: e(l).branchCompanyId, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(l).branchCompanyId = t), class: "filter-item", clearable: "", placeholder: "合同签订主体", style: { width: "250px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(n, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": a[6] || (a[6] = (t) => e(l).purchaseSN = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "采购合同编号", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[7] || (a[7] = (t) => e(l).serialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "入库单号", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).licensePlate, "onUpdate:modelValue": a[8] || (a[8] = (t) => e(l).licensePlate = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "车牌/船牌号", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": a[9] || (a[9] = (t) => e(l).shipmentNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "物流单号", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(O))])) : E("", true), s(e(B), null, { optLeft: A(() => [I(s(w, { disabled: d.value.length === 0, params: d.value, "api-key": "manufRmInboundReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: e(o).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"]), [[U, e(b).get]])]), _: 1 })]);
  };
} };
export {
  G as default
};
