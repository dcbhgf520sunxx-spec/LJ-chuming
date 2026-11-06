import { inject as L } from "vue";
import { ref as i } from "vue";
import { computed as p } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as c } from "vue";
import { unref as v } from "vue";
import { createVNode as d } from "vue";
import { ElRadioGroup as k } from "element-plus";
import { ElNotification as R } from "element-plus";
import { ElRadio as h } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as F } from "element-plus";
import { vLoading as M } from "element-plus";
import { L as G, M as I } from "../../../../../modules/base-6bc46ddf.js";
import { d as O, V as U } from "../../../../../shared/runtime.js";
const A = { class: "clearfix" }, W = { __name: "steel-bind-config", setup(H) {
  const y = L("permission"), o = i({ steelPlateType: void 0 }), t = i(o.value), s = i(false), n = i(false), b = p(() => O(t.value, o.value)), g = p(() => s.value || n.value);
  N(() => {
    T();
  });
  async function T() {
    s.value = true;
    try {
      const { steelPlateType: l = false } = await G();
      t.value = { steelPlateType: l }, o.value = { steelPlateType: l };
    } catch (l) {
      console.log("获取绑定钢板配置", l);
    } finally {
      s.value = false;
    }
  }
  async function w() {
    n.value = true;
    try {
      await I(t.value), R({ title: "绑定钢板配置成功", type: "success", duration: 2500 }), o.value = U(t.value);
    } catch (l) {
      console.log("设置绑定钢板配置", l);
    } finally {
      n.value = false;
    }
  }
  return (l, e) => {
    const E = S("common-tip-button"), m = h, V = q, x = z, C = F, B = j("permission"), D = M;
    return r(), u(C, { shadow: "always" }, { header: a(() => [f("div", A, [e[2] || (e[2] = f("span", { class: "card-title" }, "钢板绑定配置", -1)), _((r(), u(E, { loading: n.value, disabled: b.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[B, v(y).steelBindConfigEdit]])])]), default: a(() => [_((r(), u(x, { model: t.value, disabled: g.value, "label-width": "100px" }, { default: a(() => [d(V, { label: "是否绑定钢板", prop: "steelPlateType" }, { default: a(() => [d(v(k), { modelValue: t.value.steelPlateType, "onUpdate:modelValue": e[0] || (e[0] = (P) => t.value.steelPlateType = P) }, { default: a(() => [d(m, { value: true }, { default: a(() => e[3] || (e[3] = [c("是")])), _: 1, __: [3] }), d(m, { value: false }, { default: a(() => e[4] || (e[4] = [c("否")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[D, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
