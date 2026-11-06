import { ref as c } from "vue";
import { watch as U } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { unref as t } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as m } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { createTextVNode as p } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as $, _ as B } from "./module/install-detail.vue.js";
import { _ as z, m as G, x as K, o as F, bN as C, kM as N, T as Z, tZ as J, G as b, P as W } from "../../../../shared/runtime.js";
import { l as _ } from "../../../../modules/project-19a12d6b.js";
import X from "./module/header.vue.js";
const Y = { class: "app-container" }, ee = { key: 0 }, te = { key: 0 }, ae = { style: { display: "flex" } }, oe = { style: { flex: "1" } }, le = { style: { "margin-left": "3px" } }, ne = { style: { flex: "1" } }, ie = { style: { "margin-left": "3px" } }, se = { style: { display: "flex" } }, re = { style: { flex: "1" } }, de = { style: { "margin-left": "3px" } }, ue = { style: { flex: "1" } }, pe = { style: { "margin-left": "3px" } }, ce = { key: 1 }, me = { __name: "index", setup(ye) {
  const { globalProjectId: g, globalProject: w } = G(["globalProjectId", "globalProject"]), M = { add: false, edit: false, del: false, download: false }, P = c([["reportDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]]]), x = c(), h = c(false), v = c("detail"), k = c({}), { crud: s, CRUD: T } = K({ title: "安装审核", sort: ["id.desc"], permission: { ..._ }, requiredQuery: ["projectId"], optShow: { ...M }, crudApi: { ...$ }, hasPagination: true }, x), { maxHeight: D } = F({ paginate: true, extraHeight: 40 });
  U(() => g.value, (u) => {
    u && (s.query.projectId = g.value, s.toQuery());
  }, { immediate: true, deep: true }), T.HOOK.beforeRefresh = () => (s.query.projectId = w.value.businessType === C.INSTALLATION.V ? g.value : void 0, !!s.query.projectId);
  function I(u, o) {
    k.value = u.sourceRow, h.value = true, v.value = o;
  }
  return T.HOOK.handleRefresh = (u, o) => {
    o.data.content.map((i) => {
      i.projectId = u.query.projectId;
    });
  }, (u, o) => {
    var S;
    const i = O, A = H, V = j("common-button"), E = j("common-table"), L = Q;
    return r(), f("div", Y, [((S = t(w)) == null ? void 0 : S.businessType) === t(C).INSTALLATION.V ? (r(), f("div", ee, [l(t(X)), q((r(), m(E, { ref_key: "tableRef", ref: x, data: t(s).data, "empty-text": t(s).emptyText, "max-height": t(D), "data-format": P.value, stripe: false, "row-key": "id", style: { width: "100%" } }, { default: d(() => [l(i, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), t(s).query.yearMonth ? (r(), m(i, { key: "reportDate", prop: "reportDate", label: "申报日期", align: "center", width: "100" })) : y("", true), l(i, { key: "supplierName", prop: "supplierName", label: "分包单位", align: "center" }), l(i, { key: "productType", prop: "productType", label: "产品分类", align: "center", width: "150" }, { default: d((e) => [a("span", null, n(t(N).VL[e.row.productType]), 1), e.row.productType === t(N).ENCLOSURE.V ? (r(), f("span", te, n(`-${t(Z).VL[e.row.category]}`), 1)) : y("", true)]), _: 1 }), l(i, { key: "reportMete", prop: "reportMete", label: "上报量", align: "center" }, { default: d((e) => [a("div", ae, [a("div", oe, [a("span", null, [p(n(e.row.reportQuantity), 1), a("span", le, n(e.row.measureUnit), 1)])]), o[1] || (o[1] = a("div", { style: { width: "1px", height: "50px", background: "#ebeef5", position: "absolute", left: "50%", top: "0" } }, null, -1)), a("div", ne, [p(n(e.row.reportMete), 1), a("span", ie, n(e.row.accountingUnit), 1)])])]), _: 1 }), l(i, { key: "actualMete", prop: "actualMete", label: "审核量", align: "center" }, { default: d((e) => [a("div", se, [a("div", re, [a("span", null, [p(n(e.row.actualQuantity), 1), a("span", de, n(e.row.measureUnit), 1)])]), o[2] || (o[2] = a("div", { style: { width: "1px", height: "50px", background: "#ebeef5", position: "absolute", left: "50%", top: "0" } }, null, -1)), a("div", ue, [p(n(e.row.actualMete), 1), a("span", pe, n(e.row.accountingUnit), 1)])])]), _: 1 }), l(i, { key: "boolAuditStatus", prop: "boolAuditStatus", label: "状态", align: "center", width: "100" }, { default: d((e) => [l(A, { type: e.row.boolAuditStatus ? "success" : "primary" }, { default: d(() => [p(n(t(J).VL[e.row.boolAuditStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), t(b)([...t(_).detail, ...t(_).audit]) ? (r(), m(i, { key: 1, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: d((e) => [t(b)(t(_).detail) ? (r(), m(V, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (R) => I(e.row, "detail") }, null, 8, ["onClick"])) : y("", true), t(b)(t(_).audit) && !e.row.boolAuditStatus ? (r(), m(V, { key: 1, size: "default", icon: "el-icon-stamp", type: "primary", onClick: (R) => I(e.row, "audit") }, null, 8, ["onClick"])) : y("", true)]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[L, t(s).loading]]), l(t(W))])) : (r(), f("div", ce, [l(A, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: d(() => o[3] || (o[3] = [p(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [3] })])), l(t(B), { modelValue: h.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => h.value = e), showType: v.value, detailInfo: k.value, onSuccess: t(s).toQuery }, null, 8, ["modelValue", "showType", "detailInfo", "onSuccess"])]);
  };
} }, we = z(me, [["__scopeId", "data-v-59f9ef6c"]]);
export {
  we as default
};
