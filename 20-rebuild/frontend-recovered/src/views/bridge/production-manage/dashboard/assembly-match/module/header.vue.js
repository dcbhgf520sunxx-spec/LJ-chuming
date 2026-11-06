import { ref as p } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as q } from "vue";
import { createElementBlock as K } from "vue";
import { withDirectives as S } from "vue";
import { vShow as D } from "vue";
import { unref as a } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as y } from "vue";
import { withKeys as E } from "vue";
import { createTextVNode as h } from "vue";
import { ElInput as M } from "element-plus";
import { ElCheckbox as H } from "element-plus";
import { a as R } from "../../../../../../modules/assembly-match-ac180441.js";
import { u as Z } from "../../../../../../modules/use-dashboard-header-f1034215.js";
import { B as z, bW as G, C as L, E as $ } from "../../../../../../shared/runtime.js";
import { u as P } from "../../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import { C as W } from "../../../../../../modules/index-d6a37d29.js";
import { S as F } from "../../../../../../modules/index-21d3d7d7.js";
import { _ as J } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
const X = { class: "head-container" }, Y = { style: { display: "flex" } }, ie = { __name: "header", props: { isIndeterminate: { type: Boolean, default: false } }, emits: ["load", "checkedAll", "batchMatch", "clear"], setup(b, { expose: C, emit: I }) {
  const d = p([]), g = { serialNumber: "", boxClassId: void 0, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, status: { value: void 0, resetAble: false } }, { crud: r, query: t, CRUD: v } = z(g), x = P(r), m = I, c = p(1), { colors: _, boxZoomOut: V, getColorByValue: k, getTagByValue: w } = Z({ colorCardTitles: ["不具备", "部分具备", "完全具备"], emit: m, crud: r }), f = p(false);
  function A(o) {
    m("checkedAll", o);
  }
  function Q() {
    m("batchMatch");
  }
  async function j() {
    if (d.value = [], !(!t.monomerId || !t.areaId)) try {
      const o = await R({ projectId: t.projectId, monomerId: t.monomerId, areaId: t.areaId });
      d.value = o || [], d.value.length === 1 && (t.boxClassId = d.value[0].id);
    } catch (o) {
      console.log("获取区域下的分段汇总信息", o);
    }
  }
  v.HOOK.handleRefresh = (o, e) => {
    m("clear"), f.value = false, e.data.content = e.data.content.map((n) => (n.checked = false, n.compareQuantity = o.query.factoryId ? n.assignQuantity : n.quantity, n.boxColor = k(n, { field: "type" }), n.tagType = w(n, { field: "type" }), n));
  };
  function B({ monomerId: o, areaId: e }) {
    t.monomerId = o, t.areaId = e, t.boxClassId = void 0, j(), r.toQuery();
  }
  function T(o) {
    t.boxClassId = o, r.toQuery();
  }
  return C({ boxScale: c }), (o, e) => {
    const n = M, N = U("common-button"), O = H;
    return q(), K("div", X, [S(u("div", null, [s(a(J), { "project-id": a(x), onChange: B }, null, 8, ["project-id"]), u("div", null, [s(a(G), { modelValue: a(t).boxClassId, "onUpdate:modelValue": e[0] || (e[0] = (l) => a(t).boxClassId = l), class: "filter-item", style: "width:calc(100% - 0px)", data: d.value, itemKey: "id", onChange: T }, { default: i(({ item: l }) => [u("span", null, y(l.name) + "：", 1), u("span", null, y(l.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data"])]), s(n, { modelValue: a(t).serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (l) => a(t).serialNumber = l), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: E(a(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(a(L))], 512), [[D, a(r).searchToggle]]), s(a($), { "show-grid": false, "show-refresh": false }, { optRight: i(() => [u("div", Y, [s(N, { type: "primary", size: "default", onClick: Q }, { default: i(() => e[5] || (e[5] = [h("批量匹配")])), _: 1, __: [5] }), s(O, { modelValue: f.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => f.value = l), indeterminate: b.isIndeterminate, border: "", style: { "margin-left": "5px", "margin-right": "10px" }, onChange: A }, { default: i(() => e[6] || (e[6] = [h("全选")])), _: 1, __: [6] }, 8, ["modelValue", "indeterminate"]), s(a(W), { class: "filter-item", value: a(t).status, "onUpdate:value": e[3] || (e[3] = (l) => a(t).status = l), colors: a(_), "color-border": "", onChange: a(r).toQuery }, null, 8, ["value", "colors", "onChange"])])]), viewLeft: i(() => [s(a(F), { class: "filter-item", value: c.value, "onUpdate:value": e[4] || (e[4] = (l) => c.value = l), intervals: 400, onZoomOut: a(V) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  ie as default
};
