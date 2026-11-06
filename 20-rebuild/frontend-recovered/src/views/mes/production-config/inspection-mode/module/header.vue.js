import { dM as o, B as s } from "../../../../../shared/runtime.js";
import { resolveComponent as d } from "vue";
import { openBlock as l } from "vue";
import { createBlock as c } from "vue";
import { unref as e } from "vue";
const _ = { __name: "header", setup(m) {
  const r = { productType: o.ARTIFACT.V, inspectType: void 0, reportType: void 0, name: void 0 }, { crud: a, query: n } = s(r);
  return (i, t) => {
    const p = d("component-radio-button");
    return l(), c(p, { modelValue: e(n).productType, "onUpdate:modelValue": t[0] || (t[0] = (u) => e(n).productType = u), options: e(o).ENUM, unshowVal: [e(o).ENCLOSURE.V], class: "filter-item", type: "enum", size: "default", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]);
  };
} };
export {
  _ as default
};
