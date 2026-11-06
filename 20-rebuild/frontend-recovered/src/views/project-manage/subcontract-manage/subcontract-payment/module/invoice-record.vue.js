import { computed as I } from "vue";
import { watch as J } from "vue";
import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as v } from "vue";
import { createBlock as N } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as T } from "vue";
import { unref as i } from "vue";
import { createElementBlock as K } from "vue";
import { createCommentVNode as Q } from "vue";
import { isRef as W } from "vue";
import { ElTag as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as ee } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as te, u as ae, J as oe, jF as ne, bD as ie, o as le, ia as V, ba as re, bV as se } from "../../../../../shared/runtime.js";
const ce = { class: "print-wrap" }, pe = { key: 0 }, fe = { __name: "invoice-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(m, { emit: z }) {
  const { decimalPrecision: u } = te(), k = z, s = m, { visible: c, handleClose: B } = ae({ emit: k, props: s }), { handleSizeChange: S, handleCurrentChange: D, total: P, setTotalPage: j, queryPage: d } = oe({ fetchHook: C }), b = I(() => {
    const t = { propertyType: ne.SUBCONTRACT.V };
    return s.detailInfo.id ? t.orderId = s.detailInfo.id : t.supplierId = s.detailInfo.supplierId, t;
  });
  J(c, (t) => {
    t && C();
  });
  const y = h([]), x = h(), f = h(false), E = I(() => [["invoiceType", ["parse-enum", ie]], ["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", u.value.project]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: A } = le({ mainBox: ".invoice-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, x);
  function H(t) {
    const a = re(t, { props: [["invoiceAmount", u.value.project]] }), l = a[2];
    return l && (a[3] = V(l), a[2] = se(l, u.value.project)), a;
  }
  async function C() {
    let t = [];
    f.value = true;
    try {
      const { content: a = [], totalElements: l } = await ee({ ...b.value, ...d });
      t = a, j(l);
    } catch (a) {
      console.log("获取收票记录失败", a);
    } finally {
      y.value = t, f.value = false;
    }
  }
  return (t, a) => {
    const l = X, U = g("print-table"), o = Y, q = g("common-table"), L = Z, O = g("common-drawer"), F = G("permission"), M = $;
    return v(), N(O, { ref_key: "drawerRef", ref: x, title: "收票记录", "close-on-click-modal": false, modelValue: i(c), "onUpdate:modelValue": a[0] || (a[0] = (n) => W(c) ? c.value = n : null), direction: "rtl", "before-close": i(B), "custom-class": "invoice-record", size: "80%" }, { titleAfter: r(() => [e(l, { type: "success", effect: "plain", size: "large" }, { default: r(() => [w("分包订单：" + p(m.detailInfo.serialNumber), 1)]), _: 1 }), e(l, { type: "warning", effect: "plain", size: "large" }, { default: r(() => [w("分包单位：" + p(m.detailInfo.supplierName), 1)]), _: 1 })]), titleRight: r(() => {
      var n;
      return [_("div", ce, [T(e(U, { "api-key": "purchaseInvoiceRecord", params: { ...b.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[F, (n = s.permission) == null ? void 0 : n.invoicePrint]])])];
    }), content: r(() => [T((v(), N(q, { data: y.value, "show-summary": "", "summary-method": H, "data-format": E.value, "max-height": i(A) }, { default: r(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "100", "show-overflow-tooltip": "" }), e(o, { prop: "invoiceAmount", label: "发票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }), e(o, { label: "大写", align: "center", "min-width": "150", "show-overflow-tooltip": "" }, { default: r(({ row: n }) => {
      var R;
      return [_("span", null, p(i(V)((R = n == null ? void 0 : n.sourceRow) == null ? void 0 : R.invoiceAmount)), 1)];
    }), _: 1 }), e(o, { prop: "invoiceType", label: "发票类型", align: "center", width: "110", "show-overflow-tooltip": "" }), e(o, { prop: "taxRate", label: "税率", align: "center", width: "70", "show-overflow-tooltip": "" }, { default: r(({ row: n }) => [_("span", null, [w(p(n.taxRate), 1), n.taxRate !== "-" ? (v(), K("span", pe, "%")) : Q("", true)])]), _: 1 }), e(o, { prop: "branchCompanyName", label: "购方单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "supplierName", label: "销售单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "invoiceSerialNumber", label: "发票编号", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(o, { prop: "applyUserName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(o, { prop: "auditUserName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[M, f.value]]), e(L, { total: i(P), "current-page": i(d).pageNumber, "page-size": i(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(S), onCurrentChange: i(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  fe as default
};
