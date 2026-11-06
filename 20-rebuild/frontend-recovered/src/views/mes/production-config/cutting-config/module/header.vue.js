import { resolveComponent as m } from "vue";
import { withDirectives as p } from "vue";
import { vShow as u } from "vue";
import { unref as e } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as r } from "vue";
import { withCtx as h } from "vue";
import { B as _, E as f } from "../../../../../shared/runtime.js";
const C = { __name: "header", props: { deviceTypeList: Array }, setup(n) {
  const s = {}, { crud: o, query: t } = _(s);
  return (v, a) => {
    const l = m("common-select");
    return p((d(), i("div", null, [r(e(f), null, { optRight: h(() => [r(l, { modelValue: e(t).name, "onUpdate:modelValue": a[0] || (a[0] = (c) => e(t).name = c), options: n.deviceTypeList, type: "other", size: "default", clearable: "", placeholder: "切割方式", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 })], 512)), [[u, e(o).searchToggle]]);
  };
} };
export {
  C as default
};
