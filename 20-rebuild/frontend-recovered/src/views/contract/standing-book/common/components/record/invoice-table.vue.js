import { ref as c } from "vue";
import { inject as x } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as d } from "vue";
import { createElementVNode as g } from "vue";
import { createCommentVNode as j } from "vue";
import { unref as u } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElButton as S } from "element-plus";
import { vLoading as U } from "element-plus";
import { _ as M, o as P, eb as $, ec as z, bD as F } from "../../../../../../shared/runtime.js";
import { u as G } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { b as J } from "../../../../../../modules/self-healing-6f411a5c.js";
import K from "./file-download.vue.js";
const O = { class: "invoice-container" }, Q = { key: 0 }, W = { key: 1 }, X = { class: "special-box" }, Y = { class: "download-container" }, Z = { key: 1 }, ee = { __name: "invoice-table", props: { level: { type: [Number, String], required: true } }, setup(k, { expose: B }) {
  const D = k, m = c(false), { _commonFn: N } = x("selfParentData"), { requestData: f, total: b, getSummaries: w } = G(false, { defineData: ["actualInvoiceAmount"] }), { maxHeight: C } = P({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), { projectInfo: I } = x("tableItem"), p = c([]), l = async () => {
    try {
      m.value = true;
      const { content: n, totalElements: i } = await J({ projectId: I.value.project.id, ...f, level: D.level });
      p.value = z(n), p.value.forEach((e) => {
        e.invoiceTypeName = F.VL[e.invoiceType];
      }), b.value = i;
    } catch (n) {
      console.log(n);
    } finally {
      m.value = false;
    }
  };
  l(), N.value.getBillingRecordList = l;
  const _ = c(false), h = c([]), V = async (n) => {
    h.value = n.attachments, _.value = true;
  };
  return B({ getList: l }), (n, i) => {
    const e = H, L = T("table-cell-tag"), E = S, q = T("common-table"), A = U;
    return o(), s("div", O, [R((o(), v(q, { data: p.value, "max-height": u(C), "summary-method": u(w), border: "", "show-summary": "", stripe: "" }, { default: r(() => [t(e, { align: "center", fixed: "", label: "序号", type: "index", width: "60" }), t(e, { align: "center", fixed: "", label: "开票日期", prop: "invoiceDate", width: "140" }), t(e, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName" }, { default: r(({ row: a }) => [a.taxRate ? (o(), s("span", Q, d(a.invoiceTypeName) + " （" + d(a.taxRate + " %") + ")", 1)) : (o(), s("span", W, d(a.invoiceTypeName), 1))]), _: 1 }), t(e, { align: "center", fixed: "", label: "发票金额", prop: "actualInvoiceAmount" }, { default: r(({ row: a }) => [g("div", X, [a.actualInvoiceAmount.includes("-") ? (o(), v(L, { key: 0, color: "red", name: "退 减" })) : j("", true), g("span", null, d(a.actualInvoiceAmount), 1)])]), _: 1 }), t(e, { align: "center", label: "开票单位", prop: "invoiceUnit" }), t(e, { align: "center", label: "收票单位", prop: "collectionUnit" }), t(e, { align: "center", label: "发票编号", prop: "invoiceNo" }), t(e, { align: "center", label: "办理人", prop: "writtenByName", width: "120" }), t(e, { align: "center", label: "凭证", width: "80" }, { default: r(({ row: a }) => {
      var y;
      return [g("div", Y, [(y = a.attachments) != null && y.length ? (o(), v(E, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: (ae) => V(a) }, null, 8, ["onClick"])) : (o(), s("span", Z, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[A, m.value]]), t($, { "request-data": u(f), total: u(b), onHandleChange: l }, null, 8, ["request-data", "total"]), t(K, { modelValue: _.value, "onUpdate:modelValue": i[0] || (i[0] = (a) => _.value = a), "file-list": h.value }, null, 8, ["modelValue", "file-list"])]);
  };
} }, ce = M(ee, [["__scopeId", "data-v-ddcbe167"]]);
export {
  ce as default
};
