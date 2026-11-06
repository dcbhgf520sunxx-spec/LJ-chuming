import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as e } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as m } from "vue";
import { createBlock as x } from "vue";
import { unref as p } from "vue";
import { renderSlot as v } from "vue";
import { Fragment as w } from "vue";
import { ElTableColumn as k } from "element-plus";
import { ElButton as N } from "element-plus";
import { u as T } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { u as B } from "../../../../../../modules/useTableHeight-90797a0b.js";
import "../../../../../../shared/runtime.js";
const C = { class: "download-container" }, R = { key: 1 }, H = { __name: "invoice", props: { data: { type: Array } }, setup(d) {
  const u = d, { getSummaries: _ } = T(false, { defineData: ["actualInvoiceAmount"] }), { tableRef: f, maxHeight: b } = B();
  return (l, i) => {
    const a = k, h = N, g = y("common-table");
    return o(), r(w, null, [e(g, { ref_key: "tableRef", ref: f, data: u.data, "max-height": p(b), "summary-method": p(_), "show-summary": "", stripe: "" }, { default: n(() => [e(a, { align: "center", fixed: "", label: "序号", type: "index" }), e(a, { align: "center", fixed: "", label: "开票日期", prop: "invoiceDate", width: "100" }), e(a, { align: "center", fixed: "", label: "凭证号", prop: "voucherNumber", width: "100" }), e(a, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName", width: "140" }, { default: n(({ row: t }) => [s("span", null, c(t.invoiceTypeName) + "  ", 1)]), _: 1 }), e(a, { align: "center", label: "税率", prop: "taxRate" }, { default: n(({ row: t }) => [m(c(t.taxRate) + " %", 1)]), _: 1 }), e(a, { align: "center", label: "发票金额", prop: "actualInvoiceAmount", width: "160" }), e(a, { align: "center", label: "发票编号", "min-width": "140", prop: "invoiceNo" }), e(a, { align: "center", label: "创建人", prop: "writtenByName" }), e(a, { align: "center", label: "凭证", width: "100" }, { default: n(({ row: t }) => [s("div", C, [t.attachments ? (o(), x(h, { key: 0, plain: "", size: "default", type: "primary", onClick: (S) => l.download(t) }, { default: n(() => i[0] || (i[0] = [m("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (o(), r("span", R, "-"))])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"]), v(l.$slots, "default")], 64);
  };
} };
export {
  H as default
};
