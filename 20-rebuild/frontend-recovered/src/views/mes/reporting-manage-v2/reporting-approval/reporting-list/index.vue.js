import { ref as v } from "vue";
import { provide as M } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as e } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as w } from "vue";
import { withCtx as p } from "vue";
import { Fragment as z } from "vue";
import { renderList as B } from "vue";
import { normalizeClass as D } from "vue";
import { toDisplayString as i } from "vue";
import { createTextVNode as f } from "vue";
import { normalizeStyle as S } from "vue";
import { createCommentVNode as j } from "vue";
import { ElAvatar as Q } from "element-plus";
import { ElTag as U } from "element-plus";
import { ElCard as W } from "element-plus";
import { ElCol as F } from "element-plus";
import { ElRow as G } from "element-plus";
import { vLoading as Y } from "element-plus";
import { c as A, g as J, m as X } from "./module/header.vue.js";
import { _ as Z, qc as V, x as ee, qd as te, o as se, a3 as O } from "../../../../../shared/runtime.js";
import "../../../../../modules/reporting-approval-2b65eecd.js";
import "../../../../../modules/index-c07af747.js";
import "./module/project-header-time.vue.js";
const ae = { class: "reporting-list" }, ne = { class: "header-container" }, oe = { key: 0 }, re = { style: { display: "flex", "align-items": "center" } }, ce = { class: "card-content" }, ie = { class: "card-content-item" }, de = { class: "minor" }, _e = { class: "major" }, le = { class: "card-content-item" }, pe = { class: "card-content-item" }, ue = { class: "minor" }, me = { class: "major" }, ye = { key: 0 }, he = { key: 1 }, ge = { key: 1 }, ve = { __name: "index", emits: ["currentChange"], setup(fe, { expose: b, emit: H }) {
  const I = H, K = v(null), x = v(), y = v(V.REAL_TIME_WORK_REPORTING.V), { crud: r, CRUD: C } = ee({ title: "报工管理-未审核列表", permission: { ...te }, dataPath: "", sort: [], crudApi: { ...A }, hasPagination: false, queryOnPresenterCreated: false }, K);
  C.HOOK.beforeToQuery = async (t) => {
    t.crudApi.get = y.value === V.REAL_TIME_WORK_REPORTING.V ? A.get : J;
  }, C.HOOK.handleRefresh = (t, d) => {
    h(), d.data = d.data.map((s) => {
      var _, u, m;
      return s.rowKey = `${((_ = s.workshop) == null ? void 0 : _.id) ?? ""}_${((u = s.team) == null ? void 0 : u.id) ?? ""}_${s.productTypeEnum ?? ""}_${((m = s.process) == null ? void 0 : m.id) ?? ""}_${s.reportQuantity ?? ""}`, s;
    });
  };
  const { maxHeight: L } = se({ extraBox: ".header-container", paginate: true, extraHeight: 24 });
  function h(t) {
    x.value = (t == null ? void 0 : t.rowKey) || void 0, I("currentChange", t, r.query);
  }
  function N(t) {
    y.value = t;
  }
  return M("handleCurrentChange", h), b({ viewType: y }), (t, d) => {
    var E, T;
    const s = Q, _ = U, u = W, m = F, P = G, q = Y;
    return o(), c("div", ae, [e("div", ne, [l(n(X), { onViewTypeChange: N })]), (E = n(r).query) != null && E.date ? $((o(), c("div", oe, [e("div", { class: "card-list-scroll", style: S({ maxHeight: n(L) + "px" }) }, [(T = n(r).data) != null && T.length ? (o(), w(P, { key: 0, gutter: 5, style: { "justify-content": "center" } }, { default: p(() => [(o(true), c(z, null, B(n(r).data, (a) => (o(), w(m, { span: 24, key: a.id, style: { "margin-bottom": "4px" } }, { default: p(() => [l(u, { shadow: "never", class: D({ "is-card-active": x.value === a.rowKey }), onClick: (g) => h(a) }, { default: p(() => {
      var g, R, k;
      return [e("div", re, [l(s, { size: "small", icon: "ElIconUserFilled" }), e("div", ce, [e("div", ie, [e("p", de, i((g = a.workshop) == null ? void 0 : g.name), 1), e("p", _e, i((R = a.team) == null ? void 0 : R.name), 1)]), e("div", le, [l(_, { type: "success", effect: "plain", size: "default", round: "", style: { width: "60px" } }, { default: p(() => [f(i(n(O).VL[a.productTypeEnum] || "-"), 1)]), _: 2 }, 1024)]), e("div", pe, [e("p", ue, "工序：" + i((k = a.process) == null ? void 0 : k.name), 1), e("p", me, [d[0] || (d[0] = f(" 上报： ")), a.productTypeEnum === n(O).MACHINE_PART.V ? (o(), c("span", ye, "一批")) : (o(), c("span", he, i(a.reportQuantity), 1))])])])])];
    }), _: 2 }, 1032, ["class", "onClick"])]), _: 2 }, 1024))), 128))]), _: 1 })) : (o(), c("div", ge, [l(_, { type: "warning", size: "large" }, { default: p(() => [f(" * " + i(n(r).emptyText), 1)]), _: 1 })]))], 4)])), [[q, n(r).loading]]) : j("", true)]);
  };
} }, we = Z(ve, [["__scopeId", "data-v-d4973bc0"]]);
export {
  we as default
};
