import { ref as b } from "vue";
import { inject as w } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as i } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { withKeys as m } from "vue";
import { createElementVNode as I } from "vue";
import { createCommentVNode as T } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as U } from "vue";
import { withModifiers as E } from "vue";
import { createTextVNode as x } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElInput as j } from "element-plus";
import { jO as c, B as k, j_ as v, iF as z, I as D, iH as K, bE as M, C as B, E as O } from "../../../../shared/runtime.js";
const H = { class: "head-container" }, P = { key: 0 }, A = { __name: "header", setup(R) {
  const f = b([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), y = { createTime: [], orderSupplyType: void 0, materialType: void 0, purchaseType: void 0, settlementStatus: void 0, purchaseStatus: c.UNFINISHED.V, projectId: void 0, serialNumber: void 0, branchCompanyId: void 0, supplierId: void 0, operatorName: void 0 }, h = w("permission"), { crud: l, query: o } = k(y);
  return (q, t) => {
    const s = r("common-radio-button"), V = Q, d = j, C = r("project-cascader"), g = r("common-button"), _ = N("permission");
    return u(), i("div", H, [e(l).searchToggle ? (u(), i("div", P, [n(s, { modelValue: e(o).materialType, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).materialType = a), options: e(v).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).purchaseStatus, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).purchaseStatus = a), options: e(c).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).settlementStatus, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).settlementStatus = a), options: e(z).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(V, { modelValue: e(o).createTime, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).createTime = a), "default-time": f.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(D), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), n(d, { modelValue: e(o).operatorName, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).operatorName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按操作人搜索", class: "filter-item", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t[9] || (t[9] = I("br", null, null, -1)), n(C, { modelValue: e(o).projectId, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).projectId = a), placeholder: "所属项目", clearable: "", class: "filter-item", style: { width: "250px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(K, { modelValue: e(o).branchCompanyId, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).branchCompanyId = a), placeholder: "合同签订主体", class: "filter-item", style: { width: "250px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(M, { modelValue: e(o).supplierId, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).supplierId = a), type: e(o).purchaseType, clearable: "", placeholder: "可选择供应商搜索", "show-hide": "", class: "filter-item", style: { width: "250px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "type", "onChange"]), n(d, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).serialNumber = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "按采购合同编号搜索", class: "filter-item", onKeyup: m(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(B))])) : T("", true), n(e(O), null, { optLeft: p(() => [S((u(), U(g, { class: "filter-item", size: "default", type: "primary", icon: "el-icon-plus", onClick: E(e(l).toAdd, ["stop"]) }, { default: p(() => t[10] || (t[10] = [x(" 采购订单 ")])), _: 1, __: [10] }, 8, ["onClick"])), [[_, e(h).add]])]), _: 1 })]);
  };
} };
export {
  A as default
};
