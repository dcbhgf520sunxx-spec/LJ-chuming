import { ref as f } from "vue";
import { watch as h } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as v } from "vue";
import { createElementBlock as x } from "vue";
import { Fragment as V } from "vue";
import { renderList as k } from "vue";
import { unref as A } from "vue";
import { ElOption as C } from "element-plus";
import { ElOptionGroup as L } from "element-plus";
import { ElSelect as U } from "element-plus";
import { _ as I, i as N, b as T, V as c } from "../shared/runtime.js";
import { u as F } from "./use-users-4d979987.js";
const D = { __name: "index", props: { placeholder: { type: String, default: "请选择人员" }, multiple: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabledValue: { type: Array, default: () => [] }, size: { type: String, default: "default" }, modelValue: { type: [Number, Array] } }, emits: ["change", "update:modelValue"], setup(n, { expose: B, emit: E }) {
  const _ = E, O = n, p = f([]), b = f([]), i = f([]), { loaded: w, users: r } = F();
  h(() => O.modelValue, (l) => {
    p.value = l, y(l);
  }, { immediate: true }), h(r, (l) => {
    S();
  }, { immediate: true, deep: true });
  function y(l) {
    _("update:modelValue", l);
    const e = g(l);
    N(e) && _("change", e);
  }
  function g(l) {
    if (!T(i.value)) if (l instanceof Array) {
      const e = new Array(3), a = [...l];
      return i.value.forEach((o) => {
        const t = a.indexOf(o.id);
        t > -1 && (e[t] = c(o));
      }), e;
    } else {
      let e;
      for (const a of i.value) if (a.id === l) {
        e = c(a);
        break;
      }
      return e;
    }
  }
  function S() {
    let l = [];
    try {
      i.value = c(r.value), l = z(c(r.value));
    } catch (e) {
      console.log("获取所有用户-下拉列表", e);
    } finally {
      b.value = l;
    }
  }
  function z(l) {
    const e = [], a = [];
    return l.forEach((o) => {
      const t = o.deptName;
      a.indexOf(t) === -1 && (a.push(t), e.push({ label: t, options: [] }));
      const s = { id: o.id, label: o.name };
      e[a.indexOf(t)].options.push(s);
    }), e || [];
  }
  return B({ getUser: g, users: r }), (l, e) => {
    const a = C, o = L, t = U;
    return u(), m(t, { modelValue: p.value, "onUpdate:modelValue": e[0] || (e[0] = (s) => p.value = s), size: n.size, multiple: n.multiple, "collapse-tags": n.collapseTags, loading: !A(w), filterable: "", placeholder: n.placeholder, onChange: y }, { default: v(() => [(u(true), x(V, null, k(b.value, (s) => (u(), m(o, { key: s.label, label: s.label }, { default: v(() => [(u(true), x(V, null, k(s.options, (d) => (u(), m(a, { key: d.id, label: d.label, disabled: n.disabledValue.includes(d.id), value: d.id }, null, 8, ["label", "disabled", "value"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "multiple", "collapse-tags", "loading", "placeholder"]);
  };
} }, X = I(D, [["__scopeId", "data-v-e969955d"]]);
export {
  X as u
};
