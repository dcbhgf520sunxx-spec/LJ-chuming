import { inject as X } from "vue";
import { ref as f } from "vue";
import { computed as x } from "vue";
import { reactive as Y } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { unref as o } from "vue";
import { Fragment as w } from "vue";
import { renderList as C } from "vue";
import { createBlock as U } from "vue";
import { createTextVNode as d } from "vue";
import { ElDatePicker as $ } from "element-plus";
import { ElCascader as ee } from "element-plus";
import { ElOption as ae } from "element-plus";
import { ElSelect as te } from "element-plus";
import { nextTick as le } from "vue";
import { s as oe, a as re } from "../../../../../../../modules/data-499610b6.js";
import { u as ne } from "../../../../../../../modules/useSelect-654af12a.js";
import { g as se, a as ce, b as de, c as ue, d as pe } from "../../../../../../../modules/payment-settlement-e8e799d8.js";
import { uD as ie, e3 as me, b as I, e2 as L, ec as k, e6 as D } from "../../../../../../../shared/runtime.js";
const fe = { class: "header-container" }, _e = { __name: "header", setup(ge, { expose: O }) {
  const E = X("settlement_data"), { formData: e, projectInfo: i, tableList: b, contractListInfo: N } = E, { projectLeaderList: M } = ne(), j = f([]), v = f([]), h = f([]), B = x(() => ie(me(re, i))), F = async () => {
    try {
      const a = await se(e.projectManagerId);
      a ? j.value = a : (L("warning", "该项目经理下暂无项目"), j.value = []);
    } catch (a) {
      console.log(a);
    }
  }, T = async () => {
    if (e.projectManagerId && e.projectId) try {
      const a = await ce({ projectId: e.projectId, projectManagerId: e.projectManagerId });
      if (Object.keys(a).length) {
        const l = Object.entries(a).map(([u, p]) => ({ id: u, value: p }));
        v.value = l;
      } else L("warning", "该项目下暂无供应商"), v.value = [];
    } catch (a) {
      console.log(a);
    }
  }, Q = async () => {
    if (e.projectManagerId && e.projectId && e.supplierId) try {
      const a = await de({ projectId: e.projectId, projectManagerId: e.projectManagerId, supplierId: e.supplierId });
      if (Object.keys(a).length) {
        const l = Object.entries(a).map(([u, p]) => ({ id: u, value: p }));
        h.value = l;
      } else L("warning", "该项目下暂无合同号"), h.value = [];
    } catch (a) {
      console.log(a);
    }
  }, P = f([]), R = x(() => P.value.reduce((a, l) => (l.invoiceAmount && (a += l.invoiceAmount), a), 0)), _ = Y({ sum: 0, total: 0 });
  Z(() => R.value, (a) => {
    _.sum = a;
  });
  const q = async () => {
    try {
      let a = await ue(e);
      P.value = [...a.list.content], _.total = a.list.totalElements, e.orderId = a.orderId, await le();
      const l = k(a.list.content);
      b.push(...l), delete a.list, a = k([a]), Object.assign(i, ...a), Object.assign(N, ...a);
    } catch (a) {
      console.log(a);
    }
  }, z = async () => {
    try {
      let a = await pe({ projectId: e.projectId, orderId: e.orderId });
      a = k([a]), Object.assign(i, ...a);
    } catch (a) {
      console.log(a);
    }
  }, m = () => {
    b.splice(0, b.length), D(N), D(i), e.settlementAmount = null;
  }, G = () => {
    m(), e.projectId = null, e.supplierId = null, e.purchaseContractNumber = null, I(e.projectManagerId) || F();
  }, H = () => {
    m(), e.supplierId = null, e.purchaseContractNumber = null, I(e.projectId) || T();
  }, J = () => {
    m(), e.purchaseContractNumber = null, I(e.supplierId) || Q();
  }, K = async () => {
    m(), I(e.purchaseContractNumber) || (await q(), await z());
  };
  return O({ invoiceInfo: _ }), (a, l) => {
    const u = A("table-header"), p = $, S = ee, V = ae, y = te, W = A("descriptions-list");
    return c(), g("div", fe, [s(u, { "header-title": "基本信息" }), s(W, { column: 2, "table-list": B.value, "form-data": o(e), "form-rules": o(oe) }, { applyDate: n(({ item: r }) => [s(p, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, type: "date", "value-format": "x", placeholder: "请选择申请日期", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), applyUserId: n(({ item: r }) => [s(S, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, clearable: "", placeholder: "选择申请人", options: o(M), "show-all-levels": false, filterable: "", props: { value: "id", emitPath: false } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), projectManagerId: n(({ item: r }) => [s(S, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, clearable: "", placeholder: "请选择项目经理", options: o(M), "show-all-levels": false, filterable: "", onChange: G, props: { value: "id", emitPath: false } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), projectId: n(({ item: r }) => [s(y, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, clearable: "", placeholder: "请选择项目", disabled: !o(e).projectManagerId, onChange: H }, { default: n(() => [(c(true), g(w, null, C(j.value, (t) => (c(), U(V, { key: t.id, label: t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), supplierId: n(({ item: r }) => [s(y, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, placeholder: "请选择供应商", clearable: "", disabled: !o(e).projectId, onChange: J }, { default: n(() => [(c(true), g(w, null, C(v.value, (t) => (c(), U(V, { key: t.id, label: t.value, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), purchaseContractNumber: n(({ item: r }) => [s(y, { modelValue: o(e)[r], "onUpdate:modelValue": (t) => o(e)[r] = t, placeholder: "请选择采购合同号", clearable: "", disabled: !o(e).supplierId, onChange: K }, { default: n(() => [(c(true), g(w, null, C(h.value, (t) => (c(), U(V, { key: t.id, label: t.value, value: t.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), default: n(() => [l[0] || (l[0] = d(" // 申请日期 ")), l[1] || (l[1] = d(" // 申请人 ")), l[2] || (l[2] = d(" // 项目经理 ")), l[3] || (l[3] = d(" // 项目 ")), l[4] || (l[4] = d(" // 供应商 ")), l[5] || (l[5] = d(" // 采购合同号 "))]), _: 1, __: [0, 1, 2, 3, 4, 5] }, 8, ["table-list", "form-data", "form-rules"])]);
  };
} };
export {
  _e as default
};
