import { ref as l } from "vue";
import { watch as C } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as q } from "vue";
import { normalizeStyle as m } from "vue";
import { Fragment as N } from "vue";
import { renderList as T } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTooltip as M } from "element-plus";
import { Loading as U } from "@element-plus/icons-vue";
import { ElIcon as G } from "element-plus";
import { ElInfiniteScroll as H } from "element-plus";
import "../../../../modules/el-infinite-scroll-4ed993c7.js";
import { i as z, _ as A } from "./module/detail.vue.js";
import { _ as F, m as K, x as W, o as J, K as D, G as O } from "../../../../shared/runtime.js";
import { q as j } from "../../../../modules/project-19a12d6b.js";
import { u as X } from "../../../../modules/use-dashboard-index-3294c6d4.js";
import Y from "./module/header.vue.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/index-21d3d7d7.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
const Z = { class: "app-container" }, ee = ["infinite-scroll-disabled"], te = ["onDblclick"], ae = { key: 0, class: "ellipsis-text" }, oe = { class: "ellipsis-text" }, se = { class: "ellipsis-text" }, le = { key: 0, class: "red-tip" }, ne = { __name: "index", setup(ie) {
  const { globalProjectId: b, globalProject: u } = K(["globalProjectId", "globalProject"]), E = { add: false, edit: false, del: false, download: false }, y = l({}), _ = l(false), g = l(), h = l(), I = l(), { crud: a, CRUD: P } = W({ title: "收货看板", permission: { ...j }, crudApi: { get: z }, optShow: { ...E }, requiredQuery: ["areaId"] }, I), { maxHeight: R } = J({ paginate: false }), { boxStyle: x, load: v, boardList: f } = X({ headRef: h, scrollBoxRef: g, crud: a, CRUD: P });
  C(() => b.value, (n) => {
    n && (a.query.projectId = b.value, a.toQuery());
  }, { immediate: true });
  function S(n) {
    O(j.detail) && (y.value = n, _.value = true);
  }
  function V() {
    f.value = [], a.toQuery();
  }
  return (n, i) => {
    const $ = M, B = U, L = G, w = H;
    return o(), s("div", Z, [r(e(Y), { ref_key: "headRef", ref: h, onLoad: e(v), onRefresh: V, globalProject: e(u) }, null, 8, ["onLoad", "globalProject"]), e(a).firstLoaded ? q((o(), s("div", { key: 0, ref_key: "scrollBoxRef", ref: g, class: "board-container", "infinite-scroll-disabled": e(a).loading || !e(a).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: m({ "max-height": `${e(R)}px` }) }, [(o(true), s(N, null, T(e(f), (t) => (o(), Q($, { key: t.id, "open-delay": 300, class: "item", effect: "light", content: `${e(u).projectType === e(D).STEEL.V ? t.name : ""}${t.serialNumber}

            安装数量：${t.installQuantity}

            清单数量：${t.quantity}

            `, placement: "left-start" }, { default: k(() => [c("div", { class: "board-box", style: m({ cursor: "pointer", "background-color": `${t.boxColor}`, ...e(x) }), onDblclick: (re) => S(t) }, [e(u).projectType === e(D).STEEL.V ? (o(), s("span", ae, d(t.name), 1)) : p("", true), c("span", oe, d(t.serialNumber), 1), c("span", se, d(t.installQuantity) + "/" + d(t.quantity), 1)], 44, te)]), _: 2 }, 1032, ["content"]))), 128)), !e(f).length && !e(a).loading ? (o(), s("span", le, "* 暂无数据")) : p("", true), e(a).loading ? (o(), s("div", { key: 1, class: "loading-box", style: m(e(x)) }, [i[1] || (i[1] = c("span", null, "加载中", -1)), r(L, null, { default: k(() => [r(B)]), _: 1 })], 4)) : p("", true)], 12, ee)), [[w, e(v)]]) : p("", true), r(e(A), { modelValue: _.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => _.value = t), "detail-data": y.value }, null, 8, ["modelValue", "detail-data"])]);
  };
} }, De = F(ne, [["__scopeId", "data-v-5e61541b"]]);
export {
  De as default
};
