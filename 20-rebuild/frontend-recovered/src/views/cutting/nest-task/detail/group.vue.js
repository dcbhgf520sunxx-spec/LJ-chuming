import { ref as S } from "vue";
import { watchEffect as h } from "vue";
import { openBlock as u } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as V } from "vue";
import { renderList as x } from "vue";
import { renderSlot as k } from "vue";
import { unref as A } from "vue";
import { ElRadioGroup as w } from "element-plus";
import { ElRadioButton as N } from "element-plus";
import { i as b } from "../../../../shared/runtime.js";
const C = { __name: "group", props: { modelValue: [Number, String, Boolean, void 0], size: { type: String, default: "default" }, options: { type: [Object, Array, Number], required: true }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, disabledVal: { type: Array, default: () => [] }, unshowVal: { type: Array, default: () => [] }, type: { type: String, default: "other" }, value: { type: String, default: "" }, showOptionAll: { type: Boolean, default: false }, optionAllValue: { type: [Number, String, Boolean], default: -999999999 }, dataStructure: { type: Object } }, emits: ["change", "update:modelValue"], setup(e, { expose: g, emit: B }) {
  const f = B, l = e, o = S();
  h(() => {
    o.value = b(l.modelValue) ? l.modelValue : -999999999, v();
  });
  function d(a) {
    a === -999999999 && (a = void 0), a !== l.modelValue && (f("update:modelValue", a), f("change", a));
  }
  function v() {
    if (l.default && o.value === -999999999 && b(l.options)) for (const a in l.options) {
      o.value = l.options[a], d(o.value);
      return;
    }
  }
  return g({ selectChange: d }), (a, n) => {
    const p = N;
    return u(), s(A(w), { style: { "font-size": "15px" }, class: "inline-block", modelValue: o.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => o.value = t), size: e.size, disabled: e.disabled, onChange: d }, { default: i(() => [r(c(e.value) + "： ", 1), e.showOptionAll ? (u(), s(p, { key: 0, value: e.optionAllValue }, { default: i(() => n[1] || (n[1] = [r("全部")])), _: 1, __: [1] }, 8, ["value"])) : m("", true), (u(true), y(V, null, x(e.options, (t) => (u(), y(V, null, [e.unshowVal.indexOf(t) === -1 ? (u(), s(p, { key: t, value: t, disabled: e.disabledVal.indexOf(t) > -1 }, { default: i(() => [r(c(t), 1), k(a.$slots, "suffix", { item: t })]), _: 2 }, 1032, ["value", "disabled"])) : m("", true)], 64))), 256))]), _: 3 }, 8, ["modelValue", "size", "disabled"]);
  };
} };
export {
  C as default
};
