import i from "moment";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as c } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { vShow as h } from "vue";
import { renderSlot as _ } from "vue";
import { ElDatePicker as v } from "element-plus";
import { B as g, E as w } from "../../../../../../shared/runtime.js";
const Y = { __name: "header", setup(T) {
  const s = { projectId: void 0, dateTime: i().startOf("month").valueOf() }, { crud: t, query: a } = g(s);
  return (l, o) => {
    const d = v;
    return u(), m(e(w), null, { optLeft: r(() => [c(f("div", null, [p(d, { modelValue: e(a).dateTime, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(a).dateTime = n), type: "month", size: "default", class: "date-item filter-item", style: { width: "130px !important" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "x", onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"])], 512), [[h, e(t).searchToggle]])]), viewLeft: r(() => [_(l.$slots, "viewLeft")]), _: 3 });
  };
} };
export {
  Y as default
};
