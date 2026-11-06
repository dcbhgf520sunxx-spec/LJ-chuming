import { inject as k } from "vue";
import { ref as i } from "vue";
import { computed as p } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as d } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as c } from "vue";
import { unref as v } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as h } from "element-plus";
import { ElNotification as q } from "element-plus";
import { ElRadio as z } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElForm as T } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as I } from "element-plus";
import { l as M, m as O } from "../../../../../modules/base-6bc46ddf.js";
import { d as U, V as A } from "../../../../../shared/runtime.js";
const H = { class: "clearfix" }, W = { __name: "drawing-sn-config", setup(J) {
  const g = k("permission"), l = i({ type: void 0 }), o = i(l.value), s = i(false), n = i(false), b = p(() => U(o.value, l.value)), y = p(() => s.value || n.value);
  L(() => {
    w();
  });
  async function w() {
    s.value = true;
    try {
      const { type: t = null } = await M() || {};
      o.value = { type: t }, l.value = { type: t };
    } catch (t) {
      console.log("获取图纸识别规则配置", t);
    } finally {
      s.value = false;
    }
  }
  async function C() {
    n.value = true;
    try {
      await O(o.value), q({ title: "图纸识别规则配置成功", type: "success", duration: 2500 }), l.value = A(o.value);
    } catch (t) {
      console.log("设置图纸识别规则配置", t);
    } finally {
      n.value = false;
    }
  }
  return (t, e) => {
    const E = R("common-tip-button"), m = z, V = F, D = T, x = G, N = S("permission"), B = I;
    return d(), u(x, { shadow: "always" }, { header: a(() => [f("div", H, [e[2] || (e[2] = f("span", { class: "card-title" }, "图纸识别规则配置", -1)), _((d(), u(E, { loading: n.value, disabled: b.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: a(() => e[1] || (e[1] = [c(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[N, v(g).drawingSNConfigEdit]])])]), default: a(() => [_((d(), u(D, { model: o.value, disabled: y.value, "label-width": "100px" }, { default: a(() => [r(V, { label: "选择配置", prop: "type" }, { default: a(() => [r(v(h), { modelValue: o.value.type, "onUpdate:modelValue": e[0] || (e[0] = (j) => o.value.type = j) }, { default: a(() => [r(m, { value: 1 }, { default: a(() => e[3] || (e[3] = [c("构件号")])), _: 1, __: [3] }), r(m, { value: 2 }, { default: a(() => e[4] || (e[4] = [c("图号 + 构件号")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[B, s.value]])]), _: 1 });
  };
} };
export {
  W as default
};
