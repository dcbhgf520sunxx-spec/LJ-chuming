import { ref as w } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { unref as e } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as m } from "vue";
import { createTextVNode as q } from "vue";
import { ElTableColumn as C } from "element-plus";
import { ElTooltip as V } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as P } from "../../../../../modules/report-list-f9da4d70.js";
import { _ as M, m as B, mw as D, x as H, bN as k, o as F, cO as W, tR as y, tS as _, jl as z, kM as x, pz as K, pA as G, P as Q } from "../../../../../shared/runtime.js";
import { e as $ } from "../../../../../modules/project-19a12d6b.js";
import J from "./module/header.vue.js";
import "../../../../../modules/area-ca564e60.js";
import "../../../../../modules/index-8edb1b61.js";
const X = { class: "app-container" }, Y = { key: 0 }, Z = { class: "head-container" }, ee = { key: 1 }, te = { key: 1 }, oe = { __name: "index", setup(ae) {
  const { globalProjectId: f, globalProject: u } = B(["globalProjectId", "globalProject"]), R = { add: false, edit: false, del: false, download: false }, g = w(), E = w([["areaType", ["parse-enum", D]]]), { crud: a, CRUD: h } = H({ title: "收货报表", sort: ["id.desc"], permission: { ...$ }, requiredQuery: ["projectId", "productType"], optShow: { ...R }, crudApi: { ...P }, hasPagination: true }, g);
  h.HOOK.beforeRefresh = () => (a.query.projectId = u.value.businessType === k.INSTALLATION.V ? f.value : void 0, !!a.query.projectId);
  const { maxHeight: A } = F({ extraBox: ".head-container", paginate: true, extraHeight: 40 });
  return h.HOOK.handleRefresh = async (T, l) => {
    var t;
    await W(l.data.content), (t = l.data.content) == null || t.forEach(async (i) => {
      T.query.sourceType === y.OUT_SOURCE.V && i.productType === _.RAW_MATERIAL.V && await z(i, { toNum: true }, { quantity: ["quantity"], mete: ["mete", "actualReceivedMete"] });
    });
  }, (T, l) => {
    var b;
    const t = C, i = V, I = U("common-table"), N = L, O = S;
    return r(), p("div", X, [((b = e(u)) == null ? void 0 : b.businessType) === e(k).INSTALLATION.V ? (r(), p("div", Y, [d("div", Z, [o(e(J), { projectId: e(f), globalProject: e(u) }, null, 8, ["projectId", "globalProject"])]), j((r(), c(I, { ref_key: "tableRef", ref: g, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(A), stripe: false, "data-format": E.value, "row-key": "id", style: { width: "100%" } }, { default: s(() => [o(t, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(a).query.productType !== e(x).ENCLOSURE.V ? (r(), c(t, { "show-overflow-tooltip": true, key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" })) : v("", true), o(t, { "show-overflow-tooltip": true, key: "area.name", prop: "area.name", label: e(a).query.productType !== e(x).ENCLOSURE.V ? "区域" : "批次", align: "center" }, null, 8, ["label"]), o(t, { "show-overflow-tooltip": true, key: "name", prop: "name", label: "名称", align: "center" }), o(t, { "show-overflow-tooltip": true, key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), o(t, { "show-overflow-tooltip": true, key: "specification", prop: "specification", label: "规格", align: "center" }, { default: s(({ row: n }) => [e(a).query.sourceType === e(y).OUT_SOURCE.V && n.productType === e(_).RAW_MATERIAL.V ? (r(), c(i, { key: 0, content: e(K)(n), placement: "left" }, { default: s(() => [d("span", null, m(e(G)(n)), 1)]), _: 2 }, 1032, ["content"])) : (r(), p("span", ee, m(n.specification || "-"), 1))]), _: 1 }), o(t, { "show-overflow-tooltip": true, key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }, { default: s(({ row: n }) => [d("span", null, m(n.measureUnit || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": true, key: "quantity", prop: "quantity", label: "数量", align: "center" }), o(t, { "show-overflow-tooltip": true, key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), o(t, { "show-overflow-tooltip": true, key: "mete", prop: "mete", label: "核算量", align: "center" }), e(a).query.sourceType === e(y).OUT_SOURCE.V && e(a).query.productType === e(_).RAW_MATERIAL.V ? (r(), c(t, { "show-overflow-tooltip": true, key: "actualReceivedMete", prop: "actualReceivedMete", label: "实收量", align: "center" })) : v("", true), o(t, { "show-overflow-tooltip": true, key: "areaType", prop: "areaType", label: "属性", align: "center" }), o(t, { "show-overflow-tooltip": true, key: "supplierName", prop: "supplierName", label: "供应商", align: "center", "min-width": "140" })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[O, e(a).loading]]), o(e(Q))])) : (r(), p("div", te, [o(N, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: s(() => l[0] || (l[0] = [q(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, ue = M(oe, [["__scopeId", "data-v-25e51cf2"]]);
export {
  ue as default
};
