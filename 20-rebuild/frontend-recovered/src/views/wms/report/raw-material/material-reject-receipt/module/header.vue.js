import { ref as k } from "vue";
import { inject as D } from "vue";
import { useRoute as Q } from "vue-router";
import { computed as R } from "vue";
import { onMounted as K } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as V } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withKeys as i } from "vue";
import { createElementVNode as b } from "vue";
import { createCommentVNode as P } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as W } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as g } from "vue";
import { ElDatePicker as z } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElTag as L } from "element-plus";
import { r as O } from "../../../../../../modules/reject-03b2f373.js";
import { kD as B, B as $, cV as H, cJ as w, I as q, gF as F, bF as T, bE as J, C as G, bV as _, E as X } from "../../../../../../shared/runtime.js";
import { _ as Y } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { _ as Z } from "../../../../../../modules/closing-time-date-query-82715fa2.js";
const ee = { class: "head-container" }, te = { key: 0 }, ae = { class: "flex gap-2" }, ie = { __name: "header", props: { DetailsCount: { type: Object } }, setup(S) {
  const d = S, E = k([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), N = { realTime: [], reviewTime: [], basicClass: void 0, reviewStatus: B.PASS.V, projectId: void 0, projectWarehouseType: void 0, purchaseSN: void 0, inboundSN: void 0, serialNumber: void 0, supplierId: void 0, operatorName: void 0, workshopIds: [] }, v = D("permission"), p = Q(), { crud: s, query: a } = $(N), m = R(() => s.selections.map((n) => n.id));
  K(() => {
    +p.params.basicClass === H ? a.basicClass = w.STEEL_PLATE.V : a.basicClass = p.params.basicClass;
  });
  async function c(n) {
    await O(n), s.toQuery();
  }
  return (n, o) => {
    const x = y("common-radio-button"), I = z, r = A, j = y("print-table"), f = L, U = M("permission");
    return h(), V("div", ee, [e(s).searchToggle ? (h(), V("div", te, [l(x, { modelValue: e(a).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).basicClass = t), options: e(w).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(Z, { modelValue: e(a).realTime, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).realTime = t), label: "退货", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(I, { modelValue: e(a).reviewTime, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).reviewTime = t), "default-time": E.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(q), "unlink-panels": "", "start-placeholder": "审核日期", "end-placeholder": "审核日期", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(F, { modelValue: e(a).workshopIds, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(a).workshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(J, { modelValue: e(a).supplierId, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(a).supplierId = t), basicClass: e(a).basicClass, type: e(T).RAW_MATERIAL.V | e(T).OTHER.V, class: "filter-item", clearable: "", mode: "cross", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "250px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "basicClass", "type", "onChange"]), l(r, { modelValue: e(a).operatorName, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(a).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "退货申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: i(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o[11] || (o[11] = b("br", null, null, -1)), l(e(Y), { projectId: e(a).projectId, "onUpdate:projectId": o[6] || (o[6] = (t) => e(a).projectId = t), projectWarehouseType: e(a).projectWarehouseType, "onUpdate:projectWarehouseType": o[7] || (o[7] = (t) => e(a).projectWarehouseType = t), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(r, { modelValue: e(a).purchaseSN, "onUpdate:modelValue": o[8] || (o[8] = (t) => e(a).purchaseSN = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "default", style: { width: "200px" }, onKeyup: i(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(a).inboundSN, "onUpdate:modelValue": o[9] || (o[9] = (t) => e(a).inboundSN = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按入库单号搜索", size: "default", style: { width: "200px" }, onKeyup: i(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(a).serialNumber, "onUpdate:modelValue": o[10] || (o[10] = (t) => e(a).serialNumber = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按退货单号搜索", size: "default", style: { width: "200px" }, onKeyup: i(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(G))])) : P("", true), l(e(X), null, { optLeft: u(() => [W(l(j, { disabled: m.value.length === 0, params: m.value, "api-key": "wmsRmRejectReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: e(s).selectAllChange, onDownloadSuccess: c, onPrintSuccess: c }, null, 8, ["disabled", "params", "onSuccess"]), [[U, e(v).get]])]), viewLeft: u(() => [b("div", ae, [l(f, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: u(() => {
      var t;
      return [C(" 含税金额汇总：" + g(e(_)(((t = d.DetailsCount) == null ? void 0 : t.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 }), l(f, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: u(() => {
      var t;
      return [C(" 不含税金额汇总：" + g(e(_)(((t = d.DetailsCount) == null ? void 0 : t.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} };
export {
  ie as default
};
