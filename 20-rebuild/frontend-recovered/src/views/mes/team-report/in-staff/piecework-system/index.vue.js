import { ref as d } from "vue";
import { provide as N } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as P } from "vue";
import { createVNode as u } from "vue";
import { unref as s } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as f } from "vue";
import { Fragment as q } from "vue";
import { renderList as A } from "vue";
import { toDisplayString as E } from "vue";
import { createTextVNode as H } from "vue";
import { createCommentVNode as I } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as O } from "../../../../../modules/piecework-system-3800a6fe.js";
import { aY as U, t as j, x as K, o as G, a9 as W, G as Y, V as J } from "../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../modules/index-3b2628f3.js";
import X from "./module/header.vue.js";
import Z from "./module/detail.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "./module/summary-detail.vue.js";
import "../../../../../modules/index-490fd9d7.js";
const ee = { class: "app-container" }, te = { class: "head-container" }, ae = ["onClick"], ue = { __name: "index", props: { organizationType: { type: Boolean, default: U.IN_STAFF.V } }, setup(V) {
  const { decimalPrecision: z } = j(), g = V, R = { add: false, edit: false, del: false, download: false }, b = { get: [] }, v = d(), { crud: l, columns: S, CRUD: w } = K({ title: "编内-计件制", sort: [], permission: { ...b }, optShow: { ...R }, crudApi: { ...O }, hasPagination: false }, v), { maxHeight: B } = G({ paginate: false });
  N("query", l.query), N("organizationType", g.organizationType);
  const k = d([]);
  w.HOOK.beforeRefresh = () => {
    l.query.organizationType = g.organizationType;
  }, w.HOOK.handleRefresh = (c, e) => {
    var n;
    k.value = e.data.content.length && ((n = e.data.content[0]) == null ? void 0 : n.processPrice), e.data.content = e.data.content.map((t, r) => (t.rowId = r + "" + Math.random(), t.processMap = W(t.processPrice, "id"), t));
  };
  function F(c) {
    const { columns: e, data: n } = c, t = [];
    return e.forEach((r, i) => {
      if (i === 0) {
        t[i] = "合计";
        return;
      }
      if (r.property === "price") {
        const a = n.map((o) => Number(o[r.property]));
        a.every((o) => isNaN(o)) || (t[i] = a.reduce((o, m) => {
          const C = Number(m);
          return isNaN(C) ? o : o + m;
        }, 0), t[i] = t[i].toFixed(z.value.mes));
      }
    }), t;
  }
  const _ = d(false), h = d({});
  function x(c, e) {
    h.value = J(c), e && (h.value.processId = e), _.value = true;
  }
  return (c, e) => {
    const n = L, t = T("common-button"), r = T("common-table"), i = M;
    return p(), D("div", ee, [P("div", te, [u(s(X))]), $((p(), y(r, { ref_key: "tableRef", ref: v, data: s(l).data, "empty-text": s(l).emptyText, "max-height": s(B), "show-summary": "", "row-key": "rowId", "summary-method": F, style: { width: "100%" } }, { default: f(() => [u(n, { label: "序号", type: "index", align: "center", width: "60" }), u(s(Q), { columns: s(S), showFactory: "", showWorkshop: "", showProductionLine: "" }, null, 8, ["columns"]), (p(true), D(q, null, A(k.value, (a) => (p(), y(n, { key: a.id, align: "center", label: a.name }, { default: f(({ row: o }) => {
      var m;
      return [P("span", { style: { cursor: "pointer" }, onClick: (C) => x(o, a.id) }, E((m = o.processMap[a.id]) == null ? void 0 : m.price), 9, ae)];
    }), _: 2 }, 1032, ["label"]))), 128)), s(Y)([...b.detail]) ? (p(), y(n, { key: 0, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: f(({ row: a }) => [u(t, { type: "primary", size: "default", onClick: (o) => x(a) }, { default: f(() => e[1] || (e[1] = [H("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : I("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[i, s(l).loading]]), u(s(Z), { visible: _.value, "onUpdate:visible": e[0] || (e[0] = (a) => _.value = a), info: h.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  ue as default
};
