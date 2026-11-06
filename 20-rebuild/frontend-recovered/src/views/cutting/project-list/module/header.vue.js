import { B as p, lW as f, C as _, E as h } from "../../../../shared/runtime.js";
import { ref as a } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as t } from "vue";
import { withCtx as E } from "vue";
import { unref as n } from "vue";
const g = { class: "head-container" }, B = { __name: "header", emits: ["change"], setup(V, { emit: s }) {
  const u = { projectName: void 0, thick: void 0, online: void 0 }, { CRUD: r } = p(u), e = a(0), l = a(""), m = s;
  r.HOOK.beforeResetQuery = () => {
    l.value = "";
  };
  function c() {
    m("change", e.value);
  }
  return (b, o) => {
    const d = v("common-radio-button");
    return y(), C("div", g, [t(n(h), null, { optLeft: E(() => [t(d, { modelValue: e.value, "onUpdate:modelValue": o[0] || (o[0] = (i) => e.value = i), options: n(f).ENUM, size: "default", default: "", class: "filter-item", type: "enum", onChange: c }, null, 8, ["modelValue", "options"]), t(n(_))]), _: 1 })]);
  };
} };
export {
  B as default
};
