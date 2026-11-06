import { ref as E } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as A } from "vue";
import { vShow as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as r } from "vue";
import { withKeys as b } from "vue";
import { withCtx as h } from "vue";
import { ElInput as S } from "element-plus";
import { K as _, kM as K, F as P, B as Q, bN as U, tQ as q, C as B, E as R } from "../../../../../shared/runtime.js";
import { u as H } from "../../../../../modules/use-dashboard-header-292e247c.js";
import { C as L } from "../../../../../modules/index-d6a37d29.js";
import { S as k } from "../../../../../modules/index-21d3d7d7.js";
import { _ as D } from "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
const M = { class: "head-container" }, Y = { __name: "header", props: { globalProject: { type: Object, default: () => {
} } }, emits: ["load", "refresh"], setup(i, { expose: v, emit: T }) {
  const s = i, C = { productType: s.globalProject.projectType === _.STEEL.V ? K.ARTIFACT.V : P.BOX.V, projectId: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, installStatus: void 0, name: void 0, serialNumber: void 0 }, { crud: l, query: t, CRUD: m } = Q(C), p = T, u = E(1), { colors: g, boxZoomOut: V, getColor: j } = H({ colorCardTitles: ["未安装", "部分安装", "全部安装"], emit: p, crud: l });
  m.HOOK.beforeRefresh = () => (l.query.projectId = s.globalProject.businessType === U.INSTALLATION.V ? s.globalProject.id : void 0, !!l.query.projectId), m.HOOK.handleRefresh = (d, o) => {
    o.data.content = o.data.content.map((n) => (n.boxColor = j(n, { quantity: "installQuantity", compare: "quantity" }), n));
  };
  function I({ monomerId: d, areaId: o }) {
    t.monomerId = d, t.areaId = o, p("refresh");
  }
  return v({ boxScale: u }), (d, o) => {
    var f;
    const n = O("common-radio-button"), c = S;
    return w(), x("div", M, [A(y("div", null, [r(n, { modelValue: e(t).productType, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).productType = a), options: e(q).ENUM, type: "enum", default: "", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), y("div", null, [r(e(D), { "project-id": (f = i.globalProject) == null ? void 0 : f.id, class: "filter-item", mainProductType: e(t).productType, needConvert: "", style: { width: "100%" }, onChange: I }, null, 8, ["project-id", "mainProductType"])]), r(c, { modelValue: e(t).name, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).name = a), placeholder: "名称搜索", class: "filter-item", style: { width: "240px" }, size: "default", clearable: "", onKeyup: b(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(c, { modelValue: e(t).serialNumber, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).serialNumber = a), placeholder: "编号搜索", class: "filter-item", style: { width: "240px" }, size: "default", clearable: "", onKeyup: b(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(B))], 512), [[N, e(l).searchToggle]]), r(e(R), { "show-grid": false, "show-refresh": false }, { optRight: h(() => [r(e(L), { class: "filter-item", value: e(t).installStatus, "onUpdate:value": o[3] || (o[3] = (a) => e(t).installStatus = a), colors: e(g), "color-border": "", "select-able": "", onChange: e(l).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: h(() => [r(e(k), { class: "filter-item", value: u.value, "onUpdate:value": o[4] || (o[4] = (a) => u.value = a), intervals: 400, onZoomOut: e(V) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  Y as default
};
