import { ref as u } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { ElInput as b } from "element-plus";
import { ElDatePicker as w } from "element-plus";
import { w5 as r, B as N, I as h, C as y, E as S } from "../../../../../shared/runtime.js";
const v = { class: "head-container" }, T = { __name: "header", setup(k) {
  const d = u([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), i = { createTimeList: [], reviewStatus: void 0, applicationName: void 0, serialNumber: void 0, taskOrderNumber: void 0 }, m = u([r.AUDITING, r.PASS, r.REFUSE]), { crud: s, query: a } = N(i);
  return (C, t) => {
    const p = f("common-radio-button"), n = b, c = w;
    return V(), _("div", v, [o(p, { type: "enum", modelValue: e(a).reviewStatus, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).reviewStatus = l), options: m.value, "show-option-all": "", clearable: "", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(n, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).serialNumber = l), class: "filter-item", clearable: "", placeholder: "办理单号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), o(n, { modelValue: e(a).taskOrderNumber, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).taskOrderNumber = l), class: "filter-item", clearable: "", placeholder: "工单号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), o(n, { modelValue: e(a).applicationName, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).applicationName = l), class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), o(c, { modelValue: e(a).createTimeList, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).createTimeList = l), "default-time": d.value, shortcuts: e(h), class: "filter-item", "end-placeholder": "创建日期", "range-separator": ":", size: "default", "start-placeholder": "创建日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(e(y)), o(e(S))]);
  };
} };
export {
  T as default
};
