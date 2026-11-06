import { openBlock as u } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withKeys as c } from "vue";
import { ElInput as p } from "element-plus";
import { B as m, C as i } from "../../../../../shared/runtime.js";
const V = { __name: "header", setup(_) {
  const n = { label: void 0 }, { crud: o, query: a } = m(n);
  return (f, l) => {
    const r = p;
    return u(), d("div", null, [t(r, { modelValue: e(a).label, "onUpdate:modelValue": l[0] || (l[0] = (s) => e(a).label = s), placeholder: "输入字典标签查询", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: c(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(i))]);
  };
} };
export {
  V as default
};
