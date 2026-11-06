import { inject as V } from "vue";
import { useStore as q } from "vuex";
import { computed as D } from "vue";
import { watch as b } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as u } from "vue";
import { withCtx as d } from "vue";
import { unref as l } from "vue";
import { Fragment as x } from "vue";
import { renderList as C } from "vue";
import { createBlock as v } from "vue";
import { withDirectives as Q } from "vue";
import { createTextVNode as $ } from "vue";
import { toDisplayString as G } from "vue";
import { ElDatePicker as J } from "element-plus";
import { ElOption as K } from "element-plus";
import { ElSelect as M } from "element-plus";
import { ElInput as T } from "element-plus";
import { p as W, a as X } from "../../../../../../../modules/data-2d709dfa.js";
import { g as Y } from "../../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as Z, e3 as ee, cy as ae, b as S, ec as te, e6 as le } from "../../../../../../../shared/runtime.js";
import { u as oe } from "../../../../../../../modules/hook-467b8301.js";
const re = { class: "header-container" }, se = { key: 0, class: "notSlotValue truncate" }, me = { __name: "header", setup(ne) {
  const y = V("size"), E = q(), L = D(() => E.getters.user.id), j = V("payment_data"), { formData: e, projectInfo: f, paymentTypelist: p } = j, U = D(() => Z(ee(X, f)));
  b(() => L.value, (o) => {
    e.applicantId = o;
  }, { immediate: true });
  const { supplierList: B, contractNoList: I, getSupplierList: w, getPurchaseContractNumber: N } = oe({ form: e });
  w();
  const P = async () => {
    var o;
    try {
      const { invoiceDto: r, projectName: m, paymentDto: i } = await Y({ orderIds: e.orderIds });
      Object.assign(f, r[0], { projectName: m }), (o = p == null ? void 0 : p.value) != null && o.length && (p.value = []), p.value = i, e.paymentBank = null, e.paymentBankAccount = null, te(r).forEach((s) => {
        s.moneyAmount = "", s.supplierPaymentId = s.orderId, e.tableList.some((h) => h.orderId === s.orderId) || e.tableList.push(s);
      });
    } catch (r) {
      console.log(r);
    }
  };
  b(() => e.tableList.length, (o) => {
    o > 0 ? y.value = "60%" : y.value = "50%";
  });
  const A = () => {
    le(f);
  }, F = async () => {
    S(e.supplierId) || await N();
  }, z = async (o) => {
    A(), S(e.orderIds) || await P();
  };
  return b(() => e.orderIds, (o, r) => {
    if (r.length > o.length) {
      const m = r.filter((n) => !o.includes(n))[0], i = e.tableList.findIndex((n) => String(n.orderId) === m);
      i !== -1 && e.tableList.splice(i, 1);
    }
  }), (o, r) => {
    const m = k("table-header"), i = J, n = K, s = M, g = T, h = k("descriptions-list"), O = H("ellipsis");
    return c(), _("div", re, [u(m, { "header-title": "基本信息" }), u(h, { column: 2, "form-data": l(e), "form-rules": l(W), "table-list": U.value }, { applyDate: d(({ item: t }) => [u(i, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applicantId: d(({ item: t }) => [u(ae, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, clearable: false, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: d(({ item: t }) => [u(s, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, clearable: "", filterable: "", placeholder: "请输入或选择供应商", onChange: F }, { default: d(() => [(c(true), _(x, null, C(l(B), (a) => (c(), v(n, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), orderIds: d(({ item: t }) => [u(s, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, disabled: !l(I).length, clearable: "", filterable: "", multiple: "", placeholder: "请输入或选择采购合同号", onChange: z }, { default: d(() => [(c(true), _(x, null, C(l(I), (a) => (c(), v(n, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), projectName: d(({ val: t, label: a }) => [t ? Q((c(), _("div", se, [$(G(t.split("/").filter(Boolean).map((R) => `【${R}】`).join(" ")), 1)])), [[O]]) : (c(), v(g, { key: 1, placeholder: a, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  me as default
};
