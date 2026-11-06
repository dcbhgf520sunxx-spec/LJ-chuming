import { inject as y } from "vue";
import { useStore as A } from "vuex";
import { computed as I } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as u } from "vue";
import { unref as o } from "vue";
import { createBlock as v } from "vue";
import { withCtx as m } from "vue";
import { withDirectives as H } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as R } from "vue";
import { ElDatePicker as T } from "element-plus";
import { ElInput as $ } from "element-plus";
import { b as G, c as J } from "../../../../../../modules/data-33e35578.js";
import { g as K } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as M, e3 as Q, dp as W, cy as X, e5 as Y, b as D, ec as Z, e6 as w } from "../../../../../../shared/runtime.js";
import { u as ee } from "../../../../../../modules/hook-467b8301.js";
const te = { class: "header-container" }, ae = { key: 0, class: "notSlotValue truncate" }, de = { __name: "header", setup(oe) {
  const b = y("size"), k = A(), x = I(() => k.getters.user.id), C = y("payment_data"), { formData: e, projectInfo: d, paymentTypelist: i } = C, L = I(() => M(Q(J, d)));
  _(() => x.value, (t) => {
    e.applicantId = t;
  }, { immediate: true });
  const { supplierList: j, contractNoList: f, getSupplierList: N, getPurchaseContractNumber: U } = ee({ form: e });
  N();
  const B = async () => {
    var t;
    try {
      const { invoiceDto: l, projectName: p, paymentDto: r } = await K({ orderIds: e.orderIds });
      Object.assign(d, l[0], { projectName: p }), (t = i == null ? void 0 : i.value) != null && t.length && (i.value = []), i.value = r, e.paymentBank = null, e.paymentBankAccount = null, Z(l).forEach((n) => {
        n.moneyAmount = "", n.supplierPaymentId = n.orderId, e.tableList.some((s) => s.orderId === n.orderId) || e.tableList.push(n);
      });
    } catch (l) {
      console.log(l);
    }
  };
  _(() => e.tableList.length, (t) => {
    t > 0 ? b.value = "60%" : b.value = "50%";
  });
  const E = () => {
    w(d);
  }, S = async () => {
    e.orderIds.length = 0, f.value = [], d.projectName = "", e.tableList = [], D(e.supplierId) || await U();
  }, P = async (t) => {
    E(), D(e.orderIds) || await B();
  };
  return _(() => e.orderIds, (t, l) => {
    if ((l == null ? void 0 : l.length) > (t == null ? void 0 : t.length)) {
      const p = l.filter((c) => !t.includes(c))[0], r = e.tableList.findIndex((c) => c.orderId == p);
      r !== -1 && e.tableList.splice(r, 1);
    }
    t != null && t.length || (e.tableList = []);
  }), (t, l) => {
    const p = T, r = z("common-select-v2"), c = $, n = F("ellipsis");
    return h(), g("div", te, [u(W, { "header-title": "基本信息" }), o(d) ? (h(), v(Y, { key: 0, column: 2, "form-data": o(e), "form-rules": o(G), "table-list": L.value }, { applyDate: m(({ item: a }) => [u(p, { modelValue: o(e)[a], "onUpdate:modelValue": (s) => o(e)[a] = s, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applicantId: m(({ item: a }) => [u(X, { modelValue: o(e)[a], "onUpdate:modelValue": (s) => o(e)[a] = s, clearable: false, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: m(({ item: a }) => [u(r, { modelValue: o(e)[a], "onUpdate:modelValue": (s) => o(e)[a] = s, options: o(j), clearable: "", filterable: "", placeholder: "请输入或选择供应商", type: "other", onChange: S }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderIds: m(({ item: a }) => [u(r, { modelValue: o(e)[a], "onUpdate:modelValue": (s) => o(e)[a] = s, disabled: !o(f).length, options: o(f), clearable: "", filterable: "", multiple: "", placeholder: "请输入或选择采购合同号", type: "other", onChange: P }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), projectName: m(({ val: a, label: s }) => [a ? H((h(), g("div", ae, [q(O(a.split("/").filter(Boolean).map((V) => `【${V}】`).join(" ")), 1)])), [[n]]) : (h(), v(c, { key: 1, placeholder: s, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])) : R("", true)]);
  };
} };
export {
  de as default
};
