import { inject as N } from "vue";
import { ref as d } from "vue";
import { computed as A } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as t } from "vue";
import { withDirectives as y } from "vue";
import { createTextVNode as B } from "vue";
import { unref as v } from "vue";
import { createVNode as s } from "vue";
import { ElNotification as U } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElCard as M } from "element-plus";
import { vLoading as T } from "element-plus";
import { g as q, e as z } from "../../../../../modules/amount-apply-config-f0556377.js";
import { _ as F, d as I, G, fY as P, fZ as R, V as Y } from "../../../../../shared/runtime.js";
const Z = { class: "clearfix" }, H = { __name: "amount-apply-config", setup(J) {
  const _ = N("permission"), i = d({ boolAllowOverContractAmount: void 0, boolAllowOverSettleAmount: void 0 }), l = d(i.value), r = d(false), u = d(false), g = A(() => I(l.value, i.value)), C = A(() => r.value || u.value);
  D(() => {
    O();
  });
  async function O() {
    if (G(_.get)) {
      r.value = true;
      try {
        const o = await q(), e = o == null ? void 0 : o.boolAllowOverContractAmount, m = o == null ? void 0 : o.boolAllowOverSettleAmount;
        l.value = { boolAllowOverContractAmount: e, boolAllowOverSettleAmount: m }, i.value = { boolAllowOverContractAmount: e, boolAllowOverSettleAmount: m };
      } catch (o) {
        console.log("获取金额申请配置", o);
      } finally {
        r.value = false;
      }
    }
  }
  async function V() {
    u.value = true;
    try {
      await z(l.value), U({ title: "配置成功", type: "success", duration: 2500 }), i.value = Y(l.value);
    } catch (o) {
      console.log("设置金额申请配置", o);
    } finally {
      u.value = false;
    }
  }
  return (o, e) => {
    const m = w("common-tip-button"), n = j, b = w("common-select"), S = L, E = M, x = k("permission"), h = T;
    return p(), f(E, { shadow: "always" }, { header: a(() => [t("div", Z, [e[3] || (e[3] = t("span", { class: "card-title" }, "金额申请限制", -1)), y((p(), f(m, { loading: u.value, disabled: g.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: V }, { default: a(() => e[2] || (e[2] = [B(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[x, v(_).edit]])])]), default: a(() => [y((p(), f(S, { model: l.value, disabled: C.value, "label-width": "100px" }, { default: a(() => [s(n, { "label-width": "0" }, { default: a(() => e[4] || (e[4] = [t("span", { class: "form-item-label" }, "结算前", -1)])), _: 1, __: [4] }), s(n, { label: "金额：", prop: "boolAllowOverContractAmount" }, { default: a(() => [s(b, { modelValue: l.value.boolAllowOverContractAmount, "onUpdate:modelValue": e[0] || (e[0] = (c) => l.value.boolAllowOverContractAmount = c), options: v(P).ENUM, type: "enum", class: "input-underline", placeholder: "结算前金额", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }), s(n, { "label-width": "0" }, { default: a(() => e[5] || (e[5] = [t("span", { class: "form-item-label" }, "结算后", -1)])), _: 1, __: [5] }), s(n, { label: "金额：", prop: "boolAllowOverSettleAmount" }, { default: a(() => [s(b, { modelValue: l.value.boolAllowOverSettleAmount, "onUpdate:modelValue": e[1] || (e[1] = (c) => l.value.boolAllowOverSettleAmount = c), options: v(R).ENUM, type: "enum", class: "input-underline", placeholder: "结算后金额", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }), s(n, { "label-width": "0" }, { default: a(() => e[6] || (e[6] = [t("div", { class: "form-item-tip" }, [t("div", null, "受该设置影响的金额包含："), t("div", { class: "form-item-tip item-class" }, "①项目收款金额"), t("div", { class: "form-item-tip item-class" }, "②项目开票金额"), t("div", { class: "form-item-tip item-class" }, "③采购/分包合同付款金额"), t("div", { class: "form-item-tip item-class" }, "④采购/分包合同收票金额")], -1)])), _: 1, __: [6] })]), _: 1 }, 8, ["model", "disabled"])), [[h, r.value]])]), _: 1 });
  };
} }, X = F(H, [["__scopeId", "data-v-c3110fe1"]]);
export {
  X as default
};
