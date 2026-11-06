import { computed as R } from "vue";
import { watch as W } from "vue";
import { ref as w } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as p } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as m } from "vue";
import { createElementVNode as C } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createElementBlock as Y } from "vue";
import { createCommentVNode as Z } from "vue";
import { isRef as $ } from "vue";
import { ElTag as ee } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElPagination as te } from "element-plus";
import { vLoading as ne } from "element-plus";
import { p as oe } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { t as le, u as ie, J as se, jF as re, g8 as pe, o as me, ia as z, iv as ue, c3 as f, ba as ce, v3 as de, bV as ye } from "../../../../../shared/runtime.js";
const ge = { class: "print-wrap" }, he = { key: 0 }, ve = { __name: "payment-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(d, { emit: E }) {
  const { decimalPrecision: y } = le(), U = E, c = d, { visible: g, handleClose: B } = ie({ emit: U, props: c }), { handleSizeChange: D, handleCurrentChange: T, total: H, setTotalPage: L, queryPage: _ } = se({ fetchHook: S }), x = R(() => {
    const l = { propertyType: re.PURCHASE.V };
    return c.detailInfo.id ? l.orderId = c.detailInfo.id : l.supplierId = c.detailInfo.supplierId, l;
  });
  W(g, (l) => {
    l && S();
  }, { immediate: true });
  const P = w([]), V = w(), b = w(false), M = pe(["payment_reason"]), j = R(() => [["applyAmount", ["to-thousand", y.value.supplyChain]], ["actuallyPaymentAmount", ["to-thousand", y.value.supplyChain]], ["paymentDate", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: F } = me({ mainBox: ".payment-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, V);
  function q(l) {
    const i = ce(l, { props: [["applyAmount", y.value.supplyChain], ["actuallyPaymentAmount", y.value.supplyChain]], toThousandFields: ["applyAmount"] }), s = i[3];
    if (s) {
      const v = de(s);
      i[4] = z(s), i[3] = ye(s, v);
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
      P.value = l, b.value = false;
    }
  }
  return (l, i) => {
    const s = ee, v = k("print-table"), n = ae, J = k("common-table"), O = te, G = k("common-drawer"), K = X("permission"), Q = ne;
    return p(), u(G, { ref_key: "drawerRef", ref: V, title: "付款记录", "close-on-click-modal": false, modelValue: t(g), "onUpdate:modelValue": i[0] || (i[0] = (e) => $(g) ? g.value = e : null), direction: "rtl", "before-close": t(B), "custom-class": "payment-record", size: "100%" }, { titleAfter: o(() => [d.detailInfo.serialNumber ? (p(), u(s, { key: 0, type: "success", effect: "plain", size: "large" }, { default: o(() => [h("采购合同编号：" + m(d.detailInfo.serialNumber), 1)]), _: 1 })) : (p(), u(s, { key: 1, type: "warning", effect: "plain", size: "large" }, { default: o(() => [h("供应商：" + m(d.detailInfo.supplierName), 1)]), _: 1 }))]), titleRight: o(() => {
      var e;
      return [C("div", ge, [N(a(v, { "api-key": "purchasePaymentRecord", params: { ...x.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[K, (e = c.permission) == null ? void 0 : e.print]])])];
    }), content: o(() => [N((p(), u(J, { data: P.value, "show-summary": "", "summary-method": q, "data-format": j.value, "max-height": t(F) }, { default: o(() => [a(n, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), a(n, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center", width: "90" }), a(n, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "right", "min-width": "80" }), a(n, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "right", "min-width": "80" }), a(n, { label: "大写", align: "center", "min-width": "120", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => {
      var r;
      return [e.actuallyPaymentAmount ? (p(), Y("div", he, m(t(z)((r = e == null ? void 0 : e.sourceRow) == null ? void 0 : r.actuallyPaymentAmount)), 1)) : Z("", true)];
    }), _: 1 }), a(n, { key: "paymentReasonId", prop: "paymentReasonId", label: "付款事由", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var r, A, I;
      return [C("div", null, m((I = (A = (r = t(M)) == null ? void 0 : r.label) == null ? void 0 : A.payment_reason) == null ? void 0 : I[e.paymentReasonId]), 1)];
    }), _: 1 }), a(n, { key: "paymentMethod", prop: "paymentMethod", label: "付款方式", align: "center", width: "100" }, { default: o(({ row: e }) => {
      var r;
      return [C("div", null, m((r = t(ue).VL) == null ? void 0 : r[e.paymentMethod]), 1)];
    }), _: 1 }), a(n, { key: "paymentUnit", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), a(n, { key: "paymentBank", prop: "paymentBank", "show-overflow-tooltip": "", label: "付款银行", align: "center", "min-width": "130" }), a(n, { key: "receivingUnit", prop: "receivingUnit", label: "收款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), a(n, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }), a(n, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }), a(n, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), a(n, { key: "auditStatus", prop: "auditStatus", label: "审核状态", align: "center", width: "80" }, { default: o(({ row: e }) => [e.auditStatus === t(f).REJECT.V ? (p(), u(s, { key: 0, type: "warning" }, { default: o(() => [h(m(t(f).VL[e.auditStatus]), 1)]), _: 2 }, 1024)) : (p(), u(s, { key: 1, type: e.auditStatus === t(f).PASS.V ? "success" : "primary" }, { default: o(() => [h(m(t(f).VL[e.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[Q, b.value]]), a(O, { total: t(H), "current-page": t(_).pageNumber, "page-size": t(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(D), onCurrentChange: t(T) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ve as default
};
