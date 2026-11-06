import { inject as D } from "vue";
import { ref as n } from "vue";
import { computed as f } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as m } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as _ } from "vue";
import { unref as t } from "vue";
import { createVNode as u } from "vue";
import { ElRadioGroup as B } from "element-plus";
import { toDisplayString as w } from "vue";
import { ElNotification as T } from "element-plus";
import { ElRadio as j } from "element-plus";
import { ElFormItem as k } from "element-plus";
import { ElForm as S } from "element-plus";
import { ElCard as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { H as I, I as W } from "../../../../../modules/base-6bc46ddf.js";
import { d as G, fp as d, V as H } from "../../../../../shared/runtime.js";
const J = { class: "clearfix" }, Y = { __name: "raw-material-loss-formula", setup(K) {
  const L = D("permission"), l = n({ rawMaterialLossEnum: void 0 }), e = n(l.value), i = n(false), r = n(false), E = f(() => G(e.value, l.value)), M = f(() => i.value || r.value);
  N(() => {
    y();
  });
  async function y() {
    i.value = true;
    try {
      const o = await I() || {};
      e.value = { rawMaterialLossEnum: o }, l.value = { rawMaterialLossEnum: o };
    } catch (o) {
      console.log("原料损耗公式", o);
    } finally {
      i.value = false;
    }
  }
  async function g() {
    r.value = true;
    try {
      await W(e.value), T({ title: "原料损耗公式配置成功", type: "success", duration: 2500 }), l.value = H(e.value);
    } catch (o) {
      console.log("原料损耗公式配置", o);
    } finally {
      r.value = false;
    }
  }
  return (o, s) => {
    const V = U("common-tip-button"), p = j, F = k, O = S, R = q, h = A("permission"), x = z;
    return m(), c(R, { shadow: "always" }, { header: a(() => [v("div", J, [s[2] || (s[2] = v("span", { class: "card-title" }, "原料损耗公式", -1)), b((m(), c(V, { loading: r.value, disabled: E.value, "show-tip": "", size: "mini", type: "primary", style: { float: "right" }, onClick: g }, { default: a(() => s[1] || (s[1] = [_(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[h, t(L).rawMaterialLossFormulaEdit]])])]), default: a(() => [b((m(), c(O, { model: e.value, disabled: M.value, "label-width": "20px" }, { default: a(() => [u(F, { label: "", prop: "type" }, { default: a(() => [u(t(B), { modelValue: e.value.rawMaterialLossEnum, "onUpdate:modelValue": s[0] || (s[0] = (C) => e.value.rawMaterialLossEnum = C) }, { default: a(() => [u(p, { label: t(d).FORMULA_ONE.V }, { default: a(() => [_(w(t(d).FORMULA_ONE.L), 1)]), _: 1 }, 8, ["label"]), u(p, { label: t(d).FORMULA_TWO.V }, { default: a(() => [_(w(t(d).FORMULA_TWO.L), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[x, i.value]])]), _: 1 });
  };
} };
export {
  Y as default
};
