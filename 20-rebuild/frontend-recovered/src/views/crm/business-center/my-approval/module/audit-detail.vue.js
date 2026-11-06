import { u as d } from "../../../../../shared/runtime.js";
import { resolveComponent as i } from "vue";
import { openBlock as p } from "vue";
import { createBlock as c } from "vue";
import { withCtx as f } from "vue";
import { unref as l } from "vue";
import { isRef as V } from "vue";
const v = { __name: "audit-detail", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue"], setup(s, { emit: t }) {
  const a = s, n = t, { visible: o, handleClose: m } = d({ emit: n, props: a });
  return (_, e) => {
    const r = i("common-drawer");
    return p(), c(r, { modelValue: l(o), "onUpdate:modelValue": e[0] || (e[0] = (u) => V(o) ? o.value = u : null), "close-on-click-modal": false, "before-close": l(m) }, { content: f(() => e[1] || (e[1] = [])), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  v as default
};
