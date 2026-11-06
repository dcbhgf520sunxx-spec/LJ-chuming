import { ref as n } from "vue";
import { computed as w } from "vue";
import { onMounted as E } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as F } from "vue";
import { unref as v } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as N } from "vue";
import { createVNode as l } from "vue";
import { ElMessage as O } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElForm as G } from "element-plus";
import { ElCard as T } from "element-plus";
import { G as C, dy as i, V as K } from "../../../../../shared/runtime.js";
import { g as P, a as Y } from "../../../../../modules/information-validity-6783e35a.js";
const j = { class: "clearfix" }, z = { class: "card-title" }, q = { __name: "ca-lock", props: { permission: { type: Object, default: () => {
} } }, setup(m) {
  const I = m, c = n(), t = n({}), d = n({}), y = w(() => {
    let e = false;
    return t.value.remindInAdvance !== d.value.remindInAdvance ? e = false : e = true, e;
  }), r = n(false);
  E(() => {
    u();
  });
  const V = { remindInAdvance: [{ required: true, message: "有效期失效提前提醒（天）", trigger: "change" }] };
  async function u() {
    if (C(I.permission.getCADateConfig)) try {
      const e = await P({ crmInformationValidityPeriodConfigEnum: i.CA_LOCK_VALIDITY_CONFIG.V });
      console.log(e), t.value = e[0], d.value = K(e[0]);
    } catch (e) {
      console.log(e);
    }
  }
  async function b() {
    if (await c.value.validate()) try {
      r.value = true;
      const a = [];
      a.push(t.value), await Y({ crmInformationValidityPeriodConfigEnum: i.CA_LOCK_VALIDITY_CONFIG.V }, a), O.success("配置成功"), u();
    } catch (a) {
      console.log(a, "提交保存");
    } finally {
      r.value = false;
    }
  }
  return (e, a) => {
    const A = p("common-button"), D = p("common-input-number"), f = B, h = G, x = T;
    return _(), g(x, null, { header: o(() => [s("div", j, [s("span", z, F(v(i).CA_LOCK_VALIDITY_CONFIG.L), 1), v(C)(m.permission.editCADateConfig) ? (_(), g(A, { key: 0, disabled: y.value, style: { float: "right", "margin-left": "8px" }, type: "success", size: "default", loading: r.value, onClick: b }, { default: o(() => a[1] || (a[1] = [L("保存")])), _: 1, __: [1] }, 8, ["disabled", "loading"])) : N("", true)])]), default: o(() => [l(h, { ref_key: "formRef", ref: c, model: t.value, rules: V, "label-width": "200px" }, { default: o(() => [l(f, { prop: "remindInAdvance", label: "有效期失效提前提醒（天）" }, { default: o(() => [l(D, { "controls-position": "right", style: { width: "200px" }, min: 1, max: 365, modelValue: t.value.remindInAdvance, "onUpdate:modelValue": a[0] || (a[0] = (k) => t.value.remindInAdvance = k) }, null, 8, ["modelValue"])]), _: 1 }), l(f, { "label-width": "0" }, { default: o(() => a[2] || (a[2] = [s("span", { class: "form-item-tip" }, " 有效期说明： ", -1), s("span", { class: "form-item-tip" }, " 1、有效期提前提醒设置后，当有效期即将达到预设的时间内，系统自动提醒； ", -1)])), _: 1, __: [2] })]), _: 1 }, 8, ["model"])]), _: 1 });
  };
} };
export {
  q as default
};
