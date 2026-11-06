import { ref as T } from "vue";
import { watchEffect as h } from "vue";
import { onMounted as E } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as y } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as N } from "vue";
import { withKeys as u } from "vue";
import { withCtx as S } from "vue";
import { ElDatePicker as w } from "element-plus";
import { ElInput as M } from "element-plus";
import { B as I, yA as m, cM as c, k3 as j, am as d, jZ as A, k0 as Q, kD as K, I as R, bF as k, bE as v, C as x, E as P } from "../../../../../../shared/runtime.js";
import { _ } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const z = { class: "head-container" }, W = { key: 0 }, q = { __name: "header", setup(D) {
  const V = T([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), C = { createTime: [], orderSupplyType: void 0, basicClass: void 0, projectId: void 0, projectWarehouseType: void 0, qualityTestingEnum: void 0, reviewStatus: void 0, shipmentNumber: void 0, licensePlate: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, { crud: a, query: o } = I(C);
  return h(() => {
    o.basicClass & m && (o.orderSupplyType = void 0);
  }), E(() => {
    const n = c.get("ROUTER_PARAMS");
    if (n != null && n.basicClass) {
      const l = +n.basicClass;
      l === j ? o.basicClass = d.STEEL_PLATE.V : l === m ? o.basicClass = d.STRUC_MANUFACTURED.V : o.basicClass = l, c.remove("ROUTER_PARAMS");
    }
  }), (n, l) => {
    const i = U("common-radio-button"), b = w, r = M;
    return p(), y("div", z, [e(a).searchToggle ? (p(), y("div", W, [s(i, { type: "enum", modelValue: e(o).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(o).basicClass = t), options: e(d).ENUM, unshowVal: [e(d).GAS.V], "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), e(o).basicClass & e(m) ? f("", true) : (p(), g(i, { key: 0, modelValue: e(o).orderSupplyType, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(o).orderSupplyType = t), options: e(A).ENUM, "show-option-all": "", type: "enumSL", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])), s(i, { type: "enum", modelValue: e(o).qualityTestingEnum, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(o).qualityTestingEnum = t), options: e(Q).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(i, { type: "enum", modelValue: e(o).reviewStatus, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(o).reviewStatus = t), options: e(K).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(b, { modelValue: e(o).createTime, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(o).createTime = t), "default-time": V.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(R), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l[13] || (l[13] = N("br", null, null, -1)), s(e(_), { projectId: e(o).projectId, "onUpdate:projectId": l[5] || (l[5] = (t) => e(o).projectId = t), projectWarehouseType: e(o).projectWarehouseType, "onUpdate:projectWarehouseType": l[6] || (l[6] = (t) => e(o).projectWarehouseType = t), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s(v, { modelValue: e(o).supplierId, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(o).supplierId = t), basicClass: e(o).basicClass, type: e(k).RAW_MATERIAL.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(a).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), s(r, { modelValue: e(o).operatorName, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(o).operatorName = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(o).purchaseSN, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(o).purchaseSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "采购合同编号", class: "filter-item", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(o).serialNumber, "onUpdate:modelValue": l[10] || (l[10] = (t) => e(o).serialNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "入库单号", class: "filter-item", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(o).licensePlate, "onUpdate:modelValue": l[11] || (l[11] = (t) => e(o).licensePlate = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "车牌/船牌号", class: "filter-item", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(o).shipmentNumber, "onUpdate:modelValue": l[12] || (l[12] = (t) => e(o).shipmentNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "物流单号", class: "filter-item", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(x))])) : f("", true), s(e(P), null, { optLeft: S(() => l[14] || (l[14] = [])), _: 1 })]);
  };
} };
export {
  q as default
};
