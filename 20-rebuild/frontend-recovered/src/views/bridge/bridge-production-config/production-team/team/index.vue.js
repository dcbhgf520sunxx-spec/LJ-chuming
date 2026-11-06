import { useStore as L } from "vuex";
import { ref as C } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as u } from "vue";
import { renderSlot as O } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as d } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as P } from "element-plus";
import { l as g, x as H, aW as h, o as A, aD as R, G as B, an as K, P as V, aT as $ } from "../../../../../shared/runtime.js";
import q from "./module/header.vue.js";
import M from "./module/form.vue.js";
import "../../../../../modules/process-select-cf7cf476.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-bridge-process-6f90ba68.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
function Q(o) {
  return g({ url: "/api/mes/bridge/team/page", method: "get", params: o });
}
function U(o) {
  return g({ url: "/api/mes/bridge/team", method: "post", data: o });
}
function j(o) {
  return g({ url: "/api/mes/bridge/team", method: "put", data: o });
}
function v(o) {
  return g({ url: "/api/mes/bridge/team", method: "delete", data: { ids: o } });
}
const F = { get: Q, add: U, edit: j, del: v }, G = { class: "app-container" }, W = { class: "head-container" }, se = { __name: "index", setup(o, { expose: w }) {
  const T = [["wageQuotaType", ["parse-enum", $, { f: "SL", extra: "计价" }]]], y = L(), N = C(), { crud: r, columns: c, CRUD: f } = H({ title: "班组", sort: [], permission: { ...h }, crudApi: { ...F }, queryOnPresenterCreated: false }, N), { maxHeight: k } = A({ paginate: true });
  return f.HOOK.handleRefresh = (s, m) => {
    m.data.content = m.data.content.map((e) => {
      const b = [];
      return e.userLinkList.forEach((a) => {
        a.boolLeaderEnum ? (e.leaderName = a.userName, e.leaderId = a.userId, e.leader = { id: a.userId, name: a.userName }) : b.push({ teamId: a.teamId, id: a.userId, name: a.userName });
      }), e.members = b, e.members.length > 0 ? (e.memberNames = e.members.map((a) => a.name).join(", "), e.memberIds = e.members.map((a) => a.id)) : (e.memberNames = "", e.memberIds = []), e;
    });
  }, f.HOOK.beforeSubmit = () => {
    const s = r.form.members, m = [];
    m.push({ boolLeaderEnum: true, userId: r.form.leader.id, userName: r.form.leader.name, teamId: r.form.id });
    for (let e = 0; e < s.length; e++) s[e] && m.push({ boolLeaderEnum: false, userId: s[e].id, userName: s[e].name, teamId: r.form.id });
    r.form.userLinks = m;
  }, f.HOOK.afterSubmit = () => {
    y.commit("config/SET_LOADED", { key: "bridgeProductionTeam", loaded: false });
  }, f.HOOK.afterDelete = () => {
    y.commit("config/SET_LOADED", { key: "bridgeProductionTeam", loaded: false });
  }, w({ permission: h, toAdd: r.toAdd }), (s, m) => {
    const e = S, b = E("common-table"), a = P;
    return i(), I("div", G, [_("div", W, [n(t(q), null, { teamType: u(() => [O(s.$slots, "teamType")]), _: 3 })]), D((i(), d(b, { ref_key: "tableRef", ref: N, data: t(r).data, "data-format": T, "empty-text": t(r).emptyText, "max-height": t(k), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(r).selectionChangeHandler }, { default: u(() => [n(e, { type: "selection", width: "55", align: "center" }), n(e, { label: "序号", type: "index", align: "center", width: "60" }), t(c).visible("processName") ? (i(), d(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "100px" }, { default: u(({ row: l }) => [_("span", null, x(l.processName), 1)]), _: 1 })) : p("", true), t(c).visible("productType") ? (i(), d(e, { key: "productType", prop: "productType", label: "类型", align: "center", width: "100px" }, { default: u((l) => [_("span", null, x(t(R).VL[l.row.productType]), 1)]), _: 1 })) : p("", true), t(c).visible("leaderName") ? (i(), d(e, { key: "leaderName", prop: "leaderName", label: "组长", "min-width": "100px" })) : p("", true), t(c).visible("memberNames") ? (i(), d(e, { key: "memberNames", prop: "memberNames", "show-overflow-tooltip": true, label: "组员", "min-width": "160px" })) : p("", true), t(B)([...t(h).edit, ...t(h).del]) ? (i(), d(e, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((l) => [n(t(K), { data: l.row }, null, 8, ["data"])]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[a, t(r).loading]]), n(t(V)), n(t(M))]);
  };
} };
export {
  se as default
};
