import { ref as m } from "vue";
import { watch as w } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as p } from "vue";
import { createElementBlock as A } from "vue";
import { Fragment as B } from "vue";
import { renderList as I } from "vue";
import { toDisplayString as E } from "vue";
import { unref as g } from "vue";
import { isRef as U } from "vue";
import { ElCheckbox as N } from "element-plus";
import { ElCheckboxGroup as R } from "element-plus";
import { u as S } from "../../../../../../shared/runtime.js";
const F = { __name: "next-process-assist-dialog", props: { visible: { type: Boolean, default: false }, modelValue: { type: Array, default: () => [] }, nextProcessList: { type: Array, default: () => [] } }, emits: ["update:visible", "update:modelValue", "next-process-assist-select-confirm"], setup(f, { emit: k }) {
  const n = k, a = f, s = m([]), i = m(false), V = m(true);
  w(() => a.modelValue, (l) => {
    s.value = l;
    const e = l.length;
    i.value = e === a.nextProcessList.length, V.value = e > 0 && e < a.nextProcessList.length;
  }, { immediate: true, deep: true });
  function v(l) {
    const e = l ? a.nextProcessList.map((d) => d.id) : [];
    n("update:modelValue", e);
  }
  function h(l) {
    n("update:modelValue", l);
  }
  function C() {
    n("next-process-assist-select-confirm");
  }
  const { visible: u, handleClose: y } = S({ emit: n, props: a, field: "visible" });
  return (l, e) => {
    const d = x("common-button"), b = N, L = R, P = x("common-dialog");
    return r(), _(P, { title: "后续工序是否自动协同", modelValue: g(u), "onUpdate:modelValue": e[2] || (e[2] = (t) => U(u) ? u.value = t : null), width: "640px", "before-close": g(y) }, { titleRight: o(() => [c(d, { size: "default", type: "primary", onClick: C }, { default: o(() => e[3] || (e[3] = [p(" 确 认 ")])), _: 1, __: [3] })]), default: o(() => [c(b, { modelValue: i.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => i.value = t), indeterminate: V.value, onChange: v }, { default: o(() => e[4] || (e[4] = [p(" 全 选 ")])), _: 1, __: [4] }, 8, ["modelValue", "indeterminate"]), c(L, { modelValue: s.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => s.value = t), onChange: h }, { default: o(() => [(r(true), A(B, null, I(f.nextProcessList, (t) => (r(), _(b, { key: t.id, label: t.id, value: t.id }, { default: o(() => [p(E(t.name), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  F as default
};
