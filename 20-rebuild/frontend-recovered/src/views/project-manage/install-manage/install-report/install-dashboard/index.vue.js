import { ref as p } from "vue";
import { watch as R } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as a } from "vue";
import { unref as e } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as w } from "vue";
import { normalizeStyle as _ } from "vue";
import { Fragment as B } from "vue";
import { renderList as C } from "vue";
import { createBlock as V } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as $ } from "vue";
import { ElTooltip as q } from "element-plus";
import { Loading as Q } from "@element-plus/icons-vue";
import { ElIcon as A } from "element-plus";
import { ElTag as M } from "element-plus";
import { ElInfiniteScroll as z } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { i as H } from "../../../../../modules/install-report-list-d430e189.js";
import { _ as O, m as U, x as F, o as G, bN as K, K as v } from "../../../../../shared/runtime.js";
import { m as W } from "../../../../../modules/project-19a12d6b.js";
import { u as J } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import X from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
const Y = { class: "app-container" }, Z = { key: 0 }, ee = ["infinite-scroll-disabled"], te = { key: 0, class: "ellipsis-text" }, oe = { class: "ellipsis-text" }, se = { class: "ellipsis-text" }, ae = { key: 0, class: "red-tip" }, ne = { key: 1 }, le = { __name: "index", setup(ie) {
  const { globalProjectId: f, globalProject: n } = U(["globalProjectId", "globalProject"]), T = { add: false, edit: false, del: false, download: false }, m = p(), y = p(), j = p(), { crud: s, CRUD: E } = F({ title: "收货看板", permission: { ...W }, crudApi: { get: H }, optShow: { ...T }, requiredQuery: ["projectId", "productType"], queryOnPresenterCreated: false }, j), { maxHeight: I } = G({ paginate: false }), { boxStyle: g, load: b, boardList: x } = J({ headRef: y, scrollBoxRef: m, crud: s, CRUD: E });
  return R(() => f.value, (h) => {
    h && (s.query.projectId = f.value, s.toQuery());
  }, { immediate: true, deep: true }), (h, l) => {
    var k;
    const L = q, N = Q, S = A, D = M, P = z;
    return o(), a("div", Y, [((k = e(n)) == null ? void 0 : k.businessType) === e(K).INSTALLATION.V ? (o(), a("div", Z, [i(e(X), { ref_key: "headRef", ref: y, onLoad: e(b), globalProject: e(n) }, null, 8, ["onLoad", "globalProject"]), e(s).firstLoaded ? w((o(), a("div", { key: 0, ref_key: "scrollBoxRef", ref: m, class: "board-container", "infinite-scroll-disabled": e(s).loading || !e(s).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: _({ "max-height": `${e(I)}px` }) }, [(o(true), a(B, null, C(e(x), (t) => (o(), V(L, { key: t.id, "open-delay": 300, class: "item", effect: "light", content: `${e(n).projectType === e(v).STEEL.V ? t.name : ""}${t.serialNumber}

            安装数量：${t.installQuantity}

            清单数量：${t.quantity}
`, placement: "left-start" }, { default: u(() => [r("div", { class: "board-box", style: _({ "background-color": `${t.boxColor}`, ...e(g) }) }, [e(n).projectType === e(v).STEEL.V ? (o(), a("span", te, c(t.name), 1)) : d("", true), r("span", oe, c(t.serialNumber), 1), r("span", se, c(t.installQuantity) + "/" + c(t.quantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !e(x).length && !e(s).loading ? (o(), a("span", ae, "* 暂无数据")) : d("", true), e(s).loading ? (o(), a("div", { key: 1, class: "loading-box", style: _(e(g)) }, [l[0] || (l[0] = r("span", null, "加载中", -1)), i(S, null, { default: u(() => [i(N)]), _: 1 })], 4)) : d("", true)], 12, ee)), [[P, e(b)]]) : d("", true)])) : (o(), a("div", ne, [i(D, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: u(() => l[1] || (l[1] = [$(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [1] })]))]);
  };
} }, xe = O(le, [["__scopeId", "data-v-44f2ddb1"]]);
export {
  xe as default
};
