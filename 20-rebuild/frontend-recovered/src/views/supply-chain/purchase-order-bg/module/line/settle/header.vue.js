import { useStore as J } from "vuex";
import { computed as v } from "vue";
import { inject as x } from "vue";
import { ref as K } from "vue";
import { reactive as X } from "vue";
import { watch as I } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as d } from "vue";
import { withCtx as s } from "vue";
import { unref as o } from "vue";
import { Fragment as j } from "vue";
import { renderList as V } from "vue";
import { createBlock as y } from "vue";
import { nextTick as Y } from "vue";
import { ElDatePicker as Z } from "element-plus";
import { ElOption as $ } from "element-plus";
import { ElSelect as ee } from "element-plus";
import { c as ae, d as te } from "../../../../../../modules/data-5413af16.js";
import { c as le, d as oe } from "../../../../../../modules/payment-settlement-e8e799d8.js";
import { uD as re, e3 as ne, i as c, dp as se, cy as N, e5 as de, ec as B, b as h, bv as ce, iW as ue } from "../../../../../../shared/runtime.js";
import { u as ie } from "../../../../../../modules/info-429dcef2.js";
const pe = { class: "header-container" }, ve = { __name: "header", setup(me, { expose: P }) {
  const E = J(), A = v(() => E.getters.user.id), M = x("settlement_data"), { formData: e, projectInfo: _, tableList: O, contractListInfo: F } = M, H = v(() => re(ne(te, _)));
  e.applyUserId = A;
  const C = K([]), T = v(() => C.value.reduce((a, n) => (n.invoiceAmount && (a += n.invoiceAmount), a), 0)), g = X({ sum: 0, total: 0 });
  I(() => T.value, (a) => {
    g.sum = a;
  });
  const Q = async () => {
    try {
      let a = await le(e);
      C.value = [...a.list.content], g.total = a.list.totalElements, await Y();
      const n = B(a.list.content);
      O.push(...n), delete a.list, a = B([a]), Object.assign(_, ...a), Object.assign(F, ...a);
    } catch (a) {
      console.log("获取项目信息失败:getProjectInfoSettle", a);
    }
  }, R = async () => {
    try {
      let a = await oe({ projectId: e.projectId, orderId: e.orderId });
      a != null && a.basicClass && (a.basicClass = ce.getBits(ue.ENUM, a.basicClass, "L").join(" | ")), a = B([a]), Object.assign(_, ...a);
    } catch (a) {
      console.log(a);
    }
  }, U = async () => {
    c(e.projectManagerId) && await q();
  }, w = async () => {
    c(e.projectId) && await z();
  }, k = async () => {
    c(e.supplierId) && await G();
  }, L = async () => {
    h(e.orderId) || await R();
  }, { item_data: W } = x("common"), { projectList: S, supplierList: D, contractNoList: i, getProjectList: q, getSupplierList: z, getContractNo: G } = ie({ form: e });
  return I(() => i.value.length, async (a) => {
    if (a) {
      const n = i.value.findIndex((p) => p.id === e.orderId);
      n !== -1 && (e.purchaseContractNumber = i.value[n].value, await Q());
    }
  }), I(() => W.value, (a) => {
    if (c(a)) {
      const { projectManager: n, projects: p, supplierId: m, id: f } = a;
      e.projectManagerId = n.id, e.projectId = p[0].id, e.supplierId = m + "", e.orderId = f + "";
    }
  }, { immediate: true, deep: true }), I(e, async () => {
    c(e.projectManagerId) && h(S.value) && await U(), c(e.projectId) && h(D.value) && await w(), c(e.supplierId) && h(i.value) && await k(), c(e.orderId) && await L();
  }, { immediate: true, deep: true }), P({ invoiceInfo: g }), (a, n) => {
    const p = Z, m = $, f = ee;
    return u(), b("div", pe, [d(se, { "header-title": "基本信息" }), d(de, { column: 2, "form-data": o(e), "form-rules": o(ae), "table-list": H.value }, { applyDate: s(({ item: l, blur: r }) => [d(p, { modelValue: o(e)[l], "onUpdate:modelValue": (t) => o(e)[l] = t, clearable: "", placeholder: "请选择申请日期", type: "date", "value-format": "x", onBlur: r }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), applyUserId: s(({ item: l }) => [d(N, { modelValue: o(e)[l], "onUpdate:modelValue": (r) => o(e)[l] = r, clearable: false, filterable: "", placeholder: "选择申请人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), projectManagerId: s(({ item: l, blur: r }) => [d(N, { modelValue: o(e)[l], "onUpdate:modelValue": (t) => o(e)[l] = t, clearable: false, filterable: "", placeholder: "请选择项目经理", onBlur: r, onChange: U }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), projectId: s(({ item: l, blur: r }) => [d(f, { modelValue: o(e)[l], "onUpdate:modelValue": (t) => o(e)[l] = t, clearable: "", disabled: "", filterable: "", placeholder: "请输入或选择项目", onBlur: r, onChange: w }, { default: s(() => [(u(true), b(j, null, V(o(S), (t) => (u(), y(m, { key: t.id, label: t.serialNumber + "-" + t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), supplierId: s(({ item: l, blur: r }) => [d(f, { modelValue: o(e)[l], "onUpdate:modelValue": (t) => o(e)[l] = t, clearable: "", disabled: "", placeholder: "请选择供应商", onBlur: r, onChange: k }, { default: s(() => [(u(true), b(j, null, V(o(D), (t) => (u(), y(m, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), orderId: s(({ item: l, blur: r }) => [d(f, { modelValue: o(e)[l], "onUpdate:modelValue": (t) => o(e)[l] = t, clearable: "", disabled: "", placeholder: "请选择采购合同号", onBlur: r, onChange: L }, { default: s(() => [(u(true), b(j, null, V(o(i), (t) => (u(), y(m, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ve as default
};
