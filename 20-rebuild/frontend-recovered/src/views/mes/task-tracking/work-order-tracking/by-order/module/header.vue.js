import { ref as m } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createElementVNode as p } from "vue";
import { withCtx as w } from "vue";
import { withKeys as S } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as U } from "element-plus";
import { a3 as r, bo as u, B as x, ch as _, bb as v, ng as N, bZ as Q, C as A } from "../../../../../../shared/runtime.js";
const j = { class: "head-container" }, R = { __name: "header", setup(k) {
  const c = { dateTime: (/* @__PURE__ */ new Date()).getTime(), monomerId: void 0, areaId: void 0, productType: r.ARTIFACT.V, projectId: void 0, status: void 0, orderNumber: void 0, weightStatus: u.NET.V, areaBatchId: void 0 }, { crud: l, query: t } = x(c), y = m([r.ARTIFACT, r.MACHINE_PART]), f = m([u.NET, u.GROSS]);
  function T(s) {
    return s > /* @__PURE__ */ new Date();
  }
  return (s, o) => {
    const V = E, d = i("common-radio-button"), g = i("common-select"), C = U;
    return h(), b("div", j, [n(V, { modelValue: e(t).dateTime, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).dateTime = a), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px !important" }, format: "YYYY", "value-format": "x", placeholder: "选择年", "disabled-date": T, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(d, { modelValue: e(t).productType, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).productType = a), options: y.value, class: "filter-item", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(d, { modelValue: e(t).status, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).status = a), options: e(_).ENUM, showOptionAll: "", class: "filter-item", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(d, { type: "enum", modelValue: e(t).weightStatus, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).weightStatus = a), options: f.value, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(v, { modelValue: e(t).projectId, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).projectId = a), clearable: "", class: "filter-item", style: { width: "270px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), p("div", null, [n(e(Q), { monomerId: e(t).monomerId, "onUpdate:monomerId": o[6] || (o[6] = (a) => e(t).monomerId = a), areaId: e(t).areaId, "onUpdate:areaId": o[7] || (o[7] = (a) => e(t).areaId = a), needConvert: "", clearable: "", areaClearable: "", "project-id": e(t).projectId, productType: e(N).STRUCTURE.V, onChange: e(l).toQuery }, { right: w(({ planAreaBatch: a }) => [n(g, { modelValue: e(t).areaBatchId, "onUpdate:modelValue": o[5] || (o[5] = (I) => e(t).areaBatchId = I), options: a, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: e(t).areaId ? "暂无数据" : "未选择区域", class: "filter-item", placeholder: "请选择批次", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "noDataText", "onChange"])]), _: 1 }, 8, ["monomerId", "areaId", "project-id", "productType", "onChange"]), p("div", null, [n(C, { modelValue: e(t).orderNumber, "onUpdate:modelValue": o[8] || (o[8] = (a) => e(t).orderNumber = a), placeholder: "输入工单号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: S(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(A))])])]);
  };
} };
export {
  R as default
};
