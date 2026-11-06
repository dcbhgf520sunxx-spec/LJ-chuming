import { inject as I } from "vue";
import { ref as m } from "vue";
import { computed as v } from "vue";
import { onMounted as P } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as y } from "vue";
import { createTextVNode as n } from "vue";
import { unref as l } from "vue";
import { createVNode as s } from "vue";
import { ElRadioGroup as L } from "element-plus";
import { ElNotification as T } from "element-plus";
import { ElRadio as j } from "element-plus";
import { ElFormItem as k } from "element-plus";
import { ElForm as U } from "element-plus";
import { ElCard as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { u as F, v as G } from "../../../../../modules/base-6bc46ddf.js";
import { d as H, fl as c, V as K } from "../../../../../shared/runtime.js";
const M = { class: "clearfix" }, X = { __name: "machine-part-scheduling-config", setup(W) {
  const b = I("permission"), i = m({ type: void 0 }), t = m(i.value), u = m(false), d = m(false), g = v(() => H(t.value, i.value)), V = v(() => u.value || d.value);
  P(() => {
    E();
  });
  async function E() {
    u.value = true;
    try {
      const o = await F();
      t.value = { type: o }, i.value = { type: o };
    } catch (o) {
      console.log("获取零件排产配置", o);
    } finally {
      u.value = false;
    }
  }
  async function w() {
    d.value = true;
    try {
      await G(t.value), T({ title: "零件排产配置成功", type: "success", duration: 2500 }), i.value = K(t.value);
    } catch (o) {
      console.log("设置零件排产配置", o);
    } finally {
      d.value = false;
    }
  }
  return (o, e) => {
    const N = h("common-tip-button"), r = j, O = k, x = U, C = q, D = B("permission"), R = z;
    return p(), f(C, { shadow: "always" }, { header: a(() => [_("div", M, [e[2] || (e[2] = _("span", { class: "card-title" }, "零件排产车间、产线、生产组配置", -1)), y((p(), f(N, { loading: d.value, disabled: g.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [n(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[D, l(b).machinePartSchedulingEdit]])])]), default: a(() => [y((p(), f(x, { model: t.value, disabled: V.value, "label-width": "100px" }, { default: a(() => [s(O, { label: "显示层级", prop: "type" }, { default: a(() => [s(l(L), { modelValue: t.value.type, "onUpdate:modelValue": e[0] || (e[0] = (S) => t.value.type = S) }, { default: a(() => [s(r, { value: l(c).NO.V }, { default: a(() => e[3] || (e[3] = [n("无")])), _: 1, __: [3] }, 8, ["value"]), s(r, { value: l(c).WORKSHOP.V }, { default: a(() => e[4] || (e[4] = [n("车间级")])), _: 1, __: [4] }, 8, ["value"]), s(r, { value: l(c).PRODUCTION_LINE.V }, { default: a(() => e[5] || (e[5] = [n("产线级")])), _: 1, __: [5] }, 8, ["value"]), s(r, { value: l(c).GROUPS.V }, { default: a(() => e[6] || (e[6] = [n("生产组级")])), _: 1, __: [6] }, 8, ["value"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[R, u.value]])]), _: 1 });
  };
} };
export {
  X as default
};
