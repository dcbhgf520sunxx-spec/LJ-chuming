import { watch as s } from "vue";
import { ref as m } from "vue";
import { provide as d } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as a } from "vue";
import { unref as r } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as k } from "vue";
import { withCtx as Q } from "vue";
import { ElTableColumn as C } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as R } from "./project-detail/module/from.vue.js";
import { m as q, o as I, x as S, ba as T } from "../../../../../shared/runtime.js";
import B from "./project-detail/index.vue.js";
import N from "./module/header.vue.js";
import "../../../../../modules/coating-list-667107a8.js";
import "./project-detail/module/header.vue.js";
const j = { style: { display: "flex", "margin-top": "20px" } }, A = { style: { "min-width": "24%" } }, H = { class: "head-container" }, J = { __name: "index", setup(P) {
  const { globalProjectId: u } = q(["globalProjectId"]), f = { add: false, edit: false, del: false, download: false };
  s(() => u.value, (e) => {
    e && (o.value = {});
  });
  const n = m(), { maxHeight: y } = I({ paginate: true, extraHeight: "290px" }), o = m(), { crud: t, CRUD: E } = S({ title: "清单详情", optShow: { ...f }, crudApi: { ...R }, hasPagination: false }, n);
  d("query", t.query), d("getArtiList", t.toQuery);
  const _ = (e) => {
    o.value = e;
  };
  s(() => t.query.monomerId, (e) => {
    e && (o.value = {});
  }), s(() => t.query.areaId, (e) => {
    e && (o.value = {});
  });
  function g(e) {
    return T(e, { props: ["listQuantity"] });
  }
  return (e, c) => {
    const i = C, h = b("common-table"), x = D;
    return p(), v("div", j, [l("div", A, [l("div", H, [a(r(N))]), w((p(), k(h, { ref_key: "tableRef", ref: n, data: r(t).data, "empty-text": r(t).emptyText, "max-height": r(y), "highlight-current-row": "", "show-summary": "", returnSourceData: "", "summary-method": g, "row-key": "artifactTypeId", onRowClick: _ }, { default: Q(() => [a(i, { label: "类型", prop: "artifactTypeName", key: "artifactTypeName", align: "center" }), a(i, { label: "清单数量", prop: "listQuantity", key: "listQuantity", align: "center" }), a(i, { label: "可操作数量", prop: "operableQuantity", key: "operableQuantity", align: "center" }), a(i, { label: "已关联", prop: "associatedQuantity", key: "associatedQuantity", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, r(t).loading]])]), c[0] || (c[0] = l("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px" } }, null, -1)), a(B, { "artifact-data": o.value, style: { flex: "1" } }, null, 8, ["artifact-data"])]);
  };
} };
export {
  J as default
};
