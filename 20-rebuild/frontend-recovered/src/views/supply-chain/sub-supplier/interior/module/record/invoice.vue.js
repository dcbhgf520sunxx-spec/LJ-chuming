import { ref as b } from "vue";
import { inject as D } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as r } from "vue";
import { withDirectives as C } from "vue";
import { unref as s } from "vue";
import { createBlock as i } from "vue";
import { withCtx as o } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as w } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as d } from "vue";
import { Fragment as S } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTag as A } from "element-plus";
import { ElButton as B } from "element-plus";
import { vLoading as E } from "element-plus";
import { x as V, D as L, bD as U, P as j } from "../../../../../../shared/runtime.js";
import { i as F } from "../../../../../../modules/index-69cea220.js";
import { d as P } from "../../../../../../modules/upload-file-download-812f558c.js";
import { j as R } from "../../../../../../modules/self-healing-6f411a5c.js";
const z = { key: 0 }, q = { key: 1 }, Y = { key: 1 }, Q = { __name: "invoice", setup($) {
  const u = b(), { table_item_data: g, size: y } = D("common");
  y.value = "100%";
  const { crud: c } = V({ title: "开票记录", crudApi: { get: () => F(g.value.id) } }, u), f = async (_) => {
    await P(_.attachment.id, R);
  }, v = b([["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", L.YUAN]]]);
  return (_, l) => {
    const t = I, m = A, k = B, T = N("common-table"), x = E;
    return n(), r(S, null, [C((n(), i(T, { ref_key: "table_ref", ref: u, data: s(c).data, "data-format": v.value, "empty-text": s(c).emptyText }, { default: o(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "收票日期", prop: "receiveInvoiceDate" }), e(t, { align: "center", label: "发票面额", prop: "invoiceAmount" }), e(t, { align: "center", label: "发票类型", "min-width": "120", prop: "invoiceType" }, { default: o(({ row: a }) => [h("span", null, w(s(U).VL[a.invoiceType]), 1)]), _: 1 }), e(t, { align: "center", label: "是否含税", prop: "boolIncludeTax" }, { default: o(({ row: a }) => [a.boolIncludeTax ? (n(), r("span", z, "是")) : (n(), r("span", q, "否"))]), _: 1 }), e(t, { align: "center", label: "税率", prop: "taxRate" }), e(t, { align: "center", label: "购方单位", prop: "branchCompanyName" }), e(t, { align: "center", label: "销售单位", prop: "supplierName" }), e(t, { align: "center", label: "发票编号", prop: "invoiceSerialNumber" }), e(t, { align: "center", label: "申请人", prop: "applyUserName" }), e(t, { align: "center", label: "审核人", prop: "auditUserName" }), e(t, { align: "center", label: "审核时间", prop: "auditTime" }), e(t, { align: "center", label: "审核状态", prop: "auditStatus" }, { default: o(({ row: a }) => [a.auditStatus === 1 ? (n(), i(m, { key: 0, type: "warning" }, { default: o(() => l[0] || (l[0] = [p("审核中")])), _: 1, __: [0] })) : d("", true), a.auditStatus === 2 ? (n(), i(m, { key: 1, type: "success" }, { default: o(() => l[1] || (l[1] = [p("审核通过")])), _: 1, __: [1] })) : d("", true), a.auditStatus === 4 ? (n(), i(m, { key: 2, type: "danger" }, { default: o(() => l[2] || (l[2] = [p("驳回")])), _: 1, __: [2] })) : d("", true)]), _: 1 }), e(t, { align: "center", label: "申请时间", prop: "createTime" }), e(t, { align: "center", label: "附件", prop: "attachments", width: "100" }, { default: o(({ row: a }) => [a.attachments.length > 0 ? (n(), i(k, { key: 0, plain: "", size: "default", type: "primary", onClick: (G) => f(a) }, { default: o(() => l[3] || (l[3] = [p("下载 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : (n(), r("span", Y, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[x, s(c).loading]]), e(j)], 64);
  };
} };
export {
  Q as default
};
