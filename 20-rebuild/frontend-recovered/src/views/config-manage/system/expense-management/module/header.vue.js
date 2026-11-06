import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as d } from "vue";
import { vShow as i } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { ElInput as p } from "element-plus";
import { B as _, C as f, E as B } from "../../../../../shared/runtime.js";
const g = { __name: "header", setup(h) {
  const n = { name: void 0 }, { crud: l, query: r } = _(n);
  return (v, t) => {
    const o = p;
    return u(), c("div", null, [d(m("div", null, [a(o, { modelValue: e(r).name, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(r).name = s), placeholder: "输入费用类型名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onBlur: e(l).toQuery }, null, 8, ["modelValue", "onBlur"]), a(e(f))], 512), [[i, e(l).searchToggle]]), a(e(B))]);
  };
} };
export {
  g as default
};
