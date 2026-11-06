import { ref as s } from "vue";
import { provide as V } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as E } from "vue";
import { unref as o } from "vue";
import { createBlock as H } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as U } from "vue";
import { withModifiers as y } from "vue";
import { normalizeStyle as _ } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElTag as $ } from "element-plus";
import { vLoading as j } from "element-plus";
import { x as q, ss as L, o as M, p as A, st as b, P as I } from "../../../../shared/runtime.js";
import { c as O } from "../../../../modules/loss-statistics-d681f3ee.js";
import Q from "./module/receive-detail.vue.js";
import z from "./module/production-detail.vue.js";
import K from "./module/header.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const F = { class: "app-container" }, G = { class: "head-container" }, J = ["onClick"], X = ["onClick"], ne = { __name: "index", setup(Y) {
  const k = { add: false, edit: false, del: false, download: false }, f = s(), m = s(), d = s(false), u = s(false), g = s({}), v = s({}), { crud: p, CRUD: w } = q({ title: "损耗统计", optShow: { ...k }, permission: { ...L }, crudApi: { ...O }, hasPagination: true }, f), { maxHeight: R } = M({ paginate: true });
  V("query", p.query), w.HOOK.beforeRefresh = (c) => {
    var l;
    (l = m.value) == null || l.fetchSummary();
  };
  function x(c) {
    g.value = c, d.value = true;
  }
  function P(c) {
    v.value = c, u.value = true;
  }
  return (c, l) => {
    const a = W, C = $, T = N("common-table"), D = j;
    return h(), B("div", F, [n("div", G, [t(K, { ref_key: "headerRef", ref: m }, null, 512)]), E((h(), H(T, { ref_key: "tableRef", ref: f, data: o(p).data, "empty-text": o(p).emptyText, "max-height": o(R), "row-key": "id", style: { width: "100%" } }, { default: i(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { label: "立项日期", prop: "createTime", key: "createTime", align: "center" }, { default: i((e) => [n("div", null, r(e.row.createTime ? o(A)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(a, { "show-overflow-tooltip": true, label: "生产状态", key: "status", prop: "status", width: "100px", align: "center" }, { default: i(({ row: e }) => [t(C, { effect: "plain", type: o(b).V[e.status].T }, { default: i(() => [U(r(o(b).VL[e.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), t(a, { "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", key: "projectName", align: "center", "min-width": "160px" }), t(a, { label: "清单量（吨）", prop: "listQuantity", key: "listQuantity", align: "center", width: "100" }), t(a, { label: "累计生产（吨）", prop: "totalProduction", key: "totalProduction", align: "center", width: "120" }, { default: i(({ row: e }) => [n("span", { onClick: y((S) => P(e), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, r(e.totalProduction), 9, J)]), _: 1 }), t(a, { label: "钢板领用量（吨）", prop: "steelPicking", key: "steelPicking", align: "center", width: "120" }), t(a, { label: "型材领用量（吨）", prop: "sectionPicking", key: "sectionPicking", align: "center", width: "120" }), t(a, { label: "钢板退库量（吨）", prop: "steelPlateReturn", key: "steelPlateReturn", align: "center", width: "120" }), t(a, { label: "型材退库量（吨）", prop: "sectionReturn", key: "sectionReturn", align: "center", width: "120" }), t(a, { label: "实际领用总量（吨）", prop: "totalReceive", key: "totalReceive", align: "center", width: "130" }, { default: i(({ row: e }) => [n("span", { onClick: y((S) => x(e), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, r(e.totalReceive), 9, X)]), _: 1 }), t(a, { label: "实际损耗量（吨）", prop: "totalWastage", key: "totalWastage", align: "center", width: "120" }, { default: i(({ row: e }) => [n("span", { style: _(`color: ${e.totalWastage >= 0 ? "#67c23a" : "#f56c6c"}`) }, r(e.totalWastage), 5)]), _: 1 }), t(a, { label: "损耗率", prop: "wastageRate", key: "wastageRate", align: "center", width: "120" }, { default: i(({ row: e }) => [n("span", { style: _(`color: ${e.wastageRate >= 0 ? "#67c23a" : "#f56c6c"}`) }, r(e.wastageRate ? e.wastageRate + "%" : "-"), 5)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, o(p).loading]]), t(o(I)), t(Q, { visible: d.value, "onUpdate:visible": l[0] || (l[0] = (e) => d.value = e), info: g.value }, null, 8, ["visible", "info"]), t(z, { visible: u.value, "onUpdate:visible": l[1] || (l[1] = (e) => u.value = e), info: v.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  ne as default
};
