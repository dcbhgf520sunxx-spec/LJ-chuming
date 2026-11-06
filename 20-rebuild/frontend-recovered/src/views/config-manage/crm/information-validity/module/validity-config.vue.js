import { ref as s } from "vue";
import { computed as O } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as w } from "vue";
import { unref as I } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as F } from "vue";
import { createVNode as i } from "vue";
import { ElMessage as G } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElForm as k } from "element-plus";
import { ElCard as M } from "element-plus";
import { G as V, dy as u, V as B } from "../../../../../shared/runtime.js";
import { g as L, a as T } from "../../../../../modules/information-validity-6783e35a.js";
const P = { class: "clearfix" }, Y = { class: "card-title" }, U = { __name: "validity-config", props: { permission: { type: Object, default: () => {
} } }, setup(c) {
  const C = c, f = s(), a = s({ validityOfRegistration: void 0, remindInAdvance: void 0 }), l = s({}), b = O(() => {
    let t = false;
    return a.value.validityOfRegistration !== l.value.validityOfRegistration || a.value.remindInAdvance !== l.value.remindInAdvance ? t = false : t = true, t;
  }), r = s(false);
  R(() => {
    p();
  });
  const E = { validityOfRegistration: [{ required: true, message: "请填写项目信息登记有效期（天）", trigger: "change" }], remindInAdvance: [{ required: true, message: "请填写有效期失效提前提醒（天）", trigger: "change" }] };
  async function p() {
    if (V(C.permission.getExpirationDateConfig)) try {
      const t = await L({ crmInformationValidityPeriodConfigEnum: u.MESSAGE_VALIDITY_CONFIG.V });
      console.log(t), a.value = t[0], l.value = B(t[0]);
    } catch (t) {
      console.log(t);
    }
  }
  async function x() {
    if (await f.value.validate()) try {
      r.value = true;
      const e = [];
      e.push(a.value), await T({ crmInformationValidityPeriodConfigEnum: u.MESSAGE_VALIDITY_CONFIG.V }, e), G.success("配置成功"), p();
    } catch (e) {
      console.log(e, "提交保存");
    } finally {
      r.value = false;
    }
  }
  return (t, e) => {
    const A = v("common-button"), g = v("common-input-number"), d = N, h = k, D = M;
    return _(), y(D, null, { header: o(() => [n("div", P, [n("span", Y, w(I(u).MESSAGE_VALIDITY_CONFIG.L), 1), I(V)(c.permission.editExpirationDateConfig) ? (_(), y(A, { key: 0, disabled: b.value, style: { float: "right", "margin-left": "8px" }, type: "success", size: "default", loading: r.value, onClick: x }, { default: o(() => e[2] || (e[2] = [S("保存")])), _: 1, __: [2] }, 8, ["disabled", "loading"])) : F("", true)])]), default: o(() => [i(h, { ref_key: "formRef", ref: f, model: a.value, "label-width": "200px", rules: E }, { default: o(() => [i(d, { prop: "validityOfRegistration", label: "项目信息登记有效期（天）" }, { default: o(() => [i(g, { "controls-position": "right", style: { width: "200px" }, min: 1, max: 365, modelValue: a.value.validityOfRegistration, "onUpdate:modelValue": e[0] || (e[0] = (m) => a.value.validityOfRegistration = m) }, null, 8, ["modelValue"])]), _: 1 }), i(d, { prop: "remindInAdvance", label: "有效期失效提前提醒（天）" }, { default: o(() => [i(g, { "controls-position": "right", style: { width: "200px" }, min: 1, max: 365, modelValue: a.value.remindInAdvance, "onUpdate:modelValue": e[1] || (e[1] = (m) => a.value.remindInAdvance = m) }, null, 8, ["modelValue"])]), _: 1 }), i(d, { "label-width": "0" }, { default: o(() => e[3] || (e[3] = [n("span", { class: "form-item-tip" }, " 有效期说明： ", -1), n("span", { class: "form-item-tip" }, " 1、自项目信息登记且审批后，在有效期内，无任何跟踪反馈信息自动失效； ", -1), n("span", { class: "form-item-tip" }, " 2、在有效期内进行跟踪反馈，有效期按照跟踪反馈时间重新计算有效期； ", -1), n("span", { class: "form-item-tip" }, " 3、有效期提前提醒设置后，当有效期即将达到预设的时间内，系统自动提醒； ", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["model"])]), _: 1 });
  };
} };
export {
  U as default
};
