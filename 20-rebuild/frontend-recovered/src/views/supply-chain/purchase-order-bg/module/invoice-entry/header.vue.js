import { inject as P } from "vue";
import { computed as H } from "vue";
import { reactive as T } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as d } from "vue";
import { withCtx as s } from "vue";
import { unref as l } from "vue";
import { Fragment as C } from "vue";
import { renderList as v } from "vue";
import { createBlock as y } from "vue";
import { ElOption as Q } from "element-plus";
import { ElSelect as R } from "element-plus";
import { ElInput as W } from "element-plus";
import { e3 as Z, dp as q, cy as z, uC as E, e5 as G, i as b, ec as L, bv as J, iW as K, e6 as X, kZ as Y } from "../../../../../shared/runtime.js";
import { h as $, a as ee } from "../../../../../modules/invoice-entry-bd0669f8.js";
import { g as ae } from "../../../../../modules/invoice-entry-97d1bf05.js";
import { u as le } from "../../../../../modules/hook-75706e02.js";
import "../../../../../modules/payment-settlement-e8e799d8.js";
const te = { class: "header-container" }, ie = { __name: "header", setup(oe, { expose: k }) {
  const N = P("invoice_data"), { formData: a, tableList: g, projectInfo: _ } = N, U = H(() => Z(ee, _)), j = T({ total: 0 }), { projectList: I, supplierList: m, contractNoList: i, getProjectList: M, getSupplierList: S, getContractNo: D } = le({ form: a }), w = async () => {
    try {
      let o = await ae(a);
      const B = ["invoiceAmount", "invoiceDate", "paymentAmount", "paymentDate"];
      a.orderId = o.orderId, j.total = o.list.totalElements;
      const u = L(o.list.content);
      u.forEach((n) => {
        Object.keys(n).forEach((p) => {
          B.includes(p) && !n[p] && n[p] !== "-" && (n[p] = "-");
        });
      }), g.push(...u), delete o.list, o = L([o]), o[0].basicClass = J.getBits(K.ENUM, o[0].basicClass, "L").join(" | "), console.log(o), Object.assign(_, ...o);
    } catch (o) {
      console.error("获取项目信息失败:getContractInfo", o);
    }
  }, h = () => {
    g.splice(0, g.length), X(_), a.orderId = null, a.supplierPaymentId = null;
  }, V = Y(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], a), x = async () => {
    V("projectManagerId", () => {
      I.value = [], m.value = [], i.value = [], h();
    }), b(a.projectManagerId) && await M();
  }, A = async () => {
    V("projectId", () => {
      m.value = [], i.value = [], h();
    }), b(a.projectId) && await S();
  }, F = async () => {
    V("supplierId", () => {
      i.value = [], h();
    }), b(a.supplierId) && await D();
  }, O = async () => {
    h(), b(a.purchaseContractNumber) && await w();
  };
  return k({ recordInfo: j }), (o, B) => {
    const u = Q, n = R, p = W;
    return c(), f("div", te, [d(q, { "header-title": "基本信息" }), d(G, { column: 2, "form-data": l(a), "form-rules": l($), "table-list": U.value }, { projectManagerId: s(({ item: t, blur: r }) => [d(z, { modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, clearable: false, filterable: "", placeholder: "请选择项目经理", onBlur: r, onChange: x }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: s(({ item: t, blur: r }) => [d(n, { modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, disabled: !l(I).length, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: r, onChange: A }, { default: s(() => [(c(true), f(C, null, v(l(I), (e) => (c(), y(u, { key: e.id, label: e.serialNumber + "-" + e.name, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: s(({ item: t, blur: r }) => [d(n, { modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, disabled: !l(m).length, clearable: "", placeholder: "请选择供应商", onBlur: r, onChange: F }, { default: s(() => [(c(true), f(C, null, v(l(m), (e) => (c(), y(u, { key: e.id, label: e.value, value: e.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: s(({ item: t, blur: r }) => [d(n, { modelValue: l(a)[t], "onUpdate:modelValue": (e) => l(a)[t] = e, disabled: !l(i).length, clearable: "", placeholder: "请选择采购合同号", onBlur: r, onChange: O }, { default: s(() => [(c(true), f(C, null, v(l(i), (e) => (c(), y(u, { key: e.id, label: e.value, value: e.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), basicClass: s(({ val: t, label: r }) => [d(p, { "model-value": l(E).V[t] ? l(E).V[t].L : t, placeholder: r, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ie as default
};
