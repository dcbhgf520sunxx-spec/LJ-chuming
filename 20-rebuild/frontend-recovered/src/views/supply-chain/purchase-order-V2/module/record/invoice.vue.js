import { ref as i } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as b } from "vue";
import { withCtx as y } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as E } from "vue";
import { unref as c } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as L } from "element-plus";
import { _ as $, o as q, eb as A, ec as H, bD as m } from "../../../../../shared/runtime.js";
import { u as P } from "../../../../../modules/useTableTotal-3d22365a.js";
import { b as R } from "../../../../../modules/supplier-e2667d36.js";
import S from "../../../../contract/standing-book/common/components/record/file-download.vue.js";
const M = { class: "invoice-container" }, z = { class: "download-container" }, F = { key: 1 }, U = { __name: "invoice", props: { orderId: { type: [Number, String] } }, setup(x) {
  const T = x, s = i(false), { requestData: p, total: u, getSummaries: w } = P(false, { defineData: ["invoiceAmount"] }), { maxHeight: D } = q({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), r = i([]), _ = async () => {
    try {
      s.value = true;
      const { content: t, totalElements: o } = await R({ ...p, orderId: T.orderId });
      r.value = H(t), r.value.forEach((e) => {
        e.invoiceType === m.RECEIPT.V ? e.invoiceTypeName = `${m.VL[e.invoiceType]}` : e.invoiceTypeName = `${m.VL[e.invoiceType]} ( ${e.taxRate} % )`;
      }), u.value = o;
    } catch (t) {
      console.log(t);
    } finally {
      s.value = false;
    }
  };
  _();
  const d = i(false), v = i([]);
  function V(t) {
    v.value = t.attachments, d.value = true;
  }
  return (t, o) => {
    const e = I, N = g("common-button"), k = g("common-table"), B = L;
    return l(), h("div", M, [C((l(), b(k, { data: r.value, "max-height": c(D), "summary-method": c(w), border: "", "show-summary": "", stripe: "" }, { default: y(() => [a(e, { align: "center", fixed: "", label: "序号", type: "index", width: "60" }), a(e, { align: "center", fixed: "", label: "收票日期", prop: "invoiceDate", width: "100" }), a(e, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName" }), a(e, { align: "center", fixed: "", label: "发票金额", prop: "invoiceAmount" }), a(e, { align: "center", label: "开票单位", prop: "supplierName" }), a(e, { align: "center", label: "收票单位", prop: "invoiceSignBody.name" }), a(e, { align: "center", label: "发票编号", prop: "invoiceNumber" }), a(e, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), a(e, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: y(({ row: n }) => {
      var f;
      return [E("div", z, [(f = n.attachments) != null && f.length ? (l(), b(N, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (j) => V(n) }, null, 8, ["onClick"])) : (l(), h("span", F, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[B, s.value]]), a(A, { "request-data": c(p), total: c(u), onHandleChange: _ }, null, 8, ["request-data", "total"]), a(S, { "file-list": v.value, modelValue: d.value, "onUpdate:modelValue": o[0] || (o[0] = (n) => d.value = n) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, W = $(U, [["__scopeId", "data-v-1873cd2a"]]);
export {
  W as default
};
