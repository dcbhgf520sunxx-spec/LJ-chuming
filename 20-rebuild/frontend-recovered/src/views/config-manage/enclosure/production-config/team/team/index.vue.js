import { useStore as y } from "vuex";
import { ref as w } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as m } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as C } from "vue";
import { unref as t } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as c } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as S, _ as T } from "./module/form.vue.js";
import { x as H, dU as p, o as A, G as P, an as R, P as B } from "../../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import "../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../modules/index-7da9f094.js";
import "../../../../../../modules/use-users-4d979987.js";
const U = { class: "app-container" }, V = { class: "head-container" }, W = { __name: "index", setup($, { expose: N }) {
  const b = y(), h = w(), { crud: o, columns: _, CRUD: i } = H({ title: "班组", sort: [], permission: { ...p }, crudApi: { ...S } }, h), { maxHeight: x } = A({ paginate: true });
  return i.HOOK.handleRefresh = (r, s) => {
    s.data.content = s.data.content.map((e) => {
      const d = [];
      return e.userLinkList.forEach((a) => {
        a.boolLeaderEnum ? (e.leaderName = a.userName, e.leaderId = a.userId, e.leader = { id: a.userId, name: a.userName }) : d.push({ teamId: a.teamId, id: a.userId, name: a.userName });
      }), e.members = d, e.members.length > 0 ? (e.memberNames = e.members.map((a) => a.name).join(", "), e.memberIds = e.members.map((a) => a.id)) : (e.memberNames = "", e.memberIds = []), e;
    });
  }, i.HOOK.beforeSubmit = () => {
    const r = o.form.members, s = [];
    s.push({ boolLeaderEnum: true, userId: o.form.leader.id, userName: o.form.leader.name, teamId: o.form.id });
    for (let e = 0; e < r.length; e++) r[e] && s.push({ boolLeaderEnum: false, userId: r[e].id, userName: r[e].name, teamId: o.form.id });
    o.form.userLinks = s;
  }, i.HOOK.afterSubmit = () => {
    b.commit("config/SET_LOADED", { key: "productionTeam", loaded: false });
  }, i.HOOK.afterDelete = () => {
    b.commit("config/SET_LOADED", { key: "productionTeam", loaded: false });
  }, N({ permission: p, toAdd: o.toAdd }), (r, s) => {
    const e = D, d = k("common-table"), a = E;
    return n(), I("div", U, [g("div", V, [m(t(K), null, { teamType: l(() => [C(r.$slots, "teamType")]), _: 3 })]), L((n(), c(d, { ref_key: "tableRef", ref: h, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(x), "row-key": "id", style: { width: "100%" }, onSelectionChange: t(o).selectionChangeHandler }, { default: l(() => [m(e, { align: "center", type: "selection", width: "55" }), m(e, { align: "center", label: "序号", type: "index", width: "60" }), t(_).visible("processName") ? (n(), c(e, { key: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "100px", prop: "processName" }, { default: l(({ row: u }) => [g("span", null, O(u.processName), 1)]), _: 1 })) : f("", true), m(e, { key: "productionName", align: "center", label: "产线", "min-width": "100", prop: "productionName" }), t(_).visible("memberNames") ? (n(), c(e, { key: "memberNames", "show-overflow-tooltip": true, label: "组员", "min-width": "160px", prop: "memberNames" })) : f("", true), t(P)([...t(p).edit, ...t(p).del]) ? (n(), c(e, { key: 2, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: l((u) => [m(t(R), { data: u.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[a, t(o).loading]]), m(t(B)), m(t(T))]);
  };
} };
export {
  W as default
};
