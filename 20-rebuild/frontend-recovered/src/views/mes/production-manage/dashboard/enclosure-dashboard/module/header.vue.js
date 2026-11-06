import { ref as v } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as Q } from "vue";
import { vShow as I } from "vue";
import { unref as e } from "vue";
import { createElementVNode as K } from "vue";
import { createVNode as r } from "vue";
import { withKeys as n } from "vue";
import { withCtx as i } from "vue";
import { ElInput as U } from "element-plus";
import { a3 as _, B as O, m as T, C as A, E } from "../../../../../../shared/runtime.js";
import { u as N } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as S } from "../../../../../../modules/index-d6a37d29.js";
import { S as j } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as q } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as z } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const B = { class: "head-container" }, F = { __name: "header", emits: "load", setup(D, { expose: m, emit: p }) {
  const c = { name: "", serialNumber: "", plate: "", color: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false }, status: { value: void 0, resetAble: false }, productType: _.ENCLOSURE.V }, { crud: s, query: a, CRUD: f } = O(c), { globalProjectId: y } = T(["globalProjectId"]), b = p, u = v(1), { colors: h, boxZoomOut: V, getColor: C } = N({ colorCardTitles: ["未生产", "生产中", "已完成"], emit: b, crud: s });
  f.HOOK.handleRefresh = (d, o) => {
    o.data.content = o.data.content.map((l) => (l.detailLoading = false, l.hasDetail = false, l.compareQuantity = l.quantity, l.isProcess = l.inProductionQuantity > 0, l.boxColor = C(l, { quantity: "completeQuantity", compare: "compareQuantity" }), l));
  };
  function g({ monomerId: d, areaId: o }) {
    a.monomerId = d, a.areaId = o, s.toQuery();
  }
  return m({ boxScale: u }), (d, o) => {
    const l = U;
    return w(), x("div", B, [Q(K("div", null, [r(e(q), { productType: e(a).productType, needConvert: "", "project-id": e(y), onChange: g }, null, 8, ["productType", "project-id"]), r(e(z), { modelValue: e(a).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).factoryId = t), class: "filter-item", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), r(l, { modelValue: e(a).name, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).name = t), size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(l, { modelValue: e(a).serialNumber, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).serialNumber = t), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(l, { modelValue: e(a).plate, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(a).plate = t), size: "default", placeholder: "输入板型搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(l, { modelValue: e(a).color, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(a).color = t), size: "default", placeholder: "输入颜色搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: n(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(A))], 512), [[I, e(s).searchToggle]]), r(e(E), { "show-grid": false, "show-refresh": false }, { optRight: i(() => [r(e(S), { class: "filter-item", value: e(a).status, "onUpdate:value": o[5] || (o[5] = (t) => e(a).status = t), colors: e(h), "color-border": "", "select-able": "", onChange: e(s).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: i(() => [r(e(j), { class: "filter-item", value: u.value, "onUpdate:value": o[6] || (o[6] = (t) => u.value = t), intervals: 400, onZoomOut: e(V) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  F as default
};
