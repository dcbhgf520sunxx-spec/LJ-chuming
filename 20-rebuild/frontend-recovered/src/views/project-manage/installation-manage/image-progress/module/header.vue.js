import s from "moment";
import { openBlock as c } from "vue";
import { createElementBlock as m } from "vue";
import { withDirectives as u } from "vue";
import { vShow as d } from "vue";
import { unref as e } from "vue";
import { createElementVNode as Y } from "vue";
import { createVNode as h } from "vue";
import { ElDatePicker as i } from "element-plus";
import { B as p } from "../../../../../shared/runtime.js";
const g = { __name: "header", setup(f) {
  const r = { yearMonth: s((/* @__PURE__ */ new Date()).getTime()).startOf("month").format("YYYY-MM") }, { crud: a, query: o } = p(r);
  return (_, t) => {
    const n = i;
    return c(), m("div", null, [u(Y("div", null, [h(n, { modelValue: e(o).yearMonth, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(o).yearMonth = l), type: "month", format: "YYYY/MM", "value-format": "YYYY-MM", placeholder: "请选择", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"])], 512), [[d, e(a).searchToggle]])]);
  };
} };
export {
  g as default
};
