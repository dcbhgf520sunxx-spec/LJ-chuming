import { inject as h } from "vue";
import { ref as s } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as T } from "vue";
import { vShow as U } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as n } from "vue";
import { createBlock as r } from "vue";
import { withCtx as j } from "vue";
import { toDisplayString as k } from "vue";
import { createCommentVNode as x } from "vue";
import { ElInput as z } from "element-plus";
import { nk as b, B as A, T as E, q as N, C as Q, bW as R } from "../../../../../shared/runtime.js";
import { a as B } from "./change-table.vue.js";
const G = { __name: "header", setup(D) {
  const u = h("specificationList"), g = { boolAmendStatus: { value: b.V, resetAble: false }, projectId: { value: void 0, resetAble: false }, name: void 0, serialNumber: void 0, newSpecification: void 0, oldSpecification: void 0, monomerId: void 0, areaId: void 0, specification: void 0 }, S = s(), m = s([]), c = s(false), { crud: t, query: o } = A(g);
  function I(p) {
    m.value = p.filter((l) => l.itemizedType === 1) || [];
  }
  return (p, l) => {
    var f;
    const v = V("project-radio-button"), C = V("common-select"), i = z;
    return d(), w("div", null, [T(y("div", null, [n(v, { size: "default", modelValue: e(o).projectId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).projectId = a), class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(N), { ref_key: "monomerSelectRef", ref: S, modelValue: e(o).monomerId, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).monomerId = a), "project-id": e(o).projectId, productType: e(E).STRUCTURE.V, default: false, clearable: "", class: "filter-item", onChange: e(t).toQuery, onGetAreaInfo: I }, null, 8, ["modelValue", "project-id", "productType", "onChange"]), n(C, { modelValue: e(o).areaId, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).areaId = a), options: m.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(i, { modelValue: e(o).name, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).name = a), size: "default", placeholder: "输入名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), n(i, { modelValue: e(o).serialNumber, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(o).serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), e(o).boolAmendStatus !== e(b).REVISED.V ? (d(), r(i, { key: 0, modelValue: e(o).oldSpecification, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(o).oldSpecification = a), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])) : (d(), r(i, { key: 1, modelValue: e(o).newSpecification, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(o).newSpecification = a), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])), n(e(Q))], 512), [[U, e(t).searchToggle]]), (f = e(u)) != null && f.length ? (d(), r(e(R), { key: 0, modelValue: e(o).specification, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(o).specification = a), class: "filter-item", style: "width:85%; float: left", data: e(u), itemKey: "id", onChange: e(t).toQuery }, { default: j(({ item: a }) => [y("span", null, k(a.name), 1)]), _: 1 }, 8, ["modelValue", "data", "onChange"])) : x("", true), n(e(B), { modelValue: c.value, "onUpdate:modelValue": l[8] || (l[8] = (a) => c.value = a), list: e(t).selections, onSuccess: e(t).toQuery }, null, 8, ["modelValue", "list", "onSuccess"])]);
  };
} };
export {
  G as default
};
