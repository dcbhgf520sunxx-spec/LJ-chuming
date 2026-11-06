import { useRoute as te } from "vue-router";
import { ref as i } from "vue";
import { computed as ne } from "vue";
import { watch as oe } from "vue";
import { resolveComponent as ae } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as y } from "vue";
import { unref as s } from "vue";
import { createElementVNode as l } from "vue";
import { createBlock as M } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as se } from "vue";
import { normalizeStyle as D } from "vue";
import { Fragment as re } from "vue";
import { renderList as ie } from "vue";
import { ElTableColumn as ce } from "element-plus";
import { ElTooltip as le } from "element-plus";
import { ElImage as ue } from "element-plus";
import { Loading as de } from "@element-plus/icons-vue";
import { ElIcon as pe } from "element-plus";
import { ElInfiniteScroll as fe } from "element-plus";
import "../../../../../modules/el-infinite-scroll-4ed993c7.js";
import { p as _e, a as ye } from "../../../../../modules/common-256ce4d4.js";
import { l as I, _ as me, x as he, pv as ge, o as be, a3 as u, D as V, b$ as P } from "../../../../../shared/runtime.js";
import { u as $e } from "../../../../../modules/use-dashboard-index-3294c6d4.js";
import Ie from "./module/header.vue.js";
import xe from "./module/detail-drawer.vue.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-unshow-productType-by-mode-dfef77e4.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/index-21d3d7d7.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
function ke(d) {
  return I({ module: "mes", url: "kanban/product/detail/artifact", method: "get", params: d });
}
function De(d) {
  return I({ module: "mes", url: "kanban/product/detail/assemble", method: "get", params: d });
}
function Te(d) {
  return I({ module: "mes", url: `section_steel/nesting/${d}/link`, method: "get" });
}
function Le(d) {
  return I({ module: "mes", url: "kanban/product/detail/machine_part", method: "get", params: d });
}
const qe = { class: "app-container" }, we = { style: { display: "flex" }, class: "artifact-dashboard" }, Ee = { style: { cursor: "default" } }, ve = ["infinite-scroll-disabled"], Ne = ["onDblclick", "onMouseenter"], Se = { style: { width: "120px" } }, Ce = { key: 0, class: "ellipsis-text" }, Re = { class: "text-clamp" }, Qe = { key: 0, class: "ellipsis-text", style: { display: "flex" } }, Ae = { key: 0 }, Me = { key: 1 }, Ve = { class: "ellipsis-text" }, Pe = { key: 0, class: "red-tip" }, Be = { __name: "index", setup(d) {
  const B = { add: false, edit: false, del: false, download: false }, H = te(), T = i({}), x = i(false), L = i(), q = i(), b = i(), { crud: o, CRUD: O } = he({ title: "构件看板", permission: { ...ge }, crudApi: { get: _e }, optShow: { ...B }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, b), W = ne(() => H.params), { maxHeight: F } = be({ paginate: false }), { boxStyle: w, load: E, boardList: v } = $e({ headRef: q, scrollBoxRef: L, crud: o, CRUD: O, beforeRefreshHook: X });
  oe(() => W.value, (t) => {
    t && (o.query.projectId = Number(t == null ? void 0 : t.projectId), o.query.monomerId = t == null ? void 0 : t.monomerId, o.query.areaId = t == null ? void 0 : t.areaId, o.query.productType = Number(t == null ? void 0 : t.productType) || void 0);
  }, { immediate: true, deep: true });
  let N = null;
  async function j(t) {
    N = setTimeout(() => {
      switch (o.query.productType) {
        case u.ARTIFACT.V:
          C(t);
          break;
        case u.ASSEMBLE.V:
          R(t);
          break;
        case u.MACHINE_PART.V:
          Q(t);
          break;
      }
    }, 800);
  }
  const U = () => {
    clearTimeout(N);
  }, S = i([]), G = i(false), k = i(false), $ = i({});
  function K(t) {
    var e, p;
    (e = $.value) != null && e.name && t.name === ((p = $.value) == null ? void 0 : p.name) ? (b.value.setCurrentRow(), $.value = {}, o.query.steelSpec = void 0) : (b.value.setCurrentRow(t, "name"), $.value = t, o.query.steelSpec = t.name), k.value = true, o.toQuery();
  }
  async function z() {
    try {
      G.value = true;
      const { content: t } = await ye(o.query);
      S.value = t;
    } catch (t) {
      console.log("获取规格", t);
    }
  }
  async function X() {
    o.query.productType & u.MACHINE_PART.V && !k.value && z(), k.value = false;
  }
  async function C(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = await ke({ id: t.id });
      t.hasDetail = true, e.processInfo = `${e.name} ${e.serialNumber}

          规格：${e.specification}

          长度：${e.length} mm

          材质：${e.material}

          单净重：${e.netWeight && e.netWeight.toFixed(V.COM_WT__KG)} kg

          单毛重：${e.grossWeight && e.grossWeight.toFixed(V.COM_WT__KG)} kg

          图号：${e.drawingNumber}

          清单数量：${e.quantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const _ = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${_}

`;
      }), t = Object.assign(t, e, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  async function R(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = t.productType === P.NESTING.V ? await Te(t.id) : await De({ id: t.id });
      t.hasDetail = true, t.productType === P.NESTING.V ? (e.processInfo = `${e.serialNumber}

          长度（mm）：${e.length}

          材质：${e.material}

          规格：${e.specification}
`, e.processInfo += `-----------------------

编号       数量

`, (e.assembleLinkDTOS || []).forEach((n) => {
        const f = n.quantity;
        e.processInfo += `${n.serialNumber}：${f}

`;
      })) : (e.processInfo = `${e.serialNumber}

          清单数量：${e.quantity}

          已生产数量：${e.producedQuantity}

          已使用数量：${e.usedQuantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const _ = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${_}

`;
      })), t = Object.assign(t, e, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  async function Q(t) {
    if (!t.hasDetail) try {
      t.detailLoading = true;
      const e = await Le({ id: t.id });
      t.hasDetail = true, e.processInfo = `${e.serialNumber}

          清单数量：${e.quantity}

          已生产数量：${e.producedQuantity}

          已使用数量：${e.usedQuantity}
`, e.processInfo += `-----------------------

生产上报 / 已质检

`, (e.processSummaryDetailsList || []).forEach((n) => {
        const _ = e.quantity === n.completeQuantity && n.quantity === n.inspectionQuantity ? "√" : `${n.completeQuantity} / ${n.inspectionQuantity}`;
        e.processInfo += `${n.name}：${_}

`;
      }), t = Object.assign(t, e, { processInfo: e.processInfo });
    } catch (e) {
      console.log("获取详情失败", e);
    } finally {
      t.detailLoading = false;
    }
  }
  function J(t) {
    switch (o.query.productType) {
      case u.ARTIFACT.V:
        C(t);
        break;
      case u.ASSEMBLE.V:
        R(t);
        break;
      case u.MACHINE_PART.V:
        Q(t);
        break;
    }
    x.value = true, T.value = t;
  }
  return (t, e) => {
    const p = ce, n = ae("common-table"), f = le, _ = ue, Y = de, Z = pe, ee = fe;
    return r(), c("div", qe, [y(s(Ie), { ref_key: "headRef", ref: q, onLoad: s(E) }, null, 8, ["onLoad"]), l("div", we, [s(o).query.productType & s(u).MACHINE_PART.V ? (r(), M(n, { key: 0, data: S.value, "highlight-current-row": "", stripe: false, ref_key: "tableRef", ref: b, style: { width: "60px", "margin-right": "10px" }, onRowClick: K }, { default: m(() => [y(p, { "header-align": "center", align: "center", prop: "name", label: "板厚", "min-width": "55" }, { default: m(({ row: a }) => [l("span", Ee, g(a.name), 1)]), _: 1 })]), _: 1 }, 8, ["data"])) : h("", true), s(o).firstLoaded ? se((r(), c("div", { key: 1, ref_key: "scrollBoxRef", ref: L, class: "board-container", "infinite-scroll-disabled": s(o).loading || !s(o).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: D([{ flex: "1" }, { "max-height": `${s(F)}px` }]) }, [(r(true), c(re, null, ie(s(v), (a) => (r(), M(f, { key: a.id, "show-after": 1e3, class: "item", effect: "light", content: `${a.detailLoading ? "正在加载中..." : `${a.processInfo}`}`, placement: "left-start" }, { default: m(() => [l("div", { class: "board-box", style: D({ cursor: "pointer", "background-color": `${a.boxColor}`, ...s(w) }), onDblclick: (A) => J(a), onMouseenter: (A) => j(a), onMouseleave: U }, [l("div", Se, [a.name ? (r(), c("span", Ce, g(a.name), 1)) : h("", true), y(f, { class: "item", effect: "dark", content: `${a.serialNumber}`, placement: "top" }, { default: m(() => [l("span", Re, g(a.serialNumber), 1)]), _: 2 }, 1032, ["content"])]), s(o).query.productType & s(u).MACHINE_PART.V ? (r(), c("span", Qe, [y(_, { class: "ellipsis-text", style: { flex: "1", width: "95%" }, src: a.pictureUrl, onError: (A) => a.imgLoad = false }, { error: m(() => [l("div", null, [a.pictureUrl ? (r(), c("span", Ae, "加载失败")) : (r(), c("span", Me, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"])])) : h("", true), l("div", null, [l("span", Ve, g(a.completeQuantity) + "/" + g(a.compareQuantity), 1)])], 44, Ne)]), _: 2 }, 1032, ["content"]))), 128)), !s(v).length && !s(o).loading ? (r(), c("span", Pe, "* 暂无数据")) : h("", true), s(o).loading ? (r(), c("div", { key: 1, class: "loading-box", style: D(s(w)) }, [e[1] || (e[1] = l("span", null, "加载中", -1)), y(Z, null, { default: m(() => [y(Y)]), _: 1 })], 4)) : h("", true)], 12, ve)), [[ee, s(E)]]) : h("", true)]), y(s(xe), { visible: x.value, "onUpdate:visible": e[0] || (e[0] = (a) => x.value = a), "detail-row": T.value, productType: s(o).query.productType }, null, 8, ["visible", "detail-row", "productType"])]);
  };
} }, nt = me(Be, [["__scopeId", "data-v-a069b301"]]);
export {
  nt as default
};
