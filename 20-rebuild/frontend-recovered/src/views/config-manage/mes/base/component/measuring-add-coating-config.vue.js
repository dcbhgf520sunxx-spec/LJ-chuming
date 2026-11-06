import { inject as R } from "vue";
import { ref as i } from "vue";
import { computed as f } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as m } from "vue";
import { unref as d } from "vue";
import { createVNode as u } from "vue";
import { ElRadioGroup as M } from "element-plus";
import { ElNotification as h } from "element-plus";
import { ElRadio as q } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as I } from "element-plus";
import { b as S, w as H } from "../../../../../modules/base-6bc46ddf.js";
import { d as O, aT as g, V as Q } from "../../../../../shared/runtime.js";
const U = { class: "clearfix" }, X = { __name: "measuring-add-coating-config", setup(W) {
  const y = R("permission"), s = i({ type: void 0 }), t = i(s.value), l = i(false), n = i(false), b = f(() => O(t.value, s.value)), C = f(() => l.value || n.value);
  j(() => {
    E();
  });
  async function E() {
    l.value = true;
    try {
      const o = await S() || {};
      t.value = { type: o }, s.value = { type: o };
    } catch (o) {
      console.log("创建涂装配置方式", o);
    } finally {
      l.value = false;
    }
  }
  async function w() {
    n.value = true;
    try {
      await H(t.value), h({ title: "创建涂装配置方式成功", type: "success", duration: 2500 }), s.value = Q(t.value);
    } catch (o) {
      console.log("创建涂装配置方式", o);
    } finally {
      n.value = false;
    }
  }
  return (o, e) => {
    const V = k("common-tip-button"), p = q, x = z, T = F, D = G, A = L("permission"), B = I;
    return r(), c(D, { shadow: "always" }, { header: a(() => [v("div", U, [e[2] || (e[2] = v("span", { class: "card-title" }, "创建涂装配置方式", -1)), _((r(), c(V, { loading: n.value, disabled: b.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [m(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[A, d(y).coatingCreateTypeConfigEdit]])])]), default: a(() => [_((r(), c(T, { model: t.value, disabled: C.value, "label-width": "100px" }, { default: a(() => [u(x, { label: "选择配置", prop: "type" }, { default: a(() => [u(d(M), { modelValue: t.value.type, "onUpdate:modelValue": e[0] || (e[0] = (N) => t.value.type = N) }, { default: a(() => [u(p, { value: d(g).WEIGHT.V }, { default: a(() => e[3] || (e[3] = [m("按重量计")])), _: 1, __: [3] }, 8, ["value"]), u(p, { value: d(g).AREA.V }, { default: a(() => e[4] || (e[4] = [m("按面积计")])), _: 1, __: [4] }, 8, ["value"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[B, l.value]])]), _: 1 });
  };
} };
export {
  X as default
};
