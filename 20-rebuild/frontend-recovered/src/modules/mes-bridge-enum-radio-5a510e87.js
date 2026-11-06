import { m as g, fa as o } from "../shared/runtime.js";
import { ref as m } from "vue";
import { watch as r } from "vue";
import { onMounted as E } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as M } from "vue";
const U = { __name: "mes-bridge-enum-radio", props: { modelValue: { type: [Number, String, Array] } }, emits: ["update:modelValue", "change"], setup(l, { expose: c, emit: i }) {
  const { user: n } = g(["user"]);
  console.log(":user", n.value);
  const s = i, p = l, t = m([]), u = m(void 0);
  r(() => n.value, () => {
    t.value = [];
    for (const e in o.ENUM) n.value.mesProductEnum.includes(o.ENUM[e].V) && t.value.push(o.ENUM[e]);
  }, { deep: true }), r(() => p.modelValue, (e) => {
    u.value = e;
  }, { immediate: true }), E(() => {
    for (const e in o.ENUM) n.value.mesProductEnum.includes(o.ENUM[e].V) && t.value.push(o.ENUM[e]);
  });
  function d(e) {
    s("update:modelValue", e), s("change", e);
  }
  return c({ mesProductOption: t.value }), (e, a) => {
    const f = V("common-radio-button");
    return _(), M(f, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (v) => u.value = v), options: t.value, type: "enum", class: "filter-item", onChange: d }, null, 8, ["modelValue", "options"]);
  };
} };
export {
  U as _
};
