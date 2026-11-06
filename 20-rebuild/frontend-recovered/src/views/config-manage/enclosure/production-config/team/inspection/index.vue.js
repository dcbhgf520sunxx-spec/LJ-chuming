import { useStore as w } from "vuex";
import { ref as k } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as r } from "vue";
import { withCtx as u } from "vue";
import { renderSlot as D } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as S } from "element-plus";
import { l as d, x as H, dV as m, o as A, G as E, an as P, P as R } from "../../../../../../shared/runtime.js";
import B from "./module/header.vue.js";
import K from "./module/form.vue.js";
import "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/index-7da9f094.js";
import "../../../../../../modules/use-users-4d979987.js";
function V(s) {
  return d({ url: "/api/mes/enclosure/inspectionTeam/page", method: "get", params: s });
}
function $(s) {
  return d({ url: "/api/mes/enclosure/inspectionTeam", method: "post", data: s });
}
function M(s) {
  return d({ url: "/api/mes/enclosure/inspectionTeam", method: "put", data: s });
}
function U(s) {
  return d({ url: "/api/mes/enclosure/inspectionTeam", method: "delete", data: { ids: s } });
}
const j = { get: V, add: $, edit: M, del: U }, q = { class: "app-container" }, G = { class: "head-container" }, Z = { __name: "index", setup(s, { expose: x }) {
  const h = w(), _ = k(), { crud: n, columns: g, CRUD: p } = H({ title: "质检", sort: [], permission: { ...m }, crudApi: { ...j } }, _), { maxHeight: y } = A({ paginate: true });
  return p.HOOK.handleRefresh = (i, a) => {
    a.data.content = a.data.content.map((e) => (e.inspectors = e.userLinkList.map((o) => ({ inspectionTeamId: o.inspectionTeamId, id: o.userId, name: o.userName })), e.inspectors && e.inspectors.length > 0 ? (e.inspectorNames = e.inspectors.map((o) => o.name).join(", "), e.inspectorIds = e.inspectors.map((o) => o.id)) : (e.inspectorNames = "", e.inspectorIds = []), e));
  }, p.HOOK.beforeSubmit = () => {
    const i = n.form.inspectors, a = [];
    for (let e = 0; e < i.length; e++) i[e] && a.push({ userId: i[e].id, userName: i[e].name, inspectionTeamId: n.form.id });
    n.form.userLinks = a;
  }, p.HOOK.afterSubmit = () => {
    h.commit("config/SET_LOADED", { key: "inspectionTeam", loaded: false });
  }, p.HOOK.afterDelete = () => {
    h.commit("config/SET_LOADED", { key: "inspectionTeam", loaded: false });
  }, x({ permission: m, toAdd: n.toAdd }), (i, a) => {
    const e = L, o = N("common-table"), b = S;
    return c(), O("div", q, [C("div", G, [r(t(B), null, { teamType: u(() => [D(i.$slots, "teamType")]), _: 3 })]), I((c(), l(o, { ref_key: "tableRef", ref: _, data: t(n).data, "empty-text": t(n).emptyText, "max-height": t(y) + 42, style: { width: "100%" }, "row-key": "id", onSelectionChange: t(n).selectionChangeHandler }, { default: u(() => [r(e, { type: "selection", width: "55", align: "center" }), r(e, { label: "序号", type: "index", align: "center", width: "60" }), t(g).visible("processName") ? (c(), l(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", width: "120px" })) : f("", true), t(g).visible("inspectorNames") ? (c(), l(e, { key: "inspectorNames", prop: "inspectorNames", "show-overflow-tooltip": true, label: "质检", "min-width": "160px" })) : f("", true), t(E)([...t(m).edit, ...t(m).del]) ? (c(), l(e, { key: 2, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((T) => [r(t(P), { data: T.row, permission: t(m) }, null, 8, ["data", "permission"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[b, t(n).loading]]), r(t(R)), r(t(K))]);
  };
} };
export {
  Z as default
};
