import { ref as T } from "vue";
import { inject as v } from "vue";
import { useRoute as R } from "vue-router";
import { computed as S } from "vue";
import { onMounted as I } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as U } from "vue";
import { withKeys as b } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as D } from "vue";
import { withDirectives as Q } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElInput as x } from "element-plus";
import { l as i, B as M, bl as K, AX as O, I as P, C as W, E as z } from "../../../../../../shared/runtime.js";
import { _ as B } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
function $(s) {
  return i({ url: "/api/wms/report/raw-materials/return/receiptList", method: "get", params: s });
}
function A(s) {
  return i({ url: `/api/wms/report/raw-materials/return/receiptDetailById/${s}`, method: "get" });
}
function q(s) {
  return i({ url: `/api/wms/return/receipt/${s}/printState`, method: "get" });
}
const Y = { get: $, detail: A }, H = { class: "head-container" }, L = { key: 0 }, X = { __name: "header", setup(s) {
  const h = T([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), _ = { createTime: [], basicClass: void 0, reviewStatus: void 0, projectId: void 0, projectWarehouseType: void 0, serialNumber: void 0, operatorName: void 0 }, g = v("permission"), w = R(), { crud: r, query: o } = M(_), u = S(() => r.selections.map((l) => l.id));
  I(() => {
    o.basicClass = w.params.basicClass;
  });
  async function d(l) {
    await q(l), r.toQuery();
  }
  return (l, t) => {
    const p = c("common-radio-button"), C = k, m = x, V = c("print-table"), j = N("permission");
    return f(), y("div", H, [e(r).searchToggle ? (f(), y("div", L, [n(p, { modelValue: e(o).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).basicClass = a), options: e(K).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: e(o).boolRealReturn, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).boolRealReturn = a), options: e(O).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(C, { modelValue: e(o).createTime, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).createTime = a), "default-time": h.value, shortcuts: e(P), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(r).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), t[7] || (t[7] = U("br", null, null, -1)), n(e(B), { projectId: e(o).projectId, "onUpdate:projectId": t[3] || (t[3] = (a) => e(o).projectId = a), projectWarehouseType: e(o).projectWarehouseType, "onUpdate:projectWarehouseType": t[4] || (t[4] = (a) => e(o).projectWarehouseType = a), class: "filter-item", onChange: e(r).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), n(m, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).serialNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按退库单号搜索", size: "default", style: { width: "200px" }, onKeyup: b(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(o).operatorName, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).operatorName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/编辑人/审核人", size: "default", style: { width: "200px" }, onKeyup: b(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(W))])) : E("", true), n(e(z), null, { optLeft: D(() => [Q(n(V, { disabled: u.value.length === 0, params: u.value, "api-key": "wmsRmReturnReceiptReport", class: "filter-item", size: "default", type: "warning", onSuccess: e(r).selectAllChange, onDownloadSuccess: d, onPrintSuccess: d }, null, 8, ["disabled", "params", "onSuccess"]), [[j, e(g).get]])]), _: 1 })]);
  };
} }, Z = Object.freeze(Object.defineProperty({ __proto__: null, default: X }, Symbol.toStringTag, { value: "Module" }));
export {
  X as _,
  Y as c,
  Z as h
};
