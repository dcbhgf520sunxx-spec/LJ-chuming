import { ref as T } from "vue";
import { inject as x } from "vue";
import { computed as U } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withKeys as u } from "vue";
import { createCommentVNode as D } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as z } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElInput as M } from "element-plus";
import { l as V, Au as f, B as P, cP as j, fv as A, I as y, C as I, L as O, E as R } from "../../../../../../../shared/runtime.js";
import { r as S } from "../../../../../../../modules/reset-query-5216307c.js";
function G(n) {
  return V({ module: "wms", url: "outbound/manufactured/application/record/detail", method: "get", params: n });
}
function B(n) {
  return V({ module: "wms_v2", url: "report/raw-materials/outbound/details/manufactured/excel", method: "get", responseType: "blob", timeout: 6e7, params: n });
}
const $ = { class: "head-container" }, q = { key: 0 }, F = { __name: "header", setup(n) {
  const d = T([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), _ = { applicationTime: [], reviewPassTime: [], basicClass: f.STRUC_MANUFACTURED.V, serialNumber: void 0, projectId: void 0, personName: void 0, specification: void 0 }, h = x("permission"), { crud: o, query: t } = P(_), C = U(() => [j.AUX_MANUFACTURED.V]);
  async function g(w) {
    await S(t), o.toQuery(), o.data = [], o.setColumns();
  }
  return (w, a) => {
    const b = N("common-radio-button"), m = K, r = M, v = E("permission");
    return i(), p("div", $, [e(o).searchToggle ? (i(), p("div", q, [s(b, { modelValue: e(t).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).basicClass = l), options: e(f).ENUM, unshowVal: C.value, class: "filter-item", size: "default", type: "enum", onChange: g }, null, 8, ["modelValue", "options", "unshowVal"]), s(A, { modelValue: e(t).projectId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).projectId = l), class: "filter-item", style: { width: "220px" }, clearable: "", isAll: "", placeholder: "所属项目", size: "default", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(m, { modelValue: e(t).applicationTime, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).applicationTime = l), "default-time": d.value, shortcuts: e(y), class: "filter-item", "end-placeholder": "申请时间", "range-separator": ":", size: "default", "start-placeholder": "申请时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(m, { modelValue: e(t).reviewPassTime, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).reviewPassTime = l), "default-time": d.value, shortcuts: e(y), class: "filter-item", "end-placeholder": "审核时间", "range-separator": ":", size: "default", "start-placeholder": "审核时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(r, { modelValue: e(t).specification, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).specification = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "150px" }, onKeyup: u(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).serialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "160px" }, onKeyup: u(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(r, { modelValue: e(t).personName, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).personName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/领用人", size: "default", style: { width: "150px" }, onKeyup: u(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(I))])) : D("", true), s(e(R), null, { optLeft: c(() => [Q((i(), k(O, { fn: e(B), params: e(t), "response-header-result": "" }, { default: c(() => a[7] || (a[7] = [z(" 下载出库明细（根据查询条件） ")])), _: 1, __: [7] }, 8, ["fn", "params"])), [[v, e(h).get]])]), _: 1 })]);
  };
} }, J = Object.freeze(Object.defineProperty({ __proto__: null, default: F }, Symbol.toStringTag, { value: "Module" }));
export {
  F as _,
  G as g,
  J as h
};
