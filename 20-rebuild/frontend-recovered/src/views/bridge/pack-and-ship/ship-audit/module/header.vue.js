import { resolveComponent as u } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as i } from "vue";
import { vShow as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as a } from "vue";
import { withKeys as r } from "vue";
import { withCtx as g } from "vue";
import { ElInput as v } from "element-plus";
import { B as w, bQ as U, bw as C, C as K, E as Q } from "../../../../../shared/runtime.js";
const z = { class: "head-container" }, j = { __name: "header", setup(x) {
  const p = { serialNumber: void 0, licensePlate: void 0, userName: void 0, actualUserName: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false } }, { crud: n, query: t } = w(p);
  return (E, l) => {
    const m = u("project-radio-button"), c = u("common-radio-button"), f = u("component-radio-button"), s = v, y = u("print-table"), V = b("permission");
    return _(), h("div", z, [i(d("div", null, [a(m, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).projectId = o), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(c, { modelValue: e(t).checkStatus, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).checkStatus = o), options: e(U).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(f, { modelValue: e(t).productType, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).productType = o), options: e(C).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), d("div", null, [a(s, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).serialNumber = o), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: r(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: e(t).licensePlate, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(t).licensePlate = o), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: r(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: e(t).userName, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).userName = o), placeholder: "可输入装车人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: r(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: e(t).actualUserName, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(t).actualUserName = o), placeholder: "可输入过磅人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: r(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(K))])], 512), [[N, e(n).searchToggle]]), a(e(Q), null, { optLeft: g(() => [i(a(y, { "api-key": "bridgeShipmentAudit", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[V, e(n).permission.print]])]), _: 1 })]);
  };
} };
export {
  j as default
};
