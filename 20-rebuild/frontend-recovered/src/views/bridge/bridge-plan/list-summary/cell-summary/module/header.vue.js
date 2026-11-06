import { ref as d } from "vue";
import { watch as x } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as z } from "vue";
import { createVNode as o } from "vue";
import { withCtx as m } from "vue";
import { createBlock as B } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as U } from "vue";
import { createCommentVNode as W } from "vue";
import { ElInput as A } from "element-plus";
import { ElTag as O } from "element-plus";
import { l as h, B as R, T as q, q as Q, C as G, D as L, E as M } from "../../../../../../shared/runtime.js";
function P(n) {
  return h({ url: "/api/bridge/tech-element/list-summary", method: "get", params: n });
}
function $(n) {
  return h({ url: "/api/bridge/tech-element/get-sum", method: "get", params: n });
}
const K = { get: P }, F = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(n) {
  const v = { serialNumber: "", specification: "", material: "", monomerId: void 0, areaId: void 0, status: void 0 }, V = d(), c = d([]), s = d({}), { crud: i, query: t } = R(v), b = n;
  x(() => t, (r) => {
    T();
  }, { deep: true, immediate: true });
  function I(r) {
    c.value = r || [];
  }
  async function T() {
    if (s.value = {}, !!t.projectId) try {
      const r = await $({ ...t });
      s.value = r || {};
    } catch (r) {
      console.log("获取异常分段", r);
    }
  }
  return (r, l) => {
    const w = g("common-select"), u = A, C = O, N = g("print-table"), S = j("permission");
    return y(), k("div", null, [_(z("div", null, [o(e(Q), { ref_key: "monomerSelectRef", ref: V, modelValue: e(t).monomerId, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).monomerId = a), "project-id": b.projectId, productType: e(q).BRIDGE.V, default: false, clearable: "", class: "filter-item", onChange: e(i).toQuery, onGetAreaInfo: I }, null, 8, ["modelValue", "project-id", "productType", "onChange"]), o(w, { modelValue: e(t).areaId, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).areaId = a), options: c.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(u, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).serialNumber = a), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(u, { modelValue: e(t).specification, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(t).specification = a), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(u, { modelValue: e(t).material, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(t).material = a), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(e(G))], 512), [[D, e(i).searchToggle]]), o(e(M), null, { optLeft: m(() => {
      var a;
      return [(a = s.value) != null && a.totalNetWeight ? (y(), B(C, { key: 0 }, { default: m(() => {
        var p, f;
        return [E(U(`总量:${(f = (p = s.value) == null ? void 0 : p.totalNetWeight) == null ? void 0 : f.toFixed(e(L).COM_WT__T)}t`), 1)];
      }), _: 1 })) : W("", true)];
    }), viewLeft: m(() => [_(o(N, { "api-key": "cellSummary", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[S, e(i).permission.print]])]), _: 1 })]);
  };
} }, X = Object.freeze(Object.defineProperty({ __proto__: null, default: F }, Symbol.toStringTag, { value: "Module" }));
export {
  F as _,
  K as c,
  X as h
};
