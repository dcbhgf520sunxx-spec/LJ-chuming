import { inject as u } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as p } from "vue";
import { vShow as _ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as r } from "vue";
import { Fragment as f } from "vue";
import { B as g, E as h } from "../../../../../../shared/runtime.js";
const k = { __name: "header", setup(y) {
  const n = {}, s = u("rivetWeldList"), { crud: o, query: t } = g(n);
  return (V, a) => {
    const l = i("common-radio-button");
    return c(), m(f, null, [p(v("div", null, [r(l, { modelValue: e(t).id, "onUpdate:modelValue": a[0] || (a[0] = (d) => e(t).id = d), options: e(s), dataStructure: { key: "id", label: "typeName", value: "id" }, default: "", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[_, e(o).searchToggle]]), r(e(h))], 64);
  };
} };
export {
  k as default
};
