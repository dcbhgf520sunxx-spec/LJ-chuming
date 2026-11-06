import { ref as u } from "vue";
import { watch as g } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as t } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as N } from "vue";
import { unref as s } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElBadge as q } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { _ as L, J as F, G as Q, a as U } from "../../../../shared/runtime.js";
import { h as G } from "../../../../modules/scrap-ledger-452ee452.js";
import { V as H } from "../../../../modules/contract-9b18cc88.js";
import J from "./collection-and-invoice/index.vue.js";
import M from "./total-amount.vue.js";
import "./collection-and-invoice/collection/index.vue.js";
import "./collection-and-invoice/collection/form.vue.js";
import "./collection-and-invoice/invoice/index.vue.js";
import "./collection-and-invoice/invoice/form.vue.js";
const j = ["onClick"], K = { style: { color: "#409eff", "text-align": "right", "margin-left": "8px" } }, O = ["onClick"], W = { key: 0 }, X = { style: { color: "#409eff", "text-align": "right", "margin-left": "8px" } }, Y = ["onClick"], Z = { key: 0 }, ee = { style: { color: "#409eff", "text-align": "right", "margin-left": "8px" } }, te = { __name: "buy-query", props: { queryId: { type: Number, default: 1 }, scrapType: { type: Number, default: void 0 }, startDate: { type: [String, Number], default: void 0 }, endDate: { type: [String, Number], default: void 0 } }, setup(R) {
  const { handleSizeChange: V, handleCurrentChange: z, total: S, setTotalPage: I, queryPage: d } = F({ fetchHook: r }), l = R, m = u([]), _ = u(false), p = u({}), C = u(), f = u(false);
  g(() => l.queryId, (a) => {
    a === 1 && r();
  }, { immediate: true }), g(() => [l.startDate, l.endDate], () => {
    r();
  }), g(() => l.scrapType, () => {
    r();
  });
  async function r() {
    if (Q(H.get)) {
      m.value = [];
      try {
        const { content: a, totalElements: o } = await G({ ...d, startDate: l.startDate, endDate: l.endDate, wasteClassificationId: l.scrapType });
        a.forEach((n) => {
          n.collectionRate = (n.collectionRate * 100).toFixed(2) + "%", n.invoiceRate = (n.invoiceRate * 100).toFixed(2) + "%", m.value.push(n);
        }), I(o);
      } catch (a) {
        console.log(a);
      }
    }
  }
  async function b(a, o) {
    _.value = true, p.value = a, C.value = o;
  }
  async function A(a) {
    f.value = true, p.value = a;
  }
  async function w() {
    r();
  }
  return (a, o) => {
    const n = B, k = U, x = q, E = T("common-table"), P = $;
    return y(), h("div", null, [t(E, { data: m.value }, { default: c(() => [t(n, { label: "序号", align: "center", width: "60", type: "index" }), t(n, { label: "购买方", align: "center", prop: "purchaser", width: "220" }), t(n, { label: "出售方", align: "center", prop: "branchCompanyName", width: "220" }), t(n, { label: "累计出售金额", align: "center", prop: "totalAmount" }, { default: c(({ row: e }) => [i("div", { onClick: (D) => A(e), style: { cursor: "pointer" } }, [i("span", K, v(e.totalAmount), 1)], 8, j)]), _: 1 }), t(n, { label: "累计收款", align: "center", prop: "collectionAmount" }, { default: c(({ row: e }) => [i("div", { onClick: (D) => b(e, "collection"), style: { cursor: "pointer" } }, [e.unCheckCollectionCount !== 0 ? (y(), h("span", W, [t(x, { value: e.unCheckCollectionCount }, { default: c(() => [t(k, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value"])])) : N("", true), i("span", X, v(e.collectionAmount), 1)], 8, O)]), _: 1 }), t(n, { label: "收款率", align: "center", prop: "collectionRate" }), t(n, { label: "累计开票", align: "center", prop: "invoiceAmount" }, { default: c(({ row: e }) => [i("div", { onClick: (D) => b(e, "invoice"), style: { cursor: "pointer" } }, [e.unCheckInvoiceCount !== 0 ? (y(), h("span", Z, [t(x, { value: e.unCheckInvoiceCount, max: 99, hidden: e.unCheckInvoiceCount < 1 }, { default: c(() => [t(k, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])])) : N("", true), i("span", ee, v(e.invoiceAmount), 1)], 8, Y)]), _: 1 }), t(n, { label: "开票率", align: "center", prop: "invoiceRate" })]), _: 1 }, 8, ["data"]), t(P, { total: s(S), "current-page": s(d).pageNumber, "page-size": s(d).pageSize, layout: "total, prev, pager, next, sizes", onSizeChange: s(V), onCurrentChange: s(z) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(s(J), { modelValue: _.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => _.value = e), tabName: C.value, currentRow: p.value, onSuccess: w }, null, 8, ["modelValue", "tabName", "currentRow"]), t(M, { modelValue: f.value, "onUpdate:modelValue": o[1] || (o[1] = (e) => f.value = e), currentRow: p.value }, null, 8, ["modelValue", "currentRow"])]);
  };
} }, de = L(te, [["__scopeId", "data-v-5204aa57"]]);
export {
  de as default
};
