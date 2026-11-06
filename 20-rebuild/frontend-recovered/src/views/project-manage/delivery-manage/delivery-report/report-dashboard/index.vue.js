import { ref as p } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { unref as e } from "vue";
import { createVNode as r } from "vue";
import { withDirectives as P } from "vue";
import { normalizeStyle as _ } from "vue";
import { Fragment as R } from "vue";
import { renderList as B } from "vue";
import { createBlock as C } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as V } from "vue";
import { ElTooltip as $ } from "element-plus";
import { Loading as q } from "@element-plus/icons-vue";
import { ElIcon as w } from "element-plus";
import { ElTag as A } from "element-plus";
import { ElInfiniteScroll as M } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { b as Q } from "../../../../../modules/report-list-f9da4d70.js";
import { _ as z, m as H, x as O, o as U, bN as F, K as h } from "../../../../../shared/runtime.js";
import { b as G } from "../../../../../modules/project-19a12d6b.js";
import { u as K } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import W from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/area-ca564e60.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
const J = { class: "app-container" }, X = { key: 0 }, Y = ["infinite-scroll-disabled"], Z = { key: 0, class: "ellipsis-text" }, ee = { class: "ellipsis-text" }, te = { class: "ellipsis-text" }, oe = { key: 0, class: "red-tip" }, se = { key: 1 }, ae = { __name: "index", setup(ne) {
  const { globalProjectId: k, globalProject: n } = H(["globalProjectId", "globalProject"]), v = { add: false, edit: false, del: false, download: false }, f = p(), m = p(), j = p(), { crud: a, CRUD: T } = O({ title: "收货看板", permission: { ...G }, crudApi: { get: Q }, optShow: { ...v }, requiredQuery: ["projectId", "productType"], queryOnPresenterCreated: false }, j), { maxHeight: E } = U({ paginate: false }), { boxStyle: y, load: g, boardList: b } = K({ headRef: m, scrollBoxRef: f, crud: a, CRUD: T });
  return (le, l) => {
    var x;
    const I = $, L = q, N = w, S = A, D = M;
    return o(), s("div", J, [((x = e(n)) == null ? void 0 : x.businessType) === e(F).INSTALLATION.V ? (o(), s("div", X, [r(e(W), { ref_key: "headRef", ref: m, onLoad: e(g), globalProject: e(n), projectId: e(k) }, null, 8, ["onLoad", "globalProject", "projectId"]), e(a).firstLoaded ? P((o(), s("div", { key: 0, ref_key: "scrollBoxRef", ref: f, class: "board-container", "infinite-scroll-disabled": e(a).loading || !e(a).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: _({ "max-height": `${e(E)}px` }) }, [(o(true), s(R, null, B(e(b), (t) => (o(), C(I, { key: t.id, "open-delay": 300, class: "item", effect: "light", content: `${e(n).projectType === e(h).STEEL.V ? t.name : ""}${t.serialNumber}

            收货数量：${t.receivingQuantity}

            清单数量：${t.quantity}
`, placement: "left-start" }, { default: u(() => [i("div", { class: "board-box", style: _({ "background-color": `${t.boxColor}`, ...e(y) }) }, [e(n).projectType === e(h).STEEL.V ? (o(), s("span", Z, c(t.name), 1)) : d("", true), i("span", ee, c(t.serialNumber), 1), i("span", te, c(t.receivingQuantity) + "/" + c(t.quantity), 1)], 4)]), _: 2 }, 1032, ["content"]))), 128)), !e(b).length && !e(a).loading ? (o(), s("span", oe, "* 暂无数据")) : d("", true), e(a).loading ? (o(), s("div", { key: 1, class: "loading-box", style: _(e(y)) }, [l[0] || (l[0] = i("span", null, "加载中", -1)), r(N, null, { default: u(() => [r(L)]), _: 1 })], 4)) : d("", true)], 12, Y)), [[D, e(g)]]) : d("", true)])) : (o(), s("div", se, [r(S, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: u(() => l[1] || (l[1] = [V(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [1] })]))]);
  };
} }, xe = z(ae, [["__scopeId", "data-v-b4c09d8d"]]);
export {
  xe as default
};
