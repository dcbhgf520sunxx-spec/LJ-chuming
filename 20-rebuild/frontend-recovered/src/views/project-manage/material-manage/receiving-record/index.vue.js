import { ref as v } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as E } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as M, _ as A, m as S, x as N, o as P, cO as V, tR as d, tS as w, jl as B, pz as H, pA as L, P as F } from "../../../../shared/runtime.js";
import { D as x } from "../../../../modules/project-19a12d6b.js";
import K from "./module/header.vue.js";
import "../../../../modules/index-8edb1b61.js";
function W(_) {
  return M({ module: "project", url: "receiving/received/page", method: "get", params: _ });
}
const z = { get: W };
const G = { class: "app-container" }, Q = { class: "head-container" }, $ = { key: 1 }, J = { __name: "index", setup(_) {
  const { globalProjectId: f, globalProject: X } = S(["globalProjectId", "globalProject"]), k = { add: false, edit: false, del: false, download: false }, y = v(), { crud: r, CRUD: g } = N({ title: "收货记录", sort: ["id.desc"], permission: { ...x }, optShow: { ...k }, requiredQuery: ["projectId"], crudApi: { ...z }, hasPagination: true }, y);
  g.HOOK.beforeRefresh = () => (r.query.projectId = f.value || void 0, !!r.query.projectId);
  const R = v([["receivedDate", "parse-time"]]), { maxHeight: T } = P({ extraBox: ".head-container", paginate: true, extraHeight: 40 });
  return g.HOOK.handleRefresh = async (h, u) => {
    var e;
    await V(u.data.content), (e = u.data.content) == null || e.forEach(async (p) => {
      h.query.sourceType === d.OUT_SOURCE.V && p.productType === w.RAW_MATERIAL.V && await B(p, { toNum: true }, { quantity: ["quantity"], mete: ["mete", "actualReceivedMete"] });
    });
  }, (h, u) => {
    const e = I, p = O, U = j("common-table"), C = D;
    return i(), b("div", G, [s("div", Q, [a(t(K), { projectId: t(f), permission: t(x) }, null, 8, ["projectId", "permission"])]), q((i(), m(U, { ref_key: "tableRef", ref: y, data: t(r).data, "data-format": R.value, "empty-text": t(r).emptyText, "max-height": t(T), "show-empty-symbol": false, stripe: false, returnSourceData: "", "row-key": "id", style: { width: "100%" } }, { default: n(() => [a(e, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), a(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: n(({ row: o }) => {
      var l;
      return [s("span", null, c(((l = o.monomer) == null ? void 0 : l.name) || "-"), 1)];
    }), _: 1 }), a(e, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: n(({ row: o }) => {
      var l;
      return [s("span", null, c(((l = o.area) == null ? void 0 : l.name) || "-"), 1)];
    }), _: 1 }), a(e, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), a(e, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(e, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: o }) => [t(r).query.sourceType === t(d).OUT_SOURCE.V && o.productType === t(w).RAW_MATERIAL.V ? (i(), m(p, { key: 0, content: t(H)(o), placement: "left" }, { default: n(() => [s("span", null, c(t(L)(o)), 1)]), _: 2 }, 1032, ["content"])) : (i(), b("span", $, c(o.specification || "-"), 1))]), _: 1 }), a(e, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: o }) => [s("span", null, c(o.measureUnit || "-"), 1)]), _: 1 }), a(e, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), a(e, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": true }), a(e, { key: "mete", prop: "mete", label: "核算量", align: "center", "show-overflow-tooltip": true }), t(r).query.sourceType === t(d).OUT_SOURCE.V ? (i(), m(e, { key: "actualReceivedMete", prop: "actualReceivedMete", label: "实收量", align: "center" })) : E("", true), a(e, { key: "userName", prop: "userName", label: "办理人", align: "center", "show-overflow-tooltip": true }), a(e, { key: "receivedDate", prop: "receivedDate", label: "收货日期", align: "center", "min-width": "120", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[C, t(r).loading]]), a(t(F))]);
  };
} }, oe = A(J, [["__scopeId", "data-v-72615583"]]);
export {
  oe as default
};
