import { _ as w, i as z, b as A, V as u } from "../shared/runtime.js";
import { u as C } from "./use-users-4d979987.js";
import { ref as r } from "vue";
import { watch as y } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as O } from "vue";
import { createBlock as S } from "vue";
import { unref as U } from "vue";
const I = { __name: "index", props: { placeholder: { type: String, default: "请选择人员" }, multiple: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabledValue: { type: Array, default: () => [] }, size: { type: String, default: "default" }, modelValue: { type: [Number, Array] } }, emits: ["change", "update:modelValue"], setup(o, { expose: _, emit: b }) {
  const p = b, f = r([]), m = o, d = r([]), g = r([]), s = r([]), { loaded: V, users: n } = C();
  y(() => m.modelValue, (a) => {
    d.value = a, h(a);
  }, { immediate: true }), y(n, (a) => {
    x(), f.value = g.value;
  }, { immediate: true, deep: true });
  function h(a) {
    p("update:modelValue", a);
    const e = v(a);
    z(e) && p("change", e);
  }
  function v(a) {
    if (!A(s.value)) if (a instanceof Array) {
      const e = new Array(3), t = [...a];
      return s.value.forEach((l) => {
        const c = t.indexOf(l.id);
        c > -1 && (e[c] = u(l));
      }), e;
    } else {
      let e;
      for (const t of s.value) if (t.id === a) {
        e = u(t);
        break;
      }
      return e;
    }
  }
  function x() {
    let a = [];
    try {
      s.value = u(n.value), a = B(u(n.value));
    } catch (e) {
      console.log("获取所有用户-下拉列表", e);
    } finally {
      g.value = a;
    }
  }
  function B(a) {
    const e = [], t = [];
    return a.forEach((l, c) => {
      const i = l.deptName;
      t.indexOf(i) === -1 && (t.push(i), e.push({ id: -t.length, label: i, options: [] }));
      const k = { id: l.id, label: l.name };
      e[t.indexOf(i)].options.push(k);
    }), e || [];
  }
  return _({ getUser: v, users: n }), (a, e) => {
    const t = L("common-select-v2");
    return O(), S(t, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => d.value = l), options: f.value, size: o.size, multiple: o.multiple, "collapse-tags": o.collapseTags, loading: !U(V), filterable: "", dataStructure: { key: "id", label: "label", value: "id", children: "options" }, disabledVal: m.disabledValue, placeholder: o.placeholder, onChange: h }, null, 8, ["modelValue", "options", "size", "multiple", "collapse-tags", "loading", "disabledVal", "placeholder"]);
  };
} }, D = w(I, [["__scopeId", "data-v-98a28d37"]]);
export {
  D as u
};
