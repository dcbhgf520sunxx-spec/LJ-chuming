import { inject as L } from "vue";
import { ref as l } from "vue";
import { computed as y } from "vue";
import { onMounted as M } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as n } from "vue";
import { createBlock as u } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as f } from "vue";
import { unref as m } from "vue";
import { createElementBlock as z } from "vue";
import { toDisplayString as A } from "vue";
import { ElNotification as G } from "element-plus";
import { InfoFilled as J } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { ElInputNumber as P } from "element-plus";
import { ElFormItem as U } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElForm as Q } from "element-plus";
import { ElCard as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { J as Y, K as Z } from "../../../../../modules/base-6bc46ddf.js";
import { d as $, G as ee, V as te } from "../../../../../shared/runtime.js";
const ae = { class: "clearfix" }, oe = { style: { display: "inline-block", cursor: "pointer" } }, se = { key: 1 }, ce = { __name: "safe-amount-config", setup(le) {
  const p = L("permission"), g = { safetyFactor: [{ required: true, message: "请选择过磅短信接收人", trigger: "blur" }] }, _ = l(), i = l({ safetyFactor: void 0 }), a = l(i.value), r = l(false), c = l(false), F = y(() => $(a.value, i.value)), E = y(() => r.value || c.value);
  M(() => {
    k();
  });
  async function k() {
    r.value = true;
    try {
      const { safetyFactor: o } = await Y();
      a.value = { safetyFactor: o }, i.value = { safetyFactor: o };
    } catch (o) {
      console.log("获取安全余额配置失败", o);
    } finally {
      r.value = false;
    }
  }
  async function w() {
    try {
      if (!await _.value.validate()) return;
      c.value = true, await Z(a.value), G({ title: "安全余额配置成功", type: "success", duration: 2500 }), i.value = te(a.value);
    } catch (o) {
      console.log("设置安全余额配置失败", o);
    } finally {
      c.value = false;
    }
  }
  return (o, e) => {
    const x = J, h = K, V = O, C = R("common-tip-button"), D = P, v = U, B = H, I = Q, N = W, S = T("permission"), j = X;
    return n(), u(N, { shadow: "always" }, { header: t(() => [d("div", ae, [s(V, { class: "item", effect: "light", content: "安全余额 =（合同金额 - 累计发货额）* 安全余额比例", placement: "top" }, { default: t(() => [d("div", oe, [e[1] || (e[1] = d("span", { class: "card-title" }, "安全余额配置", -1)), s(h, { style: { color: "#909399", "margin-left": "5px" } }, { default: t(() => [s(x)]), _: 1 })])]), _: 1 }), b((n(), u(C, { loading: c.value, disabled: F.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: t(() => e[2] || (e[2] = [f(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[S, m(p).safeAmountFactorEdit]])])]), default: t(() => [b((n(), u(I, { ref_key: "formRef", ref: _, model: a.value, rules: g, disabled: E.value, "label-width": "100px" }, { default: t(() => [s(v, { label: "加工订单", prop: "safetyFactor" }, { default: t(() => [m(ee)(m(p).safeAmountFactorEdit) ? (n(), u(D, { key: 0, modelValue: a.value.safetyFactor, "onUpdate:modelValue": e[0] || (e[0] = (q) => a.value.safetyFactor = q), modelModifiers: { number: true }, min: 0, max: 100, step: 1, precision: 2, placeholder: "比例", controls: false, style: { width: "80px" }, class: "input-underline" }, null, 8, ["modelValue"])) : (n(), z("span", se, A(a.value.safetyFactor), 1)), e[3] || (e[3] = f(" % "))]), _: 1, __: [3] }), s(v, { label: "项目承包" }, { default: t(() => [s(B, { type: "info" }, { default: t(() => e[4] || (e[4] = [f("项目承包不设安全余额")])), _: 1, __: [4] })]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[j, r.value]])]), _: 1 });
  };
} };
export {
  ce as default
};
