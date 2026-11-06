import { ref as N } from "vue";
import { computed as K } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as S } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as p } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as w } from "vue";
import { resolveDynamicComponent as L } from "vue";
import { nextTick as M } from "vue";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as J } from "../../../../../modules/product-receive-send-storage-7de51d86.js";
import { _ as X, m as Y, x as Z, o as ee, bo as d, c as a, uk as te, G as oe, P as re, D as ie } from "../../../../../shared/runtime.js";
import { g as C } from "../../../../../modules/ship-manage-3066b2ed.js";
import ae from "./module/header.vue.js";
import ne from "./module/detail.vue.js";
import se from "./module/type-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail-drawer.vue.js";
const le = { class: "app-container" }, ue = ["onClick"], pe = ["onClick"], de = ["onClick"], ce = ["onClick"], ge = ["onClick"], ye = { __name: "index", setup(we) {
  const j = { add: false, edit: false, del: false, download: false }, { currentProjectType: I } = Y(["currentProjectType"]), V = N(), x = N(false), q = N("detail"), E = N({}), G = N({}), O = K(() => q.value === "detail" ? ne : se), { crud: o, CRUD: U, columns: m } = Z({ title: "结构制成品入发存", sort: ["id.desc"], permission: { ...C }, optShow: { ...j }, crudApi: J, hasPagination: true }, V), { maxHeight: B } = ee({ wrapperBox: ".product-send-receive-storage", paginate: true, extraHeight: 40 });
  function f(k, _) {
    q.value = _, E.value = k.sourceRow, G.value = { projectId: k.sourceRow.project.id, dateTimeList: o.query.dateTimeList }, M(() => {
      x.value = true;
    });
  }
  U.HOOK.beforeToQuery = () => {
    o.query.projectType = I.value;
  };
  function $(k) {
    const { columns: _, data: n } = k, b = [];
    return _.forEach((r, v) => {
      if (v === 0) {
        b[v] = "合计";
        return;
      }
      if (r.property === "list" || r.property === "inbound" || r.property === "outbound" || r.property === "stock" || r.property === "package" || r.property === "beginning") {
        let T = r.property === "list" ? "quantity" : r.property + "Quantity";
        r.property === "package" && (T = "column.propertyMete");
        const t = n.map((i) => {
          var l;
          return Number((l = i.sourceRow) == null ? void 0 : l[T]);
        });
        let s = 0, g = "";
        r.property === "list" && o.query.weightStatus === d.NET.V ? g = "totalNetWeight" : r.property === "list" && o.query.weightStatus === d.GROSS.V ? g = "totalGrossWeight" : r.property !== "list" && o.query.weightStatus === d.NET.V ? g = r.property + "NetWeight" : r.property !== "list" && o.query.weightStatus === d.GROSS.V && (g = r.property + "GrossWeight");
        const Q = n.map((i) => {
          var l;
          return Number(a((l = i.sourceRow) == null ? void 0 : l[g], "kg", "t", 2));
        });
        let R = 0;
        t.every((i) => isNaN(i)) || (s = t.reduce((i, l) => {
          const W = Number(l);
          return isNaN(W) ? i : i + l;
        }, 0)), Q.every((i) => isNaN(i)) || (R = Q.reduce((i, l) => {
          const W = Number(l);
          return isNaN(W) ? i : i + l;
        }, 0)), b[v] = s + " / " + R.toFixed(ie.COM_WT__KG);
      }
    }), b;
  }
  return (k, _) => {
    const n = z, b = D("common-button"), r = D("common-table"), v = H("permission"), T = F;
    return u(), A("div", le, [S(e(ae)), P((u(), p(r, { ref_key: "tableRef", ref: V, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(B), stripe: false, "show-summary": "", "summary-method": $, style: { width: "100%" } }, { default: c(() => [S(n, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(m).visible("project") ? (u(), p(n, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left" }, { default: c(({ row: t }) => {
      var s, g;
      return [h("span", null, y(((s = t.project) == null ? void 0 : s.contractNo) || "") + "-" + y(((g = t.project) == null ? void 0 : g.shortName) || ""), 1)];
    }), _: 1 })) : w("", true), e(m).visible("list") ? (u(), p(n, { key: "list", prop: "list", "show-overflow-tooltip": true, label: "清单总数（件/吨）", align: "center" }, { default: c((t) => [h("span", null, y(e(o).query.weightStatus === e(d).NET.V ? t.row.quantity + " / " + e(a)(t.row.totalNetWeight, "kg", "t", 2) : t.row.quantity + " / " + e(a)(t.row.totalGrossWeight, "kg", "t", 2)), 1)]), _: 1 })) : w("", true), e(m).visible("beginning") ? (u(), p(n, { key: "beginning", prop: "beginning", "show-overflow-tooltip": true, label: "期初库存（件/吨）", align: "center" }, { default: c((t) => [h("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (s) => f(t.row, "BEGINNING") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.beginningQuantity + " / " + e(a)(t.row.beginningNetWeight, "kg", "t", 2) : t.row.beginningQuantity + " / " + e(a)(t.row.beginningGrossWeight, "kg", "t", 2)), 9, ue)]), _: 1 })) : w("", true), e(m).visible("inbound") ? (u(), p(n, { key: "inbound", prop: "inbound", "show-overflow-tooltip": true, label: "入库量（件/吨）", align: "center" }, { default: c((t) => [h("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (s) => f(t.row, "INBOUND") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.inboundQuantity + " / " + e(a)(t.row.inboundNetWeight, "kg", "t", 2) : t.row.inboundQuantity + " / " + e(a)(t.row.inboundGrossWeight, "kg", "t", 2)), 9, pe)]), _: 1 })) : w("", true), e(m).visible("outbound") ? (u(), p(n, { key: "outbound", prop: "outbound", "show-overflow-tooltip": true, label: "出库量（件/吨）", align: "center" }, { default: c((t) => [h("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (s) => f(t.row, "OUTBOUND") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.outboundQuantity + " / " + e(a)(t.row.outboundNetWeight, "kg", "t", 2) : t.row.outboundQuantity + " / " + e(a)(t.row.outboundGrossWeight, "kg", "t", 2)), 9, de)]), _: 1 })) : w("", true), e(m).visible("package") && e(o).query.productType === e(te).STRUCTURE.V ? (u(), p(n, { key: "package", prop: "package", "show-overflow-tooltip": true, label: "打包量（件/吨）", align: "center" }, { default: c((t) => [h("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (s) => f(t.row, "PACKAGE") }, y(e(o).query.weightStatus === e(d).NET.V ? (t.row.packageQuantity || 0) + " / " + e(a)(+t.row.packageNetWeight, "kg", "t", 2) : (t.row.packageQuantity || 0) + " / " + e(a)(+t.row.packageGrossWeight, "kg", "t", 2)), 9, ce)]), _: 1 })) : w("", true), e(m).visible("stock") ? (u(), p(n, { key: "stock", prop: "stock", "show-overflow-tooltip": true, label: "期末库存（件/吨）", align: "center" }, { default: c((t) => [h("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (s) => f(t.row, "STOCK") }, y(e(o).query.weightStatus === e(d).NET.V ? t.row.stockQuantity + " / " + e(a)(t.row.stockNetWeight, "kg", "t", 2) : t.row.stockQuantity + " / " + e(a)(t.row.stockGrossWeight, "kg", "t", 2)), 9, ge)]), _: 1 })) : w("", true), e(oe)([...e(C).detail]) ? (u(), p(n, { key: 7, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: c((t) => [P(S(b, { size: "default", icon: "el-icon-view", type: "primary", onClick: (s) => f(t.row, "detail") }, null, 8, ["onClick"]), [[v, e(C).detail]])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, e(o).loading]]), S(e(re)), (u(), p(L(O.value), { showType: q.value, modelValue: x.value, "onUpdate:modelValue": _[0] || (_[0] = (t) => x.value = t), detailQuery: G.value, productType: e(o).query.productType, workshopId: e(o).query.workshopId, dateTime: e(o).query.dateTimeList, weightStatus: e(o).query.weightStatus, detailInfo: E.value, permission: e(C) }, null, 8, ["showType", "modelValue", "detailQuery", "productType", "workshopId", "dateTime", "weightStatus", "detailInfo", "permission"]))]);
  };
} }, Ce = X(ye, [["__scopeId", "data-v-72ed49aa"]]);
export {
  Ce as default
};
