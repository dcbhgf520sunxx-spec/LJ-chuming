import { inject as m } from "vue";
import { reactive as A } from "vue";
import { computed as D } from "vue";
import { ref as E } from "vue";
import { watch as f } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as s } from "vue";
import { withCtx as I } from "vue";
import { unref as i } from "vue";
import { ElInput as B } from "element-plus";
import { e3 as P, i as c, dp as H, e5 as z, b as l, ec as O } from "../../../../../../shared/runtime.js";
import { h as R, a as T } from "../../../../../../modules/invoice-entry-fec44303.js";
import { g as q } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { u as F } from "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
const G = { class: "header-container" }, Y = { __name: "header", setup(J, { expose: _ }) {
  const h = m("invoice_data"), { formData: e, projectInfo: p } = h, v = A({ total: 0 }), b = D(() => P(T, p)), { supplierList: y, getSupplierList: g, getContractNo: w } = F({ form: e });
  g();
  const u = E(false), x = async () => {
    try {
      const { invoiceDto: t, projectName: o } = await q({ orderIds: [e.orderId] });
      u.value = true, Object.assign(p, t[0], { projectName: o }), O(t).forEach((a) => {
        a.invoiceAmount = "", a.supplierPaymentId = a.orderId, e.orderInvoiceList.some((k) => k.orderId === a.orderId) || e.orderInvoiceList.push(a);
      });
    } catch (t) {
      console.log("获取付款及发票记录失败" + t);
    }
  }, C = () => {
    l(e.supplierId) || w();
  }, L = async (t) => {
    l(e.orderId) || await x();
  }, { size: j, item_data: n } = m("common");
  return j.value = "60%", f(() => n.value, async (t) => {
    if (c(t)) {
      const { supplierId: o, id: r } = t;
      e.supplierId = o, e.orderId = r;
    }
  }, { immediate: true, deep: true }), f(e, async () => {
    c(e.supplierId) && l(y.value) && await C(), c(e.orderId) && !u.value && await L();
  }, { immediate: true, deep: true }), _({ recordInfo: v }), (t, o) => {
    const r = B;
    return N(), S("div", G, [s(H, { "header-title": "基本信息" }), s(z, { column: 2, "form-data": i(e), "form-rules": i(R), "table-list": b.value }, { supplierId: I(() => {
      var a, d;
      return [s(r, { "model-value": (d = (a = i(n)) == null ? void 0 : a.supplier) == null ? void 0 : d.name, disabled: "" }, null, 8, ["model-value"])];
    }), orderId: I(() => {
      var a;
      return [s(r, { "model-value": (a = i(n)) == null ? void 0 : a.serialNumber, disabled: "" }, null, 8, ["model-value"])];
    }), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  Y as default
};
