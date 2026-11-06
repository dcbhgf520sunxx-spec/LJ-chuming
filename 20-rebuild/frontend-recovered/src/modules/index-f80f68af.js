import { _ as k, i as I, b as O, V as r } from "../shared/runtime.js";
import { u as w } from "./use-users-4d979987.js";
import { ref as i } from "vue";
import { watch as y } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as A } from "vue";
import { createBlock as C } from "vue";
import { unref as L } from "vue";
const S = { __name: "index", props: { placeholder: { type: String, default: "请选择人员" }, multiple: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabledValue: { type: Array, default: () => [] }, size: { type: String, default: "default" }, modelValue: { type: [Number, Array] } }, emits: ["change", "update:modelValue"], setup(o, { expose: _, emit: b }) {
  const p = b, f = i([]), m = o, d = i([]), g = i([]), s = i([]), { loaded: V, users: n } = w();
  y(() => m.modelValue, (a) => {
    d.value = a, h(a);
  }, { immediate: true }), y(n, (a) => {
    x(), f.value = g.value;
  }, { immediate: true, deep: true });
  function h(a) {
    p("update:modelValue", a);
    const e = v(a);
    I(e) && p("change", e);
  }
  function v(a) {
    if (!O(s.value)) if (a instanceof Array) {
      const e = new Array(3), t = [...a];
      return s.value.forEach((l) => {
        const c = t.indexOf(l.oaUserId);
        c > -1 && (e[c] = r(l));
      }), e;
    } else {
      let e;
      for (const t of s.value) if (t.oaUserId === a) {
        e = r(t);
        break;
      }
      return e;
    }
  }
  function x() {
    let a = [];
    try {
      s.value = r(n.value), a = B(r(n.value));
    } catch (e) {
      console.log("获取所有用户-下拉列表", e);
    } finally {
      g.value = a;
    }
  }
  function B(a) {
    const e = [], t = [];
    return a.forEach((l, c) => {
      const u = l.deptName;
      t.indexOf(u) === -1 && (t.push(u), e.push({ id: -t.length, label: u, options: [] }));
      const U = { id: l.oaUserId, label: l.name };
      e[t.indexOf(u)].options.push(U);
    }), e || [];
  }
  return _({ getUser: v, users: n }), (a, e) => {
    const t = z("common-select-v2");
    return A(), C(t, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => d.value = l), options: f.value, size: o.size, multiple: o.multiple, "collapse-tags": o.collapseTags, loading: !L(V), filterable: "", dataStructure: { key: "id", label: "label", value: "id", children: "options" }, disabledVal: m.disabledValue, placeholder: o.placeholder, onChange: h }, null, 8, ["modelValue", "options", "size", "multiple", "collapse-tags", "loading", "disabledVal", "placeholder"]);
  };
} }, D = k(S, [["__scopeId", "data-v-8cb6e387"]]);
export {
  D as u
};
