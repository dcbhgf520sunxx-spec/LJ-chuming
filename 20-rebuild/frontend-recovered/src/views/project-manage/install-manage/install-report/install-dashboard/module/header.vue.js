import { ref as y } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as q } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as P } from "vue";
import { vShow as U } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { withCtx as T } from "vue";
import { m as B, K as p, kM as g, F as c, B as Q, bN as N, q as k, E as H } from "../../../../../../shared/runtime.js";
import { u as X } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as D } from "../../../../../../modules/index-d6a37d29.js";
import { S as K } from "../../../../../../modules/index-21d3d7d7.js";
const Z = { class: "head-container" }, z = { __name: "header", props: { globalProject: { type: Object, default: () => {
} } }, emits: "load", setup(d, { expose: v, emit: I }) {
  const { installTypeEnumArr: C } = B("installTypeEnumArr"), i = d, h = { productType: i.globalProject.projectType === p.STEEL.V ? g.ARTIFACT.V : c.BOX.V, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, installStatus: void 0 }, { crud: a, query: t, CRUD: f } = Q(h), V = I, m = y(1), j = { key: "id", label: "name", value: "id" }, s = y([]), { colors: A, boxZoomOut: E, getColor: S } = X({ colorCardTitles: ["未安装", "部分安装", "全部安装"], emit: V, crud: a });
  f.HOOK.beforeRefresh = () => (a.query.projectId = i.globalProject.businessType === N.INSTALLATION.V ? i.globalProject.id : void 0, !!a.query.projectId), f.HOOK.handleRefresh = (u, o) => {
    o.data.content = o.data.content.map((n) => (n.boxColor = S(n, { quantity: "installQuantity", compare: "quantity" }), n));
  };
  function O(u) {
    s.value = u || [], s.value.length > 0 && (a.query.areaId = s.value[0].id);
  }
  function L(u) {
    t.areaId = void 0, a.toQuery();
  }
  return v({ boxScale: m }), (u, o) => {
    const n = b("common-radio-button"), R = b("common-select");
    return q(), x("div", Z, [P(w("div", null, [r(n, { modelValue: e(t).productType, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).productType = l), options: d.globalProject.projectType === e(p).STEEL.V ? e(C) : [e(c).BOX, e(c).AUXILIARY_MATERIAL], type: "enum", class: "filter-item", onChange: L }, null, 8, ["modelValue", "options"]), r(e(k), { ref: "monomerSelectRef", modelValue: e(t).monomerId, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).monomerId = l), "project-id": e(t).projectId, "main-product-type": d.globalProject.projectType === e(p).STEEL.V && e(t).productType !== e(g).AUXILIARY.V ? e(t).productType : "", clearable: "", class: "filter-item", onChange: e(a).toQuery, onGetAreaInfo: O }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"]), r(R, { modelValue: e(t).areaId, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).areaId = l), options: s.value, type: "other", dataStructure: j, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[U, e(a).searchToggle]]), r(e(H), { "show-grid": false, "show-refresh": false }, { optRight: T(() => [r(e(D), { class: "filter-item", value: e(t).installStatus, "onUpdate:value": o[3] || (o[3] = (l) => e(t).installStatus = l), colors: e(A), "color-border": "", "select-able": "", onChange: e(a).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: T(() => [r(e(K), { class: "filter-item", value: m.value, "onUpdate:value": o[4] || (o[4] = (l) => m.value = l), intervals: 400, onZoomOut: e(E) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  z as default
};
