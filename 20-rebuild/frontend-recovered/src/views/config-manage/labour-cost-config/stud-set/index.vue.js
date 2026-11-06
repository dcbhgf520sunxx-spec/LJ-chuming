import { ref as k } from "vue";
import { computed as h } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as n } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as O } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as R } from "../../../../modules/stud-set-1d850c87.js";
import { l as d, o as S, x as B, ex as m, D as I, G as V, an as T } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
import $ from "./module/form.vue.js";
function q(t) {
  return d({ url: "/api/system/project-bolt-sleeve/list", method: "get", params: t });
}
function E(t) {
  return d({ url: "/api/system/project-bolt-sleeve", method: "post", data: t });
}
function K(t) {
  return d({ url: "/api/system/project-bolt-sleeve", method: "put", data: t });
}
function M(t) {
  return d({ url: `/api/system/project-bolt-sleeve/${t}`, method: "delete" });
}
const F = { get: q, add: E, edit: K, del: M }, G = { class: "app-container" }, L = { class: "head-container" }, X = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(t) {
  const i = t, u = k(), { maxHeight: b } = S({ paginate: true }), g = h(() => i.projectData ? F : R), v = { add: true, edit: false, del: false, download: false }, { crud: s, columns: l, CRUD: f } = B({ title: "栓钉套筒", permission: { ...m }, optShow: { ...v }, crudApi: { ...g.value }, dataPath: "", hasPagination: false }, u), w = h(() => [["price", ["to-thousand", I.YUAN]]]);
  return f.HOOK.beforeRefresh = (r, y) => {
    var o;
    i.projectData && (r.query.projectId = (o = i.projectData) == null ? void 0 : o.contractProjectId, r.dataPath = "content");
  }, f.HOOK.beforeToAdd = () => {
    var r;
    i.projectData && (s.form.contractProjectId = (r = i.projectData) == null ? void 0 : r.contractProjectId);
  }, (r, y) => {
    const o = O, x = C("common-table"), j = H;
    return a(), P("div", G, [N("div", L, [p(e(U))]), A((a(), n(x, { ref_key: "tableRef", ref: u, data: e(s).data, "empty-text": e(s).emptyText, "data-format": w.value, "max-height": e(b), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(s).selectionChangeHandler }, { default: _(() => [p(o, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("type") ? (a(), n(o, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "类型", align: "center", "min-width": "100px" })) : c("", true), e(l).visible("processName") ? (a(), n(o, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "绑定工序", align: "center", "min-width": "140px" })) : c("", true), e(l).visible("unit") ? (a(), n(o, { key: "unit", prop: "unit", "show-overflow-tooltip": true, label: "计量单位", align: "center", "min-width": "100px" })) : c("", true), e(l).visible("price") ? (a(), n(o, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价", align: "center", "min-width": "100px" })) : c("", true), e(V)([...e(m).edit, ...e(m).del]) ? (a(), n(o, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: _((D) => [p(e(T), { data: D.row }, null, 8, ["data"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSelectionChange"])), [[j, e(s).loading]]), p(e($))]);
  };
} };
export {
  X as default
};
