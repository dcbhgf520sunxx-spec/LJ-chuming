import { ref as g } from "vue";
import { watch as R } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as D } from "vue";
import { withCtx as d } from "vue";
import { toDisplayString as n } from "vue";
import { withModifiers as y } from "vue";
import { normalizeStyle as V } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElDivider as $ } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as H, _ as B } from "./module/detail.vue.js";
import { _ as E, m as S, x as W, o as U, tQ as _, c as h, D as f, G } from "../../../../shared/runtime.js";
import { F as b } from "../../../../modules/project-19a12d6b.js";
import K from "./module/header.vue.js";
const N = { class: "app-container" }, Q = { style: { display: "flex" } }, z = { style: { width: "38%" } }, L = ["onClick"], J = { key: 0 }, X = { key: 1 }, Y = ["onClick"], Z = { key: 0 }, ee = { key: 1 }, te = ["onClick"], oe = { key: 0 }, ae = { key: 1 }, se = ["onClick"], ie = { key: 0 }, ne = { key: 1 }, le = { __name: "index", setup(re) {
  const { globalProjectId: T, globalProject: ce } = S(["globalProjectId", "globalProject"]), w = { add: false, edit: false, del: false, download: false }, M = g(), m = g(), x = g({}), { crud: o, CRUD: C } = W({ title: "收发存报表", sort: ["id.desc"], permission: { ...b }, optShow: { ...w }, requiredQuery: ["projectId"], crudApi: { ...H }, hasPagination: false }, M);
  R([() => o.query.productType, () => o.query.year, () => o.query.projectId], (p) => {
    p && (m.value = void 0);
  }), C.HOOK.beforeRefresh = () => (o.query.projectId = T.value, !!o.query.projectId), C.HOOK.handleRefresh = (p, r) => {
    r.data.content = r == null ? void 0 : r.data;
  };
  const { maxHeight: v } = U({ extraBox: [".head-container"], paginate: true });
  function u(p, r) {
    G(b.detail) && (m.value = r, x.value = p);
  }
  return (p, r) => {
    const c = P, q = j("common-table"), I = $, A = F;
    return a(), s("div", N, [l("div", Q, [l("div", z, [l("div", null, [i(e(K), { projectId: e(T) }, null, 8, ["projectId"]), O((a(), D(q, { ref_key: "tableRef", ref: M, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(v), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: d(() => [i(c, { key: "date", prop: "date", label: "月份", align: "center", "show-overflow-tooltip": true }), i(c, { key: "unit", prop: "unit", label: "单位", align: "center", "show-overflow-tooltip": true }, { default: d(() => [l("span", null, n(e(o).query.productType === e(_).ARTIFACT.V ? "吨" : "平方米"), 1)]), _: 1 }), i(c, { key: "initMete", prop: "initMete", label: "期初库存", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [l("div", { class: "tc-primary", style: { cursor: "pointer" }, onClick: y((k) => u(t, "begin"), ["stop"]) }, [e(o).query.productType === e(_).ARTIFACT.V ? (a(), s("span", J, n(t.initMete ? e(h)(t.initMete, "kg", "t", e(f).COM_WT__T) : 0), 1)) : (a(), s("span", X, n(t.initMete || 0), 1))], 8, L)]), _: 1 }), i(c, { key: "receivedMete", prop: "receivedMete", label: "入库量", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [l("div", { class: "tc-primary", style: { cursor: "pointer" }, onClick: y((k) => u(t, "inbound"), ["stop"]) }, [e(o).query.productType === e(_).ARTIFACT.V ? (a(), s("span", Z, n(t.receivedMete ? e(h)(t.receivedMete, "kg", "t", e(f).COM_WT__T) : 0), 1)) : (a(), s("span", ee, n(t.receivedMete || 0), 1))], 8, Y)]), _: 1 }), i(c, { key: "installMete", prop: "installMete", label: "出库量", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [l("div", { class: "tc-primary", style: { cursor: "pointer" }, onClick: y((k) => u(t, "outbound"), ["stop"]) }, [e(o).query.productType === e(_).ARTIFACT.V ? (a(), s("span", oe, n(t.installMete ? e(h)(t.installMete, "kg", "t", e(f).COM_WT__T) : 0), 1)) : (a(), s("span", ae, n(t.installMete || 0), 1))], 8, te)]), _: 1 }), i(c, { key: "endMete", prop: "endMete", label: "期末库存", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [l("div", { class: "tc-primary", style: { cursor: "pointer" }, onClick: y((k) => u(t, "end"), ["stop"]) }, [e(o).query.productType === e(_).ARTIFACT.V ? (a(), s("span", ie, n(t.endMete ? e(h)(t.endMete, "kg", "t", e(f).COM_WT__T) : 0), 1)) : (a(), s("span", ne, n(t.endMete || 0), 1))], 8, se)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, e(o).loading]])])]), i(I, { direction: "vertical", style: V(`height: ${e(v) + 40}px`) }, null, 8, ["style"]), i(B, { style: { flex: "1", width: "61%" }, maxHeight: e(v), showType: m.value, "detail-data": x.value, queryVO: e(o).query }, null, 8, ["maxHeight", "showType", "detail-data", "queryVO"])])]);
  };
} }, he = E(le, [["__scopeId", "data-v-f6716081"]]);
export {
  he as default
};
