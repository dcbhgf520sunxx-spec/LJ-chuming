import { resolveComponent as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as f } from "vue";
import { vShow as V } from "vue";
import { unref as e } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as o } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as _ } from "element-plus";
import { iF as s, jJ as b, B as y, bb as T, C as U, E as v } from "../../../../../../shared/runtime.js";
const C = { __name: "header", setup(g) {
  const d = { projectId: void 0, settlementStatus: s.UNSETTLEMENT.V, supplierName: void 0, serialNumber: void 0, purchaseType: { value: b.MANUFACTURED.V, resetAble: false }, createTime: [], startDate: void 0, endDate: void 0 }, { crud: n, query: t } = y(d);
  return (h, l) => {
    const u = m("common-radio-button"), i = E, r = _;
    return p(), c("div", null, [f(N("div", null, [o(u, { modelValue: e(t).settlementStatus, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).settlementStatus = a), options: e(s).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(T), { modelValue: e(t).projectId, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).projectId = a), class: "filter-item" }, null, 8, ["modelValue"]), o(i, { modelValue: e(t).createTime, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).createTime = a), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" } }, null, 8, ["modelValue"]), o(r, { modelValue: e(t).supplierName, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).supplierName = a), modelModifiers: { trim: true }, placeholder: "供应商搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), o(r, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).serialNumber = a), modelModifiers: { trim: true }, placeholder: "订单号搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), o(e(U)), o(e(v))], 512), [[V, e(n).searchToggle]])]);
  };
} };
export {
  C as default
};
