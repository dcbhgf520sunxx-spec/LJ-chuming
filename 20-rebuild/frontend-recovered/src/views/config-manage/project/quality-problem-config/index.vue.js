import { openBlock as a } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as o } from "vue";
import { withCtx as e } from "vue";
import { unref as r } from "vue";
import { ElCol as c } from "element-plus";
import { ElRow as _ } from "element-plus";
import l from "./component/problem-config/index.vue.js";
import "../../../../shared/runtime.js";
import "./component/problem-config/module/form.vue.js";
const m = { class: "app-container" }, g = { __name: "index", setup(p) {
  return (i, d) => {
    const t = c, s = _;
    return a(), n("div", m, [o(s, { gutter: 20 }, { default: e(() => [o(t, { xs: 24, sm: 24, md: 12, lg: 10 }, { default: e(() => [o(r(l))]), _: 1 })]), _: 1 })]);
  };
} };
export {
  g as default
};
