import { ref as c } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as w } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as t } from "vue";
import { createTextVNode as m } from "vue";
import { Fragment as L } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElTag as j } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as I, g as P } from "./list-sorting/module/summary-list.vue.js";
import { _ as U, x as z, o as A, p as D, sY as S, P as q } from "../../../shared/runtime.js";
import F from "./module/header.vue.js";
import M from "./list-sorting/index.vue.js";
import "./list-sorting/module/header.vue.js";
import "../../../modules/index-8356a01a.js";
const Y = { class: "app-container wrap" }, G = { class: "wrap-left" }, J = { class: "head-container" }, K = { class: "wrap-right" }, O = { class: "detailed-header" }, Q = { __name: "index", setup(X) {
  const f = c(), d = c(), T = c([]), h = c(false), { crud: _, CRUD: Z } = z({ title: "生产排期", sort: [], crudApi: { ...I }, hasPagination: true }, f), { maxHeight: b } = A({ paginate: true });
  function R(s) {
    d.value = s, s && B(s == null ? void 0 : s.projectId);
  }
  function V() {
    h.value = true;
  }
  async function B(s) {
    try {
      await P({ projectId: s });
    } catch (i) {
      console.log(i);
    }
  }
  return (s, i) => {
    var v;
    const r = W, g = j, y = x("common-table"), E = x("common-button"), N = H;
    return p(), k("div", Y, [l("div", G, [l("div", J, [a(n(F))]), C((p(), w(y, { ref_key: "tableRef", ref: f, data: n(_).data, "empty-text": n(_).emptyText, "highlight-current-row": "", "max-height": n(b), style: { width: "100%" }, onCurrentChange: R }, { default: o(() => [a(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "项目", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 }), a(r, { key: "startDate", prop: "startDate", "show-overflow-tooltip": "", label: "开始~结束日期", align: "center" }, { default: o((e) => [l("span", null, t(n(D)(e.row.startDate, "{y}-{m}-{d}")) + " ~ " + t(n(D)(e.row.endDate, "{y}-{m}-{d}")), 1)]), _: 1 }), a(r, { key: "duration", prop: "duration", "show-overflow-tooltip": "", label: "工期", align: "center", width: "80px" }, { default: o((e) => [l("span", null, t(e.row.duration) + " 天", 1)]), _: 1 }), a(r, { key: "listTotalWeight", prop: "listTotalWeight", "show-overflow-tooltip": "", label: "清单总量（吨）", align: "center", width: "120px" }, { default: o((e) => [l("span", null, t(e.row.listTotalWeight), 1)]), _: 1 }), a(r, { key: "schedulingStatus", prop: "schedulingStatus", label: "状态", align: "center", width: "80px" }, { default: o((e) => {
      var u;
      return [a(g, { type: (u = n(S).V[e.row.schedulingStatus]) == null ? void 0 : u.T }, { default: o(() => [m(t(n(S).VL[e.row.schedulingStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, n(_).loading]]), a(n(q))]), l("div", K, [(v = d.value) != null && v.projectId ? (p(), k(L, { key: 1 }, [l("div", O, [a(E, { type: "success", size: "default", onClick: V }, { default: o(() => i[2] || (i[2] = [m("清单分拣")])), _: 1, __: [2] }), a(g, { style: { "margin-left": "10px" } }, { default: o(() => {
      var e, u;
      return [m("项目： " + t((e = d.value) == null ? void 0 : e.serialNumber) + " - " + t((u = d.value) == null ? void 0 : u.shortName), 1)];
    }), _: 1 })]), C((p(), w(y, { ref: "detailedTableRef", data: T.value, "max-height": n(b), style: { width: "100%" } }, { default: o(() => [a(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "车间", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "排期数量（件）", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "排期量（吨）", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "占比", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 }), a(r, { key: "shortName", prop: "shortName", "show-overflow-tooltip": "", label: "操作", align: "center" }, { default: o((e) => [l("span", null, t(e.row.serialNumber) + " - " + t(e.row.shortName), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[N, s.detailedLoading]]), a(n(M), { visible: h.value, "onUpdate:visible": i[0] || (i[0] = (e) => h.value = e), currentRow: d.value }, null, 8, ["visible", "currentRow"])], 64)) : (p(), w(g, { key: 0, type: "info", size: "large" }, { default: o(() => i[1] || (i[1] = [m(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [1] }))])]);
  };
} }, ne = U(Q, [["__scopeId", "data-v-78ecaf4b"]]);
export {
  ne as default
};
