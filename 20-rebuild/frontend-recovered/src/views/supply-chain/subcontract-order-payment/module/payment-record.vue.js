import { computed as I } from "vue";
import { watch as W } from "vue";
import { ref as w } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as u } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as C } from "vue";
import { withDirectives as N } from "vue";
import { unref as t } from "vue";
import { createElementBlock as Y } from "vue";
import { createCommentVNode as Z } from "vue";
import { isRef as $ } from "vue";
import { ElTag as ee } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as te } from "element-plus";
import { vLoading as ne } from "element-plus";
import { p as oe } from "../../../../modules/payment-ledger-cb1d373c.js";
import { t as le, u as ie, J as se, jF as re, g8 as pe, o as me, ia as T, iv as ue, c3 as h, ba as ce, v3 as de, bV as ye } from "../../../../shared/runtime.js";
const ge = { class: "print-wrap" }, he = { key: 0 }, ve = { __name: "payment-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(f, { emit: z }) {
  const { decimalPrecision: c } = le(), B = z, m = f, { visible: d, handleClose: U } = ie({ emit: B, props: m }), { handleSizeChange: D, handleCurrentChange: E, total: H, setTotalPage: L, queryPage: _ } = se({ fetchHook: S }), x = I(() => {
    const l = { propertyType: re.SUBCONTRACT.V };
    return m.detailInfo.id ? l.orderId = m.detailInfo.id : l.supplierId = m.detailInfo.supplierId, l;
  });
  W(d, (l) => {
    l && S();
  }, { immediate: true });
  const V = w([]), P = w(), b = w(false), M = pe(["payment_reason"]), j = I(() => [["applyAmount", ["to-thousand", c.value.supplyChain]], ["actuallyPaymentAmount", ["to-thousand", c.value.supplyChain]], ["paymentDate", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: F } = me({ mainBox: ".payment-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, P);
  function q(l) {
    const i = ce(l, { props: [["applyAmount", c.value.supplyChain], ["actuallyPaymentAmount", c.value.supplyChain]], toThousandFields: ["applyAmount"] }), s = i[3];
    if (s) {
      const v = de(s);
      i[4] = T(s), i[3] = ye(s, v);
    }
    return i;
  }
  async function S() {
    let l = [];
    b.value = true;
    try {
      const { content: i = [], totalElements: s } = await oe({ ...x.value, ..._ });
      l = i, L(s);
    } catch (i) {
      console.log("获取付款记录失败", i);
    } finally {
      V.value = l, b.value = false;
    }
  }
  return (l, i) => {
    const s = ee, v = k("print-table"), n = ae, O = k("common-table"), J = te, G = k("common-drawer"), K = X("permission"), Q = ne;
    return u(), y(G, { ref_key: "drawerRef", ref: P, title: "付款记录", "close-on-click-modal": false, modelValue: t(d), "onUpdate:modelValue": i[0] || (i[0] = (e) => $(d) ? d.value = e : null), direction: "rtl", "before-close": t(U), "custom-class": "payment-record", size: "100%" }, { titleAfter: o(() => [a(s, { type: "success", effect: "plain", size: "large" }, { default: o(() => [g("分包订单：" + p(f.detailInfo.serialNumber), 1)]), _: 1 }), a(s, { type: "warning", effect: "plain", size: "large" }, { default: o(() => [g("分包单位：" + p(f.detailInfo.supplierName), 1)]), _: 1 })]), titleRight: o(() => {
      var e;
      return [C("div", ge, [N(a(v, { "api-key": "purchasePaymentRecord", params: { ...x.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[K, (e = m.permission) == null ? void 0 : e.payment.print]])])];
    }), content: o(() => [N((u(), y(O, { data: V.value, "show-summary": "", "summary-method": q, "data-format": j.value, "max-height": t(F) }, { default: o(() => [a(n, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), a(n, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center", width: "90" }), a(n, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "right", "min-width": "80" }), a(n, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "right", "min-width": "80" }), a(n, { label: "大写", align: "center", "min-width": "120", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => {
      var r;
      return [e.actuallyPaymentAmount ? (u(), Y("div", he, p(t(T)((r = e == null ? void 0 : e.sourceRow) == null ? void 0 : r.actuallyPaymentAmount)), 1)) : Z("", true)];
    }), _: 1 }), a(n, { key: "paymentReasonId", prop: "paymentReasonId", label: "付款事由", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var r, A, R;
      return [C("div", null, p((R = (A = (r = t(M)) == null ? void 0 : r.label) == null ? void 0 : A.payment_reason) == null ? void 0 : R[e.paymentReasonId]), 1)];
    }), _: 1 }), a(n, { key: "paymentMethod", prop: "paymentMethod", label: "付款方式", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var r;
      return [C("div", null, p((r = t(ue).VL) == null ? void 0 : r[e.paymentMethod]), 1)];
    }), _: 1 }), a(n, { key: "paymentUnit", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), a(n, { key: "paymentBank", prop: "paymentBank", "show-overflow-tooltip": "", label: "付款银行", align: "center", "min-width": "130" }), a(n, { key: "receivingUnit", prop: "receivingUnit", label: "收款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), a(n, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }), a(n, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }), a(n, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), a(n, { key: "auditStatus", prop: "auditStatus", label: "审核状态", align: "center", width: "80" }, { default: o(({ row: e }) => [e.auditStatus === t(h).REJECT.V ? (u(), y(s, { key: 0, type: "warning" }, { default: o(() => [g(p(t(h).VL[e.auditStatus]), 1)]), _: 2 }, 1024)) : (u(), y(s, { key: 1, type: e.auditStatus === t(h).PASS.V ? "success" : "primary" }, { default: o(() => [g(p(t(h).VL[e.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Q, b.value]]), a(J, { total: t(H), "current-page": t(_).pageNumber, "page-size": t(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(D), onCurrentChange: t(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ve as default
};
