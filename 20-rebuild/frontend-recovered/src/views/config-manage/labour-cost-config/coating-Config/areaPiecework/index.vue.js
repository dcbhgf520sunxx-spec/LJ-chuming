import { ref as f } from "vue";
import { inject as A } from "vue";
import { computed as g } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as H } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as r, o as R, x as T, ed as d, D as x, ee as k, G as B, an as I } from "../../../../../shared/runtime.js";
import j from "./module/form.vue.js";
import E from "./module/header.vue.js";
function L(e) {
  return r({ module: "mes", url: "coating", method: "get", params: e });
}
function q(e) {
  return r({ module: "mes", url: "coating", method: "put", data: e });
}
function F(e) {
  return r({ module: "mes", url: "coating", method: "put", data: e });
}
function K(e) {
  return r({ module: "mes", url: `coating/${e}`, method: "delete" });
}
const Y = { get: L, add: q, edit: F, del: K };
function G(e) {
  return r({ module: "mes", url: "coating", method: "get", params: e });
}
function z(e) {
  return r({ module: "mes", url: "coating", method: "put", data: e });
}
function J(e) {
  return r({ module: "mes", url: "coating", method: "put", data: e });
}
function Q(e) {
  return r({ module: "mes", url: `coating/${e}`, method: "delete" });
}
const W = { get: G, add: z, edit: J, del: Q }, X = { class: "app-container" }, Z = { class: "head-container" }, ae = { __name: "index", setup(e) {
  const m = f(), p = f(), { maxHeight: b } = R({ paginate: true }), v = { add: true, edit: false, del: false, download: false }, o = A("projectData"), y = g(() => o ? W : Y), { crud: i, CRUD: h } = T({ title: "涂装配置", permission: { ...d }, optShow: { ...v }, crudApi: { ...y.value }, dataPath: "content", hasPagination: false }, m), P = g(() => [["unitPrice", ["to-thousand", x.YUAN]], ["outUnitPrice", ["to-thousand", x.YUAN]]]);
  return h.HOOK.beforeRefresh = (s, C) => {
    o && (s.query.projectId = o == null ? void 0 : o.contractProjectId, s.dataPath = "content");
  }, h.HOOK.beforeToAdd = () => {
    o && (i.form.contractProjectId = o == null ? void 0 : o.contractProjectId);
  }, (s, C) => {
    const a = N, M = $("common-table"), U = O;
    return c(), D("div", X, [w("div", Z, [n(t(E), { measurementManner: p.value }, null, 8, ["measurementManner"])]), S((c(), _(M, { ref_key: "tableRef", ref: m, data: t(i).data, "empty-tet": t(i).emptyText, "data-format": P.value, "max-height": t(b), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(i).selectionChangeHandler }, { default: u(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "油漆类型", align: "center", "min-width": "100px" }), n(a, { key: "measurementManner", prop: "measurementManner", "show-overflow-tooltip": true, label: "计量方式", align: "center", "min-width": "140px" }, { default: u(({ row: l }) => [w("span", null, V(t(k).VL[l.measurementManner] || t(k).VL[l.measureUnit]), 1)]), _: 1 }), n(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "标准厚度", align: "center", "min-width": "100px" }), n(a, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "标准单价", align: "center", "min-width": "100px" }), n(a, { key: "outThickness", prop: "outThickness", "show-overflow-tooltip": true, label: "超标", align: "center", "min-width": "100px" }), n(a, { key: "outUnitPrice", prop: "outUnitPrice", "show-overflow-tooltip": true, label: "单价", align: "center", "min-width": "100px" }), t(B)([...t(d).edit, ...t(d).del]) ? (c(), _(a, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((l) => [n(t(I), { data: l.row }, null, 8, ["data"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "empty-tet", "data-format", "max-height", "onSelectionChange"])), [[U, t(i).loading]]), n(t(j), { measurementManner: p.value }, null, 8, ["measurementManner"])]);
  };
} };
export {
  ae as default
};
