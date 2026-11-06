import s from "moment";
import { ref as b } from "vue";
import { watch as w } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as p } from "vue";
import { createElementVNode as O } from "vue";
import { unref as e } from "vue";
import { vShow as T } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as k } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElTag as j } from "element-plus";
import { l as f, t as z, c3 as B, B as A, C as I, bV as L, E as M } from "../../../../../../../shared/runtime.js";
function U(l) {
  return f({ module: "contract", url: "contract/payment/payment/ledger/invoice", method: "get", params: l });
}
function q(l) {
  return f({ module: "contract", url: "contract/payment/payment/ledger/invoice/summary", method: "get", params: l });
}
const R = { get: U }, Q = { __name: "header", setup(l) {
  const { decimalPrecision: _ } = z(), v = { createTime: [s().startOf("month").valueOf(), s().valueOf()], startDate: s().startOf("month").valueOf(), endDate: s().valueOf(), supplierName: void 0, branchCompanyName: void 0, projectId: void 0, serialNumber: void 0, auditStatus: { value: B.PASS.V, resetAble: false } }, { crud: i, query: t } = A(v), u = b(0);
  w(() => t, (r) => {
    r ? d() : u.value = 0;
  }, { deep: true, immediate: true }), d();
  async function d() {
    try {
      const r = await q({ startDate: t.startDate, endDate: t.endDate });
      u.value = r || 0;
    } catch (r) {
      console.log("获取累计收票金额", r);
    }
  }
  return (r, o) => {
    const y = E, m = P, g = D("print-table"), h = j, V = N("permission");
    return S(), C("div", null, [n(e(M), null, { optLeft: c(() => [p(O("div", null, [n(y, { modelValue: e(t).createTime, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).createTime = a), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), n(m, { modelValue: e(t).supplierName, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).supplierName = a), modelModifiers: { trim: true }, placeholder: "销售单位", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(m, { modelValue: e(t).branchCompanyName, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).branchCompanyName = a), modelModifiers: { trim: true }, placeholder: "购方单位", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(e(I))], 512), [[T, e(i).searchToggle]])]), viewLeft: c(() => {
      var a;
      return [p(n(g, { "api-key": "supplierInvoiceLedger", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[V, (a = e(i).permission) == null ? void 0 : a.print]]), n(h, { type: "warning", effect: "plain", size: "large" }, { default: c(() => [x(k(`累计收票：${e(L)(u.value, e(_).contract)}元`), 1)]), _: 1 })];
    }), _: 1 })]);
  };
} }, Y = Object.freeze(Object.defineProperty({ __proto__: null, default: Q }, Symbol.toStringTag, { value: "Module" }));
export {
  Q as _,
  R as c,
  Y as h
};
