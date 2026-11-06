import { inject as W } from "vue";
import { ref as i } from "vue";
import { computed as p } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as m } from "vue";
import { createTextVNode as _ } from "vue";
import { unref as v } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as k } from "element-plus";
import { ElNotification as F } from "element-plus";
import { ElRadio as R } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as I } from "element-plus";
import { F as S, G as T } from "../../../../../modules/base-6bc46ddf.js";
import { _ as M, d as O, V as U } from "../../../../../shared/runtime.js";
const A = { class: "clearfix" }, H = { __name: "product-label-config", setup(J) {
  const b = W("permission"), l = i({ boolPrintWarehousing: void 0 }), o = i(l.value), s = i(false), n = i(false), g = p(() => O(o.value, l.value)), y = p(() => s.value || n.value);
  B(() => {
    C();
  });
  async function C() {
    s.value = true;
    try {
      const { boolPrintWarehousing: t = false } = await S();
      o.value = { boolPrintWarehousing: t }, l.value = { boolPrintWarehousing: t };
    } catch (t) {
      console.log("获取产品标签配置", t);
    } finally {
      s.value = false;
    }
  }
  async function w() {
    n.value = true;
    try {
      await T(o.value), F({ title: "产品标签配置成功", type: "success", duration: 2500 }), l.value = U(o.value);
    } catch (t) {
      console.log("设置产品标签配置", t);
    } finally {
      n.value = false;
    }
  }
  return (t, e) => {
    const x = N("common-tip-button"), f = R, E = q, P = z, V = G, L = j("permission"), h = I;
    return u(), d(V, { shadow: "always" }, { header: a(() => [c("div", A, [e[2] || (e[2] = c("span", { class: "card-title" }, "打印配置", -1)), e[3] || (e[3] = c("span", { class: "tips" }, "*仅对产品标签页生效", -1)), m((u(), d(x, { loading: n.value, disabled: g.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [_(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[L, v(b).labelPrintConfigEdit]])])]), default: a(() => [m((u(), d(P, { model: o.value, disabled: y.value, "label-width": "180px" }, { default: a(() => [r(E, { label: "是否仅打印入库数据：", prop: "boolPrintWarehousing" }, { default: a(() => [r(v(k), { modelValue: o.value.boolPrintWarehousing, "onUpdate:modelValue": e[0] || (e[0] = (D) => o.value.boolPrintWarehousing = D) }, { default: a(() => [r(f, { value: true }, { default: a(() => e[4] || (e[4] = [_("是")])), _: 1, __: [4] }), r(f, { value: false }, { default: a(() => e[5] || (e[5] = [_("否")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[h, s.value]])]), _: 1 });
  };
} }, Y = M(H, [["__scopeId", "data-v-37098a1d"]]);
export {
  Y as default
};
