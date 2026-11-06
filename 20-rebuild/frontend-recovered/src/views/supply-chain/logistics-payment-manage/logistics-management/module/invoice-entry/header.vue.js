import { inject as P } from "vue";
import { reactive as A } from "vue";
import { computed as F } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { unref as a } from "vue";
import { Fragment as g } from "vue";
import { renderList as I } from "vue";
import { createBlock as v } from "vue";
import { ElOption as M } from "element-plus";
import { ElSelect as O } from "element-plus";
import { ElInput as R } from "element-plus";
import { e3 as H, dp as T, uC as C, e5 as Q, b as V, bv as W, iW as Z, ec as y, kZ as q } from "../../../../../../shared/runtime.js";
import { h as z, a as G } from "../../../../../../modules/invoice-entry-a9ceb692.js";
import { g as J } from "../../../../../../modules/invoice-entry-d5222a89.js";
import { u as K } from "../../../../../../modules/hook-467b8301.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
const X = { class: "header-container" }, se = { __name: "header", setup(Y, { expose: B }) {
  const L = P("invoice_data"), { formData: l, tableList: d, projectInfo: i } = L, k = A({ total: 0 }), E = F(() => H(G, i)), { supplierList: S, contractNoList: u, getSupplierList: j, getPurchaseContractNumber: x } = K({ form: l });
  j();
  const N = async () => {
    try {
      const o = await J({ orderId: l.orderId });
      d.splice(0), o[0].basicClass = W.getBits(Z.ENUM, o[0].basicClass, "L").join(" | "), Object.assign(i, ...y([o[0]]));
      const h = y(o[0].dto);
      d.push(...h);
    } catch (o) {
      console.log("获取付款及发票记录失败" + o);
    }
  }, m = q(["supplierId", "orderId", "branchCompanyName", "amount", "basicClass", "settlementAmount"], i), _ = () => {
    d.splice(0);
  }, U = () => {
    m("supplierId", () => {
      _(), l.orderId = null, u.value = [];
    }), V(l.supplierId) || x();
  }, w = async (o) => {
    m("orderId", () => {
      _();
    }), V(l.orderId) || await N();
  };
  return B({ recordInfo: k }), (o, h) => {
    const b = M, f = O, D = R;
    return s(), p("div", X, [n(T, { "header-title": "基本信息" }), n(Q, { column: 2, "form-data": a(l), "form-rules": a(z), "table-list": E.value }, { supplierId: c(({ item: t, blur: r }) => [n(f, { modelValue: a(l)[t], "onUpdate:modelValue": (e) => a(l)[t] = e, clearable: "", filterable: "", placeholder: "请输入或选择供应商", onBlur: r, onChange: U }, { default: c(() => [(s(true), p(g, null, I(a(S), (e) => (s(), v(b, { key: e.id, label: e.value, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), orderId: c(({ item: t, blur: r }) => [n(f, { modelValue: a(l)[t], "onUpdate:modelValue": (e) => a(l)[t] = e, disabled: !a(u).length, clearable: "", filterable: "", placeholder: "请输入或选择采购合同号", onBlur: r, onChange: w }, { default: c(() => [(s(true), p(g, null, I(a(u), (e) => (s(), v(b, { key: e.id, label: e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), basicClass: c(({ val: t, label: r }) => [n(D, { "model-value": a(C).V[t] ? a(C).V[t].L : t, placeholder: r, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  se as default
};
