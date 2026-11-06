import { useStore as W } from "vuex";
import { computed as h } from "vue";
import { inject as X } from "vue";
import { ref as C } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as d } from "vue";
import { createSlots as Y } from "vue";
import { withCtx as r } from "vue";
import { unref as e } from "vue";
import { createBlock as v } from "vue";
import { createElementVNode as U } from "vue";
import { createCommentVNode as S } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as k } from "vue";
import { renderList as N } from "vue";
import { ElTag as ee } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElOption as te } from "element-plus";
import { ElSelect as le } from "element-plus";
import { ElInput as oe } from "element-plus";
import { p as ne, a as re } from "../../../../../../../modules/data-39ef738e.js";
import { _ as se, uD as ce, e3 as de, i as m, dp as ue, cy as D, bV as L, e5 as pe, e6 as b, jb as ie, ec as me, kZ as _e } from "../../../../../../../shared/runtime.js";
import { h as fe } from "../../../../../../../modules/index-69cea220.js";
import { u as ge } from "../../../../../../../modules/info-d30309fa.js";
const he = { class: "header-container" }, ve = ["innerHTML"], be = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, ye = { style: { position: "relative" } }, Ie = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, je = { __name: "header", setup(Ve) {
  const w = W(), A = h(() => w.getters.user.id), E = X("payment_data"), { formData: a, projectInfo: s } = E, T = h(() => ce(de(re, s)));
  a.applyUserId = A.value;
  const { projectAllInfoData: P, projectList: y, supplierList: f, contractNoList: p, getProjectList: F, getSupplierList: H, getContractNo: R } = ge({ form: a }), $ = async () => {
    try {
      let o = await fe(a.orderId);
      M.value = o.contractSignBodyRatioAmount || 0, g.value = o.projectManagerRatioAmount || 0, o && o.subcontractClassId && (o.subcontractClassId = ie.VL[o.subcontractClassId]), o = me([o]), Object.assign(s, ...o);
    } catch (o) {
      console.log(o);
    }
  }, I = _e(["projectManagerId", "projectId", "supplierId", "purchaseContractNumber"], a), z = async () => {
    I("projectManagerId", () => {
      b(s), y.value = [], f.value = [], p.value = [];
    }), m(a.projectManagerId) && await F();
  }, u = C(), O = async (o) => {
    u.value = P.value.find((_) => _.project.id === o), I("projectId", () => {
      b(s), f.value = [], p.value = [];
    }), m(a.projectId) && await H();
  }, Q = h(() => {
    if (u.value) return `
    ${u.value.signeeName || ""} : ${u.value.signeeRatio || "0"}%
     &nbsp;&nbsp;|&nbsp;&nbsp;
     ${u.value.projectManagerName || ""} : ${u.value.projectManagerRatio || "0"}%
  `;
  }), Z = async () => {
    I("supplierId", () => {
      b(s), p.value = [];
    }), m(a.supplierId) && await R();
  }, q = async (o) => {
    const _ = p.value.find((j) => j.value === o);
    _ && (a.orderId = _.id), m(a.purchaseContractNumber) && await $(), o || b(s);
  }, M = C(), g = C(), G = h(() => s.projectAttribute === 3 ? false : m(g) && a.projectManagerId && s.contractSignBodyName);
  return (o, _) => {
    const j = ee, J = ae, V = te, B = le, K = oe;
    return c(), i("div", he, [d(ue, { class: "customClass", "header-title": "基本信息" }, Y({ _: 2 }, [u.value ? { name: "subTitle", fn: r(() => [u.value.project.projectAttribute === 2 && e(s).contractSignBodyName ? (c(), v(j, { key: 0, class: "animate__animated animate__fadeIn animate__faster", size: "large", style: { "margin-bottom": "4px", "font-size": "14px" } }, { default: r(() => [U("span", { innerHTML: Q.value }, null, 8, ve)]), _: 1 })) : S("", true)]), key: "0" } : void 0]), 1024), d(pe, { column: 2, "form-data": e(a), "form-rules": e(ne), "table-list": T.value, "label-width": "100px" }, { applyDate: r(({ item: l, blur: n }) => [d(J, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: n }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: r(({ item: l }) => [d(D, { modelValue: e(a)[l], "onUpdate:modelValue": (n) => e(a)[l] = n, placeholder: "选择申请人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectManagerId: r(({ item: l, blur: n }) => [d(D, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, placeholder: "请选择项目经理", onBlur: n, onChange: z }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), e(m)(g.value) && e(a).projectManagerId && e(s).contractSignBodyName ? (c(), i("span", be, " 剩余金额 : " + x(e(L)(g.value)), 1)) : S("", true)]), projectId: r(({ item: l, blur: n }) => [d(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(y).length, clearable: "", filterable: "", placeholder: "请输入或选择项目", onBlur: n, onChange: O }, { default: r(() => [(c(true), i(k, null, N(e(y), (t) => (c(), v(V, { key: t.id, label: t.serialNumber + "-" + t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), supplierId: r(({ item: l, blur: n }) => [d(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(f).length, clearable: "", placeholder: "请选择供应商", onBlur: n, onChange: Z }, { default: r(() => [(c(true), i(k, null, N(e(f), (t) => (c(), v(V, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), purchaseContractNumber: r(({ item: l, blur: n }) => [d(B, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !e(p).length, clearable: "", placeholder: "请选择采购合同号", onBlur: n, onChange: q }, { default: r(() => [(c(true), i(k, null, N(e(p), (t) => (c(), v(V, { key: t.id, label: t.value, value: t.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), contractSignBodyName: r(({ val: l, label: n }) => [U("div", ye, [d(K, { "model-value": l, placeholder: n, readonly: "" }, null, 8, ["model-value", "placeholder"]), G.value ? (c(), i("span", Ie, " 剩余金额 : " + x(e(L)(M.value)), 1)) : S("", true)])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} }, Ue = se(je, [["__scopeId", "data-v-214cff7e"]]);
export {
  Ue as default
};
