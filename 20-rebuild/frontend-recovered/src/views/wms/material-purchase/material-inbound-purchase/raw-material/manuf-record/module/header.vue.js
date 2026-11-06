import { ref as b } from "vue";
import { useRoute as C } from "vue-router";
import { watchEffect as h } from "vue";
import { onMounted as T } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as N } from "vue";
import { withKeys as n } from "vue";
import { createCommentVNode as w } from "vue";
import { withCtx as S } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as g } from "element-plus";
import { jZ as I, B as j, yA as p, cV as M, cJ as m, kD as K, I as _, bF as v, bE as x, C as Q, E as A } from "../../../../../../../shared/runtime.js";
import { _ as k } from "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const P = { class: "head-container" }, R = { key: 0 }, F = { __name: "header", setup(W) {
  const f = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { createTime: [], orderSupplyType: { value: I.SELF.V, resetAble: false }, basicClass: void 0, projectId: void 0, projectWarehouseType: void 0, qualityTestingEnum: void 0, reviewStatus: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, u = C(), { crud: s, query: l } = j(c);
  return h(() => {
    l.basicClass & p && (l.orderSupplyType = void 0);
  }), T(() => {
    +u.params.basicClass === M ? l.basicClass = m.STEEL_PLATE.V : +u.params.basicClass === p ? l.basicClass = m.STRUC_MANUFACTURED.V : l.basicClass = u.params.basicClass;
  }), (z, a) => {
    const y = E("common-radio-button"), V = U, r = g;
    return d(), i("div", P, [e(s).searchToggle ? (d(), i("div", R, [o(y, { type: "enum", modelValue: e(l).reviewStatus, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).reviewStatus = t), options: e(K).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(V, { modelValue: e(l).createTime, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(l).createTime = t), "default-time": f.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(_), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(e(k), { projectId: e(l).projectId, "onUpdate:projectId": a[2] || (a[2] = (t) => e(l).projectId = t), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": a[3] || (a[3] = (t) => e(l).projectWarehouseType = t), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), a[10] || (a[10] = N("br", null, null, -1)), o(x, { modelValue: e(l).supplierId, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(l).supplierId = t), basicClass: e(l).basicClass, type: e(v).RAW_MATERIAL.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(s).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), o(r, { modelValue: e(l).operatorName, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(l).operatorName = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(l).purchaseSN, "onUpdate:modelValue": a[6] || (a[6] = (t) => e(l).purchaseSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[7] || (a[7] = (t) => e(l).serialNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(l).licensePlate, "onUpdate:modelValue": a[8] || (a[8] = (t) => e(l).licensePlate = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(r, { modelValue: e(l).shipmentNumber, "onUpdate:modelValue": a[9] || (a[9] = (t) => e(l).shipmentNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(Q))])) : w("", true), o(e(A), null, { optLeft: S(() => a[11] || (a[11] = [])), _: 1 })]);
  };
} };
export {
  F as default
};
