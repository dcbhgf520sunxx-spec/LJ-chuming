import { ref as o } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as w } from "vue";
import { normalizeStyle as p } from "vue";
import { Fragment as E } from "vue";
import { renderList as N } from "vue";
import { createBlock as q } from "vue";
import { withCtx as v } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTooltip as V } from "element-plus";
import { Loading as H } from "@element-plus/icons-vue";
import { ElIcon as M } from "element-plus";
import { ElInfiniteScroll as O } from "element-plus";
import "../../../../../../../modules/el-infinite-scroll-4ed993c7.js";
import Q from "./module/card-header.vue.js";
import { _ as U, o as z, x as A, pI as T, bX as k } from "../../../../../../../shared/runtime.js";
import j from "./module/artifact-card-detail.vue.js";
import { c as F } from "../../../../../../../modules/project-production-panel-fb6946a2.js";
import { u as K } from "../../../../../../../modules/use-dashboard-index-3294c6d4.js";
import "../../../../../../../modules/index-d6a37d29.js";
import "../../../../../../../modules/index-21d3d7d7.js";
import "../../../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../../../modules/index-8356a01a.js";
import "./module/process-card-detail.vue.js";
import "../../../../../../../modules/raf-ac2cc4f2.js";
const W = ["infinite-scroll-disabled"], X = ["onClick"], G = { class: "ellipsis-text" }, J = { class: "ellipsis-text" }, Y = { class: "ellipsis-text" }, Z = { key: 0, class: "red-tip" }, ee = { __name: "card-panel", setup(te) {
  const C = { add: false, edit: false, del: false, download: false }, d = o(false), _ = o(), f = o(), $ = o(), { maxHeight: S } = z({ paginate: false, extraHeight: 100 }), { crud: s, CRUD: D } = A({ title: "生产跟踪", permission: { get: T.getCardList }, crudApi: { ...F }, optShow: { ...C }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, $), { boxStyle: m, load: g, boardList: y } = K({ headRef: _, scrollBoxRef: f, crud: s, CRUD: D, pageSize: 20, intervalTime: 1e3 }), x = o();
  function I(b) {
    x.value = b.id, d.value = true;
  }
  return (b, l) => {
    const L = V, R = H, B = M, P = O;
    return a(), n("div", null, [r(Q, { ref_key: "headRef", ref: _, onLoad: t(g) }, null, 8, ["onLoad"]), t(s).firstLoaded ? w((a(), n("div", { key: 0, ref_key: "scrollBoxRef", ref: f, class: "board-container", "infinite-scroll-disabled": t(s).loading || !t(s).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: p({ "max-height": `${t(S)}px` }) }, [(a(true), n(E, null, N(t(y), (e) => (a(), q(L, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.name} ${e.serialNumber}

          规格：${e.specification}

          材质：${e.material}

          生产数量：${e.producedQuantity}

          所需数量：${e.quantity}

          `, placement: "left-start" }, { default: v(() => {
      var h;
      return [i("div", { class: "board-box", style: p([{ position: "relative", cursor: "pointer" }, { "background-color": `${(h = t(k)[t(k).VK[e.status]]) == null ? void 0 : h.COLOR}`, ...t(m) }]), onClick: (se) => I(e) }, [i("span", G, c(e.name), 1), i("span", J, c(e.serialNumber), 1), i("span", Y, c(e.producedQuantity) + " / " + c(e.quantity), 1)], 12, X)];
    }), _: 2 }, 1032, ["content"]))), 128)), !t(y).length && !t(s).loading ? (a(), n("span", Z, "* 暂无数据")) : u("", true), t(s).loading ? (a(), n("div", { key: 1, class: "loading-box", style: p(t(m)) }, [l[1] || (l[1] = i("span", null, "加载中", -1)), r(B, null, { default: v(() => [r(R)]), _: 1 })], 4)) : u("", true)], 12, W)), [[P, t(g)]]) : u("", true), r(j, { visible: d.value, "onUpdate:visible": l[0] || (l[0] = (e) => d.value = e), "product-id": x.value }, null, 8, ["visible", "product-id"])]);
  };
} }, ge = U(ee, [["__scopeId", "data-v-7c191495"]]);
export {
  ge as default
};
