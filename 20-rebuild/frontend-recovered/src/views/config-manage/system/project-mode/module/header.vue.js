import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as d } from "vue";
import { vShow as i } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { ElInput as p } from "element-plus";
import { B as _, C as f } from "../../../../../shared/runtime.js";
const y = { __name: "header", setup(B) {
  const o = { name: void 0 }, { crud: a, query: l } = _(o);
  return (h, t) => {
    const r = p;
    return u(), c("div", null, [d(m("div", null, [n(r, { modelValue: e(l).name, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(l).name = s), placeholder: "输入项目名称", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), n(e(f))], 512), [[i, e(a).searchToggle]])]);
  };
} };
export {
  y as default
};
