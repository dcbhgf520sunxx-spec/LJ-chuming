import { ref as y } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withKeys as u } from "vue";
import { createElementVNode as _ } from "vue";
import { renderSlot as h } from "vue";
import { ElDatePicker as w } from "element-plus";
import { ElInput as T } from "element-plus";
import { tS as s, B as b, I as C, C as K } from "../../../../../shared/runtime.js";
const U = { class: "head-container" }, E = { __name: "header", setup(g) {
  const d = { createTime: [], productType: void 0, serialNumber: void 0, projectName: void 0, applicantName: void 0, reviewerName: void 0 }, m = y([s.MACHINE_PART.V, s.AUXILIARY_MATERIAL.V]), { crud: n, query: l } = b(d);
  return (p, o) => {
    const i = w, c = V("common-radio-button"), r = T;
    return f(), N("div", U, [t(i, { modelValue: e(l).createTime, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).createTime = a), type: "daterange", "range-separator": "-", "value-format": "x", shortcuts: e(C), "start-placeholder": "创建日期", "end-placeholder": "创建日期", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "shortcuts", "onChange"]), t(c, { modelValue: e(l).productType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).productType = a), options: e(s).ENUM, type: "enum", unshowVal: m.value, showOptionAll: "", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), t(r, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).serialNumber = a), size: "default", placeholder: "外购退货单号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(r, { modelValue: e(l).projectName, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).projectName = a), size: "default", placeholder: "项目搜索", style: { width: "220px" }, class: "filter-item", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(r, { modelValue: e(l).applicantName, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(l).applicantName = a), size: "default", placeholder: "退货人搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(r, { modelValue: e(l).reviewerName, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(l).reviewerName = a), size: "default", placeholder: "审核人搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: u(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(K)), _("div", null, [h(p.$slots, "createBtn")])]);
  };
} };
export {
  E as default
};
