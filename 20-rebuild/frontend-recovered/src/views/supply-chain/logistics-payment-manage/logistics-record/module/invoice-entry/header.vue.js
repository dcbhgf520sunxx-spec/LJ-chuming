import { inject as Q } from "vue";
import { ref as _ } from "vue";
import { computed as R } from "vue";
import { reactive as T } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as u } from "vue";
import { withCtx as n } from "vue";
import { unref as r } from "vue";
import { Fragment as V } from "vue";
import { renderList as y } from "vue";
import { createBlock as C } from "vue";
import { createTextVNode as m } from "vue";
import { ElCascader as q } from "element-plus";
import { ElOption as z } from "element-plus";
import { ElSelect as G } from "element-plus";
import { e3 as H, e5 as J, b as g, e2 as L, ec as M, e6 as K } from "../../../../../../shared/runtime.js";
import { h as W, a as X } from "../../../../../../modules/invoice-entry-81d589e9.js";
import { u as Y } from "../../../../../../modules/useSelect-654af12a.js";
import { g as Z, a as $, b as ee } from "../../../../../../modules/payment-settlement-e8e799d8.js";
import { g as ae } from "../../../../../../modules/invoice-entry-97d1bf05.js";
const te = { class: "header-container" }, ue = { __name: "header", setup(le, { expose: N }) {
  const k = Q("invoice_data"), { formData: e, tableList: I, projectInfo: f } = k, b = _([]), j = _([]), h = _([]), { projectLeaderList: U } = Y(), S = R(() => H(X, f)), x = async () => {
    try {
      const a = await Z(e.projectManagerId);
      a ? b.value = a : (L("warning", "该项目经理下暂无项目"), b.value = []);
    } catch (a) {
      console.log(a);
    }
  }, E = async () => {
    if (e.projectManagerId && e.projectId) try {
      const a = await $({ projectId: e.projectId, projectManagerId: e.projectManagerId });
      if (Object.keys(a).length) {
        const l = Object.entries(a).map(([d, s]) => ({ id: d, value: s }));
        j.value = l;
      } else L("warning", "该项目下暂无供应商"), j.value = [];
    } catch (a) {
      console.log(a);
    }
  }, w = T({ total: 0 }), O = async () => {
    try {
      let a = await ae(e);
      e.orderId = a.orderId, w.total = a.list.totalElements;
      const l = M(a.list.content);
      I.push(...l), delete a.list, a = M([a]), Object.assign(f, ...a);
    } catch (a) {
      console.log(a);
    }
  }, P = async () => {
    if (e.projectManagerId && e.projectId && e.supplierId) try {
      const a = await ee({ projectId: e.projectId, projectManagerId: e.projectManagerId, supplierId: e.supplierId });
      if (Object.keys(a).length) {
        const l = Object.entries(a).map(([d, s]) => ({ id: d, value: s }));
        h.value = l;
      } else L("warning", "该项目下暂无合同号"), h.value = [];
    } catch (a) {
      console.log(a);
    }
  }, p = () => {
    I.splice(0, I.length), K(f), e.orderId = null, e.supplierPaymentId = null;
  }, A = () => {
    e.projectId = null, e.supplierId = null, e.purchaseContractNumber = null, p(), g(e.projectManagerId) || x();
  }, B = () => {
    e.supplierId = null, e.purchaseContractNumber = null, p(), g(e.projectId) || E();
  }, D = () => {
    e.purchaseContractNumber = null, p(), g(e.supplierId) || P();
  }, F = async (a) => {
    p(), g(e.purchaseContractNumber) || await O();
  };
  return N({ recordInfo: w }), (a, l) => {
    const d = q, s = z, v = G;
    return c(), i("div", te, [u(J, { column: 2, "table-list": S.value, "form-rules": r(W), "form-data": r(e) }, { projectManagerId: n(({ item: o }) => [u(d, { modelValue: r(e)[o], "onUpdate:modelValue": (t) => r(e)[o] = t, clearable: "", placeholder: "请选择项目经理", options: r(U), "show-all-levels": false, filterable: "", onChange: A, props: { value: "id", emitPath: false } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), projectId: n(({ item: o }) => [u(v, { modelValue: r(e)[o], "onUpdate:modelValue": (t) => r(e)[o] = t, clearable: "", placeholder: "请选择项目", disabled: !r(e).projectManagerId, onChange: B }, { default: n(() => [(c(true), i(V, null, y(b.value, (t) => (c(), C(s, { key: t.id, label: t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), supplierId: n(({ item: o }) => [u(v, { modelValue: r(e)[o], "onUpdate:modelValue": (t) => r(e)[o] = t, placeholder: "请选择供应商", clearable: "", disabled: !r(e).projectId, onChange: D }, { default: n(() => [(c(true), i(V, null, y(j.value, (t) => (c(), C(s, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), purchaseContractNumber: n(({ item: o }) => [u(v, { onChange: F, modelValue: r(e)[o], "onUpdate:modelValue": (t) => r(e)[o] = t, placeholder: "请选择采购合同号", clearable: "", disabled: !r(e).supplierId }, { default: n(() => [(c(true), i(V, null, y(h.value, (t) => (c(), C(s, { key: t.id, label: t.value, value: t.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), default: n(() => [l[0] || (l[0] = m(" // 项目经理 ")), l[1] || (l[1] = m(" // 项目 ")), l[2] || (l[2] = m(" // 供应商 ")), l[3] || (l[3] = m(" // 采购合同号 "))]), _: 1, __: [0, 1, 2, 3] }, 8, ["table-list", "form-rules", "form-data"])]);
  };
} };
export {
  ue as default
};
