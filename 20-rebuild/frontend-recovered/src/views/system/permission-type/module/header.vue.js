import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as d } from "vue";
import { vShow as i } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { withKeys as p } from "vue";
import { ElInput as _ } from "element-plus";
import { B as f, C as y, E as h } from "../../../../shared/runtime.js";
const w = { __name: "header", setup(b) {
  const o = { blurryName: void 0 }, { crud: r, query: t } = f(o);
  return (v, l) => {
    const s = _;
    return u(), c("div", null, [d(m("div", null, [a(s, { modelValue: e(t).blurryName, "onUpdate:modelValue": l[0] || (l[0] = (n) => e(t).blurryName = n), placeholder: "按名称模糊搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(y))], 512), [[i, e(r).searchToggle]]), a(e(h))]);
  };
} };
export {
  w as default
};
