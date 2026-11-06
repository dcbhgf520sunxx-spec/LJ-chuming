import { computed as N } from "vue";
import { watch as J } from "vue";
import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as v } from "vue";
import { createBlock as T } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as V } from "vue";
import { unref as l } from "vue";
import { createElementBlock as K } from "vue";
import { createCommentVNode as Q } from "vue";
import { isRef as W } from "vue";
import { ElTag as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as ee } from "../../../../modules/payment-ledger-cb1d373c.js";
import { t as te, u as ae, J as oe, jF as ne, bD as ie, o as le, ia as z, ba as re, v3 as se, bV as ce } from "../../../../shared/runtime.js";
const pe = { class: "print-wrap" }, me = { key: 0 }, he = { __name: "invoice-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(m, { emit: k }) {
  const { decimalPrecision: b } = te(), B = k, s = m, { visible: c, handleClose: D } = ae({ emit: B, props: s }), { handleSizeChange: S, handleCurrentChange: P, total: E, setTotalPage: A, queryPage: u } = oe({ fetchHook: R }), y = N(() => {
    const t = { propertyType: ne.SUBCONTRACT.V };
    return s.detailInfo.id ? t.orderId = s.detailInfo.id : t.supplierId = s.detailInfo.supplierId, t;
  });
  J(c, (t) => {
    t && R();
  });
  const x = h([]), C = h(), d = h(false), H = N(() => [["invoiceType", ["parse-enum", ie]], ["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", b.value.supplyChain]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: U } = le({ mainBox: ".invoice-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, C);
  function j(t) {
    const a = re(t, { props: [["invoiceAmount", b.value.supplyChain]] }), i = a[2];
    if (i) {
      const f = se(i);
      a[3] = z(i), a[2] = ce(i, f);
    }
    return a;
  }
  async function R() {
    let t = [];
    d.value = true;
    try {
      const { content: a = [], totalElements: i } = await ee({ ...y.value, ...u });
      t = a, A(i);
    } catch (a) {
      console.log("获取收票记录失败", a);
    } finally {
      x.value = t, d.value = false;
    }
  }
  return (t, a) => {
    const i = X, f = g("print-table"), o = Y, q = g("common-table"), L = Z, O = g("common-drawer"), F = G("permission"), M = $;
    return v(), T(O, { ref_key: "drawerRef", ref: C, title: "收票记录", "close-on-click-modal": false, modelValue: l(c), "onUpdate:modelValue": a[0] || (a[0] = (n) => W(c) ? c.value = n : null), direction: "rtl", "before-close": l(D), "custom-class": "invoice-record", size: "80%" }, { titleAfter: r(() => [e(i, { type: "success", effect: "plain", size: "large" }, { default: r(() => [w("分包订单：" + p(m.detailInfo.serialNumber), 1)]), _: 1 }), e(i, { type: "warning", effect: "plain", size: "large" }, { default: r(() => [w("分包单位：" + p(m.detailInfo.supplierName), 1)]), _: 1 })]), titleRight: r(() => {
      var n;
      return [_("div", pe, [V(e(f, { "api-key": "purchaseInvoiceRecord", params: { ...y.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[F, (n = s.permission) == null ? void 0 : n.invoice.print]])])];
    }), content: r(() => [V((v(), T(q, { data: x.value, "show-summary": "", "summary-method": j, "data-format": H.value, "max-height": l(U) }, { default: r(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "100", "show-overflow-tooltip": "" }), e(o, { prop: "invoiceAmount", label: "发票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }), e(o, { label: "大写", align: "center", "min-width": "150", "show-overflow-tooltip": "" }, { default: r(({ row: n }) => {
      var I;
      return [_("span", null, p(l(z)((I = n == null ? void 0 : n.sourceRow) == null ? void 0 : I.invoiceAmount)), 1)];
    }), _: 1 }), e(o, { prop: "invoiceType", label: "发票类型", align: "center", width: "110", "show-overflow-tooltip": "" }), e(o, { prop: "taxRate", label: "税率", align: "center", width: "70", "show-overflow-tooltip": "" }, { default: r(({ row: n }) => [_("span", null, [w(p(n.taxRate), 1), n.taxRate !== "-" ? (v(), K("span", me, "%")) : Q("", true)])]), _: 1 }), e(o, { prop: "branchCompanyName", label: "购方单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "supplierName", label: "销售单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "invoiceSerialNumber", label: "发票编号", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(o, { prop: "applyUserName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(o, { prop: "auditUserName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[M, d.value]]), e(L, { total: l(E), "current-page": l(u).pageNumber, "page-size": l(u).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(S), onCurrentChange: l(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  he as default
};
