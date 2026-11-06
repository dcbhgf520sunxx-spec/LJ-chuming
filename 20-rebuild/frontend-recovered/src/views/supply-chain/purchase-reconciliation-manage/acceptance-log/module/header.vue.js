import { ref as h } from "vue";
import { inject as P } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as c } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { createBlock as g } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as N } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElTooltip as R } from "element-plus";
import { ElTag as Y } from "element-plus";
import { vLoading as k } from "element-plus";
import { l as V, B, bV as T, cO as L, cV as Q, jl as j, v3 as z, bF as F, bE as M, I as H, ap as K, C as q, L as $, E as W } from "../../../../../shared/runtime.js";
import { p as G } from "../../../../../modules/index-2cb7c1a5.js";
function J(i) {
  return V({ module: "contract", url: "supply-chain/order-payment/acceptance", method: "get", params: i });
}
function b(i) {
  return V({ module: "contract", url: "supply-chain/order-payment/acceptance/export", method: "get", responseType: "blob", timeout: 6e7, params: i });
}
const ne = { get: J, excel: b }, X = { class: "head-container" }, Z = { __name: "header", setup(i) {
  const C = h([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), E = { inboundTime: [], year: void 0, supplierId: void 0, classifyId: void 0, purchaseOrderId: void 0 }, p = h(0), w = P("permission"), { CRUD: m, crud: r, query: a } = B(E);
  function f(u) {
    return u > /* @__PURE__ */ new Date();
  }
  return m.HOOK.beforeToQuery = () => {
    a.inboundTime || (a.inboundTime = void 0), a.year || (a.year = void 0);
  }, m.HOOK.handleRefresh = async (u, { data: t }) => {
    p.value = T(t.supplierReconciliationAmountNoFreight) || 0, t.content = await L(t.content), t.content.forEach((n) => {
      n.basicClass < Q && (n.accountingUnit = "吨", n.accountingPrecision = 3);
    }), t.content = await j(t.content, { toSmallest: false, toNum: true }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), t.content.forEach((n) => {
      n.unitPriceExcludingVAT = T(n.unitPriceExcludingVAT, z(n.unitPriceExcludingVAT));
    });
  }, (u, t) => {
    const n = U, x = R, v = Y, I = k, O = S("permission");
    return d(), A("div", X, [c(y("div", null, [o(x, { content: "过滤采购合同", "show-after": 100, placement: "right" }, { default: s(() => [y("span", null, [o(n, { modelValue: e(a).year, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).year = l), type: "year", size: "default", class: "filter-item", style: { width: "100px!important" }, "disabled-date": f, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])])]), _: 1 }), o(M, { modelValue: e(a).supplierId, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).supplierId = l), type: e(F).RAW_MATERIAL.V, clearable: "", class: "filter-item", placeholder: "可选择供应商搜索", "show-hide": "", style: { width: "240px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "type", "onChange"]), o(G, { class: "filter-item", modelValue: e(a).purchaseOrderId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).purchaseOrderId = l), "supplier-id": e(a).supplierId, year: e(a).year, clearable: "", style: { width: "240px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "supplier-id", "year", "onChange"]), o(n, { modelValue: e(a).inboundTime, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).inboundTime = l), "default-time": C.value, type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "value-format": "x", "start-placeholder": "入库日期", "end-placeholder": "入库日期", shortcuts: e(H), "disabled-date": f, style: { width: "240px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(K, { modelValue: e(a).classifyId, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).classifyId = l), separator: " > ", "check-strictly": "", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "300px" }, placeholder: "可选择/输入科目、编号搜索", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(q))], 512), [[D, e(r).searchToggle]]), o(e(W), null, { optLeft: s(() => [c((d(), g(v, { type: "success", effect: "plain", size: "large" }, { default: s(() => [_("总额（元）：" + N(p.value), 1)]), _: 1 })), [[I, e(r).loading]])]), viewLeft: s(() => [c((d(), g($, { params: e(a), fn: e(b), "response-header-result": "" }, { default: s(() => t[5] || (t[5] = [_(" 下载验收记录（根据查询条件） ")])), _: 1, __: [5] }, 8, ["params", "fn"])), [[O, e(w).download]])]), _: 1 })]);
  };
} }, le = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  ne as c,
  le as h
};
