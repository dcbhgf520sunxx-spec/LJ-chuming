import { openBlock as r } from "vue";
import { createElementBlock as n } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as u } from "vue";
import { ElInput as d } from "element-plus";
import { B as p, E as m } from "../../../../../../shared/runtime.js";
const _ = { class: "head-container" }, f = { key: 0 }, g = { __name: "header", setup(h) {
  const l = { specification: void 0 }, { crud: o, query: t } = p(l);
  return (y, a) => {
    const c = d;
    return r(), n("div", _, [e(o).searchToggle ? (r(), n("div", f, [s(c, { modelValue: e(t).specification, "onUpdate:modelValue": a[0] || (a[0] = (i) => e(t).specification = i), class: "filter-item", clearable: "", placeholder: "可输入型材规格搜索", size: "small", style: { width: "250px" }, onBlur: e(o).toQuery, onClear: e(o).toQuery }, null, 8, ["modelValue", "onBlur", "onClear"])])) : u("", true), s(e(m))]);
  };
} };
export {
  g as default
};
