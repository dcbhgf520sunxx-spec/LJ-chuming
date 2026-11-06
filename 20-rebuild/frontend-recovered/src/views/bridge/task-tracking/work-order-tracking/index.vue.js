import { ref as g } from "vue";
import { computed as Q } from "vue";
import { provide as D } from "vue";
import { watch as M } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as h } from "vue";
import { withDirectives as R } from "vue";
import { unref as e } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as A } from "element-plus";
import { g as v, m as B } from "./production-line-detail/index.vue.js";
import { x as H, o as V, F as f, z as j, p as E, D as b, P as F } from "../../../../shared/runtime.js";
import { K } from "../../../../modules/bridge-86f96a4f.js";
import I from "./module/header.vue.js";
import L from "./process-detail/index.vue.js";
import "../../../../modules/production-line-select-307387f7.js";
const S = { class: "app-container" }, W = { style: { display: "flex" } }, G = { style: { width: "50%" } }, U = { class: "head-container" }, z = { style: { width: "48%" } }, ae = { __name: "index", setup(X) {
  const x = { add: false, edit: false, del: false, download: false }, y = g(), _ = g({}), { crud: i, CRUD: w, columns: p } = H({ title: "工单跟踪", sort: [], optShow: { ...x }, permission: { ...K }, requiredQuery: ["productType"], crudApi: { get: v }, hasPagination: true }, y), m = Q(() => i.query.productType);
  D("productType", m), M(() => m.value, (d) => {
    d && (_.value = {}, i.query.workshopId = void 0, i.query.productionLineId = void 0);
  }, { immediate: true, deep: true });
  const { maxHeight: T } = V({ extraBox: [".head-container"], paginate: true });
  function k(d) {
    _.value = d;
  }
  return w.HOOK.beforeToQuery = () => {
    i.crudApi.get = i.query.productType === f.BOX.V ? v : B;
  }, w.HOOK.handleRefresh = (d, c) => {
    c.data.content = c.data.content.map((r) => r);
  }, (d, c) => {
    const r = q, C = O("common-table"), N = A;
    return a(), P("div", S, [o("div", W, [o("div", G, [o("div", U, [h(I)]), R((a(), n(C, { ref_key: "tableRef", ref: y, data: e(i).data, "highlight-current-row": "", "empty-text": e(i).emptyText, "max-height": e(T), style: { width: "100%" }, onCurrentChange: k }, { default: s(() => [h(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(p).visible("orderNumber") ? (a(), n(r, { align: "center", key: "orderNumber", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" }, { default: s((t) => [o("span", null, l(t.row.orderNumber), 1)]), _: 1 })) : u("", true), e(p).visible("project") && m.value !== e(f).MACHINE_PART.V ? (a(), n(r, { key: "project.name", prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "100px" }, { default: s((t) => [o("span", null, l(e(j)(t.row.project)), 1)]), _: 1 })) : u("", true), e(p).visible("completeTime") ? (a(), n(r, { align: "center", key: "completeTime", prop: "completeTime", "show-overflow-tooltip": true, label: "计划完成日期" }, { default: s((t) => [o("span", null, l(t.row.completeTime ? e(E)(t.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : u("", true), e(p).visible("totalQuantity") ? (a(), n(r, { align: "center", key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "总量（件/kg）" }, { default: s((t) => [o("span", null, l(t.row.totalQuantity) + "/" + l(t.row.totalMete.toFixed(e(b).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(p).visible("completeQuantity") ? (a(), n(r, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成（件/kg）", width: "130px" }, { default: s((t) => [o("span", null, l(t.row.completeQuantity) + "/" + l(t.row.completeMete.toFixed(e(b).COM_WT__KG)), 1)]), _: 1 })) : u("", true), e(p).visible("rate") ? (a(), n(r, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率" }, { default: s((t) => [o("span", null, l((t.row.completeQuantity / t.row.totalQuantity * 100).toFixed(2)) + "%", 1)]), _: 1 })) : u("", true), e(p).visible("userName") && m.value === e(f).MACHINE_PART.V ? (a(), n(r, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "排产人" }, { default: s((t) => [o("span", null, l(t.row.userName), 1)]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(i).loading]]), h(e(F))]), c[0] || (c[0] = o("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), o("div", z, [h(L, { "process-list": _.value }, null, 8, ["process-list"])])])]);
  };
} };
export {
  ae as default
};
