import { inject as w } from "vue";
import { ref as f } from "vue";
import { computed as _ } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withKeys as b } from "vue";
import { createElementVNode as R } from "vue";
import { withCtx as U } from "vue";
import { withDirectives as j } from "vue";
import { ElInput as I } from "element-plus";
import { ElDatePicker as v } from "element-plus";
import { o as N } from "../../../../../../../../modules/record-v2-41933798.js";
import { B as D, cJ as x, gG as r, I as V, C as L, E as P } from "../../../../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const A = { class: "head-container" }, M = { __name: "header", setup(K) {
  const h = w("permission"), u = f([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  f([{ L: "生产使用", K: "PRODUCE", V: 1, DISABLED: true, COLOR: "#f56c6c" }, { L: "对外出售", K: "FOR_SALE", V: 2, DISABLED: false, COLOR: "#f7b551" }]);
  const C = { projectId: void 0, projectWarehouseType: void 0, createTime: [], outboundTime: [], serialNumber: void 0, operatorName: void 0, basicClass: void 0, boolPartyA: false, outboundTypeSelection: void 0 }, { crud: n, query: t } = D(C), i = _(() => n.selections.map((s) => s.id));
  async function d(s) {
    await N(s), n.toQuery();
  }
  return (s, o) => {
    const p = y("common-radio-button"), m = I, c = v, T = y("print-table"), g = S("permission");
    return E(), O("div", A, [l(p, { modelValue: e(t).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).basicClass = a), options: e(x).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(p, { modelValue: e(t).outboundTypeSelection, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).outboundTypeSelection = a), options: e(r).ENUM, unshowVal: [e(r).SCRAPS.V, e(r).OUTSOURCE.V, e(r).TEMPORARY_LOAN.V], class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), l(m, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).serialNumber = a), class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "200px" }, onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(m, { modelValue: e(t).operatorName, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).operatorName = a), class: "filter-item", clearable: "", placeholder: "领用人/申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o[8] || (o[8] = R("br", null, null, -1)), l(e(Q), { projectId: e(t).projectId, "onUpdate:projectId": o[4] || (o[4] = (a) => e(t).projectId = a), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": o[5] || (o[5] = (a) => e(t).projectWarehouseType = a), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(c, { modelValue: e(t).createTime, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(t).createTime = a), "default-time": u.value, shortcuts: e(V), class: "filter-item", "end-placeholder": "申请日期", "range-separator": ":", size: "default", "start-placeholder": "申请日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(c, { modelValue: e(t).outboundTime, "onUpdate:modelValue": o[7] || (o[7] = (a) => e(t).outboundTime = a), "default-time": u.value, shortcuts: e(V), class: "filter-item", "end-placeholder": "出库日期", "range-separator": ":", size: "default", "start-placeholder": "出库日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(e(L)), l(e(P), null, { optLeft: U(() => [j(l(T, { disabled: i.value.length === 0, params: i.value, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning", onSuccess: e(n).selectAllChange, onDownloadSuccess: d, onPrintSuccess: d }, null, 8, ["disabled", "params", "onSuccess"]), [[g, e(h).get]])]), _: 1 })]);
  };
} };
export {
  M as default
};
