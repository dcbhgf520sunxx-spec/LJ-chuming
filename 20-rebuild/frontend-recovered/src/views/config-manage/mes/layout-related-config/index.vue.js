import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { unref as c } from "vue";
import { ElCol as r } from "element-plus";
import { ElRow as _ } from "element-plus";
import l from "./module/drawing-processing-layer-config.vue.js";
import "../../../../shared/runtime.js";
const p = { class: "app-container" }, x = { __name: "index", setup(i) {
  return (m, d) => {
    const t = r, n = _;
    return a(), s("div", p, [e(n, null, { default: o(() => [e(t, { span: 12 }, { default: o(() => [e(c(l))]), _: 1 })]), _: 1 })]);
  };
} };
export {
  x as default
};
