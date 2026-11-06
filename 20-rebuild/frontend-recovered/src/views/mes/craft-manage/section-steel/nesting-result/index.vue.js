import { ref as p } from "vue";
import { watch as u } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as a } from "vue";
import { withDirectives as E } from "vue";
import { unref as e } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as j } from "vue";
import { createTextVNode as C } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElTag as V } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as D } from "./nesting-file/index.vue.js";
import { x as P, nl as T, o as q, nm as g, P as A } from "../../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import L from "./nesting-result-detail/index.vue.js";
import "../../../../../modules/nesting-setting-83aca0bd.js";
const M = { class: "app-container" }, I = { style: { display: "flex" } }, Q = { style: { "min-width": "25%" } }, U = { class: "head-container" }, W = { __name: "index", setup($) {
  const f = { add: false, edit: false, del: false, download: false }, d = p(), n = p({}), { crud: t, columns: x } = P({ title: "套料成果", sort: [], optShow: { ...f }, permission: { ...T }, crudApi: { ...D }, hasPagination: true }, d);
  u(() => t.query.year, (s) => {
    n.value = {};
  }), u(() => t.query.nestingStatusEnum, (s) => {
    n.value = {};
  });
  const { maxHeight: y } = q({ extraBox: [".head-container"], paginate: true });
  function w(s) {
    n.value = s;
  }
  return (s, m) => {
    const r = R, v = V, b = N("common-table"), S = B;
    return c(), k("div", M, [o("div", I, [o("div", Q, [o("div", U, [a(H)]), E((c(), h(b, { ref_key: "tableRef", ref: d, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(y), "highlight-current-row": "", "row-key": "projectId", style: { width: "100%" }, onRowClick: w }, { default: l(() => [a(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(x).visible("projectName") ? (c(), h(r, { "header-align": "center", key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目", "min-width": "160px" }, { default: l(({ row: i }) => [o("span", null, _(i.projectName), 1)]), _: 1 })) : j("", true), a(r, { align: "center", key: "nestingStatusEnum", prop: "nestingStatusEnum", "show-overflow-tooltip": true, label: "状态" }, { default: l(({ row: i }) => [a(v, { style: { width: "80px" }, type: e(g).V[i.nestingStatusEnum].T }, { default: l(() => [C(_(e(g).VL[i.nestingStatusEnum]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, e(t).loading]]), a(e(A))]), m[0] || (m[0] = o("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), a(L, { "batch-row": n.value, onSuccess: e(t).toQuery, style: { flex: "1" } }, null, 8, ["batch-row", "onSuccess"])])]);
  };
} };
export {
  W as default
};
