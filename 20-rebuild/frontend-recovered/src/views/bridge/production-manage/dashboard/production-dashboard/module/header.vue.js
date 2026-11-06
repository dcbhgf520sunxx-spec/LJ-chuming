import { ref as p } from "vue";
import { watch as E } from "vue";
import { nextTick as U } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as x } from "vue";
import { vShow as P } from "vue";
import { unref as e } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as s } from "vue";
import { createBlock as L } from "vue";
import { createCommentVNode as M } from "vue";
import { withCtx as h } from "vue";
import { m as _, c0 as C, F as u, B as j, C as B, E as N } from "../../../../../../shared/runtime.js";
import { u as q } from "../../../../../../modules/use-dashboard-header-f1034215.js";
import { C as O } from "../../../../../../modules/index-d6a37d29.js";
import { S as k } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as D } from "../../../../../../modules/index-2d037787.js";
import { _ as H } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { _ as $ } from "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
function Z({ resetQuery: c }) {
  const { globalProject: d } = _("globalProject"), i = p([]), l = p(false);
  E(() => {
    var o;
    return (o = d.value) == null ? void 0 : o.mode;
  }, () => {
    typeof c == "function" && c(), i.value = n(d.value.mode), l.value = true, U(() => {
      l.value = true;
    });
  }, { deep: true, immediate: true });
  function n(o) {
    switch (o) {
      case C.STRUCTURE.V:
        return [u.CELL.V, u.MACHINE_PART.V];
      case C.STRUCTURE_ASSEMBLE.V:
        return [u.MACHINE_PART.V];
      default:
        return [];
    }
  }
  return { unshowVal: i, showComponent: l };
}
const z = { class: "head-container" }, ne = { __name: "header", emits: "load", setup(c, { expose: d, emit: i }) {
  const l = { name: void 0, serialNumber: void 0, specification: void 0, material: void 0, status: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, factoryId: { value: void 0, resetAble: false } }, { crud: n, query: o, CRUD: g } = j(l), { unshowVal: F, showComponent: b } = Z({ resetQuery: function() {
    o.productType = void 0;
  } }), { globalProjectId: V } = _(["globalProjectId"]), w = i, m = p(1), { colors: T, boxZoomOut: v, getColor: A } = q({ colorCardTitles: ["未生产", "生产中", "已完成"], emit: w, crud: n });
  g.HOOK.handleRefresh = (f, t) => {
    t.data.content = t.data.content.map((a) => (a.detailLoading = false, a.hasDetail = false, a.compareQuantity = a.quantity, a.isProcess = a.inProductionQuantity > 0, a.boxColor = A(a, { quantity: "completeQuantity", compare: "compareQuantity" }), a));
  };
  function I({ monomerId: f, areaId: t }) {
    o.monomerId = f, o.areaId = t, n.toQuery();
  }
  return d({ boxScale: m }), (f, t) => {
    const a = Q("common-radio-button");
    return y(), R("div", z, [x(S("div", null, [s(e(H), { "project-id": e(V), onChange: I }, null, 8, ["project-id"]), e(b) ? (y(), L(a, { key: 0, modelValue: e(o).productType, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).productType = r), options: e(u).ENUM, size: "default", class: "filter-item", type: "enumSL", default: "", unshowVal: [e(u).AUXILIARY_MATERIAL.V], onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : M("", true), s(e($), { modelValue: e(o).factoryId, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).factoryId = r), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), s(e(D), { productType: e(o).productType, toQuery: e(n).toQuery, query: e(o) }, null, 8, ["productType", "toQuery", "query"]), s(e(B))], 512), [[P, e(n).searchToggle]]), s(e(N), { "show-grid": false, "show-refresh": false }, { optRight: h(() => [s(e(O), { class: "filter-item", value: e(o).status, "onUpdate:value": t[2] || (t[2] = (r) => e(o).status = r), colors: e(T), "color-border": "", "select-able": "", onChange: e(n).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: h(() => [s(e(k), { class: "filter-item", value: m.value, "onUpdate:value": t[3] || (t[3] = (r) => m.value = r), intervals: 400, onZoomOut: e(v) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  ne as default
};
