import { inject as P } from "vue";
import { computed as T } from "vue";
import { reactive as H } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as n } from "vue";
import { withCtx as r } from "vue";
import { unref as l } from "vue";
import { Fragment as V } from "vue";
import { renderList as j } from "vue";
import { createBlock as y } from "vue";
import { ElOption as O } from "element-plus";
import { ElSelect as Q } from "element-plus";
import { ElInput as R } from "element-plus";
import { e3 as Z, dp as q, cy as z, jb as G, bV as B, e5 as J, i as h, ec as K, e6 as W, kZ as X } from "../../../../../../shared/runtime.js";
import { h as Y, a as $ } from "../../../../../../modules/invoice-entry-8680260e.js";
import { u as ee } from "../../../../../../modules/info-d30309fa.js";
import { a as ae } from "../../../../../../modules/index-69cea220.js";
const le = { class: "header-container" }, ce = { __name: "header", setup(oe, { expose: L }) {
  const N = P("invoice_data"), { formData: e, tableList: b, projectInfo: c } = N, S = T(() => Z($, c)), { projectList: _, getProjectList: k, supplierList: p, getSupplierList: U, contractNoList: d, getContractNo: M } = ee({ form: e }), w = H({ total: 0 }), x = async () => {
    try {
      const u = await ae(e.purchaseContractNumber), C = K(u.dto);
      b.push(...C), e.orderId = e.purchaseContractNumber, Object.assign(c, u), console.log(c);
    } catch (u) {
      console.log("发票入账获取采购信息失败", u);
    }
  }, i = () => {
    b.splice(0, b.length), W(c), e.orderId = null, e.supplierPaymentId = null;
  }, f = X(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], e), D = async () => {
    f("projectManagerId", () => {
      _.value = [], p.value = [], d.value = [], i();
    }), h(e.projectManagerId) && await k();
  }, E = async () => {
    f("projectId", () => {
      p.value = [], d.value = [], i();
    }), h(e.projectId) && await U();
  }, A = async () => {
    f("supplierId", () => {
      d.value = [], i();
    }), h(e.supplierId) && await M();
  }, F = async () => {
    i(), h(e.purchaseContractNumber) && await x();
  };
  return L({ recordInfo: w }), (u, C) => {
    const g = O, v = Q, I = R;
    return s(), m("div", le, [n(q, { "header-title": "基本信息" }), n(J, { column: 2, "form-data": l(e), "form-rules": l(Y), "table-list": S.value }, { projectManagerId: r(({ item: o, blur: t }) => [n(z, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, placeholder: "请选择项目经理", onBlur: t, onChange: D }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: r(({ item: o, blur: t }) => [n(v, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(_).length, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: t, onChange: E }, { default: r(() => [(s(true), m(V, null, j(l(_), (a) => (s(), y(g, { key: a.id, label: a.serialNumber + "-" + a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: r(({ item: o, blur: t }) => [n(v, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(p).length, clearable: "", placeholder: "请选择供应商", onBlur: t, onChange: A }, { default: r(() => [(s(true), m(V, null, j(l(p), (a) => (s(), y(g, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: r(({ item: o, blur: t }) => [n(v, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(d).length, clearable: "", placeholder: "请选择采购合同号", onBlur: t, onChange: F }, { default: r(() => [(s(true), m(V, null, j(l(d), (a) => (s(), y(g, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), subcontractClassId: r(({ val: o, label: t }) => [n(I, { "model-value": l(G).VL[o], placeholder: t, readonly: "" }, null, 8, ["model-value", "placeholder"])]), amount: r(({ val: o, label: t }) => [n(I, { "model-value": l(B)(o), placeholder: t, readonly: "" }, null, 8, ["model-value", "placeholder"])]), settlementAmount: r(({ val: o, label: t }) => [n(I, { "model-value": l(B)(o), placeholder: t, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ce as default
};
