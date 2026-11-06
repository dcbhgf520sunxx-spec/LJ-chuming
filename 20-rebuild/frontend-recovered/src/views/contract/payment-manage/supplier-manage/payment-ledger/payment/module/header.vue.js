import s from "moment";
import { ref as w } from "vue";
import { watch as D } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as O } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { withDirectives as p } from "vue";
import { createElementVNode as U } from "vue";
import { unref as e } from "vue";
import { vShow as x } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as C } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElTag as j } from "element-plus";
import { l as f, t as z, c3 as B, B as N, C as A, bV as L, E as M } from "../../../../../../../shared/runtime.js";
function q(o) {
  return f({ module: "contract", url: "contract/payment/payment/ledger", method: "get", params: o });
}
function I(o) {
  return f({ module: "contract", url: "contract/payment/payment/ledger/summary", method: "get", params: o });
}
const R = { get: q }, Q = { __name: "header", setup(o) {
  const { decimalPrecision: g } = z(), y = { createTime: [s().startOf("month").valueOf(), s().valueOf()], startDate: s().startOf("month").valueOf(), endDate: s().valueOf(), paymentUnit: void 0, receivingUnit: void 0, projectId: void 0, serialNumber: void 0, auditStatus: { value: B.PASS.V, resetAble: false } }, { crud: i, query: t } = N(y), u = w(0);
  D(() => t, (r) => {
    r ? c() : u.value = 0;
  }, { deep: true, immediate: true }), c();
  async function c() {
    try {
      const r = await I({ startDate: t.startDate, endDate: t.endDate });
      u.value = r || 0;
    } catch (r) {
      console.log("获取累计付款金额", r);
    }
  }
  return (r, l) => {
    const _ = E, m = P, v = S("print-table"), h = j, V = b("permission");
    return O(), T("div", null, [n(e(M), null, { optLeft: d(() => [p(U("div", null, [n(_, { modelValue: e(t).createTime, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(t).createTime = a), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), n(m, { modelValue: e(t).paymentUnit, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(t).paymentUnit = a), modelModifiers: { trim: true }, placeholder: "付款单位", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(m, { modelValue: e(t).receivingUnit, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(t).receivingUnit = a), modelModifiers: { trim: true }, placeholder: "收款单位", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(e(A))], 512), [[x, e(i).searchToggle]])]), viewLeft: d(() => {
      var a;
      return [p(n(v, { "api-key": "supplierPaymentLedger", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[V, (a = e(i).permission) == null ? void 0 : a.print]]), n(h, { type: "warning", size: "large", effect: "plain" }, { default: d(() => [k(C(`累计付款：${e(L)(u.value, e(g).contract)} 元`), 1)]), _: 1 })];
    }), _: 1 })]);
  };
} }, Y = Object.freeze(Object.defineProperty({ __proto__: null, default: Q }, Symbol.toStringTag, { value: "Module" }));
export {
  Q as _,
  R as c,
  Y as h
};
