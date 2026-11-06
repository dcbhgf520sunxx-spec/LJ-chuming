import { ref as _ } from "vue";
import { watch as U } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as r } from "vue";
import { createBlock as p } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as i } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as A } from "vue";
import { withDirectives as E } from "vue";
import { createVNode as t } from "vue";
import { ElTag as P } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as L } from "../../../../../../modules/logistics-payment-1a755fb1.js";
import { _ as j, x as H, o as O, jF as z, bV as T, p as V, i as F, c3 as u, an as G, P as M, uE as Q } from "../../../../../../shared/runtime.js";
import J from "./form.vue.js";
import $ from "../../../../../contract/payment-manage/supplier-manage/logistics-manage/module/payment-audit/detail.vue.js";
import "../../../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../../../../modules/pay-9ccccafb.js";
const K = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, setup(m) {
  const b = Q.application, k = { add: true, edit: false, del: false, download: false }, c = m, h = _(), y = _(false), f = _({}), { CRUD: W, crud: n } = H({ title: "付款申请", sort: [], permission: { ...b }, optShow: { ...k }, crudApi: { ...L }, requiredQuery: ["supplierId", "branchCompanyId"], hasPagination: true }, h), { maxHeight: N } = O({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  U(() => c.visibleValue, (d) => {
    d && (n.query.supplierId = c.currentRow.supplierId, n.query.branchCompanyId = c.currentRow.branchCompanyId, n.query.propertyType = z.TRANSPORT.V, n.toQuery());
  }, { deep: true, immediate: true });
  function S(d) {
    f.value = d, y.value = true;
  }
  return (d, v) => {
    const w = P, o = B, I = x("common-button"), C = x("common-table"), D = q;
    return s(), R("div", null, [r("div", null, [m.currentRow.amount ? (s(), p(w, { key: 0, type: "success", size: "large" }, { default: l(() => [g(i("合同金额:" + a(T)(m.currentRow.amount)), 1)]), _: 1 })) : A("", true)]), E((s(), p(C, { ref_key: "tableRef", ref: h, data: a(n).data, "empty-text": a(n).emptyText, "max-height": a(N), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [t(o, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(o, { key: "applyUserName", prop: "applyUserName", label: "申请人", align: "center" }, { default: l((e) => [r("div", null, i(e.row.applyUserName ? e.row.applyUserName : "-"), 1)]), _: 1 }), t(o, { key: "paymentDate", prop: "paymentDate", label: "申请日期", align: "center" }, { default: l((e) => [r("div", null, i(e.row.paymentDate ? a(V)(e.row.paymentDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(o, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "center" }, { default: l((e) => [r("div", null, i(a(F)(e.row.applyAmount) ? a(T)(e.row.applyAmount) : "-"), 1)]), _: 1 }), t(o, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center" }, { default: l((e) => [e.row.auditStatus === a(u).REJECT.V ? (s(), p(w, { key: 0, type: "warning" }, { default: l(() => [g(i(a(u).VL[e.row.auditStatus]), 1)]), _: 2 }, 1024)) : (s(), p(w, { key: 1, type: e.row.auditStatus === a(u).PASS.V ? "success" : "primary" }, { default: l(() => [g(i(a(u).VL[e.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), t(o, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center" }, { default: l((e) => [r("div", null, i(e.row.auditUserName ? e.row.auditUserName : "-"), 1)]), _: 1 }), t(o, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center" }, { default: l((e) => [r("div", null, i(e.row.auditTime ? a(V)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(o, { label: "操作", width: "190px", align: "center" }, { default: l((e) => [t(I, { icon: "el-icon-view", type: "primary", size: "default", onClick: (X) => S(e.row, "detail") }, null, 8, ["onClick"]), t(a(G), { data: e.row, "show-edit": e.row.auditStatus === a(u).AUDITING.V, "show-del": e.row.auditStatus === a(u).AUDITING.V, permission: a(b) }, null, 8, ["data", "show-edit", "show-del", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, a(n).loading]]), t(a(J), { "detail-info": f.value }, null, 8, ["detail-info"]), t(a($), { modelValue: y.value, "onUpdate:modelValue": v[0] || (v[0] = (e) => y.value = e), showType: "detail", detailInfo: f.value }, null, 8, ["modelValue", "detailInfo"]), t(a(M))]);
  };
} }, ie = j(K, [["__scopeId", "data-v-1997d013"]]);
export {
  ie as default
};
