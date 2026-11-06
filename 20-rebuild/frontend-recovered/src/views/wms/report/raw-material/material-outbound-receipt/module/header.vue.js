import { inject as S } from "vue";
import { ref as f } from "vue";
import { computed as w } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withKeys as V } from "vue";
import { createElementVNode as _ } from "vue";
import { withCtx as O } from "vue";
import { withDirectives as j } from "vue";
import { ElInput as I } from "element-plus";
import { ElDatePicker as N } from "element-plus";
import { o as v } from "../../../../../../modules/record-v2-41933798.js";
import { B as D, cJ as L, jZ as Q, gG as r, I as b, C as x, E as K } from "../../../../../../shared/runtime.js";
import { _ as P } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const k = { class: "head-container" }, q = { __name: "header", setup(A) {
  const C = S("permission"), i = f([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  f([{ L: "生产使用", K: "PRODUCE", V: 1, DISABLED: true, COLOR: "#f56c6c" }, { L: "对外出售", K: "FOR_SALE", V: 2, DISABLED: false, COLOR: "#f7b551" }]);
  const h = { projectId: void 0, projectWarehouseType: void 0, createTime: [], outboundTime: [], serialNumber: void 0, operatorName: void 0, basicClass: void 0, outboundTypeSelection: void 0, orderSupplyType: void 0 }, { crud: l, query: t } = D(h), d = w(() => l.selections.map((s) => s.id));
  async function p(s) {
    await v(s), l.toQuery();
  }
  return (s, o) => {
    const u = y("common-radio-button"), m = I, c = N, T = y("print-table"), g = E("permission");
    return R(), U("div", k, [n(u, { modelValue: e(t).basicClass, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).basicClass = a), options: e(L).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(u, { modelValue: e(t).orderSupplyType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).orderSupplyType = a), options: e(Q).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(u, { modelValue: e(t).outboundTypeSelection, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).outboundTypeSelection = a), options: e(r).ENUM, unshowVal: [e(r).SCRAPS.V, e(r).OUTSOURCE.V, e(r).TEMPORARY_LOAN.V], class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), n(m, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).serialNumber = a), class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "200px" }, onKeyup: V(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(t).operatorName, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).operatorName = a), class: "filter-item", clearable: "", placeholder: "领用人/申请人/审核人", size: "default", style: { width: "200px" }, onKeyup: V(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o[9] || (o[9] = _("br", null, null, -1)), n(e(P), { projectId: e(t).projectId, "onUpdate:projectId": o[5] || (o[5] = (a) => e(t).projectId = a), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": o[6] || (o[6] = (a) => e(t).projectWarehouseType = a), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), n(c, { modelValue: e(t).createTime, "onUpdate:modelValue": o[7] || (o[7] = (a) => e(t).createTime = a), "default-time": i.value, shortcuts: e(b), class: "filter-item", "end-placeholder": "申请日期", "range-separator": ":", size: "default", "start-placeholder": "申请日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), n(c, { modelValue: e(t).outboundTime, "onUpdate:modelValue": o[8] || (o[8] = (a) => e(t).outboundTime = a), "default-time": i.value, shortcuts: e(b), class: "filter-item", "end-placeholder": "出库日期", "range-separator": ":", size: "default", "start-placeholder": "出库日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), n(e(x)), n(e(K), null, { optLeft: O(() => [j(n(T, { disabled: d.value.length === 0, params: d.value, "api-key": "wmsRmOutboundReceiptReport", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange, onDownloadSuccess: p, onPrintSuccess: p }, null, 8, ["disabled", "params", "onSuccess"]), [[g, e(C).get]])]), _: 1 })]);
  };
} };
export {
  q as default
};
