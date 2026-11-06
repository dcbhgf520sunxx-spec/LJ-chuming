import { useStore as K } from "vuex";
import { computed as b } from "vue";
import { inject as X } from "vue";
import { ref as C } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as c } from "vue";
import { createSlots as Y } from "vue";
import { withCtx as r } from "vue";
import { unref as e } from "vue";
import { createBlock as v } from "vue";
import { createElementVNode as U } from "vue";
import { createCommentVNode as N } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as S } from "vue";
import { renderList as k } from "vue";
import { ElTag as ee } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElOption as te } from "element-plus";
import { ElSelect as le } from "element-plus";
import { ElInput as oe } from "element-plus";
import { c as ne, d as re } from "../../../../../../modules/data-499610b6.js";
import { d as se } from "../../../../../../modules/payment-settlement-e8e799d8.js";
import { _ as de, uD as ce, e3 as ue, i as m, dp as ie, cy as D, bV as L, e5 as pe, e6 as h, bv as me, iW as _e, ec as fe, kZ as ge } from "../../../../../../shared/runtime.js";
import { u as be } from "../../../../../../modules/hook-75706e02.js";
const ve = { class: "header-container" }, he = ["innerHTML"], Ie = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, je = { style: { position: "relative" } }, ye = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, Ve = { __name: "header", setup(Be) {
  const E = K(), w = b(() => E.getters.user.id), A = X("payment_data"), { formData: a, projectInfo: s } = A, P = b(() => ce(ue(re, s)));
  a.applyUserId = w.value;
  const { projectAllInfoData: T, projectList: I, supplierList: f, contractNoList: i, getProjectList: F, getSupplierList: H, getContractNo: R } = be({ form: a }), $ = async () => {
    try {
      let o = await se({ projectId: a.projectId, orderId: a.orderId });
      M.value = o.contractSignBodyRatioAmount || 0, g.value = o.projectManagerRatioAmount || 0, o && o.basicClass && (o.basicClass = me.getBits(_e.ENUM, o.basicClass, "L").join(" | ")), o = fe([o]), Object.assign(s, ...o);
    } catch (o) {
      console.log(o);
    }
  }, j = ge(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], a), O = async () => {
    j("projectManagerId", () => {
      h(s), I.value = [], f.value = [], i.value = [];
    }), m(a.projectManagerId) && await F();
  }, u = C(), z = async (o) => {
    u.value = T.value.find((_) => _.project.id === o), j("projectId", () => {
      h(s), f.value = [], i.value = [];
    }), m(a.projectId) && await H();
  }, Q = b(() => {
    if (u.value) return `
    ${u.value.signeeName || ""} : ${u.value.signeeRatio || "0"}%
     &nbsp;&nbsp;|&nbsp;&nbsp;
     ${u.value.projectManagerName || ""} : ${u.value.projectManagerRatio || "0"}%
  `;
  }), W = async () => {
    j("supplierId", () => {
      h(s), i.value = [];
    }), m(a.supplierId) && await R();
  }, Z = async (o) => {
    const _ = i.value.find((y) => y.value === o);
    _ && (a.orderId = _.id), m(a.purchaseContractNumber) && await $(), o || h(s);
  }, M = C(), g = C(), q = b(() => s.projectAttribute === 3 ? false : m(g) && a.projectManagerId && s.contractSignBodyName);
  return (o, _) => {
    const y = ee, G = ae, V = te, B = le, J = oe;
    return d(), p("div", ve, [c(ie, { class: "customClass", "header-title": "基本信息" }, Y({ _: 2 }, [u.value ? { name: "subTitle", fn: r(() => [u.value.project.projectAttribute === 2 && e(s).contractSignBodyName ? (d(), v(y, { key: 0, class: "animate__animated animate__fadeIn animate__faster", size: "large", style: { "margin-bottom": "4px", "font-size": "14px" } }, { default: r(() => [U("span", { innerHTML: Q.value }, null, 8, he)]), _: 1 })) : N("", true)]), key: "0" } : void 0]), 1024), c(pe, { column: 2, "form-data": e(a), "form-rules": e(ne), "table-list": P.value, "label-width": "100px" }, { applyDate: r(({ item: l, blur: n }) => [c(G, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: n }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: r(({ item: l }) => [c(D, { modelValue: e(a)[l], "onUpdate:modelValue": (n) => e(a)[l] = n, clearable: false, filterable: "", placeholder: "选择申请人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectManagerId: r(({ item: l, blur: n }) => [c(D, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, clearable: false, filterable: "", placeholder: "请选择项目经理", onBlur: n, onChange: O }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), e(m)(g.value) && e(a).projectManagerId && e(s).contractSignBodyName ? (d(), p("span", Ie, " 剩余金额 : " + x(e(L)(g.value)), 1)) : N("", true)]), projectId: r(({ item: l, blur: n }) => [c(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(I).length, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: n, onChange: z }, { default: r(() => [(d(true), p(S, null, k(e(I), (t) => (d(), v(V, { key: t.id, label: t.serialNumber + "-" + t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: r(({ item: l, blur: n }) => [c(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(f).length, clearable: "", placeholder: "请选择供应商", onBlur: n, onChange: W }, { default: r(() => [(d(true), p(S, null, k(e(f), (t) => (d(), v(V, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: r(({ item: l, blur: n }) => [c(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(i).length, clearable: "", placeholder: "请选择采购合同号", onBlur: n, onChange: Z }, { default: r(() => [(d(true), p(S, null, k(e(i), (t) => (d(), v(V, { key: t.id, label: t.value, value: t.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), contractSignBodyName: r(({ val: l, label: n }) => [U("div", je, [c(J, { "model-value": l, placeholder: n, readonly: "" }, null, 8, ["model-value", "placeholder"]), q.value ? (d(), p("span", ye, " 剩余金额 : " + x(e(L)(M.value)), 1)) : N("", true)])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} }, xe = de(Ve, [["__scopeId", "data-v-03f4dd7c"]]);
export {
  xe as default
};
