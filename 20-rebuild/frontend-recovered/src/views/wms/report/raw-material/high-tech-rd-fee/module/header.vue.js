import { inject as k } from "vue";
import { ref as d } from "vue";
import { resolveComponent as i } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { unref as o } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as F } from "vue";
import { createCommentVNode as U } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as c } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as M } from "vue";
import { ElDatePicker as D } from "element-plus";
import { l as f, _ as z, B as E, cJ as Q, gF as S, ap as B, C as N, L as O, E as $ } from "../../../../../../shared/runtime.js";
import { _ as R } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import H from "../../../../../config-manage/wms/high-tech-rd-fee/index.vue.js";
function L(n) {
  return f({ module: "wms", url: "report/raw-materials/high-tech-rd-fee", method: "get", params: n });
}
function q(n) {
  return f({ module: "wms", url: "report/raw-materials/high-tech-rd-fee/excel", method: "get", responseType: "blob", timeout: 6e7, params: n });
}
const ee = { get: L };
const A = { class: "head-container" }, P = { key: 0 }, Y = { __name: "header", setup(n) {
  const _ = { outboundTime: { value: (/* @__PURE__ */ new Date()).getTime(), resetAble: false }, projectId: void 0, sourceWorkshopIds: void 0, projectWarehouseType: void 0, basicClass: void 0 }, h = k("permission"), y = d([new Date(2e3, 1, 1, 0, 0, 0)]), g = d(), v = d(), u = d(false), { CRUD: b, crud: r, query: t } = E(_);
  return b.HOOK.handleRefresh = async (C, { data: e }) => {
    g.value = e.rdFeeForMonth, v.value = e.rdFeeForYear;
  }, (C, e) => {
    const V = D, w = i("common-radio-button"), j = i("common-button"), T = i("common-drawer"), x = I("permission");
    return m(), p("div", A, [o(r).searchToggle ? (m(), p("div", P, [s(V, { modelValue: o(t).outboundTime, "onUpdate:modelValue": e[0] || (e[0] = (a) => o(t).outboundTime = a), clearable: false, "default-time": y.value, class: "filter-item", placeholder: "查询月份", "range-separator": ":", size: "default", style: { width: "135px" }, type: "month", "unlink-panels": "", "value-format": "x", onChange: o(r).toQuery }, null, 8, ["modelValue", "default-time", "onChange"]), s(w, { modelValue: o(t).basicClass, "onUpdate:modelValue": e[1] || (e[1] = (a) => o(t).basicClass = a), options: o(Q).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: o(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(S, { modelValue: o(t).sourceWorkshopIds, "onUpdate:modelValue": e[2] || (e[2] = (a) => o(t).sourceWorkshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: o(r).toQuery }, null, 8, ["modelValue", "onChange"]), s(B, { modelValue: o(t).classifyId, "onUpdate:modelValue": e[3] || (e[3] = (a) => o(t).classifyId = a), "basic-class": o(t).basicClass, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: o(r).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), e[8] || (e[8] = F("br", null, null, -1)), s(o(R), { projectId: o(t).projectId, "onUpdate:projectId": e[4] || (e[4] = (a) => o(t).projectId = a), projectWarehouseType: o(t).projectWarehouseType, "onUpdate:projectWarehouseType": e[5] || (e[5] = (a) => o(t).projectWarehouseType = a), class: "filter-item", onChange: o(r).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), s(o(N))])) : U("", true), s($, null, { optLeft: l(() => [s(j, { size: "default", type: "primary", onClick: e[6] || (e[6] = (a) => u.value = true) }, { default: l(() => e[9] || (e[9] = [c("查看/设置高新研发费占比 ")])), _: 1, __: [9] }), W((m(), M(O, { fn: o(q), params: o(t), "response-header-result": "" }, { default: l(() => e[10] || (e[10] = [c(" 下载高新研发费报表（根据查询条件） ")])), _: 1, __: [10] }, 8, ["fn", "params"])), [[x, o(h).get]])]), viewLeft: l(() => e[11] || (e[11] = [])), _: 1 }), s(T, { modelValue: u.value, "onUpdate:modelValue": e[7] || (e[7] = (a) => u.value = a), size: "90%", title: "高新研发费用占比列表" }, { content: l(() => [s(H, { class: "high-tech-rd-fee-conf-view", onSaveSuccess: o(r).refresh }, null, 8, ["onSaveSuccess"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, J = z(Y, [["__scopeId", "data-v-521a475c"]]), oe = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  J as M,
  ee as c,
  oe as h
};
