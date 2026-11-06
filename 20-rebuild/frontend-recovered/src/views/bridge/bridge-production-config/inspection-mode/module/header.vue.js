import { aD as t, B as s } from "../../../../../shared/runtime.js";
import { resolveComponent as d } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { unref as e } from "vue";
const _ = { __name: "header", setup(l) {
  const r = { productType: t.BOX.V, inspectType: void 0, reportType: void 0, name: void 0 }, { crud: p, query: o } = s(r);
  return (i, n) => {
    const a = d("component-radio-button");
    return c(), m(a, { modelValue: e(o).productType, "onUpdate:modelValue": n[0] || (n[0] = (u) => e(o).productType = u), options: e(t).ENUM, class: "filter-item", type: "enum", size: "default", onChange: e(p).toQuery }, null, 8, ["modelValue", "options", "onChange"]);
  };
} };
export {
  _ as default
};
