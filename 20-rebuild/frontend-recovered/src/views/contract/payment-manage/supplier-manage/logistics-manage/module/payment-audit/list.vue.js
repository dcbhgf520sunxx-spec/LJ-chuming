import { ref as y } from "vue";
import { watch as H } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as s } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as n } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as C } from "vue";
import { createVNode as i } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as F } from "../../../../../../../modules/logistics-payment-1a755fb1.js";
import { _ as J, t as K, x as W, o as X, jF as Y, bV as D, p as R, i as Z, c3 as c, G as U, P as ee } from "../../../../../../../shared/runtime.js";
import { C as te } from "../../../../../../../modules/contract-9b18cc88.js";
import ae from "./detail.vue.js";
import "../../../../../../../modules/pay-9ccccafb.js";
const ie = { __name: "list", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(f, { emit: I }) {
  const { decimalPrecision: h } = K(), p = te.payment, P = { add: true, edit: false, del: false, download: false }, _ = f, k = y(), w = y(false), x = y("detail"), T = y({}), A = I, { crud: o } = W({ title: "付款申请", sort: [], permission: { ...p }, optShow: { ...P }, crudApi: { ...F }, requiredQuery: ["supplierId"], hasPagination: true }, k), { maxHeight: E } = X({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  H(() => _.visibleValue, (d) => {
    d && (o.query.supplierId = _.currentRow.supplierId, o.query.branchCompanyId = _.currentRow.branchCompanyId, o.query.propertyType = Y.TRANSPORT.V, o.toQuery());
  }, { deep: true, immediate: true });
  function B() {
    A("success"), o.toQuery();
  }
  function S(d, m) {
    T.value = d, x.value = m, w.value = true;
  }
  return (d, m) => {
    const g = G, l = O, V = N("common-button"), q = N("common-table"), L = M("permission"), j = $;
    return r(), Q("div", null, [s("div", null, [f.currentRow.freight ? (r(), u(g, { key: 0, type: "success", size: "large" }, { default: a(() => [v(n("运输额:" + t(D)(f.currentRow.freight, t(h).contract)), 1)]), _: 1 })) : b("", true)]), C((r(), u(q, { ref_key: "tableRef", ref: k, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(E), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: a(() => [i(l, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), i(l, { key: "applyUserName", prop: "applyUserName", label: "申请人", align: "center" }, { default: a((e) => [s("div", null, n(e.row.applyUserName ? e.row.applyUserName : "-"), 1)]), _: 1 }), i(l, { key: "paymentDate", prop: "paymentDate", label: "申请日期", align: "center" }, { default: a((e) => [s("div", null, n(e.row.paymentDate ? t(R)(e.row.paymentDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), i(l, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "center" }, { default: a((e) => [s("div", null, n(t(Z)(e.row.applyAmount) ? t(D)(e.row.applyAmount, t(h).contract) : "-"), 1)]), _: 1 }), i(l, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center" }, { default: a((e) => [e.row.auditStatus === t(c).REJECT.V ? (r(), u(g, { key: 0, type: "warning" }, { default: a(() => [v(n(t(c).VL[e.row.auditStatus]), 1)]), _: 2 }, 1024)) : (r(), u(g, { key: 1, type: e.row.auditStatus === t(c).PASS.V ? "success" : "primary" }, { default: a(() => [v(n(t(c).VL[e.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), i(l, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center" }, { default: a((e) => [s("div", null, n(e.row.auditUserName ? e.row.auditUserName : "-"), 1)]), _: 1 }), i(l, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center" }, { default: a((e) => [s("div", null, n(e.row.auditTime ? t(R)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(U)([...t(p).detail, ...t(p).audit]) ? (r(), u(l, { key: 0, label: "操作", width: "190px", align: "center" }, { default: a((e) => [C(i(V, { icon: "el-icon-view", type: "primary", size: "default", onClick: (z) => S(e.row, "detail") }, null, 8, ["onClick"]), [[L, t(p).detail]]), e.row.auditStatus == t(c).ENUM.AUDITING.V && t(U)(t(p).audit) ? (r(), u(V, { key: 0, icon: "el-icon-stamp", type: "primary", size: "default", onClick: (z) => S(e.row, "audit") }, null, 8, ["onClick"])) : b("", true)]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[j, t(o).loading]]), i(t(ae), { modelValue: w.value, "onUpdate:modelValue": m[0] || (m[0] = (e) => w.value = e), showType: x.value, detailInfo: T.value, onSuccess: B }, null, 8, ["modelValue", "showType", "detailInfo"]), i(t(ee))]);
  };
} }, pe = J(ie, [["__scopeId", "data-v-c59adf4a"]]);
export {
  pe as default
};
