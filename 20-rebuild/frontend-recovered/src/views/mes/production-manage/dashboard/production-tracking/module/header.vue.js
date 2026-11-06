import { inject as V } from "vue";
import { ref as p } from "vue";
import { watch as I } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as U } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as o } from "vue";
import { normalizeStyle as B } from "vue";
import { withKeys as v } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as Q } from "vue";
import { ElInput as j } from "element-plus";
import { ElTag as E } from "element-plus";
import { l as m, dM as y, B as K, m as M, q as R, C as N, L as P, E as O, ng as F } from "../../../../../../shared/runtime.js";
import { a as q } from "../../../../../../modules/index-8356a01a.js";
import { _ as $ } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import { c as D } from "../../../../../../modules/convert-product-type-fcb585d7.js";
function te(s) {
  return m({ module: "mes", url: "task/process/artifact/process/track", method: "get", params: s });
}
function ae(s) {
  return m({ module: "mes", url: "task/process/assemble/process/track", method: "get", params: s });
}
function le(s) {
  return m({ module: "mes", url: "task/process/type/list", method: "get", params: s });
}
function oe(s) {
  return m({ module: "mes", url: "process/find", method: "get", params: s });
}
function se(s) {
  return m({ module: "mes", url: "task/process/assemble/process/track/prodLineList", method: "get", params: s });
}
function G(s) {
  return m({ module: "mes", url: "task/process/assemble/process/track/newPrint", method: "get", responseType: "blob", params: s });
}
const H = { class: "head-container" }, J = { __name: "header", setup(s) {
  const T = V("artifactTypeList"), C = V("productionLineList"), w = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false }, classificationId: void 0, serialNumber: void 0, specification: void 0, material: void 0, processType: y.ARTIFACT.V, productionLineId: void 0, areaBatchId: void 0 }, n = p([]), d = p([]), h = p({}), { crud: r, query: a } = K(w), { globalProjectId: g } = M(["globalProjectId"]), k = p([y.ARTIFACT, y.ASSEMBLE]);
  I(() => g.value, (u) => {
    a.projectId = g.value;
  }, { immediate: true }), I([() => a.areaId, () => n.value], (u) => {
    var t;
    u && (n.value.length > 0 ? (d.value = (t = n.value.filter((i) => a.areaId === i.id)[0]) == null ? void 0 : t.planAreaBatchDTOS, h.value = { id: d.value ? d.value[0].id + "" : "", name: d.value ? d.value[0].name : "" }) : (h.value = {}, d.value = []));
  }, { immediate: true, deep: true });
  function L(u) {
    var t;
    n.value = u.filter((i) => i.itemizedType === F.STRUCTURE.V), a.areaId = (t = n.value[0]) == null ? void 0 : t.id;
  }
  return (u, t) => {
    const i = x("common-select"), b = j, A = E;
    return S(), _("div", H, [U(c("div", null, [o(e(R), { ref: "monomerSelectRef", modelValue: e(a).monomerId, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).monomerId = l), productType: e(D)(e(a).productType, void 0), "project-id": e(g), "show-tips": n.value.length <= 0, class: "filter-item", onChange: u.monomerChange, onGetAreaInfo: L }, null, 8, ["modelValue", "productType", "project-id", "show-tips", "onChange"]), o(i, { modelValue: e(a).areaId, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).areaId = l), options: n.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(q), { modelValue: e(a).areaBatchId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).areaBatchId = l), "area-info": d.value, "default-tab": h.value, style: B(n.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: e(r).toQuery }, null, 8, ["modelValue", "area-info", "default-tab", "style", "onTabClick"]), o(e($), { modelValue: e(a).factoryId, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).factoryId = l), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), o(i, { modelValue: e(a).classificationId, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).classificationId = l), options: e(T), type: "other", class: "filter-item", clearable: true, dataStructure: { key: "structureClassId", label: "name", value: "structureClassId" }, placeholder: e(a).processType === e(y).ARTIFACT.V ? "选择构件类型" : "选择部件类型", style: { width: "170px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "placeholder", "onChange"]), o(b, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).serialNumber = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: v(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(b, { modelValue: e(a).specification, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).specification = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: v(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(b, { modelValue: e(a).material, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).material = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: v(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(N)), o(P, { style: { float: "right" }, params: e(a), size: "default", fn: e(G), class: "filter-item", disabled: !e(r).data.length }, { default: f(() => t[10] || (t[10] = [Q(" 下载 ")])), _: 1, __: [10] }, 8, ["params", "fn", "disabled"])], 512), [[z, e(r).searchToggle]]), o(e(O), null, { optRight: f(() => [o(i, { modelValue: e(a).processType, "onUpdate:modelValue": t[8] || (t[8] = (l) => e(a).processType = l), options: k.value, type: "enum", size: "default", placeholder: "请选择工序类型", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(i, { modelValue: e(a).productionLineId, "onUpdate:modelValue": t[9] || (t[9] = (l) => e(a).productionLineId = l), options: e(C), type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "选择生产线", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), viewLeft: f(() => [o(A, { hit: "", effect: "plain", class: "filter-item", type: "info", size: "default" }, { default: f(() => t[11] || (t[11] = [c("span", { style: { color: "#303133" } }, "制造上报数量", -1), c("span", null, " / ", -1), c("span", { style: { color: "#1682e6" } }, "质检数量", -1)])), _: 1, __: [11] })]), _: 1 })]);
  };
} }, re = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  J as _,
  oe as a,
  ae as b,
  le as c,
  se as d,
  te as g,
  re as h
};
