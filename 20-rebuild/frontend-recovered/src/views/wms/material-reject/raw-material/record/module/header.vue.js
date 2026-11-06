import { ref as b } from "vue";
import { useRoute as V } from "vue-router";
import { onMounted as C } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { withKeys as n } from "vue";
import { createElementVNode as N } from "vue";
import { createCommentVNode as T } from "vue";
import { withCtx as w } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as S } from "element-plus";
import { B as g, cV as I, bl as m, kD as U, I as j, bF as x, bE as K, C as M, E as Q } from "../../../../../../shared/runtime.js";
import { _ } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const v = { class: "head-container" }, k = { key: 0 }, A = { __name: "header", setup(W) {
  const c = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = { createTime: [], basicClass: void 0, reviewStatus: void 0, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, inboundSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, u = V(), { crud: s, query: o } = g(f);
  return C(() => {
    +u.params.basicClass === I ? o.basicClass = m.STEEL_PLATE.V : o.basicClass = u.params.basicClass;
  }), (z, l) => {
    const d = h("common-radio-button"), y = E, r = S;
    return i(), p("div", v, [e(s).searchToggle ? (i(), p("div", k, [t(d, { type: "enum", modelValue: e(o).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).basicClass = a), options: e(m).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(d, { type: "enum", modelValue: e(o).reviewStatus, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).reviewStatus = a), options: e(U).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(y, { modelValue: e(o).createTime, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).createTime = a), "default-time": c.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(j), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), t(r, { modelValue: e(o).operatorName, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).operatorName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "退货申请人/审核人", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l[10] || (l[10] = N("br", null, null, -1)), t(e(_), { projectId: e(o).projectId, "onUpdate:projectId": l[4] || (l[4] = (a) => e(o).projectId = a), projectWarehouseType: e(o).projectWarehouseType, "onUpdate:projectWarehouseType": l[5] || (l[5] = (a) => e(o).projectWarehouseType = a), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), t(K, { modelValue: e(o).supplierId, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(o).supplierId = a), basicClass: e(o).basicClass, type: e(x).RAW_MATERIAL.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(s).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), t(r, { modelValue: e(o).purchaseSN, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(o).purchaseSN = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按采购合同编号搜索", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(r, { modelValue: e(o).inboundSN, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(o).inboundSN = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按入库单号搜索", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(r, { modelValue: e(o).serialNumber, "onUpdate:modelValue": l[9] || (l[9] = (a) => e(o).serialNumber = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按退货单号搜索", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(M))])) : T("", true), t(e(Q), null, { optLeft: w(() => l[11] || (l[11] = [])), _: 1 })]);
  };
} };
export {
  A as default
};
