import { ref as c } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as C } from "vue";
import { withCtx as y } from "vue";
import { ElTableColumn as k } from "element-plus";
import { vLoading as R } from "element-plus";
import { p as w } from "../../../../../modules/scheduling-work-order-cf0c3c01.js";
import { d as B } from "../../../../../modules/enclosure-365a2177.js";
import { x as D, o as H } from "../../../../../shared/runtime.js";
import M from "./module/header.vue.js";
const S = { class: "app-container" }, q = { __name: "index", emits: ["project-change"], setup(E, { emit: p }) {
  const m = p, d = { add: false, edit: false, del: false, download: false }, s = c(), i = c({}), h = c([["project", "parse-project"]]), { crud: o, CRUD: f } = D({ title: "排产工单-项目列表", sort: [], permission: { ...B }, optShow: { ...d }, crudApi: { get: w }, hasPagination: false }, s), { maxHeight: u } = H({ extraBox: ".project-head-container" });
  function _(e) {
    i.value = (e == null ? void 0 : e.project) || {}, m("project-change", i.value);
  }
  return f.HOOK.handleRefresh = async (e, { data: n }) => {
    n.content = n.map((a) => ({ project: { ...a } }));
  }, (e, n) => {
    const a = k, g = j("common-table"), x = R;
    return l(), b("div", S, [r(t(M), { class: "head-container project-head-container" }), v((l(), C(g, { ref_key: "tableRef", ref: s, "data-format": h.value, data: t(o).data, "highlight-current-row": "", "empty-text": t(o).emptyText, "max-height": t(u), onCurrentChange: _ }, { default: y(() => [r(a, { label: "序号", type: "index", align: "center", width: "55" }), r(a, { key: "project", prop: "project", label: "项目列表", "min-width": "100", align: "center" })]), _: 1 }, 8, ["data-format", "data", "empty-text", "max-height"])), [[x, t(o).loading]])]);
  };
} };
export {
  q as default
};
