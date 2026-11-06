import { ref as k } from "vue";
import { watch as R } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as s } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as l } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as P } from "vue";
import { withDirectives as U } from "vue";
import { createVNode as r } from "vue";
import { ElTag as A } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { vLoading as B } from "element-plus";
import { g as E } from "../../../../../../../../modules/logistics-payment-1a755fb1.js";
import { _ as q, t as I, x as H, o as O, jF as j, c3 as F, bV as _, p as f, i as L, P as M, ba as z } from "../../../../../../../../shared/runtime.js";
import { C as K } from "../../../../../../../../modules/contract-9b18cc88.js";
const Q = { class: "app-container" }, $ = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, setup(p) {
  const g = K.payment, { decimalPrecision: u } = I(), h = { add: false, edit: false, del: false, download: false }, m = p, d = k(), { crud: t, CRUD: w } = H({ title: "付款记录", sort: [], permission: { ...g }, optShow: { ...h }, crudApi: { get: E }, hasPagination: true }, d), { maxHeight: b } = O({ wrapperBox: ".logistics-payment", paginate: true, extraHeight: 40 });
  R(() => m.visibleValue, (i) => {
    i && t.toQuery();
  }, { deep: true, immediate: true }), w.HOOK.beforeRefresh = () => {
    t.query.branchCompanyId = m.currentRow.branchCompanyId, t.query.supplierId = m.currentRow.supplierId, t.query.propertyType = j.TRANSPORT.V, t.query.auditStatus = F.PASS.V;
  };
  function x(i) {
    return z(i, { props: [["applyAmount", u.value.contract]], toThousandFields: ["applyAmount"] });
  }
  return (i, G) => {
    const v = A, n = V, T = S("common-table"), N = B;
    return c(), C("div", Q, [s("div", null, [p.currentRow.freight ? (c(), y(v, { key: 0, type: "success", size: "large" }, { default: o(() => [D(l(`运输额:${a(_)(p.currentRow.freight, a(u).contract)}`), 1)]), _: 1 })) : P("", true)]), U((c(), y(T, { ref_key: "tableRef", ref: d, data: a(t).data, "empty-text": a(t).emptyText, "max-height": a(b), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": x, stripe: false }, { default: o(() => [r(n, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), r(n, { key: "applyUserName", prop: "applyUserName", label: "申请人", align: "center" }, { default: o((e) => [s("div", null, l(e.row.applyUserName ? e.row.applyUserName : "-"), 1)]), _: 1 }), r(n, { key: "paymentDate", prop: "paymentDate", label: "申请日期", align: "center" }, { default: o((e) => [s("div", null, l(e.row.paymentDate ? a(f)(e.row.paymentDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), r(n, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "center" }, { default: o((e) => [s("div", null, l(a(L)(e.row.applyAmount) ? a(_)(e.row.applyAmount, a(u).contract) : "-"), 1)]), _: 1 }), r(n, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center" }, { default: o((e) => [s("div", null, l(e.row.auditUserName ? e.row.auditUserName : "-"), 1)]), _: 1 }), r(n, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center" }, { default: o((e) => [s("div", null, l(e.row.auditTime ? a(f)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, a(t).loading]]), r(a(M))]);
  };
} }, Z = q($, [["__scopeId", "data-v-93e93656"]]);
export {
  Z as default
};
