import { inject as k } from "vue";
import { computed as F } from "vue";
import { reactive as Q } from "vue";
import { watch as v } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as m } from "vue";
import { withCtx as u } from "vue";
import { unref as l } from "vue";
import { Fragment as C } from "vue";
import { renderList as V } from "vue";
import { createBlock as j } from "vue";
import { ElOption as R } from "element-plus";
import { ElSelect as W } from "element-plus";
import { ElInput as q } from "element-plus";
import { e3 as z, i as d, dp as G, cy as J, uC as U, e5 as K, b, ec as x, bv as X, iW as Y } from "../../../../../../shared/runtime.js";
import { h as Z, a as $ } from "../../../../../../modules/invoice-entry-494c5781.js";
import { g as ee } from "../../../../../../modules/invoice-entry-97d1bf05.js";
import { u as ae } from "../../../../../../modules/info-429dcef2.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
const le = { class: "header-container" }, ie = { __name: "header", setup(te, { expose: A }) {
  const D = k("invoice_data"), { formData: e, tableList: M, projectInfo: _ } = D, N = F(() => z($, _)), y = Q({ total: 0 }), S = async () => {
    try {
      let t = await ee(e);
      const i = ["invoiceAmount", "invoiceDate", "paymentAmount", "paymentDate"];
      y.total = t.list.totalElements;
      const r = x(t.list.content);
      r.forEach((n) => {
        Object.keys(n).forEach((c) => {
          i.includes(c) && !n[c] && n[c] !== "-" && (n[c] = "-");
        });
      }), M.push(...r), delete t.list, t = x([t]), t[0].basicClass = X.getBits(Y.ENUM, t[0].basicClass, "L").join(" | "), Object.assign(_, ...t);
    } catch (t) {
      console.error("获取项目信息失败:getContractInfo", t);
    }
  }, B = async () => {
    d(e.projectManagerId) && await P();
  }, w = async () => {
    d(e.projectId) && await H();
  }, E = async () => {
    d(e.supplierId) && await T();
  }, L = async () => {
    d(e.orderId) && await S();
  }, { item_data: O } = k("common"), { projectList: I, supplierList: g, contractNoList: f, getProjectList: P, getSupplierList: H, getContractNo: T } = ae({ form: e });
  return v(() => O.value, (t) => {
    if (d(t)) {
      const { projectManager: i, projects: r, supplierId: n, id: c } = t;
      e.projectManagerId = i.id, e.projectId = r[0].id, e.supplierId = n + "", e.orderId = c + "";
    }
  }, { immediate: true, deep: true }), v(() => f.value.length, async (t) => {
    if (t) {
      const i = f.value.findIndex((r) => r.id === e.orderId);
      i !== -1 && (e.purchaseContractNumber = f.value[i].value);
    }
  }), v(e, async () => {
    d(e.projectManagerId) && b(I.value) && await B(), d(e.projectId) && b(g.value) && await w(), d(e.supplierId) && b(f.value) && await E(), d(e.orderId) && b(_.basicClass) && await L();
  }, { deep: true, immediate: true }), A({ recordInfo: y }), (t, i) => {
    const r = R, n = W, c = q;
    return p(), h("div", le, [m(G, { "header-title": "基本信息" }), m(K, { column: 2, "form-data": l(e), "form-rules": l(Z), "table-list": N.value }, { projectManagerId: u(({ item: o, blur: s }) => [m(J, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, clearable: false, filterable: "", placeholder: "请选择项目经理", onBlur: s, onChange: B }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: u(({ item: o, blur: s }) => [m(n, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(I).length, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: s, onChange: w }, { default: u(() => [(p(true), h(C, null, V(l(I), (a) => (p(), j(r, { key: a.id, label: a.serialNumber + "-" + a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: u(({ item: o, blur: s }) => [m(n, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(g).length, clearable: "", placeholder: "请选择供应商", onBlur: s, onChange: E }, { default: u(() => [(p(true), h(C, null, V(l(g), (a) => (p(), j(r, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), orderId: u(({ item: o, blur: s }) => [m(n, { modelValue: l(e)[o], "onUpdate:modelValue": (a) => l(e)[o] = a, disabled: !l(f).length, clearable: "", placeholder: "请选择采购合同号", onBlur: s, onChange: L }, { default: u(() => [(p(true), h(C, null, V(l(f), (a) => (p(), j(r, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), basicClass: u(({ val: o, label: s }) => [m(c, { "model-value": l(U).V[o] ? l(U).V[o].L : o, placeholder: s, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ie as default
};
