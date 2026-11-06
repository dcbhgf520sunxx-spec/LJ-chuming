import { computed as N } from "vue";
import { ref as y } from "vue";
import { provide as R } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as D } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as B, _ as H } from "./module/detail.vue.js";
import { a3 as h, x as M, mX as x, o as S, G as j, P as O } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
import "../../../../modules/index-3b2628f3.js";
const $ = { class: "app-container" }, K = { class: "head-container" }, L = { class: "tc-success" }, z = { class: "tc-danger" }, ee = { __name: "index", setup(F) {
  const q = { add: false, edit: false, del: false, download: false }, k = N(() => h.MACHINE_PART.V | h.ASSEMBLE.V | h.ARTIFACT.V), b = y(), { crud: s, columns: d, CRUD: v } = M({ title: "质检报表", sort: [], permission: { ...x }, optShow: { ...q }, crudApi: { ...B }, hasPagination: true }, b), { maxHeight: Q } = S({ paginate: true });
  R("query", s.query), v.HOOK.beforeToQuery = () => {
    s.query.productType = k.value;
  }, v.HOOK.handleRefresh = (f, o) => {
    o.data.content = o.data.content.map((t, _) => (t.rowId = _ + "" + Math.random(), t.qualifiedQuantity = t.inspectionQuantity - t.qhseQuantity, t));
  };
  const m = y(false), g = y({});
  function C(f) {
    m.value = true, g.value = f;
  }
  return (f, o) => {
    const t = E, _ = w("common-button"), I = w("common-table"), T = P;
    return n(), V("div", $, [r("div", K, [u(e(U))]), A((n(), l(I, { ref_key: "tableRef", ref: b, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(Q), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [u(t, { label: "序号", type: "index", align: "center", width: "60" }), e(d).visible("userName") ? (n(), l(t, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "检验人" }, { default: i(({ row: a }) => [r("span", null, p(a.userName), 1)]), _: 1 })) : c("", true), e(d).visible("inspectionQuantity") ? (n(), l(t, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "inspectionQuantity", label: "检验数" }, { default: i(({ row: a }) => [r("span", null, p(a.inspectionQuantity), 1)]), _: 1 })) : c("", true), e(d).visible("qualifiedQuantity") ? (n(), l(t, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "qualifiedQuantity", label: "合格数" }, { default: i(({ row: a }) => [r("span", L, p(a.qualifiedQuantity), 1)]), _: 1 })) : c("", true), e(d).visible("qhseQuantity") ? (n(), l(t, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "qhseQuantity", label: "不合格数" }, { default: i(({ row: a }) => [r("span", z, p(a.qhseQuantity), 1)]), _: 1 })) : c("", true), e(j)(e(x).detail) ? (n(), l(t, { key: 4, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: i(({ row: a }) => [u(_, { size: "default", type: "primary", onClick: (G) => C(a) }, { default: i(() => o[1] || (o[1] = [D("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, e(s).loading]]), u(e(O)), u(e(H), { visible: m.value, "onUpdate:visible": o[0] || (o[0] = (a) => m.value = a), info: g.value, projectId: e(s).query.projectId }, null, 8, ["visible", "info", "projectId"])]);
  };
} };
export {
  ee as default
};
