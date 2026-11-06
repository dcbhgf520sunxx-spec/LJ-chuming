import { useStore as R } from "vuex";
import { ref as k } from "vue";
import { watch as N } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as l } from "vue";
import { withCtx as u } from "vue";
import { renderSlot as q } from "vue";
import { unref as t } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as d } from "vue";
import { toDisplayString as x } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { InfoFilled as $ } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as W } from "element-plus";
import { ElSwitch as Y } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as G, _ as J, e as X } from "./module/form.vue.js";
import { x as Z, nV as y, o as ee, oV as te, aU as ae, a3 as oe, G as I, aS as p, an as ne, P as re, aT as ie, aY as se } from "../../../../../shared/runtime.js";
import le from "./module/header.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
import "../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const me = { class: "app-container" }, ue = { class: "head-container" }, de = { style: { display: "inline-block" } }, Le = { __name: "index", props: { productionLineTypeEnum: { type: Number, default: void 0 } }, setup(C, { expose: V }) {
  const g = C, v = [["wageQuotaType", ["parse-enum", ie, { f: "SL", extra: "计价" }]], ["organizationType", ["parse-enum", se]]], w = R(), E = k(), _ = k([]), { crud: a, columns: c, CRUD: f } = Z({ title: "班组", sort: [], permission: { ...y }, crudApi: { ...G }, queryOnPresenterCreated: false }, E), { maxHeight: O } = ee({ paginate: true });
  N(() => g.productionLineTypeEnum, (o) => {
    a.query.productionLineTypeEnum = o, a.toQuery();
  }, { immediate: true }), N(() => a.query.mesProductEnum, () => {
    T();
  });
  async function T() {
    try {
      const { content: o } = await te({ boolEnabledEnum: true, type: a.query.mesProductEnum });
      _.value = o || [];
    } catch (o) {
      console.log("获取车间信息失败", o);
    }
  }
  T(), f.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((e) => {
      const b = [];
      return e.userLinkList.forEach((n) => {
        n.boolLeaderEnum ? (e.leaderName = n.userName, e.leaderId = n.userId, e.leader = { id: n.userId, name: n.userName }) : b.push({ teamId: n.teamId, id: n.userId, name: n.userName });
      }), e.members = b, e.members.length > 0 ? (e.memberNames = e.members.map((n) => n.name).join(", "), e.memberIds = e.members.map((n) => n.id)) : (e.memberNames = "", e.memberIds = []), e;
    });
  }, f.HOOK.beforeSubmit = () => {
    const o = a.form.members, r = [];
    if (r.push({ boolLeaderEnum: true, userId: a.form.leader.id, userName: a.form.leader.name, teamId: a.form.id }), o != null && o.length) for (let e = 0; e < o.length; e++) o[e] && r.push({ boolLeaderEnum: false, userId: o[e].id, userName: o[e].name, teamId: a.form.id });
    a.form.userLinks = r, a.form.productionLineTypeEnum = g.productionLineTypeEnum, a.form.teamStatus = true;
  };
  async function P(o, r) {
    try {
      await K.confirm('此操作将 "' + p.VL[r] + '" 该班组, 是否继续？', "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ teamId: o.id, teamStatus: r, mesProductEnum: a.query.mesProductEnum }), a.refresh(), a.notify(p.VL[r] + "成功", f.NOTIFICATION_TYPE.SUCCESS);
    } catch (e) {
      console.log("变更状态", e), o.teamStatus = o.teamStatus === p.TRUE.V ? p.FALSE.V : p.TRUE.V;
    }
  }
  return f.HOOK.afterSubmit = () => {
    w.commit("config/SET_LOADED", { key: "productionTeam", loaded: false });
  }, f.HOOK.afterDelete = () => {
    w.commit("config/SET_LOADED", { key: "productionTeam", loaded: false });
  }, V({ permission: y, toAdd: a.toAdd }), (o, r) => {
    const e = M, b = S("table-cell-tag"), n = $, A = Q, D = W, U = Y, B = S("common-table"), F = j;
    return s(), H("div", me, [h("div", ue, [l(t(le), { workshopList: _.value }, { teamType: u(() => [q(o.$slots, "teamType")]), _: 3 }, 8, ["workshopList"])]), z((s(), m(B, { ref_key: "tableRef", ref: E, data: t(a).data, "data-format": v, "empty-text": t(a).emptyText, "max-height": t(O), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(a).selectionChangeHandler }, { default: u(() => [l(e, { type: "selection", width: "55", align: "center" }), l(e, { label: "序号", type: "index", align: "center", width: "60" }), t(c).visible("workshopName") ? (s(), m(e, { key: "workshopName", prop: "workshopName", label: "车间", width: "140px", align: "center" })) : d("", true), t(c).visible("productionLineName") ? (s(), m(e, { key: "productionLineName", prop: "productionLineName", label: "生产线", width: "140px", align: "center" })) : d("", true), t(c).visible("processName") ? (s(), m(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "100px" }, { default: u(({ row: i }) => [l(b, { show: i.productionLineTypeEnum === t(ae).INTELLECT.V, name: "智能线", offset: 10 }, null, 8, ["show"]), h("span", null, x(i.processName), 1)]), _: 1 })) : d("", true), t(c).visible("productType") ? (s(), m(e, { key: "productType", prop: "productType", label: "类型", align: "center", width: "100px" }, { default: u((i) => [h("span", null, x(t(oe).VL[i.row.productType]), 1)]), _: 1 })) : d("", true), t(c).visible("leaderName") ? (s(), m(e, { key: "leaderName", prop: "leaderName", label: "组长", width: "100px" })) : d("", true), t(c).visible("memberNames") ? (s(), m(e, { key: "memberNames", prop: "memberNames", "show-overflow-tooltip": true, label: "组员", "min-width": "160px" })) : d("", true), t(c).visible("organizationType") ? (s(), m(e, { key: "organizationType", prop: "organizationType", label: "属性", align: "center", width: "100px" })) : d("", true), t(c).visible("teamStatus") ? (s(), m(e, { key: "teamStatus", prop: "teamStatus", label: "状态", align: "center", width: "80px" }, { header: u(() => [l(D, { class: "item", effect: "light", content: "禁用后排产相关页面不可再选择", placement: "top" }, { default: u(() => [h("div", de, [r[0] || (r[0] = h("span", null, "状态", -1)), l(A, null, { default: u(() => [l(n)]), _: 1 })])]), _: 1 })]), default: u((i) => [l(U, { modelValue: i.row.teamStatus, "onUpdate:modelValue": (L) => i.row.teamStatus = L, disabled: !t(I)(t(y).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(p).TRUE.V, "inactive-value": t(p).FALSE.V, onClick: (L) => P(i.row, i.row.teamStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onClick"])]), _: 1 })) : d("", true), t(I)([...t(y).edit, ...t(y).del]) ? (s(), m(e, { key: 8, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((i) => [l(t(ne), { data: i.row }, null, 8, ["data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[F, t(a).loading]]), l(t(re)), l(t(J), { workshopList: _.value }, null, 8, ["workshopList"])]);
  };
} };
export {
  Le as default
};
