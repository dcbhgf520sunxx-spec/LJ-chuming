import { useStore as ee } from "vuex";
import { computed as I } from "vue";
import { inject as E } from "vue";
import { ref as h } from "vue";
import { watch as B } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as c } from "vue";
import { createSlots as ae } from "vue";
import { withCtx as s } from "vue";
import { unref as e } from "vue";
import { createBlock as j } from "vue";
import { createElementVNode as P } from "vue";
import { createCommentVNode as C } from "vue";
import { toDisplayString as T } from "vue";
import { Fragment as S } from "vue";
import { renderList as k } from "vue";
import { ElTag as te } from "element-plus";
import { ElDatePicker as le } from "element-plus";
import { ElOption as oe } from "element-plus";
import { ElSelect as ne } from "element-plus";
import { ElInput as re } from "element-plus";
import { p as se, a as de } from "../../../../../../modules/data-5413af16.js";
import { d as ue } from "../../../../../../modules/payment-settlement-e8e799d8.js";
import { _ as ce, uD as ie, e3 as pe, i as d, dp as me, cy as H, bV as R, e5 as _e, b as x, bv as fe, iW as ve, ec as be } from "../../../../../../shared/runtime.js";
import { u as ge } from "../../../../../../modules/info-429dcef2.js";
const Ie = { class: "header-container" }, he = ["innerHTML"], je = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, ye = { style: { position: "relative" } }, Ve = { key: 0, class: "custom-suffix animate__animated animate__fadeIn animate__faster" }, Be = { __name: "header", setup(Ce) {
  const O = ee(), $ = I(() => O.getters.user.id), z = E("payment_data"), { formData: t, projectInfo: m } = z, F = I(() => ie(pe(de, m)));
  t.applyUserId = $.value;
  const Q = async () => {
    try {
      let l = await ue({ projectId: t.projectId, orderId: t.orderId });
      D.value = l.contractSignBodyRatioAmount || 0, g.value = l.projectManagerRatioAmount || 0, l && l.basicClass && (l.basicClass = fe.getBits(ve.ENUM, l.basicClass, "L").join(" | ")), l = be([l]), Object.assign(m, ...l);
    } catch (l) {
      console.log(l);
    }
  }, M = async () => {
    d(n.value.projectManagerId) && await K();
  }, i = h(), N = async (l) => {
    i.value = J.value.find((p) => p.project.id === l), d(n.value.projectId) && await X();
  }, U = async () => {
    d(n.value.supplierId) && await Y();
  }, w = async (l) => {
    Object.assign(t, n.value), d(n.value.orderId) && await Q();
  }, W = I(() => {
    if (i.value) return `
    ${i.value.signeeName || ""} : ${i.value.signeeRatio || "0"}%
     &nbsp;&nbsp;|&nbsp;&nbsp;
     ${i.value.projectManagerName || ""} : ${i.value.projectManagerRatio || "0"}%
  `;
  }), D = h(), g = h(), q = I(() => m.projectAttribute === 3 ? false : d(g) && t.projectManagerId && m.contractSignBodyName), { item_data: G } = E("common"), n = h({}), { projectAllInfoData: J, projectList: L, supplierList: A, contractNoList: f, getProjectList: K, getSupplierList: X, getContractNo: Y } = ge({ form: n.value });
  return B(() => G.value, (l) => {
    if (d(l)) {
      const { projectManager: p, projects: v, supplierId: y, id: b } = l;
      n.value.projectManagerId = p.id, n.value.projectId = v[0].id, n.value.supplierId = y + "", n.value.orderId = b + "";
    }
  }, { immediate: true, deep: true }), B(() => f.value.length, (l) => {
    if (l && d(n.value.orderId)) {
      const p = f.value.findIndex((v) => v.id === n.value.orderId);
      p !== -1 && (t.purchaseContractNumber = f.value[p].value);
    }
  }), B(n, async () => {
    d(n.value.projectManagerId) && x(L.value) && await M(), d(n.value.projectId) && x(A.value) && await N(), d(n.value.supplierId) && x(f.value) && await U(), d(n.value.orderId) && await w();
  }, { immediate: true, deep: true }), (l, p) => {
    const v = te, y = le, b = oe, V = ne, Z = re;
    return u(), _("div", Ie, [c(me, { class: "customClass", "header-title": "基本信息" }, ae({ _: 2 }, [i.value ? { name: "subTitle", fn: s(() => [i.value.project.projectAttribute === 2 && e(m).contractSignBodyName ? (u(), j(v, { key: 0, class: "animate__animated animate__fadeIn animate__faster", size: "large", style: { "margin-bottom": "4px", "font-size": "14px" } }, { default: s(() => [P("span", { innerHTML: W.value }, null, 8, he)]), _: 1 })) : C("", true)]), key: "0" } : void 0]), 1024), c(_e, { column: 2, "form-data": e(t), "form-rules": e(se), "table-list": F.value, "label-width": "100px" }, { applyDate: s(({ item: o, blur: r }) => [c(y, { modelValue: e(t)[o], "onUpdate:modelValue": (a) => e(t)[o] = a, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: r }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: s(({ item: o }) => [c(H, { modelValue: e(t)[o], "onUpdate:modelValue": (r) => e(t)[o] = r, clearable: false, filterable: "", placeholder: "选择申请人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectManagerId: s(({ item: o, blur: r }) => [c(H, { modelValue: e(t)[o], "onUpdate:modelValue": (a) => e(t)[o] = a, clearable: false, disabled: "", filterable: "", placeholder: "请选择项目经理", onBlur: r, onChange: M }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"]), e(d)(g.value) && e(t).projectManagerId && e(m).contractSignBodyName ? (u(), _("span", je, " 剩余金额 : " + T(e(R)(g.value)), 1)) : C("", true)]), projectId: s(({ item: o, blur: r }) => [c(V, { modelValue: e(t)[o], "onUpdate:modelValue": (a) => e(t)[o] = a, clearable: "", disabled: "", filterable: "", placeholder: "请输入或选择项目", onBlur: r, onChange: N }, { default: s(() => [(u(true), _(S, null, k(e(L), (a) => (u(), j(b, { key: a.id, label: a.serialNumber + "-" + a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), supplierId: s(({ item: o, blur: r }) => [c(V, { modelValue: e(t)[o], "onUpdate:modelValue": (a) => e(t)[o] = a, clearable: "", disabled: "", placeholder: "请选择供应商", onBlur: r, onChange: U }, { default: s(() => [(u(true), _(S, null, k(e(A), (a) => (u(), j(b, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), orderId: s(({ item: o, blur: r }) => [c(V, { modelValue: e(t)[o], "onUpdate:modelValue": (a) => e(t)[o] = a, clearable: "", disabled: "", placeholder: "请选择采购合同号", onBlur: r, onChange: w }, { default: s(() => [(u(true), _(S, null, k(e(f), (a) => (u(), j(b, { key: a.id, label: a.value, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), contractSignBodyName: s(({ val: o, label: r }) => [P("div", ye, [c(Z, { "model-value": o, placeholder: r, readonly: "" }, null, 8, ["model-value", "placeholder"]), q.value ? (u(), _("span", Ve, " 剩余金额 : " + T(e(R)(D.value)), 1)) : C("", true)])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} }, we = ce(Be, [["__scopeId", "data-v-7fc190ca"]]);
export {
  we as default
};
