import { inject as B } from "vue";
import { ref as r } from "vue";
import { computed as v } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as u } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as m } from "vue";
import { unref as g } from "vue";
import { createVNode as s } from "vue";
import { ElRadioGroup as L } from "element-plus";
import { ElNotification as R } from "element-plus";
import { ElRadio as h } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as F } from "element-plus";
import { vLoading as S } from "element-plus";
import { D as T, E as I } from "../../../../../modules/base-6bc46ddf.js";
import { d as O, G as U, V as A } from "../../../../../shared/runtime.js";
const H = { class: "clearfix" }, X = { __name: "price-manage-config", setup(J) {
  const p = B("permission"), i = r({ priceEditMode: void 0 }), t = r(i.value), l = r(false), n = r(false), E = v(() => O(t.value, i.value)), y = v(() => l.value || n.value);
  N(() => {
    w();
  });
  async function w() {
    if (U(p.contractPriceConfigGet)) {
      l.value = true;
      try {
        const o = await T(), e = o == null ? void 0 : o.priceEditMode;
        t.value = { priceEditMode: e }, i.value = { priceEditMode: e };
      } catch (o) {
        console.log("获取价格办理方式", o);
      } finally {
        l.value = false;
      }
    }
  }
  async function C() {
    n.value = true;
    try {
      await I(t.value), R({ title: "配置成功", type: "success", duration: 2500 }), i.value = A(t.value);
    } catch (o) {
      console.log("设置价格办理方式", o);
    } finally {
      n.value = false;
    }
  }
  return (o, e) => {
    const V = j("common-tip-button"), f = h, _ = q, x = z, D = F, M = G("permission"), P = S;
    return u(), c(D, { shadow: "always" }, { header: a(() => [d("div", H, [e[2] || (e[2] = d("span", { class: "card-title" }, "价格录入办理方式", -1)), b((u(), c(V, { loading: n.value, disabled: E.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: C }, { default: a(() => e[1] || (e[1] = [m(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[M, g(p).contractPriceConfigEdit]])])]), default: a(() => [b((u(), c(x, { model: t.value, disabled: y.value, "label-width": "100px" }, { default: a(() => [s(_, { label: "办理方式", prop: "type" }, { default: a(() => [s(g(L), { modelValue: t.value.priceEditMode, "onUpdate:modelValue": e[0] || (e[0] = (k) => t.value.priceEditMode = k) }, { default: a(() => [s(f, { value: 1 }, { default: a(() => e[3] || (e[3] = [m("价格录入即审核")])), _: 1, __: [3] }), s(f, { value: 2 }, { default: a(() => e[4] || (e[4] = [m("价格录入即保存")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), s(_, { "label-width": "0" }, { default: a(() => e[5] || (e[5] = [d("span", { class: "form-item-tip" }, " 价格录入即审核：价格录入保存后，即在变更记录生成该条价格录入的审批单，审批完成则价格修改成功； ", -1), d("span", { class: "form-item-tip" }, "价格录入即保存：增加中转保存功能，录入价格的构件不会直接生成审批单， 而是在“保存记录”按钮中，对已保存的构件价格批量办理审核；", -1)])), _: 1, __: [5] })]), _: 1 }, 8, ["model", "disabled"])), [[P, l.value]])]), _: 1 });
  };
} };
export {
  X as default
};
