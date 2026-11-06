import { inject as k } from "vue";
import { ref as E } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as u } from "vue";
import { withCtx as y } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as v } from "vue";
import { ElDatePicker as N } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElCascader as R } from "element-plus";
import { w as S } from "../../../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { a3 as d, B as L, si as f, aV as M, fv as j, sn as A, C as D, L as H, E as W } from "../../../../../../../shared/runtime.js";
import { _ as Y } from "../../../../../../../modules/process-select-b35dffc0.js";
import { m as $ } from "../../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../../modules/use-process-af1f8c99.js";
import "../../../../../../../modules/artifact-f1b0ca44.js";
const Z = { __name: "header", props: { minQuery: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, setup(m) {
  const g = m, w = { taskTypeEnum: d.MACHINE_PART.V, workshopId: void 0, dateTimeList: [], processId: void 0, serialNumber: void 0, relationType: void 0, month: void 0, groupId: void 0 }, p = k("isInProductionType"), I = k("isTaskType"), b = E([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), V = E([]), { crud: l, query: o } = L(w);
  async function h() {
    var t;
    const i = await $({ productType: o.taskTypeEnum }, true);
    V.value = ((t = i == null ? void 0 : i.list.find((c) => c.id === g.currentRow.workShopId)) == null ? void 0 : t.children) || [];
  }
  h();
  function x() {
    o.processId = void 0, o.relationType = void 0, l.toQuery(), h();
  }
  return (i, t) => {
    const c = C("common-radio-button"), T = N, _ = P, U = R, Q = C("common-select");
    return n(), O("div", null, [u(e(W), null, { optLeft: y(() => [u(c, { modelValue: e(o).taskTypeEnum, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).taskTypeEnum = a), options: e(d).ENUM, type: "enum", unshowVal: [e(d).ENCLOSURE.V, e(d).AUXILIARY_MATERIAL.V], default: "", class: "filter-item", onChange: x }, null, 8, ["modelValue", "options", "unshowVal"]), m.minQuery.projectOrWorkShopEnum === e(f).PROJECT.V ? (n(), r(e(M), { key: 0, modelValue: e(o).workshopId, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).workshopId = a), placeholder: "生产车间", class: "filter-item", style: { width: "240px" }, clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])) : s("", true), m.minQuery.projectOrWorkShopEnum === e(f).WORKSHOP.V ? (n(), r(e(j), { key: 1, modelValue: e(o).projectId, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).projectId = a), class: "filter-item", style: { width: "240px" }, placeholder: "请选择项目", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])) : s("", true), e(p) || e(I) ? (n(), r(e(Y), { key: 2, modelValue: e(o).processId, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).processId = a), class: "filter-item", placeholder: "工序筛选", multiple: false, clearable: "", productType: e(o).taskTypeEnum, style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "productType", "onChange"])) : s("", true), e(p) ? s("", true) : (n(), r(T, { key: 3, modelValue: e(o).dateTimeList, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).dateTimeList = a), "default-time": b.value, class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "onChange"])), e(p) ? (n(), r(T, { key: 4, modelValue: e(o).month, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).month = a), type: "month", "value-format": "x", format: "YYYY-MM", clearable: false, placeholder: "选择月份", style: { width: "120px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])) : s("", true), u(_, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).serialNumber = a), class: "filter-item", clearable: "", placeholder: "编号", size: "small", style: { width: "240px" } }, null, 8, ["modelValue"]), m.minQuery.projectOrWorkShopEnum === e(f).WORKSHOP.V ? (n(), r(U, { key: 5, modelValue: e(o).groupId, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).groupId = a), options: V.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, filterable: "", clearable: "", class: "filter-item", style: { width: "200px" }, placeholder: "生产组", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : s("", true), e(o).taskTypeEnum === e(d).MACHINE_PART.V ? (n(), r(Q, { key: 6, modelValue: e(o).relationType, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).relationType = a), options: e(A).ENUM, type: "enum", size: "small", class: "filter-item", clearable: "", placeholder: "零件类型", style: { width: "240px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : s("", true), u(e(D))]), viewLeft: y(() => [u(e(H), { fn: e(S), params: e(l).query, "response-header-result": "" }, { default: y(() => t[9] || (t[9] = [v(" 详情下载 ")])), _: 1, __: [9] }, 8, ["fn", "params"])]), _: 1 })]);
  };
} };
export {
  Z as default
};
