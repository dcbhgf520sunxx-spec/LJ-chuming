import { ref as g } from "vue";
import { watch as I } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as _ } from "vue";
import { unref as e } from "vue";
import { Fragment as S } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as d } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as r } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as L } from "vue";
import { toDisplayString as k } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElTag as N } from "element-plus";
import { vLoading as q } from "element-plus";
import { l as h, m as A, x as F, o as G, mw as C, p as K, G as Q, an as U, P as z } from "../../../../shared/runtime.js";
import { b as f } from "../../../../modules/plan-d12d7ccf.js";
import $ from "./module/header.vue.js";
import J from "./module/form.vue.js";
function W(o) {
  return h({ module: "plan", url: "area", method: "get", params: o });
}
function X(o) {
  return h({ module: "plan", url: "area", method: "post", data: o });
}
function Y(o) {
  return h({ module: "plan", url: "area", method: "put", data: o });
}
function Z(o) {
  return h({ module: "plan", url: "area", method: "delete", data: o });
}
const ee = { add: X, edit: Y, del: Z, get: W }, te = { class: "app-container" }, ae = { class: "head-container" }, oe = { key: 1, style: { color: "red", "font-size": "14px" } }, pe = { __name: "index", setup(o) {
  const { globalProject: c, globalProjectId: m } = A(["globalProject", "globalProjectId"]), T = { add: true, edit: false, del: false, download: false }, b = g(), w = g([]), v = g({}), { crud: n, columns: p, CRUD: x } = F({ title: "区域", sort: ["sort.asc", "id.desc"], permission: { ...f.value }, optShow: { ...T }, requiredQuery: ["productType"], crudApi: { ...ee }, hasPagination: true }, b), { maxHeight: M } = G({ wrapperBox: ".area", paginate: true, extraHeight: 40 });
  I(() => m.value, (l) => {
    l && (n.query.projectId = m.value, n.toQuery());
  }, { immediate: true, deep: true });
  function P(l) {
    v.value = l || {};
  }
  function D(l) {
    w.value = l || [];
  }
  return x.HOOK.handleRefresh = (l, y) => {
    y.data.content = y.data.content.map((t) => (t.typeTagType = t.type === C.HOMEMADE.V ? "primary" : "warning", t));
  }, x.HOOK.beforeSubmit = () => (n.form.projectId = m.value, !!n.form.projectId), (l, y) => {
    const t = R, V = N, E = O("common-table"), H = q;
    return a(), _("div", te, [e(c) && e(c).projectContentList && e(c).projectContentList.length > 0 ? (a(), _(S, { key: 0 }, [j("div", ae, [d(e($), { "project-id": e(m), onMonomerChangeType: D, onMonomerValChange: P, "global-project": e(c) }, null, 8, ["project-id", "global-project"])]), B((a(), r(E, { ref_key: "tableRef", ref: b, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(M), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: u(() => [d(t, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("name") ? (a(), r(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "区域名称", "min-width": "100" })) : s("", true), e(p).visible("axis") ? (a(), r(t, { key: "axis", prop: "axis", "show-overflow-tooltip": true, label: "轴线/标高", "min-width": "160" })) : s("", true), e(p).visible("type") ? (a(), r(t, { key: "type", prop: "type", label: "制造方式", width: "80" }, { default: u((i) => [d(V, { effect: "plain", type: i.row.typeTagType }, { default: u(() => [L(k(e(C).VL[i.row.type]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), e(p).visible("date") ? (a(), r(t, { key: "endDate", prop: "endDate", label: "完成时间", align: "center", width: "180px" }, { default: u((i) => [j("span", null, k(i.row.date ? e(K)(i.row.date, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : s("", true), e(p).visible("sort") ? (a(), r(t, { key: "sort", prop: "sort", label: "排序", align: "center", "min-width": "80" })) : s("", true), e(p).visible("remark") ? (a(), r(t, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "140" })) : s("", true), e(Q)([...e(f).edit, ...e(f).del]) ? (a(), r(t, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((i) => [d(e(U), { data: i.row, permission: e(f) }, null, 8, ["data", "permission"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, e(n).loading]]), d(e(z)), d(e(J), { "project-id": e(m), "type-info": w.value, "global-project": e(c), currentMonomer: v.value }, null, 8, ["project-id", "type-info", "global-project", "currentMonomer"])], 64)) : (a(), _("div", oe, "*请先前去合同管理模块添加项目内容"))]);
  };
} };
export {
  pe as default
};
