import { ref as u } from "vue";
import { computed as f } from "vue";
import { onMounted as I } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as B } from "vue";
import { unref as l } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as m } from "vue";
import { createVNode as d } from "vue";
import { ElRadioGroup as L } from "element-plus";
import { createCommentVNode as T } from "vue";
import { ElNotification as F } from "element-plus";
import { ElRadio as S } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as M } from "element-plus";
import { g as P, e as U } from "../../../../../modules/technical-disclosure-config-24634047.js";
import { d as A, G as O, dl as b, au as g, V as H } from "../../../../../shared/runtime.js";
const J = { class: "clearfix" }, Y = { __name: "index", setup(K) {
  const s = u({ type: void 0 }), o = u(s.value), n = u(false), i = u(false), y = f(() => A(o.value, s.value)), E = f(() => n.value || i.value);
  I(() => {
    V();
  });
  async function V() {
    n.value = true;
    try {
      const { boolRequiredInput: t } = await P() || {};
      o.value = { boolRequiredInput: t }, s.value = { boolRequiredInput: t };
    } catch (t) {
      console.log("技术交底信息配置", t);
    } finally {
      n.value = false;
    }
  }
  async function w() {
    i.value = true;
    try {
      await U(o.value), F({ title: "技术交底信息配置成功", type: "success", duration: 2500 }), s.value = H(o.value);
    } catch (t) {
      console.log("技术交底信息配置", t);
    } finally {
      i.value = false;
    }
  }
  return (t, e) => {
    const C = N("common-tip-button"), p = S, R = j, x = z, D = G, h = B("permission"), q = M;
    return l(O)(l(b).get) ? (r(), c(D, { key: 0, shadow: "always" }, { header: a(() => [v("div", J, [e[2] || (e[2] = v("span", { class: "card-title" }, "技术交底配置", -1)), _((r(), c(C, { loading: i.value, disabled: y.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [m(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[h, l(b).coatingCreateTypeConfigEdit]])])]), default: a(() => [_((r(), c(x, { model: o.value, disabled: E.value, "label-width": "100px" }, { default: a(() => [d(R, { label: "信息是否必填", prop: "boolRequiredInput" }, { default: a(() => [d(l(L), { modelValue: o.value.boolRequiredInput, "onUpdate:modelValue": e[0] || (e[0] = (k) => o.value.boolRequiredInput = k) }, { default: a(() => [d(p, { value: l(g).TRUE.V }, { default: a(() => e[3] || (e[3] = [m("必填")])), _: 1, __: [3] }, 8, ["value"]), d(p, { value: l(g).FALSE.V }, { default: a(() => e[4] || (e[4] = [m("选填")])), _: 1, __: [4] }, 8, ["value"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[q, n.value]])]), _: 1 })) : T("", true);
  };
} };
export {
  Y as default
};
