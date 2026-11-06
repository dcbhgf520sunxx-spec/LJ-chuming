import { computed as R } from "vue";
import { watch as G } from "vue";
import { ref as v } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as d } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as V } from "vue";
import { createVNode as e } from "vue";
import { unref as i } from "vue";
import { createElementBlock as Q } from "vue";
import { createCommentVNode as W } from "vue";
import { isRef as X } from "vue";
import { ElTag as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as ee } from "element-plus";
import { a as te } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as ae, u as oe, J as ne, c3 as k, bD as ie, o as le, ia as z, ba as re, v3 as se, bV as ce } from "../../../../../shared/runtime.js";
const pe = { class: "print-wrap" }, me = { key: 0 }, he = { __name: "invoice-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(p, { emit: D }) {
  const { decimalPrecision: y } = ae(), P = D, s = p, { visible: m, handleClose: T } = oe({ emit: P, props: s }), { handleSizeChange: B, handleCurrentChange: A, total: E, setTotalPage: H, queryPage: f } = ne({ fetchHook: S }), x = R(() => s.detailInfo.id ? { orderId: s.detailInfo.id, auditStatus: k.PASS.V } : { supplierId: s.detailInfo.supplierId, auditStatus: k.PASS.V });
  G(m, (r) => {
    r && S();
  });
  const C = v([]), I = v(), h = v(false), U = R(() => [["invoiceType", ["parse-enum", ie]], ["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", y.value.supplyChain]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: j } = le({ mainBox: ".invoice-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, I);
  function q(r) {
    const t = re(r, { props: [["invoiceAmount", y.value.supplyChain]] }), n = t[2];
    if (n) {
      const g = se(n);
      t[3] = z(n), t[2] = ce(n, g);
    }
    return t;
  }
  async function S() {
    let r = [];
    h.value = true;
    try {
      const { content: t = [], totalElements: n } = await te({ ...x.value, ...f });
      r = t, H(n);
    } catch (t) {
      console.log("获取收票记录失败", t);
    } finally {
      C.value = r, h.value = false;
    }
  }
  return (r, t) => {
    const n = Y, g = w("print-table"), a = Z, L = w("common-table"), M = $, O = w("common-drawer"), F = K("permission"), J = ee;
    return c(), u(O, { ref_key: "drawerRef", ref: I, title: "收票记录", "close-on-click-modal": false, modelValue: i(m), "onUpdate:modelValue": t[0] || (t[0] = (o) => X(m) ? m.value = o : null), direction: "rtl", "before-close": i(T), "custom-class": "invoice-record", size: "80%" }, { titleAfter: l(() => [p.detailInfo.serialNumber ? (c(), u(n, { key: 0, type: "success", effect: "plain", size: "large" }, { default: l(() => [_("采购合同编号：" + d(p.detailInfo.serialNumber), 1)]), _: 1 })) : (c(), u(n, { key: 1, type: "warning", effect: "plain", size: "large" }, { default: l(() => [_("供应商：" + d(p.detailInfo.supplierName), 1)]), _: 1 }))]), titleRight: l(() => {
      var o;
      return [b("div", pe, [V(e(g, { "api-key": "purchaseInvoiceRecord", params: { ...x.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[F, (o = s.permission) == null ? void 0 : o.print]])])];
    }), content: l(() => [V((c(), u(L, { data: C.value, "show-summary": "", "summary-method": q, "data-format": U.value, "max-height": i(j) }, { default: l(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "100", "show-overflow-tooltip": "" }), e(a, { prop: "invoiceAmount", label: "发票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }), e(a, { label: "大写", align: "center", "min-width": "150", "show-overflow-tooltip": "" }, { default: l(({ row: o }) => {
      var N;
      return [b("span", null, d(i(z)((N = o == null ? void 0 : o.sourceRow) == null ? void 0 : N.invoiceAmount)), 1)];
    }), _: 1 }), e(a, { prop: "invoiceType", label: "发票类型", align: "center", width: "110", "show-overflow-tooltip": "" }), e(a, { prop: "taxRate", label: "税率", align: "center", width: "70", "show-overflow-tooltip": "" }, { default: l(({ row: o }) => [b("span", null, [_(d(o.taxRate), 1), o.taxRate !== "-" ? (c(), Q("span", me, "%")) : W("", true)])]), _: 1 }), e(a, { prop: "branchCompanyName", label: "购方单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(a, { prop: "supplierName", label: "销售单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(a, { prop: "invoiceSerialNumber", label: "发票编号", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(a, { prop: "applyUserName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(a, { prop: "auditUserName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[J, h.value]]), e(M, { total: i(E), "current-page": i(f).pageNumber, "page-size": i(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(B), onCurrentChange: i(A) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  he as default
};
