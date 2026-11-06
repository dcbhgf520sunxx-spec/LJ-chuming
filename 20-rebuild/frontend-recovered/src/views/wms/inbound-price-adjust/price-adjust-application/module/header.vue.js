import { ref as b } from "vue";
import { useRoute as h } from "vue-router";
import { onMounted as C } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withKeys as n } from "vue";
import { createElementVNode as T } from "vue";
import { createCommentVNode as N } from "vue";
import { withCtx as w } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElInput as g } from "element-plus";
import { jZ as j, kD as U, xl as m, B as I, cV as x, bl as f, j$ as K, bF as M, bE as Q, I as v, C as A, E as P } from "../../../../../shared/runtime.js";
import { _ as W } from "../../../../../modules/warehouse-project-cascader-17e2b952.js";
const _ = { class: "head-container" }, k = { key: 0 }, B = { __name: "header", setup(R) {
  const y = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { createTime: [], orderSupplyType: { value: j.SELF.V, resetAble: false }, basicClass: void 0, projectId: void 0, projectWarehouseType: void 0, qualityTestingEnum: void 0, reviewStatus: { value: U.PASS.V, resetAble: false }, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0, rejectStatus: { value: [m.NONE.V, m.PART.V], resetAble: false } }, u = h(), { crud: s, query: a } = I(c);
  return C(() => {
    +u.params.basicClass === x ? a.basicClass = f.STEEL_PLATE.V : a.basicClass = u.params.basicClass;
  }), (z, l) => {
    const d = E("common-radio-button"), V = S, r = g;
    return i(), p("div", _, [e(s).searchToggle ? (i(), p("div", k, [o(d, { type: "enum", modelValue: e(a).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).basicClass = t), options: e(f).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(d, { type: "enum", modelValue: e(a).inboundWay, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).inboundWay = t), options: e(K).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(Q, { modelValue: e(a).supplierId, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(a).supplierId = t), basicClass: e(a).basicClass, type: e(M).RAW_MATERIAL.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(s).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), o(V, { modelValue: e(a).createTime, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(a).createTime = t), "default-time": y.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(v), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(r, { modelValue: e(a).operatorName, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(a).operatorName = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).purchaseSN, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(a).purchaseSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l[11] || (l[11] = T("br", null, null, -1)), o(e(W), { projectId: e(a).projectId, "onUpdate:projectId": l[6] || (l[6] = (t) => e(a).projectId = t), projectWarehouseType: e(a).projectWarehouseType, "onUpdate:projectWarehouseType": l[7] || (l[7] = (t) => e(a).projectWarehouseType = t), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), o(r, { modelValue: e(a).serialNumber, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(a).serialNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).licensePlate, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(a).licensePlate = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(a).shipmentNumber, "onUpdate:modelValue": l[10] || (l[10] = (t) => e(a).shipmentNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(A))])) : N("", true), o(e(P), null, { optLeft: w(() => l[12] || (l[12] = [])), _: 1 })]);
  };
} };
export {
  B as default
};
