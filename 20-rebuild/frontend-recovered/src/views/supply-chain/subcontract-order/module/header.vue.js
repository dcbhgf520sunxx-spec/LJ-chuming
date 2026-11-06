import { ref as w } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as v } from "vue";
import { vShow as Q } from "vue";
import { unref as e } from "vue";
import { createElementVNode as Y } from "vue";
import { createVNode as t } from "vue";
import { withKeys as f } from "vue";
import { createBlock as E } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as k } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElCol as U } from "element-plus";
import { ElRow as j } from "element-plus";
import { vLoading as z } from "element-plus";
import { l as m, _ as A, t as B, B as D, sx as O, C as q, G as H, E as I } from "../../../../shared/runtime.js";
import { P as d } from "../../../../modules/index-5b9e6004.js";
function M(l) {
  return m({ module: "contract", url: "scm/subcontract-order", method: "get", params: l });
}
function T(l) {
  return m({ module: "contract", url: "scm/subcontract-order", method: "post", data: l });
}
function F(l) {
  return m({ module: "contract", url: "scm/subcontract-order", method: "put", data: l });
}
function G(l) {
  return m({ module: "contract", url: "scm/subcontract-order", method: "delete", data: l });
}
function L(l) {
  return m({ module: "contract", url: "scm/subcontract-order/getSum", method: "get" });
}
const ee = { add: T, edit: F, del: G, get: M };
const R = { class: "head-container" }, $ = { __name: "header", setup(l) {
  const { decimalPrecision: _ } = B(), g = { year: String((/* @__PURE__ */ new Date()).getFullYear()), boolSettlementStatus: void 0, serialNumber: void 0, projectName: void 0, supplierName: void 0 }, { crud: r, query: o } = D(g), s = w({});
  b();
  async function b() {
    try {
      const i = await L();
      s.value = i || {};
    } catch (i) {
      console.log("获取订单数量", i);
    }
  }
  return (i, a) => {
    const h = K, V = N("common-radio-button"), p = P, c = U, x = j, S = z;
    return y(), C("div", R, [v(Y("div", null, [t(h, { modelValue: e(o).year, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(o).year = n), class: "date-item filter-item", format: "YYYY", placeholder: "选择年", size: "default", style: { width: "100px!important" }, type: "year", "value-format": "YYYY", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), t(V, { modelValue: e(o).boolSettlementStatus, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(o).boolSettlementStatus = n), optionAllValue: void 0, options: e(O).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(p, { modelValue: e(o).serialNumber, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(o).serialNumber = n), class: "filter-item", clearable: "", placeholder: "订单号", size: "default", style: { width: "200px" }, onKeyup: f(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(p, { modelValue: e(o).projectName, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(o).projectName = n), class: "filter-item", clearable: "", placeholder: "项目", size: "default", style: { width: "200px" }, onKeyup: f(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(p, { modelValue: e(o).supplierName, "onUpdate:modelValue": a[4] || (a[4] = (n) => e(o).supplierName = n), class: "filter-item", clearable: "", placeholder: "分包商", size: "default", style: { width: "200px" }, onKeyup: f(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(q))], 512), [[Q, e(r).searchToggle]]), e(H)(e(r).permission.get) ? v((y(), E(x, { key: 0, gutter: 20, class: "panel-group" }, { default: u(() => [t(c, { span: 5, class: "card-panel-col" }, { default: u(() => [t(e(d), { "end-val": s.value.amount || 0, precision: e(_).supplyChain, name: "累计合同额", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 }), t(c, { span: 5, class: "card-panel-col" }, { default: u(() => [t(e(d), { "end-val": s.value.orderQuantity || 0, precision: 0, name: "累计订单数", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(c, { span: 5, class: "card-panel-col" }, { default: u(() => [t(e(d), { "end-val": s.value.unSettlementQuantity || 0, precision: 0, name: "进行中", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(c, { span: 5, class: "card-panel-col" }, { default: u(() => [t(e(d), { "end-val": s.value.settlementQuantity || 0, precision: 0, name: "已结算", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), t(c, { span: 4, class: "card-panel-col" }, { default: u(() => [t(e(d), { "end-val": s.value.settlementAmount || 0, precision: e(_).supplyChain, name: "累计结算额", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[S, e(r).loading]]) : k("", true), t(e(I), { "add-text": "分包立项" })]);
  };
} }, J = A($, [["__scopeId", "data-v-2361c3f9"]]), te = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  ee as c,
  te as h,
  J as m
};
