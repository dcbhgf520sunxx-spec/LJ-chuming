import { ref as v } from "vue";
import { computed as T } from "vue";
import { inject as U } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as m } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withKeys as i } from "vue";
import { createCommentVNode as N } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as D } from "vue";
import { createTextVNode as Q } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElInput as K } from "element-plus";
import { e as M } from "../../../../../../../modules/manuf-inbound-dfa0968a.js";
import { Au as c, cP as z, B as A, fv as I, I as f, C as P, L as R, E as j } from "../../../../../../../shared/runtime.js";
import { r as B } from "../../../../../../../modules/reset-query-5216307c.js";
const O = { class: "head-container" }, S = { key: 0 }, X = { __name: "header", setup($) {
  const u = v([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), V = { applicationTime: [], reviewPassTime: [], basicClass: c.STRUC_MANUFACTURED.V, serialNumber: void 0, projectId: void 0, personName: void 0, specification: void 0 }, y = T(() => [z.AUX_MANUFACTURED.V]), C = U("permission"), { crud: o, query: a } = A(V);
  async function h(_) {
    await B(a), o.toQuery(), o.data = [], o.setColumns();
  }
  return (_, t) => {
    const w = x("common-radio-button"), d = k, n = K, g = b("permission");
    return r(), m("div", O, [e(o).searchToggle ? (r(), m("div", S, [s(w, { modelValue: e(a).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).basicClass = l), options: e(c).ENUM, unshowVal: y.value, class: "filter-item", size: "default", type: "enum", onChange: h }, null, 8, ["modelValue", "options", "unshowVal"]), s(I, { modelValue: e(a).projectId, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).projectId = l), class: "filter-item", style: { width: "220px" }, clearable: "", isAll: "", placeholder: "所属项目", size: "default", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(d, { modelValue: e(a).applicationTime, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).applicationTime = l), "default-time": u.value, shortcuts: e(f), class: "filter-item", "end-placeholder": "申请时间", "range-separator": ":", size: "default", "start-placeholder": "申请时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(d, { modelValue: e(a).reviewPassTime, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).reviewPassTime = l), "default-time": u.value, shortcuts: e(f), class: "filter-item", "end-placeholder": "审核时间", "range-separator": ":", size: "default", "start-placeholder": "审核时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(n, { modelValue: e(a).specification, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).specification = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "150px" }, onKeyup: i(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).serialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "入库单号", size: "default", style: { width: "160px" }, onKeyup: i(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(a).personName, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).personName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/领用人", size: "default", style: { width: "150px" }, onKeyup: i(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(P))])) : N("", true), s(e(j), null, { optLeft: p(() => [E((r(), D(R, { fn: e(M), params: e(a), "response-header-result": "" }, { default: p(() => t[7] || (t[7] = [Q(" 下载入库明细（根据查询条件） ")])), _: 1, __: [7] }, 8, ["fn", "params"])), [[g, e(C).get]])]), _: 1 })]);
  };
} };
export {
  X as default
};
