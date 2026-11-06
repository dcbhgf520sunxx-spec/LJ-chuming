import { ref as d } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as $ } from "vue";
import { unref as o } from "vue";
import { createElementVNode as f } from "vue";
import { createBlock as S } from "vue";
import { withCtx as x } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as y } from "vue";
import { withDirectives as K } from "vue";
import { normalizeStyle as k } from "vue";
import { Fragment as U } from "vue";
import { renderList as z } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { Loading as Y } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElInfiniteScroll as ee } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { l as _, _ as te, x as ne, o as oe, F as g, D as q, b$ as N } from "../../../../../shared/runtime.js";
import { x as ae } from "../../../../../modules/bridge-86f96a4f.js";
import { u as se } from "../../../../../modules/use-dashboard-index-0e26908e.js";
import ie from "./module/header.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-dashboard-header-f1034215.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/index-2d037787.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
function re(s) {
  return _({ module: "bridge", url: "kanban/product/page", method: "get", params: s });
}
function le(s) {
  return _({ module: "bridge", url: "kanban/product/steelSpec", method: "get", params: s });
}
function ce(s) {
  return _({ module: "bridge", url: "kanban/product/detail/box", method: "get", params: s });
}
function de(s) {
  return _({ module: "bridge", url: "kanban/product/detail/element", method: "get", params: s });
}
function ue(s) {
  return _({ module: "bridge", url: `section_steel/nesting/${s}/link`, method: "get" });
}
function pe(s) {
  return _({ module: "bridge", url: "kanban/product/detail/machine_part", method: "get", params: s });
}
const fe = { class: "app-container" }, _e = { style: { display: "flex" }, class: "box-dashboard" }, me = { style: { cursor: "default" } }, ye = ["infinite-scroll-disabled"], ge = ["onMouseenter"], he = { key: 0, class: "ellipsis-text" }, be = { class: "ellipsis-text" }, $e = { class: "ellipsis-text" }, xe = { key: 0, class: "red-tip" }, Ie = { __name: "index", setup(s) {
  const w = { add: false, edit: false, del: false, download: false }, L = d(), D = d(), h = d(), { crud: a, CRUD: T } = ne({ title: "分段看板", permission: { ...ae }, crudApi: { get: re }, optShow: { ...w }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, h), { maxHeight: R } = oe({ paginate: false }), { boxStyle: v, load: Q, boardList: C } = se({ headRef: D, scrollBoxRef: L, crud: a, CRUD: T, beforeRefreshHook: O });
  async function M(t) {
    switch (a.query.productType) {
      case g.BOX.V:
        A(t);
        break;
      case g.CELL.V:
        W(t);
        break;
      case g.MACHINE_PART.V:
        H(t);
        break;
    }
  }
  const E = d([]), P = d(false), I = d(false), b = d({});
  function V(t) {
    var e, r;
    (e = b.value) != null && e.name && t.name === ((r = b.value) == null ? void 0 : r.name) ? (h.value.setCurrentRow(), b.value = {}, a.query.steelSpec = void 0) : (h.value.setCurrentRow(t), b.value = t, a.query.steelSpec = t.name), I.value = true, a.toQuery();
  }
  async function B() {
    try {
      P.value = true;
      const { content: t } = await le(a.query);
      E.value = t;
    } catch (t) {
      console.log("获取规格", t);
    }
  }
  function O() {
    a.query.productType & g.MACHINE_PART.V && !I.value && B(), I.value = false;
  }
  async function A(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = await ce({ id: t.id });
      t.hasDetail = true, e.processInfo = `${e.name || ""} ${e.serialNumber}

          规格：${e.specification}

          长度：${e.length} mm

          材质：${e.material}

          单净重：${e.netWeight && e.netWeight.toFixed(q.COM_WT__KG)} kg

          单毛重：${e.grossWeight && e.grossWeight.toFixed(q.COM_WT__KG) + "kg" || ""} 

          图号：${e.drawingNumber || ""}

          清单数量：${e.quantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const c = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${c}

`;
      }), t = Object.assign(t, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  async function W(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = t.productType === N.NESTING.V ? await ue(t.id) : await de({ id: t.id });
      t.hasDetail = true, t.productType === N.NESTING.V ? (e.processInfo = `${e.serialNumber}

          长度（mm）：${e.length}

          材质：${e.material}

          规格：${e.specification}
`, e.processInfo += `-----------------------

编号       数量

`, (e.assembleLinkDTOS || []).forEach((n) => {
        const u = n.quantity;
        e.processInfo += `${n.serialNumber}：${u}

`;
      })) : (e.processInfo = `${e.serialNumber}

          清单数量：${e.quantity}

          已生产数量：${e.producedQuantity}

          已使用数量：${e.usedQuantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const c = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${c}

`;
      })), t = Object.assign(t, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  async function H(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = await pe({ id: t.id });
      t.hasDetail = true, e.processInfo = `${e.serialNumber}

          清单数量：${e.quantity}

          已生产数量：${e.producedQuantity}

          已使用数量：${e.usedQuantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const c = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${c}

`;
      }), t = Object.assign(t, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  return (t, e) => {
    const r = X, n = j("common-table"), u = J, c = Y, F = Z, G = ee;
    return l(), p("div", fe, [$(o(ie), { ref_key: "headRef", ref: D, onLoad: o(Q) }, null, 8, ["onLoad"]), f("div", _e, [o(a).query.productType & o(g).MACHINE_PART.V ? (l(), S(n, { key: 0, data: E.value, "highlight-current-row": "", stripe: false, ref_key: "tableRef", ref: h, style: { width: "60px", "margin-right": "10px" }, onRowClick: V }, { default: x(() => [$(r, { "header-align": "center", align: "center", prop: "name", label: "板厚", "min-width": "55" }, { default: x(({ row: i }) => [f("span", me, m(i.name), 1)]), _: 1 })]), _: 1 }, 8, ["data"])) : y("", true), o(a).firstLoaded ? K((l(), p("div", { key: 1, ref_key: "scrollBoxRef", ref: L, class: "board-container", "infinite-scroll-disabled": o(a).loading || !o(a).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: k([{ flex: "1" }, { "max-height": `${o(R)}px` }]) }, [(l(true), p(U, null, z(o(C), (i) => (l(), S(u, { key: i.id, "show-after": 300, class: "item", effect: "light", content: `${i.detailLoading ? "正在加载中..." : `${i.processInfo}`}`, placement: "left-start" }, { default: x(() => [f("div", { class: "board-box", style: k({ "background-color": `${i.boxColor}`, ...o(v) }), onMouseenter: (ke) => M(i) }, [i.name ? (l(), p("span", he, m(i.name), 1)) : y("", true), f("span", be, m(i.serialNumber), 1), f("span", $e, m(i.completeQuantity) + "/" + m(i.compareQuantity), 1)], 44, ge)]), _: 2 }, 1032, ["content"]))), 128)), !o(C).length && !o(a).loading ? (l(), p("span", xe, "* 暂无数据")) : y("", true), o(a).loading ? (l(), p("div", { key: 1, class: "loading-box", style: k(o(v)) }, [e[0] || (e[0] = f("span", null, "加载中", -1)), $(F, null, { default: x(() => [$(c)]), _: 1 })], 4)) : y("", true)], 12, ye)), [[G, o(Q)]]) : y("", true)])]);
  };
} }, Be = te(Ie, [["__scopeId", "data-v-5c2d7948"]]);
export {
  Be as default
};
