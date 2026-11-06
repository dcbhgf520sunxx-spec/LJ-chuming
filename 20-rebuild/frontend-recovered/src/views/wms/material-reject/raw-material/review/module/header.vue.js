import { ref as E } from "vue";
import { inject as N } from "vue";
import { useRoute as S } from "vue-router";
import { computed as _ } from "vue";
import { onMounted as v } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withKeys as r } from "vue";
import { createElementVNode as j } from "vue";
import { createCommentVNode as U } from "vue";
import { withCtx as R } from "vue";
import { withDirectives as x } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElInput as M } from "element-plus";
import { B as Q, cV as k, bl as y, ib as W, I as z, bF as b, bE as D, C as A, E as L } from "../../../../../../shared/runtime.js";
import { _ as O } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const B = { class: "head-container" }, P = { key: 0 }, G = { __name: "header", setup(H) {
  const V = E([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), C = { createTime: [], basicClass: void 0, reviewStatus: void 0, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, inboundSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, h = N("permission"), i = S(), { crud: o, query: a } = Q(C), u = _(() => o.selections.map((d) => d.id));
  return v(() => {
    +i.params.basicClass === k ? a.basicClass = y.STEEL_PLATE.V : a.basicClass = i.params.basicClass;
  }), (d, t) => {
    const p = m("common-radio-button"), w = K, n = M, T = m("print-table"), g = I("permission");
    return c(), f("div", B, [e(o).searchToggle ? (c(), f("div", P, [s(p, { modelValue: e(a).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).basicClass = l), options: e(y).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(p, { modelValue: e(a).reviewStatus, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).reviewStatus = l), options: e(W).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(w, { modelValue: e(a).createTime, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).createTime = l), "default-time": V.value, shortcuts: e(z), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(n, { modelValue: e(a).operatorName, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).operatorName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "退货申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t[10] || (t[10] = j("br", null, null, -1)), s(e(O), { projectId: e(a).projectId, "onUpdate:projectId": t[4] || (t[4] = (l) => e(a).projectId = l), projectWarehouseType: e(a).projectWarehouseType, "onUpdate:projectWarehouseType": t[5] || (t[5] = (l) => e(a).projectWarehouseType = l), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s(D, { modelValue: e(a).supplierId, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).supplierId = l), basicClass: e(a).basicClass, type: e(b).RAW_MATERIAL.V | e(b).OTHER.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(n, { modelValue: e(a).purchaseSN, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).purchaseSN = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(a).inboundSN, "onUpdate:modelValue": t[8] || (t[8] = (l) => e(a).inboundSN = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按入库单号搜索", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[9] || (t[9] = (l) => e(a).serialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按退货单号搜索", size: "default", style: { width: "200px" }, onKeyup: r(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(A))])) : U("", true), s(e(L), null, { optLeft: R(() => [x(s(T, { disabled: u.value.length === 0, params: u.value, "api-key": "wmsRmRejectReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: e(o).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"]), [[g, e(h).get]])]), _: 1 })]);
  };
} };
export {
  G as default
};
