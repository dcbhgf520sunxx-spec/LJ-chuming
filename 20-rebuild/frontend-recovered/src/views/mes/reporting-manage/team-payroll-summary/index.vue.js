import { ref as g } from "vue";
import { provide as S } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as t } from "vue";
import { unref as r } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as v } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as s } from "vue";
import { withModifiers as P } from "vue";
import { createCommentVNode as T } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as I } from "element-plus";
import { c as Q } from "../../../../modules/team-payroll-summary-ec5d2034.js";
import { x as W, ql as x, o as q, p6 as B, bV as C, G as E, P as H } from "../../../../shared/runtime.js";
import M from "./module/header.vue.js";
import U from "./module/detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const A = { class: "app-container" }, G = { class: "head-container" }, L = { key: 0 }, O = { key: 1 }, $ = { key: 0 }, z = { key: 1 }, F = { key: 0 }, K = { key: 1 }, se = { __name: "index", setup(J) {
  const h = g(), { crud: d, columns: X, CRUD: N } = W({ title: "班组工资汇总", permission: { ...x }, crudApi: { ...Q }, sort: [], hasPagination: true }, h), _ = g(false), y = g(), { maxHeight: j } = q({ paginate: true });
  S("query", d.query), N.HOOK.handleRefresh = async (f, { data: p }) => {
    p.content = p.content.map((o) => {
      var u, m, w, e, a, b;
      return o.workshopId = ((u = o.workshop) == null ? void 0 : u.id) || void 0, o.projectId = ((m = o.project) == null ? void 0 : m.id) || void 0, o.teamId = ((w = o.team) == null ? void 0 : w.id) || void 0, o.teamName = ((e = o.team) == null ? void 0 : e.name) || void 0, o.productId = ((a = o.product) == null ? void 0 : a.id) || void 0, o.processId = ((b = o.process) == null ? void 0 : b.id) || void 0, o;
    });
  };
  function R(f) {
    _.value = true, y.value = f;
  }
  return (f, p) => {
    const o = V, u = k("common-button"), m = k("common-table"), w = I;
    return n(), l("div", A, [c("div", G, [t(r(M))]), D((n(), v(m, { ref_key: "tableRef", ref: h, data: r(d).data, "empty-text": r(d).emptyText, "max-height": r(j), style: { width: "100%" }, "row-key": "id" }, { default: i(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { key: "workshop", prop: "workshop", "show-overflow-tooltip": "", label: "车间", align: "center" }, { default: i((e) => {
      var a;
      return [c("span", null, s(((a = e.row.workshop) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), t(o, { key: "projectSerialNumber", prop: "projectSerialNumber", "show-overflow-tooltip": "", label: "类别", align: "center" }, { default: i((e) => [c("span", null, s(r(B).VL[e.row.productTypeEnum] || "-"), 1)]), _: 1 }), t(o, { key: "projectSerialNumber", prop: "projectSerialNumber", "show-overflow-tooltip": "", label: "工序", align: "center" }, { default: i((e) => {
      var a;
      return [c("span", null, s(((a = e.row.process) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), t(o, { key: "projectSerialNumber", prop: "projectSerialNumber", "show-overflow-tooltip": "", label: "班组", align: "center" }, { default: i((e) => {
      var a;
      return [c("span", null, s(((a = e.row.team) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 }), t(o, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center" }), t(o, { key: "productionQuantity", prop: "productionQuantity", "show-overflow-tooltip": "", label: "产量", align: "center" }, { default: i((e) => [e.row.productionQuantity || e.row.productionQuantity === 0 ? (n(), l("span", L, s(e.row.productionQuantity.toFixed(5)), 1)) : (n(), l("span", O, "-"))]), _: 1 }), t(o, { key: "wage", prop: "wage", "show-overflow-tooltip": "", label: "工价（元）", align: "center" }, { default: i((e) => [e.row.wage || e.row.wage === 0 ? (n(), l("span", $, s(r(C)(e.row.wage, 2)), 1)) : (n(), l("span", z, "-"))]), _: 1 }), t(o, { key: "averageWage", prop: "averageWage", "show-overflow-tooltip": "", label: "平均工价（元/吨）", align: "center" }, { default: i((e) => [e.row.averageWage || e.row.averageWage === 0 ? (n(), l("span", F, s(r(C)(e.row.averageWage, 2)), 1)) : (n(), l("span", K, "-"))]), _: 1 }), t(o, { label: "操作", align: "center", fixed: "right" }, { default: i((e) => [r(E)(r(x).details) ? (n(), v(u, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: P((a) => R(e.row), ["stop"]) }, null, 8, ["onClick"])) : T("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[w, r(d).loading]]), t(r(H)), t(r(U), { visible: _.value, "onUpdate:visible": p[0] || (p[0] = (e) => _.value = e), currentRow: y.value }, null, 8, ["visible", "currentRow"])]);
  };
} };
export {
  se as default
};
