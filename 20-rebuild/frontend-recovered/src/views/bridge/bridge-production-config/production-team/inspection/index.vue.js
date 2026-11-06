import { useStore as k } from "vuex";
import { ref as N } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as c } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as D } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as L } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as f, x as H, aX as p, o as P, aD as A, G as R, an as B, P as K } from "../../../../../shared/runtime.js";
import V from "./module/header.vue.js";
import $ from "./module/form.vue.js";
import "../../../../../modules/process-select-cf7cf476.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-bridge-process-6f90ba68.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
function q(s) {
  return f({ module: "bridge", url: "inspectionTeam/page", method: "get", params: s });
}
function M(s) {
  return f({ module: "bridge", url: "inspectionTeam", method: "post", data: s });
}
function U(s) {
  return f({ module: "bridge", url: "inspectionTeam", method: "put", data: s });
}
function j(s) {
  return f({ module: "bridge", url: "inspectionTeam", method: "delete", data: { ids: s } });
}
const G = { get: q, add: M, edit: U, del: j }, X = { class: "app-container" }, v = { class: "head-container" }, se = { __name: "index", setup(s, { expose: x }) {
  const _ = k(), b = N(), { crud: i, columns: g, CRUD: m } = H({ title: "质检", sort: [], permission: { ...p }, crudApi: { ...G }, queryOnPresenterCreated: false }, b), { maxHeight: w } = P({ paginate: true });
  return m.HOOK.handleRefresh = (n, r) => {
    r.data.content = r.data.content.map((e) => (e.inspectors = e.userLinkList.map((o) => ({ inspectionTeamId: o.inspectionTeamId, id: o.userId, name: o.userName })), e.inspectors && e.inspectors.length > 0 ? (e.inspectorNames = e.inspectors.map((o) => o.name).join(", "), e.inspectorIds = e.inspectors.map((o) => o.id)) : (e.inspectorNames = "", e.inspectorIds = []), e));
  }, m.HOOK.beforeSubmit = () => {
    const n = i.form.inspectors, r = [];
    for (let e = 0; e < n.length; e++) n[e] && r.push({ userId: n[e].id, userName: n[e].name, inspectionTeamId: i.form.id });
    i.form.userLinks = r;
  }, m.HOOK.afterSubmit = () => {
    _.commit("config/SET_LOADED", { key: "bridgeInspectionTeam", loaded: false });
  }, m.HOOK.afterDelete = () => {
    _.commit("config/SET_LOADED", { key: "bridgeInspectionTeam", loaded: false });
  }, x({ permission: p, toAdd: i.toAdd }), (n, r) => {
    const e = S, o = C("common-table"), y = E;
    return a(), O("div", X, [T("div", v, [c(t(V), null, { teamType: l(() => [D(n.$slots, "teamType")]), _: 3 })]), I((a(), d(o, { ref_key: "tableRef", ref: b, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(w) + 42, style: { width: "100%" }, "row-key": "id", onSelectionChange: t(i).selectionChangeHandler }, { default: l(() => [c(e, { type: "selection", width: "55", align: "center" }), c(e, { label: "序号", type: "index", align: "center", width: "60" }), t(g).visible("processName") ? (a(), d(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", width: "120px" })) : u("", true), t(g).visible("productType") ? (a(), d(e, { key: "productType", prop: "productType", label: "类型", align: "center", width: "100px" }, { default: l((h) => [T("span", null, L(t(A).VL[h.row.productType]), 1)]), _: 1 })) : u("", true), t(g).visible("inspectorNames") ? (a(), d(e, { key: "inspectorNames", prop: "inspectorNames", "show-overflow-tooltip": true, label: "质检", "min-width": "160px" })) : u("", true), t(R)([...t(p).edit, ...t(p).del]) ? (a(), d(e, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: l((h) => [c(t(B), { data: h.row, permission: t(p) }, null, 8, ["data", "permission"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[y, t(i).loading]]), c(t(K)), c(t($))]);
  };
} };
export {
  se as default
};
