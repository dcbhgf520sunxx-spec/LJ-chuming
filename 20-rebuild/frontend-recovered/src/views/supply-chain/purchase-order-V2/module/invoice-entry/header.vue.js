import { e3 as y, dp as j, e5 as k, b as p, ec as D, kZ as E } from "../../../../../shared/runtime.js";
import { h as N, a as P } from "../../../../../modules/invoice-entry-d59b5377.js";
import { g as S } from "../../../../../modules/payment-settlement-a7865af1.js";
import { u as A } from "../../../../../modules/hook-467b8301.js";
import { inject as U } from "vue";
import { reactive as B } from "vue";
import { computed as F } from "vue";
import { watch as H } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as c } from "vue";
import { withCtx as u } from "vue";
import { unref as r } from "vue";
const R = { class: "header-container" }, W = { __name: "header", setup(Z, { expose: m }) {
  const f = U("invoice_data"), { formData: e, projectInfo: d } = f, h = B({ total: 0 }), I = F(() => y(P, d)), { supplierList: _, contractNoList: i, getSupplierList: g, getPurchaseContractNumber: v } = A({ form: e });
  g();
  const b = async () => {
    try {
      const { invoiceDto: o, projectName: s } = await S({ orderIds: e.orderIds });
      Object.assign(d, o[0], { projectName: s }), D(o).forEach((t) => {
        t.invoiceAmount = "", t.supplierPaymentId = t.orderId, e.orderInvoiceList.some((L) => L.orderId === t.orderId) || e.orderInvoiceList.push(t);
      });
    } catch (o) {
      console.log("获取付款及发票记录失败" + o);
    }
  }, l = E(["supplierId", "orderIds", "branchCompanyName", "amount", "basicClass", "settlementAmount"], d), C = () => {
    l("supplierId", () => {
      e.orderId = null, i.value = [];
    }), p(e.supplierId) || v();
  }, x = async (o) => {
    l("orderIds", () => {
    }), p(e.orderIds) || await b();
  };
  return H(() => e.orderIds, (o, s) => {
    if ((s == null ? void 0 : s.length) > (o == null ? void 0 : o.length)) {
      const n = s.filter((a) => !o.includes(a))[0], t = e.orderInvoiceList.findIndex((a) => a.orderId == n);
      t !== -1 && e.orderInvoiceList.splice(t, 1);
    }
    o != null && o.length || (e.orderInvoiceList = []);
  }), m({ recordInfo: h }), (o, s) => {
    const n = M("common-select-v2");
    return T(), O("div", R, [c(j, { "header-title": "基本信息" }), c(k, { column: 2, "form-data": r(e), "form-rules": r(N), "table-list": I.value }, { supplierId: u(({ item: t }) => [c(n, { modelValue: r(e)[t], "onUpdate:modelValue": (a) => r(e)[t] = a, options: r(_), clearable: "", filterable: "", placeholder: "请输入或选择供应商", onChange: C }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderIds: u(({ item: t }) => [c(n, { modelValue: r(e)[t], "onUpdate:modelValue": (a) => r(e)[t] = a, disabled: !r(i).length, options: r(i), clearable: "", multiple: "", collapseTags: "", filterable: "", placeholder: "请输入或选择采购合同号", onChange: x }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  W as default
};
