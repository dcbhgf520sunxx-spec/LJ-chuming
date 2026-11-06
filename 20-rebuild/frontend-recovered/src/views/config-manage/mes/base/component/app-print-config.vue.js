import { inject as j } from "vue";
import { ref as i } from "vue";
import { computed as m } from "vue";
import { onMounted as k } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as c } from "vue";
import { unref as v } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as R } from "element-plus";
import { ElNotification as h } from "element-plus";
import { ElRadio as q } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as S } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as I, d as M } from "../../../../../modules/base-6bc46ddf.js";
import { d as O, V as U } from "../../../../../shared/runtime.js";
const A = { class: "clearfix" }, W = { __name: "app-print-config", setup(H) {
  const b = j("permission"), l = i({ enclosureType: void 0 }), o = i(l.value), s = i(false), n = i(false), y = m(() => O(o.value, l.value)), g = m(() => s.value || n.value);
  k(() => {
    w();
  });
  async function w() {
    s.value = true;
    try {
      const { enclosureType: t } = await I();
      o.value = { enclosureType: t }, l.value = { enclosureType: t };
    } catch (t) {
      console.log("获取移动端打印配置", t);
    } finally {
      s.value = false;
    }
  }
  async function C() {
    n.value = true;
    try {
      await M(o.value), h({ title: "移动端打印配置成功", type: "success", duration: 2500 }), l.value = U(o.value);
    } catch (t) {
      console.log("设置移动端打印配置", t);
    } finally {
      n.value = false;
    }
  }
  return (t, e) => {
    const E = L("common-tip-button"), p = q, V = z, T = F, x = S, D = P("permission"), B = G;
    return u(), d(x, { shadow: "always" }, { header: a(() => [f("div", A, [e[2] || (e[2] = f("span", { class: "card-title" }, "移动端打印配置", -1)), _((u(), d(E, { loading: n.value, disabled: y.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: a(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[D, v(b).appPrintConfigEdit]])])]), default: a(() => [_((u(), d(T, { model: o.value, disabled: g.value, "label-width": "100px" }, { default: a(() => [r(V, { label: "围护", prop: "enclosureType" }, { default: a(() => [r(v(R), { modelValue: o.value.enclosureType, "onUpdate:modelValue": e[0] || (e[0] = (N) => o.value.enclosureType = N) }, { default: a(() => [r(p, { value: 1 }, { default: a(() => e[3] || (e[3] = [c("基础型")])), _: 1, __: [3] }), r(p, { value: 2 }, { default: a(() => e[4] || (e[4] = [c("极简型")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[B, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
