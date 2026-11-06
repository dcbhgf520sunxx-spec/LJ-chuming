import { ref as i } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createBlock as k } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as R } from "vue";
import { Fragment as $ } from "vue";
import { withDirectives as S } from "vue";
import { normalizeStyle as _ } from "vue";
import { renderList as P } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTag as V } from "element-plus";
import { ElTooltip as Q } from "element-plus";
import { Loading as T } from "@element-plus/icons-vue";
import { ElIcon as A } from "element-plus";
import { ElInfiniteScroll as H } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { c as M } from "../../../../../modules/project-overview-0b01c4c7.js";
import { c as O } from "../../../../../modules/enclosure-365a2177.js";
import { _ as z, x as F, o as U, kA as G } from "../../../../../shared/runtime.js";
import W from "./project-list/index.vue.js";
import J from "./module/header.vue.js";
import { u as K } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import "./project-list/module/header.vue.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "./module/monomer-select-area-select.vue.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/raf-ac2cc4f2.js";
const X = { class: "wrap" }, Y = { class: "wrap-left" }, Z = { class: "wrap-right" }, ee = { class: "app-container" }, te = ["infinite-scroll-disabled"], oe = { class: "ellipsis-text" }, se = { class: "ellipsis-text" }, ae = { class: "ellipsis-text" }, ne = { key: 0, class: "red-tip" }, re = { __name: "index", setup(ie) {
  const I = { add: false, edit: false, del: false, download: false }, f = i(), m = i(), j = i(), y = i({}), { crud: o, CRUD: w } = F({ title: "项目全貌", permission: { ...O }, optShow: { ...I }, crudApi: { ...M }, requiredQuery: ["projectId", "areaIds"], queryOnPresenterCreated: false }, j), { maxHeight: C } = U({ extraBox: ".overview-head-container", paginate: true }), { boxStyle: g, load: h, boardList: x } = K({ headRef: m, scrollBoxRef: f, crud: o, CRUD: w });
  function E(d = {}) {
    y.value = d, o.query.projectId = d.id;
  }
  return (d, r) => {
    var v, b;
    const q = V, B = Q, L = T, N = A, D = H;
    return s(), n("div", X, [a("div", Y, [l(e(W), { onProjectChange: E })]), a("div", Z, [a("div", ee, [(v = e(o).query) != null && v.projectId ? (s(), n($, { key: 1 }, [l(e(J), { ref_key: "headRef", ref: m, project: y.value, class: "head-container overview-head-container", onLoad: e(h) }, null, 8, ["project", "onLoad"]), e(o).firstLoaded ? S((s(), n("div", { key: 0, ref_key: "scrollBoxRef", ref: f, "infinite-scroll-delay": 200, "infinite-scroll-disabled": e(o).loading || !e(o).page.hasNextPage, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: _({ "max-height": `${e(C)}px` }), class: "board-container" }, [(s(true), n($, null, P((b = e(o).query.areaIds) != null && b.length ? e(x) : [], (t) => (s(), k(B, { key: t.id, content: `${t.detailLoading ? "正在加载中..." : `名称：${t.name}

                              编号：${t.serialNumber || "-"}
 ${t.category !== e(G).FOLDING_PIECE.V ? `
板型：${t.plate || "-"}
` : ""}
                              品牌：${t.brand || "-"}

                              颜色：${t.color || "-"}

                              清单量：${t.quantity}张

                              生产量：${t.producedQuantity}张

                              排产量：${t.schedulingQuantity}张`}`, "open-delay": 300, class: "item", effect: "light", placement: "left-start" }, { default: p(() => [a("div", { style: _({ "background-color": `${t.boxColor}`, ...e(g) }), class: "board-box" }, [a("span", oe, c(t.name), 1), a("span", se, c(t.serialNumber), 1), a("span", ae, c(t.producedQuantity) + "/" + c(t.quantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !e(x).length && !e(o).loading ? (s(), n("span", ne, "* 暂无数据")) : u("", true), e(o).loading ? (s(), n("div", { key: 1, style: _(e(g)), class: "loading-box" }, [r[1] || (r[1] = a("span", null, "加载中", -1)), l(N, null, { default: p(() => [l(L)]), _: 1 })], 4)) : u("", true)], 12, te)), [[D, e(h)]]) : u("", true)], 64)) : (s(), k(q, { key: 0, effect: "plain", size: "large", type: "info" }, { default: p(() => r[0] || (r[0] = [R(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [0] }))])])]);
  };
} }, $e = z(re, [["__scopeId", "data-v-4b6c50dc"]]);
export {
  $e as default
};
