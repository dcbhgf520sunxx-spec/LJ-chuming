import { computed as G } from "vue";
import { ref as h } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as c } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as N } from "vue";
import { Fragment as T } from "vue";
import { renderList as V } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as F } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElImage as M } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as J, m as W } from "./module/detail.vue.js";
import { _ as X, t as Y, x as Z, o as ee, ub as te, G as v, c3 as q, P as ae } from "../../../../shared/runtime.js";
import { K as m } from "../../../../modules/project-19a12d6b.js";
import oe from "./module/header.vue.js";
const le = { class: "app-container" }, se = { class: "imgs-box" }, re = { class: "imgs-box" }, ne = { __name: "index", setup(ie) {
  const { decimalPrecision: P } = Y(), E = { add: false, edit: false, del: false, download: false }, j = G(() => [["problemDate", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["penalty", ["to-thousand", P.value.project]]]), C = h(), y = h(false), p = h({}), x = h("detail"), { crud: g, CRUD: z, columns: I } = Z({ title: "质安管理", sort: [], permission: { ...m }, optShow: { ...E }, crudApi: { ...J }, hasPagination: true }, C), { maxHeight: H } = ee({ paginate: true, extraHeight: 40 });
  function _(r, n) {
    var t, s, f;
    p.value = r.sourceRow, p.value.beforeImgSrc = r.sourceRow.beforeImgSrc, p.value.afterImgSrc = r.sourceRow.afterImgSrc, p.value.auditStatus = (t = r.sourceRow.qhseChange) == null ? void 0 : t.auditStatus, p.value.problemDesc = (s = r.sourceRow.qhseChange) == null ? void 0 : s.problemDesc, p.value.afterChangeImgs = (f = r.sourceRow.qhseChange) == null ? void 0 : f.afterChangeImgs, x.value = n, y.value = true;
  }
  return z.HOOK.handleRefresh = (r, { data: n }) => {
    n.content.forEach((t) => {
      t.beforeImgSrc = t.beforeChangeImgs && t.beforeChangeImgs.map((s) => s.imageUrl), t.afterImgSrc = t.afterChangeImgs && t.afterChangeImgs.map((s) => s.imageUrl);
    });
  }, (r, n) => {
    const t = K, s = M, f = O, b = R("common-button"), A = R("common-table"), B = L("permission"), $ = Q;
    return l(), w("div", le, [o(e(oe)), D((l(), c(A, { ref_key: "tableRef", ref: C, data: e(g).data, "data-format": j.value, "empty-text": e(g).emptyText, "max-height": e(H), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: u(() => [o(t, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), o(t, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), o(t, { key: "supplierName", prop: "supplierName", label: "分包单位", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "subcontractClassName", prop: "subcontractClassName", label: "分类", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "problemDate", prop: "problemDate", label: "日期", align: "center", "show-overflow-tooltip": "", width: "100" }), o(t, { key: "promoterName", prop: "promoterName", label: "发起人", align: "center", "show-overflow-tooltip": "", width: "100" }), o(t, { key: "problemTypeName", prop: "problemTypeName", label: "问题分类", align: "center", "show-overflow-tooltip": "" }), e(I).visible("beforeChangeImgs") ? (l(), c(t, { key: "beforeChangeImgs", prop: "beforeChangeImgs", "show-overflow-tooltip": false, label: "整改前", width: "180px", align: "left" }, { default: u(({ row: a }) => [N("div", se, [(l(true), w(T, null, V(a.sourceRow.beforeChangeImgs, (i) => (l(), c(s, { "preview-src-list": a.beforeImgSrc, "initial-index": 1, key: i.id, src: i.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : d("", true), e(I).visible("afterChangeImgs") ? (l(), c(t, { key: "afterChangeImgs", prop: "afterChangeImgs", "show-overflow-tooltip": false, label: "整改后", width: "180px", align: "left" }, { default: u(({ row: a }) => [N("div", re, [(l(true), w(T, null, V(a.sourceRow.afterChangeImgs, (i) => (l(), c(s, { "preview-src-list": a.afterImgSrc, "initial-index": 1, key: i.id, src: i.tinyImageUrl, style: { margin: "0 2px" }, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : d("", true), o(t, { key: "penalty", prop: "penalty", label: "违约金", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "boolChangeStatus", prop: "boolChangeStatus", label: "状态", align: "center" }, { default: u((a) => [o(f, { type: a.row.boolChangeStatus ? "success" : "warning" }, { default: u(() => [U(F(e(te).VL[a.row.boolChangeStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), e(v)([...e(m).detail, ...e(m).audit, ...e(m).close]) ? (l(), c(t, { key: 2, label: "操作", width: "190px", align: "center" }, { default: u((a) => {
      var i, k;
      return [D(o(b, { icon: "el-icon-view", type: "primary", size: "default", onClick: (S) => _(a.row, "detail") }, null, 8, ["onClick"]), [[B, e(m).detail]]), ((i = a.row.qhseChange) == null ? void 0 : i.auditStatus) === e(q).AUDITING.V && e(v)(e(m).audit) && a.row.boolReply ? (l(), c(b, { key: 0, size: "default", icon: "el-icon-stamp", type: "primary", onClick: (S) => _(a.row, "audit") }, null, 8, ["onClick"])) : d("", true), ((k = a.row.qhseChange) == null ? void 0 : k.auditStatus) === e(q).AUDITING.V && e(v)(e(m).close) && !a.row.boolReply ? (l(), c(b, { key: 1, size: "default", type: "primary", onClick: (S) => _(a.row, "close") }, { default: u(() => n[1] || (n[1] = [U("关闭")])), _: 2, __: [1] }, 1032, ["onClick"])) : d("", true)];
    }), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[$, e(g).loading]]), o(e(W), { "detail-info": p.value, modelValue: y.value, "onUpdate:modelValue": n[0] || (n[0] = (a) => y.value = a), showType: x.value, onSuccess: e(g).toQuery, permission: e(m) }, null, 8, ["detail-info", "modelValue", "showType", "onSuccess", "permission"]), o(e(ae))]);
  };
} }, ge = X(ne, [["__scopeId", "data-v-5da1a5f0"]]);
export {
  ge as default
};
