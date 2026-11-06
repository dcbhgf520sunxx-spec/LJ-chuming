import { bo as n, B as m, aV as i } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
const _ = { class: "head-container" }, S = { __name: "header", setup(y) {
  const l = { workShopId: void 0, weightStatus: n.NET.V }, { crud: r, query: o } = m(l), d = c([n.NET, n.GROSS]);
  return (g, t) => {
    const u = p("common-radio-button");
    return f(), h("div", _, [s(i, { modelValue: e(o).workShopId, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).workShopId = a), placeholder: "请选择车间", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", default: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), s(u, { type: "enum", modelValue: e(o).weightStatus, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).weightStatus = a), options: d.value, class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])]);
  };
} };
export {
  S as default
};
