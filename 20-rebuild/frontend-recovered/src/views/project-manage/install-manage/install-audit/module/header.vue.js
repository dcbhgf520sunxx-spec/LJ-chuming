import { openBlock as d } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as t } from "vue";
import { withCtx as u } from "vue";
import { unref as e } from "vue";
import { ElDatePicker as m } from "element-plus";
import { B as p, E as _ } from "../../../../../shared/runtime.js";
const i = { class: "head-container" }, M = { __name: "header", setup(f) {
  const r = { yearMonth: void 0 }, { crud: n, query: o } = p(r);
  return (h, a) => {
    const l = m;
    return d(), c("div", i, [t(e(_), null, { optLeft: u(() => [t(l, { modelValue: e(o).yearMonth, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(o).yearMonth = s), type: "month", format: "YYYY/MM", "value-format": "YYYY-MM", placeholder: "请选择", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 })]);
  };
} };
export {
  M as default
};
