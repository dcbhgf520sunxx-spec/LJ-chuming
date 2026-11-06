import { ref as m } from "vue";
import { computed as U } from "vue";
import { watch as k } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as v } from "vue";
import { vShow as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as r } from "vue";
import { normalizeStyle as R } from "vue";
import { withCtx as h } from "vue";
import { createBlock as z } from "vue";
import { createTextVNode as O } from "vue";
import { ElInput as P } from "element-plus";
import { l as c, tw as q, B as L, kC as D, T as Q, q as H, C as M, L as $, E as G } from "../../../../../shared/runtime.js";
import { a as K } from "../../../../../modules/index-8356a01a.js";
function F(o) {
  return c({ module: "plan", url: "assemble/listAssemble", method: "get", params: o });
}
function J(o) {
  return c({ module: "plan", url: "assemble/updateAssemble", method: "put", data: o });
}
function W(o) {
  return c({ module: "plan", url: "assemble/deleteAssembleList", method: "delete", data: o });
}
function X(o) {
  return c({ module: "plan", url: "assemble/export", responseType: "blob", method: "get", params: o });
}
const te = { edit: J, del: W, get: F }, Y = { style: { display: "flex" } }, Z = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(o) {
  const V = { name: "", serialNumber: "", specification: "", material: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, permissionCheck: q.CHECK_PERMISSION.V, areaBatchId: void 0 }, g = m(), I = m({}), s = m([]), f = m({}), T = m(false), n = m([]), { crud: u, query: l } = L(V), w = o, S = U(() => ({ ...u.query }));
  k([() => l.areaId, () => s.value], (d) => {
    var a;
    d && (s.value.length > 0 ? (n.value = (a = s.value.filter((i) => i.id + "" == l.areaId + "")[0]) == null ? void 0 : a.planAreaBatchDTOS, f.value = { id: n.value ? n.value[0].id + "" : "", name: n.value ? n.value[0].name : "" }) : (f.value = {}, n.value = []));
  }, { immediate: true, deep: true });
  function x(d) {
    const { name: a, label: i } = d;
    I.value = { id: a, name: i }, C();
  }
  function _(d) {
    var a;
    s.value = d.filter((i) => i.itemizedType === 1) || [], l.areaId = (a = s.value[0]) == null ? void 0 : a.id;
  }
  function C() {
    u.toQuery();
  }
  return (d, a) => {
    const i = B("common-select"), p = P, A = E("permission");
    return b(), j("div", null, [v(y("div", null, [r(e(H), { ref_key: "monomerSelectRef", ref: g, modelValue: e(l).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).monomerId = t), "main-product-type": e(D).STRUCTURE.V, productType: e(Q).STRUCTURE.V, "project-id": w.projectId, "show-tips": s.value.length <= 0, class: "filter-item", onGetAreaInfo: _ }, null, 8, ["modelValue", "main-product-type", "productType", "project-id", "show-tips"]), r(i, { modelValue: e(l).areaId, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(l).areaId = t), options: s.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: e(u).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(e(K), { modelValue: e(l).areaBatchId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(l).areaBatchId = t), "area-info": n.value, "default-tab": f.value, style: R(s.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: x }, null, 8, ["modelValue", "area-info", "default-tab", "style"]), y("div", Y, [r(p, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(l).serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(p, { modelValue: e(l).specification, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(l).specification = t), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(p, { modelValue: e(l).specification, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(l).specification = t), class: "filter-item", clearable: "", placeholder: "输入规格搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), r(p, { modelValue: e(l).material, "onUpdate:modelValue": a[6] || (a[6] = (t) => e(l).material = t), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(e(M))])], 512), [[N, e(u).searchToggle]]), r(e(G), null, { optLeft: h(() => [v((b(), z($, { disabled: e(u).data.length === 0 || T.value, fn: e(X), params: S.value, class: "filter-item" }, { default: h(() => a[7] || (a[7] = [O(" 下载部件清单 ")])), _: 1, __: [7] }, 8, ["disabled", "fn", "params"])), [[A, e(u).permission.download]])]), _: 1 })]);
  };
} }, oe = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  te as c,
  oe as h
};
