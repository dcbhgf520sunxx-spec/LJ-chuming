import { ref as _ } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as d } from "vue";
import { createElementVNode as j } from "vue";
import { withKeys as f } from "vue";
import { withCtx as y } from "vue";
import { withDirectives as N } from "vue";
import { createTextVNode as I } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as x } from "element-plus";
import { kD as k, B as P, cJ as Q, hg as V, pB as u, I as B, fv as h, C as D, L as S, BR as K, E as M } from "../../../../../../shared/runtime.js";
const O = { class: "head-container" }, R = { key: 0 }, q = { __name: "header", setup(W) {
  const C = { basicClass: void 0, deficitType: void 0, projectWarehouseType: void 0, createTime: [], projectId: void 0, serialNumber: void 0, applicantName: void 0, deficitProjectId: void 0, reviewStatus: { value: k.PASS.V, resetAble: false } }, T = _([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: l, query: o } = P(C);
  function g(p) {
    p === u.PUBLIC.V && (l.query.projectId = void 0), l.toQuery();
  }
  return (p, t) => {
    const r = v("common-radio-button"), b = U, m = x, w = E("permission");
    return s(), c("div", O, [e(l).searchToggle ? (s(), c("div", R, [n(r, { modelValue: e(o).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).basicClass = a), options: e(Q).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(r, { modelValue: e(o).deficitType, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).deficitType = a), options: e(V).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(r, { modelValue: e(o).projectWarehouseType, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).projectWarehouseType = a), options: e(u).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: g }, null, 8, ["modelValue", "options"]), n(b, { modelValue: e(o).createTime, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).createTime = a), "default-time": T.value, shortcuts: e(B), class: "filter-item", "end-placeholder": "盘亏日期", "range-separator": ":", size: "default", "start-placeholder": "盘亏日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), e(o).projectWarehouseType === e(u).PROJECT.V ? (s(), i(e(h), { key: 0, modelValue: e(o).projectId, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).projectId = a), class: "filter-item", clearable: "", isAll: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])) : d("", true), t[8] || (t[8] = j("br", null, null, -1)), e(o).deficitType === e(V).PROJECT.V ? (s(), i(e(h), { key: 1, modelValue: e(o).deficitProjectId, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).deficitProjectId = a), class: "filter-item", clearable: "", placeholder: "归属项目", style: { width: "220px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])) : d("", true), n(m, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).serialNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "盘亏单号", size: "default", style: { width: "200px" }, onKeyup: f(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(o).applicantName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).applicantName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "200px" }, onKeyup: f(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(D))])) : d("", true), n(e(M), null, { optLeft: y(() => [N((s(), i(S, { fn: e(K), params: e(o), "response-header-result": "" }, { default: y(() => t[9] || (t[9] = [I(" 下载盘亏明细（根据查询条件） ")])), _: 1, __: [9] }, 8, ["fn", "params"])), [[w, e(l).permission.download]])]), _: 1 })]);
  };
} };
export {
  q as default
};
