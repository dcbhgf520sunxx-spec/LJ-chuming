import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { withDirectives as m } from "vue";
import { vShow as c } from "vue";
import { unref as e } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as a } from "vue";
import { withCtx as f } from "vue";
import { renderSlot as _ } from "vue";
import { ElInput as v } from "element-plus";
import { B, C as N, E as V } from "../../../../../shared/runtime.js";
const y = { __name: "header", setup(b) {
  const s = { orderNumber: void 0, userName: void 0, projectId: { value: void 0, resetAble: false } }, { crud: t, query: l } = B(s);
  return (d, r) => {
    const u = v;
    return n(), i("div", null, [m(p("div", null, [a(u, { modelValue: e(l).orderNumber, "onUpdate:modelValue": r[0] || (r[0] = (o) => e(l).orderNumber = o), placeholder: "工单号搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onBlur: e(t).toQuery }, null, 8, ["modelValue", "onBlur"]), a(u, { modelValue: e(l).userName, "onUpdate:modelValue": r[1] || (r[1] = (o) => e(l).userName = o), placeholder: "排产人搜索", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onBlur: e(t).toQuery }, null, 8, ["modelValue", "onBlur"]), a(e(N))], 512), [[c, e(t).searchToggle]]), a(e(V), null, { viewLeft: f(() => [_(d.$slots, "viewLeft")]), _: 3 })]);
  };
} };
export {
  y as default
};
