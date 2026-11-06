import { inject as F } from "vue";
import { ref as n } from "vue";
import { computed as m } from "vue";
import { onMounted as M } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as d } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as c } from "vue";
import { unref as v } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as k } from "element-plus";
import { ElNotification as q } from "element-plus";
import { ElRadio as L } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElForm as R } from "element-plus";
import { ElCard as z } from "element-plus";
import { vLoading as S } from "element-plus";
import { p as G, q as I } from "../../../../../modules/base-6bc46ddf.js";
import { d as O, V as U } from "../../../../../shared/runtime.js";
const A = { class: "clearfix" }, W = { __name: "folding-price-method", setup(H) {
  const b = F("permission"), l = n({ priceType: void 0 }), o = n(l.value), s = n(false), i = n(false), y = m(() => O(o.value, l.value)), g = m(() => s.value || i.value);
  M(() => {
    w();
  });
  async function w() {
    s.value = true;
    try {
      const { priceType: t = false } = await G();
      o.value = { priceType: t }, l.value = { priceType: t };
    } catch (t) {
      console.log("获取折边件计价方式填写配置", t);
    } finally {
      s.value = false;
    }
  }
  async function E() {
    i.value = true;
    try {
      await I(o.value), q({ title: "折边件计价方式配置成功", type: "success", duration: 2500 }), l.value = U(o.value);
    } catch (t) {
      console.log("设置折边件计价方式配置", t);
    } finally {
      i.value = false;
    }
  }
  return (t, e) => {
    const V = N("common-tip-button"), p = L, T = P, h = R, x = z, C = j("permission"), D = S;
    return d(), u(x, { shadow: "always" }, { header: a(() => [f("div", A, [e[2] || (e[2] = f("span", { class: "card-title" }, "围护-折边件计价方式配置", -1)), _((d(), u(V, { loading: i.value, disabled: y.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: E }, { default: a(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[C, v(b).foldingPriceMethodEdit]])])]), default: a(() => [_((d(), u(h, { model: o.value, disabled: g.value, "label-width": "100px" }, { default: a(() => [r(T, { label: "选择计价方式", prop: "priceType" }, { default: a(() => [r(v(k), { modelValue: o.value.priceType, "onUpdate:modelValue": e[0] || (e[0] = (B) => o.value.priceType = B) }, { default: a(() => [r(p, { value: true }, { default: a(() => e[3] || (e[3] = [c("单价*计价单位")])), _: 1, __: [3] }), r(p, { value: false }, { default: a(() => e[4] || (e[4] = [c("单价*计价单位*折弯次数")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[D, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
