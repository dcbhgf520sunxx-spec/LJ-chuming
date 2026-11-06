import { useStore as z } from "vuex";
import { computed as v } from "vue";
import { inject as G } from "vue";
import { ref as J } from "vue";
import { reactive as K } from "vue";
import { watch as X } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { Fragment as V } from "vue";
import { renderList as j } from "vue";
import { createBlock as y } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { ElOption as $ } from "element-plus";
import { ElSelect as ee } from "element-plus";
import { nextTick as ae } from "vue";
import { s as le, a as te } from "../../../../../../modules/data-499610b6.js";
import { c as oe, d as re } from "../../../../../../modules/payment-settlement-e8e799d8.js";
import { uD as se, e3 as ne, dp as ce, cy as w, e5 as de, i as C, b as ue, ec as B, bv as ie, iW as pe, e6 as L, kZ as me } from "../../../../../../shared/runtime.js";
import { u as be } from "../../../../../../modules/hook-75706e02.js";
const fe = { class: "header-container" }, ye = { __name: "header", setup(he, { expose: N }) {
  const D = z(), M = v(() => D.getters.user.id), P = G("settlement_data"), { formData: a, projectInfo: u, tableList: f, contractListInfo: U } = P, E = v(() => se(ne(te, u)));
  a.applyUserId = M;
  const { projectList: k, supplierList: i, contractNoList: p, getProjectList: x, getSupplierList: A, getContractNo: F } = be({ form: a }), S = J([]), O = v(() => S.value.reduce((e, d) => (d.invoiceAmount && (e += d.invoiceAmount), e), 0)), h = K({ sum: 0, total: 0 });
  X(() => O.value, (e) => {
    h.sum = e;
  });
  const H = async () => {
    try {
      let e = await oe(a);
      S.value = [...e.list.content], h.total = e.list.totalElements, a.orderId = e.orderId, await ae();
      const d = B(e.list.content);
      f.push(...d), delete e.list, e = B([e]), Object.assign(u, ...e), Object.assign(U, ...e);
    } catch (e) {
      console.log("获取项目信息失败:getProjectInfoSettle", e);
    }
  }, T = async () => {
    try {
      let e = await re({ projectId: a.projectId, orderId: a.orderId });
      e != null && e.basicClass && (e.basicClass = ie.getBits(pe.ENUM, e.basicClass, "L").join(" | ")), e = B([e]), Object.assign(u, ...e);
    } catch (e) {
      console.log(e);
    }
  }, m = () => {
    f.splice(0, f.length), L(U), L(u), a.settlementAmount = null;
  }, g = me(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], a), Q = async () => {
    g("projectManagerId", () => {
      m(), k.value = [], i.value = [], p.value = [];
    }), C(a.projectManagerId) && await x();
  }, R = async () => {
    g("projectId", () => {
      m(), i.value = [], p.value = [];
    }), C(a.projectId) && await A();
  }, W = async () => {
    g("supplierId", () => {
      m(), p.value = [];
    }), C(a.supplierId) && await F({ boolSettleUse: true });
  }, Z = async () => {
    m(), ue(a.purchaseContractNumber) || (await H(), await T());
  };
  return N({ invoiceInfo: h }), (e, d) => {
    const q = Y, I = $, _ = ee;
    return c(), b("div", fe, [n(ce, { "header-title": "基本信息" }), n(de, { column: 2, "form-data": t(a), "form-rules": t(le), "table-list": E.value }, { applyDate: s(({ item: o, blur: r }) => [n(q, { modelValue: t(a)[o], "onUpdate:modelValue": (l) => t(a)[o] = l, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: r }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: s(({ item: o }) => [n(w, { modelValue: t(a)[o], "onUpdate:modelValue": (r) => t(a)[o] = r, clearable: false, filterable: "", placeholder: "选择申请人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectManagerId: s(({ item: o, blur: r }) => [n(w, { modelValue: t(a)[o], "onUpdate:modelValue": (l) => t(a)[o] = l, clearable: false, filterable: "", placeholder: "请选择项目经理", onBlur: r, onChange: Q }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: s(({ item: o, blur: r }) => [n(_, { modelValue: t(a)[o], "onUpdate:modelValue": (l) => t(a)[o] = l, disabled: !t(a).projectManagerId, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: r, onChange: R }, { default: s(() => [(c(true), b(V, null, j(t(k), (l) => (c(), y(I, { key: l.id, label: l.serialNumber + "-" + l.name, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: s(({ item: o, blur: r }) => [n(_, { modelValue: t(a)[o], "onUpdate:modelValue": (l) => t(a)[o] = l, disabled: !t(i).length, clearable: "", placeholder: "请选择供应商", onBlur: r, onChange: W }, { default: s(() => [(c(true), b(V, null, j(t(i), (l) => (c(), y(I, { key: l.id, label: l.value, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: s(({ item: o, blur: r }) => [n(_, { modelValue: t(a)[o], "onUpdate:modelValue": (l) => t(a)[o] = l, disabled: !t(a).supplierId, clearable: "", placeholder: "请选择采购合同号", onBlur: r, onChange: Z }, { default: s(() => [(c(true), b(V, null, j(t(p), (l) => (c(), y(I, { key: l.id, label: l.value, value: l.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ye as default
};
