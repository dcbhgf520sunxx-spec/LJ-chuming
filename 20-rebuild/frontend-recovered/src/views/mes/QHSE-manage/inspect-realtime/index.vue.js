import { ref as i } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as e } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { withDirectives as w } from "vue";
import { normalizeStyle as d } from "vue";
import { Fragment as O } from "vue";
import { renderList as M } from "vue";
import { toDisplayString as a } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as P } from "vue";
import { createCommentVNode as x } from "vue";
import { ElTooltip as A } from "element-plus";
import { ElTag as q } from "element-plus";
import { Loading as z } from "@element-plus/icons-vue";
import { ElIcon as F } from "element-plus";
import { ElInfiniteScroll as G } from "element-plus";
import "../../../../modules/el-infinite-scroll-4ed993c7.js";
import { c as K } from "../../../../modules/inspect-realtime-8a5aa6e5.js";
import W from "./module/header.vue.js";
import J from "./module/detail.vue.js";
import { _ as Q, x as X, mH as E, o as Y, p as Z, mI as m, G as ss, e2 as os } from "../../../../shared/runtime.js";
import { u as es } from "../../../../modules/use-dashboard-index-3294c6d4.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/inspect-statistics-fca9b551.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
import "../../../../modules/raf-ac2cc4f2.js";
const as = { class: "app-container" }, ts = { class: "head-container" }, ns = ["infinite-scroll-disabled"], rs = ["onClick"], ls = { class: "board-box-content" }, cs = { class: "board-box-info" }, is = { class: "board-box-text ellipsis-text" }, ds = { class: "board-box-text ellipsis-text" }, ps = { class: "board-box-text ellipsis-text" }, _s = { class: "board-box-text ellipsis-text" }, us = { class: "board-box-text ellipsis-text" }, bs = { class: "board-box-serialNumber" }, fs = { class: "board-box-date" }, xs = { key: 0, class: "red-tip" }, hs = { __name: "index", setup(vs) {
  const V = i(), { crud: t, CRUD: h } = X({ title: "质检实时信息", permission: { ...E }, invisibleColumns: [], crudApi: { ...K } }, V), v = i(), g = i(), p = i(false), y = i(), { boxStyle: _, load: B, boardList: k } = es({ headRef: v, scrollBoxRef: g, crud: t, CRUD: h, beforeRefreshHook: I }), { maxHeight: H } = Y({ paginate: false });
  h.HOOK.handleRefresh = (u, c) => {
  };
  async function I() {
  }
  function L(u) {
    if (!ss(E.detail)) {
      os("warning", "暂无权限");
      return;
    }
    y.value = u, p.value = true;
  }
  return (u, c) => {
    const T = A, S = q, U = z, $ = F, j = G;
    return n(), r("div", as, [e("div", ts, [l(o(W), { ref_key: "headRef", ref: v }, null, 512)]), o(t).firstLoaded ? w((n(), r("div", { key: 0, ref_key: "scrollBoxRef", ref: g, class: "board-container", "infinite-scroll-disabled": o(t).loading || !o(t).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: d([{ flex: "1" }, { "max-height": `${o(H)}px` }]) }, [(n(true), r(O, null, M(o(k), (s) => {
      var R, C, N, D;
      return n(), r("div", { key: s.id, class: "board-box", style: d({ cursor: "pointer", "background-color": `${s.boxColor}`, ...o(_) }), onClick: (b) => L(s) }, [e("div", ls, [e("div", cs, [e("span", is, "项目： " + a(((R = s == null ? void 0 : s.project) == null ? void 0 : R.shortName) || "-"), 1), e("span", ds, "车间： " + a(((C = s == null ? void 0 : s.workshop) == null ? void 0 : C.name) || "-"), 1), e("span", ps, "工序： " + a((s == null ? void 0 : s.processName) || "-"), 1), e("span", _s, "班组： " + a(((N = s == null ? void 0 : s.team) == null ? void 0 : N.name) || "-"), 1), l(T, { effect: "dark", content: ((D = s == null ? void 0 : s.inspectUserNames) == null ? void 0 : D.join()) || "-", placement: "top-start" }, { default: f(() => {
        var b;
        return [e("span", us, "质检： " + a(((b = s == null ? void 0 : s.inspectUserNames) == null ? void 0 : b.join()) || "-"), 1)];
      }), _: 2 }, 1032, ["content"])]), e("div", bs, [l(S, { class: "number-tag", effect: "plain", round: "" }, { default: f(() => [P(a((s == null ? void 0 : s.serialNumber) || "-") + " " + a(`（${(s == null ? void 0 : s.number) || "-"}）`), 1)]), _: 2 }, 1024), e("div", fs, a(s != null && s.createTime ? o(Z)(s == null ? void 0 : s.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)])]), e("div", { class: "board-box-state", style: d({ cursor: "pointer", "background-color": `${o(m).V[s == null ? void 0 : s.status].COLOR}`, ...o(_) }) }, a(o(m).VL[s == null ? void 0 : s.status] || "-"), 5)], 12, rs);
    }), 128)), !o(k).length && !o(t).loading ? (n(), r("span", xs, "* 暂无数据")) : x("", true), o(t).loading ? (n(), r("div", { key: 1, class: "loading-box", style: d(o(_)) }, [c[1] || (c[1] = e("span", null, "加载中", -1)), l($, null, { default: f(() => [l(U)]), _: 1 })], 4)) : x("", true)], 12, ns)), [[j, o(B)]]) : x("", true), l(o(J), { visible: p.value, "onUpdate:visible": c[0] || (c[0] = (s) => p.value = s), "detail-data": y.value }, null, 8, ["visible", "detail-data"])]);
  };
} }, Os = Q(hs, [["__scopeId", "data-v-71653c04"]]);
export {
  Os as default
};
