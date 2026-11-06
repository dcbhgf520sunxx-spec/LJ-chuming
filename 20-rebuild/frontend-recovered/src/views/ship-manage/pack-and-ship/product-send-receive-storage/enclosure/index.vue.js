import { ref as k } from "vue";
import { computed as H } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as K } from "vue";
import { createVNode as T } from "vue";
import { unref as e } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as l } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as m } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { nextTick as A } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as J } from "../../../../../modules/enclosure-product-receive-send-storage-2e87d697.js";
import { _ as X, m as Y, x as Z, o as ee, uc as te, bs as N, D as g, G as oe, P as re } from "../../../../../shared/runtime.js";
import { h as C } from "../../../../../modules/ship-manage-3066b2ed.js";
import ne from "./module/header.vue.js";
import ae from "./module/detail.vue.js";
import ie from "./module/type-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail-drawer.vue.js";
const se = { class: "app-container" }, le = ["onClick"], ue = ["onClick"], pe = ["onClick"], ce = ["onClick"], de = { __name: "index", setup(me) {
  const I = { add: false, edit: false, del: false, download: false }, R = k(), { currentProjectType: P } = Y(["currentProjectType"]), E = k(false), x = k("detail"), M = k({}), D = k({}), Q = H(() => x.value === "detail" ? ae : ie), { crud: u, CRUD: B, columns: _ } = Z({ title: "围护制成品入发存", sort: ["id.desc"], permission: { ...C }, optShow: { ...I }, crudApi: J, hasPagination: true }, R), { maxHeight: V } = ee({ wrapperBox: ".product-send-receive-storage", paginate: true, extraHeight: 40 });
  function h(p, y) {
    x.value = y, M.value = p.sourceRow, D.value = { projectId: p.sourceRow.project.id, dateTime: u.query.dateTime }, A(() => {
      E.value = true;
    });
  }
  B.HOOK.beforeToQuery = (p) => {
    p.query.productType = te.ENCLOSURE.V, p.query.projectType = P.value;
  };
  function $(p) {
    const { columns: y, data: n } = p, b = [];
    return y.forEach((r, w) => {
      if (w === 0) {
        b[w] = "合计";
        return;
      }
      if (r.property === "list" || r.property === "inbound" || r.property === "outbound" || r.property === "stock" || r.property === "beginning") {
        const S = r.property === "list" ? "quantity" : r.property + "Quantity", t = n.map((o) => {
          var a;
          return Number((a = o.sourceRow) == null ? void 0 : a[S]);
        });
        let i = 0, f = "";
        r.property === "list" ? f = "totalLength" : r.property !== "list" && (f = r.property + "TotalLength");
        const O = n.map((o) => {
          var a;
          return Number((a = o.sourceRow) == null ? void 0 : a[f]);
        });
        let U = 0;
        t.every((o) => isNaN(o)) || (i = t.reduce((o, a) => {
          const L = Number(a);
          return isNaN(L) ? o : o + a;
        }, 0)), O.every((o) => isNaN(o)) || (U = O.reduce((o, a) => {
          const L = Number(a);
          return isNaN(L) ? o : o + a;
        }, 0)), b[w] = i + " / " + U.toFixed(g.MES_ENCLOSURE_L__M);
      }
    }), b;
  }
  return (p, y) => {
    const n = F, b = j("common-button"), r = j("common-table"), w = G("permission"), S = z;
    return s(), K("div", se, [T(e(ne), { permission: e(C) }, null, 8, ["permission"]), q((s(), l(r, { ref_key: "tableRef", ref: R, data: e(u).data, "empty-text": e(u).emptyText, "max-height": e(V), stripe: false, "summary-method": $, "show-summary": "", style: { width: "100%" } }, { default: c(() => [T(n, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(_).visible("project") ? (s(), l(n, { key: "project", "show-overflow-tooltip": true, align: "left", label: "项目", prop: "project" }, { default: c(({ row: t }) => {
      var i, f;
      return [v("span", null, d(((i = t.project) == null ? void 0 : i.contractNo) || "") + "-" + d(((f = t.project) == null ? void 0 : f.shortName) || ""), 1)];
    }), _: 1 })) : m("", true), e(_).visible("list") ? (s(), l(n, { key: "list", "show-overflow-tooltip": true, align: "center", label: "清单总数（件/米）", prop: "list" }, { default: c((t) => [v("span", null, d(t.row.quantity + " / " + e(N)(t.row.totalLength, e(g).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : m("", true), e(_).visible("beginning") ? (s(), l(n, { key: "beginning", "show-overflow-tooltip": true, align: "center", label: "期初库存（件/米）", prop: "beginning" }, { default: c((t) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (i) => h(t.row, "BEGINNING") }, d(t.row.beginningQuantity + " / " + e(N)(t.row.beginningTotalLength, e(g).MES_ENCLOSURE_L__M)), 9, le)]), _: 1 })) : m("", true), e(_).visible("inbound") ? (s(), l(n, { key: "inbound", "show-overflow-tooltip": true, align: "center", label: "入库量（件/米）", prop: "inbound" }, { default: c((t) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (i) => h(t.row, "INBOUND") }, d(t.row.inboundQuantity + " / " + e(N)(t.row.inboundTotalLength, e(g).MES_ENCLOSURE_L__M)), 9, ue)]), _: 1 })) : m("", true), e(_).visible("outbound") ? (s(), l(n, { key: "outbound", "show-overflow-tooltip": true, align: "center", label: "出库量（件/米）", prop: "outbound" }, { default: c((t) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (i) => h(t.row, "OUTBOUND") }, d(t.row.outboundQuantity + " / " + e(N)(t.row.outboundTotalLength, e(g).MES_ENCLOSURE_L__M)), 9, pe)]), _: 1 })) : m("", true), e(_).visible("stock") ? (s(), l(n, { key: "stock", "show-overflow-tooltip": true, align: "center", label: "期末库存（件/米）", prop: "stock" }, { default: c((t) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (i) => h(t.row, "STOCK") }, d(t.row.stockQuantity + " / " + e(N)(t.row.stockTotalLength, e(g).MES_ENCLOSURE_L__M)), 9, ce)]), _: 1 })) : m("", true), e(oe)([...e(C).detail]) ? (s(), l(n, { key: 6, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: c((t) => [q(T(b, { icon: "el-icon-view", size: "default", type: "primary", onClick: (i) => h(t.row, "detail") }, null, 8, ["onClick"]), [[w, e(C).detail]])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, e(u).loading]]), T(e(re)), (s(), l(W(Q.value), { modelValue: E.value, "onUpdate:modelValue": y[0] || (y[0] = (t) => E.value = t), category: e(u).query.category, dateTime: e(u).query.dateTime, detailInfo: M.value, detailQuery: D.value, permission: e(C), productType: e(u).query.productType, showType: x.value, workshopId: e(u).query.workshopId }, null, 8, ["modelValue", "category", "dateTime", "detailInfo", "detailQuery", "permission", "productType", "showType", "workshopId"]))]);
  };
} }, Ce = X(de, [["__scopeId", "data-v-0af91d4a"]]);
export {
  Ce as default
};
