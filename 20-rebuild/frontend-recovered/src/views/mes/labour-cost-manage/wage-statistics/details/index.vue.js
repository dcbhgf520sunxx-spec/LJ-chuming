import { ref as u } from "vue";
import { inject as z } from "vue";
import { computed as q } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as h } from "vue";
import { unref as e } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as Q } from "vue";
import { Fragment as G } from "vue";
import { ElTag as K } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as X, d as Z, a as ee, p as te, g as ae } from "./module/production-detail.vue.js";
import { _ as ne, o as oe, x as le, nW as v, D as S, G as j, L, aY as re, P as se } from "../../../../../shared/runtime.js";
const ie = { class: "datails-header" }, ce = ["onClick"], de = ["onClick"], ue = { __name: "index", props: { currentRow: { type: Object, default: () => {
} } }, setup(_) {
  var T;
  const c = _, D = u(), p = z("query"), k = (T = c.currentRow) == null ? void 0 : T.yearMonth.lastIndexOf("-"), M = u(), f = u(false), x = u(), R = u(), C = u(), { maxHeight: O } = oe({ paginate: true }), V = q(() => (o.selections.forEach((l) => {
    l.startDate = x.value, l.endDate = R.value;
  }), o.selections)), { crud: o, CRUD: A } = le({ title: "工价统计-详情", permission: { ...v }, sort: [], crudApi: { ...X }, hasPagination: true }, D), E = q(() => [["lastMonthMoney", ["to-thousand", S.YUAN]], ["money", ["to-thousand", S.YUAN]]]);
  function N(l, r) {
    M.value = l, C.value = r, f.value = true;
  }
  $(() => {
    var l;
    return (l = c.currentRow) == null ? void 0 : l.yearMonth;
  }, (l) => {
    l && o.toQuery();
  }), A.HOOK.beforeToQuery = () => {
    var r, i;
    const l = (i = c.currentRow) == null ? void 0 : i.yearMonth.substring(k + 1, (r = c.currentRow) == null ? void 0 : r.yearMonth.length);
    o.query.year = p.year, o.query.month = l, o.query.workshopId = p.workshopId, o.query.projectId = p.projectId;
  };
  async function U() {
    var i, t;
    const r = { month: (t = c.currentRow) == null ? void 0 : t.yearMonth.substring(k + 1, (i = c.currentRow) == null ? void 0 : i.yearMonth.length), year: p.year, projectId: p.projectId };
    try {
      const d = await ae(r);
      x.value = d.startDate, R.value = d.endDate;
    } catch (d) {
      console.log(d);
    }
  }
  return U(), (l, r) => {
    var P;
    const i = K, t = W, d = I("table-cell-tag"), Y = I("common-table"), B = J;
    return y(), F(G, null, [m("div", ie, [n(i, { size: "large" }, { default: s(() => {
      var a;
      return [w(" 统计日期： " + h((a = _.currentRow) == null ? void 0 : a.yearMonth), 1)];
    }), _: 1 }), m("div", null, [e(j)(e(v).downloadSummary) ? (y(), g(L, { key: 0, fn: e(Z), params: e(o).query, class: "filter-item" }, { default: s(() => r[1] || (r[1] = [w(" 下载汇总表 ")])), _: 1, __: [1] }, 8, ["fn", "params"])) : b("", true), e(j)(e(v).downloadDetail) ? (y(), g(L, { key: 1, fn: e(ee), params: V.value, class: "filter-item", disabled: e(o).selections.length === 0 }, { default: s(() => r[2] || (r[2] = [w(" 批量下载生产明细 ")])), _: 1, __: [2] }, 8, ["fn", "params", "disabled"])) : b("", true)])]), m("div", null, [Q((y(), g(Y, { ref_key: "tableRef", ref: D, data: e(o).data, "data-format": E.value, "empty-text": e(o).emptyText, "max-height": e(O), onSelectionChange: e(o).selectionChangeHandler }, { default: s(() => [n(t, { type: "selection", width: "55", align: "center" }), n(t, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(t, { label: "车间", prop: "workshopName", key: "workshopName", align: "center" }), n(t, { label: "工序", prop: "processName", key: "processName", align: "center" }), n(t, { label: "班组", prop: "teamLeaderName", key: "teamLeaderName", align: "center" }, { default: s((a) => [a.row.teamOrganizationType !== null ? (y(), g(d, { key: 0, name: e(re).VL[a.row.teamOrganizationType], offset: 15 }, null, 8, ["name"])) : b("", true), m("span", null, h(a.row.teamLeaderName), 1)]), _: 1 }), n(t, { label: "上月数据", align: "center" }, { default: s(() => [n(t, { label: "产量（吨）", prop: "lastMonthYield", key: "lastMonthYield", align: "center" }), n(t, { label: "金额（元）", prop: "lastMonthMoney", key: "lastMonthMoney", align: "center" }, { default: s((a) => [m("div", { onClick: (H) => N(a.row, "lastMonth"), class: "highlight" }, h(a.row.lastMonthMoney || "-"), 9, ce)]), _: 1 })]), _: 1 }), n(t, { label: "本月数据", align: "center" }, { default: s(() => [n(t, { label: "产量（吨）", prop: "yield", key: "yield", align: "center" }), n(t, { label: "金额（元）", prop: "money", key: "money", align: "center" }, { default: s((a) => [m("div", { onClick: (H) => N(a.row, ""), class: "highlight" }, h(a.row.money || "-"), 9, de)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[B, e(o).loading]]), n(e(se)), n(e(te), { visible: f.value, "onUpdate:visible": r[0] || (r[0] = (a) => f.value = a), rowData: M.value, yearMonth: (P = _.currentRow) == null ? void 0 : P.yearMonth, openDetailType: C.value }, null, 8, ["visible", "rowData", "yearMonth", "openDetailType"])])], 64);
  };
} }, he = ne(ue, [["__scopeId", "data-v-4cee3d89"]]);
export {
  he as default
};
