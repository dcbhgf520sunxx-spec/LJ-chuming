import { ref as _ } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as H } from "vue";
import { unref as e } from "vue";
import { createBlock as u } from "vue";
import { withCtx as g } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as h, t as Q, x as V, o as G, an as I } from "../../../../../shared/runtime.js";
import { w as q } from "../../../../../modules/contract-9b18cc88.js";
import K from "./module/header.vue.js";
import $ from "./module/form.vue.js";
function j(o) {
  return h({ module: "", url: "/api/contract/gas-summary", method: "get", params: o });
}
function z(o) {
  return h({ module: "", url: "/api/contract/gas-summary", method: "post", data: [o] });
}
function J(o) {
  return h({ module: "", url: "/api/contract/gas-summary", method: "post", data: [o] });
}
function W(o) {
  return h({ module: "", url: "/api/contract/gas-summary", method: "delete", data: o });
}
function X(o) {
  return h({ module: "", url: "/api/contract/gas-summary/list-gas-class", method: "get", params: o });
}
const Y = { get: j, add: z, edit: J, del: W }, Z = { class: "app-container" }, ee = { class: "head-container" }, re = { __name: "index", setup(o) {
  const { decimalPrecision: x } = Q(), U = _(), v = _([]), k = _(), A = _(), M = { add: true, edit: false, del: false, download: false }, { crud: s, CRUD: C, columns: c } = V({ title: "气体统计", sort: [], optShow: { ...M }, requiredQuery: ["classifyId"], permission: { ...q }, crudApi: { ...Y }, hasPagination: false }, U);
  D();
  async function D() {
    var n, r;
    try {
      const { content: a } = await X();
      v.value = a || [], s.query.classifyId = (n = v.value[0]) == null ? void 0 : n.id, s.query.unit = (r = v.value[0]) == null ? void 0 : r.accountingUnit, s.toQuery();
    } catch (a) {
      console.log("获取气体类型失败", a);
    }
  }
  function B(n) {
    const { columns: r, data: a } = n, d = [];
    return r.forEach((m, t) => {
      if (t === 0) {
        d[t] = "合计";
        return;
      }
      if (m.property === "usedMete" || m.property === "totalAmount") {
        const i = a.map((p) => Number(p[m.property]));
        let N = 0;
        i.every((p) => isNaN(p)) || (N = i.reduce((p, P) => {
          const S = Number(P);
          return isNaN(S) ? p : p + P;
        }, 0)), m.property === "totalAmount" ? d[t] = N.toFixed(x.value.contract) : d[t] = N.toFixed(2);
      }
    }), d;
  }
  C.HOOK.beforeToQuery = (n) => {
  }, C.HOOK.handleRefresh = async (n, r) => {
  };
  const { maxHeight: O } = G({ extraBox: [".head-container"], paginate: true });
  function R(n, r) {
    k.value = n, A.value = r;
  }
  return (n, r) => {
    const a = L, d = T("common-table"), m = E;
    return l(), F("div", Z, [y("div", ee, [b(K, { onChange: R, "gas-type-list": v.value }, null, 8, ["gas-type-list"])]), H((l(), u(d, { ref_key: "tableRef", ref: U, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(O), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": B }, { default: g(() => [e(c).visible("month") ? (l(), u(a, { key: 0, prop: "month", label: "月份", align: "center", width: "100" }, { default: g(({ row: t }) => [y("span", null, w(t.month) + "月", 1)]), _: 1 })) : f("", true), e(c).visible("classifyName") ? (l(), u(a, { align: "center", key: "classifyName", prop: "classifyName", "show-overflow-tooltip": true, label: "气体种类" })) : f("", true), e(c).visible("accountingUnit") ? (l(), u(a, { align: "center", key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": true, label: "单位" })) : f("", true), e(c).visible("usedMete") ? (l(), u(a, { align: "center", key: "usedMete", prop: "usedMete", "show-overflow-tooltip": true, label: "使用量" }, { default: g(({ row: t }) => [y("span", null, w(t.usedMete), 1)]), _: 1 })) : f("", true), e(c).visible("totalAmount") ? (l(), u(a, { align: "center", key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "总额" }, { default: g(({ row: t }) => {
      var i;
      return [y("span", null, w((i = t.totalAmount) == null ? void 0 : i.toFixed(e(x).contract)), 1)];
    }), _: 1 })) : f("", true), e(c).visible("avgUnitPrice") ? (l(), u(a, { align: "center", key: "avgUnitPrice", prop: "avgUnitPrice", "show-overflow-tooltip": true, label: "平均单价" }, { default: g(({ row: t }) => {
      var i;
      return [y("span", null, w((i = t.avgUnitPrice) == null ? void 0 : i.toFixed(e(x).contract)), 1)];
    }), _: 1 })) : f("", true), b(a, { align: "center", label: "操作", width: "200px" }, { default: g((t) => [b(e(I), { data: t.row, permission: e(q) }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[m, e(s).loading]]), b($, { query: e(s).query, "accounting-unit": k.value, "gas-type": A.value, "detail-data": e(s).data }, null, 8, ["query", "accounting-unit", "gas-type", "detail-data"])]);
  };
} };
export {
  re as default
};
