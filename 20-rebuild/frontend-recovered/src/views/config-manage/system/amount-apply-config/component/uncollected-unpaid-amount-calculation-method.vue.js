import { ref as m } from "vue";
import { computed as h } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as f } from "vue";
import { createBlock as U } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as A } from "vue";
import { createTextVNode as k } from "vue";
import { unref as a } from "vue";
import { createVNode as n } from "vue";
import { ElNotification as z } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElCard as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { a as F, b as I } from "../../../../../modules/amount-apply-config-f0556377.js";
import { _ as P, d as R, G as b, f_ as p, f$ as G, g0 as O, V as T } from "../../../../../shared/runtime.js";
const $ = { class: "clearfix" }, H = { __name: "uncollected-unpaid-amount-calculation-method", setup(J) {
  const d = m({ boolShowUnsettledUncollectedAmount: void 0, boolShowUnsettledUnpaidAmount: void 0 }), t = m(d.value), s = m(false), i = m(false), S = h(() => R(t.value, d.value)), g = h(() => s.value || i.value);
  N(() => {
    y();
  });
  async function y() {
    if (b(p.getUncollectedUnpaidAmountCalculationMethod)) {
      s.value = true;
      try {
        const o = await F(), e = o == null ? void 0 : o.boolShowUnsettledUncollectedAmount, u = o == null ? void 0 : o.boolShowUnsettledUnpaidAmount;
        t.value = { boolShowUnsettledUncollectedAmount: e, boolShowUnsettledUnpaidAmount: u }, d.value = { boolShowUnsettledUncollectedAmount: e, boolShowUnsettledUnpaidAmount: u };
      } catch (o) {
        console.log("获取未收款/未付款金额计算方式", o);
      } finally {
        s.value = false;
      }
    }
  }
  async function C() {
    i.value = true;
    try {
      await I(t.value), z({ title: "配置成功", type: "success", duration: 2500 }), d.value = T(t.value);
    } catch (o) {
      console.log("设置未收款/未付款金额计算方式", o);
    } finally {
      i.value = false;
    }
  }
  return (o, e) => {
    const u = w("common-tip-button"), c = B, v = w("common-radio"), M = L, V = j, E = D("permission"), x = q;
    return f(), U(V, { shadow: "always" }, { header: l(() => [r("div", $, [e[3] || (e[3] = r("span", { class: "card-title" }, "未收款/未付款金额计算方式", -1)), A((f(), U(u, { loading: i.value, disabled: S.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: l(() => e[2] || (e[2] = [k(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[E, a(p).editUncollectedUnpaidAmountCalculationMethod]])])]), default: l(() => [A((f(), U(M, { model: t.value, disabled: g.value, "label-width": "50px" }, { default: l(() => [n(c, { "label-width": "0" }, { default: l(() => e[4] || (e[4] = [r("span", { class: "form-item-label" }, "项目台账 - 收入台账 - 未收款金额计算方式：", -1)])), _: 1, __: [4] }), n(c, { label: "", prop: "boolShowUnsettledUncollectedAmount" }, { default: l(() => [n(v, { class: "filter-item", modelValue: t.value.boolShowUnsettledUncollectedAmount, "onUpdate:modelValue": e[0] || (e[0] = (_) => t.value.boolShowUnsettledUncollectedAmount = _), options: a(G).ENUM, disabled: !a(b)(a(p).editUncollectedUnpaidAmountCalculationMethod), type: "enum", size: "default" }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), n(c, { "label-width": "0" }, { default: l(() => e[5] || (e[5] = [r("span", { class: "form-item-label" }, "采购台账 - 未付款金额计算方式：", -1)])), _: 1, __: [5] }), n(c, { label: "", prop: "boolShowUnsettledUnpaidAmount" }, { default: l(() => [n(v, { class: "filter-item", modelValue: t.value.boolShowUnsettledUnpaidAmount, "onUpdate:modelValue": e[1] || (e[1] = (_) => t.value.boolShowUnsettledUnpaidAmount = _), disabled: !a(b)(a(p).editUncollectedUnpaidAmountCalculationMethod), options: a(O).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[x, s.value]])]), _: 1 });
  };
} }, X = P(H, [["__scopeId", "data-v-b2024dac"]]);
export {
  X as default
};
