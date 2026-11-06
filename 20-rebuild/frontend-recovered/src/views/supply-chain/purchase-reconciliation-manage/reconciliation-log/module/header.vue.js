import { ref as c } from "vue";
import { inject as H } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as m } from "vue";
import { vShow as K } from "vue";
import { unref as e } from "vue";
import { createElementVNode as L } from "vue";
import { createVNode as n } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as h } from "vue";
import { Fragment as q } from "vue";
import { renderList as $ } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as W } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElCol as Z } from "element-plus";
import { ElRow as ee } from "element-plus";
import { vLoading as ae } from "element-plus";
import { l as O, _ as te, t as le, B as ne, bV as k, cO as se, cV as oe, pA as re, pz as ie, jl as ce, v3 as ue, bF as de, bE as pe, I as me, ap as fe, C as ye, L as he, E as _e } from "../../../../../shared/runtime.js";
import { P as V } from "../../../../../modules/index-5b9e6004.js";
import { p as ge } from "../../../../../modules/index-2cb7c1a5.js";
function ve(d) {
  return O({ module: "contract", url: "supply-chain/order-payment/reconciliation", method: "get", params: d });
}
function be(d) {
  return O({ url: "/api/v2/supply-chain/order-payment/reconciliation/summary", method: "get", params: d });
}
function R(d) {
  return O({ url: "/api/v2/supply-chain/order-payment/reconciliation/export", method: "get", responseType: "blob", timeout: 6e7, params: d });
}
const Pe = { get: ve, excel: R };
const Te = { class: "head-container" }, Ce = { key: 0 }, Ve = { __name: "header", setup(d) {
  const { decimalPrecision: x } = le(), U = c([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), j = { inboundTime: [], year: void 0, supplierId: void 0, classifyId: void 0, purchaseOrderId: void 0 }, E = { totalOrder: 0, totalAmount: 0, totalActualAmount: 0 }, I = c(0), A = c({}), z = c({}), P = c([]), g = c(false), p = c({ ...E }), S = H("permission"), { CRUD: w, crud: i, query: t } = ne(j);
  function D(o) {
    return o > /* @__PURE__ */ new Date();
  }
  function Y(o = {}, a) {
    A.value = o;
  }
  function B(o = {}, a) {
    z.value = o;
  }
  async function F() {
    try {
      g.value = true;
      const o = await be({ year: t.year || void 0, supplierId: t.supplierId }) || {};
      p.value = o;
    } catch (o) {
      p.value = { ...E }, console.log("供应商汇总", o);
    } finally {
      g.value = false;
    }
  }
  return w.HOOK.beforeToQuery = () => {
    t.inboundTime || (t.inboundTime = void 0), t.year || (t.year = void 0);
  }, w.HOOK.handleRefresh = async (o, { data: a }) => {
    I.value = k(a.supplierReconciliationAmountNoFreight) || 0, P.value = a.project || [], a.content = await se(a.content), a.content.forEach((l) => {
      l.basicClass < oe && (l.accountingUnit = "吨", l.accountingPrecision = 3);
      const f = { basicClass: l.basicClass, thickness: l.thickness, specification: l.specification };
      l.formatSpec = re(f), l.specTip = ie({ ...f, specificationLabels: l.specificationLabels });
    }), a.content = await ce(a.content, { toSmallest: false, toNum: true }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), a.content.forEach((l) => {
      l.unitPriceExcludingVAT = k(l.unitPriceExcludingVAT, ue(l.unitPriceExcludingVAT));
    }), F();
  }, (o, a) => {
    const l = G, f = J, v = X, b = Z, Q = ee, T = ae, N = M("permission");
    return u(), C("div", Te, [m(L("div", null, [n(f, { content: "过滤采购合同", "show-after": 100, placement: "right" }, { default: r(() => [L("span", null, [n(l, { modelValue: e(t).year, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(t).year = s), type: "year", size: "default", class: "filter-item", style: { width: "100px!important" }, "disabled-date": D, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"])])]), _: 1 }), n(pe, { modelValue: e(t).supplierId, "onUpdate:modelValue": a[1] || (a[1] = (s) => e(t).supplierId = s), type: e(de).RAW_MATERIAL.V, clearable: "", class: "filter-item", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "240px" }, onChange: e(i).toQuery, onInfoChange: B }, null, 8, ["modelValue", "type", "onChange"]), n(ge, { class: "filter-item", modelValue: e(t).purchaseOrderId, "onUpdate:modelValue": a[2] || (a[2] = (s) => e(t).purchaseOrderId = s), "supplier-id": e(t).supplierId, year: e(t).year, clearable: "", style: { width: "240px" }, onChange: e(i).toQuery, onInfoChange: Y }, null, 8, ["modelValue", "supplier-id", "year", "onChange"]), n(l, { modelValue: e(t).inboundTime, "onUpdate:modelValue": a[3] || (a[3] = (s) => e(t).inboundTime = s), "default-time": U.value, type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "value-format": "x", "start-placeholder": "入库日期", "end-placeholder": "入库日期", shortcuts: e(me), "disabled-date": D, style: { width: "240px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), n(fe, { modelValue: e(t).classifyId, "onUpdate:modelValue": a[4] || (a[4] = (s) => e(t).classifyId = s), separator: " > ", "check-strictly": "", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "300px" }, placeholder: "可选择/输入科目、编号搜索", onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(ye)), e(t).purchaseOrderId ? m((u(), C("div", Ce, [n(v, { class: "tips", effect: "plain", size: "large" }, { default: r(() => [y("采购合同编号：" + h(A.value.serialNumber), 1)]), _: 1 }), (u(true), C(q, null, $(P.value, (s) => (u(), _(v, { key: s.id, class: "tips", effect: "plain", size: "large" }, { default: r(() => [y(h(s.shortName) + " " + h(s.serialNumber), 1)]), _: 2 }, 1024))), 128))])), [[T, e(i).loading]]) : W("", true)], 512), [[K, e(i).searchToggle]]), n(e(_e), null, { optLeft: r(() => [m((u(), _(v, { class: "tips", type: "success", effect: "plain", size: "large" }, { default: r(() => [y("总额（元）：" + h(I.value), 1)]), _: 1 })), [[T, e(i).loading]])]), viewLeft: r(() => [m((u(), _(he, { class: "tips", params: e(t), fn: e(R), "response-header-result": "" }, { default: r(() => a[5] || (a[5] = [y(" 下载供应商对账（根据查询条件） ")])), _: 1, __: [5] }, 8, ["params", "fn"])), [[N, e(S).download]])]), _: 1 }), m((u(), _(Q, { gutter: 20, class: "panel-group" }, { default: r(() => [n(b, { span: 8, class: "card-panel-col" }, { default: r(() => [n(e(V), { name: "合同数（个）", "text-color": "#626262", "num-color": "#1890ff", "end-val": p.value.totalOrder || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(b, { span: 8, class: "card-panel-col" }, { default: r(() => [n(e(V), { name: "合同额（万元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": p.value.totalAmount / 1e4 || 0, precision: e(x).supplyChain }, null, 8, ["end-val", "precision"])]), _: 1 }), n(b, { span: 8, class: "card-panel-col" }, { default: r(() => [n(e(V), { name: "实际收货额（万元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": p.value.totalActualAmount / 1e4 || 0, precision: e(x).supplyChain }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[N, e(S).get], [T, g.value]])]);
  };
} }, Oe = te(Ve, [["__scopeId", "data-v-5a7b3b79"]]), Se = Object.freeze(Object.defineProperty({ __proto__: null, default: Oe }, Symbol.toStringTag, { value: "Module" }));
export {
  Pe as c,
  Se as h,
  Oe as m
};
