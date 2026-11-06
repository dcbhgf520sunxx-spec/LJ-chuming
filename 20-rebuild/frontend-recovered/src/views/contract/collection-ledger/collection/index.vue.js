import { ref as x } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as a } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as C, g as R } from "../../../../modules/collection-9275714a.js";
import { _ as q, t as N, g8 as P, x as j, o as B, bN as L, z as V, bV as f, p as E, P as H } from "../../../../shared/runtime.js";
import { c as S } from "../../../../modules/contract-9b18cc88.js";
import M from "./module/header.vue.js";
const O = { class: "app-container" }, z = { class: "head-container" }, F = { key: 0 }, I = { key: 1 }, K = { __name: "index", setup($) {
  const { decimalPrecision: _ } = N(), y = S.collection, w = { add: false, edit: false, del: false, download: false }, b = x(), p = P(["payment_reason"]), { crud: l, columns: c, CRUD: h } = j({ title: "收款台账", sort: [], permission: { ...y }, optShow: { ...w }, crudApi: { ...C, get: R }, invisibleColumns: ["contractAmount"], hasPagination: true }, b), { maxHeight: v } = B({ wrapperBox: ".collectionLedger", paginate: true, extraHeight: 100 });
  return h.HOOK.beforeRefresh = () => {
    l.query.createTime && l.query.createTime.length > 0 ? (l.query.startDate = l.query.createTime[0], l.query.endDate = l.query.createTime[1]) : (l.query.startDate = void 0, l.query.endDate = void 0);
  }, (G, J) => {
    const n = T, g = D("common-table"), k = U;
    return o(), m("div", O, [s("div", z, [d(t(M))]), A((o(), a(g, { ref_key: "tableRef", ref: b, data: t(l).data, "empty-text": t(l).emptyText, "max-height": t(v), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false, stripe: false }, { default: i(() => [d(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("businessType") ? (o(), a(n, { key: "businessType", prop: "businessType", "show-overflow-tooltip": true, label: "业务类型", align: "center" }, { default: i((e) => [s("span", null, r(e.row.businessType ? t(L).VL[e.row.businessType] : "废料出售"), 1)]), _: 1 })) : u("", true), t(c).visible("project") ? (o(), a(n, { key: "project.serialNumber", prop: "project", "show-overflow-tooltip": true, label: "所属项目/购买方", "min-width": "150" }, { default: i((e) => [e.row.type === 1 ? (o(), m("span", F, r(t(V)(e.row.project)), 1)) : (o(), m("span", I, r(e.row.paymentUnit), 1))]), _: 1 })) : u("", true), t(c).visible("collectionUnit") ? (o(), a(n, { key: "collectionUnit", prop: "collectionUnit", "show-overflow-tooltip": true, label: "签约主体/出售方", align: "center" }, { default: i((e) => [s("div", null, r(e.row.collectionUnit), 1)]), _: 1 })) : u("", true), t(c).visible("contractAmount") ? (o(), a(n, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, label: "合同金额(元)" }, { default: i((e) => [s("span", null, r(e.row.contractAmount ? t(f)(e.row.contractAmount, t(_).contract) : ""), 1)]), _: 1 })) : u("", true), t(c).visible("collectionDate") ? (o(), a(n, { key: "collectionDate", prop: "collectionDate", label: "收款日期", align: "center" }, { default: i((e) => [s("div", null, r(e.row.collectionDate ? t(E)(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : u("", true), t(c).visible("collectionAmount") ? (o(), a(n, { key: "collectionAmount", prop: "collectionAmount", label: "收款额(元)", align: "center" }, { default: i((e) => [s("div", null, r(e.row.collectionAmount && e.row.collectionAmount > 0 ? t(f)(e.row.collectionAmount, t(_).contract) : e.row.collectionAmount), 1)]), _: 1 })) : u("", true), t(c).visible("collectionReason") ? (o(), a(n, { key: "collectionReason", prop: "collectionReason", label: "收款事由", align: "center" }, { default: i((e) => [s("div", null, r(e.row.collectionReason && t(p) && t(p).label && t(p).label.payment_reason ? t(p).label.payment_reason[e.row.collectionReason] : ""), 1)]), _: 1 })) : u("", true), t(c).visible("collectionUnit") ? (o(), a(n, { key: "collectionUnit", prop: "collectionUnit", label: "收款单位", align: "center", "show-overflow-tooltip": true }, { default: i((e) => [s("div", null, r(e.row.collectionUnit || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("remark") ? (o(), a(n, { key: "remark", prop: "remark", label: "备注", align: "center", "show-overflow-tooltip": true }, { default: i((e) => [s("span", null, r(e.row.remark || "-"), 1)]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, t(l).loading]]), d(t(H))]);
  };
} }, ee = q(K, [["__scopeId", "data-v-20b0442a"]]);
export {
  ee as default
};
