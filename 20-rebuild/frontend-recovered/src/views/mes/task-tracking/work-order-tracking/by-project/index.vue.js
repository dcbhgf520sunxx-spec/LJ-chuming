import { ref as h } from "vue";
import { watch as p } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as k } from "vue";
import { unref as e } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as f } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as D } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as R } from "../../../../../modules/project-overview-1b3937a7.js";
import { x as B, rU as q, o as H, z as S, P as O } from "../../../../../shared/runtime.js";
import T from "./module/header.vue.js";
import U from "./project-process-detail/index.vue.js";
import "../../../../../modules/use-product-lines-79a95221.js";
import "./process-detail/index.vue.js";
import "../../../../../modules/production-line-select-f08e245b.js";
const V = { style: { "margin-top": "6px" } }, A = { style: { display: "flex" } }, E = { style: { width: "25%" } }, M = { class: "head-container" }, X = { __name: "index", setup(z) {
  const x = { add: false, edit: false, del: false, download: false }, o = h({}), u = h(), { crud: t, CRUD: g, columns: v } = B({ title: "项目总览", sort: [], optShow: { ...x }, permission: { ...q }, crudApi: { ...R }, hasPagination: true }, u);
  p(() => t.query.year, (a) => {
    o.value = {};
  }), p(() => t.query.status, (a) => {
    o.value = {};
  }), p(() => t.query.name, (a) => {
    o.value = {};
  });
  const { maxHeight: y } = H({ extraBox: [".head-container"], extraHeight: 40, paginate: true });
  function w(a) {
    o.value = a;
  }
  return g.HOOK.handleRefresh = (a, r) => {
    r.data.content = r.data.content.map(({ serialNumber: n, name: l, shortName: c, ...d }) => ({ ...d, project: { serialNumber: n, name: l, shortName: c } }));
  }, (a, r) => {
    const n = N, l = b("common-table"), c = P;
    return m(), j("div", V, [s("div", A, [s("div", E, [s("div", M, [i(T)]), k((m(), _(l, { ref_key: "tableRef", ref: u, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(y), "highlight-current-row": "", returnSourceData: "", "row-key": "projectId", style: { width: "100%", cursor: "pointer" }, onRowClick: w }, { default: f(() => [i(n, { prop: "index", type: "index", label: "序号", align: "center", width: "60" }), e(v).visible("projectName") ? (m(), _(n, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目" }, { default: f((d) => [s("span", null, C(e(S)(d.row.project) || "-"), 1)]), _: 1 })) : D("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[c, e(t).loading]]), i(e(O))]), r[0] || (r[0] = s("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), i(U, { "process-data": o.value, style: { flex: "1" } }, null, 8, ["process-data"])])]);
  };
} };
export {
  X as default
};
