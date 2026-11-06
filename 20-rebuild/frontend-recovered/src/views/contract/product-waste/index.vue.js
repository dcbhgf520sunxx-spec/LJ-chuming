import { ref as u } from "vue";
import { onMounted as S } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as m } from "vue";
import { withDirectives as H } from "vue";
import { unref as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as M } from "../../../modules/header.vue_vue_type_script_setup_true_lang-2aa1c749.js";
import { x as P, o as T, P as E, k9 as q } from "../../../shared/runtime.js";
import { c as K } from "../../../modules/product-waste-c86c76d6.js";
import Q from "./module/total-detail.vue.js";
import W from "./module/detail.vue.js";
import { K as j } from "../../../modules/contract-9b18cc88.js";
import "../../../modules/scrap-sell-e306ced6.js";
import "./module/collection-table.vue.js";
import "./module/add/collection.vue.js";
import "./module/invoice-table.vue.js";
import "./module/add/invoice.vue.js";
const z = { class: "app-container" }, F = ["onClick"], G = ["onClick"], J = ["onClick"], ue = { __name: "index", setup(O) {
  const R = { add: false, delete: false }, h = u(), _ = u(false), y = u(false), C = u("payment"), d = u(), k = u([]), { crud: b, columns: s } = P({ optShow: R, crudApi: K, permission: j }, h), { maxHeight: D } = T({ paginate: true });
  function L(a) {
    d.value = a, _.value = true;
  }
  function g(a, c) {
    const o = k.value.find((f) => f.id === a.branchCompanyId);
    a.bankList = o.bankAccountList || [], C.value = c, d.value = a, y.value = true;
  }
  async function N() {
    try {
      const { content: a } = await q();
      k.value = a;
    } catch (a) {
      console.log(a, "=========>");
    }
  }
  return S(() => {
    N();
  }), (a, c) => {
    const o = U, f = x("table-cell-tag"), $ = x("common-table"), B = I;
    return n(), V("div", z, [m(M), H((n(), l($, { ref_key: "tableRef", ref: h, data: t(b).data, "empty-text": t(b).emptyText, maxHeight: t(D), "show-empty-symbol": false }, { default: r(() => [m(o, { align: "center", label: "序号", type: "index", width: "60" }), t(s).visible("purchaser") ? (n(), l(o, { key: "purchaser", align: "center", label: "购买方", prop: "purchaser" })) : i("", true), t(s).visible("branchCompanyName") ? (n(), l(o, { key: "branchCompanyName", align: "center", label: "出售方", prop: "branchCompanyName", "show-overflow-tooltip": "" })) : i("", true), t(s).visible("totalAmount") ? (n(), l(o, { key: "totalAmount", align: "center", label: "累计出售金额", prop: "totalAmount" }, { default: r(({ row: e }) => [p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => L(e) }, v(e.totalAmount), 9, F)]), _: 1 })) : i("", true), t(s).visible("collectionAmount") ? (n(), l(o, { key: "collectionAmount", align: "center", label: "累计收款", prop: "collectionAmount" }, { default: r(({ row: e }) => [e != null && e.unCheckCollectionCount ? (n(), l(f, { key: 0, name: String(e == null ? void 0 : e.unCheckCollectionCount), color: "#e64242" }, null, 8, ["name"])) : i("", true), p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => g(e, "collection") }, v(e == null ? void 0 : e.collectionAmount), 9, G)]), _: 1 })) : i("", true), t(s).visible("collectionRate") ? (n(), l(o, { key: "collectionRate", align: "center", label: "收款率", prop: "collectionRate" }, { default: r(({ row: e }) => [p("span", null, v(e.collectionRate) + "%", 1)]), _: 1 })) : i("", true), t(s).visible("invoiceAmount") ? (n(), l(o, { key: "invoiceAmount", align: "center", label: "累计开票", porp: "invoiceAmount" }, { default: r(({ row: e }) => [e != null && e.unCheckInvoiceCount ? (n(), l(f, { key: 0, name: String(e == null ? void 0 : e.unCheckInvoiceCount), color: "#e64242" }, null, 8, ["name"])) : i("", true), p("span", { style: { color: "#1a8ef9", cursor: "pointer" }, onClick: (A) => g(e, "invoice") }, v(e == null ? void 0 : e.invoiceAmount), 9, J)]), _: 1 })) : i("", true), t(s).visible("invoiceRate") ? (n(), l(o, { key: "invoiceRate", align: "center", label: "开票率", prop: "invoiceRate" }, { default: r(({ row: e }) => [p("span", null, v(e.invoiceRate) + "%", 1)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "maxHeight"])), [[B, t(b).loading]]), m(E), m(Q, { visible: _.value, "onUpdate:visible": c[0] || (c[0] = (e) => _.value = e), currentLine: d.value }, null, 8, ["visible", "currentLine"]), m(W, { status: C.value, "onUpdate:status": c[1] || (c[1] = (e) => C.value = e), visible: y.value, "onUpdate:visible": c[2] || (c[2] = (e) => y.value = e), "current-line": d.value, onClose: t(b).toQuery }, null, 8, ["status", "visible", "current-line", "onClose"])]);
  };
} };
export {
  ue as default
};
