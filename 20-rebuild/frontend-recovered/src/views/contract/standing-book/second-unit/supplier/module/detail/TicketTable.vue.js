import { ref as c } from "vue";
import { inject as q } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as d } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as x } from "vue";
import { createCommentVNode as R } from "vue";
import { toDisplayString as $ } from "vue";
import { unref as s } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as P } from "element-plus";
import { _ as S, kc as j, o as F, eb as M, ec as z, bD as v } from "../../../../../../../shared/runtime.js";
import { u as U } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { a as G } from "../../../../../../../modules/detail-991649ef.js";
import J from "../../../../common/components/record/file-download.vue.js";
const K = { class: "invoice-container" }, O = { class: "special-box" }, Q = { key: 1 }, W = { __name: "TicketTable", setup(X, { expose: T }) {
  const r = c(false), { crud: k } = j(), { _commonFn: D, projectInfo: V } = q("tableItem"), { requestData: g, total: f, getSummaries: w } = U(false, { defineData: ["invoiceAmount"] }), { maxHeight: C } = F({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), m = c([]), l = async () => {
    try {
      r.value = true;
      const { content: o, totalElements: i } = await G({ ...g, orderId: V.value.id, purchaseType: k.query.purchaseType });
      m.value = z(o), m.value.forEach((e) => {
        e.invoiceType === v.RECEIPT.V ? e.invoiceTypeName = `${v.VL[e.invoiceType]}` : e.invoiceTypeName = `${v.VL[e.invoiceType]} ( ${e.taxRate} % )`;
      }), f.value = i;
    } catch (o) {
      console.log(o);
    } finally {
      r.value = false;
    }
  };
  l(), D.value.getBillingRecordList = l;
  const p = c(false), b = c([]);
  function B(o) {
    b.value = o.attachments, p.value = true;
  }
  return T({ getList: l }), (o, i) => {
    const e = H, E = u("table-cell-tag"), N = u("common-button"), L = u("common-table"), I = P;
    return n(), y("div", K, [A((n(), d(L, { data: m.value, "max-height": s(C), "summary-method": s(w), border: "", "show-summary": "", stripe: "" }, { default: _(() => [a(e, { align: "center", fixed: "", label: "序号", type: "index", width: "60" }), a(e, { align: "center", fixed: "", label: "收票日期", prop: "invoiceDate", width: "100" }), a(e, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName" }), a(e, { align: "center", fixed: "", label: "发票金额", prop: "invoiceAmount" }, { default: _(({ row: t }) => [x("div", O, [t.invoiceAmount.includes("-") ? (n(), d(E, { key: 0, color: "red", name: "退 减" })) : R("", true), x("span", null, $(t.invoiceAmount), 1)])]), _: 1 }), a(e, { align: "center", label: "开票单位", prop: "supplierName" }), a(e, { align: "center", label: "收票单位", prop: "invoiceSignBody.name" }), a(e, { align: "center", label: "发票编号", prop: "invoiceNumber" }), a(e, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), a(e, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: _(({ row: t }) => {
      var h;
      return [(h = t.attachments) != null && h.length ? (n(), d(N, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (Y) => B(t) }, null, 8, ["onClick"])) : (n(), y("span", Q, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[I, r.value]]), a(M, { "request-data": s(g), total: s(f), onHandleChange: l }, null, 8, ["request-data", "total"]), a(J, { "file-list": b.value, modelValue: p.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => p.value = t) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, ne = S(W, [["__scopeId", "data-v-45ee6230"]]);
export {
  ne as default
};
