import { ref as r } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { normalizeStyle as c } from "vue";
import { Fragment as N } from "vue";
import { renderList as R } from "vue";
import { createBlock as S } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as d } from "vue";
import { ElTooltip as w } from "element-plus";
import { Loading as L } from "@element-plus/icons-vue";
import { ElIcon as E } from "element-plus";
import { ElInfiniteScroll as M } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { g as W } from "../../../../../modules/common-85b8c78d.js";
import { _ as q, x as F, o5 as O, o as P, D as h } from "../../../../../shared/runtime.js";
import { u as Q } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import T from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const V = { class: "app-container" }, A = ["infinite-scroll-disabled"], G = { class: "ellipsis-text" }, H = { class: "ellipsis-text" }, K = { class: "ellipsis-text" }, U = { key: 0, class: "red-tip" }, z = { __name: "index", setup(j) {
  const y = { add: false, edit: false, del: false, download: false }, _ = r(), p = r(), b = r(), { crud: o, CRUD: k } = F({ title: "构件看板", permission: { ...O }, crudApi: { get: W }, optShow: { ...y }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, b), { maxHeight: $ } = P({ paginate: false }), { boxStyle: f, load: u, boardList: m } = Q({ headRef: p, scrollBoxRef: _, crud: o, CRUD: k });
  return (J, g) => {
    const v = w, C = L, D = E, B = M;
    return s(), a("div", V, [l(t(T), { ref_key: "headRef", ref: p, onLoad: t(u) }, null, 8, ["onLoad"]), t(o).firstLoaded ? I((s(), a("div", { key: 0, ref_key: "scrollBoxRef", ref: _, class: "board-container", "infinite-scroll-disabled": t(o).loading || !t(o).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: c({ "max-height": `${t($)}px` }) }, [(s(true), a(N, null, R(t(m), (e) => (s(), S(v, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          规格：${e.specification}

          长度：${e.length} mm

          材质：${e.material}

          单净重：${e.netWeight.toFixed(t(h).COM_WT__KG)} kg

          单毛重：${e.grossWeight.toFixed(t(h).COM_WT__KG)} kg

          图号：${e.drawingNumber}

          ${e.quantityInfo}
`, placement: "left-start" }, { default: x(() => [n("div", { class: "board-box", style: c({ "background-color": `${e.boxColor}`, ...t(f) }) }, [n("span", G, i(e.name), 1), n("span", H, i(e.serialNumber), 1), n("span", K, i(e.outboundQuantity) + "/" + i(e.compareQuantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !t(m).length && !t(o).loading ? (s(), a("span", U, "* 暂无数据")) : d("", true), t(o).loading ? (s(), a("div", { key: 1, class: "loading-box", style: c(t(f)) }, [g[0] || (g[0] = n("span", null, "加载中", -1)), l(D, null, { default: x(() => [l(C)]), _: 1 })], 4)) : d("", true)], 12, A)), [[B, t(u)]]) : d("", true)]);
  };
} }, pe = q(z, [["__scopeId", "data-v-e105ce1d"]]);
export {
  pe as default
};
