import { ref as y } from "vue";
import { provide as I } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as R } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as j, _ as B } from "./module/detail.vue.js";
import { c as v } from "../../../../modules/bridge-86f96a4f.js";
import { x as H, o as M, G as S, P as T } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
import "../../../../modules/index-5ab69a0f.js";
const $ = { class: "app-container" }, A = { class: "head-container" }, E = { class: "tc-success" }, O = { class: "tc-danger" }, Y = { __name: "index", setup(z) {
  const w = { add: false, edit: false, del: false, download: false }, h = y(), { crud: l, columns: d, CRUD: x } = H({ title: "质检报表", sort: [], permission: { ...v }, optShow: { ...w }, crudApi: { ...j }, hasPagination: true }, h), { maxHeight: k } = M({ paginate: true });
  I("query", l.query), x.HOOK.handleRefresh = (f, o) => {
    o.data.content = o.data.content.map((t, _) => (t.rowId = _ + "" + Math.random(), t.qualifiedQuantity = t.inspectionQuantity - t.qhseQuantity, t));
  };
  const m = y(false), b = y({});
  function Q(f) {
    m.value = true, b.value = f;
  }
  return (f, o) => {
    const t = P, _ = g("common-button"), q = g("common-table"), C = V;
    return i(), N("div", $, [r("div", A, [c(e(U))]), D((i(), s(q, { ref_key: "tableRef", ref: h, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(k), "row-key": "rowId", style: { width: "100%" } }, { default: n(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), e(d).visible("userName") ? (i(), s(t, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "检验人" }, { default: n(({ row: a }) => [r("span", null, p(a.userName), 1)]), _: 1 })) : u("", true), e(d).visible("inspectionQuantity") ? (i(), s(t, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "inspectionQuantity", label: "检验数" }, { default: n(({ row: a }) => [r("span", null, p(a.inspectionQuantity), 1)]), _: 1 })) : u("", true), e(d).visible("qualifiedQuantity") ? (i(), s(t, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "qualifiedQuantity", label: "合格数" }, { default: n(({ row: a }) => [r("span", E, p(a.qualifiedQuantity), 1)]), _: 1 })) : u("", true), e(d).visible("qhseQuantity") ? (i(), s(t, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "qhseQuantity", label: "不合格数" }, { default: n(({ row: a }) => [r("span", O, p(a.qhseQuantity), 1)]), _: 1 })) : u("", true), e(S)(e(v).detail) ? (i(), s(t, { key: 4, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: n(({ row: a }) => [c(_, { size: "default", type: "primary", onClick: (G) => Q(a) }, { default: n(() => o[1] || (o[1] = [R("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, e(l).loading]]), c(e(T)), c(e(B), { visible: m.value, "onUpdate:visible": o[0] || (o[0] = (a) => m.value = a), info: b.value, projectId: e(l).query.projectId }, null, 8, ["visible", "info", "projectId"])]);
  };
} };
export {
  Y as default
};
