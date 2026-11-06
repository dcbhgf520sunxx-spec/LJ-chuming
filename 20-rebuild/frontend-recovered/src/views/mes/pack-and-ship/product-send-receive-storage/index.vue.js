import { ref as m } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as H } from "vue";
import { createVNode as N } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as k } from "vue";
import { resolveDynamicComponent as K } from "vue";
import { nextTick as M } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as z } from "../../../../modules/product-receive-send-storage-ba88d0e7.js";
import { _ as L, x as J, oi as S, o as X, bo as u, G as Y, P as Z, D as ee } from "../../../../shared/runtime.js";
import te from "./module/header.vue.js";
import oe from "./module/detail.vue.js";
import ie from "./module/type-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const re = { class: "app-container" }, ae = ["onClick"], ne = ["onClick"], se = ["onClick"], le = ["onClick"], ue = { __name: "index", setup(de) {
  const I = { add: false, edit: false, del: false, download: false }, W = m(), T = m(false), x = m("detail"), V = m({}), G = m({}), B = $(() => x.value === "detail" ? oe : ie), { crud: o, columns: y } = J({ title: "制成品入发存", sort: ["id.desc"], permission: { ...S }, optShow: { ...I }, crudApi: z, hasPagination: true }, W), { maxHeight: j } = X({ wrapperBox: ".product-send-receive-storage", paginate: true, extraHeight: 40 }), O = m([["project", "parse-project"]]);
  function w(h, g) {
    x.value = g, V.value = h.sourceRow, G.value = { projectId: h.sourceRow.project.id, dateTime: o.query.dateTime }, M(() => {
      T.value = true;
    });
  }
  function P(h) {
    const { columns: g, data: a } = h, f = [];
    return g.forEach((i, _) => {
      if (_ === 0) {
        f[_] = "合计";
        return;
      }
      if (i.property === "list" || i.property === "inbound" || i.property === "outbound" || i.property === "stock" || i.property === "beginning") {
        const C = i.property === "list" ? "quantity" : i.property + "Quantity", e = a.map((r) => {
          var n;
          return Number((n = r.sourceRow) == null ? void 0 : n[C]);
        });
        let d = 0, b = "";
        i.property === "list" && o.query.weightStatus === u.NET.V ? b = "totalNetWeight" : i.property === "list" && o.query.weightStatus === u.GROSS.V ? b = "totalGrossWeight" : i.property !== "list" && o.query.weightStatus === u.NET.V ? b = i.property + "NetWeight" : i.property !== "list" && o.query.weightStatus === u.GROSS.V && (b = i.property + "GrossWeight");
        const E = a.map((r) => {
          var n;
          return Number((n = r.sourceRow) == null ? void 0 : n[b]);
        });
        let Q = 0;
        e.every((r) => isNaN(r)) || (d = e.reduce((r, n) => {
          const q = Number(n);
          return isNaN(q) ? r : r + n;
        }, 0)), E.every((r) => isNaN(r)) || (Q = E.reduce((r, n) => {
          const q = Number(n);
          return isNaN(q) ? r : r + n;
        }, 0)), f[_] = d + " / " + Q.toFixed(ee.COM_WT__KG);
      }
    }), f;
  }
  return (h, g) => {
    const a = A, f = R("common-button"), i = R("common-table"), _ = U("permission"), C = F;
    return s(), H("div", re, [N(t(te)), D((s(), l(i, { ref_key: "tableRef", ref: W, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(j), stripe: false, "data-format": O.value, "show-summary": "", "summary-method": P, style: { width: "100%" } }, { default: p(() => [N(a, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), t(y).visible("project") ? (s(), l(a, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left" })) : c("", true), t(y).visible("list") ? (s(), l(a, { key: "list", prop: "list", "show-overflow-tooltip": true, label: "清单总数（件/kg）", align: "center" }, { default: p((e) => [v("span", null, k(t(o).query.weightStatus === t(u).NET.V ? e.row.quantity + " / " + e.row.totalNetWeight : e.row.quantity + " / " + e.row.totalGrossWeight), 1)]), _: 1 })) : c("", true), t(y).visible("beginning") ? (s(), l(a, { key: "beginning", prop: "beginning", "show-overflow-tooltip": true, label: "期初库存（件/kg）", align: "center" }, { default: p((e) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (d) => w(e.row, "BEGINNING") }, k(t(o).query.weightStatus === t(u).NET.V ? e.row.beginningQuantity + " / " + e.row.beginningNetWeight : e.row.beginningQuantity + " / " + e.row.beginningGrossWeight), 9, ae)]), _: 1 })) : c("", true), t(y).visible("inbound") ? (s(), l(a, { key: "inbound", prop: "inbound", "show-overflow-tooltip": true, label: "入库量（件/kg）", align: "center" }, { default: p((e) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (d) => w(e.row, "INBOUND") }, k(t(o).query.weightStatus === t(u).NET.V ? e.row.inboundQuantity + " / " + e.row.inboundNetWeight : e.row.inboundQuantity + " / " + e.row.inboundGrossWeight), 9, ne)]), _: 1 })) : c("", true), t(y).visible("outbound") ? (s(), l(a, { key: "outbound", prop: "outbound", "show-overflow-tooltip": true, label: "出库量（件/kg）", align: "center" }, { default: p((e) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (d) => w(e.row, "OUTBOUND") }, k(t(o).query.weightStatus === t(u).NET.V ? e.row.outboundQuantity + " / " + e.row.outboundNetWeight : e.row.outboundQuantity + " / " + e.row.outboundGrossWeight), 9, se)]), _: 1 })) : c("", true), t(y).visible("stock") ? (s(), l(a, { key: "stock", prop: "stock", "show-overflow-tooltip": true, label: "期末库存（件/kg）", align: "center" }, { default: p((e) => [v("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (d) => w(e.row, "STOCK") }, k(t(o).query.weightStatus === t(u).NET.V ? e.row.stockQuantity + " / " + e.row.stockNetWeight : e.row.stockQuantity + " / " + e.row.stockGrossWeight), 9, le)]), _: 1 })) : c("", true), t(Y)([...t(S).detail]) ? (s(), l(a, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p((e) => [D(N(f, { size: "default", icon: "el-icon-view", type: "primary", onClick: (d) => w(e.row, "detail") }, null, 8, ["onClick"]), [[_, t(S).detail]])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[C, t(o).loading]]), N(t(Z)), (s(), l(K(B.value), { showType: x.value, modelValue: T.value, "onUpdate:modelValue": g[0] || (g[0] = (e) => T.value = e), detailQuery: G.value, productType: t(o).query.productType, workshopId: t(o).query.workshopId, dateTime: t(o).query.dateTime, weightStatus: t(o).query.weightStatus, detailInfo: V.value, permission: t(S) }, null, 8, ["showType", "modelValue", "detailQuery", "productType", "workshopId", "dateTime", "weightStatus", "detailInfo", "permission"]))]);
  };
} }, _e = L(ue, [["__scopeId", "data-v-c6a4c09c"]]);
export {
  _e as default
};
