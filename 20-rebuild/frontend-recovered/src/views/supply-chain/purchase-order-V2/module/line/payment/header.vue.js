import { inject as f } from "vue";
import { useStore as N } from "vuex";
import { computed as y } from "vue";
import { watch as p } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as r } from "vue";
import { withDirectives as w } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as E } from "vue";
import { createBlock as P } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as H } from "element-plus";
import { p as q, a as z } from "../../../../../../modules/data-e85015ff.js";
import { g as F } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as O, e3 as R, i as T, dp as $, cy as G, e5 as J, b as u, ec as K } from "../../../../../../shared/runtime.js";
import { u as M } from "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
const Q = { class: "header-container" }, W = { key: 0, class: "notSlotValue truncate" }, le = { __name: "header", setup(X) {
  const { size: D } = f("common"), g = N(), k = y(() => g.getters.user.id), V = f("payment_data"), { formData: a, projectInfo: I, paymentTypelist: n } = V, { supplierList: j, getSupplierList: x, getContractNo: B } = M({ form: a });
  x();
  const C = y(() => O(R(z, I)));
  p(k, (t) => {
    a.applicantId = t;
  }, { immediate: true });
  const L = async () => {
    var t;
    try {
      const { invoiceDto: l, projectName: d, paymentDto: i } = await F({ orderIds: a.orderId });
      Object.assign(I, l[0], { projectName: d }), (t = n == null ? void 0 : n.value) != null && t.length && (n.value = []), n.value = i, a.paymentBank = null, a.paymentBankAccount = null, K(l).forEach((e) => {
        e.moneyAmount = "", e.supplierPaymentId = e.orderId, a.tableList.some((_) => _.orderId === e.orderId) || a.tableList.push(e);
      });
    } catch (l) {
      console.log(l);
    }
  };
  p(() => a.tableList.length, (t) => {
    D.value = t > 0 ? "60%" : "50%";
  });
  const { item_data: m } = f("common");
  return p(m, (t) => {
    if (T(t)) {
      const { supplier: l, id: d } = t;
      a.supplierId = l.id, a.orderId = d;
    }
  }, { immediate: true, deep: true }), p(a, async () => {
    !u(a.supplierId) && u(j.value) && await B(), !u(a.orderId) && u(a.tableList) && await L();
  }, { immediate: true, deep: true }), (t, l) => {
    const d = U, i = H, v = S("ellipsis");
    return h(), b("div", Q, [s($, { "header-title": "基本信息" }), s(J, { column: 2, "form-data": r(a), "form-rules": r(q), "table-list": C.value }, { applyDate: c(({ item: e }) => [s(d, { modelValue: r(a)[e], "onUpdate:modelValue": (o) => r(a)[e] = o, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applicantId: c(({ item: e }) => [s(G, { modelValue: r(a)[e], "onUpdate:modelValue": (o) => r(a)[e] = o, clearable: false, placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: c(() => {
      var e, o;
      return [s(i, { "model-value": (o = (e = r(m)) == null ? void 0 : e.supplier) == null ? void 0 : o.name, disabled: "" }, null, 8, ["model-value"])];
    }), orderId: c(() => {
      var e;
      return [s(i, { "model-value": (e = r(m)) == null ? void 0 : e.serialNumber, disabled: "" }, null, 8, ["model-value"])];
    }), projectName: c(({ val: e, label: o }) => [e ? w((h(), b("div", W, [A(E(e.split("/").filter(Boolean).map((_) => `【${_}】`).join(" ")), 1)])), [[v]]) : (h(), P(i, { key: 1, placeholder: o, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  le as default
};
