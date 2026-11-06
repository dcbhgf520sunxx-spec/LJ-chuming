import { ref as w } from "vue";
import { provide as V } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as c } from "vue";
import { unref as o } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as d } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as A } from "vue";
import { createCommentVNode as y } from "vue";
import { createTextVNode as E } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as I } from "element-plus";
import { c as O } from "../../../../../modules/piecework-system-3800a6fe.js";
import { t as j, x as L, o as z, pr as F, G } from "../../../../../shared/runtime.js";
import { _ as K } from "../../../../../modules/index-3b2628f3.js";
import W from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "./module/summary-detail.vue.js";
import "../../../../../modules/index-490fd9d7.js";
const J = { class: "app-container" }, Q = { class: "head-container" }, le = { __name: "index", setup(X) {
  const { decimalPrecision: C } = j(), D = { add: false, edit: false, del: false, download: false }, b = { get: [] }, g = w(), { crud: i, columns: f, CRUD: M } = L({ title: "编内-计件制", sort: [], permission: { ...b }, optShow: { ...D }, crudApi: { ...O }, hasPagination: false }, g), { maxHeight: P } = z({ paginate: false });
  V("query", i.query);
  const R = $(() => F({ productType: i.query.productType }));
  M.HOOK.handleRefresh = (n, a) => {
    a.data.content = a.data.content.map((t, s) => (t.rowId = s + "" + Math.random(), t.productMete = t.mate, t));
  };
  function T(n) {
    const { columns: a, data: t } = n, s = [];
    return a.forEach((u, r) => {
      if (r === 0) {
        s[r] = "合计";
        return;
      }
      if (u.property === "price") {
        const p = t.map((e) => Number(e[u.property]));
        p.every((e) => isNaN(e)) || (s[r] = p.reduce((e, h) => {
          const U = Number(h);
          return isNaN(U) ? e : e + h;
        }, 0), s[r] = s[r].toFixed(C.value.mes));
      }
    }), s;
  }
  const _ = w(false), x = w({});
  function S(n) {
    x.value = n, _.value = true;
  }
  return (n, a) => {
    const t = H, s = k("common-button"), u = k("common-table"), r = q("to-fixed"), p = I;
    return l(), B("div", J, [v("div", Q, [c(o(W))]), N((l(), d(u, { ref_key: "tableRef", ref: g, data: o(i).data, "empty-text": o(i).emptyText, "max-height": o(P), "show-summary": "", "row-key": "rowId", "summary-method": T, style: { width: "100%" } }, { default: m(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), c(o(K), { columns: o(f), showWorkshop: "", showProductionLine: "", showProcess: "", showTeam: "" }, null, 8, ["columns"]), o(f).visible("productMete") ? (l(), d(t, { key: 0, prop: "productMete", align: "center", "show-overflow-tooltip": true, label: `生产量(${R.value.unit})`, "min-width": "100px" }, { default: m((e) => [v("span", null, A(e.row.productMete), 1)]), _: 1 }, 8, ["label"])) : y("", true), o(f).visible("price") ? (l(), d(t, { key: "price", prop: "price", align: "center", "show-overflow-tooltip": true, label: "工资总额(元)", "min-width": "100px" }, { default: m((e) => [N(v("span", null, null, 512), [[r, { k: "YUAN", val: e.row.price }]])]), _: 1 })) : y("", true), o(G)([...b.detail]) ? (l(), d(t, { key: 2, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: m((e) => [c(s, { type: "primary", size: "default", onClick: (h) => S(e.row) }, { default: m(() => a[1] || (a[1] = [E("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, o(i).loading]]), c(o(Y), { visible: _.value, "onUpdate:visible": a[0] || (a[0] = (e) => _.value = e), info: x.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  le as default
};
