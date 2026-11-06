import { ref as s } from "vue";
import { watch as w } from "vue";
import { watchEffect as c } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as q } from "vue";
import { withCtx as N } from "vue";
import { createTextVNode as B } from "vue";
import { createElementVNode as i } from "vue";
import { ElCheckbox as E } from "element-plus";
import { _ as F, i as d } from "../shared/runtime.js";
const O = { class: "review-convenient-operate-container" }, R = { __name: "review-convenient-operate", props: { modelValue: { type: [Number, String] }, currentIndex: { type: Number, default: 0 }, list: { type: Array, default: () => [] }, consequent: { type: Boolean, default: false }, prev: { type: Function }, next: { type: Function } }, emits: ["change", "prev", "next", "blank", "update:modelValue", "update:currentIndex", "update:consequent"], setup(v, { expose: p, emit: f }) {
  const u = f, n = v, o = s(), e = s(0), r = s(false), l = s([]);
  w(() => n.modelValue, () => {
    if (n.modelValue !== o.value) {
      const t = n.list.findIndex((a) => n.modelValue === a);
      o.value = n.modelValue, e.value = t;
    }
  }, { immediate: true }), c(() => {
    l.value = n.list;
  }), c(() => {
    n.currentIndex && (e.value = n.currentIndex);
  }), c(() => {
    r.value = n.consequent;
  }), c(() => m());
  function m() {
    const t = l.value;
    if (d(e.value) && d(t)) {
      const a = t.length;
      e.value < a ? o.value = t[e.value] : e.value = 0;
    } else o.value = void 0, e.value = 0, u("blank");
    _(e.value), x(o.value);
  }
  function x(t) {
    n.modelValue !== t && (u("update:modelValue", t), u("change", t));
  }
  function _(t) {
    n.currentIndex !== t && u("update:currentIndex", t);
  }
  function h(t) {
    t !== n.consequent && u("update:consequent", t);
  }
  function V() {
    typeof n.prev == "function" && n.prev(), --e.value < 0 && (e.value = l.value.length - 1), u("prev", e.value);
  }
  function g() {
    typeof n.next == "function" && n.next(), ++e.value > l.value.length - 1 && (e.value = 0), u("next", e.value);
  }
  function C() {
    l.value.length > 0 && (l.value.splice(e.value, 1), e.value >= l.value.length - 1 && (e.value = 0));
  }
  return p({ removeCurrent: C }), (t, a) => {
    const y = E;
    return I(), b("span", O, [q(y, { modelValue: r.value, "onUpdate:modelValue": a[0] || (a[0] = (k) => r.value = k), size: "default", onChange: h }, { default: N(() => a[1] || (a[1] = [B("连续审核")])), _: 1, __: [1] }, 8, ["modelValue"]), i("span", { class: "prev-text", onClick: V }, " 上一条 "), i("span", { class: "next-text", onClick: g }, " 下一条 ")]);
  };
} }, A = F(R, [["__scopeId", "data-v-ed18ecc5"]]);
export {
  A as R
};
