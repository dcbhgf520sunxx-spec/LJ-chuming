import { inject as k } from "vue";
import { ref as n } from "vue";
import { computed as m } from "vue";
import { onMounted as F } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as c } from "vue";
import { unref as p } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as h } from "element-plus";
import { ElNotification as q } from "element-plus";
import { ElRadio as z } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElForm as T } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as I } from "element-plus";
import { n as M, o as O } from "../../../../../modules/base-6bc46ddf.js";
import { d as U, V as A } from "../../../../../shared/runtime.js";
const H = { class: "clearfix" }, W = { __name: "driver-fill-config", setup(J) {
  const g = k("permission"), l = n({ configure: void 0 }), o = n(l.value), s = n(false), i = n(false), b = m(() => U(o.value, l.value)), y = m(() => s.value || i.value);
  F(() => {
    w();
  });
  async function w() {
    s.value = true;
    try {
      const { configure: t = false } = await M();
      o.value = { configure: t }, l.value = { configure: t };
    } catch (t) {
      console.log("获取物流信息填写配置", t);
    } finally {
      s.value = false;
    }
  }
  async function C() {
    i.value = true;
    try {
      await O(o.value), q({ title: "物流信息配置成功", type: "success", duration: 2500 }), l.value = A(o.value);
    } catch (t) {
      console.log("设置物流信息配置", t);
    } finally {
      i.value = false;
    }
  }
  return (t, e) => {
    const E = L("common-tip-button"), f = z, V = S, D = T, x = G, B = R("permission"), N = I;
    return u(), d(x, { shadow: "always" }, { header: a(() => [v("div", H, [e[2] || (e[2] = v("span", { class: "card-title" }, "物流信息填写配置", -1)), _((u(), d(E, { loading: i.value, disabled: b.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: a(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[B, p(g).driverFillConfigEdit]])])]), default: a(() => [_((u(), d(D, { model: o.value, disabled: y.value, "label-width": "100px" }, { default: a(() => [r(V, { label: "选择配置", prop: "configure" }, { default: a(() => [r(p(h), { modelValue: o.value.configure, "onUpdate:modelValue": e[0] || (e[0] = (j) => o.value.configure = j) }, { default: a(() => [r(f, { value: false }, { default: a(() => e[3] || (e[3] = [c("装车时填写")])), _: 1, __: [3] }), r(f, { value: true }, { default: a(() => e[4] || (e[4] = [c("过磅时填写")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[N, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
