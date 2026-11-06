import { ref as u } from "vue";
import { computed as k } from "vue";
import { watch as B } from "vue";
import { openBlock as w } from "vue";
import { createBlock as x } from "vue";
import { ElCascader as L } from "element-plus";
import { gu as i, gd as s } from "../shared/runtime.js";
const P = { __name: "index", props: { value: { type: [Array, Number, String], default: void 0 }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, filterable: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: true }, placeholder: { type: String, default: "请选择表格" } }, emits: ["update:value", "change"], setup(m, { emit: y }) {
  const p = y, e = m, f = u([]), r = u(void 0), h = u(false), v = k(() => ({ value: "K", label: "L", children: "children", checkStrictly: e.checkStrictly, expandTrigger: e.expandTrigger, emitPath: e.emitPath }));
  B(() => e.value, (a) => {
    e.emitPath ? r.value = e.value ? [...a] : [] : r.value = a;
  }, { immediate: true }), b();
  function g(a) {
    p("update:value", a), p("change", s[a]);
  }
  function b() {
    var c;
    h.value = true;
    const a = [], t = {};
    for (const l in i) {
      const n = i[l];
      for (const o in n.V) {
        const d = n.V[o], _ = { K: o, L: d, children: [] };
        t[o] = _;
      }
    }
    for (const l in s) t[s[l].M] && t[s[l].M].children.push({ K: l, ...s[l] });
    for (const l in i) {
      const n = i[l], o = { K: l, L: n.L, children: [] };
      for (const d in n.V) (c = t[d]) != null && c.children.length && o.children.push(t[d]);
      o.children.length && a.push(o);
    }
    f.value = a, h.value = false;
  }
  return (a, t) => {
    const c = L;
    return w(), x(c, { modelValue: r.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => r.value = l), options: f.value, props: v.value, filterable: e.filterable, clearable: e.clearable, disabled: e.disabled, "show-all-levels": e.showAllLevels, placeholder: e.placeholder, onChange: g }, null, 8, ["modelValue", "options", "props", "filterable", "clearable", "disabled", "show-all-levels", "placeholder"]);
  };
} };
export {
  P as _
};
