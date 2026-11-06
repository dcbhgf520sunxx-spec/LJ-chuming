import { ref as I } from "vue";
import { inject as k } from "vue";
import { computed as v } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as _ } from "vue";
import { withKeys as c } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as U } from "vue";
import { withDirectives as N } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElInput as Q } from "element-plus";
import { kD as S, B as D, bl as T, ib as M, I as R, fv as K, y3 as h, C as A, E as j } from "../../../../../../shared/runtime.js";
import { _ as f } from "../../../../../../modules/workshop-select-210dd661.js";
const z = { class: "head-container" }, B = { key: 0 }, H = { __name: "header", setup(O) {
  const V = I([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), y = { createTime: [], basicClass: void 0, projectId: void 0, reviewStatus: S.UNREVIEWED.V, sourceWorkshopIds: [], sourceWarehouseIds: void 0, directionWorkshopIds: [], directionWarehouseIds: void 0, serialNumber: void 0, operatorName: void 0 }, w = k("permission"), { crud: a, query: o } = D(y), n = v(() => a.selections.map((r) => r.id));
  return (r, l) => {
    const d = u("common-radio-button"), C = x, i = Q, b = u("print-table"), g = W("permission");
    return m(), p("div", z, [e(a).searchToggle ? (m(), p("div", B, [s(d, { modelValue: e(o).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(o).basicClass = t), options: e(T).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(d, { modelValue: e(o).reviewStatus, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(o).reviewStatus = t), options: e(M).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(C, { modelValue: e(o).startAndEndTime, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(o).startAndEndTime = t), "default-time": V.value, shortcuts: e(R), class: "filter-item", "end-placeholder": "申请结束日期", "range-separator": ":", size: "default", "start-placeholder": "申请开始日期", style: { width: "270px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l[10] || (l[10] = _("br", null, null, -1)), s(e(K), { modelValue: e(o).projectIds, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(o).projectIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(f, { modelValue: e(o).sourceWorkshopIds, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(o).sourceWorkshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "原仓库", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(h, { modelValue: e(o).sourceWarehouseIds, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(o).sourceWarehouseIds = t), "workshop-id": e(o).sourceWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "原存储位置", showAll: "", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"]), s(f, { modelValue: e(o).directionWorkshopIds, "onUpdate:modelValue": l[6] || (l[6] = (t) => e(o).directionWorkshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "目标仓库", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), s(h, { modelValue: e(o).directionWarehouseIds, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(o).directionWarehouseIds = t), "workshop-id": e(o).directionWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "目标存储位置", showAll: "", style: { width: "240px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"]), s(i, { modelValue: e(o).serialNumber, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(o).serialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按移库单号搜索", size: "default", style: { width: "200px" }, onKeyup: c(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(i, { modelValue: e(o).operatorName, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(o).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: c(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(A))])) : E("", true), s(e(j), null, { optLeft: U(() => [N(s(b, { disabled: n.value.length === 0, params: n.value, "api-key": "wmsRmMoveMaterialReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: e(a).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"]), [[g, e(w).get]])]), _: 1 })]);
  };
} };
export {
  H as default
};
