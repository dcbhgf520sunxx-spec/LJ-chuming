import { ref as A } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as w } from "vue";
import { unref as t } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as r } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as C } from "vue";
import { renderList as G } from "vue";
import { createTextVNode as P } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElTag as W } from "element-plus";
import { ElTooltip as D } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as F } from "../../../../modules/outsourcing-return-record-94166e49.js";
import { B as R } from "../../../../modules/project-19a12d6b.js";
import { _ as Y, m as q, x as K, o as z, cO as $, tS as d, jl as J, tW as i, c as v, p as V, aN as X, bv as Z, pz as ee, pA as te, P as ae } from "../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
const ie = { class: "app-container" }, ne = { class: "head-container" }, re = { key: 0 }, le = { key: 1 }, se = { key: 2 }, ce = { key: 1 }, pe = { __name: "index", setup(ue) {
  const { globalProjectId: Q, globalProject: me } = q(["globalProjectId", "globalProject"]), I = { add: false, edit: false, del: false, download: false }, j = A(), { crud: b, columns: l, CRUD: E } = K({ title: "外购退货记录", sort: ["id.desc"], permission: { ...R }, optShow: { ...I }, invisibleColumns: [""], crudApi: { ...F }, hasPagination: true }, j);
  E.HOOK.beforeRefresh = () => {
  };
  const M = A([["receivedDate", "parse-time"]]), { maxHeight: H } = z({ extraBox: ".head-container", paginate: true, extraHeight: 20 });
  return E.HOOK.handleRefresh = async (S, _) => {
    var T, g;
    await $(_.data.content);
    const n = (T = _.data.content) == null ? void 0 : T.filter((a) => a.productType === d.RAW_MATERIAL.V);
    await J(n, { toNum: true }, { quantity: ["rejectQuantity"], mete: ["rejectMete", "rejectActualReceivedMete"] });
    const f = (g = _.data.content) == null ? void 0 : g.filter((a) => a.productType !== d.RAW_MATERIAL.V);
    f == null || f.forEach(async (a) => {
      a.accountingUnit = a.wageQuotaType === i.WEIGHT.V ? i.WEIGHT.unit : a.wageQuotaType === i.LENGTH.V ? i.LENGTH.unit : a.wageQuotaType === i.QUANTITY.V ? i.QUANTITY.unit : a.wageQuotaType === i.AREA.V ? i.AREA.unit : "", a.accountingPrecision = a.wageQuotaType === i.WEIGHT.V ? i.WEIGHT.precision : a.wageQuotaType === i.LENGTH.V ? i.LENGTH.precision : a.wageQuotaType === i.QUANTITY.V ? i.QUANTITY.precision : a.wageQuotaType === i.AREA.V ? i.AREA.precision : 0, a.rejectMete = a.wageQuotaType === i.WEIGHT.V ? v(a.rejectMete, "g", "kg", 3) : a.wageQuotaType === i.LENGTH.V ? v(a.rejectMete, "mm", "m", 3) : a.wageQuotaType === i.AREA.V ? v(a.rejectMete, "mm²", "m²", 6) : a.rejectMete;
    });
  }, (S, _) => {
    const n = B, f = W, T = D, g = L("common-table"), a = O;
    return o(), y("div", ie, [m("div", ne, [w(t(oe), { projectId: t(Q), permission: t(R) }, null, 8, ["projectId", "permission"])]), U((o(), r(g, { ref_key: "tableRef", ref: j, data: t(b).data, "data-format": M.value, "empty-text": t(b).emptyText, "max-height": t(H), "show-empty-symbol": false, stripe: false, returnSourceData: "", "row-key": "id", style: { width: "100%" } }, { default: u(() => [w(n, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(l).visible("createTime") ? (o(), r(n, { key: "createTime", prop: "createTime", label: "退货日期", align: "center", width: "140", "show-overflow-tooltip": true, fixed: "left" }, { default: u(({ row: e }) => [m("span", null, p(e.createTime ? t(V)(e.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })) : s("", true), t(l).visible("rejectSn") ? (o(), r(n, { key: "rejectSn", prop: "rejectSn", label: "外购退货单号", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), t(l).visible("projectName") ? (o(), r(n, { key: "projectName", prop: "projectName", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: u(({ row: e }) => {
      var c, h;
      return [m("span", null, p(e.project ? ((c = e.project) == null ? void 0 : c.serialNumber) + " " + ((h = e.project) == null ? void 0 : h.name) : "-"), 1)];
    }), _: 1 })) : s("", true), t(l).visible("supplier.name") ? (o(), r(n, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), t(l).visible("purchaseSn") ? (o(), r(n, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), t(l).visible("productType") ? (o(), r(n, { key: "productType", prop: "productType", label: "材料类型", align: "center", "min-width": "135", "show-overflow-tooltip": true }, { default: u((e) => [(o(true), y(C, null, G(t(X)(t(Z).getBits(t(d), e.row.productType, "V")), (c) => (o(), r(f, { style: { "margin-right": "5px" }, key: c, type: t(d).V[c].T, effect: "light", "disable-transitions": "" }, { default: u(() => [P(p(t(d).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), t(l).visible("monomer") ? (o(), r(n, { key: "monomer", prop: "monomer", label: "单体区域/批次", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: u(({ row: e }) => {
      var c, h, N, k, x;
      return [e.productType === t(d).STRUCTURE.V ? (o(), y("span", re, p(((c = e.monomer) != null && c.name || (h = e == null ? void 0 : e.area) != null && h.name) && (((N = e.monomer) == null ? void 0 : N.name) || "->" + ((k = e == null ? void 0 : e.area) == null ? void 0 : k.name)) || "-"), 1)) : e.productType === t(d).ENCLOSURE.V ? (o(), y("span", le, p(((x = e.batch) == null ? void 0 : x.name) || "-"), 1)) : (o(), y("span", se, "-"))];
    }), _: 1 })) : s("", true), t(l).visible("name") ? (o(), r(n, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true })) : s("", true), t(l).visible("serialNumber") ? (o(), r(n, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true })) : s("", true), t(l).visible("specification") ? (o(), r(n, { key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: u(({ row: e }) => [e.productType === t(d).RAW_MATERIAL.V ? (o(), r(T, { key: 0, content: t(ee)(e), placement: "left" }, { default: u(() => [m("span", null, p(t(te)(e)), 1)]), _: 2 }, 1032, ["content"])) : (o(), y("span", ce, p(e.specification || "-"), 1))]), _: 1 })) : s("", true), t(l).visible("rejectQuantity") ? (o(), r(n, { key: "rejectQuantity", prop: "rejectQuantity", label: "退货数", align: "center", "show-overflow-tooltip": true }, { default: u(({ row: e }) => [m("span", null, p(e.rejectQuantity || "-"), 1), m("span", null, p(e.measureUnit || ""), 1)]), _: 1 })) : s("", true), t(l).visible("rejectMete") ? (o(), r(n, { key: "rejectMete", prop: "rejectMete", label: "退货量", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: u(({ row: e }) => {
      var c;
      return [m("span", null, p(((c = e.rejectMete) == null ? void 0 : c.toFixed(e.accountingPrecision)) || "-"), 1), m("span", null, p(e.accountingUnit || ""), 1)];
    }), _: 1 })) : s("", true), t(l).visible("applicantName") ? (o(), r(n, { key: "applicantName", prop: "applicantName", label: "退货人", align: "center", "show-overflow-tooltip": true, width: "100", fixed: "right" })) : s("", true), t(l).visible("reviewerName") ? (o(), r(n, { key: "reviewerName", prop: "reviewerName", label: "审核人", align: "center", "show-overflow-tooltip": true, width: "100", fixed: "right" })) : s("", true), t(l).visible("reviewTime") ? (o(), r(n, { key: "reviewTime", prop: "reviewTime", label: "审核日期", align: "center", width: "140", "show-overflow-tooltip": true, fixed: "right" }, { default: u(({ row: e }) => [m("span", null, p(e.reviewTime ? t(V)(e.reviewTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[a, t(b).loading]]), w(t(ae))]);
  };
} }, Te = Y(pe, [["__scopeId", "data-v-aa6d285e"]]);
export {
  Te as default
};
