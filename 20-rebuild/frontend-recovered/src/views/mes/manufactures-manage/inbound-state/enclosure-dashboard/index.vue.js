import { ref as i } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as r } from "vue";
import { unref as o } from "vue";
import { withDirectives as L } from "vue";
import { normalizeStyle as c } from "vue";
import { Fragment as R } from "vue";
import { renderList as v } from "vue";
import { createBlock as D } from "vue";
import { withCtx as g } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as d } from "vue";
import { ElTooltip as N } from "element-plus";
import { Loading as B } from "@element-plus/icons-vue";
import { ElIcon as I } from "element-plus";
import { ElInfiniteScroll as w } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { b as F } from "../../../../../modules/common-85b8c78d.js";
import { _ as U, x as q, o4 as O, o as P, D as _ } from "../../../../../shared/runtime.js";
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
  const y = { add: false, edit: false, del: false, download: false }, p = i(), f = i(), b = i(), { crud: s, CRUD: E } = q({ title: "围护看板", permission: { ...O }, crudApi: { get: F }, optShow: { ...y }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, b), { maxHeight: k } = P({ paginate: false }), { boxStyle: u, load: m, boardList: h } = Q({ headRef: f, scrollBoxRef: p, crud: s, CRUD: E });
  return (K, x) => {
    const S = N, M = B, $ = I, C = w;
    return t(), n("div", H, [r(o(V), { ref_key: "headRef", ref: f, onLoad: o(m) }, null, 8, ["onLoad"]), o(s).firstLoaded ? L((t(), n("div", { key: 0, ref_key: "scrollBoxRef", ref: p, class: "board-container", "infinite-scroll-disabled": o(s).loading || !o(s).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: c({ "max-height": `${o(k)}px` }) }, [(t(true), n(R, null, v(o(h), (e) => (t(), D(S, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          板型：${e.plate}

          颜色：${e.color}

          厚度：${e.thickness && e.thickness.toFixed(o(_).MES_ENCLOSURE_T__MM)} mm

          长度：${e.length && e.length.toFixed(o(_).MES_ENCLOSURE_L__MM)} mm

          有效宽度：${e.width && e.width.toFixed(o(_).MES_ENCLOSURE_W__MM)} mm

          ${e.quantityInfo}
`, placement: "left-start" }, { default: g(() => [a("div", { class: "board-box", style: c({ "background-color": `${e.boxColor}`, ...o(u) }) }, [a("span", W, l(e.name), 1), a("span", z, l(e.serialNumber), 1), a("span", A, l(e.inboundQuantity) + "/" + l(e.compareQuantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !o(h).length && !o(s).loading ? (t(), n("span", j, "* 暂无数据")) : d("", true), o(s).loading ? (t(), n("div", { key: 1, class: "loading-box", style: c(o(u)) }, [x[0] || (x[0] = a("span", null, "加载中", -1)), r($, null, { default: g(() => [r(M)]), _: 1 })], 4)) : d("", true)], 12, T)), [[C, o(m)]]) : d("", true)]);
  };
} }, pe = U(G, [["__scopeId", "data-v-d7330895"]]);
export {
  pe as default
};
