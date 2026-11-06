import { ref as _ } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { normalizeStyle as u } from "vue";
import { Fragment as R } from "vue";
import { renderList as N } from "vue";
import { createBlock as w } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTooltip as B } from "element-plus";
import { Loading as Q } from "@element-plus/icons-vue";
import { ElIcon as q } from "element-plus";
import { ElInfiniteScroll as O } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { p as P } from "../../../../../modules/common-256ce4d4.js";
import { l as U, _ as F, x as V, px as H, o as T, D as m } from "../../../../../shared/runtime.js";
import { u as W } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import j from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-292e247c.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
function z(h) {
  return U({ module: "mes", url: "kanban/product/detail/enclosure", method: "get", params: h });
}
const A = { class: "app-container" }, G = ["infinite-scroll-disabled"], J = ["onMouseenter"], K = { class: "ellipsis-text" }, X = { class: "ellipsis-text" }, Y = { class: "ellipsis-text" }, Z = { key: 0, class: "red-tip" }, ee = { __name: "index", setup(h) {
  const D = { add: false, edit: false, del: false, download: false }, y = _(), g = _(), M = _(), { crud: a, CRUD: S } = V({ title: "围护看板", permission: { ...H }, crudApi: { get: P }, optShow: { ...D }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, M), { maxHeight: v } = T({ paginate: false }), { boxStyle: x, load: b, boardList: $ } = W({ headRef: g, scrollBoxRef: y, crud: a, CRUD: S });
  async function C(n) {
    if (!n.hasDetail) try {
      n.detailLoading = true;
      const o = await z({ id: n.id });
      n.hasDetail = true, o.processInfo = `-----------------------

生产上报 / 已质检

`, (o.processSummaryDetailsList || []).forEach((s) => {
        const d = o.quantity === s.completeQuantity && s.quantity === s.inspectionQuantity ? "√" : `${s.completeQuantity} / ${s.inspectionQuantity}`;
        o.processInfo += `${s.name}：${d}

`;
      }), n = Object.assign(n, o);
    } catch (o) {
      console.log("获取详情失败", o);
    } finally {
      n.detailLoading = false;
    }
  }
  return (n, o) => {
    const L = B, s = Q, E = q, d = O;
    return i(), l("div", A, [p(t(j), { ref_key: "headRef", ref: g, onLoad: t(b) }, null, 8, ["onLoad"]), t(a).firstLoaded ? I((i(), l("div", { key: 0, ref_key: "scrollBoxRef", ref: y, class: "board-container", "infinite-scroll-disabled": t(a).loading || !t(a).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: u({ "max-height": `${t(v)}px` }) }, [(i(true), l(R, null, N(t($), (e) => (i(), w(L, { key: e.id, "open-delay": 300, class: "item", effect: "light", content: `${e.detailLoading ? "正在加载中..." : `${e.name} ${e.serialNumber}

          板型：${e.plate}

          颜色：${e.color}

          厚度：${e.thickness && e.thickness.toFixed(t(m).MES_ENCLOSURE_T__MM)} mm

          长度：${e.length && e.length.toFixed(t(m).MES_ENCLOSURE_L__MM)} mm

          有效宽度：${e.width && e.width.toFixed(t(m).MES_ENCLOSURE_W__MM)} mm

          清单数量：${e.quantity}

          ${e.processInfo}`}`, placement: "left-start" }, { default: k(() => [r("div", { class: "board-box", style: u({ "background-color": `${e.boxColor}`, ...t(x) }), onMouseenter: (te) => C(e) }, [r("span", K, c(e.name), 1), r("span", X, c(e.serialNumber), 1), r("span", Y, c(e.completeQuantity) + "/" + c(e.compareQuantity), 1)], 44, J)]), _: 2 }, 1032, ["content"]))), 128)), !t($).length && !t(a).loading ? (i(), l("span", Z, "* 暂无数据")) : f("", true), t(a).loading ? (i(), l("div", { key: 1, class: "loading-box", style: u(t(x)) }, [o[0] || (o[0] = r("span", null, "加载中", -1)), p(E, null, { default: k(() => [p(s)]), _: 1 })], 4)) : f("", true)], 12, G)), [[d, t(b)]]) : f("", true)]);
  };
} }, he = F(ee, [["__scopeId", "data-v-856e9473"]]);
export {
  he as default
};
