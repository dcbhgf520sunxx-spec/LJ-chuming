import { inject as I } from "vue";
import { watch as h } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as v } from "vue";
import { vShow as Q } from "vue";
import { unref as e } from "vue";
import { createElementVNode as l } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as m } from "vue";
import { normalizeStyle as V } from "vue";
import { createCommentVNode as q } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as y } from "vue";
import { renderSlot as T } from "vue";
import { Fragment as E } from "vue";
import { d as N } from "../../../../../modules/box-3fab54f9.js";
import { aU as S, B as D, bW as z, E as $ } from "../../../../../shared/runtime.js";
import { u as j } from "../../../../../modules/use-get-box-type-list-1288a5cc.js";
import { _ as A } from "../../../../../modules/index-2d037787.js";
const M = { __name: "header", setup(H, { expose: b }) {
  const g = { productionLineTypeEnum: S.TRADITION.V }, C = I("productType"), { crud: o, query: t } = D(g), { boxTypeList: r, refreshBoxType: x } = j({ getApi: N, initHook: _ }, true);
  h([() => o.query.areaIdList], () => {
    d();
  }, { deep: true, immediate: true });
  function L() {
    t.name = void 0, t.serialNumber = void 0, t.specification = void 0, t.material = void 0, o.toQuery();
  }
  function _() {
    var s;
    t.boxClassId = (s = r.value) != null && s.length ? r.value[0].boxClassId : void 0, o.toQuery();
  }
  function d() {
    t.boxClassId = void 0, x({ productionLineTypeEnum: t.productionLineTypeEnum, areaIdList: o.query.areaIdList });
  }
  return b({ refreshTypeList: d }), (s, a) => {
    const p = w("common-button");
    return c(), k(E, null, [v(l("div", null, [e(r).length ? (c(), B(e(z), { key: 0, modelValue: e(t).boxClassId, "onUpdate:modelValue": a[0] || (a[0] = (i) => e(t).boxClassId = i), class: "filter-item", style: V(["width:100%;", { display: "inline-block" }]), data: e(r), itemKey: "boxClassId", onChange: e(o).toQuery }, { default: n(({ item: i }) => [l("span", null, m(i.name) + "：", 1), l("span", null, m(i.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "onChange"])) : q("", true), u(e(A), { productType: e(C), toQuery: e(o).toQuery, query: e(t) }, null, 8, ["productType", "toQuery", "query"]), u(p, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: y(e(o).toQuery, ["stop"]) }, { default: n(() => a[1] || (a[1] = [f("搜索")])), _: 1, __: [1] }, 8, ["onClick"]), u(p, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: y(L, ["stop"]) }, { default: n(() => a[2] || (a[2] = [f(" 重置 ")])), _: 1, __: [2] })], 512), [[Q, e(o).searchToggle]]), u(e($), null, { optLeft: n(() => [T(s.$slots, "optLeft")]), viewLeft: n(() => [T(s.$slots, "viewLeft")]), _: 3 })], 64);
  };
} };
export {
  M as default
};
