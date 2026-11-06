import { ref as N } from "vue";
import { computed as H } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as T } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as p } from "vue";
import { withCtx as g } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as m } from "vue";
import { resolveDynamicComponent as A } from "vue";
import { nextTick as z } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as J } from "../../../../../modules/box-product-receive-send-storage-9ef20b12.js";
import { _ as X, m as Y, x as Z, o as ee, bo as d, c as s, G as te, P as oe, D as re } from "../../../../../shared/runtime.js";
import { f as S } from "../../../../../modules/ship-manage-3066b2ed.js";
import ie from "./module/header.vue.js";
import ne from "./module/detail.vue.js";
import ae from "./module/type-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail-drawer.vue.js";
const se = { class: "app-container" }, le = ["onClick"], ue = ["onClick"], pe = ["onClick"], de = ["onClick"], ce = { __name: "index", setup(ge) {
  const I = { add: false, edit: false, del: false, download: false }, { currentProjectType: O } = Y(["currentProjectType"]), V = N(), x = N(false), C = N("detail"), G = N({}), Q = N({}), P = H(() => C.value === "detail" ? ne : ae), { crud: o, CRUD: B, columns: w } = Z({ title: "结构制成品入发存", sort: ["id.desc"], permission: { ...S }, optShow: { ...I }, crudApi: J, hasPagination: true }, V), { maxHeight: U } = ee({ wrapperBox: ".product-send-receive-storage", paginate: true, extraHeight: 40 });
  function _(b, h) {
    C.value = h, G.value = b.sourceRow, Q.value = { projectId: b.sourceRow.project.id, dateTime: o.query.dateTime }, z(() => {
      x.value = true;
    });
  }
  B.HOOK.beforeToQuery = () => {
    o.query.projectType = O.value;
  };
  function $(b) {
    const { columns: h, data: n } = b, v = [];
    return h.forEach((r, k) => {
      if (k === 0) {
        v[k] = "合计";
        return;
      }
      if (r.property === "list" || r.property === "inbound" || r.property === "outbound" || r.property === "stock" || r.property === "beginning") {
        const q = r.property === "list" ? "quantity" : r.property + "Quantity", t = n.map((i) => {
          var a;
          return Number((a = i.sourceRow) == null ? void 0 : a[q]);
        });
        let l = 0, c = "";
        r.property === "list" && o.query.weightStatus === d.NET.V ? c = "totalNetWeight" : r.property === "list" && o.query.weightStatus === d.GROSS.V ? c = "totalGrossWeight" : r.property !== "list" && o.query.weightStatus === d.NET.V ? c = r.property + "NetWeight" : r.property !== "list" && o.query.weightStatus === d.GROSS.V && (c = r.property + "GrossWeight");
        const R = n.map((i) => {
          var a;
          return Number(s((a = i.sourceRow) == null ? void 0 : a[c], "kg", "t", 2));
        });
        let D = 0;
        t.every((i) => isNaN(i)) || (l = t.reduce((i, a) => {
          const W = Number(a);
          return isNaN(W) ? i : i + a;
        }, 0)), R.every((i) => isNaN(i)) || (D = R.reduce((i, a) => {
          const W = Number(a);
          return isNaN(W) ? i : i + a;
        }, 0)), v[k] = l + " / " + D.toFixed(re.COM_WT__KG);
      }
    }), v;
  }
  return (b, h) => {
    const n = F, v = E("common-button"), r = E("common-table"), k = K("permission"), q = L;
    return u(), M("div", se, [T(e(ie)), j((u(), p(r, { ref_key: "tableRef", ref: V, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(U), stripe: false, "show-summary": "", "summary-method": $, style: { width: "100%" } }, { default: g(() => [T(n, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(w).visible("project") ? (u(), p(n, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left" }, { default: g(({ row: t }) => {
      var l, c;
      return [f("span", null, y(((l = t.project) == null ? void 0 : l.contractNo) || "") + "-" + y(((c = t.project) == null ? void 0 : c.shortName) || ""), 1)];
    }), _: 1 })) : m("", true), e(w).visible("list") ? (u(), p(n, { key: "list", prop: "list", "show-overflow-tooltip": true, label: "清单总数（件/吨）", align: "center" }, { default: g((t) => [f("span", null, y(e(o).query.weightStatus === e(d).NET.V ? t.row.quantity + " / " + e(s)(t.row.totalNetWeight, "kg", "t", 2) : t.row.quantity + " / " + e(s)(t.row.totalGrossWeight, "kg", "t", 2)), 1)]), _: 1 })) : m("", true), e(w).visible("beginning") ? (u(), p(n, { key: "beginning", prop: "beginning", "show-overflow-tooltip": true, label: "期初库存（件/吨）", align: "center" }, { default: g((t) => [f("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (l) => _(t.row, "BEGINNING") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.beginningQuantity + " / " + e(s)(t.row.beginningNetWeight, "kg", "t", 2) : t.row.beginningQuantity + " / " + e(s)(t.row.beginningGrossWeight, "kg", "t", 2)), 9, le)]), _: 1 })) : m("", true), e(w).visible("inbound") ? (u(), p(n, { key: "inbound", prop: "inbound", "show-overflow-tooltip": true, label: "入库量（件/吨）", align: "center" }, { default: g((t) => [f("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (l) => _(t.row, "INBOUND") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.inboundQuantity + " / " + e(s)(t.row.inboundNetWeight, "kg", "t", 2) : t.row.inboundQuantity + " / " + e(s)(t.row.inboundGrossWeight, "kg", "t", 2)), 9, ue)]), _: 1 })) : m("", true), e(w).visible("outbound") ? (u(), p(n, { key: "outbound", prop: "outbound", "show-overflow-tooltip": true, label: "出库量（件/吨）", align: "center" }, { default: g((t) => [f("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (l) => _(t.row, "OUTBOUND") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.outboundQuantity + " / " + e(s)(t.row.outboundNetWeight, "kg", "t", 2) : t.row.outboundQuantity + " / " + e(s)(t.row.outboundGrossWeight, "kg", "t", 2)), 9, pe)]), _: 1 })) : m("", true), e(w).visible("stock") ? (u(), p(n, { key: "stock", prop: "stock", "show-overflow-tooltip": true, label: "期末库存（件/吨）", align: "center" }, { default: g((t) => [f("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (l) => _(t.row, "STOCK") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.stockQuantity + " / " + e(s)(t.row.stockNetWeight, "kg", "t", 2) : t.row.stockQuantity + " / " + e(s)(t.row.stockGrossWeight, "kg", "t", 2)), 9, de)]), _: 1 })) : m("", true), e(te)([...e(S).detail]) ? (u(), p(n, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: g((t) => [j(T(v, { size: "default", icon: "el-icon-view", type: "primary", onClick: (l) => _(t.row, "detail") }, null, 8, ["onClick"]), [[k, e(S).detail]])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, e(o).loading]]), T(e(oe)), (u(), p(A(P.value), { showType: C.value, modelValue: x.value, "onUpdate:modelValue": h[0] || (h[0] = (t) => x.value = t), detailQuery: Q.value, productType: e(o).query.productType, workshopId: e(o).query.workshopId, dateTime: e(o).query.dateTime, weightStatus: e(o).query.weightStatus, detailInfo: G.value, permission: e(S) }, null, 8, ["showType", "modelValue", "detailQuery", "productType", "workshopId", "dateTime", "weightStatus", "detailInfo", "permission"]))]);
  };
} }, Te = X(ce, [["__scopeId", "data-v-e9d1615c"]]);
export {
  Te as default
};
