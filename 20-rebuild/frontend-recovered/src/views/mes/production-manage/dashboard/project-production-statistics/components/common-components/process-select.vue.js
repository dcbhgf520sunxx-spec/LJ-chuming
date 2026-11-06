import { a as d } from "../../../../../../../modules/project-production-statistics-850038ba.js";
import { computed as i } from "vue";
import { inject as f } from "vue";
import { ref as y } from "vue";
import { watchEffect as v } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as g } from "vue";
import { createBlock as P } from "vue";
import { mergeProps as I } from "vue";
import "../../../../../../../shared/runtime.js";
const T = { __name: "process-select", props: ["productType", "processId"], emits: ["update:processId"], setup(a, { emit: r }) {
  const s = a, p = r, t = i({ get() {
    return s.processId;
  }, set(e) {
    p("update:processId", e);
  } }), n = f("commonQuery"), c = y([]), l = async () => {
    const e = { ...n, productType: s.productType }, { content: o = [] } = await d(e);
    c.value = o;
  };
  return v(() => {
    l();
  }), (e, o) => {
    const m = _("common-select");
    return g(), P(m, I({ modelValue: t.value, "onUpdate:modelValue": o[0] || (o[0] = (u) => t.value = u), options: c.value, "data-structure": { key: "id", label: "processName", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择工序" }, e.$attrs), null, 16, ["modelValue", "options"]);
  };
} };
export {
  T as default
};
