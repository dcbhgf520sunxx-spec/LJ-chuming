import { resolveComponent as c } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createElementVNode as r } from "vue";
import { withCtx as f } from "vue";
import { Fragment as C } from "vue";
import { ElInput as g } from "element-plus";
import { ElDatePicker as U } from "element-plus";
import { _ as A, jJ as s, B as T, ab as i, cE as d, fv as E, bE as b, iH as w, C as x, E as N } from "../../../../shared/runtime.js";
const R = { style: { width: "100%", display: "flex", gap: "8px" } }, I = { style: { width: "100%", display: "flex", "justify-content": "end" } }, M = { __name: "header", setup(v) {
  const u = { materialType: s.RAW_MATERIAL.V, basicClass: void 0 }, { query: a, crud: n } = T(u);
  function m() {
    a.date && a.date.length > 1 ? (a.startTime = a.date[0], a.endTime = a.date[1]) : (a.startTime = void 0, a.endTime = void 0), n.toQuery();
  }
  return (D, l) => {
    const p = g, y = U, V = c("print-table");
    return _(), h(C, null, [o(i, { modelValue: e(a).materialType, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).materialType = t), options: e(s).ENUM, type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(i, { "show-option-all": true, "unshow-val": e(a).materialType === e(s).RAW_MATERIAL.V ? [e(d).ENCL_MANUFACTURED.V, e(d).STRUC_MANUFACTURED.V] : [], modelValue: e(a).basicClass, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).basicClass = t), options: e(a).materialType === e(s).RAW_MATERIAL.V ? e(d).ENUM : [e(d).ENCL_MANUFACTURED, e(d).STRUC_MANUFACTURED], type: "enum", onChange: e(n).toQuery }, null, 8, ["unshow-val", "modelValue", "options", "onChange"]), o(p, { modelValue: e(a).createUser, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(a).createUser = t), placeholder: "办理人检索", style: { width: "200px" }, size: "default" }, null, 8, ["modelValue"]), o(p, { modelValue: e(a).className, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(a).className = t), placeholder: "名称检索", style: { width: "200px" }, size: "default" }, null, 8, ["modelValue"]), r("section", R, [r("div", null, [o(y, { modelValue: e(a).date, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(a).date = t), style: { width: "250px" }, "value-format": "x", type: "daterange", "range-separator": ":", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: m }, null, 8, ["modelValue"])]), o(E, { modelValue: e(a).projectId, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(a).projectId = t), isAll: "", clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(p, { modelValue: e(a).purchaseSerialNumber, "onUpdate:modelValue": l[6] || (l[6] = (t) => e(a).purchaseSerialNumber = t), placeholder: "采购合同号检索", style: { width: "200px" } }, null, 8, ["modelValue"]), o(b, { modelValue: e(a).supplierId, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(a).supplierId = t), type: e(a).basicClass, clearable: "", placeholder: "供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "type", "onChange"]), o(w, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(a).branchCompanyId = t), class: "filter-item", placeholder: "采购单位", clearable: "", style: { width: "250px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(p, { modelValue: e(a).specification, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(a).specification = t), placeholder: "规格检索", style: { width: "200px" } }, null, 8, ["modelValue"]), o(x)]), r("div", I, [o(N, { "show-search": false }, { optLeft: f(() => [o(V, { "api-key": e(a).materialType === e(s).RAW_MATERIAL.V ? "purchaseDetailDimensions" : "purchaseDetailDimensionsProduct", type: "warning", params: { ...e(a), pageNumber: e(n).page.page, pageSize: e(n).page.size } }, null, 8, ["api-key", "params"])]), _: 1 })])], 64);
  };
} }, S = A(M, [["__scopeId", "data-v-8dc0e846"]]);
export {
  S as default
};
