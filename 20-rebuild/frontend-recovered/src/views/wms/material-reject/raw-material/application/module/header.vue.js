import { ref as b } from "vue";
import { useRoute as C } from "vue-router";
import { onMounted as h } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as E } from "vue";
import { withKeys as n } from "vue";
import { createCommentVNode as N } from "vue";
import { withCtx as I } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { ElInput as g } from "element-plus";
import { B as w, cV as j, bl as i, I as U, bF as m, bE as S, C as x, E as K } from "../../../../../../shared/runtime.js";
import { _ as M } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const Q = { class: "head-container" }, W = { key: 0 }, z = { __name: "header", setup(k) {
  const c = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = { createTime: [], basicClass: void 0, reviewStatus: void 0, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0 }, u = C(), { crud: s, query: a } = w(f);
  return h(() => {
    +u.params.basicClass === j ? a.basicClass = i.STEEL_PLATE.V : a.basicClass = u.params.basicClass;
  }), (v, o) => {
    const y = T("common-radio-button"), V = _, r = g;
    return d(), p("div", Q, [e(s).searchToggle ? (d(), p("div", W, [l(y, { type: "enum", modelValue: e(a).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).basicClass = t), options: e(i).ENUM, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(V, { modelValue: e(a).createTime, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).createTime = t), "default-time": c.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(U), "unlink-panels": "", "start-placeholder": "入库日期", "end-placeholder": "入库日期", style: { width: "240px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(S, { modelValue: e(a).supplierId, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).supplierId = t), type: e(m).RAW_MATERIAL.V | e(m).OTHER.V, mode: "cross", clearable: "", class: "filter-item", onChange: e(s).toQuery, placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" } }, null, 8, ["modelValue", "type", "onChange"]), o[8] || (o[8] = E("br", null, null, -1)), l(e(M), { projectId: e(a).projectId, "onUpdate:projectId": o[3] || (o[3] = (t) => e(a).projectId = t), projectWarehouseType: e(a).projectWarehouseType, "onUpdate:projectWarehouseType": o[4] || (o[4] = (t) => e(a).projectWarehouseType = t), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(r, { modelValue: e(a).purchaseSN, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(a).purchaseSN = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按采购合同编号搜索", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(a).serialNumber, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(a).serialNumber = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按入库单号搜索", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(a).operatorName, "onUpdate:modelValue": o[7] || (o[7] = (t) => e(a).operatorName = t), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "申请人/编辑人/审核人", class: "filter-item", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(x))])) : N("", true), l(e(K), null, { optLeft: I(() => o[9] || (o[9] = [])), _: 1 })]);
  };
} };
export {
  z as default
};
