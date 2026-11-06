import { watch as V } from "vue";
import { ref as b } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as s } from "vue";
import { unref as t } from "vue";
import { createSlots as T } from "vue";
import { withModifiers as F } from "vue";
import { createCommentVNode as v } from "vue";
import { ElTableColumn as I } from "element-plus";
import { InfoFilled as M } from "@element-plus/icons-vue";
import { ElIcon as R } from "element-plus";
import { ElTooltip as j } from "element-plus";
import { ElPagination as L } from "element-plus";
import { b as O } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as G, J, o as U, i as u, bV as c, G as A, D as Y } from "../../../../../shared/runtime.js";
const $ = { style: { display: "inline-block" } }, K = ["onClick"], Q = { key: 0 }, W = { key: 0 }, oe = { __name: "supplier-order", props: { modelValue: { type: Boolean, require: true }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(C) {
  const { decimalPrecision: m } = G(), r = C, { handleSizeChange: w, handleCurrentChange: x, total: k, setTotalPage: E, queryPage: d } = J({ fetchHook: g });
  V(r.query, (p) => {
    p && g();
  });
  const _ = b([]), y = b(false), { maxHeight: P } = U({ wrapperBox: ".supplier-order", paginate: true, extraHeight: 60 });
  function S(p, l) {
    A(r.permission.detail);
  }
  g();
  async function g() {
    let p = [];
    y.value = true;
    try {
      const { content: l = [], totalElements: n } = await O({ ...r.query, ...d });
      console.log("content: ", l, n), p = l, E(n);
    } catch (l) {
      console.log("获取订单汇总失败", l);
    } finally {
      _.value = p, y.value = false;
    }
  }
  return (p, l) => {
    const n = I, z = M, B = R, N = j, q = H("common-table"), D = L;
    return h(), f("div", null, [o(q, { data: _.value, "return-source-data": "", showEmptySymbol: false, "max-height": t(P) }, { default: a(() => [o(n, { label: "序号", type: "index", align: "center", width: "60" }), o(n, { prop: "supplierName", label: "供应商", align: "center", "show-overflow-tooltip": "" }), o(n, { prop: "amount", label: "累计合同额", align: "right", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [i("span", null, s(t(u)(e.amount) ? t(c)(e.amount, t(m).supplyChain) : 0), 1)]), _: 1 }), o(n, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, T({ default: a(({ row: e }) => [i("div", { type: "warning", class: "clickable", onClick: F((X) => S(e, "payment"), ["stop"]) }, s(e.paymentAmount), 9, K)]), _: 2 }, [t(A)(r.permission.detail) ? { name: "header", fn: a(() => [o(N, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: a(() => [i("div", $, [l[0] || (l[0] = i("span", null, "累计入库额 ", -1)), o(B, null, { default: a(() => [o(z)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024), o(n, { prop: "inboundAmount", label: "累计入库额", align: "right", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [i("span", null, s(t(u)(e.inboundAmount) ? t(c)(e.inboundAmount, t(Y).YUAN) : 0), 1)]), _: 1 }), o(n, { prop: "paymentAmount", label: "累计已付款", align: "right", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [i("span", null, s(t(u)(e.paymentAmount) ? t(c)(e.paymentAmount, t(m).supplyChain) : 0), 1)]), _: 1 }), o(n, { prop: "paymentRate", label: "付款比例", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [e.inboundAmount ? (h(), f("span", Q, s((e.paymentAmount / e.inboundAmount * 100).toFixed(2)) + "%", 1)) : v("", true)]), _: 1 }), o(n, { prop: "invoiceAmount", label: "累计已开票", align: "right", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [i("span", null, s(t(u)(e.invoiceAmount) ? t(c)(e.invoiceAmount, t(m).supplyChain) : 0), 1)]), _: 1 }), o(n, { prop: "invoiceRate", label: "开票比例", align: "center", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [e.inboundAmount ? (h(), f("span", W, s((e.invoiceAmount / e.inboundAmount * 100).toFixed(2)) + "%", 1)) : v("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), o(D, { total: t(k), "current-page": t(d).pageNumber, "page-size": t(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(w), onCurrentChange: t(x) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  oe as default
};
