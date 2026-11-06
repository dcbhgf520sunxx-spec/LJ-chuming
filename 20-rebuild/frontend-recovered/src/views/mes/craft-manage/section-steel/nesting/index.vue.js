import { ref as u } from "vue";
import { watch as c } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as k } from "vue";
import { unref as e } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as S } from "vue";
import { createTextVNode as C } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTag as V } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as R } from "./list-detail/index.vue.js";
import { x as T, nu as q, o as A, nm as g } from "../../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import I from "./project-detail/index.vue.js";
import "../../../../../modules/SingleFileUploadBtn-17bec156.js";
const L = { class: "app-container" }, M = { class: "head-container" }, P = { style: { display: "flex" } }, O = { __name: "index", setup(U) {
  const f = { add: false, edit: false, del: false, download: false }, d = u(), o = u({}), { crud: t, columns: x } = T({ title: "型材套料", sort: [], optShow: { ...f }, permission: { ...q }, crudApi: { ...R }, hasPagination: true }, d);
  c(() => t.query.year, (a) => {
    o.value = {};
  }), c(() => t.query.projectId, (a) => {
    o.value = {};
  }), c(() => t.query.nestingStatusEnum, (a) => {
    o.value = {};
  });
  function w(a) {
    console.log(a, "row"), o.value = a;
  }
  const { maxHeight: y } = A({ extraBox: [".head-container"], paginate: true });
  return (a, m) => {
    const i = D, v = V, b = E("common-table"), j = B;
    return p(), N("div", L, [r("div", M, [n(H)]), r("div", P, [k((p(), _(b, { ref_key: "tableRef", ref: d, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(y), "highlight-current-row": "", "row-key": "projectId", style: { width: "35%" }, onRowClick: w }, { default: l(() => [n(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(x).visible("projectName") ? (p(), _(i, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目" }, { default: l((s) => [r("span", null, h(s.row.projectName), 1)]), _: 1 })) : S("", true), n(i, { align: "center", key: "nestingStatusEnum", prop: "nestingStatusEnum", "show-overflow-tooltip": true, label: "状态" }, { default: l((s) => [n(v, { style: { width: "80px" }, type: e(g).V[s.row.nestingStatusEnum].T }, { default: l(() => [C(h(e(g).VL[s.row.nestingStatusEnum]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[j, e(t).loading]]), m[0] || (m[0] = r("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), n(I, { "project-data": o.value, style: { flex: "1" } }, null, 8, ["project-data"])])]);
  };
} };
export {
  O as default
};
