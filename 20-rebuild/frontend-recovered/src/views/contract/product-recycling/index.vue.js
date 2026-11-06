import { ref as u } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as r } from "vue";
import { withDirectives as P } from "vue";
import { unref as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as o } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as V } from "element-plus";
import { _ as H } from "../../../modules/header.vue_vue_type_script_setup_true_lang-b7ba9579.js";
import { x as I, o as M, ac as T, P as E, k9 as q } from "../../../shared/runtime.js";
import { c as J } from "../../../modules/product-recycling-d772694e.js";
import Q from "./module/total-detail.vue.js";
import j from "./module/detail.vue.js";
import { J as z } from "../../../modules/contract-9b18cc88.js";
import "./module/payment-table.vue.js";
import "./module/add/payment.vue.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
import "./module/invoice-table.vue.js";
import "./module/add/invoice.vue.js";
const F = { class: "app-container" }, G = ["onClick"], K = ["onClick"], O = ["onClick"], ue = { __name: "index", setup(W) {
  const x = { add: false, delete: false }, g = u(), b = u(false), _ = u(false), C = u("payment"), y = u(), k = u([]), { crud: d, columns: c } = I({ optShow: x, crudApi: J, permission: z }, g), { maxHeight: R } = M({ paginate: true });
  function U(a) {
    y.value = a, b.value = true;
  }
  function h(a, s) {
    const i = k.value.find((f) => f.id === a.branchCompanyId);
    a.bankList = i.bankAccountList || [], C.value = s, y.value = a, _.value = true;
  }
  async function $() {
    try {
      const { content: a } = await q();
      k.value = a;
    } catch (a) {
      console.log(a, "=========>");
    }
  }
  return L(() => {
    $();
  }), (a, s) => {
    const i = S, f = N("table-cell-tag"), D = V;
    return n(), B("div", F, [r(H), P((n(), l(T, { ref_key: "tableRef", ref: g, data: t(d).data, "empty-text": t(d).emptyText, maxHeight: t(R), "show-empty-symbol": false }, { default: m(() => [r(i, { align: "center", label: "序号", type: "index", width: "60" }), t(c).visible("branchCompanyName") ? (n(), l(i, { key: "branchCompanyName", align: "center", label: "购买方", prop: "branchCompanyName" })) : o("", true), t(c).visible("customerUnit") ? (n(), l(i, { key: "customerUnit", align: "center", label: "出售方", prop: "customerUnit", "show-overflow-tooltip": "" })) : o("", true), t(c).visible("totalAmount") ? (n(), l(i, { key: "totalAmount", align: "center", label: "累计回收金额", prop: "totalAmount" }, { default: m(({ row: e }) => [p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => U(e) }, v(e.totalAmount), 9, G)]), _: 1 })) : o("", true), t(c).visible("paymentAmount") ? (n(), l(i, { key: "paymentAmount", align: "center", label: "累计付款", prop: "paymentAmount" }, { default: m(({ row: e }) => [e != null && e.unCheckPaymentCount ? (n(), l(f, { key: 0, name: String(e == null ? void 0 : e.unCheckPaymentCount), color: "#e64242" }, null, 8, ["name"])) : o("", true), p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => h(e, "payment") }, v(e == null ? void 0 : e.paymentAmount), 9, K)]), _: 1 })) : o("", true), t(c).visible("paymentRate") ? (n(), l(i, { key: "paymentRate", align: "center", label: "付款率", prop: "paymentRate" }, { default: m(({ row: e }) => [p("span", null, v(e.paymentRate) + "%", 1)]), _: 1 })) : o("", true), t(c).visible("invoiceAmount") ? (n(), l(i, { key: "invoiceAmount", align: "center", label: "累计收票", porp: "invoiceAmount" }, { default: m(({ row: e }) => [e != null && e.unCheckInvoiceCount ? (n(), l(f, { key: 0, name: String(e == null ? void 0 : e.unCheckInvoiceCount), color: "#e64242" }, null, 8, ["name"])) : o("", true), p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => h(e, "invoice") }, v(e == null ? void 0 : e.invoiceAmount), 9, O)]), _: 1 })) : o("", true), t(c).visible("invoiceRate") ? (n(), l(i, { key: "invoiceRate", align: "center", label: "收票率", prop: "invoiceRate" }, { default: m(({ row: e }) => [p("span", null, v(e.invoiceRate) + "%", 1)]), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "empty-text", "maxHeight"])), [[D, t(d).loading]]), r(E), r(Q, { visible: b.value, "onUpdate:visible": s[0] || (s[0] = (e) => b.value = e), currentLine: y.value }, null, 8, ["visible", "currentLine"]), r(j, { status: C.value, "onUpdate:status": s[1] || (s[1] = (e) => C.value = e), visible: _.value, "onUpdate:visible": s[2] || (s[2] = (e) => _.value = e), "current-line": y.value, onClose: t(d).toQuery }, null, 8, ["status", "visible", "current-line", "onClose"])]);
  };
} };
export {
  ue as default
};
