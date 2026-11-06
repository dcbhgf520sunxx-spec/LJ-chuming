import { inject as M } from "vue";
import { ref as d } from "vue";
import { computed as _ } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as e } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as f } from "vue";
import { unref as o } from "vue";
import { createVNode as u } from "vue";
import { ElRadioGroup as j } from "element-plus";
import { toDisplayString as b } from "vue";
import { ElNotification as z } from "element-plus";
import { ElRadio as A } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElForm as R } from "element-plus";
import { ElCard as S } from "element-plus";
import { vLoading as U } from "element-plus";
import { z as q, A as P } from "../../../../../modules/base-6bc46ddf.js";
import { d as G, fn as r, V as H } from "../../../../../shared/runtime.js";
const J = { class: "clearfix" }, Y = { __name: "nest-task-config", setup(K) {
  const E = M("permission"), l = d({ nestingTaskModeEnum: void 0 }), a = d(l.value), n = d(false), i = d(false), N = _(() => G(a.value, l.value)), T = _(() => n.value || i.value);
  L(() => {
    k();
  });
  async function k() {
    n.value = true;
    try {
      const s = await q() || {};
      a.value = { nestingTaskModeEnum: s }, l.value = { nestingTaskModeEnum: s };
    } catch (s) {
      console.log("套料任务设置", s);
    } finally {
      n.value = false;
    }
  }
  async function y() {
    i.value = true;
    try {
      await P(a.value), z({ title: "套料任务设置成功", type: "success", duration: 2500 }), l.value = H(a.value);
    } catch (s) {
      console.log("套料任务设置", s);
    } finally {
      i.value = false;
    }
  }
  return (s, t) => {
    const C = B("common-tip-button"), p = A, D = O, V = R, I = S, w = F("permission"), h = U;
    return c(), m(I, { shadow: "always" }, { header: e(() => [v("div", J, [t[2] || (t[2] = v("span", { class: "card-title" }, "套料任务设置", -1)), g((c(), m(C, { loading: i.value, disabled: N.value, "show-tip": "", size: "mini", type: "primary", style: { float: "right" }, onClick: y }, { default: e(() => t[1] || (t[1] = [f(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[w, o(E).mesNestTaskConfigEdit]])])]), default: e(() => [g((c(), m(V, { model: a.value, disabled: T.value, "label-width": "20px" }, { default: e(() => [u(D, { label: "", prop: "type" }, { default: e(() => [u(o(j), { modelValue: a.value.nestingTaskModeEnum, "onUpdate:modelValue": t[0] || (t[0] = (x) => a.value.nestingTaskModeEnum = x) }, { default: e(() => [u(p, { label: o(r).INDEPENDENT.V }, { default: e(() => [f(b(o(r).INDEPENDENT.L), 1)]), _: 1 }, 8, ["label"]), u(p, { label: o(r).UNIFICATION.V }, { default: e(() => [f(b(o(r).UNIFICATION.L), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[h, n.value]])]), _: 1 });
  };
} };
export {
  Y as default
};
