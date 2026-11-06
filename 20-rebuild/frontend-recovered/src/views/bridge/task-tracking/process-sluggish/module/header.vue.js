import { B as n, aV as s } from "../../../../../shared/runtime.js";
import { openBlock as l } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
const f = { class: "head-container" }, h = { __name: "header", setup(i) {
  const r = { workShopId: void 0 }, { crud: t, query: o } = n(r);
  return (p, a) => (l(), c("div", f, [u(e(s), { modelValue: e(o).workShopId, "onUpdate:modelValue": a[0] || (a[0] = (d) => e(o).workShopId = d), placeholder: "请选择车间", "factory-id": e(o).factoryId, style: { width: "300px" }, class: "filter-item", default: "", onChange: e(t).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"])]));
} };
export {
  h as default
};
