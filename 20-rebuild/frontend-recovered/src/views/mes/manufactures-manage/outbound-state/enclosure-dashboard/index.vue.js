import { ref as i } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as r } from "vue";
import { unref as o } from "vue";
import { withDirectives as L } from "vue";
import { normalizeStyle as c } from "vue";
import { Fragment as R } from "vue";
import { renderList as v } from "vue";
import { createBlock as D } from "vue";
import { withCtx as g } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as d } from "vue";
import { ElTooltip as N } from "element-plus";
import { Loading as B } from "@element-plus/icons-vue";
import { ElIcon as w } from "element-plus";
import { ElInfiniteScroll as I } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { b as F } from "../../../../../modules/common-85b8c78d.js";
import { _ as O, x as U, o6 as q, o as P, D as _ } from "../../../../../shared/runtime.js";
import { u as Q } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import V from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const H = { class: "app-container" }, T = ["infinite-scroll-disabled"], W = { class: "ellipsis-text" }, z = { class: "ellipsis-text" }, A = { class: "ellipsis-text" }, j = { key: 0, class: "red-tip" }, G = { __name: "index", setup(J) {
  const b = { add: false, edit: false, del: false, download: false }, p = i(), f = i(), y = i(), { crud: t, CRUD: E } = U({ title: "围护看板", permission: { ...q }, crudApi: { get: F }, optShow: { ...b }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, y), { maxHeight: k } = P({ paginate: false }), { boxStyle: u, load: m, boardList: h } = Q({ headRef: f, scrollBoxRef: p, crud: t, CRUD: E });
  return (K, x) => {
    const S = N, M = B, $ = w, C = I;
    return s(), a("div", H, [r(o(V), { ref_key: "headRef", ref: f, onLoad: o(m) }, null, 8, ["onLoad"]), o(t).firstLoaded ? L((s(), a("div", { key: 0, ref_key: "scrollBoxRef", ref: p, class: "board-container", "infinite-scroll-disabled": o(t).loading || !o(t).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: c({ "max-height": `${o(k)}px` }) }, [(s(true), a(R, null, v(o(h), (e) => (s(), D(S, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          板型：${e.plate}

          颜色：${e.color}

          厚度：${e.thickness && e.thickness.toFixed(o(_).MES_ENCLOSURE_T__MM)} mm

          长度：${e.length && e.length.toFixed(o(_).MES_ENCLOSURE_L__MM)} mm

          有效宽度：${e.width && e.width.toFixed(o(_).MES_ENCLOSURE_W__MM)} mm

          ${e.quantityInfo}
`, placement: "left-start" }, { default: g(() => [n("div", { class: "board-box", style: c({ "background-color": `${e.boxColor}`, ...o(u) }) }, [n("span", W, l(e.name), 1), n("span", z, l(e.serialNumber), 1), n("span", A, l(e.outboundQuantity) + "/" + l(e.compareQuantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !o(h).length && !o(t).loading ? (s(), a("span", j, "* 暂无数据")) : d("", true), o(t).loading ? (s(), a("div", { key: 1, class: "loading-box", style: c(o(u)) }, [x[0] || (x[0] = n("span", null, "加载中", -1)), r($, null, { default: g(() => [r(M)]), _: 1 })], 4)) : d("", true)], 12, T)), [[C, o(m)]]) : d("", true)]);
  };
} }, pe = O(G, [["__scopeId", "data-v-aabe894d"]]);
export {
  pe as default
};
