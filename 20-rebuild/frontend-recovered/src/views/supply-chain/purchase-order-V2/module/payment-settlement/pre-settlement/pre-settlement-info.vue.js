import { inject as c } from "vue";
import { computed as i } from "vue";
import { watch as V } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as m } from "vue";
import { withCtx as u } from "vue";
import { unref as a } from "vue";
import { ElInput as h } from "element-plus";
import { f as U, g as A } from "../../../../../../modules/data-33e35578.js";
import { e5 as P, iK as b, ia as w } from "../../../../../../shared/runtime.js";
const y = { class: "contract-info-container" }, g = { __name: "pre-settlement-info", setup(S) {
  const s = c("pre_settlement_data"), { formData: e } = s, r = i(() => U);
  V([() => e.inboundAmountSum, () => e.preSettlementAmount], ([o, d]) => {
    const l = (o ?? 0) - (d ?? 0);
    e.residualPresettlement = l == null ? void 0 : l.toFixed(2);
  }, { immediate: true });
  const p = () => {
    let o = e.settlementAmount;
    o = b(o, { allowNegative: false }), e.settlementAmount = +o >= +e.residualPresettlement ? e.residualPresettlement : o, e.uPThisPresettlement = w(e.settlementAmount);
  };
  return (o, d) => {
    const n = h;
    return _(), f("div", y, [m(P, { column: 2, "form-data": a(e), "form-rules": a(A), "table-list": r.value, "item-width": "7vw" }, { inboundAmountSum: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, placeholder: "累计入库额", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), paymentAmountSum: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, placeholder: "累计付款", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), preSettlementAmount: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, placeholder: "累计预结算", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), residualPresettlement: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), settlementAmount: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, clearable: "", placeholder: "请输入本次预结金额", onInput: p }, null, 8, ["modelValue", "onUpdate:modelValue"])]), uPThisPresettlement: u(({ item: t }) => [m(n, { modelValue: a(e)[t], "onUpdate:modelValue": (l) => a(e)[t] = l, clearable: "", placeholder: "请输入大写金额", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  g as default
};
