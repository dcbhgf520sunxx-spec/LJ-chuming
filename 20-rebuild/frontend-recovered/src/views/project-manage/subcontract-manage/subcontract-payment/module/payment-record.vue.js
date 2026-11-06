import { computed as R } from "vue";
import { watch as W } from "vue";
import { ref as v } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as u } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as k } from "vue";
import { withDirectives as I } from "vue";
import { unref as a } from "vue";
import { createElementBlock as Y } from "vue";
import { createCommentVNode as Z } from "vue";
import { isRef as $ } from "vue";
import { ElTag as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as ne } from "element-plus";
import { p as oe } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as le, u as ie, J as re, jF as se, g8 as pe, o as me, ia as N, iv as ce, c3 as f, ba as ue, bV as de } from "../../../../../shared/runtime.js";
const ye = { class: "print-wrap" }, ge = { key: 0 }, be = { __name: "payment-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(h, { emit: T }) {
  const { decimalPrecision: m } = le(), z = T, c = h, { visible: d, handleClose: B } = ie({ emit: z, props: c }), { handleSizeChange: U, handleCurrentChange: E, total: j, setTotalPage: D, queryPage: _ } = re({ fetchHook: S }), x = R(() => {
    const l = { propertyType: se.SUBCONTRACT.V };
    return c.detailInfo.id ? l.orderId = c.detailInfo.id : l.supplierId = c.detailInfo.supplierId, l;
  });
  W(d, (l) => {
    l && S();
  }, { immediate: true });
  const C = v([]), V = v(), b = v(false), M = pe(["payment_reason"]), H = R(() => [["applyAmount", ["to-thousand", m.value.project]], ["actuallyPaymentAmount", ["to-thousand", m.value.project]], ["paymentDate", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: L } = me({ mainBox: ".payment-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, V);
  function F(l) {
    const i = ue(l, { props: [["applyAmount", m.value.project], ["actuallyPaymentAmount", m.value.project]], toThousandFields: ["applyAmount"] }), r = i[3];
    return r && (i[4] = N(r), i[3] = de(r, m.value.project)), i;
  }
  async function S() {
    let l = [];
    b.value = true;
    try {
      const { content: i = [], totalElements: r } = await oe({ ...x.value, ..._ });
      l = i, D(r);
    } catch (i) {
      console.log("获取付款记录失败", i);
    } finally {
      C.value = l, b.value = false;
    }
  }
  return (l, i) => {
    const r = ee, q = w("print-table"), n = te, O = w("common-table"), J = ae, G = w("common-drawer"), K = X("permission"), Q = ne;
    return u(), y(G, { ref_key: "drawerRef", ref: V, title: "付款记录", "close-on-click-modal": false, modelValue: a(d), "onUpdate:modelValue": i[0] || (i[0] = (e) => $(d) ? d.value = e : null), direction: "rtl", "before-close": a(B), "custom-class": "payment-record", size: "100%" }, { titleAfter: o(() => [t(r, { type: "success", effect: "plain", size: "large" }, { default: o(() => [g("分包订单：" + p(h.detailInfo.serialNumber), 1)]), _: 1 }), t(r, { type: "warning", effect: "plain", size: "large" }, { default: o(() => [g("分包单位：" + p(h.detailInfo.supplierName), 1)]), _: 1 })]), titleRight: o(() => {
      var e;
      return [k("div", ye, [I(t(q, { "api-key": "purchasePaymentRecord", params: { ...x.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[K, (e = c.permission) == null ? void 0 : e.paymentManage.print]])])];
    }), content: o(() => [I((u(), y(O, { data: C.value, "show-summary": "", "summary-method": F, "data-format": H.value, "max-height": a(L) }, { default: o(() => [t(n, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(n, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center", width: "90" }), t(n, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "right", "min-width": "80" }), t(n, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "right", "min-width": "80" }), t(n, { label: "大写", align: "center", "min-width": "120", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => {
      var s;
      return [e.actuallyPaymentAmount ? (u(), Y("div", ge, p(a(N)((s = e == null ? void 0 : e.sourceRow) == null ? void 0 : s.actuallyPaymentAmount)), 1)) : Z("", true)];
    }), _: 1 }), t(n, { key: "paymentReasonId", prop: "paymentReasonId", label: "付款事由", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var s, P, A;
      return [k("div", null, p((A = (P = (s = a(M)) == null ? void 0 : s.label) == null ? void 0 : P.payment_reason) == null ? void 0 : A[e.paymentReasonId]), 1)];
    }), _: 1 }), t(n, { key: "paymentMethod", prop: "paymentMethod", label: "付款方式", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var s;
      return [k("div", null, p((s = a(ce).VL) == null ? void 0 : s[e.paymentMethod]), 1)];
    }), _: 1 }), t(n, { key: "paymentUnit", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), t(n, { key: "paymentBank", prop: "paymentBank", "show-overflow-tooltip": "", label: "付款银行", align: "center", "min-width": "130" }), t(n, { key: "receivingUnit", prop: "receivingUnit", label: "收款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), t(n, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }), t(n, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }), t(n, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), t(n, { key: "auditStatus", prop: "auditStatus", label: "审核状态", align: "center", width: "80" }, { default: o(({ row: e }) => [e.auditStatus === a(f).REJECT.V ? (u(), y(r, { key: 0, type: "warning" }, { default: o(() => [g(p(a(f).VL[e.auditStatus]), 1)]), _: 2 }, 1024)) : (u(), y(r, { key: 1, type: e.auditStatus === a(f).PASS.V ? "success" : "primary" }, { default: o(() => [g(p(a(f).VL[e.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Q, b.value]]), t(J, { total: a(j), "current-page": a(_).pageNumber, "page-size": a(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(U), onCurrentChange: a(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  be as default
};
