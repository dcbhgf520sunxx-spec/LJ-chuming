import { ref as c } from "vue";
import { computed as q } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as K } from "vue";
import { createVNode as w } from "vue";
import { unref as t } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as s } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as h } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { nextTick as E } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as G } from "../../../../modules/product-receive-send-storage-07e30ee6.js";
import { q as g } from "../../../../modules/bridge-86f96a4f.js";
import { _ as z, x as L, o as J, G as X, P as Y, D as Z } from "../../../../shared/runtime.js";
import ee from "./module/header.vue.js";
import te from "./module/detail.vue.js";
import oe from "./module/type-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const ae = { class: "app-container" }, re = ["onClick"], ie = ["onClick"], ne = ["onClick"], se = { __name: "index", setup(le) {
  const Q = { add: false, edit: false, del: false, download: false }, R = c(), k = c(false), x = c("detail"), S = c({}), T = c({}), V = q(() => x.value === "detail" ? te : oe), { crud: C, columns: m } = L({ title: "制成品入发存", sort: ["id.desc"], permission: { ...g }, optShow: { ...Q }, crudApi: G, hasPagination: true }, R), { maxHeight: $ } = J({ wrapperBox: ".product-send-receive-storage", paginate: true, extraHeight: 40 }), I = c([["project", "parse-project"]]);
  function y(f, l) {
    x.value = l, S.value = f.sourceRow, T.value = { projectId: f.sourceRow.project.id }, E(() => {
      k.value = true;
    });
  }
  function O(f) {
    const { columns: l, data: r } = f, _ = [];
    return l.forEach((i, v) => {
      if (v === 0) {
        _[v] = "合计";
        return;
      }
      if (i.property === "list" || i.property === "inbound" || i.property === "outbound" || i.property === "stock") {
        const N = i.property === "list" ? "quantity" : i.property + "Quantity", e = r.map((o) => {
          var a;
          return Number((a = o.sourceRow) == null ? void 0 : a[N]);
        });
        let u = 0;
        const U = i.property === "list" ? "mete" : i.property + "Mete", j = r.map((o) => {
          var a;
          return Number((a = o.sourceRow) == null ? void 0 : a[U]);
        });
        let B = 0;
        e.every((o) => isNaN(o)) || (u = e.reduce((o, a) => {
          const D = Number(a);
          return isNaN(D) ? o : o + a;
        }, 0)), j.every((o) => isNaN(o)) || (B = j.reduce((o, a) => {
          const D = Number(a);
          return isNaN(D) ? o : o + a;
        }, 0)), _[v] = u + " / " + B.toFixed(Z.COM_WT__KG);
      }
    }), _;
  }
  return (f, l) => {
    const r = A, _ = M("common-button"), i = M("common-table"), v = H("permission"), N = F;
    return n(), K("div", ae, [w(t(ee)), P((n(), s(i, { ref_key: "tableRef", ref: R, data: t(C).data, "empty-text": t(C).emptyText, "max-height": t($), stripe: false, "data-format": I.value, "show-summary": "", "summary-method": O, style: { width: "100%" } }, { default: d(() => [w(r, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), t(m).visible("project") ? (n(), s(r, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "left" })) : p("", true), t(m).visible("list") ? (n(), s(r, { key: "list", prop: "list", "show-overflow-tooltip": true, label: "清单数（件/kg）", align: "center" }, { default: d((e) => [b("span", null, h(e.row.quantity + " / " + e.row.mete), 1)]), _: 1 })) : p("", true), t(m).visible("inbound") ? (n(), s(r, { key: "inbound", prop: "inbound", "show-overflow-tooltip": true, label: "累计入库（件/kg）", align: "center" }, { default: d((e) => [b("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (u) => y(e.row, "INBOUND") }, h(e.row.inboundQuantity + " / " + e.row.inboundMete), 9, re)]), _: 1 })) : p("", true), t(m).visible("outbound") ? (n(), s(r, { key: "outbound", prop: "outbound", "show-overflow-tooltip": true, label: "累计出库（件/kg）", align: "center" }, { default: d((e) => [b("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (u) => y(e.row, "OUTBOUND") }, h(e.row.outboundQuantity + " / " + e.row.outboundMete), 9, ie)]), _: 1 })) : p("", true), t(m).visible("stock") ? (n(), s(r, { key: "stock", prop: "stock", "show-overflow-tooltip": true, label: "实时库存（件/kg）", align: "center" }, { default: d((e) => [b("span", { style: { cursor: "pointer", color: "#0d84ff" }, onClick: (u) => y(e.row, "STOCK") }, h(e.row.stockQuantity + " / " + e.row.stockMete), 9, ne)]), _: 1 })) : p("", true), t(X)([...t(g).detail]) ? (n(), s(r, { key: 5, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: d((e) => [P(w(_, { size: "default", icon: "el-icon-view", type: "primary", onClick: (u) => y(e.row, "detail") }, null, 8, ["onClick"]), [[v, t(g).detail]])]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[N, t(C).loading]]), w(t(Y)), (n(), s(W(V.value), { showType: x.value, modelValue: k.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => k.value = e), detailQuery: T.value, detailInfo: S.value, permission: t(g) }, null, 8, ["showType", "modelValue", "detailQuery", "detailInfo", "permission"]))]);
  };
} }, we = z(se, [["__scopeId", "data-v-1ef323d5"]]);
export {
  we as default
};
