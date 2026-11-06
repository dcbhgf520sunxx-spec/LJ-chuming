import { ref as l } from "vue";
import { inject as T } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as N } from "vue";
import { unref as o } from "vue";
import { createBlock as d } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as s } from "vue";
import { createElementVNode as g } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as L } from "element-plus";
import { x as R, D as P, o as E, bD as h, P as I } from "../../../../../../shared/runtime.js";
import { j as U } from "../../../../../../modules/index-dfff0f60.js";
import j from "../../../../../contract/standing-book/common/components/record/file-download.vue.js";
const q = { key: 0 }, F = { key: 1 }, M = { class: "special-box" }, S = { key: 1 }, O = { __name: "invoice", setup($) {
  const u = l(), { table_item_data: y } = T("common"), { crud: i } = R({ title: "开票记录", crudApi: { get: U } }, u);
  i.query.id = y.value.id;
  const x = l([["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", P.YUAN]]]), { maxHeight: k } = E({ mainBox: ".detail-record", extraBox: [".el-drawer__header", ".header-container", ".box-container"], wrapperBox: ".table-container", navbar: false, paginate: true, minHeight: 300, clientHRepMainH: true }, i.data), m = l(false), _ = l([]);
  function D(v) {
    _.value = v.attachments, m.value = true;
  }
  return (v, b) => {
    const a = H, V = p("table-cell-tag"), A = p("common-button"), B = p("common-table"), C = L;
    return n(), c("div", null, [N((n(), d(B, { ref_key: "table_ref", ref: u, data: o(i).data, "data-format": x.value, "empty-text": o(i).emptyText, "max-height": o(k) }, { default: r(() => [t(a, { align: "center", label: "序号", type: "index", width: "60" }), t(a, { align: "center", label: "收票日期", prop: "invoiceDate", width: "100" }), t(a, { align: "center", label: "发票类型", "max-width": "120", prop: "invoiceType" }, { default: r(({ row: e }) => [e.taxRate ? (n(), c("span", q, s(o(h).VL[e.invoiceType]) + " （" + s(e.taxRate + " %") + ")", 1)) : (n(), c("span", F, s(o(h).VL[e.invoiceType]), 1))]), _: 1 }), t(a, { align: "center", label: "发票金额", prop: "invoiceAmount" }, { default: r(({ row: e }) => [g("div", M, [e.invoiceAmount !== "-" && e.invoiceAmount.includes("-") ? (n(), d(V, { key: 0, color: "red", name: "退减" })) : w("", true), g("span", null, s(e.invoiceAmount), 1)])]), _: 1 }), t(a, { align: "center", label: "开票单位", prop: "supplierName" }), t(a, { align: "center", label: "收票单位", prop: "invoiceSignBody.name" }), t(a, { align: "center", label: "发票编号", prop: "invoiceNumber" }), t(a, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), t(a, { align: "center", label: "附件", prop: "attachments", width: "80" }, { default: r(({ row: e }) => {
      var f;
      return [(f = e.attachments) != null && f.length ? (n(), d(A, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (z) => D(e) }, null, 8, ["onClick"])) : (n(), c("span", S, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[C, o(i).loading]]), t(I), t(j, { "file-list": _.value, modelValue: m.value, "onUpdate:modelValue": b[0] || (b[0] = (e) => m.value = e) }, null, 8, ["file-list", "modelValue"])]);
  };
} };
export {
  O as default
};
