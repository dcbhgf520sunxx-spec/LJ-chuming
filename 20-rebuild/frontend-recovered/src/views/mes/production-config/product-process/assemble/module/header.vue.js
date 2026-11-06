import { withDirectives as d } from "vue";
import { vShow as u } from "vue";
import { unref as e } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as t } from "vue";
import { withCtx as p } from "vue";
import { ElInput as m } from "element-plus";
import { fA as _, B as f, C as A, E as h } from "../../../../../../shared/runtime.js";
const v = { __name: "header", setup(E) {
  const l = { boolSectionSteel: { value: _.NOT_SECTION_STEEL.V, resetAble: false }, sectionAndNameAndType: void 0 }, { crud: s, query: a } = f(l);
  return (T, n) => {
    const o = m;
    return d((c(), i("div", null, [t(e(h), null, { optRight: p(() => [t(o, { modelValue: e(a).sectionAndNameAndType, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(a).sectionAndNameAndType = r), size: "default", placeholder: "输入类型、前缀搜索", style: { width: "240px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), t(e(A))]), _: 1 })], 512)), [[u, e(s).searchToggle]]);
  };
} };
export {
  v as default
};
