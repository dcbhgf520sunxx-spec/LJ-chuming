import { provide as r } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { withDirectives as p } from "vue";
import { unref as t } from "vue";
import { ElCol as _ } from "element-plus";
import { ElRow as d } from "element-plus";
import { p8 as s } from "../../../../../shared/runtime.js";
import f from "./component/paint-film-config.vue.js";
const u = { class: "app-container" }, C = { __name: "index", setup(g) {
  return r("permission", s), (v, x) => {
    const i = _, n = d, a = c("permission");
    return l(), m("div", u, [e(n, { gutter: 20 }, { default: o(() => [e(i, { xs: 24, sm: 24, md: 20, lg: 20 }, { default: o(() => [p(e(t(f), { style: { "margin-bottom": "20px" } }, null, 512), [[a, t(s).get]])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  C as default
};
