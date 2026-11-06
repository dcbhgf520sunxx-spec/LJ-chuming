import { openBlock as d } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as m } from "vue";
import { vShow as p } from "vue";
import { unref as e } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as r } from "vue";
import { withKeys as f } from "vue";
import { renderSlot as _ } from "vue";
import { ElInput as y } from "element-plus";
import { B as h, C as b } from "../../../../../../shared/runtime.js";
const v = { style: { display: "flex", "justify-content": "space-between" } }, N = { __name: "header", setup(w) {
  const o = {}, { crud: t, query: s } = h(o);
  return (n, a) => {
    const i = y;
    return d(), c("div", v, [m(l("div", null, [r(i, { modelValue: e(s).serialNumber, "onUpdate:modelValue": a[0] || (a[0] = (u) => e(s).serialNumber = u), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: f(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(b))], 512), [[p, e(t).searchToggle]]), l("div", null, [_(n.$slots, "btn")])]);
  };
} };
export {
  N as default
};
