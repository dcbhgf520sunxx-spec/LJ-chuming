import { ref as y } from "vue";
import { computed as E } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as w } from "vue";
import { Fragment as B } from "vue";
import { renderList as F } from "vue";
import { ElTableColumn as H } from "element-plus";
import { InfoFilled as $ } from "@element-plus/icons-vue";
import { ElIcon as L } from "element-plus";
import { ElTooltip as M } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as U, _ as j } from "./module/header.vue.js";
import { G } from "../../../../../../modules/contract-9b18cc88.js";
import { _ as K, t as z, x as J, o as Q, jF as W, bD as X, P as Y, iy as Z, ba as ee } from "../../../../../../shared/runtime.js";
const te = { class: "app-container" }, ae = { class: "head-container" }, oe = ["onDblclick"], ie = { __name: "index", setup(ne) {
  const g = G.invoice, { decimalPrecision: _ } = z(), x = { add: false, edit: false, del: false, download: false }, h = y(), m = y(false), b = y(), { crud: a, columns: r, CRUD: k } = J({ title: "收票台账", sort: [], permission: { ...g }, invisibleColumns: [], optShow: { ...x }, crudApi: { ...U }, hasPagination: true }, h), { maxHeight: T } = Q({ wrapperBox: ".pay-invoice", paginate: true, extraHeight: 120 }), D = E(() => [["invoiceAmount", ["to-thousand", _.value.contract]], ["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["propertyType", ["parse-enum", W]], ["invoiceType", ["parse-enum", X]], ["taxRate", ["suffix", "%"]]]);
  function N(l) {
    b.value = l.id, m.value = true;
  }
  k.HOOK.beforeRefresh = () => {
    var l;
    ((l = a.query.createTime) == null ? void 0 : l.length) > 0 ? (a.query.startDate = a.query.createTime[0], a.query.endDate = a.query.createTime[1]) : (a.query.startDate = void 0, a.query.endDate = void 0);
  };
  function S(l) {
    return ee(l, { props: [["invoiceAmount", _.value.contract]], toThousandFields: ["invoiceAmount"] });
  }
  return (l, d) => {
    const o = H, C = $, I = L, R = M, q = P("common-table"), A = O;
    return t(), f("div", te, [u("div", ae, [s(e(j))]), V((t(), i(q, { ref_key: "tableRef", ref: h, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(T), style: { width: "100%" }, "data-format": D.value, showEmptySymbol: false, stripe: false, "show-summary": "", "summary-method": S }, { default: p(() => [s(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("propertyType") ? (t(), i(o, { key: "propertyType", prop: "propertyType", "show-overflow-tooltip": true, align: "center", label: "订单类型", width: "100" })) : n("", true), e(r).visible("supplierName") ? (t(), i(o, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "销售单位", align: "center", "min-width": "140" })) : n("", true), e(r).visible("branchCompanyName") ? (t(), i(o, { key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "购方单位", align: "center", "min-width": "140" })) : n("", true), e(r).visible("receiveInvoiceDate") ? (t(), i(o, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "100" })) : n("", true), e(r).visible("invoiceAmount") ? (t(), i(o, { key: "invoiceAmount", prop: "invoiceAmount", label: "发票金额", align: "right", "min-width": "100" })) : n("", true), e(r).visible("invoiceSerialNumber") ? (t(), i(o, { key: "invoiceSerialNumber", prop: "invoiceSerialNumber", "show-overflow-tooltip": true, label: "发票号码", align: "center", "min-width": "120" }, { default: p((c) => [u("div", null, w(c.row.invoiceSerialNumber), 1)]), _: 1 })) : n("", true), s(o, { key: "attachments", prop: "attachments", label: "附件", align: "center", "show-overflow-tooltip": true, "min-width": "140" }, { header: p(() => [s(R, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: p(() => [u("div", null, [d[1] || (d[1] = u("span", null, "附件", -1)), s(I, null, { default: p(() => [s(C)]), _: 1 })])]), _: 1 })]), default: p((c) => [c.row.attachments && c.row.attachments.length > 0 ? (t(true), f(B, { key: 0 }, F(c.row.attachments, (v) => (t(), f("div", { key: v.id }, [u("div", { style: { cursor: "pointer" }, onDblclick: (re) => N(v) }, w(v.name), 41, oe)]))), 128)) : n("", true)]), _: 1 }), e(r).visible("invoiceType") ? (t(), i(o, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", width: "106" })) : n("", true), e(r).visible("taxRate") ? (t(), i(o, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "60" })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[A, e(a).loading]]), s(e(Y)), m.value ? (t(), i(Z, { key: 0, isVisible: m.value, showType: "attachment", id: b.value, onClose: d[0] || (d[0] = (c) => m.value = false) }, null, 8, ["isVisible", "id"])) : n("", true)]);
  };
} }, ue = K(ie, [["__scopeId", "data-v-33f62885"]]);
export {
  ue as default
};
