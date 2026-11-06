import u from "moment";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { renderSlot as p } from "vue";
import { ElDatePicker as m } from "element-plus";
import { B as y, aV as h } from "../../../../../shared/runtime.js";
const _ = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, g = { __name: "header", setup(k) {
  const s = { date: u().valueOf(), workShopId: void 0 }, { crud: l, query: a } = y(s);
  return (n, o) => {
    const d = m;
    return c(), i("div", _, [f("div", null, [r(d, { modelValue: e(a).date, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).date = t), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), r(h, { ref: "workshopInfRef", modelValue: e(a).workShopId, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).workShopId = t), placeholder: "请选择车间", "factory-id": e(a).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"])]), p(n.$slots, "printBtn")]);
  };
} };
export {
  g as default
};
