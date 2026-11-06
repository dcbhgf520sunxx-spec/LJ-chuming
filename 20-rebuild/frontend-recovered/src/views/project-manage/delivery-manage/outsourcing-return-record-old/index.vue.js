import { ref as V } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as d } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as r } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as O } from "vue";
import { renderList as W } from "vue";
import { createTextVNode as R } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElTag as D } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { vLoading as Y } from "element-plus";
import { c as q } from "../../../../modules/outsourcing-return-record-94166e49.js";
import { g as Q } from "../../../../modules/project-19a12d6b.js";
import { _ as z, m as K, x as $, o as J, cO as X, tS as y, jl as Z, tW as i, c as v, bN as ee, p as I, aN as te, bv as ae, pz as oe, pA as ie, P as ne } from "../../../../shared/runtime.js";
import re from "./module/header.vue.js";
const le = { class: "app-container" }, se = { key: 0 }, pe = { class: "head-container" }, ce = { key: 0 }, ue = { key: 1 }, me = { key: 2 }, de = { key: 1 }, ye = { key: 1 }, _e = { __name: "index", setup(fe) {
  const { globalProjectId: M, globalProject: S } = K(["globalProjectId", "globalProject"]), H = { add: false, edit: false, del: false, download: false }, j = V(), { crud: w, columns: l, CRUD: N } = $({ title: "外购退货记录", sort: ["id.desc"], permission: { ...Q }, optShow: { ...H }, invisibleColumns: [""], crudApi: { ...q }, hasPagination: true }, j);
  N.HOOK.beforeRefresh = () => {
  };
  const L = V([["receivedDate", "parse-time"]]), { maxHeight: U } = J({ extraBox: ".head-container", paginate: true, extraHeight: 20 });
  return N.HOOK.handleRefresh = async (C, _) => {
    var g, h;
    await X(_.data.content);
    const n = (g = _.data.content) == null ? void 0 : g.filter((o) => o.productType === y.RAW_MATERIAL.V);
    await Z(n, { toNum: true }, { quantity: ["rejectQuantity"], mete: ["rejectMete", "rejectActualReceivedMete"] });
    const f = (h = _.data.content) == null ? void 0 : h.filter((o) => o.productType !== y.RAW_MATERIAL.V);
    f == null || f.forEach(async (o) => {
      o.accountingUnit = o.wageQuotaType === i.WEIGHT.V ? i.WEIGHT.unit : o.wageQuotaType === i.LENGTH.V ? i.LENGTH.unit : o.wageQuotaType === i.QUANTITY.V ? i.QUANTITY.unit : o.wageQuotaType === i.AREA.V ? i.AREA.unit : "", o.accountingPrecision = o.wageQuotaType === i.WEIGHT.V ? i.WEIGHT.precision : o.wageQuotaType === i.LENGTH.V ? i.LENGTH.precision : o.wageQuotaType === i.QUANTITY.V ? i.QUANTITY.precision : o.wageQuotaType === i.AREA.V ? i.AREA.precision : 0, o.rejectMete = o.wageQuotaType === i.WEIGHT.V ? v(o.rejectMete, "g", "kg", 3) : o.wageQuotaType === i.LENGTH.V ? v(o.rejectMete, "mm", "m", 3) : o.wageQuotaType === i.AREA.V ? v(o.rejectMete, "mm²", "m²", 6) : o.rejectMete;
    });
  }, (C, _) => {
    var k;
    const n = B, f = D, g = F, h = G("common-table"), o = Y;
    return a(), d("div", le, [((k = e(S)) == null ? void 0 : k.businessType) === e(ee).INSTALLATION.V ? (a(), d("div", se, [m("div", pe, [b(e(re), { projectId: e(M), permission: e(Q) }, null, 8, ["projectId", "permission"])]), P((a(), r(h, { ref_key: "tableRef", ref: j, data: e(w).data, "data-format": L.value, "empty-text": e(w).emptyText, "max-height": e(U), "show-empty-symbol": false, stripe: false, returnSourceData: "", "row-key": "id", style: { width: "100%" } }, { default: c(() => [b(n, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e(l).visible("createTime") ? (a(), r(n, { key: "createTime", prop: "createTime", label: "退货日期", align: "center", width: "140", "show-overflow-tooltip": true, fixed: "left" }, { default: c(({ row: t }) => [m("span", null, u(t.createTime ? e(I)(t.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })) : s("", true), e(l).visible("rejectSn") ? (a(), r(n, { key: "rejectSn", prop: "rejectSn", label: "外购退货单号", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), e(l).visible("projectName") ? (a(), r(n, { key: "projectName", prop: "projectName", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: c(({ row: t }) => {
      var p, T;
      return [m("span", null, u(t.project ? ((p = t.project) == null ? void 0 : p.serialNumber) + " " + ((T = t.project) == null ? void 0 : T.name) : "-"), 1)];
    }), _: 1 })) : s("", true), e(l).visible("supplier.name") ? (a(), r(n, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), e(l).visible("purchaseSn") ? (a(), r(n, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : s("", true), e(l).visible("productType") ? (a(), r(n, { key: "productType", prop: "productType", label: "材料类型", align: "center", "min-width": "135", "show-overflow-tooltip": true }, { default: c((t) => [(a(true), d(O, null, W(e(te)(e(ae).getBits(e(y), t.row.productType, "V")), (p) => (a(), r(f, { style: { "margin-right": "5px" }, key: p, type: e(y).V[p].T, effect: "light", "disable-transitions": "" }, { default: c(() => [R(u(e(y).VL[p]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), e(l).visible("monomer") ? (a(), r(n, { key: "monomer", prop: "monomer", label: "单体区域/批次", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: c(({ row: t }) => {
      var p, T, A, E, x;
      return [t.productType === e(y).STRUCTURE.V ? (a(), d("span", ce, u(((p = t.monomer) != null && p.name || (T = t == null ? void 0 : t.area) != null && T.name) && (((A = t.monomer) == null ? void 0 : A.name) || "->" + ((E = t == null ? void 0 : t.area) == null ? void 0 : E.name)) || "-"), 1)) : t.productType === e(y).ENCLOSURE.V ? (a(), d("span", ue, u(((x = t.batch) == null ? void 0 : x.name) || "-"), 1)) : (a(), d("span", me, "-"))];
    }), _: 1 })) : s("", true), e(l).visible("name") ? (a(), r(n, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true })) : s("", true), e(l).visible("serialNumber") ? (a(), r(n, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true })) : s("", true), e(l).visible("specification") ? (a(), r(n, { key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: c(({ row: t }) => [t.productType === e(y).RAW_MATERIAL.V ? (a(), r(g, { key: 0, content: e(oe)(t), placement: "left" }, { default: c(() => [m("span", null, u(e(ie)(t)), 1)]), _: 2 }, 1032, ["content"])) : (a(), d("span", de, u(t.specification || "-"), 1))]), _: 1 })) : s("", true), e(l).visible("rejectQuantity") ? (a(), r(n, { key: "rejectQuantity", prop: "rejectQuantity", label: "退货数", align: "center", "show-overflow-tooltip": true }, { default: c(({ row: t }) => [m("span", null, u(t.rejectQuantity || "-"), 1), m("span", null, u(t.measureUnit || ""), 1)]), _: 1 })) : s("", true), e(l).visible("rejectMete") ? (a(), r(n, { key: "rejectMete", prop: "rejectMete", label: "退货量", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: c(({ row: t }) => {
      var p;
      return [m("span", null, u(((p = t.rejectMete) == null ? void 0 : p.toFixed(t.accountingPrecision)) || "-"), 1), m("span", null, u(t.accountingUnit || ""), 1)];
    }), _: 1 })) : s("", true), e(l).visible("applicantName") ? (a(), r(n, { key: "applicantName", prop: "applicantName", label: "退货人", align: "center", "show-overflow-tooltip": true, width: "100", fixed: "right" })) : s("", true), e(l).visible("reviewerName") ? (a(), r(n, { key: "reviewerName", prop: "reviewerName", label: "审核人", align: "center", "show-overflow-tooltip": true, width: "100", fixed: "right" })) : s("", true), e(l).visible("reviewTime") ? (a(), r(n, { key: "reviewTime", prop: "reviewTime", label: "审核日期", align: "center", width: "140", "show-overflow-tooltip": true, fixed: "right" }, { default: c(({ row: t }) => [m("span", null, u(t.reviewTime ? e(I)(t.reviewTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[o, e(w).loading]]), b(e(ne))])) : (a(), d("div", ye, [b(f, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: c(() => _[0] || (_[0] = [R(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, ve = z(_e, [["__scopeId", "data-v-daa64bd2"]]);
export {
  ve as default
};
