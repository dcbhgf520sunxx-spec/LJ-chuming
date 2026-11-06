import { useStore as z } from "vuex";
import { computed as v } from "vue";
import { inject as G } from "vue";
import { ref as J } from "vue";
import { reactive as K } from "vue";
import { watch as W } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { unref as l } from "vue";
import { Fragment as V } from "vue";
import { renderList as I } from "vue";
import { createBlock as j } from "vue";
import { ElDatePicker as X } from "element-plus";
import { ElOption as Y } from "element-plus";
import { ElSelect as $ } from "element-plus";
import { ElInput as ee } from "element-plus";
import { s as ae, b as le } from "../../../../../../../modules/data-39ef738e.js";
import { uD as te, e3 as oe, dp as re, cy as N, jb as ne, bV as se, e5 as ue, i as y, b as de, ec as ce, e6 as L, kZ as pe } from "../../../../../../../shared/runtime.js";
import { u as ie } from "../../../../../../../modules/info-d30309fa.js";
import { a as me } from "../../../../../../../modules/index-69cea220.js";
const he = { class: "header-container" }, je = { __name: "header", setup(be, { expose: D }) {
  const w = z(), M = v(() => w.getters.user.id), x = G("settlement_data"), { formData: e, projectInfo: h, tableList: b, contractListInfo: B } = x, E = v(() => te(oe(le, h)));
  e.applyUserId = M;
  const { projectList: C, getProjectList: P, supplierList: p, getSupplierList: A, contractNoList: d, getContractNo: F } = ie({ form: e }), U = J([]), O = v(() => U.value.reduce((r, c) => (c.invoiceAmount && (r += c.invoiceAmount), r), 0)), S = K({ sum: 0, total: 0 });
  W(() => O.value, (r) => {
    S.sum = r;
  });
  const T = async () => {
    try {
      const r = await me(e.purchaseContractNumber), c = ce(r.dto);
      b.push(...c), U.value = r.dto, e.orderId = e.purchaseContractNumber, Object.assign(h, r), Object.assign(B, r);
    } catch (r) {
      console.log("获取项目信息失败:getProjectInfoSettle", r);
    }
  }, i = () => {
    b.splice(0, b.length), L(B), L(h), e.settlementAmount = null;
  }, _ = pe(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], e), H = async () => {
    _("projectManagerId", () => {
      i(), C.value = [], p.value = [], d.value = [];
    }), y(e.projectManagerId) && await P();
  }, Q = async () => {
    _("projectId", () => {
      i(), p.value = [], d.value = [];
    }), y(e.projectId) && await A();
  }, R = async () => {
    _("supplierId", () => {
      i(), d.value = [];
    }), y(e.supplierId) && await F();
  }, Z = async () => {
    i(), de(e.purchaseContractNumber) || await T();
  };
  return D({ invoiceInfo: S }), (r, c) => {
    const q = X, f = Y, g = $, k = ee;
    return u(), m("div", he, [s(re, { "header-title": "基本信息" }), s(ue, { column: 2, "form-data": l(e), "form-rules": l(ae), "table-list": E.value }, { applyDate: n(({ item: t, blur: o }) => [s(q, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: o }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: n(({ item: t, blur: o }) => [s(N, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, placeholder: "选择申请人", onBlur: o }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectManagerId: n(({ item: t, blur: o }) => [s(N, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, placeholder: "请选择项目经理", onBlur: o, onChange: H }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: n(({ item: t, blur: o }) => [s(g, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, disabled: !l(e).projectManagerId, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: o, onChange: Q }, { default: n(() => [(u(true), m(V, null, I(l(C), (a) => (u(), j(f, { key: a.id, label: a.serialNumber + "-" + a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: n(({ item: t, blur: o }) => [s(g, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, disabled: !l(p).length, clearable: "", placeholder: "请选择供应商", onBlur: o, onChange: R }, { default: n(() => [(u(true), m(V, null, I(l(p), (a) => (u(), j(f, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: n(({ item: t, blur: o }) => [s(g, { modelValue: l(e)[t], "onUpdate:modelValue": (a) => l(e)[t] = a, disabled: !l(d).length, clearable: "", placeholder: "请选择采购合同号", onBlur: o, onChange: Z }, { default: n(() => [(u(true), m(V, null, I(l(d), (a) => (u(), j(f, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), subcontractClassId: n(({ val: t, label: o }) => [s(k, { "model-value": l(ne).VL[t], placeholder: o, readonly: "" }, null, 8, ["model-value", "placeholder"])]), amount: n(({ val: t, label: o }) => [s(k, { "model-value": l(se)(t), placeholder: o, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  je as default
};
