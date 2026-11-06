import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as c } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withKeys as r } from "vue";
import { vShow as f } from "vue";
import { ElInput as y } from "element-plus";
import { B as _, C as V, E as h } from "../../../../../../shared/runtime.js";
const g = { __name: "header", setup(v) {
  const i = { name: void 0, specification: void 0 }, { crud: l, query: a } = _(i);
  return (w, t) => {
    const n = y;
    return u(), d(e(h), null, { optLeft: p(() => [c(m("div", null, [s(n, { modelValue: e(a).name, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).name = o), size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(a).specification, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).specification = o), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: r(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(V))], 512), [[f, e(l).searchToggle]])]), _: 1 });
  };
} };
export {
  g as default
};
