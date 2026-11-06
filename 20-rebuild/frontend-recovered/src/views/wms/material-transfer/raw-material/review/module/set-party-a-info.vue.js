import { ref as U } from "vue";
import { computed as T } from "vue";
import { watchEffect as E } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as p } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { createVNode as x } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as m } from "vue";
import { Fragment as O } from "vue";
import { ElTableColumn as z } from "element-plus";
import { zd as k, zn as l, D as g, v3 as Y, iX as V, i as B } from "../../../../../../shared/runtime.js";
const I = { key: 1 }, D = { key: 1 }, W = { key: 1 }, S = { __name: "set-party-a-info", props: { form: { type: Object, default: () => ({ list: [] }) } }, setup(N) {
  const c = N, d = U([]), R = T(() => c.form.transferType !== k.BORROW_RETURN.V), u = U(l.BORROW.V), f = T(() => c.form.transferType === k.PUBLIC_WARE.V), h = T(() => d.value.some((a) => a.boolPartyA && a.partyATransferType === l.BUY_IN.V));
  E(() => {
    d.value = c.form.list || [], f.value && (u.value = f.value ? l.BUY_IN.V : l.BORROW.V), A(u.value);
  });
  function A(a) {
    d.value.forEach((n) => {
      n.boolPartyA && (n.partyATransferType = a);
    });
  }
  function C(a, n) {
    Y(a) > 10 && (n.unitPrice = V(a, 10), a = n.unitPrice), n.amount = B(a) ? V(a * n.mete, g.YUAN) : void 0;
  }
  function v(a, n) {
    n.unitPrice = B(a) ? V(a / n.mete, 10) : void 0;
  }
  return (a, n) => {
    const y = b("common-radio-button"), _ = z, P = b("common-input-number");
    return R.value ? (t(), p(O, { key: 0 }, [f.value ? m("", true) : (t(), r(_, { key: 0, prop: "partyATransferType", align: "center", width: "140px" }, { header: i(() => [x(y, { type: "enum", modelValue: u.value, "onUpdate:modelValue": n[0] || (n[0] = (e) => u.value = e), options: s(l).ENUM, onChange: A, size: "default" }, null, 8, ["modelValue", "options"])]), default: i(({ row: { sourceRow: e } }) => [e.boolPartyA ? (t(), r(y, { key: 0, type: "enum", modelValue: e.partyATransferType, "onUpdate:modelValue": (o) => e.partyATransferType = o, options: s(l).ENUM, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), p("span", I, "-"))]), _: 1 })), h.value ? (t(), r(_, { key: 1, prop: "unitPrice", align: "center", width: "135px", label: "含税单价" }, { default: i(({ row: { sourceRow: e } }) => [e.partyATransferType === s(l).BUY_IN.V ? (t(), r(P, { key: 0, modelValue: e.unitPrice, "onUpdate:modelValue": (o) => e.unitPrice = o, min: 0, max: 9999999, controls: false, step: 1, size: "default", placeholder: "含税单价", onChange: (o) => C(o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (t(), p("span", D, "-"))]), _: 1 })) : m("", true), h.value ? (t(), r(_, { key: 2, prop: "amount", align: "center", width: "135px", label: "金额" }, { default: i(({ row: { sourceRow: e } }) => [e.partyATransferType === s(l).BUY_IN.V ? (t(), r(P, { key: 0, modelValue: e.amount, "onUpdate:modelValue": (o) => e.amount = o, min: 0, max: 999999999, controls: false, step: 1, precision: s(g).YUAN, size: "default", placeholder: "金额", onChange: (o) => v(o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (t(), p("span", W, "-"))]), _: 1 })) : m("", true)], 64)) : m("", true);
  };
} };
export {
  S as default
};
