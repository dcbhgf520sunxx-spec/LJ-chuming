import { useStore as L } from "vuex";
import { ref as N } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as p } from "vue";
import { withCtx as d } from "vue";
import { renderSlot as C } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as H } from "element-plus";
import { l as _, x as P, p7 as u, o as A, aU as V, a3 as R, G as B, an as K, P as U } from "../../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import j from "./module/form.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
function q(n) {
  return _({ module: "mes", url: "inspectionTeam/page", method: "get", params: n });
}
function M(n) {
  return _({ module: "mes", url: "inspectionTeam", method: "post", data: n });
}
function v(n) {
  return _({ module: "mes", url: "inspectionTeam", method: "put", data: n });
}
function G(n) {
  return _({ module: "mes", url: "inspectionTeam", method: "delete", data: { ids: n } });
}
const z = { get: q, add: M, edit: v, del: G }, F = { class: "app-container" }, J = { class: "head-container" }, se = { __name: "index", setup(n, { expose: w }) {
  const y = L(), g = N(), { crud: i, columns: f, CRUD: h } = P({ title: "质检", sort: [], permission: { ...u }, crudApi: { ...z }, queryOnPresenterCreated: false }, g), { maxHeight: k } = A({ paginate: true });
  return h.HOOK.handleRefresh = (s, r) => {
    r.data.content = r.data.content.map((e) => (e.inspectors = e.userLinkList.map((o) => ({ inspectionTeamId: o.inspectionTeamId, id: o.userId, name: o.userName })), e.inspectors && e.inspectors.length > 0 ? (e.inspectorNames = e.inspectors.map((o) => o.name).join(", "), e.inspectorIds = e.inspectors.map((o) => o.id)) : (e.inspectorNames = "", e.inspectorIds = []), e));
  }, h.HOOK.beforeSubmit = () => {
    const s = i.form.inspectors, r = [];
    for (let e = 0; e < s.length; e++) s[e] && r.push({ userId: s[e].id, userName: s[e].name, inspectionTeamId: i.form.id });
    i.form.userLinks = r;
  }, h.HOOK.afterSubmit = () => {
    y.commit("config/SET_LOADED", { key: "inspectionTeam", loaded: false });
  }, h.HOOK.afterDelete = () => {
    y.commit("config/SET_LOADED", { key: "inspectionTeam", loaded: false });
  }, w({ permission: u, toAdd: i.toAdd }), (s, r) => {
    const e = I, o = E("common-table"), T = H;
    return a(), O("div", F, [b("div", J, [p(t($), null, { teamType: d(() => [C(s.$slots, "teamType")]), _: 3 })]), D((a(), c(o, { ref_key: "tableRef", ref: g, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(k) + 42, style: { width: "100%" }, "row-key": "id", onSelectionChange: t(i).selectionChangeHandler }, { default: d(() => [p(e, { type: "selection", width: "55", align: "center" }), p(e, { label: "序号", type: "index", align: "center", width: "60" }), t(f).visible("productionLineTypeEnum") ? (a(), c(e, { key: "productionLineTypeEnum", prop: "productionLineTypeEnum", label: "生产线类型", width: "100px" }, { default: d((m) => [S(x(t(V).VL[m.row.productionLineTypeEnum]), 1)]), _: 1 })) : l("", true), t(f).visible("processName") ? (a(), c(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", width: "120px" })) : l("", true), t(f).visible("productType") ? (a(), c(e, { key: "productType", prop: "productType", label: "类型", align: "center", width: "100px" }, { default: d((m) => [b("span", null, x(t(R).VL[m.row.productType]), 1)]), _: 1 })) : l("", true), t(f).visible("inspectorNames") ? (a(), c(e, { key: "inspectorNames", prop: "inspectorNames", "show-overflow-tooltip": true, label: "质检", "min-width": "160px" })) : l("", true), t(B)([...t(u).edit, ...t(u).del]) ? (a(), c(e, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: d((m) => [p(t(K), { data: m.row, permission: t(u) }, null, 8, ["data", "permission"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[T, t(i).loading]]), p(t(U)), p(t(j))]);
  };
} };
export {
  se as default
};
