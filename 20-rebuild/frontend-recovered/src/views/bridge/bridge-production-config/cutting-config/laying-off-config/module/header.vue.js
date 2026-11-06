import { openBlock as c } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as d } from "vue";
import { vShow as i } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { withKeys as p } from "vue";
import { ElInput as _ } from "element-plus";
import { B as f, C as h, E as y } from "../../../../../../shared/runtime.js";
const v = { class: "head-container" }, x = { __name: "header", setup(V) {
  const o = { name: void 0 }, { crud: t, query: s } = f(o);
  return (w, n) => {
    const r = _;
    return c(), u("div", v, [d(m("div", null, [a(r, { modelValue: e(s).name, "onUpdate:modelValue": n[0] || (n[0] = (l) => e(s).name = l), placeholder: "输入下料方式搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(h))], 512), [[i, e(t).searchToggle]]), a(e(y))]);
  };
} };
export {
  x as default
};
