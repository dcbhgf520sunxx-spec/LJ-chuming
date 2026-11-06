import { a3 as t, o$ as u, B as m, C as p, E as i } from "../../../../../shared/runtime.js";
import { resolveComponent as c } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withCtx as f } from "vue";
import { unref as o } from "vue";
const x = { __name: "header", setup(E) {
  const d = { productType: t.MACHINE_PART.V, boolFixedProcess: u.YES.V }, { crud: l, query: e } = m(d);
  return (y, n) => {
    const r = c("common-radio-button");
    return V(), _("div", null, [s(o(i), null, { optRight: f(() => [s(r, { modelValue: o(e).boolFixedProcess, "onUpdate:modelValue": n[0] || (n[0] = (a) => o(e).boolFixedProcess = a), options: o(u).ENUM, type: "enum", size: "default", class: "filter-item", onChange: o(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(r, { modelValue: o(e).productType, "onUpdate:modelValue": n[1] || (n[1] = (a) => o(e).productType = a), options: o(t).ENUM, unshowVal: [o(t).ENCLOSURE.V, o(t).AUXILIARY_MATERIAL.V], type: "enum", size: "default", class: "filter-item", onChange: o(l).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), s(o(p))]), _: 1 })]);
  };
} };
export {
  x as default
};
