import { withDirectives as u } from "vue";
import { vShow as i } from "vue";
import { unref as e } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as t } from "vue";
import { withCtx as m } from "vue";
import { withKeys as p } from "vue";
import { ElInput as _ } from "element-plus";
import { B as f, C as h, E as y } from "../../../../../shared/runtime.js";
const V = { __name: "header", setup(w) {
  const l = {}, { crud: a, query: o } = f(l);
  return (g, r) => {
    const s = _;
    return u((c(), d("div", null, [t(e(y), null, { optRight: m(() => [t(s, { modelValue: e(o).name, "onUpdate:modelValue": r[0] || (r[0] = (n) => e(o).name = n), modelModifiers: { trim: true }, clearable: "", size: "default", placeholder: "输入切割形式搜索", class: "filter-item", style: { width: "200px" }, onKeyup: p(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(h))]), _: 1 })], 512)), [[i, e(a).searchToggle]]);
  };
} };
export {
  V as default
};
