import { ref as V } from "vue";
import { inject as w } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as h } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as u } from "vue";
import { withCtx as p } from "vue";
import { withKeys as s } from "vue";
import { createCommentVNode as Q } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as z } from "vue";
import { createTextVNode as K } from "vue";
import { ElCheckbox as P } from "element-plus";
import { ElTooltip as E } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElDatePicker as M } from "element-plus";
import { B as D, sC as j, sF as S, I as b, C as I, E as B } from "../../../../../shared/runtime.js";
import { u as O } from "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import R from "./configure-project-preparation-type/drawer.vue.js";
import "./configure-project-preparation-type/preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "../../../../../modules/use-table-change-32e98420.js";
const q = { class: "head-container" }, H = { key: 0 }, A = { class: "filter-item" }, F = { class: "filter-item" }, ae = { __name: "header", setup(G) {
  const m = V([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), g = { monomerName: void 0, areaName: void 0, listUpdateTime: [], preparationUpdateTime: [], hasListUpdate: false, boolPreparationLessThanList: false, preparationStatus: void 0, classification: void 0, projectId: { value: void 0, resetAble: false }, serialNumber: void 0, preparationUpdaterName: void 0, listUploaderName: void 0 }, C = w("permission"), i = V(false), { crud: n, query: o } = D(g);
  O(n);
  function N() {
    i.value = true;
  }
  return ($, t) => {
    const f = U("common-radio-button"), c = P, v = E, r = L, y = M, T = U("common-button"), _ = x("permission");
    return d(), h("div", q, [e(n).searchToggle ? (d(), h("div", H, [l(f, { modelValue: e(o).classification, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).classification = a), options: e(j).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(f, { modelValue: e(o).preparationStatus, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).preparationStatus = a), options: e(S).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), u("div", A, [l(v, { "show-after": 1e3, content: "有清单更新：未备料 或 清单更新时间“晚于”备料更新时间", placement: "right" }, { default: p(() => [l(c, { modelValue: e(o).hasListUpdate, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).hasListUpdate = a), label: "只显示有清单更新", size: "default", border: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 })]), u("div", F, [l(c, { modelValue: e(o).boolPreparationLessThanList, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).boolPreparationLessThanList = a), label: "只显示备料量小于清单量", size: "default", border: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), l(r, { modelValue: e(o).monomerName, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).monomerName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "单体", class: "filter-item", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(o).areaName, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).areaName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "区域", class: "filter-item", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t[12] || (t[12] = u("br", null, null, -1)), l(y, { modelValue: e(o).listUpdateTime, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).listUpdateTime = a), "default-time": m.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(b), "unlink-panels": "", "start-placeholder": "清单更新日期", "end-placeholder": "清单更新日期", style: { width: "240px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(y, { modelValue: e(o).preparationUpdateTime, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).preparationUpdateTime = a), "default-time": m.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(b), "unlink-panels": "", "start-placeholder": "备料更新日期", "end-placeholder": "备料更新日期", style: { width: "240px" }, class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(r, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).serialNumber = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "备料单号", class: "filter-item", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(o).listUploaderName, "onUpdate:modelValue": t[9] || (t[9] = (a) => e(o).listUploaderName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "清单上传人", class: "filter-item", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(o).preparationUpdaterName, "onUpdate:modelValue": t[10] || (t[10] = (a) => e(o).preparationUpdaterName = a), modelModifiers: { trim: true }, clearable: "", style: { width: "200px" }, size: "default", placeholder: "备料更新人", class: "filter-item", onKeyup: s(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(I))])) : Q("", true), l(e(B), null, { viewLeft: p(() => [k((d(), z(T, { size: "default", type: "success", onClick: N }, { default: p(() => t[13] || (t[13] = [K(" 配置项目备料类型 ")])), _: 1, __: [13] })), [[_, e(C).config]])]), _: 1 }), l(R, { visible: i.value, "onUpdate:visible": t[11] || (t[11] = (a) => i.value = a), onUpdate: e(n).refresh }, null, 8, ["visible", "onUpdate"])]);
  };
} };
export {
  ae as default
};
