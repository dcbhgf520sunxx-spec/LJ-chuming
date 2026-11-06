import { ref as V } from "vue";
import { computed as b } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { unref as e } from "vue";
import { createVNode as r } from "vue";
import { withKeys as s } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElInput as C } from "element-plus";
import { ElDatePicker as g } from "element-plus";
import { pB as N, B as T, vI as m, fv as w, I as E, C as I, E as k } from "../../../../../../shared/runtime.js";
const U = { class: "head-container" }, x = { key: 0 }, D = { __name: "header", setup(K) {
  const p = V([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { projectWarehouseType: N.PUBLIC.V, basicClass: void 0, projectId: void 0, operatorName: void 0, createTime: [], taskOrderNumber: void 0, receiptSerialNumber: void 0 }, { crud: o, query: t } = T(c);
  return b(() => o.selections.map((u) => u.id) || []), (u, l) => {
    const f = h("common-radio-button"), n = C, y = g;
    return d(), i("div", U, [e(o).searchToggle ? (d(), i("div", x, [r(f, { modelValue: e(t).basicClass, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).basicClass = a), options: e(m).ENUM, unshowVal: [e(m).STEEL_COIL.V], class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), r(w, { modelValue: e(t).projectId, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).projectId = a), class: "filter-item", clearable: "", isAll: "", filterable: "", placeholder: "可选择项目搜索", style: { width: "240px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), r(n, { modelValue: e(t).receiptSerialNumber, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).receiptSerialNumber = a), class: "filter-item", clearable: "", placeholder: "可输入形态转换单号搜索", size: "default", style: { width: "200px" }, onKeyup: s(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(n, { modelValue: e(t).operatorName, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).operatorName = a), class: "filter-item", clearable: "", placeholder: "可输入办理人搜索", size: "default", style: { width: "200px" }, onKeyup: s(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(y, { modelValue: e(t).createTime, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).createTime = a), "default-time": p.value, disabledDate: (a) => a.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: e(E), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"]), r(n, { modelValue: e(t).taskOrderNumber, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(t).taskOrderNumber = a), class: "filter-item", clearable: "", placeholder: "可输入工单号搜索", size: "default", style: { width: "200px" }, onKeyup: s(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(I))])) : _("", true), r(e(k))]);
  };
} };
export {
  D as default
};
