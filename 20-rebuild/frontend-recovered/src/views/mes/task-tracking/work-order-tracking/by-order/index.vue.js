import { ref as b } from "vue";
import { computed as D } from "vue";
import { provide as O } from "vue";
import { watch as S } from "vue";
import { resolveComponent as W } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as h } from "vue";
import { withDirectives as E } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as d } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as M } from "element-plus";
import { g as v, m as R } from "./production-line-detail/index.vue.js";
import { x as V, rU as g, o as A, a3 as T, p as F, bo as N, D as y, P as I, G as K } from "../../../../../shared/runtime.js";
import B from "./module/header.vue.js";
import H from "./process-detail/index.vue.js";
const j = { style: { "margin-top": "6px" } }, L = { style: { display: "flex" } }, U = { style: { width: "50%" } }, $ = { class: "head-container" }, z = { class: "tc-primary" }, J = { style: { width: "48%" } }, ae = { __name: "index", setup(X) {
  const C = { add: false, edit: false, del: false, download: false }, f = b(), _ = b({}), { crud: o, CRUD: x, columns: n } = V({ title: "工单跟踪", sort: [], optShow: { ...C }, permission: { ...g }, requiredQuery: ["productType", "projectId"], crudApi: { get: v }, hasPagination: true }, f), w = D(() => o.query.productType);
  O("productType", w), S(() => w.value, (p) => {
    p && (_.value = {}, o.query.workshopId = void 0, o.query.productionLineId = void 0);
  }, { immediate: true, deep: true });
  const { maxHeight: k } = A({ extraBox: [".head-container"], paginate: true });
  function Q(p) {
    K(g.orderDetail) && (_.value = p);
  }
  return x.HOOK.beforeToQuery = () => {
    o.crudApi.get = o.query.productType === T.ARTIFACT.V ? v : R;
  }, x.HOOK.handleRefresh = (p, c) => {
    c.data.content = c.data.content.map((r) => {
      var m;
      return r.groupNameStr = (m = r.groupNames) == null ? void 0 : m.join("、"), r;
    });
  }, (p, c) => {
    const r = G, m = W("common-table"), q = M;
    return i(), P("div", j, [a("div", L, [a("div", U, [a("div", $, [h(B)]), E((i(), s(m, { ref_key: "tableRef", ref: f, data: e(o).data, "highlight-current-row": "", "empty-text": e(o).query.projectId ? "暂无数据" : "请选择项目", "max-height": e(k), style: { width: "100%", cursor: "pointer" }, onCurrentChange: Q }, { default: l(() => [h(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(n).visible("scheduleTime") ? (i(), s(r, { align: "center", key: "scheduleTime", prop: "scheduleTime", "show-overflow-tooltip": true, label: "排产日期" }, { default: l((t) => [a("span", null, u(t.row.scheduleTime ? e(F)(t.row.scheduleTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : d("", true), e(n).visible("orderNumber") ? (i(), s(r, { align: "center", key: "orderNumber", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" }, { default: l((t) => [a("span", null, u(t.row.orderNumber), 1)]), _: 1 })) : d("", true), e(n).visible("totalQuantity") ? (i(), s(r, { align: "center", key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "任务数（件/吨）", width: "130px" }, { default: l((t) => [a("span", null, u(e(o).query.weightStatus === e(N).NET.V ? t.row.totalQuantity + "/" + (t.row.totalNetWeight / 1e3).toFixed(e(y).COM_WT__KG) : t.row.totalQuantity + "/" + (t.row.totalGrossWeight / 1e3).toFixed(e(y).COM_WT__KG)), 1)]), _: 1 })) : d("", true), e(n).visible("completeQuantity") ? (i(), s(r, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成（件/吨）", width: "130px" }, { default: l((t) => [a("span", z, u(e(o).query.weightStatus === e(N).NET.V ? t.row.completeQuantity + "/" + (t.row.completeNetWeight / 1e3).toFixed(e(y).COM_WT__KG) : t.row.completeQuantity + "/" + (t.row.completeGrossWeight / 1e3).toFixed(e(y).COM_WT__KG)), 1)]), _: 1 })) : d("", true), e(n).visible("rate") ? (i(), s(r, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率" }, { default: l((t) => [a("span", null, u((t.row.completeQuantity / t.row.totalQuantity * 100).toFixed(2)) + "%", 1)]), _: 1 })) : d("", true), e(n).visible("userName") && w.value === e(T).MACHINE_PART.V ? (i(), s(r, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "排产人" }, { default: l((t) => [a("span", null, u(t.row.userName), 1)]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, e(o).loading]]), h(e(I))]), c[0] || (c[0] = a("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), a("div", J, [h(H, { "process-list": _.value, weightStatus: e(o).query.weightStatus, query: e(o).query, permission: e(g) }, null, 8, ["process-list", "weightStatus", "query", "permission"])])])]);
  };
} };
export {
  ae as default
};
