import { openBlock as n } from "vue";
import { createElementBlock as e } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { unref as s } from "vue";
import { ElCol as l } from "element-plus";
import { ElRow as p } from "element-plus";
import { dD as m } from "../../../../shared/runtime.js";
import a from "./module/building-type.vue.js";
import _ from "./module/contract-build.vue.js";
import c from "./module/difficulty-factor.vue.js";
import f from "./module/key-project.vue.js";
import u from "./module/project-type.vue.js";
import d from "./module/project-level.vue.js";
import x from "./module/follow-type.vue.js";
import "../components/table-config-card.vue.js";
import "../../../../modules/project-config-3fa4f850.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
const g = { class: "app-container" }, N = { __name: "index", setup(b) {
  return (y, $) => {
    const t = l, r = p;
    return n(), e("div", g, [o(r, { gutter: 20 }, { default: i(() => [o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: i(() => [o(a, { style: { "margin-bottom": "20px" }, permission: s(m).build }, null, 8, ["permission"]), o(u, { style: { "margin-bottom": "20px" }, permission: s(m).category }, null, 8, ["permission"]), o(x, { style: { "margin-bottom": "20px" }, permission: s(m).track }, null, 8, ["permission"])]), _: 1 }), o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: i(() => [o(_, { style: { "margin-bottom": "20px" }, permission: s(m).construction }, null, 8, ["permission"]), o(d, { style: { "margin-bottom": "20px" }, permission: s(m).level }, null, 8, ["permission"])]), _: 1 }), o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: i(() => [o(f, { style: { "margin-bottom": "20px" }, permission: s(m).focus }, null, 8, ["permission"]), o(c, { style: { "margin-bottom": "20px" }, permission: s(m).diffcult }, null, 8, ["permission"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  N as default
};
