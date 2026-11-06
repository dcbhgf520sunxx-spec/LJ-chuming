import { ref as m } from "vue";
import { watch as n } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as j } from "vue";
import { unref as a } from "vue";
import { createBlock as u } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as k } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as R } from "../../../../../modules/project-overview-1b3937a7.js";
import { x as B, pH as q, o as H, P as S } from "../../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import V from "./project-process-detail/index.vue.js";
import "../../../../../modules/use-product-lines-79a95221.js";
import "./process-detail/index.vue.js";
import "../../../../../modules/production-line-select-f08e245b.js";
const A = { class: "app-container" }, E = { style: { display: "flex" } }, M = { style: { width: "25%" } }, T = { class: "head-container" }, W = { __name: "index", setup(U) {
  const f = { add: false, edit: false, del: false, download: false }, o = m({}), c = m(), { crud: e, CRUD: v, columns: x } = B({ title: "项目总览", sort: [], optShow: { ...f }, permission: { ...q }, crudApi: { ...R }, hasPagination: true }, c);
  n(() => e.query.year, (t) => {
    o.value = {};
  }), n(() => e.query.status, (t) => {
    o.value = {};
  }), n(() => e.query.name, (t) => {
    o.value = {};
  });
  const { maxHeight: g } = H({ extraBox: [".head-container"], paginate: true });
  function w(t) {
    o.value = t;
  }
  return v.HOOK.handleRefresh = (t, i) => {
  }, (t, i) => {
    const d = N, y = C("common-table"), b = P;
    return l(), D("div", A, [r("div", E, [r("div", M, [r("div", T, [s(O)]), j((l(), u(y, { ref_key: "tableRef", ref: c, data: a(e).data, "empty-text": a(e).emptyText, "max-height": a(g), "highlight-current-row": "", returnSourceData: "", "row-key": "projectId", style: { width: "100%", cursor: "pointer" }, onRowClick: w }, { default: h(() => [s(d, { prop: "index", type: "index", label: "序号", align: "center", width: "60" }), a(x).visible("projectName") ? (l(), u(d, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目" }, { default: h((p) => [r("span", null, _(p.row.serialNumber) + "-" + _(p.row.name), 1)]), _: 1 })) : k("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[b, a(e).loading]]), s(a(S))]), i[0] || (i[0] = r("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), s(V, { "process-data": o.value, style: { flex: "1" } }, null, 8, ["process-data"])])]);
  };
} };
export {
  W as default
};
