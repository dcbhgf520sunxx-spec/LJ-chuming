import { ref as O } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as g } from "vue";
import { withDirectives as D } from "vue";
import { unref as t } from "vue";
import { createBlock as h } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as v } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as C, t as F, x as H, o as P, jj as M, an as I } from "../../../../../shared/runtime.js";
import { x as N } from "../../../../../modules/contract-9b18cc88.js";
import j from "./module/header.vue.js";
import K from "./module/form.vue.js";
function U(n) {
  return C({ module: "", url: "/api/contract/water-electricity", method: "get", params: n });
}
function $(n) {
  return C({ module: "", url: "/api/contract/water-electricity", method: "post", data: [n] });
}
function Q(n) {
  return C({ module: "", url: "/api/contract/water-electricity", method: "post", data: [n] });
}
function z(n) {
  return C({ module: "", url: "/api/contract/water-electricity", method: "delete", data: n });
}
const G = { get: U, add: $, edit: Q, del: z }, J = { class: "app-container" }, W = { class: "head-container" }, ae = { __name: "index", setup(n) {
  const { decimalPrecision: x } = F(), k = O(), V = { add: true, edit: false, del: false, download: false }, { crud: s, CRUD: E, columns: _ } = H({ title: "水电费", sort: [], optShow: { ...V }, permission: { ...N }, crudApi: { ...G }, hasPagination: false }, k);
  function S(A) {
    const { columns: m, data: a } = A, l = [];
    return m.forEach((u, e) => {
      if (e === 0) {
        l[e] = "合计";
        return;
      }
      if (e === 3) {
        l[e] = 0;
        const y = a.map((o) => o.usedMete), d = a.map((o) => o.totalAmount), r = y.reduce((o, p) => p ? o + Number(p) : o, 0), b = d.reduce((o, p) => p ? o + Number(p) : o, 0);
        l[e] = r ? (b / r).toFixed(x.value.contract) : 0;
        return;
      }
      if (u.property === "usedMete" || u.property === "totalAmount") {
        const y = a.map((r) => Number(r[u.property]));
        let d = 0;
        y.every((r) => isNaN(r)) || (d = y.reduce((r, b) => {
          const o = Number(b);
          return isNaN(o) ? r : r + b;
        }, 0)), u.property === "totalAmount" ? l[e] = d.toFixed(x.value.contract) : l[e] = d.toFixed(2);
      }
    }), l;
  }
  E.HOOK.beforeToQuery = () => {
  }, E.HOOK.handleRefresh = (A, m) => {
    m.data.content = m.data.content.map((a) => (a.averageValue = a.totalAmount && a.usedMete ? (a.totalAmount / a.usedMete).toFixed(x.value.contract) : 0, a));
  };
  const { maxHeight: T } = P({ extraBox: [".head-container"], paginate: true });
  return (A, m) => {
    const a = L, l = R("common-table"), u = B;
    return i(), q("div", J, [f("div", W, [g(j)]), D((i(), h(l, { ref_key: "tableRef", ref: k, data: t(s).data, "empty-text": t(s).emptyText, "max-height": t(T), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": S }, { default: c(() => [t(_).visible("month") ? (i(), h(a, { key: 0, prop: "month", label: "月份", align: "center", width: "100" }, { default: c(({ row: e }) => [f("span", null, w(e.month) + "月", 1)]), _: 1 })) : v("", true), t(_).visible("usedMete") ? (i(), h(a, { align: "center", key: "usedMete", prop: "usedMete", "show-overflow-tooltip": true, label: t(s).query.type === t(M).ELECTRIC_COST.V ? "用电度数（kw/h）" : "用水量（吨）" }, { default: c(({ row: e }) => [f("span", null, w(e.usedMete), 1)]), _: 1 }, 8, ["label"])) : v("", true), t(_).visible("totalAmount") ? (i(), h(a, { align: "center", key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: t(s).query.type === t(M).ELECTRIC_COST.V ? "电费总额（元）" : "水费总额（元）" }, { default: c(({ row: e }) => [f("span", null, w(e.totalAmount), 1)]), _: 1 }, 8, ["label"])) : v("", true), t(_).visible("averageValue") ? (i(), h(a, { align: "center", key: "averageValue", prop: "averageValue", "show-overflow-tooltip": true, label: t(s).query.type === t(M).ELECTRIC_COST.V ? "平均电费（元/kw/h）" : "平均水费（元/吨）" }, { default: c(({ row: e }) => [f("span", null, w(e.averageValue), 1)]), _: 1 }, 8, ["label"])) : v("", true), g(a, { align: "center", label: "操作", width: "200px" }, { default: c(({ row: e }) => [g(t(I), { data: e, permission: t(N) }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[u, t(s).loading]]), g(K, { query: t(s).query }, null, 8, ["query"])]);
  };
} };
export {
  ae as default
};
