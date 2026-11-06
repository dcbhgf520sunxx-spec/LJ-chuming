import { inject as C } from "vue";
import { ref as m } from "vue";
import { watchEffect as K } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as B } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as T } from "vue";
import { vShow as j } from "vue";
import { unref as e } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as o } from "vue";
import { normalizeStyle as z } from "vue";
import { withKeys as p } from "vue";
import { withCtx as y } from "vue";
import { ElInput as k } from "element-plus";
import { C as N } from "../../../../../../../../modules/index-d6a37d29.js";
import { S as O } from "../../../../../../../../modules/index-21d3d7d7.js";
import { B as E, q, C as D, E as Z } from "../../../../../../../../shared/runtime.js";
import { u as H } from "../../../../../../../../modules/use-dashboard-header-292e247c.js";
import { a as $ } from "../../../../../../../../modules/index-8356a01a.js";
const G = { class: "head-container" }, X = { __name: "card-header", emits: "load", setup(L, { expose: b, emit: h }) {
  const f = C("projectId"), V = { name: "", serialNumber: "", specification: "", material: "", projectId: f.value, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, status: { value: void 0, resetAble: false } }, { crud: r, query: l } = E(V), s = m([]), n = m([]), c = m({}), w = h;
  K(() => {
    l.projectId = f.value;
  });
  const v = m(1), { colors: I, boxZoomOut: g } = H({ colorCardTitles: ["未生产", "生产中", "已完成"], emit: w, crud: r });
  function x(i, a) {
    var u;
    s.value = i.filter((d) => d.itemizedType === 1) || [], l.areaId = (u = s.value[0]) == null ? void 0 : u.id;
  }
  return Q([() => l.areaId, () => s.value], (i) => {
    var a;
    i && (s.value.length > 0 ? (n.value = (a = s.value.filter((u) => l.areaId === u.id)[0]) == null ? void 0 : a.planAreaBatchDTOS, c.value = { id: n.value ? n.value[0].id + "" : "", name: n.value ? n.value[0].name : "" }) : (c.value = {}, n.value = []));
  }, { immediate: true, deep: true }), b({ boxScale: v }), (i, a) => {
    const u = U("common-select"), d = k;
    return B(), S("div", G, [T(A("div", null, [o(e(q), { modelValue: e(l).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(l).monomerId = t), "project-id": e(f), "show-tips": s.value.length <= 0, onChange: a[1] || (a[1] = (t) => e(r).toQuery()), onGetAreaInfo: x }, null, 8, ["modelValue", "project-id", "show-tips"]), o(u, { modelValue: e(l).areaId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(l).areaId = t), dataStructure: { key: "id", label: "name", value: "id" }, options: s.value, class: "filter-item", placeholder: "请选择区域", style: { width: "200px", "margin-left": "3px" }, type: "other", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e($), { modelValue: e(l).areaBatchId, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(l).areaBatchId = t), "area-info": n.value, "default-tab": c.value, style: z(s.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: e(r).toQuery }, null, 8, ["modelValue", "area-info", "default-tab", "style", "onTabClick"]), o(d, { modelValue: e(l).name, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(l).name = t), size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: p(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(d, { modelValue: e(l).serialNumber, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(l).serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: p(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(d, { modelValue: e(l).specification, "onUpdate:modelValue": a[6] || (a[6] = (t) => e(l).specification = t), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: p(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(d, { modelValue: e(l).material, "onUpdate:modelValue": a[7] || (a[7] = (t) => e(l).material = t), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: p(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(D))], 512), [[j, e(r).searchToggle]]), o(e(Z), { "show-grid": false, "show-refresh": false }, { optRight: y(() => [o(e(N), { class: "filter-item", value: e(l).status, "onUpdate:value": a[8] || (a[8] = (t) => e(l).status = t), colors: e(I), "color-border": "", "select-able": "", onChange: e(r).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: y(() => [o(e(O), { class: "filter-item", value: v.value, "onUpdate:value": a[9] || (a[9] = (t) => v.value = t), intervals: 400, onZoomOut: e(g) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  X as default
};
