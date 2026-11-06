import { _ as i } from "../../../../../shared/runtime.js";
import { ref as r } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as a } from "vue";
import { normalizeClass as d } from "vue";
import { renderSlot as f } from "vue";
const k = { class: "checkbox-label" }, h = ["value"], m = { style: { "margin-left": "6px" } }, b = { __name: "TableCheckBox", props: { value: { type: [String, Number], default: void 0 }, checked: { type: Boolean, default: () => false } }, emits: ["on-click"], setup(t, { emit: c }) {
  const l = t, e = r(l.checked), o = c;
  function n() {
    e.value ? e.value = false : e.value = true, o("on-click", e.value, l.value);
  }
  return (u, s) => (_(), p("label", k, [a("span", { class: d(["checkbox-input", e.value ? "checkbox-checked" : ""]), onClick: n }, [a("input", { ref: "checkbox", type: "checkbox", value: l.value }, null, 8, h), s[0] || (s[0] = a("span", { class: "checkbox-inner" }, null, -1))], 2), a("span", m, [f(u.$slots, "default", {}, void 0, true)])]));
} }, y = i(b, [["__scopeId", "data-v-669a6fe6"]]);
export {
  y as default
};
