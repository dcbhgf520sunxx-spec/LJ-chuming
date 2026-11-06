import { inject as U } from "vue";
import { ref as p } from "vue";
import { computed as q } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as j } from "vue";
import { unref as s } from "vue";
import { createBlock as I } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as n } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as k, o as H, x as B, q3 as Y, D as y, P as V, ba as E } from "../../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
import $ from "./module/update-record.vue.js";
function z(i) {
  return k({ url: "/api/mes/building/production-wage-manage/yield-confirm/audited-workshop-process-team-list", method: "get", params: i });
}
function K(i) {
  return k({ url: "api/mes/building/production-wage-manage/yield-confirm/audited-list", method: "get", params: i });
}
const re = { get: z }, L = { class: "head-container" }, W = ["onClick"], G = { key: 1 }, J = ["onClick"], X = { key: 1 }, Z = { __name: "index", props: { detail: { type: Object, default: () => {
} } }, setup(i, { expose: v }) {
  const u = i, Q = U("query"), { maxHeight: x } = H({ paginate: true, extraHeight: "20px" }), w = p(), N = { add: false, edit: false, del: false, download: false }, g = p(false), f = p(), b = p(), { crud: o, CRUD: P } = B({ title: "产量工资", optShow: { ...N }, permission: { ...Y }, crudApi: { get: K }, hasPagination: true }, w), D = q(() => [["newQuotaPrice", ["to-thousand", y.YUAN]], ["oldQuotaPrice", ["to-thousand", y.YUAN]], ["wage", ["to-thousand", y.YUAN]], ["reportingTime", ["parse-time", "{y}-{m}-{d}"]], ["operateDate", ["parse-time", "{y}-{m}-{d}"]]]);
  P.HOOK.beforeToQuery = () => {
    o.query.processId = u.detail.processId, o.query.productType = u.detail.productType, o.query.selectedDate = Q.selectedDate, o.query.teamId = u.detail.teamId, o.query.workshopId = u.detail.workshopId;
  };
  function h(c, d) {
    g.value = true, f.value = c, b.value = d;
  }
  function S(c) {
    return E(c, { props: ["newMeasureQuantity", ["wage", y.YUAN]], toThousandFields: ["wage"] });
  }
  return v({ fetchData: o.toQuery }), (c, d) => {
    const a = A, M = R("common-table"), T = O;
    return r(), l("div", null, [_("div", L, [t(F, { ref: "headerRef" }, null, 512)]), j((r(), I(M, { ref_key: "tableRef", ref: w, style: { width: "100%" }, data: s(o).data, "empty-text": s(o).emptyText, "max-height": s(x), class: "table", "show-summary": "", "data-format": D.value, "summary-method": S }, { default: m(() => [t(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(a, { label: "项目", prop: "projectName", key: "projectName", align: "center" }, { default: m((e) => [_("div", null, n(e.row.projectSerialNumber) + " " + n(e.row.projectName), 1)]), _: 1 }), t(a, { label: "报工时间", prop: "reportingTime", key: "reportingTime", align: "center" }), t(a, { label: "名称", prop: "productName", key: "productName", align: "center" }), t(a, { label: "编号", prop: "productSerialNumber", key: "productSerialNumber", align: "center" }), t(a, { label: "规格", prop: "productSpecification", key: "productSpecification", align: "center", width: "130px" }), t(a, { label: "数量", prop: "inspectionQuantity", key: "inspectionQuantity", align: "center" }), t(a, { label: "计量量", prop: "newMeasureQuantity", key: "newMeasureQuantity", align: "center" }, { default: m((e) => [e.row.oldMeasureQuantity && e.row.oldMeasureQuantity !== e.row.newMeasureQuantity ? (r(), l("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (C) => h(e.row, "weight") }, n(e.row.newMeasureQuantity), 9, W)) : (r(), l("span", G, n(e.row.newMeasureQuantity), 1))]), _: 1 }), t(a, { label: "计量单位", prop: "measureUnit", key: "measureUnit", align: "center" }), t(a, { label: "定额单价（元）", prop: "newQuotaPrice", key: "newQuotaPrice", align: "center" }, { default: m((e) => [e.row.oldQuotaPrice && e.row.oldQuotaPrice !== e.row.newQuotaPrice ? (r(), l("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (C) => h(e.row, "unitPrice") }, n(e.row.newQuotaPrice), 9, J)) : (r(), l("span", X, n(e.row.newQuotaPrice), 1))]), _: 1 }), t(a, { label: "工价（元）", prop: "wage", key: "wage", align: "center" }), t(a, { label: "审核人", prop: "operatorName", key: "operatorName", align: "center" }), t(a, { label: "审核日期", prop: "operateDate", key: "operateDate", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[T, s(o).loading]]), t(s(V)), t($, { visible: g.value, "onUpdate:visible": d[0] || (d[0] = (e) => g.value = e), info: f.value, type: b.value }, null, 8, ["visible", "info", "type"])]);
  };
} }, ne = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  re as c,
  ne as i
};
